import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
// import javax.swing.JScrollPane;

import java.awt.event.KeyListener;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.Color;
// import java.awt.FlowLayout;
// import java.awt.BorderLayout;

// import java.security.SecureRandom;


// topMessageLabelFirstLine at y-axis : 0 ~ 20
// topMessageLabelSecondLine at y-axis : 20 ~ 40
// textArea at y-axis : 75 ~ 175


public class TypingTutor extends JFrame implements KeyListener, ItemListener{

    private JLabel topMessageLabelFirstLine;
    private JLabel topMessageLabelSecondLine;
    private JLabel userMustType;
    private JTextArea typeArea;
    private int margin;
    private String [] keyboardWord;
    private List<JButton> buttons;
    private List<String> pangram;
    private String userMustTypeString;
    private HashMap<Character,Integer> map;
    private SecureRandom random;
    // private int currentIndex;
    // JLabel temp;

    public TypingTutor(){
        super("Typing Application");
        // this.setLayout(new FlowLayout());
        this.setLayout(null);
        addKeyListener(this);

        ////////////

        // temp = new JLabel("hahaha");
        // temp.setLocation(0,450);
        // temp.setSize(50,50);
       
        // this.add(temp);

        //////////////////
        margin = 10;
        keyboardWord = new String[]{"~","1","2","3","4","5","6","7","8","9","0","-","+","Backspace","Tab","Q","W","E","R","T","Y","U","I","O","P","[","]","\\","Caps","A","S","D","F","G","H","J","K","L",":","\"","Enter","Shift","Z","X","C","V","B","N","M",",",".","?","^","","<","v",">"};
        buttons = new ArrayList<JButton>();

        topMessageLabelFirstLine = new JLabel("Type some text using your keyboard.\n The keys you pressed will highlighted and the text will be displayed.");
        topMessageLabelFirstLine.setBounds(margin,0,800 - margin * 2,20);

        topMessageLabelSecondLine = new JLabel("Note: Clicking the buttons with your mouse will not perform any action. Type Enter key for finish typing!!!");
        topMessageLabelSecondLine.setBounds(margin,20,800 - margin * 2,20);

        pangram = new ArrayList<>();
        pangram.add("The quick brown fox jumped over a lazy dog.");
        pangram.add("Few quips galvanized the mock jury box.");
        pangram.add("Vamp fox held quartz duck just by wing.");
        pangram.add("Cozy sphinx waves quart jug of bad milk.");
        pangram.add("Pack my box with five dozen liquor jugs.");


        random = new SecureRandom();
        userMustTypeString = pangram.get(random.nextInt(pangram.size()));
        userMustType = new JLabel("Please type: " +  userMustTypeString);
        userMustType.setBounds(margin,40,800 - margin * 2, 20);

        typeArea = new JTextArea();
        typeArea.setBounds(margin,50 + 25,800 - margin * 2,100);
        typeArea.setLineWrap(true);
        typeArea.addKeyListener(this);

        map = new HashMap<>();
        // currentIndex = 0;
        // typeArea.setFocusable(false);
        add(topMessageLabelFirstLine);
        add(topMessageLabelSecondLine);
        add(userMustType);
        add(typeArea);
        addButtons();
        setResizable(false);
        // add(new JScrollPane());
    }

    public void addButtons(){

        int buttonWidth = 50;
        
        for(int i = 0; i < keyboardWord.length; i++){
            buttons.add(new JButton(keyboardWord[i]));
            if(i == 13)
                buttonWidth = 100;
            else if(i == 14 || i == 28)
                buttonWidth = 75;
            else if(i == 40 || i == 41)
                buttonWidth = buttonWidth * 2;
            else if(i == 53)
                buttonWidth = buttonWidth * 6;
            buttons.get(i).setSize(buttonWidth,50);
            setPosition(i);
            this.add(buttons.get(i));
            buttonWidth = 50;
        }
    }

    public void setPosition(int i){
        int keyBoardMargin = 25;
        if(i < 14)
            buttons.get(i).setLocation(keyBoardMargin + i * 50, 200);
        else if(i == 14)
            buttons.get(i).setLocation(keyBoardMargin + (i - 14) * 50, 255);  
        else if(i > 14 && i < 28)  
            buttons.get(i).setLocation(keyBoardMargin + (i - 14) * 50 + 25, 255); 
        else if(i == 28)
            buttons.get(i).setLocation(keyBoardMargin + (i - 28) * 50, 310);
        else if(i > 28 && i < 41)  
            buttons.get(i).setLocation(keyBoardMargin + (i - 28) * 50 + 25, 310);
        else if(i == 41)
            buttons.get(i).setLocation(keyBoardMargin + (i - 41) * 50, 365); 
        else if(i > 41 && i < 52)  
            buttons.get(i).setLocation(keyBoardMargin + (i - 41) * 50 + 50, 365); 
        else if(i == 52)
            buttons.get(i).setLocation(keyBoardMargin + (i - 41) * 50 + 75, 365); 
        else if(i == 53)
            buttons.get(i).setLocation(keyBoardMargin + (i - 53) * 50 + 200, 420); 
        else if(i > 53)
            buttons.get(i).setLocation(keyBoardMargin + (i - 54) * 50 + 200 + 300 + 75, 420); 
    }

    public void setButtonColorPressed(int i){
        buttons.get(i).setOpaque(true);
        buttons.get(i).setBackground(Color.yellow);
    }

    // public boolean checkKeyExist(String str){
    //     for(int i = 0; i < keyboardWord.length; i++){
    //         if(str.equals(keyboardWord[i])){
    //             return true;
    //         }
    //     }

    //     return false;
    // }

    public int getKeyIndex(String str){
        for(int i = 0; i < keyboardWord.length; i++){
            if(str.equals(keyboardWord[i])){
                return i;
            }
        }
        return -1;
    }
    
    public String checkAccuracyAndDetail(){
        map.clear();
        int correctCharacterCount = 0;
        int wrongCharacterCount = 0;
        String contents = typeArea.getText();
        boolean shorter = false;

        if(contents.length() < userMustTypeString.length()){
            shorter = true;
        }

        for(int i = 0; i < userMustTypeString.length(); i++){
            char currentChar = userMustTypeString.charAt(i);
            char currentTypeAreaChar = '@';
            if(shorter && i > contents.length() - 1){
                currentTypeAreaChar = '@';
            }
            else{
                currentTypeAreaChar = contents.charAt(i);
            }
            
            
            if(currentTypeAreaChar == currentChar){
                correctCharacterCount++;              
            }
            else{
                wrongCharacterCount++;
                if(map.containsKey(currentChar)){
                    map.put(currentChar, map.get(currentChar) + 1);
                }
                else{
                    map.put(currentChar,1);
                }
               
            }
        }
        
        return "Total Character(answer): " + userMustTypeString.length() + "\nCorrect Character: " + correctCharacterCount + "\nWrong Character: " + wrongCharacterCount + "\n" + "Accuracy: " + String.valueOf(correctCharacterCount / Double.valueOf(userMustTypeString.length()) * 100) + "%" + "\n";
    }

    public String showWrongCharacterCountDetails(){

        String finalString = "";
        for(Character ch: map.keySet()){
            finalString += String.valueOf(ch) + "(wrong)" + ": " + map.get(ch) + "\n";
        }

        return finalString;
    }

    public void showFinalResult(){
        
        // String wrongCharacterCount = showWrongCharacterCountDetails();
        JOptionPane.showMessageDialog(this,"Your accuracy is: " + checkAccuracyAndDetail() + "Character wrong Statistics: "  + "\n" + showWrongCharacterCountDetails());
        userMustTypeString = pangram.get(random.nextInt(pangram.size()));
        userMustType.setText("Please type: " +  userMustTypeString);
        typeArea.setText("");
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
       
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
       
        // temp.setText(KeyEvent.getKeyText(e.getKeyCode()));
        
        // temp.setText("aaa");

        // System.out.println(KeyEvent.getKeyText(e.getKeyCode()));
        int key1 = e.getKeyCode();
        char key2 = e.getKeyChar();
        int buttonIndex = 0;
        switch (key1) {
            case KeyEvent.VK_TAB:
                System.out.println("Tab");
                buttonIndex = getKeyIndex("Tab");
                break;
                
            case KeyEvent.VK_CAPS_LOCK:
                System.out.println("Caps");
                buttonIndex = getKeyIndex("Caps");
                break;
                
            case KeyEvent.VK_SHIFT:
                System.out.println("Shift");
                buttonIndex = getKeyIndex("Shift");
                break;  
                
            case KeyEvent.VK_SPACE:
                System.out.println("space");
                buttonIndex = getKeyIndex("");
                break;
                
            case KeyEvent.VK_BACK_SPACE:
                System.out.println("Backspace");
                buttonIndex = getKeyIndex("Backspace");
                break;
                
            case KeyEvent.VK_ENTER:
                System.out.println("Enter");
                buttonIndex = getKeyIndex("Enter");
                break;      

            //Use slash to detect questoin mark
            case KeyEvent.VK_SLASH:
                System.out.println("Question mark");
                buttonIndex = getKeyIndex("?");
                break;      
                
            //Use back quote to detect wave
            case KeyEvent.VK_BACK_QUOTE:
                System.out.println("wave");
                buttonIndex = getKeyIndex("~");
                break;
            
            //Use equal sign to detect plus sign    
            case KeyEvent.VK_EQUALS:
                System.out.println("plus");
                buttonIndex = getKeyIndex("+");
                break;     

            //Use semicolon to detect colon
            case KeyEvent.VK_SEMICOLON:
                System.out.println("colon");
                buttonIndex = getKeyIndex(":");
                break;     
            
            case KeyEvent.VK_QUOTE:
                System.out.println("quote");
                buttonIndex = getKeyIndex("\"");
                break;

            case KeyEvent.VK_UP:
                System.out.println("Up");
                buttonIndex = getKeyIndex("^");
                break;    
            
            case KeyEvent.VK_DOWN:
                System.out.println("Down");
                buttonIndex = getKeyIndex("v");
                break;      

            case KeyEvent.VK_LEFT:
                System.out.println("Left");
                buttonIndex = getKeyIndex("<");
                break;

            case KeyEvent.VK_RIGHT:
                System.out.println("Right");
                buttonIndex = getKeyIndex(">");
                break;

            default:
                // System.out.println(key2);
                buttonIndex = getKeyIndex(KeyEvent.getKeyText(e.getKeyCode()));
            }

        // System.out.println(e.getKeyChar());
        // int buttonIndex = getKeyIndex(KeyEvent.getKeyText(e.getKeyCode()));
        
        setButtonColorPressed(buttonIndex);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key1 = e.getKeyCode();
        char key2 = e.getKeyChar();
        int buttonIndex = 0;
        switch (key1) {
                
            case KeyEvent.VK_TAB:
                System.out.println("Tab");
                buttonIndex = getKeyIndex("Tab");
                break;
                
            case KeyEvent.VK_CAPS_LOCK:
                System.out.println("Caps");
                buttonIndex = getKeyIndex("Caps");
                break;
                
            case KeyEvent.VK_SHIFT:
                System.out.println("Shift");
                buttonIndex = getKeyIndex("Shift");
                break; 
                
            case KeyEvent.VK_SPACE:
                System.out.println("space");
                buttonIndex = getKeyIndex("");
                break;
                
            case KeyEvent.VK_BACK_SPACE:
                System.out.println("Backspace");
                buttonIndex = getKeyIndex("Backspace");
                break;
                
            case KeyEvent.VK_ENTER:
                System.out.println("Enter");
                buttonIndex = getKeyIndex("Enter");
                buttons.get(buttonIndex).setBackground(null);
                showFinalResult();
                break;  

            //Use slash to detect questoin mark
            case KeyEvent.VK_SLASH: 
                System.out.println("Question mark");
                buttonIndex = getKeyIndex("?");
                break;    
            
            //Use back quote to detect wave
            case KeyEvent.VK_BACK_QUOTE:
                System.out.println("wave");
                buttonIndex = getKeyIndex("~");
                break;    
                 
            //Use equal sign to detect plus sign    
            case KeyEvent.VK_EQUALS:
                System.out.println("plus");
                buttonIndex = getKeyIndex("+");
                break; 
            
            //Use semicolon to detect colon
            case KeyEvent.VK_SEMICOLON:
                System.out.println("colon");
                buttonIndex = getKeyIndex(":");
                break;

            case KeyEvent.VK_QUOTE:
                System.out.println("quote");
                buttonIndex = getKeyIndex("\"");
                break;
                case KeyEvent.VK_UP:
                System.out.println("Up");
                buttonIndex = getKeyIndex("^");
                break;    
            
            case KeyEvent.VK_DOWN:
                System.out.println("Down");
                buttonIndex = getKeyIndex("v");
                break;      

            case KeyEvent.VK_LEFT:
                System.out.println("Left");
                buttonIndex = getKeyIndex("<");
                break;

            case KeyEvent.VK_RIGHT:
                System.out.println("Right");
                buttonIndex = getKeyIndex(">");
                break;

            default:
                // System.out.println(key2);
                buttonIndex = getKeyIndex(KeyEvent.getKeyText(e.getKeyCode()));
            }
        
        // int buttonIndex = getKeyIndex(KeyEvent.getKeyText(e.getKeyCode()));
        buttons.get(buttonIndex).setBackground(null);
    }
}
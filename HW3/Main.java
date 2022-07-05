import javax.swing.JFrame;

public class Main {
    public static void main(String[] args){
        TypingTutor typingTutor = new TypingTutor();
        typingTutor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        typingTutor.setSize(800,600);
        typingTutor.setVisible(true);
    }
}

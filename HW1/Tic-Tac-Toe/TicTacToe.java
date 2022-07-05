   
/**
 * Tic-tac-toe的位置如下
 * -------------
 * | 1 | 2 | 3 |
 * -------------
 * | 4 | 5 | 6 |
 * -------------
 * | 7 | 8 | 9 |
 * -------------
 * 
 * 
 * 範例:
 * -------------
 * | X |   |   |
 * -------------
 * |   | O |   |
 * -------------
 * | O |   | X |
 * -------------
 * 
 * 
 *
 */
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Scanner;
public class TicTacToe{

    public enum Mark{
        EMPTY,
        X,
        O;
        /**/
        @Override
        public String toString(){

        	switch (this) {
        		case EMPTY:
        			return "   ";
        		case X:
        			return " X ";
        		case O:
        			return " O ";
        	}
        	return "   ";
        }
    };
    
    private static Mark position_1 = Mark.EMPTY;
    private static Mark position_2 = Mark.EMPTY;
    private static Mark position_3 = Mark.EMPTY;
    private static Mark position_4 = Mark.EMPTY;
    private static Mark position_5 = Mark.EMPTY;
    private static Mark position_6 = Mark.EMPTY;
    private static Mark position_7 = Mark.EMPTY;
    private static Mark position_8 = Mark.EMPTY;
    private static Mark position_9 = Mark.EMPTY;
    
    private static Mark turn = Mark.X;
   
    /**
      * This function returns true if the spot is empty, false if not.
      */
    public static boolean isValidMove(int pos){
    	Mark check = Mark.EMPTY;
    	switch (pos) {
    		case 1:
				check = position_1;
    			break;
    		case 2:
    			check = position_2;
    			break;
    		case 3:
    			check = position_3;
    			break;
    		case 4:
    			check = position_4;
    			break;
    		case 5:
    			check = position_5;
    			break;
    		case 6:
    			check = position_6;
    			break;
    		case 7:
    			check = position_7;
    			break;
    		case 8:
    			check = position_8;
    			break;
    		case 9:
    			check = position_9;
    			break;
    		default:
    			return false;
    	}
    	if (check == Mark.EMPTY) {
    		return true;
    	}
    	return false;
    }
    
    /**
     * 印出board
     */
    public static void printBoard(){
    	System.out.println("-------------");
    	System.out.print("|");
    	System.out.print(position_1.toString());
    	System.out.print("|");
    	System.out.print(position_2.toString());
    	System.out.print("|");
    	System.out.print(position_3.toString());
    	System.out.print("|");
    	System.out.println("");
    	System.out.println("-------------");
    	System.out.print("|");
    	System.out.print(position_4.toString());
    	System.out.print("|");
    	System.out.print(position_5.toString());
    	System.out.print("|");
    	System.out.print(position_6.toString());
    	System.out.print("|");
    	System.out.println("");
    	System.out.println("-------------");
    	System.out.print("|");
    	System.out.print(position_7.toString());
    	System.out.print("|");
    	System.out.print(position_8.toString());
    	System.out.print("|");
    	System.out.print(position_9.toString());
    	System.out.print("|");
    	System.out.println("");
    	System.out.println("-------------");
    }
    
    /**
     * 判斷特定玩家是否有贏
     */
    public static boolean hasWon(Mark m){
    /*
    1,2,3
 	4,5,6
 	7,8,9
 	1,4,7
 	2,5,8
 	3,6,9
 	1.5.9
 	3.5.7
    8種情況
    */
    	if (position_1 == m && position_2 == m && position_3 == m) {
    		return true;
    	}
    	else if (position_4 == m && position_5 == m && position_6 == m) {
    		return true;
    	}
    	else if (position_7 == m && position_8 == m && position_9 == m) {
    		return true;
    	}
    	else if (position_1 == m && position_4 == m && position_7 == m) {
    		return true;
    	}
    	else if (position_2 == m && position_5 == m && position_8 == m) {
    		return true;
    	}
    	else if (position_3 == m && position_6 == m && position_9 == m) {
    		return true;
    	}
    	else if (position_1 == m && position_5 == m && position_9 == m) {
    		return true;
    	}
    	else if (position_3 == m && position_5 == m && position_7 == m) {
    		return true;
    	}
    	return false;
    }
    
    /**
     * 判斷有無贏家
     * 
     */
    public static boolean isTie(){

    	if (position_1 != Mark.EMPTY && position_2 != Mark.EMPTY && position_3 != Mark.EMPTY && position_4 != Mark.EMPTY && position_5 != Mark.EMPTY && position_6 != Mark.EMPTY && position_7 != Mark.EMPTY && position_8 != Mark.EMPTY && position_9 != Mark.EMPTY) {
    		return true;
    	}
    	return false;
    }
   
    /**
     * Mark the given position with the given Mark
     */
    
    public static void markTheBoard(Mark m, int pos){
    	switch (pos) {
    		case 1:
				position_1 = m;
    			break;
    		case 2:
    			position_2 = m;
    			break;
    		case 3:
    			position_3 = m;
    			break;
    		case 4:
    			position_4 = m;
    			break;
    		case 5:
    			position_5 = m;
    			break;
    		case 6:
    			position_6 = m;
    			break;
    		case 7:
    			position_7 = m;
    			break;
    		case 8:
    			position_8 = m;
    			break;
    		case 9:
    			position_9 = m;
    			break;
    	}
    }
    
    public static void main(String[] args) {
    
    	//test the toString() method
    	// System.out.println("test:" + Mark.EMPTY.toString());
    	// System.out.println("test:" + Mark.X.toString());
    	// System.out.println("test:" + Mark.O.toString());
    
    	int counter = 0;
    	System.out.println("Enter \"111\" to leave the game");

        /*Play with computer or not  */
        System.out.println("Play with computer or not?\nType y for yes n for no.");

        // char yesOrNo = sc.next().charAt(0);
        Scanner sc = new Scanner(System.in);
        char yesOrNo = sc.next().charAt(0);
        if(!playWithComputer(yesOrNo)){
            while (true) {
                try {
                    int position = -1;
                    if (counter % 2 == 0) {
                        turn = Mark.X;
                        position = readValue("Player X ,please enter a position to play", sc);
                    }
                    else if (counter % 2 == 1) {
                        turn = Mark.O;
                        position = readValue("Player O ,please enter a position to play", sc);
                    }
                    if (position == 111) {
                        System.out.println("Game Over");
                        break;
                    }
                    if (isValidMove(position)) {
                        markTheBoard(turn, position);
                        printBoard();
                        counter ++;
                    }
                    else {
                        System.out.println("Invalid turn or position has been chosen!!!");
                    }
                    /*
                    check if anyone has wan!
                    */
                    if (hasWon(Mark.X)) {
                            System.out.println("Player X has wan!");
                            break;
                    }
                    if (hasWon(Mark.O)) {
                            System.out.println("Player O has wan!");
                            break;
                    }
                    if (isTie()) {
                        System.out.println("No one has won!");
                        break;
                    }
                }
                catch (Exception e) {
                    System.out.println("Invalid turn or position has been chosen!!!");
                }
            }
        }
        else{
            System.out.println("Go first or second? (Type f for first and s for second)");
            char firstOrSecond = sc.next().charAt(0);
                if(checkFirst(firstOrSecond)){
                    System.out.println("PLayer is Player X!!!");
                    System.out.println("Computer is Player O!!!");
                    
                    while(true){
                        try {
                            int position = -1;
                            if (counter % 2 == 0) {
                                turn = Mark.X;
                                position = readValue("Player X ,please enter a position to play", sc);
                            }
                            else if (counter % 2 == 1) {
                                turn = Mark.O;
                                position = computerGo();
                                 while(!isValidMove(position)){
                                    position = computerGo();
            
                                }
                                System.out.println("Computer has Entered a position!");
                            }
                            if (position == 111) {
                                System.out.println("Game Over");
                                break;
                            }
                            if (isValidMove(position)) {
                                markTheBoard(turn, position);
                                printBoard();
                                counter ++;
                            }
                            else {
                                System.out.println("Invalid turn or position has been chosen!!!");
                            }
                            /*
                            check if anyone has wan!
                            */
                            if (hasWon(Mark.X)) {
                                    System.out.println("Player X has wan!");
                                    break;
                            }
                            if (hasWon(Mark.O)) {
                                    System.out.println("Player O has wan! (Computer Won)");
                                    break;
                            }
                            if (isTie()) {
                                System.out.println("No one has won!");
                                break;
                            }
                        }
                        catch (Exception e) {
                            System.out.println("Invalid turn or position has been chosen!!!");
                        }
                    }
                }
                else if(!checkFirst(firstOrSecond)){
                    
                    
                    System.out.println("Computer is Player X!!!");
                    System.out.println("Player is Player O!!!");
    
                    while(true){
                        try {
                            int position = -1;
                            if (counter % 2 == 0) {
                                turn = Mark.X;
                                position = computerGo();
                                while(!isValidMove(position)){
                                    position = computerGo();
            
                                }
                                System.out.println("Computer has Entered a position!");
                            }
                            else if (counter % 2 == 1) {
                                turn = Mark.O;
                                position = readValue("Player O ,please enter a position to play", sc);
                            }
                            if (position == 111) {
                                System.out.println("Game Over");
                                break;
                            }
                            if (isValidMove(position)) {
                                markTheBoard(turn, position);
                                printBoard();
                                counter ++;
                            }
                            else {
                                System.out.println("Invalid turn or position has been chosen!!!");
                            }
                            /*
                            check if anyone has wan!
                            */
                            if (hasWon(Mark.X)) {
                                    System.out.println("Player X has wan!(Computer won)");
                                    break;
                            }
                            if (hasWon(Mark.O)) {
                                    System.out.println("Player O has wan!");
                                    break;
                            }
                            if (isTie()) {
                                System.out.println("No one has won!");
                                break;
                            }
                        }
                        catch (Exception e) {
                            System.out.println("Invalid turn or position has been chosen!!!");
                        }
                    }
                }
        }
        
    }

    
    public static boolean checkFirst(char firstOrSecond ){

        // Scanner sc = new Scanner(System.in);
        // char firstOrSecond = sc.next().charAt(0);
        // if(firstOrSecond.length() > 1)
        //     throw new IllegalArgumentException("");
        // System.out.println(firstOrSecond);
        
        // while(firstOrSecond == 'f' || firstOrSecond == 's'){
            
            if(firstOrSecond == 'f'){
                // System.out.println(firstOrSecond == 'f');
                // sc.close();
                return  true;
            }else if(firstOrSecond == 's'){
               
                // System.out.println(firstOrSecond == 's');
                // System.out.println(firstOrSecond + " is " + firstOrSecond);
                // System.out.println("Please press any key to start");
                return  false;
            }else{
                // System.out.println("Enter f or s !!!");
                throw new IllegalArgumentException("Enter f or s !!!");
                // return false;
            }
        // }
        // sc.close();
        // return false;
    }

    public static boolean playWithComputer(char yesOrNo){

        // while(yesOrNo == 'y' || yesOrNo == 'n'){
            if(yesOrNo == 'y'){
                // System.out.println(yesOrNo);
                return  true;
            }else if(yesOrNo == 'n'){
                return  false;
            }else{
                // System.out.println("Enter y or n !!!");
                throw new IllegalArgumentException("Enter y or n !!!");
            }
        // }

        // return false;
    }
    
    
    private static int readValue(String prompt, Scanner sc)  throws IOException{
        if (!prompt.isEmpty()){
            System.out.println(prompt);
        }
        
        return sc.nextInt();
    }

    private static int computerGo()  throws IOException{
        // if (!prompt.isEmpty()){
        //     System.out.println(prompt);
        // }
        
        SecureRandom random = new SecureRandom();
        int max = 9;
        int min = 1;
        return random.nextInt(max-min+1)+min;
        
    }
}


import java.awt.Color;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import org.w3c.dom.events.MouseEvent;

public class BouncingBallsFrame extends JFrame{
    
    private List<Ball> ballList;
    private final int ballNumber = 100;
    private int clickCount;
    private DrawPanel drawPanel;

    public BouncingBallsFrame(){
        super("Bouncing Balls");
        clickCount = 0;
        ballList = new ArrayList<>();
        drawPanel = new DrawPanel(ballList,ballNumber);
        // this.setBackground();
        this.add(drawPanel);

        for(int i = 0; i < ballNumber; i++){
            Ball ball = new Ball((i + 1 )* 10,(i + 1) * 5);
            ballList.add(ball);
        }

        this.addMouseListener(
            new MouseInputListener() {

                @Override
                public void mouseClicked(java.awt.event.MouseEvent e) {
                    // TODO Auto-generated method stub
                    if(clickCount < ballNumber){
                        SecureRandom random = new SecureRandom();
                        Ball tempBall = ballList.get(clickCount);
                        tempBall.color = new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255));
                        tempBall.updatePosition(e.getX(), e.getY());
                        BouncingBallsFrame.this.repaint();
                        clickCount++;
                        System.out.println("Cicked at " + e.getX() + " " + e.getY());
                        System.out.println("Radius: " + tempBall.width);
                    }
                    // BouncingBallsFrame.this.getContentPane().setBackground(new Color(0,0,255));
                }

                @Override
                public void mousePressed(java.awt.event.MouseEvent e) {
                    // TODO Auto-generated method stub
                    
                }

                @Override
                public void mouseReleased(java.awt.event.MouseEvent e) {
                    // TODO Auto-generated method stub
                    
                }

                @Override
                public void mouseEntered(java.awt.event.MouseEvent e) {
                    // TODO Auto-generated method stub
                    // BouncingBallsFrame.this.getContentPane().add(new Ball(100,100));
                }

                @Override
                public void mouseExited(java.awt.event.MouseEvent e) {
                    // TODO Auto-generated method stub
                    
                }

                @Override
                public void mouseDragged(java.awt.event.MouseEvent e) {
                    // TODO Auto-generated method stub
                    
                }

                @Override
                public void mouseMoved(java.awt.event.MouseEvent e) {
                    // TODO Auto-generated method stub
                    
                }
                
            }
        );
    }
    public List<Ball> getBallList(){

        return ballList;
    }
}



import java.awt.Color;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args){
        BouncingBallsFrame frame = new BouncingBallsFrame();
        // Ball ball = new Ball(5,5);
        // frame.add(ball);
        // frame.getContentPane().add(new Ball(100, 100));
        // frame.setBackground(Color.WHITE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        // frame.pack();
        frame.setVisible(true);
        System.out.println(frame.getHeight());
        while(true){
            for (Ball b: frame.getBallList()) {
                if(b.getX() + b.getWidth() >= frame.getWidth() && b.getY() + b.getHeight() >= frame.getHeight()){
                    b.modifyVerticalVelocity();
                    b.modifyhorizontalVelocity();
                    b.updatePosition(frame.getWidth() - b.width,frame.getHeight() - b.getHeight());
                }
                else if(b.getX() + b.getWidth() >= frame.getWidth() && b.getY() + b.getHeight() <= frame.getHeight() && b.getY() >= 0){
                    b.modifyhorizontalVelocity();
                    b.updatePosition(frame.getWidth() - b.getWidth(),b.getY());
                }
                else if(b.getX() + b.getWidth() >= frame.getWidth() && b.getY() <= 0){
                    b.modifyVerticalVelocity();
                    b.updatePosition(frame.getWidth() - b.getWidth(),0);
                }
                else if(b.getX() + b.getWidth() <= frame.getWidth() && b.getX() >= 0 && b.getY() <= 0){
                    b.modifyVerticalVelocity();
                    b.updatePosition(b.getX(),0);
                }
                else if(b.getX() <= 0 && b.getY() <= 0){
                    b.modifyVerticalVelocity();
                    b.modifyhorizontalVelocity();
                    b.updatePosition(0,0);
                }
                else if(b.getX() <= 0 && b.getY() >= 0 && b.getY() + b.getHeight() <= frame.getHeight()){
                    b.modifyhorizontalVelocity();
                    b.updatePosition(0, b.getY());
                }
                else if(b.getX() <= 0 && b.getY() + b.getHeight()>= frame.getHeight()){
                    b.modifyVerticalVelocity();
                    b.modifyhorizontalVelocity();
                    b.updatePosition(0,frame.getHeight() - b.getHeight());
                }
                // else if(b.getX() >= 0 && b.getX() + b.getWidth()<= frame.getWidth() && b.getY() + b.getHeight() * 3 >= frame.getHeight()){
                else if(b.getX() >= 0 && b.getX() + b.getWidth()<= frame.getWidth() && b.getY()  >= frame.getHeight() - b.getHeight() * 2){
                    b.modifyVerticalVelocity();
                    b.updatePosition(b.getX(),frame.getHeight() - b.getHeight() * 2);
                    // b.updatePosition();
                }
                
                b.updatePosition(b.getX() + b.getHorizontalVelocity(),b.getY() + b.getVerticalVelocity());
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                frame.repaint();
            }
        }
    }
}

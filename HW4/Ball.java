import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.security.SecureRandom;


public class Ball {
    
    private int posX;
    private int posY;
    public final int width = 20;
    private final int height = 20;
    private int verticalVelocity;  
    private int horizontalVelocity;
    private final int [] velocityMultiplier = new int[]{1,-1}; 
    // private int verticalVelocity;
    // private int v
    public Color color;

    public Ball(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
        color = new Color(0,0,0,0);
        SecureRandom random = new SecureRandom();
        verticalVelocity = 5 * velocityMultiplier[random.nextInt(2)];
        horizontalVelocity = 5 * velocityMultiplier[random.nextInt(2)];
        // color = Color.RED;
    }

    // @Override
    // public void paintComponent(Graphics g){
    //     super.paintComponent(g);
    //     SecureRandom random = new SecureRandom();
    //     g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
    //     g.fillOval(posX, posY, width, height);;
    // }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(posX, posY, width, height);
    }

    public void updatePosition(int x, int y){
        this.posX = x;
        this.posY = y;
    }

    public int getX(){

        return posX;
    }

    public int getY(){

        return posY;
    }

    public void setX(int x){
        posX = x;
    }

    public void setY(int y){
        posY = y;
    }

    public int getVerticalVelocity(){
        return verticalVelocity;
    }

    public int getHorizontalVelocity(){
        return horizontalVelocity;
    }

    public void modifyVerticalVelocity(){
        verticalVelocity *= -1; 
    }

    public void modifyhorizontalVelocity(){
        horizontalVelocity *= -1; 
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }
}

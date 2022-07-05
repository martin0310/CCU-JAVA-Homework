import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class DrawPanel extends JPanel {
    
    private List<Ball> ballList;
    private int ballNumber;

    public DrawPanel(List<Ball> ballList, int ballNumber){
        this.ballList = ballList;
        this.ballNumber = ballNumber;
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        for (Ball b: ballList) {
            b.draw(graphics);
        }
    }

}

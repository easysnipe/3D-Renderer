import java.awt.*;
import javax.swing.*;
import java.util.concurrent.TimeUnit;
import java.awt.event.*;

public class Draw implements KeyListener
{
    private JFrame win;
    private Container contentPane;
    private Graphics g;
    private Prisim shape;
    private Point d, cO, c;
    private double focalLength;
    public Draw(Prisim object) throws InterruptedException
    {
        d = new Point(0,0,0);
        cO = new Point(0,0,0);
        c = new Point(0,0,0);
        focalLength = 1;
        win = new JFrame("3D Renderer");
        win.setSize(1920,1080);
        win.setLocation(0,0);
        win.setVisible(true);
        contentPane = win.getContentPane();
        g = contentPane.getGraphics();
        win.addKeyListener(this);
        shape = object;
        TimeUnit.MILLISECONDS.sleep(100);
        DrawShapes(c, cO);
        
    }
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyChar() == 'a')
        {
        } 
        else if (e.getKeyChar() == 's')
        {
        }
        cO.setX3(1);
        cO.setY3(1);
        cO.setZ3(1);
        c.setX3(1);
        c.setY3(1);
        c.setZ3(1);
        DrawShapes(c, cO);
    }
    public void keyReleased(KeyEvent e)
    {
    }
    public void keyTyped(KeyEvent e)
    {
    }
    public void DrawShapes( Point camOrientation, Point cam)
    {
        shape.create3dPoints();
        cO = camOrientation;
        c = cam;
        shape.CreatePerspective(c, cO);
        shape.ConvertTo2D(focalLength, 0, 0);
        shape.createLines();
        Line[] lines = shape.getLines();
        System.out.println(lines[0].getPointA().getX2());
        g.setColor(new Color(0,0,0));
        for (Point P : shape.getPoints())
        {
            System.out.println("(" + P.getX2() + " ," + P.getY2() + ")");
        }
        for (Line line : lines)
        {
            g.drawLine((int)line.getPointA().getX2(), (int)line.getPointA().getY2(), (int)line.getPointB().getX2(), (int)line.getPointB().getY2());
        }
    }
}   
import java.awt.*;
import javax.swing.*;
import java.util.concurrent.TimeUnit;
import java.awt.event.*;

public class Draw implements KeyListener
{
    private int currentLine = -1;
    private JFrame win;
    Container contentPane;
    Graphics g;
    Prisim shape;
    Point d, cO, c;
    double focalLength;
    public Draw(Prisim object) throws InterruptedException
    {
        d = new Point(0,0,0);
        cO = new Point(0,0,0);
        c = new Point(0,0,0);
        focalLength = 5;
        win = new JFrame("3D Renderer");
        win.setSize(1920,1080);
        win.setLocation(0,0);
        win.setVisible(true);
        contentPane = win.getContentPane();
        g = contentPane.getGraphics();
        win.addKeyListener(this);
        shape = object;
        TimeUnit.MILLISECONDS.sleep(300);
        
    }
    public void keyPressed(KeyEvent e)
    {
        System.out.println(e.getKeyChar());
        if (e.getKeyChar() == 'a')
        {
            DrawShapes(d, c, c);
        } 
        else if (e.getKeyChar() == 's')
        {
            DrawShapes(d, c, c);
        }
        else if (e.getKeyChar() == 'd')
        {
            currentLine++;
            shape.ConvertTo2D(focalLength, 0, 0);
            shape.createLines();
            Line[] lines = shape.getLines();
            g.setColor(new Color(0,0,0));
            g.drawLine((int)lines[currentLine].getPointA().getX2(), (int)lines[currentLine].getPointA().getY2(), (int)lines[currentLine].getPointB().getX2(), (int)lines[currentLine].getPointB().getY2());
        }
        else if (e.getKeyChar() == 'f')
        {
            currentLine++;
            shape.create3dPoints();
            shape.ConvertTo2D(focalLength, 0, 0);
            shape.createLines();
            Line[] lines = shape.getLines();
            g.setColor(new Color(0,0,0));
            g.drawLine((int)lines[currentLine].getPointA().getX2(), (int)lines[currentLine].getPointA().getY2(), (int)lines[currentLine].getPointB().getX2(), (int)lines[currentLine].getPointB().getY2());

        }
        d.setX3(100);
        d.setY3(1);
        d.setZ3(1);
        cO.setX3(1);
        cO.setY3(1);
        cO.setZ3(1);
        c.setX3(1);
        c.setY3(1);
        c.setZ3(1);
        
    }
    public void keyReleased(KeyEvent e)
    {
        //System.out.println("Key Pressed");
    }
    public void keyTyped(KeyEvent e)
    {
        //System.out.println("Key Pressed");

    }
    public void DrawShapes(Point display, Point camOrientation, Point cam)
    {
        shape.create3dPoints();
        d = display;
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
import java.awt.*;
import javax.swing.*;
import java.util.concurrent.TimeUnit;
import java.awt.event.*;

public class Draw implements KeyListener
{
    private JFrame win;
    Container contentPane;
    Graphics g;
    Prisim shape;
    Point d, cO, c;
    public Draw(Prisim object) throws InterruptedException
    {
        d = new Point(0,0,0);
        cO = new Point(0,0,0);
        c = new Point(0,0,0);
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
            d.setZ3(d.getZ3() + 1);
        } 
        else if (e.getKeyChar() == 's')
        {
            d.setZ3(d.getZ3() - 1);
        }
        DrawShapes(d,cO,c);
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
        shape.create3dPoints(1920/2, 1080/2);
        d = display;
        cO = camOrientation;
        c = cam;
        shape.CreatePerspective(c, cO);
        shape.ConvertTo2D(d);
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
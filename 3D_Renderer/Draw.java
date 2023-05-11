import java.awt.*;
import javax.swing.*;
import java.util.concurrent.TimeUnit;
import java.awt.event.*;
import java.time.Instant;

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
        c = new Point(0,10,200);
        focalLength = 200;
        win = new JFrame("3D Renderer");
        win.setSize(1920,1080);
        win.setLocation(0,0);
        win.setVisible(true);
        contentPane = win.getContentPane();
        g = contentPane.getGraphics();
        win.addKeyListener(this);
        shape = object;
        TimeUnit.MILLISECONDS.sleep(100);
        DrawShapes(cO, c);
        win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void keyPressed(KeyEvent e) 
    {
        contentPane.removeAll();
        contentPane.revalidate();
        contentPane.repaint();
        if (e.getKeyChar() == 'a')
        {
            c.setX3(c.getX3() + 1);
        } 
        else if (e.getKeyChar() == 's')
        {
            c.setX3(c.getX3() - 1);
        }
        else if (e.getKeyChar() == 'd')
        {
            c.setY3(c.getY3() + 1);
        }
        else if (e.getKeyChar() == 'f')
        {
            c.setY3(c.getY3() - 1);
        }
        else if (e.getKeyChar() == 'g')
        {
            c.setZ3(c.getZ3() + 1);
        }
        else if (e.getKeyChar() == 'h')
        {
            c.setZ3(c.getZ3() - 1);
        }
        else if (e.getKeyChar() == 'z')
        {
            focalLength++;
        }
        else if (e.getKeyChar() == 'x')
        {
            focalLength--;
        }
        contentPane = win.getContentPane();
        g = contentPane.getGraphics();
        DrawShapes(cO, c);
        
    
        // Instant start = Instant.now();
        // while(Instant.now().toEpochMilli() < (start.toEpochMilli() + 1000))
        // {

        // }
        

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
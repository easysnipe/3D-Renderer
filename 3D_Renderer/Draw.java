import java.awt.*;
import javax.swing.*;
import java.util.concurrent.TimeUnit;
import java.awt.event.*;

public class Draw extends JPanel implements Runnable
{
    private Graphics g;
    private Prisim shape;
    private Point d, cO, c;
    private double focalLength;
    private int xAdd;
    private Thread drawThread;
    private KeyInputs keyI = new KeyInputs();
    private final int FPS = 60;
    public Draw(Prisim object) throws InterruptedException
    {
        //Create window and add needed functions
        this.setPreferredSize(new Dimension(1920,1080));
        this.setLocation(0,0);
        this.setDoubleBuffered(true);

        TimeUnit.MILLISECONDS.sleep(100);
        this.addKeyListener(keyI);
        this.setFocusable(true);
        this.requestFocus();

        //Set default values
        shape = object;
        d = new Point(500,100,200); 
        cO = new Point(0,0,0); 
        c = new Point(0,0,0); 
        int xAdd = 0;
        
    }
    public void startDrawThread()
    {
        drawThread = new Thread(this);   
        drawThread.start();
    }
    public void run() 
    {
        double interval = 1000000000/FPS;
        double draw = System.nanoTime() + interval;

        while(drawThread != null)
        {
            long time = System.nanoTime();
            update();
            repaint();

            double timeLeft = draw - System.nanoTime();
            timeLeft = timeLeft/1000000;
            if (timeLeft < 0)
            {
                timeLeft = 0;
            }
            try
            {
                Thread.sleep((long)timeLeft);
                draw += interval;
            }
            catch (InterruptedException e) {}
        }
    }
    public void update()
    {
        if (keyI.aPress)
        {
            c.setX3(c.getX3() + 10);
        } 
        else if (keyI.sPress)
        {
            c.setX3(c.getX3() - 10);
        }
        else if (keyI.dPress)
        {
            c.setY3(c.getY3() + 1);
        }
        else if (keyI.fPress)
        {
            c.setY3(c.getY3() - 1);
        }
        else if (keyI.gPress)
        {
            c.setZ3(c.getZ3() + 1);
        }
        else if (keyI.hPress)
        {
            c.setZ3(c.getZ3() - 1);
        }
        else if (keyI.zPress)
        {
            focalLength++;
        }
        else if (keyI.xPress)
        {
            focalLength++;
        }
        else if (keyI.oPress)
        {
            xAdd++;
        }
        else if (keyI.pPress)
        {
            xAdd++;
        }
    }
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);

        g.drawString("Focal Length: " + focalLength, 20,20);
        g.drawString("AddX: " + xAdd, 20,35);
        g.drawString("Camera: (" + c.getX3() + " ," + c.getY3() + " ," + c.getZ3() + " )", 20, 50);

        shape.create3dPoints(xAdd);
        shape.CreatePerspective(c, cO);
        shape.ConvertTo2D(d, 0, 0);
        shape.createLines();
        Line[] lines = shape.getLines();

        //System.out.println(lines[0].getPointA().getX2());

        g.setColor(new Color(0,0,0));
        // for (Point P : shape.getPoints())
        // {
        //     System.out.println("(" + P.getX2() + " ," + P.getY2() + ")");
        // }
        for (Line line : lines)
        {
            g.drawLine((int)line.getPointA().getX2(), (int)line.getPointA().getY2(), (int)line.getPointB().getX2(), (int)line.getPointB().getY2());
        }
        g.dispose();
    }
}   
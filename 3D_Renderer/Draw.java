import java.awt.*;
import javax.swing.*;
import java.util.concurrent.TimeUnit;
import java.awt.event.*;

public class Draw extends JPanel implements Runnable
{
    private Graphics g;
    private Prisim shape;
    private Point d, cO, c;
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
        d = new Point(960,540,400); 
        cO = new Point(0,0,0); 
        c = new Point(0,0,0); 
        
    }
    public void startDrawThread()
    {
        drawThread = new Thread(this);   
        drawThread.start();
    }
    public void run() //Main loop
    {
        int loopsPassed = 0;
        double interval = 1000000000/FPS;
        double draw = System.nanoTime() + interval;

        while(drawThread != null)
        {
            loopsPassed++;
            if (loopsPassed >= 1)
            {
                loopsPassed = 0;
                update();
                repaint();
            }
            long time = System.nanoTime();

            double timeLeft = draw - System.nanoTime();
            timeLeft = timeLeft/1000000;
            if (timeLeft < 0)
            {
                timeLeft = 0;
            }
            try
            {
                System.out.println(timeLeft);
                Thread.sleep((long)timeLeft);
                draw += interval;
            }
            catch (InterruptedException e) {}
        }
    }
    public void update() //Updates Panel based on input
    {
        if (keyI.aPress)
        {
            c.setX3(c.getX3() + 1);
        } 
        else if (keyI.sPress)
        {
            c.setX3(c.getX3() - 1);
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
        else if (keyI.jPress)
        {
            d.setX3(d.getX3() + 1);
        }
        else if (keyI.kPress)
        {
            d.setX3(d.getX3() - 1);
        }
        else if (keyI.lPress)
        {
            d.setY3(d.getY3() + 1);
        }
        else if (keyI.semiPress)
        {
            d.setY3(d.getY3() - 1);
        }
        if (keyI.zPress)
        {
            d.setZ3(d.getZ3() + 1);
        } 
        else if (keyI.xPress)
        {
            d.setZ3(d.getZ3() - 1);
        }
        else if (keyI.cPress)
        {
            cO.setX3(cO.getX3() + 0.1);
        }
        else if (keyI.vPress)
        {
            cO.setX3(cO.getX3() - 0.1);
        }
        else if (keyI.bPress)
        {
            cO.setY3(cO.getY3() + 0.1);
        }
        else if (keyI.nPress)
        {
            cO.setY3(cO.getY3() - 0.1);
        }
        else if (keyI.mPress)
        {
            cO.setZ3(cO.getX3() + 0.1);
        }
        else if (keyI.colPress)
        {
            cO.setZ3(cO.getX3() - 0.1);
        }
        else if (keyI.backPress)
        {
            d = new Point(0,0,400); 
            cO = new Point(0,0,0); 
            c = new Point(0,0,0); 
        }
    }
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);

        g.drawString("Dispaly: (" + d.getX3() + " ," + d.getY3() + " ," + d.getZ3() + " )", 20,20);
        g.drawString("Camera Angle: (" + (int)cO.getX3() + " ," + (int)cO.getY3() + " ," + (int)cO.getZ3() + " )", 20,35);
        g.drawString("Camera: (" + c.getX3() + " ," + c.getY3() + " ," + c.getZ3() + " )", 20, 50);
        g.drawString("Controls (WIP): ", 20,1000);
        g.drawString("Camera: Right = A, Left = S, Up = D, Down = F", 20,1015);
        g.drawString("FOV Adjustment: + = z, - = x", 20,1030);
        g.drawString("Rotation: Right = C, Left =V, Up = B, Down = N", 20,1045);


        shape.create3dPoints();
        shape.CreatePerspective(c, cO);
        shape.ConvertTo2D(d.getZ3());
        shape.createLines();
        Line[] lines = shape.getLines();
        Point[] points = shape.getPoints(); 

        g.setColor(new Color(0,0,0));
        System.out.println("\n");
        for (Point P : shape.getPoints())
        {
            System.out.println("(" + P.getX2() + " ," + P.getY2() + ")");
        }
        int count = 0;
        for (Line line : lines)
        {
            g.drawLine((int)line.getPointA().getX2(), (int)line.getPointA().getY2(), (int)line.getPointB().getX2(), (int)line.getPointB().getY2());
        }
        for (Point point : points)
        {
            g.drawString(count + "", (int)point.getX2(), (int)point.getY2());
            count++;
        }
        g.dispose();
    }
}   
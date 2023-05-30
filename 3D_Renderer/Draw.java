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
    private MouseInputs mouseI = new MouseInputs();
    private final int FPS = 60;
    public Draw(Prisim object) throws InterruptedException
    {
        //Create window and add needed functions
        this.setPreferredSize(new Dimension(1920,1080));
        this.setLocation(0,0);
        this.setDoubleBuffered(true);
        this.setFocusTraversalKeysEnabled(false);

        TimeUnit.MILLISECONDS.sleep(100);
        this.addKeyListener(keyI);
        this.addMouseListener(mouseI);
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

            double timeLeft = draw - System.nanoTime(); //Makes sure that the framrate is a constant 60 FPS
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
    public void update() //Updates Panel based on input
    {
        if (keyI.aPress)
        {
            c.setX3(c.getX3() + 1);
        } 
        if (keyI.sPress)
        {
            c.setX3(c.getX3() - 1);
        }
        if (keyI.dPress)
        {
            c.setY3(c.getY3() + 1);
        }
        if (keyI.fPress)
        {
            c.setY3(c.getY3() - 1);
        }
        if (keyI.gPress)
        {
            c.setZ3(c.getZ3() + 1);
        }
        if (keyI.hPress)
        {
            c.setZ3(c.getZ3() - 1);
        }
        if (keyI.jPress)
        {
            shape.setSize(shape.getSize() + 1);
        }
        if (keyI.kPress)
        {
            shape.setSize(shape.getSize() - 1);
        }
        if (keyI.lPress)
        {
            d.setY3(d.getY3() + 1);
        }
        if (keyI.semiPress)
        {
            d.setY3(d.getY3() - 1);
        }
        if (keyI.zPress)
        {
            d.setZ3(d.getZ3() + 1);
        } 
        if (keyI.xPress)
        {
            d.setZ3(d.getZ3() - 1);
        }
        if (keyI.cPress)
        {
            cO.setX3(cO.getX3() + 0.1);
        }
        if (keyI.vPress)
        {
            cO.setX3(cO.getX3() - 0.1);
        }
        if (keyI.bPress)
        {
            cO.setY3(cO.getY3() + 0.1);
        }
        if (keyI.nPress)
        {
            cO.setY3(cO.getY3() - 0.1);
        }
        if (keyI.mPress)
        {
            cO.setZ3(cO.getZ3() + 0.1);
        }
        if (keyI.lessPress)
        {
            cO.setZ3(cO.getZ3() - 0.1);
        }
        if (keyI.backPress) // Reset all values to defaults
        {
            d = new Point(0,0,400); 
            cO = new Point(0,0,0); 
            c = new Point(0,0,0); 
        }
        if (mouseI.cubeClick) //Change the shape when button is pressed
        {
            if (shape.getCode() != 0)
            {
                double size = shape.getSize();
                shape = new Cube(size);
            }
        }
        else if (mouseI.pyramidClick)
        {
            if (shape.getCode() != 1)
            {
                double size = shape.getSize();
                shape = new Pyramid(size);
            }
        }

    }
    public void paintComponent(Graphics g) //Draws all of the lines and buttons
    {
        super.paintComponent(g);

        g.setFont(new Font("Arial", Font.PLAIN, 12));
        g.drawString("Dispaly: (" + d.getX3() + " ," + d.getY3() + " ," + d.getZ3() + " )", 20,20); //Status text
        g.drawString("Camera Angle: (" + (int)cO.getX3() + " ," + (int)cO.getY3() + " ," + (int)cO.getZ3() + " )", 20,35);
        g.drawString("Camera: (" + c.getX3() + " ," + c.getY3() + " ," + c.getZ3() + " )", 20, 50);
        g.drawString("Controls (WIP): ", 20,1000);
        g.drawString("Camera: Right = A, Left = S, Up = D, Down = F", 20,1015);
        g.drawString("FOV Adjustment: + = z, - = x", 20,1030);
        g.drawString("Rotation: Right = C, Left =V, Up = B, Down = N", 20,1045);

        g.fillRect(1750, 20, 150,50);
        g.fillRect(1750, 90, 150, 50);
        
        g.setColor(new Color(255,255,255)); //Buttons
        g.setFont(new Font("Arial", Font.PLAIN, 30));
        g.drawString("Cube", 1787, 60);
        g.drawString("Pyramid", 1770, 130);
        
        shape.create3dPoints();
        shape.CreatePerspective(c, cO);
        shape.ConvertTo2D(d.getZ3());
        shape.createLines();
        Line[] lines = shape.getLines();
        Point[] points = shape.getPoints(); 

        g.setColor(new Color(0,0,0));
        int count = 0;
        for (Line line : lines) // Draw the lines
        {
            g.drawLine((int)line.getPointA().getX2(), (int)line.getPointA().getY2(), (int)line.getPointB().getX2(), (int)line.getPointB().getY2());
        }
        g.setFont(new Font("Arial", Font.PLAIN, 12));
        for (Point point : points) // Draw point number
        {
            g.drawString(count + "", (int)point.getX2(), (int)point.getY2());
            count++;
        }
        g.dispose();
    }
}   
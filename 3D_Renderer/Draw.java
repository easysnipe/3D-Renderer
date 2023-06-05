import java.awt.*;
import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class Draw extends JPanel implements Runnable
{
    private Prisim shape;
    private Point d, cO, c;
    private Thread drawThread;
    private KeyInputs keyI = new KeyInputs();
    private MouseInputs mouseI = new MouseInputs();
    private final int FPS = 60;
    private int[] res;
    public Draw(Prisim object, int[] resolution) throws InterruptedException
    {
        //Create window and add needed functions
        res = resolution;
        this.setLocation(0,0);
        this.setDoubleBuffered(true);
        this.setFocusTraversalKeysEnabled(false);
        this.setPreferredSize(new Dimension(res[0], res[1]));

        TimeUnit.MILLISECONDS.sleep(100);
        this.addKeyListener(keyI);
        this.addMouseListener(mouseI);
        mouseI.resolution = res;
        this.setFocusable(true);
        this.requestFocus();

        //Set default values
        shape = object;
        d = new Point(960,540,400); 
        cO = new Point(0,0,0); 
        c = new Point(0,0,0); 
        
    }
    public void startDrawThread() //Start the main loop
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

            double timeLeft = draw - time; //Makes sure that the framrate is a constant 60 FPS
            timeLeft = timeLeft/1000000; 
            if (timeLeft < 0)
            {
                timeLeft = 0;
            }
            //If there is still left by the time that the objects are drawn this makes the program wait in order to keep framrate stable
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
            c.setX3(c.getX3() - 1);
        } 
        if (keyI.sPress)
        {
            c.setZ3(c.getZ3() - 1);
        }
        if (keyI.dPress)
        {
            c.setX3(c.getX3() + 1);
        }
        if (keyI.wPress)
        {
            c.setZ3(c.getZ3() + 1);
        }
        if (keyI.qPress)
        {
            c.setY3(c.getY3() + 1);
        }
        if (keyI.ePress)
        {
            c.setY3(c.getY3() - 1);
        }
        if (keyI.laPress)
        {
            cO.setY3(cO.getY3() - 0.1);
        }
        if (keyI.raPress)
        {
            cO.setY3(cO.getY3() + 0.1);
        }
        if (keyI.uaPress)
        {
            cO.setX3(cO.getX3() + 0.1); 
        }
        if (keyI.daPress)
        {
            cO.setX3(cO.getX3() - 0.1);
        }
        if (keyI.lePress)
        {
            cO.setZ3(cO.getZ3() - 0.1);
        }
        if (keyI.grPress)
        {
            cO.setZ3(cO.getZ3() + 0.1);
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
        else if (mouseI.hexagonalClick)
        {
            if (shape.getCode() != 2)
            {
                double size = shape.getSize();
                shape = new Hexagonal(size);
            }
        }

    }
    //Draws all of the lines and buttons
    //Uses the Prisim object to draw the 3D object to the screen
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);

        g.setFont(new Font("Arial", Font.PLAIN, 12));
        g.drawString("Focal Length: (" + d.getZ3() + " )", 20,20); //Status text adn controls
        g.drawString("Camera Angle: (" + (int)cO.getX3() + " ," + (int)cO.getY3() + " ," + (int)cO.getZ3() + " )", 20,35);
        g.drawString("Camera: (" + c.getX3() + " ," + c.getY3() + " ," + c.getZ3() + " )", 20, 50);
        g.drawString("Controls (WIP): ", 20,res[1] - 80);
        g.drawString("Camera: Right = D, Left = A, Up = E, Down = Q, Forward = W, Backwards = S", 20,res[1] - 65);
        g.drawString("FOV Adjustment: + = z, - = x", 20,1030);
        g.drawString("Rotation: Arrow keys ", 20,res[1] - 35);

        g.fillRect(res[0] - 170, 20, 150,50); //Buttons
        g.fillRect(res[0] - 170, 90, 150, 50);
        g.fillRect(res[0] - 170, 160, 150, 50);
        
        g.setColor(new Color(255,255,255)); //Buttons
        g.setFont(new Font("Arial", Font.PLAIN, 30));
        g.drawString("Cube", res[0] - 133, 60);
        g.drawString("Pyramid", res[0] - 150, 130);
        g.drawString("Hexagonal", res[0] - 170, 200);

        
        shape.create3dPoints();
        shape.CreatePerspective(c, cO);
        shape.ConvertTo2D(d.getZ3(), res);
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
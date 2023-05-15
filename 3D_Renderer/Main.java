import javax.swing.JFrame;

public class Main
{
    public static void main(String[]args) throws InterruptedException
    {
        JFrame win = new JFrame();
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setTitle("3D Renderer");

        Prisim cube = new Cube(100);
        Draw threeD = new Draw(cube);
        win.add(threeD);
        win.pack();

        win.setLocationRelativeTo(null);
        win.setResizable(false);
        win.setVisible(true);
        
        threeD.startDrawThread();
        
    }
}
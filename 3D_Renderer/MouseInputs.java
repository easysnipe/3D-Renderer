import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class MouseInputs implements MouseListener
{
    boolean cubeClick, pyramidClick, hexagonalClick;

    public void mouseEntered(MouseEvent e)
    {

    }

    public void mouseExited(MouseEvent e)
    {

    }

    public void mouseClicked(MouseEvent e)
    {

    }

    public void mousePressed(MouseEvent e) //Checks if mouse is within the button when you click it, if so sets cubeClick true triggering update in the Draw Class
    {
        if (e.getX() >= 1750 && e.getX() <= 1900 && e.getY() >= 20 && e.getY() <= 70)
        {
            cubeClick = true;
            System.out.println("Cube clicked");
        } 
        else if (e.getX() >= 1750 && e.getX() <= 1900 && e.getY() >= 90 && e.getY() <= 140)
        {
            pyramidClick = true;
        }
        else if (e.getX() >= 1750 && e.getX() <= 1900 && e.getY() >= 160 && e.getY() <= 210)
        {
            hexagonalClick = true;
        }
        
    }

    public void mouseReleased(MouseEvent e)
    {
        cubeClick = false;
        pyramidClick = false;
        hexagonalClick = false;
    }
}
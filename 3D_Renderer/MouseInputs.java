import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class MouseInputs implements MouseListener
{
    boolean cubeClick, pyramidClick;
    public void mouseEntered(MouseEvent e)
    {

    }
    public void mouseExited(MouseEvent e)
    {

    }
    public void mouseClicked(MouseEvent e)
    {
        if (e.getX() >= 1750 && e.getY() <= 140 && e.getX() <= 1900 && e.getY() >= 20)
        {
            if (e.getY() <= 70)
            {
                cubeClick = true;
            }
            if (e.getY() >= 90)
            {
                pyramidClick = true;
            }
        }
    }
    public void mousePressed(MouseEvent e)
    {

    }
    public void mouseReleased(MouseEvent e)
    {

    }
}
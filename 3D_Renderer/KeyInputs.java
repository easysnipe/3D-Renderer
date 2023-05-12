import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class KeyInputs implements KeyListener
{
    public boolean aPress, sPress, dPress, fPress, gPress, hPress, zPress, xPress, oPress, pPress;
    public void keyTyped(KeyEvent e) {}
    public void keyPressed(KeyEvent e)
    {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_A)
        {
            aPress = true;
        }
        if (code == KeyEvent.VK_S)
        {
            sPress = true;
        }
        if (code == KeyEvent.VK_D)
        {
            dPress = true;
        }
        if (code == KeyEvent.VK_F)
        {
            fPress = true;
        }
        if (code == KeyEvent.VK_G)
        {
            gPress = true;
        }
        if (code == KeyEvent.VK_H)
        {
            hPress = true;
        }
        if (code == KeyEvent.VK_Z)
        {
            zPress = true;
        }
        if (code == KeyEvent.VK_X)
        {
            xPress = true;
        }
        if (code == KeyEvent.VK_O)
        {
            oPress = true;
        }
        if (code == KeyEvent.VK_P)
        {
            pPress = true;
        }
    }
    public void keyReleased(KeyEvent e)
    {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A)
        {
            aPress = false;
        }
        if (code == KeyEvent.VK_S)
        {
            sPress = false;
        }
        if (code == KeyEvent.VK_D)
        {
            dPress = false;
        }
        if (code == KeyEvent.VK_F)
        {
            fPress = false;
        }
        if (code == KeyEvent.VK_G)
        {
            gPress = false;
        }
        if (code == KeyEvent.VK_H)
        {
            hPress = false;
        }
        if (code == KeyEvent.VK_Z)
        {
            zPress = false;
        }
        if (code == KeyEvent.VK_X)
        {
            xPress = false;
        }
        if (code == KeyEvent.VK_O)
        {
            oPress = false;
        }
        if (code == KeyEvent.VK_P)
        {
            pPress = false;
        }
    }
}

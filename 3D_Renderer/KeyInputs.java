import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class KeyInputs implements KeyListener
{
    public boolean wPress, sPress, aPress, dPress, qPress, ePress, raPress, uaPress, daPress, laPress, backPress, grPress, lePress;
    public void keyTyped(KeyEvent e) {}
    public void keyPressed(KeyEvent e) //Triggers update if one of the keys are pressed
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
        if (code == KeyEvent.VK_W)
        {
            wPress = true;
        }
        if (code == KeyEvent.VK_Q)
        {
            qPress = true;
        }
        if (code == KeyEvent.VK_E)
        {
            ePress = true;
        }
        if (code == KeyEvent.VK_LEFT)
        {
            laPress = true;
        }
        if (code == KeyEvent.VK_RIGHT)
        {
            raPress = true;
        }
        if (code == KeyEvent.VK_UP)
        {
            uaPress = true;
        }
        if (code == KeyEvent.VK_DOWN)
        {
            daPress = true;
        }
        if (code == KeyEvent.VK_COMMA)
        {
            lePress = true;
        }
        if (code == KeyEvent.VK_PERIOD)
        {
            grPress = true;
        }
        if (code == KeyEvent.VK_BACK_SPACE)
        {
            backPress = true;
        }
    }
    public void keyReleased(KeyEvent e) //Set to false after key is released so it is no longer triggering update
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
        if (code == KeyEvent.VK_W)
        {
            wPress = false;
        }
        if (code == KeyEvent.VK_LEFT)
        {
            laPress = false;
        }
        if (code == KeyEvent.VK_RIGHT)
        {
            raPress = false;
        }
        if (code == KeyEvent.VK_UP)
        {
            uaPress = false;
        }
        if (code == KeyEvent.VK_DOWN)
        {
            daPress = false;
        }
        if (code == KeyEvent.VK_COMMA)
        {
            lePress = false;
        }
        if (code == KeyEvent.VK_PERIOD)
        {
            grPress = false;
        }
        if (code == KeyEvent.VK_BACK_SPACE)
        {
            backPress = false;
        }
        if (code == KeyEvent.VK_Q)
        {
            qPress = false;
        }
        if (code == KeyEvent.VK_E)
        {
            ePress = false;
        }
        
    }
}

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class KeyInputs implements KeyListener
{
    public boolean aPress, sPress, dPress, fPress, gPress, hPress, zPress, xPress, jPress, kPress, lPress, semiPress, cPress, vPress, bPress, nPress, mPress, lessPress, backPress;
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
        if (code == KeyEvent.VK_J)
        {
            jPress = true;
        }
        if (code == KeyEvent.VK_K)
        {
            kPress = true;
        }
        if (code == KeyEvent.VK_L)
        {
            lPress = true;
        }
        if (code == KeyEvent.VK_SEMICOLON)
        {
            semiPress = true;
        }
        if (code == KeyEvent.VK_Z)
        {
            zPress = true;
        }
        if (code == KeyEvent.VK_X)
        {
            xPress = true;
        }
        if (code == KeyEvent.VK_C)
        {
            cPress = true;
        }
        if (code == KeyEvent.VK_V)
        {
            vPress = true;
        }
        if (code == KeyEvent.VK_B)
        {
            bPress = true;
        }
        if (code == KeyEvent.VK_N)
        {
            nPress = true;
        }
        if (code == KeyEvent.VK_M)
        {
            mPress = true;
        }
        if (code == KeyEvent.VK_COMMA)
        {
            lessPress = true;
        }
        if (code == KeyEvent.VK_BACK_SPACE)
        {
            backPress = true;
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
        if (code == KeyEvent.VK_J)
        {
            jPress = false;
        }
        if (code == KeyEvent.VK_K)
        {
            kPress = false;
        }
        if (code == KeyEvent.VK_L)
        {
            lPress = false;
        }
        if (code == KeyEvent.VK_SEMICOLON)
        {
            semiPress = false;
        }
        if (code == KeyEvent.VK_Z)
        {
            zPress = false;
        }
        if (code == KeyEvent.VK_X)
        {
            xPress = false;
        }
        if (code == KeyEvent.VK_C)
        {
            cPress = false;
        }
        if (code == KeyEvent.VK_V)
        {
            vPress = false;
        }
        if (code == KeyEvent.VK_B)
        {
            bPress = false;
        }
        if (code == KeyEvent.VK_N)
        {
            nPress = false;
        }
        if (code == KeyEvent.VK_M)
        {
            mPress = false;
        }
        if (code == KeyEvent.VK_COMMA)
        {
            lessPress = false;
        }
        if (code == KeyEvent.VK_BACK_SPACE)
        {
            backPress = false;
        }
    }
}

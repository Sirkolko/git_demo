package Program.Imagine;
/**
 * Class for demonstrating actual scheme;
 * Use JFrame methods.
 * Class runs in another thread, for testing thread technology.
 * @see javax.swing.JFrame
 * @see java.lang.Runnable
 * @version 1.0 28 Feb 2022
 * @author Sergiy Okhota
 */
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;



public class SchemeImagine extends JFrame implements Runnable{

    private static SchemeImagine scheme_window;
    private static Image BackGround;

    /**
     * Method sets and describes window parameters.
     * @return this method doesn't return anything.
     * @exception IOException when can not read imagine.
     * @exception IllegalArgumentException when imagine doesn't exist.
     * @see IOException
     * @see IllegalArgumentException
     */
    public static void showScheme()throws IOException {
        BackGround = ImageIO.read(SchemeImagine.class.getResourceAsStream("/ProtectionTransformerScheme.JPG"));
        scheme_window = new SchemeImagine();
        scheme_window.setSize(800, 600);
        scheme_window.setResizable(true);
        scheme_window.setTitle("Simplified electrical power grid scheme ");
        scheme_window.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        scheme_window.setLocation(0, 0);
        scheme_window.setVisible(true);
        SchemePaint schemePaint = new SchemePaint();
        scheme_window.add(schemePaint);

    }
    /**
     * Methods fills window created in @link showScheme.

     * @return this method doesn't return anything.
     * @exception IOException when can not read imagine.
     * @exception IllegalArgumentException when imagine doesn't exist.
     * @see IOException
     * @see IllegalArgumentException
     */
    public static void onRepaint (Graphics g){
        g.drawImage(BackGround,0,0,null);

    }
        public static void closeScheme(){
            scheme_window.removeAll();
           scheme_window.setVisible(false);

        }

    @Override
    public void run()  {
        try {
            showScheme();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static class SchemePaint extends JPanel{
        @Override
        protected void paintComponent (Graphics g){
            super.paintComponent(g);
            onRepaint(g);
            repaint();
        }
    }
    }


import javax.swing.*;
public class app
{
    public static void main(String args[])
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
               new gui().setVisible(true); 
            }
        });
    }
}

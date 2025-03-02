import javax.swing.*;
class app2
{
    public static void main(String args[])
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new gui2().setVisible(true);
                Song2 song = new Song2("D:/sorts/musicPlayer/musicPlayer/love came back.mp3");
                System.out.println(song.getSongTitle());
                System.out.println(song.getSongArtist());
            }
        });
    }
}

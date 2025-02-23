import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
public class gui extends JFrame
{
    public static final Color FRAME_COLOR = Color.BLACK;
    public static final Color TEXT_COLOR = Color.WHITE;
    gui()
    {
        JFrame jframe = new JFrame("music player");
        setSize(400, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        addGuiComponents();
    }
    private void addGuiComponents()
    {
        JToolBar toolbar = new JToolBar();
        toolbar.setBounds(0,0,getWidth(),20);
        toolbar.setFloatable(false); 
        JMenuBar menubar = new JMenuBar();
        toolbar.add(menubar);
        JMenu menu1 = new JMenu("songs");
        menubar.add(menu1);
        JMenuItem menuitem11 = new JMenuItem("load song");
        menu1.add(menuitem11);
        JMenu menu2 = new JMenu("playlists");
        menubar.add(menu2);
        JMenuItem menuitem21 = new JMenuItem("create playlist");
        menu2.add(menuitem21);
        JMenuItem menuitem22 = new JMenuItem("load playlist");
        menu2.add(menuitem22);
        add(toolbar);
        JLabel songImage = new JLabel(albumart("image1.jpg"));
        songImage.setBounds(0,50,getWidth()-20,255);
        add(songImage);
        JLabel songTitle = new JLabel("song title");
        songTitle.setBounds(0,285,getWidth()-10,30);
        songTitle.setHorizontalAlignment(SwingConstants.CENTER);
        add(songTitle);
        JLabel songArtist = new JLabel("song artist");
        songArtist.setBounds(0,315,getWidth()-10,30);
        songArtist.setHorizontalAlignment(SwingConstants.CENTER);
        add(songArtist);
        JSlider slider = new JSlider();
        slider.setBounds(0,340,getWidth()-5,10);
        slider.setBackground(null);
        add(slider);
        JPanel buttonSystem = new JPanel();
        buttonSystem.setBounds(0,415,getWidth()-10,80);
        JButton pause = new JButton(albumart("pause.png"));
        pause.setBackground(null);
        pause.setBorderPainted(false);
        JButton play = new JButton(albumart("play.png"));
        play.setBackground(null);
        play.setBorderPainted(false);
        JButton prev = new JButton(albumart("prev.png"));
        prev.setBackground(null);
        prev.setBorderPainted(false);
        JButton next = new JButton(albumart("next.png"));
        prev.setBackground(null);
        prev.setBorderPainted(false);
        buttonSystem.add(prev);
        buttonSystem.add(play);
        buttonSystem.add(pause);
        buttonSystem.add(next);
        add(buttonSystem);
    }
    private ImageIcon albumart(String filelocation)
    {
        try
        {
             BufferedImage artwork = ImageIO.read(new File(filelocation));
             return new ImageIcon(artwork);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
}

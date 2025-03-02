import javax.swing.*;
import java.awt.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;
import javax.swing.plaf.basic.BasicSliderUI;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class gui2 extends JFrame 
{
    public static final Color FRAME_COLOR = Color.BLACK;
    public static final Color WORDS_COLOR = Color.WHITE;
    public static final Color SLIDER_COLOR = Color.RED;
    public static final Color BUTTON_COLOR = Color.YELLOW;
    private Player2 player;
    private JFileChooser jFileChooser;
    private JLabel albumArt;
    private JLabel songName;
    private JLabel artistName;
    gui2() 
    {       
        player = new Player2();
        setTitle("Rajveer's Player");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(FRAME_COLOR);
        jFileChooser = new JFileChooser();
        jFileChooser.setCurrentDirectory(new File("D:/sorts/musicPlayer/musicPlayer"));
        setLayout(null);
        addGuiComponents();
    }

    public void addGuiComponents() 
    {
        JToolBar musicToolBar = new JToolBar();
        add(musicToolBar);
        musicToolBar.setBounds(0, 0, 380, 30);
        JMenuBar musicMenuBar = new JMenuBar();
        musicMenuBar.setForeground(Color.BLUE);
        musicToolBar.add(musicMenuBar);
        JMenu songs = new JMenu("Song");
        musicMenuBar.add(songs);
        JMenuItem loadSongs = new JMenuItem("Load song");
        loadSongs.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                jFileChooser.showOpenDialog(gui2.this);
                File selectedFile = jFileChooser.getSelectedFile();
                if(selectedFile != null)
                {
                   Song2 song = new Song2(selectedFile.getPath());
                   player.loadSong(song);
                   updateSongTitleAndArtist(song);
                }
            }
        });
        songs.add(loadSongs);
        JMenu playlists = new JMenu("Playlists");
        musicMenuBar.add(playlists);
        JMenuItem loadPlaylist = new JMenuItem("load playlist");
        JMenuItem makePlaylist = new JMenuItem("make playlist");
        playlists.add(loadPlaylist);
        playlists.add(makePlaylist);
        albumArt = new JLabel(loadAlbumArt(""));
        albumArt.setBounds(0, 50, 200, 255);
        add(albumArt);
        songName = new JLabel();
        songName.setBounds(0, 270, 380, 30);
        songName.setForeground(WORDS_COLOR);
        songName.setFont(new Font("Arial", Font.BOLD, 20));
        songName.setHorizontalAlignment(SwingConstants.CENTER);
        add(songName);
        artistName = new JLabel();
        artistName.setBounds(0, 295, 380, 30);
        artistName.setFont(new Font("Arial", Font.BOLD, 20));
        artistName.setForeground(WORDS_COLOR);
        artistName.setHorizontalAlignment(SwingConstants.CENTER);
        add(artistName);
        JSlider playbackSlider = new JSlider();
        playbackSlider.setBounds(0, 340, 400, 30);
        playbackSlider.setBackground(null);
        playbackSlider.setUI(new CircularThumbSliderUI(playbackSlider));
        add(playbackSlider);
        JPanel buttonSystem = new JPanel();
        buttonSystem.setBounds(0, 400, 400, 65);
        JButton prev = new JButton(loadAlbumArt("prev.png"));
        prev.setBackground(null);
        prev.setBorderPainted(false);
        buttonSystem.add(prev);
        JButton play = new JButton(loadAlbumArt("play.png"));
        play.setBackground(null);
        play.setBorderPainted(false);
        buttonSystem.add(play);
        JButton pause = new JButton(loadAlbumArt("pause.png"));
        buttonSystem.add(pause);
        pause.setBackground(null);
        pause.setBorderPainted(false);
        JButton next = new JButton(loadAlbumArt("next.png"));
        next.setBackground(null);
        next.setBorderPainted(false);
        buttonSystem.add(next);
        buttonSystem.setBackground(null);
        add(buttonSystem);
    }

    public ImageIcon loadAlbumArt(String location) 
    {
        try 
        {
            BufferedImage albumArt = ImageIO.read(new File(location));
            return new ImageIcon(albumArt);
        } catch (Exception ex) 
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    private void updateSongTitleAndArtist(Song2 song)
    {
        songName.setText(song.getSongTitle());
        artistName.setText(song.getSongArtist());
        
    }
}
class CircularThumbSliderUI extends BasicSliderUI 
{
    public CircularThumbSliderUI(JSlider slider) 
    {
        super(slider);
    }

    @Override
    public void paintThumb(Graphics g) 
    {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2.setComposite(AlphaComposite.Clear);
        g2.fillRect(thumbRect.x, thumbRect.y, thumbRect.width, thumbRect.height);
        g2.setComposite(AlphaComposite.SrcOver);
        
        int thumbSize = 20;
        int x = thumbRect.x + thumbRect.width / 2 - thumbSize / 2;
        int y = thumbRect.y + thumbRect.height / 2 - thumbSize / 2;
        
        g2.setColor(Color.RED);
        g2.fillOval(x, y, thumbSize, thumbSize);
        g2.setColor(Color.BLACK);
        g2.drawOval(x, y, thumbSize, thumbSize);
        g2.dispose();
    }
}


import database.Database;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

public class GameGUI {
    
    /*
    static private gui.Window window;
    static String userid;
    
    public static void setUserID(String id)
    {
        userid = id;
    }
    
    public static void createAndShowGui() {
        window = new gui.Window();
        JFrame frame = new JFrame("Tower Challenge Mission");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(window);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setMinimumSize(new Dimension(710, 540));
        JMenuBar menubar = new JMenuBar();
        JMenu menu = new JMenu("File");
        
        JMenuItem item = new JMenuItem("Save");
        menu.add(item);
        item.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("save");
                Database.save();
            }
        }));
        
        JMenuItem item2 = new JMenuItem("Restore");
        menu.add(item2);
        item2.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Database.restore(userid);
                window.update();
            }
        }));
        
        JMenuItem item3 = new JMenuItem("Reset");
        menu.add(item3);
        item3.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Database.reset();
                window.update();
            }
        }));
        
        // exit the game
        JMenuItem item4 = new JMenuItem("Exit");
        menu.add(item4);
        item4.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               System.exit(0);
            }
        }));
        
        menubar.add(menu);
        JMenu menu2 = new JMenu("Music");
        final JMenuItem item21 = new JMenuItem("Stop");
        item21.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (item21.getText().equals("Stop")) {
                    window.stopPlaying();
                    item21.setText("Resume");
                } else {
                    window.playBack();
                    item21.setText("Stop");
                }
            }
        }));
        menu2.add(item21);
        menubar.add(menu2);
        frame.setJMenuBar(menubar);
    }
   */
    
    static private gui.Window window;
    private static String player;
    
    public static void createAndShowGui(String thePlayer) {
        player = thePlayer;
        Database.init();
        window = new gui.Window();
        JFrame frame = new JFrame("Game");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(window);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setMinimumSize(new Dimension(710, 540));
        JMenuBar menubar = new JMenuBar();
        JMenu menu = new JMenu("Progress");
        JMenuItem itm = new JMenuItem("Save");
        menu.add(itm);
        itm.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("save");
                Database.save();
            }
        }));
        JMenuItem itm2 = new JMenuItem("Restore");
        menu.add(itm2);
        itm2.addActionListener((new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Database.restore(player);
                window.update();
            }
        }));
        JMenuItem itm3 = new JMenuItem("Reset");
        menu.add(itm3);
        itm3.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Database.reset();
                window.update();
            }
        }));
        menubar.add(menu);
        JMenu menu2 = new JMenu("Music");
        final JMenuItem itm21 = new JMenuItem("Stop");
        itm21.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (itm21.getText().equals("Stop")) {
                    window.stopPlaying();
                    itm21.setText("Resume");
                } else {
                    window.playBack();
                    itm21.setText("Stop");
                }
            }
        }));
        menu2.add(itm21);
        menubar.add(menu2);
        
        JMenu menu3 = new JMenu("Help");
        final JMenuItem itm31 = new JMenuItem("Help");
        itm31.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	ImageIcon playerIcon = new ImageIcon("res/player.png"); 
            	ImageIcon rockIcon = new ImageIcon("res/rock.png");
            	ImageIcon keyIcon = new ImageIcon("res/key.png");
            	ImageIcon monsterIcon = new ImageIcon("res/monster.png");
            	ImageIcon shieldIcon = new ImageIcon("res/shield.png");
            	ImageIcon wallIcon = new ImageIcon("res/wall.png");
            	ImageIcon lifeIcon = new ImageIcon("res/life.png");
            	ImageIcon doorIcon = new ImageIcon("res/door.png");
            	ImageIcon exitIcon = new ImageIcon("res/exit.png");
            	ImageIcon helmIcon = new ImageIcon("res/helm.png");
            	ImageIcon sandIcon = new ImageIcon("res/sand.png");
            	ImageIcon grassIcon = new ImageIcon("res/grass.png");
            	
            	String[] columnNames = {"Picture", "Description"};
            	
            	Object[][] data =
                    {
                    	{playerIcon, "Player"},
                        {keyIcon,     "Key"},
                        {rockIcon, "Rock"},
                        {monsterIcon, "Monster"},
                        {shieldIcon, "Shield"},
                        {wallIcon, "Wall"},
                        {lifeIcon, "Life"},
                        {doorIcon, "Door"},
                        {exitIcon, "Exit"},
                        {helmIcon, "Helmet"},
                        {sandIcon, "Sand"},
                        {grassIcon, "Grass"}
                    };

                    DefaultTableModel model = new DefaultTableModel(data, columnNames);
                    JTable table = new JTable( model )
                    {
                        public Class getColumnClass(int column)
                        {
                            return getValueAt(0, column).getClass();
                        }
                    };
                    table.setPreferredScrollableViewportSize(table.getPreferredSize());

                    JDialog jdialog = new JDialog();
                    JScrollPane scrollPane = new JScrollPane( table );
                    jdialog.add(scrollPane);
                    jdialog.setTitle("Help");
                    jdialog.setSize(400, 300);
                    jdialog.setVisible(true);
                
            }
        }));
        menu3.add(itm31);
        
        final JMenuItem itm32 = new JMenuItem("About");
        itm32.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	JDialog jdialog = new JDialog();
                jdialog.setTitle("About");
                JTextArea text1 = new JTextArea("          For More Information Contact The Game Developer team \n \n"
                		+ "                                Tower Challenge Mission Group \n"
                                + "                                      Tamim Alshakarah \n " 
                                + "                                      Khalid Alanazi \n " 
                                + "                                      Tian Zhao \n " 
                                + "                                      Alan Wu");
                jdialog.add(text1);
                jdialog.setSize(350, 100);
                jdialog.setVisible(true);
            	
            }
        }));
        menu3.add(itm32);
        menubar.add(menu3);
        
        frame.setJMenuBar(menubar);
    }
    
}

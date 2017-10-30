package gui;

import database.Database;
import game.Monster;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Field extends JPanel {
    public static BufferedImage buffer;
    static int d = 0;
    private ArrayList<JLabel> obj;
    public ArrayList<Monster> monsters;

    Field() {
        super();
        obj = new ArrayList<>();
        monsters = new ArrayList<Monster>();
        setLayout(null);
        update();
    }

    void update() {
        for (JLabel anObj : obj) {
            remove(anObj);
        }
        BufferedImage image = null;
        BufferedImage imageD = null;
        try {
            image = ImageIO.read(new File("res/key.png"));
            imageD = ImageIO.read(new File("res/door.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < Database.getObjects().length; i++) {
            for (int j = 0; j < Database.getObjects().length; j++) {
                ImageIcon img = null;
                int level = Database.getDataLevel()[1];
                switch (Database.getObjects()[j][i]) {
                    case 1:
                        img = new ImageIcon("res/player.png");
                        break;
                    case 2:
                        img = new ImageIcon("res/door.png");
                        break;
                    case 3:
                        img = new ImageIcon(Parameters.dye(image, new Color(255, 0, 0, 128)));
                        break;
                    case 4:
                        img = new ImageIcon(Parameters.dye(image, new Color(255, 0, 128, 128)));
                        break;
                    case 5:
                        img = new ImageIcon(Parameters.dye(image, new Color(0, 128, 0, 128)));
                        break;
                    case 6:
                        img = new ImageIcon(Parameters.dye(imageD, new Color(255, 0, 0, 128)));
                        break;
                    case 7:
                        img = new ImageIcon(Parameters.dye(imageD, new Color(255, 0, 128, 128)));
                        break;
                    case 8:
                        img = new ImageIcon(Parameters.dye(imageD, new Color(0, 128, 0, 128)));
                        break;
                    case 9:
                        img = new ImageIcon("res/exit.png");
                        break;
                    case 10:
                        img = new ImageIcon("res/helm.png");
                        break;
                    case 11:
                        img = new ImageIcon("res/shield.png");
                        break;
                    case 12:
                        img = new ImageIcon("res/life.png");
                        break;
                    case 13:
                        img = new ImageIcon("res/monster.png");
                        Monster m = new Monster(j,i);
                        monsters.add(m);
                        break;
                    default:
                        break;
                }
                JLabel object = new JLabel(img);
                object.setBounds(i * 25, j * 25, 25, 25);
                obj.add(object);
                add(object);
            }
        }
        repaint();
        revalidate();
        updateUI();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (buffer == null) {
            rebuildBuffer();
        }
        g.drawImage(buffer, 0, 0, this);
    }

    private void rebuildBuffer() {
        int w = getWidth();
        int h = getHeight();
        buffer = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = buffer.createGraphics();
        BufferedImage imagesL1[] = new BufferedImage[5];
        BufferedImage imagesL2[] = new BufferedImage[5];
        BufferedImage imagesL3[] = new BufferedImage[5];
        if (Database.getDataLevel()[1] == 1)
        {
        	try {
        		imagesL1[0] = ImageIO.read(new File("res/rock2.png"));
        		imagesL1[1] = ImageIO.read(new File("res/sand.png"));
        		imagesL1[2] = ImageIO.read(new File("res/grass.png"));
        		imagesL1[3] = ImageIO.read(new File("res/wall.png"));
        		imagesL1[4] = ImageIO.read(new File("res/exit.png"));
        	} catch (IOException e) {
            e.printStackTrace();
        	}
        	for (int x = 0; x < 20; x++) {
        		for (int y = 0; y < 20; y++) {
        			g2d.drawImage(imagesL1[Database.getField()[y][x]], x * 25, y * 25, this);
        		}
        	}
        }
        else if (Database.getDataLevel()[1] == 2)
        {
        	try {
        		imagesL2[0] = ImageIO.read(new File("res/rock4.png"));
        		imagesL2[1] = ImageIO.read(new File("res/sand.png"));
        		imagesL2[2] = ImageIO.read(new File("res/grass.png"));
        		imagesL2[3] = ImageIO.read(new File("res/wall.png"));
        		imagesL2[4] = ImageIO.read(new File("res/exit.png"));
        	} catch (IOException e) {
            e.printStackTrace();
        	}
        	for (int x = 0; x < 20; x++) {
        		for (int y = 0; y < 20; y++) {
        			g2d.drawImage(imagesL2[Database.getField()[y][x]], x * 25, y * 25, this);
        		}
        	}
        }
        else
        {
        	try {
        		imagesL3[0] = ImageIO.read(new File("res/rock3.png"));
        		imagesL3[1] = ImageIO.read(new File("res/sand.png"));
        		imagesL3[2] = ImageIO.read(new File("res/grass.png"));
        		imagesL3[3] = ImageIO.read(new File("res/wall.png"));
        		imagesL3[4] = ImageIO.read(new File("res/exit.png"));
        	} catch (IOException e) {
            e.printStackTrace();
        	}
        	for (int x = 0; x < 20; x++) {
        		for (int y = 0; y < 20; y++) {
        			g2d.drawImage(imagesL3[Database.getField()[y][x]], x * 25, y * 25, this);
        		}
        	}
        }
    }
}


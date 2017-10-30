package game;

import database.Database;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Player {
    public static ArrayList<Staff> staff;
    private static int X;
    private static int Y;
    private int way;

    public Player() {

        staff = new ArrayList<>();
        X = 0;
        Y = 0;
        way = Database.getObjects().length - 1;
        relocate();
    }

    public static void relocate() {
        for (int i = 0; i < Database.getObjects().length; i++) {
            for (int j = 0; j < Database.getObjects().length; j++) {
                switch (Database.getObjects()[i][j]) {
                    case 1:
                        X = i;
                        Y = j;
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public void go(String key) {
        Database.getObjects()[X][Y] = 0;
        int x = X;
        int y = Y;
        switch (key) {
            case "LEFT":
                if (y > 0) {
                    y--;
                }
                break;
            case "RIGHT":
                if (y < way) {
                    y++;
                }
                break;
            case "DOWN":
                if (x < way) {
                    x++;
                }
                break;
            case "UP":
                if (x > 0) {
                    x--;
                }
                break;
        }
        boolean go = false;
        if (Database.getField()[x][y] < 3) {
            switch (Database.getObjects()[x][y]) {
                case 2:
                    Database.getObjects()[x][y] = 0;
                    go = true;
                    break;
                case 3:
                    Database.getObjects()[x][y] = 0;
                    Database.getDataPlayer()[0]++;
                    go = true;
                    break;
                case 4:
                    Database.getObjects()[x][y] = 0;
                    Database.getDataPlayer()[1]++;
                    go = true;
                    break;
                case 5:
                    Database.getObjects()[x][y] = 0;
                    Database.getDataPlayer()[2]++;
                    go = true;
                    break;
                case 6:
                    if (Database.getDataPlayer()[0] > 0) {
                        Database.getDataPlayer()[0]--;
                        Database.getObjects()[x][y] = 0;
                        go = true;
                    }
                    break;
                case 7:
                    if (Database.getDataPlayer()[1] > 0) {
                        Database.getDataPlayer()[1]--;
                        Database.getObjects()[x][y] = 0;
                        go = true;
                    }
                    break;
                case 8:
                    if (Database.getDataPlayer()[2] > 0) {
                        Database.getDataPlayer()[2]--;
                        Database.getObjects()[x][y] = 0;
                        go = true;
                    }
                    break;
                case 9:
                	Database.newLevel();
                    for (int i = 0; i < Database.getObjects().length; i++) {
                        for (int j = 0; j < Database.getObjects().length; j++) {
                            switch (Database.getObjects()[i][j]) {
                                case 1:
                                    X = i;
                                    Y = j;
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                    break;
                case 10:
                    staff.add(new Staff(Database.getObjects()[x][y]));
                    Database.getDataPlayer()[4] = Database.getDataPlayer()[4] + 5;
                    go = true;
                    break;
                case 11:
                    staff.add(new Staff(Database.getObjects()[x][y]));
                    Database.getDataPlayer()[4] = Database.getDataPlayer()[4] + 10;
                    go = true;
                    break;
                case 12:
                    staff.add(new Staff(Database.getObjects()[x][y]));
                    Database.getDataPlayer()[5] = Database.getDataPlayer()[3] + 5;
                    go = true;
                    break;
                case 13:
                    if (Database.getDataPlayer()[3] > 10)
                    	Database.getDataPlayer()[5] = Database.getDataPlayer()[3] - 10;
                    else
                    	Database.getDataPlayer()[5] = 0;
                    	JOptionPane.showMessageDialog(null, "OWF!\n" + "YOu DIE !");
                    go = true;
                    break;
                default:
                    go = true;
            }
        }
        if (go) {
            X = x;
            Y = y;
        }
        Database.getObjects()[X][Y] = 1;

    }
}


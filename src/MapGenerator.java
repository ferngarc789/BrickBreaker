import java.awt.*;
import java.util.Random;

public class MapGenerator {
    public int map[][];
    public int brickWidth;
    public int brickHeight;
    public boolean recolor = true;
    public MapGenerator(int row, int col) {
        map = new int[row][col];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = 1;
            }
        }
        brickWidth = 540/col;
        brickHeight = 150/row;
    }
    public void draw(Graphics2D g) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] > 0) {
                    Random random = new Random();
                    int randomnumber = random.nextInt(5);
                    int white = 0;
                    int red = 1;
                    int blue = 2;
                    int green = 3;
                    // int pink = 4;
                    if (!recolor) {
                        if (randomnumber == white) {
                            g.setColor(Color.white);
                        } else if (randomnumber == red) {
                            g.setColor(Color.red);
                        } else if (randomnumber == blue) {
                            g.setColor(Color.blue);
                        } else if (randomnumber == green) {
                            g.setColor(Color.green);
                        } else {
                            g.setColor(Color.pink);
                        }
                    } else {
                        g.setColor(Color.white);
                    }


                    g.fillRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.black);
                    g.drawRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
                }
            }
        }
    }
    public void setBrickValue(int value, int row, int col) {
        map[row][col] = value;
    }
}

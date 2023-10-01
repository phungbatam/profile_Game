package Game.Tile;

import Game.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;

public class TileManager {
    GamePanel gp;
    Tile[] tile;
    int mapTileNum[][];
    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[10];
        mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];

        getTileImage();
        loadMap();
    }
    public void getTileImage() {
        try {

            // Browse files
            File til_0 = new File("A:\\Workspace\\Java\\Game\\Swing\\tutorial for Java 2D beginners\\src\\Assets\\Tiles\\Old version\\grass.png");
            File til_1 = new File("A:\\Workspace\\Java\\Game\\Swing\\tutorial for Java 2D beginners\\src\\Assets\\Tiles\\Old version\\wall.png");
            File til_2 = new File("A:\\Workspace\\Java\\Game\\Swing\\tutorial for Java 2D beginners\\src\\Assets\\Tiles\\Old version\\water.png");

            tile[0] = new Tile();
            tile[0].image = ImageIO.read(til_0);

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(til_1);

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(til_2);

        } catch(IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadMap() {
        try {

            // InputStream is = getClass().getResourceAsStream("A:\\Workspace\\Java\\Game\\Swing\\tutorial for Java 2D beginners\\Map\\map01.txt");
            File is = new File("A:\\Workspace\\Java\\Game\\Swing\\tutorial for Java 2D beginners\\src\\Assets\\Map\\map01.txt");
            BufferedReader br = new BufferedReader(new FileReader(is));

            int col = 0;
            int row = 0;
            while((col < gp.maxScreenCol) && (row < gp.maxScreenRow)) {

                String line = br.readLine();

                while(col < gp.maxScreenCol) {
                    String number[] = line.split(" ");

                    int num = Integer.parseInt(number[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }

                if(col == gp.maxScreenCol) {
                    col = 0;
                    row++;
                }

            }

            br.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {

        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while((col < gp.maxScreenCol) && (row < gp.maxScreenRow)) {

            int tileNum = mapTileNum[col][row];

            g2.drawImage(tile[tileNum].image, x, y, gp.titleSize, gp.titleSize, null);

            col++;

            x += gp.titleSize;

            if(col == gp.maxScreenCol)  {
                col = 0;
                x = 0;
                row++;
                y += gp.titleSize;
            }

        }

    }

}

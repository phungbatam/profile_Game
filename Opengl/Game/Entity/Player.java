package Game.Entity;

import Game.GamePanel;
import Game.KeyHanld;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player extends Entity{

    GamePanel gp;
    KeyHanld keyH;

    public final int screenX, screenY;

    public Player(GamePanel gp, KeyHanld keyH) {
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth / 2 - (gp.titleSize / 2);
        screenY = gp.screenHeight / 2 - (gp.titleSize / 2);

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        worldX = gp.titleSize * 10;
        worldY = gp.titleSize * 10;
        speed = 4;
        // show direction figure position
        direction = "right";
    }

    public void getPlayerImage() {
        // Link File move
        File fImageUp = new File("A:\\Workspace\\Java\\Game\\Swing\\tutorial for Java 2D beginners\\src\\Assets\\Player\\Walking sprites\\boy_up_1.png");
        File fImageUp2 = new File("A:\\Workspace\\Java\\Game\\Swing\\tutorial for Java 2D beginners\\src\\Assets\\Player\\Walking sprites\\boy_up_2.png");
        File fImageDown1 = new File("A:\\Workspace\\Java\\Game\\Swing\\tutorial for Java 2D beginners\\src\\Assets\\Player\\Walking sprites\\boy_down_1.png");
        File fImageDown2 = new File("A:\\Workspace\\Java\\Game\\Swing\\tutorial for Java 2D beginners\\src\\Assets\\Player\\Walking sprites\\boy_down_2.png");
        File fImageLeft1 = new File("A:\\Workspace\\Java\\Game\\Swing\\tutorial for Java 2D beginners\\src\\Assets\\Player\\Walking sprites\\boy_left_1.png");
        File fImageLeft2 = new File("A:\\Workspace\\Java\\Game\\Swing\\tutorial for Java 2D beginners\\src\\Assets\\Player\\Walking sprites\\boy_left_2.png");
        File fImageRight1 = new File("A:\\Workspace\\Java\\Game\\Swing\\tutorial for Java 2D beginners\\src\\Assets\\Player\\Walking sprites\\boy_right_1.png");
        File fImageRight2 = new File("A:\\Workspace\\Java\\Game\\Swing\\tutorial for Java 2D beginners\\src\\Assets\\Player\\Walking sprites\\boy_right_2.png");

        try{
            // move input Image IO File
            up1 = ImageIO.read(fImageUp);
            up2 = ImageIO.read(fImageUp2);
            down1 = ImageIO.read(fImageDown1);
            down2 = ImageIO.read(fImageDown2);
            left1 = ImageIO.read(fImageLeft1);
            left2 = ImageIO.read(fImageLeft2);
            right1 = ImageIO.read(fImageRight1);
            right2 = ImageIO.read(fImageRight2);

        } catch(IOException e) {
            e.printStackTrace();
        }

    }

    public void update() {

        /*
        *  keyH.upPressed == true
        *  keyH.downPressed == true
        *  keyH.leftPressed == true
        *  keyH.rightPressed == true
        * */

        if(keyH.upPressed || keyH.downPressed || keyH.leftPressed|| keyH.rightPressed) {
            if (keyH.upPressed) {
                direction = "up";
                worldY -= speed;
            } else if (keyH.downPressed) {
                direction = "down";
                worldY += speed;
            } else if (keyH.leftPressed) {
                direction = "left";
                worldX -= speed;
            } else {
                direction = "right";
                worldX += speed;
            }

            spriteCounter++;
            if(spriteCounter > 10) {

                if(spriteNum == 1) {
                    spriteNum = 2;
                } else if(spriteNum == 2) {
                    spriteNum = 1;
                }

                spriteCounter = 0;
            }
        }

    }

    public void draw(Graphics2D g2) {

        /*
        g2.setColor(Color.white);

        g2.fillRect(x, y, gp.titleSize, gp.titleSize);
        */

        BufferedImage image = null;

        switch (direction) {
            case "up":
                if(spriteNum == 1) {
                    image = up1;
                }
                if(spriteNum == 2) {
                    image = up2;
                }
                break;
            case "down":
                if(spriteNum == 1) {
                    image = down1;
                }
                if(spriteNum == 2) {
                    image = down2;
                }
                break;
            case "left":
                if(spriteNum == 1) {
                    image = left1;
                }
                if(spriteNum == 2) {
                    image = left2;
                }
                break;
            case "right":
                if(spriteNum == 1) {
                    image = right1;
                }
                if(spriteNum == 2) {
                    image = right2;
                }
                break;
        }

        g2.drawImage(image, screenX ,screenX, GamePanel.titleSize, GamePanel.titleSize, null);

    }

}

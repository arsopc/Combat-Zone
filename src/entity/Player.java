package entity;

import main.GamePanel;
import main.KeyHandler;
import main.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static java.awt.SystemColor.window;

public class Player extends Entity
{
    GamePanel gp;
    KeyHandler keyH;
    public final int screenX;
    public final int screenY;
    int hasKey=0;
    public Player(GamePanel gp, KeyHandler keyH)
    {

        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth/2  - gp.tileSize/2;
        screenY = gp.screenHeight/2 - gp.tileSize/2;

        solidArea = new Rectangle();
        solidArea.x = 30;
        solidArea.y = 19;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 2;
        solidArea.height = 18;

        setDefaultValue();
        getPlayerImage();
    }


    public void setDefaultValue()
    {
        worldX=gp.tileSize*25 -(96*3);
        worldY=gp.tileSize*25 -(96*3);
        speed =2;
        direction ="down";
    }

    public void getPlayerImage()
    {
        try
        {
            up1     = ImageIO.read(getClass().getResourceAsStream("/player/up_01-01.png"));
            up2     = ImageIO.read(getClass().getResourceAsStream("/player/up_02-01.png"));
            up3     = ImageIO.read(getClass().getResourceAsStream("/player/up_03-01.png"));
            up4     = ImageIO.read(getClass().getResourceAsStream("/player/up_04-01.png"));
            up5     = ImageIO.read(getClass().getResourceAsStream("/player/up_05-01.png"));
            up6     = ImageIO.read(getClass().getResourceAsStream("/player/up_06-01.png"));
            up7     = ImageIO.read(getClass().getResourceAsStream("/player/up_07-01.png"));
            up8     = ImageIO.read(getClass().getResourceAsStream("/player/up_08-01.png"));
            up9     = ImageIO.read(getClass().getResourceAsStream("/player/up_09-01.png"));

            down1   = ImageIO.read(getClass().getResourceAsStream("/player/down_01-01.png"));
            down2   = ImageIO.read(getClass().getResourceAsStream("/player/down_02-01.png"));
            down3   = ImageIO.read(getClass().getResourceAsStream("/player/down_03-01.png"));
            down4   = ImageIO.read(getClass().getResourceAsStream("/player/down_04-01.png"));
            down5   = ImageIO.read(getClass().getResourceAsStream("/player/down_05-01.png"));
            down6   = ImageIO.read(getClass().getResourceAsStream("/player/down_06-01.png"));
            down7   = ImageIO.read(getClass().getResourceAsStream("/player/down_07-01.png"));
            down8   = ImageIO.read(getClass().getResourceAsStream("/player/down_08-01.png"));
            down9   = ImageIO.read(getClass().getResourceAsStream("/player/down_09-01.png"));


            left1   = ImageIO.read(getClass().getResourceAsStream("/player/left_01-01.png"));
            left2   = ImageIO.read(getClass().getResourceAsStream("/player/left_02-01.png"));
            left3   = ImageIO.read(getClass().getResourceAsStream("/player/left_03-01.png"));
            left4   = ImageIO.read(getClass().getResourceAsStream("/player/left_04-01.png"));
            left5   = ImageIO.read(getClass().getResourceAsStream("/player/left_05-01.png"));
            left6   = ImageIO.read(getClass().getResourceAsStream("/player/left_06-01.png"));
            left7   = ImageIO.read(getClass().getResourceAsStream("/player/left_07-01.png"));
            left8   = ImageIO.read(getClass().getResourceAsStream("/player/left_08-01.png"));
            left9   = ImageIO.read(getClass().getResourceAsStream("/player/left_09-01.png"));

            right1  = ImageIO.read(getClass().getResourceAsStream("/player/right_01-01.png"));
            right2  = ImageIO.read(getClass().getResourceAsStream("/player/right_02-01.png"));
            right3  = ImageIO.read(getClass().getResourceAsStream("/player/right_03-01.png"));
            right4  = ImageIO.read(getClass().getResourceAsStream("/player/right_04-01.png"));
            right5  = ImageIO.read(getClass().getResourceAsStream("/player/right_05-01.png"));
            right6  = ImageIO.read(getClass().getResourceAsStream("/player/right_06-01.png"));
            right7  = ImageIO.read(getClass().getResourceAsStream("/player/right_07-01.png"));
            right8  = ImageIO.read(getClass().getResourceAsStream("/player/right_08-01.png"));
            right9  = ImageIO.read(getClass().getResourceAsStream("/player/right_09-01.png"));


        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    public void update()
    {
        if(keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed )
        {

            if(keyH.upPressed==true)
            {
                direction = "up";
            }

            else if(keyH.downPressed == true)
            {
                direction = "down";
            }

            else if(keyH.leftPressed == true)
            {
                direction = "left";
            }

            else if(keyH.rightPressed == true)
            {
                direction = "right";
            }

            //Chcek tile collsion
            collisionOn = false;
            gp.cChecker.checkTile(this);

            //chcek object Collision
            int objIndex = gp.cChecker.chcekObject(this,true);
            pickUpObject(objIndex);

            // If Cossiosion is False, player can move
            if(collisionOn == false)
            {
                switch(direction)
                {
                    case "up" :
                        worldY-=speed;
                        break;

                    case "down" :
                        worldY+=speed;
                        break;

                    case "left" :
                        worldX-=speed;
                        break;

                    case "right" :
                        worldX+=speed;
                        break;
                }
            }

            spriteCounter++;
            if (spriteCounter>4)
            {
                if(spriteNum ==1)
                {
                    spriteNum =2;
                }

                else if(spriteNum ==2)
                {
                    spriteNum =3;
                }

                else if(spriteNum ==3)
                {
                    spriteNum =4;
                }

                else if(spriteNum ==4)
                {
                    spriteNum =5;
                }

                else if(spriteNum ==5)
                {
                    spriteNum =6;
                }

                else if(spriteNum ==6)
                {
                    spriteNum =7;
                }

                else if(spriteNum ==7)
                {
                    spriteNum =8;
                }

                else if(spriteNum ==8)
                {
                    spriteNum =9;
                }

                else if(spriteNum ==9)
                {
                    spriteNum =1;
                }
                spriteCounter=0;
            }
        }
    }


    public void pickUpObject (int i )
    {
        if(i!=404)
        {
            String ObjectName = gp.obj[i].name;

            switch (ObjectName)
            {
                case "Key":
                    hasKey++;
                    gp.obj[i] = null;
                    System.out.println("Keys: "+hasKey);
                    break;

                case "Door":
                    if(hasKey>0)
                    {
                        gp.obj[i] =null;
                        hasKey--;
                        System.out.println("Keys: "+hasKey);
                    }
                    break;

                case "Chest":
                    if(hasKey>0)
                    {
                        gp.obj[i] =null;

                        System.out.println("You win! Game Over");


                    }
                    break;
            }
        }
    }

    public void draw(Graphics2D g2)
    {
        //g2.setColor(Color.cyan);
        //g2.fillRect(x,y,gp.tileSize, gp.tileSize);


        BufferedImage image = null;

        switch (direction)
        {
            case "up" :
                if (spriteNum==1)
                {
                    image = up1;
                }
                if (spriteNum==2)
                {
                    image = up2;
                }

                if (spriteNum==3)
                {
                    image = up3;
                }

                if (spriteNum==4)
                {
                    image = up4;
                }

                if (spriteNum==5)
                {
                    image = up5;
                }

                if (spriteNum==6)
                {
                    image = up6;
                }

                if (spriteNum==7)
                {
                    image = up7;
                }

                if (spriteNum==8)
                {
                    image = up8;
                }

                if (spriteNum==9)
                {
                    image = up9;
                }

                break;

            case "down" :
                if (spriteNum==1)
                {
                    image = down1;
                }

                if (spriteNum==2)
                {
                    image = down2;
                }

                if (spriteNum==3)
                {
                    image = down3;
                }

                if (spriteNum==4)
                {
                    image = down4;
                }

                if (spriteNum==5)
                {
                    image = down5;
                }

                if (spriteNum==6)
                {
                    image = down6;
                }

                if (spriteNum==7)
                {
                    image = down7;
                }

                if (spriteNum==8)
                {
                    image = down8;
                }

                if (spriteNum==9)
                {
                    image = down9;
                }

                break;


            case "left" :
                if (spriteNum==1)
                {
                    image = left1;
                }
                if (spriteNum==2)
                {
                    image = left2;
                }

                if (spriteNum==3)
                {
                    image = left3;
                }

                if (spriteNum==4)
                {
                    image = left4;
                }

                if (spriteNum==5)
                {
                    image = left5;
                }

                if (spriteNum==6)
                {
                    image = left6;
                }

                if (spriteNum==7)
                {
                    image = left7;
                }

                if (spriteNum==8)
                {
                    image = left8;
                }

                if (spriteNum==9)
                {
                    image = left9;
                }
                break;

            case "right" :
                if (spriteNum==1)
                {
                    image = right1;
                }
                if (spriteNum==2)
                {
                    image = right2;
                }

                if (spriteNum==3)
                {
                    image = right3;
                }

                if (spriteNum==4)
                {
                    image = right4;
                }

                if (spriteNum==5)
                {
                    image = right5;
                }

                if (spriteNum==6)
                {
                    image = right6;
                }

                if (spriteNum==7)
                {
                    image = right7;
                }

                if (spriteNum==8)
                {
                    image = right8;
                }

                if (spriteNum==9)
                {
                    image = right9;
                }
                break;
        }        g2.drawImage(image,screenX,screenY, gp.tileSize/2, gp.tileSize/2,null);
    }
}

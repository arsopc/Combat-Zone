package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager
{
    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][];

    public TileManager(GamePanel gp)
    {
        this.gp=gp;
        tile = new Tile[30];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        loadMap("/maps/map01.txt");
    }

    public void getTileImage()
    {
        try
        {
            tile[0]=new Tile();
            tile[0].image =ImageIO.read(getClass().getResourceAsStream("/tiles/100.png"));
            tile[0].collision = true;

            tile[1]=new Tile();
            tile[1].image =ImageIO.read(getClass().getResourceAsStream("/tiles/101.png"));
            tile[1].collision = true;

            tile[2]=new Tile();
            tile[2].image =ImageIO.read(getClass().getResourceAsStream("/tiles/102.png"));
            tile[2].collision = true;

            tile[3]=new Tile();
            tile[3].image =ImageIO.read(getClass().getResourceAsStream("/tiles/103.png"));
            tile[3].collision = true;

            tile[4]=new Tile();
            tile[4].image =ImageIO.read(getClass().getResourceAsStream("/tiles/104.png"));
            tile[4].collision = true;

            tile[5]=new Tile();
            tile[5].image =ImageIO.read(getClass().getResourceAsStream("/tiles/105.png"));
            tile[5].collision = true;

            tile[6]=new Tile();
            tile[6].image =ImageIO.read(getClass().getResourceAsStream("/tiles/106.png"));
            tile[6].collision = true;

            tile[7]=new Tile();
            tile[7].image =ImageIO.read(getClass().getResourceAsStream("/tiles/107.png"));
            tile[7].collision = true;

            tile[8]=new Tile();
            tile[8].image =ImageIO.read(getClass().getResourceAsStream("/tiles/108.png"));
            tile[8].collision = true;

            tile[9]=new Tile();
            tile[9].image =ImageIO.read(getClass().getResourceAsStream("/tiles/109.png"));
            tile[9].collision = true;

            tile[10]=new Tile();
            tile[10].image =ImageIO.read(getClass().getResourceAsStream("/tiles/110.png"));

            tile[11]=new Tile();
            tile[11].image =ImageIO.read(getClass().getResourceAsStream("/tiles/111.png"));

            tile[12]=new Tile();
            tile[12].image =ImageIO.read(getClass().getResourceAsStream("/tiles/112.png"));

            tile[13]=new Tile();
            tile[13].image =ImageIO.read(getClass().getResourceAsStream("/tiles/113.png"));

            tile[14]=new Tile();
            tile[14].image =ImageIO.read(getClass().getResourceAsStream("/tiles/114.png"));

            tile[15]=new Tile();
            tile[15].image =ImageIO.read(getClass().getResourceAsStream("/tiles/200.png"));
            tile[15].collision = true;

            tile[16]=new Tile();
            tile[16].image =ImageIO.read(getClass().getResourceAsStream("/tiles/201.png"));
            tile[16].collision = true;

            tile[17]=new Tile();
            tile[17].image =ImageIO.read(getClass().getResourceAsStream("/tiles/202.png"));
            tile[17].collision = true;

            tile[18]=new Tile();
            tile[18].image =ImageIO.read(getClass().getResourceAsStream("/tiles/203.png"));
            tile[18].collision = true;

            tile[19]=new Tile();
            tile[19].image =ImageIO.read(getClass().getResourceAsStream("/tiles/204.png"));
            tile[19].collision = true;

            tile[20]=new Tile();
            tile[20].image =ImageIO.read(getClass().getResourceAsStream("/tiles/205.png"));
            tile[20].collision = true;

            tile[21]=new Tile();
            tile[21].image =ImageIO.read(getClass().getResourceAsStream("/tiles/206.png"));
            tile[21].collision = true;

            tile[22]=new Tile();
            tile[22].image =ImageIO.read(getClass().getResourceAsStream("/tiles/207.png"));
            tile[22].collision = true;

            tile[23]=new Tile();
            tile[23].image =ImageIO.read(getClass().getResourceAsStream("/tiles/208.png"));
            tile[23].collision = true;

            tile[24]=new Tile();
            tile[24].image =ImageIO.read(getClass().getResourceAsStream("/tiles/209.png"));

            tile[25]=new Tile();
            tile[25].image =ImageIO.read(getClass().getResourceAsStream("/tiles/210.png"));
            tile[25].collision = true;

            tile[26]=new Tile();
            tile[26].image =ImageIO.read(getClass().getResourceAsStream("/tiles/211.png"));
            tile[26].collision = true;

            tile[27]=new Tile();
            tile[27].image =ImageIO.read(getClass().getResourceAsStream("/tiles/212.png"));
            tile[27].collision = true;

            tile[28]=new Tile();
            tile[28].image =ImageIO.read(getClass().getResourceAsStream("/tiles/213.png"));
            tile[28].collision = true;

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public void loadMap(String filePath)
    {
        try
        {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader((new InputStreamReader((is))));

            int col =0;
            int row =0;

            while(col<gp.maxWorldCol && row< gp.maxWorldRow)
            {
                String line =br.readLine();

                while(col<gp.maxWorldCol)
                {
                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col== gp.maxWorldCol)
                {
                    col = 0;
                    row++;
                }

            }
            br.close();

        }
        catch(Exception e)
        {

        }
    }

    public void draw(Graphics2D g2)
    {
        int worldCol =0;
        int worldRow =0;

        while(worldCol<gp.maxWorldCol && worldRow< gp.maxWorldRow)
        {
            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol*gp.tileSize;
            int worldY = worldRow*gp.tileSize;
            int screenX = worldX- gp.player.worldX + gp.player.screenX;
            int screenY = worldY- gp.player.worldY + gp.player.screenY;


            if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX && worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
               worldY + gp.tileSize > gp.player.worldY - gp.player.screenY && worldY - gp.tileSize < gp.player.worldY + gp.player.screenY)
            {
                g2.drawImage(tile[tileNum].image, screenX,screenY,gp.tileSize, gp.tileSize, null);
            }
            worldCol++;

            if(worldCol == gp.maxWorldCol)
            {
                worldCol=0;
                worldRow++;
            }
        }
    }
}

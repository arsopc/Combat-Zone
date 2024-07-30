package main;

import object.OBJ_Chest;
import object.OBJ_Door;
import object.OBJ_Key;

public class AssetSetter
{
    GamePanel gp ;
    public AssetSetter(GamePanel gp)
    {
        this.gp = gp;
    }

    public void setObject()
    {
        gp.obj[0] = new OBJ_Key();
        gp.obj[0].worldX = 15*gp.tileSize;
        gp.obj[0].worldY = 18*gp.tileSize;

        gp.obj[1] = new OBJ_Key();
        gp.obj[1].worldX = 2*gp.tileSize;
        gp.obj[1].worldY = 23*gp.tileSize;

        gp.obj[2] = new OBJ_Door();
        gp.obj[2].worldX = 10*gp.tileSize;
        gp.obj[2].worldY = 21*gp.tileSize;

        gp.obj[3] = new OBJ_Door();
        gp.obj[3].worldX = 14*gp.tileSize;
        gp.obj[3].worldY = 15*gp.tileSize;

        gp.obj[4] = new OBJ_Door();
        gp.obj[4].worldX = 10*gp.tileSize;
        gp.obj[4].worldY = 15*gp.tileSize;

        gp.obj[5] = new OBJ_Key();
        gp.obj[5].worldX = 10*gp.tileSize;
        gp.obj[5].worldY = 16*gp.tileSize;

        gp.obj[6] = new OBJ_Door();
        gp.obj[6].worldX = 3*gp.tileSize;
        gp.obj[6].worldY = 12*gp.tileSize;

        gp.obj[7] = new OBJ_Key();
        gp.obj[7].worldX = 10*gp.tileSize;
        gp.obj[7].worldY = 10*gp.tileSize;

        gp.obj[8] = new OBJ_Key();
        gp.obj[8].worldX = 6*gp.tileSize;
        gp.obj[8].worldY = 8*gp.tileSize;


        gp.obj[9] = new OBJ_Chest();
        gp.obj[9].worldX = 22*gp.tileSize;
        gp.obj[9].worldY = 11*gp.tileSize;

        gp.obj[10] = new OBJ_Door();
        gp.obj[10].worldX = 10*gp.tileSize;
        gp.obj[10].worldY = 4*gp.tileSize;

        gp.obj[11] = new OBJ_Door();
        gp.obj[11].worldX = 14*gp.tileSize;
        gp.obj[11].worldY = 4*gp.tileSize;

        gp.obj[12] = new OBJ_Key();
        gp.obj[12].worldX = 14*gp.tileSize;
        gp.obj[12].worldY = 4*gp.tileSize;


    }
}

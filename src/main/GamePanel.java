package main;

import javax.swing.*;
import java.awt.*;
import entity.Player;
import object.SuperObject;
import tile.TileManager;


public class GamePanel extends JPanel implements Runnable
{

    final int originalTileSize =16;
    final int scale =6;
    public final int tileSize =originalTileSize*scale;

    //Screen Setting
    public final int maxScreenCol = 8;
    public final int maxScreenRow = 6;
    public final int screenWidth = tileSize*maxScreenCol;
    public final int screenHeight = tileSize*maxScreenRow;

    // World Setting
    public final int maxWorldCol =25;
    public final int maxWorldRow =25;
    public final int worldWidth =tileSize*maxWorldCol;
    public final int worldHeight =tileSize*maxWorldRow;

    int FPS = 60;

    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;



    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public Player player = new Player(this, keyH);
    public SuperObject obj[] = new SuperObject[30];


    public GamePanel()
    {
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);

    }


    public void setupGame()
    {
        aSetter.setObject();
    }

    public void startGameThread()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run()
    {
       double drawInterval = 1000000000/FPS;
       double nextDrawTime = System.nanoTime() + drawInterval;

        while(gameThread != null)
        {
            //System.out.println("The game loop is Running");
            update();

            repaint();

            try
            {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime=remainingTime/1000000;

                if(remainingTime < 0)
                {
                    remainingTime=0;
                }

                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;
            }
            catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }
    }

    public void update()
    {
        player.update();
    }




    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Graphics g2 = (Graphics2D)g;

        tileM.draw((Graphics2D) g2);

        for (int i = 0 ; i< obj.length; i++)
        {
            if (obj[i] !=null)
            {
                obj[i].draw((Graphics2D)g2,this);
            }
        }

        player.draw((Graphics2D) g2);

        g2.dispose();
    }
}

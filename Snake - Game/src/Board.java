import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Board extends JPanel implements KeyListener, ActionListener {

    private int[] xLength = new int[750];
    private int[] yLength = new int[750];

    private int elementSize = 25;
    private int score = 0;
    private int snakeLength = 3;
    private int delay = 100;
    private int moves = 0;

    private Timer timer;

    private boolean left = false;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false;
    private boolean gameOver = false;

    private ImageIcon rightHead;
    private ImageIcon upHead;
    private ImageIcon downHead;
    private ImageIcon leftHead;
    private ImageIcon tail;
    private ImageIcon apple;

    private int xApplePosition;
    private int yApplePosition;

    private int [] appleX = {50,75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,
                            475,500,525,550,575,600,625,650,675,700,725,750,775,800,825};
    private int [] appleY = {100,125,150,175,200,225,250,275,300,325,350,375,400,425,
                                450,475,500,525,550,575,600};


    private Random random = new Random();


    public Board(){
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        locateApple();
        timer = new Timer(delay, this);
        timer.start();
    }

    public void paint(Graphics g){
            if (moves == 0){
                xLength[2] = 50;
                xLength[1] = 75;
                xLength[0] = 100;

                yLength[2] = 100;
                yLength[1] = 100;
                yLength[0] = 100;
            }

            //draw Title box
            g.setColor(Color.WHITE);
            g.drawRect(24, 10,851,55);

            g.setColor(new Color(34,155,3));
            g.fillRect(25,11,850,54);

            //draw Title
            g.setColor(Color.WHITE);
            String msg = "Snake";
            g.setFont(new Font("arial", Font.BOLD, 30));
            g.drawString(msg, 420, 50);

            //draw Board
            g.setColor(Color.WHITE);
            g.drawRect(24,74,851,577);

            g.setColor(Color.BLACK);
            g.fillRect(25,75,850,575);


            //set Images
            rightHead = new ImageIcon(getClass().getResource("resources/headRight.png"));
            rightHead.paintIcon(this, g, xLength[0], yLength[0]);

            for(int i = 0; i < snakeLength; i++){
                if(i==0 && right){
                    rightHead = new ImageIcon(getClass().getResource("resources/headRight.png"));
                    rightHead.paintIcon(this, g, xLength[i], yLength[i]);
                }
                if(i==0 && left){
                    leftHead = new ImageIcon(getClass().getResource("resources/headLeft.png"));
                    leftHead.paintIcon(this, g, xLength[i], yLength[i]);
                }
                if(i==0 && down){
                    downHead = new ImageIcon(getClass().getResource("resources/headDown.png"));
                    downHead.paintIcon(this, g, xLength[i], yLength[i]);
                }
                if(i==0 && up){
                    upHead = new ImageIcon(getClass().getResource("resources/headUp.png"));
                    upHead.paintIcon(this, g, xLength[i], yLength[i]);
                }

                if(i!=0){
                    tail = new ImageIcon(getClass().getResource("resources/tail.png"));
                    tail.paintIcon(this,g,xLength[i],yLength[i]);
                }
            }

            apple = new ImageIcon(getClass().getResource("resources/apple.png"));
            apple.paintIcon(this,g,appleX[xApplePosition],appleY[yApplePosition]);

            if(gameOver){
                gameOver(g);
            }

            g.dispose();


    }

    private void checkApple() {

        if ((xLength[0] == appleX[xApplePosition]) && (yLength[0] == appleY[yApplePosition])) {
            score++;
            snakeLength++;
            locateApple();
        }
    }
    private void locateApple() {
        xApplePosition = random.nextInt(32);
        yApplePosition = random.nextInt(21);
    }
    private void move() {

        for (int z = snakeLength; z > 0; z--) {
            xLength[z] = xLength[(z - 1)];
            yLength[z] = yLength[(z - 1)];
        }

        if (left) {
            xLength[0] -= elementSize;
        }

        if (right) {
            xLength[0] += elementSize;
        }

        if (up) {
            yLength[0] -= elementSize;
        }

        if (down) {
            yLength[0] += elementSize;
        }
    }

    private void gameOver(Graphics g){
        g.setColor(Color.WHITE);
        g.setFont(new Font("arial", Font.BOLD, 50));
        g.drawString("Game Over", 300, 300);

        g.setFont(new Font("arial", Font.BOLD, 20));
        g.drawString("Space to RESTART", 340, 340);

        g.setColor(Color.WHITE);
        g.setFont( new Font("arial", Font.PLAIN, 20));
        g.drawString("Score: " +score, 390,380);
    }

    private void checkCollision() {

        for(int b = 1; b < snakeLength; b++){
            if(xLength[b] == xLength[0] && yLength[b] == yLength[0]) {
                right = false;
                left = false;
                down = false;
                up = false;
                gameOver = true;
            }
        }

        if(right){
            if(xLength[0] >= 825) {
                gameOver = true;
            }
        }
        if(left){
            if(xLength[0] <= 50) {
                gameOver = true;
            }
        }
        if(down){
            if(yLength[0] >= 600) {
                gameOver = true;
            }
        }
        if(up){
            if(yLength[0] <= 100) {
                gameOver = true;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        if (!gameOver) {
            checkApple();
            checkCollision();
            move();
        }
        repaint();

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {
            gameOver = false;
            moves = 0;
            score = 0;
            snakeLength = 3;
            repaint();
        }

        if ((key == KeyEvent.VK_LEFT) && (!right)) {
            moves++;
            left = true;
            up = false;
            down = false;
        }

        if ((key == KeyEvent.VK_RIGHT) && (!left)) {
            moves++;
            right = true;
            up = false;
            down = false;
        }

        if ((key == KeyEvent.VK_UP) && (!down)) {
            moves++;
            up = true;
            right = false;
            left = false;
        }

        if ((key == KeyEvent.VK_DOWN) && (!up)) {
            moves++;
            down = true;
            right = false;
            left = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

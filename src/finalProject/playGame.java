package finalProject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

import javax.swing.JPanel;

public class playGame extends JPanel implements KeyListener, ActionListener{
	// the game wouldn't be started once i click run.
	private boolean play = false;
	private int score = 0;
	private int bricksCollection = 21;
	
	// to specify how fast it should be.
	private Timer timer;
	private int delay = 8;
	
	// to specify the coordinates.
	private int playerX =310;
	private int ballposX = 120;
	private int ballposY = 350;
	private int ballXdir = -1;
	private int ballYdir = -2;
	
	// create a constructor
	public playGame() {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		
		// create an object for the timer
		timer = new Timer(delay, this);
		timer.start();
	}
	
	public void paint(Graphics g) {
		// choose the backGround color.
		g.setColor(Color.black);
		//g.fillRect(ballposX, ballposY, ballYdir, ballXdir);
		g.fillRect(1, 1, 692, 592);
		
		// create the borders
		g.setColor(Color.yellow);
		g.fillRect(0, 0, 3, 592);
		g.fillRect(0, 0, 692, 3);
		g.fillRect(691, 0, 3, 592);
		
		// create the paddle
		g.setColor(Color.orange);
		g.fillRect(playerX, 550, 100, 8);
		
		// Create the ball
		
		g.setColor(Color.red);
		g.fillOval(ballposX, ballposY, 20, 20);
		g.dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// Recall the paint method and repaint the game
		timer.start();
		repaint();
	}
	
	

	@Override
	public void keyTyped(KeyEvent e) {}
	
	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) { 
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(playerX >=600) {
				playerX = 600;
			} else {
				moveRight();
			}
		}
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			if(playerX < 10) {
				playerX = 10;
			} else {
				moveLeft();
			}
		}
	}
	
	// Handle the move right and move left Methods
	public void moveRight() {
		play = true;
		playerX+= 20;
	}
	
	public void moveLeft() {
		play = true;
		playerX-= 20;
	}



}

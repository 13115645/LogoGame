
import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JProgressBar;

/**
 * 
 * @author Yasiru Dahanayake 
 * 
 */
public class Game {

	private JFrame frame;
	private JTextField getName;
	private String playerName;
	private int score = 0;
	private int count = 60;
	private Timer t;
	private JLabel showTime;
	private JButton rePlay, btnStartGame, nameSubmitButton, exitGame, finishAttempt;
	private JLabel displayEnterName, gameNameLabel, iconHint;
	private File file;
	private Scanner scanner;
	private JTextArea scoreName, scorePoint, wrongAnswers;
	private JProgressBar progressBar;
	private ArrayList<Integer> list = new ArrayList<Integer>();
	private JTextField[] answers = new JTextField[10];
	private JLabel[] pictures = new JLabel[10];
	private ImageIcon[] imgicon = new ImageIcon[30];
	private Image[] image = new Image[10];
	private int[] ranNum = new int[10];

	private int xAxis = 39;
	private int xAxis2 = 39;
	private int xInputAxis = 26;
	private int xInputAxis2 = 26;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game window = new Game();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	private Game() {
		initialize();
	}

	/**
	 * writes data to the score.txt file. if not present create the file.
	 * instead of overwriting the current fire appends to the pre-existing data
	 * 
	 */
	private void writeToTextFile(String Name, int score) {
		file = new File("score.txt");

		try {
			// maing sure the data can be appended to the text file and not just
			// over Written.
			FileWriter fw = new FileWriter(file, true);
			fw.write("\n" + Name + " " + score);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * to create a random integer between 1 to 10 this integer is then used to
	 * reference a random image later on
	 */
	public void createrandom() {

		for (int i = 1; i < 31; i++) {
			list.add(new Integer(i));

		}
		Collections.shuffle(list);
		for (int i = 0; i < 10; i++) {
			ranNum[i] = list.get(i);
		}

	}

	/**
	 * Method to read the name and score data from the score.txt file. stores
	 * the name and score of different variables to be displayed in different
	 * textfields
	 */
	public void readingTextFile() {
		try {
			scanner = new Scanner(new File("score.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (scanner.hasNext()) {
			String a = scanner.next();
			String b = scanner.next();

			scoreName.append("\n" + a);
			scorePoint.append("\n" + b);

		}
	}

	/**
	 * closes the open text file
	 */
	public void closeFile() {
		scanner.close();
	}

	/**
	 * uses the random numbers created earlier to reference a random image
	 * scored within the bin folder then displays that image to the screen
	 * 
	 */
	public void displayItems() {
		// assigns a random integer to to number
		createrandom();
		// uses random INT's that are stores within the ranNum variable's to
		// point and collect image
		for (int i = 0; i < 10; i++) {
			try {
				image[i] = ImageIO.read(getClass().getResource("/" + ranNum[i] + ".png"));
				imgicon[i] = new ImageIcon(image[i]);
				pictures[i].setIcon(imgicon[i]);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * method to set the visibility of selected labels and other components
	 */
	public void setVisibility(boolean show) {
		for (int i = 0; i < 10; i++) {
			answers[i].setVisible(show);
		}

		progressBar.setVisible(show);
		finishAttempt.setVisible(show);
	}

	/**
	 * Method to take in the ansnum (picture number) and the user input (the
	 * answer) to make sure the they match (hence making sure the answers are
	 * correct)
	 */
	public void checker(int ansnum, String input) {

		String name;

		switch (ansnum) {
		case 1:
			name = "APPLE";
			// gets the user input converts it to upper case and removes
			// surrounding whitespace
			if (input.replaceAll("\\s+", "").equalsIgnoreCase(name)) {
				score += 1;
			} else {
				wrongAnswers.append(input);
			}
			break;

		case 2:
			name = "ANDROID";
			if (input.replaceAll("\\s+", "").equalsIgnoreCase(name)) {
				score += 1;
			} else {
				wrongAnswers.append("\n" + input);
			}
			break;

		case 3:
			name = "SAFARI";
			if (input.replaceAll("\\s+", "").equalsIgnoreCase(name)) {
				score += 1;
			} else {
				wrongAnswers.append("\n" + input);
			}
			break;

		case 4:
			name = "CHROME";
			if (input.replaceAll("\\s+", "").equalsIgnoreCase(name)) {
				score += 1;
			} else {
				wrongAnswers.append("\n" + input);
			}
			break;

		case 5:
			name = "FIREFOX";
			if (input.replaceAll("\\s+", "").equalsIgnoreCase(name)) {
				score += 1;
			} else {
				wrongAnswers.append("\n" + input);
			}
			break;

		case 6:
			name = "NIKE";
			if (input.replaceAll("\\s+", "").equalsIgnoreCase(name)) {
				score += 1;
			} else {
				wrongAnswers.append("\n" + input);
			}
			break;

		case 7:
			name = "DELL";
			if (input.replaceAll("\\s+", "").equalsIgnoreCase(name)) {
				score += 1;
			} else {
				wrongAnswers.append("\n" + input);
			}
			break;

		case 8:
			name = "WINDOWS";
			if (input.replaceAll("\\s+", "").equalsIgnoreCase(name)) {
				score += 1;
			} else {
				wrongAnswers.append("\n" + input);
			}
			break;

		case 9:
			name = "XBOX";
			if (input.replaceAll("\\s+", "").equalsIgnoreCase(name)) {
				score += 1;
			} else {
				wrongAnswers.append("\n" + input);
			}
			break;

		case 10:
			name = "PLAYSTATION";
			if (input.replaceAll("\\s+", "").equalsIgnoreCase(name)) {
				score += 1;
			} else {
				wrongAnswers.append("\n" + input);
			}
			break;

		case 11:
			name = "WHATSAPP";
			if (input.replaceAll("\\s+", "").equalsIgnoreCase(name)) {
				score += 1;
			} else {
				wrongAnswers.append("\n" + input);
			}
			break;

		case 12:
			name = "FACEBOOK";
			if (input.replaceAll("\\s+", "").equalsIgnoreCase(name)) {
				score += 1;
			} else {
				wrongAnswers.append("\n" + input);
			}
			break;

		case 13:
			name = "TWITTER";
			if (input.replaceAll("\\s+", "").equalsIgnoreCase(name)) {
				score += 1;
			} else {
				wrongAnswers.append("\n" + input);
			}
			break;

		case 14:
			name = "OUTLOOK";
			if (input.replaceAll("\\s+", "").equalsIgnoreCase(name)) {
				score += 1;
			} else {
				wrongAnswers.append("\n" + input);
			}
			break;

		case 15:
			name = "SAMSUNG";
			if (input.replaceAll("\\s+", "").equalsIgnoreCase(name)) {
				score += 1;
			} else {
				wrongAnswers.append("\n" + input);
			}
			break;

		case 16:
			name = "ITUNES";
			if (input.replaceAll("\\s+", "").equalsIgnoreCase(name)) {
				score += 1;
			} else {
				wrongAnswers.append("\n" + input);
			}
			break;

		case 17:
			name = "BING";
			if (input.replaceAll("\\s+", "").equalsIgnoreCase(name)) {
				score += 1;
			} else {
				wrongAnswers.append("\n" + input);
			}
			break;

		case 18:
			name = "YOUTUBE";
			if (input.replaceAll("\\s+", "").equalsIgnoreCase(name)) {
				score += 1;
			} else {
				wrongAnswers.append("\n" + input);
			}
			break;

		case 19:
			name = "NETFLIX";
			if (input.replaceAll("\\s+", "").equalsIgnoreCase(name)) {
				score += 1;
			} else {
				wrongAnswers.append("\n" + input);
			}
			break;

		case 20:
			name = "AMAZON";
			if (input.replaceAll("\\s+", "").equalsIgnoreCase(name)) {
				score += 1;
			} else {
				wrongAnswers.append("\n" + input);
			}
			break;

		case 21:
			name = "STEAM";
			if (input.replaceAll("\\s+", "").equalsIgnoreCase(name)) {
				score += 1;
			} else {
				wrongAnswers.append("\n" + input);
			}
			break;

		case 22:
			name = "PHOTOSHOP";
			if (input.replaceAll("\\s+", "").equalsIgnoreCase(name)) {
				score += 1;
			} else {
				wrongAnswers.append("\n" + input);
			}
			break;

		case 23:
			name = "GMAIL";
			if (input.replaceAll("\\s+", "").equalsIgnoreCase(name)) {
				score += 1;
			} else {
				wrongAnswers.append("\n" + input);
			}
			break;

		case 24:
			name = "APPSTORE";
			if (input.replaceAll("\\s+", "").equalsIgnoreCase(name)) {
				score += 1;
			} else {
				wrongAnswers.append("\n" + input);
			}
			break;

		case 25:
			name = "PINTREST";
			if (input.replaceAll("\\s+", "").equalsIgnoreCase(name)) {
				score += 1;
			} else {
				wrongAnswers.append("\n" + input);
			}
			break;

		case 26:
			name = "BLUETOOTH";
			if (input.replaceAll("\\s+", "").equalsIgnoreCase(name)) {
				score += 1;
			} else {
				wrongAnswers.append("\n" + input);
			}
			break;

		case 27:
			name = "SKYDRIVE";
			if (input.replaceAll("\\s+", "").equalsIgnoreCase(name)) {
				score += 1;
			} else {
				wrongAnswers.append("\n" + input);
			}
			break;

		case 28:
			name = "DROPBOX";
			if (input.replaceAll("\\s+", "").equalsIgnoreCase(name)) {
				score += 1;
			} else {
				wrongAnswers.append("\n" + input);
			}
			break;

		case 29:
			name = "LINKEDIN";
			if (input.replaceAll("\\s+", "").equalsIgnoreCase(name)) {
				score += 1;
			} else {
				wrongAnswers.append("\n" + input);
			}
			break;

		case 30:
			name = "YAHOO";
			if (input.replaceAll("\\s+", "").equalsIgnoreCase(name)) {
				score += 1;
			} else {
				wrongAnswers.append("\n" + input);
			}
			break;

		default:
			break;
		}

	}

	/**
	 * gets the random num(iconnumber) and the user input (answer) associated
	 * with it, and use the checker function to see if the image number matches
	 * with the text.
	 * 
	 */
	public void checkUserInput() {

		for (int i = 0; i < 10; i++) {
			checker(ranNum[i], answers[i].getText());
		}

	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 700, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));

		/**
		 * Creating main Panels (screens for the game)
		 */

		// creating a j panel for Initial Menu
		final JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(253, 245, 230));
		frame.getContentPane().add(panelMenu, "name_20944790259259");
		panelMenu.setLayout(null);
		panelMenu.setVisible(true);

		// creating a j panel for Game
		final JPanel panelGame = new JPanel();
		panelGame.setBackground(new Color(245, 245, 245));
		frame.getContentPane().add(panelGame, "name_20955451149331");
		panelGame.setLayout(null);

		// creating a j panel for ScroeBoard
		final JPanel panelScoreBoard = new JPanel();
		panelScoreBoard.setBackground(new Color(245, 255, 250));
		frame.getContentPane().add(panelScoreBoard, "name_20964640985390");
		panelScoreBoard.setLayout(null);
		panelScoreBoard.setVisible(false);

		/**
		 * BUTTONS
		 */
		/**
		 * The start game button starts the count-down timer, sets the progress
		 * bar to visible and makes sure, the answers are either correct or
		 * incorrect one the timer runs out.
		 */
		btnStartGame = new JButton("Start Game");
		btnStartGame.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		btnStartGame.setBounds(23, 19, 117, 29);
		panelGame.add(btnStartGame);
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// displays he icons in a random order
				displayItems();

				// turns off the visibility of the start game button to prevent
				// errors.
				btnStartGame.setVisible(false);

				// created a timer which will count down at at a 1 second
				// interval, which its counting do the methods below
				t = new Timer(1000, new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						setVisibility(true);

						count--;
						// decrease the value of the progress bar as the as the
						// count is decreasing
						progressBar.setValue((int) (count * (1.6)));

						// display the time counter on the frame
						showTime.setText("time remaning " + count + "");

						// when the timer runs to 0 stop the time and switch to
						// scoreBoard
						if (count == 0) {
							// resets the count to 60 seconds.
							t.stop();

							// gets the random num(iconnumber) and the answer
							// associated with it, and use the checker function
							// to see if correct.
							checkUserInput();

							panelGame.setVisible(false);
							panelScoreBoard.setVisible(true);
							writeToTextFile(playerName, score);
							readingTextFile();
							closeFile();
							score = 0;
							list.clear();
						}
					}

				});
				// start the timer
				t.start();

			}
		});

		/**
		 * button takes the user name and make sure that something has been
		 * entered, if so switches the visibility of the panel to that of the
		 * game panel.
		 */
		nameSubmitButton = new JButton("Start");
		nameSubmitButton.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		nameSubmitButton.setBounds(264, 311, 117, 29);
		panelMenu.add(nameSubmitButton);
		nameSubmitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				playerName = getName.getText().replaceAll("\\s+", "");

				// if the player name is not empty set the panel to game mode if
				// not display the java message dialogue
				if (playerName.isEmpty() == false) {

					panelGame.setVisible(true);
					panelMenu.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(frame, "please enter a valid name");
				}

			}
		});

		/**
		 * play again buttons resets all the icons text fields and other
		 * components to make sure the user is able to, start a fresh game
		 */
		rePlay = new JButton("PlayAgain");
		rePlay.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		rePlay.setBounds(165, 351, 117, 29);
		panelScoreBoard.add(rePlay);
		rePlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count = 60;
				// resets the text areas
				scoreName.setText(null);
				scorePoint.setText(null);

				// displays the image icons as null
				for (int i = 0; i < 10; i++) {
					pictures[i].setIcon(null);
					answers[i].setText(null);
				}

				// clears the user name input field.
				getName.setText(null);

				// resets the random integers so a random set
				list.clear();

				wrongAnswers.setText(null);
				panelScoreBoard.setVisible(false);
				panelMenu.setVisible(true);

				// sets the visibility of the icons to false
				setVisibility(false);
				btnStartGame.setVisible(true);

			}
		});

		/**
		 * disposes the frame, hence closing the application
		 */
		exitGame = new JButton("Exit Game");
		exitGame.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		exitGame.setBounds(393, 351, 117, 29);
		panelScoreBoard.add(exitGame);
		exitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});

		/**
		 * overrides the count-down timer and takes the user input + name and
		 * displays it to the scoreboard.
		 */
		finishAttempt = new JButton("Finish Attempt");
		finishAttempt.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		finishAttempt.setVisible(false);
		finishAttempt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// takes in checks the user input
				checkUserInput();

				// switches the panel to score board
				panelGame.setVisible(false);
				panelScoreBoard.setVisible(true);

				// write name and score to text file and close the file
				writeToTextFile(playerName, score);
				readingTextFile();
				closeFile();
				list.clear();
				score = 0;
				t.stop();
			}
		});
		finishAttempt.setBounds(262, 19, 165, 29);
		panelGame.add(finishAttempt);

		/**
		 * TEXTFIELDS
		 */

		getName = new JTextField();
		getName.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		getName.setBounds(254, 262, 149, 42);
		panelMenu.add(getName);
		getName.setColumns(10);

		scoreName = new JTextArea();
		scoreName.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		scoreName.setBounds(84, 97, 139, 224);
		panelScoreBoard.add(scoreName);

		scorePoint = new JTextArea();
		scorePoint.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		scorePoint.setBounds(254, 97, 139, 224);
		panelScoreBoard.add(scorePoint);

		// creating text fields for user input (top)
		for (int i = 0; i < 5; i++) {

			answers[i] = new JTextField();
			answers[i].setBounds(xInputAxis, 154, 100, 26);
			answers[i].setVisible(false);
			answers[i].setColumns(10);
			panelGame.add(answers[i]);
			xInputAxis += 136;

		}
		// creating text fields for user input text field (bottom)
		for (int i = 5; i < 10; i++) {

			answers[i] = new JTextField();
			answers[i].setBounds(xInputAxis2, 313, 100, 26);
			answers[i].setVisible(false);
			answers[i].setColumns(10);
			panelGame.add(answers[i]);
			xInputAxis2 += 136;

		}

		/**
		 * LABELS
		 */

		// creates a label to display the timer in the panelGame
		showTime = new JLabel("Time Remaning 60");
		showTime.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		showTime.setBounds(521, 7, 158, 50);
		panelGame.add(showTime);

		// creating labels for image icons (top)
		for (int i = 0; i < 5; i++) {

			pictures[i] = new JLabel("");
			pictures[i].setBounds(xAxis, 73, 75, 69);
			panelGame.add(pictures[i]);
			xAxis += 136;
		}

		// creating labels for image icons (bottom)
		for (int i = 5; i < 10; i++) {

			pictures[i] = new JLabel("");
			pictures[i].setBounds(xAxis2, 232, 75, 69);
			panelGame.add(pictures[i]);
			xAxis2 += 136;
		}

		// label for scoreBoard
		JLabel lblScoreBoard = new JLabel("Score Board");
		lblScoreBoard.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblScoreBoard.setBounds(281, 17, 139, 30);
		panelScoreBoard.add(lblScoreBoard);

		JLabel lblPlayerName = new JLabel("Player Name");
		lblPlayerName.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblPlayerName.setBounds(104, 69, 112, 16);
		panelScoreBoard.add(lblPlayerName);

		JLabel lblPlayerScore = new JLabel("Player Score");
		lblPlayerScore.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblPlayerScore.setBounds(276, 69, 117, 16);
		panelScoreBoard.add(lblPlayerScore);

		wrongAnswers = new JTextArea();
		wrongAnswers.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		wrongAnswers.setBounds(433, 97, 139, 224);
		panelScoreBoard.add(wrongAnswers);

		JLabel lblIncorrectAnswers = new JLabel("Incorrect Answers");
		lblIncorrectAnswers.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblIncorrectAnswers.setBounds(423, 69, 149, 16);
		panelScoreBoard.add(lblIncorrectAnswers);

		// label for (menuPanel)
		displayEnterName = new JLabel("Please Enter your Name");
		displayEnterName.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		displayEnterName.setBounds(227, 234, 200, 16);
		panelMenu.add(displayEnterName);

		iconHint = new JLabel("");
		iconHint.setBounds(391, 61, 70, 70);
		Image img100 = new ImageIcon(this.getClass().getResource("hint.gif")).getImage();
		iconHint.setIcon(new ImageIcon(img100));
		panelMenu.add(iconHint);

		gameNameLabel = new JLabel("Logo Game");
		gameNameLabel.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 25));
		gameNameLabel.setForeground(Color.BLACK);
		gameNameLabel.setBounds(230, 88, 159, 29);
		panelMenu.add(gameNameLabel);

		// progress bar to display the time
		progressBar = new JProgressBar();
		progressBar.setBounds(191, 54, 318, 20);
		progressBar.setValue(100);
		progressBar.setVisible(false);
		panelGame.add(progressBar);

	}
}

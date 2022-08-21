import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
public class TicTacToe implements ActionListener{
	  /* since here we r randomly choosing X and Os turn, we'll create an instance of  random */
	static Random random=new Random();
	JFrame frame=new JFrame();
	JPanel title_panel=new JPanel();
	JPanel button_panel=new JPanel();
	static JLabel textfield=new JLabel();
	static JButton[] buttons=new JButton[9];
	static boolean player1_turn;
	
	TicTacToe (){
		//creating JFRame
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		textfield.setBackground(new Color(25,25,0));
		textfield.setForeground(new Color(25,255,0));
		textfield.setFont(new Font("Ink Free",Font.BOLD,75));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("Tic-Tac-Toe");
		textfield.setOpaque(true);
		
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0,800,100);

		button_panel.setLayout(new GridLayout(3,3));
		button_panel.setBackground(new Color(150,150,150));
		//creating buttons. will be using loops for moving around through 1-9
		for(int i=0;i<9;i++) {
			buttons[i]=new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);	
		}
		
		title_panel.add(textfield);
		frame.add(title_panel,BorderLayout.NORTH);
		frame.add(button_panel);
		firstTurn();
	 }
	@Override
	public void actionPerformed(ActionEvent e) {
		//stick within for 9 times when button is clicked
		for(int i=0;i<9;i++) {
			//if ecountered is same as buttons at specified index then
			if(e.getSource()==buttons[i]) {
				//player1's turn then 
				if(player1_turn) {
					//checking if the index is occupied
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(255,0,0));
						buttons[i].setText("X");
						player1_turn=false;
						textfield.setText("O turn");
						check();
					}
				}
				else {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(0,0,255));
						buttons[i].setText("O");
						player1_turn=true;
						textfield.setText("X turn");	
						check();
				}
			}
		}
		}
	}
//method to create whose turn will be
// this is random either X or O
	public void firstTurn() {
		//let random class pick a random integer between 0-1
		//0=player1
		//1=player2
		try {
		Thread.sleep(1000);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		if(random.nextInt(2)==0) {
			player1_turn=true;
			textfield.setText("X turn");
		}
		else {
			player1_turn=false;
			textfield.setText("O turn");
		}		
	}
	// check if any player has won the game or is in winning condition
	public void check() {
		//check X win conditions
				if(
						(buttons[0].getText()=="X") &&
						(buttons[1].getText()=="X") &&
						(buttons[2].getText()=="X")
						) {
					xWins(0,1,2);
				}
				if(
						(buttons[3].getText()=="X") &&
						(buttons[4].getText()=="X") &&
						(buttons[5].getText()=="X")
						) {
					xWins(3,4,5);
				}
				if(
						(buttons[6].getText()=="X") &&
						(buttons[7].getText()=="X") &&
						(buttons[8].getText()=="X")
						) {
					xWins(6,7,8);
				}
				if(
						(buttons[0].getText()=="X") &&
						(buttons[3].getText()=="X") &&
						(buttons[6].getText()=="X")
						) {
					xWins(0,3,6);
				}
				if(
						(buttons[1].getText()=="X") &&
						(buttons[4].getText()=="X") &&
						(buttons[7].getText()=="X")
						) {
					xWins(1,4,7);
				}
				if(
						(buttons[2].getText()=="X") &&
						(buttons[5].getText()=="X") &&
						(buttons[8].getText()=="X")
						) {
					xWins(2,5,8);
				}
				if(
						(buttons[0].getText()=="X") &&
						(buttons[4].getText()=="X") &&
						(buttons[8].getText()=="X")
						) {
					xWins(0,4,8);
				}
				if(
						(buttons[2].getText()=="X") &&
						(buttons[4].getText()=="X") &&
						(buttons[6].getText()=="X")
						) {
					xWins(2,4,6);
				}
				//check O win conditions
				if(
						(buttons[0].getText()=="O") &&
						(buttons[1].getText()=="O") &&
						(buttons[2].getText()=="O")
						) {
					oWins(0,1,2);
				}
				if(
						(buttons[3].getText()=="O") &&
						(buttons[4].getText()=="O") &&
						(buttons[5].getText()=="O")
						) {
					oWins(3,4,5);
				}
				if(
						(buttons[6].getText()=="O") &&
						(buttons[7].getText()=="O") &&
						(buttons[8].getText()=="O")
						) {
					oWins(6,7,8);
				}
				if(
						(buttons[0].getText()=="O") &&
						(buttons[3].getText()=="O") &&
						(buttons[6].getText()=="O")
						) {
					oWins(0,3,6);
				}
				if(
						(buttons[1].getText()=="O") &&
						(buttons[4].getText()=="O") &&
						(buttons[7].getText()=="O")
						) {
					oWins(1,4,7);
				}
				if(
						(buttons[2].getText()=="O") &&
						(buttons[5].getText()=="O") &&
						(buttons[8].getText()=="O")
						) {
					oWins(2,5,8);
				}
				if(
						(buttons[0].getText()=="O") &&
						(buttons[4].getText()=="O") &&
						(buttons[8].getText()=="O")
						) {
					oWins(0,4,8);
				}
				if(
						(buttons[2].getText()=="O") &&
						(buttons[4].getText()=="O") &&
						(buttons[6].getText()=="O")
						) {
					oWins(2,4,6);
				}
				else if (checkIfDraw()) {
		            JOptionPane jOptionPane = new JOptionPane();
		            JOptionPane jOptionPane1 = new JOptionPane();
		            int dialog = JOptionPane.showConfirmDialog(jOptionPane, "Game Draw", "Result", JOptionPane.DEFAULT_OPTION);

		            if (dialog == JOptionPane.OK_OPTION)
		                System.exit(0);
//		            if (dialog == JOptionPane.OK_OPTION)
//		                TicTacToe();
		        }				
				// to get it as draw 
				// then all 9 cells of array is occupied and as you have come till this line there is no winner
				// simple for loop to check aste
	}
				public boolean checkIfDraw() {
					 boolean gridsFull = true;
					 for (int i = 0; i < 9; i++) {
						 //if the box is empty then draw wont occur
				            if (buttons[i].getText().equals("")) {
				                gridsFull = false;
				            }
				        }
				        return gridsFull;
				}
				/*make this as seperate func
				 this is where you have the result 
				 now here try to give an option 
				 let it be from the CLI first
				 like Y to restart and N to end 
				 if N is given as input then do System.exit(0); done
				 Y then call the start game function*/
			public void xWins(int a,int b,int c) {
				buttons[a].setBackground(Color.GREEN);
				buttons[b].setBackground(Color.GREEN);
				buttons[c].setBackground(Color.GREEN);
				int dialog =JOptionPane.showConfirmDialog(button_panel, "new game", "Result", JOptionPane.DEFAULT_OPTION);
				for(int i=0;i<9;i++) {
					buttons[i].setEnabled(false);
				}
				textfield.setText("X wins");
				if (dialog == JOptionPane.OK_OPTION)
				{
					TicTacToe window = new TicTacToe();
					window.frame.setVisible(true);
				}
				
			}
			public void oWins(int a,int b,int c) {
				buttons[a].setBackground(Color.GREEN);
				buttons[b].setBackground(Color.GREEN);
				buttons[c].setBackground(Color.GREEN);
				int dialog =JOptionPane.showConfirmDialog(button_panel, "new game", "Result", JOptionPane.DEFAULT_OPTION);
				for(int i=0;i<9;i++) {
					buttons[i].setEnabled(false);
				}
				textfield.setText("O wins");
				if (dialog == JOptionPane.OK_OPTION)
				{
					TicTacToe window = new TicTacToe();
					window.frame.setVisible(true);
				}
				
		}
	}
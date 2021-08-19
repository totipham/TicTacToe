import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;



public class TicTacToe implements ActionListener {
    int step = 0;
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel text_field = new JLabel();
    JLabel player_turn = new JLabel();
    JButton[] buttons = new JButton[9];
    JButton resetButton = new JButton();
    JPanel resetPanel = new JPanel();
    boolean player1_turn;
    Random random = new Random();
    Color defButtonColor = new Color (33,40,69);
	Color yellowButton = new Color (248,211,32);

    TicTacToe () {

        frame.setTitle("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 500);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setVisible(true);
        frame.setResizable(false );
        frame.setLayout(new BorderLayout ());

        text_field.setText("Tic Tac Toe");
        text_field.setFont(new Font ("Segoe UI", Font.BOLD, 32));
        text_field.setBackground(defButtonColor);
		text_field.setForeground(new Color(255, 255, 255));
        text_field.setHorizontalAlignment(JLabel.CENTER);
        text_field.setOpaque(true);

        //player_turn.setText("X turn");
        player_turn.setForeground(new Color (248,211,32));
        player_turn.setBackground(new Color (33,40,69));
        player_turn.setFont(new Font ("Segoe UI", Font.BOLD, 20));
        player_turn.setHorizontalAlignment(JLabel.CENTER);
        player_turn.setOpaque(true);

        title_panel.setLayout(new GridLayout(2, 0));
		title_panel.setBounds(0,0,800,100);
        title_panel.add (text_field);
        title_panel.add (player_turn);

        frame.add (title_panel, BorderLayout.NORTH);

        button_panel.setLayout(new GridLayout(3,3));
		
		for (int i = 0; i < 9; i++) {
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("Segoe UI",Font.BOLD,60));
            buttons[i].setBackground(defButtonColor);
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}

        frame.add(button_panel, BorderLayout.CENTER);

        resetPanel.setLayout (new GridLayout (1, 1));
        resetPanel.add (resetButton);
        resetButton.setFont (new Font ("Segoe UI", Font.BOLD, 32));
        resetButton.setText ("Reset");
        resetButton.setFocusable (false);
        resetButton.setBackground (yellowButton);
        resetButton.addActionListener (this);

        frame.add (resetPanel, BorderLayout.SOUTH);

        randomTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetButton) {
            reset();
        } else {
            for (int i = 0; i < 9; i++) {
                if (e.getSource() == buttons [i]) {
                    if (player1_turn && (buttons[i].getText().equals(""))) {
                        step ++;
                        buttons[i].setForeground (Color.WHITE);
                        buttons[i].setText ("X");
                        player1_turn = false;
                        player_turn.setText ("O turn");
                        check();
                    } else if ((player1_turn == false) && (buttons[i].getText().equals(""))) {
                        step ++;
                        buttons[i].setForeground (Color.WHITE);
                        buttons[i].setText ("O");
                        player1_turn = true;
                        player_turn.setText ("X turn");
                        check();
                    } 
                }
            }
        }
        
    }

    void randomTurn () {
        if (random.nextInt(2) == 1) {
            player1_turn = true;
            player_turn.setText ("X turn");
        } else {
            player1_turn = false;
            player_turn.setText ("O turn");
        }
    }

	public void check() {
		//check X win conditions
        if (step == 9) {
            player_turn.setText ("Draw");
        }
        
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
	}
	
	public void xWins(int a,int b,int c) {
		buttons[a].setBackground(yellowButton);
		buttons[b].setBackground(yellowButton);
		buttons[c].setBackground(yellowButton);
		
		for(int i=0;i<9;i++) {
			if (buttons[i].getText().equals("")) {
                buttons[i].setEnabled(false);
            }
		}
		player_turn.setText("X win ");
	}
	public void oWins(int a,int b,int c) {
		buttons[a].setBackground(yellowButton);
		buttons[b].setBackground(yellowButton);
		buttons[c].setBackground(yellowButton);
		
		for(int i=0;i<9;i++) {
			if (buttons[i].getText().equals("")) {
                buttons[i].setEnabled(false);
            }
		}
		player_turn.setText("O win ");
	}

    void reset () {
        // System.out.println("Reset button !!");
        step = 0;
        for (int i = 0; i < 9; i++) {
            buttons[i].setText("");
            buttons[i].setBackground(defButtonColor);
            buttons[i].setEnabled(true);
        }
        randomTurn();
    }
    
}

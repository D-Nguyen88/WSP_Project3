package csc4380;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class View extends JFrame {
	
	Controller c; 

	JDialog dialog; 
	JPanel dialogPanel; 

	JTabbedPane mainPanel;
	JPanel english_panel; 
	JPanel spanish_panel; 
	
	// Main Components 
	JTextField english_leftText;
	JTextField english_rightText; 
	JTextField spanish_leftText;
	JTextField spanish_rightText; 
	JTextField chinese_leftText; 
	JTextField chinese_rightText; 
	
	// Let Components for each tabbed Panel 
	JButton english_convertBtn; 
	JButton spanish_convertBtn; 
	JButton chinese_convertBtn; 
	
	// Convert Feature Values 
	float rightVal;
	float leftVal; 
	
	
	
	public View(Controller c) {
		
		this.c = c; 
		
		initialize_dialog(); 
		initialize_main_frame(); 
					
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void initialize_dialog() {
		
		dialogPanel = new JPanel(); 
		
		dialogPanel.setLayout(new GridLayout(0, 2, 40, 10));
		dialogPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
		
		JLabel loginLabel = new JLabel("Login");
		JLabel registerLabel = new JLabel("Register"); 
		
		loginLabel.setFont(new Font("Sans-Serif", Font.PLAIN, 25)); 
		registerLabel.setFont(new Font("Sans-Serif", Font.PLAIN, 25));
		
		dialogPanel.add(loginLabel);
		dialogPanel.add(registerLabel);
		
		dialogPanel.add(new JLabel("Existing Username")); 
		dialogPanel.add(new JLabel("New Username"));
		
		dialogPanel.add(new JTextField("Login. Username"));
		dialogPanel.add(new JTextField("Register. Username"));

		dialogPanel.add(new JLabel("Existing Password"));
		dialogPanel.add(new JLabel("New Password"));
		
		dialogPanel.add(new JTextField("Existing Password")); 
		dialogPanel.add(new JTextField("New Password"));
		
		dialogPanel.add(new JLabel("")); 
		dialogPanel.add(new JLabel("Native Country"));
		dialogPanel.add(new JLabel("")); 
		dialogPanel.add(new JTextField("Native Country"));
			
		dialogPanel.add(new JButton("Login"));
		dialogPanel.add(new JButton("Register"));
		dialogPanel.add(new JLabel("")); 
		dialogPanel.add(new JLabel(""));

		dialog = new JDialog();
		dialog.add(dialogPanel);
		dialog.setSize(500, 400);
		dialog.setLocationRelativeTo(null);
	    dialog.setVisible(true);
				
	}
	
	public void initialize_main_frame() {
		mainPanel = new JTabbedPane(); 		
		english_panel = new JPanel(); 
		spanish_panel = new JPanel(); 		
		
		english_input = new JTextField("English Input Text field"); 
		spanish_input = new JTextField("Spanish Input Text field");
		
		english_convertBtn = new JButton("Convert Enlgish"); 
		spanish_convert = new JButton("Convert Spanish");
		
		// Button Converter
		english_convertBtn.addActionListener(e -> c.btnConvert(this));
		spanish_convert.addActionListener(e -> c.btnConvert(this)); 
		
		english_panel.add(new JLabel("English Label")); 
		english_panel.add(english_input); 
		english_panel.add(english_convertBtn); 
		
		spanish_panel.add(new JLabel("Spanish Label")); 
		spanish_panel.add(spanish_input); 
		spanish_panel.add(spanish_convert);
				
		ImageIcon icon = new ImageIcon("images/english.png");
		mainPanel.addTab("Tab #1", icon, english_panel, "Does nothing");
		mainPanel.addTab("Tab #2", icon, spanish_panel, "hello");
		
		english_panel.setBackground(Color.red);
		spanish_panel.setBackground(Color.pink);
		
		this.add(mainPanel);
		
		this.setSize(600, 400);
		this.setVisible(true);
		
	}
	
	
	
}

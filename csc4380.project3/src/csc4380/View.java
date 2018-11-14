package csc4380;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class View extends JFrame {
	
	Controller c; 

	JDialog dialog; 
	JPanel dialogPanel; 

	JTabbedPane mainPanel;
	JPanel english_panel; 
	JPanel spanish_panel; 
	JPanel chinese_panel; 
	
	// Main Components separated by each Tab Pane
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
	int activeTab = 0; 
	
	double active_rightVal = 9.99f;
	double active_leftVal = 18.88f;
	
	// For the Controller Model
	public String country; 
	
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
		chinese_panel = new JPanel(); 
		
		// Set Layout 
		english_panel.setLayout(new BoxLayout(english_panel, BoxLayout.Y_AXIS));
		spanish_panel.setLayout(new BoxLayout(spanish_panel, BoxLayout.X_AXIS));
		chinese_panel.setLayout(new BoxLayout(chinese_panel, BoxLayout.Y_AXIS)); 
				
		english_leftText = new JTextField("English Left Text field"); 
		english_rightText = new  JTextField("English Right Text field"); 
		
		spanish_leftText = new JTextField("Spanish Left Text field");
		spanish_rightText = new JTextField("Spanish Right Text field"); 
		
		english_convertBtn = new JButton("Convert Enlgish"); 
		spanish_convertBtn = new JButton("Convert Spanish");
		
		// Button Converter
		english_convertBtn.addActionListener(e -> c.btnConvert(this));
		spanish_convertBtn.addActionListener(e -> c.btnConvert(this)); 
		
		english_panel.add(new JLabel("Left Label")); 
		english_panel.add(english_leftText); 
		
		english_panel.add(new JLabel("Right Label"));
		english_panel.add(english_rightText);
		english_panel.add(english_convertBtn); 
		
		spanish_panel.add(new JLabel("Spanish Label")); 
		spanish_panel.add(spanish_leftText); 
		spanish_panel.add(spanish_convertBtn);
				
		ImageIcon icon = new ImageIcon("images/english.png");
		mainPanel.addTab("Tab #1", icon, english_panel, "Does nothing");
		mainPanel.addTab("Tab #2", icon, spanish_panel, "hello");
		
		english_panel.setBackground(Color.red);
		spanish_panel.setBackground(Color.pink);
		
		// Add ActionListener to Tabbed Pane 
		activeTab = 0; 
		mainPanel.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				switch(activeTab) {
				case 0:
					active_rightVal = Double.parseDouble(english_rightText.getText());
					active_leftVal = Double.parseDouble(english_leftText.getText());					
				break; 
				case 1:
					active_rightVal = Double.parseDouble(spanish_rightText.getText());
					active_leftVal = Double.parseDouble(spanish_leftText.getText());
				break; 
				case 2:
					active_rightVal = Double.parseDouble(chinese_rightText.getText());
					active_leftVal = Double.parseDouble(chinese_leftText.getText());
				break; 
				}
			}
		});
		
		this.add(mainPanel);
		
		this.setSize(600, 400);
		this.setVisible(true);
		
	}
	
	
	//  Control Methods GETTERS
	public String getLeftText() {
		return null;}
	
	public String getLeftDropDown() {
		return null;}
	
	public String getRightText() {
		return null; 
	}
	
	public String getRightDropDown() {
		return null; 
	}
	
	// Control Methods SETTERS 
	public void setRightVal(String string) {
		
		
	}

	public void setLeftVal(String string) {
		
		
	}

	public void setRightDropDown(String leftDropDown) {
		
		
	}

	public void setLeftDropDown(String temp) {
		
		
	}
	
	public void updateConver(String rightDropDown) {
		
		
	}


	
}











package csc4380;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
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
	
	// Dialog Components
	JButton loginBtn; 
	JButton signupBtn; 
	
	// Main Panel Layout 	
	JTabbedPane mainPanel;
	JPanel english_panel; 
	JPanel spanish_panel; 
	JPanel chinese_panel; 
	
	JPanel english_userPanel; 
	JPanel spanish_userPanel; 
	JPanel chinese_userPanel; 
	
	JPanel english_conversionPanel; 
	JPanel spanish_conversionPanel; 
	JPanel chinese_conversionPanel; 
	
	JPanel english_leftPanel; 
	JPanel spanish_leftPanel; 
	JPanel chinese_leftPanel;	
	
	JPanel english_btnGroup; 
	JPanel spanish_btnGroup; 
	JPanel chinese_btnGroup; 
	
	JPanel english_rightPanel; 
	JPanel spanish_rightPanel; 
	JPanel chinese_rightPanel; 
	
	// Main Components separated by each Tab Pane
	// Multi-Dimensional Componenet Array for handling Multi-Tabs
	JComponent[][] components = new JComponent[3][7]; 
	JTextField 	english_leftText,			spanish_leftText,			chinese_leftText; 
	JTextField 	english_rightText,			spanish_rightText,			chinese_rightText; 
	JComboBox 	english_leftDropdown,		spanish_leftDropdown,		chinese_leftDropdown;
	JComboBox 	english_rightDropdown,		spanish_rightDropdown,		chinese_rightDropdown; 
	JButton 	english_convertBtn,			spanish_convertBtn,			chinese_convertBtn; 
	JButton 	english_swapBtn,			spanish_swapBtn,			chinese_swapBtn; 
	JButton 	english_clearBtn,			spanish_clearBtn,			chinese_clearBtn;  
	
	// True Global Variables 
		
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
	
	// For Testing
	public View() {
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
		loginBtn = new JButton("Login"); 
		signupBtn = new JButton("Sign Up"); 
		
		
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
			
		dialogPanel.add(loginBtn);
		dialogPanel.add(signupBtn);
		dialogPanel.add(new JLabel("")); 
		dialogPanel.add(new JLabel(""));

		// Set Action Listeners for Login/Register 
		// loginBtn.addActionListener(e -> c.someControllerMethodNotYetDefined);
		// signupBtn.addActionListener(e -> c.someControllerethodNotYetDefined);
				
		
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
		
		english_userPanel = new JPanel(); 
		spanish_userPanel = new JPanel(); 
		chinese_userPanel = new JPanel(); 
		
		english_conversionPanel = new JPanel(); 
		spanish_conversionPanel = new JPanel(); 
		chinese_conversionPanel = new JPanel(); 
		
		english_leftPanel = new JPanel(); 
		spanish_leftPanel = new JPanel(); 
		chinese_leftPanel = new JPanel(); 
				
		english_btnGroup =  new JPanel(); 
		spanish_btnGroup = new JPanel(); 
		chinese_btnGroup = new JPanel(); 
		
		english_rightPanel = new JPanel(); 
		spanish_rightPanel = new JPanel(); 
		chinese_rightPanel = new JPanel(); 
		
		// Combo test String 
		String[] test_choices = {"Option 1", "Option 2", "Option 3"}; 
				
		english_leftText = new JTextField("1.0"); 
		english_rightText = new  JTextField("1.0");
		english_leftDropdown = new JComboBox(test_choices); 
		english_rightDropdown = new JComboBox(test_choices); 
		english_convertBtn = new JButton("Convert Enlgish"); 
		english_swapBtn = new JButton("Swap Button"); 
		english_clearBtn = new JButton("Clear Button"); 
		
		spanish_leftText = new JTextField("2.0");
		spanish_rightText = new JTextField("2.0");
		spanish_leftDropdown = new JComboBox(test_choices); 
		spanish_rightDropdown = new JComboBox(test_choices); 
		spanish_convertBtn = new JButton("Convert Spanish");
		spanish_swapBtn = new JButton("Swap Button"); 
		spanish_clearBtn = new JButton("Clear Button"); 
		
		chinese_leftText = new JTextField("3.0"); 
		chinese_rightText = new JTextField("3.0"); 
		chinese_leftDropdown = new JComboBox(test_choices); 
		chinese_rightDropdown = new JComboBox(test_choices); 
		chinese_convertBtn = new JButton("Convert Chinese"); 
		chinese_swapBtn = new JButton("Swap Button"); 
		chinese_clearBtn = new JButton("Clear Button"); 
		
		
		// Initialize Componenet 2D Array 
		components[0][0] = english_leftText;			components[1][0] = spanish_leftText;			components[2][0] = chinese_leftText; 
		components[0][1] = english_rightText; 			components[1][1] = spanish_rightText;			components[2][1] = chinese_rightText; 
		components[0][2] = english_leftDropdown; 		components[1][2] = spanish_leftDropdown;		components[2][2] = chinese_leftDropdown;
		components[0][3] = english_rightDropdown; 		components[1][3] = spanish_rightDropdown;		components[2][3] = chinese_rightDropdown; 
		components[0][4] = english_convertBtn; 			components[1][4] = spanish_convertBtn;			components[2][4] = chinese_convertBtn; 
		components[0][5] = english_swapBtn; 			components[1][5] = spanish_swapBtn;				components[2][5] = chinese_swapBtn; 
		components[0][6] = english_clearBtn; 			components[1][6] = spanish_clearBtn;			components[2][6] = chinese_clearBtn;
				
		// Button Converter
		english_convertBtn.addActionListener(e -> c.btnConvert(this));
		spanish_convertBtn.addActionListener(e -> c.btnConvert(this)); 
		chinese_convertBtn.addActionListener(e -> c.btnConvert(this));
		
		mainPanel.addTab("English", createImageIcon("/images/english.gif"), english_panel, "Does nothing");
		mainPanel.addTab("Spanish", createImageIcon("/images/spanish.gif"), spanish_panel, "hello");
		mainPanel.addTab("Chinese", createImageIcon("/images/chinese.gif"), chinese_panel, "chinese words");
		
		
		// Add ActionListener to Tabbed-Panel 
		mainPanel.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				switch(mainPanel.getSelectedIndex()) {
				case 0:
					System.out.println("English Tab");
					active_rightVal = Double.parseDouble(english_rightText.getText());
					active_leftVal = Double.parseDouble(english_leftText.getText());					
				break; 
				case 1:
					System.out.println("Spanish Tab");
					active_rightVal = Double.parseDouble(spanish_rightText.getText());
					active_leftVal = Double.parseDouble(spanish_leftText.getText());
				break; 
				case 2:
					System.out.println("Chinese Tab");
					active_rightVal = Double.parseDouble(chinese_rightText.getText());
					active_leftVal = Double.parseDouble(chinese_leftText.getText());
				break; 
				}
				System.out.println("Active Vals: (" + active_leftVal + " | " + active_rightVal + ")");
			}
		});
		
		
		// Add Components to each tabbed-panel
		// Add Componenets to the following panels: 
		//	-[]_mainPanel (tabbed)
		//		-[]_panel 
		//			-[]_userPanel
		// 			-[]_conversionPanel
		//				-[]_leftPanel
		//				-[]_btnGroup
		//				-[]_rightPanel
		for (int m = 0; m < components.length; m++) {
			
			JPanel leftPanel = null;
			JPanel rightPanel = null;
			JPanel btnGroup = null;

			switch(m) {
			case 0:
				System.out.println("English case");
				leftPanel = english_leftPanel; 
				rightPanel = english_rightPanel; 
				btnGroup = english_btnGroup; 
				break; 
			case 1:
				System.out.println("Spanish case");
				leftPanel = spanish_leftPanel; 
				rightPanel = spanish_rightPanel;
				btnGroup = spanish_btnGroup; 
				break; 
			case 2: 
				System.out.println("Chinese case");
				leftPanel = chinese_leftPanel;
				rightPanel = chinese_rightPanel; 
				btnGroup = chinese_btnGroup; 
			}			
			
			leftPanel.add(components[m][2]); //leftDropdown
			rightPanel.add(components[m][3]); //rightDropdown 
			leftPanel.add(components[m][0]); //leftText
			rightPanel.add(components[m][1]); //rightText				
			btnGroup.add(components[m][4]); //convertBtn 
			btnGroup.add(components[m][5]); //swapBtn 
			btnGroup.add(components[m][6]); //clearBtn  			 				
		
		}	
				
		// Set Panel Properties 
		english_leftPanel.setBackground(Color.green);
		english_btnGroup.setBackground(Color.pink);
		english_rightPanel.setBackground(Color.red);
		english_userPanel.setBackground(Color.blue);
		
		// Set Layout 
		english_leftPanel.setLayout(new BoxLayout(english_leftPanel, BoxLayout.Y_AXIS));
		english_btnGroup.setLayout(new BoxLayout(english_btnGroup, BoxLayout.Y_AXIS));
		english_rightPanel.setLayout(new BoxLayout(english_rightPanel, BoxLayout.Y_AXIS));
		spanish_leftPanel.setLayout(new BoxLayout(spanish_leftPanel, BoxLayout.Y_AXIS));
		spanish_btnGroup.setLayout(new BoxLayout(spanish_btnGroup, BoxLayout.Y_AXIS));
		spanish_rightPanel.setLayout(new BoxLayout(spanish_rightPanel, BoxLayout.Y_AXIS));
		chinese_leftPanel.setLayout(new BoxLayout(chinese_leftPanel, BoxLayout.Y_AXIS));
		chinese_btnGroup.setLayout(new BoxLayout(chinese_btnGroup, BoxLayout.Y_AXIS));
		chinese_rightPanel.setLayout(new BoxLayout(chinese_rightPanel, BoxLayout.Y_AXIS));

		english_panel.setLayout(new BoxLayout(english_panel, BoxLayout.X_AXIS));
		spanish_panel.setLayout(new BoxLayout(spanish_panel, BoxLayout.X_AXIS));
		chinese_panel.setLayout(new BoxLayout(chinese_panel, BoxLayout.X_AXIS));
				
		
		// Composite Panels 		
		english_conversionPanel.add(english_leftPanel); 
		english_conversionPanel.add(english_btnGroup); 
		english_conversionPanel.add(english_rightPanel); 
		spanish_conversionPanel.add(spanish_leftPanel);
		spanish_conversionPanel.add(spanish_btnGroup); 
		spanish_conversionPanel.add(spanish_rightPanel);
		chinese_conversionPanel.add(chinese_leftPanel);
		chinese_conversionPanel.add(chinese_btnGroup); 
		chinese_conversionPanel.add(chinese_rightPanel);
		
		english_panel.add(english_userPanel);
		english_panel.add(english_conversionPanel); 	
		spanish_panel.add(spanish_userPanel); 
		spanish_panel.add(spanish_conversionPanel); 
		chinese_panel.add(chinese_userPanel); 
		chinese_panel.add(chinese_conversionPanel); 
		
		this.add(mainPanel);
		
		this.setSize(600, 400);
		this.setVisible(true);
		
	}
	
	// Utility Functions 
	
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = View.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
	
	//  Control Methods GETTERS
	public String getSignUpUser() {
		return null; 
	}
	
	public String getSignUpPass() {
		return null; 
	}
	
	public String getLoginUser() {
		return null; 
	}
	
	public String getLoginPass() {
		return null; 
	}
	
	public String getStatus() {
		return null; 
	}
	
	public String getLeftText() {
		
		return null;
	}
	
	public String getLeftDropDown() {
		return null;
	}
	
	public String getRightText() {
		return null; 
	}
	
	public String getRightDropDown() {
		return null; 
	}
	
	// Control Methods SETTERS 
	public void setStatus(String status) {
		
	}
		
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
	
	// Authentication Methods 
	public void unlockProfile() {
		
	}
	
	public void lockProfile() {
		
	}
	
	public void loadUserInfo(String[] userInfo) {
		
	}
	
	// Other Methods 
	
	public void goHome() {
		
	}


	
}











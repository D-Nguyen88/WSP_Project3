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
        JTextField login_userTextField; 
        JTextField login_passTextField; 
        JTextField register_userTextField; 
        JTextField register_passTextField; 
        JTextField register_countryTextField; 
        
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
	JTextField 	english_leftText,		spanish_leftText,		chinese_leftText; 
	JTextField 	english_rightText,		spanish_rightText,		chinese_rightText; 
	JComboBox 	english_leftDropdown,		spanish_leftDropdown,		chinese_leftDropdown;
	JComboBox 	english_rightDropdown,		spanish_rightDropdown,		chinese_rightDropdown; 
	JButton 	english_convertBtn,		spanish_convertBtn,		chinese_convertBtn; 
	JButton 	english_swapBtn,		spanish_swapBtn,		chinese_swapBtn; 
	JButton 	english_clearBtn,		spanish_clearBtn,		chinese_clearBtn;  
	
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
		
                // Initialize TextFields 
                login_userTextField = new JTextField("user Login"); 
                login_passTextField = new JTextField("pass Login"); 
                register_userTextField = new JTextField("user register"); 
                register_passTextField = new JTextField("pass register"); 
                register_countryTextField = new JTextField("country register");                
		
		loginLabel.setFont(new Font("Sans-Serif", Font.PLAIN, 25)); 
		registerLabel.setFont(new Font("Sans-Serif", Font.PLAIN, 25));
		
		dialogPanel.add(loginLabel);
		dialogPanel.add(registerLabel);
		
		dialogPanel.add(new JLabel("Existing Username")); 
		dialogPanel.add(new JLabel("New Username"));
		
		dialogPanel.add(login_userTextField);
		dialogPanel.add(register_userTextField);

		dialogPanel.add(new JLabel("Existing Password"));
		dialogPanel.add(new JLabel("New Password"));
		
		dialogPanel.add(login_passTextField); 
		dialogPanel.add(register_passTextField);
		
		dialogPanel.add(new JLabel("")); 
		dialogPanel.add(new JLabel("Native Country"));
		dialogPanel.add(new JLabel("")); 
		dialogPanel.add(register_countryTextField);
			
		dialogPanel.add(loginBtn);
		dialogPanel.add(signupBtn);
		dialogPanel.add(new JLabel("")); 
		dialogPanel.add(new JLabel(""));

		// Set Action Listeners for Login/Register 
		loginBtn.addActionListener(e -> c.btnLogin(this));
		signupBtn.addActionListener(e -> c.btnSignup(this));
						
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
		String[] english_choices =  {"Argentine Peso", "Australian Dollar", "Bahraini Dinar", "Botswana Pula", "Brazilian Real", "British Pound", "Bruneian Dollar", "Bulgarian Lev", "Canadian Dollar", "Chilean Peso", "Chinese Yuan Renminbi", "Colombian Peso", "Croatian Kuna", "Czech Koruna", "Danish Krone", "Emirati Dirham", "Euro", "Hong Kong Dollar", "Hungarian Forint", "Icelandic Krona", "Indian Rupee", "Indonesian Rupiah", "Iranian Rial", "Israeli Shekel", "Japanese Yen", "Kazakhstani Tenge", "Kuwaiti Dinar", "Libyan Dinar", "Malaysian Ringgit", "Mauritian Rupee", "Mexican Peso", "Nepalese Rupee", "New Zealand Dollar", "Norwegian Krone", "Omani Rial", "Pakistani Rupee", "Philippine Peso", "Polish Zloty", "Qatari Riyal", "Romanian New Leu", "Russian Ruble", "Saudi Arabian Riyal", "Singapore Dollar", "South African Rand", "South Korean Won", "Sri Lankan Rupee", "Swedish Krona", "Swiss Franc", "Taiwan New Dollar", "Thai Baht", "Trinidadian Dollar", "Turkish Lira", "US Dollar", "Venezuelan Bolivar"};
                String[] spanish_choices = {"Peso argentino", "Dólar australiano", "Dinar bahreiní", "Botswana Pula", "Real brasileño", "Libra esterlina", "Dólar de Brunei", "Leva búlgara", "Dólar canadiense", "Peso chileno", "Yuan renminbi chino", "Peso colombiano", "Kuna croata", "Corona checa", "Corona danesa", "Dirham emirati", "Euro", "Dólar de Hong Kong", "Florín húngaro", "Corona islandesa" , "Rupia india", "Rupia indonesia", "Rial iraní", "Shekel israelí", "Yen japonés", "Tenge de Kazajstán", "Dinar kuwaití", "Dinar libio", "Ringgit de Malasia", "Rupia de Mauricio" , "Peso mexicano", "Rupia nepalí", "Dólar neozelandés", "Corona noruega", "Rial omaní", "Rupia pakistaní", "Peso filipino", "Zloty polaco", "Riyal qatarí", "Rumano nuevo Leu "," Rublo ruso "," Riyal de Arabia Saudita "," Dólar de Singapur "," Rand sudafricano "," Won surcoreano "," Rupia de Sri Lanka "," Corona sueca "," Franco suizo "," Taiwán NuevoDólar "," Baht tailandés "," Dólar trinitense "," Lira turca "," Dólar estadounidense "," Bolívar venezolano"}; 
                String[] chinese_choices = {"阿根廷比索","澳大利亞元","巴林第納爾","博茨瓦納普拉","巴西雷亞爾","英鎊","文萊元","保加利亞列弗","加拿大元","智利比索", "人民幣","哥倫比亞比索","克羅地亞庫納","捷克克朗","丹麥克朗","阿聯酋迪拉姆","歐元","港幣","匈牙利福林","冰島克朗" ,"印度盧比","印尼盧比","伊朗里亞爾","以色列謝克爾","日元","哈薩克斯坦堅戈","科威特第納爾","利比亞第納爾","馬來西亞林吉特","毛里求斯盧比" ,"墨西哥比索","尼泊爾盧比","新西蘭元","挪威克朗","阿曼里亞爾","巴基斯坦盧比","菲律賓比索","波蘭茲羅提","卡塔爾里亞爾","羅馬尼亞新Leu","俄羅斯盧布","沙特阿拉伯里亞爾","新加坡元","南非蘭特","韓元","斯里蘭卡盧比","瑞典克朗","瑞士法郎","台灣新美元","泰銖","特立尼達元","土耳其里拉","美元","委內瑞拉玻利瓦爾"}; 
				
		english_leftText = new JTextField("1.0"); 
		english_rightText = new  JTextField("1.0");
		english_leftDropdown = new JComboBox(english_choices); 
		english_rightDropdown = new JComboBox(english_choices); 
		english_convertBtn = new JButton("Convert Enlgish"); 
		english_swapBtn = new JButton("Swap Button"); 
		english_clearBtn = new JButton("Clear Button"); 
		
		spanish_leftText = new JTextField("2.0");
		spanish_rightText = new JTextField("2.0");
		spanish_leftDropdown = new JComboBox(spanish_choices); 
		spanish_rightDropdown = new JComboBox(spanish_choices); 
		spanish_convertBtn = new JButton("Convert Spanish");
		spanish_swapBtn = new JButton("Swap Button"); 
		spanish_clearBtn = new JButton("Clear Button"); 
		
		chinese_leftText = new JTextField("3.0"); 
		chinese_rightText = new JTextField("3.0"); 
		chinese_leftDropdown = new JComboBox(chinese_choices); 
		chinese_rightDropdown = new JComboBox(chinese_choices); 
		chinese_convertBtn = new JButton("Convert Chinese"); 
		chinese_swapBtn = new JButton("Swap Button"); 
		chinese_clearBtn = new JButton("Clear Button"); 
				
		// Initialize Componenet 2D Array 
		components[0][0] = english_leftText;			components[1][0] = spanish_leftText;			components[2][0] = chinese_leftText; 
		components[0][1] = english_rightText; 			components[1][1] = spanish_rightText;			components[2][1] = chinese_rightText; 
		components[0][2] = english_leftDropdown; 		components[1][2] = spanish_leftDropdown;		components[2][2] = chinese_leftDropdown;
		components[0][3] = english_rightDropdown; 		components[1][3] = spanish_rightDropdown;		components[2][3] = chinese_rightDropdown; 
		components[0][4] = english_convertBtn; 			components[1][4] = spanish_convertBtn;			components[2][4] = chinese_convertBtn; 
		components[0][5] = english_swapBtn; 			components[1][5] = spanish_swapBtn;			components[2][5] = chinese_swapBtn; 
		components[0][6] = english_clearBtn; 			components[1][6] = spanish_clearBtn;			components[2][6] = chinese_clearBtn;
				
		// Button Converter
		english_convertBtn.addActionListener(e -> c.btnConvert(this));
		spanish_convertBtn.addActionListener(e -> c.btnConvert(this)); 
		chinese_convertBtn.addActionListener(e -> c.btnConvert(this));
		english_clearBtn.addActionListener(e -> c.btnClear(this));
		spanish_clearBtn.addActionListener(e -> c.btnClear(this)); 
		chinese_clearBtn.addActionListener(e -> c.btnClear(this));
		
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
           return register_userTextField.getText(); 
	}
	
	public String getSignUpPass() {
           return register_passTextField.getText(); 
	}
	
	public String getLoginUser() {
            return login_userTextField.getText(); 
	}
	
	public String getLoginPass() {
            return login_passTextField.getText(); 
	}
	
	public String getStatus() {
		return null; 
	}
	
	public String getLeftText() {
            return Double.toString(active_leftVal);
	}
	
	public String getLeftDropDown() {
            return null;
	}
	
	public String getRightText() {
            return Double.toString(active_rightVal); 
	}
	
	public String getRightDropDown() {
            return null; 
	}
	
	// Control Methods SETTERS 
	public void setStatus(String status) {
		
	}
		
	public void setRightVal(String string) {
            switch (mainPanel.getSelectedIndex()) {
                case 0: 
                    english_rightText.setText(string);
                    break; 
                case 1:
                    spanish_rightText.setText(string); 
                    break; 
                case 2: 
                    chinese_rightText.setText(string); 
                    break; 
            }	
	}
	
	public void setLeftVal(String string) {
            switch (mainPanel.getSelectedIndex()) {
                case 0: 
                    english_leftText.setText(string);
                    break; 
                case 1:
                    spanish_leftText.setText(string); 
                    break; 
                case 2: 
                    chinese_leftText.setText(string); 
                    break; 
            }			
	}
	
	public void setRightDropDown(String leftDropDown) {
            switch (mainPanel.getSelectedIndex()) {
                case 0:
                    break; 
                case 1:
                    break; 
                case 2: 
                    break; 
            }          
	}

	public void setLeftDropDown(String temp) {
            switch (mainPanel.getSelectedIndex()) {
                case 0:
                    break; 
                case 1:
                    break; 
                case 2: 
                    break; 
            }	
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
        
}











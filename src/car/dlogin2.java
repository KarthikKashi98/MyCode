package car;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class dlogin2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	static String d;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dlogin2 frame = new dlogin2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public dlogin2() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 878, 587);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 31, 875, 145);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(dlogin2.class.getResource("/photo/driver logooooooo.png")));
		label.setBounds(31, 24, 364, 110);
		panel.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(dlogin2.class.getResource("/photo/CARRO 065.gif")));
		label_1.setBounds(605, 0, 254, 145);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("LOGIN PAGE");
		label_2.setFont(new Font("Comic Sans MS", Font.BOLD, 27));
		label_2.setBounds(20, 167, 274, 70);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("User name:");
		label_3.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		label_3.setBounds(137, 231, 194, 40);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Password :");
		label_4.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		label_4.setBounds(137, 294, 194, 40);
		contentPane.add(label_4);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(341, 231, 289, 41);
		contentPane.add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(341, 294, 289, 40);
		contentPane.add(passwordField);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(170, 361, 512, 8);
		contentPane.add(separator);
		
		Button button = new Button("LOGIN");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					
							Class.forName("com.mysql.jdbc.Driver");
							Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject2","root","");
							
										{
											 String s="Select `dname` from ddetails where IsBlocked ='yes' and Dname='"+textField.getText()+"';";
												
												PreparedStatement stmt=con.prepareStatement(s);
												ResultSet rs= stmt.executeQuery();
												
												if(rs.next()) {
													JOptionPane.showMessageDialog(null,"you are blocked by the admin");
													dispose();
													dlogin2.main(null);
													
												}
												else {
								
													String sql="Select * from dlogin where dname='"+textField.getText()+"'and " + "password='"+passwordField.getText()+"';";
													Statement stmt1=con.createStatement();
													ResultSet rs1= stmt1.executeQuery(sql);
													if(rs1.next()) {
														
															
																	dispose();
																	driver g=new driver();
																
																	g.main(null);
																
																		d=textField.getText();
																		
										
																	
																
																}
										
													else 
														{
															JOptionPane.showMessageDialog(null,"please insert correctly");
														}
															}
				}}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null,e);
				
				}
				}
				
		});
		button.setFont(new Font("Dialog", Font.BOLD, 17));
		button.setBounds(190, 403, 105, 40);
		contentPane.add(button);
		
		Button button_1 = new Button("SIGN UP");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				DriverSignup.main(null);
				
			}
		});
		button_1.setFont(new Font("Dialog", Font.BOLD, 17));
		button_1.setBounds(529, 403, 105, 40);
		contentPane.add(button_1);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 11, 97, 21);
		contentPane.add(menuBar);
		
		JMenu mnOptions = new JMenu("Options");
		mnOptions.setFont(new Font("Segoe UI", Font.BOLD, 18));
		menuBar.add(mnOptions);
		
		JMenuItem mntmHome = new JMenuItem("Home");
		mntmHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				login3.main(null);
			}
		});
		mnOptions.add(mntmHome);
	}
}

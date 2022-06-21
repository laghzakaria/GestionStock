import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField USERNAME;
	private JPasswordField PASSWORD;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(47, 79, 79));
		panel.setBounds(0, 0, 700, 350);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 128, 128));
		panel_1.setBounds(0, 0, 278, 350);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Identification");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Gloucester MT Extra Condensed", Font.PLAIN, 24));
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(55, 130, 148, 31);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\GestionStock\\img\\logo.png"));
		lblNewLabel_1.setBounds(75, 11, 97, 97);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\GestionStock\\img\\login.png"));
		lblNewLabel_2.setBounds(65, 172, 128, 128);
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(47, 79, 79));
		panel_2.setBounds(276, 0, 424, 350);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("LOGIN");
		lblNewLabel_2_1.setBackground(new Color(255, 99, 71));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Monospaced", Font.BOLD, 25));
		lblNewLabel_2_1.setBounds(0, 32, 424, 48);
		panel_2.add(lblNewLabel_2_1);
		
		JList list = new JList();
		list.setBounds(260, 169, -76, -35);
		panel_2.add(list);
		
		JLabel lblNewLabel_3 = new JLabel("USERNAME");
		lblNewLabel_3.setFont(new Font("Lucida Console", Font.BOLD, 17));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(43, 104, 141, 30);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("PASSWORD");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Lucida Console", Font.BOLD, 17));
		lblNewLabel_3_1.setBounds(43, 169, 141, 30);
		panel_2.add(lblNewLabel_3_1);
		
		USERNAME = new JTextField();
		USERNAME.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 17));
		USERNAME.setForeground(new Color(0, 128, 128));
		USERNAME.setBounds(194, 104, 185, 30);
		panel_2.add(USERNAME);
		USERNAME.setColumns(10);
		
		JButton valider = new JButton("Valider");
		valider.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionstock","root","");
					Statement stmt = con.createStatement();
					String sql =  "Select * from login where USERNAME = '" +USERNAME.getText()+"' and PASSWORD = '"+PASSWORD.getText().toString()+"'";
					ResultSet rs = stmt.executeQuery(sql);
					if(rs.next()) {
						Home home = new Home();
						home.setVisible(true);
						Dispose();
						con.close();
					}else {
						JOptionPane.showMessageDialog(null, "Incorrect USERNAME and PASSWORD...");
					}
					
				}catch(Exception e){
					System.out.print(e);
				}
			}
		});
		
		valider.setFont(new Font("Monospac821 BT", Font.BOLD, 18));
		valider.setForeground(new Color(255, 255, 255));
		valider.setBackground(new Color(46, 139, 87));
		valider.setBounds(146, 239, 149, 39);
		panel_2.add(valider);
		
		JLabel fermer = new JLabel("X");
		fermer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		fermer.setHorizontalAlignment(SwingConstants.CENTER);
		fermer.setForeground(new Color(255, 255, 255));
		fermer.setFont(new Font("Lucida Fax", Font.BOLD, 17));
		fermer.setBounds(368, 11, 46, 14);
		panel_2.add(fermer);
		
		PASSWORD = new JPasswordField();
		PASSWORD.setBounds(194, 165, 185, 30);
		panel_2.add(PASSWORD);
	}
	
	void Dispose() {
		this.dispose();
	}
}

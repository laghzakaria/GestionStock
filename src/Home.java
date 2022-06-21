import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(0, 0, 1000, 600);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(95, 158, 160));
		panel_1.setBounds(200, 50, 790, 540);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenue");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(24, 24, 296, 119);
		panel_1.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Se Deconnecter ");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Login().setVisible(true);
				Dispose();
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(95, 158, 160));
		btnNewButton.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		btnNewButton.setBounds(580, 66, 153, 42);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\GestionStock\\img\\logo.png"));
		lblNewLabel_2.setBounds(50, 20, 97, 97);
		panel.add(lblNewLabel_2);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Produit().setVisible(true);
				Dispose();
			}
		});
		panel_1_1.setBackground(new Color(102, 205, 170));
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(10, 199, 180, 90);
		panel.add(panel_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("Espace \r\nProduit");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 16));
		lblNewLabel_3.setBounds(0, 41, 180, 49);
		panel_1_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\Gestion_stock\\ressources\\product.png"));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(0, 0, 180, 49);
		panel_1_1.add(lblNewLabel_5);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Fournisseur().setVisible(true);
				Dispose();
			}
		});
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBackground(new Color(102, 205, 170));
		panel_1_1_1.setBounds(10, 300, 180, 90);
		panel.add(panel_1_1_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Espace Fournisseur");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 16));
		lblNewLabel_3_1.setBounds(0, 40, 180, 50);
		panel_1_1_1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\GestionStock\\img\\icons8-fournisseur-42.png"));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(0, 0, 180, 50);
		panel_1_1_1.add(lblNewLabel_6);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Facture().setVisible(true);
				Dispose();
			}
		});
		panel_1_2.setLayout(null);
		panel_1_2.setBackground(new Color(102, 205, 170));
		panel_1_2.setBounds(10, 401, 180, 90);
		panel.add(panel_1_2);
		
		JLabel lblNewLabel_3_2 = new JLabel("Editer Facture");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 16));
		lblNewLabel_3_2.setBounds(0, 41, 180, 49);
		panel_1_2.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\GestionStock\\img\\facture.png"));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(0, 0, 180, 55);
		panel_1_2.add(lblNewLabel_7);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setLayout(null);
		panel_1_3.setForeground(Color.WHITE);
		panel_1_3.setBackground(new Color(102, 205, 170));
		panel_1_3.setBounds(10, 128, 180, 60);
		panel.add(panel_1_3);
		
		JLabel lblNewLabel_3_3 = new JLabel("Home");
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3.setForeground(Color.BLACK);
		lblNewLabel_3_3.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 16));
		lblNewLabel_3_3.setBackground(new Color(46, 139, 87));
		lblNewLabel_3_3.setBounds(0, 0, 180, 60);
		panel_1_3.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_4 = new JLabel("\r\n");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\Gestion_stock\\ressources\\home.png"));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(0, 0, 60, 60);
		panel_1_3.add(lblNewLabel_4);
		
		JLabel fermer = new JLabel("X");
		fermer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		fermer.setHorizontalAlignment(SwingConstants.CENTER);
		fermer.setForeground(Color.WHITE);
		fermer.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		fermer.setBounds(944, 11, 46, 21);
		panel.add(fermer);
	}
	
	void Dispose() {
		this.dispose();
	}

}

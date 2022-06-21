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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class Facture extends JFrame {

	private JPanel contentPane;
	private JTextField NFacture;
	private JTextField NomProduit;
	private JTextField Quantite;
	private JTable table;
	double prix;
	int newQT;
	int Id;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Facture frame = new Facture();
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
	
	public void inserer() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionstock","root","");
			Statement stmt = con.createStatement();
			String sql =  "Select ID,Nom_Produit,prix,Quantite_Stock from produit";
			ResultSet rs = stmt.executeQuery(sql);
			//
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Facture() {
		setForeground(new Color(47, 79, 79));
		setBackground(new Color(47, 79, 79));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\GestionStock\\img\\logo.png"));
		lblNewLabel_2.setBounds(50, 20, 97, 97);
		contentPane.add(lblNewLabel_2);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Produit().setVisible(true);
				Dispose();
			}
		});
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(102, 205, 170));
		panel_1_1.setBounds(20, 199, 180, 90);
		contentPane.add(panel_1_1);
		
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
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBackground(new Color(102, 205, 170));
		panel_1_1_1.setBounds(20, 300, 180, 90);
		contentPane.add(panel_1_1_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Espace Fournisseur");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 16));
		lblNewLabel_3_1.setBounds(0, 40, 180, 50);
		panel_1_1_1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Fournisseur().setVisible(true);
				Dispose();
			}
		});
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\GestionStock\\img\\icons8-fournisseur-42.png"));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(0, 0, 180, 50);
		panel_1_1_1.add(lblNewLabel_6);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBackground(new Color(102, 205, 170));
		panel_1_2.setBounds(20, 401, 180, 90);
		contentPane.add(panel_1_2);
		
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
		panel_1_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Home().setVisible(true);
				Dispose();			}
		});
		panel_1_3.setLayout(null);
		panel_1_3.setForeground(Color.WHITE);
		panel_1_3.setBackground(new Color(102, 205, 170));
		panel_1_3.setBounds(20, 128, 180, 60);
		contentPane.add(panel_1_3);
		
		JLabel lblNewLabel_3_3 = new JLabel("Home");
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3.setForeground(Color.BLACK);
		lblNewLabel_3_3.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 16));
		lblNewLabel_3_3.setBackground(new Color(46, 139, 87));
		lblNewLabel_3_3.setBounds(0, 0, 180, 60);
		panel_1_3.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_4 = new JLabel("\r\n");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\GestionStock\\img\\home.png"));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(0, 0, 60, 60);
		panel_1_3.add(lblNewLabel_4);
		
		JLabel lblNewLabel_2_1 = new JLabel("Facturation");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Monospaced", Font.BOLD, 28));
		lblNewLabel_2_1.setBackground(new Color(255, 99, 71));
		lblNewLabel_2_1.setBounds(407, 11, 327, 49);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel = new JLabel("FACTURE N\u00B0");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Monospac821 BT", Font.PLAIN, 15));
		lblNewLabel.setBounds(257, 128, 104, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblNomProduit = new JLabel("Nom Produit");
		lblNomProduit.setForeground(Color.WHITE);
		lblNomProduit.setFont(new Font("Monospac821 BT", Font.PLAIN, 15));
		lblNomProduit.setBounds(257, 195, 104, 22);
		contentPane.add(lblNomProduit);
		
		JLabel lblQuantitVendue = new JLabel("Quantit\u00E9 vendue");
		lblQuantitVendue.setForeground(Color.WHITE);
		lblQuantitVendue.setFont(new Font("Monospac821 BT", Font.PLAIN, 15));
		lblQuantitVendue.setBounds(257, 267, 144, 22);
		contentPane.add(lblQuantitVendue);
		
		NFacture = new JTextField();
		NFacture.setBounds(407, 128, 129, 20);
		contentPane.add(NFacture);
		NFacture.setColumns(10);
		
		NomProduit = new JTextField();
		NomProduit.setColumns(10);
		NomProduit.setBounds(407, 198, 129, 20);
		contentPane.add(NomProduit);
		
		Quantite = new JTextField();
		Quantite.setColumns(10);
		Quantite.setBounds(407, 267, 129, 20);
		contentPane.add(Quantite);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(591, 128, 399, 162);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				int myIndex = table.getSelectedRow();
				NomProduit.setText(model.getValueAt(myIndex,1).toString());
				prix=Double.valueOf(model.getValueAt(myIndex,2).toString());
				newQT=Integer.valueOf(model.getValueAt(myIndex,3).toString())-Integer.valueOf(Quantite.getText());
				//System.out.print(newQT);
				Id = Integer.valueOf(model.getValueAt(myIndex,0).toString());
				//System.out.print(Id);
			}
		});
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"", null, null, null},
				{"", null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"ID", "Nom Produit", "Prix Unitaire", "Quantit\u00E9 Disponible"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(32);
		JTextArea facture = new JTextArea();
		facture.setBounds(591, 327, 399, 232);
		contentPane.add(facture);
		//
		
		//
		JButton Ajouter = new JButton("Ajouter");
		Ajouter.addMouseListener(new MouseAdapter() {
			int i=0;
			@Override
			public void mouseClicked(MouseEvent e) {
				if(NFacture.getText().isEmpty() || NomProduit.getText().isEmpty()|| Quantite.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Missing Information");
				}else {
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionstock","root","");
						Statement stmt = con.createStatement();
						String sql = "Update produit set Quantite_Stock='"+newQT+"' Where ID='"+Id+"'";
						stmt.executeUpdate(sql);
						inserer();
						con.close();
						i++;
						if(i==1) {
							facture.setText("\t**************FACTURE DE VENTE**************\n"+"\tNum  |  Produit  |  Prix/Unité  |  Quantité  |  Total\n\t"+i+"             "+NomProduit.getText()+"             "+prix+"          "+Quantite.getText()+"              "+prix*Integer.valueOf(Quantite.getText())+"\n\t");
						}else {
							facture.setText(facture.getText()+i+"             "+NomProduit.getText()+"             "+prix+"          "+Quantite.getText()+"              "+prix*Integer.valueOf(Quantite.getText())+"\n\t");
						}
					}catch(Exception f) {
						
					}
					
				}
			}
		});
		Ajouter.setBounds(352, 300, 89, 23);
		contentPane.add(Ajouter);
		
		JButton imprimer = new JButton("Imprimer");
		imprimer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					facture.print();
				}catch(Exception f) {
				}
			}
		});
		imprimer.setBounds(763, 570, 89, 23);
		contentPane.add(imprimer);
		
		JLabel lblListeProduitsDispnibles = new JLabel("Liste Produits Disponibles");
		lblListeProduitsDispnibles.setHorizontalAlignment(SwingConstants.CENTER);
		lblListeProduitsDispnibles.setForeground(Color.WHITE);
		lblListeProduitsDispnibles.setFont(new Font("Monospac821 BT", Font.PLAIN, 18));
		lblListeProduitsDispnibles.setBounds(624, 79, 317, 22);
		contentPane.add(lblListeProduitsDispnibles);
		
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
		fermer.setBounds(930, 11, 46, 21);
		contentPane.add(fermer);
		
		
		
		inserer();
	}
	
	private void Dispose() {
		this.dispose();
	}
}

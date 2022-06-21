import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;import com.sun.media.sound.ModelOscillator;

import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import net.proteanit.sql.*;
public class Produit extends JFrame {

	private JPanel contentPane;
	private JTextField nomProduit;
	private JTextField prix;
	private JTextField quatite;
	private JTable table;
	private JTextField ID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Produit frame = new Produit();
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
	//INSERER LES ELEMENTS DANS LE TABLEAU
		public void inserer() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionstock","root","");
				Statement stmt = con.createStatement();
				String sql =  "Select * from produit ";
				ResultSet rs = stmt.executeQuery(sql);
				//
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	public Produit() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(47, 79, 79));
		panel.setForeground(new Color(47, 79, 79));
		panel.setBounds(0, 0, 1000, 600);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel MAIN = new JPanel();
		MAIN.setBackground(new Color(0, 128, 128));
		MAIN.setForeground(new Color(46, 139, 87));
		MAIN.setBounds(200, 50, 790, 540);
		panel.add(MAIN);
		MAIN.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom Produit");
		lblNewLabel.setFont(new Font("Monospac821 BT", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(403, 59, 154, 31);
		MAIN.add(lblNewLabel);
		
		nomProduit = new JTextField();
		nomProduit.setBounds(560, 63, 220, 31);
		MAIN.add(nomProduit);
		nomProduit.setColumns(10);
		
		JLabel lblPrixUnitaire = new JLabel("Prix Unitaire");
		lblPrixUnitaire.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrixUnitaire.setForeground(Color.WHITE);
		lblPrixUnitaire.setFont(new Font("Monospac821 BT", Font.BOLD, 20));
		lblPrixUnitaire.setBackground(Color.WHITE);
		lblPrixUnitaire.setBounds(10, 110, 180, 31);
		MAIN.add(lblPrixUnitaire);
		
		prix = new JTextField();
		prix.setColumns(10);
		prix.setBounds(186, 110, 211, 31);
		MAIN.add(prix);
		
		JLabel tets = new JLabel("Quantit\u00E9");
		tets.setHorizontalAlignment(SwingConstants.LEFT);
		tets.setForeground(Color.WHITE);
		tets.setFont(new Font("Monospac821 BT", Font.BOLD, 20));
		tets.setBackground(Color.WHITE);
		tets.setBounds(413, 110, 377, 31);
		MAIN.add(tets);
		
		quatite = new JTextField();
		quatite.setColumns(10);
		quatite.setBounds(560, 114, 220, 31);
		MAIN.add(quatite);
		
		JComboBox categorie = new JComboBox();
		categorie.setFont(new Font("Kristen ITC", Font.BOLD, 17));
		categorie.setModel(new DefaultComboBoxModel(new String[] {"Telephones", "PC"}));
		categorie.setBounds(189, 163, 208, 40);
		MAIN.add(categorie);
		
		JLabel lblCategorie = new JLabel("Cat\u00E9gorie");
		lblCategorie.setHorizontalAlignment(SwingConstants.LEFT);
		lblCategorie.setForeground(Color.WHITE);
		lblCategorie.setFont(new Font("Monospac821 BT", Font.BOLD, 20));
		lblCategorie.setBackground(Color.WHITE);
		lblCategorie.setBounds(10, 162, 175, 31);
		MAIN.add(lblCategorie);
		
		JButton Ajouter = new JButton("Ajouter ");
		Ajouter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(ID.getText().isEmpty()||prix.getText().isEmpty()||quatite.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Missing Information");
				}else {
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionstock","root","");
						PreparedStatement stmt = con.prepareStatement("insert into produit values(?,?,?,?,?)");
						stmt.setString(1,ID.getText());
						stmt.setString(2,nomProduit.getText()); 
						stmt.setString(3,categorie.getSelectedItem().toString());
						stmt.setInt(4, Integer.valueOf(prix.getText()));
						stmt.setInt(5, Integer.valueOf(quatite.getText()));
						stmt.executeUpdate();
						// inserer au fur et à mesure 
						inserer();
						JOptionPane.showMessageDialog(null, "produit ajouté avec succes");
						con.close();
					}catch(Exception e) {
						
					}
				}
			}
		});
		
		//
		Ajouter.setBackground(new Color(210, 105, 30));
		Ajouter.setForeground(new Color(255, 255, 255));
		Ajouter.setFont(new Font("Monospac821 BT", Font.BOLD, 18));
		Ajouter.setBounds(35, 230, 220, 40);
		MAIN.add(Ajouter);
		
		JButton Supprimer = new JButton("Supprimer");
		Supprimer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionstock","root","");
					Statement stmt = con.createStatement();
					String Id = ID.getText();
					String sql =  "Delete from produit where ID = '" +Id+"'";
					stmt.executeUpdate(sql);
					JOptionPane.showMessageDialog(null, "Produit Supprimé");
					con.close();
					inserer();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		Supprimer.setForeground(new Color(255, 255, 255));
		Supprimer.setBackground(new Color(160, 82, 45));
		Supprimer.setFont(new Font("Monospac821 BT", Font.BOLD, 18));
		Supprimer.setBounds(285, 230, 220, 40);
		MAIN.add(Supprimer);
		
		JButton Editer = new JButton("Editer");
		Editer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(ID.getText().isEmpty()||prix.getText().isEmpty()||quatite.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Missing Information");
				}else {
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionstock","root","");
						Statement stmt = con.createStatement();
						String sql = "Update produit set Nom_Produit= '"+nomProduit.getText()+"'"+",Categorie= '"+categorie.getSelectedItem().toString()+"'"+",prix='"+prix.getText()+"'"+",Quantite_Stock= '"+quatite.getText()+"'"+"Where ID="+ID.getText();
						stmt.executeUpdate(sql);
						JOptionPane.showMessageDialog(null, "Mise à jour avec succès");
						inserer();
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
		Editer.setForeground(new Color(255, 255, 255));
		Editer.setBackground(new Color(184, 134, 11));
		Editer.setFont(new Font("Monospac821 BT", Font.BOLD, 18));
		Editer.setBounds(535, 230, 220, 40);
		MAIN.add(Editer);
		
		JLabel lblNewLabel_1 = new JLabel("Liste Produits ");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 281, 790, 31);
		MAIN.add(lblNewLabel_1);
		
		JScrollPane tableProduit = new JScrollPane();
		tableProduit.setBounds(10, 323, 770, 206);
		MAIN.add(tableProduit);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			//CHERCHER
			public void mouseClicked(MouseEvent arg0) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				int myIndex = table.getSelectedRow();
				ID.setText(model.getValueAt(myIndex,0).toString());
				nomProduit.setText(model.getValueAt(myIndex,1).toString());
				prix.setText(model.getValueAt(myIndex,3).toString());
				quatite.setText(model.getValueAt(myIndex,4).toString());
				
			}
		});
		tableProduit.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"ID", "Nom Produit", "Categorie", "Prix unitaire", "Quantite en stock"
			}
		));
		
		JLabel lblIdProduit = new JLabel("R\u00E9f\u00E9rence ");
		lblIdProduit.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdProduit.setForeground(Color.WHITE);
		lblIdProduit.setFont(new Font("Monospac821 BT", Font.BOLD, 20));
		lblIdProduit.setBackground(Color.WHITE);
		lblIdProduit.setBounds(10, 59, 183, 31);
		MAIN.add(lblIdProduit);
		
		ID = new JTextField();
		ID.setColumns(10);
		ID.setBounds(189, 59, 208, 31);
		MAIN.add(ID);
		
		JLabel fermer = new JLabel("X");
		fermer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		fermer.setForeground(new Color(255, 255, 255));
		fermer.setHorizontalAlignment(SwingConstants.CENTER);
		fermer.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		fermer.setBounds(930, 11, 46, 21);
		panel.add(fermer);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\GestionStock\\img\\logo.png"));
		lblNewLabel_2.setBounds(50, 20, 97, 97);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Espace Produits");
		lblNewLabel_2_1.setBounds(437, 0, 327, 49);
		panel.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Monospaced", Font.BOLD, 28));
		lblNewLabel_2_1.setBackground(new Color(255, 99, 71));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 205, 170));
		panel_1.setBounds(10, 203, 180, 90);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Espace \r\nProduit");
		lblNewLabel_3.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 16));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(0, 41, 180, 49);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\Gestion_stock\\ressources\\product.png"));
		lblNewLabel_5.setBounds(0, 0, 180, 49);
		panel_1.add(lblNewLabel_5);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Fournisseur().setVisible(true);
				Dispose();
			}
		});
		panel_1_1.setBackground(new Color(102, 205, 170));
		panel_1_1.setBounds(10, 304, 180, 90);
		panel.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JLabel lblNewLabel_3_1 = new JLabel("Espace Fournisseur");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 16));
		lblNewLabel_3_1.setBounds(0, 40, 180, 50);
		panel_1_1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\Gestion_stock\\ressources\\icons8-fournisseur-42.png"));
		lblNewLabel_6.setBounds(0, 0, 180, 50);
		panel_1_1.add(lblNewLabel_6);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Facture().setVisible(true);
				Dispose();
			}
		});
		panel_1_2.setBackground(new Color(102, 205, 170));
		panel_1_2.setBounds(10, 405, 180, 90);
		panel.add(panel_1_2);
		panel_1_2.setLayout(null);
		
		JLabel lblNewLabel_3_2 = new JLabel("Editer Facture");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 16));
		lblNewLabel_3_2.setBounds(0, 41, 180, 49);
		panel_1_2.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\GestionStock\\img\\facture.png"));
		lblNewLabel_7.setBounds(0, 0, 180, 55);
		panel_1_2.add(lblNewLabel_7);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Home().setVisible(true);
				Dispose();
			}
		});
		panel_1_3.setForeground(new Color(255, 255, 255));
		panel_1_3.setBackground(new Color(102, 205, 170));
		panel_1_3.setLayout(null);
		panel_1_3.setBounds(10, 132, 180, 60);
		panel.add(panel_1_3);
		
		JLabel lblNewLabel_3_3 = new JLabel("Home");
		lblNewLabel_3_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3_3.setBackground(new Color(46, 139, 87));
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 16));
		lblNewLabel_3_3.setBounds(0, 0, 180, 60);
		panel_1_3.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_4 = new JLabel("\r\n");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\GestionStock\\img\\home.png"));
		lblNewLabel_4.setBounds(0, 0, 60, 60);
		panel_1_3.add(lblNewLabel_4);
		// Lister le stock
		inserer();
	}
	
	private void Dispose(){
		// TODO Auto-generated method stub
		this.dispose();
	}
}

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.sql.*;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Fournisseur extends JFrame {

	private JPanel contentPane;
	private JTextField FN;
	private JTextField Desi;
	private JTextField comm;
	private JTextField livr;
	private JTextField obsr;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fournisseur frame = new Fournisseur();
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
			String sql =  "Select * from fournisseur ";
			ResultSet rs = stmt.executeQuery(sql);
			//
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Fournisseur() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(47, 79, 79));
		panel.setBounds(0, 0, 1000, 600);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 128, 128));
		panel_1.setForeground(new Color(0, 128, 128));
		panel_1.setBounds(200, 50, 790, 540);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNomFournisseur = new JLabel("Nom Fournisseur");
		lblNomFournisseur.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomFournisseur.setForeground(Color.WHITE);
		lblNomFournisseur.setFont(new Font("Monospac821 BT", Font.BOLD, 20));
		lblNomFournisseur.setBackground(Color.WHITE);
		lblNomFournisseur.setBounds(10, 28, 183, 31);
		panel_1.add(lblNomFournisseur);
		
		FN = new JTextField();
		FN.setColumns(10);
		FN.setBounds(201, 28, 208, 31);
		panel_1.add(FN);
		
		JLabel lblDsignation = new JLabel("D\u00E9signation");
		lblDsignation.setHorizontalAlignment(SwingConstants.LEFT);
		lblDsignation.setForeground(Color.WHITE);
		lblDsignation.setFont(new Font("Monospac821 BT", Font.BOLD, 20));
		lblDsignation.setBackground(Color.WHITE);
		lblDsignation.setBounds(419, 28, 183, 31);
		panel_1.add(lblDsignation);
		
		Desi = new JTextField();
		Desi.setColumns(10);
		Desi.setBounds(558, 28, 222, 31);
		panel_1.add(Desi);
		
		JLabel lblQuantitsCommandes = new JLabel("Quantit\u00E9s Command\u00E9es");
		lblQuantitsCommandes.setHorizontalAlignment(SwingConstants.LEFT);
		lblQuantitsCommandes.setForeground(Color.WHITE);
		lblQuantitsCommandes.setFont(new Font("Monospac821 BT", Font.BOLD, 20));
		lblQuantitsCommandes.setBackground(Color.WHITE);
		lblQuantitsCommandes.setBounds(20, 77, 263, 31);
		panel_1.add(lblQuantitsCommandes);
		
		comm = new JTextField();
		comm.setColumns(10);
		comm.setBounds(315, 77, 304, 31);
		panel_1.add(comm);
		
		JLabel lblQuantitsLivres = new JLabel("Quantit\u00E9s Livr\u00E9es");
		lblQuantitsLivres.setHorizontalAlignment(SwingConstants.LEFT);
		lblQuantitsLivres.setForeground(Color.WHITE);
		lblQuantitsLivres.setFont(new Font("Monospac821 BT", Font.BOLD, 20));
		lblQuantitsLivres.setBackground(Color.WHITE);
		lblQuantitsLivres.setBounds(20, 121, 263, 31);
		panel_1.add(lblQuantitsLivres);
		
		livr = new JTextField();
		livr.setColumns(10);
		livr.setBounds(315, 119, 304, 31);
		panel_1.add(livr);
		
		JLabel lblObservations = new JLabel("Observations");
		lblObservations.setHorizontalAlignment(SwingConstants.LEFT);
		lblObservations.setForeground(Color.WHITE);
		lblObservations.setFont(new Font("Monospac821 BT", Font.BOLD, 20));
		lblObservations.setBackground(Color.WHITE);
		lblObservations.setBounds(20, 170, 263, 31);
		panel_1.add(lblObservations);
		
		obsr = new JTextField();
		obsr.setColumns(10);
		obsr.setBounds(219, 163, 530, 52);
		panel_1.add(obsr);
		
		JButton Valider = new JButton("Valider");
		Valider.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(FN.getText().isEmpty() || Desi.getText().isEmpty() || comm.getText().isEmpty() || livr.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Missing Information");
				}else
				{
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionstock","root","");
						PreparedStatement stmt = con.prepareStatement("insert into fournisseur values(?,?,?,?,?)");
						stmt.setString(1,FN.getText());
						stmt.setString(5,Desi.getText()); 
						stmt.setInt(2,Integer.valueOf(comm.getText()));
						stmt.setInt(3,Integer.valueOf(livr.getText()));
						stmt.setString(4,"aucune note");
						stmt.executeUpdate();
						inserer();
						JOptionPane.showMessageDialog(null, "Bien Enregistré");
						con.close();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		Valider.setForeground(new Color(255, 255, 255));
		Valider.setBackground(new Color(184, 134, 11));
		Valider.setFont(new Font("Monospaced", Font.BOLD, 17));
		Valider.setBounds(91, 240, 150, 40);
		panel_1.add(Valider);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Liste Fournisseurs");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1.setFont(new Font("Monospaced", Font.BOLD, 24));
		lblNewLabel_2_1_1.setBackground(new Color(255, 99, 71));
		lblNewLabel_2_1_1.setBounds(256, 291, 330, 38);
		panel_1.add(lblNewLabel_2_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 329, 770, 200);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			//CHERCHER
			public void mouseClicked(MouseEvent arg0) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				int myIndex = table.getSelectedRow();
				FN.setText(model.getValueAt(myIndex,0).toString());
				comm.setText(model.getValueAt(myIndex,1).toString());
				livr.setText(model.getValueAt(myIndex,2).toString());
				Desi.setText(model.getValueAt(myIndex,4).toString());
				obsr.setText(model.getValueAt(myIndex,3).toString());
				
				
			}
		});
		scrollPane.setViewportView(table);
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
			},
			new String[] {
				"Nom fournisseur", "Quantites Commandees", "Quantites Livrees", "Observations", "ID"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(113);
		table.getColumnModel().getColumn(1).setPreferredWidth(127);
		table.getColumnModel().getColumn(2).setPreferredWidth(102);
		table.getColumnModel().getColumn(3).setPreferredWidth(165);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		
		JButton btnEditer = new JButton("Editer");
		btnEditer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(FN.getText().isEmpty()||comm.getText().isEmpty()||livr.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Missing Information");
				}else {
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionstock","root","");
						Statement stmt = con.createStatement();
						String sql = "Update fournisseur set Nom_Fournisseur= '"+FN.getText()+"'"+",Quantite_Commande= '"+comm.getText()+"'"+",Quantite_livre='"+livr.getText()+"'"+",Observation= '"+obsr.getText()+"'"+"Where ID_Fournisseur="+Desi.getText();
						stmt.executeUpdate(sql);
						inserer();
						JOptionPane.showMessageDialog(null, "Mise à jour avec succès");
						inserer();
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
		btnEditer.setForeground(Color.WHITE);
		btnEditer.setFont(new Font("Monospaced", Font.BOLD, 17));
		btnEditer.setBackground(new Color(244, 164, 96));
		btnEditer.setBounds(329, 240, 150, 40);
		panel_1.add(btnEditer);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionstock","root","");
					Statement stmt = con.createStatement();
					String Id = Desi.getText();
					String sql =  "Delete from fournisseur where ID_Fournisseur = '" +Id+"'";
					stmt.executeUpdate(sql);
					inserer();
					JOptionPane.showMessageDialog(null, "Produit Supprimé");
					con.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnSupprimer.setForeground(Color.WHITE);
		btnSupprimer.setFont(new Font("Monospaced", Font.BOLD, 17));
		btnSupprimer.setBackground(new Color(189, 183, 107));
		btnSupprimer.setBounds(558, 240, 150, 40);
		panel_1.add(btnSupprimer);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\GestionStock\\img\\logo.png"));
		lblNewLabel.setBounds(50, 20, 97, 97);
		panel.add(lblNewLabel);
		
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
		panel.add(fermer);
		
		JLabel lblNewLabel_2_1 = new JLabel("Espace Fournisseurs");
		lblNewLabel_2_1.setBounds(384, 1, 388, 38);
		panel.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Monospaced", Font.BOLD, 28));
		lblNewLabel_2_1.setBackground(new Color(255, 99, 71));
		
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
		panel_1_1.setBounds(10, 199, 180, 90);
		panel.add(panel_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("Espace \r\nProduit");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Produit().setVisible(true);
				Dispose();
			}			
		});
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
		panel_1_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Home().setVisible(true);
				Dispose();
			}
		});
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
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\GestionStock\\img\\home.png"));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(0, 0, 60, 60);
		panel_1_3.add(lblNewLabel_4);
		inserer();
	}
	private void Dispose(){
		// TODO Auto-generated method stub
		this.dispose();
	}
}

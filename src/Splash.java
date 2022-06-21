import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Splash extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JProgressBar progressBar;
	private JLabel pourcentage;

	

	/**
	 * Create the frame.
	 */
	public Splash() {
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(47, 79, 79));
		panel.setBounds(0, 0, 500, 300);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\GestionStock\\img\\logo.png"));
		lblNewLabel.setBounds(58, 89, 97, 97);
		panel.add(lblNewLabel);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(181, 131, 293, 14);
		panel.add(progressBar);
		
		pourcentage = new JLabel("%");
		pourcentage.setForeground(new Color(255, 255, 255));
		pourcentage.setFont(new Font("Rockwell Condensed", Font.BOLD, 18));
		pourcentage.setHorizontalAlignment(SwingConstants.CENTER);
		pourcentage.setBounds(301, 106, 46, 14);
		panel.add(pourcentage);
		
		JLabel lblNewLabel_2 = new JLabel("My-Store");
		lblNewLabel_2.setFont(new Font("Monospaced", Font.BOLD, 25));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(45, 42, 128, 36);
		panel.add(lblNewLabel_2);
	}
	
	
	public static void main(String[] args) {
		Splash mySplash = new Splash();
		mySplash.setVisible(true);
		try {
			for(int i=0;i<=100;i++) {
				Thread.sleep(40);
				mySplash.progressBar.setValue(i);
				mySplash.pourcentage.setText(Integer.toString(i)+"%");
			}
		}catch (Exception e) {
			
		}
		new Login().setVisible(true);
		mySplash.dispose();
	}
}

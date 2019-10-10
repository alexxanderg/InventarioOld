package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import clases.Usuarios;
import model.Model;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Login extends JFrame implements ActionListener, KeyListener {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JButton btnIngresar;
	private JPasswordField txtPass;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					//UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeela");
					//UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
					//UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
					//UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
					
					//UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
					//UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
					
					//UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
					//UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");				
					//UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
					//UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
					//UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
					//UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
					
					//UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
					
					Login frame = new Login();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Login() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				windowClosingThis(arg0);
			}
		});		
		setTitle("Login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 403);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnIngresar = new JButton("INGRESAR");
		btnIngresar.setForeground(Color.WHITE);
		btnIngresar.setBackground(Color.DARK_GRAY);
		btnIngresar.addActionListener(this);
		btnIngresar.setFont(new Font("EngraversGothic BT", Font.BOLD, 30));
		btnIngresar.setBounds(118, 314, 378, 49);
		contentPane.add(btnIngresar);
		
		txtUsuario = new JTextField();
		txtUsuario.setForeground(Color.BLACK);
		txtUsuario.addKeyListener(this);
		txtUsuario.setBackground(SystemColor.menu);
		txtUsuario.setFont(new Font("Berlin Sans FB Demi", Font.BOLD | Font.ITALIC, 22));
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(118, 178, 378, 41);
		contentPane.add(txtUsuario);
		
		txtPass = new JPasswordField();
		txtPass.setForeground(Color.BLACK);
		txtPass.addKeyListener(this);
		txtPass.setBackground(SystemColor.menu);
		txtPass.setFont(new Font("USAngel", Font.ITALIC, 18));
		txtPass.setBounds(118, 247, 378, 41);
		contentPane.add(txtPass);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		Image img = new ImageIcon(this.getClass().getResource("/imgbanner.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(0, 0, 597, 160);
		contentPane.add(lblNewLabel);
		
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		Image img2 = new ImageIcon(this.getClass().getResource("/imgbtnuser.jpg")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img2));
		lblNewLabel_1.setBounds(67, 178, 41, 41);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		Image img3 = new ImageIcon(this.getClass().getResource("/imgbtnpass.jpg")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img3));
		lblNewLabel_2.setBounds(67, 247, 41, 41);
		contentPane.add(lblNewLabel_2);
		cargar();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(e);
		}
	}
	
	public void cargar(){
		this.setLocationRelativeTo(null);
	}
	
	public void actionPerformedBtnIngresar(ActionEvent e) {
		String usuIngre = txtUsuario.getText();
		String passIngre = String.valueOf(txtPass.getPassword());
		Model modelo = new Model();
		Usuarios ingresante = new Usuarios();
		ingresante.setUsuario(usuIngre);
		ingresante.setPassword(passIngre);
		Usuarios usu = modelo.obtenerUsuario(ingresante);
		String nombreUsuario = null;
		if(usu!=null){
			nombreUsuario = usu.getNombre();
			JOptionPane.showMessageDialog(contentPane, "Bienvenido: " + nombreUsuario);
			if(usu.getTipo() == 0){
				Eleccion el = new Eleccion(nombreUsuario );
				el.setLocationRelativeTo(null);
				el.setVisible(true);
				txtUsuario.requestFocus();
				txtUsuario.setText(null);
				txtPass.setText(null);
				this.setVisible(false);
			}
			else{
				Ventas v = new Ventas(1, null, nombreUsuario);
				v.setVisible(true);
				txtUsuario.setText(null);
				txtPass.setText(null);
				dispose();
			}
		}
		else
			JOptionPane.showMessageDialog(contentPane, "Usuario no econtrado o datos incorrectos");
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtUsuario) {
			keyTypedTxtUsuario(e);
		}
		if (e.getSource() == txtPass) {
			keyTypedTxtPass(e);
		}
	}
	protected void keyTypedTxtUsuario(KeyEvent e) {
		char c = e.getKeyChar();
		if (c == (char)KeyEvent.VK_ENTER){
			actionPerformedBtnIngresar(null);
		}
	}
	protected void keyTypedTxtPass(KeyEvent e) {
		char c = e.getKeyChar();
		if (c == (char)KeyEvent.VK_ENTER){
			actionPerformedBtnIngresar(null);
		}
	}
	protected void windowClosingThis(WindowEvent arg0) {
		try {
			DateFormat df = new SimpleDateFormat("dd.MM.yyyy  HH.mm.ss");
			Date today = Calendar.getInstance().getTime();       
			String reportDate = df.format(today);
			File directorio=new File("D:\\�INFORMACION_DEL_SISTEMA\\BACKUP_SISTEMA"); 
			directorio.mkdirs(); 
			Process p;
			p = Runtime.getRuntime().exec("mysqldump -u root -pAa123 db_inventario");
			InputStream is = p.getInputStream();
			FileOutputStream fos = new FileOutputStream("D:\\�INFORMACION_DEL_SISTEMA\\BACKUP_SISTEMA\\backup_inventario  "+reportDate+".sql");
			byte[] buffer = new byte[1000];
			int leido = is.read(buffer);
			while(leido>0){
				fos.write(buffer, 0, leido);
				leido = is.read(buffer);
			}
			//JOptionPane.showMessageDialog(null, "Copia de segudidad creada en: \n D:/ INFORMACION DEL SISTEMA / BACKUP_SISTEMA / ");
			//JOptionPane.showMessageDialog(null, "Copia de segudidad realizada correctamente");
			fos.close();
		} catch (IOException e1) {
			//JOptionPane.showMessageDialog(null, e1);
		}
	}
}

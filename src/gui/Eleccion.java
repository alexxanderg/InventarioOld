package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.WindowEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Eleccion extends JFrame implements ActionListener, WindowListener {

	private JPanel contentPane;
	private JButton btnVentas;
	private JTextField txtqueDeseaHacer;
	private JButton btnVolver;
	private JButton btnAlmacen;
	private JButton btnUsuarios;
	private JButton btnReportes;
	
	String usuario;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Eleccion frame = new Eleccion(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Eleccion(String temp2) {
		usuario = temp2;
		
		setResizable(false);
		addWindowListener(this);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 707, 571);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(this);
		btnVolver.setForeground(new Color(0, 255, 0));
		btnVolver.setFont(new Font("EngraversGothic BT", Font.BOLD | Font.ITALIC, 15));
		btnVolver.setBackground(Color.DARK_GRAY);
		btnVolver.setBounds(0, 0, 121, 53);
		contentPane.add(btnVolver);
		
		txtqueDeseaHacer = new JTextField();
		txtqueDeseaHacer.setForeground(Color.WHITE);
		txtqueDeseaHacer.setFocusTraversalKeysEnabled(false);
		txtqueDeseaHacer.setFocusable(false);
		txtqueDeseaHacer.setIgnoreRepaint(true);
		txtqueDeseaHacer.setRequestFocusEnabled(false);
		txtqueDeseaHacer.setEditable(false);
		txtqueDeseaHacer.setText("Elija una ventana...");
		txtqueDeseaHacer.setBackground(Color.DARK_GRAY);
		txtqueDeseaHacer.setFont(new Font("Perpetua", Font.ITALIC, 25));
		txtqueDeseaHacer.setHorizontalAlignment(SwingConstants.RIGHT);
		txtqueDeseaHacer.setBounds(0, 0, 700, 53);
		contentPane.add(txtqueDeseaHacer);
		txtqueDeseaHacer.setColumns(10);
		
		btnAlmacen = new JButton(new ImageIcon(this.getClass().getResource("/imgalmacen.png")));
		btnAlmacen.setForeground(Color.WHITE);
		btnAlmacen.setBackground(Color.DARK_GRAY);
		btnAlmacen.setFont(new Font("EngraversGothic BT", Font.BOLD, 20));
		btnAlmacen.setText("ALMAC�N");
		btnAlmacen.addActionListener(this);
		btnAlmacen.setBounds(0, 74, 350, 200);
		contentPane.add(btnAlmacen);
		
		btnUsuarios = new JButton(new ImageIcon(this.getClass().getResource("/imgusuarios.png")));
		btnUsuarios.setForeground(Color.WHITE);
		btnUsuarios.setBackground(Color.DARK_GRAY);
		btnUsuarios.setFont(new Font("EngraversGothic BT", Font.BOLD, 20));
		btnUsuarios.setText("USUARIOS");
		btnUsuarios.addActionListener(this);
		btnUsuarios.setBounds(352, 74, 350, 200);
		contentPane.add(btnUsuarios);
		
		btnReportes = new JButton(new ImageIcon(this.getClass().getResource("/imgreportes.png")));		
		btnReportes.setForeground(Color.WHITE);
		btnReportes.setBackground(Color.DARK_GRAY);
		btnReportes.setFont(new Font("EngraversGothic BT", Font.BOLD, 20));
		btnReportes.setText("REPORTES");
		btnReportes.addActionListener(this);
		btnReportes.setBounds(0, 277, 350, 267);
		contentPane.add(btnReportes);
		
		btnVentas = new JButton(new ImageIcon(this.getClass().getResource("/imgvender.png")));
		btnVentas.setForeground(Color.WHITE);
		btnVentas.setBackground(Color.DARK_GRAY);
		btnVentas.setFont(new Font("EngraversGothic BT", Font.BOLD, 20));
		btnVentas.setText("VENDER");
		btnVentas.addActionListener(this);
		btnVentas.setBounds(352, 276, 350, 267);
		contentPane.add(btnVentas);
		
		cargar();
	}
	
	private void cargar(){
		this.setLocationRelativeTo(null);
	}
	
	public void windowActivated(WindowEvent e) {
	}
	public void windowClosed(WindowEvent e) {
	}
	public void windowClosing(WindowEvent e) {
		if (e.getSource() == this) {
			windowClosingThis(e);
		}
	}
	public void windowDeactivated(WindowEvent e) {
	}
	public void windowDeiconified(WindowEvent e) {
	}
	public void windowIconified(WindowEvent e) {
	}
	public void windowOpened(WindowEvent e) {
	}
	protected void windowClosingThis(WindowEvent e) {
		int opc = JOptionPane.showConfirmDialog(null, "�Cerrar Sistema?", "Confirmaci�n", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (opc == 0){
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
			System.exit(0);
		}
		else
			this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnVolver) {
			actionPerformedBtnVolver(e);
		}
		if (e.getSource() == btnVentas) {
			actionPerformedBtnVentas(e);
		}
		if (e.getSource() == btnAlmacen) {
			actionPerformedBtnAlmacen(e);
		}
		if (e.getSource() == btnUsuarios) {
			actionPerformedBtnUsuarios(e);
		}
		if (e.getSource() == btnReportes) {
			actionPerformedBtnReportes(e);
		}
	}
	
	protected void actionPerformedBtnVolver(ActionEvent e) {
		int opc = JOptionPane.showConfirmDialog(null, "�Cerrar sesi�n?", "Confirmaci�n", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (opc == 0){
			Login log = new Login();
			log.setVisible(true);
			this.dispose();
		}
		else
			this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	}
	
	
	
	protected void actionPerformedBtnAlmacen(ActionEvent e) {
		MantenimientoProductos mp = new MantenimientoProductos(usuario);
		mp.setVisible(true);
		dispose();
	}
	
	protected void actionPerformedBtnUsuarios(ActionEvent e) {
		MantenimientoUsuarios mu = new MantenimientoUsuarios( usuario);
		mu.setVisible(true);
		dispose();
	}
	
	
	protected void actionPerformedBtnReportes(ActionEvent e) {
		Reportes r = new Reportes(usuario, null);
		r.setVisible(true);
		dispose();
	}
	
	protected void actionPerformedBtnVentas(ActionEvent e) {
		Ventas v = new Ventas(1, this, usuario);
		v.setLocationRelativeTo(null);
		v.setVisible(true);
		this.setVisible(false);
	}
}

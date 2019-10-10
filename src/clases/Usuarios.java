package clases;

import java.sql.ResultSet;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import model.Model;

public class Usuarios {
	String usuario;
	String password;
	String nombre;
	int tipo;
	ResultSet rs;

	public Usuarios(){}
	public Usuarios(String id, String password, String nombre, int tipo){
		this.usuario = id;
		this.password = password;
		this.nombre = nombre;
		this.tipo = tipo;
	}
	
	public void cargarUsuarios(JComboBox<Usuarios> cbUsuarios){
		Model consult = new Model();
		rs = consult.cargarUsuarios();
		try {
			while(rs.next())
				cbUsuarios.addItem(
						new Usuarios(
								rs.getString("usuario"),
								rs.getString("pass"),
								rs.getString("nombre"),
								rs.getInt("tipo")
								)
				);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR: " + e);
		}		
	}
	
	@Override
	public String toString(){
		return nombre;
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
}


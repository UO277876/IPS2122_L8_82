package inscripcion;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class ClasificacionesView extends JFrame {
	
	private JTextField txClasificacion;
	private JLabel lbClasificacion;
	private JButton btnAceptar;
	private JComboBox<String> cbClasificaciones;
	private JScrollPane scrClasificaciones;
	private JTextArea txClasificaciones;
	
	private InscripcionController ic;
	
	public ClasificacionesView() {
		setTitle("Clasificaciones");
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		getContentPane().add(txClasificacion);
		getContentPane().add(lbClasificacion);
		getContentPane().add(btnAceptar);
		getContentPane().add(cbClasificaciones);
		getContentPane().add(scrClasificaciones);
		
		JTextArea txClasificaciones = new JTextArea();
		txClasificaciones.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txClasificaciones.setEditable(false);
		
		setResizable(false);
	}
	
	private JTextField getTxClasificacion( ) {
		if(txClasificacion == null) {
			txClasificacion = new JTextField();
			txClasificacion.setBounds(209, 23, 172, 19);
			txClasificacion.setColumns(10);
		}
		return txClasificacion;
	}
	
	private JLabel getLbClasificacion() {
		if(lbClasificacion == null) {
			lbClasificacion = new JLabel("Introduzca el ID de la carrera:");
			lbClasificacion.setLabelFor(txClasificacion);
			lbClasificacion.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lbClasificacion.setBounds(22, 25, 177, 13);
		}
		return lbClasificacion;
	}
	
	private JButton btnAceptar() {
		if(btnAceptar == null) {
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarClasificaciones();
				}
			});
			btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnAceptar.setBackground(new Color(51, 204, 0));
			btnAceptar.setBounds(508, 22, 85, 21);
		}
		return btnAceptar;
	}
	
	private JComboBox<String> getCbClasificaciones() {
		if(cbClasificaciones == null) {
			cbClasificaciones = new JComboBox<String>();
			cbClasificaciones.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			//cbArticulos.setModel(new DefaultComboBoxModel<Articulo>(carta.getArticulos()));
			cbClasificaciones.setModel(new DefaultComboBoxModel<String>(ic.getTipoClasif()));
			cbClasificaciones.setBounds(391, 22, 107, 21);
		}
		
		return cbClasificaciones;
	}
	
	private JScrollPane getScrClasificaciones() {
		if(scrClasificaciones == null) {
			scrClasificaciones = new JScrollPane();
			scrClasificaciones.setBounds(22, 66, 580, 247);
			scrClasificaciones.setViewportView(txClasificaciones);
		}
		return scrClasificaciones;
	}
	
	private JTextArea getTxClasificaciones() {
		if(txClasificaciones == null) {
			txClasificaciones = new JTextArea();
			txClasificaciones.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txClasificaciones.setEditable(false);
		}
		
		return txClasificaciones;
		
	}
	
	/**
	 * Muestra las clasificaciones dependiendo del id de la carrera
	 */
	private void mostrarClasificaciones() {
		// 1. Verificar que el campo ID no esta en blanco
		if(isVacio()) {
			JOptionPane.showMessageDialog(null, "Error: Campo id en blanco");
		} else {
			//2. Se almacena el tipo de clasificacion que se desea y el id
			int id = Integer.valueOf(txClasificacion.getText());
			String tipo = (String) getCbClasificaciones().getSelectedItem();
			
			// 3. Ejecutamos
			ic.clasificacion(tipo,id);
			
		}
	}
	
	// ----------------------------- Métodos de revision ---------------------------------------
	/**
	 * Comprueba si el campo txClasificacion esta vacío
	 * 
	 * @return true si lo esta y false si no
	 */
	private boolean isVacio() {
		return txClasificacion.getText().contentEquals("");
	}
}

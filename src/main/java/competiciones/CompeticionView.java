package competiciones;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class CompeticionView extends JFrame {

	private JLabel lbNombre;
	private JLabel lbTipo;
	private JLabel lbPlazas;
	private JTextField txNombre;
	private JComboBox<String> cbTipo;
	private JLabel lbDescripcion;
	private JTextField txPlazas;
	private JLabel lbDistancia;
	private JTextField txDistancia;
	private JScrollPane scrollPane;
	private JTextArea txDescripcion;
	private JButton btAceptar;
	private JLabel lblFechaCompe;
	private JTextField txFecha;

	public CompeticionView() {
		setResizable(false);
		setTitle("Listado de inscripciones");
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setForeground(Color.WHITE);
		getContentPane().setLayout(null);
		getContentPane().add(getLbNombre());
		getContentPane().add(getTxNombre());
		getContentPane().add(getLbTipo());
		getContentPane().add(getCbTipo());
		getContentPane().add(getLbDescripcion());
		getContentPane().add(getScrollPanel());
		getContentPane().add(getLbPlazas());
		getContentPane().add(getTxPlazas());
		getContentPane().add(getLbDistancia());
		getContentPane().add(getTxDistancia());
		getContentPane().add(getBtAceptar());
		getContentPane().add(getLblFechaCompe());
		getContentPane().add(getTxFecha());

		// Inicializacion de la clase InscripcionController
	}

	private JLabel getLbNombre() {
		if (lbNombre == null) {
			lbNombre = new JLabel("Nombre:");
			lbNombre.setDisplayedMnemonic('N');
			lbNombre.setLabelFor(getTxNombre());
			lbNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lbNombre.setBounds(24, 35, 70, 13);
		}
		return lbNombre;
	}
	
	private JLabel getLbPlazas() {
		if (lbPlazas == null) {
			lbPlazas = new JLabel("Número de plazas:");
			lbPlazas.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lbPlazas.setBounds(24, 114, 127, 13);
			lbPlazas.setLabelFor(getTxPlazas());
		}
		return lbPlazas;
	}
	
	private JScrollPane getScrollPanel() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(509, 58, 143, 168);
			scrollPane.setViewportView(getTxDescripcion());
		}
		return 	scrollPane;
	}
	
	private JButton getBtAceptar() {
		if(btAceptar == null) {
			btAceptar = new JButton("Aceptar");
			btAceptar.setForeground(Color.WHITE);
			btAceptar.setBackground(new Color(51, 204, 0));
			btAceptar.setFont(new Font("Tahoma", Font.BOLD, 13));
			btAceptar.setMnemonic('A');
			btAceptar.setBounds(556, 266, 96, 28);
		}
		return btAceptar;
	}
	
	private JTextArea getTxDescripcion() {
		if(txDescripcion == null) {
			txDescripcion = new JTextArea();
			txDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		}
		
		return txDescripcion;
	}
	
	private JTextField getTxPlazas() {
		if(txPlazas == null) {
			txPlazas = new JTextField();
			txPlazas.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txPlazas.setColumns(10);
			txPlazas.setBounds(245, 107, 155, 28);
		}
		return txPlazas;
	}
	
	private JLabel getLbTipo() {
		if (lbTipo == null) {
			lbTipo = new JLabel("Tipo:");
			lbTipo.setLabelFor(getCbTipo());
			lbTipo.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lbTipo.setBounds(24, 68, 70, 19);
		}
		return lbTipo;
	}
	
	
	private JTextField getTxNombre() {
		if (txNombre == null) {
			txNombre = new JTextField();
			txNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txNombre.setBounds(245, 28, 155, 28);
			txNombre.setColumns(10);
			setBounds(100, 100, 700, 354);
		}
		return txNombre;
	}
	
	private JComboBox<String> getCbTipo() {
		if (cbTipo == null) {
			cbTipo = new JComboBox<String>();
			cbTipo.setFont(new Font("Tahoma", Font.PLAIN, 13));
			cbTipo.setModel(new DefaultComboBoxModel<String>(new String[] { "Asfalto", "Montaña" }));
			cbTipo.setBounds(245, 66, 156, 21);
		}
		return cbTipo;
	}
	
	private JLabel getLbDescripcion() {
		if (lbDescripcion == null) {
			lbDescripcion = new JLabel("Descripción:");
			lbDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lbDescripcion.setBounds(512, 32, 96, 18);
			lbDescripcion.setLabelFor(getTxDescripcion());
		}
		return lbDescripcion;
	}
	
	private JLabel getLbDistancia() {
		if (lbDistancia == null) {
			lbDistancia = new JLabel("Distancia:");
			lbDistancia.setLabelFor(getTxDistancia());
			lbDistancia.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lbDistancia.setBounds(24, 157, 88, 19);
		}
		return lbDistancia;
	}
	
	private JTextField getTxDistancia() {
		if (txDistancia == null) {
			txDistancia = new JTextField();
			txDistancia.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txDistancia.setColumns(10);
			txDistancia.setBounds(245, 153, 155, 28);
		}
		return txDistancia;
	}
	
	private JLabel getLblFechaCompe() {
		if (lblFechaCompe == null) {
			lblFechaCompe = new JLabel("Fecha de la competición:");
			lblFechaCompe.setLabelFor(getTxFecha());
			lblFechaCompe.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblFechaCompe.setBounds(24, 207, 168, 19);
		}
		return lblFechaCompe;
	}
	
	private JTextField getTxFecha() {
		if (txFecha == null) {
			txFecha = new JTextField();
			txFecha.setForeground(Color.GRAY);
			txFecha.setText("YYYY/MM/DD");
			txFecha.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txFecha.setColumns(10);
			txFecha.setBounds(245, 198, 155, 28);
		}
		return txFecha;
	}

	// ----------------------------- Métodos independientes de la interfaz ---------------------------------------
	

	// ----------------------------- Métodos de revision ---------------------------------------
	/**
	 * Comprueba si el campo txNombre esta vacío
	 * 
	 * @return true si lo esta y false si no
	 */
	private boolean isVacio() {
		//return txEmail.getText().contentEquals("");
	}

}

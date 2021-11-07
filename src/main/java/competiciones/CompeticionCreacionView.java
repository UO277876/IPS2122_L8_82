package competiciones;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class CompeticionCreacionView extends JFrame {

	private JLabel lbNombre;
	private JLabel lbTipo;
	private JLabel lbProblemas;
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
	
	private CompeticionController cc;
	private JScrollPane scrollPane_1;
	private JTextArea txProblemas;
	private JButton btInscripcion;

	public CompeticionCreacionView() {
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
		getContentPane().add(getScrollPane_1());
		getContentPane().add(getLbProblemas());
		getContentPane().add(getBtInscripcion());

		// Inicializacion de la clase CompeticionController
		this.cc = new CompeticionController();
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
	
	private JLabel getLbProblemas() {
		if (lbProblemas == null) {
			lbProblemas = new JLabel("Incidencias:");
			lbProblemas.setDisplayedMnemonic('I');
			lbProblemas.setLabelFor(txProblemas);
			lbProblemas.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lbProblemas.setBounds(517, 32, 81, 19);
		}
		return lbProblemas;
	}
	
	private JLabel getLbPlazas() {
		if (lbPlazas == null) {
			lbPlazas = new JLabel("Número de plazas:");
			lbPlazas.setDisplayedMnemonic('N');
			lbPlazas.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lbPlazas.setBounds(24, 114, 127, 13);
			lbPlazas.setLabelFor(getTxPlazas());
		}
		return lbPlazas;
	}
	
	private JScrollPane getScrollPanel() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(245, 243, 155, 111);
			scrollPane.setViewportView(getTxDescripcion());
		}
		return 	scrollPane;
	}
	
	private JButton getBtAceptar() {
		if(btAceptar == null) {
			btAceptar = new JButton("Aceptar");
			btAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						crearCompeticion();
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			btAceptar.setForeground(Color.WHITE);
			btAceptar.setBackground(new Color(51, 204, 0));
			btAceptar.setFont(new Font("Tahoma", Font.BOLD, 13));
			btAceptar.setMnemonic('A');
			btAceptar.setBounds(666, 358, 96, 28);
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
			lbTipo.setDisplayedMnemonic('T');
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
			setBounds(100, 100, 824, 448);
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
			lbDescripcion.setDisplayedMnemonic('e');
			lbDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lbDescripcion.setBounds(24, 266, 96, 18);
			lbDescripcion.setLabelFor(getTxDescripcion());
		}
		return lbDescripcion;
	}
	
	private JLabel getLbDistancia() {
		if (lbDistancia == null) {
			lbDistancia = new JLabel("Distancia:");
			lbDistancia.setDisplayedMnemonic('D');
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
			lblFechaCompe.setDisplayedMnemonic('F');
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
			txFecha.setText("YYYY-MM-DD");
			txFecha.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txFecha.setColumns(10);
			txFecha.setBounds(245, 198, 155, 28);
		}
		return txFecha;
	}
	
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(517, 67, 245, 164);
			
			txProblemas = new JTextArea();
			txProblemas.setEditable(false);
			txProblemas.setFont(new Font("Tahoma", Font.PLAIN, 13));
			scrollPane_1.setViewportView(txProblemas);
		}
		return scrollPane_1;
	}
	
	private JButton getBtInscripcion() {
		if (btInscripcion == null) {
			btInscripcion = new JButton("Configurar inscripciones");
			btInscripcion.setMnemonic('C');
			btInscripcion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			btInscripcion.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btInscripcion.setBounds(517, 267, 176, 21);
		}
		return btInscripcion;
	}

	// ----------------------------- Métodos independientes de la interfaz
	// ---------------------------------------
	private void crearCompeticion() throws ParseException {
		try{
		String nombre = getTxNombre().getText();
		String descripcion = getTxDescripcion().getText();
		String tipo = (String) getCbTipo().getSelectedItem();
		int numPlazas = Integer.valueOf(getTxPlazas().getText());
		int distancia = Integer.valueOf(getTxDistancia().getText());
		
		// No se si esta muy bien
		String fecha = getTxFecha().getText();
		
		if(comprobacion(numPlazas,distancia)) {
			// FALTA INICIO Y FIN DE INSCRIPCIONES
			boolean correcto = cc.addCompeticion(nombre, descripcion, fecha, numPlazas, distancia, tipo);
			
			if(correcto) {
				JOptionPane.showMessageDialog(null,"Competición añadida correctamente");
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(null,"Ha habido algñun error en la creación");
			}
			
		}
		
		} catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"No puede introducir caracteres en el número de plazas o distancia");
		} 
		
	}
	
	private boolean comprobacion(int numPlazas, int distancia) {
		String listado = "";
		boolean correcto = true;
		if(isVacio()) {
			listado += ">" + "El campo nombre o fecha no puede estar vacío";
			correcto = false;
		}
		
		if(numPlazas < 0) {
			listado += ">" + "El número de plazas debe ser mayor o igual a 0";
			correcto = false;
		}
		
		if(distancia < 0) {
			listado += ">" + "La distancia debe ser mayor o igual a 0";
			correcto = false;
		}
		
		if(getTxFecha().getText().equals("YYYY-MM-DD")) {
			listado += ">" + "Debe introducir la fecha en el formato correcto";
			correcto = false;
		}
		
		txProblemas.setText(listado);
		return correcto;
	}

	// ----------------------------- Métodos de revision ---------------------------------------
	/**
	 * Comprueba si el campo txNombre esta vacío
	 * 
	 * @return true si lo esta y false si no
	 */
	private boolean isVacio() {
		return txNombre.getText().contentEquals("") || txFecha.getText().contentEquals("");
	}

}

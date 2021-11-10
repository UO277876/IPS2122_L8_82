package competiciones;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private JButton btContinuar;
	private JLabel lblFechaCompe;
	private JTextField txFecha;
	
	private CompeticionController cc;
	private JScrollPane scrollPane_1;
	private JTextArea txProblemas;
	private JButton btInscripcion;
	private JButton btCancelar;
	private JButton btRegistro;
	private JLabel lbAviso;
	private JLabel lbInicioIns;
	private JLabel lbFinIns;
	private JTextField txInicio;
	private JTextField txFin;

	public CompeticionCreacionView() {
		setResizable(false);
		setTitle("Creación Competiciones");
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
		getContentPane().add(getBtContinuar());
		getContentPane().add(getLblFechaCompe());
		getContentPane().add(getTxFecha());
		getContentPane().add(getScrollPane_1());
		getContentPane().add(getLbProblemas());
		getContentPane().add(getBtInscripcion());
		getContentPane().add(getBtCancelar());
		getContentPane().add(getBtRegistro());
		getContentPane().add(getLbAviso());
		getContentPane().add(getLbInicioIns());
		getContentPane().add(getLbFinIns());
		getContentPane().add(getTxInicio());
		getContentPane().add(getTxFin());

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
			lbProblemas.setBounds(494, 32, 81, 19);
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
	
	private JButton getBtContinuar() {
		if(btContinuar == null) {
			btContinuar = new JButton("Continuar");
			btContinuar.setEnabled(false);
			btContinuar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					reset();
				}
			});
			btContinuar.setForeground(Color.WHITE);
			btContinuar.setBackground(new Color(51, 204, 0));
			btContinuar.setFont(new Font("Tahoma", Font.BOLD, 13));
			btContinuar.setMnemonic('n');
			btContinuar.setBounds(666, 358, 117, 28);
		}
		return btContinuar;
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
			scrollPane_1.setBounds(494, 67, 268, 116);
			
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
			btInscripcion.setEnabled(false);
			btInscripcion.setMnemonic('C');
			btInscripcion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			btInscripcion.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btInscripcion.setBounds(494, 277, 176, 21);
		}
		return btInscripcion;
	}
	
	private JButton getBtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton("Cancelar");
			btCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					reset();
				}
			});
			btCancelar.setMnemonic('C');
			btCancelar.setForeground(Color.WHITE);
			btCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
			btCancelar.setBackground(new Color(153, 0, 0));
			btCancelar.setBounds(547, 358, 96, 28);
		}
		return btCancelar;
	}
	
	private void reset() {
		this.getTxPlazas().setText("");
		this.getTxNombre().setText("");
		this.getTxDescripcion().setText("");
		this.getTxFecha().setText("YYYY-MM-DD");
		this.getTxDistancia().setText("");
		this.getBtContinuar().setEnabled(false);
		this.getBtRegistro().setEnabled(true);
		this.txProblemas.setText("");
		getLbAviso().setText("");
		getLbAviso().setVisible(false);
		getTxFin().setText("YYYY-MM-DD");
		getTxInicio().setText("YYYY-MM-DD");
		
		setVisible(false);
	}
	
	private JButton getBtRegistro() {
		if (btRegistro == null) {
			btRegistro = new JButton("Registro");
			btRegistro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					crearCompeticion();
				}
			});
			btRegistro.setMnemonic('R');
			btRegistro.setForeground(Color.WHITE);
			btRegistro.setFont(new Font("Tahoma", Font.BOLD, 13));
			btRegistro.setBackground(Color.BLUE);
			btRegistro.setBounds(245, 364, 96, 28);
		}
		return btRegistro;
	}

	// ----------------------------- Métodos independientes de la interfaz
	// ---------------------------------------
	private void crearCompeticion() {
		try{
		String nombre = getTxNombre().getText();
		String descripcion = getTxDescripcion().getText();
		String tipo = (String) getCbTipo().getSelectedItem();
		int numPlazas = Integer.valueOf(getTxPlazas().getText());
		int distancia = Integer.valueOf(getTxDistancia().getText());
		String fecha = getTxFecha().getText();
		String inicio = getTxInicio().getText();
		String fin = getTxFin().getText();
		
		if(comprobacion(numPlazas,distancia)) {
			boolean correcto = cc.addCompeticion(nombre, descripcion, fecha, numPlazas, distancia, tipo, inicio, fin);
			
			if(correcto) {
				getBtContinuar().setEnabled(true);
				getBtRegistro().setEnabled(false);
				getLbAviso().setVisible(true);
				getLbAviso().setText("Se ha añadido correctamente");
			} else {
				getBtContinuar().setEnabled(false);
				getBtRegistro().setEnabled(true);
				getLbAviso().setVisible(true);
				getLbAviso().setText("No se pudo añadir correctamente");
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
			listado += ">" + "El campo nombre o fecha no puede estar vacío" + "\n";
			correcto = false;
		}
		
		if(numPlazas < 0) {
			listado += ">" + "El número de plazas debe ser mayor que 0" + "\n";
			correcto = false;
		}
		
		if(distancia < 0) {
			listado += ">" + "La distancia debe ser mayor que 0" + "\n";
			correcto = false;
		}
		
		if(!controlarFecha(getTxFecha().getText()) || !controlarFecha(getTxInicio().getText()) 
				|| !controlarFecha(getTxFin().getText())) {
			correcto = false;
		}
		
		listado += ">" + controlarFecha(getTxFecha().getText(), "fecha");
		listado += ">" + controlarFecha(getTxInicio().getText(), "fecha de inicio de inscripción");
		listado += ">" + controlarFecha(getTxFin().getText(), "fecha de fin de inscripción");
	
		txProblemas.setText(listado);
		return correcto;
	}
	
	private boolean controlarFecha(String fecha) {
		try {
			String[] parts = fecha.split("-");
			int año = Integer.valueOf(parts[0]);
			int mes = Integer.valueOf(parts[1]);
			int dia = Integer.valueOf(parts[2]);
			
			if(año >= 2021 && mes <= 12 && mes > 0 && dia <= 31 && dia > 0 ) {
				return true;
			} else {
				return false;
			}
		
		} catch(NumberFormatException e ) {
			return false;
		}
		
	}
	
	private String controlarFecha(String fecha, String tipo) {
		try {
			String[] parts = fecha.split("-");
			int año = Integer.valueOf(parts[0]);
			int mes = Integer.valueOf(parts[1]);
			int dia = Integer.valueOf(parts[2]);
			
			if(año >= 2021 && mes <= 12 && mes > 0 && dia <= 31 && dia > 0 ) {
				return "Formato " + tipo +" correcto"+ "\n";
			} else {
				return "Parámetro " + tipo +" incorrecto"+ "\n";
			}
		
		} catch(NumberFormatException e ) {
			return "Formato " + tipo +" incorrecto"+ "\n";
		}
		
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
	private JLabel getLbAviso() {
		if (lbAviso == null) {
			lbAviso = new JLabel("");
			lbAviso.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lbAviso.setBounds(494, 308, 268, 28);
			lbAviso.setVisible(false);
		}
		return lbAviso;
	}
	private JLabel getLbInicioIns() {
		if (lbInicioIns == null) {
			lbInicioIns = new JLabel("Inicio inscripción:");
			lbInicioIns.setLabelFor(getTxInicio());
			lbInicioIns.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lbInicioIns.setDisplayedMnemonic('I');
			lbInicioIns.setBounds(494, 207, 117, 19);
		}
		return lbInicioIns;
	}
	private JLabel getLbFinIns() {
		if (lbFinIns == null) {
			lbFinIns = new JLabel("Fin inscripción:");
			lbFinIns.setLabelFor(getTxFin());
			lbFinIns.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lbFinIns.setDisplayedMnemonic('F');
			lbFinIns.setBounds(494, 244, 117, 19);
		}
		return lbFinIns;
	}
	private JTextField getTxInicio() {
		if (txInicio == null) {
			txInicio = new JTextField();
			txInicio.setText("YYYY-MM-DD");
			txInicio.setForeground(Color.GRAY);
			txInicio.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txInicio.setColumns(10);
			txInicio.setBounds(628, 203, 155, 28);
		}
		return txInicio;
	}
	private JTextField getTxFin() {
		if (txFin == null) {
			txFin = new JTextField();
			txFin.setText("YYYY-MM-DD");
			txFin.setForeground(Color.GRAY);
			txFin.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txFin.setColumns(10);
			txFin.setBounds(628, 240, 155, 28);
		}
		return txFin;
	}
}

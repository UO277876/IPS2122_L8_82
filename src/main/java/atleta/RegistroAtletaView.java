package atleta;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class RegistroAtletaView extends JFrame {
	
	private AtletaController ac;

	private JPanel panel;
	private JLabel lbNombre;
	private JLabel lbFechaNacimiento;
	private JTextField txNombre;
	private JLabel lbDni;
	private JTextField txDni;
	private JButton btnContinuar;
	private JButton btnCancelar;
	private JLabel lbEmail;
	private JTextField txEmail;
	private JLabel lbGenero;
	private JTextField txEdad;
	private JComboBox<String> cbGenero;
	private JLabel lbIncidencias;
	private JScrollPane scrollPane;
	private JTextArea txProblemas;
	private JButton btnRegistrar;
	private JLabel lbCorrecto;
	private InscripcionAtletaView iav;
	private JTextField txApellidos;
	private JLabel lbApellido;
	
	public RegistroAtletaView(InscripcionAtletaView iav) {
		this.iav = iav;
		setTitle("Registro Atleta");
		setResizable(false);
		ac = new AtletaController();
		
		
		getContentPane().add(getPanel(), BorderLayout.CENTER);
		setBounds(100, 100, 631, 397);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setLayout(null);
			panel.add(getLbNombre());
			panel.add(getTxNombre());
			panel.add(getLbDni());
			panel.add(getTxDni());
			panel.add(getBtnContinuar());
			panel.add(getBtnCancelar());
			panel.add(getLbEmail());
			panel.add(getTxEmail());
			panel.add(getLbGenero());
			panel.add(getLbFechaNacimiento());
			panel.add(getCbGenero());
			panel.add(getTxEdad());
			panel.add(getLbIncidencias());
			panel.add(getScrollPane());
			panel.add(getBtnRegistrar());
			panel.add(getLbCorrecto());
			panel.add(getTxApellidos());
			panel.add(getLbApellido());
		}
		return panel;
	}
	
	private JLabel getLbNombre() {
		if (lbNombre == null) {
			lbNombre = new JLabel("Nombre:");
			lbNombre.setDisplayedMnemonic('N');
			lbNombre.setLabelFor(getTxNombre());
			lbNombre.setFont(new Font("Calibri", Font.PLAIN, 17));
			lbNombre.setBounds(20, 25, 106, 43);
		}
		return lbNombre;
	}
	
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(414, 59, 177, 160);
			
			txProblemas = new JTextArea();
			getLbIncidencias().setLabelFor(txProblemas);
			txProblemas.setEditable(false);
			txProblemas.setFont(new Font("Tahoma", Font.PLAIN, 13));
			scrollPane.setViewportView(txProblemas);
		}
		return scrollPane;
	}
	
	private JComboBox<String> getCbGenero() {
		if (cbGenero == null) {
			cbGenero = new JComboBox<String>();
			getLbGenero().setLabelFor(cbGenero);
			cbGenero.setModel(new DefaultComboBoxModel<String>(new String[] { "Masculino", "Femenino" }));
			cbGenero.setBounds(195, 197, 99, 21);
		}
		return cbGenero;
	}
	
	private JLabel getLbFechaNacimiento() {
		if (lbFechaNacimiento == null) {
			lbFechaNacimiento = new JLabel("Fecha de nacimiento:");
			lbFechaNacimiento.setDisplayedMnemonic('F');
			lbFechaNacimiento.setFont(new Font("Calibri", Font.PLAIN, 17));
			lbFechaNacimiento.setBounds(20, 228, 154, 26);
			lbFechaNacimiento.setLabelFor(txEdad);
		}
		return lbFechaNacimiento;
	}
	
	private JTextField getTxEdad() {
		if (txEdad == null) {
			txEdad = new JTextField();
			txEdad.setText("YYYY-MM-DD");
			txEdad.setForeground(Color.GRAY);
			txEdad.setColumns(10);
			txEdad.setBounds(195, 228, 139, 26);
		}
		return txEdad;
	}
	
	private JTextField getTxNombre() {
		if (txNombre == null) {
			txNombre = new JTextField();
			txNombre.setBounds(195, 33, 166, 26);
			txNombre.setColumns(10);
		}
		return txNombre;
	}
	
	private JLabel getLbDni() {
		if (lbDni == null) {
			lbDni = new JLabel("DNI:");
			lbDni.setDisplayedMnemonic('D');
			lbDni.setLabelFor(getTxDni());
			lbDni.setFont(new Font("Calibri", Font.PLAIN, 17));
			lbDni.setBounds(20, 101, 38, 26);
		}
		return lbDni;
	}
	
	private JTextField getTxDni() {
		if (txDni == null) {
			txDni = new JTextField();
			txDni.setColumns(10);
			txDni.setBounds(195, 101, 166, 26);
		}
		return txDni;
	}
	
	private JButton getBtnContinuar() {
		if (btnContinuar == null) {
			btnContinuar = new JButton("Continuar");
			btnContinuar.setEnabled(false);
			btnContinuar.setMnemonic('n');
			btnContinuar.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnContinuar.setBackground(new Color(51, 204, 0));
			btnContinuar.setForeground(Color.WHITE);
			btnContinuar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					reset();
					
				}
			});
			btnContinuar.setBounds(509, 315, 98, 21);
		}
		return btnContinuar;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setForeground(Color.WHITE);
			btnCancelar.setMnemonic('C');
			btnCancelar.setBackground(new Color(153, 0, 0));
			btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					reset();
				}
			});
			btnCancelar.setBounds(414, 315, 85, 21);
		}
		return btnCancelar;
	}
	
	private JButton getBtnRegistrar() {
		if(btnRegistrar == null){
			btnRegistrar = new JButton("Registrar");
			btnRegistrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					crearAtleta();
					
				}
			});
			btnRegistrar.setMnemonic('R');
			btnRegistrar.setForeground(Color.WHITE);
			btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnRegistrar.setBackground(Color.BLUE);
			btnRegistrar.setBounds(195, 279, 85, 21);
		}
		
		return btnRegistrar;
	}
	
	public void reset() {
		this.txDni.setText("");
		this.txNombre.setText("");
		this.txEdad.setText("");
		this.txEmail.setText("");
		this.txApellidos.setText("");
		getBtnContinuar().setEnabled(false);
		getBtnRegistrar().setEnabled(true);
		getLbCorrecto().setVisible(false);
		setVisible(false);
	}
	
	private JLabel getLbEmail() {
		if (lbEmail == null) {
			lbEmail = new JLabel("Email:");
			lbEmail.setDisplayedMnemonic('E');
			lbEmail.setLabelFor(getTxEmail());
			lbEmail.setFont(new Font("Calibri", Font.PLAIN, 17));
			lbEmail.setBounds(20, 150, 64, 26);
		}
		return lbEmail;
	}
	
	private JTextField getTxEmail() {
		if (txEmail == null) {
			txEmail = new JTextField();
			txEmail.setColumns(10);
			txEmail.setBounds(195, 150, 209, 26);
			txEmail.setText(iav.getEmail());
		}
		return txEmail;
	}
	
	private JLabel getLbGenero() {
		if (lbGenero == null) {
			lbGenero = new JLabel("Género:");
			lbGenero.setDisplayedMnemonic('G');
			lbGenero.setFont(new Font("Calibri", Font.PLAIN, 17));
			lbGenero.setBounds(20, 192, 64, 26);
			lbGenero.setLabelFor(getCbGenero());
		}
		return lbGenero;
	}
	
	private void crearAtleta() {
		String email = getTxEmail().getText();
		String nombre = getTxNombre().getText();
		String dni = getTxDni().getText();
		String genero = (String) getCbGenero().getSelectedItem();
		genero = genero.toLowerCase();
		String edad = getTxEdad().getText();
		String apellidos = getTxApellidos().getText();
		
		if(control()) {
			boolean añadido = ac.crearAtleta(email,nombre,apellidos,dni,genero,edad);
			setTexto(añadido);
			
		}
	}
	
	private boolean control() {
		String listado = "";
		boolean correcto = true;
		if(getTxNombre().getText().equals("") ) {
			listado += ">" + "El campo nombre no puede estar vacío" + "\n";
			correcto = false;
		}
		
		if(getTxApellidos().getText().equals("") ) {
			listado += ">" + "El campo apellidos no puede estar vacío" + "\n";
			correcto = false;
		}
		
		if(getTxDni().getText().equals("")) {
			listado += ">" + "El campo dni no puede estar vacío" + "\n";
			correcto = false;
		}
		
		if(getTxEmail().getText().equals("")) {
			listado += ">" + "El campo email no puede estar vacío" + "\n";
			correcto = false;
		}
		
		listado += ">" + controlarFecha();
		
		txProblemas.setText(listado);
		return correcto;
	}
	
	private String controlarFecha() {
		try {
			String edad = getTxEdad().getText();
			String[] parts = edad.split("-");
			int año = Integer.valueOf(parts[0]);
			int mes = Integer.valueOf(parts[1]);
			int dia = Integer.valueOf(parts[2]);
			
			if(año >= 1920 && mes <= 12 && mes > 0 && dia <= 31 && dia > 0 ) {
				return "Formato fecha correcto";
			} else {
				return "Parámetro fecha incorrecto";
			}
		
		} catch(NumberFormatException e ) {
			return "Formato fecha incorrecto";
		}
		
		
	}
	
	private void setTexto(boolean añadido) {
		if(añadido) {
			getLbCorrecto().setText("Registro completado correctamente");
			getBtnRegistrar().setEnabled(false);
			getBtnContinuar().setEnabled(true);
		} else {
			getLbCorrecto().setText("Ha habido un problema");
			getBtnRegistrar().setEnabled(true);
			getBtnContinuar().setEnabled(false);
		}
		
		lbCorrecto.setVisible(true);
	}
	
	private JLabel getLbIncidencias() {
		if (lbIncidencias == null) {
			lbIncidencias = new JLabel("Incidencias:");
			lbIncidencias.setFont(new Font("Calibri", Font.PLAIN, 17));
			lbIncidencias.setBounds(414, 25, 106, 43);
		}
		return lbIncidencias;
	}

	private JLabel getLbCorrecto() {
		if (lbCorrecto == null) {
			lbCorrecto = new JLabel("");
			lbCorrecto.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lbCorrecto.setBounds(398, 241, 209, 26);
			lbCorrecto.setVisible(false);
		}
		return lbCorrecto;
	}
	private JTextField getTxApellidos() {
		if (txApellidos == null) {
			txApellidos = new JTextField();
			txApellidos.setColumns(10);
			txApellidos.setBounds(195, 69, 209, 26);
		}
		return txApellidos;
	}
	private JLabel getLbApellido() {
		if (lbApellido == null) {
			lbApellido = new JLabel("Apellidos:");
			lbApellido.setDisplayedMnemonic('A');
			lbApellido.setLabelFor(getTxApellidos());
			lbApellido.setFont(new Font("Calibri", Font.PLAIN, 17));
			lbApellido.setBounds(20, 59, 106, 43);
		}
		return lbApellido;
	}
}

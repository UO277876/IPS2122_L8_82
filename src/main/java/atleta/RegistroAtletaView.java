package atleta;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class RegistroAtletaView extends JFrame {
	
	private AtletaController ac;
	
	private JPanel panel;
	private JLabel lbNombre;
	private JLabel lbEdad;
	private JTextField txNombre;
	private JLabel lbDni;
	private JTextField txDni;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JLabel lbEmail;
	private JTextField txEmail;
	private JLabel lbGenero;
	private JTextField txEdad;
	private JComboBox<String> cbGenero;
	private JLabel lbIncidencias;
	private JScrollPane scrollPane;
	private JTextArea txProblemas;
	
	public RegistroAtletaView() {
		setTitle("Registro Atleta");
		setResizable(false);
		ac = new AtletaController();
		
		
		getContentPane().add(getPanel(), BorderLayout.CENTER);
		setBounds(100, 100, 631, 350);
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
			panel.add(getBtnAceptar());
			panel.add(getBtnCancelar());
			panel.add(getLbEmail());
			panel.add(getTxEmail());
			panel.add(getLbGenero());
			panel.add(getLbEdad());
			panel.add(getCbGenero());
			panel.add(getTxEdad());
			panel.add(getLbIncidencias());
			panel.add(getScrollPane());
		}
		return panel;
	}
	
	private JLabel getLbNombre() {
		if (lbNombre == null) {
			lbNombre = new JLabel("Nombre:");
			lbNombre.setLabelFor(getTxNombre());
			lbNombre.setFont(new Font("Calibri", Font.PLAIN, 17));
			lbNombre.setBounds(34, 25, 106, 43);
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
			cbGenero.setBounds(115, 154, 99, 21);
		}
		return cbGenero;
	}
	
	private JLabel getLbEdad() {
		if (lbEdad == null) {
			lbEdad = new JLabel("Edad:");
			lbEdad.setFont(new Font("Calibri", Font.PLAIN, 17));
			lbEdad.setBounds(34, 193, 64, 26);
			lbEdad.setLabelFor(txEdad);
		}
		return lbEdad;
	}
	
	private JTextField getTxEdad() {
		if (txEdad == null) {
			txEdad = new JTextField();
			txEdad.setColumns(10);
			txEdad.setBounds(115, 193, 85, 26);
		}
		return txEdad;
	}
	
	private JTextField getTxNombre() {
		if (txNombre == null) {
			txNombre = new JTextField();
			txNombre.setBounds(115, 33, 198, 26);
			txNombre.setColumns(10);
		}
		return txNombre;
	}
	
	private JLabel getLbDni() {
		if (lbDni == null) {
			lbDni = new JLabel("DNI:");
			lbDni.setLabelFor(getTxDni());
			lbDni.setFont(new Font("Calibri", Font.PLAIN, 17));
			lbDni.setBounds(34, 78, 38, 26);
		}
		return lbDni;
	}
	
	private JTextField getTxDni() {
		if (txDni == null) {
			txDni = new JTextField();
			txDni.setColumns(10);
			txDni.setBounds(115, 78, 166, 26);
		}
		return txDni;
	}
	
	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton("Aceptar");
			btnAceptar.setMnemonic('A');
			btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnAceptar.setBackground(new Color(51, 204, 0));
			btnAceptar.setForeground(Color.WHITE);
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					crearAtleta();
					
				}
			});
			btnAceptar.setBounds(522, 282, 85, 21);
		}
		return btnAceptar;
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
			btnCancelar.setBounds(427, 282, 85, 21);
		}
		return btnCancelar;
	}
	
	public void reset() {
		this.txDni.setText("");
		this.txNombre.setText("");
		this.txEdad.setText("");
		this.txEmail.setText("");
		setVisible(false);
	}
	
	private JLabel getLbEmail() {
		if (lbEmail == null) {
			lbEmail = new JLabel("Email:");
			lbEmail.setLabelFor(getTxEmail());
			lbEmail.setFont(new Font("Calibri", Font.PLAIN, 17));
			lbEmail.setBounds(34, 116, 64, 26);
		}
		return lbEmail;
	}
	
	private JTextField getTxEmail() {
		if (txEmail == null) {
			txEmail = new JTextField();
			txEmail.setColumns(10);
			txEmail.setBounds(115, 114, 260, 26);
		}
		return txEmail;
	}
	
	private JLabel getLbGenero() {
		if (lbGenero == null) {
			lbGenero = new JLabel("Género:");
			lbGenero.setFont(new Font("Calibri", Font.PLAIN, 17));
			lbGenero.setBounds(34, 152, 64, 26);
			lbGenero.setLabelFor(getCbGenero());
		}
		return lbGenero;
	}
	
	private void crearAtleta() throws ParseException {
		try {
		String email = getTxEmail().getText();
		String nombre = getTxNombre().getText();
		String dni = getTxDni().getText();
		String genero = (String) getCbGenero().getSelectedItem();
		int edad = Integer.valueOf(getTxEdad().getText());
		
		} catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"No puede introducir caracteres en edad");
		} 
	}
	private JLabel getLbIncidencias() {
		if (lbIncidencias == null) {
			lbIncidencias = new JLabel("Incidencias:");
			lbIncidencias.setFont(new Font("Calibri", Font.PLAIN, 17));
			lbIncidencias.setBounds(414, 25, 106, 43);
		}
		return lbIncidencias;
	}
}

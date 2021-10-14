package Atleta;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class InscripcionAtletaView extends JFrame {
	public InscripcionAtletaView() {
		setResizable(false);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblIntroduceEmail = new JLabel("Introduzca su email: ");
		lblIntroduceEmail.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblIntroduceEmail.setBounds(33, 71, 147, 37);
		panel.add(lblIntroduceEmail);
		
		txtIntroduceEmail = new JTextField();
		txtIntroduceEmail.setBounds(184, 71, 216, 37);
		panel.add(txtIntroduceEmail);
		txtIntroduceEmail.setColumns(10);
		
		JLabel lblCarrera = new JLabel("Introduzca el codigo de la carrera:");
		lblCarrera.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblCarrera.setBounds(33, 157, 216, 44);
		panel.add(lblCarrera);
		
		textField = new JTextField();
		textField.setBounds(259, 157, 141, 44);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(315, 241, 85, 21);
		panel.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(220, 241, 85, 21);
		panel.add(btnCancelar);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtIntroduceEmail;
	private JTextField textField;
}

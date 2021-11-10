package atleta;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import inscripcion.InscripcionController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PagarConTarjetaView extends JFrame {
	private JLabel lblDescripcion;
	private JLabel lblNumero;
	private JTextField txtNumero;
	private JLabel lblFechaCaducidad;
	private JTextField txtFechaCaducidad;
	private JLabel lblCVC;
	private JTextField txtCVC;
	private JButton btnAceptar;
	private JButton btnCancelar;
	
	
	private InscripcionController ic;
	
	
	public PagarConTarjetaView() {
		
		this.setResizable(false);
		
		this.ic = new InscripcionController();
		
		getContentPane().setLayout(null);
		getContentPane().add(getLblDescripcion());
		getContentPane().add(getLblNumero());
		getContentPane().add(getTxtNumero());
		getContentPane().add(getLblFechaCaducidad());
		getContentPane().add(getTxtFechaCaducidad());
		getContentPane().add(getLblCVC());
		getContentPane().add(getTxtCVC());
		getContentPane().add(getBtnAceptar());
		getContentPane().add(getBtnCancelar());
		
		setBounds(100, 100, 460, 400);
	}

	private JLabel getLblDescripcion() {
		if (lblDescripcion == null) {
			lblDescripcion = new JLabel("Introduzca los datos de la tarjeta:");
			lblDescripcion.setFont(new Font("Calibri", Font.PLAIN, 16));
			lblDescripcion.setBounds(98, 33, 233, 31);
		}
		return lblDescripcion;
	}
	private JLabel getLblNumero() {
		if (lblNumero == null) {
			lblNumero = new JLabel("Número:");
			lblNumero.setFont(new Font("Calibri", Font.PLAIN, 16));
			lblNumero.setBounds(54, 111, 64, 20);
		}
		return lblNumero;
	}
	private JTextField getTxtNumero() {
		if (txtNumero == null) {
			txtNumero = new JTextField();
			txtNumero.setFont(new Font("Calibri", Font.PLAIN, 16));
			txtNumero.setBounds(128, 100, 249, 45);
			txtNumero.setColumns(10);
		}
		return txtNumero;
	}
	private JLabel getLblFechaCaducidad() {
		if (lblFechaCaducidad == null) {
			lblFechaCaducidad = new JLabel("Fecha de Caducidad:");
			lblFechaCaducidad.setFont(new Font("Calibri", Font.PLAIN, 16));
			lblFechaCaducidad.setBounds(54, 175, 151, 20);
		}
		return lblFechaCaducidad;
	}
	private JTextField getTxtFechaCaducidad() {
		if (txtFechaCaducidad == null) {
			txtFechaCaducidad = new JTextField();
			txtFechaCaducidad.setBounds(215, 163, 162, 45);
			txtFechaCaducidad.setColumns(10);
		}
		return txtFechaCaducidad;
	}
	private JLabel getLblCVC() {
		if (lblCVC == null) {
			lblCVC = new JLabel("CVC:");
			lblCVC.setFont(new Font("Calibri", Font.PLAIN, 16));
			lblCVC.setBounds(54, 239, 64, 20);
		}
		return lblCVC;
	}
	private JTextField getTxtCVC() {
		if (txtCVC == null) {
			txtCVC = new JTextField();
			txtCVC.setBounds(128, 228, 249, 45);
			txtCVC.setColumns(10);
		}
		return txtCVC;
	}
	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					//ic.setMetodoDePago("tarjeta");
					
					reset();
				}
			});
			btnAceptar.setBounds(288, 320, 89, 23);
		}
		return btnAceptar;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					reset();
				}
			});
			btnCancelar.setBounds(188, 320, 89, 23);
		}
		return btnCancelar;
	}
	
	public void reset() {
		this.getTxtCVC().setText("");
		this.getTxtFechaCaducidad().setText("");
		this.getTxtNumero().setText("");
		this.setVisible(false);
	}
	
}

package Atleta;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import inscripcion.InscripcionController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PagarConTransferenciaView extends JFrame{
	
	private final static String METODODEPAGO_TRANSFERENCIA = "Transferencia";
	
	private JLabel lblDescripcion;
	private JLabel lblCantidadAPagar;
	private JLabel lblDescripcion2;
	private JLabel lblNumeroDeCuenta;
	private JButton btnAceptar;
	
	private InscripcionController ic;
	
	public PagarConTransferenciaView(InscripcionController ic) {
		
		this.ic = ic;
		
		
		this.setResizable(false);
		setBounds(100,100,480,299);
		
		getContentPane().setLayout(null);
		getContentPane().add(getLblDescripcion());
		getContentPane().add(getLblCantidadAPagar());
		getContentPane().add(getLblDescripcion2());
		getContentPane().add(getLblNumeroDeCuenta());
		getContentPane().add(getBtnAceptar());
	}
	private JLabel getLblDescripcion() {
		if (lblDescripcion == null) {
			lblDescripcion = new JLabel("Por favor siga las indicaciones para completar su inscripcion");
			lblDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
			lblDescripcion.setFont(new Font("Calibri", Font.PLAIN, 16));
			lblDescripcion.setBounds(37, 40, 410, 40);
		}
		return lblDescripcion;
	}
	private JLabel getLblCantidadAPagar() {
		if (lblCantidadAPagar == null) {
			lblCantidadAPagar = new JLabel("Debe abonar la cantidad de X euros antes de 48 horas");
			lblCantidadAPagar.setHorizontalAlignment(SwingConstants.CENTER);
			lblCantidadAPagar.setFont(new Font("Calibri", Font.PLAIN, 16));
			lblCantidadAPagar.setBounds(37, 90, 410, 40);
		}
		return lblCantidadAPagar;
	}
	private JLabel getLblDescripcion2() {
		if (lblDescripcion2 == null) {
			lblDescripcion2 = new JLabel("Al siguiente numero de cuenta:");
			lblDescripcion2.setHorizontalAlignment(SwingConstants.CENTER);
			lblDescripcion2.setFont(new Font("Calibri", Font.PLAIN, 16));
			lblDescripcion2.setBounds(37, 126, 410, 40);
		}
		return lblDescripcion2;
	}
	private JLabel getLblNumeroDeCuenta() {
		if (lblNumeroDeCuenta == null) {
			lblNumeroDeCuenta = new JLabel("XXXX-XXXX-XXXX-XXXX");
			lblNumeroDeCuenta.setFont(new Font("Calibri", Font.PLAIN, 16));
			lblNumeroDeCuenta.setHorizontalAlignment(SwingConstants.CENTER);
			lblNumeroDeCuenta.setBounds(37, 176, 410, 40);
		}
		return lblNumeroDeCuenta;
	}
	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ic.setMetodoDePago(ic.getEmailProvisionalParaPago(), ic.getIdProvisionalParaPago(), METODODEPAGO_TRANSFERENCIA);
					reset();
				}
			});
			btnAceptar.setBounds(362, 232, 85, 21);
		}
		return btnAceptar;
	}
	
	public void reset() {
		/*this.getTxtCVC().setText("");
		this.getTxtFechaCaducidad().setText("");
		this.getTxtNumero().setText("");*/
		this.setVisible(false);
	}
}

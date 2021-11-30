package atleta;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import inscripcion.InscripcionController;

import java.awt.Font;
import javax.swing.DropMode;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PagarConTransferenciaView extends JFrame{
	private JLabel lblConfirmacionDeRegistro;
	private JLabel lblCantidadAPagar;
	private JLabel lblPlazoParaPagar;
	private JLabel lblNumeroDeCuenta;
	private JButton btnAceptar;
	private JButton btnCancelar;
	
	
	private InscripcionController ic;
	private MetodoDePagoView mdpv;
	
	public PagarConTransferenciaView(MetodoDePagoView mdpv, InscripcionController ic) {
		this.setResizable(false);
		
		this.mdpv = mdpv;
		this.ic = ic;
		
		getContentPane().setLayout(null);
		getContentPane().add(getLblConfirmacionDeRegistro());
		getContentPane().add(getLblCantidadAPagar());
		getContentPane().add(getLblPlazoParaPagar());
		getContentPane().add(getLblNumeroDeCuenta());
		getContentPane().add(getBtnAceptar());
		getContentPane().add(getBtnCancelar());
		
		setBounds(100, 100, 460, 400);
		
	}
	private JLabel getLblConfirmacionDeRegistro() {
		if (lblConfirmacionDeRegistro == null) {
			lblConfirmacionDeRegistro = new JLabel("New label");
			lblConfirmacionDeRegistro.setBounds(44, 37, 45, 13);
		}
		return lblConfirmacionDeRegistro;
	}
	private JLabel getLblCantidadAPagar() {
		if (lblCantidadAPagar == null) {
			lblCantidadAPagar = new JLabel("New label");
			lblCantidadAPagar.setBounds(44, 82, 45, 13);
		}
		return lblCantidadAPagar;
	}
	private JLabel getLblPlazoParaPagar() {
		if (lblPlazoParaPagar == null) {
			lblPlazoParaPagar = new JLabel("New label");
			lblPlazoParaPagar.setBounds(44, 135, 45, 13);
		}
		return lblPlazoParaPagar;
	}
	private JLabel getLblNumeroDeCuenta() {
		if (lblNumeroDeCuenta == null) {
			lblNumeroDeCuenta = new JLabel("New label");
			lblNumeroDeCuenta.setBounds(44, 184, 45, 13);
		}
		return lblNumeroDeCuenta;
	}
	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ic.actualizaMetodoDePago(ic.getIdMetodoDePagoProvisional(), "transferencia");
					JOptionPane.showMessageDialog(null, "Se ha completado su registro");
					reset();
				}
			});
			btnAceptar.setBounds(341, 232, 85, 21);
		}
		return btnAceptar;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setBounds(246, 232, 85, 21);
		}
		return btnCancelar;
	}
	
	public void reset() {
		this.mdpv.setVisible(false);
		this.setVisible(false);
	}
}

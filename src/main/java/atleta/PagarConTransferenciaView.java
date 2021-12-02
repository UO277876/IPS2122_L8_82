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
import java.awt.Color;

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
		getContentPane().setBackground(Color.WHITE);
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
		
		setBounds(100, 100, 591, 376);
		
	}
	private JLabel getLblConfirmacionDeRegistro() {
		if (lblConfirmacionDeRegistro == null) {
			lblConfirmacionDeRegistro = new JLabel("Para terminar de confirma su registro siga las siguientes instrucciones:");
			lblConfirmacionDeRegistro.setHorizontalAlignment(SwingConstants.CENTER);
			lblConfirmacionDeRegistro.setFont(new Font("Calibri", Font.PLAIN, 16));
			lblConfirmacionDeRegistro.setBounds(44, 37, 501, 28);
		}
		return lblConfirmacionDeRegistro;
	}
	private JLabel getLblCantidadAPagar() {
		if (lblCantidadAPagar == null) {
			lblCantidadAPagar = new JLabel("Debe abonar la cantidad de 0.0 euros antes de 48 horas ");
			lblCantidadAPagar.setHorizontalAlignment(SwingConstants.CENTER);
			lblCantidadAPagar.setFont(new Font("Calibri", Font.PLAIN, 16));
			lblCantidadAPagar.setBounds(44, 82, 501, 28);
		}
		return lblCantidadAPagar;
	}
	private JLabel getLblPlazoParaPagar() {
		if (lblPlazoParaPagar == null) {
			lblPlazoParaPagar = new JLabel("al siguiente numero de cuenta:");
			lblPlazoParaPagar.setHorizontalAlignment(SwingConstants.CENTER);
			lblPlazoParaPagar.setFont(new Font("Calibri", Font.PLAIN, 16));
			lblPlazoParaPagar.setBounds(44, 110, 501, 28);
		}
		return lblPlazoParaPagar;
	}
	private JLabel getLblNumeroDeCuenta() {
		if (lblNumeroDeCuenta == null) {
			lblNumeroDeCuenta = new JLabel("4010 8901 0252 1448");
			lblNumeroDeCuenta.setFont(new Font("Calibri", Font.PLAIN, 20));
			lblNumeroDeCuenta.setHorizontalAlignment(SwingConstants.CENTER);
			lblNumeroDeCuenta.setBounds(44, 184, 501, 51);
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
			btnAceptar.setBounds(460, 300, 85, 21);
		}
		return btnAceptar;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setBounds(365, 300, 85, 21);
		}
		return btnCancelar;
	}
	
	public void reset() {
		this.mdpv.setVisible(false);
		this.setVisible(false);
	}
}

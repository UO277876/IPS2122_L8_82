package atleta;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class MetodoDePagoView extends JFrame{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private JLabel lblMetodoDePago;
	private JComboBox<String> cbMetodoDePago;
	private JButton btnAceptar;
	private JButton btnCancelar;
	
	
	public MetodoDePagoView() {
		setResizable(false);
		getContentPane().setLayout(null);
		getContentPane().add(getLblMetodoDePago());
		getContentPane().add(getCbMetodoDePago());
		getContentPane().add(getBtnAceptar());
		getContentPane().add(getBtnCancelar());
		setBounds(100, 100, 265, 250);
	}

	private JLabel getLblMetodoDePago() {
		if (lblMetodoDePago == null) {
			lblMetodoDePago = new JLabel("Seleccione su metodo de pago:");
			lblMetodoDePago.setFont(new Font("Calibri", Font.PLAIN, 16));
			lblMetodoDePago.setBounds(30, 36, 201, 34);
		}
		return lblMetodoDePago;
	}
	private JComboBox<String> getCbMetodoDePago() {
		if (cbMetodoDePago == null) {
			cbMetodoDePago = new JComboBox<String>();
			cbMetodoDePago.setFont(new Font("Calibri", Font.PLAIN, 16));
			cbMetodoDePago.setModel(new DefaultComboBoxModel<String>(new String[] {"metalico", "tarjeta"}));
			cbMetodoDePago.setBounds(30, 81, 201, 34);
		}
		return cbMetodoDePago;
	}
	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton("Aceptar");
			btnAceptar.setBounds(142, 174, 89, 23);
		}
		return btnAceptar;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setBounds(30, 174, 89, 23);
		}
		return btnCancelar;
	}
}

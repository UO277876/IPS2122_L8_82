package inscripcion;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class CancelacionView extends JFrame {
	
	@SuppressWarnings("unused")
	private InscripcionView iv;
	private double cantidadDevuelta;
	
	private JButton btnAceptar;
	private JTextField txCantidad;
	private JLabel lbAviso;
	private JLabel lbAviso2;
	
	public CancelacionView(InscripcionView iv, double cantidadDevuelta) {
		setBounds(400,400,310,200);
		setResizable(false);
		this.cantidadDevuelta = cantidadDevuelta;
		this.iv = iv;
		
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		setTitle("Cancelación");
		getContentPane().add(getBtnAceptar());
		
		JLabel lbCantidad = new JLabel("Cantidad a devolver:");
		lbCantidad.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbCantidad.setBounds(31, 66, 120, 13);
		getContentPane().add(lbCantidad);
		
		JLabel lbExito = new JLabel("Cancelación exitosa");
		lbExito.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbExito.setBounds(79, 27, 198, 13);
		getContentPane().add(lbExito);
		
		lbCantidad.setLabelFor(getTxCantidad());
		getContentPane().add(getTxCantidad());
		getContentPane().add(getLbAviso());
		getContentPane().add(getLbAviso2());
	}
	
	private JTextField getTxCantidad() {
		if (txCantidad == null) {
			txCantidad = new JTextField();
			txCantidad.setForeground(Color.BLACK);
			txCantidad.setBackground(Color.WHITE);
			txCantidad.setEditable(false);
			txCantidad.setColumns(10);
			txCantidad.setBounds(161, 61, 85, 26);
			txCantidad.setText(String.valueOf(cantidadDevuelta) + " €");
		}
		return txCantidad;
	}
	
	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton("Aceptar");
			btnAceptar.setMnemonic('A');
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					reset();
				}
			});
			btnAceptar.setBackground(new Color(0, 204, 0));
			btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnAceptar.setForeground(Color.WHITE);
			btnAceptar.setBounds(195, 125, 85, 21);
		}
		return btnAceptar;
	}
	
	private void reset() {
		getTxCantidad().setText("0" + " €");
		setVisible(false);
	}
	private JLabel getLbAviso() {
		if (lbAviso == null) {
			lbAviso = new JLabel("Por favor. actualice el listado de inscripciones");
			lbAviso.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lbAviso.setBounds(31, 102, 259, 13);
		}
		return lbAviso;
	}
	private JLabel getLbAviso2() {
		if (lbAviso2 == null) {
			lbAviso2 = new JLabel("*Se le devolvera en unos dias");
			lbAviso2.setForeground(Color.GRAY);
			lbAviso2.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lbAviso2.setBounds(31, 130, 154, 13);
		}
		return lbAviso2;
	}
}

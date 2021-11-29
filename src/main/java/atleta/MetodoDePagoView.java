package atleta;

import javax.swing.JFrame;
import javax.swing.JLabel;

import inscripcion.InscripcionController;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MetodoDePagoView extends JFrame{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private InscripcionController ic;
	private AtletaController ac;
	
	private JLabel lblMetodoDePago;
	private JComboBox<String> cbMetodoDePago;
	private JButton btnAceptar;
	private JLabel lblNombreAtleta;
	private JLabel lblCategoria;
	private JLabel lblFechaInscripcion;
	private JLabel lblCantidadPagar;

	
	private AtletaDTO atleta;
	
	private PagarConTarjetaView pagarTarjView;
	private PagarConTransferenciaView pagarTransView;
	
	
	public MetodoDePagoView(InscripcionController ic, AtletaController ac) {
		this.ic = ic;
		this.ac = ac;
		this.pagarTarjView = new PagarConTarjetaView(this, ic);
		this.pagarTransView = new PagarConTransferenciaView(this, ic);
		
		atleta = ac.obtenerAtletaByEmail(ic.getEmailProvisionalParaPago());
		
		setText();
		
		setResizable(false);
		getContentPane().setLayout(null);
		getContentPane().add(getLblMetodoDePago());
		getContentPane().add(getCbMetodoDePago());
		getContentPane().add(getBtnAceptar());
		getContentPane().add(getLblNombreAtleta());
		getContentPane().add(getLblCategoria());
		getContentPane().add(getLblFechaInscripcion());
		getContentPane().add(getLblCantidadPagar());
		setBounds(100, 100, 519, 509);
	}

	private JLabel getLblMetodoDePago() {
		if (lblMetodoDePago == null) {
			lblMetodoDePago = new JLabel("Seleccione su metodo de pago:");
			lblMetodoDePago.setFont(new Font("Calibri", Font.PLAIN, 16));
			lblMetodoDePago.setBounds(48, 348, 201, 34);
		}
		return lblMetodoDePago;
	}
	
	
	private JComboBox<String> getCbMetodoDePago() {
		if (cbMetodoDePago == null) {
			cbMetodoDePago = new JComboBox<String>();
			cbMetodoDePago.setFont(new Font("Calibri", Font.PLAIN, 16));
			cbMetodoDePago.setModel(new DefaultComboBoxModel(new String[] {"Tarjeta", "Por Transferencia"}));
			cbMetodoDePago.setBounds(259, 348, 201, 34);
		}
		return cbMetodoDePago;
	}
	
	
	
	
	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(ac.obtenerAtletaByEmail(ic.getEmailProvisionalParaPago()) != null) {
						if(getCbMetodoDePago().getSelectedIndex() == 0) {
							pagarTarjView.setVisible(true);
						}
						else {
							pagarTransView.setVisible(true);
						}
					}		
					else {
						System.out.println("El atleta no esta registrado, por favor revise si el correo es correcto");
					}
					
				}
			});
			btnAceptar.setBounds(386, 435, 89, 23);
		}
		return btnAceptar;
	}
	
	
	
	public void reset() {
		this.cbMetodoDePago.setSelectedIndex(0);
		this.setVisible(false);
	}
	private JLabel getLblNombreAtleta() {
		if (lblNombreAtleta == null) {
			lblNombreAtleta = new JLabel("");
			lblNombreAtleta.setFont(new Font("Calibri", Font.PLAIN, 16));
			lblNombreAtleta.setBounds(48, 44, 412, 44);
		}
		return lblNombreAtleta;
	}
	private JLabel getLblCategoria() {
		if (lblCategoria == null) {
			lblCategoria = new JLabel("");
			lblCategoria.setFont(new Font("Calibri", Font.PLAIN, 16));
			lblCategoria.setBounds(48, 110, 427, 63);
		}
		return lblCategoria;
	}
	private JLabel getLblFechaInscripcion() {
		if (lblFechaInscripcion == null) {
			lblFechaInscripcion = new JLabel("");
			lblFechaInscripcion.setFont(new Font("Calibri", Font.PLAIN, 16));
			lblFechaInscripcion.setBounds(48, 196, 427, 53);
		}
		return lblFechaInscripcion;
	}
	private JLabel getLblCantidadPagar() {
		if (lblCantidadPagar == null) {
			lblCantidadPagar = new JLabel("");
			lblCantidadPagar.setFont(new Font("Calibri", Font.PLAIN, 16));
			lblCantidadPagar.setBounds(48, 260, 427, 44);
		}
		return lblCantidadPagar;
	}
	
	
	private void setText(){
		getLblNombreAtleta().setText(atleta.getNombre() + " " + atleta.getApellidos());
		getLblCategoria().setText("Compite en categoría - " + atleta.getGenero());
		getLblFechaInscripcion().setText("Fecha de la inscripcion " + ic.getActualDate());
		getLblCantidadPagar().setText("Debe abonar la cantidad de: " + ic.getPrecioInscripcion(ic.getIdProvisionalParaPago()) + " euros");
	}
}

package atleta;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import competicion.CompeticionDTO;
import inscripcion.InscripcionController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class InscripcionAtletaView extends JFrame {
	
	private AtletaController ac;
	private InscripcionController ic;
	private MetodoDePagoView metododepagoview;
	
	private CompeticionDTO competicion;
	
	private JPanel panel;
	private JLabel lblIndiqueEmail;
	private JTextField txtIndiqueEmail;
	private JButton btnAceptar;
	private JButton btnCancelar;
	
	private String email;

	public InscripcionAtletaView(CompeticionDTO competicion) {
		setResizable(false);
		
		this.competicion = competicion;
		
		ac = new AtletaController();
		ic = new InscripcionController();
		this.email = "";
		
		getContentPane().add(getPanel(), BorderLayout.CENTER);
		setBounds(100, 100, 500, 350);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getLblIndiqueEmail());
			panel.add(getTxtIndiqueEmail());
			panel.add(getBtnAceptar());
			panel.add(getBtnCancelar());
			
			JLabel lbAviso = new JLabel("Atencion, para continuar debe estar registrado.");
			lbAviso.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lbAviso.setBounds(75, 177, 352, 21);
			panel.add(lbAviso);
			
			JButton btnRegistrar = new JButton("Registrar");
			btnRegistrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setEmail(txtIndiqueEmail.getText());
					crearRegistroVentana();
				}
			});
			btnRegistrar.setMnemonic('R');
			btnRegistrar.setBounds(120, 252, 120, 21);
			panel.add(btnRegistrar);
		}
		return panel;
	}
	private JLabel getLblIndiqueEmail() {
		if (lblIndiqueEmail == null) {
			lblIndiqueEmail = new JLabel("Introduzca su email:");
			lblIndiqueEmail.setFont(new Font("Calibri", Font.PLAIN, 17));
			lblIndiqueEmail.setBounds(75, 112, 147, 43);
		}
		return lblIndiqueEmail;
	}
	private JTextField getTxtIndiqueEmail() {
		if (txtIndiqueEmail == null) {
			txtIndiqueEmail = new JTextField();
			txtIndiqueEmail.setBounds(232, 112, 198, 43);
			txtIndiqueEmail.setColumns(10);
		}
		return txtIndiqueEmail;
	}
	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ic.setEmailProvisionalParaPago(txtIndiqueEmail.getText());
					ic.setIdProvisionalParaPago(competicion.getId());

					ic.setIdMetodoDePagoProvisional(ic.getNewIdMetodoPago());
					System.out.println("El id provisional para el metodo de pago es: " + ic.getIdMetodoDePagoProvisional());
					if(ac.obtenerAtletaByEmail(ic.getEmailProvisionalParaPago()) == null) {
						JOptionPane.showMessageDialog(null, "Debe registrarse, el email no ha sido encontrado.");
					}
					else if(ic.checkAtletaInscrito(ac.obtenerAtletaByEmail(ic.getEmailProvisionalParaPago()), ic.getIdProvisionalParaPago())) {
						JOptionPane.showMessageDialog(null, "El email introducido ya esta registrado para esa competicion. No se puede registrar dos veces, intentelo de nuevo.");
					}
					else {
						ic.inscribirAtleta(ac.obtenerAtletaByEmail(ic.getEmailProvisionalParaPago()), ic.getIdProvisionalParaPago(), ic.getNewDorsal(), 13, "preinscrito", "Pre-inscrito");
						System.out.println("Inscripcion Correcta, tenga una buena tarde");
						metododepagoview = new MetodoDePagoView(ic, ac);
						metododepagoview.setVisible(true);
					}
					
				}
			});
			btnAceptar.setBounds(345, 252, 85, 21);
		}
		return btnAceptar;
	}
	
	private void crearRegistroVentana() {
		RegistroAtletaView vc = new RegistroAtletaView(this);
		// Centra la ventana registro respecto a la principal
		vc.setLocationRelativeTo(this);
		vc.setVisible(true);
	}
	
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					reset();
				}
			});
			btnCancelar.setBounds(250, 252, 85, 21);
		}
		return btnCancelar;
	}
	
	public void reset() {
		this.txtIndiqueEmail.setText("");
		setVisible(false);
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}

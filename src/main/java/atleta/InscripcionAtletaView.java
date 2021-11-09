package atleta;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JTextField;

import inscripcion.InscripcionController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class InscripcionAtletaView extends JFrame {
	
	private AtletaController ac;
	private InscripcionController ic;
	private MetodoDePagoView metododepagoview;
	
	private JPanel panel;
	private JLabel lblIndiqueEmail;
	private JTextField txtIndiqueEmail;
	private JLabel lblIndiqueCompeticion;
	private JTextField txtIndiqueCompeticion;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JLabel lbDorsal2;
	
	public InscripcionAtletaView() {
		setResizable(false);
		ac = new AtletaController();
		ic = new InscripcionController();
		
		
		getContentPane().add(getPanel(), BorderLayout.CENTER);
		setBounds(100, 100, 500, 350);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getLblIndiqueEmail());
			panel.add(getTxtIndiqueEmail());
			panel.add(getLblIndiqueCompeticion());
			panel.add(getTxtIndiqueCompeticion());
			panel.add(getBtnAceptar());
			panel.add(getBtnCancelar());
			
			JLabel lbDorsal1 = new JLabel("NOTA: Los dorsales se asignan");
			lbDorsal1.setFont(new Font("Tahoma", Font.BOLD, 12));
			lbDorsal1.setBounds(34, 265, 198, 13);
			panel.add(lbDorsal1);
			panel.add(getLbDorsal2());
		}
		return panel;
	}
	private JLabel getLblIndiqueEmail() {
		if (lblIndiqueEmail == null) {
			lblIndiqueEmail = new JLabel("Introduzca su email:");
			lblIndiqueEmail.setFont(new Font("Calibri", Font.PLAIN, 17));
			lblIndiqueEmail.setBounds(75, 66, 147, 43);
		}
		return lblIndiqueEmail;
	}
	private JTextField getTxtIndiqueEmail() {
		if (txtIndiqueEmail == null) {
			txtIndiqueEmail = new JTextField();
			txtIndiqueEmail.setBounds(232, 66, 198, 43);
			txtIndiqueEmail.setColumns(10);
		}
		return txtIndiqueEmail;
	}
	private JLabel getLblIndiqueCompeticion() {
		if (lblIndiqueCompeticion == null) {
			lblIndiqueCompeticion = new JLabel("Introduzca competicion:");
			lblIndiqueCompeticion.setFont(new Font("Calibri", Font.PLAIN, 17));
			lblIndiqueCompeticion.setBounds(75, 141, 177, 43);
		}
		return lblIndiqueCompeticion;
	}
	private JTextField getTxtIndiqueCompeticion() {
		if (txtIndiqueCompeticion == null) {
			txtIndiqueCompeticion = new JTextField();
			txtIndiqueCompeticion.setColumns(10);
			txtIndiqueCompeticion.setBounds(264, 141, 166, 43);
		}
		return txtIndiqueCompeticion;
	}
	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ic.setEmailProvisionalParaPago(txtIndiqueEmail.getText());
					ic.setIdProvisionalParaPago(Integer.parseInt(txtIndiqueCompeticion.getText()));

					metododepagoview = new MetodoDePagoView(ic, ac);
					metododepagoview.setVisible(true);
				}
			});
			btnAceptar.setBounds(345, 262, 85, 21);
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
			btnCancelar.setBounds(250, 262, 85, 21);
		}
		return btnCancelar;
	}
	
	public void reset() {
		this.txtIndiqueCompeticion.setText("");
		this.txtIndiqueEmail.setText("");
		setVisible(false);
	}
	private JLabel getLbDorsal2() {
		if (lbDorsal2 == null) {
			lbDorsal2 = new JLabel(" al final del plazo de inscripción");
			lbDorsal2.setFont(new Font("Tahoma", Font.BOLD, 12));
			lbDorsal2.setBounds(34, 277, 205, 13);
		}
		return lbDorsal2;
	}
}

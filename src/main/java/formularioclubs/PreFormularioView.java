package formularioclubs;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PreFormularioView extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private JButton btnFormulario;
	private JButton btnLeerFichero;
	private JLabel lblNumAt;
	private JSpinner spinnerNumAt;
	private JButton btnCancelar;
	private JLabel lblNewLabel;
	private JTextField txtClub;
	
	
	private int id_competicion;
	
	
	private FormularioParaClubsView fpcv;
	
	public PreFormularioView(int id_competicion) {
		
		this.id_competicion = id_competicion;
		
		setResizable(false);
		
		getContentPane().setLayout(null);
		getContentPane().add(getBtnFormulario());
		getContentPane().add(getBtnLeerFichero());
		getContentPane().add(getLblNumAt());
		getContentPane().add(getSpinnerNumAt());
		getContentPane().add(getBtnCancelar());
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getTxtClub());
		
		setBounds(0, 0, 455, 216);
	}
	
	private JButton getBtnFormulario() {
		if (btnFormulario == null) {
			btnFormulario = new JButton("Acceder al Formulario");
			btnFormulario.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(checkAllGood()) {
						fpcv = new FormularioParaClubsView(id_competicion, (Integer) spinnerNumAt.getValue());
						fpcv.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "No ha indicado el nombre del club, por favor rellene el campo y vuelva a intentarlo");
					}
				}
			});
			btnFormulario.setBounds(150, 136, 133, 21);
		}
		return btnFormulario;
	}
	
	private JButton getBtnLeerFichero() {
		if (btnLeerFichero == null) {
			btnLeerFichero = new JButton("Leer el Fichero");
			btnLeerFichero.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(checkAllGood()) {
						fpcv = new FormularioParaClubsView(id_competicion, (Integer) spinnerNumAt.getValue());
						fpcv.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "No ha indicado el nombre del club, por favor rellene el campo y vuelva a intentarlo");
					}
				}
			});
			btnLeerFichero.setBounds(293, 136, 133, 21);
		}
		return btnLeerFichero;
	}
	
	private JLabel getLblNumAt() {
		if (lblNumAt == null) {
			lblNumAt = new JLabel("Seleccione el numero de atletas que quiere inscribir:");
			lblNumAt.setFont(new Font("Calibri", Font.PLAIN, 16));
			lblNumAt.setHorizontalAlignment(SwingConstants.CENTER);
			lblNumAt.setBounds(10, 79, 365, 14);
		}
		return lblNumAt;
	}
	
	private JSpinner getSpinnerNumAt() {
		if (spinnerNumAt == null) {
			spinnerNumAt = new JSpinner();
			spinnerNumAt.setBounds(379, 75, 47, 20);
		}
		return spinnerNumAt;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
				}
			});
			btnCancelar.setBounds(10, 136, 133, 21);
		}
		return btnCancelar;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Nombre del Club:");
			lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
			lblNewLabel.setBounds(20, 30, 133, 28);
		}
		return lblNewLabel;
	}
	private JTextField getTxtClub() {
		if (txtClub == null) {
			txtClub = new JTextField();
			txtClub.setBounds(151, 27, 275, 31);
			txtClub.setColumns(10);
		}
		return txtClub;
	}
	
	public boolean checkAllGood() {
		boolean isOkey = false;
		if(!getTxtClub().getText().isEmpty()) {
			isOkey = true;
		}
		return isOkey;
	}
	
}

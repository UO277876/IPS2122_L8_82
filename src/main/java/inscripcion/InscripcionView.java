package inscripcion;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.TextArea;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class InscripcionView extends JFrame {

	private JLabel lbEmail;
	private JButton btnEmail;
	private JTextField txEmail;

	// Otros atributos
	private InscripcionController ic;
	private JScrollPane scrpListado;
	private TextArea txaListado;

	public InscripcionView() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle("Listado de inscripciones");
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setForeground(Color.WHITE);
		getContentPane().setLayout(null);
		getContentPane().add(getLbEmail());
		getContentPane().add(getBtnEmail());
		getContentPane().add(getTxEmail());
		getContentPane().add(getScrollPane_1());

		// Inicializacion de la clase InscripcionController
		this.ic = new InscripcionController();
	}

	private JLabel getLbEmail() {
		if (lbEmail == null) {
			lbEmail = new JLabel("Introduzca el email:");
			lbEmail.setLabelFor(getTxEmail());
			lbEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lbEmail.setBounds(81, 35, 150, 13);
		}
		return lbEmail;
	}

	private JButton getBtnEmail() {
		if (btnEmail == null) {
			btnEmail = new JButton("Aceptar");
			btnEmail.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					listarPorEmail();
				}
			});
			btnEmail.setBackground(new Color(0, 204, 0));
			btnEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnEmail.setForeground(Color.WHITE);
			btnEmail.setBounds(486, 32, 85, 21);
		}
		return btnEmail;
	}

	private JTextField getTxEmail() {
		if (txEmail == null) {
			txEmail = new JTextField();
			txEmail.setBounds(216, 30, 260, 27);
			txEmail.setColumns(10);
		}
		return txEmail;
	}

	private JScrollPane getScrollPane_1() {
		if (scrpListado == null) {
			scrpListado = new JScrollPane();
			scrpListado.setBounds(81, 99, 546, 255);
			scrpListado.setViewportView(getTxaListado());
		}
		return scrpListado;
	}

	private TextArea getTxaListado() {
		if (txaListado == null) {
			txaListado = new TextArea();
			txaListado.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txaListado.setBackground(UIManager.getColor("Button.light"));
			txaListado.setEditable(false);
		}
		return txaListado;
	}

	// ----------------------------- Métodos independientes de la interfaz ---------------------------------------
	/**
	 * Añade pedidos y calcula su precio total
	 */
	private void listarPorEmail() {
		// 1.Verificar que la casilla email no esta vacía
		if (isVacio()) {
			JOptionPane.showMessageDialog(null, "Error: Campo email en blanco");
		} else {
			// 2. Listo inscripciones por emails
			String email = txEmail.getText();	
			// 2.1 Compruebo que el email existe
			List<String> listado = ic.listarPorIds(email);
			
			// 3. Listo competiciones por ids de inscripciones

			// 4. Imprimo por pantalla

		}
	}

	// ----------------------------- Métodos de revision ---------------------------------------
	/**
	 * Comprueba si el campo txNombre esta vacío
	 * 
	 * @return true si lo esta y false si no
	 */
	private boolean isVacio() {
		return txEmail.getText().contentEquals("");
	}
}

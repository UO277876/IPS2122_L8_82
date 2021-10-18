package inscripcion;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.ParseException;
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
	private TextArea txaListado;

	// Otros atributos
	private InscripcionController ic;
	private JScrollPane scrpListado;

	public InscripcionView() {
		setResizable(false);
		setTitle("Listado de inscripciones");
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setForeground(Color.WHITE);
		getContentPane().setLayout(null);
		getContentPane().add(getLbEmail());
		getContentPane().add(getBtnEmail());
		getContentPane().add(getTxEmail());
		getContentPane().add(getScrollPane_1());
		setBounds(100, 100, 700, 400);

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
					try {
						listarPorEmail();
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
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
	 * @throws ParseException 
	 */
	private void listarPorEmail() throws ParseException {
		// 1.Verificar que la casilla email no esta vacía
		if (isVacio()) {
			JOptionPane.showMessageDialog(null, "Error: Campo email en blanco");
		} else {
			// 2. Listo inscripciones por emails
			String email = txEmail.getText();	
			// 2.1 Compruebo que el email existe
			List<String> listadoIns = ic.listarPorIds(email);
			
			if(listadoIns.size() <= 0) {
				getTxaListado().setText("No se han encontrado inscripciones con el email introducido.");
			} else {
				// 3. Obtengo la cadena 
				getTxaListado().setText(ic.imprimirListado(listadoIns));
			}

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

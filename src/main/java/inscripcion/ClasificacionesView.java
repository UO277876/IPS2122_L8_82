package inscripcion;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class ClasificacionesView extends JFrame {

	private JLabel lbId;
	private JButton btnID;
	private JTextField txID;
	private TextArea txaClasificacion;

	// Otros atributos
	private InscripcionController ic;
	private JScrollPane scrpClasificacion;
	private JComboBox<String> cbId;

	public ClasificacionesView() {
		setResizable(false);
		setTitle("Listado de inscripciones");
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setForeground(Color.WHITE);
		getContentPane().setLayout(null);
		getContentPane().add(getLbId());
		getContentPane().add(getBtnID());
		getContentPane().add(getTxID());
		getContentPane().add(getScrollPane_1());
		getContentPane().add(getCbId());
		setBounds(100, 100, 700, 400);

		// Inicializacion de la clase InscripcionController
		this.ic = new InscripcionController();
	}

	private JLabel getLbId() {
		if (lbId == null) {
			lbId = new JLabel("Introduzca ID:");
			lbId.setLabelFor(getTxID());
			lbId.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lbId.setBounds(81, 35, 150, 13);
		}
		return lbId;
	}

	private JButton getBtnID() {
		if (btnID == null) {
			btnID = new JButton("Aceptar");
			btnID.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					clasificar();
				}
			});
			btnID.setBackground(new Color(0, 204, 0));
			btnID.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnID.setForeground(Color.WHITE);
			btnID.setBounds(486, 32, 85, 21);
		}
		return btnID;
	}

	private JTextField getTxID() {
		if (txID == null) {
			txID = new JTextField();
			txID.setBounds(187, 30, 169, 27);
			txID.setColumns(10);
		}
		return txID;
	}

	private JScrollPane getScrollPane_1() {
		if (scrpClasificacion == null) {
			scrpClasificacion = new JScrollPane();
			scrpClasificacion.setBounds(81, 99, 546, 255);
			scrpClasificacion.setViewportView(getTxaClasificacion());
		}
		return scrpClasificacion;
	}

	private TextArea getTxaClasificacion() {
		if (txaClasificacion == null) {
			txaClasificacion = new TextArea();
			txaClasificacion.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txaClasificacion.setBackground(UIManager.getColor("Button.light"));
			txaClasificacion.setEditable(false);
		}
		return txaClasificacion;
	}

	private JComboBox<String> getCbId() {
		if (cbId == null) {
			cbId = new JComboBox<String>();
			cbId.setModel(new DefaultComboBoxModel<String>(new String[] { "Absoluta", "Genero" }));
			cbId.setBounds(376, 33, 98, 21);
		}
		return cbId;
	}

	// ----------------------------- Métodos independientes de la interfaz ---------------------------------------
	/**
	 * Clasifica a los competidores de la competicion pasada como ID
	 * 
	 * No se aceptan en el campo ID letras
	 */
	private void clasificar() {
		// 1.Verificar que la casilla email no esta vacía
		if (isVacio()) {
			JOptionPane.showMessageDialog(null, "Error: Campo ID en blanco");
		} else {
			// 2. Listo inscripciones por emails
			try {
				int id = Integer.valueOf(getTxID().getText());
				String tipo = (String) getCbId().getSelectedItem();

				// 2.1 Compruebo que el id existe
				List<String> listadoIns = ic.clasificacion(tipo, id);

				if ((listadoIns.size() <= 0 && tipo.equals("Absoluta")) || (listadoIns.size() == 2 && tipo.equals("Genero"))) {
					getTxaClasificacion().setText("No se han encontrado competiciones con el id introducido.");
				} else {
					// 3. Obtengo la cadena
					getTxaClasificacion().setText(ic.imprimirListadoClasif(listadoIns));
				}
			} catch (NumberFormatException e) {
				getTxaClasificacion().setText("Error, solo se aceptan números en el campo ID.");
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
		return txID.getText().contentEquals("");
	}

}

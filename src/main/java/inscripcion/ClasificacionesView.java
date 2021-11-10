package inscripcion;

import java.awt.Color;
import java.awt.Font;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

import competiciones.CompeticionController;
import giis.demo.util.SwingUtil;

@SuppressWarnings("serial")
public class ClasificacionesView extends JFrame {

	private JLabel lbId;
	private JButton btnID;
	private JTextField txID;

	// Otros atributos
	private InscripcionController ic;
	private CompeticionController cm;
	private JScrollPane scrpClasificacion;
	private JComboBox<String> cbId;
	private JTable tbClasificacion;

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
		setBounds(100, 100, 661, 420);

		// Inicializacion de la clase InscripcionController
		this.ic = new InscripcionController();
		this.cm = new CompeticionController();
	}

	private JLabel getLbId() {
		if (lbId == null) {
			lbId = new JLabel("Nombre de la competición:");
			lbId.setLabelFor(getTxID());
			lbId.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lbId.setBounds(21, 35, 182, 13);
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
			btnID.setBounds(542, 32, 85, 21);
		}
		return btnID;
	}

	private JTextField getTxID() {
		if (txID == null) {
			txID = new JTextField();
			txID.setBounds(213, 30, 211, 27);
			txID.setColumns(10);
		}
		return txID;
	}

	private JScrollPane getScrollPane_1() {
		if (scrpClasificacion == null) {
			scrpClasificacion = new JScrollPane();
			scrpClasificacion.setBounds(21, 87, 606, 267);
			scrpClasificacion.setViewportView(getTbClasificacion());
		}
		return scrpClasificacion;
	}

	private JComboBox<String> getCbId() {
		if (cbId == null) {
			cbId = new JComboBox<String>();
			cbId.setModel(new DefaultComboBoxModel<String>(new String[] { "Absoluta", "Genero", InscripcionDTO.SENIOR,
					InscripcionDTO.VETA, InscripcionDTO.VETB, InscripcionDTO.VETC, InscripcionDTO.VETD, InscripcionDTO.VETE }));
			cbId.setBounds(434, 33, 98, 21);
		}
		return cbId;
	}

	private JTable getTbClasificacion() {
		if (tbClasificacion == null) {
			tbClasificacion = new JTable();
		}
		return tbClasificacion;
	}

	// ----------------------------- Métodos independientes de la interfaz
	// ---------------------------------------
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
			String name = getTxID().getText();
			String tipo = (String) getCbId().getSelectedItem();

			// 2.1 Compruebo que el name existe
			if (!cm.obtenerCompeticionNameBool(name)) {
				JOptionPane.showMessageDialog(null, "No se han encontrado competiciones con el nombre introducido.");
			} else {
				List<ClasificacionDTO> listadoIns = ic.clasificacion(tipo, name);

				// 3. Obtengo la cadena
				// getTxaClasificacion().setText(ic.imprimirListadoClasif(listadoIns));
				getListaClasificaciones(listadoIns);
			}

		}

	}

	public void getListaClasificaciones(List<ClasificacionDTO> listadoIns) {
		TableModel tmodel = SwingUtil.getTableModelFromPojos(listadoIns,
				new String[] { "numero", "genero", "nombre", "tiempo"});
		getTbClasificacion().setModel(tmodel);
		SwingUtil.autoAdjustColumns(getTbClasificacion());
	}

	// ----------------------------- Métodos de revision
	// ---------------------------------------
	/**
	 * Comprueba si el campo txNombre esta vacío
	 * 
	 * @return true si lo esta y false si no
	 */
	private boolean isVacio() {
		return txID.getText().contentEquals("");
	}
}

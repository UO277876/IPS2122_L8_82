package inscripcion;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

import giis.demo.util.SwingUtil;

@SuppressWarnings("serial")
public class InscripcionView extends JFrame {

	private JLabel lbEmail;
	private JButton btnEmail;
	private JTextField txEmail;
	private JButton btnCancelarInscripcion;

	// Otros atributos
	private InscripcionController ic;
	private JScrollPane scrpListado;
	private JTable tbListado;

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
	
		getContentPane().add(getBtnCancelarIns());
		setBounds(100, 100, 700, 400);

		// Inicializacion de la clase InscripcionController
		this.ic = new InscripcionController();
	}
	
	private JButton getBtnCancelarIns() {
		if (btnCancelarInscripcion == null) {
			btnCancelarInscripcion = new JButton("Cancelar inscripción");
			btnCancelarInscripcion.setEnabled(false);
			btnCancelarInscripcion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					borrarInscripcion();
				}
			});
			btnCancelarInscripcion.setForeground(Color.WHITE);
			btnCancelarInscripcion.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnCancelarInscripcion.setBackground(Color.BLUE);
			btnCancelarInscripcion.setBounds(451, 63, 190, 21);
		}
		return btnCancelarInscripcion;
	}

	private JLabel getLbEmail() {
		if (lbEmail == null) {
			lbEmail = new JLabel("Introduzca el email:");
			lbEmail.setLabelFor(getTxEmail());
			lbEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lbEmail.setBounds(32, 35, 150, 13);
		}
		return lbEmail;
	}

	private JButton getBtnEmail() {
		if (btnEmail == null) {
			btnEmail = new JButton("Aceptar");
			btnEmail.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					listarPorEmail();
					getBtnCancelarIns().setEnabled(true);
				}
			});
			btnEmail.setBackground(new Color(0, 204, 0));
			btnEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnEmail.setForeground(Color.WHITE);
			btnEmail.setBounds(451, 32, 85, 21);
		}
		return btnEmail;
	}

	private JTextField getTxEmail() {
		if (txEmail == null) {
			txEmail = new JTextField();
			txEmail.setBounds(170, 30, 271, 27);
			txEmail.setColumns(10);
		}
		return txEmail;
	}

	private JScrollPane getScrollPane_1() {
		if (scrpListado == null) {
			scrpListado = new JScrollPane();
			scrpListado.setBackground(Color.WHITE);
			scrpListado.setBounds(32, 99, 615, 255);
			
			scrpListado.setViewportView(getTbListado());
		}
		return scrpListado;
	}
	
	private JTable getTbListado() {
		if (tbListado == null) {
			tbListado = new JTable();
		}
		return tbListado;
	}

	// ----------------------------- Métodos independientes de la interfaz ---------------------------------------
	/**
	 * Añade pedidos y calcula su precio total
	 * @throws ParseException 
	 */
	private void listarPorEmail() {
		// 1.Verificar que la casilla email no esta vacía
		if (isVacio()) {
			JOptionPane.showMessageDialog(null, "Error: Campo email en blanco");
		} else {
			// 2. Listo inscripciones por emails
			String email = txEmail.getText();	
			// 2.1 Compruebo que el email existe
			List<ListadoDTO> listadoIns = ic.listarPorIds(email);
			
			if(listadoIns.size() <= 0) {
				JOptionPane.showMessageDialog(null, "No se han encontrado inscripciones con el email introducido.");
			} else {
				// 3. Obtengo la cadena 
				getListado(listadoIns);
			}

		}
	}
	
	private void borrarInscripcion() {
		String email = txEmail.getText();	
		
		if(!checkNotSelected()) {
			ListadoDTO dto = getListado();
			boolean cancelacion = ic.hayCancelacion(dto);
			
			if(cancelacion) {
				if(confirmarCancelacion(dto)) {
					if(ic.checkEstadoCompeticion(dto)) {
						double cantidadDevuelta = ic.cancelar(dto, email);
						crearVentanaCancelacion(cantidadDevuelta);
					} else {
						JOptionPane.showMessageDialog(null, "Solo se puede cancelar donde no se ha participado.");
					}
				}
				
			} else {
				JOptionPane.showMessageDialog(null, "La inscripción seleccionada no admite cancelaciones.");
			}
			
		} else {
			JOptionPane.showMessageDialog(null, "No ha seleccionado inscripción.");
		}
	}
	
	private void crearVentanaCancelacion(double cantidadDevuelta) {
		CancelacionView vc = new CancelacionView(this,cantidadDevuelta);
		vc.setLocationRelativeTo(this);
		vc.setVisible(true);
	}
	
	/**
	 * Abre una ventana de confirmación para cancelar o no la inscripción
	 */
	private boolean confirmarCancelacion(ListadoDTO dto) {
		boolean yes = false;
		int resp = JOptionPane.showConfirmDialog(this,  "¿Está seguro de cancelar la inscripción?");
		if(resp == JOptionPane.YES_OPTION) {
			yes = true;
		}
		return yes;
	}
	
	private ListadoDTO getListado(){
		String nombre = (String) getTbListado().getValueAt(getTbListado().getSelectedRow(), 0);
		String estado = (String) getTbListado().getValueAt(getTbListado().getSelectedRow(), 1);
		String fecha = (String) getTbListado().getValueAt(getTbListado().getSelectedRow(), 2);
		String hayCancelacion = (String) getTbListado().getValueAt(getTbListado().getSelectedRow(), 3);
		ListadoDTO listado = new ListadoDTO(nombre, estado, fecha, hayCancelacion);
		return listado;
		
	}
	
	private boolean checkNotSelected() {
		for(int i = 0; i < getTbListado().getRowCount(); i++) {
			if(getTbListado().isRowSelected(i)) {
				return false;
			}
		}
		
		return true;
	}
	
	public void getListado(List<ListadoDTO> listadoIns) {
		TableModel tmodel = SwingUtil.getTableModelFromPojos(listadoIns,
				new String[] { "nombre", "estado", "fecha", "hayCancelacion" });
		getTbListado().setModel(tmodel);
		SwingUtil.autoAdjustColumns(getTbListado());
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

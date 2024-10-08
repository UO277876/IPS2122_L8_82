package competicion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import atleta.InscripcionAtletaView;
import detallesCompeticion.DetallesCompeticionView;
import formularioclubs.PreFormularioView;

import java.awt.GridLayout;

public class CompeticionView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane spCompeticiones;
	private JTable tabCompeticiones;
	private JLabel lblDisponibles;
	private JButton btnTablaCarreras;
	
	private String fechaHoy;
	
	private DetallesCompeticionView dcv;
	private InscripcionAtletaView iav;
	private CompeticionController compContr;
	private JPanel panel;
	private JButton btnDetallesCompeticion;
	private JButton btnInscripcionClubs;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CompeticionView frame = new CompeticionView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CompeticionView() {
		setTitle("Listado de Competiciones");
		setBounds(100, 100, 656, 475);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getScrollPane_1(), BorderLayout.CENTER);
		contentPane.add(getLblDisponibles(), BorderLayout.NORTH);
		contentPane.add(getPanel(), BorderLayout.SOUTH);
		
	}

	private JScrollPane getScrollPane_1() {
		if (spCompeticiones == null) {
			spCompeticiones = new JScrollPane(getTabCompeticionesForContentPane());
//			spCompeticiones.setViewportView(getTabCompeticionesForContentPane());
		}
		return spCompeticiones;
	}

	private JTable getTabCompeticionesForContentPane() {
		if (tabCompeticiones == null) {
			tabCompeticiones = new JTable();
			tabCompeticiones.setRowSelectionAllowed(true);
			tabCompeticiones.setDefaultEditor(Object.class, null);
		}
		return tabCompeticiones;
	}

	private JLabel getLblDisponibles() {
		if (lblDisponibles == null) {
			lblDisponibles = new JLabel("Competiciones disponibles:");
			lblDisponibles.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return lblDisponibles;
	}

	private JButton getBtnTablaCarrerasForContentPane() {
		if (btnTablaCarreras == null) {
			btnTablaCarreras = new JButton("APUNTARME");
			btnTablaCarreras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(checkNotSelected()) {
						JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna competicion, por favor seleccione una competicion");
					}
					else {
						CompeticionDTO competicion = getCompeticion();
						if(competicion == null) {
							JOptionPane.showMessageDialog(null, "No se ha podido encontrar la competición deseada, vuelva a intentarlo.");
						}
						else {
							iav = new InscripcionAtletaView(competicion);
							iav.setVisible(true);
						}
					}
					
				}
			});
			btnTablaCarreras.setBackground(new Color(34, 139, 34));
			btnTablaCarreras.setForeground(new Color(0, 0, 0));
		}
		return btnTablaCarreras;
	}

	public JTable getTablaCompeticiones() {
		return tabCompeticiones;
	}

	public void setFechaHoy(String fecha) {
		this.fechaHoy = fecha;
	}
	
	public String getFechaHoy() {
		return this.fechaHoy;
	}

	public JTable getTabCompeticiones() {
		return this.tabCompeticiones;
	}

	public JButton getBtnTablaCarreras() {
		return this.btnTablaCarreras;
	}
	
	public void setCompeticionController(CompeticionController cc) {
		this.compContr = cc;
	}

	
	private CompeticionDTO getCompeticion(){
		String nombre = (String) getTabCompeticionesForContentPane().getValueAt(getTabCompeticionesForContentPane().getSelectedRow(), 0);
		String fecha = (String) getTabCompeticionesForContentPane().getValueAt(getTabCompeticionesForContentPane().getSelectedRow(), 1);
		String tipo = (String) getTabCompeticionesForContentPane().getValueAt(getTabCompeticionesForContentPane().getSelectedRow(), 2);
		int distancia = (Integer) getTabCompeticionesForContentPane().getValueAt(getTabCompeticionesForContentPane().getSelectedRow(), 3);
		String fechaFin = (String) getTabCompeticionesForContentPane().getValueAt(getTabCompeticionesForContentPane().getSelectedRow(), 4);
		int numPlazas = (Integer) getTabCompeticionesForContentPane().getValueAt(getTabCompeticionesForContentPane().getSelectedRow(), 5);
		CompeticionDTO competicion = compContr.getCompeticion(nombre, fecha, tipo, distancia, fechaFin);
		return competicion;
		
	}
	
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new GridLayout(0, 3, 0, 0));
			panel.add(getBtnDetallesCompeticion());
			panel.add(getBtnTablaCarrerasForContentPane());
			panel.add(getBtnInscripcionClubs());
		}
		return panel;
	}
	private JButton getBtnDetallesCompeticion() {
		if (btnDetallesCompeticion == null) {
			btnDetallesCompeticion = new JButton("VER DETALLES");
			btnDetallesCompeticion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(checkNotSelected()) {
						JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna competicion, por favor seleccione una competicion");
					}
					else {
						CompeticionDTO competicion = getCompeticion();
						if(competicion == null) {
							JOptionPane.showMessageDialog(null, "No se ha podido encontrar la competición deseada, vuelva a intentarlo.");
						}
						else {
							dcv = new DetallesCompeticionView(competicion);
							dcv.setVisible(true);
						}
					}
				}
			});
			btnDetallesCompeticion.setBackground(new Color(30, 144, 255));
		}
		return btnDetallesCompeticion;
	}
	
	private boolean checkNotSelected() {
		for(int i = 0; i < tabCompeticiones.getRowCount(); i++) {
			if(tabCompeticiones.isRowSelected(i)) {
				return false;
			}
		}
		
		return true;
	}
	private JButton getBtnInscripcionClubs() {
		if (btnInscripcionClubs == null) {
			btnInscripcionClubs = new JButton("Inscripcion para Clubs");
			btnInscripcionClubs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					if(checkNotSelected()) {
						JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna competicion, por favor seleccione una competicion");
					}
					else {
						CompeticionDTO competicion = getCompeticion();
						if(competicion == null) {
							JOptionPane.showMessageDialog(null, "No se ha podido encontrar la competición deseada, vuelva a intentarlo.");
						}
						else {
							PreFormularioView pfv = new PreFormularioView(competicion.getId());
							pfv.setVisible(true);
						}
					}
					
				}
			});
		}
		return btnInscripcionClubs;
	}
}

package competicion;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;

public class CompeticionView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane spCompeticiones;
	private JTable tabCompeticiones;
	private JLabel lblDisponibles;

	private String fechaHoy;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getScrollPane_1(), BorderLayout.CENTER);
		contentPane.add(getLblDisponibles(), BorderLayout.NORTH);
	}

	private JScrollPane getScrollPane_1() {
		if (spCompeticiones == null) {
			spCompeticiones = new JScrollPane();
			spCompeticiones.setViewportView(getTabCompeticiones());
		}
		return spCompeticiones;
	}

	private JTable getTabCompeticiones() {
		if (tabCompeticiones == null) {
			tabCompeticiones = new JTable();
			tabCompeticiones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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

	public JTable getTablaCompeticiones() {
		return tabCompeticiones;
	}

	public void setFechaHoy(String fecha) {
		this.fechaHoy = fecha;
	}

	public String getFechaHoy() {
		return this.fechaHoy;
	}

}

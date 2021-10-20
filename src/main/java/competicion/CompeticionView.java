package competicion;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import atleta.InscripcionAtletaView;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	

	private InscripcionAtletaView iav;
	

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

		iav = new InscripcionAtletaView();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 475);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getScrollPane_1(), BorderLayout.CENTER);
		contentPane.add(getLblDisponibles(), BorderLayout.NORTH);
		contentPane.add(getBtnTablaCarrerasForContentPane(), BorderLayout.SOUTH);
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
					iav.setVisible(true);
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

}

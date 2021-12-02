package detallesCompeticion;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.BorderLayout;
import javax.swing.JTable;

import competicion.CompeticionDTO;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DetallesCompeticionView extends JFrame{
	
	
	private JScrollPane spDetalles;
	private JTable table;
	
	
	private CompeticionDTO competicion;
	private DetallesCompeticionController detallesController;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JButton btnCancelar;
	
	public DetallesCompeticionView(CompeticionDTO competicion) {
		
		this.competicion = competicion;
		this.detallesController = new DetallesCompeticionController(competicion.getId());
		
		getContentPane().add(getSpDetalles(), BorderLayout.CENTER);
		getContentPane().add(getPanel(), BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 656, 475);
	}

	private JScrollPane getSpDetalles() {
		if (spDetalles == null) {
			spDetalles = new JScrollPane((Component) null);
			spDetalles.setViewportView(getTable());
		}
		return spDetalles;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable(detallesController.getData(), detallesController.getColumnNames());
			table.setRowSelectionAllowed(true);
			table.setDefaultEditor(Object.class, null);
		}
		return table;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new GridLayout(0, 2, 0, 0));
			panel.add(getPanel_1());
			panel.add(getPanel_2());
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBackground(Color.WHITE);
		}
		return panel_1;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setBackground(Color.WHITE);
			panel_2.add(getBtnCancelar());
		}
		return panel_2;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
				}
			});
		}
		return btnCancelar;
	}
}

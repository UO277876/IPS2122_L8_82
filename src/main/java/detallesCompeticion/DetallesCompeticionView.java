package detallesCompeticion;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.BorderLayout;
import javax.swing.JTable;

import competicion.CompeticionDTO;

public class DetallesCompeticionView extends JFrame{
	
	
	private JScrollPane spDetalles;
	private JTable table;
	
	
	private CompeticionDTO competicion;
	private DetallesCompeticionController detallesController;
	
	public DetallesCompeticionView(CompeticionDTO competicion) {
		
		this.competicion = competicion;
		this.detallesController = new DetallesCompeticionController(competicion.getId());
		
		getContentPane().add(getSpDetalles(), BorderLayout.CENTER);
		
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
}

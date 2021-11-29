package formularioclubs;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class FormularioParaClubsView extends JFrame {
	
	private JScrollPane spFormulario;
	private JTable table;
	
	private FormularioController formularioController;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JButton btnInscribir;
	private JButton btnCancelar;
	private JLabel lblEspecifiqueNumAt;
	private JButton btnCrearTabla;
	private JSpinner spinnerNumAt;
	
	
	
	public FormularioParaClubsView(int id_competicion, int numAtletas) {
		
		formularioController = new FormularioController(id_competicion, numAtletas);
		
		getContentPane().add(getSpFormulario(), BorderLayout.CENTER);
		getContentPane().add(getPanel(), BorderLayout.SOUTH);
		
		setBounds(0, 0, 886, 486);
	}

	private JScrollPane getSpFormulario() {
		if (spFormulario == null) {
			spFormulario = new JScrollPane((Component) null);
			spFormulario.setViewportView(getTable());
		}
		return spFormulario;
	}
	
	private JTable getTable() {
		if (table == null) {
			table = new JTable(formularioController.getData(), formularioController.getColumnNames());
		}
		return table;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new GridLayout(1, 0, 0, 0));
			panel.add(getPanel_1());
			panel.add(getPanel_2());
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.add(getLblEspecifiqueNumAt());
			panel_1.add(getSpinnerNumAt());
			panel_1.add(getBtnCrearTabla());
		}
		return panel_1;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.add(getBtnCancelar());
			panel_2.add(getBtnInscribir());
		}
		return panel_2;
	}
	private JButton getBtnInscribir() {
		if (btnInscribir == null) {
			btnInscribir = new JButton("Inscribir");
		}
		return btnInscribir;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
		}
		return btnCancelar;
	}
	private JLabel getLblEspecifiqueNumAt() {
		if (lblEspecifiqueNumAt == null) {
			lblEspecifiqueNumAt = new JLabel("¿Cuántos atletas desea inscribir?");
		}
		return lblEspecifiqueNumAt;
	}
	private JButton getBtnCrearTabla() {
		if (btnCrearTabla == null) {
			btnCrearTabla = new JButton("Crear Formulario");
			btnCrearTabla.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					table = new JTable(formularioController.getData(), formularioController.getColumnNames());
					getContentPane().add(new JScrollPane(table));
					
				}
			});
		}
		return btnCrearTabla;
	}
	private JSpinner getSpinnerNumAt() {
		if (spinnerNumAt == null) {
			spinnerNumAt = new JSpinner();
			spinnerNumAt.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		}
		return spinnerNumAt;
	}
}

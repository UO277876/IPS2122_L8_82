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
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import atleta.AtletaController;
import atleta.MetodoDePagoView;
import inscripcion.InscripcionController;

import java.awt.Color;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.Font;

public class FormularioParaClubsView extends JFrame {
	
	private JScrollPane spFormulario;
	private JTable table;
	
	private FormularioController formularioController;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JButton btnInscribir;
	private JButton btnCancelar;
	
	private InscripcionController ic;
	private AtletaController ac;
	
	private int id_competicion;
	private JPanel panel_3;
	private JPanel pnIncidencias;
	private JLabel lblIncidencias;
	private JTextField txtIncidencias;
	private JLabel lblCorrecto;
	private JButton btnFinalizar;
	
	public FormularioParaClubsView(int id_competicion, int numAtletas) {
		getContentPane().setBackground(Color.WHITE);
		
		this.id_competicion = id_competicion;
		formularioController = new FormularioController(id_competicion, numAtletas);
		this.ic = new InscripcionController();
		this.ac = new AtletaController();
		getContentPane().add(getPanel(), BorderLayout.SOUTH);
		getContentPane().add(getPanel_3(), BorderLayout.CENTER);
		
		setBounds(0, 0, 886, 486);
	}

	private JScrollPane getSpFormulario() {
		if (spFormulario == null) {
			spFormulario = new JScrollPane((Component) null);
			spFormulario.setBackground(Color.WHITE);
			spFormulario.setViewportView(getTable());
		}
		return spFormulario;
	}
	
	private JTable getTable() {
		if (table == null) {
			table = new JTable(formularioController.getData(), formularioController.getColumnNames());
			table.setBackground(Color.WHITE);
		}
		return table;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setLayout(new GridLayout(1, 0, 0, 0));
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
			panel_2.add(getBtnInscribir());
			panel_2.add(getBtnFinalizar());
		}
		return panel_2;
	}
	private JButton getBtnInscribir() {
		if (btnInscribir == null) {
			btnInscribir = new JButton("Inscribir");
			btnInscribir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(checkAllGood()) {
						Inscribir();
					}
					else {
						JOptionPane.showMessageDialog(null, "Alguno de los campos está sin rellenas por favor revise el formulario y vuelva a intentarlo");
					}
				}
			});
		}
		return btnInscribir;
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
	
	public boolean checkAllGood() {
		for(int i = 0; i < table.getRowCount(); i++) {
			for(int j = 0; j < table.getColumnCount(); j++) {
				System.out.println(table.getValueAt(i,j));
				if(table.getValueAt(i,j) == null) {
					return false;
				}
			}
		}
		return true;
	}
	
	public void Inscribir() {
		
		for(int i = 0; i < table.getRowCount(); i++) {
			ic.setEmailProvisionalParaPago(table.getValueAt(i, 0).toString());
			ic.setIdProvisionalParaPago(id_competicion);
			ic.setIdMetodoDePagoProvisional(ic.getNewIdMetodoPago());
			

			String email = table.getValueAt(i, 0).toString();
			String nombre = table.getValueAt(i, 1).toString();
			String dni = table.getValueAt(i, 3).toString();
			String genero = table.getValueAt(i, 5).toString();
			genero = genero.toLowerCase();
			String edad = table.getValueAt(i, 4).toString();
			String apellidos = table.getValueAt(i, 2).toString();
			
			if(control(i)) {
				boolean añadido = ac.crearAtletaFechaSinModificar(email,nombre,apellidos,dni,genero,edad);
				setTexto(añadido);
				
				ic.inscribirAtleta(ac.obtenerAtletaByEmail(ic.getEmailProvisionalParaPago()), ic.getIdProvisionalParaPago(), ic.getNewDorsal(), 13, "preinscrito");
				ic.revisarDorsales(id_competicion);
				
				System.out.println("Inscripcion Correcta, tenga una buena tarde");
					
			}
			
		}
	
	}
	
	
	private boolean control(int i) {
		String listado = "";
		boolean correcto = true;
		if(table.getValueAt(i, 1).toString().equals("") ) {
			listado += ">" + "El campo nombre no puede estar vacío" + "\n";
			correcto = false;
		}
		
		if(table.getValueAt(i, 2).toString().equals("") ) {
			listado += ">" + "El campo apellidos no puede estar vacío" + "\n";
			correcto = false;
		}
		
		if(table.getValueAt(i, 3).toString().equals("")) {
			listado += ">" + "El campo dni no puede estar vacío" + "\n";
			correcto = false;
		}
		
		if(table.getValueAt(i, 0).toString().equals("")) {
			listado += ">" + "El campo email no puede estar vacío" + "\n";
			correcto = false;
		}
		
		listado += ">" + controlarFecha(i);
		
		txtIncidencias.setText(listado);
		return correcto;
	}
	
	private String controlarFecha(int i) {
		try {
			String edad = table.getValueAt(i, 4).toString();
			String[] parts = edad.split("-");
			int año = Integer.valueOf(parts[0]);
			int mes = Integer.valueOf(parts[1]);
			int dia = Integer.valueOf(parts[2]);
			
			if(año >= 1920 && mes <= 12 && mes > 0 && dia <= 31 && dia > 0 ) {
				return "Formato fecha correcto";
			} else {
				return "Parámetro fecha incorrecto";
			}
		
		} catch(NumberFormatException e ) {
			return "Formato fecha incorrecto";
		}
	}
	
	
	
	private void setTexto(boolean añadido) {
		if(añadido) {
			getLblCorrecto().setText("Registro completado correctamente");
			getBtnInscribir().setEnabled(false);
			getBtnFinalizar().setEnabled(true);
		} else {
			getLblCorrecto().setText("Ha habido un problema");
			getBtnInscribir().setEnabled(true);
			getBtnFinalizar().setEnabled(false);
		}
		
		lblCorrecto.setVisible(true);
	}
	
	
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setLayout(new GridLayout(0, 2, 0, 0));
			panel_3.add(getSpFormulario());
			panel_3.add(getPnIncidencias());
		}
		return panel_3;
	}
	private JPanel getPnIncidencias() {
		if (pnIncidencias == null) {
			pnIncidencias = new JPanel();
			pnIncidencias.setBackground(Color.WHITE);
			pnIncidencias.setLayout(null);
			pnIncidencias.add(getLblIncidencias());
			pnIncidencias.add(getTxtIncidencias());
			pnIncidencias.add(getLblCorrecto());
		}
		return pnIncidencias;
	}
	private JLabel getLblIncidencias() {
		if (lblIncidencias == null) {
			lblIncidencias = new JLabel("Incidencias");
			lblIncidencias.setFont(new Font("Calibri", Font.PLAIN, 16));
			lblIncidencias.setBounds(46, 44, 242, 30);
		}
		return lblIncidencias;
	}
	private JTextField getTxtIncidencias() {
		if (txtIncidencias == null) {
			txtIncidencias = new JTextField();
			txtIncidencias.setEditable(false);
			txtIncidencias.setBounds(46, 90, 357, 190);
			txtIncidencias.setColumns(10);
		}
		return txtIncidencias;
	}
	private JLabel getLblCorrecto() {
		if (lblCorrecto == null) {
			lblCorrecto = new JLabel("");
			lblCorrecto.setFont(new Font("Calibri", Font.PLAIN, 16));
			lblCorrecto.setBounds(46, 296, 357, 36);
		}
		return lblCorrecto;
	}
	private JButton getBtnFinalizar() {
		if (btnFinalizar == null) {
			btnFinalizar = new JButton("Finalizar");
			btnFinalizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
				}
			});
		}
		return btnFinalizar;
	}
}

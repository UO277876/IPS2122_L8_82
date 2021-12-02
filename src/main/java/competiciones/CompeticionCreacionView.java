package competiciones;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import categorias.CategoriasView;
import giis.demo.util.Util;

@SuppressWarnings("serial")
public class CompeticionCreacionView extends JFrame {
	
	private boolean cancelacion;

	private JPanel pnCancelacion;
	private JLabel lbNombre;
	private JLabel lbDorsalesReservados;
	private JLabel lbTipo;
	private JLabel lbProblemas;
	private JLabel lbPlazas;
	private JTextField txNombre;
	private JComboBox<String> cbTipo;
	private JLabel lbDescripcion;
	private JTextField txPlazas;
	private JLabel lbDistancia;
	private JTextField txDistancia;
	private JScrollPane scrollPane;
	private JTextArea txDescripcion;
	private JButton btContinuar;
	private JLabel lblFechaCompe;
	private JTextField txFecha;
	private JLabel lbLimite;

	private CompeticionController cc;
	private JScrollPane scrollPane_1;
	private JTextArea txProblemas;
	private JButton btInscripcion;
	private JButton btCancelar;
	private JButton btRegistro;
	private JLabel lbInicioIns;
	private JLabel lbFinIns;
	private JTextField txInicio;
	private JTextField txFin;
	private JTextField txDorsales;
	private JRadioButton rdSi;
	private JRadioButton rdNo;
	private JLabel lblPorcentajeDePrecio;
	private JLabel lbDisponible;
	
	private String nombreCompeticion;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txFechaLimite;
	private JTextField txPorcentaje;

	public CompeticionCreacionView() {
		setResizable(false);
		setTitle("Creación Competiciones");
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setForeground(Color.WHITE);
		getContentPane().setLayout(null);
		getContentPane().add(getLbNombre());
		getContentPane().add(getTxNombre());
		getContentPane().add(getLbTipo());
		getContentPane().add(getCbTipo());
		getContentPane().add(getLbDescripcion());
		getContentPane().add(getScrollPanel());
		getContentPane().add(getLbPlazas());
		getContentPane().add(getTxPlazas());
		getContentPane().add(getLbDistancia());
		getContentPane().add(getTxDistancia());
		getContentPane().add(getBtContinuar());
		getContentPane().add(getLblFechaCompe());
		getContentPane().add(getTxFecha());
		getContentPane().add(getScrollPane_1());
		getContentPane().add(getLbProblemas());
		getContentPane().add(getBtInscripcion());
		getContentPane().add(getBtCancelar());
		getContentPane().add(getBtRegistro());
		getContentPane().add(getLbInicioIns());
		getContentPane().add(getLbFinIns());
		getContentPane().add(getTxInicio());
		getContentPane().add(getTxFin());
		getContentPane().add(getLbDorsalesReservados());
		
		getContentPane().add(getTxDorsales());

		getContentPane().add(getPnCancelacion());

		// Inicializacion de la clase CompeticionController
		this.cc = new CompeticionController();
		this.cancelacion = false;
	}
	
	private JPanel getPnCancelacion() {
		if (pnCancelacion == null) {
			pnCancelacion = new JPanel();
			pnCancelacion.setBackground(Color.WHITE);
			pnCancelacion.setBounds(24, 386, 423, 140);
			pnCancelacion.setBorder(new TitledBorder(null, "Politica de cancelacion", TitledBorder.LEADING, TitledBorder.TOP, new Font("Arial",java.awt.Font.BOLD,12), null));
			pnCancelacion.setLayout(null);
			pnCancelacion.add(getLbLimite());
			pnCancelacion.add(getRbSi());
			pnCancelacion.add(getRbNo());
			pnCancelacion.add(getLbDisponible());
			pnCancelacion.add(getLbPorcentajePrecio());
			pnCancelacion.add(getTxFechaLimite());
			pnCancelacion.add(getTxPorcentaje());
		}
		return pnCancelacion;
	}
	
	private JTextField getTxPorcentaje() {
		if (txPorcentaje == null) {
			txPorcentaje = new JTextField();
			txPorcentaje.setText("%");
			txPorcentaje.setForeground(Color.GRAY);
			txPorcentaje.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txPorcentaje.setColumns(10);
			txPorcentaje.setBounds(173, 87, 155, 19);
			txPorcentaje.setEnabled(false);
		}
		return txPorcentaje;
	}
	
	private JLabel getLbDisponible() {
		if (lbDisponible == null) {
			lbDisponible = new JLabel("¿Estará disponible?");
			lbDisponible.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lbDisponible.setBounds(22, 29, 126, 13);
		}
		return lbDisponible;
	}
	
	private JLabel getLbPorcentajePrecio() {
		if (lblPorcentajeDePrecio == null) {
			lblPorcentajeDePrecio = new JLabel("Porcentaje de precio:");
			lblPorcentajeDePrecio.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblPorcentajeDePrecio.setDisplayedMnemonic('F');
			lblPorcentajeDePrecio.setBounds(22, 85, 117, 21);
			lblPorcentajeDePrecio.setLabelFor(txPorcentaje);
		}
		return lblPorcentajeDePrecio;
	}
	
	private JTextField getTxFechaLimite() {
		if (txFechaLimite == null) {
			txFechaLimite = new JTextField();
			txFechaLimite.setText("YYYY-MM-DD");
			txFechaLimite.setForeground(Color.GRAY);
			txFechaLimite.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txFechaLimite.setColumns(10);
			txFechaLimite.setBounds(173, 55, 155, 19);
			txFechaLimite.setEnabled(false);
		}
		return txFechaLimite;
	}
	
	private JLabel getLbLimite() {
		if (lbLimite == null) {
			lbLimite = new JLabel("Fecha límite:");
			lbLimite.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lbLimite.setDisplayedMnemonic('F');
			lbLimite.setBounds(22, 56, 117, 19);
			lbLimite.setLabelFor(txFechaLimite);
		}
		return lbLimite;
	}
	
	private JRadioButton getRbSi() {
		if(rdSi == null) {
			rdSi = new JRadioButton("Si");
			rdSi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setCancelacion(true);
					getTxFechaLimite().setEnabled(true);
					getTxPorcentaje().setEnabled(true);
				}
			});
			buttonGroup.add(rdSi);
			rdSi.setBackground(Color.WHITE);
			rdSi.setForeground(Color.BLACK);
			rdSi.setFont(new Font("Tahoma", Font.BOLD, 12));
			rdSi.setBounds(173, 25, 47, 21);
		}
		return rdSi;
	}
	
	private void setCancelacion(boolean cancelacion) {
		this.cancelacion = cancelacion;
	}
	
	private JRadioButton getRbNo() {
		if(rdNo == null) {
			rdNo = new JRadioButton("No");
			rdNo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cancelacionNo();
				}
			});
			buttonGroup.add(rdNo);
			rdNo.setFont(new Font("Tahoma", Font.BOLD, 12));
			rdNo.setBackground(Color.WHITE);
			rdNo.setBounds(234, 25, 62, 21);
			rdNo.setSelected(true);
		}
		return rdNo;
	}
	
	private void cancelacionNo() {
		setCancelacion(false);
		getTxFechaLimite().setEnabled(false);
		getTxPorcentaje().setEnabled(false);
	}

	private JLabel getLbNombre() {
		if (lbNombre == null) {
			lbNombre = new JLabel("Nombre:");
			lbNombre.setDisplayedMnemonic('N');
			lbNombre.setLabelFor(getTxNombre());
			lbNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lbNombre.setBounds(24, 35, 70, 13);
		}
		return lbNombre;
	}

	private JLabel getLbProblemas() {
		if (lbProblemas == null) {
			lbProblemas = new JLabel("Incidencias:");
			lbProblemas.setDisplayedMnemonic('I');
			lbProblemas.setLabelFor(txProblemas);
			lbProblemas.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lbProblemas.setBounds(494, 32, 81, 19);
		}
		return lbProblemas;
	}
	
	private JLabel getLbDorsalesReservados() {
		if(lbDorsalesReservados == null) {
		lbDorsalesReservados = new JLabel("Dorsales reservados:");
		lbDorsalesReservados.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbDorsalesReservados.setDisplayedMnemonic('r');
		lbDorsalesReservados.setBounds(24, 345, 168, 18);
		}
		return lbDorsalesReservados;
	}
	
	private JLabel getLbPlazas() {
		if (lbPlazas == null) {
			lbPlazas = new JLabel("Número de plazas:");
			lbPlazas.setDisplayedMnemonic('p');
			lbPlazas.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lbPlazas.setBounds(24, 114, 127, 13);
			lbPlazas.setLabelFor(getTxPlazas());
		}
		return lbPlazas;
	}

	private JScrollPane getScrollPanel() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(245, 243, 155, 80);
			scrollPane.setViewportView(getTxDescripcion());
		}
		return scrollPane;
	}

	private JButton getBtContinuar() {
		if (btContinuar == null) {
			btContinuar = new JButton("Continuar");
			btContinuar.setEnabled(false);
			btContinuar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					reset();
					if (nombreCompeticion != null)
						try {
							CategoriasView dialog = new CategoriasView(nombreCompeticion, cc);
							dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
							dialog.setVisible(true);
						} catch (Exception ex) {
							ex.printStackTrace();
						}
				}
			});
			btContinuar.setForeground(Color.WHITE);
			btContinuar.setBackground(new Color(51, 204, 0));
			btContinuar.setFont(new Font("Tahoma", Font.BOLD, 13));
			btContinuar.setMnemonic('n');
			btContinuar.setBounds(800, 531, 117, 28);
		}
		return btContinuar;
	}

	private JTextArea getTxDescripcion() {
		if (txDescripcion == null) {
			txDescripcion = new JTextArea();
			txDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		}

		return txDescripcion;
	}
	
	private JTextField getTxDorsales() {
		if(txDorsales == null) {
			txDorsales = new JTextField();
			getLbDorsalesReservados().setLabelFor(txDorsales);
			txDorsales.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txDorsales.setColumns(10);
			txDorsales.setBounds(245, 341, 155, 28);
		}
		
		return txDorsales;
	}
	
	private JTextField getTxPlazas() {
		if (txPlazas == null) {
			txPlazas = new JTextField();
			txPlazas.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txPlazas.setColumns(10);
			txPlazas.setBounds(245, 107, 155, 28);
		}
		return txPlazas;
	}

	private JLabel getLbTipo() {
		if (lbTipo == null) {
			lbTipo = new JLabel("Tipo:");
			lbTipo.setDisplayedMnemonic('T');
			lbTipo.setLabelFor(getCbTipo());
			lbTipo.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lbTipo.setBounds(24, 68, 70, 19);
		}
		return lbTipo;
	}

	private JTextField getTxNombre() {
		if (txNombre == null) {
			txNombre = new JTextField();
			txNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txNombre.setBounds(245, 28, 155, 28);
			txNombre.setColumns(10);
			setBounds(100, 100, 974, 621);
		}
		return txNombre;
	}

	private JComboBox<String> getCbTipo() {
		if (cbTipo == null) {
			cbTipo = new JComboBox<String>();
			cbTipo.setFont(new Font("Tahoma", Font.PLAIN, 13));
			cbTipo.setModel(new DefaultComboBoxModel<String>(new String[] { "Asfalto", "Montaña" }));
			cbTipo.setBounds(245, 66, 156, 21);
		}
		return cbTipo;
	}

	private JLabel getLbDescripcion() {
		if (lbDescripcion == null) {
			lbDescripcion = new JLabel("Descripción:");
			lbDescripcion.setDisplayedMnemonic('e');
			lbDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lbDescripcion.setBounds(24, 266, 96, 18);
			lbDescripcion.setLabelFor(getTxDescripcion());
		}
		return lbDescripcion;
	}

	private JLabel getLbDistancia() {
		if (lbDistancia == null) {
			lbDistancia = new JLabel("Distancia:");
			lbDistancia.setDisplayedMnemonic('D');
			lbDistancia.setLabelFor(getTxDistancia());
			lbDistancia.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lbDistancia.setBounds(24, 157, 88, 19);
		}
		return lbDistancia;
	}

	private JTextField getTxDistancia() {
		if (txDistancia == null) {
			txDistancia = new JTextField();
			txDistancia.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txDistancia.setColumns(10);
			txDistancia.setBounds(245, 153, 155, 28);
		}
		return txDistancia;
	}

	private JLabel getLblFechaCompe() {
		if (lblFechaCompe == null) {
			lblFechaCompe = new JLabel("Fecha de la competición:");
			lblFechaCompe.setDisplayedMnemonic('F');
			lblFechaCompe.setLabelFor(getTxFecha());
			lblFechaCompe.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblFechaCompe.setBounds(24, 207, 168, 19);
		}
		return lblFechaCompe;
	}

	private JTextField getTxFecha() {
		if (txFecha == null) {
			txFecha = new JTextField();
			txFecha.setForeground(Color.GRAY);
			txFecha.setText("YYYY-MM-DD");
			txFecha.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txFecha.setColumns(10);
			txFecha.setBounds(245, 198, 155, 28);
		}
		return txFecha;
	}

	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(494, 67, 423, 116);

			txProblemas = new JTextArea();
			txProblemas.setEditable(false);
			txProblemas.setFont(new Font("Tahoma", Font.PLAIN, 13));
			scrollPane_1.setViewportView(txProblemas);
		}
		return scrollPane_1;
	}

	private JButton getBtInscripcion() {
		if (btInscripcion == null) {
			btInscripcion = new JButton("Configurar inscripciones");
			btInscripcion.setEnabled(false);
			btInscripcion.setMnemonic('C');
			btInscripcion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

				}
			});
			btInscripcion.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btInscripcion.setBounds(494, 278, 176, 21);
		}
		return btInscripcion;
	}

	private JButton getBtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton("Cancelar");
			btCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					reset();
				}
			});
			btCancelar.setMnemonic('C');
			btCancelar.setForeground(Color.WHITE);
			btCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
			btCancelar.setBackground(new Color(153, 0, 0));
			btCancelar.setBounds(687, 531, 96, 28);
		}
		return btCancelar;
	}

	private void reset() {
		allEnabled();
		this.getTxPlazas().setText("");
		this.getTxNombre().setText("");
		this.getTxDescripcion().setText("");
		this.getTxFecha().setText("YYYY-MM-DD");
		this.getTxDistancia().setText("");
		this.getBtContinuar().setEnabled(false);
		this.getBtRegistro().setEnabled(true);
		this.txProblemas.setText("");
		getTxFin().setText("YYYY-MM-DD");
		getTxInicio().setText("YYYY-MM-DD");
		getTxDorsales().setText("");
		cancelacionNo();
		getTxFechaLimite().setText("YYYY-MM-DD");
		getTxPorcentaje().setText("%");
		getRbNo().setSelected(true);

		setVisible(false);
	}

	private JButton getBtRegistro() {
		if (btRegistro == null) {
			btRegistro = new JButton("Registro");
			btRegistro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					nombreCompeticion = crearCompeticion();
				}
			});
			btRegistro.setMnemonic('R');
			btRegistro.setForeground(Color.WHITE);
			btRegistro.setFont(new Font("Tahoma", Font.BOLD, 13));
			btRegistro.setBackground(Color.BLUE);

			btRegistro.setBounds(494, 309, 96, 28);

		}
		return btRegistro;
	}

	// ----------------------------- Métodos independientes de la interfaz
	// ---------------------------------------
	private String crearCompeticion() {
		try {
			String nombre = getTxNombre().getText();
			String descripcion = getTxDescripcion().getText();
			String tipo = (String) getCbTipo().getSelectedItem();
			int numPlazas = Integer.valueOf(getTxPlazas().getText());
			int distancia = Integer.valueOf(getTxDistancia().getText());
			String fecha = getTxFecha().getText();
			String inicio = getTxInicio().getText();
			String fin = getTxFin().getText();
			int dorsalesReservados = Integer.valueOf(getTxDorsales().getText());

			if (comprobacion(numPlazas, distancia, dorsalesReservados)) {
				boolean correcto = false;
				
				if(getCancelacion()) {
					String fechaLimite = getTxFechaLimite().getText();
					int porcentaje = Integer.valueOf(getTxPorcentaje().getText());
					
					if(comprobacionCancelacion(porcentaje)) {
						correcto = cc.addCompeticionConCancelacion(nombre, descripcion, fecha, numPlazas, distancia, tipo, inicio,
								fin,true,porcentaje,fechaLimite,dorsalesReservados);
						return ifCorrecto(nombre, correcto);
					}
					
				} else {
					// NOTA: Cuando no hay cancelación, se pone por defecto a porcentaje 0.0
					// y a fecha límite 2
					correcto = cc.addCompeticionConCancelacion(nombre, descripcion, fecha, numPlazas, distancia, tipo, inicio,
							fin,true,0,"2021-12-12",dorsalesReservados);
					return ifCorrecto(nombre, correcto);
				}

			}
			
			} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "No puede introducir caracteres en cuadros con valores numéricos");
		}
		return null;
		
	}
	
	private boolean fechasLimite(String fecha, String inicio, String fin) {
		Date fecha1 = Util.isoStringToDate(fecha);
		Date inicio2 = Util.isoStringToDate(inicio);
		Date fin2 = Util.isoStringToDate(fin);

		if (fecha1.after(inicio2) && fecha1.after(fin2) && fin2.after(inicio2)) {
			return true;
		} else {
			return false;
		}
	}
	
	private boolean fechasLimiteCancelacion(String fecha, String cancelacion) {
		Date fecha1 = Util.isoStringToDate(fecha);
		Date cancelacion2 = Util.isoStringToDate(cancelacion);

		if (fecha1.after(cancelacion2)) {
			return true;
		} else {
			return false;
		}
	}

	private String ifCorrecto(String nombre, boolean correcto) {
		if (correcto) {
			getBtContinuar().setEnabled(true);
			getBtRegistro().setEnabled(false);
			txProblemas.setText("Se ha añadido correctamente");
			allDiasabled();
			return nombre;
		} else {
			getBtContinuar().setEnabled(false);
			getBtRegistro().setEnabled(true);
			txProblemas.setText("No se pudo añadir correctamente");
			return null;
		}
	}

	private void allDiasabled() {
		this.getTxPlazas().setEnabled(false);
		this.getTxNombre().setEnabled(false);
		this.getTxDescripcion().setEnabled(false);
		this.getTxFecha().setEnabled(false);
		this.getTxDistancia().setEnabled(false);
		getBtContinuar().setEnabled(true);
		getBtRegistro().setEnabled(false);
		getTxFin().setEnabled(false);
		getTxInicio().setEnabled(false);
		
		getTxFechaLimite().setEnabled(false);
		getTxPorcentaje().setEnabled(false);
		
		getRbSi().setEnabled(false);
		getRbNo().setEnabled(false);
		
	}

	private void allEnabled() {
		this.getTxPlazas().setEnabled(true);
		this.getTxNombre().setEnabled(true);
		this.getTxDescripcion().setEnabled(true);
		this.getTxFecha().setEnabled(true);
		this.getTxDistancia().setEnabled(true);
		getBtContinuar().setEnabled(true);
		getBtRegistro().setEnabled(true);
		getTxFin().setEnabled(true);
		getTxInicio().setEnabled(true);
		
		getRbSi().setEnabled(true);
		getRbNo().setEnabled(true);
		
	}

	private boolean comprobacion(int numPlazas, int distancia, int dorsales) {
		String listado = "";
		boolean correcto = true;

		if (isVacio()) {
			listado += "> " + "El campo nombre o fecha no puede estar vacío" + "\n";
			correcto = false;
		}

		if (numPlazas < 0) {
			listado += "> " + "El número de plazas debe ser mayor que 0" + "\n";
			correcto = false;
		}

		if (distancia < 0) {
			listado += "> " + "La distancia debe ser mayor que 0" + "\n";
			correcto = false;
		}
		
		if(dorsales > numPlazas || dorsales < 0) {
			listado += ">" + "El número de dorsales reservados debe ser menor que el número de plazas" + "\n";
			correcto = false;
		}
		
		if (!controlarFecha(getTxFecha().getText()) || !controlarFecha(getTxInicio().getText())
				|| !controlarFecha(getTxFin().getText())) {
			correcto = false;
		} else {
			if(!fechasLimite(getTxFecha().getText(), getTxInicio().getText(), getTxFin().getText())) {
				listado += "> " + "Las fechas de inicio y fin de inscripciones deben ser menores\n a la "
						+ "de la competición" + "\n";
				correcto = false;
			}
		}

		listado += controlarFecha(getTxFecha().getText(), "fecha");
		listado += controlarFecha(getTxInicio().getText(), "fecha de inicio de inscripción");
		listado += controlarFecha(getTxFin().getText(), "fecha de fin de inscripción");

		txProblemas.setText(listado);
		return correcto;
	}
	
	private boolean comprobacionCancelacion(double porcentaje) {
		boolean correcto = true;
		String listado = "";
		
		if (!controlarFecha(getTxFechaLimite().getText())) {
			correcto = false;
		} else {
			if(!fechasLimiteCancelacion(getTxFecha().getText(), getTxFechaLimite().getText())) {
				listado += "> " + "La fecha de cancelación\n" + "debe ser menor a la "
						+ "de la competición" + "\n";
				correcto = false;
			}
		}
		
		listado += controlarFecha(getTxFechaLimite().getText(), "fecha de límite de cancelación");
		
		if (porcentaje < 0 && porcentaje > 100) {
			listado += "> " + "El porcentaje debe ser mayor que 0 y menor que 100" + "\n";
			correcto = false;
		}
		
		txProblemas.setText(listado);
		return correcto;
		
	}
	
	private boolean getCancelacion() {
		return this.cancelacion;
	}

	private boolean controlarFecha(String fecha) {
		try {
			String[] parts = fecha.split("-");
			int año = Integer.valueOf(parts[0]);
			int mes = Integer.valueOf(parts[1]);
			int dia = Integer.valueOf(parts[2]);

			if (año >= 2021 && mes <= 12 && mes > 0 && dia <= 31 && dia > 0) {
				return true;
			} else {
				return false;
			}

		} catch (NumberFormatException e) {
			return false;
		}

	}

	private String controlarFecha(String fecha, String tipo) {
		try {
			String[] parts = fecha.split("-");
			int año = Integer.valueOf(parts[0]);
			int mes = Integer.valueOf(parts[1]);
			int dia = Integer.valueOf(parts[2]);

			if (año >= 2021 && mes <= 12 && mes > 0 && dia <= 31 && dia > 0) {
				return "";
			} else {
				return "> Parámetro " + tipo + " incorrecto" + "\n";
			}

		} catch (NumberFormatException e) {
			return "> Formato " + tipo + " incorrecto" + "\n";
		}

	}

	// ----------------------------- Métodos de revision
	// ---------------------------------------
	/**
	 * Comprueba si el campo txNombre esta vacío
	 * 
	 * @return true si lo esta y false si no
	 */
	private boolean isVacio() {
		return txNombre.getText().contentEquals("") || txFecha.getText().contentEquals("");
	}
 
	private JLabel getLbInicioIns() {
		if (lbInicioIns == null) {
			lbInicioIns = new JLabel("Inicio inscripción:");
			lbInicioIns.setLabelFor(getTxInicio());
			lbInicioIns.setFont(new Font("Tahoma", Font.PLAIN, 15));

			lbInicioIns.setDisplayedMnemonic('I');
			lbInicioIns.setBounds(494, 207, 117, 19);
		}
		return lbInicioIns;
	}

	private JLabel getLbFinIns() {
		if (lbFinIns == null) {
			lbFinIns = new JLabel("Fin inscripción:");
			lbFinIns.setLabelFor(getTxFin());
			lbFinIns.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lbFinIns.setDisplayedMnemonic('F');

			lbFinIns.setBounds(494, 244, 117, 19);
		}
		return lbFinIns;
	}

	private JTextField getTxInicio() {
		if (txInicio == null) {
			txInicio = new JTextField();
			txInicio.setText("YYYY-MM-DD");
			txInicio.setForeground(Color.GRAY);
			txInicio.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txInicio.setColumns(10);
			txInicio.setBounds(628, 203, 155, 28);
		}
		return txInicio;
	}

	private JTextField getTxFin() {
		if (txFin == null) {
			txFin = new JTextField();
			txFin.setText("YYYY-MM-DD");
			txFin.setForeground(Color.GRAY);
			txFin.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txFin.setColumns(10);
			txFin.setBounds(628, 240, 155, 28);
		}
		return txFin;
	}
}

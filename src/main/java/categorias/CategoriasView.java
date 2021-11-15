package categorias;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import competiciones.CompeticionController;
import competiciones.CompeticionDTO;

public class CategoriasView extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pnCategorias;
	private JLabel lblPrimeraCategoria;
	private JLabel lblSegundaCategoria;
	private JLabel lblTerceraCategoria;
	private JLabel lblCuartaCategoria;
	private JLabel lblQuintaCategoria;
	private JTextField txtPrimeraCategoria;
	private JButton btnAñadirCategoria;
	private JLabel lblEspecifiqueLasEdades;
	private int edadPrimeraCategoria = 35;
	private JTextField txtSegundaCategoria;
	private JTextField txtTerceraCategoria;
	private JTextField txtCuartaCategoria;
	private JTextField txtQuintaCategoria;
	private JLabel lblInfo;
	private JLabel lblInfo2;
	private JPanel pnGeneros;
	private JRadioButton rdbtnEspecificarGenero;
	private JRadioButton rdbtnNoDiferenciarCategorias;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnTerminar;

	private String nombreCompeticion;
	private CompeticionController cc;

	/**
	 * Create the dialog.
	 * 
	 * @param cc
	 * @param nombre
	 */
	public CategoriasView(String nombre, CompeticionController cc) {
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 601, 348);
		getContentPane().setLayout(null);
		getContentPane().add(getPanel_1());
		getContentPane().add(getPanel_1_1());
		getContentPane().add(getBtnTerminar());
		this.nombreCompeticion = nombre;
		this.cc = cc;
	}

	private JPanel getPanel_1() {
		if (pnCategorias == null) {
			pnCategorias = new JPanel();
			pnCategorias.setBackground(Color.WHITE);
			pnCategorias.setBounds(10, 10, 567, 193);
			pnCategorias.setLayout(null);
			pnCategorias.add(getLblPrimeraCategoria());
			pnCategorias.add(getLblSegundaCategoria());
			pnCategorias.add(getLblTerceraCategoria());
			pnCategorias.add(getLblCuartaCategoria());
			pnCategorias.add(getLblQuintaCategoria());
			pnCategorias.add(getBtnAñadirCategoria());
			pnCategorias.add(getLblEspecifiqueLasEdades());
			pnCategorias.add(getTxtPrimeraCategoria());
			pnCategorias.add(getTxtSegundaCategoria());
			pnCategorias.add(getTxtTerceraCategoria());
			pnCategorias.add(getTxtCuartaCategoria());
			pnCategorias.add(getTxtQuintaCategoria());
			pnCategorias.add(getLblInfo());
			pnCategorias.add(getLblInfo2());
		}
		return pnCategorias;
	}

	/**
	 * Label que tiene el texto "Primera categoria:".
	 * 
	 * @return
	 */
	private JLabel getLblPrimeraCategoria() {
		if (lblPrimeraCategoria == null) {
			lblPrimeraCategoria = new JLabel("Primera categoria:");
			lblPrimeraCategoria.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblPrimeraCategoria.setBounds(10, 43, 109, 20);
		}
		return lblPrimeraCategoria;
	}

	/**
	 * Label que tiene el texto "Segunda categoria:".
	 * 
	 * @return
	 */
	private JLabel getLblSegundaCategoria() {
		if (lblSegundaCategoria == null) {
			lblSegundaCategoria = new JLabel("Segunda categoria:");
			lblSegundaCategoria.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblSegundaCategoria.setBounds(10, 73, 123, 20);
			lblSegundaCategoria.setVisible(false);
		}
		return lblSegundaCategoria;
	}

	/**
	 * Label que tiene el texto "Tercera categoria:".
	 * 
	 * @return
	 */
	private JLabel getLblTerceraCategoria() {
		if (lblTerceraCategoria == null) {
			lblTerceraCategoria = new JLabel("Tercera categoria:");
			lblTerceraCategoria.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblTerceraCategoria.setBounds(10, 103, 123, 20);
			lblTerceraCategoria.setVisible(false);
		}
		return lblTerceraCategoria;
	}

	/**
	 * Label que tiene el texto "Cuarta categoria:".
	 * 
	 * @return
	 */
	private JLabel getLblCuartaCategoria() {
		if (lblCuartaCategoria == null) {
			lblCuartaCategoria = new JLabel("Cuarta categoria:");
			lblCuartaCategoria.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblCuartaCategoria.setBounds(10, 133, 123, 20);
			lblCuartaCategoria.setVisible(false);
		}
		return lblCuartaCategoria;
	}

	/**
	 * Label que tiene el texto "Quinta categoria:".
	 * 
	 * @return
	 */
	private JLabel getLblQuintaCategoria() {
		if (lblQuintaCategoria == null) {
			lblQuintaCategoria = new JLabel("Quinta categoria:");
			lblQuintaCategoria.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblQuintaCategoria.setBounds(10, 163, 123, 20);
			lblQuintaCategoria.setVisible(false);
		}
		return lblQuintaCategoria;
	}

	/**
	 * Texto con la información relativa a la edad límite de la primera categoria.
	 * Por defecto pone la edad especificada en edadPrimeraCategoria.
	 * 
	 * @return
	 */
	private JTextField getTxtPrimeraCategoria() {
		if (txtPrimeraCategoria == null) {
			txtPrimeraCategoria = new JTextField();
			txtPrimeraCategoria.setColumns(10);
			txtPrimeraCategoria.setBounds(160, 45, 109, 19);
			txtPrimeraCategoria.setText(Integer.toString(edadPrimeraCategoria));
		}
		if (!this.isEdadValida(txtPrimeraCategoria.getText())) {
			JOptionPane.showMessageDialog(null, "Número no válido para la primera categoria.");
		}
		return txtPrimeraCategoria;
	}

	/**
	 * Texto con la información relativa a la edad límite de la segunda categoria.
	 * Por defecto pone la edad especificada en 5 años más que txtPrimeraCategoria.
	 * 
	 * @return
	 */
	private JTextField getTxtSegundaCategoria() {
		if (txtSegundaCategoria == null) {
			txtSegundaCategoria = new JTextField();
			txtSegundaCategoria.setColumns(10);
			txtSegundaCategoria.setBounds(160, 75, 109, 19);
			txtSegundaCategoria.setVisible(false);
		}
		int edadPorDefecto = Integer.valueOf(txtPrimeraCategoria.getText()) + 5;
		txtSegundaCategoria.setText(Integer.toString(edadPorDefecto));
		if (!this.isEdadValida(txtSegundaCategoria.getText())) {
			JOptionPane.showMessageDialog(null, "Número no válido para la segunda categoria.");
		}
		return txtSegundaCategoria;
	}

	/**
	 * Texto con la información relativa a la edad límite de la tercera categoria.
	 * Por defecto pone la edad especificada en 5 años más que txtSegundaCategoria.
	 * 
	 * @return
	 */
	private JTextField getTxtTerceraCategoria() {
		if (txtTerceraCategoria == null) {
			txtTerceraCategoria = new JTextField();
			txtTerceraCategoria.setColumns(10);
			txtTerceraCategoria.setBounds(160, 105, 109, 19);
			txtTerceraCategoria.setVisible(false);
		}
		int edadPorDefecto = Integer.valueOf(txtSegundaCategoria.getText()) + 5;
		txtTerceraCategoria.setText(Integer.toString(edadPorDefecto));
		if (!this.isEdadValida(txtTerceraCategoria.getText())) {
			JOptionPane.showMessageDialog(null, "Número no válido para la tecera categoria.");
		}
		return txtTerceraCategoria;
	}

	/**
	 * Texto con la información relativa a la edad límite de la cuarta categoria.
	 * Por defecto pone la edad especificada en 5 años más que txtTerceraCategoria.
	 * 
	 * @return
	 */
	private JTextField getTxtCuartaCategoria() {
		if (txtCuartaCategoria == null) {
			txtCuartaCategoria = new JTextField();
			txtCuartaCategoria.setColumns(10);
			txtCuartaCategoria.setBounds(160, 135, 109, 19);
			txtCuartaCategoria.setVisible(false);
		}
		int edadPorDefecto = Integer.valueOf(txtTerceraCategoria.getText()) + 5;
		txtCuartaCategoria.setText(Integer.toString(edadPorDefecto));
		if (!this.isEdadValida(txtCuartaCategoria.getText())) {
			JOptionPane.showMessageDialog(null, "Número no válido para la cuarta categoria.");
		}
		return txtCuartaCategoria;
	}

	/**
	 * Texto con la información relativa a la edad límite de la quinta categoria.
	 * Por defecto pone la edad especificada en 5 años más que txtCuartaCategoria.
	 * 
	 * @return
	 */
	private JTextField getTxtQuintaCategoria() {
		if (txtQuintaCategoria == null) {
			txtQuintaCategoria = new JTextField();
			txtQuintaCategoria.setColumns(10);
			txtQuintaCategoria.setBounds(160, 165, 109, 19);
			txtQuintaCategoria.setVisible(false);
		}
		int edadPorDefecto = Integer.valueOf(txtCuartaCategoria.getText()) + 5;
		txtQuintaCategoria.setText(Integer.toString(edadPorDefecto));
		if (!this.isEdadValida(txtQuintaCategoria.getText())) {
			JOptionPane.showMessageDialog(null, "Número no válido para la quinta categoria.");
		}
		return txtQuintaCategoria;
	}

	/**
	 * Pone en visible la siguiente categoria. Después, si no va a haber más, se
	 * deshabilita.
	 * 
	 * @return
	 */
	private JButton getBtnAñadirCategoria() {
		if (btnAñadirCategoria == null) {
			btnAñadirCategoria = new JButton("Añadir categoria");
			btnAñadirCategoria.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// obtiene la siguiente txt y lbl y los hace visibles
					JTextField siguienteTxt = getSiguienteTxt();
					siguienteTxt.setVisible(true);
					JLabel siguienteLbl = getSiguienteLbl();
					siguienteLbl.setVisible(true);

					// si no hay más categoias posibles, se deshabilita
					if (!isNext())
						btnAñadirCategoria.setEnabled(false);
				}
			});
			btnAñadirCategoria.setForeground(Color.WHITE);
			btnAñadirCategoria.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnAñadirCategoria.setBackground(Color.BLUE);
			btnAñadirCategoria.setBounds(425, 38, 132, 30);
		}
		return btnAñadirCategoria;
	}

	/**
	 * Devuelve true si es posible añadir más categorias y false si no.
	 * @return
	 */
	private boolean isNext() {
		return getSiguienteTxt() != null;
	}

	private JTextField getSiguienteTxt() {
		if (!this.txtSegundaCategoria.isVisible())
			return this.getTxtSegundaCategoria();
		if (!this.txtTerceraCategoria.isVisible())
			return this.getTxtTerceraCategoria();
		if (!this.txtCuartaCategoria.isVisible())
			return this.getTxtCuartaCategoria();
		if (!this.txtQuintaCategoria.isVisible())
			return this.getTxtQuintaCategoria();
		return null;
	}

	private JLabel getSiguienteLbl() {
		if (!this.lblSegundaCategoria.isVisible())
			return this.lblSegundaCategoria;
		if (!this.lblTerceraCategoria.isVisible())
			return this.lblTerceraCategoria;
		if (!this.lblCuartaCategoria.isVisible())
			return this.lblCuartaCategoria;
		if (!this.lblQuintaCategoria.isVisible())
			return this.lblQuintaCategoria;
		return null;
	}

	private JLabel getLblEspecifiqueLasEdades() {
		if (lblEspecifiqueLasEdades == null) {
			lblEspecifiqueLasEdades = new JLabel("Especifique el límite de edad de las categorías que desea:");
			lblEspecifiqueLasEdades.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblEspecifiqueLasEdades.setBounds(10, 10, 349, 20);
		}
		return lblEspecifiqueLasEdades;
	}

	private JLabel getLblInfo() {
		if (lblInfo == null) {
			lblInfo = new JLabel("*Automáticamente se establece una última");
			lblInfo.setForeground(Color.GRAY);
			lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblInfo.setBounds(305, 135, 252, 20);
		}
		return lblInfo;
	}

	private JLabel getLblInfo2() {
		if (lblInfo2 == null) {
			lblInfo2 = new JLabel("categoria para las edades superiores.");
			lblInfo2.setForeground(Color.GRAY);
			lblInfo2.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblInfo2.setBounds(337, 165, 220, 17);
		}
		return lblInfo2;
	}

	private boolean isEdadValida(String edad) {
		try {
			return Integer.valueOf(edad) < 100 && Integer.valueOf(edad) > 18;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Introduzca un número.");
		}
		return false;

	}

	/**
	 * JPanel que contiene rdbtnEspecificarGenero y rdbtnNoDiferenciarCategorias.
	 * 
	 * @return pnGeneros
	 */
	private JPanel getPanel_1_1() {
		if (pnGeneros == null) {
			pnGeneros = new JPanel();
			pnGeneros.setBackground(Color.WHITE);
			pnGeneros.setBounds(10, 213, 294, 71);
			pnGeneros.setLayout(null);
			pnGeneros.add(getRdbtnEspecificarGenero());
			pnGeneros.add(getRdbtnNoDiferenciarCategorias());
		}
		return pnGeneros;
	}

	/**
	 * JRadioButton con la opcion "Diferenciar categorias por géneros." e incluido
	 * en buttonGroup.
	 * 
	 * @return rdbtnEspecificarGenero
	 */
	private JRadioButton getRdbtnEspecificarGenero() {
		if (rdbtnEspecificarGenero == null) {
			rdbtnEspecificarGenero = new JRadioButton("Diferenciar categorias por géneros.");
			buttonGroup.add(rdbtnEspecificarGenero);
			rdbtnEspecificarGenero.setFont(new Font("Tahoma", Font.PLAIN, 13));
			rdbtnEspecificarGenero.setBackground(Color.WHITE);
			rdbtnEspecificarGenero.setBounds(6, 6, 253, 21);
		}
		return rdbtnEspecificarGenero;
	}

	/**
	 * JRadioButton con la opcion "No diferenciar categorias por géneros." e
	 * incluido en buttonGroup.
	 * 
	 * @return rdbtnNoDiferenciarCategorias
	 */
	private JRadioButton getRdbtnNoDiferenciarCategorias() {
		if (rdbtnNoDiferenciarCategorias == null) {
			rdbtnNoDiferenciarCategorias = new JRadioButton("No diferenciar categorias por géneros.");
			buttonGroup.add(rdbtnNoDiferenciarCategorias);
			rdbtnNoDiferenciarCategorias.setFont(new Font("Tahoma", Font.PLAIN, 13));
			rdbtnNoDiferenciarCategorias.setBackground(Color.WHITE);
			rdbtnNoDiferenciarCategorias.setBounds(6, 29, 253, 21);
		}
		return rdbtnNoDiferenciarCategorias;
	}

	/**
	 * Si todo está correcto, añade las categorias a la competicion.
	 * 
	 * @return
	 */
	private JButton getBtnTerminar() {
		if (btnTerminar == null) {
			btnTerminar = new JButton("Terminar");
			btnTerminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// se crea un objeto CategoriasDTO con categorias predetermindas y obtiene la
					// competicion.
					CategoriasDTO categorias = new CategoriasDTO();
					CompeticionDTO competicion = cc.obtenerCompeticionName(nombreCompeticion);
					// si se han introducido categorias
					if (txtSegundaCategoria.isVisible()) {
						// si todas las edades son válidas
						if (isTodasLasEdadesValidas()) {
							// crea un objeto CategoriasDTO con las categorias especificadas.
							fin(crearCategorias(), competicion);
						} else
							JOptionPane.showMessageDialog(null, "Número no válido en alguna categoria.");
					} else {
						fin(categorias, competicion);
					}
				}
			});
			btnTerminar.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnTerminar.setBackground(new Color(34, 139, 34));
			btnTerminar.setBounds(477, 259, 100, 25);
		}
		return btnTerminar;

	}

	/**
	 * Añade las categorias a la competicion. Muestra un mensaje de confirmacion y
	 * vuelve invisible this.
	 * 
	 * @param categorias
	 * @param competicion
	 */
	private void fin(CategoriasDTO categorias, CompeticionDTO competicion) {
		competicion.setCategorias(categorias);
		JOptionPane.showMessageDialog(null, "Añadido correctamente.");
		this.setVisible(false);
	}

	/**
	 * Crea las categorias
	 */
	private CategoriasDTO crearCategorias() {
		int primera = getEdadCategoria(txtPrimeraCategoria);
		int segunda = getEdadCategoria(txtSegundaCategoria);
		int tercera = getEdadCategoria(txtTerceraCategoria);
		int cuarta = getEdadCategoria(txtCuartaCategoria);
		int quinta = getEdadCategoria(txtQuintaCategoria);
		return new CategoriasDTO(primera, segunda, tercera, cuarta, quinta);

	}

	/**
	 * Devuelve la edad especificada en la categoria. Si la categoria no está
	 * visible aún, devuelve -1.
	 * 
	 * @param categoria
	 * @return
	 */
	private int getEdadCategoria(JTextField categoria) {
		if (categoria.isVisible())
			return Integer.valueOf(categoria.getText());
		return -1;
	}

	/**
	 * Comprueba que todas las edades son válidas.
	 * 
	 * @return
	 */
	private boolean isTodasLasEdadesValidas() {
		boolean primera = this.isEdadValida(this.txtPrimeraCategoria.getText());
		boolean segunda = this.isEdadValida(this.txtSegundaCategoria.getText());
		boolean tercera = this.isEdadValida(this.txtTerceraCategoria.getText());
		boolean cuarta = this.isEdadValida(this.txtCuartaCategoria.getText());
		boolean quinta = this.isEdadValida(this.txtQuintaCategoria.getText());
		return primera && segunda && tercera && cuarta && quinta;
	}
}

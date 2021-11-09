package giis.demo.util;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import atleta.InscripcionAtletaView;
import competicion.CompeticionController;
import competicion.CompeticionView;
import competicion.CompeticionModel;
import giis.demo.tkrun.CarrerasController;
import giis.demo.tkrun.CarrerasModel;
import giis.demo.tkrun.CarrerasView;
import inscripcion.ClasificacionesView;
import inscripcion.InscripcionView;

/**
 * Punto de entrada principal que incluye botones para la ejecucion de las pantallas 
 * de las aplicaciones de ejemplo
 * y acciones de inicializacion de la base de datos.
 * No sigue MVC pues es solamente temporal para que durante el desarrollo se tenga posibilidad
 * de realizar acciones de inicializacion
 */
public class SwingMain {

	private InscripcionAtletaView iav;
	private InscripcionView iiv;
	private JFrame frame;
	private ClasificacionesView cv;
	private CompeticionController cc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() { //NOSONAR codigo autogenerado
			public void run() {
				try {
					SwingMain window = new SwingMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace(); //NOSONAR codigo autogenerado
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SwingMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		cv = new ClasificacionesView();
		iav = new InscripcionAtletaView();
		iiv = new InscripcionView();
		
		frame = new JFrame();
		frame.setTitle("Main");
		frame.setBounds(0, 0, 287, 303);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnEjecutarTkrun = new JButton("Ejecutar giis.demo.tkrun");
		btnEjecutarTkrun.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				CarrerasController controller=new CarrerasController(new CarrerasModel(), new CarrerasView());
				controller.initController();
			}
		});
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.getContentPane().add(btnEjecutarTkrun);
		
			
		JButton btnInicializarBaseDeDatos = new JButton("Inicializar Base de Datos en Blanco");
		btnInicializarBaseDeDatos.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				Database db=new Database();
				db.createDatabase(false);
			}
		});
		frame.getContentPane().add(btnInicializarBaseDeDatos);
			
		JButton btnCargarDatosIniciales = new JButton("Cargar Datos Iniciales para Pruebas");
		btnCargarDatosIniciales.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				Database db=new Database();
				db.createDatabase(false);
				db.loadDatabase();
			}
		});
		frame.getContentPane().add(btnCargarDatosIniciales);
		
		JButton btnClasificaciones = new JButton("Clasificaciones");
		btnClasificaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cv.setVisible(true);
			}
		});
		frame.getContentPane().add(btnClasificaciones);
		
		/*JButton btnInscribirse = new JButton("Inscripcion para atletas");
		btnInscribirse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				iav.setVisible(true);
			}
		});
		frame.getContentPane().add(btnInscribirse);*/
		
		JButton btnListadoIns = new JButton("Listado de inscripciones");
		btnListadoIns.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iiv.setVisible(true);
			}
		});
		frame.getContentPane().add(btnListadoIns);
		
		JButton btnListaDeCompeticiones = new JButton("Lista de Competiciones");
		btnListaDeCompeticiones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CompeticionController(new CompeticionModel(), new CompeticionView());
			}
		});
		frame.getContentPane().add(btnListaDeCompeticiones);
		
		
	}

	public JFrame getFrame() { return this.frame; }
	
}

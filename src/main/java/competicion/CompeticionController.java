package competicion;

import java.awt.event.MouseAdapter;
import java.util.List;

import javax.swing.table.TableModel;

import giis.demo.util.SwingUtil;
import giis.demo.util.Util;

public class CompeticionController {

	private CompeticionModel model;
	private CompeticionView view;
	
	private CompeticionViewParaOrganizadores cvpo;

	public CompeticionController(CompeticionView v) {
		this.model = new CompeticionModel();
		this.view = v;
		this.initView();
	}
	
	public CompeticionController(CompeticionViewParaOrganizadores cvpo) {
		this.model = new CompeticionModel();
		this.cvpo = cvpo;
		this.initViewParaOrganizadores();
	}

	public void initView() {
		/*SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");
		Date dateAct = new Date();*/
		view.setFechaHoy("2021-10-21");
		
		view.setCompeticionController(this);
		
		this.getListaCompeticiones();

		view.setVisible(true);
	}
	
	
	public void initViewParaOrganizadores() {
		/*SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");
		Date dateAct = new Date();*/
		cvpo.setFechaHoy("2021-10-21");
		
		cvpo.setCompeticionController(this);
		
		this.getListaCompeticionesParaOrganizador();

		cvpo.setVisible(true);
	}

	/**
	 * Inicializacion del controlador: anyade los manejadores de eventos a los
	 * objetos del UI. Cada manejador de eventos se instancia de la misma forma,
	 * para que invoque un metodo privado de este controlador, encerrado en un
	 * manejador de excepciones generico para mostrar ventanas emergentes cuando
	 * ocurra algun problema o excepcion controlada.
	 */
	public void initController() {
		// ActionListener define solo un metodo actionPerformed(), es un interfaz
		// funcional que se puede invocar de la siguiente forma:
		// view.getBtnTablaCarreras().addActionListener(e -> getListaCarreras());
		// ademas invoco el metodo que responde al listener en el exceptionWrapper para
		// que se encargue de las excepciones
		view.getBtnTablaCarreras().addActionListener(e -> SwingUtil.exceptionWrapper(() -> getListaCompeticiones()));

		// En el caso del mouse listener (para detectar seleccion de una fila) no es un
		// interfaz funcional puesto que tiene varios metodos
		view.getTabCompeticiones().addMouseListener(new MouseAdapter() {
		});
	}

	/**
	 * La obtencion de la lista de competiciones solo necesita obtener la lista de
	 * objetos del modelo y usar metodo de SwingUtil para crear un tablemodel que se
	 * asigna finalmente a la tabla.
	 */
	public void getListaCompeticiones() {
		List<CompeticionDTO> competiciones = model.getListaCompeticiones(Util.isoStringToDate(view.getFechaHoy()));
		TableModel tmodel = SwingUtil.getTableModelFromPojos(competiciones,
				new String[] { "nombre", "fecha", "tipo", "distancia", "fin", "numPlazas" });
		view.getTablaCompeticiones().setModel(tmodel);
		SwingUtil.autoAdjustColumns(view.getTablaCompeticiones());
	}
	
	public void getListaCompeticionesParaOrganizador() {
		List<CompeticionDTO> competiciones = model.getListaCompeticiones(Util.isoStringToDate(cvpo.getFechaHoy()));
		TableModel tmodel = SwingUtil.getTableModelFromPojos(competiciones,
				new String[] { "nombre", "fecha", "tipo", "distancia", "fin", "numPlazas" });
		cvpo.getTablaCompeticiones().setModel(tmodel);
		SwingUtil.autoAdjustColumns(cvpo.getTablaCompeticiones());
	}
	
	
	public CompeticionDTO getCompeticion(String nombre, String fecha, String tipo, int distancia,String fechaFin) {
		CompeticionDTO competicion = new CompeticionDTO();
		List<CompeticionDTO> competiciones =  model.getListaCompeticiones(Util.isoStringToDate(view.getFechaHoy()));
		for(CompeticionDTO comp : competiciones) {
			if(comp.getNombre().equals(nombre) && comp.getFecha().equals(fecha) && comp.getTipo().equals(tipo) && comp.getDistancia() == distancia &&
					comp.getFin().equals(fechaFin)) {
				competicion = comp;
			}
		}
		
		if(competicion.getNombre() == null) {
			System.out.println(competicion.getNombre());
			return null;
		}
		
		return competicion;
	}

}

package competicion;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import giis.demo.util.SwingUtil;
import giis.demo.util.Util;

public class CompeticionController {

	private CompeticionModel model;
	private CompeticionView view;

	public CompeticionController(CompeticionModel m, CompeticionView v) {
		this.model = m;
		this.view = v;
		this.initView();
	}

	public void initView() {
		view.setFechaHoy("2021-10-10");
		this.getListaCarreras();

		view.setVisible(true);
	}

	/**
	 * Inicializacion del controlador: anyade los manejadores de eventos a los objetos del UI.
	 * Cada manejador de eventos se instancia de la misma forma, para que invoque un metodo privado
	 * de este controlador, encerrado en un manejador de excepciones generico para mostrar ventanas
	 * emergentes cuando ocurra algun problema o excepcion controlada.
	 */
	public void initController() {
		//ActionListener define solo un metodo actionPerformed(), es un interfaz funcional que se puede invocar de la siguiente forma:
		//view.getBtnTablaCarreras().addActionListener(e -> getListaCarreras());
		//ademas invoco el metodo que responde al listener en el exceptionWrapper para que se encargue de las excepciones
		view.getBtnTablaCarreras().addActionListener(e -> SwingUtil.exceptionWrapper(() -> getListaCarreras()));
	
		//En el caso del mouse listener (para detectar seleccion de una fila) no es un interfaz funcional puesto que tiene varios metodos
		//ver discusion: https://stackoverflow.com/questions/21833537/java-8-lambda-expressions-what-about-multiple-methods-in-nested-class
		view.getTabCompeticiones().addMouseListener(new MouseAdapter() {
		});
	}
	
	/**
	 * La obtencion de la lista de carreras solo necesita obtener la lista de
	 * objetos del modelo y usar metodo de SwingUtil para crear un tablemodel que se
	 * asigna finalmente a la tabla.
	 */
	public void getListaCarreras() {
		List<CompeticionDTO> carreras = model.getListaCarreras(Util.isoStringToDate(view.getFechaHoy()));
		TableModel tmodel = SwingUtil.getTableModelFromPojos(carreras, new String[] { "nombre", "fecha", "tipo","distancia","fin inscripcion","numero de plazas"});
		view.getTablaCompeticiones().setModel(tmodel);
		SwingUtil.autoAdjustColumns(view.getTablaCompeticiones());
	}


}

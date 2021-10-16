package competicion;

public class Main {

	private static CompeticionController controller;
	
	public static void main(String[] args) {
		controller = new CompeticionController(new CompeticionModel(), new CompeticionView());
		controller.initController();
	}
}

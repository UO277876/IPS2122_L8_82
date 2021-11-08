package metododepago;

public class MetodoDePagoController {
	
	private MetodoDePagoModel pm;
	
	/**
	 * Constructor sin parámetros de la clase método de pago
	 */
	public MetodoDePagoController() {
		this.pm = new MetodoDePagoModel();
	}
	
	/**
	 * Devuelve True si el metodo de pago etsa realizado y false si no
	 * @param email
	 * @return True si esta pagado, False si no
	 */
	public boolean getEstado(String email) {
		return pm.getPago(email).isEstado();
	}

}

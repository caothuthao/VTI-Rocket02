
public class Queen {

	private float health = 100;

	
	/**
	 * This method is used to return health of Queen
	 * 
	 * @return
	 * @author CaoThuThao
	 */
	public float getHealth() {
		return health;
	}

	
	/**
	 * This method return health if status is dead and return health - num if
	 * status is alive
	 * 
	 * @param num
	 * @return health
	 * @author CaoThuThao
	 */
	public float damage(int num) {
		if (this.checkHealthStatus().equals("Alive")) {
			health = health - num;
			return health;
		} else {
			return health;
		}
	}

	
	/**
	 * This method is used to return health status of Queen
	 * 
	 * @return
	 * @author CaoThuThao
	 */
	public String checkHealthStatus() {
		if (health < 20) {
			return "Dead";
		} else {
			return "Alive";
		}
	}

	/**
	 * This method is used to print information of bee to screen
	 * 
	 * @author CaoThuThao
	 */
	public void print() {
		System.out.println("Health: " + this.getHealth());
		System.out.println("Stautus: " + this.checkHealthStatus());
	}
}

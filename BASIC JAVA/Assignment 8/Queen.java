/**
 * 
 * This class is Queen bee. 
 * 
 * @Description: .
 * @author: CaoThuThao
 * @create_date: Mar 28, 2020
 * @version: 1.0
 * @modifer: CaoThuThao
 * @modifer_date: Mar 28, 2020
 */

public class Queen extends Bee {
	
	/**
	 * 
	 * This method is used to return health if status is dead and return health - number if status is alive. 
	 * 
	 * @Description: .
	 * @author: CaoThuThao
	 * @create_date: Mar 28, 2020
	 * @version: 1.0
	 * @modifer: CaoThuThao
	 * @modifer_date: Mar 28, 2020
	 * @param num
	 * @return
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
	 * 
	 * This method is return health status of Queen. 
	 * 
	 * @Description: .
	 * @author: CaoThuThao
	 * @create_date: Mar 28, 2020
	 * @version: 1.0
	 * @modifer: CaoThuThao
	 * @modifer_date: Mar 28, 2020
	 * @return
	 */
	public String checkHealthStatus() {
		if (health < 20) {
			return "Dead";
		} else {
			return "Alive";
		}
	}
	
}

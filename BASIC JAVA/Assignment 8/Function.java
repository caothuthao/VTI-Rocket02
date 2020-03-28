import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 */

/**
 * This class is Function.
 * 
 * @Description: .
 * @author: CaoThuThao
 * @create_date: Mar 28, 2020
 * @version: 1.0
 * @modifer: CaoThuThao
 * @modifer_date: Mar 28, 2020
 */
public class Function {

	Scanner scanner = new Scanner(System.in);
	Random random = new Random();

	/**
	 * 
	 * This method is used to remove elements of list Bee.
	 * 
	 * @Description: .
	 * @author: CaoThuThao
	 * @create_date: Mar 28, 2020
	 * @version: 1.0
	 * @modifer: CaoThuThao
	 * @modifer_date: Mar 28, 2020
	 * @param list
	 * @param n
	 */
	public void removeList(List<Bee> list) {
		for (int i = 0; i < list.size(); i++) {
			list.remove(i);
		}
	}

	/**
	 * 
	 * This method is used to create Random List Bee.
	 * 
	 * @Description: .
	 * @author: CaoThuThao
	 * @create_date: Mar 28, 2020
	 * @version: 1.0
	 * @modifer: CaoThuThao
	 * @modifer_date: Mar 28, 2020
	 * @return
	 */
	public void createRandomList() {
		
		System.out.println("Please enter the size of list Bee:");
		int sizeList = ScannerUtils.readInt(scanner, "Please enter an integer number! Enter again:");

		List<Bee> listRandomBee = new ArrayList<>();
		
		int healthRandom;

		// create a Worker list:
		List<Worker> listRandomWorker = new ArrayList<>();
		int sizeWorkerList = random.nextInt(sizeList / 3) + 1;
		for (int i = 0; i < sizeWorkerList; i++) {
			listRandomWorker.add(new Worker());
			healthRandom = random.nextInt(101);
			listRandomWorker.get(i).setHealth(healthRandom);
		}

		// create a Queen list:
		List<Queen> listRandomQueen = new ArrayList<>();
		int sizeQueenList = random.nextInt(sizeList / 3) + 1;
		for (int i = 0; i < sizeQueenList; i++) {
			listRandomQueen.add(new Queen());
			healthRandom = random.nextInt(101);
			listRandomQueen.get(i).setHealth(healthRandom);
		}

		// create a Drone list:
		List<Drone> listRandomDrone = new ArrayList<>();
		int sizeDroneList = sizeList - sizeWorkerList - sizeQueenList;
		for (int i = 0; i < sizeDroneList; i++) {
			listRandomDrone.add(new Drone());
			healthRandom = random.nextInt(101);
			listRandomDrone.get(i).setHealth(healthRandom);
		}

		listRandomBee.addAll(listRandomWorker);
		listRandomBee.addAll(listRandomQueen);
		listRandomBee.addAll(listRandomDrone);

		// print list to screen
		System.out.println("List random of Bee:");
		System.out.println("**************************************");
		for (int i = 0; i < listRandomBee.size(); i++) {
			// print Worker
			if (listRandomBee.get(i) instanceof Worker) {
				Worker obj = (Worker) listRandomBee.get(i);
				System.out.println("Bee[" + (i) + "] : Worker" + "\n" + "Health: " + obj.getHealth() + "\n" + "Status: "
					+ obj.checkHealthStatus());
			}

			// print Queen
			if (listRandomBee.get(i) instanceof Queen) {
				Queen obj = (Queen) listRandomBee.get(i);
				System.out.println("Bee[" + (i) + "] : Queen" + "\n" + "Health: " + obj.getHealth() + "\n" + "Status: "
						+ obj.checkHealthStatus());
			}

			// print Drone
			if (listRandomBee.get(i) instanceof Drone) {
				Drone obj = (Drone) listRandomBee.get(i);
				System.out.println("Bee[" + (i) + "] : Drone" + "\n" + "Health: " + obj.getHealth() + "\n" + "Status: "
						+ obj.checkHealthStatus());
			}
		}
	}
	
	
	/**
	 * 
	 * This method is used to damage list Bee. 
	 * 
	 * @Description: .
	 * @author: CaoThuThao
	 * @create_date: Mar 28, 2020
	 * @version: 1.0
	 * @modifer: CaoThuThao
	 * @modifer_date: Mar 28, 2020
	 * @param list
	 */
	public void damageBee(List<Bee> list){
		int randomNumber;
		for (int i = 0; i < list.size(); i++) {
			
			randomNumber = random.nextInt(80) + 1;
			System.out.println("Random number of bee[" + i + "]:" + randomNumber);

			if (list.get(i) instanceof Worker) {
				Worker obj = (Worker) list.get(i);
				obj.damage(randomNumber);
				System.out.println("Health stataus of bee[" + i + "]:" + obj.checkHealthStatus());
				System.out.println("-----------------------------------------");
			}

			if (list.get(i) instanceof Queen) {
				Queen obj = (Queen) list.get(i);
				obj.damage(randomNumber);
				System.out.println("Health stataus of bee[" + i + "]:" + obj.checkHealthStatus());
				System.out.println("-----------------------------------------");
			}

			if (list.get(i) instanceof Drone) {
				Drone obj = (Drone) list.get(i);
				obj.damage(randomNumber);
				System.out.println("Health stataus of bee[" + i + "]:" + obj.checkHealthStatus());
				System.out.println("-----------------------------------------");
			}
		}

	}

}

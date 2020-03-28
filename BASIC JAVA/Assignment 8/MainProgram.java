import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class MainProgram {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Function f = new Function();

		// create a list of worker
		List<Worker> listWorker = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			listWorker.add(new Worker());
		}

		// create a list of queen
		List<Queen> listQueen = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			listQueen.add(new Queen());
		}

		// create a list of Drone
		List<Drone> listDrone = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			listDrone.add(new Drone());
		}

		// Create list of Bee
		List<Bee> listBee = new ArrayList<>();
		// add all elements of 3 list into listBee
		listBee.addAll(listWorker);
		listBee.addAll(listQueen);
		listBee.addAll(listDrone);

		// print list to screen
		System.out.println("List of Bee:");
		System.out.println("**************************************");
		for (int i = 0; i < listBee.size(); i++) {
			// print Worker
			if (listBee.get(i) instanceof Worker) {
				Worker obj = (Worker) listBee.get(i);
				System.out.println("Bee[" + (i) + "] : Worker" + "\n" + "Health: " + obj.getHealth() + "\n" + "Status: "
						+ obj.checkHealthStatus());
			}

			// print Queen
			if (listBee.get(i) instanceof Queen) {
				Queen obj = (Queen) listBee.get(i);
				System.out.println("Bee[" + (i) + "] : Queen" + "\n" + "Health: " + obj.getHealth() + "\n" + "Status: "
						+ obj.checkHealthStatus());
			}

			// print Drone
			if (listBee.get(i) instanceof Drone) {
				Drone obj = (Drone) listBee.get(i);
				System.out.println("Bee[" + (i) + "] : Drone" + "\n" + "Health: " + obj.getHealth() + "\n" + "Status: "
						+ obj.checkHealthStatus());
			}
		}

		// Menu:
		boolean valueBoolean = true;
		while (valueBoolean) {
			System.out.println("********* MENU **********");
			System.out.println("1. Create a list of Bee");
			System.out.println("2. Damage Bee");
			System.out.println("3. Exit");

			System.out.println("Plese enter your choice: ");

			int choice = ScannerUtils.readInt(scanner, "Please enter a int number! Enter again:");
			if ((choice != 1) && (choice != 2) && (choice != 3)) {
				System.out.println("Please enter 1 or 2 or 3! Enter again:");
				choice = ScannerUtils.readInt(scanner, "Please enter a int number! Enter again:");
			}

			switch (choice) {
			case 1:
				// remove list of Bee
				f.removeList(listBee);

				// create random list of bee:
				f.createRandomList();
				break;

			case 2:
				f.damageBee(listBee);
				break;

			case 3:
				System.out.println("Exit succesfully!");
				valueBoolean = false;
				break;
			}

		}
	}

}

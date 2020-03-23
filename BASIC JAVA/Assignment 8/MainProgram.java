import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class MainProgram {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		// Create 3 list of Bee
		// Worker
		List<Worker> listWorker = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			listWorker.add(new Worker());
		}

		// Queen
		List<Queen> listQueen = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			listQueen.add(new Queen());
		}

		// Drone
		List<Drone> listDrone = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			listDrone.add(new Drone());
		}

		// print 3 list to screen
		System.out.println("3 list: ");
		System.out.println("**************************************");
		System.out.println("The first list: Worker");
		for (Worker worker : listWorker) {
			System.out.println("---------------------------------------");
			worker.print();
		}

		System.out.println("**************************************");
		System.out.println("The second list: Queen");
		for (Queen queen : listQueen) {
			System.out.println("---------------------------------------");
			queen.print();
		}

		System.out.println("**************************************");
		System.out.println("The third list: Drone");
		for (Drone drone : listDrone) {
			System.out.println("---------------------------------------");
			drone.print();
		}

		// Menu:
		System.out.println("*********MENU**********");
		System.out.println("1. Create a list of Bee");
		System.out.println("2. Damage Bee");

		System.out.println("Plese enter your choice: ");
		int choice = ScannerUtils.readInt(scanner, "Please enter a int number! Enter again:");

		if (choice == 1) {
			// remove 3 list
			for (int i = 0; i < listWorker.size(); i++) {
				listWorker.remove(i);
			}
			for (int i = 0; i < listQueen.size(); i++) {
				listQueen.remove(i);
			}
			for (int i = 0; i < listDrone.size(); i++) {
				listDrone.remove(i);
			}

			// create 3 new list
			int typeBee = random.nextInt(3) + 1;
			System.out.println("typeBee: " + typeBee);
			System.out.println("Enter the size of list random bees:");
			int sizeListBees = ScannerUtils.readInt(scanner, "Please enter a int number! Enter again:");

			if (typeBee == 1) {
				// create list Worker
				List<Worker> listRandomWorker = new ArrayList<>();
				for (int i = 0; i < sizeListBees; i++) {
					listRandomWorker.add(new Worker());
				}

				System.out.println("**************************************");
				System.out.println("List Worker:");
				for (Worker worker : listRandomWorker) {
					System.out.println("---------------------------------------");
					worker.print();
				}

			} else if (typeBee == 2) {
				// create list Queen
				List<Queen> listRandomQueen = new ArrayList<>();
				for (int i = 0; i < sizeListBees; i++) {
					listRandomQueen.add(new Queen());
				}

				System.out.println("**************************************");
				System.out.println("List Queen:");
				for (Queen queen : listRandomQueen) {
					System.out.println("---------------------------------------");
					queen.print();
				}
			} else if (typeBee == 3) {
				// create list Drone
				List<Drone> listRandomDrone = new ArrayList<>();
				for (int i = 0; i < sizeListBees; i++) {
					listRandomDrone.add(new Drone());
				}

				System.out.println("**************************************");
				System.out.println("List Drone:");
				for (Drone drone : listRandomDrone) {
					System.out.println("---------------------------------------");
					drone.print();
				}
			}

		} else if (choice == 2) {

			int randomNumber = random.nextInt(81);
			System.out.println("Random number: " + randomNumber);
			System.out.println("Status of bees after being damaged:");
			System.out.println("3 list: ");
			System.out.println("**************************************");
			System.out.println("The first list: Worker");
			for (Worker worker : listWorker) {
				System.out.println("---------------------------------------");
				System.out.println("Health: " + worker.damage(randomNumber));
				System.out.println("Stauts: " + worker.checkHealthStatus());
			}

			System.out.println("**************************************");
			System.out.println("The second list: Queen");
			for (Queen queen : listQueen) {
				System.out.println("---------------------------------------");
				System.out.println("Health: " + queen.damage(randomNumber));
				System.out.println("Stauts: " + queen.checkHealthStatus());
			}

			System.out.println("**************************************");
			System.out.println("The third list: Drone");
			for (Drone drone : listDrone) {
				System.out.println("---------------------------------------");
				System.out.println("Health: " + drone.damage(randomNumber));
				System.out.println("Stauts: " + drone.checkHealthStatus());
			}
		}

	}
}

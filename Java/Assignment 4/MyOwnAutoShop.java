package asignment4;

public class MyOwnAutoShop {

	public static void main(String[] args) {
		// a)
		Sedan sedan = new Sedan(200, 300.32d, "Black", 3);

		// b)
		Ford ford1 = new Ford(250, 400d, "Yellow", 2019, 50);
		Ford ford2 = new Ford(260, 450d, "Red", 2020, 100);

		// c)
		Car car = new Car(200, 200d, "Pink");

		// d)
		System.out.println("Sale price of car: " + car.getSalePrice());
		System.out.println("Sale price of sedan: " + sedan.getSalePrice());
		System.out.println("Sale price of ford1: " + ford1.getSalePrice());
		System.out.println("Sale price of ford2: " + ford2.getSalePrice());
	}
}

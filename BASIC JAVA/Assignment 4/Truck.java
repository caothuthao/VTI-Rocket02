package asignment4;

public class Truck extends Car {
	int weight;

	Truck(int speed, double regularPrice, String color, int weight){
		super(speed, regularPrice, color);
		this.weight = weight;
	}
	
	@Override
	double getSalePrice() {
		if (weight > 2000){
			return regularPrice*0.9;
		} else {
			return regularPrice*0.8;
		}
	}
}

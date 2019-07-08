package test;

public class Car extends Vehicle {
	void name() {
		System.out.println("Car");
	}
	public static void main(String[] args) {
		Vehicle v = new Car();
		v.query();
		v.what();
	}
}

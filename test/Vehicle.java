package test;

public class Vehicle {
	void name() {
		System.out.println("Vehicle");
	}
	void query() {
		name();
	}
	void what() {
        try {
            this.getClass().newInstance().name();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
}

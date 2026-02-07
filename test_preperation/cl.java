class Car{
	String color;
	String model;
	int year;

	void start(){
		System.out.println("Car started");
	}

	void stop(){
		System.out.println("Car stopped");
	}

	void view(){
		System.out.println("Color"+color);
		System.out.println("year"+year);
		System.out.println("model"+model);
	}
}


class cl{
	public static void main(String args[]){
		Car mycar = new Car();
		
		mycar.color = "Red";
		mycar.model = "Toyata";
		mycar.year = 2020;

		mycar.view();
		mycar.start();
		mycar.stop();
	}	
}

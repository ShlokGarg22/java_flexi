class Person{
	String name;
	int age;

	Person(String n , int a){
		name = n;
		age = a;
	}

	void print(){
		System.out.println("name is " + name);
		System.out.println("age is" + age);
	}
}

class para{
	public static void main(String args[]){	
		Person p = new Person("ALICE" , 25);
		p.print();
	}
}

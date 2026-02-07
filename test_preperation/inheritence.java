class Animal{
	void eat(){
		System.out.println("This animal eats food");
	}

}
class Dog extends Animal{
	void bark(){
		System.out.println("this dog barks");	
	}	
}
class inheritence{
	public static void main(String args[]){
		Dog d = new Dog();
		d.eat(); //inherited from animal which is the parent class
		d.bark();
	}
}


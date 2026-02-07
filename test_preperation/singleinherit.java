class Parent{
	void hair(){
		System.out.println("this is our hair of parent class");	
	}	
}
class Child extends Parent{
	void eyes(){
		System.out.println("this is the eyes of the child class");
		}
	}
class Child1 extends Parent{
	void nose(){
		System.out.println("this is nose from the child of the child of the parent class");
	}	
}
class singleinherit{
	public static void main(String args[]){
		Child1 c = new Child1();
		c.hair();
		// c.eyes();
		c.nose();

		Child ch = new Child();
		ch.hair();
		ch.eyes();

	}


}

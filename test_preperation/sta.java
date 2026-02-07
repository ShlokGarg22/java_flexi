class School{
	String studentName;


	static String schoolName = "ABC School";
	static int totalStudent = 0;

	School(String studentName){
		this.studentName  = studentName;
		totalStudent++;
	}

}

class sta{
	public static void main(String args[]){
		School s1 = new School("Alice");
		School s2 = new School("Bob");

		System.out.println(s1.schoolName);
		System.out.println(s2.schoolName);

		System.out.println(School.totalStudent);
	}	
}


import java.util.Scanner; // Step 1: Import the Scanner classclass GenericClass{
class GenericClass{
    double speed(){
        return 50;
    }
}
class Car{
    @Override
    double speed(){
        return 100;
    }
}
class Bike{
    @Override
    double speed(){
        return 140;
    }
}
class vehicle_tracking{
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your speed"); // Step 3: Prompt
        int speed = scanner.nextInt(); // Step 4: Read input

        scanner.nextLine();

        System.out.print("Enter what are you driving 1 for car 2 for bike")

        int vehicle = scanner.nextInt();

        scanner.nextLine();

        switch(vehicle){
            case 1:
                Car c = new Car();
                double s = c.speed()

                if(speed > s){
                    System.out.println("you are under the limit")
                }else{
                    System.out.println("you are over the limit")
                }
                break;
            case 2:
                Bike c = new Bike();
                double sa = c.speed()

                if(speed > sa){
                    System.out.println("you are under the limit")
                }else{
                    System.out.println("you are over the limit")
                }

                break;
            default:
                System.out.println("error");
        }

    }
}


//we will take inout speed
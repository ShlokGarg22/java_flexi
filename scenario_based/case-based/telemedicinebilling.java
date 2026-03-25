
abstract class Plan{
    private String patientname;
    private double basefee;

    Plan(String patientname , double basefee){
        this.patientname = patientname;
        this.basefee = basefee;


        System.out.println("constructor initialized");
    }

    public String getPatientname() {
        return patientname;
    }

    public double getBasefee() {
        return basefee;
    }

    abstract double calculateBill();


}
class gold extends Plan{
    public int servicetax;


    public gold(String patientname, double basefee) {
        super(patientname, basefee);
        this.servicetax = 20;
    }

    @Override
    double calculateBill(){
        double a =  getBasefee() + (getBasefee() * 0.10) + servicetax;
        System.out.println("the bill calculated is" + a);
        return a;
    }

}

class silver extends Plan{

    public silver(String patientname , double basefee){
        super(patientname,basefee);
    }

    @Override
    double calculateBill(){
        double a =  getBasefee() + 15;
        System.out.println("the bill calculated is" + a);
        return a;
    }

}


class telemedicinebilling{
    static void printInvoice(Plan p) {
        System.out.println("Patient: " + p.getPatientname());
        System.out.println("Final Bill: " + p.calculateBill());
    }

    public static void main(String args[]){
        Plan p1 = new gold("Riya", 1000);
        Plan p2 = new silver("Aman", 1000);

        printInvoice(p1);
        printInvoice(p2);
    }
}
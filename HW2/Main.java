import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        ArrayList<CarbonFootprint>  vehicleCarbonObject = new ArrayList<>();
        // Scanner sc = new Scanner(System.in);

        // //Building:
        // System.out.println("Building: ");
        // System.out.println("Please enter coal: ");
        // double coal = sc.nextDouble();

        // System.out.println("Please enter electricity: ");
        // double electricity = sc.nextDouble();

        // System.out.println("Please enter heatingOil: ");
        // double heatingOil = sc.nextDouble();

        // System.out.println("Please enter lpg: ");
        // double lpg = sc.nextDouble();

        // System.out.println("Please enter natural gas: ");
        // double naturalGas = sc.nextDouble();

        // System.out.println("Please enter number of people: ");
        // int numberOfPeople = sc.nextInt();

        // System.out.println("Please enter number of propane: ");
        // double propane = sc.nextDouble();

        // System.out.println("Please enter number of wooden pellets: ");
        // double woodenPellets = sc.nextDouble();
        // System.out.println();

        // //Car
        // System.out.println("Car: ");
        // System.out.println("Please enter monthly electricity: ");
        // double monthlyElectricity= sc.nextDouble();

        // System.out.println("Please enter monthly gas bill: ");
        // double monthlyGasBill = sc.nextDouble();

        // System.out.println("Please enter monthly oil bill: ");
        // double monthlyOilBill = sc.nextDouble();

        // System.out.println("Please enter total yearly mileage: ");
        // double totalYearlyMileage = sc.nextDouble();

        // System.out.println("Please enter monthly electricBill: ");
        // double monthlyElectricBill = sc.nextDouble();
        // System.out.println();

        // //Bicycle:
        // System.out.println("Bicycle: ");

        // System.out.println("Please enter miles: ");
        // double miles = sc.nextDouble();

        // System.out.println("Please type power source such as (air_freighted_asparagus, bacon, bananas, cereal_with_milk, cheeseburgers): ");
        // String  powerSource = sc.next();

        vehicleCarbonObject.add(new Building(30.0,20.0,5.0,20.0,3.0,5,15.0,25.0));
        vehicleCarbonObject.add(new Car(5.0,3.0,7.0,20.0,25.0));
        vehicleCarbonObject.add(new Bicycle(50.0,"bacon"));

        // vehicleCarbonObject.add(new Building(coal, electricity, heatingOil, lpg, naturalGas, numberOfPeople, propane, woodenPellets));
        // vehicleCarbonObject.add(new Car(monthlyElectricity, monthlyGasBill, monthlyOilBill, totalYearlyMileage, monthlyElectricBill));
        // vehicleCarbonObject.add(new Bicycle(miles, powerSource));
        
        
        System.out.println();
        for(int i = 0; i < vehicleCarbonObject.size(); i++){
            System.out.print(vehicleCarbonObject.get(i).toString());
        }
    }
}
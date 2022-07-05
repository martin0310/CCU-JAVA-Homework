public class Car implements CarbonFootprint{

    // source:
    // https://www.forbes.com/2008/04/15/green-carbon-living-forbeslife-cx_ls_0415carbon.html?sh=658a83c1852e

    private double monthlyElectricity; //Multiply 105
    private double monthlyGasBill; //Multiply 105
    private double monthlyOilBill; //Multiply 113
    private double totalYearlyMileage; //Multiply 0.79
    private double monthlyElectricBill; //Multiply 105

    private static double monthlyElectricityIndex = 105; 
    private static double monthlyGasBillIndex = 105; 
    private static double monthlyOilBillIndex = 113;
    private static double totalYearlyMileageIndex = 0.79; 
    private static double monthlyElectricBillIndex = 105; 

    public Car(double monthlyElectricity, double monthlyGasBill, double monthlyOilBill, double totalYearlyMileage, double monthlyElectricBill){
        this.monthlyElectricity = monthlyElectricity;
        this.monthlyGasBill = monthlyGasBill;
        this.monthlyOilBill = monthlyOilBill;
        this.totalYearlyMileage = totalYearlyMileage;
        this.monthlyElectricBill = monthlyElectricBill;
    }

    @Override
    public double getCarbonFootprint() {
        double footprint = getMonthlyElectricity() * monthlyElectricityIndex + getMonthlyGasBill() * monthlyGasBillIndex + getMonthlyOilBill() * monthlyOilBillIndex + getTotalYearlyMileage() * totalYearlyMileageIndex + getMonthlyElectricBill() * monthlyElectricBillIndex;
        return footprint;
    }
    
    public double getMonthlyElectricity(){
        return this.monthlyElectricity;
    }

    public double getMonthlyGasBill(){
        return this.monthlyGasBill;
    }

    public double getMonthlyOilBill(){
        return this.monthlyOilBill;
    }

    public double getTotalYearlyMileage(){
        return this.totalYearlyMileage;
    }

    public double getMonthlyElectricBill(){
        return this.monthlyElectricBill;
    }

    @Override
    public String toString(){
        return  "Car: " + "\n" + "MonthlyElectricity: " + getMonthlyElectricity() + "\n" + "MonthlyGasBill: " + getMonthlyGasBill() + "\n" + "MonthlyOilBill: " + getMonthlyOilBill() + "\n" + "TotalYearlyMileage: " + getTotalYearlyMileage() + "\n" + "MonthlyElectricBill: " + getMonthlyElectricBill() + "\n" + "Carbon Footprint: " + getCarbonFootprint() + "(pounds)" + "\n" + "\n"; 
    } 
}

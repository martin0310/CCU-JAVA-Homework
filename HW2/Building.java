public class Building implements CarbonFootprint{


    // Source: http://www.carbonfootprint.com/calculator.aspx

    private static double COAL_PER_ONE_KWH = .00034;
	private static double ELECTRICITY_PER_ONE_KWH = .00059;
	private static double HEATING_OIL_PER_ONE_KWH = .00028;
	private static double LPG_PER_ONE_KWH = .00021;
	private static double NATURAL_GAS_PER_ONE_KWH = .00018;
	private static double PROPANE_PER_ONE_GALLON = .00579;
	private static double WOODEN_PELLETS_PER_ONE_METRIC_TON = .00774;

    private double coal;
	private double electricity;
	private double heatingOil;
	private double lpg;
	private double naturalGas;
	private int numberOfPeople;
	private double propane;
	private double woodenPellets;


    public Building(double coal, double electricity, double heatingOil, double lpg, double naturalGas, int numberOfPeople, double propane, double woodenPellets){
        this.coal = coal;
        this.electricity = electricity;
        this.heatingOil = heatingOil;
        this.lpg = lpg;
        this.naturalGas = naturalGas;
        this.numberOfPeople = numberOfPeople;
        this.propane = propane;
        this.woodenPellets = woodenPellets;
    }

    @Override
    public double getCarbonFootprint() {
        double footprint = getCoal() * COAL_PER_ONE_KWH + getElectricity() * ELECTRICITY_PER_ONE_KWH + getHeatingOil() * HEATING_OIL_PER_ONE_KWH + getLpg() * LPG_PER_ONE_KWH + getNaturalGas() * NATURAL_GAS_PER_ONE_KWH + getPropane() * PROPANE_PER_ONE_GALLON + getWoodenPellets() * WOODEN_PELLETS_PER_ONE_METRIC_TON;
        return footprint;
    }
    
    public double getCoal(){
        return this.coal;
    } 

    public double getElectricity(){
        return this.electricity;
    }
    
    public double getHeatingOil(){
        return this.heatingOil;
    }

    public double getLpg(){
        return this.lpg;
    }

    public double getNaturalGas(){
        return this.naturalGas;
    }

    public int getNumberOfPeople(){
        return this.numberOfPeople;
    }

    public double getPropane(){
        return this.propane;
    }

    public double getWoodenPellets(){
        return this.woodenPellets;
    }

    @Override
    public String toString(){
        return "Building: " + "\n" + "Coal: " + getCoal() + "\n" + "Electricity: " + getElectricity() + "\n" + "Heating Oil: " + getHeatingOil() + "\n" + "LPG: " + getLpg() + "\n" + "naturalGas: " + getNaturalGas() + "\n" + "Propane: " + getPropane() + "\n" + "Wooden Pellets: " + getWoodenPellets() + "\n" + "Carbon Footprint: " + getCarbonFootprint() + "\n" + "\n";
    } 
}

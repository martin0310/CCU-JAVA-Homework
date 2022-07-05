public class Bicycle implements CarbonFootprint{

    // Source:
    // https://www.theguardian.com/environment/2010/jun/08/carbon-footprint-cycling

    private static double FOOTPRINT_PER_MILE_AVERAGE = 50;
	private static double FOOTPRINT_PER_MILE_BY_BANANAS = 65;
	private static double FOOTPRINT_PER_MILE_BY_CEREAL_WITH_MILK = 90;
	private static double FOOTPRINT_PER_MILE_BY_BACON = 200;
	private static double FOOTPRINT_PER_MILE_BY_CHEESEBURGERS = 260;
	private static double FOOTPRINT_PER_MILE_BY_AIR_FREIGHTED_ASPARAGUS = 2800;


    private static double GRAM_TO_METRIC_TON_MULTIPLIER = .000001;

    private double miles;
    private String powerSource;

    public Bicycle(double miles, String powerSource) {
		this.miles = miles;
		this.powerSource = powerSource;
	}

    public double getMiles(){
        return this.miles;
    }

    public String getPowerSource(){
        return this.powerSource;
    }

    @Override
    public double getCarbonFootprint() {
        double footprint = 0;
        switch(powerSource.toLowerCase()){
            case "air_freighted_asparagus":
			footprint = getMiles() * FOOTPRINT_PER_MILE_BY_AIR_FREIGHTED_ASPARAGUS;
            case "bacon":
                footprint = getMiles() * FOOTPRINT_PER_MILE_BY_BACON;
            case "bananas":
                footprint = getMiles() * FOOTPRINT_PER_MILE_BY_BANANAS;
            case "cereal_with_milk":
                footprint = getMiles() * FOOTPRINT_PER_MILE_BY_CEREAL_WITH_MILK;
            case "cheeseburgers":
                footprint = getMiles() * FOOTPRINT_PER_MILE_BY_CHEESEBURGERS;
            default:
                footprint = getMiles() * FOOTPRINT_PER_MILE_AVERAGE;
		}

		// Convert final footprint to metric tons.
		return footprint * GRAM_TO_METRIC_TON_MULTIPLIER;
        
    }
    
    @Override
    public String toString(){
        String output =  "Bicycle: " + "\n" + "Miles Traveled: " + getMiles() + "\n" + "Power Source: " + getPowerSource() + "\n" + "Carbon Footprint: " + getCarbonFootprint() + "(units: g)(carbon dioxide)" + "\n" + "\n";
        
        return output;
    }

}

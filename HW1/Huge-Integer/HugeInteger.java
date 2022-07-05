public class HugeInteger{
    
    int [] number ;
    // int validDigit = 0;
    public HugeInteger(String input){
        

        if(input.length() > 40)
        throw new IllegalArgumentException("Overflow!!!");

        // for(int i = input.length() - 1; i >= 0; i--){
            
            
        // }

        number = new int[40];
        // validDigit = input.length();
        for(int i = input.length() - 1; i >= 0; i--){
            
            Boolean validDigit = Character.isDigit(input.charAt(i));
            if(input.charAt(i) == '-'){
                throw new IllegalArgumentException("No negative number!!!");
            }
            if(!validDigit){
                throw new IllegalArgumentException("Invalid number!!!");
            }
            number[i] = Character.getNumericValue(input.charAt(input.length() - i - 1)); 
        }
        
    }

    public HugeInteger parse(String input){

        for(int i = input.length() - 1; i >= 0; i--){
            number[i] = Character.getNumericValue(input.charAt(input.length() - i - 1)); 
        }

        return this; //????
    }

    public String toString(){
        
        String outputString = "";
        for(int i = 0; i < this.number.length; i++){
            outputString = String.valueOf(this.number[i]) + outputString;
        } 
        
        int count_digit = 0;

        while(outputString.charAt(count_digit) == '0' && count_digit <= this.number.length - 2){
            
            count_digit++;
        }
        outputString = outputString.substring(count_digit, outputString.length());

        return outputString;
    }

    public HugeInteger add(HugeInteger hugeInteger){
        
        int carry = 0;
        for(int i = 0; i < this.number.length; i++){
            int positionSum = this.number[i] + hugeInteger.number[i] + carry;
            carry = positionSum / 10;
            this.number[i] = positionSum % 10;   
            // System.out.println(this.number[i]);     
        }
        // System.out.println("Carry is: " + carry);
        if(carry != 0){
            throw new IllegalArgumentException("Overflow!!!");
        }

        return this;
    }

    public HugeInteger subtract(HugeInteger hugeInteger){

        int difference = 0;
		int borrow = 0;

        if(this.isGreaterThanOrEqualTo(hugeInteger)){
            for(int i = 0; i < this.number.length; i++){

                difference = this.number[i] - hugeInteger.number[i] - borrow;

                if(difference >= 0){
					this.number[i] = difference;
					borrow = 0;
				}
				
				else{
					this.number[i] = difference + 10;
					borrow = 1;
				}
            }
            
        }
        else{
            throw new IllegalArgumentException("Result would be negative!!!");
        }

        return this;
    }

    public boolean isEqualTo(HugeInteger hugeInteger){
        
        for(int i = this.number.length - 1; i >= 0; i--){
            if(this.number[i] != hugeInteger.number[i]){
                return false;
            }
        }

        return true;
    }

    public boolean isNotEqualTo(HugeInteger hugeInteger){
        
        for(int i = this.number.length - 1; i >= 0; i--){
            if(this.number[i] != hugeInteger.number[i]){
                return true;
            }
        }

        return false;
    }

    public boolean isGreaterThan(HugeInteger hugeInteger){
        
        for(int i = this.number.length - 1; i >= 0; i--){
            if(this.number[i] > hugeInteger.number[i]){
                return true;
            }
            else if(this.number[i] < hugeInteger.number[i]){
                return false;
            }
        }

        return true;
    }

    public boolean isLessThan(HugeInteger hugeInteger){
        
        return this.isNotEqualTo(hugeInteger) && !this.isGreaterThan(hugeInteger);
    }

    public boolean isGreaterThanOrEqualTo(HugeInteger hugeInteger){
        
        return (this.isEqualTo(hugeInteger) || this.isGreaterThan(hugeInteger));
    }

    public boolean isLessThanOrEqualTo(HugeInteger hugeInteger){
        
        return this.isLessThan(hugeInteger) || this.isEqualTo(hugeInteger);
    }

    public boolean isZero(){
       
        for(int i = 0; i < this.number.length; i++){
            if(this.number[i] != 0){
                return false;
            }
        }

        return true;
    }

}
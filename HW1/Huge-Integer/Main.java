import java.util.Scanner;

public class Main {
   public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
    //    String input1 = sc.next();
    //    String input2 = sc.next();

       HugeInteger hugeInteger_1 = new HugeInteger("11000");
       HugeInteger hugeInteger_2 = new HugeInteger("10000");
       HugeInteger hugeInteger_3 = new HugeInteger("100000000");
       System.out.println("ToString: "+ hugeInteger_1.toString());
       System.out.println("ToString: " + hugeInteger_2.toString());
      // for(int i = 0; i < hugeInteger_1.number.length; i++){
      //    System.out.println(hugeInteger_2.number[i]);
      // }
       System.out.println("isEqualTo: " + hugeInteger_1.isEqualTo(hugeInteger_2));
       System.out.println("isNotEqualTo: " + hugeInteger_1.isNotEqualTo(hugeInteger_2));
       System.out.println("isGreaterThan: " + hugeInteger_1.isGreaterThan(hugeInteger_2));
       System.out.println("isLessThan: " + hugeInteger_1.isLessThan(hugeInteger_2));
       System.out.println("isGreaterThanOrEqualTo: " + hugeInteger_1.isGreaterThanOrEqualTo(hugeInteger_2));
       System.out.println("isLessThanOrEqualTo: " + hugeInteger_1.isLessThanOrEqualTo(hugeInteger_2));
       System.out.println("isZero: " + hugeInteger_1.isZero());
       System.out.println("11000 add 10000: " + hugeInteger_1.add(hugeInteger_2).toString());
       System.out.println("21000 subtract 10000: " + hugeInteger_1.subtract(hugeInteger_2).toString());
       System.out.println("parse: " + hugeInteger_3.parse("11000000000").toString());
   } 
}

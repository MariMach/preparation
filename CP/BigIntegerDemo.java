

import java.math.*;

public class BigIntegerDemo {

   public static void main(String[] args) {

      // create a BigInteger object
      BigInteger bi;

      // create 2 boolean objects
      Boolean b1, b2, b3, b4;

      bi = new BigInteger("10"); 

      // perform testbit on bi at index 2 and 3
      b1 = bi.testBit(1);
      b2 = bi.testBit(2);
      b3 = bi.testBit(3);
      b4 = bi.testBit(4);

      String str1 = "Test Bit on " + bi + " at index 1 returns " +b1;
      String str2 = "Test Bit on " + bi + " at index 2 returns " +b2;
      String str3 = "Test Bit on " + bi + " at index 3 returns " +b3;
      String str4 = "Test Bit on " + bi + " at index 4 returns " +b4;

      // print b1, b2 values
      System.out.println(Long.toString(10, 2));
      System.out.println( str1 );
      System.out.println( str2 );
      System.out.println( str3 );
      System.out.println( str4 );
   }
}
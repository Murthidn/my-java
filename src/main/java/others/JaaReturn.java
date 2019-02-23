/*
 *
 * Copyright (c) 2019 Ranser Group, Inc. All rights reserved.
 *
 */

package others;

import java.util.Scanner;

public class JaaReturn{
   public static void main(String[]args){
      int a;
      Scanner sc = new Scanner(System.in);

      while (true){
         System.out.println("Enter a number: 0 for exit:");
         a = sc.nextInt();

         if(a==0){
            System.exit(0);
         }
         boolean isValid = firstMethod(a);

         if (isValid){
            System.out.println("Congrats! you have  passed!");
         }
         else{
            System.out.println("Sorry!");
         }
      }
   }

   public static boolean firstMethod(int a){
      if(a>=35){
         System.out.println("");
         return true;
      }
      return false;
   }
}

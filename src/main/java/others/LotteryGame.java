/*
 *
 * Copyright (c) 2019 Ranser Group, Inc. All rights reserved.
 *
 */

package others;

import java.util.Random;
import java.util.Scanner;

public class LotteryGame{

   public static void main(String args[])
   {
      Scanner scanner=new Scanner(System.in);

      System.out.println("You have to pay 5 Dollars:");
      int readInitAmount = scanner.nextInt();

      if (readInitAmount != 5)
      {
         System.out.println("Incorrect! You have to pay 5$");
         System.exit(1);
      }
      else {
         System.out.println("Enter a num between 0 - 9");
         int luckyNum = scanner.nextInt();

         Random rand = new Random();
         int rand_int1 = rand.nextInt(10);
         int rand_int2 = rand.nextInt(10);
         int rand_int3 = rand.nextInt(10);

         int totalWinAmount = 0;

         if (luckyNum == rand_int1){
            System.out.println("You won 100 Rs!!! Matched 1 lucky number!");
            totalWinAmount +=100;

            if(luckyNum == rand_int2){
               System.out.println("You won 200 Rs!!! Matched 2 lucky numbers!");
               totalWinAmount +=200;

               if (luckyNum == rand_int3){
                  System.out.println("You won 300 Rs!!! Matched 3 lucky numbers!");
                  totalWinAmount +=300;
               }
            }
         }
         else {
            System.out.println("Sorry! Better luck next time!");
         }
         System.out.println("Total amount you won: "+totalWinAmount);
      }
   }
}
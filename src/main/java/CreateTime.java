/*
 *
 * Copyright (c) 2019 Ranser Group, Inc. All rights reserved.
 *
 */

import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class CreateTime{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Date currentTime = new Date();

        System.out.println("Note: +0530 IST and -0500 US\n");
        System.out.println("Enter minutes to subtract with current Date and Time:");
        int duration=sc.nextInt();   //1440;
        Date date = new Date();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        String lte= formatter.format(date);
        System.out.println("Current Time: "+lte);

        Date fromTime = new Date(currentTime.getTime() - duration * 60000); //60K (mili sec) = 1 MIN and duration (1440 min) = 1 day
        String gte = formatter.format(fromTime);
        System.out.println("Before  Time: "+gte);
    }
}

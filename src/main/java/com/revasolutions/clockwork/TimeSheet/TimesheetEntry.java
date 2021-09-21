package com.revasolutions.clockwork.TimeSheet;

import java.util.Scanner;


public class TimesheetEntry {

	static Scanner sc = new Scanner(System.in);


	public static void getInputData() {

		System.out.println("Welcome to clockwork api modules");
		System.out.println("Enter from the below choices");
		System.out.println("1> Find all the worklogs\n"+ "2> Find the timelog for a specific user in a specific time\n");
		int input = sc.nextInt();

		ControllerModule cmObj = entryMethod();
		switch(input) {
		case 1: 
			try {
				cmObj.getWholeWorkLog();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case 2:
			String userDetails[] = inputForSpecificUser();

			cmObj.getSpecificUserDetails(userDetails);
			break;


		}

	}

	public static ControllerModule entryMethod() {

		ControllerModule cm = new ControllerModule();
		return cm;
	}

	public static String[] inputForSpecificUser() {

		System.out.println("Enter the starting date");
		System.out.println("The date format should be in yyyy-mm-dd");
		String inputStartDate = sc.next().trim();

		System.out.println("Enter the ending date");
		System.out.println("The date format should be in yyyy-mm-dd");
		String inputEndDate = sc.next().trim();

		System.out.println("Enter the user-email OR userdisplayname");
		String userEmail = sc.next().trim();

		return new String[] {inputStartDate, inputEndDate, userEmail};

	}

}

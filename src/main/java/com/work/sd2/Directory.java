package com.work.sd2;

import java.util.Scanner;
public class Directory
{



   public static void main(String[] args)
   {
              Personnel per = new Personnel();
			  TotalObjects total = new TotalObjects();
			  Scanner scan = new Scanner(System.in);
              int choice = -1;


      do{


          System.out.println("Welcome to the Personnel Directory Management System");
          System.out.println("====================================================");

          System.out.println("\n\n\t 1. Add Personel");
          System.out.println("\n\t 2. Find Personel");
          System.out.println("\n\t 3. Print Names");
          System.out.println("\n\t 4. Number of Entries in the Directory");

          System.out.println("\n\t Select one of the options above (1, 2, 3, 4)");
          choice = scan.nextInt();
          scan.nextLine();

          switch(choice)
          {
			  case 1:
			  	String firstName1,middleName1,lastName1,type1;
			  	int empID1;
			  	double salary1;
			  System.out.println("Enter first name: ");
				  firstName1 = scan.nextLine();
			  System.out.println("Enter last name: ");
				  lastName1 = scan.nextLine();
			  System.out.println("Enter middle name: ");
				  middleName1 = scan.nextLine();
				  System.out.println("Enter the type: ");
				  type1 = scan.nextLine();
			  System.out.println("Enter employ id : ");
				  empID1 = scan.nextInt();
			  System.out.println("Enter base salary" );
				  salary1 = scan.nextDouble();

			  scan.nextLine();
			  per.addPersonnel( firstName1, middleName1, lastName1,empID1, salary1,type1);
			  total.objectAdded();

			  break;

			  case 2:
				String firstName2,lastName2;
			  System.out.println("Enter firts name : ");
				  firstName2 = scan.nextLine();

			  System.out.println("Enter last name : ");
				  lastName2 = scan.nextLine();



                                  boolean found = false;
			  		 			   int loc =-1;
			  		 			  for(int i =0; i <per.getPersonListSize(); i++)
			  		 			  {
			  		 			  	Person person = per.getPersonByOrder(i);
			  		 			  	if (person != null){
										if( person.getFirst().equals(firstName2) && person.getLast().equals(lastName2))
										{
											found = true;
											loc = i;
										}
									}
			  		 			  }

			  		 			  if(found)
			  		 			  {
			  		 				  System.out.println("Found");
			  		 				  per.getPersonByOrder(loc).printNameZero();

			  		 			  }else
			  		 			  {
			  		 				  System.out.println("not found");
			  		 				  per.addPerson(firstName2," ",lastName2);
			  		 				  total.objectAdded();
			                      }

              break;

			  case 3:

			  System.out.println("Enter the order 0: first, middle,  last, 1: first, last, middle, 2: last, first , middle ");
			  int order = scan.nextInt();
			  for(int i=0; i<per.getPersonListSize(); i++)
			  {
			  	switch (order){
					case 0:
						per.getPersonByOrder(i).printNameZero();
					break;
					case 1:
						per.getPersonByOrder(i).printNameFirst();
						break;
					case 2:
						per.getPersonByOrder(i).printNameSecond();
						break;
					default:
						System.out.println("error");
				}
			  }

               break;

			  case 4:
			  System.out.println("Total Entries : " + total.getTotalObjects());

               break;

		  }

		 } while(true);


  }

}
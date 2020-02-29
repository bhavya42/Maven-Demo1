package com.epam.maven_demo;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
public class NewYear implements Gift{
		String child_name;
		int tot_sweet,tot_Choclate;
		static int totalweight; 
		static sweet[] sweets;
		static Choclates[] Choclate;
		static NewYear gift[];
		
		static HashMap<String, Integer> a = new HashMap<>();
		static Scanner sc;
		
		NewYear(int sw_no, int ch_no ,String name)
		{
			child_name=name;
			sweets = new sweet[sw_no];
			Choclate = new Choclates[ch_no];
		}
		public void no_of_items()
		{
			System.out.println(sweets.length+Choclate.length+gift.length);
		}
		public static void addcount(String child_name, int quantity)
		{
			if(a.containsKey(child_name)) 
			{
				a.put(child_name,a.get(child_name)+quantity);
			}
			else
			{
				a.put(child_name,quantity);	
			}
			
		}
		
		public static void count_candies(int opt)
		{

			if(opt==1)
			{
				System.out.println("Enter the name of child whose candies you want to count: ");
				String name = sc.next();
				if(a.containsKey(name))
					System.out.println(name+"  has "+a.get(name)+" chocolates ");
				else
					System.out.println("No child by that name");
				
			}
			else if(opt==2)
			{
				System.out.println("Enter the value of n to find the number of gifts with no. of chocolates less than n:");
				int n = sc.nextInt();
				int count=0;
				for(int i=0;i<gift.length;i++)
				{
					if(gift[i].tot_Choclate<n)
						count++;
				}
				System.out.println(count);
			}
			else if(opt==3)
			{
				System.out.println("Enter the value of n to find the number of gifts with no. of chocolates more than n:");
				int n = sc.nextInt();
				int count=0;
				for(int i=0;i<gift.length;i++)
				{
					if(gift[i].tot_Choclate>n)
						count++;
				}
				System.out.println(count);
			}
		}
		
		
		public static void main(String args[])
		{
			 sc = new Scanner(System.in);
			 System.out.println("Enter the number of children for whom the new year gift has to be distributed: ");
			 int t = sc.nextInt();
			 gift = new NewYear[t];
			 for(int h=0;h<t;h++)
			 {
				System.out.println("Enter the name of the child: ");
				String child_name = sc.next();
				
				System.out.println("Enter the no. of types of sweets and chocolates in the gift: ");
				int no_of_sweets_type = sc.nextInt();
				int no_of_Chocolates_type = sc.nextInt();
				gift[h] = new NewYear(no_of_sweets_type,no_of_Chocolates_type,child_name);
				
				int sweet_weight,sweet_price,Choclate_weight,Choclate_price;	
				int sw_count=0;
				int Choclate_count=0;
				
				System.out.println("Enter the weight of sweets and price and quantity for all the sweets: ");
				for(int i=0;i<no_of_sweets_type;i++)
				{
				    sweet_weight= sc.nextInt();
				    sweet_price= sc.nextInt();
					int quantity =sc.nextInt();
					sw_count+=quantity;
					sweets[i]=new sweet(sweet_weight,sweet_price,quantity);
					gift[h].totalweight+=sweet_weight*quantity;
				}
				
				gift[h].tot_sweet=sw_count;
				
				if(no_of_Chocolates_type!=0)
					System.out.println("Enter the weight of chocolates ,price and quantity and flavour for all the chocolates: ");
				else
					addcount(child_name,0);
				
				for(int i=0;i<no_of_Chocolates_type;i++)
				{
					Choclate_weight = sc.nextInt();
				    Choclate_price = sc.nextInt();
					int quantity =sc.nextInt();
					String flavour=sc.next();
					Choclate_count+=quantity;
					Choclate[i]=new Choclates(Choclate_weight,Choclate_price,quantity,flavour);
					gift[h].totalweight+=Choclate_weight*quantity;
					addcount(child_name,quantity);
					
				}
		
				gift[h].tot_Choclate=Choclate_count;
				
				if(no_of_Chocolates_type!=0)
				{
					System.out.println("Select the basis for sorting chocolates\n 1.Price 2.Weight 3.Quantity");
					int op=sc.nextInt();
					Arrays.sort(Choclate,new sort_Choclates(op));
					System.out.println("After sorting chocolates in a gift according to selected option");
					for(int j=0;j<no_of_Chocolates_type;j++) 
					{
						System.out.print(Choclate[j]);
						System.out.println();
					}
				}
					System.out.println();
			 }
			 
			 
			System.out.println("Counting the candies in a gift");
			System.out.println("You have the following options:\n1.Count candies for a particular child.\n"
					+ "2.Count gifts with chocolates less than a value.\n3.Count gifts with chocolates less than a value");
			
			System.out.println("Enter the option: ");
			int opt = sc.nextInt();
			count_candies(opt);
			
			System.out.println("Total Weight of the new year gifts is: "+totalweight);
			sc.close();
		}
	}



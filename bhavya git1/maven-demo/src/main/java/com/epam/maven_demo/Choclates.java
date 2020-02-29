package com.epam.maven_demo;

public class Choclates extends sweet {
		String flavour;
		Choclates(int weight, int price,  int no, String flavour)
		{
			super(weight,price,no);
			this.flavour=flavour;
		}
		public  String toString() {
			return "Price: "+this.price+" Weight: "+this.weight+" Quantity: "+this.no;
			}
	}


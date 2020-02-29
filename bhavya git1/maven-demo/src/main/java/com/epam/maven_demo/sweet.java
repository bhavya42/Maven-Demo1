package com.epam.maven_demo;
public class sweet
{
    int price,weight;
    int no;
	sweet(int w,int p, int n)
	{
		this.price=p;
		this.weight=w;
		this.no=n;
	}
	public String toString() 
	{
		return "Price: "+this.price+" Weight: "+this.weight+" Quantity: "+this.no;
	}

}



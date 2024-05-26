package hello;

import java.util.Scanner;

public class 数字特征值 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int number;
		int count = 0;
		double result = 0;
		number = in.nextInt();
		if( number>=0 & number<=1000000)
		{
			do
			{
				int digit = number % 10;
				count = count+1;
				int x = (digit+count+1)%2;
				result = Math.pow(2*x, count-1) + result;
				number = number / 10;
			} while ( number >0 );
		}
		System.out.println( (int)result );
		
		

	}

}

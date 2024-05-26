package hello;

import java.util.Scanner;

public class 奇偶个数 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int number;
		int count = 0;
		int odd = 0; 
		number = in.nextInt();
		if ( number>0 & number<100000)
		{
			do
			{
				number = in.nextInt();
				count = count+1;
				if ( (number+1)%2 == 0 )
				{
					odd = odd+1;
				}
			} while( number != -1 );
				System.out.println( odd+" "+(count-odd));
				
		}
		
		
			
			
		}

	}



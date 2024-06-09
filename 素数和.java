package hello;

import java.util.Scanner;

public class 素数和 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int k = 2;
		
		int count = 0;
		int sum = 0;
//		判断变量k是否为素数
		while ( k != 0 )
		{
			boolean isPrime = true;
			for ( int i =2; i < k; i++ )
			{
				if ( k % i == 0 )
				{
					isPrime = false;
					break;
				}
			}
//			记录素数位数count，count在[m,n]范围内时循环，超过范围停止计算
			if ( isPrime )
			{
				count++;
				if ( count >= n && count <= m )
				{
					sum += k;
				}
				if ( count>m )
				{
					break;
				}
			}
			k++;
		}
		System.out.println( sum );
		
	}

}

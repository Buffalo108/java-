package hello;

import java.util.Scanner;

public class 念整数 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		int[] n = new int[10];
		int count = 0;
		if ( num >= -10000 && num <= 10000 )
		{
			if ( num < 0 )
			{
				System.out.print("fu"+" ");
				num = - num;
			}
			if ( num == 0 )
			{
				System.out.print("ling");
			}
			else
			{
				for ( int i = 0; num != 0; i++ )
				{
//					数组参与运算，n[0]-个位数，n[1]-十位数……，num=0时，结束循环，记录所得count和n[i]进入下个循环
					n[i] = num % 10;
					num /= 10;
//					count记录整数的位数
					count ++;
				}
//				遍历数组输出
				for ( int i = count-1; i >= 0; i-- )
				{
					switch( n[i] )
					{
					case 0:
						System.out.print("ling");
						break;
					case 1:
						System.out.print("yi");
						break;
					case 2:
						System.out.print("er");
						break;
					case 3:
						System.out.print("san");
						break;
					case 4:
						System.out.print("si");
						break;
					case 5:
						System.out.print("wu");
						break;
					case 6:
						System.out.print("liu");
						break;
					case 7:
						System.out.print("qi");
						break;
					case 8:
						System.out.print("ba");
						break;
					case 9:
						System.out.print("jiu");
						break;
					default:
						System.out.print("error");
						break;
					}
					if( i != 0 )
					{
						System.out.print(" ");
					}
				}
				
			}
		}
		else
		{
			System.out.println("error");
		}
		

	}

}

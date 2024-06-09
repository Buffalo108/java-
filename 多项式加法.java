package hello;

import java.util.Scanner;

public class 多项式加法 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
//		a为幂次
		int[] powers = new int[ a+1 ];
//		建立幂次数组,幂次——系数
		int b;
//		b为系数
		int max = a;
//		记录最高幂次
		int count = 0;
//		记录输入的多项式幂次数
		while ( a>=0 && a<=100 )
		{
			if ( a==0 )
			{
				if(count == 0)
				{
					count++;
				}
//				当第一次输入的幂次是0，则记录下来，count+1，防止直接识别成最后一个停止计算
				else
				{
					b = in.nextInt();
					powers[a] += b; 
					break;
				}
			}
			else
			{
				b = in.nextInt();
				powers[a] += b;
				a = in.nextInt();
			}
			
			
		}
//		输出：题目中最后一行是0次幂，作为循环结束的标志
//		    ①如果最高次幂是0，直接输出常数后跳出循环
//		    ②系数(powers[i])等于0时不需要输出，直接进入下一轮循环
//		    ③系数>0时,对幂次的三种情况讨论,>1; =1; =0,排最后；
		for( int i = max; i>=0; i-- )
		{
			if ( max == 0 )
			{
				System.out.print( powers[a] );
				break;
			}
			else if ( powers[i] == 0 )
			{
				continue;
			}
			else if ( powers[i]>0 )
			{
				if( powers[i] != 1 )
				{
					if( i>1 )
					{
						System.out.print( powers[i]+"x"+i );
					}
					else if ( i==1 )
					{
						System.out.print( powers[i]+"x" );
					}
					else if ( i==0 )
					{
						System.out.print( powers[i] );
					}
				}
			}
			if (i!= 0)
			{
				System.out.print( "+" );
			}
		}
	

	}

}

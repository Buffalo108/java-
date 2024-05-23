package hello;

import java.util.Scanner;

public class 时间换算 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int bjt;
		bjt = in.nextInt();
		int utc = 0;
		if( bjt>=0 & bjt<=2359 )
		{
			if( bjt>=800 )
			{
				utc = bjt-800;
				System.out.println(utc);
			}
			else
			{
				utc = bjt-800+2400;
				System.out.println(utc);
			}
		}
		else
		{
			System.out.println("请输入0～2359范围的数字");
		}
	}

}

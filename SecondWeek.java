package hello;

import java.util.Scanner;

public class SecondWeek {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//        Scanner in = new Scanner(System.in);
//        int bjt;
//        bjt = in.nextInt();
//        int utc = 0;
//        if( bjt<=2359 )
//        {
//        	if( bjt>=800 )
//        	{ 
//        		utc = bjt-800;
//        	}
//        	else if( bjt<800)
//        	{
//        		utc =bjt-800+2400;
//        	}
//        	System.out.println(utc);
//        }
//        else if( bjt>2359 )
//        {
//        	System.out.println("请输入0～2359范围的数字");
//        }
		
		
//		时间换算
//		Scanner in = new Scanner(System.in);
//		int bjt;
//		bjt = in.nextInt();
//		int utc = 0;
//		if( bjt>=0 & bjt<=2359 )
//		{
//			if( bjt>=800)
//			{
//				utc = bjt-800;
//				System.out.println(utc);
//			}
//			else
//			{
//				utc = bjt-800+2400;
//				System.out.println(utc);
//			}
//		}
//		else
//		{
//			System.out.println("请输入0～2359范围的数字");
//		}
		
		
		
		
//		信息报告
		Scanner in = new Scanner(System.in);
		int num;
		num = in.nextInt();
		int R = num/10;
		int S = num%10;
		if( num>=11 & num<=59 )
		{
			switch( S )
			{
			case 1:
				System.out.print("Faint signals, barely perceptible,");
				break;
			case 2:
				System.out.print("Very weak signals,");
				break;
			case 3:
				System.out.print("Weak signals,");
				break;
			case 4:
				System.out.print("Fair signals,");
				break;
			case 5:
				System.out.print("Fairly good signals,");
				break;
			case 6:
				System.out.print("Good signals,");
				break;
			case 7:
				System.out.print("Moderately strong signals,");
				break;
			case 8:
				System.out.print("Strong signals,");
				break;
			case 9:
				System.out.print("Extremely strong signals,");
				break;
			}
			
			switch( R )
			{
			case 1:
				System.out.print("unreadable.");
				break;
			case 2:
				System.out.print("barely readable,occasional words distinguishable.");
				break;
			case 3:
				System.out.println("readable with considerable difficulty.");
				break;
			case 4:
				System.out.println("readable with practically no difficulty.");
				break;
			case 5:
				System.out.println("perfectly readable.");
				break;
			}
		}
		else
		{
			System.out.println("请输入[11,59]内的数字");
		}
		
		
		
		
		
	}

	private static void swich(int s) {
		// TODO Auto-generated method stub
		
	}

	}
		   
		        
		

        
        
        	
  


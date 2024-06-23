package fraction;

import java.util.Scanner;

public class Fraction {
	private int a;
	private int b;
//	构造方法
	public Fraction(int a,int b)
	{
		this.a = a;
		this.b = b;
		simp();/* 调用simp方法简化分数 */
	}
//	将分数转换为double
	public double toDouble()
	{
		return ((double)a)/b;
	}
	
	public void print()
	{
		if ( a==1 && b==1 )
		System.out.println(1);
		else
			System.out.println(a+"/"+b);
	}
//	两个分数相加
	public Fraction plus(Fraction r)
	{
		int fenzi = a*r.b+r.a*b;
		int fenmu = b*r.b;
		return new Fraction(fenzi, fenmu);
	}
//	两个分数相乘
	Fraction multiply(Fraction r)
	{
		return new Fraction(a*r.a,b*r.b);
	}

//	辗转相除法求最大公约数
	private int gcd(int a,int b)
	{
		while ( b != 0 )
		{
			int t = a % b;
			a = b;
			b = t;
		}
//		b为0时，a为最大公约数
		return a;
	}
//	简化分数的方法
	private void simp()
	{
		int gcd = gcd(a,b);
		if( gcd != 1)
		{
			a = a/gcd;
			b = b/gcd;
		}
//		确保分母为正
		if(b<0)
		{
			a = -a;
			b = -b;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
	    Fraction a = new Fraction(in.nextInt(), in.nextInt());
        Fraction b = new Fraction(in.nextInt(), in.nextInt());
        a.print();
        b.print();
        a.plus(b).print();
        a.multiply(b).plus(new Fraction(5, 6)).print();
        a.print();
        b.print();
        in.close();
		
	}
 }

	

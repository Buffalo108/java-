//个代码定义了一个名为City的Java类，该类主要用于管理城市以及城市之间的距离。
//代码由三个主要部分组成：输入城市名称、设置城市之间的距离、查询两个城市之间的距离。

package vendingmachine;//声明该类属于vendingmachine包。

import java.util.HashMap;//导入HashMap类，用于存储城市名称和对应的编号。
import java.util.Scanner;//导入Scanner类，用于从控制台读取输入。

//类定义和成员变量
public class City { //定义City类。
//	定义一个私有的HashMap，用于存储城市名称（字符串）和对应的编号（整数）
	private HashMap<String, Integer> city = new HashMap<String, Integer>();
//	定义一个二维数组，用于存储城市之间的距离。
		int [][] dis;
//	一个叫 dis 的二维数组变量，内容对应城市里程
	Scanner in = new Scanner(System.in);
	
//	输入城市名称的方法
	public void input() { //定义一个input方法，用于输入城市名称
		System.out.println("Please enter the cities");
		int value=0;
		while(true)//使用一个无限循环来读取用户输入的城市名称。
		{
			String s = in.next();//读取一个城市名称。
			if(s.equals("###")) {
				break;
			}
			city.put(s, value++);//将城市名称和对应的编号存入HashMap。
		}
	}
	
//	设置城市之间距离的方法
	public void setdistance() {	//定义一个setdistance方法，用于设置城市之间的距离。
		System.out.println("Please enter the distance");
		int size = city.size();//获取城市数量
		dis = new int[size][size];//初始化一个二维数组，大小为城市数量的平方。
		for(int i=0; i<size; i++)//读取用户输入的距离并存入二维数组中
		{
			for(int j=0; j<size; j++) 
			{
				dis[i][j] = in.nextInt();
			}
		}
	}
	
//	查询城市之间距离的方法
	public void getdistance() { //定义一个getdistance方法，用于查询两个城市之间的距离。
		System.out.println("Search for what?");
		String a = in.next();//读取两个城市名称
		String b = in.next();
		int result = dis[city.get(a)][city.get(b)];//从二维数组中获取两个城市之间的距离。
		System.out.println(result);
	}



//	主方法
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    		City c = new City();//创建City类的实例。
    		c.input();//调用input方法，输入城市名称。
    		c.setdistance();//调用setdistance方法，设置城市之间的距离。
    		c.getdistance();//调用getdistance方法，查询两个城市之间的距离。

	}

}

//构造方法：生存时间20，生育年龄4；
//重写抽象方法：animal的生育、进食；
//生育：5%概率生育，返回 Animal；
//进食：返回cell(传入附近兔子数组)，被吃掉概率0.2，可通过cell是否为null判断给否被吃掉；
//重写接口cell方法：draw，传入cell 图，坐标，大小；

//Fox 类继承自 Animal 类并实现了 Cell 接口。
//包含一个构造函数设置 Fox 的最大年龄和生育年龄。
//draw 方法用于绘制 Fox 的图形。
//breed 方法用于 Fox 繁殖，有 5% 的概率创建一个新的 Fox。
//toString 方法返回 Fox 的字符串表示。
//feed 方法模拟 Fox 的捕食行为，有 20% 的概率捕食邻近的动物，并延长其寿命。

//包声明和导入
package animal;

import java.awt.Color;//导入color类用于处理颜色
import java.awt.Graphics;//导入 Graphics 类用于绘图
import java.util.ArrayList;//导入 ArrayList 类用于处理动态数组

import cell.Cell;//导入 Cell 接口

//构造函数
public class Fox extends Animal implements Cell{
	public Fox(){
		super(20,4);  //调用父类 Animal 的构造函数，设置 Fox 的最大年龄为 20，生育年龄为 4
	}
	
//	绘图方法
	@Override//注解表示此方法覆盖了父类或接口中的方法
	//draw 方法，用于绘制 Fox 的图形
	public void draw( Graphics g, int x, int y, int size ){
		//计算透明度值 alpha，透明度随年龄增加而降低
		int alpha = (int)((1-getAgePercent())*255);
		//设置颜色为具有透明度的黑色
		g.setColor(new Color(0,0,0,alpha));
		//在指定位置绘制一个指定大小的矩形
		g.fillRect(x, y, size, size);
	}
	
//	breed 方法，返回一个 Animal 对象
	@Override
	public Animal breed() { 
		Animal ret = null;
		if( isBreedable() && Math.random() < 0.05 ){ //如果Fox处于可繁殖状态并且有5%的概率发生繁殖
			ret = new Fox(); //创建并返回一个新的 Fox 对象
		}
		return ret;
	}
	
//	toString方法
	@Override
	public String toString(){
		return "Fox:"+super.toString();
	}
	
//	feed方法
	@Override
//	定义 feed 方法，返回一个Animal对象，接受一个包含邻近动物的 ArrayList 作为参数
	public Animal feed(ArrayList<Animal> neighbour){    //返回被吃的兔子
		Animal ret = null;
		if( Math.random() < 0.2 ){//有 20% 的概率进行喂食行为，即达到一定的几率，就随机在它周围的邻居的兔子当中挑选一个兔子
			//随机选择一个邻近的动物，并将其赋值给 ret
			ret = neighbour.get((int)(Math.random()*neighbour.size()));
			//调用 longerlife 方法，将 Fox 的寿命延长 2 个单位
			longerlife(2);//吃掉后延长自己的寿命
		}
		return ret;//返回 ret，如果不满足条件则返回 null
	}
}


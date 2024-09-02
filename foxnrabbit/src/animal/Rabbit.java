//Rabbit类：继承animal，cell
//构造方法：生存时间10，生育年龄2；
//重写抽象方法：animal的 生育、进食；
//生育：12%概率生育，返回 Animal；
//重写接口cell方法：draw，传入cell 图，坐标，大小；

//包声明和导入
package animal;

import java.awt.Color;
import java.awt.Graphics;

import cell.Cell;

//构造函数
public class Rabbit extends Animal implements Cell{
	public Rabbit() {
		super(10, 2);//调用父类 Animal 的构造函数，设置Rabbit的最大年龄为10，生育年龄为2
	}

	@Override
//	draw函数
	public void draw(Graphics g, int x, int y, int size) {
		int alpha = (int)((1-getAgePercent())*255);//透明度
		g.setColor(new Color(255,0,0,alpha));//颜色
		g.fillRect(x, y, size, size);//画矩形
	}

//	breed函数
	@Override
	public Animal breed() {
		Animal ret = null;
		if( isBreedable() && Math.random() < 0.12 ){   //12%的几率breed
			ret = new Rabbit();
		}
		return ret;
	}
	
//	toString函数
	@Override
	public String toString(){
		return "Rabbit:"+super.toString();
	}
}

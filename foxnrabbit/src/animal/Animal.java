//animal抽象类是fox，rabbit的父类：
//属性：ageLimit(生存时间)，breedableAge(生育年龄)，age(现年龄)，isAlive；
//方法：
//**构造方法：**生存时间、生育年龄；
//**简单方法：**获取年龄、年龄百分比（决定各自颜色的深浅）、成长(到年龄死亡)、见耶稣、确定没死、确定能生、寿命增长的方法；
//**抽象方法：**生育；
//移动方法:
//传入周围空cell坐标，返回其中一个空cell坐标。
//**Animal返回值方法：**进食

package animal;

import java.util.ArrayList;

import field.Location;

public abstract class Animal{
	private int ageLimit;//生存时间
	private int breedableAge;//生育年龄
	private int age;//当前年龄
	private boolean isAlive = true;//是否活着
	
	public Animal(int ageLimit, int breedableAge){
		this.ageLimit = ageLimit;
		this.breedableAge = breedableAge;
	}
	
//	获取年龄方法
	protected int getAge(){
		return age;
	}
	
//	获取年龄百分比方法
	protected double getAgePercent(){
		return (double)age/ageLimit;
	}
	
//	抽象方法，生育
	public abstract Animal breed();
	
//	grow方法
	public void grow(){
		age++;
		if(age > ageLimit){
			die();
		}
	}

//	die方法
	private void die() {
		isAlive = false;
	}
	
//  判断isAlive方法
	public boolean isAlive(){
		return isAlive;
	}
	
//	判断isBreedable方法
	public boolean isBreedable(){
		return age >breedableAge;
	}
	
//	move方法
    //在满足特定条件（邻近位置数组非空且有 2% 的概率）时，从可用的邻近位置中随机选择一个返回；如果条件不满足，则返回 null。
    //传入周围空cell坐标，返回其中一个空cell坐标，**Animal返回值方法：**进食
	//初始化一个 Location 类型的变量 ret，初始值为 null。如果条件不满足，方法将返回 null
	public Location move(Location[] freeAdj){//表示传入一个 Location（坐标）对象数组，代表所有可用的邻近位置
		Location ret = null;
    //首先检查 freeAdj 数组是否非空，即 freeAdj.length > 0。
    //然后生成一个随机数 Math.random()，范围在 [0.0, 1.0) 之间。如果这个随机数小于 0.02（即 2% 的概率），条件成立。
	//即在一定的概率下去随机找一个空的位置，然后返回那个位置
		if( freeAdj.length > 0 && Math.random() < 0.02 ){
			//选择随机位置
			//当条件成立时，生成一个在 [0, freeAdj.length) 范围内的随机整数索引
			//使用该索引从 freeAdj 数组中随机选择一个位置，并赋值给 ret
			ret = freeAdj[(int)(Math.random()*freeAdj.length)];
			//当条件成立时，生成一个在 [0, freeAdj.length) 范围内的随机整数索引。
			//使用该索引从 freeAdj 数组中随机选择一个位置，并赋值给 ret。
		}
		return ret;
	}
	
	@Override
//	toString方法,返回:age:live/dead
	public String toString(){
		return " "+age+":"+(isAlive?"live":"dead");
		//根据 isAlive 的布尔值决定返回 "live" 或 "dead"
	}
//	feed方法
	public Animal feed(ArrayList<Animal> neighbour){
		//ArrayList<Animal> neighbour 是方法的参数,表示传入一个包含 Animal 对象的 ArrayList，代表邻近的动物。
		return null;//在子类中覆盖
	}
//	longerlife方法,增加动物的最大年龄
	protected void longerlife( int addage ){
		ageLimit += addage;//ageLimit += addage 表示将传入的 addage 值加到 ageLimit 上，即延长动物的最大年龄。
	}
}

                        

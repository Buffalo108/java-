//FoxAndRabbit程序执行入口：
//主要思想：两层for循环，挨个cell执行移动、进食、生育；每次循环结束后repaint view；

//包声明和导入
package foxnrabbit;

import field.Field;
import field.View;
import field.Location;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import animal.Fox;
import animal.Rabbit;
import animal.Animal;
import cell.Cell;



//类声明
public class FoxAndRabbit{
	//成员变量,数据和画面
	private Field thefield;
	private View theview;
	private JFrame frame; 
	
	
//	//新做出来一个类,内部类
//	private class StepListener implements ActionListener{
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			// TODO Auto-generated method stub
//		step();
//		frame.repaint();
//		}
//	}
	
	//构造函数，初始化模拟场地并创建图形界面
	public FoxAndRabbit( int size ){
		thefield = new Field(size, size);//创建一个 Field 对象，大小为 size x size。
		//双重循环遍历场地的每个位置，根据随机数决定放置 Fox 或 Rabbit
		for( int row = 0; row <thefield.getHeight(); row++ ){
			for( int col = 0; col < thefield.getWidth(); col++ ){
				double probability = Math.random();
				if( probability <0.05 ){
					thefield.place( row, col, new Fox());
				}else if( probability < 0.15 ){
					thefield.place( row, col, new Rabbit());
				}
			}
		}
//View		
		//创建一个 View 对象，传入 Field
		theview = new View(thefield);
		//配置 JFrame，添加视图，设置基本属性并显示
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle("FoxAndRabbit");
		frame.add(theview);
		//给面板加按钮
		JButton btnStep = new JButton("单步");
		frame.add(btnStep, BorderLayout.NORTH);
		btnStep.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("按下啦");
				step();
				frame.repaint();
			}
		});
		
		frame.pack();
		frame.setVisible(true);
	}
	
//模拟一步	
	public void step(){//定义模拟的一步
		//双重循环遍历场地的每个位置
		for( int row = 0; row < thefield.getHeight(); row++ ){
			for( int col = 0; col < thefield.getWidth(); col++ ){
				Cell cell = thefield.get(row, col);//获取当前的cell,
				if( cell != null ){//如果非空,
					Animal animal = (Animal)cell;//将其转换为Animal，拿到的是cell，将cell造型cast成animal
					animal.grow();//动物生长,
					if( animal.isAlive()){//并检查上是否存活
                    //如果存活,1,2,3
						//1.move:根据可用邻近位置移动
						Location loc = animal.move(thefield.getFreeNeighbour(row, col));
						if( loc != null ){
							thefield.move(row, col, loc);
						}
						//2.eat:如果是 Fox，尝试捕食邻近的 Rabbit 
						if( animal instanceof Fox){
							Cell[] neighbour = thefield.getNeighbour(row, col);
							ArrayList<Animal> listRabbit = new ArrayList<Animal>();//判断是不是兔子
							for( Cell an : neighbour ){
								if( an instanceof Rabbit ){
									listRabbit.add( (Rabbit)an );
								}
							}
							if( !listRabbit.isEmpty() ){
								Animal fed = animal.feed(listRabbit);
								if( fed != null ){
									thefield.remove((Cell)fed);
								}
							}
						}
						//3.breed:尝试繁殖新动物并放置在邻近位置
						Animal baby = animal.breed();
						if( baby != null ){
							thefield.placeRandomAdj(row, col, (Cell)baby);
						}
					}else{//如果死亡,则移除
						thefield.remove(row, col);
					}
				}
			}
		}	
	}

	
//开始模拟	
	public void start( int steps ){//定义模拟的开始，接受步数作为参数
//		执行steps次
		for( int i = 0; i < steps; i++ ){
			step();//调用 step() 执行一步模拟
			theview.repaint();//刷新视图
			try{//线程休眠 200 毫秒
				Thread.sleep(200);
			}catch (InterruptedException e){
				e.printStackTrace();
			}
		}
	}
//主方法	
	public static void main(String[] args) {//程序的入口
		FoxAndRabbit fnr = new FoxAndRabbit(30);//创建一个 FoxAndRabbit 对象，场地大小为 30 x 30
//		fnr.start(10);//开始模拟，执行 10 步
	}
}

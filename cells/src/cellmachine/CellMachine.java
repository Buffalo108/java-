package cellmachine;//负责逻辑架构，视线最终的业务逻辑，它本身并不是实际的东西，而是一个逻辑

import javax.swing.JFrame;

import cell.Cell;
import field.Field;
import field.View;

public class CellMachine {
   
	public static void main(String[] args) {
		
//Field,准备数据
		//调用field中的get和place方法，数据和方法体都在field中，这里只是调用
		Field field = new Field(30,30);
		//建立30X30大的数组，往格子里放细胞(默认die)
		for ( int row = 0; row<field.getHeight(); row++ ) {
			for ( int col = 0; col<field.getWidth(); col++ ) {
				field.place(row, col, new Cell());
			}
		}
		//初始化确定最开始细胞的数量,设置1/5数量的细胞会reborn
		for ( int row = 0; row<field.getHeight(); row++ ) {
			for ( int col = 0; col<field.getWidth(); col++ ) {
				Cell cell = field.get(row, col);
				if ( Math.random() < 0.2 ) {//random：返回0-1之间的随机数，意思是这个位置上的cell有1/5的可能性reborn
					cell.reborn();
				}
			}
		}
//View，窗口，接受Field的信息
//		JFrame是Java自带的，不用新建一个class
		View view = new View(field);//view对应相应的field	
		JFrame frame = new JFrame();//JFrame是Swing库中的一个类，用于创建窗口。这个窗口可以包含按钮、文本框、标签等Swing组件
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口键
		frame.setResizable(false);//表示不可以改变窗口大小
		frame.setTitle("Cells");
		frame.add(view);
		frame.pack();//自己决定大小
		frame.setVisible(true);//画出画面
		
//建立View和Field间的互动
//		View只管根据Field画出图形，Field只管储存数据，一旦数据更新，会通知View画出整个画面
//		核心:每一轮去取出相应的格子来,取出一个格子后,调用Field函数的方法去得到所有的邻居,然后根据邻居来判断我的情况
		for ( int i=0; i<1000; i++ ) {
			for ( int row = 0; row<field.getHeight(); row++ ) {
				for ( int col = 0; col<field.getWidth(); col++ ) {
					Cell cell = field.get(row, col);//调用field函数中get方法
//					用field方法区找到cell的八个邻居,然后去遍历所有的邻居放入数组
//					调用field对象的getNeighbour方法，传入行和列索引，以获取位于(row, col)位置的单元格的邻居，并将这些邻居存储在neighbour数组中
					Cell[] neighbour = field.getNeighbour(row, col);
					int numOfLive = 0;
					for ( Cell c : neighbour ) {
//						如果某一个邻居时活着的,那数量++,得到周围有多少邻居活着
						if ( c.isAlive() ) {//调用cell中的查询死活方法
							numOfLive++;
						}
					}
					System.out.print("["+row+"]["+col+"]:");
					System.out.print(cell.isAlive()?"live":"dead");
					System.out.print(":"+numOfLive+"-->");
					if ( cell.isAlive() ) {//调用cell函数中的isAlive函数，查询细胞的状态
						if ( numOfLive <2 || numOfLive >3 ) {
							cell.die();//如果数目满足这个条件，就调用cell中的die方法，把alive设置成false
							System.out.print("die");
						}
					} else if ( numOfLive == 3 ) {
						cell.reborn();
						System.out.print("reborn");
					}
//					根据数目决定调用Cell函数中的die或alive函数
					System.out.println();
				}
			}
			System.out.println("UPDATE");
			frame.repaint();//得到所有cell的状态,得到cell的状态后区repaint
//			repaint方法的作用是请求重新绘制该窗口或框架。当你更改了窗口中的某些内容，并希望这些更改立即反映在屏幕上时，你会调用这个方法。
//			相当于向系统发出一个刷新请求
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//			这段代码包含了一个try-catch块，用于处理可能发生的异常。
//			Thread.sleep(200);是尝试让当前线程暂停执行200毫秒（0.2秒）。这是一个静态方法，属于Thread类。
//			InterruptedException是Thread.sleep方法可能抛出的异常，表示线程的睡眠状态被中断。这种情况通常发生在其他线程调用了当前线程的interrupt方法时。
//			如果InterruptedException异常发生，catch块将被执行。e.printStackTrace();将打印异常堆栈跟踪到标准错误流，这有助于调试和诊断问题。
		}
		
		
	}

}

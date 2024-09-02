//类表达的是东西，接口表达的是概念。
//cell作用：所有实现了cell这个接口的类的对象可以被放到filed里面去，用cell接口的类要去override cell的draw方法，
//然后才能在view和filed之间的关系里面被画出来
package cell;

import java.awt.Graphics;

public interface Cell {
	void draw( Graphics g, int x, int y, int size);
}


//定义实体类：包括狐狸和兔子，继承自通用的动物类，提供生长、繁殖、捕食等行为。
//定义场地类：用于管理和操作动物的位置。
//定义视图类：用于绘制场地和动物。
//定义主类：初始化场地和动物，控制模拟步骤和显示。
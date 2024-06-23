package clock;
//这个是整个程序中真正的main
//public class Clock 定义了一个名为 Clock 的公共类。
public class Clock {
//	这个类里面有两个Display类型的成员,注意new之后这个变量才真正存在
//	有了这两个才表明，制造一个clock对象的时候会制造出两个dispaly的对象
//	表示分钟的 Display 对象，初始值为 new Display(60)，即创建了一个 Display 对象，最大值为60。
//	这里的初始赋值可删去，与下面的public Clock初始赋值重复了
	private Display minute = new Display(60);
	private Display hour = new Display(24);
	private Display second = new Display(60);
	
//	start 方法: 这个方法启动一个无限循环，不断增加分钟数
    public void start()
    {
		while (true)/* 无限循环 */
    	{
    		minute.increase();
        	if ( minute.getValue() == 0 )
//        		方法调用，用于获取 minute 对象当前的值
        	{
        		hour.increase();
        	}
//        	printf表示带格式的输出，"%02d:%02d\n"用来说明想要什么格式
//        	%02d表示占据两个字符的位置，如果只有个位数，则用0填充
        	System.out.printf( "%02d:%02d\n",hour.getValue(),minute.getValue());
    	}
    }
    
//    构造函数：用hour, minute和second初始化时间
    public Clock(int hour, int minute, int second) {
//    	public Clock(int hour, int minute, int second) 是一个构造函数，它接受三个整数参数 hour、minute 和 second
//      创建一个新的 Display 对象，最大值为24，并赋值给 hour 成员变量
    	this.hour = new Display(24);   // 24 小时制
        this.minute = new Display(60); // 60 分钟制
        this.second = new Display(60); // 60 秒钟制
    }
    
//   tick 方法:  “嘀嗒”一下，时间走1秒,每次调用增加一次秒数，并根据秒、分钟的变化情况调整分钟和小时
    public void tick() {
    	second.increase(); 
        if (second.getValue() == 0)
        {
            minute.increase(); 
            if (minute.getValue() == 0) 
            {
                hour.increase(); 
            }
        }
    }
    
//    返回一个String的值，以“hh:mm:ss“的形式表示当前时间。这里每个数值都占据两位，不足两位时补0。如“00:01:22"。注意其中的冒号是西文的，不是中文的。
//    public：表示这个方法是公共的，可以从任何地方访问。
//    String：方法的返回类型是字符串。
//    toString()：方法名是 toString，没有参数。
    public String toString() {
//    	%02d 表示一个两位的十进制整数。如果整数少于两位，用前导零填充。
//    	: 是分隔符，用于分隔小时、分钟和秒。
//    	整个格式字符串表示时间的格式为 HH:MM:SS。
    	return String.format("%02d:%02d:%02d", hour.getValue(), minute.getValue(), second.getValue());
    }
//    这个 toString 方法的作用是提供一个人类可读的、标准化的 Clock 对象的字符串表示形式。这样，当你打印 Clock 对象或将其转换为字符串时，会得到一个格式为 HH:MM:SS 的时间字符串。
//    hour.getValue()：调用 hour 对象的 getValue 方法，返回当前小时的值。
//    String.format 将这些值插入到格式字符串中，生成一个格式化的时间字符串。
    	
    public static void main(String[] args) {
		java.util.Scanner in = new java.util.Scanner(System.in);
		Clock clock = new Clock(in.nextInt(), in.nextInt(), in.nextInt());
		clock.tick();
		System.out.println(clock);
		in.close();

}
}
	


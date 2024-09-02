package castle;

import java.util.Scanner;

public class Game {
    private Room currentRoom;
        
    public Game() 
    {
        createRooms();
    }

    private void createRooms()
    {
        Room outside, lobby, pub, study, bedroom;
      
        //	制造房间
        outside = new Room("城堡外");
        lobby = new Room("大堂");
        pub = new Room("小酒吧");
        study = new Room("书房");
        bedroom = new Room("卧室");
        
        //	初始化房间的出口
        outside.setExit("east", lobby);
        outside.setExit("south", study);
        outside.setExit("west", pub);
        lobby.setExit("west", outside);
        pub.setExit("east", outside);
        study.setExit("north", outside);
        study.setExit("east", bedroom);
        bedroom.setExit("west", study);

        lobby.setExit("up", pub);
        pub.setExit("down", lobby);
        currentRoom = outside;  //	从城堡门外开始
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("欢迎来到城堡！");
        System.out.println("这是一个超级无聊的游戏。");
        System.out.println("如果需要帮助，请输入 'help' 。");
        System.out.println();
//        System.out.println("现在你在" + currentRoom);
//        System.out.print("出口有：");
//        
//        if(currentRoom.northExit != null)
//            System.out.print("north ");
//        if(currentRoom.eastExit != null)
//            System.out.print("east ");
//        if(currentRoom.southExit != null)
//            System.out.print("south ");
//        if(currentRoom.westExit != null)
//            System.out.print("west ");
//        System.out.println();
        showPrompt();
    }

    // 以下为用户命令

    private void printHelp() 
    {
        System.out.print("迷路了吗？你可以做的命令有：go bye help");
        System.out.println("如：\tgo east"); //"\t"表示tab
    }

    //根据指定的方向移动到当前房间的相邻房间
    //方法签名：方法名为 goRoom，接受一个 String 类型的参数 direction，用来指定移动的方向。
    private void goRoom(String direction) 
    {
    	//局部变量：声明了一个 Room 类型的变量 nextRoom，初始化为 null。这个变量将用来存储移动后的房间对象。
        
    	Room nextRoom = currentRoom.getExit(direction);
    	
//        //方向判断,玩家输入一个方向，判断那个方向上有没有东西
//        if(direction.equals("north")) {
//            nextRoom = currentRoom.northExit;
//        }
//        if(direction.equals("east")) {
//            nextRoom = currentRoom.eastExit;
//        }
//        if(direction.equals("south")) {
//            nextRoom = currentRoom.southExit;
//        }
//        if(direction.equals("west")) {
//            nextRoom = currentRoom.westExit;
//        }
       
        if (nextRoom == null) {
            System.out.println("那里没有门！");
        }
        else {
        	currentRoom = nextRoom;
        	showPrompt();
        }
    }

   

//    用函数整合弹框提示
	public void showPrompt() {
      System.out.println("你在" + currentRoom);
      System.out.print("出口有: ");
//      if(currentRoom.northExit != null)
//          System.out.print("north ");
//      if(currentRoom.eastExit != null)
//          System.out.print("east ");
//      if(currentRoom.southExit != null)
//          System.out.print("south ");
//      if(currentRoom.westExit != null)
//          System.out.print("west ");
      System.out.print(currentRoom.getExitDesc());
      System.out.println();
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Game game = new Game();
		game.printWelcome();

        while ( true ) {
        		String line = in.nextLine();
//        		是用来将一个字符串 line 按照空格进行拆分，并将拆分后的结果存储到字符串数组 words 中
        		String[] words = line.split(" ");
//        		如果第一个单词是help做什么，第一个单词是go做什么……
        		if ( words[0].equals("help") ) {
        			game.printHelp();
//        			如果是go的话回去调用goRoom函数
        		} else if (words[0].equals("go") ) {
        			game.goRoom(words[1]);
        		} else if ( words[0].equals("bye") ) {
        			break;
        		}
        }
        
        System.out.println("感谢您的光临。再见！");
        in.close();
	}

}

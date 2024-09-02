package castle;
import java.util.HashMap;
//成员变量
public class Room {
    private String description;
//用于存储房间的四个方向的出口
    private HashMap<String, Room> exits = new HashMap<String, Room>();
//    private Room northExit;
//    private Room southExit;
//    private Room eastExit;
//    private Room westExit;这四句也是重复，如果多加房间的时候仍会改动很多
//构造方法
    public Room(String descriotion)//这个构造方法接受一个字符串参数 description，并将其赋值给成员变量 description。
    {
        this.description = description;
        exits = new HashMap<>();
    }
    
    public void setExit(String dir,Room room) {
    	exits.put(dir, room);//里面的key是房间的名字
    }
    
//    将成员变量改成private后，让room本身去做动作，去只想房间的方位
//setExits方法:用于设置房间的四个方向的出口。
    //需要一个能够描述房间有什么出口的东西
    //参数 north, east, south, west 分别表示向北、东、南、西的出口的目标房间对象。
    
//    用于设置房间的四个方向的出口
//    public void setExits(Room north, Room east, Room south, Room west) 
//    {
//        if(north != null)
//            northExit = north;
//        if(east != null)
//            eastExit = east;
//        if(south != null)
//            southExit = south;
//        if(west != null)
//            westExit = west;
//    }

    @Override
    public String toString()
    {
        return description;
    }
    
    public String getExitDesc() {
    	StringBuffer sb = new StringBuffer();
        for(String dir : exits.keySet()) {
        	sb.append(dir);
        	sb.append(' ');
        }
        return sb.toString();
//    	if( northExit != null )
//    		sb.append("north");
//    	if( eastExit != null )
//    		sb.append("east");
//    	if( westExit != null )
//    		sb.append("west");
//    	if( southExit != null )
//    		sb.append("south");
//    	return sb.toString();
    	//于是所有showprompt变成了getExitDesc
    }
    
    public Room getExit(String direction){
    	return exits.get(direction);
//    	//方向判断,玩家输入一个方向，判断那个方向上有没有东西
//        if(ret.equals("north")) {
//            ret = northExit;
//        }
//        if(ret.equals("east")) {
//           ret = eastExit;
//        }
//        if(ret.equals("south")) {
//        	ret = southExit;
//        }
//        if(ret.equals("west")) {
//        	ret = westExit;
//        }
    }
}

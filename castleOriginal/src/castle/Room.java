package castle;
//创建4个对象，分别表示当前房间通往的下一个房间，当setExit函数得到null时，说明该房间的对应方向不存在新的房间。
public class Room {
    public String description;
    public Room northExit;//在当前Room北面的房间？
    public Room southExit;
    public Room eastExit;
    public Room westExit;

    public Room(String description) 
    {
        this.description = description;
    }
//outside.setExits(null, lobby, study, pub);
    public void setExits(Room north, Room east, Room south, Room west) 
    {
        if(north != null)//如果输入的go north ，north不是null，那当前房间就被赋值成
            northExit = north;
        if(east != null)
            eastExit = east;
        if(south != null)
            southExit = south;
        if(west != null)
            westExit = west;
    }

    @Override
    public String toString()
    {
        return description;
    }
}

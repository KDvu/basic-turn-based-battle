public class Unit
{
    private String name;
    private int hp;
    private int atk;
    private int spd;
    private String unit_image;
    
    public Unit(String name, int hp,int atk,int spd){
        this.name = name;
        this.hp = hp;
        this.atk = atk;
        this.spd = spd;
    }
    
    public String getName(){
        return name;
    }
    
    public int getHp(){
        return hp;
    }
    
    public int getAtk(){
        return atk;
    }
    
    public int getSpd(){
        return spd;
    }
    
    public void setUnitImage(String image){
        this.unit_image = image;
    }    
    
    public String getUnitImage(){
        return unit_image;
    }
}

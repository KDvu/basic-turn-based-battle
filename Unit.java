public class Unit
{
    private int hp;
    private int atk;
    private int spd;
    private String unit_image;
    
    public Unit(int hp,int atk,int spd, String image){
        this.hp = hp;
        this.atk = atk;
        this.spd = spd;
        this.unit_image = image;
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
    
    public String getUnitImage(){
        return unit_image;
    }
}

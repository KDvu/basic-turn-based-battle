import javax.swing.JFrame;

public class Display
{
    public static void main(String[] args){
        Hero hero = new Hero("Dave",10,9,8);
        Enemy enemy = new Enemy("Bobbie",8,9,10);
        BattleState test = new BattleState(hero,enemy);
    }
}

public class Enemy extends Unit
{
    public Enemy(String name, int hp, int atk, int spd)
    {
        super(name,hp,atk,spd);
        setUnitImage("images/enemy_image.png");
    }
}

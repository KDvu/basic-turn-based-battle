import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JProgressBar;

public class BattleState extends JFrame
{
    private JLabel hero;
    private JLabel hero_image;
    private JProgressBar hero_hp;
    
    private JLabel enemy;
    private JLabel enemy_image;
    private JProgressBar enemy_hp;
    
    private JButton button1;
    private JButton button2;
    private JButton button3;    
    private JTextArea battle_report;
    
    //Constructor
    public BattleState(){
        super("Turn-Based Battle System");
        setLayout(new FlowLayout());
        
        hero = new JLabel("HERO");
        hero.setToolTipText("HERO NAME");
        enemy = new JLabel("ENEMY");
        hero.setToolTipText("ENEMY NAME");        
        add(hero);
        add(enemy);
        
        hero_image = new JLabel("INSERT IMAGE");        
        enemy_image = new JLabel("INSERT IMAGE");
        add(hero_image);
        add(enemy_image);
        
        hero_hp = new JProgressBar(0);
        enemy_hp = new JProgressBar(0);
        add(hero_image);
        add(enemy_hp);
        
        button1 = new JButton("Attack");
        button2 = new JButton("Defend");        
        button3 = new JButton("Run");
        add(button1);
        add(button2);
        add(button3);
        
        battle_report = new JTextArea("Battle Report");
        add(battle_report);
    }
}

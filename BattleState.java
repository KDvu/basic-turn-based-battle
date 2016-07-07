import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JProgressBar;
import java.awt.Insets;
import java.awt.Color;

import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import javax.swing.border.Border;

public class BattleState extends JFrame
{
    private JPanel panel;
    
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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        
        //setLayout(new FlowLayout());
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createLineBorder(Color.black));     
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTHWEST;
        add(panel, c);
        c.insets= new Insets(10,10,10,10);                
        
        hero = new JLabel("HERO");
        hero.setToolTipText("HERO NAME");
        enemy = new JLabel("ENEMY");
        hero.setToolTipText("ENEMY NAME");
        c.gridx=1;
        c.gridy=0;
        panel.add(hero,c);
        c.gridx=3;
        c.gridy=0;
        panel.add(enemy,c);
        
        hero_image = new JLabel("INSERT IMAGE");        
        enemy_image = new JLabel("INSERT IMAGE");
        c.gridx=1;
        c.gridy=1;
        panel.add(hero_image,c);
        c.gridx=3;
        c.gridy=1;
        panel.add(enemy_image,c);
        
        hero_hp = new JProgressBar(0);
        enemy_hp = new JProgressBar(0);        
        c.gridx=1;
        c.gridy=2;
        panel.add(hero_hp,c);
        c.gridx=3;
        c.gridy=2;        
        panel.add(enemy_hp,c);
        
        button1 = new JButton("Attack");
        button2 = new JButton("Defend");        
        button3 = new JButton("Run");
        c.gridx=1;
        c.gridy=4;                
        panel.add(button1,c);
        c.gridx=1;
        c.gridy=5; 
        panel.add(button2,c);
        c.gridx=1;
        c.gridy=6; 
        panel.add(button3,c);
        
        battle_report = new JTextArea("Battle Report",8, 12);
        Border border = BorderFactory.createLineBorder(Color.black);
        //battle_report.setBackground(Color.yellow);
        battle_report.setBorder(border);
        c.gridheight=3;
        c.gridx=3;
        c.gridy=4; 
        panel.add(battle_report,c);
        pack();
        
        setVisible(true);
    }
}

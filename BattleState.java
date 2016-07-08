import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JProgressBar;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import javax.swing.border.Border;

public class BattleState extends JFrame 
{
    private JPanel panel;
    
    private JLabel hero_name;
    private JLabel hero_image;
    private JProgressBar hero_hp_bar;
    
    private JLabel enemy_name;
    private JLabel enemy_image;
    private JProgressBar enemy_hp_bar;
    
    private JButton button1;
    private JButton button2;
    private JButton button3;    
    private JTextArea battle_report;
    
    private Unit[] turn_order = new Unit[2];
    
    //Constructor
    public BattleState(Unit hero, Unit enemy){
        super("Turn-Based Battle System");
        createComponents(hero,enemy);
        displayHealthBars(hero,enemy);
        calculateTurnOrder(hero,enemy);
        
        battle_report.append("\n" + turn_order[0].getName() + " goes first");
    }
    
    private void createComponents(Unit hero,Unit enemy){

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
        
        hero_name = new JLabel(hero.getName());
        hero_name.setToolTipText("HERO NAME");
        enemy_name = new JLabel(enemy.getName());
        enemy_name.setToolTipText("ENEMY NAME");
        c.gridx=1;
        c.gridy=0;
        panel.add(hero_name,c);
        c.gridx=3;
        c.gridy=0;
        panel.add(enemy_name,c);
        
        hero_image = new JLabel();
        hero_image.setIcon(new ImageIcon(hero.getUnitImage()));
        enemy_image = new JLabel();
        enemy_image.setIcon(new ImageIcon(enemy.getUnitImage()));
        c.gridx=1;
        c.gridy=1;
        panel.add(hero_image,c);
        c.gridx=3;
        c.gridy=1;
        panel.add(enemy_image,c);
        
        hero_hp_bar = new JProgressBar(0);
        enemy_hp_bar = new JProgressBar(0);        
        c.gridx=1;
        c.gridy=2;
        panel.add(hero_hp_bar,c);
        c.gridx=3;
        c.gridy=2;        
        panel.add(enemy_hp_bar,c);
        
        button1 = new JButton("Attack");
        button2 = new JButton("Defend");        
        button3 = new JButton("Run");

        c.gridwidth=2;
        c.gridx=1;
        c.gridy=4;                
        panel.add(button1,c);
        c.gridwidth=2;        
        c.gridx=1;
        c.gridy=5; 
        panel.add(button2,c);
        c.gridwidth=2;        
        c.gridx=1;
        c.gridy=6; 
        panel.add(button3,c);
        
        EventHandler handler = new EventHandler(hero, enemy);
        button1.addActionListener(handler);
        button2.addActionListener(handler);        
        button3.addActionListener(handler);
        
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
    
    private void displayHealthBars(Unit hero,Unit enemy){
        hero_hp_bar.setMaximum(hero.getHp());
        hero_hp_bar.setValue(hero.getHp());
 
        enemy_hp_bar.setMaximum(enemy.getHp());
        enemy_hp_bar.setValue(enemy.getHp());       
    }
    
    private void calculateTurnOrder(Unit hero, Unit enemy){
        if(hero.getSpd() > enemy.getSpd()){
            turn_order[0] = hero;
            turn_order[1] = enemy;
        } else{
            turn_order[0] = enemy;
            turn_order[1] = hero;
        }
    }
    
    public void healthChange(Unit attacker, Unit victim){
         victim.setHp(victim.getHp() - attacker.getAtk());
         battle_report.append("\n" + victim.getName() + " took " + attacker.getAtk() + " damage and now has " +   
                              victim.getHp() + " hp.");
         
         if(victim instanceof Enemy)
            enemy_hp_bar.setValue(victim.getHp());                       
         else if (victim instanceof Hero)
            hero_hp_bar.setValue(victim.getHp());                       
    }
    
    private class EventHandler implements ActionListener{
        private Hero hero;
        private Enemy enemy;
        
        public EventHandler(Unit hero, Unit enemy){
            this.hero = (Hero) hero;
            this.enemy = (Enemy) enemy;
        }
        
        public void actionPerformed(ActionEvent event){
                if(event.getSource()==button1){
                    healthChange(hero,enemy);
                        
                } else if(event.getSource()==button3){
                    battle_report.append("\nYou ran away");
                    System.exit(0);
                }
        }
    }    
}

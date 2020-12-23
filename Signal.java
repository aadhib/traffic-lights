package packtraffic;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
public class SwingTrafficPgm extends JFrame implements ActionListener
{
private JPanel contentPane;
JButton b1, b2, b3;
Signal green = new Signal(Color.green);
Signal yellow = new Signal(Color.yellow);
Signal red = new Signal(Color.red);
public SwingTrafficPgm(){
super("Traffic Light");
getContentPane().setLayout(new GridLayout(2, 1));
b1 = new JButton("Red");
b2 = new JButton("Yellow");
b3 = new JButton("Green");
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
green.turnOn(false);
yellow.turnOn(false);
red.turnOn(false);
JPanel p1 = new JPanel(new GridLayout(3,1));
p1.add(red);
p1.add(yellow);
p1.add(green);
JPanel p2 = new JPanel(new FlowLayout());
p2.add(b1);
p2.add(b2);
p2.add(b3);
getContentPane().add(p1);
getContentPane().add(p2);
pack();
}
public static void main(String[] args)
{
SwingTrafficPgm tl = new SwingTrafficPgm();
tl.setVisible(true);
}
public void actionPerformed(ActionEvent e){
if (e.getSource() == b1){
green.turnOn(false);
yellow.turnOn(false);
red.turnOn(true);
} else if (e.getSource() == b2){
yellow.turnOn(true);
green.turnOn(false);
red.turnOn(false);
} else if (e.getSource() == b3){
red.turnOn(false);
yellow.turnOn(false);
green.turnOn(true);
}
}
}
class Signal extends JPanel{
Color on;
int radius = 40;
int border = 10;
boolean change;
Signal(Color color){
on = color;
change = true;
}
public void turnOn(boolean a){
change = a;
repaint();
}
public Dimension getPreferredSize(){
int size = (radius+border)*2;
return new Dimension( size, size );
}
public void paintComponent(Graphics g){
g.setColor( Color.black );
g.fillRect(0,0,getWidth(),getHeight());
if (change){
g.setColor( on );
} else {
g.setColor( on.darker().darker().darker() );
}
g.fillOval( border,border,2*radius,2*radius );
}
}

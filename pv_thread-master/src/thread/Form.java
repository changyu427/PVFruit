package thread;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Form extends JFrame {
    public JFrame myFrame=new JFrame("吃水果"); //静态的窗口容器
    public JPanel myPanel1=new JPanel();
    public JPanel myPanel2=new JPanel();
    public Container myContainer=myFrame.getContentPane();
    public static JTextArea myTextArea=new JTextArea();      //静态的多行文本框
    public JScrollPane myScroll=new JScrollPane();
    public Graphics g=myPanel2.getGraphics();

    ImageIcon father=new ImageIcon("E:\\JavaProject\\pv_thread-master\\src\\images\\father.jpg");
    ImageIcon mother=new ImageIcon("E:\\JavaProject\\pv_thread-master\\src\\images\\mother.jpg");
    ImageIcon son=new ImageIcon("E:\\JavaProject\\pv_thread-master\\src\\images\\son.jpg");
    ImageIcon daughter=new ImageIcon("E:\\JavaProject\\pv_thread-master\\src\\images\\daughter.jpg");
    public static ImageIcon fatherHand=new ImageIcon("E:\\JavaProject\\pv_thread-master\\src\\images\\fatherHand.png");
    public static ImageIcon motherHand=new ImageIcon("E:\\JavaProject\\pv_thread-master\\src\\images\\motherHand.png");
    public static ImageIcon sonHand=new ImageIcon("E:\\JavaProject\\pv_thread-master\\src\\images\\sonHand.png");
    public static ImageIcon daughterHand=new ImageIcon("E:\\JavaProject\\pv_thread-master\\src\\images\\daughterHand.png");
    public static ImageIcon plate=new ImageIcon("E:\\JavaProject\\pv_thread-master\\src\\images\\plate.png");
    public static ImageIcon apple=new ImageIcon("E:\\JavaProject\\pv_thread-master\\src\\images\\apple.png");
    public static ImageIcon orange=new ImageIcon("E:\\JavaProject\\pv_thread-master\\src\\images\\orange.png");

    public JLabel fatherLabel=new JLabel(father);
    public JLabel motherLabel=new JLabel(mother);
    public JLabel sonLabel=new JLabel(son);
    public JLabel daughterLabel=new JLabel(daughter);
    public JLabel plateLabel=new JLabel(plate);
    public static JLabel fHandLabel=new JLabel(fatherHand);
    public static JLabel mHandLabel=new JLabel(motherHand);
    public static JLabel sHandLabel=new JLabel(sonHand);
    public static JLabel dHandLabel=new JLabel(daughterHand);
    public static JLabel appleLabel1=new JLabel(apple);
    public static JLabel appleLabel2=new JLabel(apple);
    public static JLabel appleLabel3=new JLabel(apple);
    public static JLabel appleLabel4=new JLabel(apple);
    public static JLabel orangeLabel1=new JLabel(orange);
    public static JLabel orangeLabel2=new JLabel(orange);
    public static JLabel orangeLabel3=new JLabel(orange);
    public static JLabel orangeLabel4=new JLabel(orange);

    public static int getX(Component a){
        return a.getX();
    }

    public static int getY(Component a){
        return a.getY();
    }

    public static void setXY(Component a,int x,int y){
        a.setLocation(x,y);
    }


    public static void putFruit(String name,String fruit){
        myTextArea.append(name+"放了一个"+fruit+"\n");
    }
    public static void eatFruit(String name,String fruit){
        myTextArea.append(name+"吃了一个"+fruit+"\n");
    }

    public static void putFruitFailed(String name,String fruit){
        myTextArea.append(name+"放"+fruit+"失败"+"\n");
    }

    public static void eatFruitFailed(String name,String fruit){
        myTextArea.append(name+"吃"+fruit+"失败"+"\n");
    }


    public void Init(){
        myFrame.setLayout(null);
        myPanel1.setLayout(null);
        myPanel2.setLayout(null);
        myContainer.setLayout(null);

        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myFrame.setSize(1200,800);

        myPanel1.setBounds(0,0,210,800);
        myPanel2.setBounds(210,0,990,800);
        fatherLabel.setBounds(20,5,100,100);
        motherLabel.setBounds(850,5,100,100);
        sonLabel.setBounds(20,645,100,100);
        daughterLabel.setBounds(850,645,100,100);
        plateLabel.setBounds(375,325,200,100);
        fHandLabel.setBounds(100,20,70,70);
        mHandLabel.setBounds(800,20,70,70);
        sHandLabel.setBounds(100,660,70,70);
        dHandLabel.setBounds(800,660,70,70);
        appleLabel1.setBounds(750,55,50,50);//右上角
        appleLabel2.setBounds(750,635,50,50);//右下角
        appleLabel3.setBounds(475,300,50,50);//中间靠左
        appleLabel4.setBounds(525,300,50,50);//中间靠右
        orangeLabel1.setBounds(170,55,50,50);
        orangeLabel2.setBounds(170,635,50,50);
        orangeLabel3.setBounds(375,300,50,50);
        orangeLabel4.setBounds(425,300,50,50);

        myTextArea.add(myScroll);
        myPanel1.add(myTextArea);
        myPanel2.add(fatherLabel);
        myPanel2.add(motherLabel);
        myPanel2.add(sonLabel);
        myPanel2.add(daughterLabel);
        myPanel2.add(plateLabel);
        myPanel2.add(fHandLabel);
        myPanel2.add(mHandLabel);
        myPanel2.add(sHandLabel);
        myPanel2.add(dHandLabel);
        myPanel2.add(appleLabel1);
        myPanel2.add(appleLabel2);
        myPanel2.add(appleLabel3);
        myPanel2.add(appleLabel4);
        myPanel2.add(orangeLabel1);
        myPanel2.add(orangeLabel2);
        myPanel2.add(orangeLabel3);
        myPanel2.add(orangeLabel4);

        myContainer.add(myPanel1);
        myContainer.add(myPanel2);
        myFrame.add(myScroll);

        myTextArea.setBounds(20,20,180,710);

        myFrame.setVisible(true);
        myScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        orangeLabel3.setVisible(false);
        orangeLabel4.setVisible(false);
        appleLabel3.setVisible(false);
        appleLabel4.setVisible(false);
        orangeLabel2.setVisible(false);
        appleLabel2.setVisible(false);
    }


    public Form(){
        Init();
    }

}

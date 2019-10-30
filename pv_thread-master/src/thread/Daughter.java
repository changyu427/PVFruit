package thread;

import javax.swing.*;
import java.util.TimerTask;

public class Daughter extends TimerTask {
    @Override
    public void run() {
        try {
            while (true) {
                if(App.haveApple.tryAcquire()){
                    App.appleCount--;
                    int x1=Form.getX(Form.appleLabel2);//记录苹果的坐标
                    int y1=Form.getY(Form.appleLabel2);
                    int x2=Form.getX(Form.dHandLabel);
                    int y2=Form.getY(Form.dHandLabel);
                    while (x2>=375&&y2>=300){
                        x2-=7;
                        y2-=7;
                        Thread.sleep(100); //移动手
                        Form.setXY(Form.dHandLabel,x2,y2);
                    }
                    if(App.appleCount==1)
                        Form.appleLabel4.setVisible(false);
                    else if(App.appleCount==0)
                        Form.appleLabel3.setVisible(false);
                    x1=x2-50;
                    y1=y2;
                    Form.appleLabel2.setLocation(x1,y1); //把橘子放在手旁边
                    Form.appleLabel2.setVisible(true);
                    while(x2<=800&&y2<=660){
                        x2+=7;
                        y2+=7;
                        x1+=7;
                        y1+=7;
                        Thread.sleep(100);
                        Form.setXY(Form.dHandLabel,x2,y2);
                        Form.setXY(Form.appleLabel2,x1,y1);
                    }
                    Form.appleLabel2.setBounds(750,655,50,50);
                    Form.dHandLabel.setBounds(800,660,70,70);
                    Thread.sleep(1000);
                    Form.appleLabel2.setVisible(false);

                    Form.eatFruit("女儿","苹果");

                    App.diskEmpty.release();
                }
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

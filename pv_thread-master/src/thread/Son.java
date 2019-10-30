package thread;

import java.util.TimerTask;

public class Son extends TimerTask {
    @Override
    public void run() {
        try {
            while (true) {
                if(App.haveOrange.tryAcquire()){
                    App.orangeCount--;
                    int x1=Form.getX(Form.orangeLabel2);//记录橘子的坐标
                    int y1=Form.getY(Form.orangeLabel2);
                    int x2=Form.getX(Form.sHandLabel);
                    int y2=Form.getY(Form.sHandLabel);
                    while (x2<=375&&y2>=300){
                        x2+=7;
                        y2-=7;
                        Thread.sleep(100); //移动手
                        Form.setXY(Form.sHandLabel,x2,y2);
                    }
                    if(App.orangeCount==1)
                        Form.orangeLabel4.setVisible(false);
                    else if(App.orangeCount==0)
                        Form.orangeLabel3.setVisible(false);
                    x1=x2+75;
                    y1=y2;
                    Form.orangeLabel2.setLocation(x1,y1); //把橘子放在手旁边
                    Form.orangeLabel2.setVisible(true);
                    while(x2>=100&&y2<=660){
                        x2-=7;
                        y2+=7;
                        x1-=7;
                        y1+=7;
                        Thread.sleep(100);
                        Form.setXY(Form.sHandLabel,x2,y2);
                        Form.setXY(Form.orangeLabel2,x1,y1);
                    }
                    Form.orangeLabel2.setBounds(170,655,50,50);
                    Form.sHandLabel.setBounds(100,660,70,70);
                    Thread.sleep(1000);
                    Form.orangeLabel2.setVisible(false);
                    Form.eatFruit("儿子","橘子");
                    App.diskEmpty.release();
                }
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

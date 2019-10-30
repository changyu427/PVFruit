package thread;

import java.util.Timer;
import java.util.TimerTask;

public class Father extends TimerTask {
    Timer timer=new Timer(true);

    @Override
    public void run() {
        try {
            while (true) {
                if(App.diskEmpty.tryAcquire()){
                    App.mute.acquire();
//                    Thread.sleep(1000);

                    int x1=Form.getX(Form.orangeLabel1);
                    int y1=Form.getY(Form.orangeLabel1);
                    int x2=Form.getX(Form.fHandLabel);
                    int y2=Form.getY(Form.fHandLabel);

                    while(x1<=475&&y1<=300){        //移动图片
                        x1+=7;
                        y1+=7;
                        x2+=7;
                        y2+=7;
                        Thread.sleep(100);
                        Form.setXY(Form.orangeLabel1,x1,y1);
                        Form.setXY(Form.fHandLabel,x2,y2);
                    }

                    if(App.orangeCount==0){
                        Form.orangeLabel3.setVisible(true);
                    }
                    else if(App.orangeCount==1){
                        Form.orangeLabel4.setVisible(true);
                    }

                    Form.orangeLabel1.setBounds(170,55,50,50);//橘子返回原位
                    Form.fHandLabel.setBounds(100,20,70,70);//爸爸的手返回原位




                    Form.putFruit("爸爸","橘子");

                    App.mute.release();
                    App.haveOrange.release();

                    App.orangeCount=App.orangeCount+1;//橘子数加一
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

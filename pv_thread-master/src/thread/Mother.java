package thread;

import java.util.TimerTask;

public class Mother extends TimerTask {
    @Override
    public void run() {
        try {
            while (true) {
                if(App.diskEmpty.tryAcquire()){
                    App.mute.acquire();
//                    Thread.sleep(1000);

                    int x1=Form.getX(Form.appleLabel1);
                    int y1=Form.getY(Form.appleLabel1);
                    int x2=Form.getX(Form.mHandLabel);
                    int y2=Form.getY(Form.mHandLabel);

                    while(x1>=475&&y1<=300){        //移动图片
                        x1-=7;
                        y1+=7;
                        x2-=7;
                        y2+=7;
                        Thread.sleep(100);
                        Form.setXY(Form.appleLabel1,x1,y1);
                        Form.setXY(Form.mHandLabel,x2,y2);
                    }

                    if(App.appleCount==0){
                        Form.appleLabel3.setVisible(true);
                    }
                    else if(App.appleCount==1){
                        Form.appleLabel4.setVisible(true);
                    }

                    Form.appleLabel1.setBounds(750,55,50,50);
                    Form.mHandLabel.setBounds(800,20,70,70);



                    Form.putFruit("妈妈","苹果");

                    App.mute.release();
                    App.haveApple.release();

                    App.appleCount=App.appleCount+1; //苹果数+1；
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

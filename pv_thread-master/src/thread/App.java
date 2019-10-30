package thread;

import java.util.Date;
import java.util.Timer;
import java.util.concurrent.Semaphore;

/**
 * @ClassName App
 * @Author 邱昌煜
 * @Date 19-10-28 下午3:37
 * @Description
 **/
public class App {

    public static Semaphore diskEmpty = new Semaphore(2);
    //信号量为2表示盘子为空，信号量为1表示盘子中有1个水果，信号量为0表示盘子中有2个水果
    public static Semaphore haveOrange = new Semaphore(0);
    //信号量为2表示盘子中有2个橘子，信号量为1表示盘子中有1个橘子，信号量为0表示盘子中没有橘子
    public static Semaphore haveApple = new Semaphore(0);
    //信号量为2表示盘子中有2个苹果，信号量为1表示盘子中有1个苹果，信号量为0表示盘子中没有苹果
    public static Semaphore mute=new Semaphore(1);
    //互斥信号量，爸爸与妈妈放水果是互斥的

    public static int orangeCount=0;
    public static int appleCount=0;

    public static void main(String[] args) {
        Timer timer1=new Timer();
        Timer timer2=new Timer();
        Timer timer3=new Timer();
        Timer timer4=new Timer();
        timer1.schedule(new Father(),1000);
        timer2.schedule(new Mother(),1000);
        timer3.schedule(new Son(),1000);
        timer4.schedule(new Daughter(),1000);
        new Form();
    }

}

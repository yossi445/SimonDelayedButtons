package com.example.yossi.simondelayedbuttons;

import android.os.Handler;
import android.os.Message;

public class TimerHandler extends Thread {


    Handler handler;
    int[] seq;
    boolean isRun = true;

    public TimerHandler(Handler handler, int[] seq) {
        this.handler = handler;
        this.seq = seq;
    }

    @Override
    public void run() {
        super.run();


        for (int i = 0; i < seq.length; i++) {

            if(isRun) {
                Message msg = new Message();
                msg.arg1 = seq[i];
                handler.sendMessage(msg);


                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                Message msg2 = new Message();
                msg2.arg1 = 99;
                handler.sendMessage(msg2);


                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }






            }


        }
    }
}
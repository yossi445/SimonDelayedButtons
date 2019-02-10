package com.example.yossi.simondelayedbuttons;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn1,btn2,btn3;
    Handler handler;
    TimerHandler timerHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

        int[] arr = new int[]{1,2,3,1,2,3,1,1,1,1,99};


        handler=new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {



                if(msg.arg1 == 1) {
                    btn1.setVisibility(View.INVISIBLE);
                    btn2.setVisibility(View.VISIBLE);
                    btn3.setVisibility(View.VISIBLE);
                }
                else if(msg.arg1 == 2) {

                    btn1.setVisibility(View.VISIBLE);
                    btn2.setVisibility(View.INVISIBLE);
                    btn3.setVisibility(View.VISIBLE);

                }
                else if(msg.arg1 == 3) {
                    btn1.setVisibility(View.VISIBLE);
                    btn2.setVisibility(View.VISIBLE);
                    btn3.setVisibility(View.INVISIBLE);
                }
                else if(msg.arg1==99)
                {
                     btn1.setVisibility(View.VISIBLE);
                     btn2.setVisibility(View.VISIBLE);
                     btn3.setVisibility(View.VISIBLE);
                }


                return true;
            }
        });

        timerHandler = new TimerHandler(handler,arr);
        timerHandler.start();




    }
}

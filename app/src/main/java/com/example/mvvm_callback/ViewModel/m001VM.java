package com.example.mvvm_callback.ViewModel;

import android.view.View;

import androidx.lifecycle.ViewModel;

public class m001VM extends ViewModel {
       private Thread th ;
       private callBackCountDown callBack ;


    public void setCallBack(callBackCountDown callBack) {
        this.callBack = callBack;
    }

    public void startCountDown() {
        if( th == null || !th.isAlive())
        {
            th = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i=10;i >= 0;i--)
                    {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            return ;
                        }
                        callBack.update(i);
                    }
                }
            });
            th.start();
        }
    }
    public interface callBackCountDown{
        void update(int i) ;
    }
}

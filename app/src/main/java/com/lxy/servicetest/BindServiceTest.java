package com.lxy.servicetest;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * @author LiXinyu
 * @date 2017/11/14 17:10.
 */

public class BindServiceTest extends Service{
    final String TAG=BindServiceTest.class.getSimpleName();
    private Mybinder mybinder=new Mybinder();
    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate: " );
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mybinder;
    }
    class Mybinder extends Binder{
        public void start(){
            Log.e(TAG, "start: " );
        }
    }
}

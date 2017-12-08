package com.potoyang.myandroid;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.potoyang.common.config.Config;

/**
 * Created by potoyang on 2017/11/24.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        if (Config.isDebug) {
            ARouter.openLog();
            ARouter.openDebug();
        }

        ARouter.init(this);

    }

}

package com.potoyang.common.arouter;

import android.app.Activity;
import android.os.Bundle;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by potoyang on 2017/11/24.
 */

public class ARouterUtil {
    public static void startActvity(String path) {
        startActvity(path, null);
    }

    public static void startActvity(String path, Bundle bundle) {
        ARouter.getInstance().build(path).with(bundle).navigation();
    }

    public static void startActivityForResult(String path, Bundle bundle, Activity context, int requestCode) {
        ARouter.getInstance().build(path).with(bundle).navigation(context, requestCode);
    }
}

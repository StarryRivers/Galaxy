package com.starryriver.galaxy;

import android.app.Application;
import android.content.Context;

/**
 * Copyright  : qinjingsheng@foxmail.com
 * Project    : 星河
 * Package    : com.starryriver.galaxy
 * @author    : StarryRivers
 * @date      : 2020/11/14 14:32
 * Desc       : TODO
 **/
public class TUIKitDemoApplication extends Application {
    public static final int SDKAPPID = 1400447868;
    private static final String PWD = "3e3b4faed59b46efb657ff30bcd1a2ed6932d34e31e80b03f56df8e72ff4c053";
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getContext() {
        return mContext;
    }
}

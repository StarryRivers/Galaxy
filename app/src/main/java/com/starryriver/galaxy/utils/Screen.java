package com.starryriver.galaxy.utils;

import android.content.Context;

import com.starryriver.galaxy.TUIKitDemoApplication;

/**
 * Copyright  : qinjingsheng@foxmail.com
 * Project    : Galaxy
 * Package    : com.starryriver.galaxy.utils
 * @author    : StarryRivers
 * @date      : 2020/11/14 17:10
 * Desc       : 屏幕相关工具类
 **/
public class Screen {
    private static final String TAG = "Screen";
    private static Context mContext = TUIKitDemoApplication.getContext();

    /**
     * dp转px
     * @param dpValue dp
     * @return px
     */
    public static int getPxByDp(float dpValue) {
        final float scale = mContext.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * px转dp
     * @param pxValue px
     * @return dp
     */
    public static int getDpByPx(float pxValue){
        final float scale = mContext.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}

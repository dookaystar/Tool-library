package com.toollibrary.viewutil.colorutil;

import android.graphics.drawable.GradientDrawable;

/**
 * Created by 李双 on 2017/4/26.
 */

public class GradientUtil {


    /**
     * 变化的背景
     * 传入 color []
     * @param colorid
     * @return mTv.setBackground(getGradientDrawable);
     */
    public GradientDrawable getGradientDrawable(int[] colorid) {
        return new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, colorid);
    }
}

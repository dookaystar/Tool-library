package com.toollibrary.viewutil.imgeview;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

import com.mob.commons.clt.DvcClt;

/**
 * Created by 李双 on 2017/4/25.
 */

public class ImagShowHelper {

    /**
     * 通过 传入内容获取 图片的 Drawable
     *
     * @param context
     * @param drawableid 图片的位置id
     * @return
     */
    public static Drawable getDrawable(Context context, int drawableid) {
        return ContextCompat.getDrawable(context, drawableid);
    }
}

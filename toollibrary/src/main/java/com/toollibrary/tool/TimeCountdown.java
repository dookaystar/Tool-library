package com.toollibrary.tool;

import android.content.Intent;
import android.os.CountDownTimer;

import java.util.TimerTask;

/**
 * Created by 李双 on 2017/3/17.
 * <p>
 * 倒计时
 */

public abstract class TimeCountdown {

    private CountDownTimer timer;

    /**
     * 输入分钟
     *
     * @param second
     */
    public TimeCountdown(int second) {
        /**
         * 最简单的倒计时类，实现了官方的CountDownTimer类（没有特殊要求的话可以使用）
         * 即使退出activity，倒计时还能进行，因为是创建了后台的线程。 有onTick，onFinsh、cancel和start方法
         */
        timer = new CountDownTimer(second * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                // 每隔countDownInterval秒会回调一次onTick()方法
                NewSecond(millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                TimeFinsh();
            }
        };
        timer.start();// 开始计时
    }

    /**
     * 当前的秒数
     *
     * @param seconds
     */
    public abstract void NewSecond(long seconds);

    /**
     * 倒计时已经结束
     */
    public abstract void TimeFinsh();
}

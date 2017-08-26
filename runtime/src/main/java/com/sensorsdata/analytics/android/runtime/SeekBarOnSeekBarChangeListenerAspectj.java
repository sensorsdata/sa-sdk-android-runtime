package com.sensorsdata.analytics.android.runtime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created by 王灼洲 on 2016/11/29
 * SeekBar.OnSeekBarChangeListener 事件
 */

@Aspect
public class SeekBarOnSeekBarChangeListenerAspectj {
    private final static String TAG = SeekBarOnSeekBarChangeListenerAspectj.class.getCanonicalName();

    @After("execution(* android.widget.SeekBar.OnSeekBarChangeListener.onStartTrackingTouch(android.widget.SeekBar))")
    public void onStartTrackingTouchMethod(JoinPoint joinPoint) throws Throwable {
        actionAOP(joinPoint, "onStartTrackingTouch");
    }

    @After("execution(* android.widget.SeekBar.OnSeekBarChangeListener.onStopTrackingTouch(android.widget.SeekBar))")
    public void onStopTrackingTouchMethod(JoinPoint joinPoint) throws Throwable {
        actionAOP(joinPoint, "onStopTrackingTouch");
    }

    private void actionAOP(final JoinPoint joinPoint, final String action) {
        AopUtil.sendTrackEventToSDK(joinPoint, "onSeekBarChange");
    }
}

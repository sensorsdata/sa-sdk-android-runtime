package com.sensorsdata.analytics.android.runtime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created by 王灼洲 on 2016/11/29
 * spinner.setOnItemSelectedListener 事件
 */

@Aspect
public class SpinnerOnItemSelectedAspectj {
    private final static String TAG = SpinnerOnItemSelectedAspectj.class.getCanonicalName();

    @After("execution(* android.widget.AdapterView.OnItemSelectedListener.onItemSelected(android.widget.AdapterView,android.view.View,int,long))")
    public void onItemSelectedAOP(final JoinPoint joinPoint) throws Throwable {
        AopUtil.sendTrackEventToSDK(joinPoint, "onSpinnerItemSelected");
    }
}

package com.sensorsdata.analytics.android.runtime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created by 王灼洲 on 2016/11/16
 * ListView、GridView onItemClick
 */

@Aspect
public class AdapterViewOnItemClickListenerAspectj {
    private final static String TAG = AdapterViewOnItemClickListenerAspectj.class.getCanonicalName();

    @After("execution(* android.widget.AdapterView.OnItemClickListener.onItemClick(android.widget.AdapterView,android.view.View,int,long))")
    public void onItemClickAOP(final JoinPoint joinPoint) throws Throwable {
        AopUtil.sendTrackEventToSDK(joinPoint, "onAdapterViewItemClick");
    }

    @After("execution(* android.widget.AdapterView.OnItemLongClickListener.onItemLongClick(..))")
    public void onItemLongClickMethod(JoinPoint joinPoint) throws Throwable {

    }
}

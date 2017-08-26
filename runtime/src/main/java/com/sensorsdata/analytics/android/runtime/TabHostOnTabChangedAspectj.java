package com.sensorsdata.analytics.android.runtime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created by 王灼洲 on 2016/12/1
 * TabHost.OnTabChangeListener
 */

@Aspect
public class TabHostOnTabChangedAspectj {
    private final static String TAG = TabHostOnTabChangedAspectj.class.getCanonicalName();

    @After("execution(* android.widget.TabHost.OnTabChangeListener.onTabChanged(String))")
    public void onTabChangedAOP(final JoinPoint joinPoint) throws Throwable {
        AopUtil.sendTrackEventToSDK(joinPoint, "onTabHostChanged");
    }
}

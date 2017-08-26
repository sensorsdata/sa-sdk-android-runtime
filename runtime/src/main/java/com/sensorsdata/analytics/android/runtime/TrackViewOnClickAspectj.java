package com.sensorsdata.analytics.android.runtime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by 王灼洲 on 2017/1/5
 */

@Aspect
public class TrackViewOnClickAspectj {
    private final static String TAG = TrackViewOnClickAspectj.class.getCanonicalName();

    @Pointcut("execution(@com.sensorsdata.analytics.android.sdk.SensorsDataTrackViewOnClick * *(..))")
    public void methodAnnotatedWithTrackEvent() {
    }

    @After("methodAnnotatedWithTrackEvent()")
    public void trackOnClickAOP(final JoinPoint joinPoint) throws Throwable {
        AopUtil.sendTrackEventToSDK(joinPoint, "trackViewOnClick");
    }
}

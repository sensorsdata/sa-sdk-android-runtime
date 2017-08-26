package com.sensorsdata.analytics.android.runtime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created by 王灼洲 on 2017/6/20
 */

@Aspect
public class ReactNativeAspectj {
    private final static String TAG = ReactNativeAspectj.class.getCanonicalName();

    @After("execution(* com.facebook.react.uimanager.NativeViewHierarchyManager.setJSResponder(int,int,boolean))")
    public void onNativeViewHierarchyManagerSetJSResponderAOP(final JoinPoint joinPoint) throws Throwable {
        AopUtil.sendTrackEventToSDK(joinPoint, "onReactNativeViewAppClick");
    }
}

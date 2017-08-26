package com.sensorsdata.analytics.android.runtime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created by 王灼洲 on 2016/11/16
 */

@Aspect
public class FragmentAspectj {
    private final static String TAG = FragmentAspectj.class.getCanonicalName();

    @Around("execution(* android.support.v4.app.Fragment.onCreateView(..))")
    public Object fragmentOnCreateViewMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        return trackFragmentView(joinPoint);
    }

    @Around("execution(* android.app.Fragment.onCreateView(..))")
    public Object fragmentOnCreateViewMethod2(ProceedingJoinPoint joinPoint) throws Throwable {
        return trackFragmentView(joinPoint);
    }

    private Object trackFragmentView(final ProceedingJoinPoint joinPoint) throws Throwable {
        // 被注解的方法在这一行代码被执行
        Object result = joinPoint.proceed();
        AopUtil.sendTrackEventToSDK3(joinPoint, "trackFragmentView", result);
        return result;
    }

    @After("execution(* android.support.v4.app.Fragment.onHiddenChanged(boolean))")
    public void onHiddenChangedMethod(JoinPoint joinPoint) throws Throwable {
        AopUtil.sendTrackEventToSDK(joinPoint, "onFragmentHiddenChangedMethod");
    }

    @After("execution(* android.support.v4.app.Fragment.setUserVisibleHint(boolean))")
    public void setUserVisibleHintMethod(JoinPoint joinPoint) throws Throwable {
        AopUtil.sendTrackEventToSDK(joinPoint, "onFragmentSetUserVisibleHintMethod");
    }

    @After("execution(* android.support.v4.app.Fragment.onResume())")
    public void onResumeMethod(JoinPoint joinPoint) throws Throwable {
        AopUtil.sendTrackEventToSDK(joinPoint, "onFragmentOnResumeMethod");
    }
}

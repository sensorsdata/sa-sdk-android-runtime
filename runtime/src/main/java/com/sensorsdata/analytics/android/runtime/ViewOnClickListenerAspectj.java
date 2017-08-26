package com.sensorsdata.analytics.android.runtime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by 王灼洲 on 2016/11/16
 * android.view.View.OnClickListener.onClick(android.view.View)
 */

@Aspect
public class ViewOnClickListenerAspectj {

    /**
     * 支持 butterknife.OnClick 注解
     */
    @Pointcut("execution(@butterknife.OnClick * *(..))")
    public void methodAnnotatedWithButterknifeClick() {
    }

    @After("methodAnnotatedWithButterknifeClick()")
    public void onButterknifeClickAOP(final JoinPoint joinPoint) throws Throwable {
        AopUtil.sendTrackEventToSDK(joinPoint, "onButterknifeClick");
    }

    /**
     * android.view.View.OnClickListener.onClick(android.view.View)
     *
     * @param joinPoint JoinPoint
     * @throws Throwable Exception
     */
    @After("execution(* android.view.View.OnClickListener.onClick(android.view.View))")
    public void onViewClickAOP(final JoinPoint joinPoint) throws Throwable {
        AopUtil.sendTrackEventToSDK(joinPoint, "onViewOnClick");
    }

    /**
     * android.view.View.OnLongClickListener.onLongClick(android.view.View)
     *
     * @param joinPoint JoinPoint
     * @throws Throwable Exception
     */
    @After("execution(* android.view.View.OnLongClickListener.onLongClick(android.view.View))")
    public void onViewLongClickAOP(JoinPoint joinPoint) throws Throwable {

    }
}

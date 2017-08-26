package com.sensorsdata.analytics.android.runtime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created by 王灼洲 on 2016/11/29
 * RatingBar.OnRatingBarChangeListener.onRatingChanged 事件
 */

@Aspect
public class RatingBarOnRatingChangedAspectj {
    private final static String TAG = RatingBarOnRatingChangedAspectj.class.getCanonicalName();

    @After("execution(* android.widget.RatingBar.OnRatingBarChangeListener.onRatingChanged(android.widget.RatingBar,float,boolean))")
    public void onRatingChangedAOP(final JoinPoint joinPoint) throws Throwable {
        AopUtil.sendTrackEventToSDK(joinPoint, "onRatingBarChanged");
    }
}

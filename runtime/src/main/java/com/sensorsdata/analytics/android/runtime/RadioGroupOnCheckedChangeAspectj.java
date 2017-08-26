package com.sensorsdata.analytics.android.runtime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created by 王灼洲 on 2016/11/29
 * RadioGroup 的 onCheckedChanged 事件
 */

@Aspect
public class RadioGroupOnCheckedChangeAspectj {
    private final static String TAG = RadioGroupOnCheckedChangeAspectj.class.getCanonicalName();

    @After("execution(* android.widget.RadioGroup.OnCheckedChangeListener.onCheckedChanged(android.widget.RadioGroup,int))")
    public void onCheckedChangedAOP(final JoinPoint joinPoint) throws Throwable {
        AopUtil.sendTrackEventToSDK(joinPoint, "onRadioGroupCheckedChanged");
    }
}

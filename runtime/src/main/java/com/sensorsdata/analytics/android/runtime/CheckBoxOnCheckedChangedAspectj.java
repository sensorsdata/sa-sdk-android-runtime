package com.sensorsdata.analytics.android.runtime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created by 王灼洲 on 2016/11/29
 * CheckBox、ToggleButton 的onCheckedChanged事件
 */

@Aspect
public class CheckBoxOnCheckedChangedAspectj {
    private final static String TAG = CheckBoxOnCheckedChangedAspectj.class.getCanonicalName();

    @After("execution(* android.widget.CompoundButton.OnCheckedChangeListener.onCheckedChanged(android.widget.CompoundButton,boolean))")
    public void onCheckedChangedAOP(final JoinPoint joinPoint) throws Throwable {
        AopUtil.sendTrackEventToSDK(joinPoint, "onCheckBoxCheckedChanged");
    }
}

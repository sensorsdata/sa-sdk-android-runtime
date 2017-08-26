package com.sensorsdata.analytics.android.runtime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created by 王灼洲 on 2016/11/29
 * Dialog.OnClickListener.onClick 事件
 */

@Aspect
public class DialogOnClickAspectj {
    private final static String TAG = DialogOnClickAspectj.class.getCanonicalName();

    @After("execution(* android.content.DialogInterface.OnClickListener.onClick(android.content.DialogInterface, int))")
    public void onClickAOP(final JoinPoint joinPoint) throws Throwable {
        AopUtil.sendTrackEventToSDK(joinPoint, "onDialogClick");
    }

    @After("execution(* android.content.DialogInterface.OnMultiChoiceClickListener.onClick(android.content.DialogInterface, int, boolean))")
    public void onMultiChoiceClickAOP(final JoinPoint joinPoint) throws Throwable {
        AopUtil.sendTrackEventToSDK(joinPoint, "onMultiChoiceClick");
    }
}

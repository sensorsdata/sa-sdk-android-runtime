package com.sensorsdata.analytics.android.runtime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created by 王灼洲 on 2016/12/1
 * android.widget.ExpandableListView.OnChildClickListener.onChildClick
 * android.widget.ExpandableListView.OnGroupClickListener.onGroupClick
 */

@Aspect
public class ExpandableListViewItemOnClickAspectj {
    private final static String TAG = ExpandableListViewItemOnClickAspectj.class.getCanonicalName();

    /**
     * public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id)
     *
     * @param joinPoint JoinPoint
     * @throws Throwable Exception
     */
    @After("execution(* android.widget.ExpandableListView.OnChildClickListener.onChildClick(android.widget.ExpandableListView, android.view.View, int, int, long))")
    public void onChildClickAOP(final JoinPoint joinPoint) throws Throwable {
        AopUtil.sendTrackEventToSDK(joinPoint, "onExpandableListViewItemChildClick");
    }

    /**
     * public boolean onGroupClick(ExpandableListView expandableListView, View view, int groupPosition, long l)
     *
     * @param joinPoint
     * @throws Throwable
     */
    @After("execution(* android.widget.ExpandableListView.OnGroupClickListener.onGroupClick(android.widget.ExpandableListView, android.view.View, int, long))")
    public void onGroupClickAOP(final JoinPoint joinPoint) throws Throwable {
        AopUtil.sendTrackEventToSDK(joinPoint, "onExpandableListViewItemGroupClick");
    }
}

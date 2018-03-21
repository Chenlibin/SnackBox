package com.clb.clblibrary.utils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liber on 2018/3/8.
 */

public class ActivtyCollectorUtils {


    public static List<Activity> activities = new ArrayList<Activity>();

    public static void addActivity(Activity activity){
        activities.add(activity);
    }
    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }
    public static void finishAll(){
        Activity activity =null;
        if(activities==null||(activities.size()==0)){
            return;
        }
        for (int i=(activities.size()-1);i>=0;i--){
            activity = activities.get(i);
            if(activity!=null&&!activity.isFinishing()){
                activity.finish();
            }
            activities.remove(i);
        }
    }
}

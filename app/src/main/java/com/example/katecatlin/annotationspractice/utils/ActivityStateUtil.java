package com.example.katecatlin.annotationspractice.utils;

import android.app.Activity;
import android.os.Build;

/**
 * Created by katecatlin on 12/22/14.
 */
public final class ActivityStateUtil {

    private ActivityStateUtil() { }

    public static boolean isActivityValid(Activity activity) {
        if (activity == null) {
            return false;
        } else {
            if (Build.VERSION.SDK_INT >= 17) {
                return !activity.isFinishing() && !activity.isDestroyed();
            } else {
                return !activity.isFinishing();
            }
        }
    }

}

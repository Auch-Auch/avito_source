package com.facebook.common.activitylistener;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import com.facebook.common.internal.Preconditions;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;
public class ActivityListenerManager {

    public static class a extends BaseActivityListener {
        public final WeakReference<ActivityListener> a;

        public a(ActivityListener activityListener) {
            this.a = new WeakReference<>(activityListener);
        }

        @Nullable
        public final ActivityListener a(Activity activity) {
            ActivityListener activityListener = this.a.get();
            if (activityListener == null) {
                Preconditions.checkArgument(activity instanceof ListenableActivity);
                ((ListenableActivity) activity).removeActivityListener(this);
            }
            return activityListener;
        }

        @Override // com.facebook.common.activitylistener.BaseActivityListener, com.facebook.common.activitylistener.ActivityListener
        public void onActivityCreate(Activity activity) {
            ActivityListener a3 = a(activity);
            if (a3 != null) {
                a3.onActivityCreate(activity);
            }
        }

        @Override // com.facebook.common.activitylistener.BaseActivityListener, com.facebook.common.activitylistener.ActivityListener
        public void onDestroy(Activity activity) {
            ActivityListener a3 = a(activity);
            if (a3 != null) {
                a3.onDestroy(activity);
            }
        }

        @Override // com.facebook.common.activitylistener.BaseActivityListener, com.facebook.common.activitylistener.ActivityListener
        public void onPause(Activity activity) {
            ActivityListener a3 = a(activity);
            if (a3 != null) {
                a3.onPause(activity);
            }
        }

        @Override // com.facebook.common.activitylistener.BaseActivityListener, com.facebook.common.activitylistener.ActivityListener
        public void onResume(Activity activity) {
            ActivityListener a3 = a(activity);
            if (a3 != null) {
                a3.onResume(activity);
            }
        }

        @Override // com.facebook.common.activitylistener.BaseActivityListener, com.facebook.common.activitylistener.ActivityListener
        public void onStart(Activity activity) {
            ActivityListener a3 = a(activity);
            if (a3 != null) {
                a3.onStart(activity);
            }
        }

        @Override // com.facebook.common.activitylistener.BaseActivityListener, com.facebook.common.activitylistener.ActivityListener
        public void onStop(Activity activity) {
            ActivityListener a3 = a(activity);
            if (a3 != null) {
                a3.onStop(activity);
            }
        }
    }

    @Nullable
    public static ListenableActivity getListenableActivity(Context context) {
        if (!(context instanceof ListenableActivity) && (context instanceof ContextWrapper)) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (context instanceof ListenableActivity) {
            return (ListenableActivity) context;
        }
        return null;
    }

    public static void register(ActivityListener activityListener, Context context) {
        ListenableActivity listenableActivity = getListenableActivity(context);
        if (listenableActivity != null) {
            listenableActivity.addActivityListener(new a(activityListener));
        }
    }
}

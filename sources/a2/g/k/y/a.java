package a2.g.k.y;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.facebook.FacebookSdk;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.appevents.internal.AutomaticAnalyticsLogger;
import java.util.concurrent.TimeUnit;
public final class a implements Runnable {
    public final /* synthetic */ long a;
    public final /* synthetic */ String b;

    /* renamed from: a2.g.k.y.a$a  reason: collision with other inner class name */
    public class RunnableC0026a implements Runnable {
        public RunnableC0026a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ActivityLifecycleTracker.e == null) {
                ActivityLifecycleTracker.e = new e(Long.valueOf(a.this.a), null);
            }
            if (ActivityLifecycleTracker.d.get() <= 0) {
                f.b(a.this.b, ActivityLifecycleTracker.e, ActivityLifecycleTracker.g);
                SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
                edit.remove("com.facebook.appevents.SessionInfo.sessionStartTime");
                edit.remove("com.facebook.appevents.SessionInfo.sessionEndTime");
                edit.remove("com.facebook.appevents.SessionInfo.interruptionCount");
                edit.remove("com.facebook.appevents.SessionInfo.sessionId");
                edit.apply();
                SharedPreferences.Editor edit2 = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
                edit2.remove("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage");
                edit2.remove("com.facebook.appevents.SourceApplicationInfo.openedByApplink");
                edit2.apply();
                ActivityLifecycleTracker.e = null;
            }
            synchronized (ActivityLifecycleTracker.c) {
                ActivityLifecycleTracker.b = null;
            }
        }
    }

    public a(long j, String str) {
        this.a = j;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (ActivityLifecycleTracker.e == null) {
            ActivityLifecycleTracker.e = new e(Long.valueOf(this.a), null);
        }
        ActivityLifecycleTracker.e.b = Long.valueOf(this.a);
        if (ActivityLifecycleTracker.d.get() <= 0) {
            RunnableC0026a aVar = new RunnableC0026a();
            synchronized (ActivityLifecycleTracker.c) {
                ActivityLifecycleTracker.b = ActivityLifecycleTracker.a.schedule(aVar, (long) ActivityLifecycleTracker.a(), TimeUnit.SECONDS);
            }
        }
        long j = ActivityLifecycleTracker.h;
        long j2 = 0;
        if (j > 0) {
            j2 = (this.a - j) / 1000;
        }
        AutomaticAnalyticsLogger.logActivityTimeSpentEvent(this.b, j2);
        ActivityLifecycleTracker.e.a();
    }
}

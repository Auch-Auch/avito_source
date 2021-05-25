package a2.g.k;

import android.preference.PreferenceManager;
import com.facebook.FacebookSdk;
import java.util.concurrent.locks.ReentrantReadWriteLock;
public class d {
    public static ReentrantReadWriteLock a = new ReentrantReadWriteLock();
    public static String b;
    public static volatile boolean c = false;

    public static void a() {
        if (!c) {
            a.writeLock().lock();
            try {
                if (!c) {
                    b = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).getString("com.facebook.appevents.AnalyticsUserIDStore.userID", null);
                    c = true;
                    a.writeLock().unlock();
                }
            } finally {
                a.writeLock().unlock();
            }
        }
    }
}

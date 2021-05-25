package a2.g.k;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.facebook.FacebookSdk;
public final class c implements Runnable {
    public final /* synthetic */ String a;

    public c(String str) {
        this.a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        d.a.writeLock().lock();
        try {
            d.b = this.a;
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
            edit.putString("com.facebook.appevents.AnalyticsUserIDStore.userID", d.b);
            edit.apply();
        } finally {
            d.a.writeLock().unlock();
        }
    }
}

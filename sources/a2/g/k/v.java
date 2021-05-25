package a2.g.k;

import android.content.SharedPreferences;
import com.facebook.appevents.UserDataStore;
public final class v implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        if (!UserDataStore.b.get()) {
            SharedPreferences sharedPreferences = UserDataStore.a;
            UserDataStore.a();
        }
        UserDataStore.c.clear();
        UserDataStore.a.edit().putString("com.facebook.appevents.UserDataStore.userData", null).apply();
    }
}

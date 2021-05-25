package a2.j.e.h;

import android.content.Context;
import android.content.SharedPreferences;
public class b {
    public static b b;
    public final SharedPreferences a;

    public b(Context context) {
        this.a = context.getSharedPreferences("FirebaseAppHeartBeat", 0);
    }

    public synchronized boolean a(String str, long j) {
        if (!this.a.contains(str)) {
            this.a.edit().putLong(str, j).apply();
            return true;
        } else if (j - this.a.getLong(str, -1) < 86400000) {
            return false;
        } else {
            this.a.edit().putLong(str, j).apply();
            return true;
        }
    }
}

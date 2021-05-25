package a2.j.e.i;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import androidx.core.content.ContextCompat;
import com.avito.android.social.AppleSignInManagerKt;
import com.google.firebase.iid.FirebaseInstanceId;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
public class i0 {
    public final SharedPreferences a;
    public final Context b;
    @GuardedBy("this")
    public final Map<String, Long> c = new ArrayMap();

    public static class a {
        public static final long d = TimeUnit.DAYS.toMillis(7);
        public static final /* synthetic */ int e = 0;
        public final String a;
        public final String b;
        public final long c;

        public a(String str, String str2, long j) {
            this.a = str;
            this.b = str2;
            this.c = j;
        }

        public static a a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (!str.startsWith("{")) {
                return new a(str, null, 0);
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new a(jSONObject.getString(AppleSignInManagerKt.EXTRA_APPLE_TOKEN), jSONObject.getString("appVersion"), jSONObject.getLong("timestamp"));
            } catch (JSONException e2) {
                String.valueOf(e2).length();
                return null;
            }
        }
    }

    public i0(Context context) {
        boolean isEmpty;
        this.b = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.appid", 0);
        this.a = sharedPreferences;
        File file = new File(ContextCompat.getNoBackupFilesDir(context), "com.google.android.gms.appid-no-backup");
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    synchronized (this) {
                        isEmpty = sharedPreferences.getAll().isEmpty();
                    }
                    if (!isEmpty) {
                        c();
                        FirebaseInstanceId.getInstance().m();
                    }
                }
            } catch (IOException e) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String valueOf = String.valueOf(e.getMessage());
                    if (valueOf.length() != 0) {
                        "Error creating file in no backup dir: ".concat(valueOf);
                    } else {
                        new String("Error creating file in no backup dir: ");
                    }
                }
            }
        }
    }

    public static String a(String str, String str2) {
        return a2.b.a.a.a.s2(str2.length() + a2.b.a.a.a.q0(str, 3), str, "|S|", str2);
    }

    public final String b(String str, String str2, String str3) {
        StringBuilder K = a2.b.a.a.a.K(a2.b.a.a.a.q0(str3, a2.b.a.a.a.q0(str2, a2.b.a.a.a.q0(str, 4))), str, "|T|", str2, "|");
        K.append(str3);
        return K.toString();
    }

    public synchronized void c() {
        this.c.clear();
        this.a.edit().clear().commit();
    }

    public final long d(String str) {
        String string = this.a.getString(a(str, "cre"), null);
        if (string == null) {
            return 0;
        }
        try {
            return Long.parseLong(string);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public synchronized long e(String str) {
        long currentTimeMillis;
        currentTimeMillis = System.currentTimeMillis();
        if (!this.a.contains(a(str, "cre"))) {
            SharedPreferences.Editor edit = this.a.edit();
            edit.putString(a(str, "cre"), String.valueOf(currentTimeMillis));
            edit.commit();
        } else {
            currentTimeMillis = d(str);
        }
        this.c.put(str, Long.valueOf(currentTimeMillis));
        return currentTimeMillis;
    }
}

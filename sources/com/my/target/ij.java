package com.my.target;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.firebase.messaging.Constants;
public class ij {
    @Nullable
    public static volatile ij b;
    @NonNull
    public final SharedPreferences a;

    public ij(@NonNull SharedPreferences sharedPreferences) {
        this.a = sharedPreferences;
    }

    @NonNull
    public static ij ad(@NonNull Context context) {
        ij ijVar = b;
        if (ijVar == null) {
            synchronized (ij.class) {
                ijVar = b;
                if (ijVar == null) {
                    ijVar = new ij(context.getSharedPreferences("mytarget_prefs", 0));
                    b = ijVar;
                }
            }
        }
        return ijVar;
    }

    @NonNull
    public final String a(@NonNull String str) {
        try {
            String string = this.a.getString(str, null);
            return string != null ? string : "";
        } catch (Throwable th) {
            ae.c("PrefsCache exception: " + th);
            return "";
        }
    }

    public void ak(@Nullable String str) {
        b("hoaid", str);
    }

    public void al(@Nullable String str) {
        b("hlimit", str);
    }

    @WorkerThread
    public void am(@NonNull String str) {
        b(Constants.FirelogAnalytics.PARAM_INSTANCE_ID, str);
    }

    @SuppressLint({"ApplySharedPref"})
    public final void b(@NonNull String str, @Nullable String str2) {
        try {
            SharedPreferences.Editor edit = this.a.edit();
            edit.putString(str, str2);
            edit.commit();
        } catch (Throwable th) {
            ae.c("PrefsCache exception: " + th);
        }
    }

    @Nullable
    public String eV() {
        return a("hoaid");
    }

    @Nullable
    public String eW() {
        return a("hlimit");
    }

    @NonNull
    @WorkerThread
    public String eX() {
        return a(Constants.FirelogAnalytics.PARAM_INSTANCE_ID);
    }

    public int getFlags() {
        try {
            return this.a.getInt("sdk_flags", -1);
        } catch (Throwable th) {
            ae.c("PrefsCache exception: " + th);
            return 0;
        }
    }

    public void setFlags(int i) {
        try {
            SharedPreferences.Editor edit = this.a.edit();
            edit.putInt("sdk_flags", i);
            edit.commit();
        } catch (Throwable th) {
            ae.c("PrefsCache exception: " + th);
        }
    }
}

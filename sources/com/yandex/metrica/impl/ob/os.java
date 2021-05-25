package com.yandex.metrica.impl.ob;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
public class os {
    private final ado a = new ado();

    @Nullable
    private or b(Context context) {
        or c;
        or b = b(context, context.getPackageName());
        if (b == null) {
            return null;
        }
        return (!a() || (c = c(context, context.getPackageName())) == null) ? b : c;
    }

    public void a(@NonNull Context context, @NonNull oq oqVar, @NonNull so soVar) {
        try {
            or b = b(context);
            String str = null;
            if (!(b == null || b.c() == null)) {
                str = b.c().a();
            }
            String a3 = new or(oqVar, new ot(context, str, soVar), System.currentTimeMillis()).a();
            if (a()) {
                a(context, a3);
            }
            a(context, "credentials.dat", a3);
        } catch (Throwable unused) {
        }
    }

    @TargetApi(21)
    @Nullable
    public or c(Context context, String str) {
        return a(context, str, new File(context.getNoBackupFilesDir(), "credentials.dat"));
    }

    @Nullable
    public or b(Context context, String str) {
        return a(context, str, context.getFileStreamPath("credentials.dat"));
    }

    @Nullable
    private or b(Context context, String str, String str2) {
        try {
            File file = new File(str2);
            if (!file.exists()) {
                return null;
            }
            String a3 = ax.a(context, file);
            if (a3 == null) {
                return null;
            }
            return new or(new JSONObject(a3), file.lastModified());
        } catch (JSONException unused) {
            return null;
        }
    }

    @SuppressLint({"WorldReadableFiles"})
    private void a(Context context, String str, String str2) {
        ax.a(context, str, str2);
    }

    @VisibleForTesting
    public void a(Context context, String str) {
        ax.b(context, "credentials.dat", str);
    }

    @Nullable
    public oq a(@NonNull Context context) {
        or b = b(context);
        if (b == null) {
            return null;
        }
        return b.b();
    }

    public boolean a() {
        return ax.a();
    }

    @Nullable
    private or a(Context context, String str, File file) {
        ApplicationInfo b = this.a.b(context, str, 8192);
        if (b != null) {
            return b(context, str, a(file, context.getApplicationInfo().dataDir, b.dataDir));
        }
        return null;
    }

    @NonNull
    private String a(File file, String str, String str2) {
        return file.getAbsolutePath().replace(str, str2);
    }
}

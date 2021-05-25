package com.google.android.play.core.internal;

import a2.b.a.a.a;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import java.util.IllegalFormatException;
import java.util.Locale;
public final class aa {
    public final String a;

    public aa(String str) {
        int myUid = Process.myUid();
        int myPid = Process.myPid();
        StringBuilder sb = new StringBuilder(39);
        sb.append("UID: [");
        sb.append(myUid);
        sb.append("]  PID: [");
        sb.append(myPid);
        sb.append("] ");
        String valueOf = String.valueOf(sb.toString());
        String valueOf2 = String.valueOf(str);
        this.a = valueOf2.length() == 0 ? new String(valueOf) : valueOf.concat(valueOf2);
    }

    public static String b(String str, String str2, Object... objArr) {
        if (objArr.length > 0) {
            try {
                str2 = String.format(Locale.US, str2, objArr);
            } catch (IllegalFormatException unused) {
                String valueOf = String.valueOf(str2);
                if (valueOf.length() == 0) {
                    new String("Unable to format ");
                } else {
                    "Unable to format ".concat(valueOf);
                }
                String join = TextUtils.join(", ", objArr);
                str2 = a.v(new StringBuilder(String.valueOf(str2).length() + 3 + String.valueOf(join).length()), str2, " [", join, "]");
            }
        }
        return a.u(new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(str2).length()), str, " : ", str2);
    }

    public final int a(int i, String str, Object[] objArr) {
        if (Log.isLoggable("PlayCore", i)) {
            return Log.i("PlayCore", b(this.a, str, objArr));
        }
        return 0;
    }

    public final void a(String str, Object... objArr) {
        a(3, str, objArr);
    }

    public final void a(Throwable th, String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 6)) {
            b(this.a, str, objArr);
        }
    }

    public final void b(String str, Object... objArr) {
        a(6, str, objArr);
    }

    public final void c(String str, Object... objArr) {
        a(4, str, objArr);
    }

    public final void d(String str, Object... objArr) {
        a(5, str, objArr);
    }
}

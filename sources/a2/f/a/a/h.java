package a2.f.a.a;

import androidx.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class h {
    public static final boolean a;

    static {
        boolean z;
        try {
            Class.forName("androidx.work.WorkManager");
            z = true;
        } catch (Throwable unused) {
            z = false;
        }
        a = z;
    }
}

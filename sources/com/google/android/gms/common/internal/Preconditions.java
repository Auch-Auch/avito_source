package com.google.android.gms.common.internal;

import a2.b.a.a.a;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.zzb;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
@KeepForSdk
public final class Preconditions {
    private Preconditions() {
        throw new AssertionError("Uninstantiable");
    }

    @KeepForSdk
    public static void checkArgument(@RecentlyNonNull boolean z, @RecentlyNonNull Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    @KeepForSdk
    public static void checkHandlerThread(@RecentlyNonNull Handler handler) {
        Looper myLooper = Looper.myLooper();
        if (myLooper != handler.getLooper()) {
            String name = myLooper != null ? myLooper.getThread().getName() : "null current looper";
            String name2 = handler.getLooper().getThread().getName();
            StringBuilder K = a.K(a.q0(name, a.q0(name2, 36)), "Must be called on ", name2, " thread, but got ", name);
            K.append(".");
            throw new IllegalStateException(K.toString());
        }
    }

    @KeepForSdk
    public static void checkMainThread(@RecentlyNonNull String str) {
        if (!zzb.zza()) {
            throw new IllegalStateException(str);
        }
    }

    @RecentlyNonNull
    @KeepForSdk
    public static String checkNotEmpty(@RecentlyNonNull String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException("Given String is empty or null");
    }

    @KeepForSdk
    public static void checkNotMainThread() {
        checkNotMainThread("Must not be called on the main application thread");
    }

    @NonNull
    @EnsuresNonNull({"#1"})
    @KeepForSdk
    public static <T> T checkNotNull(@Nullable T t) {
        Objects.requireNonNull(t, "null reference");
        return t;
    }

    @RecentlyNonNull
    @KeepForSdk
    public static int checkNotZero(@RecentlyNonNull int i, @RecentlyNonNull Object obj) {
        if (i != 0) {
            return i;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    @KeepForSdk
    public static void checkState(@RecentlyNonNull boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    @KeepForSdk
    public static void checkArgument(@RecentlyNonNull boolean z, @RecentlyNonNull String str, @RecentlyNonNull Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    @KeepForSdk
    public static void checkNotMainThread(@RecentlyNonNull String str) {
        if (zzb.zza()) {
            throw new IllegalStateException(str);
        }
    }

    @NonNull
    @EnsuresNonNull({"#1"})
    @KeepForSdk
    public static <T> T checkNotNull(@RecentlyNonNull T t, @RecentlyNonNull Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    @RecentlyNonNull
    @KeepForSdk
    public static int checkNotZero(@RecentlyNonNull int i) {
        if (i != 0) {
            return i;
        }
        throw new IllegalArgumentException("Given Integer is zero");
    }

    @KeepForSdk
    public static void checkState(@RecentlyNonNull boolean z, @RecentlyNonNull Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    @KeepForSdk
    public static void checkArgument(@RecentlyNonNull boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    @RecentlyNonNull
    @KeepForSdk
    public static String checkNotEmpty(@RecentlyNonNull String str, @RecentlyNonNull Object obj) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    @RecentlyNonNull
    @KeepForSdk
    public static long checkNotZero(@RecentlyNonNull long j, @RecentlyNonNull Object obj) {
        if (j != 0) {
            return j;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    @KeepForSdk
    public static void checkState(@RecentlyNonNull boolean z, @RecentlyNonNull String str, @RecentlyNonNull Object... objArr) {
        if (!z) {
            throw new IllegalStateException(String.format(str, objArr));
        }
    }

    @RecentlyNonNull
    @KeepForSdk
    public static long checkNotZero(@RecentlyNonNull long j) {
        if (j != 0) {
            return j;
        }
        throw new IllegalArgumentException("Given Long is zero");
    }

    @KeepForSdk
    public static void checkHandlerThread(@RecentlyNonNull Handler handler, @RecentlyNonNull String str) {
        if (Looper.myLooper() != handler.getLooper()) {
            throw new IllegalStateException(str);
        }
    }
}

package com.avito.android.util;

import com.avito.android.util.preferences.Names;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import timber.log.Timber;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0004\b\b\u0010\tJ+\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0004\b\n\u0010\tJ#\u0010\n\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0004\b\n\u0010\u000bJ+\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0004\b\f\u0010\tJ+\u0010\r\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0004\b\r\u0010\tJ+\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0004\b\u000e\u0010\tJ#\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0004\b\u000e\u0010\u000bJ\u001b\u0010\u000e\u001a\u00020\u00072\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0004\b\u0010\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/avito/android/util/Logs;", "", "", "tag", "message", "", "t", "", "verbose", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", Names.DEBUG, "(Ljava/lang/String;Ljava/lang/Throwable;)V", "info", "warning", "error", "(Ljava/lang/Throwable;)V", "wtf", "<init>", "()V", "android_release"}, k = 1, mv = {1, 4, 2})
public final class Logs {
    @NotNull
    public static final Logs INSTANCE = new Logs();

    @JvmStatic
    @JvmOverloads
    public static final void debug(@NotNull String str) {
        debug$default(str, null, 2, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void debug(@NotNull String str, @NotNull String str2) {
        debug$default(str, str2, null, 4, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void debug(@NotNull String str, @NotNull String str2, @Nullable Throwable th) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "message");
        Timber.tag(str).d(th, str2, new Object[0]);
    }

    public static /* synthetic */ void debug$default(String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        debug(str, str2, th);
    }

    @JvmStatic
    @JvmOverloads
    public static final void error() {
        error$default(null, 1, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void error(@NotNull String str) {
        error$default(str, null, 2, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void error(@NotNull String str, @NotNull String str2) {
        error$default(str, str2, null, 4, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void error(@NotNull String str, @NotNull String str2, @Nullable Throwable th) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "message");
        Timber.tag(str).e(th, str2, new Object[0]);
    }

    public static /* synthetic */ void error$default(String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        error(str, str2, th);
    }

    @JvmStatic
    @JvmOverloads
    public static final void info(@NotNull String str, @NotNull String str2) {
        info$default(str, str2, null, 4, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void info(@NotNull String str, @NotNull String str2, @Nullable Throwable th) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "message");
        Timber.tag(str).i(th, str2, new Object[0]);
    }

    public static /* synthetic */ void info$default(String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        info(str, str2, th);
    }

    @JvmStatic
    @JvmOverloads
    public static final void verbose(@NotNull String str, @NotNull String str2) {
        verbose$default(str, str2, null, 4, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void verbose(@NotNull String str, @NotNull String str2, @Nullable Throwable th) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "message");
        Timber.tag(str).v(th, str2, new Object[0]);
    }

    public static /* synthetic */ void verbose$default(String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        verbose(str, str2, th);
    }

    @JvmStatic
    @JvmOverloads
    public static final void warning(@NotNull String str, @NotNull String str2) {
        warning$default(str, str2, null, 4, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void warning(@NotNull String str, @NotNull String str2, @Nullable Throwable th) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "message");
        Timber.tag(str).w(th, str2, new Object[0]);
    }

    public static /* synthetic */ void warning$default(String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        warning(str, str2, th);
    }

    @JvmStatic
    @JvmOverloads
    public static final void wtf(@NotNull String str, @NotNull String str2) {
        wtf$default(str, str2, null, 4, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void wtf(@NotNull String str, @NotNull String str2, @Nullable Throwable th) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "message");
        Timber.tag(str).wtf(th, str2, new Object[0]);
    }

    public static /* synthetic */ void wtf$default(String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        wtf(str, str2, th);
    }

    @JvmStatic
    @JvmOverloads
    public static final void debug(@NotNull String str, @Nullable Throwable th) {
        Intrinsics.checkNotNullParameter(str, "message");
        Timber.tag("DEFAULT_TAG").d(th, str, new Object[0]);
    }

    public static /* synthetic */ void debug$default(String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        debug(str, th);
    }

    @JvmStatic
    @JvmOverloads
    public static final void error(@NotNull String str, @Nullable Throwable th) {
        Intrinsics.checkNotNullParameter(str, "message");
        Timber.tag("DEFAULT_TAG").e(th, str, new Object[0]);
    }

    public static /* synthetic */ void error$default(String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        error(str, th);
    }

    @JvmStatic
    @JvmOverloads
    public static final void error(@Nullable Throwable th) {
        Timber.tag("DEFAULT_TAG").e(th);
    }

    public static /* synthetic */ void error$default(Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        error(th);
    }
}

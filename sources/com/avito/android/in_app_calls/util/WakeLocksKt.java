package com.avito.android.in_app_calls.util;

import android.os.PowerManager;
import com.avito.android.util.Logs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a)\u0010\u0007\u001a\u00020\u0006*\u00060\u0000R\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "", "flags", "", "logError", "", "releaseQuietly", "(Landroid/os/PowerManager$WakeLock;IZ)V", "in-app-calls_release"}, k = 2, mv = {1, 4, 2})
public final class WakeLocksKt {
    public static final void releaseQuietly(@NotNull PowerManager.WakeLock wakeLock, int i, boolean z) {
        Intrinsics.checkNotNullParameter(wakeLock, "$this$releaseQuietly");
        try {
            wakeLock.release(i);
        } catch (Exception e) {
            if (z) {
                Logs.debug("WakeLocks", "Failed to release wake lock", e);
            }
        }
    }

    public static /* synthetic */ void releaseQuietly$default(PowerManager.WakeLock wakeLock, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            z = true;
        }
        releaseQuietly(wakeLock, i, z);
    }
}

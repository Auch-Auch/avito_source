package net.gotev.uploadservice.extensions;

import android.content.Context;
import android.os.PowerManager;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u0017\u0010\u0003\u001a\u00020\u0002*\b\u0018\u00010\u0000R\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a+\u0010\t\u001a\u00060\u0000R\u00020\u0001*\u00020\u00052\f\u0010\u0006\u001a\b\u0018\u00010\u0000R\u00020\u00012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "", "safeRelease", "(Landroid/os/PowerManager$WakeLock;)V", "Landroid/content/Context;", "currentWakeLock", "", "tag", "acquirePartialWakeLock", "(Landroid/content/Context;Landroid/os/PowerManager$WakeLock;Ljava/lang/String;)Landroid/os/PowerManager$WakeLock;", "uploadservice_release"}, k = 2, mv = {1, 4, 0})
public final class WakeLockExtensionsKt {
    @NotNull
    public static final PowerManager.WakeLock acquirePartialWakeLock(@NotNull Context context, @Nullable PowerManager.WakeLock wakeLock, @NotNull String str) {
        Intrinsics.checkNotNullParameter(context, "$this$acquirePartialWakeLock");
        Intrinsics.checkNotNullParameter(str, "tag");
        if (wakeLock != null && wakeLock.isHeld()) {
            return wakeLock;
        }
        Object systemService = context.getSystemService("power");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        PowerManager.WakeLock newWakeLock = ((PowerManager) systemService).newWakeLock(1, str);
        newWakeLock.setReferenceCounted(false);
        if (!newWakeLock.isHeld()) {
            newWakeLock.acquire();
        }
        Intrinsics.checkNotNullExpressionValue(newWakeLock, "powerManager.newWakeLock…(!isHeld) acquire()\n    }");
        return newWakeLock;
    }

    public static final void safeRelease(@Nullable PowerManager.WakeLock wakeLock) {
        if (wakeLock != null && wakeLock.isHeld()) {
            wakeLock.release();
        }
    }
}

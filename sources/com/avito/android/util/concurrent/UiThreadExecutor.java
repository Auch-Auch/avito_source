package com.avito.android.util.concurrent;

import android.os.Handler;
import android.os.Looper;
import com.avito.android.remote.auth.AuthSource;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/util/concurrent/UiThreadExecutor;", "Ljava/util/concurrent/Executor;", "Ljava/lang/Runnable;", "command", "", "execute", "(Ljava/lang/Runnable;)V", "Landroid/os/Handler;", AuthSource.SEND_ABUSE, "Landroid/os/Handler;", "mHandler", "<init>", "()V", "android_release"}, k = 1, mv = {1, 4, 2})
public final class UiThreadExecutor implements Executor {
    public final Handler a = new Handler(Looper.getMainLooper());

    @Override // java.util.concurrent.Executor
    public void execute(@NotNull Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "command");
        this.a.post(runnable);
    }
}

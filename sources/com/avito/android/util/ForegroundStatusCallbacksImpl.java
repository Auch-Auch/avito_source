package com.avito.android.util;

import android.app.Activity;
import com.avito.android.app.SimpleActivityLifecycleCallbacks;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ForegroundStatusCallbacks;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0015\u0010\u000fJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0007R$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/avito/android/util/ForegroundStatusCallbacksImpl;", "Lcom/avito/android/app/SimpleActivityLifecycleCallbacks;", "Lcom/avito/android/util/ForegroundStatusCallbacks;", "Landroid/app/Activity;", "activity", "", "onActivityStarted", "(Landroid/app/Activity;)V", "onActivityStopped", "Lcom/avito/android/util/ForegroundStatusCallbacks$Listener;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/ForegroundStatusCallbacks$Listener;", "getListener", "()Lcom/avito/android/util/ForegroundStatusCallbacks$Listener;", "setListener", "(Lcom/avito/android/util/ForegroundStatusCallbacks$Listener;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", AuthSource.SEND_ABUSE, "I", "counter", "<init>", "android_release"}, k = 1, mv = {1, 4, 2})
public final class ForegroundStatusCallbacksImpl extends SimpleActivityLifecycleCallbacks implements ForegroundStatusCallbacks {
    public int a;
    @Nullable
    public ForegroundStatusCallbacks.Listener b;

    public ForegroundStatusCallbacksImpl() {
        this(null, 1, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ForegroundStatusCallbacksImpl(ForegroundStatusCallbacks.Listener listener, int i, j jVar) {
        this((i & 1) != 0 ? null : listener);
    }

    @Override // com.avito.android.util.ForegroundStatusCallbacks
    @Nullable
    public ForegroundStatusCallbacks.Listener getListener() {
        return this.b;
    }

    @Override // com.avito.android.app.SimpleActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NotNull Activity activity) {
        ForegroundStatusCallbacks.Listener listener;
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.a == 0 && (listener = getListener()) != null) {
            listener.appForegrounded();
        }
        this.a++;
    }

    @Override // com.avito.android.app.SimpleActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NotNull Activity activity) {
        ForegroundStatusCallbacks.Listener listener;
        Intrinsics.checkNotNullParameter(activity, "activity");
        int i = this.a - 1;
        this.a = i;
        if (i == 0 && (listener = getListener()) != null) {
            listener.appBackgrounded();
        }
    }

    @Override // com.avito.android.util.ForegroundStatusCallbacks
    public void setListener(@Nullable ForegroundStatusCallbacks.Listener listener) {
        this.b = listener;
    }

    public ForegroundStatusCallbacksImpl(@Nullable ForegroundStatusCallbacks.Listener listener) {
        this.b = listener;
    }
}

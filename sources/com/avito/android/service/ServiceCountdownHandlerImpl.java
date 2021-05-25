package com.avito.android.service;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.service.ServiceCountdownHandler;
import com.avito.android.util.Logs;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b \u0010!J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000bR\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001c¨\u0006\""}, d2 = {"Lcom/avito/android/service/ServiceCountdownHandlerImpl;", "Lcom/avito/android/service/ServiceCountdownHandler;", "", "startId", "", "onStartAction", "(I)V", "onActionDone", "()V", "Lcom/avito/android/service/ServiceCountdownHandler$Listener;", "d", "Lcom/avito/android/service/ServiceCountdownHandler$Listener;", "getListener", "()Lcom/avito/android/service/ServiceCountdownHandler$Listener;", "setListener", "(Lcom/avito/android/service/ServiceCountdownHandler$Listener;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "f", "internalListener", "", "e", "Ljava/lang/String;", "name", "Ljava/lang/Object;", AuthSource.SEND_ABUSE, "Ljava/lang/Object;", "lock", "c", "I", "runningActions", AuthSource.BOOKING_ORDER, "lastStartId", "<init>", "(Ljava/lang/String;Lcom/avito/android/service/ServiceCountdownHandler$Listener;)V", "android_release"}, k = 1, mv = {1, 4, 2})
public final class ServiceCountdownHandlerImpl implements ServiceCountdownHandler {
    public final Object a;
    @GuardedBy("lock")
    public int b;
    @GuardedBy("lock")
    public int c;
    @Nullable
    public ServiceCountdownHandler.Listener d;
    public final String e;
    public final ServiceCountdownHandler.Listener f;

    @Inject
    public ServiceCountdownHandlerImpl(@NotNull String str, @Nullable ServiceCountdownHandler.Listener listener) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.e = str;
        this.f = listener;
        this.a = new Object();
    }

    @Override // com.avito.android.service.ServiceCountdownHandler
    @Nullable
    public ServiceCountdownHandler.Listener getListener() {
        return this.d;
    }

    @Override // com.avito.android.service.ServiceCountdownHandler
    public void onActionDone() {
        String str = this.e;
        StringBuilder L = a.L("onActionDone: startId=");
        L.append(this.b);
        L.append("; actions=");
        L.append(this.c);
        Logs.verbose$default(str, L.toString(), null, 4, null);
        synchronized (this.a) {
            int i = this.c - 1;
            this.c = i;
            if (i <= 0) {
                ServiceCountdownHandler.Listener listener = getListener();
                if (listener != null) {
                    listener.onStop(this.b);
                }
                ServiceCountdownHandler.Listener listener2 = this.f;
                if (listener2 != null) {
                    listener2.onStop(this.b);
                }
            }
        }
    }

    @Override // com.avito.android.service.ServiceCountdownHandler
    public void onStartAction(int i) {
        String str = this.e;
        StringBuilder L = a.L("onStartAction: startId=");
        L.append(this.b);
        L.append("; actions=");
        L.append(this.c);
        Logs.verbose$default(str, L.toString(), null, 4, null);
        synchronized (this.a) {
            this.b = i;
            int i2 = this.c + 1;
            this.c = i2;
            if (i2 == 1) {
                ServiceCountdownHandler.Listener listener = getListener();
                if (listener != null) {
                    listener.onStart();
                }
                ServiceCountdownHandler.Listener listener2 = this.f;
                if (listener2 != null) {
                    listener2.onStart();
                }
            }
        }
    }

    @Override // com.avito.android.service.ServiceCountdownHandler
    public void setListener(@Nullable ServiceCountdownHandler.Listener listener) {
        this.d = listener;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ServiceCountdownHandlerImpl(String str, ServiceCountdownHandler.Listener listener, int i, j jVar) {
        this(str, (i & 2) != 0 ? null : listener);
    }
}

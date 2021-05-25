package com.avito.android.analytics.inhouse_transport;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.avito.android.remote.auth.AuthSource;
import dagger.Lazy;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\u0012\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00060\u000b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0004R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\"\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00060\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/analytics/inhouse_transport/InHouseAnalyticsWatchDog;", "Landroidx/lifecycle/LifecycleObserver;", "", "onEnterBackground", "()V", "onEnterForeground", "Ldagger/Lazy;", "Lcom/avito/android/analytics/inhouse_transport/InHouseAnalyticsTimer;", AuthSource.BOOKING_ORDER, "Ldagger/Lazy;", "timer", "", "Lcom/avito/android/analytics/inhouse_transport/InHouseAnalyticsFlushInteractor;", AuthSource.SEND_ABUSE, "Ljava/util/List;", "flushInteractor", "<init>", "(Ljava/util/List;Ldagger/Lazy;)V", "analytics-transport_release"}, k = 1, mv = {1, 4, 2})
public final class InHouseAnalyticsWatchDog implements LifecycleObserver {
    public final List<Lazy<InHouseAnalyticsFlushInteractor>> a;
    public final Lazy<InHouseAnalyticsTimer> b;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends dagger.Lazy<com.avito.android.analytics.inhouse_transport.InHouseAnalyticsFlushInteractor>> */
    /* JADX WARN: Multi-variable type inference failed */
    public InHouseAnalyticsWatchDog(@NotNull List<? extends Lazy<InHouseAnalyticsFlushInteractor>> list, @NotNull Lazy<InHouseAnalyticsTimer> lazy) {
        Intrinsics.checkNotNullParameter(list, "flushInteractor");
        Intrinsics.checkNotNullParameter(lazy, "timer");
        this.a = list;
        this.b = lazy;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onEnterBackground() {
        Iterator<T> it = this.a.iterator();
        while (it.hasNext()) {
            ((InHouseAnalyticsFlushInteractor) it.next().get()).flush();
        }
        this.b.get().shutdown();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public final void onEnterForeground() {
        this.b.get().reset();
    }
}

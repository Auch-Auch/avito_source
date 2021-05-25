package com.avito.android.performance;

import com.avito.android.performance.di.PerformanceTrackersModule;
import com.avito.android.remote.auth.AuthSource;
import java.util.Iterator;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B.\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0017\u001a\u00020\u0012\u0012\u0011\u0010\u0011\u001a\r\u0012\t\u0012\u00070\r¢\u0006\u0002\b\u000e0\f¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004R\u001c\u0010\u000b\u001a\u00020\u00068\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR!\u0010\u0011\u001a\r\u0012\t\u0012\u00070\r¢\u0006\u0002\b\u000e0\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0017\u001a\u00020\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/performance/ScreenTrackerImpl;", "Lcom/avito/android/performance/ScreenTracker;", "", "stop", "()V", "resetSession", "Lcom/avito/android/performance/DiInjectTracker;", AuthSource.SEND_ABUSE, "Lcom/avito/android/performance/DiInjectTracker;", "getDiInject", "()Lcom/avito/android/performance/DiInjectTracker;", "diInject", "", "Lcom/avito/android/performance/ContentTracker;", "Lkotlin/jvm/JvmSuppressWildcards;", "c", "Ljava/util/Set;", "contentTrackers", "Lcom/avito/android/performance/SimpleTracker;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/performance/SimpleTracker;", "getInit", "()Lcom/avito/android/performance/SimpleTracker;", "init", "<init>", "(Lcom/avito/android/performance/DiInjectTracker;Lcom/avito/android/performance/SimpleTracker;Ljava/util/Set;)V", "tns-core_release"}, k = 1, mv = {1, 4, 2})
public final class ScreenTrackerImpl implements ScreenTracker {
    @NotNull
    public final DiInjectTracker a;
    @NotNull
    public final SimpleTracker b;
    public final Set<ContentTracker> c;

    @Inject
    public ScreenTrackerImpl(@NotNull DiInjectTracker diInjectTracker, @PerformanceTrackersModule.Init @NotNull SimpleTracker simpleTracker, @NotNull Set<ContentTracker> set) {
        Intrinsics.checkNotNullParameter(diInjectTracker, "diInject");
        Intrinsics.checkNotNullParameter(simpleTracker, "init");
        Intrinsics.checkNotNullParameter(set, "contentTrackers");
        this.a = diInjectTracker;
        this.b = simpleTracker;
        this.c = set;
    }

    @Override // com.avito.android.performance.ScreenTracker
    @NotNull
    public DiInjectTracker getDiInject() {
        return this.a;
    }

    @Override // com.avito.android.performance.ScreenTracker
    @NotNull
    public SimpleTracker getInit() {
        return this.b;
    }

    @Override // com.avito.android.performance.ScreenTracker
    public void resetSession() {
    }

    @Override // com.avito.android.performance.ScreenTracker
    public void stop() {
        getInit().stop();
        Iterator<T> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().stop();
        }
    }
}

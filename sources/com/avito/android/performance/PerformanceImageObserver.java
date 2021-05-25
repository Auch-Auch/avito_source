package com.avito.android.performance;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/performance/PerformanceImageObserver;", "", "Lcom/avito/android/performance/ImageLoadingListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "addListener", "(Lcom/avito/android/performance/ImageLoadingListener;)V", "removeListener", "<init>", "()V", "image-loader_release"}, k = 1, mv = {1, 4, 2})
public final class PerformanceImageObserver {
    @NotNull
    public static final PerformanceImageObserver INSTANCE = new PerformanceImageObserver();

    public final void addListener(@NotNull ImageLoadingListener imageLoadingListener) {
        Intrinsics.checkNotNullParameter(imageLoadingListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        PerformanceImageTracker.INSTANCE.addListener(imageLoadingListener);
    }

    public final void removeListener(@NotNull ImageLoadingListener imageLoadingListener) {
        Intrinsics.checkNotNullParameter(imageLoadingListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        PerformanceImageTracker.INSTANCE.removeListener(imageLoadingListener);
    }
}

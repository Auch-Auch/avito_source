package com.avito.android.service.short_task.metrics;

import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/service/short_task/metrics/AccessibilityInfoProvider;", "Lcom/avito/android/service/short_task/metrics/MetricProvider;", "Lio/reactivex/Observable;", "Lcom/avito/android/service/short_task/metrics/Metric;", "getMetricStream", "()Lio/reactivex/Observable;", "metricStream", "Lcom/avito/android/service/short_task/metrics/AccessibilityManagerWrapper;", AuthSource.SEND_ABUSE, "Lcom/avito/android/service/short_task/metrics/AccessibilityManagerWrapper;", "accessibilityManager", "<init>", "(Lcom/avito/android/service/short_task/metrics/AccessibilityManagerWrapper;)V", "application_release"}, k = 1, mv = {1, 4, 2})
public final class AccessibilityInfoProvider implements MetricProvider {
    public final AccessibilityManagerWrapper a;

    @Inject
    public AccessibilityInfoProvider(@NotNull AccessibilityManagerWrapper accessibilityManagerWrapper) {
        Intrinsics.checkNotNullParameter(accessibilityManagerWrapper, "accessibilityManager");
        this.a = accessibilityManagerWrapper;
    }

    @Override // com.avito.android.service.short_task.metrics.MetricProvider
    @NotNull
    public Observable<Metric> getMetricStream() {
        Observable<Metric> fromArray = Observable.fromArray(new Metric("accessibility_is_on", Boolean.valueOf(this.a.isAccessibilityEnabled())), new Metric("accessibility_talkback", Boolean.valueOf(this.a.isTalkBackEnabled())), new Metric("accessibility_haptic", Boolean.valueOf(this.a.isHapticEnabled())), new Metric("accessibility_visual", Boolean.valueOf(this.a.isVisualEnabled())));
        Intrinsics.checkNotNullExpressionValue(fromArray, "Observable.fromArray(\n  …sVisualEnabled)\n        )");
        return fromArray;
    }
}

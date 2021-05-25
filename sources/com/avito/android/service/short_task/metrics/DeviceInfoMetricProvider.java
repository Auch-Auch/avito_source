package com.avito.android.service.short_task.metrics;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.DeviceMetrics;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/avito/android/service/short_task/metrics/DeviceInfoMetricProvider;", "Lcom/avito/android/service/short_task/metrics/MetricProvider;", "Lio/reactivex/Observable;", "Lcom/avito/android/service/short_task/metrics/Metric;", AuthSource.SEND_ABUSE, "Lio/reactivex/Observable;", "getMetricStream", "()Lio/reactivex/Observable;", "metricStream", "Lcom/avito/android/util/DeviceMetrics;", "deviceMetrics", "<init>", "(Lcom/avito/android/util/DeviceMetrics;)V", "application_release"}, k = 1, mv = {1, 4, 2})
public final class DeviceInfoMetricProvider implements MetricProvider {
    @NotNull
    public final Observable<Metric> a;

    @Inject
    public DeviceInfoMetricProvider(@NotNull DeviceMetrics deviceMetrics) {
        Intrinsics.checkNotNullParameter(deviceMetrics, "deviceMetrics");
        Observable<Metric> fromArray = Observable.fromArray(new Metric("manufacturer", deviceMetrics.getBuildInfo().getManufacturer()), new Metric("screen_width_dp", Integer.valueOf(deviceMetrics.getDisplayRealWidthDp())), new Metric("screen_height_dp", Integer.valueOf(deviceMetrics.getDisplayRealHeightDp())), new Metric("app_width_dp", Integer.valueOf(deviceMetrics.getDisplayWidthDp())), new Metric("app_height_dp", Integer.valueOf(deviceMetrics.getDisplayHeightDp())), new Metric("screen_dpi", Integer.valueOf(deviceMetrics.getDensityDpi())), new Metric("text_scale", Float.valueOf(deviceMetrics.getTextScaleFactor() / deviceMetrics.getDisplayScaleFactor())));
        Intrinsics.checkNotNullExpressionValue(fromArray, "Observable.fromArray(\n  …displayScaleFactor)\n    )");
        this.a = fromArray;
    }

    @Override // com.avito.android.service.short_task.metrics.MetricProvider
    @NotNull
    public Observable<Metric> getMetricStream() {
        return this.a;
    }
}

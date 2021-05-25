package com.avito.android.analytics.screens.fps;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.g;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0004\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\nJ)\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/avito/android/analytics/screens/fps/FpsMetricsCalculator;", "", "", "", "frames", "", "", "", "calculateMetrics", "(Ljava/util/List;)Ljava/util/Map;", "Impl", "analytics-screens_release"}, k = 1, mv = {1, 4, 2})
public interface FpsMetricsCalculator {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ%\u0010\u000e\u001a\u00020\r2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/analytics/screens/fps/FpsMetricsCalculator$Impl;", "Lcom/avito/android/analytics/screens/fps/FpsMetricsCalculator;", "", "", "frames", "", "", "", "calculateMetrics", "(Ljava/util/List;)Ljava/util/Map;", "allFrames", "", "percentile", "", AuthSource.SEND_ABUSE, "(Ljava/util/List;D)I", "<init>", "()V", "analytics-screens_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl implements FpsMetricsCalculator {
        public final int a(List<Long> list, double d) {
            return Math.min(list.size() - 1, (int) Math.rint(((double) list.size()) * d));
        }

        @Override // com.avito.android.analytics.screens.fps.FpsMetricsCalculator
        @NotNull
        public Map<String, Number> calculateMetrics(@NotNull List<Long> list) {
            Intrinsics.checkNotNullParameter(list, "frames");
            long sumOfLong = CollectionsKt___CollectionsKt.sumOfLong(list);
            int size = list.size();
            if (size <= 30 || sumOfLong <= 0) {
                return r.emptyMap();
            }
            g.sort(list);
            return r.mapOf(TuplesKt.to("fps", Double.valueOf(1.0E9d / ((double) (sumOfLong / ((long) size))))), TuplesKt.to("percentile_50", Double.valueOf(FpsMetricsCalculatorKt.access$toMs(list.get(a(list, 0.5d)).longValue()))), TuplesKt.to("percentile_75", Double.valueOf(FpsMetricsCalculatorKt.access$toMs(list.get(a(list, 0.75d)).longValue()))), TuplesKt.to("percentile_90", Double.valueOf(FpsMetricsCalculatorKt.access$toMs(list.get(a(list, 0.9d)).longValue()))), TuplesKt.to("percentile_95", Double.valueOf(FpsMetricsCalculatorKt.access$toMs(list.get(a(list, 0.95d)).longValue()))), TuplesKt.to("percentile_99", Double.valueOf(FpsMetricsCalculatorKt.access$toMs(list.get(a(list, 0.99d)).longValue()))), TuplesKt.to("frame_first", Double.valueOf(FpsMetricsCalculatorKt.access$toMs(list.get(0).longValue()))), TuplesKt.to("frame_last1", Double.valueOf(FpsMetricsCalculatorKt.access$toMs(((Number) a.j2(list, 1)).longValue()))), TuplesKt.to("frame_last2", Double.valueOf(FpsMetricsCalculatorKt.access$toMs(((Number) a.j2(list, 2)).longValue()))), TuplesKt.to("frame_last3", Double.valueOf(FpsMetricsCalculatorKt.access$toMs(((Number) a.j2(list, 3)).longValue()))));
        }
    }

    @NotNull
    Map<String, Number> calculateMetrics(@NotNull List<Long> list);
}

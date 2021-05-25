package com.avito.android.memory_consumption;

import android.os.Debug;
import android.os.SystemClock;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\nJ\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/avito/android/memory_consumption/MemoryMetricsProvider;", "", "Lcom/avito/android/memory_consumption/GcFootprint;", "provideGcFootprint", "()Lcom/avito/android/memory_consumption/GcFootprint;", "Lcom/avito/android/memory_consumption/GcAccumulator;", "gcAccumulator", "Lcom/avito/android/memory_consumption/MemoryMetrics;", "provideMemoryMetrics", "(Lcom/avito/android/memory_consumption/GcAccumulator;)Lcom/avito/android/memory_consumption/MemoryMetrics;", "Impl", "memory-consumption_release"}, k = 1, mv = {1, 4, 2})
public interface MemoryMetricsProvider {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/avito/android/memory_consumption/MemoryMetricsProvider$Impl;", "Lcom/avito/android/memory_consumption/MemoryMetricsProvider;", "Lcom/avito/android/memory_consumption/GcFootprint;", "provideGcFootprint", "()Lcom/avito/android/memory_consumption/GcFootprint;", "Lcom/avito/android/memory_consumption/GcAccumulator;", "gcAccumulator", "Lcom/avito/android/memory_consumption/MemoryMetrics;", "provideMemoryMetrics", "(Lcom/avito/android/memory_consumption/GcAccumulator;)Lcom/avito/android/memory_consumption/MemoryMetrics;", "<init>", "()V", "memory-consumption_release"}, k = 1, mv = {1, 4, 2})
    @RequiresApi(23)
    public static final class Impl implements MemoryMetricsProvider {
        @Override // com.avito.android.memory_consumption.MemoryMetricsProvider
        @NotNull
        public GcFootprint provideGcFootprint() {
            String runtimeStat = Debug.getRuntimeStat("art.gc.gc-count");
            Intrinsics.checkNotNullExpressionValue(runtimeStat, "Debug.getRuntimeStat(\"art.gc.gc-count\")");
            long parseLong = Long.parseLong(runtimeStat);
            String runtimeStat2 = Debug.getRuntimeStat("art.gc.gc-time");
            Intrinsics.checkNotNullExpressionValue(runtimeStat2, "Debug.getRuntimeStat(\"art.gc.gc-time\")");
            long parseLong2 = Long.parseLong(runtimeStat2);
            String runtimeStat3 = Debug.getRuntimeStat("art.gc.blocking-gc-count");
            Intrinsics.checkNotNullExpressionValue(runtimeStat3, "Debug.getRuntimeStat(\"art.gc.blocking-gc-count\")");
            long parseLong3 = Long.parseLong(runtimeStat3);
            String runtimeStat4 = Debug.getRuntimeStat("art.gc.blocking-gc-time");
            Intrinsics.checkNotNullExpressionValue(runtimeStat4, "Debug.getRuntimeStat(\"art.gc.blocking-gc-time\")");
            long parseLong4 = Long.parseLong(runtimeStat4);
            String runtimeStat5 = Debug.getRuntimeStat("art.gc.bytes-allocated");
            Intrinsics.checkNotNullExpressionValue(runtimeStat5, "Debug.getRuntimeStat(\"art.gc.bytes-allocated\")");
            String runtimeStat6 = Debug.getRuntimeStat("art.gc.bytes-freed");
            Intrinsics.checkNotNullExpressionValue(runtimeStat6, "Debug.getRuntimeStat(\"art.gc.bytes-freed\")");
            return new GcFootprint(parseLong, parseLong2, parseLong3, parseLong4, Long.parseLong(runtimeStat5) / 1024, Long.parseLong(runtimeStat6) / 1024, SystemClock.elapsedRealtime());
        }

        @Override // com.avito.android.memory_consumption.MemoryMetricsProvider
        @NotNull
        public MemoryMetrics provideMemoryMetrics(@NotNull GcAccumulator gcAccumulator) {
            Intrinsics.checkNotNullParameter(gcAccumulator, "gcAccumulator");
            Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memoryInfo);
            String memoryStat = memoryInfo.getMemoryStat("summary.native-heap");
            Intrinsics.checkNotNullExpressionValue(memoryStat, "memoryInfo.getMemoryStat(\"summary.native-heap\")");
            long parseLong = Long.parseLong(memoryStat);
            String memoryStat2 = memoryInfo.getMemoryStat("summary.java-heap");
            Intrinsics.checkNotNullExpressionValue(memoryStat2, "memoryInfo.getMemoryStat(\"summary.java-heap\")");
            long parseLong2 = Long.parseLong(memoryStat2);
            String memoryStat3 = memoryInfo.getMemoryStat("summary.private-other");
            Intrinsics.checkNotNullExpressionValue(memoryStat3, "memoryInfo.getMemoryStat(\"summary.private-other\")");
            return new MemoryMetrics(parseLong, parseLong2, Long.parseLong(memoryStat3), gcAccumulator.getGcCount(), gcAccumulator.getGcTime(), gcAccumulator.getBlockingGcCount(), gcAccumulator.getBlockingGcTime(), gcAccumulator.getAllocatedSize(), gcAccumulator.getFreedSize(), gcAccumulator.getTimeRange());
        }
    }

    @NotNull
    GcFootprint provideGcFootprint();

    @NotNull
    MemoryMetrics provideMemoryMetrics(@NotNull GcAccumulator gcAccumulator);
}

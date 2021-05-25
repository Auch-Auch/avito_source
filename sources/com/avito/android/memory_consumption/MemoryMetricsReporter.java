package com.avito.android.memory_consumption;

import com.avito.android.remote.auth.AuthSource;
import com.yandex.mobile.ads.video.tracking.Tracker;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\nJ\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/avito/android/memory_consumption/MemoryMetricsReporter;", "", "", "restart", "()V", Tracker.Events.CREATIVE_RESUME, Tracker.Events.CREATIVE_PAUSE, "Lcom/avito/android/memory_consumption/MemoryMetrics;", "report", "()Lcom/avito/android/memory_consumption/MemoryMetrics;", "Impl", "memory-consumption_release"}, k = 1, mv = {1, 4, 2})
public interface MemoryMetricsReporter {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/memory_consumption/MemoryMetricsReporter$Impl;", "Lcom/avito/android/memory_consumption/MemoryMetricsReporter;", "", "restart", "()V", Tracker.Events.CREATIVE_RESUME, Tracker.Events.CREATIVE_PAUSE, "Lcom/avito/android/memory_consumption/MemoryMetrics;", "report", "()Lcom/avito/android/memory_consumption/MemoryMetrics;", "Lcom/avito/android/memory_consumption/GcFootprint;", AuthSource.SEND_ABUSE, "()Lcom/avito/android/memory_consumption/GcFootprint;", "Lcom/avito/android/memory_consumption/MemoryMetricsProvider;", "Lcom/avito/android/memory_consumption/MemoryMetricsProvider;", "memoryMetricsProvider", "Lcom/avito/android/memory_consumption/GcUsageCollector;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/memory_consumption/GcUsageCollector;", "collector", "<init>", "(Lcom/avito/android/memory_consumption/MemoryMetricsProvider;Lcom/avito/android/memory_consumption/GcUsageCollector;)V", "memory-consumption_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl implements MemoryMetricsReporter {
        public final MemoryMetricsProvider a;
        public final GcUsageCollector b;

        @Inject
        public Impl(@NotNull MemoryMetricsProvider memoryMetricsProvider, @NotNull GcUsageCollector gcUsageCollector) {
            Intrinsics.checkNotNullParameter(memoryMetricsProvider, "memoryMetricsProvider");
            Intrinsics.checkNotNullParameter(gcUsageCollector, "collector");
            this.a = memoryMetricsProvider;
            this.b = gcUsageCollector;
        }

        public final GcFootprint a() {
            return this.a.provideGcFootprint();
        }

        @Override // com.avito.android.memory_consumption.MemoryMetricsReporter
        public void pause() {
            this.b.reportStop(a());
        }

        @Override // com.avito.android.memory_consumption.MemoryMetricsReporter
        @NotNull
        public MemoryMetrics report() {
            if (!this.b.isMeasured()) {
                this.b.reportStop(a());
            }
            return this.a.provideMemoryMetrics(this.b.getTotalGcUsage());
        }

        @Override // com.avito.android.memory_consumption.MemoryMetricsReporter
        public void restart() {
            this.b.restart();
        }

        @Override // com.avito.android.memory_consumption.MemoryMetricsReporter
        public void resume() {
            this.b.reportStart(a());
        }
    }

    void pause();

    @NotNull
    MemoryMetrics report();

    void restart();

    void resume();
}

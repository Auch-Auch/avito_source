package com.avito.android.analytics.screens.tracker;

import a2.a.a.i.i.c.a;
import a2.g.r.g;
import android.os.Handler;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.perfomance.ScreenMemoryConsumptionEvent;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.analytics.screens.TrackerInfoProvider;
import com.avito.android.analytics.statsd.StatsdEvent;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.memory_consumption.MemoryMetrics;
import com.avito.android.memory_consumption.MemoryMetricsReporter;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u001e\u001a\u00020\u001b¢\u0006\u0004\b*\u0010+J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u001f\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010#R\u0016\u0010%\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010#¨\u0006,"}, d2 = {"Lcom/avito/android/analytics/screens/tracker/ScreenMemoryMeasureTrackerImpl;", "Lcom/avito/android/analytics/screens/tracker/ScreenMemoryMeasureTracker;", "", "restart", "()V", "resumeTracking", "pauseTracking", "reportLeast", AuthSource.SEND_ABUSE, "", "metricName", "", "metricValue", AuthSource.BOOKING_ORDER, "(Ljava/lang/String;Ljava/lang/Number;)V", "Landroid/os/Handler;", "d", "Landroid/os/Handler;", "handler", "Lcom/avito/android/Features;", "f", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/analytics/screens/Timer;", "e", "Lcom/avito/android/analytics/screens/Timer;", "timer", "Lcom/avito/android/memory_consumption/MemoryMetricsReporter;", g.a, "Lcom/avito/android/memory_consumption/MemoryMetricsReporter;", "memoryMetricsReporter", "Lcom/avito/android/analytics/Analytics;", "c", "Lcom/avito/android/analytics/Analytics;", "analytics", "Ljava/lang/String;", "prefix", "screenName", "Lcom/avito/android/analytics/screens/TrackerInfoProvider;", "trackerInfoProvider", "Lcom/avito/android/analytics/screens/Screen;", InternalConstsKt.SCREEN, "<init>", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/analytics/screens/TrackerInfoProvider;Lcom/avito/android/analytics/screens/Screen;Landroid/os/Handler;Lcom/avito/android/analytics/screens/Timer;Lcom/avito/android/Features;Lcom/avito/android/memory_consumption/MemoryMetricsReporter;)V", "analytics-screens_release"}, k = 1, mv = {1, 4, 2})
public final class ScreenMemoryMeasureTrackerImpl implements ScreenMemoryMeasureTracker {
    public final String a;
    public final String b;
    public final Analytics c;
    public final Handler d;
    public final Timer e;
    public final Features f;
    public final MemoryMetricsReporter g;

    public ScreenMemoryMeasureTrackerImpl(@NotNull Analytics analytics, @NotNull TrackerInfoProvider trackerInfoProvider, @NotNull Screen screen, @NotNull Handler handler, @NotNull Timer timer, @NotNull Features features, @NotNull MemoryMetricsReporter memoryMetricsReporter) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(trackerInfoProvider, "trackerInfoProvider");
        Intrinsics.checkNotNullParameter(screen, InternalConstsKt.SCREEN);
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(timer, "timer");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(memoryMetricsReporter, "memoryMetricsReporter");
        this.c = analytics;
        this.d = handler;
        this.e = timer;
        this.f = features;
        this.g = memoryMetricsReporter;
        String name = screen.getName();
        this.a = name;
        this.b = trackerInfoProvider.getPrefixStatsd() + ".memory-consumption" + FormatterType.defaultDecimalSeparator + name;
    }

    public static final void access$sendReportDelayed(ScreenMemoryMeasureTrackerImpl screenMemoryMeasureTrackerImpl, long j) {
        screenMemoryMeasureTrackerImpl.d.postDelayed(new a(screenMemoryMeasureTrackerImpl), j);
    }

    public final void a() {
        MemoryMetrics report = this.g.report();
        if (this.f.getDwhMemoryMetrics().invoke().booleanValue()) {
            this.c.track(new ScreenMemoryConsumptionEvent(this.a, report.getNativeHeapSize(), report.getJavaHeapSize(), report.getTotalPrivateSize(), report.getGcCount(), report.getGcTime(), report.getBlockingGcCount(), report.getBlockingGcTime(), report.getAllocatedSize(), report.getFreedSize(), report.getTimeRange()));
        }
        if (this.f.getStatsdMemoryMetrics().invoke().booleanValue()) {
            b("nativeHeapSize", Long.valueOf(report.getNativeHeapSize()));
            b("javaHeapSize", Long.valueOf(report.getJavaHeapSize()));
            b("totalPrivateSize", Long.valueOf(report.getTotalPrivateSize()));
            b("allocatedSize", Long.valueOf(report.getAllocatedSize()));
            b("freedSize", Long.valueOf(report.getFreedSize()));
            b("gcCount", Long.valueOf(report.getGcCount()));
            b("gcTime", Long.valueOf(report.getGcTime()));
            b("blockingGcCount", Long.valueOf(report.getBlockingGcCount()));
            b("blockingGcTime", Long.valueOf(report.getBlockingGcTime()));
            b("timeRange", Long.valueOf(report.getTimeRange()));
        }
    }

    public final void b(String str, Number number) {
        Analytics analytics = this.c;
        analytics.track(new StatsdEvent.TimeEvent(this.b + FormatterType.defaultDecimalSeparator + str, number));
    }

    @Override // com.avito.android.analytics.screens.tracker.ScreenMemoryMeasureTracker
    public void pauseTracking() {
        this.g.pause();
        this.e.pause();
        this.d.removeCallbacksAndMessages(null);
    }

    @Override // com.avito.android.analytics.screens.tracker.ScreenMemoryMeasureTracker
    public void reportLeast() {
        a();
        this.e.stop();
    }

    @Override // com.avito.android.analytics.screens.tracker.ScreenMemoryMeasureTracker
    public void restart() {
        this.g.restart();
    }

    @Override // com.avito.android.analytics.screens.tracker.ScreenMemoryMeasureTracker
    public void resumeTracking() {
        this.g.resume();
        this.e.start();
        this.d.postDelayed(new a(this), Math.max(10000 - this.e.elapsed(), 0L));
    }
}

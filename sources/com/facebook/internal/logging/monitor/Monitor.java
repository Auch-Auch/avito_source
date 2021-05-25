package com.facebook.internal.logging.monitor;

import a2.g.r.m.a.a;
import android.os.SystemClock;
import androidx.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import com.facebook.internal.logging.LogCategory;
import com.facebook.internal.logging.LogEvent;
import com.facebook.internal.logging.LoggingManager;
import com.facebook.internal.logging.monitor.MetricsUtil;
import com.facebook.internal.logging.monitor.MonitorLog;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@AutoHandleExceptions
public class Monitor {
    public static final Random a = new Random();
    public static Integer b = 1000;
    public static boolean c;
    public static final LoggingManager d = MonitorLoggingManager.getInstance(MonitorLoggingQueue.getInstance(), MonitorLoggingStore.getInstance());
    public static final MetricsUtil e = MetricsUtil.getInstance();
    public static final Map<String, Integer> f = new HashMap();
    public static final AtomicLong g = new AtomicLong(0);

    public static long a() {
        return Thread.currentThread().getId();
    }

    public static void cancelMeasurePerfFor(PerformanceEventName performanceEventName) {
        long a3 = a();
        MetricsUtil metricsUtil = e;
        metricsUtil.a.remove(new MetricsUtil.a(performanceEventName, a3));
    }

    public static void enable() {
        if (!c) {
            c = true;
            FacebookSdk.getExecutor().execute(new a());
            d.flushLoggingStore();
        }
    }

    public static long generateExtraId() {
        return g.incrementAndGet();
    }

    public static boolean isEnabled() {
        return c;
    }

    public static void startMeasurePerfFor(PerformanceEventName performanceEventName, long j) {
        if (c) {
            String performanceEventName2 = performanceEventName.toString();
            boolean z = false;
            if (!Utility.isNullOrEmpty(performanceEventName2)) {
                int intValue = b.intValue();
                Map<String, Integer> map = f;
                if (map.containsKey(performanceEventName2)) {
                    intValue = map.get(performanceEventName2).intValue();
                }
                if (intValue > 0 && a.nextInt(intValue) == 0) {
                    z = true;
                }
            }
            if (z) {
                MetricsUtil metricsUtil = e;
                Objects.requireNonNull(metricsUtil);
                metricsUtil.a.put(new MetricsUtil.a(performanceEventName, j), new MetricsUtil.b(SystemClock.elapsedRealtime()));
            }
        }
    }

    public static void stopMeasurePerfFor(PerformanceEventName performanceEventName, long j) {
        MetricsUtil metricsUtil = e;
        Objects.requireNonNull(metricsUtil);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        MetricsUtil.a aVar = new MetricsUtil.a(performanceEventName, j);
        LogEvent logEvent = new LogEvent(performanceEventName.toString(), LogCategory.PERFORMANCE);
        MonitorLog build = new MonitorLog.LogBuilder(logEvent).timeSpent(-1).build();
        if (!metricsUtil.a.containsKey(aVar)) {
            Utility.logd("com.facebook.internal.logging.monitor.MetricsUtil", "Can't measure for " + performanceEventName + ", startMeasureFor hasn't been called before.");
        } else {
            MetricsUtil.b bVar = metricsUtil.a.get(aVar);
            if (bVar != null) {
                build = new MonitorLog.LogBuilder(logEvent).timeSpent((int) (elapsedRealtime - bVar.a)).build();
            }
            metricsUtil.a.remove(aVar);
        }
        if (build.isValid() && c) {
            d.addLog(build);
        }
    }

    public static void cancelMeasurePerfFor(PerformanceEventName performanceEventName, long j) {
        MetricsUtil metricsUtil = e;
        metricsUtil.a.remove(new MetricsUtil.a(performanceEventName, j));
    }

    public static void startMeasurePerfFor(PerformanceEventName performanceEventName) {
        startMeasurePerfFor(performanceEventName, a());
    }

    public static void stopMeasurePerfFor(PerformanceEventName performanceEventName) {
        stopMeasurePerfFor(performanceEventName, a());
    }
}

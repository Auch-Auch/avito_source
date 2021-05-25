package com.facebook.internal.logging.monitor;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import java.util.HashMap;
import java.util.Map;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@AutoHandleExceptions
public class MetricsUtil {
    public static final int INVALID_TIME = -1;
    public static MetricsUtil b;
    public final Map<a, b> a = new HashMap();

    public static class a {
        public PerformanceEventName a;
        public long b;

        public a(PerformanceEventName performanceEventName, long j) {
            this.a = performanceEventName;
            this.b = j;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.b == aVar.b && this.a == aVar.a) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            long j = this.b;
            return ((this.a.hashCode() + 527) * 31) + ((int) (j ^ (j >>> 32)));
        }
    }

    public static class b {
        public long a;

        public b(long j) {
            this.a = j;
        }
    }

    public static synchronized MetricsUtil getInstance() {
        MetricsUtil metricsUtil;
        synchronized (MetricsUtil.class) {
            if (b == null) {
                b = new MetricsUtil();
            }
            metricsUtil = b;
        }
        return metricsUtil;
    }
}

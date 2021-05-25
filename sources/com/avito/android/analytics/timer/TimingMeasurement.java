package com.avito.android.analytics.timer;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0001\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/analytics/timer/TimingMeasurement;", "", "", AuthSource.SEND_ABUSE, "J", "getTimestamp", "()J", "timestamp", "Lcom/avito/android/analytics/timer/Start;", "Lcom/avito/android/analytics/timer/End;", "analytics_release"}, k = 1, mv = {1, 4, 2})
public abstract class TimingMeasurement {
    public final long a;

    public TimingMeasurement(long j, j jVar) {
        this.a = j;
    }

    public final long getTimestamp() {
        return this.a;
    }
}

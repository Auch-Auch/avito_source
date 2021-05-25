package com.avito.android.app.task;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.statsd.StatsdEvent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.SchedulersFactory;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0012\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0018\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/app/task/SendStartupTimeTask;", "", "", "time", "", "sendTime", "(J)V", "Lcom/avito/android/util/BuildInfo;", "c", "Lcom/avito/android/util/BuildInfo;", "getBuildInfo", "()Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/analytics/Analytics;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "getSchedulers", "()Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/util/BuildInfo;)V", "application_release"}, k = 1, mv = {1, 4, 2})
public class SendStartupTimeTask {
    @NotNull
    public final Analytics a;
    @NotNull
    public final SchedulersFactory b;
    @NotNull
    public final BuildInfo c;

    @Inject
    public SendStartupTimeTask(@NotNull Analytics analytics, @NotNull SchedulersFactory schedulersFactory, @NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        this.a = analytics;
        this.b = schedulersFactory;
        this.c = buildInfo;
    }

    @NotNull
    public final Analytics getAnalytics() {
        return this.a;
    }

    @NotNull
    public final BuildInfo getBuildInfo() {
        return this.c;
    }

    @NotNull
    public final SchedulersFactory getSchedulers() {
        return this.b;
    }

    public final void sendTime(long j) {
        this.a.track(new StatsdEvent.TimeEvent(this.c.getVersionCode() + ".os." + this.c.getSdkVersion() + ".app-startup-time", Long.valueOf(j)));
    }
}

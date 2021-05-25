package com.avito.android.analytics;

import android.content.res.Configuration;
import com.avito.android.analytics.event.OrientationChangeEvent;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/avito/android/analytics/OrientationTracker;", "", "Landroid/content/res/Configuration;", "newConfig", "", "trackOrientationChange", "(Landroid/content/res/Configuration;)V", "", AuthSource.SEND_ABUSE, "I", "currentOrientation", "Lcom/avito/android/analytics/Analytics;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/Analytics;", "analytics", "configuration", "<init>", "(Lcom/avito/android/analytics/Analytics;Landroid/content/res/Configuration;)V", "analytics_release"}, k = 1, mv = {1, 4, 2})
public final class OrientationTracker {
    public int a;
    public final Analytics b;

    public OrientationTracker(@NotNull Analytics analytics, @NotNull Configuration configuration) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.b = analytics;
        this.a = configuration.orientation;
    }

    public final void trackOrientationChange(@NotNull Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "newConfig");
        if (this.a != configuration.orientation) {
            this.b.track(new OrientationChangeEvent(configuration.screenWidthDp, configuration.screenHeightDp));
        }
        this.a = configuration.orientation;
    }
}

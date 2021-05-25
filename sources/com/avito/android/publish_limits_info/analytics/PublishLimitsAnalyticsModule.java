package com.avito.android.publish_limits_info.analytics;

import com.avito.android.analytics.Analytics;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/publish_limits_info/analytics/PublishLimitsAnalyticsModule;", "", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/publish_limits_info/analytics/PublishLimitsEventTracker;", "provideAnalytics", "(Lcom/avito/android/analytics/Analytics;)Lcom/avito/android/publish_limits_info/analytics/PublishLimitsEventTracker;", "<init>", "()V", "publish-limits-info_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class PublishLimitsAnalyticsModule {
    @NotNull
    public static final PublishLimitsAnalyticsModule INSTANCE = new PublishLimitsAnalyticsModule();

    @Provides
    @NotNull
    public final PublishLimitsEventTracker provideAnalytics(@NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        return new PublishLimitsEventTrackerImpl(analytics);
    }
}

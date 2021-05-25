package com.avito.android.publish.drafts.di;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.publish.drafts.analytics.PublishDraftEventTracker;
import com.avito.android.publish.drafts.analytics.PublishDraftEventTrackerImpl;
import com.google.gson.Gson;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/publish/drafts/di/PublishDraftsAnalyticsModule;", "", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "dataProvider", "Lcom/google/gson/Gson;", "gson", "Lcom/avito/android/publish/drafts/analytics/PublishDraftEventTracker;", "providePublishEventTracker", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;Lcom/google/gson/Gson;)Lcom/avito/android/publish/drafts/analytics/PublishDraftEventTracker;", "<init>", "()V", "publish-drafts_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class PublishDraftsAnalyticsModule {
    @NotNull
    public static final PublishDraftsAnalyticsModule INSTANCE = new PublishDraftsAnalyticsModule();

    @Provides
    @JvmStatic
    @NotNull
    public static final PublishDraftEventTracker providePublishEventTracker(@NotNull Analytics analytics, @NotNull PublishAnalyticsDataProvider publishAnalyticsDataProvider, @AnalyticsParametersSerializer @NotNull Gson gson) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(publishAnalyticsDataProvider, "dataProvider");
        Intrinsics.checkNotNullParameter(gson, "gson");
        return new PublishDraftEventTrackerImpl(analytics, publishAnalyticsDataProvider, gson);
    }
}

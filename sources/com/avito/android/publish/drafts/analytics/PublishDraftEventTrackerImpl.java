package com.avito.android.publish.drafts.analytics;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.publish.drafts.analytics.events.PublishDraftAcceptedEvent;
import com.avito.android.publish.drafts.analytics.events.PublishDraftDialogShownEvent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.NavigationKt;
import com.google.gson.Gson;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/publish/drafts/analytics/PublishDraftEventTrackerImpl;", "Lcom/avito/android/publish/drafts/analytics/PublishDraftEventTracker;", "", "draftsSessionId", "", "trackDialogShown", "(Ljava/lang/String;)V", "Lcom/avito/android/remote/model/Navigation;", "navigation", "draftId", "trackDraftAccepted", "(Lcom/avito/android/remote/model/Navigation;Ljava/lang/String;)V", "Lcom/avito/android/analytics/Analytics;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/google/gson/Gson;", "c", "Lcom/google/gson/Gson;", "gson", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "analyticsDataProvider", "<init>", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;Lcom/google/gson/Gson;)V", "publish-drafts_release"}, k = 1, mv = {1, 4, 2})
public final class PublishDraftEventTrackerImpl implements PublishDraftEventTracker {
    public final Analytics a;
    public final PublishAnalyticsDataProvider b;
    public final Gson c;

    public PublishDraftEventTrackerImpl(@NotNull Analytics analytics, @NotNull PublishAnalyticsDataProvider publishAnalyticsDataProvider, @NotNull Gson gson) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(publishAnalyticsDataProvider, "analyticsDataProvider");
        Intrinsics.checkNotNullParameter(gson, "gson");
        this.a = analytics;
        this.b = publishAnalyticsDataProvider;
        this.c = gson;
    }

    @Override // com.avito.android.publish.drafts.analytics.PublishDraftEventTracker
    public void trackDialogShown(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "draftsSessionId");
        this.a.track(new PublishDraftDialogShownEvent(TuplesKt.to("esid", str)));
    }

    @Override // com.avito.android.publish.drafts.analytics.PublishDraftEventTracker
    public void trackDraftAccepted(@NotNull Navigation navigation, @NotNull String str) {
        Intrinsics.checkNotNullParameter(navigation, "navigation");
        Intrinsics.checkNotNullParameter(str, "draftId");
        Analytics analytics = this.a;
        PublishAnalyticsDataProvider publishAnalyticsDataProvider = this.b;
        Integer categoryId = navigation.getCategoryId();
        List<Map<String, String>> attributes = navigation.getAttributes();
        analytics.track(new PublishDraftAcceptedEvent(publishAnalyticsDataProvider, categoryId, attributes != null ? NavigationKt.toAnalyticsFormat(attributes, this.c) : null, str));
    }
}

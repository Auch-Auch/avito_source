package com.avito.android.ui.widget.tagged_input.analytics;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.Event;
import com.avito.android.analytics.events.ClickSuggestParametrizedEvent;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.search.suggest.SuggestAnalyticsEvent;
import com.avito.android.ui.widget.tagged_input.TagItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/ui/widget/tagged_input/analytics/TagSelectionTracker;", "", "Lcom/avito/android/ui/widget/tagged_input/TagItem;", "tag", "", "trackTagSelection", "(Lcom/avito/android/ui/widget/tagged_input/TagItem;)V", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "publishAnalyticsDataProvider", "Lcom/avito/android/analytics/Analytics;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class TagSelectionTracker {
    public final Analytics a;
    public final PublishAnalyticsDataProvider b;

    public TagSelectionTracker(@NotNull Analytics analytics, @NotNull PublishAnalyticsDataProvider publishAnalyticsDataProvider) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(publishAnalyticsDataProvider, "publishAnalyticsDataProvider");
        this.a = analytics;
        this.b = publishAnalyticsDataProvider;
    }

    public final void trackTagSelection(@NotNull TagItem tagItem) {
        Event event;
        Intrinsics.checkNotNullParameter(tagItem, "tag");
        Analytics analytics = this.a;
        SuggestAnalyticsEvent clickEvent = tagItem.getClickEvent();
        if (clickEvent == null || (event = ClickSuggestParametrizedEvent.Companion.fromAction(clickEvent)) == null) {
            event = new TagSelectionEvent(this.b, tagItem.getLabel());
        }
        analytics.track(event);
    }
}

package com.avito.android.suggest_locations.analytics;

import com.avito.android.analytics.Analytics;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.suggest_locations.analytics.events.SuggestLocationsScreenCloseEvent;
import com.avito.android.suggest_locations.analytics.events.SuggestLocationsScreenOpenEvent;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0011¢\u0006\u0004\b\u0017\u0010\u0018J7\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJQ\u0010\u000f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0016\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/suggest_locations/analytics/SuggestLocationsAnalyticsInteractorImpl;", "Lcom/avito/android/suggest_locations/analytics/SuggestLocationsAnalyticsInteractor;", "", "categoryId", "locationId", "", BookingInfoActivity.EXTRA_FROM_BLOCK, "geoSessionId", "", "trackSuggestLocationsScreenOpen", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "locationInput", "Lcom/avito/android/suggest_locations/analytics/FromBlock;", "fromPage", "oldLocationId", "trackSuggestLocationsScreenClose", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/suggest_locations/analytics/FromBlock;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/avito/android/analytics/Analytics;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Lcom/avito/android/analytics/Analytics;)V", "suggest-locations_release"}, k = 1, mv = {1, 4, 2})
public final class SuggestLocationsAnalyticsInteractorImpl implements SuggestLocationsAnalyticsInteractor {
    @NotNull
    public final Analytics a;

    @Inject
    public SuggestLocationsAnalyticsInteractorImpl(@NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.a = analytics;
    }

    @NotNull
    public final Analytics getAnalytics() {
        return this.a;
    }

    @Override // com.avito.android.suggest_locations.analytics.SuggestLocationsAnalyticsInteractor
    public void trackSuggestLocationsScreenClose(@Nullable String str, @Nullable String str2, @NotNull String str3, @NotNull FromBlock fromBlock, @Nullable Integer num, @Nullable String str4, @Nullable String str5) {
        Intrinsics.checkNotNullParameter(str3, "locationInput");
        Intrinsics.checkNotNullParameter(fromBlock, BookingInfoActivity.EXTRA_FROM_BLOCK);
        this.a.track(new SuggestLocationsScreenCloseEvent(str, str2, str3, fromBlock, num, str4, str5));
    }

    @Override // com.avito.android.suggest_locations.analytics.SuggestLocationsAnalyticsInteractor
    public void trackSuggestLocationsScreenOpen(@Nullable String str, @Nullable String str2, @Nullable Integer num, @Nullable String str3) {
        this.a.track(new SuggestLocationsScreenOpenEvent(str, str2, num, str3));
    }
}

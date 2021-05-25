package com.avito.android.location_list.analytics;

import com.avito.android.analytics.Analytics;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.location_list.analytics.events.LocationListScreenCloseEvent;
import com.avito.android.location_list.analytics.events.LocationListScreenOpenEvent;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\r¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J3\u0010\u000b\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u0012\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/location_list/analytics/LocationListAnalyticsInteractorImpl;", "Lcom/avito/android/location_list/analytics/LocationListAnalyticsInteractor;", "", "categoryId", "locationId", "", "trackLocationListScreenOpen", "(Ljava/lang/String;Ljava/lang/String;)V", "locationInput", "Lcom/avito/android/location_list/analytics/FromBlock;", BookingInfoActivity.EXTRA_FROM_BLOCK, "trackLocationListScreenClose", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/location_list/analytics/FromBlock;)V", "Lcom/avito/android/analytics/Analytics;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Lcom/avito/android/analytics/Analytics;)V", "location-list_release"}, k = 1, mv = {1, 4, 2})
public final class LocationListAnalyticsInteractorImpl implements LocationListAnalyticsInteractor {
    @NotNull
    public final Analytics a;

    @Inject
    public LocationListAnalyticsInteractorImpl(@NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.a = analytics;
    }

    @NotNull
    public final Analytics getAnalytics() {
        return this.a;
    }

    @Override // com.avito.android.location_list.analytics.LocationListAnalyticsInteractor
    public void trackLocationListScreenClose(@Nullable String str, @Nullable String str2, @NotNull String str3, @NotNull FromBlock fromBlock) {
        Intrinsics.checkNotNullParameter(str3, "locationInput");
        Intrinsics.checkNotNullParameter(fromBlock, BookingInfoActivity.EXTRA_FROM_BLOCK);
        this.a.track(new LocationListScreenCloseEvent(str, str2, str3, fromBlock));
    }

    @Override // com.avito.android.location_list.analytics.LocationListAnalyticsInteractor
    public void trackLocationListScreenOpen(@Nullable String str, @Nullable String str2) {
        this.a.track(new LocationListScreenOpenEvent(str, str2));
    }
}

package com.avito.android.suggest_locations.analytics;

import com.avito.android.booking.info.BookingInfoActivity;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J7\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\t\u0010\nJQ\u0010\u000f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/suggest_locations/analytics/SuggestLocationsAnalyticsInteractor;", "", "", "categoryId", "locationId", "", BookingInfoActivity.EXTRA_FROM_BLOCK, "geoSessionId", "", "trackSuggestLocationsScreenOpen", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "locationInput", "Lcom/avito/android/suggest_locations/analytics/FromBlock;", "fromPage", "oldLocationId", "trackSuggestLocationsScreenClose", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/suggest_locations/analytics/FromBlock;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "suggest-locations_release"}, k = 1, mv = {1, 4, 2})
public interface SuggestLocationsAnalyticsInteractor {
    void trackSuggestLocationsScreenClose(@Nullable String str, @Nullable String str2, @NotNull String str3, @NotNull FromBlock fromBlock, @Nullable Integer num, @Nullable String str4, @Nullable String str5);

    void trackSuggestLocationsScreenOpen(@Nullable String str, @Nullable String str2, @Nullable Integer num, @Nullable String str3);
}

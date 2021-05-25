package com.avito.android.location_list.analytics;

import com.avito.android.booking.info.BookingInfoActivity;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J#\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J3\u0010\u000b\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/location_list/analytics/LocationListAnalyticsInteractor;", "", "", "categoryId", "locationId", "", "trackLocationListScreenOpen", "(Ljava/lang/String;Ljava/lang/String;)V", "locationInput", "Lcom/avito/android/location_list/analytics/FromBlock;", BookingInfoActivity.EXTRA_FROM_BLOCK, "trackLocationListScreenClose", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/location_list/analytics/FromBlock;)V", "location-list_release"}, k = 1, mv = {1, 4, 2})
public interface LocationListAnalyticsInteractor {
    void trackLocationListScreenClose(@Nullable String str, @Nullable String str2, @NotNull String str3, @NotNull FromBlock fromBlock);

    void trackLocationListScreenOpen(@Nullable String str, @Nullable String str2);
}

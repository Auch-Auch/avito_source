package com.avito.android.location.analytics;

import android.location.Location;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.location.LocationSource;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\f\bf\u0018\u00002\u00020\u0001JG\u0010\n\u001a\u00020\t2\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\n\u0010\u000bJ5\u0010\u0011\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J3\u0010\u0017\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u0004H&¢\u0006\u0004\b\u0017\u0010\u0018J5\u0010\u001c\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001a\u001a\u00020\u00192\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001b\u001a\u00020\u0004H&¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u001e\u001a\u00020\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u001e\u0010\u001fJ'\u0010!\u001a\u00020\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\tH&¢\u0006\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;", "", "Ljava/util/HashMap;", "Lcom/avito/android/location/LocationSource;", "", "Lkotlin/collections/HashMap;", "storageTypes", BookingInfoActivity.EXTRA_FROM_BLOCK, "locationId", "", "trackLocationStorageRequested", "(Ljava/util/HashMap;Lcom/avito/android/location/LocationSource;Ljava/lang/String;)V", "Landroid/location/Location;", "location", "fromPage", "", "coordinateResolveTime", "trackHomeRequestWithUserCoordinates", "(Landroid/location/Location;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "geoSessionId", "changeReason", "oldLocationId", "newLocationId", "trackLocationNotificationWasShown", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "isChange", "changeRule", "trackLocationNotificationSubmitted", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "trackFindCoordinates", "(Ljava/lang/String;)V", "errorText", "trackResolveCoordinates", "(Landroid/location/Location;Ljava/lang/String;)V", "trackScreenExitAfterCoordinatesResolve", "()V", "user-location_release"}, k = 1, mv = {1, 4, 2})
public interface LocationAnalyticsInteractor {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void trackFindCoordinates$default(LocationAnalyticsInteractor locationAnalyticsInteractor, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = null;
                }
                locationAnalyticsInteractor.trackFindCoordinates(str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackFindCoordinates");
        }

        public static /* synthetic */ void trackLocationNotificationSubmitted$default(LocationAnalyticsInteractor locationAnalyticsInteractor, String str, boolean z, String str2, String str3, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    str2 = null;
                }
                locationAnalyticsInteractor.trackLocationNotificationSubmitted(str, z, str2, str3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackLocationNotificationSubmitted");
        }

        public static /* synthetic */ void trackResolveCoordinates$default(LocationAnalyticsInteractor locationAnalyticsInteractor, Location location, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    location = null;
                }
                if ((i & 2) != 0) {
                    str = null;
                }
                locationAnalyticsInteractor.trackResolveCoordinates(location, str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackResolveCoordinates");
        }
    }

    void trackFindCoordinates(@Nullable String str);

    void trackHomeRequestWithUserCoordinates(@NotNull Location location, @Nullable String str, @Nullable String str2, @Nullable Integer num);

    void trackLocationNotificationSubmitted(@Nullable String str, boolean z, @Nullable String str2, @NotNull String str3);

    void trackLocationNotificationWasShown(@Nullable String str, @NotNull String str2, @Nullable String str3, @NotNull String str4);

    void trackLocationStorageRequested(@NotNull HashMap<LocationSource, String> hashMap, @Nullable LocationSource locationSource, @Nullable String str);

    void trackResolveCoordinates(@Nullable Location location, @Nullable String str);

    void trackScreenExitAfterCoordinatesResolve();
}

package com.avito.android.location_picker.analytics;

import com.avito.android.analytics.Analytics;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.location_picker.entities.LocationPickerState;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Coordinates;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SearchRadius;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0016\u001a\u00020\u00118B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/location_picker/analytics/LocationPickerAnalyticsInteractorImpl;", "Lcom/avito/android/location_picker/analytics/LocationPickerAnalyticsInteractor;", "Lcom/avito/android/location_picker/entities/LocationPickerState;", "state", "", "trackScreenOpened", "(Lcom/avito/android/location_picker/entities/LocationPickerState;)V", "Lcom/avito/android/location_picker/analytics/ScreenCloseFromBlock;", BookingInfoActivity.EXTRA_FROM_BLOCK, "trackScreenClosed", "(Lcom/avito/android/location_picker/entities/LocationPickerState;Lcom/avito/android/location_picker/analytics/ScreenCloseFromBlock;)V", "Lcom/avito/android/analytics/Analytics;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "analytics", "", AuthSource.SEND_ABUSE, "Lkotlin/Lazy;", "getUuid", "()Ljava/lang/String;", "uuid", "<init>", "(Lcom/avito/android/analytics/Analytics;)V", "location-picker_release"}, k = 1, mv = {1, 4, 2})
public final class LocationPickerAnalyticsInteractorImpl implements LocationPickerAnalyticsInteractor {
    public final Lazy a = c.lazy(a.a);
    @NotNull
    public final Analytics b;

    public static final class a extends Lambda implements Function0<String> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public String invoke() {
            return a2.b.a.a.a.I2("UUID.randomUUID().toString()");
        }
    }

    @Inject
    public LocationPickerAnalyticsInteractorImpl(@NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.b = analytics;
    }

    @NotNull
    public final Analytics getAnalytics() {
        return this.b;
    }

    @Override // com.avito.android.location_picker.analytics.LocationPickerAnalyticsInteractor
    public void trackScreenClosed(@NotNull LocationPickerState locationPickerState, @NotNull ScreenCloseFromBlock screenCloseFromBlock) {
        T t;
        Long distanceInMeters;
        Intrinsics.checkNotNullParameter(locationPickerState, "state");
        Intrinsics.checkNotNullParameter(screenCloseFromBlock, BookingInfoActivity.EXTRA_FROM_BLOCK);
        SearchParams searchParams = locationPickerState.getRadiusState().getSearchParams();
        Analytics analytics = this.b;
        String str = (String) this.a.getValue();
        int value = screenCloseFromBlock.getValue();
        String categoryId = searchParams != null ? searchParams.getCategoryId() : null;
        String locationId = searchParams != null ? searchParams.getLocationId() : null;
        List<String> directionId = searchParams != null ? searchParams.getDirectionId() : null;
        List<String> metroIds = searchParams != null ? searchParams.getMetroIds() : null;
        List<String> districtId = searchParams != null ? searchParams.getDistrictId() : null;
        List listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{String.valueOf(locationPickerState.getLatLng().getLatitude()), String.valueOf(locationPickerState.getLatLng().getLongitude())});
        Iterator<T> it = locationPickerState.getRadiusState().getRadiusList().iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (Intrinsics.areEqual(t.getId(), locationPickerState.getRadiusState().getRadiusId())) {
                break;
            }
        }
        T t2 = t;
        analytics.track(new LocationPickerScreenCloseEvent(str, value, categoryId, locationId, directionId, metroIds, districtId, listOf, (t2 == null || (distanceInMeters = t2.getDistanceInMeters()) == null) ? null : LocationPickerAnalyticsInteractorKt.access$toKilometers(distanceInMeters)));
    }

    @Override // com.avito.android.location_picker.analytics.LocationPickerAnalyticsInteractor
    public void trackScreenOpened(@NotNull LocationPickerState locationPickerState) {
        Long distanceInMeters;
        Coordinates coordinates;
        Intrinsics.checkNotNullParameter(locationPickerState, "state");
        SearchParams searchParams = locationPickerState.getRadiusState().getSearchParams();
        Analytics analytics = this.b;
        String str = (String) this.a.getValue();
        String categoryId = searchParams != null ? searchParams.getCategoryId() : null;
        String locationId = searchParams != null ? searchParams.getLocationId() : null;
        List<String> directionId = searchParams != null ? searchParams.getDirectionId() : null;
        List<String> metroIds = searchParams != null ? searchParams.getMetroIds() : null;
        List<String> districtId = searchParams != null ? searchParams.getDistrictId() : null;
        SearchRadius initialRadius = locationPickerState.getRadiusState().getInitialRadius();
        List listOf = (initialRadius == null || (coordinates = initialRadius.getCoordinates()) == null) ? null : CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{String.valueOf(coordinates.getLatitude()), String.valueOf(coordinates.getLongitude()), "0", String.valueOf(System.currentTimeMillis())});
        SearchRadius initialRadius2 = locationPickerState.getRadiusState().getInitialRadius();
        analytics.track(new LocationPickerScreenOpenEvent(str, categoryId, locationId, directionId, metroIds, districtId, listOf, (initialRadius2 == null || (distanceInMeters = initialRadius2.getDistanceInMeters()) == null) ? null : LocationPickerAnalyticsInteractorKt.access$toKilometers(distanceInMeters)));
    }
}

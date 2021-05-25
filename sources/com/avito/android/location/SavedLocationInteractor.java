package com.avito.android.location;

import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Location;
import io.reactivex.rxjava3.core.Observable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\bf\u0018\u00002\u00020\u0001:\u0001\u001dJ/\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ+\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u0006H&¢\u0006\u0004\b\r\u0010\u000eJ+\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\f2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u0006H&¢\u0006\u0004\b\u0010\u0010\u000eJ+\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\f2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u0006H&¢\u0006\u0004\b\u0012\u0010\u000eJ\u0011\u0010\u0013\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0019\u0010\u0018R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/avito/android/location/SavedLocationInteractor;", "", "Lcom/avito/android/remote/model/Location;", "location", "Lcom/avito/android/location/LocationSource;", "source", "", "locationForcedByUser", "", "saveLocation", "(Lcom/avito/android/remote/model/Location;Lcom/avito/android/location/LocationSource;Z)V", "silently", "Lio/reactivex/rxjava3/core/Observable;", "savedLocation", "(Lcom/avito/android/location/LocationSource;Z)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/location/SavedLocation;", "fullSavedLocation", "Lcom/avito/android/location/SavedLocationInteractor$AnalyticsInfoLocation;", "wrappedLocation", "getLocationForSearch", "()Lcom/avito/android/remote/model/Location;", "", "locationId", "checkLocationForSearch", "(Ljava/lang/String;)Z", "isCorrectLocation", "getOnLocationChanged", "()Lio/reactivex/rxjava3/core/Observable;", "onLocationChanged", "AnalyticsInfoLocation", "user-location_release"}, k = 1, mv = {1, 4, 2})
public interface SavedLocationInteractor {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B?\u0012\"\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\bj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t`\n\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R5\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\bj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t`\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/location/SavedLocationInteractor$AnalyticsInfoLocation;", "", "Lcom/avito/android/location/LocationSource;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/location/LocationSource;", "getFromBlock", "()Lcom/avito/android/location/LocationSource;", BookingInfoActivity.EXTRA_FROM_BLOCK, "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", AuthSource.SEND_ABUSE, "Ljava/util/HashMap;", "getStorageInfo", "()Ljava/util/HashMap;", "storageInfo", "Lcom/avito/android/location/SavedLocation;", "c", "Lcom/avito/android/location/SavedLocation;", "getSavedLocation", "()Lcom/avito/android/location/SavedLocation;", "savedLocation", "<init>", "(Ljava/util/HashMap;Lcom/avito/android/location/LocationSource;Lcom/avito/android/location/SavedLocation;)V", "user-location_release"}, k = 1, mv = {1, 4, 2})
    public static final class AnalyticsInfoLocation {
        @NotNull
        public final HashMap<LocationSource, String> a;
        @Nullable
        public final LocationSource b;
        @Nullable
        public final SavedLocation c;

        public AnalyticsInfoLocation(@NotNull HashMap<LocationSource, String> hashMap, @Nullable LocationSource locationSource, @Nullable SavedLocation savedLocation) {
            Intrinsics.checkNotNullParameter(hashMap, "storageInfo");
            this.a = hashMap;
            this.b = locationSource;
            this.c = savedLocation;
        }

        @Nullable
        public final LocationSource getFromBlock() {
            return this.b;
        }

        @Nullable
        public final SavedLocation getSavedLocation() {
            return this.c;
        }

        @NotNull
        public final HashMap<LocationSource, String> getStorageInfo() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Observable fullSavedLocation$default(SavedLocationInteractor savedLocationInteractor, LocationSource locationSource, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    locationSource = null;
                }
                if ((i & 2) != 0) {
                    z = false;
                }
                return savedLocationInteractor.fullSavedLocation(locationSource, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fullSavedLocation");
        }

        public static /* synthetic */ void saveLocation$default(SavedLocationInteractor savedLocationInteractor, Location location, LocationSource locationSource, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    locationSource = null;
                }
                if ((i & 4) != 0) {
                    z = false;
                }
                savedLocationInteractor.saveLocation(location, locationSource, z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: saveLocation");
        }

        public static /* synthetic */ Observable savedLocation$default(SavedLocationInteractor savedLocationInteractor, LocationSource locationSource, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    locationSource = null;
                }
                if ((i & 2) != 0) {
                    z = false;
                }
                return savedLocationInteractor.savedLocation(locationSource, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: savedLocation");
        }

        public static /* synthetic */ Observable wrappedLocation$default(SavedLocationInteractor savedLocationInteractor, LocationSource locationSource, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    locationSource = null;
                }
                if ((i & 2) != 0) {
                    z = false;
                }
                return savedLocationInteractor.wrappedLocation(locationSource, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: wrappedLocation");
        }
    }

    boolean checkLocationForSearch(@NotNull String str);

    @NotNull
    Observable<SavedLocation> fullSavedLocation(@Nullable LocationSource locationSource, boolean z);

    @Nullable
    Location getLocationForSearch();

    @NotNull
    Observable<Unit> getOnLocationChanged();

    boolean isCorrectLocation(@NotNull String str);

    void saveLocation(@Nullable Location location, @Nullable LocationSource locationSource, boolean z);

    @NotNull
    Observable<Location> savedLocation(@Nullable LocationSource locationSource, boolean z);

    @NotNull
    Observable<AnalyticsInfoLocation> wrappedLocation(@Nullable LocationSource locationSource, boolean z);
}

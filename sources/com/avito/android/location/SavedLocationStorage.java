package com.avito.android.location;

import com.avito.android.remote.model.Location;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001!J#\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\u0007\u0010\tJ\u001f\u0010\u000b\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00020\nH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0004H&¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H&¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u001b\u0010\u001aJ+\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001d0\u001cj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001d`\u001eH&¢\u0006\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lcom/avito/android/location/SavedLocationStorage;", "", "Lcom/avito/android/location/LocationSource;", "source", "", "silently", "Lcom/avito/android/location/SavedLocation;", "getLocation", "(Lcom/avito/android/location/LocationSource;Z)Lcom/avito/android/location/SavedLocation;", "()Lcom/avito/android/location/SavedLocation;", "Lkotlin/Pair;", "getLocationByPriority", "()Lkotlin/Pair;", "", "removeLocation", "()V", "Lcom/avito/android/remote/model/Location;", "location", "locationForcedByUser", "saveLocation", "(Lcom/avito/android/remote/model/Location;Lcom/avito/android/location/LocationSource;Z)V", "hasLocationFromFilters", "()Z", "Lcom/avito/android/location/SavedLocationStorage$OnLocationChangedListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "addLocationChangedListener", "(Lcom/avito/android/location/SavedLocationStorage$OnLocationChangedListener;)V", "removeLocationChangedListener", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getStorageTypesInfo", "()Ljava/util/HashMap;", "OnLocationChangedListener", "user-location_release"}, k = 1, mv = {1, 4, 2})
public interface SavedLocationStorage {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ SavedLocation getLocation$default(SavedLocationStorage savedLocationStorage, LocationSource locationSource, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = false;
                }
                return savedLocationStorage.getLocation(locationSource, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLocation");
        }

        public static /* synthetic */ void saveLocation$default(SavedLocationStorage savedLocationStorage, Location location, LocationSource locationSource, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    locationSource = null;
                }
                if ((i & 4) != 0) {
                    z = false;
                }
                savedLocationStorage.saveLocation(location, locationSource, z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: saveLocation");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/location/SavedLocationStorage$OnLocationChangedListener;", "", "", "onLocationChanged", "()V", "user-location_release"}, k = 1, mv = {1, 4, 2})
    public interface OnLocationChangedListener {
        void onLocationChanged();
    }

    void addLocationChangedListener(@NotNull OnLocationChangedListener onLocationChangedListener);

    @Nullable
    SavedLocation getLocation();

    @Nullable
    SavedLocation getLocation(@NotNull LocationSource locationSource, boolean z);

    @NotNull
    Pair<SavedLocation, LocationSource> getLocationByPriority();

    @NotNull
    HashMap<LocationSource, String> getStorageTypesInfo();

    boolean hasLocationFromFilters();

    void removeLocation();

    void removeLocationChangedListener(@NotNull OnLocationChangedListener onLocationChangedListener);

    void saveLocation(@NotNull Location location, @Nullable LocationSource locationSource, boolean z);
}

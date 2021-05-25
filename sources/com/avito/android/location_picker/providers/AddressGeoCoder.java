package com.avito.android.location_picker.providers;

import com.avito.android.avito_map.AvitoMapBounds;
import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.remote.model.location_picker.AddressByCoordinatesResult;
import com.avito.android.remote.model.location_picker.AddressCoordinatesByQueryResult;
import com.avito.android.remote.model.location_picker.AddressSuggestionResult;
import com.avito.android.remote.model.location_picker.CoordinatesCurrentResult;
import com.avito.android.remote.model.location_picker.CoordinatesVerificationResult;
import com.google.android.gms.maps.model.LatLngBounds;
import io.reactivex.rxjava3.core.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u000fH&¢\u0006\u0004\b\r\u0010\u0010J\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00042\u0006\u0010\u0011\u001a\u00020\bH&¢\u0006\u0004\b\u0013\u0010\u0014J)\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00042\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0004H&¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/avito/android/location_picker/providers/AddressGeoCoder;", "", "Lcom/avito/android/avito_map/AvitoMapPoint;", "latLng", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/location_picker/AddressByCoordinatesResult;", "getAddressByLatLng", "(Lcom/avito/android/avito_map/AvitoMapPoint;)Lio/reactivex/rxjava3/core/Single;", "", "searchQuery", "Lcom/avito/android/avito_map/AvitoMapBounds;", "visibleRegion", "Lcom/avito/android/remote/model/location_picker/AddressSuggestionResult;", "getSuggestions", "(Ljava/lang/String;Lcom/avito/android/avito_map/AvitoMapBounds;)Lio/reactivex/rxjava3/core/Single;", "Lcom/google/android/gms/maps/model/LatLngBounds;", "(Ljava/lang/String;Lcom/google/android/gms/maps/model/LatLngBounds;)Lio/reactivex/rxjava3/core/Single;", "addressQuery", "Lcom/avito/android/remote/model/location_picker/AddressCoordinatesByQueryResult;", "getCoordinatesByAddress", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "itemId", "Lcom/avito/android/remote/model/location_picker/CoordinatesVerificationResult;", "verifyCoordinates", "(Lcom/avito/android/avito_map/AvitoMapPoint;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/location_picker/CoordinatesCurrentResult;", "getCurrentCoordinates", "()Lio/reactivex/rxjava3/core/Single;", "location-picker_release"}, k = 1, mv = {1, 4, 2})
public interface AddressGeoCoder {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Single verifyCoordinates$default(AddressGeoCoder addressGeoCoder, AvitoMapPoint avitoMapPoint, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str = null;
                }
                return addressGeoCoder.verifyCoordinates(avitoMapPoint, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: verifyCoordinates");
        }
    }

    @NotNull
    Single<AddressByCoordinatesResult> getAddressByLatLng(@NotNull AvitoMapPoint avitoMapPoint);

    @NotNull
    Single<AddressCoordinatesByQueryResult> getCoordinatesByAddress(@NotNull String str);

    @NotNull
    Single<CoordinatesCurrentResult> getCurrentCoordinates();

    @NotNull
    Single<AddressSuggestionResult> getSuggestions(@NotNull String str, @NotNull AvitoMapBounds avitoMapBounds);

    @NotNull
    Single<AddressSuggestionResult> getSuggestions(@NotNull String str, @NotNull LatLngBounds latLngBounds);

    @NotNull
    Single<CoordinatesVerificationResult> verifyCoordinates(@NotNull AvitoMapPoint avitoMapPoint, @Nullable String str);
}

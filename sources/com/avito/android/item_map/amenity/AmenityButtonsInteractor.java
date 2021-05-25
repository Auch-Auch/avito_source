package com.avito.android.item_map.amenity;

import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.item_map.remote.model.AmenityResponse;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J3\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/item_map/amenity/AmenityButtonsInteractor;", "", "", "developmentsId", "type", "Lcom/avito/android/avito_map/AvitoMapPoint;", "coordinates", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/item_map/remote/model/AmenityResponse;", "getAmenityPins", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/avito_map/AvitoMapPoint;)Lio/reactivex/rxjava3/core/Observable;", "item-map_release"}, k = 1, mv = {1, 4, 2})
public interface AmenityButtonsInteractor {
    @NotNull
    Observable<LoadingState<AmenityResponse>> getAmenityPins(@NotNull String str, @NotNull String str2, @NotNull AvitoMapPoint avitoMapPoint);
}

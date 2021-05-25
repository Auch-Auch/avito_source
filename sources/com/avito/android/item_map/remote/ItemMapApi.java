package com.avito.android.item_map.remote;

import com.avito.android.item_map.remote.model.AmenityResponse;
import com.avito.android.remote.model.TypedResult;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JC\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0002H'¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/item_map/remote/ItemMapApi;", "", "", "itemId", "", "lat", "lng", "type", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/item_map/remote/model/AmenityResponse;", "getAmenity", "(Ljava/lang/String;FFLjava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "item-map_release"}, k = 1, mv = {1, 4, 2})
public interface ItemMapApi {
    @GET("1/developmentsCatalog/amenity/{itemId}")
    @NotNull
    Observable<TypedResult<AmenityResponse>> getAmenity(@Path("itemId") @NotNull String str, @Query("lat") float f, @Query("lng") float f2, @NotNull @Query("type") String str2);
}

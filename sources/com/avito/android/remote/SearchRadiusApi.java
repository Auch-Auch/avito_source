package com.avito.android.remote;

import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.location_picker.AdvertsCountResult;
import com.avito.android.remote.model.location_picker.RadiusListResult;
import io.reactivex.rxjava3.core.Observable;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J/\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0002H'¢\u0006\u0004\b\b\u0010\tJ1\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00060\u00052\u0014\b\u0001\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\nH'¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/remote/SearchRadiusApi;", "", "", "radiusId", "categoryId", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/model/location_picker/RadiusListResult$Ok;", "getSearchRadiusList", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "", "searchParams", "Lcom/avito/android/remote/model/location_picker/AdvertsCountResult$Ok;", "getAdvertsCount", "(Ljava/util/Map;)Lio/reactivex/rxjava3/core/Observable;", "location_release"}, k = 1, mv = {1, 4, 2})
public interface SearchRadiusApi {
    @GET("10/items?countOnly=1")
    @NotNull
    Observable<TypedResult<AdvertsCountResult.Ok>> getAdvertsCount(@QueryMap @NotNull Map<String, String> map);

    @GET("1/search/parameters/radius/values")
    @NotNull
    @NetworkRequestEventId(eventId = 3815)
    Observable<TypedResult<RadiusListResult.Ok>> getSearchRadiusList(@NotNull @Query("selectedValue") String str, @NotNull @Query("categoryId") String str2);
}

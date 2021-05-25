package com.avito.android.remote;

import com.avito.android.remote.model.Direction;
import com.avito.android.remote.model.District;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.LocationResponse;
import com.avito.android.remote.model.LocationsResponse;
import com.avito.android.remote.model.Metro;
import com.avito.android.remote.model.SuggestLocationsResponse;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.category_parameters.AddressParameter;
import com.avito.android.remote.model.location_picker.AddressByCoordinatesResult;
import com.avito.android.remote.model.location_picker.AddressCoordinatesByQueryResult;
import com.avito.android.remote.model.location_picker.AddressSuggestionResult;
import com.avito.android.remote.model.location_picker.AddressValidationResult;
import com.avito.android.remote.model.location_picker.CoordinatesVerificationResult;
import com.avito.android.remote.model.location_picker.CurrentCoordinates;
import com.avito.android.remote.model.metro_lines.MetroResponseBody;
import com.avito.android.util.preferences.GeoContract;
import io.reactivex.rxjava3.core.Observable;
import java.util.HashMap;
import java.util.List;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H'¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\n0\u0004H'¢\u0006\u0004\b\u000b\u0010\tJ\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00042\b\b\u0001\u0010\f\u001a\u00020\u0002H'¢\u0006\u0004\b\u000e\u0010\u0007J%\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\n0\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u000f\u0010\u0007J%\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u00042\b\b\u0001\u0010\f\u001a\u00020\u0002H'¢\u0006\u0004\b\u0012\u0010\u0007JU\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00100\u00042\b\b\u0001\u0010\f\u001a\u00020\u00022\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u00132\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u00132\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u0013H'¢\u0006\u0004\b\u0019\u0010\u001aJ\u001b\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u00100\u0004H'¢\u0006\u0004\b\u001c\u0010\tJ/\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u00100\u00042\b\b\u0001\u0010\u001d\u001a\u00020\u00132\b\b\u0001\u0010\u001e\u001a\u00020\u0013H'¢\u0006\u0004\b \u0010!J;\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u00100\u00042\b\b\u0001\u0010\u001d\u001a\u00020\u00132\b\b\u0001\u0010\u001e\u001a\u00020\u00132\n\b\u0001\u0010\"\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b$\u0010%J)\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u00042\b\b\u0001\u0010\u001d\u001a\u00020\u00022\b\b\u0001\u0010\u001e\u001a\u00020\u0002H'¢\u0006\u0004\b'\u0010(J%\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0\n0\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b*\u0010\u0007J\u001f\u0010,\u001a\b\u0012\u0004\u0012\u00020+0\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b,\u0010\u0007J%\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0\n0\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b.\u0010\u0007J%\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0\n0\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b0\u0010\u0007J1\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002010\u00100\u00042\b\b\u0001\u0010\f\u001a\u00020\u00022\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b2\u0010(JC\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002070\u00100\u00042\b\b\u0001\u00103\u001a\u00020\u00022\b\b\u0001\u00104\u001a\u00020\u00132\b\b\u0001\u00105\u001a\u00020\u00132\b\b\u0001\u00106\u001a\u00020\u0002H'¢\u0006\u0004\b8\u00109JK\u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020>0\u00100\u00042\b\b\u0001\u0010:\u001a\u00020\u00022$\b\u0001\u0010=\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020;j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`<H'¢\u0006\u0004\b?\u0010@¨\u0006A"}, d2 = {"Lcom/avito/android/remote/LocationApi;", "", "", "locationId", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/Location;", "getLocation", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "getTopLocation", "()Lio/reactivex/rxjava3/core/Observable;", "", "getTopLocations", "query", "Lcom/avito/android/remote/model/LocationsResponse;", "getSearchLocations", "getChildrenLocations", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/model/location_picker/AddressCoordinatesByQueryResult;", "getCoordsByAddress", "", "bottomLeftLng", "bottomLeftLat", "upperRightLng", "upperRightLat", "Lcom/avito/android/remote/model/location_picker/AddressSuggestionResult$Ok;", "getAddressSuggestions", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/location_picker/CurrentCoordinates;", "getCurrentCoordinates", GeoContract.LATITUDE, GeoContract.LONGITUDE, "Lcom/avito/android/remote/model/location_picker/AddressByCoordinatesResult;", "getAddressByCoordinates", "(DD)Lio/reactivex/rxjava3/core/Observable;", "itemId", "Lcom/avito/android/remote/model/location_picker/CoordinatesVerificationResult;", "verifyCoordinates", "(DDLjava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/LocationResponse;", "getNearestLocation", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/Metro;", "getMetro", "Lcom/avito/android/remote/model/metro_lines/MetroResponseBody;", "getMetroWithLines", "Lcom/avito/android/remote/model/District;", "getDistricts", "Lcom/avito/android/remote/model/Direction;", "getDirections", "Lcom/avito/android/remote/model/SuggestLocationsResponse$Ok;", "getLocationSuggestions", "channelId", "lat", "lng", "text", "", "sendLocation", "(Ljava/lang/String;DDLjava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", AddressParameter.Value.JSON_WEB_TOKEN, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "validationRules", "Lcom/avito/android/remote/model/location_picker/AddressValidationResult$Ok;", "validateAddress", "(Ljava/lang/String;Ljava/util/HashMap;)Lio/reactivex/rxjava3/core/Observable;", "location_release"}, k = 1, mv = {1, 4, 2})
public interface LocationApi {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Observable getAddressSuggestions$default(LocationApi locationApi, String str, Double d, Double d2, Double d3, Double d4, int i, Object obj) {
            if (obj == null) {
                return locationApi.getAddressSuggestions(str, (i & 2) != 0 ? null : d, (i & 4) != 0 ? null : d2, (i & 8) != 0 ? null : d3, (i & 16) != 0 ? null : d4);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAddressSuggestions");
        }
    }

    @GET("1/location/suggest/by_coordinates")
    @NotNull
    @NetworkRequestEventId(eventId = 3683)
    Observable<TypedResult<AddressByCoordinatesResult>> getAddressByCoordinates(@Query("lat") double d, @Query("lng") double d2);

    @GET("1/location/suggest/by_query")
    @NotNull
    @NetworkRequestEventId(eventId = 3684)
    Observable<TypedResult<AddressSuggestionResult.Ok>> getAddressSuggestions(@NotNull @Query("query") String str, @Nullable @Query("bottomLeftLng") Double d, @Nullable @Query("bottomLeftLat") Double d2, @Nullable @Query("upperRightLng") Double d3, @Nullable @Query("upperRightLat") Double d4);

    @GET("2/locations/{locationId}/children")
    @NotNull
    Observable<List<Location>> getChildrenLocations(@Path("locationId") @NotNull String str);

    @GET("1/location/coords/by_address")
    @NotNull
    @NetworkRequestEventId(eventId = 3680)
    Observable<TypedResult<AddressCoordinatesByQueryResult>> getCoordsByAddress(@NotNull @Query("address") String str);

    @GET("1/location/coords/current")
    @NotNull
    @NetworkRequestEventId(eventId = 3681)
    Observable<TypedResult<CurrentCoordinates>> getCurrentCoordinates();

    @GET("2/locations/{locationId}/directions")
    @NotNull
    @NetworkRequestEventId(eventId = 3690)
    Observable<List<Direction>> getDirections(@Path("locationId") @NotNull String str);

    @GET("2/locations/{locationId}/districts")
    @NotNull
    @NetworkRequestEventId(eventId = 3691)
    Observable<List<District>> getDistricts(@Path("locationId") @NotNull String str);

    @GET("2/locations/{locationId}")
    @NotNull
    @NetworkRequestEventId(eventId = 3689)
    Observable<Location> getLocation(@Path("locationId") @NotNull String str);

    @GET("1/slocations?limit=10")
    @NotNull
    @NetworkRequestEventId(eventId = 3824)
    Observable<TypedResult<SuggestLocationsResponse.Ok>> getLocationSuggestions(@NotNull @Query("query") String str, @Nullable @Query("locationId") String str2);

    @GET("2/locations/{locationId}/metro")
    @NotNull
    @NetworkRequestEventId(eventId = 3692)
    Observable<List<Metro>> getMetro(@Path("locationId") @NotNull String str);

    @GET("3/locations/{locationId}/metro")
    @NotNull
    @NetworkRequestEventId(eventId = 3692)
    Observable<MetroResponseBody> getMetroWithLines(@Path("locationId") @NotNull String str);

    @GET("2/locations/nearest?includeRefs=1")
    @Named("nearest")
    @NotNull
    @NetworkRequestEventId(eventId = 3686)
    Observable<LocationResponse> getNearestLocation(@NotNull @Query("lat") String str, @NotNull @Query("lng") String str2);

    @GET("2/locations/search")
    @NotNull
    @NetworkRequestEventId(eventId = 3687)
    Observable<LocationsResponse> getSearchLocations(@NotNull @Query("query") String str);

    @GET("2/locations/top")
    @NotNull
    Observable<Location> getTopLocation();

    @GET("2/locations/top/children")
    @NotNull
    Observable<List<Location>> getTopLocations();

    @NotNull
    @FormUrlEncoded
    @POST("1/job/assistant/location")
    Observable<TypedResult<Unit>> sendLocation(@Field("channelId") @NotNull String str, @Field("geo[lat]") double d, @Field("geo[lng]") double d2, @Field("geo[text]") @NotNull String str2);

    @NotNull
    @FormUrlEncoded
    @POST("2/address/validate")
    Observable<TypedResult<AddressValidationResult.Ok>> validateAddress(@Field("jwt") @NotNull String str, @FieldMap @NotNull HashMap<String, String> hashMap);

    @NotNull
    @NetworkRequestEventId(eventId = 3685)
    @FormUrlEncoded
    @POST("2/location/verify")
    Observable<TypedResult<CoordinatesVerificationResult>> verifyCoordinates(@Field("lat") double d, @Field("lng") double d2, @Field("itemId") @Nullable String str);
}

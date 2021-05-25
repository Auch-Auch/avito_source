package com.avito.android.remote;

import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.model.DeepLinkResponse;
import com.avito.android.remote.model.HomeElementResult;
import com.avito.android.remote.model.MainSearchResult;
import com.avito.android.remote.model.SearchParameters;
import com.avito.android.remote.model.SerpElementResult;
import com.avito.android.remote.model.Shortcuts;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.counter.ChangingParametersForButton;
import com.avito.android.remote.model.search.InlineFilters;
import com.avito.android.remote.model.search.auto_suggest.AutoSuggestResponse;
import com.avito.android.remote.model.search.map.MarkersResponse;
import com.avito.android.remote.model.search.map.PinAdvertsResult;
import com.avito.android.remote.model.search.suggest.SuggestResponse;
import com.avito.android.remote.model.serp.BannerRotationResponse;
import com.avito.android.remote.model.vertical_main.SearchFormResult;
import com.avito.android.remote.parse.NonStreamParsing;
import com.avito.android.remote.parse.adapter.stream_gson.StreamParsing;
import com.avito.android.util.UrlParams;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0001\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f2\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0014\b\u0001\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\f2\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\tH'¢\u0006\u0004\b\u0012\u0010\u0013J\u0001\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f2\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0014\b\u0001\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\f2\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\tH'¢\u0006\u0004\b\u0014\u0010\u0013J!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u000f2\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u0006H'¢\u0006\u0004\b\u0017\u0010\u0018JI\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00100\u000f2\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\t2\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u00062\u0014\b\u0001\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\fH'¢\u0006\u0004\b\u001b\u0010\u001cJ1\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u00100\u000f2\u0014\b\u0001\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\fH'¢\u0006\u0004\b\u001e\u0010\u001fJ1\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u00100\u000f2\u0014\b\u0001\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\fH'¢\u0006\u0004\b\"\u0010\u001fJE\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u00100\u000f2\u0014\b\u0001\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\f2\b\b\u0001\u0010#\u001a\u00020\u00022\b\b\u0001\u0010$\u001a\u00020\u0002H'¢\u0006\u0004\b&\u0010'JE\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0\u00100\u000f2\b\b\u0001\u0010(\u001a\u00020\u00062\b\b\u0001\u0010)\u001a\u00020\u00022\b\b\u0001\u0010*\u001a\u00020\u00062\n\b\u0001\u0010+\u001a\u0004\u0018\u00010\tH'¢\u0006\u0004\b-\u0010.J3\u00103\u001a\b\u0012\u0004\u0012\u0002020\u000f2\b\b\u0001\u0010/\u001a\u00020\u00062\b\b\u0001\u00100\u001a\u00020\u00022\b\b\u0001\u00101\u001a\u00020\u0006H'¢\u0006\u0004\b3\u00104J7\u00107\u001a\b\u0012\u0004\u0012\u0002060\u000f2\b\b\u0001\u0010/\u001a\u00020\u00062\u0016\b\u0001\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fH'¢\u0006\u0004\b7\u00108J1\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002090\u00100\u000f2\u0014\b\u0001\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\fH'¢\u0006\u0004\b:\u0010\u001fJ+\u0010<\u001a\b\u0012\u0004\u0012\u00020;0\u000f2\u0014\b\u0001\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\fH'¢\u0006\u0004\b<\u0010\u001fJA\u0010@\u001a\b\u0012\u0004\u0012\u00020?0\u000f2\u0014\b\u0001\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\f2\u0014\b\u0001\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\fH'¢\u0006\u0004\b@\u0010AJA\u0010B\u001a\b\u0012\u0004\u0012\u00020?0\u000f2\u0014\b\u0001\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\f2\u0014\b\u0001\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\fH'¢\u0006\u0004\bB\u0010AJQ\u0010H\u001a\b\u0012\u0004\u0012\u00020G0\u000f2\n\b\u0001\u0010C\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010D\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010E\u001a\u0004\u0018\u00010\t2\n\b\u0001\u0010F\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\bH\u0010IJ-\u0010J\u001a\b\u0012\u0004\u0012\u00020;0\u000f2\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010E\u001a\u0004\u0018\u00010\tH'¢\u0006\u0004\bJ\u0010KJG\u0010N\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002090\u00100\u000f2\b\b\u0001\u0010(\u001a\u00020\u00062\b\b\u0001\u0010L\u001a\u00020\u00062\u0016\b\u0001\u0010M\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fH'¢\u0006\u0004\bN\u0010OJ[\u0010S\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002090\u00100\u000f2\b\b\u0001\u0010(\u001a\u00020\u00062\b\b\u0001\u0010P\u001a\u00020\u00062\n\b\u0001\u0010Q\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010R\u001a\u00020\u00022\b\b\u0001\u0010D\u001a\u00020\u0006H'¢\u0006\u0004\bS\u0010TJ\u0015\u0010V\u001a\b\u0012\u0004\u0012\u00020U0\u000fH'¢\u0006\u0004\bV\u0010WJ1\u0010Y\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020X0\u00100\u000f2\u0014\b\u0001\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\fH'¢\u0006\u0004\bY\u0010\u001f¨\u0006Z"}, d2 = {"Lcom/avito/android/remote/SearchApi;", "", "", "page", "", UrlParams.LAST_STAMP, "", "displayType", "context", "", "areNotificationsEnabled", "pageId", "", "searchParams", "forcedLocationForRecommendation", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/model/SerpElementResult;", "getSerpElementTypedResult", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Boolean;)Lio/reactivex/rxjava3/core/Observable;", "getSerpElementTypedResultV11", "locationId", "Lcom/avito/android/remote/model/MainSearchResult;", "getCategoriesSearch", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "clearGeoFilters", "Lcom/avito/android/remote/model/DeepLinkResponse;", "getSerpDeeplink", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/Map;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/counter/ChangingParametersForButton;", "getCounterButton", "(Ljava/util/Map;)Lio/reactivex/rxjava3/core/Observable;", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "Lcom/avito/android/remote/model/SearchParameters;", "getSearchParameters", "viewPortWidth", "viewPortHeight", "Lcom/avito/android/remote/model/search/map/MarkersResponse;", "getMapMarkers", "(Ljava/util/Map;II)Lio/reactivex/rxjava3/core/Observable;", "id", "limit", "searchHash", "isBegin", "Lcom/avito/android/remote/model/search/map/PinAdvertsResult;", "getPinAdverts", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Boolean;)Lio/reactivex/rxjava3/core/Observable;", "query", "attributeId", "sorting", "Lcom/avito/android/remote/model/search/auto_suggest/AutoSuggestResponse;", "getAutoSearchSuggest", "(Ljava/lang/String;ILjava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "params", "Lcom/avito/android/remote/model/search/suggest/SuggestResponse;", "getSearchSuggestV8", "(Ljava/lang/String;Ljava/util/Map;)Lio/reactivex/rxjava3/core/Observable;", "", "clearSearchHistory", "Lcom/avito/android/remote/model/Shortcuts;", "getSearchShortcuts", "extendedSearchParams", "changesParams", "Lcom/avito/android/remote/model/search/InlineFilters;", "getInlineFiltersV2", "(Ljava/util/Map;Ljava/util/Map;)Lio/reactivex/rxjava3/core/Observable;", "getInlineFilters", "offset", "feedId", "locationForcedByUser", "showedPageCount", "Lcom/avito/android/remote/model/HomeElementResult;", "getHomePageSerpElements", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;)Lio/reactivex/rxjava3/core/Observable;", "getHomeShortcuts", "(Ljava/lang/String;Ljava/lang/Boolean;)Lio/reactivex/rxjava3/core/Observable;", "action", "analytics", "sendSerpSnippetAction", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lio/reactivex/rxjava3/core/Observable;", "type", "categoryId", VKApiConst.POSITION, "hideRecommendation", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ILjava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/serp/BannerRotationResponse;", "getMainWarning", "()Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/vertical_main/SearchFormResult;", "getVerticalFormTypedResult", "search_release"}, k = 1, mv = {1, 4, 2})
public interface SearchApi {
    @NotNull
    @FormUrlEncoded
    @POST("1/suggest/clear-search-history")
    Observable<TypedResult<Unit>> clearSearchHistory(@FieldMap @NotNull Map<String, String> map);

    @StreamParsing
    @NotNull
    @FormUrlEncoded
    @POST("1/suggest/attributes")
    Observable<AutoSuggestResponse> getAutoSearchSuggest(@Field("query") @NotNull String str, @Field("attributeId") int i, @Field("sorting") @NotNull String str2);

    @GET("3/search/main")
    @NotNull
    @NetworkRequestEventId(eventId = 3811)
    Observable<MainSearchResult> getCategoriesSearch(@Nullable @Query("locationId") String str);

    @GET("10/items?countOnly=1")
    @NotNull
    Observable<TypedResult<ChangingParametersForButton>> getCounterButton(@QueryMap @NotNull Map<String, String> map);

    @StreamParsing
    @GET("3/main/items")
    @NotNull
    @NetworkRequestEventId(eventId = 3693)
    @Headers({ConstsKt.GEO})
    Observable<HomeElementResult> getHomePageSerpElements(@Nullable @Query("offset") Integer num, @Nullable @Query("locationId") String str, @Nullable @Query("feedId") String str2, @Nullable @Query("locationForcedByUser") Boolean bool, @Nullable @Query("showedPageCount") Integer num2);

    @GET("3/main/shortcuts")
    @NotNull
    @NetworkRequestEventId(eventId = 3694)
    @Headers({ConstsKt.GEO})
    Observable<Shortcuts> getHomeShortcuts(@Nullable @Query("locationId") String str, @Nullable @Query("locationForcedByUser") Boolean bool);

    @NonStreamParsing
    @GET("4/items/search/header")
    @NotNull
    @Headers({ConstsKt.GEO})
    Observable<InlineFilters> getInlineFilters(@QueryMap @NotNull Map<String, String> map, @QueryMap @NotNull Map<String, String> map2);

    @NonStreamParsing
    @GET("2/items/search/header")
    @NotNull
    @Headers({ConstsKt.GEO})
    Observable<InlineFilters> getInlineFiltersV2(@QueryMap @NotNull Map<String, String> map, @QueryMap @NotNull Map<String, String> map2);

    @GET("1/internalBannerRotation/banners?&platform=android&page=main")
    @NotNull
    Observable<BannerRotationResponse> getMainWarning();

    @NotNull
    @NetworkRequestEventId(eventId = 3813)
    @FormUrlEncoded
    @POST("1/map/markers")
    Observable<TypedResult<MarkersResponse>> getMapMarkers(@FieldMap @NotNull Map<String, String> map, @Field("viewPort[width]") int i, @Field("viewPort[height]") int i2);

    @GET("2/search/map/items")
    @NotNull
    @NetworkRequestEventId(eventId = 3812)
    Observable<TypedResult<PinAdvertsResult>> getPinAdverts(@NotNull @Query("id") String str, @Query("limit") int i, @NotNull @Query("searchHash") String str2, @Nullable @Query("isBegin") Boolean bool);

    @GET("5/search/parameters")
    @NotNull
    @NetworkRequestEventId(eventId = 3814)
    Observable<TypedResult<SearchParameters>> getSearchParameters(@QueryMap @NotNull Map<String, String> map);

    @NotNull
    @NetworkRequestEventId(eventId = 3662)
    @Headers({ConstsKt.GEO})
    @POST("3/items/search/shortcuts")
    Observable<Shortcuts> getSearchShortcuts(@QueryMap @NotNull Map<String, String> map);

    @StreamParsing
    @NotNull
    @NetworkRequestEventId(eventId = 3841)
    @FormUrlEncoded
    @POST("8/suggest")
    Observable<SuggestResponse> getSearchSuggestV8(@Field("query") @NotNull String str, @FieldMap @Nullable Map<String, String> map);

    @GET("10/items/search/deeplink")
    @NotNull
    @NetworkRequestEventId(eventId = 3661)
    @Headers({ConstsKt.GEO})
    Observable<TypedResult<DeepLinkResponse>> getSerpDeeplink(@Nullable @Query("clearGeoFilters") Boolean bool, @Nullable @Query("context") String str, @QueryMap @NotNull Map<String, String> map);

    @GET("10/items")
    @NotNull
    @NetworkRequestEventId(eventId = 3375)
    @Headers({ConstsKt.GEO})
    Observable<TypedResult<SerpElementResult>> getSerpElementTypedResult(@Nullable @Query("page") Integer num, @Nullable @Query("lastStamp") Long l, @Nullable @Query("display") String str, @Nullable @Query("context") String str2, @Nullable @Query("areNotificationsEnabled") Boolean bool, @Nullable @Query("pageId") String str3, @QueryMap @NotNull Map<String, String> map, @Nullable @Query("forceLocation") Boolean bool2);

    @GET("11/items")
    @NotNull
    @NetworkRequestEventId(eventId = 3375)
    @Headers({ConstsKt.GEO})
    Observable<TypedResult<SerpElementResult>> getSerpElementTypedResultV11(@Nullable @Query("page") Integer num, @Nullable @Query("lastStamp") Long l, @Nullable @Query("display") String str, @Nullable @Query("context") String str2, @Nullable @Query("areNotificationsEnabled") Boolean bool, @Nullable @Query("pageId") String str3, @QueryMap @NotNull Map<String, String> map, @Nullable @Query("forceLocation") Boolean bool2);

    @GET("1/vertical/form")
    @NotNull
    @Headers({ConstsKt.GEO})
    Observable<TypedResult<SearchFormResult>> getVerticalFormTypedResult(@QueryMap @NotNull Map<String, String> map);

    @GET("1/main/hide")
    @NotNull
    Observable<TypedResult<Unit>> hideRecommendation(@NotNull @Query("id") String str, @NotNull @Query("type") String str2, @Nullable @Query("categoryId") String str3, @Nullable @Query("locationId") Integer num, @Query("position") int i, @NotNull @Query("feedId") String str4);

    @NotNull
    @NetworkRequestEventId(eventId = 3663)
    @FormUrlEncoded
    @POST("1/items/snippet/action")
    Observable<TypedResult<Unit>> sendSerpSnippetAction(@Field("id") @NotNull String str, @Field("action") @NotNull String str2, @FieldMap @Nullable Map<String, String> map);
}

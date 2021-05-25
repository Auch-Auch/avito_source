package com.avito.android.brandspace.remote;

import com.avito.android.brandspace.remote.model.Brandspace;
import com.avito.android.brandspace.remote.model.MarketplaceSnippetsResult;
import com.avito.android.brandspace.remote.model.MarketplaceTabsContentModule;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.parse.adapter.stream_gson.StreamParsing;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J%\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0001\u0010\t\u001a\u00020\u00022\b\b\u0001\u0010\n\u001a\u00020\u0002H'¢\u0006\u0004\b\r\u0010\u000eJ?\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b2\b\b\u0001\u0010\n\u001a\u00020\u00022\b\b\u0001\u0010\u0010\u001a\u00020\u000f2\u0014\b\u0001\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0011H'¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/avito/android/brandspace/remote/BrandspaceApi;", "", "", "itemId", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/brandspace/remote/model/Brandspace;", "getBrandspace", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "url", "apiKey", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/brandspace/remote/model/MarketplaceSnippetsResult;", "getMarketplaceItemModule", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "", "limit", "", "tabs", "Lcom/avito/android/brandspace/remote/model/MarketplaceTabsContentModule;", "getMarketplaceTabsModule", "(Ljava/lang/String;ILjava/util/Map;)Lio/reactivex/rxjava3/core/Single;", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public interface BrandspaceApi {
    @StreamParsing
    @GET("1/brandspace")
    @NotNull
    Observable<TypedResult<Brandspace>> getBrandspace(@NotNull @Query("id") String str);

    @StreamParsing
    @GET
    @NotNull
    Single<MarketplaceSnippetsResult> getMarketplaceItemModule(@Url @NotNull String str, @NotNull @Query("key") String str2);

    @StreamParsing
    @NotNull
    @FormUrlEncoded
    @POST("1/b2b/components/tabs")
    Single<MarketplaceTabsContentModule> getMarketplaceTabsModule(@NotNull @Query("key") String str, @Field("limit") int i, @QueryMap @NotNull Map<String, String> map);
}

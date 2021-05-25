package com.avito.android.analytics.provider.pixel;

import io.reactivex.Observable;
import java.util.Map;
import kotlin.Metadata;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J1\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H'¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/analytics/provider/pixel/PixelApi;", "", "", "", "map", "Lio/reactivex/Observable;", "Lretrofit2/Response;", "Lokhttp3/ResponseBody;", "sendAd", "(Ljava/util/Map;)Lio/reactivex/Observable;", "analytics_release"}, k = 1, mv = {1, 4, 2})
public interface PixelApi {
    @GET("ad")
    @NotNull
    Observable<Response<ResponseBody>> sendAd(@QueryMap(encoded = true) @NotNull Map<String, String> map);
}

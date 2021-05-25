package com.avito.android.analytics.statsd;

import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.Body;
import retrofit2.http.POST;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J%\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0001\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H'¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/analytics/statsd/StatsdApi;", "", "", "Lcom/avito/android/analytics/statsd/StatsdRecord;", "events", "Lio/reactivex/Single;", "Lokhttp3/ResponseBody;", "sendEvents", "(Ljava/util/List;)Lio/reactivex/Single;", "analytics-statsd_release"}, k = 1, mv = {1, 4, 2})
public interface StatsdApi {
    @POST("1/stats/realtime")
    @NotNull
    Single<ResponseBody> sendEvents(@Body @NotNull List<StatsdRecord> list);
}

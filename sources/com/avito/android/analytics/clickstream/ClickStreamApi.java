package com.avito.android.analytics.clickstream;

import io.reactivex.Single;
import kotlin.Metadata;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import proto.events.apps.BatchOuterClass;
import retrofit2.http.Body;
import retrofit2.http.POST;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/analytics/clickstream/ClickStreamApi;", "", "Lproto/events/apps/BatchOuterClass$Envelope;", "batch", "Lio/reactivex/Single;", "Lokhttp3/ResponseBody;", "sendEvents", "(Lproto/events/apps/BatchOuterClass$Envelope;)Lio/reactivex/Single;", "analytics-clickstream_release"}, k = 1, mv = {1, 4, 2})
public interface ClickStreamApi {
    @POST("0/proto")
    @NotNull
    Single<ResponseBody> sendEvents(@Body @NotNull BatchOuterClass.Envelope envelope);
}

package com.avito.android.service.short_task;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TimeResponse;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.Logs;
import com.google.gson.Gson;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/service/short_task/TimeDiffAnalyticsInterceptor;", "Lokhttp3/Interceptor;", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "Lcom/google/gson/Gson;", AuthSource.BOOKING_ORDER, "Lcom/google/gson/Gson;", "gson", "Lcom/avito/android/server_time/TimeSource;", AuthSource.SEND_ABUSE, "Lcom/avito/android/server_time/TimeSource;", "localTimeSource", "<init>", "(Lcom/avito/android/server_time/TimeSource;Lcom/google/gson/Gson;)V", "application_release"}, k = 1, mv = {1, 4, 2})
public final class TimeDiffAnalyticsInterceptor implements Interceptor {
    public final TimeSource a;
    public final Gson b;

    public TimeDiffAnalyticsInterceptor(@NotNull TimeSource timeSource, @NotNull Gson gson) {
        Intrinsics.checkNotNullParameter(timeSource, "localTimeSource");
        Intrinsics.checkNotNullParameter(gson, "gson");
        this.a = timeSource;
        this.b = gson;
    }

    @Override // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) throws IOException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Response proceed = chain.proceed(chain.request());
        ResponseBody body = proceed.body();
        if (body != null) {
            Logs.debug$default("TimeDiffAnalyticsInterceptor", a.V2("Local and server time diff is ", Math.abs(this.a.now() - ((TimeResponse) this.b.fromJson(body.charStream(), (Class<Object>) TimeResponse.class)).getTimestamp()), " ms"), null, 4, null);
        }
        return proceed;
    }
}

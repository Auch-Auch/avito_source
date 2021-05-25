package com.avito.android.remote.interceptor;

import a2.b.a.a.a;
import com.avito.android.remote.HttpDateKt;
import com.avito.android.remote.MissingResponseHeaderException;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.Logs;
import com.facebook.internal.ServerProtocol;
import com.google.common.net.HttpHeaders;
import io.reactivex.functions.Consumer;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B'\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/remote/interceptor/ServerTimeInterceptor;", "Lokhttp3/Interceptor;", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "Lio/reactivex/functions/Consumer;", "", AuthSource.SEND_ABUSE, "Lio/reactivex/functions/Consumer;", "timeDiffObserver", "Lcom/avito/android/server_time/TimeSource;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/server_time/TimeSource;", "timeSource", "", "c", "Z", "isDateMandatory", "<init>", "(Lio/reactivex/functions/Consumer;Lcom/avito/android/server_time/TimeSource;Z)V", "api_release"}, k = 1, mv = {1, 4, 2})
public class ServerTimeInterceptor implements Interceptor {
    public final Consumer<Long> a;
    public final TimeSource b;
    public final boolean c;

    public ServerTimeInterceptor(@NotNull Consumer<Long> consumer, @NotNull TimeSource timeSource, boolean z) {
        Intrinsics.checkNotNullParameter(consumer, "timeDiffObserver");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        this.a = consumer;
        this.b = timeSource;
        this.c = z;
    }

    @Override // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        boolean equals = m.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE, request.header("X-Date-required"), true);
        if (request.header("X-Date-required") != null) {
            request = request.newBuilder().headers(request.headers().newBuilder().removeAll("X-Date-required").build()).build();
        }
        Response proceed = chain.proceed(request);
        if (equals) {
            StringBuilder L = a.L("Response date: ");
            L.append(Response.header$default(proceed, HttpHeaders.DATE, null, 2, null));
            Logs.debug$default("ServerTimeInterceptor", L.toString(), null, 4, null);
            Response networkResponse = proceed.networkResponse();
            if (networkResponse != null) {
                String header$default = Response.header$default(networkResponse, HttpHeaders.DATE, null, 2, null);
                if (header$default == null) {
                    header$default = "";
                }
                Date httpDateOrNull = HttpDateKt.toHttpDateOrNull(header$default);
                if (this.c && httpDateOrNull == null) {
                    throw new MissingResponseHeaderException(HttpHeaders.DATE, networkResponse.request().method(), networkResponse.request().url().toString());
                } else if (httpDateOrNull != null) {
                    this.a.accept(Long.valueOf(this.b.now() - httpDateOrNull.getTime()));
                }
            }
        }
        return proceed;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ServerTimeInterceptor(Consumer consumer, TimeSource timeSource, boolean z, int i, j jVar) {
        this(consumer, timeSource, (i & 4) != 0 ? false : z);
    }
}

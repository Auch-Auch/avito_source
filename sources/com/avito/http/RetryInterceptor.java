package com.avito.http;

import a2.g.r.g;
import androidx.browser.trusted.sharing.ShareTarget;
import com.avito.android.remote.auth.AuthSource;
import com.avito.logger.Logger;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import t6.n.d;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001Bc\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0017\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u0012\u0012\b\b\u0002\u0010#\u001a\u00020 \u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b$\u0010%J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\u00020\u0007*\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\"\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0015R\u0016\u0010\u001b\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lcom/avito/http/RetryInterceptor;", "Lokhttp3/Interceptor;", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "", AuthSource.SEND_ABUSE, "(Lokhttp3/Response;)Z", "e", "Z", "useIncreasingDelay", "Lkotlin/Function1;", "Lokhttp3/Request;", g.a, "Lkotlin/jvm/functions/Function1;", "modifyRetryRequest", "", "", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "allowedMethods", "", "c", "allowedCodes", "I", "retries", "Lcom/avito/logger/Logger;", "f", "Lcom/avito/logger/Logger;", "logger", "", "d", "J", "delayMs", "<init>", "(ILjava/util/List;Ljava/util/List;JZLcom/avito/logger/Logger;Lkotlin/jvm/functions/Function1;)V", "okhttp"}, k = 1, mv = {1, 4, 2})
public final class RetryInterceptor implements Interceptor {
    public final int a;
    public final List<String> b;
    public final List<Integer> c;
    public final long d;
    public final boolean e;
    public final Logger f;
    public final Function1<Request, Request> g;

    public static final class a extends Lambda implements Function1<Request, Request> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Request invoke(Request request) {
            Request request2 = request;
            Intrinsics.checkNotNullParameter(request2, "it");
            return request2;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: kotlin.jvm.functions.Function1<? super okhttp3.Request, okhttp3.Request> */
    /* JADX WARN: Multi-variable type inference failed */
    public RetryInterceptor(int i, @NotNull List<String> list, @NotNull List<Integer> list2, long j, boolean z, @NotNull Logger logger, @NotNull Function1<? super Request, Request> function1) {
        Intrinsics.checkNotNullParameter(list, "allowedMethods");
        Intrinsics.checkNotNullParameter(list2, "allowedCodes");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(function1, "modifyRetryRequest");
        this.a = i;
        this.b = list;
        this.c = list2;
        this.d = j;
        this.e = z;
        this.f = logger;
        this.g = function1;
        if (!(i < 1 ? false : true)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public final boolean a(Response response) {
        if (response == null) {
            return true;
        }
        return this.b.contains(response.request().method()) && this.c.contains(Integer.valueOf(response.code()));
    }

    @Override // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        int i = 0;
        Response response = null;
        IOException e2 = null;
        while (a(response) && i < this.a) {
            i++;
            if (response != null && a(response)) {
                response.close();
            }
            try {
                response = chain.proceed(i > 1 ? this.g.invoke(request) : request);
            } catch (IOException e3) {
                e2 = e3;
                response = null;
            }
            TimeUnit.MILLISECONDS.sleep(this.e ? ((long) i) * this.d : this.d);
        }
        if (response != null) {
            return response;
        }
        if (e2 != null) {
            throw e2;
        }
        throw new IllegalStateException("Failed to execute request for unknown reason");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RetryInterceptor(int i, List list, List list2, long j, boolean z, Logger logger, Function1 function1, int i2, j jVar) {
        this((i2 & 1) != 0 ? 5 : i, (i2 & 2) != 0 ? d.listOf(ShareTarget.METHOD_GET) : list, (i2 & 4) != 0 ? CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{408, 500, 502, 503, 504}) : list2, (i2 & 8) != 0 ? TimeUnit.SECONDS.toMillis(1) : j, (i2 & 16) != 0 ? true : z, logger, (i2 & 64) != 0 ? a.a : function1);
    }
}

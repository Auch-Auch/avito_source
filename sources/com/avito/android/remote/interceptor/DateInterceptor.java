package com.avito.android.remote.interceptor;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.GeoContract;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/interceptor/DateInterceptor;", "Lokhttp3/Interceptor;", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "Lcom/avito/android/remote/interceptor/DateHeaderProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/interceptor/DateHeaderProvider;", GeoContract.PROVIDER, "<init>", "(Lcom/avito/android/remote/interceptor/DateHeaderProvider;)V", "api_release"}, k = 1, mv = {1, 4, 2})
public class DateInterceptor implements Interceptor {
    public final DateHeaderProvider a;

    public DateInterceptor(@NotNull DateHeaderProvider dateHeaderProvider) {
        Intrinsics.checkNotNullParameter(dateHeaderProvider, GeoContract.PROVIDER);
        this.a = dateHeaderProvider;
    }

    @Override // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) throws IOException {
        Request request;
        Intrinsics.checkNotNullParameter(chain, "chain");
        String value = this.a.getValue();
        if (!(value == null || m.isBlank(value))) {
            request = chain.request().newBuilder().header(this.a.getKey(), value).build();
        } else {
            request = chain.request();
        }
        return chain.proceed(request);
    }
}

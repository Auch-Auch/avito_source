package net.gotev.uploadservice.okhttp;

import com.avito.android.remote.auth.AuthSource;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.gotev.uploadservice.network.HttpRequest;
import net.gotev.uploadservice.network.HttpStack;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lnet/gotev/uploadservice/okhttp/OkHttpStack;", "Lnet/gotev/uploadservice/network/HttpStack;", "", "uploadId", "method", "url", "Lnet/gotev/uploadservice/network/HttpRequest;", "newRequest", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lnet/gotev/uploadservice/network/HttpRequest;", "Lokhttp3/OkHttpClient;", AuthSource.SEND_ABUSE, "Lokhttp3/OkHttpClient;", "client", "<init>", "(Lokhttp3/OkHttpClient;)V", "uploadservice-okhttp_release"}, k = 1, mv = {1, 4, 0})
public final class OkHttpStack implements HttpStack {
    public final OkHttpClient a;

    public OkHttpStack() {
        this(null, 1, null);
    }

    public OkHttpStack(@NotNull OkHttpClient okHttpClient) {
        Intrinsics.checkNotNullParameter(okHttpClient, "client");
        this.a = okHttpClient;
    }

    @Override // net.gotev.uploadservice.network.HttpStack
    @NotNull
    public HttpRequest newRequest(@NotNull String str, @NotNull String str2, @NotNull String str3) throws IOException {
        Intrinsics.checkNotNullParameter(str, "uploadId");
        Intrinsics.checkNotNullParameter(str2, "method");
        Intrinsics.checkNotNullParameter(str3, "url");
        return new OkHttpStackRequest(str, this.a, str2, str3);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ OkHttpStack(okhttp3.OkHttpClient r2, int r3, t6.r.a.j r4) {
        /*
            r1 = this;
            r4 = 1
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0039
            okhttp3.OkHttpClient$Builder r2 = new okhttp3.OkHttpClient$Builder
            r2.<init>()
            okhttp3.OkHttpClient$Builder r2 = r2.followRedirects(r4)
            okhttp3.OkHttpClient$Builder r2 = r2.followSslRedirects(r4)
            okhttp3.OkHttpClient$Builder r2 = r2.retryOnConnectionFailure(r4)
            r3 = 15
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS
            okhttp3.OkHttpClient$Builder r2 = r2.connectTimeout(r3, r0)
            r3 = 30
            okhttp3.OkHttpClient$Builder r2 = r2.writeTimeout(r3, r0)
            okhttp3.OkHttpClient$Builder r2 = r2.readTimeout(r3, r0)
            r3 = 0
            okhttp3.OkHttpClient$Builder r2 = r2.cache(r3)
            net.gotev.uploadservice.okhttp.OkHttpStack$1 r3 = new net.gotev.uploadservice.okhttp.OkHttpStack$1
            r3.<init>()
            okhttp3.OkHttpClient$Builder r2 = r2.addInterceptor(r3)
            okhttp3.OkHttpClient r2 = r2.build()
        L_0x0039:
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.gotev.uploadservice.okhttp.OkHttpStack.<init>(okhttp3.OkHttpClient, int, t6.r.a.j):void");
    }
}

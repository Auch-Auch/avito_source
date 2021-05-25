package com.avito.android.service.short_task;

import com.avito.android.analytics.Analytics;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.CertificatePinner;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/service/short_task/CheckCertPinningInterceptor;", "Lokhttp3/Interceptor;", "Lcom/avito/android/service/short_task/OkHttpPreparer;", "Lokhttp3/OkHttpClient$Builder;", "builder", "", "prepare", "(Lokhttp3/OkHttpClient$Builder;)V", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "Lokhttp3/CertificatePinner;", AuthSource.BOOKING_ORDER, "Lokhttp3/CertificatePinner;", "pinner", "Lcom/avito/android/analytics/Analytics;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Lcom/avito/android/analytics/Analytics;Lokhttp3/CertificatePinner;)V", "application_release"}, k = 1, mv = {1, 4, 2})
public final class CheckCertPinningInterceptor implements Interceptor, OkHttpPreparer {
    public final Analytics a;
    public final CertificatePinner b;

    @Inject
    public CheckCertPinningInterceptor(@NotNull Analytics analytics, @NotNull CertificatePinner certificatePinner) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(certificatePinner, "pinner");
        this.a = analytics;
        this.b = certificatePinner;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0038 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0039  */
    @Override // okhttp3.Interceptor
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okhttp3.Response intercept(@org.jetbrains.annotations.NotNull okhttp3.Interceptor.Chain r12) throws java.io.IOException {
        /*
            r11 = this;
            java.lang.String r0 = "Certificate is bad"
            java.lang.String r1 = "CertPinningInterceptor"
            java.lang.String r2 = "chain"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r2)
            r2 = 4
            r3 = 0
            okhttp3.Request r4 = r12.request()     // Catch:{ SSLPeerUnverifiedException -> 0x0023, all -> 0x001f }
            okhttp3.Response r12 = r12.proceed(r4)     // Catch:{ SSLPeerUnverifiedException -> 0x0023, all -> 0x001f }
            if (r12 == 0) goto L_0x0018
            r12.close()
        L_0x0018:
            java.lang.String r0 = "Certificate is good"
            com.avito.android.util.Logs.debug$default(r1, r0, r3, r2, r3)
            r3 = r12
            goto L_0x0036
        L_0x001f:
            com.avito.android.util.Logs.debug$default(r1, r0, r3, r2, r3)
            goto L_0x0036
        L_0x0023:
            r12 = move-exception
            r6 = r12
            com.avito.android.analytics.Analytics r12 = r11.a     // Catch:{ all -> 0x003f }
            com.avito.android.analytics.event.NonFatalError r10 = new com.avito.android.analytics.event.NonFatalError     // Catch:{ all -> 0x003f }
            java.lang.String r5 = "certificate pinning failed"
            r7 = 0
            r8 = 4
            r9 = 0
            r4 = r10
            r4.<init>(r5, r6, r7, r8, r9)     // Catch:{ all -> 0x003f }
            r12.track(r10)     // Catch:{ all -> 0x003f }
            goto L_0x001f
        L_0x0036:
            if (r3 == 0) goto L_0x0039
            return r3
        L_0x0039:
            java.io.IOException r12 = new java.io.IOException
            r12.<init>()
            throw r12
        L_0x003f:
            r12 = move-exception
            com.avito.android.util.Logs.debug$default(r1, r0, r3, r2, r3)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.service.short_task.CheckCertPinningInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }

    @Override // com.avito.android.service.short_task.OkHttpPreparer
    public void prepare(@NotNull OkHttpClient.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        builder.certificatePinner(this.b);
    }
}

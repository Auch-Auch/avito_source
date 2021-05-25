package com.sumsub.sns.core.data.network.interceptor;

import com.avito.android.remote.auth.AuthSource;
import com.sumsub.sns.core.ValueProvider;
import com.sumsub.sns.core.common.SNSConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0015\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010\fR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/sumsub/sns/core/data/network/interceptor/TokenInterceptor;", "Lokhttp3/Interceptor;", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "Lokhttp3/Request;", "request", AuthSource.SEND_ABUSE, "(Lokhttp3/Request;)Lokhttp3/Request;", "", "I", "attempts", "Lcom/sumsub/sns/core/ValueProvider;", "", AuthSource.BOOKING_ORDER, "Lcom/sumsub/sns/core/ValueProvider;", "tokenProvider", "<init>", "(Lcom/sumsub/sns/core/ValueProvider;)V", "Companion", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class TokenInterceptor implements Interceptor {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public int a;
    public final ValueProvider<String> b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/sumsub/sns/core/data/network/interceptor/TokenInterceptor$Companion;", "", "", "MAX_ATTEMPTS", "I", "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public TokenInterceptor(@NotNull ValueProvider<String> valueProvider) {
        Intrinsics.checkNotNullParameter(valueProvider, "tokenProvider");
        this.b = valueProvider;
    }

    public final Request a(Request request) {
        Request build = request.newBuilder().removeHeader(SNSConstants.Header.ACCESS_TOKEN).addHeader(SNSConstants.Header.ACCESS_TOKEN, this.b.get()).build();
        Intrinsics.checkNotNullExpressionValue(build, "request.newBuilder()\n   …\n                .build()");
        return build;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00c3 A[EDGE_INSN: B:41:0x00c3->B:31:0x00c3 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b9 A[SYNTHETIC] */
    @Override // okhttp3.Interceptor
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized okhttp3.Response intercept(@org.jetbrains.annotations.NotNull okhttp3.Interceptor.Chain r11) {
        /*
            r10 = this;
            monitor-enter(r10)
            java.lang.String r0 = "chain"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)     // Catch:{ all -> 0x00d7 }
            okhttp3.Request r0 = r11.request()     // Catch:{ all -> 0x00d7 }
            com.sumsub.sns.core.ValueProvider<java.lang.String> r1 = r10.b     // Catch:{ all -> 0x00d7 }
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x00d7 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x00d7 }
            boolean r1 = com.sumsub.sns.core.common.ParamValidationKt.isValidToken(r1)     // Catch:{ all -> 0x00d7 }
            r2 = 401(0x191, float:5.62E-43)
            r3 = 0
            r4 = 0
            if (r1 == 0) goto L_0x0062
            java.lang.String r1 = "request"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch:{ all -> 0x00d7 }
            okhttp3.Request r0 = r10.a(r0)     // Catch:{ all -> 0x00d7 }
            okhttp3.Response r1 = r11.proceed(r0)     // Catch:{ all -> 0x00d7 }
            int r5 = r1.code()     // Catch:{ all -> 0x00d7 }
            if (r5 == r2) goto L_0x0038
            r10.a = r4     // Catch:{ all -> 0x00d7 }
            java.lang.String r11 = "response"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r11)     // Catch:{ all -> 0x00d7 }
            monitor-exit(r10)
            return r1
        L_0x0038:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Token is expired. Attempts("
            r5.append(r6)
            int r6 = r10.a
            r5.append(r6)
            java.lang.String r6 = "). Headers are "
            r5.append(r6)
            okhttp3.Headers r6 = r1.headers()
            r5.append(r6)
            java.lang.String r6 = ", try to refresh..."
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r6 = new java.lang.Object[r4]
            timber.log.Timber.d(r5, r6)
            goto L_0x006a
        L_0x0062:
            java.lang.String r1 = "Invalid token, try to refresh"
            java.lang.Object[] r5 = new java.lang.Object[r4]
            timber.log.Timber.d(r1, r5)
            r1 = r3
        L_0x006a:
            com.sumsub.sns.core.SNSMobileSDK r5 = com.sumsub.sns.core.SNSMobileSDK.INSTANCE     // Catch:{ Exception -> 0x0077 }
            com.sumsub.sns.core.data.listener.TokenExpirationHandler r5 = r5.getTokenExpirationHandler()     // Catch:{ Exception -> 0x0077 }
            if (r5 == 0) goto L_0x007b
            java.lang.String r5 = r5.onTokenExpired()     // Catch:{ Exception -> 0x0077 }
            goto L_0x007c
        L_0x0077:
            r5 = move-exception
            timber.log.Timber.e(r5)
        L_0x007b:
            r5 = r3
        L_0x007c:
            r6 = 3
            r7 = 1
            if (r5 == 0) goto L_0x00bc
            boolean r8 = com.sumsub.sns.core.common.ParamValidationKt.isValidToken(r5)
            if (r8 != r7) goto L_0x00bc
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "New token is available. Token is "
            r8.append(r9)
            r8.append(r5)
            java.lang.String r8 = r8.toString()
            java.lang.Object[] r9 = new java.lang.Object[r4]
            timber.log.Timber.d(r8, r9)
            com.sumsub.sns.core.ValueProvider<java.lang.String> r8 = r10.b
            r8.put(r5)
            java.lang.String r5 = "request"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)
            okhttp3.Request r0 = r10.a(r0)
            if (r1 == 0) goto L_0x00af
            r1.close()
        L_0x00af:
            okhttp3.Response r1 = r11.proceed(r0)
            int r5 = r1.code()
            if (r5 == r2) goto L_0x00bc
            r10.a = r4
            goto L_0x00c3
        L_0x00bc:
            int r5 = r10.a
            int r5 = r5 + r7
            r10.a = r5
            if (r5 < r6) goto L_0x006a
        L_0x00c3:
            int r2 = r10.a
            if (r2 < r6) goto L_0x00c9
            r10.a = r4
        L_0x00c9:
            if (r1 == 0) goto L_0x00cc
            goto L_0x00d5
        L_0x00cc:
            okhttp3.Response r1 = r11.proceed(r0)
            java.lang.String r11 = "chain.proceed(request)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r11)
        L_0x00d5:
            monitor-exit(r10)
            return r1
        L_0x00d7:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.data.network.interceptor.TokenInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }
}

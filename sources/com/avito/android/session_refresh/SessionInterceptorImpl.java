package com.avito.android.session_refresh;

import a2.b.a.a.a;
import com.avito.android.Features;
import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.interceptor.SessionInterceptor;
import com.avito.android.util.Logs;
import com.avito.android.util.Strings;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.internal.OkHttpMessengerImageUploaderKt;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/session_refresh/SessionInterceptorImpl;", "Lcom/avito/android/remote/interceptor/SessionInterceptor;", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "Lcom/avito/android/Features;", "d", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/session_refresh/SessionRefresher;", "c", "Lcom/avito/android/session_refresh/SessionRefresher;", "sessionRefresher", "Lcom/avito/android/account/AccountStorageInteractor;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/account/AccountStorageInteractor;", "accountStorageInteractor", "Lokhttp3/HttpUrl;", AuthSource.SEND_ABUSE, "Lokhttp3/HttpUrl;", "baseUrl", "<init>", "(Lcom/avito/android/account/AccountStorageInteractor;Lcom/avito/android/session_refresh/SessionRefresher;Lcom/avito/android/Features;)V", "session-refresher_release"}, k = 1, mv = {1, 4, 2})
public final class SessionInterceptorImpl implements SessionInterceptor {
    public final HttpUrl a;
    public final AccountStorageInteractor b;
    public final SessionRefresher c;
    public final Features d;

    public SessionInterceptorImpl(@NotNull AccountStorageInteractor accountStorageInteractor, @NotNull SessionRefresher sessionRefresher, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(accountStorageInteractor, "accountStorageInteractor");
        Intrinsics.checkNotNullParameter(sessionRefresher, "sessionRefresher");
        Intrinsics.checkNotNullParameter(features, "features");
        this.b = accountStorageInteractor;
        this.c = sessionRefresher;
        this.d = features;
        HttpUrl parse = HttpUrl.Companion.parse(Strings.ensureEndsWith(features.getApiUrl().invoke(), "/"));
        if (parse != null) {
            this.a = parse;
            return;
        }
        StringBuilder L = a.L("Invalid api url: ");
        L.append(features.getApiUrl().invoke());
        throw new IllegalArgumentException(L.toString().toString());
    }

    @Override // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) throws IOException {
        String session;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        boolean z = false;
        if (Intrinsics.areEqual(request.url().host(), this.a.host()) && m.startsWith$default(request.url().encodedPath(), this.a.encodedPath(), false, 2, null)) {
            z = true;
        }
        if (!z) {
            StringBuilder L = a.L("Skipping request: ");
            L.append(request.url());
            Logs.verbose$default("SessionInterceptor", L.toString(), null, 4, null);
            return chain.proceed(request);
        }
        Request withSession = RequestsKt.withSession(request, this.b.toBlocking().getSession());
        Response proceed = chain.proceed(withSession);
        if (proceed.code() != 401 || RequestsKt.isRefreshRequest(withSession)) {
            return proceed;
        }
        Response build = proceed.newBuilder().body(proceed.peekBody(Long.MAX_VALUE)).build();
        proceed.close();
        return (!this.c.refreshSession(withSession.header(OkHttpMessengerImageUploaderKt.IMAGE_UPLOAD_SESSION_HEADER), withSession.url().encodedPath(), new Function1<Request, Response>(chain) { // from class: a2.a.a.q2.c
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Response invoke(Request request2) {
                Request request3 = request2;
                Intrinsics.checkNotNullParameter(request3, "p1");
                return ((Interceptor.Chain) this.receiver).proceed(request3);
            }
        }) || (session = this.b.toBlocking().getSession()) == null) ? build : chain.proceed(RequestsKt.withSession(withSession, session));
    }
}

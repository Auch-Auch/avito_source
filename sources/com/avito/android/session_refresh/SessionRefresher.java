package com.avito.android.session_refresh;

import a2.a.a.q2.b;
import a2.b.a.a.a;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.Features;
import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.account.AccountUpdateInteractor;
import com.avito.android.account.AccountUpdateInteractorKt;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.NonFatalError;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AuthResult;
import com.avito.android.session_refresh.event.SessionRefreshErrorEvent;
import com.avito.android.util.RequestUtils;
import com.avito.android.util.Strings;
import com.google.gson.Gson;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongycastle.i18n.ErrorBundle;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\fJ7\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/avito/android/session_refresh/SessionRefresher;", "", "", "sessionFromRequest", "source", "Lkotlin/Function1;", "Lokhttp3/Request;", "Lokhttp3/Response;", "perform", "", "refreshSession", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Z", "Impl", "session-refresher_release"}, k = 1, mv = {1, 4, 2})
public interface SessionRefresher {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010)\u001a\u00020'\u0012\u0006\u0010&\u001a\u00020$\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010#\u001a\u00020 ¢\u0006\u0004\b*\u0010+J7\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010%R\u0016\u0010)\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010(¨\u0006,"}, d2 = {"Lcom/avito/android/session_refresh/SessionRefresher$Impl;", "Lcom/avito/android/session_refresh/SessionRefresher;", "", "sessionFromRequest", "source", "Lkotlin/Function1;", "Lokhttp3/Request;", "Lokhttp3/Response;", "perform", "", "refreshSession", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Z", AuthSource.SEND_ABUSE, "()Lokhttp3/Request;", CommonKt.EXTRA_RESPONSE, AuthSource.BOOKING_ORDER, "(Lokhttp3/Response;Ljava/lang/String;)Z", ErrorBundle.DETAIL_ENTRY, "", "c", "(Ljava/lang/String;)V", "Lcom/avito/android/analytics/Analytics;", "e", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lokhttp3/HttpUrl;", "Lokhttp3/HttpUrl;", "baseUrl", "Lcom/google/gson/Gson;", "d", "Lcom/google/gson/Gson;", "gson", "Lcom/avito/android/Features;", "f", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/account/AccountUpdateInteractor;", "Lcom/avito/android/account/AccountUpdateInteractor;", "accountUpdateInteractor", "Lcom/avito/android/account/AccountStorageInteractor;", "Lcom/avito/android/account/AccountStorageInteractor;", "accountStorageInteractor", "<init>", "(Lcom/avito/android/account/AccountStorageInteractor;Lcom/avito/android/account/AccountUpdateInteractor;Lcom/google/gson/Gson;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/Features;)V", "session-refresher_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl implements SessionRefresher {
        public final HttpUrl a;
        public final AccountStorageInteractor b;
        public final AccountUpdateInteractor c;
        public final Gson d;
        public final Analytics e;
        public final Features f;

        public Impl(@NotNull AccountStorageInteractor accountStorageInteractor, @NotNull AccountUpdateInteractor accountUpdateInteractor, @NotNull Gson gson, @NotNull Analytics analytics, @NotNull Features features) {
            Intrinsics.checkNotNullParameter(accountStorageInteractor, "accountStorageInteractor");
            Intrinsics.checkNotNullParameter(accountUpdateInteractor, "accountUpdateInteractor");
            Intrinsics.checkNotNullParameter(gson, "gson");
            Intrinsics.checkNotNullParameter(analytics, "analytics");
            Intrinsics.checkNotNullParameter(features, "features");
            this.b = accountStorageInteractor;
            this.c = accountUpdateInteractor;
            this.d = gson;
            this.e = analytics;
            this.f = features;
            HttpUrl parse = HttpUrl.Companion.parse(Strings.ensureEndsWith(features.getApiUrl().invoke(), "/"));
            if (parse != null) {
                this.a = parse;
                return;
            }
            StringBuilder L = a.L("Invalid api url: ");
            L.append(features.getApiUrl().invoke());
            throw new IllegalArgumentException(L.toString().toString());
        }

        public final Request a() {
            if (!this.b.toBlocking().isAuthorized()) {
                this.e.track(new SessionRefreshErrorEvent("no_session"));
                return null;
            }
            String refreshToken = this.b.toBlocking().getRefreshToken();
            if (refreshToken == null) {
                this.e.track(new SessionRefreshErrorEvent("no_token"));
                return null;
            }
            HttpUrl build = this.a.newBuilder().addEncodedPathSegment(ExifInterface.GPS_MEASUREMENT_2D).addEncodedPathSegment("refresh").build();
            return RequestsKt.withRefreshTag(new Request.Builder().url(build).post(RequestBody.Companion.create(RequestUtils.INSTANCE.getUrlEncodedParams(a.y1("refreshToken", refreshToken)), RequestsKt.getMEDIA_TYPE_FORM_URLENCODED()))).build();
        }

        public final boolean b(Response response, String str) {
            if (response.isSuccessful()) {
                try {
                    ResponseBody body = response.body();
                    if (body != null) {
                        AuthResult authResult = (AuthResult) this.d.fromJson(body.string(), (Class<Object>) AuthResult.class);
                        AccountUpdateInteractorKt.login(this.c, authResult.getSession(), authResult.getProfile(), str).blockingAwait();
                        return true;
                    }
                    throw new IllegalArgumentException("empty refresh response body".toString());
                } catch (Throwable th) {
                    this.e.track(new SessionRefreshErrorEvent("network_client"));
                    this.e.track(new NonFatalError("Cannot refresh user session", th, null, 4, null));
                }
            } else {
                if (response.code() == 403 || response.code() == 401) {
                    this.e.track(new SessionRefreshErrorEvent("forbidden"));
                    this.c.logout(false, str).blockingAwait();
                } else {
                    c(String.valueOf(response.code()));
                }
                return false;
            }
        }

        public final void c(String str) {
            this.e.track(new SessionRefreshErrorEvent(str));
        }

        @Override // com.avito.android.session_refresh.SessionRefresher
        public boolean refreshSession(@Nullable String str, @Nullable String str2, @NotNull Function1<? super Request, Response> function1) {
            Intrinsics.checkNotNullParameter(function1, "perform");
            synchronized (b.a) {
                if (!TextUtils.equals(this.b.toBlocking().getSession(), str)) {
                    return true;
                }
                Request a3 = a();
                if (a3 == null) {
                    return false;
                }
                try {
                    return b(function1.invoke(a3), str2);
                } catch (IOException e2) {
                    this.e.track(new SessionRefreshErrorEvent("network"));
                    throw e2;
                }
            }
        }
    }

    boolean refreshSession(@Nullable String str, @Nullable String str2, @NotNull Function1<? super Request, Response> function1) throws IOException;
}

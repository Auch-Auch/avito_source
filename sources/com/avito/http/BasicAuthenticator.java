package com.avito.http;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.Preference;
import com.google.common.net.HttpHeaders;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/avito/http/BasicAuthenticator;", "Lokhttp3/Authenticator;", "Lokhttp3/Route;", AnalyticFieldsName.route, "Lokhttp3/Response;", CommonKt.EXTRA_RESPONSE, "Lokhttp3/Request;", "authenticate", "(Lokhttp3/Route;Lokhttp3/Response;)Lokhttp3/Request;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", Preference.PASSWORD, AuthSource.SEND_ABUSE, "user", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "okhttp"}, k = 1, mv = {1, 4, 2})
public final class BasicAuthenticator implements Authenticator {
    public final String a;
    public final String b;

    public BasicAuthenticator(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "user");
        Intrinsics.checkNotNullParameter(str2, Preference.PASSWORD);
        this.a = str;
        this.b = str2;
    }

    @Override // okhttp3.Authenticator
    @NotNull
    public Request authenticate(@Nullable Route route, @NotNull Response response) {
        Intrinsics.checkNotNullParameter(response, CommonKt.EXTRA_RESPONSE);
        return response.request().newBuilder().addHeader(HttpHeaders.AUTHORIZATION, Credentials.basic$default(this.a, this.b, null, 4, null)).build();
    }
}

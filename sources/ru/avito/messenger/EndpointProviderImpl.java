package ru.avito.messenger;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Singles;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\n¢\u0006\u0004\b\b\u0010\u000bJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lru/avito/messenger/EndpointProviderImpl;", "Lru/avito/messenger/EndpointProvider;", "Lio/reactivex/Single;", "Lokhttp3/HttpUrl;", "endpoint", "()Lio/reactivex/Single;", AuthSource.SEND_ABUSE, "Lokhttp3/HttpUrl;", "<init>", "(Lokhttp3/HttpUrl;)V", "", "(Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class EndpointProviderImpl implements EndpointProvider {
    public final HttpUrl a;

    public EndpointProviderImpl(@NotNull HttpUrl httpUrl) {
        Intrinsics.checkNotNullParameter(httpUrl, "endpoint");
        this.a = httpUrl;
    }

    @Override // ru.avito.messenger.EndpointProvider
    @NotNull
    public Single<HttpUrl> endpoint() {
        return Singles.toSingle(this.a);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public EndpointProviderImpl(@org.jetbrains.annotations.NotNull java.lang.String r2) {
        /*
            r1 = this;
            java.lang.String r0 = "endpoint"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            okhttp3.HttpUrl$Companion r0 = okhttp3.HttpUrl.Companion
            okhttp3.HttpUrl r0 = r0.parse(r2)
            if (r0 == 0) goto L_0x0011
            r1.<init>(r0)
            return
        L_0x0011:
            java.lang.String r0 = "invalid endpoint: "
            java.lang.String r2 = a2.b.a.a.a.c3(r0, r2)
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.avito.messenger.EndpointProviderImpl.<init>(java.lang.String):void");
    }
}

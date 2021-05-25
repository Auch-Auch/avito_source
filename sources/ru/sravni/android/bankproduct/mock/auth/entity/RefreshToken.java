package ru.sravni.android.bankproduct.mock.auth.entity;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.domain.token.entity.HttpResponseStatus;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u001b\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007¨\u0006\u001f"}, d2 = {"Lru/sravni/android/bankproduct/mock/auth/entity/RefreshToken;", "", "Lru/sravni/android/bankproduct/domain/token/entity/HttpResponseStatus;", "component1", "()Lru/sravni/android/bankproduct/domain/token/entity/HttpResponseStatus;", "Lru/sravni/android/bankproduct/mock/auth/entity/AccessToken;", "component2", "()Lru/sravni/android/bankproduct/mock/auth/entity/AccessToken;", "responseStatus", "nextAccessToken", "copy", "(Lru/sravni/android/bankproduct/domain/token/entity/HttpResponseStatus;Lru/sravni/android/bankproduct/mock/auth/entity/AccessToken;)Lru/sravni/android/bankproduct/mock/auth/entity/RefreshToken;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/domain/token/entity/HttpResponseStatus;", "getResponseStatus", AuthSource.BOOKING_ORDER, "Lru/sravni/android/bankproduct/mock/auth/entity/AccessToken;", "getNextAccessToken", "<init>", "(Lru/sravni/android/bankproduct/domain/token/entity/HttpResponseStatus;Lru/sravni/android/bankproduct/mock/auth/entity/AccessToken;)V", "Companion", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class RefreshToken {
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final HttpResponseStatus a;
    @Nullable
    public final AccessToken b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lru/sravni/android/bankproduct/mock/auth/entity/RefreshToken$Companion;", "", "Lru/sravni/android/bankproduct/mock/auth/entity/AccessToken;", "nextAccessToken", "Lru/sravni/android/bankproduct/mock/auth/entity/RefreshToken;", "success", "(Lru/sravni/android/bankproduct/mock/auth/entity/AccessToken;)Lru/sravni/android/bankproduct/mock/auth/entity/RefreshToken;", "Lru/sravni/android/bankproduct/domain/token/entity/HttpResponseStatus;", "responseStatus", "fail", "(Lru/sravni/android/bankproduct/domain/token/entity/HttpResponseStatus;)Lru/sravni/android/bankproduct/mock/auth/entity/RefreshToken;", "<init>", "()V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final RefreshToken fail(@NotNull HttpResponseStatus httpResponseStatus) {
            Intrinsics.checkParameterIsNotNull(httpResponseStatus, "responseStatus");
            if (httpResponseStatus != HttpResponseStatus.SUCCESS) {
                return new RefreshToken(httpResponseStatus, null, 2, null);
            }
            throw new Exception("Wrong Argument for fail refresh token. It can not be success");
        }

        @NotNull
        public final RefreshToken success(@NotNull AccessToken accessToken) {
            Intrinsics.checkParameterIsNotNull(accessToken, "nextAccessToken");
            return new RefreshToken(HttpResponseStatus.SUCCESS, accessToken);
        }

        public Companion(j jVar) {
        }
    }

    public RefreshToken(@NotNull HttpResponseStatus httpResponseStatus, @Nullable AccessToken accessToken) {
        Intrinsics.checkParameterIsNotNull(httpResponseStatus, "responseStatus");
        this.a = httpResponseStatus;
        this.b = accessToken;
    }

    public static /* synthetic */ RefreshToken copy$default(RefreshToken refreshToken, HttpResponseStatus httpResponseStatus, AccessToken accessToken, int i, Object obj) {
        if ((i & 1) != 0) {
            httpResponseStatus = refreshToken.a;
        }
        if ((i & 2) != 0) {
            accessToken = refreshToken.b;
        }
        return refreshToken.copy(httpResponseStatus, accessToken);
    }

    @NotNull
    public final HttpResponseStatus component1() {
        return this.a;
    }

    @Nullable
    public final AccessToken component2() {
        return this.b;
    }

    @NotNull
    public final RefreshToken copy(@NotNull HttpResponseStatus httpResponseStatus, @Nullable AccessToken accessToken) {
        Intrinsics.checkParameterIsNotNull(httpResponseStatus, "responseStatus");
        return new RefreshToken(httpResponseStatus, accessToken);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RefreshToken)) {
            return false;
        }
        RefreshToken refreshToken = (RefreshToken) obj;
        return Intrinsics.areEqual(this.a, refreshToken.a) && Intrinsics.areEqual(this.b, refreshToken.b);
    }

    @Nullable
    public final AccessToken getNextAccessToken() {
        return this.b;
    }

    @NotNull
    public final HttpResponseStatus getResponseStatus() {
        return this.a;
    }

    public int hashCode() {
        HttpResponseStatus httpResponseStatus = this.a;
        int i = 0;
        int hashCode = (httpResponseStatus != null ? httpResponseStatus.hashCode() : 0) * 31;
        AccessToken accessToken = this.b;
        if (accessToken != null) {
            i = accessToken.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("RefreshToken(responseStatus=");
        L.append(this.a);
        L.append(", nextAccessToken=");
        L.append(this.b);
        L.append(")");
        return L.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RefreshToken(HttpResponseStatus httpResponseStatus, AccessToken accessToken, int i, j jVar) {
        this(httpResponseStatus, (i & 2) != 0 ? null : accessToken);
    }
}

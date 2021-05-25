package ru.sravni.android.bankproduct.mock.auth.entity;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.payment.status.PaymentStateKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.domain.token.entity.HttpResponseStatus;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\b\u0018\u0000 %2\u00020\u0001:\u0001%B%\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\b¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ0\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\nR\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u001b\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0007¨\u0006&"}, d2 = {"Lru/sravni/android/bankproduct/mock/auth/entity/AccessToken;", "", "Lru/sravni/android/bankproduct/domain/token/entity/HttpResponseStatus;", "component1", "()Lru/sravni/android/bankproduct/domain/token/entity/HttpResponseStatus;", "Lru/sravni/android/bankproduct/mock/auth/entity/RefreshToken;", "component2", "()Lru/sravni/android/bankproduct/mock/auth/entity/RefreshToken;", "", "component3", "()J", "tokenStatus", "refreshToken", "expiresAt", "copy", "(Lru/sravni/android/bankproduct/domain/token/entity/HttpResponseStatus;Lru/sravni/android/bankproduct/mock/auth/entity/RefreshToken;J)Lru/sravni/android/bankproduct/mock/auth/entity/AccessToken;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "J", "getExpiresAt", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/domain/token/entity/HttpResponseStatus;", "getTokenStatus", AuthSource.BOOKING_ORDER, "Lru/sravni/android/bankproduct/mock/auth/entity/RefreshToken;", "getRefreshToken", "<init>", "(Lru/sravni/android/bankproduct/domain/token/entity/HttpResponseStatus;Lru/sravni/android/bankproduct/mock/auth/entity/RefreshToken;J)V", "Companion", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class AccessToken {
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final HttpResponseStatus a;
    @Nullable
    public final RefreshToken b;
    public final long c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lru/sravni/android/bankproduct/mock/auth/entity/AccessToken$Companion;", "", "Lru/sravni/android/bankproduct/mock/auth/entity/AccessToken;", "success", "()Lru/sravni/android/bankproduct/mock/auth/entity/AccessToken;", "Lru/sravni/android/bankproduct/mock/auth/entity/RefreshToken;", "refreshToken", "expired", "(Lru/sravni/android/bankproduct/mock/auth/entity/RefreshToken;)Lru/sravni/android/bankproduct/mock/auth/entity/AccessToken;", "Lru/sravni/android/bankproduct/domain/token/entity/HttpResponseStatus;", "tokenStatus", PaymentStateKt.PAYMENT_STATE_FAILED, "(Lru/sravni/android/bankproduct/domain/token/entity/HttpResponseStatus;)Lru/sravni/android/bankproduct/mock/auth/entity/AccessToken;", "<init>", "()V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                HttpResponseStatus.values();
                int[] iArr = new int[10];
                $EnumSwitchMapping$0 = iArr;
                HttpResponseStatus httpResponseStatus = HttpResponseStatus.SUCCESS;
                iArr[0] = 1;
                HttpResponseStatus httpResponseStatus2 = HttpResponseStatus.TOKEN_EXPIRE;
                iArr[1] = 2;
            }
        }

        public Companion() {
        }

        @NotNull
        public final AccessToken expired(@NotNull RefreshToken refreshToken) {
            Intrinsics.checkParameterIsNotNull(refreshToken, "refreshToken");
            return new AccessToken(HttpResponseStatus.TOKEN_EXPIRE, refreshToken, 0, 4, null);
        }

        @NotNull
        public final AccessToken failed(@NotNull HttpResponseStatus httpResponseStatus) {
            Intrinsics.checkParameterIsNotNull(httpResponseStatus, "tokenStatus");
            int ordinal = httpResponseStatus.ordinal();
            if (ordinal == 0) {
                throw new Exception("Wrong Argument for fail access token. It can not be success");
            } else if (ordinal != 1) {
                return new AccessToken(httpResponseStatus, null, 0, 6, null);
            } else {
                throw new Exception("Wrong Argument for fail expired token. It can not be expired");
            }
        }

        @NotNull
        public final AccessToken success() {
            return new AccessToken(HttpResponseStatus.SUCCESS, null, 0, 6, null);
        }

        public Companion(j jVar) {
        }
    }

    public AccessToken(@NotNull HttpResponseStatus httpResponseStatus, @Nullable RefreshToken refreshToken, long j) {
        Intrinsics.checkParameterIsNotNull(httpResponseStatus, "tokenStatus");
        this.a = httpResponseStatus;
        this.b = refreshToken;
        this.c = j;
    }

    public static /* synthetic */ AccessToken copy$default(AccessToken accessToken, HttpResponseStatus httpResponseStatus, RefreshToken refreshToken, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            httpResponseStatus = accessToken.a;
        }
        if ((i & 2) != 0) {
            refreshToken = accessToken.b;
        }
        if ((i & 4) != 0) {
            j = accessToken.c;
        }
        return accessToken.copy(httpResponseStatus, refreshToken, j);
    }

    @NotNull
    public final HttpResponseStatus component1() {
        return this.a;
    }

    @Nullable
    public final RefreshToken component2() {
        return this.b;
    }

    public final long component3() {
        return this.c;
    }

    @NotNull
    public final AccessToken copy(@NotNull HttpResponseStatus httpResponseStatus, @Nullable RefreshToken refreshToken, long j) {
        Intrinsics.checkParameterIsNotNull(httpResponseStatus, "tokenStatus");
        return new AccessToken(httpResponseStatus, refreshToken, j);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccessToken)) {
            return false;
        }
        AccessToken accessToken = (AccessToken) obj;
        return Intrinsics.areEqual(this.a, accessToken.a) && Intrinsics.areEqual(this.b, accessToken.b) && this.c == accessToken.c;
    }

    public final long getExpiresAt() {
        return this.c;
    }

    @Nullable
    public final RefreshToken getRefreshToken() {
        return this.b;
    }

    @NotNull
    public final HttpResponseStatus getTokenStatus() {
        return this.a;
    }

    public int hashCode() {
        HttpResponseStatus httpResponseStatus = this.a;
        int i = 0;
        int hashCode = (httpResponseStatus != null ? httpResponseStatus.hashCode() : 0) * 31;
        RefreshToken refreshToken = this.b;
        if (refreshToken != null) {
            i = refreshToken.hashCode();
        }
        return ((hashCode + i) * 31) + c.a(this.c);
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("AccessToken(tokenStatus=");
        L.append(this.a);
        L.append(", refreshToken=");
        L.append(this.b);
        L.append(", expiresAt=");
        return a.l(L, this.c, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AccessToken(HttpResponseStatus httpResponseStatus, RefreshToken refreshToken, long j, int i, j jVar) {
        this(httpResponseStatus, (i & 2) != 0 ? null : refreshToken, (i & 4) != 0 ? 1640984400 : j);
    }
}

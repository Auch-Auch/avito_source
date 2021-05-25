package ru.sravni.android.bankproduct.domain.token.entity;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ8\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\bR\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u001c\u001a\u0004\b!\u0010\b¨\u0006$"}, d2 = {"Lru/sravni/android/bankproduct/domain/token/entity/TokenData;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()J", "component4", "refresh_token", "access_token", "expires_at", "saveTime", "copy", "(Ljava/lang/String;Ljava/lang/String;JJ)Lru/sravni/android/bankproduct/domain/token/entity/TokenData;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getRefresh_token", "c", "J", "getExpires_at", AuthSource.BOOKING_ORDER, "getAccess_token", "d", "getSaveTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;JJ)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class TokenData {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    public final long c;
    public final long d;

    public TokenData(@NotNull String str, @NotNull String str2, long j, long j2) {
        Intrinsics.checkParameterIsNotNull(str, "refresh_token");
        Intrinsics.checkParameterIsNotNull(str2, "access_token");
        this.a = str;
        this.b = str2;
        this.c = j;
        this.d = j2;
    }

    public static /* synthetic */ TokenData copy$default(TokenData tokenData, String str, String str2, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = tokenData.a;
        }
        if ((i & 2) != 0) {
            str2 = tokenData.b;
        }
        if ((i & 4) != 0) {
            j = tokenData.c;
        }
        if ((i & 8) != 0) {
            j2 = tokenData.d;
        }
        return tokenData.copy(str, str2, j, j2);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    public final long component3() {
        return this.c;
    }

    public final long component4() {
        return this.d;
    }

    @NotNull
    public final TokenData copy(@NotNull String str, @NotNull String str2, long j, long j2) {
        Intrinsics.checkParameterIsNotNull(str, "refresh_token");
        Intrinsics.checkParameterIsNotNull(str2, "access_token");
        return new TokenData(str, str2, j, j2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TokenData)) {
            return false;
        }
        TokenData tokenData = (TokenData) obj;
        return Intrinsics.areEqual(this.a, tokenData.a) && Intrinsics.areEqual(this.b, tokenData.b) && this.c == tokenData.c && this.d == tokenData.d;
    }

    @NotNull
    public final String getAccess_token() {
        return this.b;
    }

    public final long getExpires_at() {
        return this.c;
    }

    @NotNull
    public final String getRefresh_token() {
        return this.a;
    }

    public final long getSaveTime() {
        return this.d;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((((hashCode + i) * 31) + c.a(this.c)) * 31) + c.a(this.d);
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("TokenData(refresh_token=");
        L.append(this.a);
        L.append(", access_token=");
        L.append(this.b);
        L.append(", expires_at=");
        L.append(this.c);
        L.append(", saveTime=");
        return a.l(L, this.d, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TokenData(String str, String str2, long j, long j2, int i, j jVar) {
        this(str, str2, j, (i & 8) != 0 ? System.currentTimeMillis() : j2);
    }
}

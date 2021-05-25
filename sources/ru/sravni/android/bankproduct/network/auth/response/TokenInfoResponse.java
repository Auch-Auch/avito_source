package ru.sravni.android.bankproduct.network.auth.response;

import a2.b.a.a.a;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J8\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u000b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001c\u0010\n\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0018\u0010\u0004R\u001c\u0010\b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0019\u0010\u0004R\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001d"}, d2 = {"Lru/sravni/android/bankproduct/network/auth/response/TokenInfoResponse;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", SDKConstants.PARAM_ACCESS_TOKEN, "expiresAt", "refreshToken", "tokenType", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/network/auth/response/TokenInfoResponse;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTokenType", "getRefreshToken", "getAccessToken", "getExpiresAt", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class TokenInfoResponse {
    @SerializedName("access_token")
    @NotNull
    private final String accessToken;
    @SerializedName("expires_at")
    @NotNull
    private final String expiresAt;
    @SerializedName("refresh_token")
    @NotNull
    private final String refreshToken;
    @SerializedName("token_type")
    @NotNull
    private final String tokenType;

    public TokenInfoResponse(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkParameterIsNotNull(str, SDKConstants.PARAM_ACCESS_TOKEN);
        Intrinsics.checkParameterIsNotNull(str2, "expiresAt");
        Intrinsics.checkParameterIsNotNull(str3, "refreshToken");
        Intrinsics.checkParameterIsNotNull(str4, "tokenType");
        this.accessToken = str;
        this.expiresAt = str2;
        this.refreshToken = str3;
        this.tokenType = str4;
    }

    public static /* synthetic */ TokenInfoResponse copy$default(TokenInfoResponse tokenInfoResponse, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = tokenInfoResponse.accessToken;
        }
        if ((i & 2) != 0) {
            str2 = tokenInfoResponse.expiresAt;
        }
        if ((i & 4) != 0) {
            str3 = tokenInfoResponse.refreshToken;
        }
        if ((i & 8) != 0) {
            str4 = tokenInfoResponse.tokenType;
        }
        return tokenInfoResponse.copy(str, str2, str3, str4);
    }

    @NotNull
    public final String component1() {
        return this.accessToken;
    }

    @NotNull
    public final String component2() {
        return this.expiresAt;
    }

    @NotNull
    public final String component3() {
        return this.refreshToken;
    }

    @NotNull
    public final String component4() {
        return this.tokenType;
    }

    @NotNull
    public final TokenInfoResponse copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkParameterIsNotNull(str, SDKConstants.PARAM_ACCESS_TOKEN);
        Intrinsics.checkParameterIsNotNull(str2, "expiresAt");
        Intrinsics.checkParameterIsNotNull(str3, "refreshToken");
        Intrinsics.checkParameterIsNotNull(str4, "tokenType");
        return new TokenInfoResponse(str, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TokenInfoResponse)) {
            return false;
        }
        TokenInfoResponse tokenInfoResponse = (TokenInfoResponse) obj;
        return Intrinsics.areEqual(this.accessToken, tokenInfoResponse.accessToken) && Intrinsics.areEqual(this.expiresAt, tokenInfoResponse.expiresAt) && Intrinsics.areEqual(this.refreshToken, tokenInfoResponse.refreshToken) && Intrinsics.areEqual(this.tokenType, tokenInfoResponse.tokenType);
    }

    @NotNull
    public final String getAccessToken() {
        return this.accessToken;
    }

    @NotNull
    public final String getExpiresAt() {
        return this.expiresAt;
    }

    @NotNull
    public final String getRefreshToken() {
        return this.refreshToken;
    }

    @NotNull
    public final String getTokenType() {
        return this.tokenType;
    }

    public int hashCode() {
        String str = this.accessToken;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.expiresAt;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.refreshToken;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.tokenType;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("TokenInfoResponse(accessToken=");
        L.append(this.accessToken);
        L.append(", expiresAt=");
        L.append(this.expiresAt);
        L.append(", refreshToken=");
        L.append(this.refreshToken);
        L.append(", tokenType=");
        return a.t(L, this.tokenType, ")");
    }
}

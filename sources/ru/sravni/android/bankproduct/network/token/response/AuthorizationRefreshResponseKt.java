package ru.sravni.android.bankproduct.network.token.response;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.domain.token.entity.TokenData;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lru/sravni/android/bankproduct/network/token/response/AuthorizationRefreshResponse;", "Lru/sravni/android/bankproduct/domain/token/entity/TokenData;", "toConvertTokenData", "(Lru/sravni/android/bankproduct/network/token/response/AuthorizationRefreshResponse;)Lru/sravni/android/bankproduct/domain/token/entity/TokenData;", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class AuthorizationRefreshResponseKt {
    @NotNull
    public static final TokenData toConvertTokenData(@NotNull AuthorizationRefreshResponse authorizationRefreshResponse) {
        Intrinsics.checkParameterIsNotNull(authorizationRefreshResponse, "$this$toConvertTokenData");
        return new TokenData(authorizationRefreshResponse.getRefreshToken(), authorizationRefreshResponse.getAccessToken(), Long.parseLong(authorizationRefreshResponse.getExpiresAt()), 0, 8, null);
    }
}

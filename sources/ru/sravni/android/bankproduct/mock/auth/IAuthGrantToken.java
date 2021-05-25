package ru.sravni.android.bankproduct.mock.auth;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.domain.token.entity.TokenData;
import ru.sravni.android.bankproduct.mock.auth.entity.AccessToken;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lru/sravni/android/bankproduct/mock/auth/IAuthGrantToken;", "", "Lru/sravni/android/bankproduct/mock/auth/entity/AccessToken;", SDKConstants.PARAM_ACCESS_TOKEN, "Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/domain/token/entity/TokenData;", "grantToken", "(Lru/sravni/android/bankproduct/mock/auth/entity/AccessToken;)Lio/reactivex/Observable;", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IAuthGrantToken {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static final class DefaultImpls {
        public static /* synthetic */ Observable grantToken$default(IAuthGrantToken iAuthGrantToken, AccessToken accessToken, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    accessToken = AccessToken.Companion.success();
                }
                return iAuthGrantToken.grantToken(accessToken);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: grantToken");
        }
    }

    @NotNull
    Observable<TokenData> grantToken(@Nullable AccessToken accessToken);
}

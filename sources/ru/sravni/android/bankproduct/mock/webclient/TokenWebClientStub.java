package ru.sravni.android.bankproduct.mock.webclient;

import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Observable;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.domain.token.entity.TokenData;
import ru.sravni.android.bankproduct.mock.auth.IAuthRefreshToken;
import ru.sravni.android.bankproduct.repository.token.ITokenWebClient;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lru/sravni/android/bankproduct/mock/webclient/TokenWebClientStub;", "Lru/sravni/android/bankproduct/repository/token/ITokenWebClient;", "", "refreshToken", "Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/domain/token/entity/TokenData;", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/mock/auth/IAuthRefreshToken;", AuthSource.BOOKING_ORDER, "Lru/sravni/android/bankproduct/mock/auth/IAuthRefreshToken;", "tokenRefresher", "", AuthSource.SEND_ABUSE, "J", "delay", "<init>", "(JLru/sravni/android/bankproduct/mock/auth/IAuthRefreshToken;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class TokenWebClientStub implements ITokenWebClient {
    public final long a;
    public final IAuthRefreshToken b;

    public TokenWebClientStub(long j, @NotNull IAuthRefreshToken iAuthRefreshToken) {
        Intrinsics.checkParameterIsNotNull(iAuthRefreshToken, "tokenRefresher");
        this.a = j;
        this.b = iAuthRefreshToken;
    }

    @Override // ru.sravni.android.bankproduct.repository.token.ITokenWebClient
    @NotNull
    public Observable<TokenData> refreshToken(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "refreshToken");
        Observable<TokenData> delay = this.b.refreshToken(str).delay(this.a, TimeUnit.SECONDS);
        Intrinsics.checkExpressionValueIsNotNull(delay, "tokenRefresher.refreshTo…(delay, TimeUnit.SECONDS)");
        return delay;
    }
}

package ru.sravni.android.bankproduct.mock.webclient;

import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Observable;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.domain.token.entity.TokenData;
import ru.sravni.android.bankproduct.mock.auth.IAuthGrantToken;
import ru.sravni.android.bankproduct.mock.auth.entity.AccessToken;
import ru.sravni.android.bankproduct.mock.auth.entity.RefreshToken;
import ru.sravni.android.bankproduct.repository.auth.IAuthWebClient;
import ru.sravni.android.bankproduct.repository.auth.entity.RegisterInfoRepo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lru/sravni/android/bankproduct/mock/webclient/AuthWebClientStub;", "Lru/sravni/android/bankproduct/repository/auth/IAuthWebClient;", "", "phone", "Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/repository/auth/entity/RegisterInfoRepo;", "registerUser", "(Ljava/lang/String;)Lio/reactivex/Observable;", "smsCode", "Lru/sravni/android/bankproduct/domain/token/entity/TokenData;", "sendSmsCode", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/mock/auth/IAuthGrantToken;", AuthSource.BOOKING_ORDER, "Lru/sravni/android/bankproduct/mock/auth/IAuthGrantToken;", "authGrantToken", "", AuthSource.SEND_ABUSE, "J", "delay", "<init>", "(JLru/sravni/android/bankproduct/mock/auth/IAuthGrantToken;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class AuthWebClientStub implements IAuthWebClient {
    public final long a;
    public final IAuthGrantToken b;

    public AuthWebClientStub(long j, @NotNull IAuthGrantToken iAuthGrantToken) {
        Intrinsics.checkParameterIsNotNull(iAuthGrantToken, "authGrantToken");
        this.a = j;
        this.b = iAuthGrantToken;
    }

    @Override // ru.sravni.android.bankproduct.repository.auth.IAuthWebClient
    @NotNull
    public Observable<RegisterInfoRepo> registerUser(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "phone");
        Observable<RegisterInfoRepo> delay = Observable.just(new RegisterInfoRepo()).delay(this.a, TimeUnit.SECONDS);
        Intrinsics.checkExpressionValueIsNotNull(delay, "Observable.just(Register…(delay, TimeUnit.SECONDS)");
        return delay;
    }

    @Override // ru.sravni.android.bankproduct.repository.auth.IAuthWebClient
    @NotNull
    public Observable<TokenData> sendSmsCode(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "phone");
        Intrinsics.checkParameterIsNotNull(str2, "smsCode");
        IAuthGrantToken iAuthGrantToken = this.b;
        AccessToken.Companion companion = AccessToken.Companion;
        return iAuthGrantToken.grantToken(companion.expired(RefreshToken.Companion.success(companion.success())));
    }
}

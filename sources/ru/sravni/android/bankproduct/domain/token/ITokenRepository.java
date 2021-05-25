package ru.sravni.android.bankproduct.domain.token;

import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.domain.token.entity.HttpResponseStatus;
import ru.sravni.android.bankproduct.domain.token.entity.TokenData;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0004H&¢\u0006\u0004\b\n\u0010\bR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lru/sravni/android/bankproduct/domain/token/ITokenRepository;", "Lru/sravni/android/bankproduct/domain/token/ITokenDataGetter;", "Lru/sravni/android/bankproduct/domain/token/entity/TokenData;", "tokenData", "", "setTokenData", "(Lru/sravni/android/bankproduct/domain/token/entity/TokenData;)V", "restoreTokenData", "()V", "clear", "refresh", "Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/domain/token/entity/HttpResponseStatus;", "getTokenStatusChannel", "()Lio/reactivex/Observable;", "tokenStatusChannel", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface ITokenRepository extends ITokenDataGetter {
    void clear();

    @NotNull
    Observable<HttpResponseStatus> getTokenStatusChannel();

    void refresh();

    void restoreTokenData();

    void setTokenData(@NotNull TokenData tokenData);
}

package ru.sravni.android.bankproduct.domain.token;

import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.domain.token.entity.HttpResponseStatus;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lru/sravni/android/bankproduct/domain/token/ITokenInteractor;", "", "", "restoreTokenData", "()V", "clearToken", "Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/domain/token/entity/HttpResponseStatus;", "getTokenStatusChannel", "()Lio/reactivex/Observable;", "tokenStatusChannel", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface ITokenInteractor {
    void clearToken();

    @NotNull
    Observable<HttpResponseStatus> getTokenStatusChannel();

    void restoreTokenData();
}

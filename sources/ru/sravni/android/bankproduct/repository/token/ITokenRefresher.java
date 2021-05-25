package ru.sravni.android.bankproduct.repository.token;

import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.domain.DataContainer;
import ru.sravni.android.bankproduct.domain.token.entity.TokenData;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006JD\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00072'\u0010\f\u001a#\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\bH&¢\u0006\u0004\b\r\u0010\u000eJR\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00072'\u0010\u000f\u001a#\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H&¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0006¨\u0006\u0015"}, d2 = {"Lru/sravni/android/bankproduct/repository/token/ITokenRefresher;", "", "Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/domain/DataContainer;", "Lru/sravni/android/bankproduct/domain/token/entity/TokenData;", "refresh", "()Lio/reactivex/Observable;", "T", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "tokenData", "baseRequest", "wrapWithTokenRefresh", "(Lkotlin/jvm/functions/Function1;)Lio/reactivex/Observable;", "authRequest", "unAuthRequest", "sendAuthorizedOrUnauthorizedQuery", "(Lkotlin/jvm/functions/Function1;Lio/reactivex/Observable;)Lio/reactivex/Observable;", "getTokenRefreshChannel", "tokenRefreshChannel", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface ITokenRefresher {
    @NotNull
    Observable<DataContainer<TokenData>> getTokenRefreshChannel();

    @NotNull
    Observable<DataContainer<TokenData>> refresh();

    @NotNull
    <T> Observable<T> sendAuthorizedOrUnauthorizedQuery(@NotNull Function1<? super TokenData, ? extends Observable<T>> function1, @NotNull Observable<T> observable);

    @NotNull
    <T> Observable<T> wrapWithTokenRefresh(@NotNull Function1<? super TokenData, ? extends Observable<T>> function1);
}

package a7.c.a.a.p.b;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import ru.sravni.android.bankproduct.domain.DataContainer;
import ru.sravni.android.bankproduct.domain.token.entity.TokenData;
import ru.sravni.android.bankproduct.repository.token.TokenRefresher;
public final class d<T, R> implements Function<Throwable, ObservableSource<? extends DataContainer<? extends TokenData>>> {
    public final /* synthetic */ TokenRefresher a;

    public d(TokenRefresher tokenRefresher) {
        this.a = tokenRefresher;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ObservableSource<? extends DataContainer<? extends TokenData>> apply(Throwable th) {
        Throwable th2 = th;
        Intrinsics.checkParameterIsNotNull(th2, "throwable");
        return Observable.just(new DataContainer(null, this.a.g.wrap(th2)));
    }
}

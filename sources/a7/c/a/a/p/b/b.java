package a7.c.a.a.p.b;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ru.sravni.android.bankproduct.domain.DataContainer;
import ru.sravni.android.bankproduct.domain.sravnierror.entity.SravniError;
import ru.sravni.android.bankproduct.domain.token.entity.HttpResponseStatus;
import ru.sravni.android.bankproduct.repository.token.TokenRefresher;
public final class b<T, R> implements Function<Throwable, ObservableSource<? extends T>> {
    public final /* synthetic */ TokenRefresher a;
    public final /* synthetic */ Function1 b;

    public b(TokenRefresher tokenRefresher, Function1 function1) {
        this.a = tokenRefresher;
        this.b = function1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Object apply(Throwable th) {
        Throwable th2 = th;
        Intrinsics.checkParameterIsNotNull(th2, "throwable");
        SravniError wrap = this.a.g.wrap(th2);
        int code = wrap.getErrDescription().getCode();
        if (code == HttpResponseStatus.TOKEN_EXPIRE.getCode()) {
            return this.a.refresh().flatMap(new a(this));
        }
        HttpResponseStatus[] values = HttpResponseStatus.values();
        ArrayList arrayList = new ArrayList(10);
        for (int i = 0; i < 10; i++) {
            arrayList.add(Integer.valueOf(values[i].getCode()));
        }
        if (!arrayList.contains(Integer.valueOf(code))) {
            return Observable.error(th2);
        }
        this.a.getTokenRefreshChannel().onNext(new DataContainer<>(null, wrap));
        return Observable.error(th2);
    }
}

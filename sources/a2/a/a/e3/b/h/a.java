package a2.a.a.e3.b.h;

import com.avito.android.tariff.count.viewmodel.TariffCountRepositoryImpl;
import com.avito.android.util.ShouldRetryException;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
public final class a<T, R> implements Function<Throwable, ObservableSource<? extends Long>> {
    public final /* synthetic */ TariffCountRepositoryImpl.b a;

    public a(TariffCountRepositoryImpl.b bVar) {
        this.a = bVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ObservableSource<? extends Long> apply(Throwable th) {
        Throwable th2 = th;
        Intrinsics.checkNotNullParameter(th2, "t");
        if (th2 instanceof ShouldRetryException) {
            return Observable.timer(5, TimeUnit.SECONDS, this.a.a.b.computation());
        }
        return Observable.error(th2);
    }
}

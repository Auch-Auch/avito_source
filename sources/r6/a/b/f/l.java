package r6.a.b.f;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Map;
public final class l<T, K> extends Single<T> {
    public final Supplier<? extends K> a;
    public final Map<? super K, ? extends SingleSource<? extends T>> b;
    public final SingleSource<? extends T> c;

    public l(Supplier<? extends K> supplier, Map<? super K, ? extends SingleSource<? extends T>> map, SingleSource<? extends T> singleSource) {
        this.a = supplier;
        this.b = map;
        this.c = singleSource;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        try {
            SingleSource<? extends T> singleSource = (SingleSource) this.b.get(this.a.get());
            if (singleSource == null) {
                singleSource = this.c;
            }
            singleSource.subscribe(singleObserver);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, singleObserver);
        }
    }
}

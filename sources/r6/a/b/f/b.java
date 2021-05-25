package r6.a.b.f;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Map;
public final class b<K> extends Completable {
    public final Supplier<? extends K> a;
    public final Map<? super K, ? extends CompletableSource> b;
    public final CompletableSource c;

    public b(Supplier<? extends K> supplier, Map<? super K, ? extends CompletableSource> map, CompletableSource completableSource) {
        this.a = supplier;
        this.b = map;
        this.c = completableSource;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        try {
            CompletableSource completableSource = (CompletableSource) this.b.get(this.a.get());
            if (completableSource == null) {
                completableSource = this.c;
            }
            completableSource.subscribe(completableObserver);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, completableObserver);
        }
    }
}

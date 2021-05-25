package com.avito.android.util.rx3;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00018\u00008\u0000 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00018\u00008\u0000\u0018\u00010\u00040\u0004\"\u0004\b\u0000\u0010\u00002*\u0010\u0003\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00018\u00008\u0000 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00018\u00008\u0000\u0018\u00010\u00010\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "Lio/reactivex/rxjava3/core/Observable;", "kotlin.jvm.PlatformType", "obs", "Lio/reactivex/rxjava3/core/ObservableSource;", "apply", "(Lio/reactivex/rxjava3/core/Observable;)Lio/reactivex/rxjava3/core/ObservableSource;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class Observables$doOnFirst$1<T, R> implements Function<Observable<T>, ObservableSource<T>> {
    public final /* synthetic */ Function1 a;

    public Observables$doOnFirst$1(Function1 function1) {
        this.a = function1;
    }

    public final ObservableSource<T> apply(Observable<T> observable) {
        return Observable.merge(observable.skip(1), observable.take(1).doOnNext(new Consumer<T>(this) { // from class: com.avito.android.util.rx3.Observables$doOnFirst$1.1
            public final /* synthetic */ Observables$doOnFirst$1 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(T t) {
                this.a.a.invoke(t);
            }
        }));
    }

    @Override // io.reactivex.rxjava3.functions.Function
    public /* bridge */ /* synthetic */ Object apply(Object obj) {
        return apply((Observable) ((Observable) obj));
    }
}

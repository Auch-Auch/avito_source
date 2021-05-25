package com.avito.android.util;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.jakewharton.rxrelay2.Relay;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\b0\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"com/avito/android/util/Observables$switchMapByKey$1", "Lio/reactivex/Observable;", "Lio/reactivex/Observer;", "observer", "", "subscribeActual", "(Lio/reactivex/Observer;)V", "", "Lio/reactivex/disposables/Disposable;", AuthSource.BOOKING_ORDER, "Ljava/util/Map;", "disposableMap", "Lcom/jakewharton/rxrelay2/Relay;", "c", "Lcom/jakewharton/rxrelay2/Relay;", "outRelay", AuthSource.SEND_ABUSE, "Lio/reactivex/Observable;", "source", "rx"}, k = 1, mv = {1, 4, 2})
public final class Observables$switchMapByKey$1 extends Observable<OutT> {
    public final Observable<EventT> a;
    public final Map<KeyT, Disposable> b = new LinkedHashMap();
    public final Relay<OutT> c = a.J1("PublishRelay.create<T>().toSerialized()");
    public final /* synthetic */ Observable d;
    public final /* synthetic */ Function1 e;
    public final /* synthetic */ Function1 f;

    public Observables$switchMapByKey$1(Observable<EventT> observable, Function1 function1, Function1 function12) {
        this.d = observable;
        this.e = function1;
        this.f = function12;
        this.a = observable;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(@NotNull Observer<? super OutT> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.a.subscribe(new Consumer<EventT>(this) { // from class: com.avito.android.util.Observables$switchMapByKey$1$subscribeActual$1
            public final /* synthetic */ Observables$switchMapByKey$1 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(EventT eventt) {
                Map access$getDisposableMap$p = Observables$switchMapByKey$1.access$getDisposableMap$p(this.a);
                Object invoke = this.a.e.invoke(eventt);
                Disposable subscribe = ((Observable) this.a.f.invoke(eventt)).subscribe(Observables$switchMapByKey$1.access$getOutRelay$p(this.a));
                Intrinsics.checkNotNullExpressionValue(subscribe, "mapper(event).subscribe(outRelay)");
                Disposable disposable = (Disposable) access$getDisposableMap$p.put(invoke, subscribe);
                if (disposable != null) {
                    disposable.dispose();
                }
            }
        });
        this.c.subscribe(observer);
    }
}

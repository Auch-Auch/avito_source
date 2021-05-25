package a2.a.a.o1.b.b.a.d;

import a2.b.a.a.a;
import com.avito.android.messenger.channels.mvi.common.v4.Reducible;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
public final class d<T, R> implements Function<StateT, ObservableSource<? extends Pair<? extends StateT, ? extends StateT>>> {
    public final /* synthetic */ g a;
    public final /* synthetic */ Reducible b;

    public d(g gVar, Reducible reducible) {
        this.a = gVar;
        this.b = reducible;
    }

    @Override // io.reactivex.functions.Function
    public Object apply(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "oldState");
        Function1 function1 = this.a.a.n;
        StringBuilder L = a.L("New Reducible: ");
        L.append(this.b);
        function1.invoke(L.toString());
        return this.b.execute(obj).toObservable().takeUntil(this.a.a.getReducerQueue().getStream().observeOn(this.a.a.getSchedulers().computation()).filter(new a(this)).subscribeOn(this.a.a.getSchedulers().computation())).observeOn(this.a.a.getSchedulerForReducibles()).onErrorReturn(new b(obj)).map(new c(obj)).subscribeOn(this.a.a.getSchedulerForReducibles());
    }
}

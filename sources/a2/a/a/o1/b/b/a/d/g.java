package a2.a.a.o1.b.b.a.d;

import com.avito.android.messenger.channels.mvi.common.v4.BaseMviEntityWithReducerQueue;
import com.avito.android.messenger.channels.mvi.common.v4.Reducible;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
public final class g<T, R> implements Function<Reducible<StateT>, ObservableSource<? extends Unit>> {
    public final /* synthetic */ BaseMviEntityWithReducerQueue a;

    public g(BaseMviEntityWithReducerQueue baseMviEntityWithReducerQueue) {
        this.a = baseMviEntityWithReducerQueue;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // io.reactivex.functions.Function
    public ObservableSource<? extends Unit> apply(Object obj) {
        Reducible reducible = (Reducible) obj;
        Intrinsics.checkNotNullParameter(reducible, "reducible");
        return this.a.c.observeOn(this.a.getSchedulerForReducibles()).take(1).flatMap(new d(this, reducible)).observeOn(this.a.getSchedulerForReducibles()).filter(e.a).map(new f(this)).subscribeOn(this.a.getSchedulerForReducibles());
    }
}

package a2.a.a.o1.b.b.a.d;

import com.avito.android.messenger.channels.mvi.common.v4.BaseMviEntityWithReducerQueue;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
public final class h<T> implements Consumer<Disposable> {
    public final /* synthetic */ BaseMviEntityWithReducerQueue a;

    public h(BaseMviEntityWithReducerQueue baseMviEntityWithReducerQueue) {
        this.a = baseMviEntityWithReducerQueue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Disposable disposable) {
        this.a.m.invoke("initialize() - Reducer Subscribed");
    }
}

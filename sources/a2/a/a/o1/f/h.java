package a2.a.a.o1.f;

import com.avito.android.messenger.search.ChannelsSearchInteractor;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class h<T, R> implements Function<Throwable, ChannelsSearchInteractor.State> {
    public final /* synthetic */ ChannelsSearchInteractor.State a;

    public h(ChannelsSearchInteractor.State state) {
        this.a = state;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ChannelsSearchInteractor.State apply(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return this.a;
    }
}

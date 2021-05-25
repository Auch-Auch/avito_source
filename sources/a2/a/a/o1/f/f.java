package a2.a.a.o1.f;

import com.avito.android.messenger.search.ChannelsSearchInteractor;
import com.avito.android.messenger.search.ChannelsSearchInteractorImpl;
import com.avito.android.messenger.util.ThrowablesKt;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class f<T, R> implements Function<Throwable, ChannelsSearchInteractor.State> {
    public final /* synthetic */ ChannelsSearchInteractorImpl.e a;
    public final /* synthetic */ ChannelsSearchInteractor.State b;

    public f(ChannelsSearchInteractorImpl.e eVar, ChannelsSearchInteractor.State state) {
        this.a = eVar;
        this.b = state;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ChannelsSearchInteractor.State apply(Throwable th) {
        Throwable th2 = th;
        Intrinsics.checkNotNullParameter(th2, "error");
        return new ChannelsSearchInteractor.State.Error(this.b.getCurrentUserId(), this.a.c, ThrowablesKt.toAvitoException(th2));
    }
}

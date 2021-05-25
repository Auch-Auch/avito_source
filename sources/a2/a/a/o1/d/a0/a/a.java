package a2.a.a.o1.d.a0.a;

import com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractor;
import com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class a<T, R> implements Function<Throwable, ChannelContextInteractor.State> {
    public final /* synthetic */ ChannelContextInteractorImpl.InitialDataRequestComposite.GetUserIdMutator.a a;
    public final /* synthetic */ ChannelContextInteractor.State b;

    public a(ChannelContextInteractorImpl.InitialDataRequestComposite.GetUserIdMutator.a aVar, ChannelContextInteractor.State state) {
        this.a = aVar;
        this.b = state;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ChannelContextInteractor.State apply(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        ChannelContextInteractorImpl.this.D.trackMessagesLoadError();
        return this.b;
    }
}

package a2.a.a.o1.d.a0.i;

import com.avito.android.messenger.conversation.mvi.messages.LoadFirstPageMutator;
import com.avito.android.messenger.conversation.mvi.messages.MessageListInteractor;
import io.reactivex.functions.Consumer;
public final class g<T> implements Consumer<MessageListInteractor.State.FirstPageLoaded> {
    public final /* synthetic */ LoadFirstPageMutator.a a;

    public g(LoadFirstPageMutator.a aVar) {
        this.a = aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(MessageListInteractor.State.FirstPageLoaded firstPageLoaded) {
        this.a.a.f.getTrackMessageFoundInDb().invoke();
    }
}

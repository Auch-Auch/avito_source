package a2.a.a.o1.d.a0.i;

import com.avito.android.messenger.conversation.mvi.messages.LoadPrevPageMutator;
import com.avito.android.messenger.conversation.mvi.messages.MessageListInteractor;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
public final class h<T, R> implements Function<Boolean, MessageListInteractor.State.FirstPageLoaded> {
    public final /* synthetic */ LoadPrevPageMutator.a a;

    public h(LoadPrevPageMutator.a aVar) {
        this.a = aVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public MessageListInteractor.State.FirstPageLoaded apply(Boolean bool) {
        Boolean bool2 = bool;
        Intrinsics.checkNotNullParameter(bool2, "hasMorePages");
        Observable<List<Pair<LocalMessage, MessageMetaInfo>>> firstPageMessagesAndMetaInfoObservable = ((MessageListInteractor.State.FirstPageLoaded) this.a.c).getFirstPageMessagesAndMetaInfoObservable();
        Observable<List<Pair<LocalMessage, MessageMetaInfo>>> messagesAndMetaInfoBefore = this.a.a.e.getMessageRepo().getMessagesAndMetaInfoBefore(this.a.d.longValue() + 1, this.a.a.c, this.a.a.d, this.a.b);
        LoadPrevPageMutator.a aVar = this.a;
        return new MessageListInteractor.State.FirstPageLoaded(firstPageMessagesAndMetaInfoObservable, new MessageListInteractor.PaginationState.Success(messagesAndMetaInfoBefore, aVar.d, aVar.b, bool2.booleanValue()));
    }
}

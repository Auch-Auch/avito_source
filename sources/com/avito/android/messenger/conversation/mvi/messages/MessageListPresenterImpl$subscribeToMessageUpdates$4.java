package com.avito.android.messenger.conversation.mvi.messages;

import com.avito.android.remote.model.messenger.message.LocalMessage;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u000b\u001a\u0001\u0012>\b\u0001\u0012:\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002j\u0002`\u0005 \b*\u001c\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002j\u0002`\u0005\u0018\u00010\u00010\u0001 \b*D\u0012>\b\u0001\u0012:\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002j\u0002`\u0005 \b*\u001c\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002j\u0002`\u0005\u0018\u00010\u00010\u0001\u0018\u00010\u00070\u00072$\u0010\u0006\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002j\u0002`\u00050\u00010\u0000H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lio/reactivex/Observable;", "", "Lkotlin/Pair;", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "Lru/avito/android/persistence/messenger/MessageMetaInfo;", "Lcom/avito/android/messenger/conversation/mvi/data/MessageAndMetaInfo;", "previousMessagesAndMetaInfo", "Lio/reactivex/ObservableSource;", "kotlin.jvm.PlatformType", "apply", "(Lio/reactivex/Observable;)Lio/reactivex/ObservableSource;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class MessageListPresenterImpl$subscribeToMessageUpdates$4<T, R> implements Function<Observable<List<? extends Pair<? extends LocalMessage, ? extends MessageMetaInfo>>>, ObservableSource<? extends List<? extends Pair<? extends LocalMessage, ? extends MessageMetaInfo>>>> {
    public final /* synthetic */ Scheduler a;

    public MessageListPresenterImpl$subscribeToMessageUpdates$4(Scheduler scheduler) {
        this.a = scheduler;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ ObservableSource<? extends List<? extends Pair<? extends LocalMessage, ? extends MessageMetaInfo>>> apply(Observable<List<? extends Pair<? extends LocalMessage, ? extends MessageMetaInfo>>> observable) {
        return apply((Observable<List<Pair<LocalMessage, MessageMetaInfo>>>) observable);
    }

    public final ObservableSource<? extends List<Pair<LocalMessage, MessageMetaInfo>>> apply(@NotNull Observable<List<Pair<LocalMessage, MessageMetaInfo>>> observable) {
        Intrinsics.checkNotNullParameter(observable, "previousMessagesAndMetaInfo");
        return observable.subscribeOn(this.a).observeOn(this.a);
    }
}

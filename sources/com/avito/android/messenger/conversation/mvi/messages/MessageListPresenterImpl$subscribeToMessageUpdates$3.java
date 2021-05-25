package com.avito.android.messenger.conversation.mvi.messages;

import com.avito.android.messenger.conversation.mvi.messages.MessageListInteractor;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u000b\u001aF\u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004j\u0002`\u00070\u0003 \b*\"\u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004j\u0002`\u00070\u0003\u0018\u00010\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$State$FirstPageLoaded;", "state", "Lio/reactivex/Observable;", "", "Lkotlin/Pair;", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "Lru/avito/android/persistence/messenger/MessageMetaInfo;", "Lcom/avito/android/messenger/conversation/mvi/data/MessageAndMetaInfo;", "kotlin.jvm.PlatformType", "apply", "(Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$State$FirstPageLoaded;)Lio/reactivex/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class MessageListPresenterImpl$subscribeToMessageUpdates$3<T, R> implements Function<MessageListInteractor.State.FirstPageLoaded, Observable<List<? extends Pair<? extends LocalMessage, ? extends MessageMetaInfo>>>> {
    public static final MessageListPresenterImpl$subscribeToMessageUpdates$3 INSTANCE = new MessageListPresenterImpl$subscribeToMessageUpdates$3();

    public final Observable<List<Pair<LocalMessage, MessageMetaInfo>>> apply(@NotNull MessageListInteractor.State.FirstPageLoaded firstPageLoaded) {
        Intrinsics.checkNotNullParameter(firstPageLoaded, "state");
        return firstPageLoaded.getPaginationState().getPreviousMessagesAndMetaInfoObservable();
    }
}

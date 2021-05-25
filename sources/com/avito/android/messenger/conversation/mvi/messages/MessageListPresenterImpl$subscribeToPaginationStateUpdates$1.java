package com.avito.android.messenger.conversation.mvi.messages;

import com.avito.android.messenger.conversation.mvi.messages.MessageListInteractor;
import io.reactivex.functions.BiPredicate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$State$FirstPageLoaded;", "prevState", "curState", "", "test", "(Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$State$FirstPageLoaded;Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$State$FirstPageLoaded;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class MessageListPresenterImpl$subscribeToPaginationStateUpdates$1<T1, T2> implements BiPredicate<MessageListInteractor.State.FirstPageLoaded, MessageListInteractor.State.FirstPageLoaded> {
    public static final MessageListPresenterImpl$subscribeToPaginationStateUpdates$1 INSTANCE = new MessageListPresenterImpl$subscribeToPaginationStateUpdates$1();

    public final boolean test(@NotNull MessageListInteractor.State.FirstPageLoaded firstPageLoaded, @NotNull MessageListInteractor.State.FirstPageLoaded firstPageLoaded2) {
        Intrinsics.checkNotNullParameter(firstPageLoaded, "prevState");
        Intrinsics.checkNotNullParameter(firstPageLoaded2, "curState");
        return Intrinsics.areEqual(firstPageLoaded.getPaginationState().getClass(), firstPageLoaded2.getPaginationState().getClass());
    }
}

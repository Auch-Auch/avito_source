package com.avito.android.messenger.conversation.mvi.messages;

import arrow.core.Option;
import arrow.core.OptionKt;
import com.avito.android.messenger.conversation.mvi.messages.MessageListInteractor;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$State$FirstPageLoaded;", "state", "Larrow/core/Option;", "", "kotlin.jvm.PlatformType", "apply", "(Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$State$FirstPageLoaded;)Larrow/core/Option;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class MessageListPresenterImpl$subscribeToMessageUpdates$5<T, R> implements Function<MessageListInteractor.State.FirstPageLoaded, Option<? extends Boolean>> {
    public static final MessageListPresenterImpl$subscribeToMessageUpdates$5 INSTANCE = new MessageListPresenterImpl$subscribeToMessageUpdates$5();

    public final Option<Boolean> apply(@NotNull MessageListInteractor.State.FirstPageLoaded firstPageLoaded) {
        Intrinsics.checkNotNullParameter(firstPageLoaded, "state");
        MessageListInteractor.PaginationState paginationState = firstPageLoaded.getPaginationState();
        Boolean bool = null;
        if (!(paginationState instanceof MessageListInteractor.PaginationState.Success)) {
            paginationState = null;
        }
        MessageListInteractor.PaginationState.Success success = (MessageListInteractor.PaginationState.Success) paginationState;
        if (success != null) {
            bool = Boolean.valueOf(success.getHasMorePages());
        }
        return OptionKt.toOption(bool);
    }
}

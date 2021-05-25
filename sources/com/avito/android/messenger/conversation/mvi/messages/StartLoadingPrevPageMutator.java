package com.avito.android.messenger.conversation.mvi.messages;

import androidx.annotation.VisibleForTesting;
import com.avito.android.messenger.channels.mvi.common.v2.Mutator;
import com.avito.android.messenger.conversation.mvi.messages.MessageListInteractor;
import com.avito.android.messenger.conversation.mvi.messages.MessageListInteractorImpl;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/StartLoadingPrevPageMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Mutator;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$State;)Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$State;", "", "d", "Ljava/lang/String;", "channelId", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractorImpl$Dependencies;", "e", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractorImpl$Dependencies;", "deps", "c", ChannelContext.Item.USER_ID, "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractorImpl$Dependencies;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
@VisibleForTesting(otherwise = 3)
public final class StartLoadingPrevPageMutator extends Mutator<MessageListInteractor.State> {
    public final String c;
    public final String d;
    public final MessageListInteractorImpl.Dependencies e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StartLoadingPrevPageMutator(@NotNull String str, @NotNull String str2, @NotNull MessageListInteractorImpl.Dependencies dependencies) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(dependencies, "deps");
        this.c = str;
        this.d = str2;
        this.e = dependencies;
    }

    @NotNull
    public MessageListInteractor.State invoke(@NotNull MessageListInteractor.State state) {
        Intrinsics.checkNotNullParameter(state, "oldState");
        if (!(state instanceof MessageListInteractor.State.FirstPageLoaded)) {
            return state;
        }
        MessageListInteractor.State.FirstPageLoaded firstPageLoaded = (MessageListInteractor.State.FirstPageLoaded) state;
        if ((!(firstPageLoaded.getPaginationState() instanceof MessageListInteractor.PaginationState.Success) && !(firstPageLoaded.getPaginationState() instanceof MessageListInteractor.PaginationState.Error)) || firstPageLoaded.getPaginationState().getPreviousMessagesEndTimestamp() == null) {
            return state;
        }
        MessageListInteractor.PaginationState paginationState = firstPageLoaded.getPaginationState();
        MessageListInteractor.State.FirstPageLoaded copy$default = MessageListInteractor.State.FirstPageLoaded.copy$default(firstPageLoaded, null, new MessageListInteractor.PaginationState.InProgress(paginationState.getPreviousMessagesAndMetaInfoObservable(), paginationState.getPreviousMessagesEndTimestamp(), paginationState.getRequestedPrevMessagesCount()), 1, null);
        this.e.getDispatchLoadPrevPageMutator().invoke(this.c, this.d);
        return copy$default;
    }
}

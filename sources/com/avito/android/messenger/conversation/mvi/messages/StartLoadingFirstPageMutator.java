package com.avito.android.messenger.conversation.mvi.messages;

import androidx.annotation.VisibleForTesting;
import com.avito.android.messenger.channels.mvi.common.v2.Mutator;
import com.avito.android.messenger.conversation.mvi.messages.MessageListInteractor;
import com.avito.android.messenger.conversation.mvi.messages.MessageListInteractorImpl;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/StartLoadingFirstPageMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Mutator;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$State;)Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$State;", "", "c", "Ljava/lang/String;", ChannelContext.Item.USER_ID, "d", "channelId", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractorImpl$Dependencies;", "e", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractorImpl$Dependencies;", "deps", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractorImpl$Dependencies;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
@VisibleForTesting(otherwise = 3)
public final class StartLoadingFirstPageMutator extends Mutator<MessageListInteractor.State> {
    public final String c;
    public final String d;
    public final MessageListInteractorImpl.Dependencies e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StartLoadingFirstPageMutator(@NotNull String str, @NotNull String str2, @NotNull MessageListInteractorImpl.Dependencies dependencies) {
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
        if (state instanceof MessageListInteractor.State.FirstPageLoadingInProgress) {
            return state;
        }
        MessageListInteractor.State.FirstPageLoadingInProgress firstPageLoadingInProgress = MessageListInteractor.State.FirstPageLoadingInProgress.INSTANCE;
        this.e.getDispatchLoadFirstPageMutator().invoke(this.c, this.d);
        return firstPageLoadingInProgress;
    }
}

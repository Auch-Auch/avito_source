package com.avito.android.messenger.conversation.mvi.messages;

import com.avito.android.messenger.conversation.mvi.messages.MessageListView;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\t\u001a\u00020\b8\u0016@\u0016XD¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"com/avito/android/messenger/conversation/mvi/messages/MessageListView$State$Companion$DEFAULT$1", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListView$State;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListView$ListState$LoadingInProgress;", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListView$ListState$LoadingInProgress;", "getListState", "()Lcom/avito/android/messenger/conversation/mvi/messages/MessageListView$ListState$LoadingInProgress;", "listState", "", "paginationIsEnabled", "Z", "getPaginationIsEnabled", "()Z", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessageListView$State$Companion$DEFAULT$1 implements MessageListView.State {
    @NotNull
    public final MessageListView.ListState.LoadingInProgress a = MessageListView.ListState.LoadingInProgress.INSTANCE;

    @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListView.State
    public boolean getPaginationIsEnabled() {
        return false;
    }

    @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListView.State
    @NotNull
    public MessageListView.ListState.LoadingInProgress getListState() {
        return this.a;
    }
}

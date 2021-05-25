package com.avito.android.messenger.conversation.mvi.new_messages;

import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import com.avito.android.messenger.channels.mvi.common.MviEntity;
import com.avito.android.messenger.conversation.ChannelItem;
import com.avito.android.messenger.conversation.mvi.new_messages.NewMessagesView;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH&¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00108&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/new_messages/NewMessagesPresenter;", "Lcom/avito/android/messenger/channels/mvi/common/MviEntity;", "Lcom/avito/android/messenger/conversation/mvi/new_messages/NewMessagesView$State;", "Landroidx/lifecycle/LifecycleObserver;", "", "onInitialScrollPerformed", "()V", "", "isScrolledToBottom", "onScrolledToBottomChanged", "(Z)V", "Lcom/avito/android/messenger/conversation/ChannelItem;", "oldBottomItem", "newBottomItem", "onNewListItems", "(Lcom/avito/android/messenger/conversation/ChannelItem;Lcom/avito/android/messenger/conversation/ChannelItem;)V", "Landroidx/lifecycle/LiveData;", "getScrollToBottomStream", "()Landroidx/lifecycle/LiveData;", "scrollToBottomStream", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface NewMessagesPresenter extends MviEntity<NewMessagesView.State>, LifecycleObserver {
    @NotNull
    LiveData<Unit> getScrollToBottomStream();

    void onInitialScrollPerformed();

    void onNewListItems(@NotNull ChannelItem channelItem, @NotNull ChannelItem channelItem2);

    void onScrolledToBottomChanged(boolean z);
}

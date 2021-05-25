package com.avito.android.messenger.conversation.adapter.spam_actions;

import com.avito.android.messenger.conversation.ChannelItem;
import com.avito.konveyor.blueprint.ItemPresenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/spam_actions/SpamActionsPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/messenger/conversation/adapter/spam_actions/SpamActionsView;", "Lcom/avito/android/messenger/conversation/ChannelItem$SpamActions;", "Listener", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface SpamActionsPresenter extends ItemPresenter<SpamActionsView, ChannelItem.SpamActions> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/spam_actions/SpamActionsPresenter$Listener;", "", "Lcom/avito/android/messenger/conversation/ChannelItem$SpamActions;", "item", "", "isSpam", "", "onSpamActionClicked", "(Lcom/avito/android/messenger/conversation/ChannelItem$SpamActions;Z)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public interface Listener {
        void onSpamActionClicked(@NotNull ChannelItem.SpamActions spamActions, boolean z);
    }
}

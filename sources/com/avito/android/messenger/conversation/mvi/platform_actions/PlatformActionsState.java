package com.avito.android.messenger.conversation.mvi.platform_actions;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u001a\u0010\u0006\u001a\u00060\u0002j\u0002`\u00038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\n\u001a\u00060\u0001j\u0002`\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsState;", "", "", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/ChannelDataId;", "getId", "()J", "id", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsStateKey;", "getKey", "()Ljava/lang/Object;", "key", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface PlatformActionsState {
    long getId();

    @NotNull
    Object getKey();
}

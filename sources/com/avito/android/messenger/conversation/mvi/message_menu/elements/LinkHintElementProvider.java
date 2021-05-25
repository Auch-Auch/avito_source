package com.avito.android.messenger.conversation.mvi.message_menu.elements;

import com.avito.android.messenger.conversation.mvi.message_menu.MenuElement;
import com.avito.android.messenger.conversation.mvi.message_menu.MenuElementProvider;
import com.avito.android.messenger.conversation.mvi.message_menu.MessageContextData;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/LinkHintElementProvider;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MenuElementProvider;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;", "contextData", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MenuElement;", "getMenuElement", "(Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;)Lcom/avito/android/messenger/conversation/mvi/message_menu/MenuElement;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class LinkHintElementProvider implements MenuElementProvider {
    @Override // com.avito.android.messenger.conversation.mvi.message_menu.MenuElementProvider
    @Nullable
    public MenuElement getMenuElement(@NotNull MessageContextData messageContextData) {
        String str;
        Intrinsics.checkNotNullParameter(messageContextData, "contextData");
        if (messageContextData instanceof MessageContextData.Item) {
            str = ((MessageContextData.Item) messageContextData).getUrl();
        } else if (messageContextData instanceof MessageContextData.Link) {
            str = ((MessageContextData.Link) messageContextData).getUrl();
        } else if (messageContextData instanceof MessageContextData.LinkInText) {
            str = ((MessageContextData.LinkInText) messageContextData).getUrl();
        } else if (messageContextData instanceof MessageContextData.Image) {
            str = ((MessageContextData.Image) messageContextData).getUrl();
        } else if (!(messageContextData instanceof MessageContextData.LocalImage) && !(messageContextData instanceof MessageContextData.Text) && !(messageContextData instanceof MessageContextData.Location) && !(messageContextData instanceof MessageContextData.File)) {
            throw new NoWhenBranchMatchedException();
        } else {
            str = null;
        }
        if (str != null) {
            return new MenuElement.Hint(new Regex(".(?!$)").replace(str, "$0​"));
        }
        return null;
    }
}

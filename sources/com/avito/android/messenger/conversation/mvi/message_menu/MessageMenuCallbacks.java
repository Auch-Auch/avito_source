package com.avito.android.messenger.conversation.mvi.message_menu;

import android.content.ClipData;
import androidx.lifecycle.LiveData;
import com.avito.android.messenger.conversation.mvi.message_menu.elements.CopyToClipboardElementProvider;
import com.avito.android.messenger.conversation.mvi.message_menu.elements.OpenInBrowserElementProvider;
import com.avito.android.messenger.conversation.mvi.message_menu.elements.RetrySendingMessageElementProvider;
import com.avito.android.messenger.conversation.mvi.message_menu.elements.delete_local.DeleteLocalMessageElementProvider;
import com.avito.android.messenger.conversation.mvi.message_menu.elements.delete_remote.DeleteRemoteMessageElementProvider;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\tR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuCallbacks;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/CopyToClipboardElementProvider$Callback;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/OpenInBrowserElementProvider$Callback;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/delete_local/DeleteLocalMessageElementProvider$Callback;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/RetrySendingMessageElementProvider$Callback;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/delete_remote/DeleteRemoteMessageElementProvider$Callback;", "Landroidx/lifecycle/LiveData;", "", "getToastStream", "()Landroidx/lifecycle/LiveData;", "toastStream", "Landroid/content/ClipData;", "getCopyToClipboardStream", "copyToClipboardStream", "getUrlNavigationStream", "urlNavigationStream", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface MessageMenuCallbacks extends CopyToClipboardElementProvider.Callback, OpenInBrowserElementProvider.Callback, DeleteLocalMessageElementProvider.Callback, RetrySendingMessageElementProvider.Callback, DeleteRemoteMessageElementProvider.Callback {
    @NotNull
    LiveData<ClipData> getCopyToClipboardStream();

    @NotNull
    LiveData<String> getToastStream();

    @NotNull
    LiveData<String> getUrlNavigationStream();
}

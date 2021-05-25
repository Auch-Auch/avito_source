package com.avito.android.messenger.conversation.adapter.system;

import com.avito.android.messenger.conversation.ChannelItem;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.util.Logs;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/system/SystemTextPresenterImpl;", "Lcom/avito/android/messenger/conversation/adapter/system/SystemTextPresenter;", "Lcom/avito/android/messenger/conversation/adapter/system/SystemMessageTextView;", "view", "Lcom/avito/android/messenger/conversation/ChannelItem$Message;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/messenger/conversation/adapter/system/SystemMessageTextView;Lcom/avito/android/messenger/conversation/ChannelItem$Message;I)V", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class SystemTextPresenterImpl implements SystemTextPresenter {
    public void bindView(@NotNull SystemMessageTextView systemMessageTextView, @NotNull ChannelItem.Message message, int i) {
        Intrinsics.checkNotNullParameter(systemMessageTextView, "view");
        Intrinsics.checkNotNullParameter(message, "item");
        MessageBody body = message.getBodyOrBubble().getBody();
        if (!(body instanceof MessageBody.SystemMessageBody.Text)) {
            body = null;
        }
        MessageBody.SystemMessageBody.Text text = (MessageBody.SystemMessageBody.Text) body;
        if (text != null) {
            systemMessageTextView.setText(text.getText());
            systemMessageTextView.setDate(message.getDate());
            systemMessageTextView.setTime(message.getTime());
            return;
        }
        systemMessageTextView.setText(null);
        systemMessageTextView.setDate(message.getDate());
        systemMessageTextView.setTime(message.getTime());
        Logs.debug$default("SystemTextPresenter", "Unsupported bodyOrBubble: " + message.getBodyOrBubble(), null, 4, null);
    }
}

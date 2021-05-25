package com.avito.android.messenger.conversation.adapter.location;

import com.avito.android.image_loader.Picture;
import com.avito.android.messenger.conversation.adapter.Highlightable;
import com.avito.android.messenger.conversation.adapter.MessageViewClicks;
import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0006\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/location/LocationMessageView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/messenger/conversation/adapter/Highlightable;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewClicks;", "Lcom/avito/android/image_loader/Picture;", "picture", "", "setMapImage", "(Lcom/avito/android/image_loader/Picture;)V", "", "text", "setText", "(Ljava/lang/CharSequence;)V", "showCopiedText", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface LocationMessageView extends ItemView, Highlightable, MessageViewClicks {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull LocationMessageView locationMessageView) {
            ItemView.DefaultImpls.onUnbind(locationMessageView);
        }
    }

    void setMapImage(@NotNull Picture picture);

    void setText(@NotNull CharSequence charSequence);

    void showCopiedText();
}

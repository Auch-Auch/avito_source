package com.avito.android.messenger.conversation.adapter.platform.from_user.text;

import android.content.Context;
import android.widget.TextView;
import com.avito.android.messenger.conversation.adapter.Highlightable;
import com.avito.android.messenger.conversation.adapter.MessageViewClicks;
import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J#\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\t\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/platform/from_user/text/PlatformTextMessageFromUserView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/messenger/conversation/adapter/Highlightable;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewClicks;", "", "charSequence", "Landroid/widget/TextView$BufferType;", "bufferType", "", "setText", "(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V", "", "stringResId", "(I)V", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface PlatformTextMessageFromUserView extends ItemView, Highlightable, MessageViewClicks {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull PlatformTextMessageFromUserView platformTextMessageFromUserView) {
            ItemView.DefaultImpls.onUnbind(platformTextMessageFromUserView);
        }

        public static /* synthetic */ void setText$default(PlatformTextMessageFromUserView platformTextMessageFromUserView, CharSequence charSequence, TextView.BufferType bufferType, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    bufferType = TextView.BufferType.SPANNABLE;
                }
                platformTextMessageFromUserView.setText(charSequence, bufferType);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setText");
        }
    }

    @NotNull
    Context getContext();

    void setText(int i);

    void setText(@Nullable CharSequence charSequence, @NotNull TextView.BufferType bufferType);
}

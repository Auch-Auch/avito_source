package com.avito.android.messenger.conversation.adapter.link;

import com.avito.android.image_loader.Picture;
import com.avito.android.messenger.conversation.adapter.Highlightable;
import com.avito.android.messenger.conversation.adapter.MessageViewClicks;
import com.avito.konveyor.blueprint.ItemView;
import com.facebook.share.internal.MessengerShareContentUtility;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\tH&¢\u0006\u0004\b\u000f\u0010\u0010J3\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\t2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0006H&¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/link/LinkSnippetMessageView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/messenger/conversation/adapter/Highlightable;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewClicks;", "Lcom/avito/android/image_loader/Picture;", "picture", "", "setImage", "(Lcom/avito/android/image_loader/Picture;)V", "", "title", MessengerShareContentUtility.SUBTITLE, "setText", "(Ljava/lang/String;Ljava/lang/String;)V", "domain", "setDomain", "(Ljava/lang/String;)V", "url", "Lkotlin/Function0;", "onOpenInBrowserClick", "onCopyClick", "showLinkMenuLegacy", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "showCopiedMessage", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface LinkSnippetMessageView extends ItemView, Highlightable, MessageViewClicks {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull LinkSnippetMessageView linkSnippetMessageView) {
            ItemView.DefaultImpls.onUnbind(linkSnippetMessageView);
        }

        public static /* synthetic */ void setText$default(LinkSnippetMessageView linkSnippetMessageView, String str, String str2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str2 = null;
                }
                linkSnippetMessageView.setText(str, str2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setText");
        }
    }

    void setDomain(@NotNull String str);

    void setImage(@Nullable Picture picture);

    void setText(@NotNull String str, @Nullable String str2);

    void showCopiedMessage();

    void showLinkMenuLegacy(@NotNull String str, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02);
}

package com.avito.android.messenger.conversation.adapter.typing;

import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.messenger.conversation.ChannelItem;
import com.avito.android.remote.model.Image;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/typing/TypingIndicatorPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/messenger/conversation/adapter/typing/TypingIndicatorView;", "Lcom/avito/android/messenger/conversation/ChannelItem$TypingIndicator;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/messenger/conversation/adapter/typing/TypingIndicatorView;Lcom/avito/android/messenger/conversation/ChannelItem$TypingIndicator;I)V", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class TypingIndicatorPresenter implements ItemPresenter<TypingIndicatorView, ChannelItem.TypingIndicator> {

    public static final class a extends Lambda implements Function0<Unit> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            return Unit.INSTANCE;
        }
    }

    public void bindView(@NotNull TypingIndicatorView typingIndicatorView, @NotNull ChannelItem.TypingIndicator typingIndicator, int i) {
        Intrinsics.checkNotNullParameter(typingIndicatorView, "view");
        Intrinsics.checkNotNullParameter(typingIndicator, "item");
        Image avatar = typingIndicator.getAvatar();
        typingIndicatorView.setAvatar(avatar != null ? AvitoPictureKt.pictureOf$default(avatar, false, 0.0f, 0.0f, null, 28, null) : null);
        typingIndicatorView.setAvatarClickListener(a.a);
        typingIndicatorView.startAnimations();
    }
}

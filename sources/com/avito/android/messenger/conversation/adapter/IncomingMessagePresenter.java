package com.avito.android.messenger.conversation.adapter;

import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.messenger.conversation.ChannelItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import dagger.Lazy;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/messenger/conversation/adapter/IncomingMessageView;", "Lcom/avito/android/messenger/conversation/ChannelItem$Message;", "Impl", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface IncomingMessagePresenter extends ItemPresenter<IncomingMessageView, ChannelItem.Message> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0011\u0010\u0010\u001a\r\u0012\t\u0012\u00070\f¢\u0006\u0002\b\r0\u000b\u0012\u0011\u0010\u0013\u001a\r\u0012\t\u0012\u00070\u0011¢\u0006\u0002\b\r0\u000b¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR!\u0010\u0010\u001a\r\u0012\t\u0012\u00070\f¢\u0006\u0002\b\r0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR!\u0010\u0013\u001a\r\u0012\t\u0012\u00070\u0011¢\u0006\u0002\b\r0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter$Impl;", "Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;", "Lcom/avito/android/messenger/conversation/adapter/IncomingMessageView;", "view", "Lcom/avito/android/messenger/conversation/ChannelItem$Message;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/messenger/conversation/adapter/IncomingMessageView;Lcom/avito/android/messenger/conversation/ChannelItem$Message;I)V", "Ldagger/Lazy;", "Lcom/avito/android/messenger/conversation/adapter/MessageClickListener;", "Lkotlin/jvm/JvmSuppressWildcards;", AuthSource.BOOKING_ORDER, "Ldagger/Lazy;", "messageClickListener", "Lcom/avito/android/messenger/conversation/adapter/MessageAvatarClickListener;", "c", "avatarClickListener", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "lastHighlightedId", "<init>", "(Ldagger/Lazy;Ldagger/Lazy;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl implements IncomingMessagePresenter {
        public String a;
        public final Lazy<MessageClickListener> b;
        public final Lazy<MessageAvatarClickListener> c;

        /* compiled from: kotlin-style lambda group */
        public static final class a extends Lambda implements Function0<Unit> {
            public final /* synthetic */ int a;
            public final /* synthetic */ Object b;
            public final /* synthetic */ Object c;
            public final /* synthetic */ Object d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(int i, Object obj, Object obj2, Object obj3) {
                super(0);
                this.a = i;
                this.b = obj;
                this.c = obj2;
                this.d = obj3;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                int i = this.a;
                if (i == 0) {
                    ((MessageClickListener) ((Impl) this.b).b.get()).onMessageBodyClick((ChannelItem.Message) this.c);
                    return Unit.INSTANCE;
                } else if (i == 1) {
                    ((MessageAvatarClickListener) ((Impl) this.b).c.get()).onAvatarClicked((ChannelItem.Message) this.c);
                    return Unit.INSTANCE;
                } else {
                    throw null;
                }
            }
        }

        public static final class b extends Lambda implements Function0<Boolean> {
            public final /* synthetic */ Impl a;
            public final /* synthetic */ ChannelItem.Message b;
            public final /* synthetic */ IncomingMessageView c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(Impl impl, ChannelItem.Message message, IncomingMessageView incomingMessageView) {
                super(0);
                this.a = impl;
                this.b = message;
                this.c = incomingMessageView;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public Boolean invoke() {
                return Boolean.valueOf(((MessageClickListener) this.a.b.get()).onMessageLongClick(this.b));
            }
        }

        @Inject
        public Impl(@NotNull Lazy<MessageClickListener> lazy, @NotNull Lazy<MessageAvatarClickListener> lazy2) {
            Intrinsics.checkNotNullParameter(lazy, "messageClickListener");
            Intrinsics.checkNotNullParameter(lazy2, "avatarClickListener");
            this.b = lazy;
            this.c = lazy2;
        }

        public void bindView(@NotNull IncomingMessageView incomingMessageView, @NotNull ChannelItem.Message message, int i) {
            Intrinsics.checkNotNullParameter(incomingMessageView, "view");
            Intrinsics.checkNotNullParameter(message, "item");
            boolean z = false;
            incomingMessageView.setClickListener(new a(0, this, message, incomingMessageView));
            incomingMessageView.setLongClickListener(new b(this, message, incomingMessageView));
            incomingMessageView.setDate(message.getDate());
            incomingMessageView.setTime(message.getTime());
            Image avatar = message.getAvatar();
            incomingMessageView.setAvatar(avatar != null ? AvitoPictureKt.pictureOf$default(avatar, false, 0.0f, 0.0f, null, 28, null) : null);
            incomingMessageView.setAvatarClickListener(new a(1, this, message, incomingMessageView));
            ChannelItem.GroupFlags groupFlags = message.getGroupFlags();
            if (groupFlags != null && groupFlags.isAtUserGroupStart() && !groupFlags.isAtDateGroupStart() && !groupFlags.isAfterSystemMessage() && !groupFlags.isFirstNewMessage()) {
                z = true;
            }
            incomingMessageView.showGroupDivider(z);
            if (message.getHighlight() && (incomingMessageView instanceof Highlightable) && (!Intrinsics.areEqual(this.a, message.getStringId()))) {
                ((Highlightable) incomingMessageView).highlight(true);
                this.a = message.getStringId();
            }
        }
    }
}

package com.avito.android.messenger.conversation.adapter;

import com.avito.android.messenger.conversation.ChannelItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import dagger.Lazy;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/OutgoingMessagePresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/messenger/conversation/adapter/OutgoingMessageView;", "Lcom/avito/android/messenger/conversation/ChannelItem$Message;", "Impl", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface OutgoingMessagePresenter extends ItemPresenter<OutgoingMessageView, ChannelItem.Message> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/OutgoingMessagePresenter$Impl;", "Lcom/avito/android/messenger/conversation/adapter/OutgoingMessagePresenter;", "Lcom/avito/android/messenger/conversation/adapter/OutgoingMessageView;", "view", "Lcom/avito/android/messenger/conversation/ChannelItem$Message;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/messenger/conversation/adapter/OutgoingMessageView;Lcom/avito/android/messenger/conversation/ChannelItem$Message;I)V", "Ldagger/Lazy;", "Lcom/avito/android/messenger/conversation/adapter/MessageClickListener;", AuthSource.BOOKING_ORDER, "Ldagger/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "lastHighlightedId", "<init>", "(Ldagger/Lazy;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl implements OutgoingMessagePresenter {
        public String a;
        public final Lazy<MessageClickListener> b;

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
            /* JADX WARNING: Code restructure failed: missing block: B:11:0x0026, code lost:
                if (r1 != false) goto L_0x0028;
             */
            @Override // kotlin.jvm.functions.Function0
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final kotlin.Unit invoke() {
                /*
                    r4 = this;
                    int r0 = r4.a
                    r1 = 0
                    r2 = 1
                    if (r0 == 0) goto L_0x0042
                    if (r0 != r2) goto L_0x0040
                    java.lang.Object r0 = r4.c
                    com.avito.android.messenger.conversation.ChannelItem$Message r0 = (com.avito.android.messenger.conversation.ChannelItem.Message) r0
                    com.avito.android.component.message_status.MessageDeliveryStatus r0 = r0.getStatus()
                    com.avito.android.component.message_status.MessageDeliveryStatus r3 = com.avito.android.component.message_status.MessageDeliveryStatus.ERROR
                    if (r0 != r3) goto L_0x0016
                    r0 = 1
                    goto L_0x0017
                L_0x0016:
                    r0 = 0
                L_0x0017:
                    if (r0 != 0) goto L_0x0028
                    java.lang.Object r0 = r4.c
                    com.avito.android.messenger.conversation.ChannelItem$Message r0 = (com.avito.android.messenger.conversation.ChannelItem.Message) r0
                    com.avito.android.component.message_status.MessageDeliveryStatus r0 = r0.getStatus()
                    com.avito.android.component.message_status.MessageDeliveryStatus r3 = com.avito.android.component.message_status.MessageDeliveryStatus.SENDING
                    if (r0 != r3) goto L_0x0026
                    r1 = 1
                L_0x0026:
                    if (r1 == 0) goto L_0x003d
                L_0x0028:
                    java.lang.Object r0 = r4.b
                    com.avito.android.messenger.conversation.adapter.OutgoingMessagePresenter$Impl r0 = (com.avito.android.messenger.conversation.adapter.OutgoingMessagePresenter.Impl) r0
                    dagger.Lazy r0 = com.avito.android.messenger.conversation.adapter.OutgoingMessagePresenter.Impl.access$getListener$p(r0)
                    java.lang.Object r0 = r0.get()
                    com.avito.android.messenger.conversation.adapter.MessageClickListener r0 = (com.avito.android.messenger.conversation.adapter.MessageClickListener) r0
                    java.lang.Object r1 = r4.c
                    com.avito.android.messenger.conversation.ChannelItem$Message r1 = (com.avito.android.messenger.conversation.ChannelItem.Message) r1
                    r0.onMessageErrorClick(r1)
                L_0x003d:
                    kotlin.Unit r0 = kotlin.Unit.INSTANCE
                    return r0
                L_0x0040:
                    r0 = 0
                    throw r0
                L_0x0042:
                    java.lang.Object r0 = r4.c
                    com.avito.android.messenger.conversation.ChannelItem$Message r0 = (com.avito.android.messenger.conversation.ChannelItem.Message) r0
                    com.avito.android.component.message_status.MessageDeliveryStatus r0 = r0.getStatus()
                    com.avito.android.component.message_status.MessageDeliveryStatus r3 = com.avito.android.component.message_status.MessageDeliveryStatus.ERROR
                    if (r0 != r3) goto L_0x0050
                    r0 = 1
                    goto L_0x0051
                L_0x0050:
                    r0 = 0
                L_0x0051:
                    if (r0 != 0) goto L_0x0079
                    java.lang.Object r0 = r4.c
                    com.avito.android.messenger.conversation.ChannelItem$Message r0 = (com.avito.android.messenger.conversation.ChannelItem.Message) r0
                    com.avito.android.component.message_status.MessageDeliveryStatus r0 = r0.getStatus()
                    com.avito.android.component.message_status.MessageDeliveryStatus r3 = com.avito.android.component.message_status.MessageDeliveryStatus.SENDING
                    if (r0 != r3) goto L_0x0060
                    r1 = 1
                L_0x0060:
                    if (r1 == 0) goto L_0x0063
                    goto L_0x0079
                L_0x0063:
                    java.lang.Object r0 = r4.b
                    com.avito.android.messenger.conversation.adapter.OutgoingMessagePresenter$Impl r0 = (com.avito.android.messenger.conversation.adapter.OutgoingMessagePresenter.Impl) r0
                    dagger.Lazy r0 = com.avito.android.messenger.conversation.adapter.OutgoingMessagePresenter.Impl.access$getListener$p(r0)
                    java.lang.Object r0 = r0.get()
                    com.avito.android.messenger.conversation.adapter.MessageClickListener r0 = (com.avito.android.messenger.conversation.adapter.MessageClickListener) r0
                    java.lang.Object r1 = r4.c
                    com.avito.android.messenger.conversation.ChannelItem$Message r1 = (com.avito.android.messenger.conversation.ChannelItem.Message) r1
                    r0.onMessageBodyClick(r1)
                    goto L_0x008e
                L_0x0079:
                    java.lang.Object r0 = r4.b
                    com.avito.android.messenger.conversation.adapter.OutgoingMessagePresenter$Impl r0 = (com.avito.android.messenger.conversation.adapter.OutgoingMessagePresenter.Impl) r0
                    dagger.Lazy r0 = com.avito.android.messenger.conversation.adapter.OutgoingMessagePresenter.Impl.access$getListener$p(r0)
                    java.lang.Object r0 = r0.get()
                    com.avito.android.messenger.conversation.adapter.MessageClickListener r0 = (com.avito.android.messenger.conversation.adapter.MessageClickListener) r0
                    java.lang.Object r1 = r4.c
                    com.avito.android.messenger.conversation.ChannelItem$Message r1 = (com.avito.android.messenger.conversation.ChannelItem.Message) r1
                    r0.onMessageErrorClick(r1)
                L_0x008e:
                    kotlin.Unit r0 = kotlin.Unit.INSTANCE
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.adapter.OutgoingMessagePresenter.Impl.a.invoke():java.lang.Object");
            }
        }

        public static final class b extends Lambda implements Function0<Boolean> {
            public final /* synthetic */ Impl a;
            public final /* synthetic */ ChannelItem.Message b;
            public final /* synthetic */ OutgoingMessageView c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(Impl impl, ChannelItem.Message message, OutgoingMessageView outgoingMessageView) {
                super(0);
                this.a = impl;
                this.b = message;
                this.c = outgoingMessageView;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public Boolean invoke() {
                return Boolean.valueOf(((MessageClickListener) this.a.b.get()).onMessageLongClick(this.b));
            }
        }

        @Inject
        public Impl(@NotNull Lazy<MessageClickListener> lazy) {
            Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.b = lazy;
        }

        public void bindView(@NotNull OutgoingMessageView outgoingMessageView, @NotNull ChannelItem.Message message, int i) {
            Intrinsics.checkNotNullParameter(outgoingMessageView, "view");
            Intrinsics.checkNotNullParameter(message, "item");
            outgoingMessageView.setClickListener(new a(0, this, message, outgoingMessageView));
            outgoingMessageView.setLongClickListener(new b(this, message, outgoingMessageView));
            outgoingMessageView.setDate(message.getDate());
            outgoingMessageView.setTime(message.getTime());
            outgoingMessageView.setStatus(message.getStatus());
            outgoingMessageView.setStatusClickListener(new a(1, this, message, outgoingMessageView));
            ChannelItem.GroupFlags groupFlags = message.getGroupFlags();
            outgoingMessageView.showGroupDivider(groupFlags != null && groupFlags.isAtUserGroupStart() && !groupFlags.isAtDateGroupStart() && !groupFlags.isAfterSystemMessage() && !groupFlags.isFirstNewMessage());
            if (message.getHighlight() && (outgoingMessageView instanceof Highlightable) && (!Intrinsics.areEqual(this.a, message.getStringId()))) {
                ((Highlightable) outgoingMessageView).highlight(false);
                this.a = message.getStringId();
            }
        }
    }
}

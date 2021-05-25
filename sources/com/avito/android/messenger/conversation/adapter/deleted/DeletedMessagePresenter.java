package com.avito.android.messenger.conversation.adapter.deleted;

import com.avito.android.messenger.conversation.ChannelItem;
import com.avito.android.messenger.conversation.adapter.IncomingMessagePresenter;
import com.avito.android.messenger.conversation.adapter.IncomingMessageView;
import com.avito.android.messenger.conversation.adapter.MessageViewClicks;
import com.avito.android.messenger.conversation.adapter.OutgoingMessagePresenter;
import com.avito.android.messenger.conversation.adapter.OutgoingMessageView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.util.Logs;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/deleted/DeletedMessagePresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/messenger/conversation/adapter/deleted/DeletedMessageView;", "Lcom/avito/android/messenger/conversation/ChannelItem$Message;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/messenger/conversation/adapter/deleted/DeletedMessageView;Lcom/avito/android/messenger/conversation/ChannelItem$Message;I)V", "Lcom/avito/android/messenger/conversation/adapter/OutgoingMessagePresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/conversation/adapter/OutgoingMessagePresenter;", "outgoingMessagePresenter", "Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;", "incomingMessagePresenter", "<init>", "(Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;Lcom/avito/android/messenger/conversation/adapter/OutgoingMessagePresenter;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class DeletedMessagePresenter implements ItemPresenter<DeletedMessageView, ChannelItem.Message> {
    public final IncomingMessagePresenter a;
    public final OutgoingMessagePresenter b;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ DeletedMessageView a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(DeletedMessageView deletedMessageView) {
            super(0);
            this.a = deletedMessageView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.showInfoPopup();
            return Unit.INSTANCE;
        }
    }

    @Inject
    public DeletedMessagePresenter(@NotNull IncomingMessagePresenter incomingMessagePresenter, @NotNull OutgoingMessagePresenter outgoingMessagePresenter) {
        Intrinsics.checkNotNullParameter(incomingMessagePresenter, "incomingMessagePresenter");
        Intrinsics.checkNotNullParameter(outgoingMessagePresenter, "outgoingMessagePresenter");
        this.a = incomingMessagePresenter;
        this.b = outgoingMessagePresenter;
    }

    public void bindView(@NotNull DeletedMessageView deletedMessageView, @NotNull ChannelItem.Message message, int i) {
        Intrinsics.checkNotNullParameter(deletedMessageView, "view");
        Intrinsics.checkNotNullParameter(message, "item");
        if (deletedMessageView instanceof IncomingMessageView) {
            this.a.bindView(deletedMessageView, message, i);
        } else if (deletedMessageView instanceof OutgoingMessageView) {
            this.b.bindView(deletedMessageView, message, i);
        }
        MessageBody body = message.getBodyOrBubble().getBody();
        if (!(body instanceof MessageBody.Deleted)) {
            body = null;
        }
        MessageBody.Deleted deleted = (MessageBody.Deleted) body;
        if (deleted != null) {
            deletedMessageView.setText(deleted.getText());
            if (!message.isMy() && (deletedMessageView instanceof MessageViewClicks)) {
                ((MessageViewClicks) deletedMessageView).setClickListener(new a(deletedMessageView));
                return;
            }
            return;
        }
        deletedMessageView.setText("");
        Logs.debug$default("DeletedMessagePresenter", "Unsupported bodyOrBubble: " + message.getBodyOrBubble(), null, 4, null);
    }
}

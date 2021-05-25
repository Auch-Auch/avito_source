package com.avito.android.messenger.conversation.adapter.link;

import com.avito.android.messenger.conversation.ChannelItem;
import com.avito.android.messenger.conversation.adapter.IncomingMessagePresenter;
import com.avito.android.messenger.conversation.adapter.IncomingMessageView;
import com.avito.android.messenger.conversation.adapter.OutgoingMessagePresenter;
import com.avito.android.messenger.conversation.adapter.OutgoingMessageView;
import com.avito.android.messenger.conversation.adapter.image.MessagePictureProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.util.Logs;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001f\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/link/LinkSnippetMessagePresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/messenger/conversation/adapter/link/LinkSnippetMessageView;", "Lcom/avito/android/messenger/conversation/ChannelItem$Message;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/messenger/conversation/adapter/link/LinkSnippetMessageView;Lcom/avito/android/messenger/conversation/ChannelItem$Message;I)V", "Lcom/avito/android/messenger/conversation/adapter/OutgoingMessagePresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/conversation/adapter/OutgoingMessagePresenter;", "outgoingMessagePresenter", "Lcom/avito/android/messenger/conversation/adapter/image/MessagePictureProvider;", "c", "Lcom/avito/android/messenger/conversation/adapter/image/MessagePictureProvider;", "pictureProvider", "Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;", "incomingMessagePresenter", "<init>", "(Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;Lcom/avito/android/messenger/conversation/adapter/OutgoingMessagePresenter;Lcom/avito/android/messenger/conversation/adapter/image/MessagePictureProvider;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class LinkSnippetMessagePresenter implements ItemPresenter<LinkSnippetMessageView, ChannelItem.Message> {
    public final IncomingMessagePresenter a;
    public final OutgoingMessagePresenter b;
    public final MessagePictureProvider c;

    public LinkSnippetMessagePresenter(@NotNull IncomingMessagePresenter incomingMessagePresenter, @NotNull OutgoingMessagePresenter outgoingMessagePresenter, @NotNull MessagePictureProvider messagePictureProvider) {
        Intrinsics.checkNotNullParameter(incomingMessagePresenter, "incomingMessagePresenter");
        Intrinsics.checkNotNullParameter(outgoingMessagePresenter, "outgoingMessagePresenter");
        Intrinsics.checkNotNullParameter(messagePictureProvider, "pictureProvider");
        this.a = incomingMessagePresenter;
        this.b = outgoingMessagePresenter;
        this.c = messagePictureProvider;
    }

    public void bindView(@NotNull LinkSnippetMessageView linkSnippetMessageView, @NotNull ChannelItem.Message message, int i) {
        Intrinsics.checkNotNullParameter(linkSnippetMessageView, "view");
        Intrinsics.checkNotNullParameter(message, "item");
        if (linkSnippetMessageView instanceof IncomingMessageView) {
            this.a.bindView(linkSnippetMessageView, message, i);
        } else if (linkSnippetMessageView instanceof OutgoingMessageView) {
            this.b.bindView(linkSnippetMessageView, message, i);
        }
        MessageBody body = message.getBodyOrBubble().getBody();
        if (!(body instanceof MessageBody.Link)) {
            body = null;
        }
        MessageBody.Link link = (MessageBody.Link) body;
        MessageBody.Link.Preview preview = link != null ? link.getPreview() : null;
        if (!(preview instanceof MessageBody.Link.Preview.Snippet)) {
            preview = null;
        }
        MessageBody.Link.Preview.Snippet snippet = (MessageBody.Link.Preview.Snippet) preview;
        if (link == null || snippet == null) {
            linkSnippetMessageView.setText("", "");
            linkSnippetMessageView.setDomain("");
            linkSnippetMessageView.setImage(null);
            Logs.debug$default("LinkSnippetMessagePresenter", "Unsupported bodyOrBubble: " + message.getBodyOrBubble(), null, 4, null);
            return;
        }
        linkSnippetMessageView.setText(snippet.getTitle(), snippet.getSubtitle());
        linkSnippetMessageView.setDomain(snippet.getDomain());
        if (snippet.getImage() != null) {
            linkSnippetMessageView.setImage(MessagePictureProvider.DefaultImpls.getThumbnail$default(this.c, link, null, 2, null));
        } else {
            linkSnippetMessageView.setImage(null);
        }
    }
}

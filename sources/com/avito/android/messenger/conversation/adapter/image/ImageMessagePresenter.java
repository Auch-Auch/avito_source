package com.avito.android.messenger.conversation.adapter.image;

import android.net.Uri;
import com.avito.android.component.message_status.MessageDeliveryStatus;
import com.avito.android.image_loader.SimplePicture;
import com.avito.android.messenger.conversation.ChannelItem;
import com.avito.android.messenger.conversation.adapter.IncomingMessagePresenter;
import com.avito.android.messenger.conversation.adapter.IncomingMessageView;
import com.avito.android.messenger.conversation.adapter.OutgoingMessagePresenter;
import com.avito.android.messenger.conversation.adapter.OutgoingMessageView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.util.Logs;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001f\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/image/ImageMessagePresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/messenger/conversation/adapter/image/ImageMessageView;", "Lcom/avito/android/messenger/conversation/ChannelItem$Message;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/messenger/conversation/adapter/image/ImageMessageView;Lcom/avito/android/messenger/conversation/ChannelItem$Message;I)V", "Lcom/avito/android/messenger/conversation/adapter/image/MessagePictureProvider;", "c", "Lcom/avito/android/messenger/conversation/adapter/image/MessagePictureProvider;", "pictureProvider", "Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;", "incomingMessagePresenter", "Lcom/avito/android/messenger/conversation/adapter/OutgoingMessagePresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/conversation/adapter/OutgoingMessagePresenter;", "outgoingMessagePresenter", "<init>", "(Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;Lcom/avito/android/messenger/conversation/adapter/OutgoingMessagePresenter;Lcom/avito/android/messenger/conversation/adapter/image/MessagePictureProvider;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ImageMessagePresenter implements ItemPresenter<ImageMessageView, ChannelItem.Message> {
    public final IncomingMessagePresenter a;
    public final OutgoingMessagePresenter b;
    public final MessagePictureProvider c;

    public ImageMessagePresenter(@NotNull IncomingMessagePresenter incomingMessagePresenter, @NotNull OutgoingMessagePresenter outgoingMessagePresenter, @NotNull MessagePictureProvider messagePictureProvider) {
        Intrinsics.checkNotNullParameter(incomingMessagePresenter, "incomingMessagePresenter");
        Intrinsics.checkNotNullParameter(outgoingMessagePresenter, "outgoingMessagePresenter");
        Intrinsics.checkNotNullParameter(messagePictureProvider, "pictureProvider");
        this.a = incomingMessagePresenter;
        this.b = outgoingMessagePresenter;
        this.c = messagePictureProvider;
    }

    public static void a(ImageMessagePresenter imageMessagePresenter, ImageMessageView imageMessageView, MessageBody messageBody, String str, int i) {
        int i2 = i & 2;
        imageMessageView.setImage(imageMessagePresenter.c.getPicture(messageBody, null), imageMessagePresenter.c.getThumbnail(messageBody, null));
    }

    public void bindView(@NotNull ImageMessageView imageMessageView, @NotNull ChannelItem.Message message, int i) {
        Intrinsics.checkNotNullParameter(imageMessageView, "view");
        Intrinsics.checkNotNullParameter(message, "item");
        if (imageMessageView instanceof IncomingMessageView) {
            this.a.bindView(imageMessageView, message, i);
        } else if (imageMessageView instanceof OutgoingMessageView) {
            this.b.bindView(imageMessageView, message, i);
        }
        MessageBody body = message.getBodyOrBubble().getBody();
        if (body instanceof MessageBody.ImageBody) {
            a(this, imageMessageView, body, null, 2);
            imageMessageView.setStatus(message.getStatus());
        } else if (body instanceof MessageBody.Link) {
            a(this, imageMessageView, body, null, 2);
            imageMessageView.setStatus(message.getStatus());
        } else if (body instanceof MessageBody.LocalImage) {
            a(this, imageMessageView, body, null, 2);
            if (message.getStatus() == MessageDeliveryStatus.ERROR) {
                imageMessageView.setStatus(message.getStatus());
            } else {
                imageMessageView.setStatus(MessageDeliveryStatus.SENDING);
            }
        } else if (body instanceof MessageBody.ImageReference) {
            Uri uri = Uri.EMPTY;
            Intrinsics.checkNotNullExpressionValue(uri, "Uri.EMPTY");
            imageMessageView.setImage(new SimplePicture(uri), null);
            imageMessageView.setStatus(message.getStatus());
        } else {
            MessageBody.SystemMessageBody.Platform.Bubble bubble = message.getBodyOrBubble().getBubble();
            if (bubble instanceof MessageBody.SystemMessageBody.Platform.Bubble.Image) {
                MessageBody messageBody = message.getLocalMessage().body;
                String imageId = ((MessageBody.SystemMessageBody.Platform.Bubble.Image) bubble).getImageId();
                imageMessageView.setImage(this.c.getPicture(messageBody, imageId), this.c.getThumbnail(messageBody, imageId));
                imageMessageView.setStatus(message.getStatus());
                return;
            }
            Uri uri2 = Uri.EMPTY;
            Intrinsics.checkNotNullExpressionValue(uri2, "Uri.EMPTY");
            imageMessageView.setImage(new SimplePicture(uri2), null);
            imageMessageView.setStatus(message.getStatus());
            Logs.debug$default("ImageMessagePresenter", "Unsupported bodyOrBubble: " + message.getBodyOrBubble(), null, 4, null);
        }
    }
}

package com.avito.android.messenger.conversation.adapter.platform.from_avito.image;

import android.net.Uri;
import com.avito.android.image_loader.SimplePicture;
import com.avito.android.messenger.conversation.ChannelItem;
import com.avito.android.messenger.conversation.adapter.IncomingMessagePresenter;
import com.avito.android.messenger.conversation.adapter.image.MessagePictureProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.util.Logs;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/image/PlatformImageMessageFromAvitoPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/image/PlatformImageMessageFromAvitoView;", "Lcom/avito/android/messenger/conversation/ChannelItem$Message;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/image/PlatformImageMessageFromAvitoView;Lcom/avito/android/messenger/conversation/ChannelItem$Message;I)V", "Lcom/avito/android/messenger/conversation/adapter/image/MessagePictureProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/conversation/adapter/image/MessagePictureProvider;", "pictureProvider", "Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;", "incomingMessagePresenter", "<init>", "(Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;Lcom/avito/android/messenger/conversation/adapter/image/MessagePictureProvider;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class PlatformImageMessageFromAvitoPresenter implements ItemPresenter<PlatformImageMessageFromAvitoView, ChannelItem.Message> {
    public final IncomingMessagePresenter a;
    public final MessagePictureProvider b;

    public PlatformImageMessageFromAvitoPresenter(@NotNull IncomingMessagePresenter incomingMessagePresenter, @NotNull MessagePictureProvider messagePictureProvider) {
        Intrinsics.checkNotNullParameter(incomingMessagePresenter, "incomingMessagePresenter");
        Intrinsics.checkNotNullParameter(messagePictureProvider, "pictureProvider");
        this.a = incomingMessagePresenter;
        this.b = messagePictureProvider;
    }

    public void bindView(@NotNull PlatformImageMessageFromAvitoView platformImageMessageFromAvitoView, @NotNull ChannelItem.Message message, int i) {
        Intrinsics.checkNotNullParameter(platformImageMessageFromAvitoView, "view");
        Intrinsics.checkNotNullParameter(message, "item");
        this.a.bindView(platformImageMessageFromAvitoView, message, i);
        MessageBody.SystemMessageBody.Platform.Bubble bubble = message.getBodyOrBubble().getBubble();
        if (!(bubble instanceof MessageBody.SystemMessageBody.Platform.Bubble.Image)) {
            bubble = null;
        }
        MessageBody.SystemMessageBody.Platform.Bubble.Image image = (MessageBody.SystemMessageBody.Platform.Bubble.Image) bubble;
        if (image != null) {
            image.getImage();
            platformImageMessageFromAvitoView.setImage(this.b.getPicture(message.getLocalMessage().body, image.getImageId()), this.b.getThumbnail(message.getLocalMessage().body, image.getImageId()));
            platformImageMessageFromAvitoView.overrideMargins(message.getOverrideTopMarginDp(), message.getOverrideBottomMarginDp());
            return;
        }
        Uri uri = Uri.EMPTY;
        Intrinsics.checkNotNullExpressionValue(uri, "Uri.EMPTY");
        platformImageMessageFromAvitoView.setImage(new SimplePicture(uri), null);
        Logs.debug$default("PlatformImageMessageFromAvitoPresenter", "Unsupported bodyOrBubble: " + message.getBodyOrBubble(), null, 4, null);
    }
}

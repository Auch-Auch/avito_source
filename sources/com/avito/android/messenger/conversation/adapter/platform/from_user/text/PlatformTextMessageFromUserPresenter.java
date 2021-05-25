package com.avito.android.messenger.conversation.adapter.platform.from_user.text;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.deep_linking.links.OnUrlClickListener;
import com.avito.android.messenger.conversation.ChannelItem;
import com.avito.android.messenger.conversation.adapter.IncomingMessagePresenter;
import com.avito.android.messenger.conversation.adapter.IncomingMessageView;
import com.avito.android.messenger.conversation.adapter.OutgoingMessagePresenter;
import com.avito.android.messenger.conversation.adapter.OutgoingMessageView;
import com.avito.android.messenger.conversation.adapter.platform.from_user.text.PlatformTextMessageFromUserView;
import com.avito.android.messenger.conversation.adapter.text.MessageLinkClickListener;
import com.avito.android.messenger.conversation.mvi.deeplinks.DeeplinkProcessor;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.util.Logs;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import dagger.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B7\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010$\u001a\u00020!\u0012\u000e\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u0010\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b%\u0010&J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/platform/from_user/text/PlatformTextMessageFromUserPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/messenger/conversation/adapter/platform/from_user/text/PlatformTextMessageFromUserView;", "Lcom/avito/android/messenger/conversation/ChannelItem$Message;", "Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/messenger/conversation/adapter/platform/from_user/text/PlatformTextMessageFromUserView;Lcom/avito/android/messenger/conversation/ChannelItem$Message;I)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "onDeepLinkClick", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "Ldagger/Lazy;", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/DeeplinkProcessor;", "c", "Ldagger/Lazy;", "deeplinkProcessor", "Lcom/avito/android/util/text/AttributedTextFormatter;", "e", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;", "incomingMessagePresenter", "Lcom/avito/android/messenger/conversation/adapter/text/MessageLinkClickListener;", "d", "Lcom/avito/android/messenger/conversation/adapter/text/MessageLinkClickListener;", "linkClickListener", "Lcom/avito/android/messenger/conversation/adapter/OutgoingMessagePresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/conversation/adapter/OutgoingMessagePresenter;", "outgoingMessagePresenter", "<init>", "(Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;Lcom/avito/android/messenger/conversation/adapter/OutgoingMessagePresenter;Ldagger/Lazy;Lcom/avito/android/messenger/conversation/adapter/text/MessageLinkClickListener;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class PlatformTextMessageFromUserPresenter implements ItemPresenter<PlatformTextMessageFromUserView, ChannelItem.Message>, OnDeepLinkClickListener {
    public final IncomingMessagePresenter a;
    public final OutgoingMessagePresenter b;
    public final Lazy<? extends DeeplinkProcessor> c;
    public final MessageLinkClickListener d;
    public final AttributedTextFormatter e;

    public PlatformTextMessageFromUserPresenter(@NotNull IncomingMessagePresenter incomingMessagePresenter, @NotNull OutgoingMessagePresenter outgoingMessagePresenter, @NotNull Lazy<? extends DeeplinkProcessor> lazy, @NotNull MessageLinkClickListener messageLinkClickListener, @NotNull AttributedTextFormatter attributedTextFormatter) {
        Intrinsics.checkNotNullParameter(incomingMessagePresenter, "incomingMessagePresenter");
        Intrinsics.checkNotNullParameter(outgoingMessagePresenter, "outgoingMessagePresenter");
        Intrinsics.checkNotNullParameter(lazy, "deeplinkProcessor");
        Intrinsics.checkNotNullParameter(messageLinkClickListener, "linkClickListener");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        this.a = incomingMessagePresenter;
        this.b = outgoingMessagePresenter;
        this.c = lazy;
        this.d = messageLinkClickListener;
        this.e = attributedTextFormatter;
    }

    @Override // com.avito.android.deep_linking.links.OnDeepLinkClickListener
    public void onDeepLinkClick(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        ((DeeplinkProcessor) this.c.get()).process(deepLink);
    }

    public void bindView(@NotNull PlatformTextMessageFromUserView platformTextMessageFromUserView, @NotNull ChannelItem.Message message, int i) {
        Intrinsics.checkNotNullParameter(platformTextMessageFromUserView, "view");
        Intrinsics.checkNotNullParameter(message, "item");
        if (platformTextMessageFromUserView instanceof IncomingMessageView) {
            this.a.bindView(platformTextMessageFromUserView, message, i);
        } else if (platformTextMessageFromUserView instanceof OutgoingMessageView) {
            this.b.bindView(platformTextMessageFromUserView, message, i);
        }
        MessageBody.SystemMessageBody.Platform.Bubble bubble = message.getBodyOrBubble().getBubble();
        if (!(bubble instanceof MessageBody.SystemMessageBody.Platform.Bubble.Text)) {
            bubble = null;
        }
        MessageBody.SystemMessageBody.Platform.Bubble.Text text = (MessageBody.SystemMessageBody.Platform.Bubble.Text) bubble;
        if (text != null) {
            text.getText().setOnDeepLinkClickListener(this);
            text.getText().setOnUrlClickListener(new OnUrlClickListener(this, message, platformTextMessageFromUserView) { // from class: com.avito.android.messenger.conversation.adapter.platform.from_user.text.PlatformTextMessageFromUserPresenter$bindView$$inlined$with$lambda$1
                public final /* synthetic */ PlatformTextMessageFromUserPresenter a;
                public final /* synthetic */ ChannelItem.Message b;
                public final /* synthetic */ PlatformTextMessageFromUserView c;

                {
                    this.a = r1;
                    this.b = r2;
                    this.c = r3;
                }

                @Override // com.avito.android.deep_linking.links.OnUrlClickListener
                public boolean onUrlClick(@NotNull String str) {
                    Intrinsics.checkNotNullParameter(str, "url");
                    this.a.d.onMessageLinkClicked(this.b.getBodyOrBubble(), this.b.getLocalMessage(), str);
                    return true;
                }
            });
            PlatformTextMessageFromUserView.DefaultImpls.setText$default(platformTextMessageFromUserView, this.e.format(platformTextMessageFromUserView.getContext(), text.getText()), null, 2, null);
            return;
        }
        PlatformTextMessageFromUserView.DefaultImpls.setText$default(platformTextMessageFromUserView, null, null, 2, null);
        Logs.debug$default("PlatformTextMessageFromAvitoPresenter", "Unsupported bodyOrBubble: " + message.getBodyOrBubble(), null, 4, null);
    }
}

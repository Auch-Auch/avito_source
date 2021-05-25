package com.avito.android.messenger.conversation.adapter.platform.from_avito.text;

import android.view.ActionMode;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.messenger.conversation.ChannelItem;
import com.avito.android.messenger.conversation.adapter.IncomingMessagePresenter;
import com.avito.android.messenger.conversation.adapter.platform.from_avito.text.PlatformTextMessageFromAvitoView;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B7\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u000e\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001d0\u0018\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u000e\u0010\u001c\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00190\u0018¢\u0006\u0004\b \u0010!J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001e\u0010\u001c\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00190\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001d0\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001b¨\u0006\""}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/text/PlatformTextMessageFromAvitoPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/text/PlatformTextMessageFromAvitoView;", "Lcom/avito/android/messenger/conversation/ChannelItem$Message;", "Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/text/PlatformTextMessageFromAvitoView;Lcom/avito/android/messenger/conversation/ChannelItem$Message;I)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "onDeepLinkClick", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;", "incomingMessagePresenter", "Lcom/avito/android/util/text/AttributedTextFormatter;", "c", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Ldagger/Lazy;", "Landroid/view/ActionMode$Callback;", "d", "Ldagger/Lazy;", "actionModeCallback", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/DeeplinkProcessor;", AuthSource.BOOKING_ORDER, "deeplinkProcessor", "<init>", "(Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;Ldagger/Lazy;Lcom/avito/android/util/text/AttributedTextFormatter;Ldagger/Lazy;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class PlatformTextMessageFromAvitoPresenter implements ItemPresenter<PlatformTextMessageFromAvitoView, ChannelItem.Message>, OnDeepLinkClickListener {
    public final IncomingMessagePresenter a;
    public final Lazy<? extends DeeplinkProcessor> b;
    public final AttributedTextFormatter c;
    public final Lazy<? extends ActionMode.Callback> d;

    public PlatformTextMessageFromAvitoPresenter(@NotNull IncomingMessagePresenter incomingMessagePresenter, @NotNull Lazy<? extends DeeplinkProcessor> lazy, @NotNull AttributedTextFormatter attributedTextFormatter, @NotNull Lazy<? extends ActionMode.Callback> lazy2) {
        Intrinsics.checkNotNullParameter(incomingMessagePresenter, "incomingMessagePresenter");
        Intrinsics.checkNotNullParameter(lazy, "deeplinkProcessor");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        Intrinsics.checkNotNullParameter(lazy2, "actionModeCallback");
        this.a = incomingMessagePresenter;
        this.b = lazy;
        this.c = attributedTextFormatter;
        this.d = lazy2;
    }

    @Override // com.avito.android.deep_linking.links.OnDeepLinkClickListener
    public void onDeepLinkClick(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        ((DeeplinkProcessor) this.b.get()).process(deepLink);
    }

    public void bindView(@NotNull PlatformTextMessageFromAvitoView platformTextMessageFromAvitoView, @NotNull ChannelItem.Message message, int i) {
        Intrinsics.checkNotNullParameter(platformTextMessageFromAvitoView, "view");
        Intrinsics.checkNotNullParameter(message, "item");
        this.a.bindView(platformTextMessageFromAvitoView, message, i);
        MessageBody.SystemMessageBody.Platform.Bubble bubble = message.getBodyOrBubble().getBubble();
        if (!(bubble instanceof MessageBody.SystemMessageBody.Platform.Bubble.Text)) {
            bubble = null;
        }
        MessageBody.SystemMessageBody.Platform.Bubble.Text text = (MessageBody.SystemMessageBody.Platform.Bubble.Text) bubble;
        if (text != null) {
            text.getText().setOnDeepLinkClickListener(this);
            PlatformTextMessageFromAvitoView.DefaultImpls.setText$default(platformTextMessageFromAvitoView, this.c.format(platformTextMessageFromAvitoView.getContext(), text.getText()), null, 2, null);
            platformTextMessageFromAvitoView.overrideMargins(message.getOverrideTopMarginDp(), message.getOverrideBottomMarginDp());
            Object obj = this.d.get();
            Intrinsics.checkNotNullExpressionValue(obj, "actionModeCallback.get()");
            platformTextMessageFromAvitoView.setActionModeCallback((ActionMode.Callback) obj);
            return;
        }
        PlatformTextMessageFromAvitoView.DefaultImpls.setText$default(platformTextMessageFromAvitoView, null, null, 2, null);
        Logs.debug$default("PlatformTextMessageFromAvitoPresenter", "Unsupported bodyOrBubble: " + message.getBodyOrBubble(), null, 4, null);
    }
}

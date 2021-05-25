package com.avito.android.messenger.conversation.mvi.message_menu.elements;

import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.R;
import com.avito.android.messenger.analytics.MessengerLinkClick;
import com.avito.android.messenger.channels.mvi.common.v4.Action;
import com.avito.android.messenger.channels.mvi.common.v4.Reducible;
import com.avito.android.messenger.conversation.mvi.message_menu.ClickableMenuElementProvider;
import com.avito.android.messenger.conversation.mvi.message_menu.MenuElement;
import com.avito.android.messenger.conversation.mvi.message_menu.MessageContextData;
import com.avito.android.messenger.conversation.mvi.message_menu.MessageMenuPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.ActionConfirmation;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0002\u001b\u001cB\u0019\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0010\u001a\u00020\u000b8\u0016@\u0016XD¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001d"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/OpenInBrowserElementProvider;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/ClickableMenuElementProvider;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;", "contextData", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MenuElement;", "getMenuElement", "(Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;)Lcom/avito/android/messenger/conversation/mvi/message_menu/MenuElement;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Reducible;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State;", "getReducible", "(Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;)Lcom/avito/android/messenger/channels/mvi/common/v4/Reducible;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getActionId", "()Ljava/lang/String;", "actionId", "Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/OpenInBrowserElementProvider$Callback;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/OpenInBrowserElementProvider$Callback;", "callback", "Lcom/avito/android/analytics/Analytics;", "c", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/OpenInBrowserElementProvider$Callback;Lcom/avito/android/analytics/Analytics;)V", "Callback", "OpenInBrowserAction", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class OpenInBrowserElementProvider implements ClickableMenuElementProvider {
    @NotNull
    public final String a = "open_in_browser";
    public final Callback b;
    public final Analytics c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/OpenInBrowserElementProvider$Callback;", "", "", "url", "", "openInBrowser", "(Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public interface Callback {
        void openInBrowser(@NotNull String str);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/OpenInBrowserElementProvider$OpenInBrowserAction;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Action;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State;", "curState", "", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State;)V", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;", "d", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;", "contextData", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/OpenInBrowserElementProvider;Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class OpenInBrowserAction extends Action<MessageMenuPresenter.State> {
        public final MessageContextData d;
        public final /* synthetic */ OpenInBrowserElementProvider e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OpenInBrowserAction(@NotNull OpenInBrowserElementProvider openInBrowserElementProvider, MessageContextData messageContextData) {
            super(null, null, 3, null);
            Intrinsics.checkNotNullParameter(messageContextData, "contextData");
            this.e = openInBrowserElementProvider;
            this.d = messageContextData;
        }

        public void invoke(@NotNull MessageMenuPresenter.State state) {
            String str;
            Intrinsics.checkNotNullParameter(state, "curState");
            MessageContextData messageContextData = this.d;
            if (messageContextData instanceof MessageContextData.Item) {
                str = ((MessageContextData.Item) messageContextData).getUrl();
            } else if (messageContextData instanceof MessageContextData.Image) {
                str = ((MessageContextData.Image) messageContextData).getUrl();
            } else if (messageContextData instanceof MessageContextData.Link) {
                str = ((MessageContextData.Link) messageContextData).getUrl();
            } else if (messageContextData instanceof MessageContextData.LinkInText) {
                str = ((MessageContextData.LinkInText) messageContextData).getUrl();
            } else {
                return;
            }
            String remoteId = this.d.getMessageData().getRemoteId();
            if (remoteId != null) {
                this.e.c.track(new MessengerLinkClick(this.d.getMessageData().getChannelId(), remoteId, str));
            }
            this.e.b.openInBrowser(str);
        }
    }

    @Inject
    public OpenInBrowserElementProvider(@NotNull Callback callback, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.b = callback;
        this.c = analytics;
    }

    @Override // com.avito.android.messenger.conversation.mvi.message_menu.ClickableMenuElementProvider
    @NotNull
    public String getActionId() {
        return this.a;
    }

    @Override // com.avito.android.messenger.conversation.mvi.message_menu.ClickableMenuElementProvider
    @Nullable
    public ActionConfirmation getConfirmation(@NotNull MessageContextData messageContextData) {
        Intrinsics.checkNotNullParameter(messageContextData, "contextData");
        return ClickableMenuElementProvider.DefaultImpls.getConfirmation(this, messageContextData);
    }

    @Override // com.avito.android.messenger.conversation.mvi.message_menu.MenuElementProvider
    @Nullable
    public MenuElement getMenuElement(@NotNull MessageContextData messageContextData) {
        Intrinsics.checkNotNullParameter(messageContextData, "contextData");
        if ((messageContextData instanceof MessageContextData.Item) || (messageContextData instanceof MessageContextData.Link) || (messageContextData instanceof MessageContextData.LinkInText) || (messageContextData instanceof MessageContextData.Image)) {
            return new MenuElement.Action(getActionId(), R.string.messenger_chat_link_menu_open_in_browser, R.drawable.ic_messenger_link_menu_open_in_browser);
        }
        if ((messageContextData instanceof MessageContextData.Text) || (messageContextData instanceof MessageContextData.LocalImage) || (messageContextData instanceof MessageContextData.Location) || (messageContextData instanceof MessageContextData.File)) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.avito.android.messenger.conversation.mvi.message_menu.ClickableMenuElementProvider
    @NotNull
    public Reducible<MessageMenuPresenter.State> getReducible(@NotNull MessageContextData messageContextData) {
        Intrinsics.checkNotNullParameter(messageContextData, "contextData");
        return new OpenInBrowserAction(this, messageContextData);
    }
}

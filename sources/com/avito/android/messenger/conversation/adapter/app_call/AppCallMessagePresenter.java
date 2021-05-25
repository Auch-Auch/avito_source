package com.avito.android.messenger.conversation.adapter.app_call;

import com.avito.android.Features;
import com.avito.android.deep_linking.links.NoMatchLink;
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
import dagger.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B-\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u001c\u0010\u001dJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/app_call/AppCallMessagePresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/messenger/conversation/adapter/app_call/AppCallMessageView;", "Lcom/avito/android/messenger/conversation/ChannelItem$Message;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/messenger/conversation/adapter/app_call/AppCallMessageView;Lcom/avito/android/messenger/conversation/ChannelItem$Message;I)V", "Lcom/avito/android/Features;", "d", "Lcom/avito/android/Features;", "features", "Ldagger/Lazy;", "Lcom/avito/android/messenger/conversation/adapter/app_call/AppCallMessageClickListener;", "c", "Ldagger/Lazy;", "clickListener", "Lcom/avito/android/messenger/conversation/adapter/OutgoingMessagePresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/conversation/adapter/OutgoingMessagePresenter;", "outgoingMessagePresenter", "Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;", "incomingMessagePresenter", "<init>", "(Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;Lcom/avito/android/messenger/conversation/adapter/OutgoingMessagePresenter;Ldagger/Lazy;Lcom/avito/android/Features;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class AppCallMessagePresenter implements ItemPresenter<AppCallMessageView, ChannelItem.Message> {
    public final IncomingMessagePresenter a;
    public final OutgoingMessagePresenter b;
    public final Lazy<AppCallMessageClickListener> c;
    public final Features d;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ AppCallMessagePresenter a;
        public final /* synthetic */ MessageBody.AppCall b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(AppCallMessagePresenter appCallMessagePresenter, MessageBody.AppCall appCall) {
            super(0);
            this.a = appCallMessagePresenter;
            this.b = appCall;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            ((AppCallMessageClickListener) this.a.c.get()).onAppCallMessageClicked(this.b.getCall().getDeepLink());
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function0<Boolean> {
        public final /* synthetic */ AppCallMessagePresenter a;
        public final /* synthetic */ MessageBody.AppCall b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(AppCallMessagePresenter appCallMessagePresenter, MessageBody.AppCall appCall) {
            super(0);
            this.a = appCallMessagePresenter;
            this.b = appCall;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Boolean invoke() {
            ((AppCallMessageClickListener) this.a.c.get()).onAppCallMessageClicked(this.b.getCall().getDeepLink());
            return Boolean.TRUE;
        }
    }

    public AppCallMessagePresenter(@NotNull IncomingMessagePresenter incomingMessagePresenter, @NotNull OutgoingMessagePresenter outgoingMessagePresenter, @NotNull Lazy<AppCallMessageClickListener> lazy, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(incomingMessagePresenter, "incomingMessagePresenter");
        Intrinsics.checkNotNullParameter(outgoingMessagePresenter, "outgoingMessagePresenter");
        Intrinsics.checkNotNullParameter(lazy, "clickListener");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = incomingMessagePresenter;
        this.b = outgoingMessagePresenter;
        this.c = lazy;
        this.d = features;
    }

    public void bindView(@NotNull AppCallMessageView appCallMessageView, @NotNull ChannelItem.Message message, int i) {
        Intrinsics.checkNotNullParameter(appCallMessageView, "view");
        Intrinsics.checkNotNullParameter(message, "item");
        if (appCallMessageView instanceof IncomingMessageView) {
            this.a.bindView(appCallMessageView, message, i);
        } else if (appCallMessageView instanceof OutgoingMessageView) {
            this.b.bindView(appCallMessageView, message, i);
        }
        MessageBody body = message.getBodyOrBubble().getBody();
        if (!(body instanceof MessageBody.AppCall)) {
            body = null;
        }
        MessageBody.AppCall appCall = (MessageBody.AppCall) body;
        if (appCall != null) {
            appCallMessageView.setText(appCall.getText());
            if (!this.d.getMessengerInAppCalls().invoke().booleanValue() || (appCall.getCall().getDeepLink() instanceof NoMatchLink)) {
                appCallMessageView.setActionTitle(null);
                return;
            }
            appCallMessageView.setActionTitle(appCall.getCall().getTitle());
            if (appCallMessageView instanceof MessageViewClicks) {
                MessageViewClicks messageViewClicks = (MessageViewClicks) appCallMessageView;
                messageViewClicks.setClickListener(new a(this, appCall));
                messageViewClicks.setLongClickListener(new b(this, appCall));
                return;
            }
            return;
        }
        appCallMessageView.setText("");
        appCallMessageView.setActionTitle(null);
        Logs.debug$default("AppCallMessagePresenter", "Unsupported bodyOrBubble: " + message.getBodyOrBubble(), null, 4, null);
    }
}

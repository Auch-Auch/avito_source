package com.avito.android.messenger.conversation.mvi.message_menu.elements;

import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.R;
import com.avito.android.messenger.analytics.SendMessageEvent;
import com.avito.android.messenger.channels.mvi.common.v4.ActionSingle;
import com.avito.android.messenger.channels.mvi.common.v4.Reducible;
import com.avito.android.messenger.conversation.mvi.data.MessageRepo;
import com.avito.android.messenger.conversation.mvi.message_menu.ClickableMenuElementProvider;
import com.avito.android.messenger.conversation.mvi.message_menu.MenuElement;
import com.avito.android.messenger.conversation.mvi.message_menu.MessageContextData;
import com.avito.android.messenger.conversation.mvi.message_menu.MessageData;
import com.avito.android.messenger.conversation.mvi.message_menu.MessageMenuPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.ActionConfirmation;
import com.avito.android.remote.model.messenger.MessengerTimestamp;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import io.reactivex.CompletableSource;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.d;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0002'(B1\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u0010 \u001a\u00020\u001d¢\u0006\u0004\b%\u0010&J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0010\u001a\u00020\u000b8\u0016@\u0016XD¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006)"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/RetrySendingMessageElementProvider;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/ClickableMenuElementProvider;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;", "contextData", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MenuElement;", "getMenuElement", "(Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;)Lcom/avito/android/messenger/conversation/mvi/message_menu/MenuElement;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Reducible;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State;", "getReducible", "(Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;)Lcom/avito/android/messenger/channels/mvi/common/v4/Reducible;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getActionId", "()Ljava/lang/String;", "actionId", "Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;", "messageRepo", "Lcom/avito/android/analytics/Analytics;", "d", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/server_time/TimeSource;", "c", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/RetrySendingMessageElementProvider$Callback;", "f", "Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/RetrySendingMessageElementProvider$Callback;", "callback", "Lcom/avito/android/util/SchedulersFactory;", "e", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/RetrySendingMessageElementProvider$Callback;)V", "Callback", "RetrySendingMessageAction", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class RetrySendingMessageElementProvider implements ClickableMenuElementProvider {
    @NotNull
    public final String a = "retry_sending_message";
    public final MessageRepo b;
    public final TimeSource c;
    public final Analytics d;
    public final SchedulersFactory e;
    public final Callback f;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/RetrySendingMessageElementProvider$Callback;", "", "", "error", "", "onRetrySendingMessageFailure", "(Ljava/lang/Throwable;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public interface Callback {
        void onRetrySendingMessageFailure(@NotNull Throwable th);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/RetrySendingMessageElementProvider$RetrySendingMessageAction;", "Lcom/avito/android/messenger/channels/mvi/common/v4/ActionSingle;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State;", "curState", "Lio/reactivex/Single;", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State;)Lio/reactivex/Single;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;", "d", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;", "contextData", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/RetrySendingMessageElementProvider;Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class RetrySendingMessageAction extends ActionSingle<MessageMenuPresenter.State> {
        public final MessageContextData d;
        public final /* synthetic */ RetrySendingMessageElementProvider e;

        public static final class a<T> implements Consumer<Throwable> {
            public final /* synthetic */ RetrySendingMessageAction a;
            public final /* synthetic */ MessageData b;

            public a(RetrySendingMessageAction retrySendingMessageAction, MessageData messageData) {
                this.a = retrySendingMessageAction;
                this.b = messageData;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Consumer
            public void accept(Throwable th) {
                Throwable th2 = th;
                StringBuilder L = a2.b.a.a.a.L("Failed update state of message: ");
                L.append(this.b.getLocalId());
                Logs.error("RetrySendingMessageElementProvider", L.toString(), th2);
                Callback callback = this.a.e.f;
                Intrinsics.checkNotNullExpressionValue(th2, "error");
                callback.onRetrySendingMessageFailure(th2);
            }
        }

        public static final class b<T, R> implements Function<Throwable, CompletableSource> {
            public final /* synthetic */ RetrySendingMessageAction a;
            public final /* synthetic */ MessageData b;

            public b(RetrySendingMessageAction retrySendingMessageAction, MessageData messageData) {
                this.a = retrySendingMessageAction;
                this.b = messageData;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Function
            public CompletableSource apply(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "it");
                return this.a.e.b.markMessagesAsFailed(d.listOf(this.b.getLocalId()));
            }
        }

        public static final class c<T> implements Consumer<Disposable> {
            public final /* synthetic */ RetrySendingMessageAction a;
            public final /* synthetic */ MessageData b;

            public c(RetrySendingMessageAction retrySendingMessageAction, MessageData messageData) {
                this.a = retrySendingMessageAction;
                this.b = messageData;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Consumer
            public void accept(Disposable disposable) {
                this.a.e.d.track(new SendMessageEvent.Retry(this.b.getChannelId(), this.b.getType(), this.b.getLocalId(), false));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RetrySendingMessageAction(@NotNull RetrySendingMessageElementProvider retrySendingMessageElementProvider, MessageContextData messageContextData) {
            super(null, null, 3, null);
            Intrinsics.checkNotNullParameter(messageContextData, "contextData");
            this.e = retrySendingMessageElementProvider;
            this.d = messageContextData;
        }

        @NotNull
        public Single<?> invoke(@NotNull MessageMenuPresenter.State state) {
            Intrinsics.checkNotNullParameter(state, "curState");
            long fromMillis = MessengerTimestamp.fromMillis(this.e.c.now());
            MessageData messageData = this.d.getMessageData();
            Single<?> doOnSubscribe = this.e.b.resetMessageForResend(messageData.getLocalId(), fromMillis).subscribeOn(this.e.e.io()).observeOn(this.e.e.computation()).doOnError(new a(this, messageData)).onErrorResumeNext(new b(this, messageData)).onErrorComplete().toSingleDefault(Unit.INSTANCE).doOnSubscribe(new c(this, messageData));
            Intrinsics.checkNotNullExpressionValue(doOnSubscribe, "messageRepo.resetMessage…      )\n                }");
            return doOnSubscribe;
        }
    }

    @Inject
    public RetrySendingMessageElementProvider(@NotNull MessageRepo messageRepo, @NotNull TimeSource timeSource, @NotNull Analytics analytics, @NotNull SchedulersFactory schedulersFactory, @NotNull Callback callback) {
        Intrinsics.checkNotNullParameter(messageRepo, "messageRepo");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.b = messageRepo;
        this.c = timeSource;
        this.d = analytics;
        this.e = schedulersFactory;
        this.f = callback;
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
        boolean z = true;
        boolean z2 = messageContextData.getMessageData().getRemoteId() == null;
        boolean isFailed = messageContextData.getMessageData().isFailed();
        if ((messageContextData instanceof MessageContextData.LinkInText) || !z2 || !isFailed) {
            z = false;
        }
        if (z) {
            return new MenuElement.Action(getActionId(), R.string.messenger_retry_sending, com.avito.android.ui_components.R.drawable.ic_retry_24);
        }
        return null;
    }

    @Override // com.avito.android.messenger.conversation.mvi.message_menu.ClickableMenuElementProvider
    @NotNull
    public Reducible<MessageMenuPresenter.State> getReducible(@NotNull MessageContextData messageContextData) {
        Intrinsics.checkNotNullParameter(messageContextData, "contextData");
        return new RetrySendingMessageAction(this, messageContextData);
    }
}

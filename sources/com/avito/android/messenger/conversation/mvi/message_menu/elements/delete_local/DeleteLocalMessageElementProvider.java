package com.avito.android.messenger.conversation.mvi.message_menu.elements.delete_local;

import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.R;
import com.avito.android.messenger.analytics.DeleteMessageEvent;
import com.avito.android.messenger.channels.mvi.common.v4.ActionSingle;
import com.avito.android.messenger.channels.mvi.common.v4.Reducible;
import com.avito.android.messenger.conversation.mvi.message_menu.ClickableMenuElementProvider;
import com.avito.android.messenger.conversation.mvi.message_menu.MenuElement;
import com.avito.android.messenger.conversation.mvi.message_menu.MessageContextData;
import com.avito.android.messenger.conversation.mvi.message_menu.MessageData;
import com.avito.android.messenger.conversation.mvi.message_menu.MessageMenuPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.ActionConfirmation;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0002#$B)\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b!\u0010\"J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001c\u0010\u0014\u001a\u00020\u000f8\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006%"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/delete_local/DeleteLocalMessageElementProvider;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/ClickableMenuElementProvider;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;", "contextData", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MenuElement;", "getMenuElement", "(Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;)Lcom/avito/android/messenger/conversation/mvi/message_menu/MenuElement;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Reducible;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State;", "getReducible", "(Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;)Lcom/avito/android/messenger/channels/mvi/common/v4/Reducible;", "Lcom/avito/android/util/SchedulersFactory;", "d", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getActionId", "()Ljava/lang/String;", "actionId", "Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/delete_local/DeleteLocalMessageElementProvider$Callback;", "e", "Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/delete_local/DeleteLocalMessageElementProvider$Callback;", "callback", "Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/delete_local/MessageEraser;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/delete_local/MessageEraser;", "messageEraser", "Lcom/avito/android/analytics/Analytics;", "c", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/delete_local/MessageEraser;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/delete_local/DeleteLocalMessageElementProvider$Callback;)V", "Callback", "DeleteLocalMessageAction", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class DeleteLocalMessageElementProvider implements ClickableMenuElementProvider {
    @NotNull
    public final String a = "delete_local_message";
    public final MessageEraser b;
    public final Analytics c;
    public final SchedulersFactory d;
    public final Callback e;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/delete_local/DeleteLocalMessageElementProvider$Callback;", "", "", "error", "", "onDeletePendingMessageFailure", "(Ljava/lang/Throwable;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public interface Callback {
        void onDeletePendingMessageFailure(@NotNull Throwable th);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/delete_local/DeleteLocalMessageElementProvider$DeleteLocalMessageAction;", "Lcom/avito/android/messenger/channels/mvi/common/v4/ActionSingle;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State;", "curState", "Lio/reactivex/Single;", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State;)Lio/reactivex/Single;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;", "d", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;", "contextData", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/delete_local/DeleteLocalMessageElementProvider;Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class DeleteLocalMessageAction extends ActionSingle<MessageMenuPresenter.State> {
        public final MessageContextData d;
        public final /* synthetic */ DeleteLocalMessageElementProvider e;

        public static final class a<T> implements Consumer<Boolean> {
            public final /* synthetic */ DeleteLocalMessageAction a;
            public final /* synthetic */ MessageData b;

            public a(DeleteLocalMessageAction deleteLocalMessageAction, MessageData messageData) {
                this.a = deleteLocalMessageAction;
                this.b = messageData;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Consumer
            public void accept(Boolean bool) {
                Boolean bool2 = bool;
                Intrinsics.checkNotNullExpressionValue(bool2, "wasDeleted");
                if (bool2.booleanValue()) {
                    this.a.e.c.track(new DeleteMessageEvent(this.b.getChannelId(), this.b.getType(), this.b.getLocalId()));
                }
            }
        }

        public static final class b<T> implements Consumer<Throwable> {
            public final /* synthetic */ DeleteLocalMessageAction a;
            public final /* synthetic */ MessageData b;

            public b(DeleteLocalMessageAction deleteLocalMessageAction, MessageData messageData) {
                this.a = deleteLocalMessageAction;
                this.b = messageData;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Consumer
            public void accept(Throwable th) {
                Throwable th2 = th;
                StringBuilder L = a2.b.a.a.a.L("Failed to delete message: ");
                L.append(this.b.getLocalId());
                Logs.error("DeleteLocalMessageElementProvider", L.toString(), th2);
                Callback callback = this.a.e.e;
                Intrinsics.checkNotNullExpressionValue(th2, "error");
                callback.onDeletePendingMessageFailure(th2);
            }
        }

        public static final class c<T, R> implements Function<Throwable, Boolean> {
            public static final c a = new c();

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Function
            public Boolean apply(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "it");
                return Boolean.FALSE;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DeleteLocalMessageAction(@NotNull DeleteLocalMessageElementProvider deleteLocalMessageElementProvider, MessageContextData messageContextData) {
            super(null, null, 3, null);
            Intrinsics.checkNotNullParameter(messageContextData, "contextData");
            this.e = deleteLocalMessageElementProvider;
            this.d = messageContextData;
        }

        @NotNull
        public Single<?> invoke(@NotNull MessageMenuPresenter.State state) {
            Intrinsics.checkNotNullParameter(state, "curState");
            MessageData messageData = this.d.getMessageData();
            Single<Boolean> onErrorReturn = this.e.b.deleteLocalMessage(this.d.getMessageData().getUserId(), this.d.getMessageData().getChannelId(), this.d.getMessageData().getLocalId()).observeOn(this.e.d.computation()).doAfterSuccess(new a(this, messageData)).doOnError(new b(this, messageData)).onErrorReturn(c.a);
            Intrinsics.checkNotNullExpressionValue(onErrorReturn, "messageEraser.deleteLoca… .onErrorReturn { false }");
            return onErrorReturn;
        }
    }

    @Inject
    public DeleteLocalMessageElementProvider(@NotNull MessageEraser messageEraser, @NotNull Analytics analytics, @NotNull SchedulersFactory schedulersFactory, @NotNull Callback callback) {
        Intrinsics.checkNotNullParameter(messageEraser, "messageEraser");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.b = messageEraser;
        this.c = analytics;
        this.d = schedulersFactory;
        this.e = callback;
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
        if ((messageContextData instanceof MessageContextData.LinkInText) || !z2 || !messageContextData.getMessageData().isSentByUserDirectly()) {
            z = false;
        }
        if (z) {
            return new MenuElement.Action(getActionId(), R.string.messenger_delete_message, com.avito.android.ui_components.R.drawable.ic_rds_trash_24);
        }
        return null;
    }

    @Override // com.avito.android.messenger.conversation.mvi.message_menu.ClickableMenuElementProvider
    @NotNull
    public Reducible<MessageMenuPresenter.State> getReducible(@NotNull MessageContextData messageContextData) {
        Intrinsics.checkNotNullParameter(messageContextData, "contextData");
        return new DeleteLocalMessageAction(this, messageContextData);
    }
}

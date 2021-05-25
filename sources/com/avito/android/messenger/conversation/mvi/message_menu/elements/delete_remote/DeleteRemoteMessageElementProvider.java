package com.avito.android.messenger.conversation.mvi.message_menu.elements.delete_remote;

import android.content.res.Resources;
import com.avito.android.messenger.R;
import com.avito.android.messenger.channels.mvi.common.v4.ActionSingle;
import com.avito.android.messenger.channels.mvi.common.v4.Reducible;
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
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0002&'B)\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010#\u001a\u00020 ¢\u0006\u0004\b$\u0010%J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001c\u0010\u001b\u001a\u00020\u00168\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006("}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/delete_remote/DeleteRemoteMessageElementProvider;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/ClickableMenuElementProvider;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;", "contextData", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MenuElement;", "getMenuElement", "(Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;)Lcom/avito/android/messenger/conversation/mvi/message_menu/MenuElement;", "Lcom/avito/android/remote/model/messenger/ActionConfirmation;", "getConfirmation", "(Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;)Lcom/avito/android/remote/model/messenger/ActionConfirmation;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Reducible;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State;", "getReducible", "(Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;)Lcom/avito/android/messenger/channels/mvi/common/v4/Reducible;", "Landroid/content/res/Resources;", AuthSource.BOOKING_ORDER, "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/server_time/TimeSource;", "d", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getActionId", "()Ljava/lang/String;", "actionId", "Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/delete_remote/DeleteRemoteMessageElementProvider$Callback;", "c", "Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/delete_remote/DeleteRemoteMessageElementProvider$Callback;", "callback", "Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/delete_remote/DeleteRemoteMessageInteractor;", "e", "Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/delete_remote/DeleteRemoteMessageInteractor;", "interactor", "<init>", "(Landroid/content/res/Resources;Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/delete_remote/DeleteRemoteMessageElementProvider$Callback;Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/delete_remote/DeleteRemoteMessageInteractor;)V", "Callback", "DeleteRemoteMessageAction", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class DeleteRemoteMessageElementProvider implements ClickableMenuElementProvider {
    @NotNull
    public final String a = "delete_remote_message";
    public final Resources b;
    public final Callback c;
    public final TimeSource d;
    public final DeleteRemoteMessageInteractor e;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/delete_remote/DeleteRemoteMessageElementProvider$Callback;", "", "", "error", "", "onDeleteRemoteMessageFailure", "(Ljava/lang/Throwable;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public interface Callback {
        void onDeleteRemoteMessageFailure(@NotNull Throwable th);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/delete_remote/DeleteRemoteMessageElementProvider$DeleteRemoteMessageAction;", "Lcom/avito/android/messenger/channels/mvi/common/v4/ActionSingle;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State;", "curState", "Lio/reactivex/Single;", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State;)Lio/reactivex/Single;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;", "d", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;", "contextData", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/delete_remote/DeleteRemoteMessageElementProvider;Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class DeleteRemoteMessageAction extends ActionSingle<MessageMenuPresenter.State> {
        public final MessageContextData d;
        public final /* synthetic */ DeleteRemoteMessageElementProvider e;

        public static final class a<T> implements Consumer<Throwable> {
            public final /* synthetic */ DeleteRemoteMessageAction a;
            public final /* synthetic */ MessageData b;

            public a(DeleteRemoteMessageAction deleteRemoteMessageAction, MessageData messageData) {
                this.a = deleteRemoteMessageAction;
                this.b = messageData;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Consumer
            public void accept(Throwable th) {
                Throwable th2 = th;
                StringBuilder L = a2.b.a.a.a.L("Failed to delete message { remoteId = ");
                L.append(this.b.getRemoteId());
                L.append(", localId = ");
                L.append(this.b.getLocalId());
                L.append(" }");
                Logs.error("DeleteRemoteMessageElementProvider", L.toString(), th2);
                Callback callback = this.a.e.c;
                Intrinsics.checkNotNullExpressionValue(th2, "error");
                callback.onDeleteRemoteMessageFailure(th2);
            }
        }

        public static final class b<T, R> implements Function<Throwable, Unit> {
            public static final b a = new b();

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Function
            public Unit apply(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "it");
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DeleteRemoteMessageAction(@NotNull DeleteRemoteMessageElementProvider deleteRemoteMessageElementProvider, MessageContextData messageContextData) {
            super(null, null, 3, null);
            Intrinsics.checkNotNullParameter(messageContextData, "contextData");
            this.e = deleteRemoteMessageElementProvider;
            this.d = messageContextData;
        }

        @NotNull
        public Single<?> invoke(@NotNull MessageMenuPresenter.State state) {
            Completable completable;
            Intrinsics.checkNotNullParameter(state, "curState");
            MessageData messageData = this.d.getMessageData();
            DeleteRemoteMessageElementProvider deleteRemoteMessageElementProvider = this.e;
            MessageContextData messageContextData = this.d;
            if (!(MessengerTimestamp.fromMillis(deleteRemoteMessageElementProvider.d.now()) < messageContextData.getConfig().getTimeToModifyMessage() + messageContextData.getMessageData().getCreated())) {
                completable = Completable.error(new IllegalStateException("Message is too old to be deleted"));
            } else if (messageData.getRemoteId() == null) {
                completable = Completable.error(new IllegalArgumentException("Message remoteId == null"));
            } else {
                completable = this.e.e.deleteMessage(messageData.getRemoteId());
            }
            Single<?> onErrorReturn = completable.doOnError(new a(this, messageData)).toSingleDefault(Unit.INSTANCE).onErrorReturn(b.a);
            Intrinsics.checkNotNullExpressionValue(onErrorReturn, "when {\n                !…  .onErrorReturn { Unit }");
            return onErrorReturn;
        }
    }

    @Inject
    public DeleteRemoteMessageElementProvider(@NotNull Resources resources, @NotNull Callback callback, @NotNull TimeSource timeSource, @NotNull DeleteRemoteMessageInteractor deleteRemoteMessageInteractor) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(deleteRemoteMessageInteractor, "interactor");
        this.b = resources;
        this.c = callback;
        this.d = timeSource;
        this.e = deleteRemoteMessageInteractor;
    }

    public static final boolean access$messageIsNotTooOldToDelete(DeleteRemoteMessageElementProvider deleteRemoteMessageElementProvider, MessageContextData messageContextData) {
        Objects.requireNonNull(deleteRemoteMessageElementProvider);
        return MessengerTimestamp.fromMillis(deleteRemoteMessageElementProvider.d.now()) < messageContextData.getConfig().getTimeToModifyMessage() + messageContextData.getMessageData().getCreated();
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
        String string = this.b.getString(R.string.messenger_delete_remote_message_confirmation_title);
        String string2 = this.b.getString(R.string.messenger_delete_remote_message_confirmation_message);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st…age_confirmation_message)");
        String string3 = this.b.getString(R.string.messenger_delete_remote_message_confirmation_confirm);
        Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(R.st…age_confirmation_confirm)");
        String string4 = this.b.getString(R.string.messenger_delete_remote_message_confirmation_cancel);
        Intrinsics.checkNotNullExpressionValue(string4, "resources.getString(R.st…sage_confirmation_cancel)");
        return new ActionConfirmation(string, string2, string3, string4);
    }

    @Override // com.avito.android.messenger.conversation.mvi.message_menu.MenuElementProvider
    @Nullable
    public MenuElement getMenuElement(@NotNull MessageContextData messageContextData) {
        Intrinsics.checkNotNullParameter(messageContextData, "contextData");
        boolean z = false;
        if (!(messageContextData instanceof MessageContextData.LinkInText) && messageContextData.getMessageData().isSentByUserDirectly() && Intrinsics.areEqual(messageContextData.getMessageData().getUserId(), messageContextData.getMessageData().getFromId()) && messageContextData.getMessageData().getRemoteId() != null) {
            if (MessengerTimestamp.fromMillis(this.d.now()) < messageContextData.getConfig().getTimeToModifyMessage() + messageContextData.getMessageData().getCreated()) {
                z = true;
            }
        }
        if (z) {
            return new MenuElement.Action(getActionId(), R.string.messenger_delete_remote_message, com.avito.android.ui_components.R.drawable.ic_rds_trash_24);
        }
        return null;
    }

    @Override // com.avito.android.messenger.conversation.mvi.message_menu.ClickableMenuElementProvider
    @NotNull
    public Reducible<MessageMenuPresenter.State> getReducible(@NotNull MessageContextData messageContextData) {
        Intrinsics.checkNotNullParameter(messageContextData, "contextData");
        return new DeleteRemoteMessageAction(this, messageContextData);
    }
}

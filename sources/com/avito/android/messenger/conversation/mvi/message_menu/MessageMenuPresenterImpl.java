package com.avito.android.messenger.conversation.mvi.message_menu;

import androidx.annotation.VisibleForTesting;
import com.avito.android.messenger.channels.mvi.common.v4.BaseMviEntityWithReducerQueue;
import com.avito.android.messenger.channels.mvi.common.v4.Mutator;
import com.avito.android.messenger.channels.mvi.common.v4.ReducerQueue;
import com.avito.android.messenger.channels.mvi.common.v4.SimpleReducerQueue;
import com.avito.android.messenger.conversation.ChannelItem;
import com.avito.android.messenger.conversation.mvi.message_menu.MenuElement;
import com.avito.android.messenger.conversation.mvi.message_menu.MessageMenuPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.messenger.ActionConfirmation;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import com.avito.android.util.SchedulersFactory;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.config.MessengerConfig;
import ru.avito.messenger.config.MessengerConfigProvider;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u000501234BB\b\u0007\u0012\u0011\u0010&\u001a\r\u0012\t\u0012\u00070\u0017¢\u0006\u0002\b#0\u0016\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010(\u001a\u00020'\u0012\u0006\u0010*\u001a\u00020)\u0012\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00030+¢\u0006\u0004\b-\u0010.B4\b\u0017\u0012\u0011\u0010&\u001a\r\u0012\t\u0012\u00070\u0017¢\u0006\u0002\b#0\u0016\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010(\u001a\u00020'\u0012\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b-\u0010/J\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u000f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0006J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0006J!\u0010\u0019\u001a\u0004\u0018\u00010\u0018*\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0012\u001a\u00020\r¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R!\u0010&\u001a\r\u0012\t\u0012\u00070\u0017¢\u0006\u0002\b#0\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u00065"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenterImpl;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter;", "Lcom/avito/android/messenger/channels/mvi/common/v4/BaseMviEntityWithReducerQueue;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State;", "", "onCleared", "()V", "Lcom/avito/android/messenger/conversation/ChannelItem$Message$BodyOrBubble;", "bodyOrBubble", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "localMessage", "showMenuForMessage", "(Lcom/avito/android/messenger/conversation/ChannelItem$Message$BodyOrBubble;Lcom/avito/android/remote/model/messenger/message/LocalMessage;)V", "", "url", "showMenuForLink", "(Lcom/avito/android/messenger/conversation/ChannelItem$Message$BodyOrBubble;Lcom/avito/android/remote/model/messenger/message/LocalMessage;Ljava/lang/String;)V", "dismissMenu", "actionId", "onActionClicked", "(Ljava/lang/String;)V", "onActionConfirmed", "", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MenuElementProvider;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/ClickableMenuElementProvider;", "findClickableElementById", "(Ljava/util/List;Ljava/lang/String;)Lcom/avito/android/messenger/conversation/mvi/message_menu/ClickableMenuElementProvider;", "Lio/reactivex/disposables/CompositeDisposable;", "p", "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextDataFactory;", "r", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextDataFactory;", "contextDataFactory", "Lkotlin/jvm/JvmSuppressWildcards;", VKApiConst.Q, "Ljava/util/List;", "menuElementProviders", "Lru/avito/messenger/config/MessengerConfigProvider;", "configProvider", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/messenger/channels/mvi/common/v4/ReducerQueue;", "reducerQueue", "<init>", "(Ljava/util/List;Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextDataFactory;Lru/avito/messenger/config/MessengerConfigProvider;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/messenger/channels/mvi/common/v4/ReducerQueue;)V", "(Ljava/util/List;Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextDataFactory;Lru/avito/messenger/config/MessengerConfigProvider;Lcom/avito/android/util/SchedulersFactory;)V", "DismissMenuMutator", "NewMessengerConfigMutator", "OnActionClickedMutator", "OnActionConfirmedMutator", "ShowMenuMutator", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessageMenuPresenterImpl extends BaseMviEntityWithReducerQueue<MessageMenuPresenter.State> implements MessageMenuPresenter {
    public final CompositeDisposable p;
    public final List<MenuElementProvider> q;
    public final MessageContextDataFactory r;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenterImpl$DismissMenuMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State;)Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State;", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenterImpl;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class DismissMenuMutator extends Mutator<MessageMenuPresenter.State> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public DismissMenuMutator(MessageMenuPresenterImpl messageMenuPresenterImpl) {
            super(null, null, 3, null);
        }

        @NotNull
        public MessageMenuPresenter.State invoke(@NotNull MessageMenuPresenter.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            if (Intrinsics.areEqual(state, MessageMenuPresenter.State.Empty.INSTANCE) || (state instanceof MessageMenuPresenter.State.Hidden)) {
                return state;
            }
            if (state instanceof MessageMenuPresenter.State.Shown) {
                return new MessageMenuPresenter.State.Hidden(((MessageMenuPresenter.State.Shown) state).getConfig());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenterImpl$NewMessengerConfigMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State;)Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State;", "Lru/avito/messenger/config/MessengerConfig;", "d", "Lru/avito/messenger/config/MessengerConfig;", Navigation.CONFIG, "<init>", "(Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenterImpl;Lru/avito/messenger/config/MessengerConfig;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class NewMessengerConfigMutator extends Mutator<MessageMenuPresenter.State> {
        public final MessengerConfig d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NewMessengerConfigMutator(@NotNull MessageMenuPresenterImpl messageMenuPresenterImpl, MessengerConfig messengerConfig) {
            super(null, null, 3, null);
            Intrinsics.checkNotNullParameter(messengerConfig, Navigation.CONFIG);
            this.d = messengerConfig;
        }

        @NotNull
        public MessageMenuPresenter.State invoke(@NotNull MessageMenuPresenter.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            return Intrinsics.areEqual(state.getConfig(), this.d) ^ true ? new MessageMenuPresenter.State.Hidden(this.d) : state;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenterImpl$OnActionClickedMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State;)Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State;", "", "d", "Ljava/lang/String;", "actionId", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenterImpl;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class OnActionClickedMutator extends Mutator<MessageMenuPresenter.State> {
        public final String d;
        public final /* synthetic */ MessageMenuPresenterImpl e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OnActionClickedMutator(@NotNull MessageMenuPresenterImpl messageMenuPresenterImpl, String str) {
            super(null, null, 3, null);
            Intrinsics.checkNotNullParameter(str, "actionId");
            this.e = messageMenuPresenterImpl;
            this.d = str;
        }

        @NotNull
        public MessageMenuPresenter.State invoke(@NotNull MessageMenuPresenter.State state) {
            Object obj;
            Intrinsics.checkNotNullParameter(state, "oldState");
            if (Intrinsics.areEqual(state, MessageMenuPresenter.State.Empty.INSTANCE) || (state instanceof MessageMenuPresenter.State.Hidden) || (state instanceof MessageMenuPresenter.State.Shown.Confirmation)) {
                return state;
            }
            if (state instanceof MessageMenuPresenter.State.Shown.Menu) {
                MessageMenuPresenter.State.Shown.Menu menu = (MessageMenuPresenter.State.Shown.Menu) state;
                List<MenuElement> menuItems = menu.getMenuItems();
                ArrayList arrayList = new ArrayList();
                for (T t : menuItems) {
                    if (t instanceof MenuElement.Action) {
                        arrayList.add(t);
                    }
                }
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (Intrinsics.areEqual(((MenuElement.Action) obj).getId(), this.d)) {
                        break;
                    }
                }
                if (((MenuElement.Action) obj) == null) {
                    return state;
                }
                MessageMenuPresenterImpl messageMenuPresenterImpl = this.e;
                ClickableMenuElementProvider findClickableElementById = messageMenuPresenterImpl.findClickableElementById(messageMenuPresenterImpl.q, this.d);
                if (!(findClickableElementById instanceof ClickableMenuElementProvider)) {
                    return state;
                }
                ActionConfirmation confirmation = findClickableElementById.getConfirmation(menu.getContextData());
                if (confirmation != null) {
                    return new MessageMenuPresenter.State.Shown.Confirmation(menu.getConfig(), menu.getContextData(), this.d, confirmation);
                }
                this.e.getReducerQueue().plusAssign(findClickableElementById.getReducible(menu.getContextData()));
                return new MessageMenuPresenter.State.Hidden(menu.getConfig());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenterImpl$OnActionConfirmedMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State;)Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State;", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenterImpl;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class OnActionConfirmedMutator extends Mutator<MessageMenuPresenter.State> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public OnActionConfirmedMutator() {
            super(null, null, 3, null);
        }

        @NotNull
        public MessageMenuPresenter.State invoke(@NotNull MessageMenuPresenter.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            if (Intrinsics.areEqual(state, MessageMenuPresenter.State.Empty.INSTANCE) || (state instanceof MessageMenuPresenter.State.Hidden) || (state instanceof MessageMenuPresenter.State.Shown.Menu)) {
                return state;
            }
            if (state instanceof MessageMenuPresenter.State.Shown.Confirmation) {
                MessageMenuPresenterImpl messageMenuPresenterImpl = MessageMenuPresenterImpl.this;
                MessageMenuPresenter.State.Shown.Confirmation confirmation = (MessageMenuPresenter.State.Shown.Confirmation) state;
                ClickableMenuElementProvider findClickableElementById = messageMenuPresenterImpl.findClickableElementById(messageMenuPresenterImpl.q, confirmation.getActionId());
                if (findClickableElementById instanceof ClickableMenuElementProvider) {
                    MessageMenuPresenterImpl.this.getReducerQueue().plusAssign(findClickableElementById.getReducible(confirmation.getContextData()));
                }
                return new MessageMenuPresenter.State.Hidden(confirmation.getConfig());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenterImpl$ShowMenuMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State;)Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;", "contextData", "", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MenuElement;", AuthSource.SEND_ABUSE, "(Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;)Ljava/util/List;", "Lcom/avito/android/messenger/conversation/ChannelItem$Message$BodyOrBubble;", "d", "Lcom/avito/android/messenger/conversation/ChannelItem$Message$BodyOrBubble;", "bodyOrBubble", "", "f", "Ljava/lang/String;", "url", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "e", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "localMessage", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenterImpl;Lcom/avito/android/messenger/conversation/ChannelItem$Message$BodyOrBubble;Lcom/avito/android/remote/model/messenger/message/LocalMessage;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class ShowMenuMutator extends Mutator<MessageMenuPresenter.State> {
        public final ChannelItem.Message.BodyOrBubble d;
        public final LocalMessage e;
        public final String f;
        public final /* synthetic */ MessageMenuPresenterImpl g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ShowMenuMutator(@NotNull MessageMenuPresenterImpl messageMenuPresenterImpl, @NotNull ChannelItem.Message.BodyOrBubble bodyOrBubble, @Nullable LocalMessage localMessage, String str) {
            super(null, null, 3, null);
            Intrinsics.checkNotNullParameter(bodyOrBubble, "bodyOrBubble");
            Intrinsics.checkNotNullParameter(localMessage, "localMessage");
            this.g = messageMenuPresenterImpl;
            this.d = bodyOrBubble;
            this.e = localMessage;
            this.f = str;
        }

        public final List<MenuElement> a(MessageContextData messageContextData) {
            List<MenuElementProvider> list = this.g.q;
            ArrayList arrayList = new ArrayList();
            for (MenuElementProvider menuElementProvider : list) {
                MenuElement menuElement = menuElementProvider.getMenuElement(messageContextData);
                if (menuElement != null) {
                    arrayList.add(menuElement);
                }
            }
            return arrayList;
        }

        @NotNull
        public MessageMenuPresenter.State invoke(@NotNull MessageMenuPresenter.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            if (Intrinsics.areEqual(state, MessageMenuPresenter.State.Empty.INSTANCE)) {
                return state;
            }
            if (state instanceof MessageMenuPresenter.State.Hidden) {
                MessageMenuPresenter.State.Hidden hidden = (MessageMenuPresenter.State.Hidden) state;
                MessageContextData createContextData = this.g.r.createContextData(hidden.getConfig(), this.d, this.e, this.f);
                if (createContextData == null) {
                    return state;
                }
                List<MenuElement> a = a(createContextData);
                if (!a.isEmpty()) {
                    return new MessageMenuPresenter.State.Shown.Menu(hidden.getConfig(), createContextData, a);
                }
                return state;
            } else if (state instanceof MessageMenuPresenter.State.Shown) {
                MessageMenuPresenter.State.Shown shown = (MessageMenuPresenter.State.Shown) state;
                MessageContextData createContextData2 = this.g.r.createContextData(shown.getConfig(), this.d, this.e, this.f);
                if (createContextData2 == null) {
                    return new MessageMenuPresenter.State.Hidden(shown.getConfig());
                }
                if (!(!Intrinsics.areEqual(createContextData2, shown.getContextData()))) {
                    return state;
                }
                List<MenuElement> a3 = a(createContextData2);
                if (!a3.isEmpty()) {
                    return new MessageMenuPresenter.State.Shown.Menu(shown.getConfig(), createContextData2, a3);
                }
                return new MessageMenuPresenter.State.Hidden(shown.getConfig());
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ShowMenuMutator(MessageMenuPresenterImpl messageMenuPresenterImpl, ChannelItem.Message.BodyOrBubble bodyOrBubble, LocalMessage localMessage, String str, int i, j jVar) {
            this(messageMenuPresenterImpl, bodyOrBubble, localMessage, (i & 4) != 0 ? null : str);
        }
    }

    public static final class a<T> implements Consumer<MessengerConfig> {
        public final /* synthetic */ MessageMenuPresenterImpl a;
        public final /* synthetic */ ReducerQueue b;

        public a(MessageMenuPresenterImpl messageMenuPresenterImpl, ReducerQueue reducerQueue) {
            this.a = messageMenuPresenterImpl;
            this.b = reducerQueue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(MessengerConfig messengerConfig) {
            MessengerConfig messengerConfig2 = messengerConfig;
            ReducerQueue reducerQueue = this.b;
            MessageMenuPresenterImpl messageMenuPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(messengerConfig2, Navigation.CONFIG);
            reducerQueue.plusAssign(new NewMessengerConfigMutator(messageMenuPresenterImpl, messengerConfig2));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @VisibleForTesting
    public MessageMenuPresenterImpl(@NotNull List<MenuElementProvider> list, @NotNull MessageContextDataFactory messageContextDataFactory, @NotNull MessengerConfigProvider messengerConfigProvider, @NotNull SchedulersFactory schedulersFactory, @NotNull ReducerQueue<MessageMenuPresenter.State> reducerQueue) {
        super("MessageActionsMenuPresenter", MessageMenuPresenter.State.Empty.INSTANCE, schedulersFactory, null, reducerQueue, null, null, null, 232, null);
        Intrinsics.checkNotNullParameter(list, "menuElementProviders");
        Intrinsics.checkNotNullParameter(messageContextDataFactory, "contextDataFactory");
        Intrinsics.checkNotNullParameter(messengerConfigProvider, "configProvider");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(reducerQueue, "reducerQueue");
        this.q = list;
        this.r = messageContextDataFactory;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.p = compositeDisposable;
        Disposable subscribe = messengerConfigProvider.getConfig().observeOn(schedulersFactory.computation()).subscribe(new a(this, reducerQueue));
        Intrinsics.checkNotNullExpressionValue(subscribe, "configProvider.config\n  …tor(config)\n            }");
        DisposableKt.addTo(subscribe, compositeDisposable);
    }

    @Override // com.avito.android.messenger.conversation.mvi.message_menu.MessageMenuPresenter
    public void dismissMenu() {
        getReducerQueue().plusAssign(new DismissMenuMutator(this));
    }

    @Nullable
    public final ClickableMenuElementProvider findClickableElementById(@NotNull List<? extends MenuElementProvider> list, @NotNull String str) {
        Object obj;
        Intrinsics.checkNotNullParameter(list, "$this$findClickableElementById");
        Intrinsics.checkNotNullParameter(str, "actionId");
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            if (t instanceof ClickableMenuElementProvider) {
                arrayList.add(t);
            }
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((ClickableMenuElementProvider) obj).getActionId(), str)) {
                break;
            }
        }
        return (ClickableMenuElementProvider) obj;
    }

    @Override // com.avito.android.messenger.conversation.mvi.message_menu.MessageMenuPresenter
    public void onActionClicked(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "actionId");
        getReducerQueue().plusAssign(new OnActionClickedMutator(this, str));
    }

    @Override // com.avito.android.messenger.conversation.mvi.message_menu.MessageMenuPresenter
    public void onActionConfirmed() {
        getReducerQueue().plusAssign(new OnActionConfirmedMutator());
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v4.BaseMviEntityWithReducerQueue, androidx.lifecycle.ViewModel
    public void onCleared() {
        this.p.clear();
        super.onCleared();
    }

    @Override // com.avito.android.messenger.conversation.mvi.message_menu.MessageMenuPresenter
    public void showMenuForLink(@NotNull ChannelItem.Message.BodyOrBubble bodyOrBubble, @NotNull LocalMessage localMessage, @NotNull String str) {
        Intrinsics.checkNotNullParameter(bodyOrBubble, "bodyOrBubble");
        Intrinsics.checkNotNullParameter(localMessage, "localMessage");
        Intrinsics.checkNotNullParameter(str, "url");
        getReducerQueue().plusAssign(new ShowMenuMutator(this, bodyOrBubble, localMessage, str));
    }

    @Override // com.avito.android.messenger.conversation.mvi.message_menu.MessageMenuPresenter
    public void showMenuForMessage(@NotNull ChannelItem.Message.BodyOrBubble bodyOrBubble, @NotNull LocalMessage localMessage) {
        Intrinsics.checkNotNullParameter(bodyOrBubble, "bodyOrBubble");
        Intrinsics.checkNotNullParameter(localMessage, "localMessage");
        getReducerQueue().plusAssign(new ShowMenuMutator(this, bodyOrBubble, localMessage, null, 4, null));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Inject
    public MessageMenuPresenterImpl(@NotNull List<MenuElementProvider> list, @NotNull MessageContextDataFactory messageContextDataFactory, @NotNull MessengerConfigProvider messengerConfigProvider, @NotNull SchedulersFactory schedulersFactory) {
        this(list, messageContextDataFactory, messengerConfigProvider, schedulersFactory, new SimpleReducerQueue(schedulersFactory.io(), null, 2, null));
        Intrinsics.checkNotNullParameter(list, "menuElementProviders");
        Intrinsics.checkNotNullParameter(messageContextDataFactory, "contextDataFactory");
        Intrinsics.checkNotNullParameter(messengerConfigProvider, "configProvider");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
    }
}

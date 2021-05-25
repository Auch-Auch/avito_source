package com.avito.android.messenger.conversation.mvi.new_messages;

import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import com.avito.android.messenger.channels.mvi.common.v2.Action;
import com.avito.android.messenger.channels.mvi.common.v2.ActionSingle;
import com.avito.android.messenger.channels.mvi.common.v2.BaseMviEntityWithMutatorsRelay;
import com.avito.android.messenger.channels.mvi.common.v2.Mutator;
import com.avito.android.messenger.channels.mvi.common.v2.MutatorSingle;
import com.avito.android.messenger.conversation.ChannelItem;
import com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractor;
import com.avito.android.messenger.conversation.mvi.data.MessageRepo;
import com.avito.android.messenger.conversation.mvi.new_messages.NewMessagesView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.jakewharton.rxrelay2.Relay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0006456789B7\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010.\u001a\u00020-\u0012\u0006\u00100\u001a\u00020/\u0012\u0006\u00101\u001a\u00020\u0003¢\u0006\u0004\b2\u00103J\u000f\u0010\u0005\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\u0006J\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\"\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u001b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006:"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/new_messages/NewMessagesPresenterImpl;", "Lcom/avito/android/messenger/conversation/mvi/new_messages/NewMessagesPresenter;", "Lcom/avito/android/messenger/channels/mvi/common/v2/BaseMviEntityWithMutatorsRelay;", "Lcom/avito/android/messenger/conversation/mvi/new_messages/NewMessagesView$State;", "", "onStart", "()V", "onStop", "onCleared", "onInitialScrollPerformed", "", "isScrolledToBottom", "onScrolledToBottomChanged", "(Z)V", "Lcom/avito/android/messenger/conversation/ChannelItem;", "oldBottomItem", "newBottomItem", "onNewListItems", "(Lcom/avito/android/messenger/conversation/ChannelItem;Lcom/avito/android/messenger/conversation/ChannelItem;)V", "Lcom/avito/android/server_time/TimeSource;", "r", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Ljava/util/concurrent/atomic/AtomicBoolean;", "n", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isStarted", "Landroidx/lifecycle/MutableLiveData;", "o", "Landroidx/lifecycle/MutableLiveData;", "getScrollToBottomStream", "()Landroidx/lifecycle/MutableLiveData;", "scrollToBottomStream", "Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;", VKApiConst.Q, "Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;", "messageRepo", "", "p", "Ljava/lang/String;", "channelId", "Lio/reactivex/disposables/CompositeDisposable;", AuthSource.OPEN_CHANNEL_LIST, "Lio/reactivex/disposables/CompositeDisposable;", "backendNotificationsSubscription", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor;", "channelContextInteractor", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "defaultState", "<init>", "(Ljava/lang/String;Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/messenger/conversation/mvi/new_messages/NewMessagesView$State;)V", "InitialScrollPerformedMutator", "MarkMessagesAsReadAction", "OnNewListItemsAction", "OnScrolledToBottomChangedMutator", "UnreadMessageCountChangedMutator", "UserIdChangedMutator", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class NewMessagesPresenterImpl extends BaseMviEntityWithMutatorsRelay<NewMessagesView.State> implements NewMessagesPresenter {
    public final CompositeDisposable m;
    public final AtomicBoolean n = new AtomicBoolean(false);
    @NotNull
    public final MutableLiveData<Unit> o = new SingleLiveEvent();
    public final String p;
    public final MessageRepo q;
    public final TimeSource r;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/new_messages/NewMessagesPresenterImpl$InitialScrollPerformedMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Mutator;", "Lcom/avito/android/messenger/conversation/mvi/new_messages/NewMessagesView$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/new_messages/NewMessagesView$State;)Lcom/avito/android/messenger/conversation/mvi/new_messages/NewMessagesView$State;", "Lkotlin/Function0;", "", "c", "Lkotlin/jvm/functions/Function0;", "markMessagesAsRead", "", "d", "Z", "markChatAsReadImmediately", "<init>", "(Lkotlin/jvm/functions/Function0;Z)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @VisibleForTesting(otherwise = 3)
    public static final class InitialScrollPerformedMutator extends Mutator<NewMessagesView.State> {
        public final Function0<Unit> c;
        public final boolean d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public InitialScrollPerformedMutator(@NotNull Function0<Unit> function0, boolean z) {
            super("InitialScrollPerformedMutator");
            Intrinsics.checkNotNullParameter(function0, "markMessagesAsRead");
            this.c = function0;
            this.d = z;
        }

        @NotNull
        public NewMessagesView.State invoke(@NotNull NewMessagesView.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            if (state instanceof NewMessagesView.State.Empty) {
                return state;
            }
            if (!(state instanceof NewMessagesView.State.Loaded)) {
                throw new NoWhenBranchMatchedException();
            } else if (state.getInitialScrollPerformed()) {
                return (NewMessagesView.State.Loaded) state;
            } else {
                if (this.d || Intrinsics.areEqual(state.isScrolledToBottom(), Boolean.TRUE)) {
                    this.c.invoke();
                }
                return NewMessagesView.State.Loaded.copy$default((NewMessagesView.State.Loaded) state, null, null, true, 0, 11, null);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u001c\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/new_messages/NewMessagesPresenterImpl$MarkMessagesAsReadAction;", "Lcom/avito/android/messenger/channels/mvi/common/v2/ActionSingle;", "Lcom/avito/android/messenger/conversation/mvi/new_messages/NewMessagesView$State;", "curState", "Lio/reactivex/Single;", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/new_messages/NewMessagesView$State;)Lio/reactivex/Single;", "Lcom/avito/android/server_time/TimeSource;", "f", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Lio/reactivex/Scheduler;", "e", "Lio/reactivex/Scheduler;", "scheduler", "Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;", "d", "Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;", "messageRepo", "", "c", "Ljava/lang/String;", "channelId", "<init>", "(Ljava/lang/String;Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;Lio/reactivex/Scheduler;Lcom/avito/android/server_time/TimeSource;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @VisibleForTesting(otherwise = 3)
    public static final class MarkMessagesAsReadAction extends ActionSingle<NewMessagesView.State> {
        public final String c;
        public final MessageRepo d;
        public final Scheduler e;
        public final TimeSource f;

        public static final class a<T> implements Consumer<Throwable> {
            public static final a a = new a();

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Consumer
            public void accept(Throwable th) {
                Logs.debug("NewMessagesPresenter", "Failed to mark messages as read locally", th);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MarkMessagesAsReadAction(@NotNull String str, @NotNull MessageRepo messageRepo, @NotNull Scheduler scheduler, @NotNull TimeSource timeSource) {
            super(null, 1, null);
            Intrinsics.checkNotNullParameter(str, "channelId");
            Intrinsics.checkNotNullParameter(messageRepo, "messageRepo");
            Intrinsics.checkNotNullParameter(scheduler, "scheduler");
            Intrinsics.checkNotNullParameter(timeSource, "timeSource");
            this.c = str;
            this.d = messageRepo;
            this.e = scheduler;
            this.f = timeSource;
        }

        @NotNull
        public Single<?> invoke(@NotNull NewMessagesView.State state) {
            Intrinsics.checkNotNullParameter(state, "curState");
            if (state.getUserId().length() > 0) {
                Single<?> singleDefault = this.d.setIsReadLocallyForMessagesInChannel(state.getUserId(), this.c, this.f.now()).subscribeOn(this.e).doOnError(a.a).onErrorComplete().toSingleDefault(Unit.INSTANCE);
                Intrinsics.checkNotNullExpressionValue(singleDefault, "messageRepo.setIsReadLoc…   .toSingleDefault(Unit)");
                return singleDefault;
            }
            Single<?> just = Single.just(Unit.INSTANCE);
            Intrinsics.checkNotNullExpressionValue(just, "Single.just(Unit)");
            return just;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/new_messages/NewMessagesPresenterImpl$OnNewListItemsAction;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Action;", "Lcom/avito/android/messenger/conversation/mvi/new_messages/NewMessagesView$State;", "curState", "", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/new_messages/NewMessagesView$State;)V", "Lcom/avito/android/messenger/conversation/ChannelItem;", "c", "Lcom/avito/android/messenger/conversation/ChannelItem;", "oldBottomItem", "Landroidx/lifecycle/MutableLiveData;", "e", "Landroidx/lifecycle/MutableLiveData;", "scrollToBottomStream", "d", "newBottomItem", "<init>", "(Lcom/avito/android/messenger/conversation/ChannelItem;Lcom/avito/android/messenger/conversation/ChannelItem;Landroidx/lifecycle/MutableLiveData;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @VisibleForTesting(otherwise = 3)
    public static final class OnNewListItemsAction extends Action<NewMessagesView.State> {
        public final ChannelItem c;
        public final ChannelItem d;
        public final MutableLiveData<Unit> e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OnNewListItemsAction(@NotNull ChannelItem channelItem, @NotNull ChannelItem channelItem2, @NotNull MutableLiveData<Unit> mutableLiveData) {
            super("OnNewListItemsAction(oldBottomItem = " + channelItem + ", newBottomItem = " + channelItem2 + ')');
            Intrinsics.checkNotNullParameter(channelItem, "oldBottomItem");
            Intrinsics.checkNotNullParameter(channelItem2, "newBottomItem");
            Intrinsics.checkNotNullParameter(mutableLiveData, "scrollToBottomStream");
            this.c = channelItem;
            this.d = channelItem2;
            this.e = mutableLiveData;
        }

        public void invoke(@NotNull NewMessagesView.State state) {
            Intrinsics.checkNotNullParameter(state, "curState");
            if (state.getInitialScrollPerformed()) {
                if (!(this.c instanceof ChannelItem.TypingIndicator)) {
                    ChannelItem channelItem = this.d;
                    if ((channelItem instanceof ChannelItem.Message) && ((ChannelItem.Message) channelItem).isMy()) {
                        Logs.verbose$default("NewMessagesPresenter", getName() + ":\n\t newBottomItem is ChannelItem.Message && newBottomItem.isMy \n\t => Scroll to bottom", null, 4, null);
                        this.e.postValue(Unit.INSTANCE);
                        return;
                    }
                }
                if (Intrinsics.areEqual(state.isScrolledToBottom(), Boolean.TRUE)) {
                    Logs.verbose$default("NewMessagesPresenter", getName() + ":\n\t (newBottomItem !is ChannelItem.Message || !newBottomItem.isMy) && curState.isScrolledToBottom \n\t => Scroll to bottom", null, 4, null);
                    this.e.postValue(Unit.INSTANCE);
                    return;
                }
                Logs.verbose$default("NewMessagesPresenter", getName() + ":\n\t (newBottomItem !is ChannelItem.Message || !newBottomItem.isMy) && !curState.isScrolledToBottom \n\t => Don't scroll to bottom", null, 4, null);
                return;
            }
            Logs.verbose$default("NewMessagesPresenter", getName() + ":\n\t initialScrollPerformed == false \n\t => Don't scroll to bottom", null, 4, null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/new_messages/NewMessagesPresenterImpl$OnScrolledToBottomChangedMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Mutator;", "Lcom/avito/android/messenger/conversation/mvi/new_messages/NewMessagesView$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/new_messages/NewMessagesView$State;)Lcom/avito/android/messenger/conversation/mvi/new_messages/NewMessagesView$State;", "", "c", "Z", "isScrolledToBottom", "Lkotlin/Function0;", "", "d", "Lkotlin/jvm/functions/Function0;", "markMessagesAsRead", "<init>", "(ZLkotlin/jvm/functions/Function0;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @VisibleForTesting(otherwise = 3)
    public static final class OnScrolledToBottomChangedMutator extends Mutator<NewMessagesView.State> {
        public final boolean c;
        public final Function0<Unit> d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OnScrolledToBottomChangedMutator(boolean z, @NotNull Function0<Unit> function0) {
            super("OnScrolledToBottomChangedMutator(isScrolledToBottom=" + z + ')');
            Intrinsics.checkNotNullParameter(function0, "markMessagesAsRead");
            this.c = z;
            this.d = function0;
        }

        @NotNull
        public NewMessagesView.State invoke(@NotNull NewMessagesView.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            if (state instanceof NewMessagesView.State.Loaded) {
                boolean z = !Intrinsics.areEqual(Boolean.valueOf(this.c), state.isScrolledToBottom());
                if (this.c && state.getInitialScrollPerformed() && (z || state.getUnreadMessageCount() > 0)) {
                    this.d.invoke();
                }
                if (z) {
                    return NewMessagesView.State.Loaded.copy$default((NewMessagesView.State.Loaded) state, null, Boolean.valueOf(this.c), false, 0, 13, null);
                }
                return (NewMessagesView.State.Loaded) state;
            } else if (state instanceof NewMessagesView.State.Empty) {
                return state;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/new_messages/NewMessagesPresenterImpl$UnreadMessageCountChangedMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Mutator;", "Lcom/avito/android/messenger/conversation/mvi/new_messages/NewMessagesView$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/new_messages/NewMessagesView$State;)Lcom/avito/android/messenger/conversation/mvi/new_messages/NewMessagesView$State;", "Lkotlin/Function0;", "", "d", "Lkotlin/jvm/functions/Function0;", "markMessagesAsRead", "Ljava/util/concurrent/atomic/AtomicBoolean;", "e", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isStarted", "", "c", "I", "unreadMessageCount", "<init>", "(ILkotlin/jvm/functions/Function0;Ljava/util/concurrent/atomic/AtomicBoolean;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @VisibleForTesting(otherwise = 3)
    public static final class UnreadMessageCountChangedMutator extends Mutator<NewMessagesView.State> {
        public final int c;
        public final Function0<Unit> d;
        public final AtomicBoolean e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public UnreadMessageCountChangedMutator(int i, @NotNull Function0<Unit> function0, @NotNull AtomicBoolean atomicBoolean) {
            super("UnreadMessageCountChangedMutator(unreadMessageCount=" + i + ')');
            Intrinsics.checkNotNullParameter(function0, "markMessagesAsRead");
            Intrinsics.checkNotNullParameter(atomicBoolean, "isStarted");
            this.c = i;
            this.d = function0;
            this.e = atomicBoolean;
        }

        @NotNull
        public NewMessagesView.State invoke(@NotNull NewMessagesView.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            if (state instanceof NewMessagesView.State.Loaded) {
                if (Intrinsics.areEqual(state.isScrolledToBottom(), Boolean.TRUE) && state.getInitialScrollPerformed() && this.c > 0 && this.e.get()) {
                    this.d.invoke();
                }
                return NewMessagesView.State.Loaded.copy$default((NewMessagesView.State.Loaded) state, null, null, false, this.c, 7, null);
            } else if (state instanceof NewMessagesView.State.Empty) {
                return state;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/new_messages/NewMessagesPresenterImpl$UserIdChangedMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Mutator;", "Lcom/avito/android/messenger/conversation/mvi/new_messages/NewMessagesView$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/new_messages/NewMessagesView$State;)Lcom/avito/android/messenger/conversation/mvi/new_messages/NewMessagesView$State;", "", "c", "Ljava/lang/String;", ChannelContext.Item.USER_ID, "<init>", "(Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @VisibleForTesting(otherwise = 3)
    public static final class UserIdChangedMutator extends Mutator<NewMessagesView.State> {
        public final String c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public UserIdChangedMutator(@NotNull String str) {
            super(null, 1, null);
            Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
            this.c = str;
        }

        @NotNull
        public NewMessagesView.State invoke(@NotNull NewMessagesView.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            if (this.c.length() == 0) {
                return new NewMessagesView.State.Empty(state.isScrolledToBottom());
            }
            if (state instanceof NewMessagesView.State.Empty) {
                return new NewMessagesView.State.Loaded(this.c, state.isScrolledToBottom(), false, 0, 12, null);
            }
            if (state instanceof NewMessagesView.State.Loaded) {
                return NewMessagesView.State.Loaded.copy$default((NewMessagesView.State.Loaded) state, this.c, null, false, 0, 14, null);
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class a<T> implements Consumer<String> {
        public final /* synthetic */ NewMessagesPresenterImpl a;

        public a(NewMessagesPresenterImpl newMessagesPresenterImpl) {
            this.a = newMessagesPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.jakewharton.rxrelay2.Relay */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(String str) {
            String str2 = str;
            Relay mutatorsRelay = this.a.getMutatorsRelay();
            Intrinsics.checkNotNullExpressionValue(str2, ChannelContext.Item.USER_ID);
            UserIdChangedMutator userIdChangedMutator = new UserIdChangedMutator(str2);
            mutatorsRelay.accept(new MutatorSingle(userIdChangedMutator.getName(), new NewMessagesPresenterImpl$1$$special$$inlined$plusAssign$1(userIdChangedMutator)));
        }
    }

    public static final class b<T, R> implements Function<String, ObservableSource<? extends Integer>> {
        public final /* synthetic */ NewMessagesPresenterImpl a;
        public final /* synthetic */ SchedulersFactory b;

        public b(NewMessagesPresenterImpl newMessagesPresenterImpl, SchedulersFactory schedulersFactory) {
            this.a = newMessagesPresenterImpl;
            this.b = schedulersFactory;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends Integer> apply(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, ChannelContext.Item.USER_ID);
            if (str2.length() > 0) {
                return this.a.q.getUnreadMessagesCount(str2, this.a.p).subscribeOn(this.b.io());
            }
            return Observable.empty();
        }
    }

    public static final class c<T> implements Consumer<Integer> {
        public final /* synthetic */ NewMessagesPresenterImpl a;

        public c(NewMessagesPresenterImpl newMessagesPresenterImpl) {
            this.a = newMessagesPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.jakewharton.rxrelay2.Relay */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Integer num) {
            Integer num2 = num;
            Relay mutatorsRelay = this.a.getMutatorsRelay();
            Intrinsics.checkNotNullExpressionValue(num2, "unreadMessageCount");
            UnreadMessageCountChangedMutator unreadMessageCountChangedMutator = new UnreadMessageCountChangedMutator(num2.intValue(), new a2.a.a.o1.d.a0.j.a(this), this.a.n);
            mutatorsRelay.accept(new MutatorSingle(unreadMessageCountChangedMutator.getName(), new NewMessagesPresenterImpl$3$$special$$inlined$plusAssign$1(unreadMessageCountChangedMutator)));
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public final /* synthetic */ NewMessagesPresenterImpl a;

        public d(NewMessagesPresenterImpl newMessagesPresenterImpl) {
            this.a = newMessagesPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            String tag = this.a.getTAG();
            Logs.warning$default(tag, "unreadMessageCount subscription encountered an error: " + th, null, 4, null);
        }
    }

    public static final class e extends Lambda implements Function0<Unit> {
        public final /* synthetic */ NewMessagesPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(NewMessagesPresenterImpl newMessagesPresenterImpl) {
            super(0);
            this.a = newMessagesPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            NewMessagesPresenterImpl.access$markMessagesAsRead(this.a);
            return Unit.INSTANCE;
        }
    }

    public static final class f extends Lambda implements Function0<Unit> {
        public final /* synthetic */ NewMessagesPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(NewMessagesPresenterImpl newMessagesPresenterImpl) {
            super(0);
            this.a = newMessagesPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            NewMessagesPresenterImpl.access$markMessagesAsRead(this.a);
            return Unit.INSTANCE;
        }
    }

    public static final class g<T, R> implements Function<ChannelContextInteractor.State, String> {
        public static final g a = new g();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public String apply(ChannelContextInteractor.State state) {
            ChannelContextInteractor.State state2 = state;
            Intrinsics.checkNotNullParameter(state2, "it");
            return state2.getCurrentUserId();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewMessagesPresenterImpl(@NotNull String str, @NotNull MessageRepo messageRepo, @NotNull TimeSource timeSource, @NotNull ChannelContextInteractor channelContextInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull NewMessagesView.State state) {
        super("NewMessagesPresenter", state, schedulersFactory, null, 8, null);
        Intrinsics.checkNotNullParameter(str, "channelId");
        Intrinsics.checkNotNullParameter(messageRepo, "messageRepo");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(channelContextInteractor, "channelContextInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(state, "defaultState");
        this.p = str;
        this.q = messageRepo;
        this.r = timeSource;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.m = compositeDisposable;
        ConnectableObservable publish = channelContextInteractor.getStateObservable().observeOn(schedulersFactory.computation()).map(g.a).distinctUntilChanged().publish();
        Disposable subscribe = publish.subscribe(new a(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "sharedUserIdStream\n     …dChangedMutator(userId) }");
        DisposableKt.addTo(subscribe, compositeDisposable);
        Disposable subscribe2 = publish.switchMap(new b(this, schedulersFactory)).skip(1).distinctUntilChanged().subscribe(new c(this), new d(this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "sharedUserIdStream\n     …          }\n            )");
        DisposableKt.addTo(subscribe2, compositeDisposable);
        Disposable connect = publish.connect();
        Intrinsics.checkNotNullExpressionValue(connect, "sharedUserIdStream.connect()");
        DisposableKt.addTo(connect, compositeDisposable);
    }

    public static final void access$markMessagesAsRead(NewMessagesPresenterImpl newMessagesPresenterImpl) {
        Relay mutatorsRelay = newMessagesPresenterImpl.getMutatorsRelay();
        MarkMessagesAsReadAction markMessagesAsReadAction = new MarkMessagesAsReadAction(newMessagesPresenterImpl.p, newMessagesPresenterImpl.q, newMessagesPresenterImpl.getSchedulers().io(), newMessagesPresenterImpl.r);
        mutatorsRelay.accept(new MutatorSingle(markMessagesAsReadAction.getName(), new Function1<NewMessagesView.State, Single<NewMessagesView.State>>() { // from class: com.avito.android.messenger.conversation.mvi.new_messages.NewMessagesPresenterImpl$markMessagesAsRead$$inlined$plusAssign$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Single<NewMessagesView.State> invoke(@NotNull final NewMessagesView.State state) {
                Intrinsics.checkNotNullParameter(state, "oldState");
                Single<NewMessagesView.State> onErrorReturn = ((Single) ActionSingle.this.getBlock().invoke(state)).map(new Function<Object, NewMessagesView.State>() { // from class: com.avito.android.messenger.conversation.mvi.new_messages.NewMessagesPresenterImpl$markMessagesAsRead$$inlined$plusAssign$1.1
                    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, com.avito.android.messenger.conversation.mvi.new_messages.NewMessagesView$State] */
                    /* JADX WARNING: Unknown variable types count: 1 */
                    @Override // io.reactivex.functions.Function
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final com.avito.android.messenger.conversation.mvi.new_messages.NewMessagesView.State apply(@org.jetbrains.annotations.NotNull java.lang.Object r2) {
                        /*
                            r1 = this;
                            java.lang.String r0 = "it"
                            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                            java.lang.Object r2 = r3
                            return r2
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.new_messages.NewMessagesPresenterImpl$markMessagesAsRead$$inlined$plusAssign$1.AnonymousClass1.apply(java.lang.Object):java.lang.Object");
                    }
                }).onErrorReturn(new Function<Throwable, NewMessagesView.State>() { // from class: com.avito.android.messenger.conversation.mvi.new_messages.NewMessagesPresenterImpl$markMessagesAsRead$$inlined$plusAssign$1.2
                    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, com.avito.android.messenger.conversation.mvi.new_messages.NewMessagesView$State] */
                    /* JADX WARNING: Unknown variable types count: 1 */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final com.avito.android.messenger.conversation.mvi.new_messages.NewMessagesView.State apply(@org.jetbrains.annotations.NotNull java.lang.Throwable r2) {
                        /*
                            r1 = this;
                            java.lang.String r0 = "it"
                            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                            java.lang.Object r2 = r3
                            return r2
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.new_messages.NewMessagesPresenterImpl$markMessagesAsRead$$inlined$plusAssign$1.AnonymousClass2.apply(java.lang.Throwable):java.lang.Object");
                    }
                });
                Intrinsics.checkNotNullExpressionValue(onErrorReturn, "block(oldState).map { ol…nErrorReturn { oldState }");
                return onErrorReturn;
            }
        }));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private final void onStart() {
        this.n.set(true);
        Logs.verbose$default(getTAG(), "onStart()", null, 4, null);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private final void onStop() {
        this.n.set(false);
        Logs.verbose$default(getTAG(), "onStop()", null, 4, null);
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v2.BaseMviEntity, androidx.lifecycle.ViewModel
    public void onCleared() {
        this.m.dispose();
        super.onCleared();
    }

    @Override // com.avito.android.messenger.conversation.mvi.new_messages.NewMessagesPresenter
    public void onInitialScrollPerformed() {
        Relay mutatorsRelay = getMutatorsRelay();
        InitialScrollPerformedMutator initialScrollPerformedMutator = new InitialScrollPerformedMutator(new e(this), false);
        mutatorsRelay.accept(new MutatorSingle(initialScrollPerformedMutator.getName(), new NewMessagesPresenterImpl$onInitialScrollPerformed$$inlined$plusAssign$1(initialScrollPerformedMutator)));
    }

    @Override // com.avito.android.messenger.conversation.mvi.new_messages.NewMessagesPresenter
    public void onNewListItems(@NotNull ChannelItem channelItem, @NotNull ChannelItem channelItem2) {
        Intrinsics.checkNotNullParameter(channelItem, "oldBottomItem");
        Intrinsics.checkNotNullParameter(channelItem2, "newBottomItem");
        Relay mutatorsRelay = getMutatorsRelay();
        OnNewListItemsAction onNewListItemsAction = new OnNewListItemsAction(channelItem, channelItem2, getScrollToBottomStream());
        mutatorsRelay.accept(new MutatorSingle(onNewListItemsAction.getName(), new NewMessagesPresenterImpl$onNewListItems$$inlined$plusAssign$1(onNewListItemsAction)));
    }

    @Override // com.avito.android.messenger.conversation.mvi.new_messages.NewMessagesPresenter
    public void onScrolledToBottomChanged(boolean z) {
        Relay mutatorsRelay = getMutatorsRelay();
        OnScrolledToBottomChangedMutator onScrolledToBottomChangedMutator = new OnScrolledToBottomChangedMutator(z, new f(this));
        mutatorsRelay.accept(new MutatorSingle(onScrolledToBottomChangedMutator.getName(), new NewMessagesPresenterImpl$onScrolledToBottomChanged$$inlined$plusAssign$1(onScrolledToBottomChangedMutator)));
    }

    @Override // com.avito.android.messenger.conversation.mvi.new_messages.NewMessagesPresenter
    @NotNull
    public MutableLiveData<Unit> getScrollToBottomStream() {
        return this.o;
    }
}

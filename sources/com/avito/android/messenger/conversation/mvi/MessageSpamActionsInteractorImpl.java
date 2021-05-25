package com.avito.android.messenger.conversation.mvi;

import arrow.core.Option;
import arrow.core.OptionKt;
import com.avito.android.messenger.blacklist_reasons.BlockUserInteractor;
import com.avito.android.messenger.channels.mvi.common.Loading;
import com.avito.android.messenger.channels.mvi.common.v4.Action;
import com.avito.android.messenger.channels.mvi.common.v4.BaseMviEntityWithReducerQueue;
import com.avito.android.messenger.channels.mvi.common.v4.Mutator;
import com.avito.android.messenger.channels.mvi.common.v4.ReducerQueue;
import com.avito.android.messenger.conversation.mvi.MessageSpamActionsInteractor;
import com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractor;
import com.avito.android.remote.model.messenger.Channel;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.util.SchedulersFactory;
import com.jakewharton.rxrelay2.Relay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0004!\"#$B!\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006%"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractorImpl;", "Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor;", "Lcom/avito/android/messenger/channels/mvi/common/v4/BaseMviEntityWithReducerQueue;", "Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor$State;", "", "onCleared", "()V", "", "messageUserId", "markChatAsSpam", "(Ljava/lang/String;)V", "markChatAsNonSpam", "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor;", "r", "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor;", "blockUserInteractor", "Lcom/jakewharton/rxrelay2/Relay;", "", VKApiConst.Q, "Lcom/jakewharton/rxrelay2/Relay;", "getErrorStream", "()Lcom/jakewharton/rxrelay2/Relay;", "errorStream", "Lio/reactivex/disposables/CompositeDisposable;", "p", "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor;", "channelContextInteractor", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor;Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor;Lcom/avito/android/util/SchedulersFactory;)V", "MarkChatAsSpamAction", "NewChannelDataMutator", "ResultMutator", "StartProgressMutator", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessageSpamActionsInteractorImpl extends BaseMviEntityWithReducerQueue<MessageSpamActionsInteractor.State> implements MessageSpamActionsInteractor {
    public final CompositeDisposable p;
    @NotNull
    public final Relay<Throwable> q = a2.b.a.a.a.J1("PublishRelay.create<T>().toSerialized()");
    public final BlockUserInteractor r;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0011\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractorImpl$MarkChatAsSpamAction;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Action;", "Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor$State;", "curState", "", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor$State;)V", "", "d", "Z", "isSpam", "()Z", "", "e", "Ljava/lang/String;", "getUserId", "()Ljava/lang/String;", ChannelContext.Item.USER_ID, "<init>", "(Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractorImpl;ZLjava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class MarkChatAsSpamAction extends Action<MessageSpamActionsInteractor.State> {
        public final boolean d;
        @NotNull
        public final String e;
        public final /* synthetic */ MessageSpamActionsInteractorImpl f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MarkChatAsSpamAction(MessageSpamActionsInteractorImpl messageSpamActionsInteractorImpl, @NotNull boolean z, String str) {
            super(null, null, 3, null);
            Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
            this.f = messageSpamActionsInteractorImpl;
            this.d = z;
            this.e = str;
        }

        @NotNull
        public final String getUserId() {
            return this.e;
        }

        public final boolean isSpam() {
            return this.d;
        }

        public void invoke(@NotNull MessageSpamActionsInteractor.State state) {
            Intrinsics.checkNotNullParameter(state, "curState");
            if (state instanceof MessageSpamActionsInteractor.State.Static) {
                MessageSpamActionsInteractor.State.Static r8 = (MessageSpamActionsInteractor.State.Static) state;
                this.f.r.confirmChatAsSpam(this.d, this.e, r8.getData().getChannelId(), r8.getData().getSuspectMessageId(), r8.getData().getItemId());
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractorImpl$NewChannelDataMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor$State;)Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor$State;", "Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor$ChannelData;", "d", "Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor$ChannelData;", "channelData", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractorImpl;Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor$ChannelData;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class NewChannelDataMutator extends Mutator<MessageSpamActionsInteractor.State> {
        public final MessageSpamActionsInteractor.ChannelData d;

        public NewChannelDataMutator(@Nullable MessageSpamActionsInteractorImpl messageSpamActionsInteractorImpl, MessageSpamActionsInteractor.ChannelData channelData) {
            super("NewChannelDataMutator(" + channelData + ')', null, 2, null);
            this.d = channelData;
        }

        @NotNull
        public MessageSpamActionsInteractor.State invoke(@NotNull MessageSpamActionsInteractor.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            MessageSpamActionsInteractor.State.Empty empty = MessageSpamActionsInteractor.State.Empty.INSTANCE;
            if (Intrinsics.areEqual(state, empty)) {
                MessageSpamActionsInteractor.ChannelData channelData = this.d;
                if (channelData != null) {
                    return new MessageSpamActionsInteractor.State.Static(channelData);
                }
                return state;
            } else if (state instanceof MessageSpamActionsInteractor.State.InProgress) {
                MessageSpamActionsInteractor.ChannelData channelData2 = this.d;
                if (channelData2 != null) {
                    return MessageSpamActionsInteractor.State.InProgress.copy$default((MessageSpamActionsInteractor.State.InProgress) state, channelData2, false, null, 6, null);
                }
                return (MessageSpamActionsInteractor.State.InProgress) state;
            } else if (state instanceof MessageSpamActionsInteractor.State.Static) {
                MessageSpamActionsInteractor.ChannelData channelData3 = this.d;
                return channelData3 != null ? ((MessageSpamActionsInteractor.State.Static) state).copy(channelData3) : empty;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractorImpl$ResultMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor$State;)Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor$State;", "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$Result;", "d", "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$Result;", "getResult", "()Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$Result;", "result", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractorImpl;Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$Result;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class ResultMutator extends Mutator<MessageSpamActionsInteractor.State> {
        @NotNull
        public final BlockUserInteractor.Result d;
        public final /* synthetic */ MessageSpamActionsInteractorImpl e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ResultMutator(@NotNull MessageSpamActionsInteractorImpl messageSpamActionsInteractorImpl, BlockUserInteractor.Result result) {
            super(null, null, 3, null);
            Intrinsics.checkNotNullParameter(result, "result");
            this.e = messageSpamActionsInteractorImpl;
            this.d = result;
        }

        @NotNull
        public final BlockUserInteractor.Result getResult() {
            return this.d;
        }

        @NotNull
        public MessageSpamActionsInteractor.State invoke(@NotNull MessageSpamActionsInteractor.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            if (!(state instanceof MessageSpamActionsInteractor.State.InProgress)) {
                return state;
            }
            BlockUserInteractor.Action action = this.d.getAction();
            if (!(action instanceof BlockUserInteractor.Action.ConfirmChatAsSpam)) {
                action = null;
            }
            BlockUserInteractor.Action.ConfirmChatAsSpam confirmChatAsSpam = (BlockUserInteractor.Action.ConfirmChatAsSpam) action;
            if (confirmChatAsSpam == null) {
                return state;
            }
            MessageSpamActionsInteractor.State.InProgress inProgress = (MessageSpamActionsInteractor.State.InProgress) state;
            if ((!Intrinsics.areEqual(confirmChatAsSpam.getChannelId(), inProgress.getData().getChannelId())) || (!Intrinsics.areEqual(confirmChatAsSpam.getMessageId(), inProgress.getData().getSuspectMessageId()))) {
                return state;
            }
            BlockUserInteractor.Result result = this.d;
            if (result instanceof BlockUserInteractor.Result.Success) {
                return MessageSpamActionsInteractor.State.Empty.INSTANCE;
            }
            if (result instanceof BlockUserInteractor.Result.Error) {
                this.e.getErrorStream().accept(((BlockUserInteractor.Result.Error) this.d).getError());
                return new MessageSpamActionsInteractor.State.Static(inProgress.getData());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractorImpl$StartProgressMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor$State;)Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor$State;", "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$Action$ConfirmChatAsSpam;", "d", "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$Action$ConfirmChatAsSpam;", "getAction", "()Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$Action$ConfirmChatAsSpam;", "action", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractorImpl;Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$Action$ConfirmChatAsSpam;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class StartProgressMutator extends Mutator<MessageSpamActionsInteractor.State> {
        @NotNull
        public final BlockUserInteractor.Action.ConfirmChatAsSpam d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public StartProgressMutator(@NotNull MessageSpamActionsInteractorImpl messageSpamActionsInteractorImpl, BlockUserInteractor.Action.ConfirmChatAsSpam confirmChatAsSpam) {
            super(null, null, 3, null);
            Intrinsics.checkNotNullParameter(confirmChatAsSpam, "action");
            this.d = confirmChatAsSpam;
        }

        @NotNull
        public final BlockUserInteractor.Action.ConfirmChatAsSpam getAction() {
            return this.d;
        }

        @NotNull
        public MessageSpamActionsInteractor.State invoke(@NotNull MessageSpamActionsInteractor.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            if (!(state instanceof MessageSpamActionsInteractor.State.Static)) {
                return state;
            }
            MessageSpamActionsInteractor.State.Static r1 = (MessageSpamActionsInteractor.State.Static) state;
            if (!(!Intrinsics.areEqual(this.d.getChannelId(), r1.getData().getChannelId())) && !(!Intrinsics.areEqual(this.d.getMessageId(), r1.getData().getSuspectMessageId()))) {
                return new MessageSpamActionsInteractor.State.InProgress(r1.getData(), this.d.isSpam(), this.d.getUserId());
            }
            return state;
        }
    }

    public static final class a<T> implements Predicate<ChannelContextInteractor.State> {
        public static final a a = new a();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Predicate
        public boolean test(ChannelContextInteractor.State state) {
            ChannelContextInteractor.State state2 = state;
            Intrinsics.checkNotNullParameter(state2, "state");
            return state2.getChannelState() instanceof Loading.Success;
        }
    }

    public static final class b<T, R> implements Function<ChannelContextInteractor.State, Option<? extends MessageSpamActionsInteractor.ChannelData>> {
        public final /* synthetic */ MessageSpamActionsInteractorImpl a;

        public b(MessageSpamActionsInteractorImpl messageSpamActionsInteractorImpl) {
            this.a = messageSpamActionsInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Option<? extends MessageSpamActionsInteractor.ChannelData> apply(ChannelContextInteractor.State state) {
            ChannelContextInteractor.State state2 = state;
            Intrinsics.checkNotNullParameter(state2, "state");
            return OptionKt.toOption(MessageSpamActionsInteractorImpl.access$toChannelData(this.a, state2));
        }
    }

    public static final class c<T> implements Consumer<Option<? extends MessageSpamActionsInteractor.ChannelData>> {
        public final /* synthetic */ MessageSpamActionsInteractorImpl a;

        public c(MessageSpamActionsInteractorImpl messageSpamActionsInteractorImpl) {
            this.a = messageSpamActionsInteractorImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Option<? extends MessageSpamActionsInteractor.ChannelData> option) {
            this.a.getReducerQueue().plusAssign(new NewChannelDataMutator(this.a, (MessageSpamActionsInteractor.ChannelData) option.orNull()));
        }
    }

    public static final class d<T, R> implements Function<BlockUserInteractor.State, Option<? extends BlockUserInteractor.Action.ConfirmChatAsSpam>> {
        public static final d a = new d();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Option<? extends BlockUserInteractor.Action.ConfirmChatAsSpam> apply(BlockUserInteractor.State state) {
            BlockUserInteractor.State state2 = state;
            Intrinsics.checkNotNullParameter(state2, "state");
            BlockUserInteractor.Action.ConfirmChatAsSpam confirmChatAsSpam = null;
            if (!(state2 instanceof BlockUserInteractor.State.InProgress)) {
                state2 = null;
            }
            BlockUserInteractor.State.InProgress inProgress = (BlockUserInteractor.State.InProgress) state2;
            BlockUserInteractor.Action action = inProgress != null ? inProgress.getAction() : null;
            if (action instanceof BlockUserInteractor.Action.ConfirmChatAsSpam) {
                confirmChatAsSpam = action;
            }
            return OptionKt.toOption(confirmChatAsSpam);
        }
    }

    public static final class e<T> implements Consumer<BlockUserInteractor.Action.ConfirmChatAsSpam> {
        public final /* synthetic */ MessageSpamActionsInteractorImpl a;

        public e(MessageSpamActionsInteractorImpl messageSpamActionsInteractorImpl) {
            this.a = messageSpamActionsInteractorImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(BlockUserInteractor.Action.ConfirmChatAsSpam confirmChatAsSpam) {
            BlockUserInteractor.Action.ConfirmChatAsSpam confirmChatAsSpam2 = confirmChatAsSpam;
            ReducerQueue reducerQueue = this.a.getReducerQueue();
            MessageSpamActionsInteractorImpl messageSpamActionsInteractorImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(confirmChatAsSpam2, "action");
            reducerQueue.plusAssign(new StartProgressMutator(messageSpamActionsInteractorImpl, confirmChatAsSpam2));
        }
    }

    public static final class f<T> implements Consumer<BlockUserInteractor.Result> {
        public final /* synthetic */ MessageSpamActionsInteractorImpl a;

        public f(MessageSpamActionsInteractorImpl messageSpamActionsInteractorImpl) {
            this.a = messageSpamActionsInteractorImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(BlockUserInteractor.Result result) {
            BlockUserInteractor.Result result2 = result;
            ReducerQueue reducerQueue = this.a.getReducerQueue();
            MessageSpamActionsInteractorImpl messageSpamActionsInteractorImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(result2, "result");
            reducerQueue.plusAssign(new ResultMutator(messageSpamActionsInteractorImpl, result2));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public MessageSpamActionsInteractorImpl(@NotNull BlockUserInteractor blockUserInteractor, @NotNull ChannelContextInteractor channelContextInteractor, @NotNull SchedulersFactory schedulersFactory) {
        super("MessageSpamActionsInteractor", MessageSpamActionsInteractor.State.Empty.INSTANCE, schedulersFactory, null, null, null, null, null, 248, null);
        Intrinsics.checkNotNullParameter(blockUserInteractor, "blockUserInteractor");
        Intrinsics.checkNotNullParameter(channelContextInteractor, "channelContextInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.r = blockUserInteractor;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.p = compositeDisposable;
        Disposable subscribe = channelContextInteractor.getStateObservable().observeOn(getSchedulerForReducibles()).filter(a.a).map(new b(this)).distinctUntilChanged().subscribe(new c(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "channelContextInteractor…a.orNull())\n            }");
        DisposableKt.addTo(subscribe, compositeDisposable);
        Observable map = blockUserInteractor.getStateObservable().observeOn(getSchedulerForReducibles()).distinctUntilChanged().map(d.a);
        Intrinsics.checkNotNullExpressionValue(map, "blockUserInteractor.stat….toOption()\n            }");
        Disposable subscribe2 = com.avito.android.util.rx.arrow.OptionKt.filterDefined(map).subscribe(new e(this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "blockUserInteractor.stat…tor(action)\n            }");
        DisposableKt.addTo(subscribe2, compositeDisposable);
        Disposable subscribe3 = blockUserInteractor.getResultStream().observeOn(schedulersFactory.computation()).subscribe(new f(this));
        Intrinsics.checkNotNullExpressionValue(subscribe3, "blockUserInteractor.resu…tor(result)\n            }");
        DisposableKt.addTo(subscribe3, compositeDisposable);
    }

    public static final MessageSpamActionsInteractor.ChannelData access$toChannelData(MessageSpamActionsInteractorImpl messageSpamActionsInteractorImpl, ChannelContextInteractor.State state) {
        String suspectMessageId;
        Objects.requireNonNull(messageSpamActionsInteractorImpl);
        String str = null;
        if (m.isBlank(state.getCurrentUserId())) {
            return null;
        }
        Loading<Channel> channelState = state.getChannelState();
        if (!(channelState instanceof Loading.Success)) {
            channelState = null;
        }
        Loading.Success success = (Loading.Success) channelState;
        Channel channel = (Channel) (success != null ? success.getValue() : null);
        if (channel == null || (suspectMessageId = channel.getSuspectMessageId()) == null) {
            return null;
        }
        String currentUserId = state.getCurrentUserId();
        String channelId = channel.getChannelId();
        ChannelContext context = channel.getContext();
        if (!(context instanceof ChannelContext.Item)) {
            context = null;
        }
        ChannelContext.Item item = (ChannelContext.Item) context;
        if (item != null) {
            str = item.getId();
        }
        return new MessageSpamActionsInteractor.ChannelData(currentUserId, channelId, str, suspectMessageId);
    }

    @Override // com.avito.android.messenger.conversation.mvi.MessageSpamActionsInteractor
    public void markChatAsNonSpam(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "messageUserId");
        getReducerQueue().plusAssign(new MarkChatAsSpamAction(this, false, str));
    }

    @Override // com.avito.android.messenger.conversation.mvi.MessageSpamActionsInteractor
    public void markChatAsSpam(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "messageUserId");
        getReducerQueue().plusAssign(new MarkChatAsSpamAction(this, true, str));
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v4.BaseMviEntityWithReducerQueue, androidx.lifecycle.ViewModel
    public void onCleared() {
        this.p.clear();
        super.onCleared();
    }

    @Override // com.avito.android.messenger.conversation.mvi.MessageSpamActionsInteractor
    @NotNull
    public Relay<Throwable> getErrorStream() {
        return this.q;
    }
}

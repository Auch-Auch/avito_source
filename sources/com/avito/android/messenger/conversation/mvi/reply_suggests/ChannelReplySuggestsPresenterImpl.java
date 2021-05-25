package com.avito.android.messenger.conversation.mvi.reply_suggests;

import arrow.core.Either;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.authorization.event.SocialButtonClickedEventKt;
import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.messenger.ReplySuggestsLoadingException;
import com.avito.android.messenger.analytics.MessengerErrorTracker;
import com.avito.android.messenger.analytics.graphite_counter.MessengerGraphiteCounter;
import com.avito.android.messenger.channels.mvi.common.v2.BaseMviEntityWithMutatorsRelay;
import com.avito.android.messenger.channels.mvi.common.v2.Mutator;
import com.avito.android.messenger.channels.mvi.common.v2.MutatorSingle;
import com.avito.android.messenger.conversation.mvi.reply_suggests.ChannelReplySuggestsView;
import com.avito.android.messenger.conversation.mvi.send.SendMessageInteractor;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.jakewharton.rxrelay2.Relay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003BO\u0012\u0006\u0010/\u001a\u00020\u0002\u0012\u0006\u00101\u001a\u000200\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010,\u001a\u00020\u0019\u0012\u0006\u0010.\u001a\u00020\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u00103\u001a\u000202\u0012\u0006\u00105\u001a\u000204¢\u0006\u0004\b6\u00107J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u000b\u0010\nR8\u0010\u0014\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000e0\rj\u0002`\u000f0\f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR2\u0010\u001e\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000e0\rj\u0002`\u000f0\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u0011R\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010\u001bR\u0016\u0010.\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010\u001b¨\u00068"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/reply_suggests/ChannelReplySuggestsPresenterImpl;", "Lcom/avito/android/messenger/channels/mvi/common/v2/BaseMviEntityWithMutatorsRelay;", "Lcom/avito/android/messenger/conversation/mvi/reply_suggests/ChannelReplySuggestsView$State;", "Lcom/avito/android/messenger/conversation/mvi/reply_suggests/ChannelReplySuggestsPresenter;", "", SocialButtonClickedEventKt.SUGGEST, "", "replySuggestClicked", "(Ljava/lang/String;)V", "closeButtonClicked", "()V", "onCleared", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "Lkotlin/Pair;", "", "Lcom/avito/android/messenger/conversation/mvi/reply_suggests/TextMessageAndTemplates;", "n", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getSendMessageLiveEvents", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "sendMessageLiveEvents", "Lcom/avito/android/messenger/conversation/mvi/send/SendMessageInteractor;", "r", "Lcom/avito/android/messenger/conversation/mvi/send/SendMessageInteractor;", "sendMessageInteractor", "Lcom/avito/android/messenger/analytics/graphite_counter/MessengerGraphiteCounter;", "u", "Lcom/avito/android/messenger/analytics/graphite_counter/MessengerGraphiteCounter;", "suggestCloseCounter", AuthSource.OPEN_CHANNEL_LIST, "sendMessageSingleLiveEvent", "Lcom/avito/android/messenger/conversation/mvi/reply_suggests/ChannelReplySuggestsInteractor;", VKApiConst.Q, "Lcom/avito/android/messenger/conversation/mvi/reply_suggests/ChannelReplySuggestsInteractor;", "replySuggestsInteractor", "Lio/reactivex/disposables/CompositeDisposable;", "o", "Lio/reactivex/disposables/CompositeDisposable;", "backendNotificationSubscriptions", "Lcom/avito/android/messenger/analytics/MessengerErrorTracker;", "p", "Lcom/avito/android/messenger/analytics/MessengerErrorTracker;", "errorTracker", "s", "suggestShowCounter", "t", "suggestClickCounter", "defaultState", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/Features;", "features", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/reply_suggests/ChannelReplySuggestsView$State;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/messenger/conversation/mvi/reply_suggests/ChannelReplySuggestsInteractor;Lcom/avito/android/messenger/conversation/mvi/send/SendMessageInteractor;Lcom/avito/android/messenger/analytics/graphite_counter/MessengerGraphiteCounter;Lcom/avito/android/messenger/analytics/graphite_counter/MessengerGraphiteCounter;Lcom/avito/android/messenger/analytics/graphite_counter/MessengerGraphiteCounter;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/Features;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelReplySuggestsPresenterImpl extends BaseMviEntityWithMutatorsRelay<ChannelReplySuggestsView.State> implements ChannelReplySuggestsPresenter {
    public final SingleLiveEvent<Pair<String, List<String>>> m;
    @NotNull
    public final SingleLiveEvent<Pair<String, List<String>>> n;
    public final CompositeDisposable o = new CompositeDisposable();
    public final MessengerErrorTracker p;
    public final ChannelReplySuggestsInteractor q;
    public final SendMessageInteractor r;
    public final MessengerGraphiteCounter s;
    public final MessengerGraphiteCounter t;
    public final MessengerGraphiteCounter u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelReplySuggestsPresenterImpl(@NotNull ChannelReplySuggestsView.State state, @NotNull SchedulersFactory schedulersFactory, @NotNull ChannelReplySuggestsInteractor channelReplySuggestsInteractor, @NotNull SendMessageInteractor sendMessageInteractor, @NotNull MessengerGraphiteCounter messengerGraphiteCounter, @NotNull MessengerGraphiteCounter messengerGraphiteCounter2, @NotNull MessengerGraphiteCounter messengerGraphiteCounter3, @NotNull Analytics analytics, @NotNull Features features) {
        super("ChannelReplySuggestsPresenter", state, schedulersFactory, null, 8, null);
        Intrinsics.checkNotNullParameter(state, "defaultState");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(channelReplySuggestsInteractor, "replySuggestsInteractor");
        Intrinsics.checkNotNullParameter(sendMessageInteractor, "sendMessageInteractor");
        Intrinsics.checkNotNullParameter(messengerGraphiteCounter, "suggestShowCounter");
        Intrinsics.checkNotNullParameter(messengerGraphiteCounter2, "suggestClickCounter");
        Intrinsics.checkNotNullParameter(messengerGraphiteCounter3, "suggestCloseCounter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(features, "features");
        this.q = channelReplySuggestsInteractor;
        this.r = sendMessageInteractor;
        this.s = messengerGraphiteCounter;
        this.t = messengerGraphiteCounter2;
        this.u = messengerGraphiteCounter3;
        SingleLiveEvent<Pair<String, List<String>>> singleLiveEvent = new SingleLiveEvent<>();
        this.m = singleLiveEvent;
        this.n = singleLiveEvent;
        this.p = new MessengerErrorTracker(analytics);
        Disposable subscribe = this.q.getReplySuggests().subscribe(new Consumer<Either<? extends Throwable, ? extends List<? extends String>>>() { // from class: com.avito.android.messenger.conversation.mvi.reply_suggests.ChannelReplySuggestsPresenterImpl$subscribeToBackendNotifications$1
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Consumer
            public /* bridge */ /* synthetic */ void accept(Either<? extends Throwable, ? extends List<? extends String>> either) {
                accept((Either<? extends Throwable, ? extends List<String>>) either);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.jakewharton.rxrelay2.Relay */
            /* JADX WARN: Multi-variable type inference failed */
            public final void accept(Either<? extends Throwable, ? extends List<String>> either) {
                Mutator mutator;
                if (either instanceof Either.Right) {
                    List list = (List) ((Either.Right) either).getB();
                    Relay relay = ChannelReplySuggestsPresenterImpl.this.getMutatorsRelay();
                    if (!list.isEmpty()) {
                        mutator = new Mutator("NewReplySuggests()", new ChannelReplySuggestsPresenterImpl$newReplySuggestsMutator$1(ChannelReplySuggestsPresenterImpl.this, list));
                    } else {
                        mutator = new Mutator("EmptyReplySuggests()", ChannelReplySuggestsPresenterImpl$emptyReplySuggestsMutator$1.INSTANCE);
                    }
                    relay.accept(new MutatorSingle(mutator.getName(), new ChannelReplySuggestsPresenterImpl$subscribeToBackendNotifications$1$$special$$inlined$plusAssign$1(mutator)));
                } else if (either instanceof Either.Left) {
                    ErrorTracker.DefaultImpls.track$default(ChannelReplySuggestsPresenterImpl.this.p, new ReplySuggestsLoadingException("Failed to load reply suggests", (Throwable) ((Either.Left) either).getA()), null, null, 6, null);
                    ChannelReplySuggestsPresenterImpl.this.s.trackError();
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "replySuggestsInteractor.…          )\n            }");
        DisposableKt.addTo(subscribe, this.o);
        Disposable subscribe2 = this.r.getMessageSendAttemptsStream().subscribe(new Consumer<Unit>() { // from class: com.avito.android.messenger.conversation.mvi.reply_suggests.ChannelReplySuggestsPresenterImpl$subscribeToBackendNotifications$2
            /* JADX DEBUG: Multi-variable search result rejected for r5v2, resolved type: com.jakewharton.rxrelay2.Relay */
            /* JADX WARN: Multi-variable type inference failed */
            public final void accept(Unit unit) {
                Relay relay = ChannelReplySuggestsPresenterImpl.this.getMutatorsRelay();
                Mutator mutator = new Mutator("MessageSendAttempt", ChannelReplySuggestsPresenterImpl$messageSendAttemptMutator$1.INSTANCE);
                relay.accept(new MutatorSingle(mutator.getName(), new ChannelReplySuggestsPresenterImpl$subscribeToBackendNotifications$2$$special$$inlined$plusAssign$1(mutator)));
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe2, "sendMessageInteractor.me…ptMutator()\n            }");
        DisposableKt.addTo(subscribe2, this.o);
    }

    public static final Mutator access$emptyReplySuggestsMutator(ChannelReplySuggestsPresenterImpl channelReplySuggestsPresenterImpl) {
        Objects.requireNonNull(channelReplySuggestsPresenterImpl);
        return new Mutator("EmptyReplySuggests()", ChannelReplySuggestsPresenterImpl$emptyReplySuggestsMutator$1.INSTANCE);
    }

    public static final Mutator access$messageSendAttemptMutator(ChannelReplySuggestsPresenterImpl channelReplySuggestsPresenterImpl) {
        Objects.requireNonNull(channelReplySuggestsPresenterImpl);
        return new Mutator("MessageSendAttempt", ChannelReplySuggestsPresenterImpl$messageSendAttemptMutator$1.INSTANCE);
    }

    public static final Mutator access$newReplySuggestsMutator(ChannelReplySuggestsPresenterImpl channelReplySuggestsPresenterImpl, List list) {
        Objects.requireNonNull(channelReplySuggestsPresenterImpl);
        return new Mutator("NewReplySuggests()", new ChannelReplySuggestsPresenterImpl$newReplySuggestsMutator$1(channelReplySuggestsPresenterImpl, list));
    }

    @Override // com.avito.android.messenger.conversation.mvi.reply_suggests.ChannelReplySuggestsPresenter
    public void closeButtonClicked() {
        Relay mutatorsRelay = getMutatorsRelay();
        Mutator mutator = new Mutator("CloseButtonClicked", new Function1<ChannelReplySuggestsView.State, ChannelReplySuggestsView.State>() { // from class: com.avito.android.messenger.conversation.mvi.reply_suggests.ChannelReplySuggestsPresenterImpl$closeButtonClickedMutator$1
            @NotNull
            public final ChannelReplySuggestsView.State invoke(@NotNull ChannelReplySuggestsView.State state) {
                Intrinsics.checkNotNullParameter(state, "oldState");
                if (Intrinsics.areEqual(state, ChannelReplySuggestsView.State.Empty.INSTANCE)) {
                    return ChannelReplySuggestsView.State.Closed.INSTANCE;
                }
                if (state instanceof ChannelReplySuggestsView.State.Visible) {
                    ChannelReplySuggestsPresenterImpl.access$getSuggestCloseCounter$p(ChannelReplySuggestsPresenterImpl.this).trackSuccess();
                    return ChannelReplySuggestsView.State.Closed.INSTANCE;
                } else if (Intrinsics.areEqual(state, ChannelReplySuggestsView.State.Closed.INSTANCE)) {
                    return state;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
        });
        mutatorsRelay.accept(new MutatorSingle(mutator.getName(), new ChannelReplySuggestsPresenterImpl$closeButtonClicked$$inlined$plusAssign$1(mutator)));
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v2.BaseMviEntity, androidx.lifecycle.ViewModel
    public void onCleared() {
        this.o.clear();
        super.onCleared();
    }

    @Override // com.avito.android.messenger.conversation.mvi.reply_suggests.ChannelReplySuggestsPresenter
    public void replySuggestClicked(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, SocialButtonClickedEventKt.SUGGEST);
        Relay mutatorsRelay = getMutatorsRelay();
        Mutator mutator = new Mutator("ReplySuggestClicked", new Function1<ChannelReplySuggestsView.State, ChannelReplySuggestsView.State>(str) { // from class: com.avito.android.messenger.conversation.mvi.reply_suggests.ChannelReplySuggestsPresenterImpl$replySuggestClickedMutator$1
            public final /* synthetic */ String b;

            {
                this.b = r2;
            }

            @NotNull
            public final ChannelReplySuggestsView.State invoke(@NotNull ChannelReplySuggestsView.State state) {
                Intrinsics.checkNotNullParameter(state, "oldState");
                if (Intrinsics.areEqual(state, ChannelReplySuggestsView.State.Empty.INSTANCE)) {
                    return ChannelReplySuggestsView.State.Closed.INSTANCE;
                }
                if (state instanceof ChannelReplySuggestsView.State.Visible) {
                    ChannelReplySuggestsPresenterImpl.this.t.trackSuccess();
                    ChannelReplySuggestsPresenterImpl.this.m.postValue(TuplesKt.to(this.b, state.getSuggests()));
                    return ChannelReplySuggestsView.State.Closed.INSTANCE;
                } else if (Intrinsics.areEqual(state, ChannelReplySuggestsView.State.Closed.INSTANCE)) {
                    return state;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
        });
        mutatorsRelay.accept(new MutatorSingle(mutator.getName(), new ChannelReplySuggestsPresenterImpl$replySuggestClicked$$inlined$plusAssign$1(mutator)));
    }

    @Override // com.avito.android.messenger.conversation.mvi.reply_suggests.ChannelReplySuggestsPresenter
    @NotNull
    public SingleLiveEvent<Pair<String, List<String>>> getSendMessageLiveEvents() {
        return this.n;
    }
}

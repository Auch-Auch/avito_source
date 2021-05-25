package com.avito.android.messenger.conversation.mvi.platform_actions.legacy;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.analytics.MessengerPlatformBottomSheetOpenEvent;
import com.avito.android.messenger.channels.mvi.common.Loading;
import com.avito.android.messenger.channels.mvi.common.v2.Action;
import com.avito.android.messenger.channels.mvi.common.v2.BaseMviEntityWithMutatorsRelay;
import com.avito.android.messenger.channels.mvi.common.v2.Mutator;
import com.avito.android.messenger.channels.mvi.common.v2.MutatorSingle;
import com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractor;
import com.avito.android.messenger.conversation.mvi.messages.MessageListInteractor;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.Channel;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.jakewharton.rxrelay2.Relay;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.rxkotlin.DisposableKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0003&'(B1\b\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b$\u0010%J\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\u0006R\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006)"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenterImpl;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter;", "Lcom/avito/android/messenger/channels/mvi/common/v2/BaseMviEntityWithMutatorsRelay;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$State;", "", "onCleared", "()V", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$ContentData;", "data", "updateContent", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$ContentData;)V", "onBottomSheetOpened", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getHideKeyboardStream", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "hideKeyboardStream", "Lcom/avito/android/Features;", "p", "Lcom/avito/android/Features;", "features", "Lio/reactivex/disposables/CompositeDisposable;", "n", "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "Lcom/avito/android/analytics/Analytics;", "o", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor;", "channelContextInteractor", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor;", "messageListInteractor", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor;Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/Features;)V", "c", "d", "e", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class LegacyPlatformActionsPresenterImpl extends BaseMviEntityWithMutatorsRelay<LegacyPlatformActionsPresenter.State> implements LegacyPlatformActionsPresenter {
    @NotNull
    public final SingleLiveEvent<Unit> m = new SingleLiveEvent<>();
    public final CompositeDisposable n;
    public final Analytics o;
    public final Features p;

    public static final class a<T> implements Predicate<ChannelContextInteractor.State> {
        public static final a a = new a();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Predicate
        public boolean test(ChannelContextInteractor.State state) {
            ChannelContextInteractor.State state2 = state;
            Intrinsics.checkNotNullParameter(state2, "contextInteractorState");
            return state2.getChannelState() instanceof Loading.Success;
        }
    }

    public static final class b<T> implements Consumer<ChannelContextInteractor.State> {
        public final /* synthetic */ LegacyPlatformActionsPresenterImpl a;

        public b(LegacyPlatformActionsPresenterImpl legacyPlatformActionsPresenterImpl) {
            this.a = legacyPlatformActionsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.jakewharton.rxrelay2.Relay */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(ChannelContextInteractor.State state) {
            ChannelContextInteractor.State state2 = state;
            Loading<Channel> channelState = state2.getChannelState();
            if (!(channelState instanceof Loading.Success)) {
                channelState = null;
            }
            Loading.Success success = (Loading.Success) channelState;
            Channel channel = (Channel) (success != null ? success.getValue() : null);
            if (channel != null) {
                PlatformActions contextActions = channel.getContextActions();
                if (contextActions == null) {
                    contextActions = new PlatformActions.None(null);
                }
                Relay mutatorsRelay = this.a.getMutatorsRelay();
                d dVar = new d(this.a, state2.getCurrentUserId(), channel.getChannelId(), channel.getUpdated(), channel.getFlow(), contextActions);
                mutatorsRelay.accept(new MutatorSingle(dVar.getName(), new LegacyPlatformActionsPresenterImpl$3$$special$$inlined$plusAssign$1(dVar)));
            }
        }
    }

    public final class c extends Mutator<LegacyPlatformActionsPresenter.State> {
        public final LegacyPlatformActionsPresenter.ContentData c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(@NotNull LegacyPlatformActionsPresenterImpl legacyPlatformActionsPresenterImpl, LegacyPlatformActionsPresenter.ContentData contentData) {
            super("NewContentDataMutator(" + contentData + ')');
            Intrinsics.checkNotNullParameter(contentData, "newData");
            this.c = contentData;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.avito.android.messenger.channels.mvi.common.v2.Mutator
        public LegacyPlatformActionsPresenter.State invoke(LegacyPlatformActionsPresenter.State state) {
            LegacyPlatformActionsPresenter.State state2 = state;
            Intrinsics.checkNotNullParameter(state2, "oldState");
            if (Intrinsics.areEqual(state2, LegacyPlatformActionsPresenter.State.Empty.INSTANCE)) {
                return state2;
            }
            if (state2 instanceof LegacyPlatformActionsPresenter.State.Actions) {
                LegacyPlatformActionsPresenter.State.Actions actions = (LegacyPlatformActionsPresenter.State.Actions) state2;
                if (actions.getChannelData().actions instanceof PlatformActions.None) {
                    return LegacyPlatformActionsPresenter.State.Actions.copy$default(actions, null, null, null, 3, null);
                }
                if (!Intrinsics.areEqual(state2.getContentData(), this.c)) {
                    return LegacyPlatformActionsPresenter.State.Actions.copy$default((LegacyPlatformActionsPresenter.State.Actions) state2, null, null, this.c, 3, null);
                }
                return (LegacyPlatformActionsPresenter.State.Actions) state2;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public final class d extends Mutator<LegacyPlatformActionsPresenter.State> {
        public final String c;
        public final String d;
        public final long e;
        public final String f;
        public final PlatformActions g;
        public final /* synthetic */ LegacyPlatformActionsPresenterImpl h;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public d(@org.jetbrains.annotations.NotNull com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsPresenterImpl r3, @org.jetbrains.annotations.NotNull java.lang.String r4, java.lang.String r5, @org.jetbrains.annotations.Nullable long r6, @org.jetbrains.annotations.NotNull java.lang.String r8, com.avito.android.remote.model.messenger.context_actions.PlatformActions r9) {
            /*
                r2 = this;
                java.lang.String r0 = "currentUserId"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                java.lang.String r0 = "channelId"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                java.lang.String r0 = "actions"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
                r2.h = r3
                java.lang.String r3 = "NewContextActionsMutator(\n            | channelId='"
                java.lang.String r0 = "',\n            | timestamp="
                java.lang.StringBuilder r3 = a2.b.a.a.a.T(r3, r5, r0, r6)
                java.lang.String r0 = ",\n            | flow="
                r3.append(r0)
                r3.append(r8)
                java.lang.String r0 = ",\n            | actions="
                r3.append(r0)
                r3.append(r9)
                java.lang.String r0 = "\n            )"
                r3.append(r0)
                java.lang.String r3 = r3.toString()
                r0 = 0
                r1 = 1
                java.lang.String r3 = t6.y.f.trimMargin$default(r3, r0, r1, r0)
                r2.<init>(r3)
                r2.c = r4
                r2.d = r5
                r2.e = r6
                r2.f = r8
                r2.g = r9
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsPresenterImpl.d.<init>(com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsPresenterImpl, java.lang.String, java.lang.String, long, java.lang.String, com.avito.android.remote.model.messenger.context_actions.PlatformActions):void");
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.avito.android.messenger.channels.mvi.common.v2.Mutator
        public LegacyPlatformActionsPresenter.State invoke(LegacyPlatformActionsPresenter.State state) {
            LegacyPlatformActionsPresenter.UiData uiData;
            LegacyPlatformActionsPresenter.State state2 = state;
            Intrinsics.checkNotNullParameter(state2, "oldState");
            PlatformActions platformActions = this.g;
            boolean z = false;
            if ((platformActions instanceof PlatformActions.ExpandableData.Provider) && ((PlatformActions.ExpandableData.Provider) platformActions).getExpandableData() != null) {
                z = true;
            }
            if (z) {
                uiData = LegacyPlatformActionsPresenter.UiData.Sheet.INSTANCE;
            } else {
                uiData = LegacyPlatformActionsPresenter.UiData.Sticky.INSTANCE;
            }
            if (Intrinsics.areEqual(state2, LegacyPlatformActionsPresenter.State.Empty.INSTANCE)) {
                return new LegacyPlatformActionsPresenter.State.Actions(new LegacyPlatformActionsPresenter.ChannelData(this.c, this.d, this.e, this.f, this.g), uiData, null, 4, null);
            }
            if (state2 instanceof LegacyPlatformActionsPresenter.State.Actions) {
                LegacyPlatformActionsPresenter.State.Actions actions = (LegacyPlatformActionsPresenter.State.Actions) state2;
                long j = actions.getChannelData().updated;
                PlatformActions platformActions2 = actions.getChannelData().actions;
                if (!this.h.p.getMessengerContextActionsInChannelUpdates().invoke().booleanValue() && (j > this.e || !(!Intrinsics.areEqual(platformActions2.getMessageId(), this.g.getMessageId())))) {
                    return actions;
                }
                LegacyPlatformActionsPresenter.ChannelData channelData = new LegacyPlatformActionsPresenter.ChannelData(this.c, this.d, this.e, this.f, this.g);
                if (this.g.getHideKeyboard()) {
                    this.h.getHideKeyboardStream().postValue(Unit.INSTANCE);
                }
                if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(platformActions2.getClass()), Reflection.getOrCreateKotlinClass(this.g.getClass()))) {
                    return LegacyPlatformActionsPresenter.State.Actions.copy$default(actions, channelData, uiData, null, 4, null);
                }
                return actions.copy(channelData, uiData, null);
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public final class e extends Action<LegacyPlatformActionsPresenter.State> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public e() {
            super(null, 1, null);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.avito.android.messenger.channels.mvi.common.v2.Action
        public void invoke(LegacyPlatformActionsPresenter.State state) {
            LegacyPlatformActionsPresenter.State state2 = state;
            Intrinsics.checkNotNullParameter(state2, "curState");
            if (state2 instanceof LegacyPlatformActionsPresenter.State.Actions) {
                LegacyPlatformActionsPresenter.State.Actions actions = (LegacyPlatformActionsPresenter.State.Actions) state2;
                String str = actions.getChannelData().flow;
                if (!(str == null || m.isBlank(str))) {
                    LegacyPlatformActionsPresenterImpl.this.o.track(new MessengerPlatformBottomSheetOpenEvent(actions.getChannelData().channelId, actions.getChannelData().flow));
                }
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public LegacyPlatformActionsPresenterImpl(@NotNull ChannelContextInteractor channelContextInteractor, @NotNull MessageListInteractor messageListInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull Analytics analytics, @NotNull Features features) {
        super("PlatformActionsPresenter", LegacyPlatformActionsPresenter.State.Empty.INSTANCE, schedulersFactory, null, 8, null);
        Intrinsics.checkNotNullParameter(channelContextInteractor, "channelContextInteractor");
        Intrinsics.checkNotNullParameter(messageListInteractor, "messageListInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(features, "features");
        this.o = analytics;
        this.p = features;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.n = compositeDisposable;
        initialize();
        Observable observeOn = messageListInteractor.getStateObservable().observeOn(schedulersFactory.computation());
        Intrinsics.checkNotNullExpressionValue(observeOn, "messageListInteractor.st…schedulers.computation())");
        Observable ofType = observeOn.ofType(MessageListInteractor.State.FirstPageLoaded.class);
        Intrinsics.checkExpressionValueIsNotNull(ofType, "ofType(R::class.java)");
        Observable take = ofType.take(1);
        Observable filter = channelContextInteractor.getStateObservable().observeOn(schedulersFactory.computation()).filter(a.a);
        Intrinsics.checkNotNullExpressionValue(filter, "channelContextInteractor…ss<Channel>\n            }");
        Intrinsics.checkNotNullExpressionValue(take, "messagesLoaded");
        Observable combineLatest = Observable.combineLatest(filter, take, new BiFunction<T1, T2, R>() { // from class: com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsPresenterImpl$$special$$inlined$combineLatestWith$1
            /* JADX WARN: Type inference failed for: r2v1, types: [R, com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractor$State] */
            @Override // io.reactivex.functions.BiFunction
            @NotNull
            public final R apply(@NotNull T1 t1, @NotNull T2 t2) {
                Intrinsics.checkNotNullParameter(t1, "t1");
                Intrinsics.checkNotNullParameter(t2, "t2");
                return t1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(combineLatest, "Observable.combineLatest…ombineFunction(t1, t2) })");
        Disposable subscribe = combineLatest.subscribe(new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "channelContextInteractor…          )\n            }");
        DisposableKt.addTo(subscribe, compositeDisposable);
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsPresenter
    public void onBottomSheetOpened() {
        Relay mutatorsRelay = getMutatorsRelay();
        e eVar = new e();
        mutatorsRelay.accept(new MutatorSingle(eVar.getName(), new LegacyPlatformActionsPresenterImpl$onBottomSheetOpened$$inlined$plusAssign$1(eVar)));
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v2.BaseMviEntity, androidx.lifecycle.ViewModel
    public void onCleared() {
        this.n.clear();
        super.onCleared();
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsPresenter
    public void updateContent(@NotNull LegacyPlatformActionsPresenter.ContentData contentData) {
        Intrinsics.checkNotNullParameter(contentData, "data");
        if (!(contentData instanceof LegacyPlatformActionsPresenter.ContentData.Unsupported)) {
            Relay mutatorsRelay = getMutatorsRelay();
            c cVar = new c(this, contentData);
            mutatorsRelay.accept(new MutatorSingle(cVar.getName(), new LegacyPlatformActionsPresenterImpl$updateContent$$inlined$plusAssign$1(cVar)));
        }
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsPresenter
    @NotNull
    public SingleLiveEvent<Unit> getHideKeyboardStream() {
        return this.m;
    }
}

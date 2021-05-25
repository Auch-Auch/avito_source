package com.avito.android.messenger.conversation.mvi.platform_actions.legacy.context_actions;

import android.content.res.Resources;
import android.net.Uri;
import androidx.lifecycle.MutableLiveData;
import arrow.core.Option;
import arrow.core.OptionKt;
import com.avito.android.analytics.Analytics;
import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.NoMatchLink;
import com.avito.android.messenger.R;
import com.avito.android.messenger.analytics.MessengerPlatformActionClickedEvent;
import com.avito.android.messenger.channels.mvi.common.v2.Action;
import com.avito.android.messenger.channels.mvi.common.v2.BaseMviEntityWithMutatorsRelay;
import com.avito.android.messenger.channels.mvi.common.v2.Mutator;
import com.avito.android.messenger.channels.mvi.common.v2.MutatorSingle;
import com.avito.android.messenger.conversation.mvi.deeplinks.DeeplinkProcessor;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsPresenter;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.context_actions.ContextActionsPresenter;
import com.avito.android.messenger.util.ThrowablesKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.RawJson;
import com.avito.android.remote.model.messenger.ActionConfirmation;
import com.avito.android.remote.model.messenger.context_actions.ContextAction;
import com.avito.android.remote.model.messenger.context_actions.ContextActionHandler;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.avito.android.util.Formatter;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.jakewharton.rxrelay2.Relay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Typography;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002BW\b\u0007\u0012\u0006\u0010A\u001a\u00020@\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010;\u001a\u000208\u0012\u0006\u0010,\u001a\u00020)\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\f\u0010$\u001a\b\u0012\u0004\u0012\u00020!0 \u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010C\u001a\u00020B¢\u0006\u0004\bD\u0010EJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\u0006J\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u0006J\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u0006J\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0006J\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020!0 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\"\u00103\u001a\b\u0012\u0004\u0012\u00020.0-8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\"\u0010?\u001a\b\u0012\u0004\u0012\u00020<0-8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b=\u00100\u001a\u0004\b>\u00102¨\u0006F"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenterImpl;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter;", "Lcom/avito/android/messenger/channels/mvi/common/v2/BaseMviEntityWithMutatorsRelay;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State;", "", "onCleared", "()V", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$Action;", "action", "handleAction", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$Action;)V", "handleActionConfirmation", "handleCloseAction", "onStartDeepLinkProcessing", "onEndDeepLinkProcessing", "onConfirmationDialogDismissed", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$ActionPayload;", "payload", "c", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$ActionPayload;)V", "Landroid/content/res/Resources;", "t", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsInteractor;", "p", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsInteractor;", "interactor", "Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "s", "Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "connectivityProvider", "Lcom/avito/android/util/Formatter;", "", "u", "Lcom/avito/android/util/Formatter;", "errorFormatter", "Lcom/avito/android/analytics/Analytics;", VKApiConst.VERSION, "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/DeeplinkProcessor;", "r", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/DeeplinkProcessor;", "deepLinkProcessor", "Landroidx/lifecycle/MutableLiveData;", "Landroid/net/Uri;", "n", "Landroidx/lifecycle/MutableLiveData;", "getUrlNavigationStream", "()Landroidx/lifecycle/MutableLiveData;", "urlNavigationStream", "Lio/reactivex/disposables/CompositeDisposable;", "o", "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "Lcom/avito/android/deep_linking/DeepLinkFactory;", VKApiConst.Q, "Lcom/avito/android/deep_linking/DeepLinkFactory;", "deepLinkFactory", "", AuthSource.OPEN_CHANNEL_LIST, "getErrorMessageStream", "errorMessageStream", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter;", "parent", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter;Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsInteractor;Lcom/avito/android/deep_linking/DeepLinkFactory;Lcom/avito/android/messenger/conversation/mvi/deeplinks/DeeplinkProcessor;Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;Landroid/content/res/Resources;Lcom/avito/android/util/Formatter;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/SchedulersFactory;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ContextActionsPresenterImpl extends BaseMviEntityWithMutatorsRelay<ContextActionsPresenter.State> implements ContextActionsPresenter {
    @NotNull
    public final MutableLiveData<String> m = new SingleLiveEvent();
    @NotNull
    public final MutableLiveData<Uri> n = new SingleLiveEvent();
    public final CompositeDisposable o;
    public final ContextActionsInteractor p;
    public final DeepLinkFactory q;
    public final DeeplinkProcessor r;
    public final ConnectivityProvider s;
    public final Resources t;
    public final Formatter<Throwable> u;
    public final Analytics v;

    public static final class a<T, R> implements Function<LegacyPlatformActionsPresenter.State, Option<? extends LegacyPlatformActionsPresenter.ChannelData>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Option<? extends LegacyPlatformActionsPresenter.ChannelData> apply(LegacyPlatformActionsPresenter.State state) {
            LegacyPlatformActionsPresenter.State state2 = state;
            Intrinsics.checkNotNullParameter(state2, "parentState");
            return OptionKt.toOption(state2.getChannelData());
        }
    }

    public static final class b<T> implements Consumer<Option<? extends LegacyPlatformActionsPresenter.ChannelData>> {
        public final /* synthetic */ ContextActionsPresenterImpl a;

        public b(ContextActionsPresenterImpl contextActionsPresenterImpl) {
            this.a = contextActionsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Option<? extends LegacyPlatformActionsPresenter.ChannelData> option) {
            ContextActionsPresenterImpl.access$onNewDataReceived(this.a, (LegacyPlatformActionsPresenter.ChannelData) option.orNull());
        }
    }

    public static final class d extends Lambda implements Function1<ContextActionsPresenter.State, Unit> {
        public final /* synthetic */ ContextActionsPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(ContextActionsPresenterImpl contextActionsPresenterImpl) {
            super(1);
            this.a = contextActionsPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(ContextActionsPresenter.State state) {
            ContextActionHandler.MethodCall closeHandler;
            ContextActionsPresenter.State state2 = state;
            Intrinsics.checkNotNullParameter(state2, "oldState");
            if (!(state2 instanceof ContextActionsPresenter.State.Visible)) {
                state2 = null;
            }
            ContextActionsPresenter.State.Visible visible = (ContextActionsPresenter.State.Visible) state2;
            if (!(visible == null || (closeHandler = visible.getCloseHandler()) == null)) {
                ContextActionsPresenterImpl contextActionsPresenterImpl = this.a;
                String method = closeHandler.getMethod();
                RawJson params = closeHandler.getParams();
                ContextActionHandler.MethodCall.Reaction reaction = closeHandler.getReaction();
                if (contextActionsPresenterImpl.s.isConnectionAvailable()) {
                    MutatorSingle mutatorSingle = new MutatorSingle("MethodCall: " + method + '(' + params + ") reaction=\"" + reaction + Typography.quote, new ContextActionsPresenterImpl$scheduleMethodCall$methodCallMutator$1(contextActionsPresenterImpl, method, params, reaction));
                    Relay mutatorsRelay = contextActionsPresenterImpl.getMutatorsRelay();
                    Mutator mutator = new Mutator("StartProgressForMethodCall", new ContextActionsPresenterImpl$scheduleMethodCall$1(contextActionsPresenterImpl, mutatorSingle));
                    mutatorsRelay.accept(new MutatorSingle(mutator.getName(), new ContextActionsPresenterImpl$handleCloseAction$1$scheduleMethodCall$$inlined$plusAssign$1(mutator)));
                } else {
                    contextActionsPresenterImpl.getErrorMessageStream().postValue(contextActionsPresenterImpl.t.getString(R.string.network_unavailable_message));
                }
            }
            return Unit.INSTANCE;
        }
    }

    public static final class e extends Lambda implements Function1<ContextActionsPresenter.State, ContextActionsPresenter.State> {
        public final /* synthetic */ ContextActionsPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(ContextActionsPresenterImpl contextActionsPresenterImpl) {
            super(1);
            this.a = contextActionsPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public ContextActionsPresenter.State invoke(ContextActionsPresenter.State state) {
            ContextActionsPresenter.State state2 = state;
            Intrinsics.checkNotNullParameter(state2, "oldState");
            return state2 instanceof ContextActionsPresenter.State.Visible ? ContextActionsPresenter.State.Visible.copy$default((ContextActionsPresenter.State.Visible) state2, null, null, null, null, null, false, ContextActionsPresenter.State.ConfirmationAlertState.Hidden.INSTANCE, 63, null) : state2;
        }
    }

    public static final class f extends Lambda implements Function1<ContextActionsPresenter.State, ContextActionsPresenter.State> {
        public final /* synthetic */ ContextActionsPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(ContextActionsPresenterImpl contextActionsPresenterImpl) {
            super(1);
            this.a = contextActionsPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public ContextActionsPresenter.State invoke(ContextActionsPresenter.State state) {
            ContextActionsPresenter.State state2 = state;
            Intrinsics.checkNotNullParameter(state2, "oldState");
            if (!(state2 instanceof ContextActionsPresenter.State.Visible)) {
                return state2;
            }
            ContextActionsPresenter.State.Visible visible = (ContextActionsPresenter.State.Visible) state2;
            return visible.isActionInProgress() ? ContextActionsPresenter.State.Visible.copy$default(visible, null, null, null, null, null, false, null, 95, null) : state2;
        }
    }

    public static final class g extends Lambda implements Function1<ContextActionsPresenter.State, ContextActionsPresenter.State> {
        public final /* synthetic */ ContextActionsPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(ContextActionsPresenterImpl contextActionsPresenterImpl) {
            super(1);
            this.a = contextActionsPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public ContextActionsPresenter.State invoke(ContextActionsPresenter.State state) {
            ContextActionsPresenter.State state2 = state;
            Intrinsics.checkNotNullParameter(state2, "oldState");
            if (!(state2 instanceof ContextActionsPresenter.State.Visible)) {
                return state2;
            }
            ContextActionsPresenter.State.Visible visible = (ContextActionsPresenter.State.Visible) state2;
            return true != visible.isActionInProgress() ? ContextActionsPresenter.State.Visible.copy$default(visible, null, null, null, null, null, true, null, 95, null) : state2;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public ContextActionsPresenterImpl(@NotNull LegacyPlatformActionsPresenter legacyPlatformActionsPresenter, @NotNull ContextActionsInteractor contextActionsInteractor, @NotNull DeepLinkFactory deepLinkFactory, @NotNull DeeplinkProcessor deeplinkProcessor, @NotNull ConnectivityProvider connectivityProvider, @NotNull Resources resources, @NotNull Formatter<Throwable> formatter, @NotNull Analytics analytics, @NotNull SchedulersFactory schedulersFactory) {
        super("ContextActionsPresenter", ContextActionsPresenter.State.Empty.INSTANCE, schedulersFactory, null, 8, null);
        Intrinsics.checkNotNullParameter(legacyPlatformActionsPresenter, "parent");
        Intrinsics.checkNotNullParameter(contextActionsInteractor, "interactor");
        Intrinsics.checkNotNullParameter(deepLinkFactory, "deepLinkFactory");
        Intrinsics.checkNotNullParameter(deeplinkProcessor, "deepLinkProcessor");
        Intrinsics.checkNotNullParameter(connectivityProvider, "connectivityProvider");
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(formatter, "errorFormatter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.p = contextActionsInteractor;
        this.q = deepLinkFactory;
        this.r = deeplinkProcessor;
        this.s = connectivityProvider;
        this.t = resources;
        this.u = formatter;
        this.v = analytics;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.o = compositeDisposable;
        Disposable subscribe = legacyPlatformActionsPresenter.getStateObservable().observeOn(schedulersFactory.computation()).map(a.a).distinctUntilChanged().subscribe(new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "parent.stateObservable\n …a.orNull())\n            }");
        DisposableKt.addTo(subscribe, compositeDisposable);
        Disposable subscribe2 = getStateObservable().distinctUntilChanged().subscribe(new a2.a.a.o1.d.a0.k.a.e.b(new Function1<LegacyPlatformActionsPresenter.ContentData, Unit>(legacyPlatformActionsPresenter) { // from class: com.avito.android.messenger.conversation.mvi.platform_actions.legacy.context_actions.ContextActionsPresenterImpl.c
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(LegacyPlatformActionsPresenter.ContentData contentData) {
                LegacyPlatformActionsPresenter.ContentData contentData2 = contentData;
                Intrinsics.checkNotNullParameter(contentData2, "p1");
                ((LegacyPlatformActionsPresenter) this.receiver).updateContent(contentData2);
                return Unit.INSTANCE;
            }
        }));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "stateObservable.distinct…be(parent::updateContent)");
        DisposableKt.addTo(subscribe2, compositeDisposable);
    }

    public static final ContextActionsPresenter.State access$hideConfirmationAlert(ContextActionsPresenterImpl contextActionsPresenterImpl, ContextActionsPresenter.State state) {
        Objects.requireNonNull(contextActionsPresenterImpl);
        return state instanceof ContextActionsPresenter.State.Visible ? ContextActionsPresenter.State.Visible.copy$default((ContextActionsPresenter.State.Visible) state, null, null, null, null, null, false, ContextActionsPresenter.State.ConfirmationAlertState.Hidden.INSTANCE, 63, null) : state;
    }

    public static final ContextActionsPresenter.State.Confirmation access$map(ContextActionsPresenterImpl contextActionsPresenterImpl, ActionConfirmation actionConfirmation) {
        Objects.requireNonNull(contextActionsPresenterImpl);
        return new ContextActionsPresenter.State.Confirmation(actionConfirmation.getTitle(), actionConfirmation.getMessage(), actionConfirmation.getConfirmButtonText(), actionConfirmation.getCancelButtonText());
    }

    public static final void access$onNewDataReceived(ContextActionsPresenterImpl contextActionsPresenterImpl, LegacyPlatformActionsPresenter.ChannelData channelData) {
        Relay mutatorsRelay = contextActionsPresenterImpl.getMutatorsRelay();
        Mutator mutator = new Mutator("NewChannelData(" + channelData + ')', new a2.a.a.o1.d.a0.k.a.e.a(contextActionsPresenterImpl, channelData));
        mutatorsRelay.accept(new MutatorSingle(mutator.getName(), new ContextActionsPresenterImpl$onNewDataReceived$$inlined$plusAssign$1(mutator)));
    }

    public static final void access$scheduleMethodCall(ContextActionsPresenterImpl contextActionsPresenterImpl, String str, RawJson rawJson, ContextActionHandler.MethodCall.Reaction reaction) {
        Objects.requireNonNull(contextActionsPresenterImpl);
        if (contextActionsPresenterImpl.s.isConnectionAvailable()) {
            MutatorSingle mutatorSingle = new MutatorSingle("MethodCall: " + str + '(' + rawJson + ") reaction=\"" + reaction + Typography.quote, new ContextActionsPresenterImpl$scheduleMethodCall$methodCallMutator$1(contextActionsPresenterImpl, str, rawJson, reaction));
            Relay mutatorsRelay = contextActionsPresenterImpl.getMutatorsRelay();
            Mutator mutator = new Mutator("StartProgressForMethodCall", new ContextActionsPresenterImpl$scheduleMethodCall$1(contextActionsPresenterImpl, mutatorSingle));
            mutatorsRelay.accept(new MutatorSingle(mutator.getName(), new ContextActionsPresenterImpl$scheduleMethodCall$$inlined$plusAssign$2(mutator)));
            return;
        }
        contextActionsPresenterImpl.getErrorMessageStream().postValue(contextActionsPresenterImpl.t.getString(R.string.network_unavailable_message));
    }

    public static final void access$showErrorMessage(ContextActionsPresenterImpl contextActionsPresenterImpl, Throwable th) {
        Objects.requireNonNull(contextActionsPresenterImpl);
        contextActionsPresenterImpl.getErrorMessageStream().postValue(contextActionsPresenterImpl.u.format(ThrowablesKt.toAvitoException(th)));
    }

    public static final List access$toViewActions(ContextActionsPresenterImpl contextActionsPresenterImpl, PlatformActions.Actions actions, String str, String str2) {
        Objects.requireNonNull(contextActionsPresenterImpl);
        List<ContextAction> actions2 = actions.getActions();
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(actions2, 10));
        for (T t2 : actions2) {
            String title = t2.getTitle();
            boolean areEqual = Intrinsics.areEqual(t2.getType(), "primary");
            ContextActionsPresenter.State.ActionPayload actionPayload = new ContextActionsPresenter.State.ActionPayload(t2.getHandler(), str, actions.getMessageId(), str2, t2.getAnalytics());
            ActionConfirmation confirmation = t2.getConfirmation();
            arrayList.add(new ContextActionsPresenter.State.Action(title, areEqual, actionPayload, confirmation != null ? new ContextActionsPresenter.State.Confirmation(confirmation.getTitle(), confirmation.getMessage(), confirmation.getConfirmButtonText(), confirmation.getCancelButtonText()) : null));
        }
        return arrayList;
    }

    public static final ContextActionsPresenter.State access$withActionInProgress(ContextActionsPresenterImpl contextActionsPresenterImpl, ContextActionsPresenter.State state, boolean z) {
        Objects.requireNonNull(contextActionsPresenterImpl);
        if (!(state instanceof ContextActionsPresenter.State.Visible)) {
            return state;
        }
        ContextActionsPresenter.State.Visible visible = (ContextActionsPresenter.State.Visible) state;
        return z != visible.isActionInProgress() ? ContextActionsPresenter.State.Visible.copy$default(visible, null, null, null, null, null, z, null, 95, null) : state;
    }

    public static final ContextActionsPresenter.State access$withConfirmationAlert(ContextActionsPresenterImpl contextActionsPresenterImpl, ContextActionsPresenter.State state, ContextActionsPresenter.State.Action action) {
        Objects.requireNonNull(contextActionsPresenterImpl);
        return state instanceof ContextActionsPresenter.State.Visible ? ContextActionsPresenter.State.Visible.copy$default((ContextActionsPresenter.State.Visible) state, null, null, null, null, null, false, ContextActionsPresenter.State.ConfirmationAlertState.Companion.createFromAction(action), 63, null) : state;
    }

    public final void c(ContextActionsPresenter.State.ActionPayload actionPayload) {
        boolean z;
        String str;
        ContextActionHandler handler = actionPayload.getHandler();
        if (handler instanceof ContextActionHandler.Link) {
            ContextActionHandler.Link link = (ContextActionHandler.Link) handler;
            String deepLink = link.getDeepLink();
            DeepLink createFromUri = deepLink != null ? this.q.createFromUri(deepLink) : null;
            if (createFromUri == null || (createFromUri instanceof NoMatchLink)) {
                getUrlNavigationStream().postValue(Uri.parse(link.getLink()));
            } else {
                z = true;
                this.r.process(createFromUri);
                if (actionPayload.getMessageId() != null && actionPayload.getFlow() != null) {
                    ContextActionHandler handler2 = actionPayload.getHandler();
                    if (handler2 instanceof ContextActionHandler.Link) {
                        str = z ? "deep_link" : "link";
                    } else if (handler2 instanceof ContextActionHandler.MethodCall) {
                        str = ContextActionHandler.MethodCall.TYPE;
                    } else if (handler2 instanceof ContextActionHandler.Unknown) {
                        str = "unknown";
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                    this.v.track(new MessengerPlatformActionClickedEvent(actionPayload.getChannelId(), actionPayload.getMessageId(), actionPayload.getFlow(), str, actionPayload.getData()));
                    return;
                }
            }
        } else if (handler instanceof ContextActionHandler.MethodCall) {
            ContextActionHandler.MethodCall methodCall = (ContextActionHandler.MethodCall) handler;
            String method = methodCall.getMethod();
            RawJson params = methodCall.getParams();
            ContextActionHandler.MethodCall.Reaction reaction = methodCall.getReaction();
            if (this.s.isConnectionAvailable()) {
                MutatorSingle mutatorSingle = new MutatorSingle("MethodCall: " + method + '(' + params + ") reaction=\"" + reaction + Typography.quote, new ContextActionsPresenterImpl$scheduleMethodCall$methodCallMutator$1(this, method, params, reaction));
                Relay mutatorsRelay = getMutatorsRelay();
                Mutator mutator = new Mutator("StartProgressForMethodCall", new ContextActionsPresenterImpl$scheduleMethodCall$1(this, mutatorSingle));
                mutatorsRelay.accept(new MutatorSingle(mutator.getName(), new ContextActionsPresenterImpl$scheduleMethodCall$$inlined$plusAssign$1(mutator)));
            } else {
                getErrorMessageStream().postValue(this.t.getString(R.string.network_unavailable_message));
            }
        } else if (handler instanceof ContextActionHandler.Unknown) {
            getErrorMessageStream().postValue(this.t.getString(R.string.messenger_unsupported_context_action_type));
        }
        z = false;
        if (actionPayload.getMessageId() != null) {
        }
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.legacy.context_actions.ContextActionsPresenter
    public void handleAction(@NotNull ContextActionsPresenter.State.Action action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (action.getConfirmation() != null) {
            Relay mutatorsRelay = getMutatorsRelay();
            Mutator mutator = new Mutator("ShowConfirmation(" + action + ')', new Function1<ContextActionsPresenter.State, ContextActionsPresenter.State>(action) { // from class: com.avito.android.messenger.conversation.mvi.platform_actions.legacy.context_actions.ContextActionsPresenterImpl$showConfirmationForAction$1
                public final /* synthetic */ ContextActionsPresenter.State.Action b;

                {
                    this.b = r2;
                }

                @NotNull
                public final ContextActionsPresenter.State invoke(@NotNull ContextActionsPresenter.State state) {
                    Intrinsics.checkNotNullParameter(state, "oldState");
                    return state instanceof ContextActionsPresenter.State.Visible ? ContextActionsPresenter.State.Visible.copy$default((ContextActionsPresenter.State.Visible) state, null, null, null, null, null, false, ContextActionsPresenter.State.ConfirmationAlertState.Companion.createFromAction(this.b), 63, null) : state;
                }
            });
            mutatorsRelay.accept(new MutatorSingle(mutator.getName(), new ContextActionsPresenterImpl$showConfirmationForAction$$inlined$plusAssign$1(mutator)));
            return;
        }
        c(action.getPayload());
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.legacy.context_actions.ContextActionsPresenter
    public void handleActionConfirmation(@NotNull ContextActionsPresenter.State.Action action) {
        Intrinsics.checkNotNullParameter(action, "action");
        c(action.getPayload());
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.legacy.context_actions.ContextActionsPresenter
    public void handleCloseAction() {
        Relay mutatorsRelay = getMutatorsRelay();
        Action action = new Action("HandleCloseAction", new d(this));
        mutatorsRelay.accept(new MutatorSingle(action.getName(), new ContextActionsPresenterImpl$handleCloseAction$$inlined$plusAssign$1(action)));
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v2.BaseMviEntity, androidx.lifecycle.ViewModel
    public void onCleared() {
        this.o.clear();
        super.onCleared();
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.legacy.context_actions.ContextActionsPresenter
    public void onConfirmationDialogDismissed() {
        Relay mutatorsRelay = getMutatorsRelay();
        Mutator mutator = new Mutator("ConfirmationDialogDismissed", new e(this));
        mutatorsRelay.accept(new MutatorSingle(mutator.getName(), new ContextActionsPresenterImpl$onConfirmationDialogDismissed$$inlined$plusAssign$1(mutator)));
    }

    @Override // com.avito.android.messenger.conversation.mvi.deeplinks.DeepLinkProcessingListener
    public void onEndDeepLinkProcessing() {
        Relay mutatorsRelay = getMutatorsRelay();
        Mutator mutator = new Mutator("EndDeepLinkProcessing", new f(this));
        mutatorsRelay.accept(new MutatorSingle(mutator.getName(), new ContextActionsPresenterImpl$onEndDeepLinkProcessing$$inlined$plusAssign$1(mutator)));
    }

    @Override // com.avito.android.messenger.conversation.mvi.deeplinks.DeepLinkProcessingListener
    public void onStartDeepLinkProcessing() {
        Relay mutatorsRelay = getMutatorsRelay();
        Mutator mutator = new Mutator("StartDeepLinkProcessing", new g(this));
        mutatorsRelay.accept(new MutatorSingle(mutator.getName(), new ContextActionsPresenterImpl$onStartDeepLinkProcessing$$inlined$plusAssign$1(mutator)));
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.legacy.context_actions.ContextActionsPresenter
    @NotNull
    public MutableLiveData<String> getErrorMessageStream() {
        return this.m;
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.legacy.context_actions.ContextActionsPresenter
    @NotNull
    public MutableLiveData<Uri> getUrlNavigationStream() {
        return this.n;
    }

    public static final void access$showErrorMessage(ContextActionsPresenterImpl contextActionsPresenterImpl, int i) {
        contextActionsPresenterImpl.getErrorMessageStream().postValue(contextActionsPresenterImpl.t.getString(i));
    }
}

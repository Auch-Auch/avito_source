package com.avito.android.messenger.conversation.mvi.context;

import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import arrow.syntax.function.Partial;
import arrow.syntax.function.PartialsKt;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.links.AbuseReportLink;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.NoMatchLink;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.messenger.analytics.MessengerErrorTracker;
import com.avito.android.messenger.channels.mvi.common.v2.AbstractMviEvent;
import com.avito.android.messenger.channels.mvi.common.v2.BaseMviEntityWithEvents;
import com.avito.android.messenger.channels.mvi.common.v2.Mutator;
import com.avito.android.messenger.channels.mvi.common.v2.MutatorSingle;
import com.avito.android.messenger.conversation.analytics.ChannelTracker;
import com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractor;
import com.avito.android.messenger.conversation.mvi.context.ChannelContextPresenterImpl;
import com.avito.android.messenger.conversation.mvi.context.ChannelContextView;
import com.avito.android.messenger.conversation.mvi.deeplinks.DeeplinkProcessor;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.User;
import com.avito.android.remote.model.messenger.Channel;
import com.avito.android.remote.model.messenger.PlatformSupport;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.remote.model.messenger.deal_action.DealAction;
import com.avito.android.util.Formatter;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.api.entity.UserLastActivity;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u0005:\u0001WBV\b\u0007\u0012\u0006\u0010R\u001a\u00020\u0002\u0012\u0006\u0010T\u001a\u00020S\u0012\u0006\u0010(\u001a\u00020%\u0012\u0013\u00104\u001a\u000f\u0012\u000b\u0012\t\u0018\u000100¢\u0006\u0002\b10/\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010G\u001a\u00020D\u0012\u0006\u00108\u001a\u000205\u0012\u0006\u0010N\u001a\u00020K¢\u0006\u0004\bU\u0010VJ\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\bJ)\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\f0\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u000f\u0010\bR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\"\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u0019R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\"\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060\u00148\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\"\u0010\u0017\u001a\u0004\b#\u0010\u0019R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00150)8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b*\u0010+R\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00150)8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b-\u0010+R#\u00104\u001a\u000f\u0012\u000b\u0012\t\u0018\u000100¢\u0006\u0002\b10/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R4\u0010?\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020:\u0012\n\u0012\b\u0012\u0004\u0012\u00020<0;090\u00148\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b=\u0010\u0017\u001a\u0004\b>\u0010\u0019R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\"\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00060\u00148\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bH\u0010\u0017\u001a\u0004\bI\u0010\u0019R\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\"\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00060\u00148\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bO\u0010\u0017\u001a\u0004\bP\u0010\u0019¨\u0006X"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextPresenterImpl;", "Lcom/avito/android/messenger/channels/mvi/common/v2/BaseMviEntityWithEvents;", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextView$State;", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextPresenterImpl$Event;", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextPresenter;", "Lcom/avito/android/messenger/conversation/mvi/context/OpenAdvertHandler;", "", "openDealActionOrAdvert", "()V", "onCleared", "Lio/reactivex/Observable;", "eventObservable", "Lcom/avito/android/messenger/channels/mvi/common/v2/MutatorSingle;", "eventHandlerObservable", "(Lio/reactivex/Observable;)Lio/reactivex/Observable;", "openAdvert", "Lcom/avito/android/analytics/Analytics;", "y", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "", "t", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getErrorMessageStream", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "errorMessageStream", "u", "getCallUserConfirmedStream", "callUserConfirmedStream", "Lio/reactivex/disposables/CompositeDisposable;", "o", "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", VKApiConst.Q, "getUserBlockedStream", "userBlockedStream", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor;", "w", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor;", "interactor", "Landroidx/lifecycle/LiveData;", "getOpenAdvertScreenStream", "()Landroidx/lifecycle/LiveData;", "openAdvertScreenStream", "getOpenMyAdvertScreenStream", "openMyAdvertScreenStream", "Lcom/avito/android/util/Formatter;", "Lru/avito/messenger/api/entity/UserLastActivity;", "Lkotlin/jvm/JvmSuppressWildcards;", "x", "Lcom/avito/android/util/Formatter;", "userActionTimeFormatter", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/DeeplinkProcessor;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/avito/android/messenger/conversation/mvi/deeplinks/DeeplinkProcessor;", "deeplinkProcessor", "Lkotlin/Pair;", "Lcom/avito/android/deep_linking/links/AbuseReportLink;", "", "Lcom/avito/android/remote/model/Action;", "s", "getAbuseReportStream", "abuseReportStream", "Lcom/avito/android/messenger/analytics/MessengerErrorTracker;", "p", "Lcom/avito/android/messenger/analytics/MessengerErrorTracker;", "errorTracker", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "z", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "deepLinkFactory", "r", "getChannelDeletedStream", "channelDeletedStream", "Lcom/avito/android/messenger/conversation/analytics/ChannelTracker;", "B", "Lcom/avito/android/messenger/conversation/analytics/ChannelTracker;", "perfTracker", VKApiConst.VERSION, "getCloseScreenStream", "closeScreenStream", "defaultState", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextView$State;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor;Lcom/avito/android/util/Formatter;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/deep_linking/DeepLinkFactory;Lcom/avito/android/messenger/conversation/mvi/deeplinks/DeeplinkProcessor;Lcom/avito/android/messenger/conversation/analytics/ChannelTracker;)V", "Event", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelContextPresenterImpl extends BaseMviEntityWithEvents<ChannelContextView.State, Event> implements ChannelContextPresenter, OpenAdvertHandler {
    public final DeeplinkProcessor A;
    public final ChannelTracker B;
    public final CompositeDisposable o = new CompositeDisposable();
    public final MessengerErrorTracker p;
    @NotNull
    public final SingleLiveEvent<Unit> q;
    @NotNull
    public final SingleLiveEvent<Unit> r;
    @NotNull
    public final SingleLiveEvent<Pair<AbuseReportLink, List<Action>>> s;
    @NotNull
    public final SingleLiveEvent<String> t;
    @NotNull
    public final SingleLiveEvent<String> u;
    @NotNull
    public final SingleLiveEvent<Unit> v;
    public final ChannelContextInteractor w;
    public final Formatter<UserLastActivity> x;
    public final Analytics y;
    public final DeepLinkFactory z;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextPresenterImpl$Event;", "Lcom/avito/android/messenger/channels/mvi/common/v2/AbstractMviEvent;", "NewInteractorState", "OpenDealActionOrAdvert", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextPresenterImpl$Event$NewInteractorState;", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextPresenterImpl$Event$OpenDealActionOrAdvert;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class Event extends AbstractMviEvent {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextPresenterImpl$Event$NewInteractorState;", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextPresenterImpl$Event;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getParamsString", "()Ljava/lang/String;", "paramsString", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor$State;", "interactorState", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor$State;", "", "eventId", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor$State;J)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class NewInteractorState extends Event {
            @NotNull
            public final String b;
            @JvmField
            @NotNull
            public final ChannelContextInteractor.State interactorState;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public NewInteractorState(@NotNull ChannelContextInteractor.State state, long j) {
                super(j, null);
                Intrinsics.checkNotNullParameter(state, "interactorState");
                this.interactorState = state;
                this.b = "(interactorState = " + state + ')';
            }

            @Override // com.avito.android.messenger.channels.mvi.common.v2.AbstractMviEvent
            @NotNull
            public String getParamsString() {
                return this.b;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextPresenterImpl$Event$OpenDealActionOrAdvert;", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextPresenterImpl$Event;", "", "eventId", "<init>", "(J)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class OpenDealActionOrAdvert extends Event {
            public OpenDealActionOrAdvert(long j) {
                super(j, null);
            }
        }

        public Event(long j, j jVar) {
            super(j);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public ChannelContextPresenterImpl(@NotNull ChannelContextView.State state, @NotNull SchedulersFactory schedulersFactory, @NotNull ChannelContextInteractor channelContextInteractor, @NotNull Formatter<UserLastActivity> formatter, @NotNull Analytics analytics, @NotNull DeepLinkFactory deepLinkFactory, @NotNull DeeplinkProcessor deeplinkProcessor, @NotNull ChannelTracker channelTracker) {
        super("ChannelContextPresenter", state, schedulersFactory);
        Intrinsics.checkNotNullParameter(state, "defaultState");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(channelContextInteractor, "interactor");
        Intrinsics.checkNotNullParameter(formatter, "userActionTimeFormatter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(deepLinkFactory, "deepLinkFactory");
        Intrinsics.checkNotNullParameter(deeplinkProcessor, "deeplinkProcessor");
        Intrinsics.checkNotNullParameter(channelTracker, "perfTracker");
        this.w = channelContextInteractor;
        this.x = formatter;
        this.y = analytics;
        this.z = deepLinkFactory;
        this.A = deeplinkProcessor;
        this.B = channelTracker;
        this.p = new MessengerErrorTracker(analytics);
        this.q = new SingleLiveEvent<>();
        this.r = new SingleLiveEvent<>();
        this.s = new SingleLiveEvent<>();
        this.t = new SingleLiveEvent<>();
        this.u = new SingleLiveEvent<>();
        this.v = new SingleLiveEvent<>();
        Disposable subscribe = this.w.getLoggedOutStream().observeOn(getSchedulers().computation()).subscribe(new Consumer<Unit>() { // from class: com.avito.android.messenger.conversation.mvi.context.ChannelContextPresenterImpl$subscribeToLogouts$1
            public final void accept(Unit unit) {
                ChannelContextPresenterImpl.this.getCloseScreenStream().postValue(Unit.INSTANCE);
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.loggedOutStre…Value(Unit)\n            }");
        DisposableKt.addTo(subscribe, this.o);
        Disposable subscribe2 = this.w.getStateObservable().observeOn(getSchedulers().computation()).subscribe(new Consumer<ChannelContextInteractor.State>() { // from class: com.avito.android.messenger.conversation.mvi.context.ChannelContextPresenterImpl$subscribeToInteractorUpdates$1
            /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.jakewharton.rxrelay2.Relay */
            /* JADX WARN: Multi-variable type inference failed */
            public final void accept(ChannelContextInteractor.State state2) {
                ChannelContextPresenterImpl channelContextPresenterImpl = ChannelContextPresenterImpl.this;
                channelContextPresenterImpl.initialize().blockingGet();
                channelContextPresenterImpl.m.accept((AbstractMviEvent) PartialsKt.invoke$default(AnonymousClass1.INSTANCE, state2, (Partial) null, 2, (Object) null).invoke(Long.valueOf(channelContextPresenterImpl.generateEventId(Reflection.getOrCreateKotlinClass(ChannelContextPresenterImpl.Event.NewInteractorState.class)))));
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe2, "interactor.stateObservab….dispatch()\n            }");
        DisposableKt.addTo(subscribe2, this.o);
    }

    public static final DealAction.Action access$getSupportedDealAction$p(ChannelContextPresenterImpl channelContextPresenterImpl, Channel channel) {
        List<String> platforms;
        Objects.requireNonNull(channelContextPresenterImpl);
        DealAction dealAction = channel.getDealAction();
        if (!(dealAction instanceof DealAction.Action)) {
            dealAction = null;
        }
        DealAction.Action action = (DealAction.Action) dealAction;
        if (action == null) {
            return null;
        }
        PlatformSupport platformSupport = action.getPlatformSupport();
        if ((platformSupport == null || (platforms = platformSupport.getPlatforms()) == null) ? true : platforms.contains("android")) {
            return action;
        }
        return null;
    }

    public static final ChannelContextView.ItemBlock access$itemBlock(ChannelContextPresenterImpl channelContextPresenterImpl, Channel channel) {
        Uri uri;
        Objects.requireNonNull(channelContextPresenterImpl);
        ChannelContext context = channel.getContext();
        String str = null;
        if (!(context instanceof ChannelContext.Item)) {
            context = null;
        }
        ChannelContext.Item item = (ChannelContext.Item) context;
        if (item == null) {
            return ChannelContextView.ItemBlock.Hidden.INSTANCE;
        }
        DealAction.Action access$getSupportedDealAction$p = access$getSupportedDealAction$p(channelContextPresenterImpl, channel);
        DeepLink createFromUri = (access$getSupportedDealAction$p == null || (uri = access$getSupportedDealAction$p.getUri()) == null) ? null : channelContextPresenterImpl.z.createFromUri(uri);
        if (!(createFromUri != null ? createFromUri instanceof NoMatchLink : true) && access$getSupportedDealAction$p != null) {
            str = access$getSupportedDealAction$p.getTitle();
        }
        String title = item.getTitle();
        Objects.requireNonNull(title, "null cannot be cast to non-null type kotlin.CharSequence");
        String obj = StringsKt__StringsKt.trim(title).toString();
        String price = item.getPrice();
        Objects.requireNonNull(price, "null cannot be cast to non-null type kotlin.CharSequence");
        return new ChannelContextView.ItemBlock.Loaded(obj, StringsKt__StringsKt.trim(price).toString(), AvitoPictureKt.pictureOf$default(item.getImage(), true, 0.0f, 0.0f, null, 28, null), str, createFromUri);
    }

    public static final Observable access$newInteractorStateEventHandler(ChannelContextPresenterImpl channelContextPresenterImpl, Event.NewInteractorState newInteractorState) {
        String str;
        Objects.requireNonNull(channelContextPresenterImpl);
        ChannelContextPresenterImpl$newInteractorStateEventHandler$1 channelContextPresenterImpl$newInteractorStateEventHandler$1 = new ChannelContextPresenterImpl$newInteractorStateEventHandler$1(channelContextPresenterImpl);
        if (newInteractorState.getParamsString().length() == 0) {
            str = Event.NewInteractorState.class.getSimpleName() + '#' + newInteractorState.eventId;
        } else {
            str = Event.NewInteractorState.class.getSimpleName() + '#' + newInteractorState.eventId + ' ' + newInteractorState.getParamsString();
        }
        Mutator mutator = new Mutator(str, PartialsKt.invoke$default(channelContextPresenterImpl$newInteractorStateEventHandler$1, newInteractorState, (Partial) null, 2, (Object) null));
        Observable just = Observable.just(new MutatorSingle(mutator.getName(), new ChannelContextPresenterImpl$newInteractorStateEventHandler$$inlined$mutatorHandler$1(mutator)));
        Intrinsics.checkNotNullExpressionValue(just, "Observable.just(mutator(block))");
        return just;
    }

    public static final String access$onlineStatus(ChannelContextPresenterImpl channelContextPresenterImpl, List list) {
        Object obj;
        Objects.requireNonNull(channelContextPresenterImpl);
        Iterator it = list.iterator();
        UserLastActivity userLastActivity = null;
        if (!it.hasNext()) {
            obj = null;
        } else {
            obj = it.next();
            if (it.hasNext()) {
                Long lastActionTime = ((User) obj).getLastActionTime();
                long longValue = lastActionTime != null ? lastActionTime.longValue() : 0;
                do {
                    Object next = it.next();
                    Long lastActionTime2 = ((User) next).getLastActionTime();
                    long longValue2 = lastActionTime2 != null ? lastActionTime2.longValue() : 0;
                    if (longValue < longValue2) {
                        obj = next;
                        longValue = longValue2;
                    }
                } while (it.hasNext());
            }
        }
        User user = (User) obj;
        Formatter formatter = channelContextPresenterImpl.x;
        if (user != null) {
            userLastActivity = new UserLastActivity(user.getId(), user.getLastActionTime(), user.getTimeDiff());
        }
        return formatter.format(userLastActivity);
    }

    public static final Observable access$openDealActionOrAdvertEventHandler(ChannelContextPresenterImpl channelContextPresenterImpl, Event.OpenDealActionOrAdvert openDealActionOrAdvert) {
        String str;
        Objects.requireNonNull(channelContextPresenterImpl);
        ChannelContextPresenterImpl$openDealActionOrAdvertEventHandler$1 channelContextPresenterImpl$openDealActionOrAdvertEventHandler$1 = new ChannelContextPresenterImpl$openDealActionOrAdvertEventHandler$1(channelContextPresenterImpl);
        if (openDealActionOrAdvert.getParamsString().length() == 0) {
            str = Event.OpenDealActionOrAdvert.class.getSimpleName() + '#' + openDealActionOrAdvert.eventId;
        } else {
            str = Event.OpenDealActionOrAdvert.class.getSimpleName() + '#' + openDealActionOrAdvert.eventId + ' ' + openDealActionOrAdvert.getParamsString();
        }
        com.avito.android.messenger.channels.mvi.common.v2.Action action = new com.avito.android.messenger.channels.mvi.common.v2.Action(str, PartialsKt.invoke$default(channelContextPresenterImpl$openDealActionOrAdvertEventHandler$1, openDealActionOrAdvert, (Partial) null, 2, (Object) null));
        Observable just = Observable.just(new MutatorSingle(action.getName(), new ChannelContextPresenterImpl$openDealActionOrAdvertEventHandler$$inlined$actionHandler$1(action)));
        Intrinsics.checkNotNullExpressionValue(just, "Observable.just(action(block))");
        return just;
    }

    public static final UserLastActivity access$toUserLastActivity(ChannelContextPresenterImpl channelContextPresenterImpl, User user) {
        Objects.requireNonNull(channelContextPresenterImpl);
        return new UserLastActivity(user.getId(), user.getLastActionTime(), user.getTimeDiff());
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v2.BaseMviEntityWithEvents
    @NotNull
    public Observable<MutatorSingle<ChannelContextView.State>> eventHandlerObservable(@NotNull Observable<Event> observable) {
        Intrinsics.checkNotNullParameter(observable, "eventObservable");
        Observable<U> ofType = observable.ofType(Event.NewInteractorState.class);
        Intrinsics.checkExpressionValueIsNotNull(ofType, "ofType(R::class.java)");
        Observable<R> concatMap = ofType.concatMap(new a2.a.a.o1.d.a0.a.b(new Function1<Event.NewInteractorState, Observable<MutatorSingle<ChannelContextView.State>>>(this) { // from class: com.avito.android.messenger.conversation.mvi.context.ChannelContextPresenterImpl.a
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Observable<MutatorSingle<ChannelContextView.State>> invoke(Event.NewInteractorState newInteractorState) {
                String str;
                Event.NewInteractorState newInteractorState2 = newInteractorState;
                Intrinsics.checkNotNullParameter(newInteractorState2, "p1");
                ChannelContextPresenterImpl$newInteractorStateEventHandler$1 channelContextPresenterImpl$newInteractorStateEventHandler$1 = new ChannelContextPresenterImpl$newInteractorStateEventHandler$1((ChannelContextPresenterImpl) this.receiver);
                if (newInteractorState2.getParamsString().length() == 0) {
                    str = Event.NewInteractorState.class.getSimpleName() + '#' + newInteractorState2.eventId;
                } else {
                    str = Event.NewInteractorState.class.getSimpleName() + '#' + newInteractorState2.eventId + ' ' + newInteractorState2.getParamsString();
                }
                Mutator mutator = new Mutator(str, PartialsKt.invoke$default(channelContextPresenterImpl$newInteractorStateEventHandler$1, newInteractorState2, (Partial) null, 2, (Object) null));
                Observable<MutatorSingle<ChannelContextView.State>> just = Observable.just(new MutatorSingle(mutator.getName(), new ChannelContextPresenterImpl$eventHandlerObservable$1$newInteractorStateEventHandler$$inlined$mutatorHandler$1(mutator)));
                Intrinsics.checkNotNullExpressionValue(just, "Observable.just(mutator(block))");
                return just;
            }
        }));
        Observable<U> ofType2 = observable.ofType(Event.OpenDealActionOrAdvert.class);
        Intrinsics.checkExpressionValueIsNotNull(ofType2, "ofType(R::class.java)");
        Observable<MutatorSingle<ChannelContextView.State>> merge = Observable.merge(concatMap, ofType2.concatMap(new a2.a.a.o1.d.a0.a.b(new Function1<Event.OpenDealActionOrAdvert, Observable<MutatorSingle<ChannelContextView.State>>>(this) { // from class: com.avito.android.messenger.conversation.mvi.context.ChannelContextPresenterImpl.b
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Observable<MutatorSingle<ChannelContextView.State>> invoke(Event.OpenDealActionOrAdvert openDealActionOrAdvert) {
                String str;
                Event.OpenDealActionOrAdvert openDealActionOrAdvert2 = openDealActionOrAdvert;
                Intrinsics.checkNotNullParameter(openDealActionOrAdvert2, "p1");
                ChannelContextPresenterImpl$openDealActionOrAdvertEventHandler$1 channelContextPresenterImpl$openDealActionOrAdvertEventHandler$1 = new ChannelContextPresenterImpl$openDealActionOrAdvertEventHandler$1((ChannelContextPresenterImpl) this.receiver);
                if (openDealActionOrAdvert2.getParamsString().length() == 0) {
                    str = Event.OpenDealActionOrAdvert.class.getSimpleName() + '#' + openDealActionOrAdvert2.eventId;
                } else {
                    str = Event.OpenDealActionOrAdvert.class.getSimpleName() + '#' + openDealActionOrAdvert2.eventId + ' ' + openDealActionOrAdvert2.getParamsString();
                }
                com.avito.android.messenger.channels.mvi.common.v2.Action action = new com.avito.android.messenger.channels.mvi.common.v2.Action(str, PartialsKt.invoke$default(channelContextPresenterImpl$openDealActionOrAdvertEventHandler$1, openDealActionOrAdvert2, (Partial) null, 2, (Object) null));
                Observable<MutatorSingle<ChannelContextView.State>> just = Observable.just(new MutatorSingle(action.getName(), new ChannelContextPresenterImpl$eventHandlerObservable$2$openDealActionOrAdvertEventHandler$$inlined$actionHandler$1(action)));
                Intrinsics.checkNotNullExpressionValue(just, "Observable.just(action(block))");
                return just;
            }
        })));
        Intrinsics.checkNotNullExpressionValue(merge, "Observable.merge(\n      …rtEventHandler)\n        )");
        return merge;
    }

    @Override // com.avito.android.messenger.conversation.mvi.context.OpenAdvertHandler
    @NotNull
    public LiveData<String> getOpenAdvertScreenStream() {
        return this.w.getOpenAdvertScreenStream();
    }

    @Override // com.avito.android.messenger.conversation.mvi.context.OpenAdvertHandler
    @NotNull
    public LiveData<String> getOpenMyAdvertScreenStream() {
        return this.w.getOpenMyAdvertScreenStream();
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v2.BaseMviEntity, androidx.lifecycle.ViewModel
    public void onCleared() {
        this.o.clear();
        super.onCleared();
    }

    @Override // com.avito.android.messenger.conversation.mvi.context.OpenAdvertHandler
    public void openAdvert() {
        this.w.openAdvert();
    }

    @Override // com.avito.android.messenger.conversation.mvi.context.ChannelContextPresenter
    public void openDealActionOrAdvert() {
        initialize().blockingGet();
        this.m.accept((AbstractMviEvent) c.a.invoke(Long.valueOf(generateEventId(Reflection.getOrCreateKotlinClass(Event.OpenDealActionOrAdvert.class)))));
    }

    @Override // com.avito.android.messenger.conversation.mvi.context.ChannelContextPresenter
    @NotNull
    public SingleLiveEvent<Pair<AbuseReportLink, List<Action>>> getAbuseReportStream() {
        return this.s;
    }

    @Override // com.avito.android.messenger.conversation.mvi.context.ChannelContextPresenter
    @NotNull
    public SingleLiveEvent<String> getCallUserConfirmedStream() {
        return this.u;
    }

    @Override // com.avito.android.messenger.conversation.mvi.context.ChannelContextPresenter
    @NotNull
    public SingleLiveEvent<Unit> getChannelDeletedStream() {
        return this.r;
    }

    @Override // com.avito.android.messenger.conversation.mvi.context.ChannelContextPresenter
    @NotNull
    public SingleLiveEvent<Unit> getCloseScreenStream() {
        return this.v;
    }

    @Override // com.avito.android.messenger.conversation.mvi.context.ChannelContextPresenter
    @NotNull
    public SingleLiveEvent<String> getErrorMessageStream() {
        return this.t;
    }

    @Override // com.avito.android.messenger.conversation.mvi.context.ChannelContextPresenter
    @NotNull
    public SingleLiveEvent<Unit> getUserBlockedStream() {
        return this.q;
    }
}

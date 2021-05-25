package com.avito.android.messenger.map.search;

import com.avito.android.analytics.Analytics;
import com.avito.android.authorization.event.SocialButtonClickedEventKt;
import com.avito.android.messenger.analytics.MessengerGeoSearchLocationPick;
import com.avito.android.messenger.channels.mvi.common.v2.BaseMviEntityWithMutatorsRelay;
import com.avito.android.messenger.channels.mvi.common.v2.MutatorSingle;
import com.avito.android.messenger.map.search.GeoSearchInteractor;
import com.avito.android.messenger.map.search.GeoSearchPresenter;
import com.avito.android.messenger.map.search.adapter.GeoSearchSuggestItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.jakewharton.rxrelay2.Relay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002BZ\b\u0007\u0012\u0006\u00100\u001a\u00020/\u0012\u0006\u0010#\u001a\u00020 \u0012\b\b\u0001\u0010&\u001a\u00020\u0004\u0012\b\b\u0001\u0010*\u001a\u00020\u0004\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\b\b\u0001\u0010(\u001a\u00020\u0004\u0012\u0006\u00101\u001a\u00020\u0003\u0012\u0011\u00105\u001a\r\u0012\t\u0012\u000703¢\u0006\u0002\b402¢\u0006\u0004\b6\u00107J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\r\u0010\u000eR\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010%R\u0016\u0010*\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010%R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-¨\u00068"}, d2 = {"Lcom/avito/android/messenger/map/search/GeoSearchPresenterImpl;", "Lcom/avito/android/messenger/map/search/GeoSearchPresenter;", "Lcom/avito/android/messenger/channels/mvi/common/v2/BaseMviEntityWithMutatorsRelay;", "Lcom/avito/android/messenger/map/search/GeoSearchPresenter$State;", "", "newQuery", "", "queryChanged", "(Ljava/lang/String;)V", "Lcom/avito/android/messenger/map/search/adapter/GeoSearchSuggestItem;", SocialButtonClickedEventKt.SUGGEST, "suggestClicked", "(Lcom/avito/android/messenger/map/search/adapter/GeoSearchSuggestItem;)V", "onCleared", "()V", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getSetQueryStream", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "setQueryStream", "n", "getSendSuggestStream", "sendSuggestStream", "Lcom/avito/android/messenger/map/search/StateModifierImpl;", "p", "Lcom/avito/android/messenger/map/search/StateModifierImpl;", "stateModifier", "Lcom/avito/android/analytics/Analytics;", "t", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/messenger/map/search/GeoSearchInteractor;", VKApiConst.Q, "Lcom/avito/android/messenger/map/search/GeoSearchInteractor;", "interactor", "r", "Ljava/lang/String;", "connectionErrorIndicatorMessage", "u", "channelId", "s", "connectionErrorIndicatorActionName", "Lio/reactivex/disposables/CompositeDisposable;", "o", "Lio/reactivex/disposables/CompositeDisposable;", "disposables", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "defaultState", "Lru/avito/messenger/MessengerClient;", "Lru/avito/messenger/api/AvitoMessengerApi;", "Lkotlin/jvm/JvmSuppressWildcards;", "client", "<init>", "(Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/messenger/map/search/GeoSearchInteractor;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/analytics/Analytics;Ljava/lang/String;Lcom/avito/android/messenger/map/search/GeoSearchPresenter$State;Lru/avito/messenger/MessengerClient;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class GeoSearchPresenterImpl extends BaseMviEntityWithMutatorsRelay<GeoSearchPresenter.State> implements GeoSearchPresenter {
    @NotNull
    public final SingleLiveEvent<String> m = new SingleLiveEvent<>();
    @NotNull
    public final SingleLiveEvent<GeoSearchSuggestItem> n = new SingleLiveEvent<>();
    public final CompositeDisposable o;
    public final StateModifierImpl p;
    public final GeoSearchInteractor q;
    public final String r;
    public final String s;
    public final Analytics t;
    public final String u;

    public static final class a<T> implements Consumer<GeoSearchInteractor.State> {
        public final /* synthetic */ GeoSearchPresenterImpl a;

        public a(GeoSearchPresenterImpl geoSearchPresenterImpl) {
            this.a = geoSearchPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.jakewharton.rxrelay2.Relay */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(GeoSearchInteractor.State state) {
            GeoSearchInteractor.State state2 = state;
            Relay mutatorsRelay = this.a.getMutatorsRelay();
            Intrinsics.checkNotNullExpressionValue(state2, "newInteractorState");
            NewInteractorStateMutator newInteractorStateMutator = new NewInteractorStateMutator(state2, this.a.p);
            mutatorsRelay.accept(new MutatorSingle(newInteractorStateMutator.getName(), new GeoSearchPresenterImpl$1$$special$$inlined$plusAssign$1(newInteractorStateMutator)));
        }
    }

    public static final class b<T> implements Consumer<Boolean> {
        public final /* synthetic */ GeoSearchPresenterImpl a;

        public b(GeoSearchPresenterImpl geoSearchPresenterImpl) {
            this.a = geoSearchPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v3, resolved type: com.jakewharton.rxrelay2.Relay */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Boolean bool) {
            Relay mutatorsRelay = this.a.getMutatorsRelay();
            ReconnectedAction reconnectedAction = new ReconnectedAction(this.a.q);
            mutatorsRelay.accept(new MutatorSingle(reconnectedAction.getName(), new GeoSearchPresenterImpl$2$$special$$inlined$plusAssign$1(reconnectedAction)));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public GeoSearchPresenterImpl(@NotNull SchedulersFactory schedulersFactory, @NotNull GeoSearchInteractor geoSearchInteractor, @Named("error_indicator_message") @NotNull String str, @Named("error_indicator_action_name") @NotNull String str2, @NotNull Analytics analytics, @Named("channel_id") @NotNull String str3, @NotNull GeoSearchPresenter.State state, @NotNull MessengerClient<AvitoMessengerApi> messengerClient) {
        super("GeoSearchPresenter", state, schedulersFactory, null, 8, null);
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(geoSearchInteractor, "interactor");
        Intrinsics.checkNotNullParameter(str, "connectionErrorIndicatorMessage");
        Intrinsics.checkNotNullParameter(str2, "connectionErrorIndicatorActionName");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(str3, "channelId");
        Intrinsics.checkNotNullParameter(state, "defaultState");
        Intrinsics.checkNotNullParameter(messengerClient, "client");
        this.q = geoSearchInteractor;
        this.r = str;
        this.s = str2;
        this.t = analytics;
        this.u = str3;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.o = compositeDisposable;
        this.p = new StateModifierImpl(geoSearchInteractor, str, str2);
        Disposable subscribe = geoSearchInteractor.getStateObservable().observeOn(schedulersFactory.io()).subscribe(new a(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.stateObservab…          )\n            }");
        DisposableKt.addTo(subscribe, compositeDisposable);
        Disposable subscribe2 = messengerClient.allReconnects().debounce(500, TimeUnit.MILLISECONDS, schedulersFactory.computation()).observeOn(schedulersFactory.io()).subscribe(new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "client.allReconnects()\n …interactor)\n            }");
        DisposableKt.addTo(subscribe2, compositeDisposable);
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v2.BaseMviEntity, androidx.lifecycle.ViewModel
    public void onCleared() {
        this.o.clear();
        super.onCleared();
    }

    @Override // com.avito.android.messenger.map.search.GeoSearchPresenter
    public void queryChanged(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "newQuery");
        Relay mutatorsRelay = getMutatorsRelay();
        QueryChangedMutator queryChangedMutator = new QueryChangedMutator(str, this.q, this.p);
        mutatorsRelay.accept(new MutatorSingle(queryChangedMutator.getName(), new GeoSearchPresenterImpl$queryChanged$$inlined$plusAssign$1(queryChangedMutator)));
    }

    @Override // com.avito.android.messenger.map.search.GeoSearchSuggestClickListener
    public void suggestClicked(@NotNull GeoSearchSuggestItem geoSearchSuggestItem) {
        Intrinsics.checkNotNullParameter(geoSearchSuggestItem, SocialButtonClickedEventKt.SUGGEST);
        if (geoSearchSuggestItem.isSendable()) {
            getSendSuggestStream().postValue(geoSearchSuggestItem);
        } else {
            SingleLiveEvent<String> setQueryStream = getSetQueryStream();
            setQueryStream.postValue(geoSearchSuggestItem.getTitle() + ", ");
        }
        this.t.track(new MessengerGeoSearchLocationPick(this.u, geoSearchSuggestItem.getAddressType()));
    }

    @Override // com.avito.android.messenger.map.search.GeoSearchPresenter
    @NotNull
    public SingleLiveEvent<GeoSearchSuggestItem> getSendSuggestStream() {
        return this.n;
    }

    @Override // com.avito.android.messenger.map.search.GeoSearchPresenter
    @NotNull
    public SingleLiveEvent<String> getSetQueryStream() {
        return this.m;
    }
}

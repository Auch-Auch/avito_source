package com.avito.android.messenger.map.sharing;

import com.avito.android.authorization.event.SocialButtonClickedEventKt;
import com.avito.android.avito_map.AvitoMapCameraPosition;
import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.messenger.channels.mvi.common.v2.Action;
import com.avito.android.messenger.channels.mvi.common.v2.BaseMviEntityWithMutatorsRelay;
import com.avito.android.messenger.channels.mvi.common.v2.Mutator;
import com.avito.android.messenger.channels.mvi.common.v2.MutatorSingle;
import com.avito.android.messenger.map.sharing.SharingMapView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.geo.GeoSearchSuggest;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.android.util.rx3.InteropKt;
import com.avito.android.util.rx3.Singles;
import com.jakewharton.rxrelay2.Relay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Single;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002BK\b\u0007\u0012\b\b\u0001\u0010:\u001a\u00020\u0003\u0012\u0006\u0010<\u001a\u00020;\u0012\b\b\u0001\u0010$\u001a\u00020\u0003\u0012\u0006\u00100\u001a\u00020-\u0012\b\b\u0001\u00106\u001a\u00020\u001a\u0012\b\b\u0001\u0010&\u001a\u00020\u001a\u0012\b\b\u0001\u0010\u001d\u001a\u00020\u001a¢\u0006\u0004\b=\u0010>J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0017\u0010\u000eJ\u000f\u0010\u0018\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0018\u0010\u000eJ\u000f\u0010\u0019\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0019\u0010\u000eR\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010\u001cR\"\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001a0'8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\"\u00104\u001a\b\u0012\u0004\u0012\u0002010'8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b2\u0010)\u001a\u0004\b3\u0010+R\u0016\u00106\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u0010\u001cR\"\u00109\u001a\b\u0012\u0004\u0012\u00020\u00060'8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b7\u0010)\u001a\u0004\b8\u0010+¨\u0006?"}, d2 = {"Lcom/avito/android/messenger/map/sharing/SharingMapPresenterImpl;", "Lcom/avito/android/messenger/map/sharing/SharingMapPresenter;", "Lcom/avito/android/messenger/channels/mvi/common/v2/BaseMviEntityWithMutatorsRelay;", "Lcom/avito/android/messenger/map/sharing/SharingMapView$State;", "", "causedByNewUserLocation", "", "cameraDraggingStarted", "(Z)V", "Lcom/avito/android/avito_map/AvitoMapCameraPosition;", "newCameraPosition", "cameraPositionChanged", "(Lcom/avito/android/avito_map/AvitoMapCameraPosition;Z)V", "myLocationButtonClicked", "()V", "Lcom/avito/android/avito_map/AvitoMapPoint;", "point", "userLocationChanged", "(Lcom/avito/android/avito_map/AvitoMapPoint;)V", "Lcom/avito/android/remote/model/messenger/geo/GeoSearchSuggest;", SocialButtonClickedEventKt.SUGGEST, "selectedSearchSuggest", "(Lcom/avito/android/remote/model/messenger/geo/GeoSearchSuggest;)V", "editAddressClicked", "sendLocationButtonClicked", "onCleared", "", "u", "Ljava/lang/String;", "retryString", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", AuthSource.OPEN_CHANNEL_LIST, "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "subscriptions", VKApiConst.Q, "Lcom/avito/android/messenger/map/sharing/SharingMapView$State;", "initialState", "t", "addressNotFoundErrorMessageString", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "o", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getEditAddressStream", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "editAddressStream", "Lcom/avito/android/messenger/map/sharing/SharingMapInteractor;", "r", "Lcom/avito/android/messenger/map/sharing/SharingMapInteractor;", "interactor", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;", "n", "getSendLocationEventsStream", "sendLocationEventsStream", "s", "addressNotFoundTitleString", "p", "getRequestLocationStream", "requestLocationStream", "defaultState", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Lcom/avito/android/messenger/map/sharing/SharingMapView$State;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/messenger/map/sharing/SharingMapView$State;Lcom/avito/android/messenger/map/sharing/SharingMapInteractor;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class SharingMapPresenterImpl extends BaseMviEntityWithMutatorsRelay<SharingMapView.State> implements SharingMapPresenter {
    public final CompositeDisposable m;
    @NotNull
    public final SingleLiveEvent<MessageBody.Location> n = new SingleLiveEvent<>();
    @NotNull
    public final SingleLiveEvent<String> o = new SingleLiveEvent<>();
    @NotNull
    public final SingleLiveEvent<Unit> p = new SingleLiveEvent<>();
    public final SharingMapView.State q;
    public final SharingMapInteractor r;
    public final String s;
    public final String t;
    public final String u;

    public static final class a extends Lambda implements Function1<SharingMapView.State, SharingMapView.State> {
        public final /* synthetic */ SharingMapPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SharingMapPresenterImpl sharingMapPresenterImpl) {
            super(1);
            this.a = sharingMapPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public SharingMapView.State invoke(SharingMapView.State state) {
            Intrinsics.checkNotNullParameter(state, "it");
            return this.a.q;
        }
    }

    public static final class b<T> implements Consumer<Unit> {
        public final /* synthetic */ SharingMapPresenterImpl a;

        public b(SharingMapPresenterImpl sharingMapPresenterImpl) {
            this.a = sharingMapPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v3, resolved type: com.jakewharton.rxrelay2.Relay */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            Relay mutatorsRelay = this.a.getMutatorsRelay();
            OnReconnectedAction onReconnectedAction = new OnReconnectedAction(new a2.a.a.o1.e.c.a(this.a));
            mutatorsRelay.accept(new MutatorSingle(onReconnectedAction.getName(), new SharingMapPresenterImpl$2$$special$$inlined$plusAssign$1(onReconnectedAction)));
        }
    }

    public static final class c extends Lambda implements Function1<SharingMapView.State, SharingMapView.State> {
        public final /* synthetic */ boolean a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(boolean z) {
            super(1);
            this.a = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public SharingMapView.State invoke(SharingMapView.State state) {
            SharingMapView.State state2 = state;
            Intrinsics.checkNotNullParameter(state2, "oldState");
            boolean z = false;
            if ((state2 instanceof SharingMapView.State.Empty) || (state2 instanceof SharingMapView.State.Static.Loaded)) {
                AvitoMapPoint userPoint = state2.getUserPoint();
                String bottomSheetTitle = state2.getBottomSheetTitle();
                if (this.a) {
                    z = state2.getAwaitingNewUserLocation();
                }
                SharingMapView.CameraState cameraState = null;
                if (!(state2 instanceof SharingMapView.State.Static)) {
                    state2 = null;
                }
                SharingMapView.State.Static r7 = (SharingMapView.State.Static) state2;
                if (r7 != null) {
                    cameraState = r7.getCameraState();
                }
                return new SharingMapView.State.Dragging(userPoint, bottomSheetTitle, z, cameraState);
            } else if (!(state2 instanceof SharingMapView.State.Dragging) && !(state2 instanceof SharingMapView.State.Static.Error)) {
                throw new NoWhenBranchMatchedException();
            } else {
                boolean awaitingNewUserLocation = this.a ? state2.getAwaitingNewUserLocation() : false;
                if (state2.getAwaitingNewUserLocation() == awaitingNewUserLocation) {
                    return state2;
                }
                SharingMapView.State withAwaitingNewUserLocation = state2.withAwaitingNewUserLocation(awaitingNewUserLocation);
                if (!(withAwaitingNewUserLocation instanceof SharingMapView.State.Static)) {
                    return withAwaitingNewUserLocation;
                }
                SharingMapView.State.Static r0 = (SharingMapView.State.Static) withAwaitingNewUserLocation;
                return r0.getForceMoveCamera() ? r0.withForceMoveCamera(false) : withAwaitingNewUserLocation;
            }
        }
    }

    public static final class d extends Lambda implements Function1<SharingMapView.State, Single<SharingMapView.State>> {
        public final /* synthetic */ SharingMapPresenterImpl a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ AvitoMapCameraPosition c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(SharingMapPresenterImpl sharingMapPresenterImpl, boolean z, AvitoMapCameraPosition avitoMapCameraPosition) {
            super(1);
            this.a = sharingMapPresenterImpl;
            this.b = z;
            this.c = avitoMapCameraPosition;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Single<SharingMapView.State> invoke(SharingMapView.State state) {
            SharingMapView.State state2 = state;
            Intrinsics.checkNotNullParameter(state2, "oldState");
            boolean z = this.b;
            if (z && (!z || !state2.getAwaitingNewUserLocation())) {
                return InteropKt.toV2(Singles.toSingle(state2));
            }
            io.reactivex.rxjava3.core.Single<R> map = this.a.r.getAddressForCoordinates(this.c.getMapPoint()).map(new a2.a.a.o1.e.c.b(this, state2));
            Intrinsics.checkNotNullExpressionValue(map, "interactor.getAddressFor…s State\n                }");
            Single<SharingMapView.State> onErrorReturn = InteropKt.toV2(map).onErrorReturn(new a2.a.a.o1.e.c.d(this, state2));
            Intrinsics.checkNotNullExpressionValue(onErrorReturn, "interactor.getAddressFor…      )\n                }");
            return onErrorReturn;
        }
    }

    public static final class e extends Lambda implements Function1<SharingMapView.State, Unit> {
        public final /* synthetic */ SharingMapPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(SharingMapPresenterImpl sharingMapPresenterImpl) {
            super(1);
            this.a = sharingMapPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(SharingMapView.State state) {
            SharingMapView.State state2 = state;
            Intrinsics.checkNotNullParameter(state2, "state");
            if (state2 instanceof SharingMapView.State.Static.Loaded) {
                this.a.getSendLocationEventsStream().postValue(((SharingMapView.State.Static.Loaded) state2).getGeoPosition());
            }
            return Unit.INSTANCE;
        }
    }

    public static final class f extends Lambda implements Function1<SharingMapView.State, SharingMapView.State> {
        public final /* synthetic */ SharingMapPresenterImpl a;
        public final /* synthetic */ AvitoMapPoint b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(SharingMapPresenterImpl sharingMapPresenterImpl, AvitoMapPoint avitoMapPoint) {
            super(1);
            this.a = sharingMapPresenterImpl;
            this.b = avitoMapPoint;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public SharingMapView.State invoke(SharingMapView.State state) {
            SharingMapView.State state2 = state;
            Intrinsics.checkNotNullParameter(state2, "oldState");
            if (state2.getAwaitingNewUserLocation()) {
                this.a.cameraDraggingStarted(true);
                this.a.cameraPositionChanged(new AvitoMapCameraPosition(this.b, 18.0f, 0.0f, null, null, 28, null), true);
            }
            if (!(!Intrinsics.areEqual(state2.getUserPoint(), this.b))) {
                return state2;
            }
            SharingMapView.State withNewUserLocation = state2.withNewUserLocation(this.b);
            if (!(withNewUserLocation instanceof SharingMapView.State.Static)) {
                return withNewUserLocation;
            }
            SharingMapView.State.Static r0 = (SharingMapView.State.Static) withNewUserLocation;
            return r0.getForceMoveCamera() ? r0.withForceMoveCamera(false) : withNewUserLocation;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public SharingMapPresenterImpl(@Named("default") @NotNull SharingMapView.State state, @NotNull SchedulersFactory schedulersFactory, @Named("initial") @NotNull SharingMapView.State state2, @NotNull SharingMapInteractor sharingMapInteractor, @Named("addressNotFoundTitle") @NotNull String str, @Named("addressNotFoundErrorMessage") @NotNull String str2, @Named("retryLabel") @NotNull String str3) {
        super("SharingMapPresenter", state, schedulersFactory, null, 8, null);
        Intrinsics.checkNotNullParameter(state, "defaultState");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(state2, "initialState");
        Intrinsics.checkNotNullParameter(sharingMapInteractor, "interactor");
        Intrinsics.checkNotNullParameter(str, "addressNotFoundTitleString");
        Intrinsics.checkNotNullParameter(str2, "addressNotFoundErrorMessageString");
        Intrinsics.checkNotNullParameter(str3, "retryString");
        this.q = state2;
        this.r = sharingMapInteractor;
        this.s = str;
        this.t = str2;
        this.u = str3;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.m = compositeDisposable;
        a aVar = new a(this);
        Relay access$getMutatorsRelay$p = BaseMviEntityWithMutatorsRelay.access$getMutatorsRelay$p(this);
        Mutator mutator = new Mutator("InitialState", aVar);
        access$getMutatorsRelay$p.accept(new MutatorSingle(mutator.getName(), new SharingMapPresenterImpl$$special$$inlined$dispatchMutator$1(mutator)));
        Disposable subscribe = sharingMapInteractor.reconnects().subscribe(new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.reconnects()\n…on(::retry)\n            }");
        DisposableKt.addTo(subscribe, compositeDisposable);
    }

    public static final void access$retry(SharingMapPresenterImpl sharingMapPresenterImpl, AvitoMapCameraPosition avitoMapCameraPosition) {
        sharingMapPresenterImpl.cameraDraggingStarted(false);
        sharingMapPresenterImpl.cameraPositionChanged(avitoMapCameraPosition, false);
    }

    @Override // com.avito.android.messenger.map.sharing.SharingMapPresenter
    public void cameraDraggingStarted(boolean z) {
        String str = "CameraDraggingStarted(causedByNewUserLocation = " + z + ')';
        c cVar = new c(z);
        Relay access$getMutatorsRelay$p = BaseMviEntityWithMutatorsRelay.access$getMutatorsRelay$p(this);
        Mutator mutator = new Mutator(str, cVar);
        access$getMutatorsRelay$p.accept(new MutatorSingle(mutator.getName(), new SharingMapPresenterImpl$cameraDraggingStarted$$inlined$dispatchMutator$1(mutator)));
    }

    @Override // com.avito.android.messenger.map.sharing.SharingMapPresenter
    public void cameraPositionChanged(@NotNull AvitoMapCameraPosition avitoMapCameraPosition, boolean z) {
        Intrinsics.checkNotNullParameter(avitoMapCameraPosition, "newCameraPosition");
        BaseMviEntityWithMutatorsRelay.access$getMutatorsRelay$p(this).accept(new MutatorSingle("CameraPositionChanged(causedByNewUserLocation = " + z + ", newCameraPosition = " + avitoMapCameraPosition + ')', new d(this, z, avitoMapCameraPosition)));
    }

    @Override // com.avito.android.messenger.map.sharing.SharingMapPresenter
    public void editAddressClicked() {
        Relay mutatorsRelay = getMutatorsRelay();
        EditAddressClickedAction editAddressClickedAction = new EditAddressClickedAction(getEditAddressStream());
        mutatorsRelay.accept(new MutatorSingle(editAddressClickedAction.getName(), new SharingMapPresenterImpl$editAddressClicked$$inlined$plusAssign$1(editAddressClickedAction)));
    }

    @Override // com.avito.android.messenger.map.sharing.SharingMapPresenter
    public void myLocationButtonClicked() {
        Relay mutatorsRelay = getMutatorsRelay();
        MyLocationButtonClickedMutator myLocationButtonClickedMutator = new MyLocationButtonClickedMutator(getRequestLocationStream());
        mutatorsRelay.accept(new MutatorSingle(myLocationButtonClickedMutator.getName(), new SharingMapPresenterImpl$myLocationButtonClicked$$inlined$plusAssign$1(myLocationButtonClickedMutator)));
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v2.BaseMviEntity, androidx.lifecycle.ViewModel
    public void onCleared() {
        this.m.clear();
        super.onCleared();
    }

    @Override // com.avito.android.messenger.map.sharing.SharingMapPresenter
    public void selectedSearchSuggest(@NotNull GeoSearchSuggest geoSearchSuggest) {
        Intrinsics.checkNotNullParameter(geoSearchSuggest, SocialButtonClickedEventKt.SUGGEST);
        Relay mutatorsRelay = getMutatorsRelay();
        SelectedSearchSuggestMutator selectedSearchSuggestMutator = new SelectedSearchSuggestMutator(geoSearchSuggest);
        mutatorsRelay.accept(new MutatorSingle(selectedSearchSuggestMutator.getName(), new SharingMapPresenterImpl$selectedSearchSuggest$$inlined$plusAssign$1(selectedSearchSuggestMutator)));
    }

    @Override // com.avito.android.messenger.map.sharing.SharingMapPresenter
    public void sendLocationButtonClicked() {
        e eVar = new e(this);
        Relay access$getMutatorsRelay$p = BaseMviEntityWithMutatorsRelay.access$getMutatorsRelay$p(this);
        Action action = new Action("SendLocationClicked", eVar);
        access$getMutatorsRelay$p.accept(new MutatorSingle(action.getName(), new SharingMapPresenterImpl$sendLocationButtonClicked$$inlined$dispatchAction$1(action)));
    }

    @Override // com.avito.android.messenger.map.sharing.SharingMapPresenter
    public void userLocationChanged(@NotNull AvitoMapPoint avitoMapPoint) {
        Intrinsics.checkNotNullParameter(avitoMapPoint, "point");
        String str = "UserLocationChanged(newPoint = " + avitoMapPoint + ')';
        f fVar = new f(this, avitoMapPoint);
        Relay access$getMutatorsRelay$p = BaseMviEntityWithMutatorsRelay.access$getMutatorsRelay$p(this);
        Mutator mutator = new Mutator(str, fVar);
        access$getMutatorsRelay$p.accept(new MutatorSingle(mutator.getName(), new SharingMapPresenterImpl$userLocationChanged$$inlined$dispatchMutator$1(mutator)));
    }

    @Override // com.avito.android.messenger.map.sharing.SharingMapPresenter
    @NotNull
    public SingleLiveEvent<String> getEditAddressStream() {
        return this.o;
    }

    @Override // com.avito.android.messenger.map.sharing.SharingMapPresenter
    @NotNull
    public SingleLiveEvent<Unit> getRequestLocationStream() {
        return this.p;
    }

    @Override // com.avito.android.messenger.map.sharing.SharingMapPresenter
    @NotNull
    public SingleLiveEvent<MessageBody.Location> getSendLocationEventsStream() {
        return this.n;
    }
}

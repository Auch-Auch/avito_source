package com.avito.android.messenger.map.viewing;

import android.net.Uri;
import com.avito.android.avito_map.AvitoMapCameraPosition;
import com.avito.android.avito_map.AvitoMapCameraUpdate;
import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.avito_map.PointsWithOffset;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.NoMatchLink;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.messenger.channels.mvi.common.v2.BaseMviEntityWithMutatorsRelay;
import com.avito.android.messenger.channels.mvi.common.v2.Mutator;
import com.avito.android.messenger.channels.mvi.common.v2.MutatorSingle;
import com.avito.android.messenger.map.MapBottomSheet;
import com.avito.android.messenger.map.viewing.view.Pin;
import com.avito.android.messenger.map.viewing.view.PlatformMapView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Coordinates;
import com.avito.android.remote.model.messenger.geo.GeoMarker;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.Formatter;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.android.util.text.AttributedTextFormatter;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.jakewharton.rxrelay2.Relay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.bottom_sheet.BottomSheet;
import t6.n.y;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003BE\u0012\u0006\u0010J\u001a\u00020G\u0012\u0006\u0010=\u001a\u00020:\u0012\u0006\u0010&\u001a\u00020#\u0012\f\u0010F\u001a\b\u0012\u0004\u0012\u00020C0B\u0012\u0006\u0010K\u001a\u00020\u0002\u0012\u0006\u0010M\u001a\u00020L\u0012\u0006\u0010*\u001a\u00020'¢\u0006\u0004\bN\u0010OJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\nJ\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\nJ\u0017\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u001b\u0010\nR\"\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\"\u0010.\u001a\b\u0012\u0004\u0012\u00020+0\u001c8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b,\u0010\u001f\u001a\u0004\b-\u0010!R\"\u00102\u001a\b\u0012\u0004\u0012\u00020/0\u001c8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b0\u0010\u001f\u001a\u0004\b1\u0010!R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\"\u00109\u001a\b\u0012\u0004\u0012\u00020\u00060\u001c8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b7\u0010\u001f\u001a\u0004\b8\u0010!R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\"\u0010A\u001a\b\u0012\u0004\u0012\u00020>0\u001c8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b?\u0010\u001f\u001a\u0004\b@\u0010!R\u001c\u0010F\u001a\b\u0012\u0004\u0012\u00020C0B8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u0010I¨\u0006P"}, d2 = {"Lcom/avito/android/messenger/map/viewing/PlatformMapPresenterImpl;", "Lcom/avito/android/messenger/channels/mvi/common/v2/BaseMviEntityWithMutatorsRelay;", "Lcom/avito/android/messenger/map/viewing/view/PlatformMapView$State;", "Lcom/avito/android/messenger/map/viewing/PlatformMapPresenter;", "Lcom/avito/android/messenger/map/viewing/view/Pin;", "clickedPin", "", "pinClicked", "(Lcom/avito/android/messenger/map/viewing/view/Pin;)V", "cameraDraggingStarted", "()V", "Lcom/avito/android/avito_map/AvitoMapCameraPosition;", "newCameraPosition", "", "causedByNewUserLocation", "cameraPositionChanged", "(Lcom/avito/android/avito_map/AvitoMapCameraPosition;Z)V", "myLocationButtonClicked", "Lcom/avito/android/avito_map/AvitoMapPoint;", "point", "userLocationChanged", "(Lcom/avito/android/avito_map/AvitoMapPoint;)V", "createRouteButtonClicked", "Lru/avito/component/bottom_sheet/BottomSheet$Visibility;", ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY, "bottomSheetVisibilityChanged", "(Lru/avito/component/bottom_sheet/BottomSheet$Visibility;)V", "onCleared", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "Lcom/avito/android/remote/model/Coordinates;", "n", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getCreateRouteClicksStream", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "createRouteClicksStream", "Lcom/avito/android/util/text/AttributedTextFormatter;", "u", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Lcom/avito/android/util/SchedulersFactory3;", "w", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers3", "Lcom/avito/android/deep_linking/links/DeepLink;", "p", "getDeepLinkClicksStream", "deepLinkClicksStream", "", "o", "getGeoMarkersLoadingErrorsStream", "geoMarkersLoadingErrorsStream", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", AuthSource.OPEN_CHANNEL_LIST, "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "subscriptions", "r", "getRequestLocationStream", "requestLocationStream", "", "t", "I", "latLngBoundsPadding", "Landroid/net/Uri;", VKApiConst.Q, "getUriClicksStream", "uriClicksStream", "Lcom/avito/android/util/Formatter;", "", VKApiConst.VERSION, "Lcom/avito/android/util/Formatter;", "errorFormatter", "Lcom/avito/android/messenger/map/viewing/PlatformMapInteractor;", "s", "Lcom/avito/android/messenger/map/viewing/PlatformMapInteractor;", "interactor", "defaultState", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Lcom/avito/android/messenger/map/viewing/PlatformMapInteractor;ILcom/avito/android/util/text/AttributedTextFormatter;Lcom/avito/android/util/Formatter;Lcom/avito/android/messenger/map/viewing/view/PlatformMapView$State;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/util/SchedulersFactory3;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class PlatformMapPresenterImpl extends BaseMviEntityWithMutatorsRelay<PlatformMapView.State> implements PlatformMapPresenter {
    public final CompositeDisposable m = new CompositeDisposable();
    @NotNull
    public final SingleLiveEvent<Coordinates> n = new SingleLiveEvent<>();
    @NotNull
    public final SingleLiveEvent<String> o = new SingleLiveEvent<>();
    @NotNull
    public final SingleLiveEvent<DeepLink> p = new SingleLiveEvent<>();
    @NotNull
    public final SingleLiveEvent<Uri> q = new SingleLiveEvent<>();
    @NotNull
    public final SingleLiveEvent<Unit> r = new SingleLiveEvent<>();
    public final PlatformMapInteractor s;
    public final int t;
    public final AttributedTextFormatter u;
    public final Formatter<Throwable> v;
    public final SchedulersFactory3 w;

    public static final class a extends Lambda implements Function1<PlatformMapView.State, PlatformMapView.State> {
        public final /* synthetic */ PlatformMapPresenterImpl a;
        public final /* synthetic */ BottomSheet.Visibility b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(PlatformMapPresenterImpl platformMapPresenterImpl, BottomSheet.Visibility visibility) {
            super(1);
            this.a = platformMapPresenterImpl;
            this.b = visibility;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public PlatformMapView.State invoke(PlatformMapView.State state) {
            PlatformMapView.State state2 = state;
            Intrinsics.checkNotNullParameter(state2, "oldState");
            if (Intrinsics.areEqual(this.b, BottomSheet.Visibility.Closed.INSTANCE)) {
                PlatformMapPresenterImpl.access$scheduleCloseBottomSheet(this.a);
                return state2;
            }
            boolean areEqual = Intrinsics.areEqual(this.b, BottomSheet.Visibility.Expanded.INSTANCE);
            MapBottomSheet.State bottomSheetState = state2.getBottomSheetState();
            if (bottomSheetState instanceof MapBottomSheet.State.Expanded) {
                return PlatformMapView.State.copy$default(state2, null, MapBottomSheet.State.Expanded.copy$default((MapBottomSheet.State.Expanded) state2.getBottomSheetState(), null, null, false, false, false, areEqual, 31, null), null, null, false, false, false, 125, null);
            }
            if (Intrinsics.areEqual(bottomSheetState, MapBottomSheet.State.Closed.INSTANCE)) {
                return state2;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class b extends Lambda implements Function1<PlatformMapView.State, PlatformMapView.State> {
        public static final b a = new b();

        public b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public PlatformMapView.State invoke(PlatformMapView.State state) {
            PlatformMapView.State state2 = state;
            Intrinsics.checkNotNullParameter(state2, "oldState");
            return (state2.getAwaitingNewUserLocation() || state2.getForceMoveCamera() || !state2.isDragging()) ? PlatformMapView.State.copy$default(state2, null, null, null, null, true, false, false, 15, null) : state2;
        }
    }

    public static final class c extends Lambda implements Function1<PlatformMapView.State, PlatformMapView.State> {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ AvitoMapCameraPosition b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(boolean z, AvitoMapCameraPosition avitoMapCameraPosition) {
            super(1);
            this.a = z;
            this.b = avitoMapCameraPosition;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public PlatformMapView.State invoke(PlatformMapView.State state) {
            PlatformMapView.State state2 = state;
            Intrinsics.checkNotNullParameter(state2, "oldState");
            boolean z = this.a;
            return (!z || (z && state2.getAwaitingNewUserLocation())) ? PlatformMapView.State.copy$default(state2, null, null, new AvitoMapCameraUpdate(this.b, null, null, 6, null), null, false, false, this.a, 11, null) : state2;
        }
    }

    public static final class d extends Lambda implements Function1<PlatformMapView.State, PlatformMapView.State> {
        public final /* synthetic */ PlatformMapPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(PlatformMapPresenterImpl platformMapPresenterImpl) {
            super(1);
            this.a = platformMapPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public PlatformMapView.State invoke(PlatformMapView.State state) {
            T t;
            PlatformMapView.State state2 = state;
            Intrinsics.checkNotNullParameter(state2, "oldState");
            Iterator<T> it = state2.getPins().iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                t = it.next();
                if (t.isSelected()) {
                    break;
                }
            }
            T t2 = t;
            if (t2 != null) {
                this.a.getCreateRouteClicksStream().postValue(new Coordinates(t2.getPosition().getLatitude(), t2.getPosition().getLongitude()));
            }
            return state2;
        }
    }

    public static final class e extends Lambda implements Function1<PlatformMapView.State, PlatformMapView.State> {
        public final /* synthetic */ PlatformMapPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(PlatformMapPresenterImpl platformMapPresenterImpl) {
            super(1);
            this.a = platformMapPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public PlatformMapView.State invoke(PlatformMapView.State state) {
            PlatformMapView.State state2 = state;
            Intrinsics.checkNotNullParameter(state2, "oldState");
            if (state2.isDragging() && !state2.getAwaitingNewUserLocation()) {
                return state2;
            }
            this.a.getRequestLocationStream().postValue(Unit.INSTANCE);
            return (!state2.getAwaitingNewUserLocation() || state2.getForceMoveCamera()) ? PlatformMapView.State.copy$default(state2, null, null, null, null, false, true, false, 31, null) : state2;
        }
    }

    public static final class f extends Lambda implements Function1<PlatformMapView.State, PlatformMapView.State> {
        public final /* synthetic */ PlatformMapPresenterImpl a;
        public final /* synthetic */ Pin b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(PlatformMapPresenterImpl platformMapPresenterImpl, Pin pin) {
            super(1);
            this.a = platformMapPresenterImpl;
            this.b = pin;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public PlatformMapView.State invoke(PlatformMapView.State state) {
            Object obj;
            MapBottomSheet.State state2;
            PlatformMapView.State state3 = state;
            Intrinsics.checkNotNullParameter(state3, "oldState");
            if (!this.b.isSelected()) {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                for (T t : state3.getPins()) {
                    if (Intrinsics.areEqual(t, this.b)) {
                        t = (T) Pin.copy$default(t, null, null, null, null, true, 15, null);
                    } else if (t.isSelected()) {
                        t = (T) Pin.copy$default(t, null, null, null, null, false, 15, null);
                    }
                    linkedHashSet.add(t);
                }
                Iterator it = linkedHashSet.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (((Pin) obj).isSelected()) {
                        break;
                    }
                }
                Pin pin = (Pin) obj;
                if (pin != null) {
                    state2 = new MapBottomSheet.State.Expanded(pin.getTitle(), pin.getDescription(), linkedHashSet.size() > 1, true, false, false, 48, null);
                } else {
                    state2 = MapBottomSheet.State.Closed.INSTANCE;
                }
                return PlatformMapView.State.copy$default(state3, linkedHashSet, state2, null, null, false, false, false, 124, null);
            } else if (!PlatformMapPresenterImpl.access$isCloseable$p(this.a, state3.getBottomSheetState())) {
                return state3;
            } else {
                PlatformMapPresenterImpl.access$scheduleCloseBottomSheet(this.a);
                return state3;
            }
        }
    }

    public static final class g extends Lambda implements Function1<PlatformMapView.State, PlatformMapView.State> {
        public final /* synthetic */ PlatformMapPresenterImpl a;
        public final /* synthetic */ AvitoMapPoint b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(PlatformMapPresenterImpl platformMapPresenterImpl, AvitoMapPoint avitoMapPoint) {
            super(1);
            this.a = platformMapPresenterImpl;
            this.b = avitoMapPoint;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public PlatformMapView.State invoke(PlatformMapView.State state) {
            PlatformMapView.State state2 = state;
            Intrinsics.checkNotNullParameter(state2, "oldState");
            if (state2.getAwaitingNewUserLocation()) {
                this.a.cameraPositionChanged(new AvitoMapCameraPosition(this.b, 18.0f, 0.0f, null, null, 28, null), true);
            }
            return Intrinsics.areEqual(state2.getUserPoint(), this.b) ^ true ? PlatformMapView.State.copy$default(state2, null, null, null, this.b, false, false, false, 119, null) : state2;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlatformMapPresenterImpl(@NotNull PlatformMapInteractor platformMapInteractor, int i, @NotNull AttributedTextFormatter attributedTextFormatter, @NotNull Formatter<Throwable> formatter, @NotNull PlatformMapView.State state, @NotNull SchedulersFactory schedulersFactory, @NotNull SchedulersFactory3 schedulersFactory3) {
        super("PlatformMapPresenter", state, schedulersFactory, null, 8, null);
        Intrinsics.checkNotNullParameter(platformMapInteractor, "interactor");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        Intrinsics.checkNotNullParameter(formatter, "errorFormatter");
        Intrinsics.checkNotNullParameter(state, "defaultState");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers3");
        this.s = platformMapInteractor;
        this.t = i;
        this.u = attributedTextFormatter;
        this.v = formatter;
        this.w = schedulersFactory3;
        Disposable subscribe = this.s.geoMarkersObservable().observeOn(this.w.io()).map(new Function<GeoMarker[], Set<? extends Pin>>() { // from class: com.avito.android.messenger.map.viewing.PlatformMapPresenterImpl$subscribeToPinUpdates$1
            public final Set<Pin> apply(GeoMarker[] geoMarkerArr) {
                String str;
                ArrayList arrayList;
                String str2;
                ArrayList arrayList2;
                Intrinsics.checkNotNullExpressionValue(geoMarkerArr, "updatedGeoMarkers");
                if (!(!(geoMarkerArr.length == 0))) {
                    return y.emptySet();
                }
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                if (geoMarkerArr.length == 1) {
                    PlatformMapPresenterImpl platformMapPresenterImpl = PlatformMapPresenterImpl.this;
                    GeoMarker geoMarker = (GeoMarker) ArraysKt___ArraysKt.first(geoMarkerArr);
                    AvitoMapPoint avitoMapPoint = new AvitoMapPoint(geoMarker.getLatitude(), geoMarker.getLongitude());
                    String title = geoMarker.getTitle();
                    if (title != null) {
                        str2 = title;
                    } else {
                        str2 = "";
                    }
                    List<AttributedText> description = geoMarker.getDescription();
                    if (description != null) {
                        ArrayList arrayList3 = new ArrayList();
                        for (T t2 : description) {
                            t2.setOnDeepLinkClickListener(
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x005a: INVOKE  
                                  (r3v8 't2' T)
                                  (wrap: com.avito.android.messenger.map.viewing.PlatformMapPresenterImpl$subscribeToPinUpdates$1$toPin$$inlined$mapNotNull$lambda$1 : 0x0057: CONSTRUCTOR  (r4v1 com.avito.android.messenger.map.viewing.PlatformMapPresenterImpl$subscribeToPinUpdates$1$toPin$$inlined$mapNotNull$lambda$1) = (r1v3 'platformMapPresenterImpl' com.avito.android.messenger.map.viewing.PlatformMapPresenterImpl) call: com.avito.android.messenger.map.viewing.PlatformMapPresenterImpl$subscribeToPinUpdates$1$toPin$$inlined$mapNotNull$lambda$1.<init>(com.avito.android.messenger.map.viewing.PlatformMapPresenterImpl):void type: CONSTRUCTOR)
                                 type: VIRTUAL call: com.avito.android.remote.model.text.AttributedText.setOnDeepLinkClickListener(com.avito.android.deep_linking.links.OnDeepLinkClickListener):void in method: com.avito.android.messenger.map.viewing.PlatformMapPresenterImpl$subscribeToPinUpdates$1.apply(com.avito.android.remote.model.messenger.geo.GeoMarker[]):java.util.Set<com.avito.android.messenger.map.viewing.view.Pin>, file: classes3.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:245)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:104)
                                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:220)
                                	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:173)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:345)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:298)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:267)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0057: CONSTRUCTOR  (r4v1 com.avito.android.messenger.map.viewing.PlatformMapPresenterImpl$subscribeToPinUpdates$1$toPin$$inlined$mapNotNull$lambda$1) = (r1v3 'platformMapPresenterImpl' com.avito.android.messenger.map.viewing.PlatformMapPresenterImpl) call: com.avito.android.messenger.map.viewing.PlatformMapPresenterImpl$subscribeToPinUpdates$1$toPin$$inlined$mapNotNull$lambda$1.<init>(com.avito.android.messenger.map.viewing.PlatformMapPresenterImpl):void type: CONSTRUCTOR in method: com.avito.android.messenger.map.viewing.PlatformMapPresenterImpl$subscribeToPinUpdates$1.apply(com.avito.android.remote.model.messenger.geo.GeoMarker[]):java.util.Set<com.avito.android.messenger.map.viewing.view.Pin>, file: classes3.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:955)
                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:780)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:394)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:275)
                                	... 39 more
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.avito.android.messenger.map.viewing.PlatformMapPresenterImpl$subscribeToPinUpdates$1$toPin$$inlined$mapNotNull$lambda$1, state: NOT_LOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:212)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:657)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                                	... 45 more
                                */
                            /*
                            // Method dump skipped, instructions count: 233
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.map.viewing.PlatformMapPresenterImpl$subscribeToPinUpdates$1.apply(com.avito.android.remote.model.messenger.geo.GeoMarker[]):java.util.Set");
                        }
                    }).doOnError(new Consumer<Throwable>() { // from class: com.avito.android.messenger.map.viewing.PlatformMapPresenterImpl$subscribeToPinUpdates$2
                        public final void accept(Throwable th) {
                            PlatformMapPresenterImpl.this.getGeoMarkersLoadingErrorsStream().postValue(PlatformMapPresenterImpl.this.v.format(th));
                        }
                    }).onErrorResumeWith(Observable.never()).subscribe(new PlatformMapPresenterImpl$subscribeToPinUpdates$3(this));
                    Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.geoMarkersObs…          }\n            }");
                    DisposableKt.addTo(subscribe, this.m);
                }

                public static final boolean access$isCloseable$p(PlatformMapPresenterImpl platformMapPresenterImpl, MapBottomSheet.State state) {
                    Objects.requireNonNull(platformMapPresenterImpl);
                    if (!(state instanceof MapBottomSheet.State.Expanded)) {
                        state = null;
                    }
                    MapBottomSheet.State.Expanded expanded = (MapBottomSheet.State.Expanded) state;
                    return expanded != null && expanded.isCloseable();
                }

                public static final MapBottomSheet.State access$newBottomSheetState(PlatformMapPresenterImpl platformMapPresenterImpl, Set set) {
                    Object obj;
                    Objects.requireNonNull(platformMapPresenterImpl);
                    Iterator it = set.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it.next();
                        if (((Pin) obj).isSelected()) {
                            break;
                        }
                    }
                    Pin pin = (Pin) obj;
                    if (pin == null) {
                        return MapBottomSheet.State.Closed.INSTANCE;
                    }
                    return new MapBottomSheet.State.Expanded(pin.getTitle(), pin.getDescription(), set.size() > 1, true, false, false, 48, null);
                }

                public static final AvitoMapCameraUpdate access$newCameraUpdate(PlatformMapPresenterImpl platformMapPresenterImpl, Set set) {
                    AvitoMapCameraUpdate avitoMapCameraUpdate;
                    Objects.requireNonNull(platformMapPresenterImpl);
                    Object obj = null;
                    if (!(!set.isEmpty())) {
                        return null;
                    }
                    Iterator it = set.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        if (((Pin) next).isSelected()) {
                            obj = next;
                            break;
                        }
                    }
                    Pin pin = (Pin) obj;
                    if (pin != null) {
                        avitoMapCameraUpdate = new AvitoMapCameraUpdate(new AvitoMapCameraPosition(pin.getPosition(), 18.0f, 0.0f, null, null, 28, null), null, null, 6, null);
                    } else if (set.size() > 1) {
                        int i = platformMapPresenterImpl.t;
                        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(set, 10));
                        Iterator it2 = set.iterator();
                        while (it2.hasNext()) {
                            arrayList.add(((Pin) it2.next()).getPosition());
                        }
                        return new AvitoMapCameraUpdate(null, null, new PointsWithOffset(arrayList, i), 3, null);
                    } else {
                        avitoMapCameraUpdate = new AvitoMapCameraUpdate(new AvitoMapCameraPosition(((Pin) CollectionsKt___CollectionsKt.first(set)).getPosition(), 18.0f, 0.0f, null, null, 28, null), null, null, 6, null);
                    }
                    return avitoMapCameraUpdate;
                }

                public static final void access$scheduleCloseBottomSheet(PlatformMapPresenterImpl platformMapPresenterImpl) {
                    Relay mutatorsRelay = platformMapPresenterImpl.getMutatorsRelay();
                    Mutator mutator = new Mutator("scheduleCloseBottomSheet()", new a2.a.a.o1.e.d.b(platformMapPresenterImpl));
                    mutatorsRelay.accept(new MutatorSingle(mutator.getName(), new PlatformMapPresenterImpl$scheduleCloseBottomSheet$$inlined$plusAssign$1(mutator)));
                }

                public static final Pin access$toPin(PlatformMapPresenterImpl platformMapPresenterImpl, GeoMarker geoMarker, boolean z) {
                    ArrayList arrayList;
                    Objects.requireNonNull(platformMapPresenterImpl);
                    AvitoMapPoint avitoMapPoint = new AvitoMapPoint(geoMarker.getLatitude(), geoMarker.getLongitude());
                    String title = geoMarker.getTitle();
                    if (title == null) {
                        title = "";
                    }
                    List<AttributedText> description = geoMarker.getDescription();
                    if (description != null) {
                        ArrayList arrayList2 = new ArrayList();
                        for (T t2 : description) {
                            t2.setOnDeepLinkClickListener(new OnDeepLinkClickListener() { // from class: com.avito.android.messenger.map.viewing.PlatformMapPresenterImpl$toPin$$inlined$mapNotNull$lambda$1
                                @Override // com.avito.android.deep_linking.links.OnDeepLinkClickListener
                                public void onDeepLinkClick(@NotNull DeepLink deepLink) {
                                    Intrinsics.checkNotNullParameter(deepLink, "deepLink");
                                    if (!(deepLink instanceof NoMatchLink)) {
                                        String str = PlatformMapPresenterImpl.this.getTAG();
                                        Logs.verbose$default(str, "onDeepLinkClick(" + deepLink + "):\n\t valid Deeplink", null, 4, null);
                                        PlatformMapPresenterImpl.this.getDeepLinkClicksStream().postValue(deepLink);
                                    }
                                }
                            });
                            CharSequence format = platformMapPresenterImpl.u.format(t2);
                            if (format != null) {
                                arrayList2.add(format);
                            }
                        }
                        arrayList = arrayList2;
                    } else {
                        arrayList = CollectionsKt__CollectionsKt.emptyList();
                    }
                    return new Pin(null, avitoMapPoint, title, arrayList, z, 1, null);
                }

                @Override // com.avito.android.messenger.map.viewing.PlatformMapPresenter
                public void bottomSheetVisibilityChanged(@NotNull BottomSheet.Visibility visibility) {
                    Intrinsics.checkNotNullParameter(visibility, ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY);
                    Relay mutatorsRelay = getMutatorsRelay();
                    Mutator mutator = new Mutator("BottomSheetVisibilityChanged(" + visibility + ')', new a(this, visibility));
                    mutatorsRelay.accept(new MutatorSingle(mutator.getName(), new PlatformMapPresenterImpl$bottomSheetVisibilityChanged$$inlined$plusAssign$1(mutator)));
                }

                @Override // com.avito.android.messenger.map.viewing.PlatformMapPresenter
                public void cameraDraggingStarted() {
                    Relay mutatorsRelay = getMutatorsRelay();
                    Mutator mutator = new Mutator("CameraDraggingStarted", b.a);
                    mutatorsRelay.accept(new MutatorSingle(mutator.getName(), new PlatformMapPresenterImpl$cameraDraggingStarted$$inlined$plusAssign$1(mutator)));
                }

                @Override // com.avito.android.messenger.map.viewing.PlatformMapPresenter
                public void cameraPositionChanged(@NotNull AvitoMapCameraPosition avitoMapCameraPosition, boolean z) {
                    Intrinsics.checkNotNullParameter(avitoMapCameraPosition, "newCameraPosition");
                    Relay mutatorsRelay = getMutatorsRelay();
                    Mutator mutator = new Mutator("CameraPositionChanged(causedByNewUserLocation = " + z + ", newCameraPosition = " + avitoMapCameraPosition + ')', new c(z, avitoMapCameraPosition));
                    mutatorsRelay.accept(new MutatorSingle(mutator.getName(), new PlatformMapPresenterImpl$cameraPositionChanged$$inlined$plusAssign$1(mutator)));
                }

                @Override // com.avito.android.messenger.map.viewing.PlatformMapPresenter
                public void createRouteButtonClicked() {
                    Relay mutatorsRelay = getMutatorsRelay();
                    Mutator mutator = new Mutator("CreateRouteButtonClicked", new d(this));
                    mutatorsRelay.accept(new MutatorSingle(mutator.getName(), new PlatformMapPresenterImpl$createRouteButtonClicked$$inlined$plusAssign$1(mutator)));
                }

                @Override // com.avito.android.messenger.map.viewing.PlatformMapPresenter
                public void myLocationButtonClicked() {
                    Relay mutatorsRelay = getMutatorsRelay();
                    Mutator mutator = new Mutator("MyLocationButtonClicked", new e(this));
                    mutatorsRelay.accept(new MutatorSingle(mutator.getName(), new PlatformMapPresenterImpl$myLocationButtonClicked$$inlined$plusAssign$1(mutator)));
                }

                @Override // com.avito.android.messenger.channels.mvi.common.v2.BaseMviEntity, androidx.lifecycle.ViewModel
                public void onCleared() {
                    this.m.clear();
                    super.onCleared();
                }

                @Override // com.avito.android.messenger.map.viewing.PlatformMapPresenter
                public void pinClicked(@NotNull Pin pin) {
                    Intrinsics.checkNotNullParameter(pin, "clickedPin");
                    Relay mutatorsRelay = getMutatorsRelay();
                    Mutator mutator = new Mutator("PinClicked(clickedPin = " + pin + ')', new f(this, pin));
                    mutatorsRelay.accept(new MutatorSingle(mutator.getName(), new PlatformMapPresenterImpl$pinClicked$$inlined$plusAssign$1(mutator)));
                }

                @Override // com.avito.android.messenger.map.viewing.PlatformMapPresenter
                public void userLocationChanged(@NotNull AvitoMapPoint avitoMapPoint) {
                    Intrinsics.checkNotNullParameter(avitoMapPoint, "point");
                    Relay mutatorsRelay = getMutatorsRelay();
                    Mutator mutator = new Mutator("UserLocationChanged(newAvitoMapPoint = " + avitoMapPoint + ')', new g(this, avitoMapPoint));
                    mutatorsRelay.accept(new MutatorSingle(mutator.getName(), new PlatformMapPresenterImpl$userLocationChanged$$inlined$plusAssign$1(mutator)));
                }

                @Override // com.avito.android.messenger.map.viewing.PlatformMapPresenter
                @NotNull
                public SingleLiveEvent<Coordinates> getCreateRouteClicksStream() {
                    return this.n;
                }

                @Override // com.avito.android.messenger.map.viewing.PlatformMapPresenter
                @NotNull
                public SingleLiveEvent<DeepLink> getDeepLinkClicksStream() {
                    return this.p;
                }

                @Override // com.avito.android.messenger.map.viewing.PlatformMapPresenter
                @NotNull
                public SingleLiveEvent<String> getGeoMarkersLoadingErrorsStream() {
                    return this.o;
                }

                @Override // com.avito.android.messenger.map.viewing.PlatformMapPresenter
                @NotNull
                public SingleLiveEvent<Unit> getRequestLocationStream() {
                    return this.r;
                }

                @Override // com.avito.android.messenger.map.viewing.PlatformMapPresenter
                @NotNull
                public SingleLiveEvent<Uri> getUriClicksStream() {
                    return this.q;
                }
            }

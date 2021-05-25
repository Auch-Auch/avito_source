package com.avito.android.delivery.map.start_ordering;

import a2.a.a.k0.a.b.s;
import a2.a.a.k0.a.b.t;
import a2.a.a.k0.a.b.u;
import a2.g.r.g;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import com.avito.android.SummaryState;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.advert_core.marketplace.MarketplacePresenterKt;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.ParametrizedEventsKt;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker;
import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.delivery.analytics.map.BuyWithDeliveryEvent;
import com.avito.android.delivery.analytics.map.DeliveryOrderRequestEvent;
import com.avito.android.delivery.map.common.CameraCoordinatesEvent;
import com.avito.android.delivery.map.common.marker.Marker;
import com.avito.android.delivery.map.start_ordering.PreselectPinEvent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.ParametrizedEvent;
import com.avito.android.remote.model.delivery.DeliveryPointsRectResult;
import com.avito.android.remote.model.delivery.DeliveryPreselectPoint;
import com.avito.android.remote.model.delivery.Overlay;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002By\u0012\u0006\u0010]\u001a\u00020Z\u0012\u0006\u0010$\u001a\u00020!\u0012\b\u0010O\u001a\u0004\u0018\u00010(\u0012\b\u00108\u001a\u0004\u0018\u00010(\u0012\b\u0010k\u001a\u0004\u0018\u00010(\u0012\u0006\u0010W\u001a\u00020\u000e\u0012\u0006\u0010\u001c\u001a\u00020\u000e\u0012\b\u0010e\u001a\u0004\u0018\u00010(\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u0010H\u001a\u00020E\u0012\u0006\u0010i\u001a\u00020f\u0012\b\u0010D\u001a\u0004\u0018\u00010A\u0012\u0006\u0010m\u001a\u00020l¢\u0006\u0004\bn\u0010oJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0011\u0010\tJ\u0019\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0016\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\"\u0010-\u001a\b\u0012\u0004\u0012\u00020(0'8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\"\u00101\u001a\b\u0012\u0004\u0012\u00020.0'8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b/\u0010*\u001a\u0004\b0\u0010,R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00108\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\"\u0010@\u001a\b\u0012\u0004\u0012\u00020=0'8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b>\u0010*\u001a\u0004\b?\u0010,R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010GR(\u0010M\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020J0I0'8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bK\u0010*\u001a\u0004\bL\u0010,R\u0018\u0010O\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bN\u00107R\u0018\u0010R\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\"\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00050'8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bS\u0010*\u001a\u0004\bT\u0010,R\u0016\u0010W\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bV\u0010\u0019R\u0018\u0010Y\u001a\u0004\u0018\u0001028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bX\u00104R\u0016\u0010]\u001a\u00020Z8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R\"\u0010`\u001a\b\u0012\u0004\u0012\u00020(0'8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b^\u0010*\u001a\u0004\b_\u0010,R\u0018\u0010c\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\ba\u0010bR\u0018\u0010e\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bd\u00107R\u0016\u0010i\u001a\u00020f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bg\u0010hR\u0018\u0010k\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bj\u00107¨\u0006p"}, d2 = {"Lcom/avito/android/delivery/map/start_ordering/DeliveryRdsStartOrderingViewModelImpl;", "Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/delivery/map/start_ordering/DeliveryRdsStartOrderingViewModel;", "Lcom/avito/android/delivery/map/common/CameraCoordinatesEvent;", "event", "", "onNewCameraCoordinates", "(Lcom/avito/android/delivery/map/common/CameraCoordinatesEvent;)V", "onAuthCompleted", "()V", "Lcom/avito/android/avito_map/AvitoMapPoint;", "point", "onNewLocation", "(Lcom/avito/android/avito_map/AvitoMapPoint;)V", "", "isNeedOpenCheckout", "()Z", "onCleared", "Lcom/avito/android/SummaryState;", "state", "setDataFromCheckout", "(Lcom/avito/android/SummaryState;)V", "summaryState", "()Lcom/avito/android/SummaryState;", g.a, "Z", "checkPreselectedLocation", VKApiConst.VERSION, "isCart", "Lcom/avito/android/delivery/map/start_ordering/DeliveryStartOrderingResourceProvider;", "x", "Lcom/avito/android/delivery/map/start_ordering/DeliveryStartOrderingResourceProvider;", "resourceProvider", "Lcom/avito/android/util/SchedulersFactory3;", VKApiConst.Q, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "h", "Lcom/avito/android/SummaryState;", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "", "o", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getSelectCheckoutPinEvent", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "selectCheckoutPinEvent", "Lcom/avito/android/delivery/map/start_ordering/PreselectPinEvent;", "n", "getPreselectPinEvent", "preselectPinEvent", "Lio/reactivex/rxjava3/disposables/Disposable;", "d", "Lio/reactivex/rxjava3/disposables/Disposable;", "getMarkersDisposable", "s", "Ljava/lang/String;", "analyticsAdvertId", "Lcom/avito/android/delivery/map/common/marker/Marker$Pin;", "i", "Lcom/avito/android/delivery/map/common/marker/Marker$Pin;", "preselectPoint", "Lcom/avito/android/remote/model/delivery/Overlay;", "k", "getOverlayEvent", "overlayEvent", "Lcom/avito/android/remote/model/ParametrizedEvent;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/avito/android/remote/model/ParametrizedEvent;", MarketplacePresenterKt.KEY_CONTACT_EVENT, "Lcom/avito/android/analytics/Analytics;", "y", "Lcom/avito/android/analytics/Analytics;", "analytics", "", "Lcom/avito/android/delivery/map/common/marker/Marker;", "j", "getNewMarkersEvents", "newMarkersEvents", "r", BookingInfoActivity.EXTRA_ITEM_ID, "f", "Lcom/avito/android/avito_map/AvitoMapPoint;", "userLatLng", AuthSource.OPEN_CHANNEL_LIST, "getAuthScreenChanges", "authScreenChanges", "u", "isMarketplace", "c", "authorizedDisposable", "Lcom/avito/android/delivery/map/start_ordering/DeliveryRdsStartOrderingInteractor;", "p", "Lcom/avito/android/delivery/map/start_ordering/DeliveryRdsStartOrderingInteractor;", "interactor", "l", "getSnackBarEvents", "snackBarEvents", "e", "Ljava/lang/Boolean;", "authorized", "w", "cartItems", "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "z", "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "tracker", "t", "source", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "<init>", "(Lcom/avito/android/delivery/map/start_ordering/DeliveryRdsStartOrderingInteractor;Lcom/avito/android/util/SchedulersFactory3;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Lcom/avito/android/delivery/map/start_ordering/DeliveryStartOrderingResourceProvider;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;Lcom/avito/android/remote/model/ParametrizedEvent;Lcom/avito/android/account/AccountStateProvider;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryRdsStartOrderingViewModelImpl extends ViewModel implements DeliveryRdsStartOrderingViewModel {
    public final ParametrizedEvent A;
    public Disposable c;
    public Disposable d;
    public Boolean e;
    public AvitoMapPoint f;
    public boolean g = true;
    public SummaryState h;
    public Marker.Pin i;
    @NotNull
    public final SingleLiveEvent<List<Marker>> j = new SingleLiveEvent<>();
    @NotNull
    public final SingleLiveEvent<Overlay> k = new SingleLiveEvent<>();
    @NotNull
    public final SingleLiveEvent<String> l = new SingleLiveEvent<>();
    @NotNull
    public final SingleLiveEvent<Unit> m = new SingleLiveEvent<>();
    @NotNull
    public final SingleLiveEvent<PreselectPinEvent> n = new SingleLiveEvent<>();
    @NotNull
    public final SingleLiveEvent<String> o = new SingleLiveEvent<>();
    public final DeliveryRdsStartOrderingInteractor p;
    public final SchedulersFactory3 q;
    public final String r;
    public final String s;
    public final String t;
    public final boolean u;
    public final boolean v;
    public final String w;
    public final DeliveryStartOrderingResourceProvider x;
    public final Analytics y;
    public final BaseScreenPerformanceTracker z;

    public static final class a<T> implements Consumer<Boolean> {
        public final /* synthetic */ DeliveryRdsStartOrderingViewModelImpl a;

        public a(DeliveryRdsStartOrderingViewModelImpl deliveryRdsStartOrderingViewModelImpl) {
            this.a = deliveryRdsStartOrderingViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Boolean bool) {
            ParametrizedClickStreamEvent clickStreamEvent;
            Boolean bool2 = bool;
            this.a.e = bool2;
            Intrinsics.checkNotNullExpressionValue(bool2, "authorized");
            if (bool2.booleanValue()) {
                this.a.y.track(new DeliveryOrderRequestEvent(this.a.s, this.a.t, this.a.u, this.a.v, this.a.w));
                ParametrizedEvent parametrizedEvent = this.a.A;
                if (parametrizedEvent != null && (clickStreamEvent = ParametrizedEventsKt.toClickStreamEvent(parametrizedEvent)) != null) {
                    this.a.y.track(clickStreamEvent);
                    return;
                }
                return;
            }
            DeliveryRdsStartOrderingViewModelImpl.access$authenticate(this.a);
        }
    }

    public DeliveryRdsStartOrderingViewModelImpl(@NotNull DeliveryRdsStartOrderingInteractor deliveryRdsStartOrderingInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @Nullable String str, @Nullable String str2, @Nullable String str3, boolean z2, boolean z3, @Nullable String str4, @NotNull DeliveryStartOrderingResourceProvider deliveryStartOrderingResourceProvider, @NotNull Analytics analytics, @NotNull BaseScreenPerformanceTracker baseScreenPerformanceTracker, @Nullable ParametrizedEvent parametrizedEvent, @NotNull AccountStateProvider accountStateProvider) {
        Intrinsics.checkNotNullParameter(deliveryRdsStartOrderingInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(deliveryStartOrderingResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(baseScreenPerformanceTracker, "tracker");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        this.p = deliveryRdsStartOrderingInteractor;
        this.q = schedulersFactory3;
        this.r = str;
        this.s = str2;
        this.t = str3;
        this.u = z2;
        this.v = z3;
        this.w = str4;
        this.x = deliveryStartOrderingResourceProvider;
        this.y = analytics;
        this.z = baseScreenPerformanceTracker;
        this.A = parametrizedEvent;
        this.c = accountStateProvider.currentAuthorized().subscribeOn(schedulersFactory3.io()).observeOn(schedulersFactory3.mainThread()).subscribe(new a(this), new u(new Function1<Throwable, Unit>(Logs.INSTANCE) { // from class: com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingViewModelImpl.b
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Throwable th) {
                Logs logs = (Logs) this.receiver;
                Logs.error(th);
                return Unit.INSTANCE;
            }
        }));
        analytics.track(new BuyWithDeliveryEvent());
    }

    public static final void access$authenticate(DeliveryRdsStartOrderingViewModelImpl deliveryRdsStartOrderingViewModelImpl) {
        deliveryRdsStartOrderingViewModelImpl.getAuthScreenChanges().postValue(Unit.INSTANCE);
    }

    public static final void access$onGetMarkersError(DeliveryRdsStartOrderingViewModelImpl deliveryRdsStartOrderingViewModelImpl, TypedError typedError) {
        deliveryRdsStartOrderingViewModelImpl.z.trackLoadingError();
        deliveryRdsStartOrderingViewModelImpl.z.startDrawing();
        if (typedError instanceof ErrorWithMessage) {
            deliveryRdsStartOrderingViewModelImpl.getSnackBarEvents().postValue(((ErrorWithMessage) typedError).getMessage());
        } else {
            deliveryRdsStartOrderingViewModelImpl.getSnackBarEvents().postValue(deliveryRdsStartOrderingViewModelImpl.x.getUnknownError());
        }
        deliveryRdsStartOrderingViewModelImpl.z.trackDrawnError();
    }

    public static final void access$onGetMarkersSuccess(DeliveryRdsStartOrderingViewModelImpl deliveryRdsStartOrderingViewModelImpl, DeliveryPointsRectResult deliveryPointsRectResult) {
        Marker.Pin convert;
        deliveryRdsStartOrderingViewModelImpl.z.trackLoaded();
        deliveryRdsStartOrderingViewModelImpl.z.startPreparing();
        List<Marker> convert2 = DeliveryRdsStartOrderingViewModelKt.convert(deliveryPointsRectResult);
        deliveryRdsStartOrderingViewModelImpl.z.trackPrepared();
        deliveryRdsStartOrderingViewModelImpl.z.startDrawing();
        deliveryRdsStartOrderingViewModelImpl.getNewMarkersEvents().postValue(convert2);
        deliveryRdsStartOrderingViewModelImpl.getOverlayEvent().postValue(deliveryPointsRectResult.getOverlay());
        deliveryRdsStartOrderingViewModelImpl.z.trackDrawn();
        if (deliveryRdsStartOrderingViewModelImpl.g) {
            DeliveryPreselectPoint preferredLocation = deliveryPointsRectResult.getPreferredLocation();
            if (preferredLocation != null && (convert = DeliveryRdsStartOrderingViewModelKt.convert(preferredLocation)) != null) {
                DeliveryPreselectPoint preferredLocation2 = deliveryPointsRectResult.getPreferredLocation();
                if (Intrinsics.areEqual(preferredLocation2 != null ? preferredLocation2.getMoveCamera() : null, Boolean.TRUE)) {
                    deliveryRdsStartOrderingViewModelImpl.i = convert;
                    deliveryRdsStartOrderingViewModelImpl.getPreselectPinEvent().postValue(new PreselectPinEvent.MoveCamera(convert.getLatLng()));
                    return;
                }
                deliveryRdsStartOrderingViewModelImpl.getPreselectPinEvent().postValue(new PreselectPinEvent.ClickPin(convert));
                deliveryRdsStartOrderingViewModelImpl.i = null;
                deliveryRdsStartOrderingViewModelImpl.g = false;
                return;
            }
            return;
        }
        Marker.Pin pin = deliveryRdsStartOrderingViewModelImpl.i;
        if (pin != null) {
            deliveryRdsStartOrderingViewModelImpl.getPreselectPinEvent().postValue(new PreselectPinEvent.ClickPin(pin));
            deliveryRdsStartOrderingViewModelImpl.i = null;
        }
    }

    @Override // com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingViewModel
    public boolean isNeedOpenCheckout() {
        return this.h != null;
    }

    @Override // com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingViewModel
    public void onAuthCompleted() {
        ParametrizedClickStreamEvent clickStreamEvent;
        this.e = Boolean.TRUE;
        this.y.track(new DeliveryOrderRequestEvent(this.s, this.t, this.u, this.v, this.w));
        ParametrizedEvent parametrizedEvent = this.A;
        if (parametrizedEvent != null && (clickStreamEvent = ParametrizedEventsKt.toClickStreamEvent(parametrizedEvent)) != null) {
            this.y.track(clickStreamEvent);
        }
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        Disposable disposable = this.d;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    @Override // com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingViewModel
    public void onNewCameraCoordinates(@NotNull CameraCoordinatesEvent cameraCoordinatesEvent) {
        Intrinsics.checkNotNullParameter(cameraCoordinatesEvent, "event");
        AvitoMapPoint topLeft = cameraCoordinatesEvent.getTopLeft();
        AvitoMapPoint bottomRight = cameraCoordinatesEvent.getBottomRight();
        Float clusterRadius = cameraCoordinatesEvent.getClusterRadius();
        boolean z2 = this.g;
        AvitoMapPoint avitoMapPoint = z2 ? this.f : null;
        Boolean bool = this.e;
        if (bool != null && bool.booleanValue()) {
            this.z.startLoading();
            Disposable disposable = this.d;
            if (disposable != null) {
                disposable.dispose();
            }
            this.d = this.p.getDeliveryPoints(this.r, topLeft, bottomRight, clusterRadius, avitoMapPoint, z2).observeOn(this.q.computation()).subscribe(new s(this), new t(this));
        }
    }

    @Override // com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingViewModel
    public void onNewLocation(@Nullable AvitoMapPoint avitoMapPoint) {
        this.f = avitoMapPoint;
    }

    @Override // com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingViewModel
    public void setDataFromCheckout(@Nullable SummaryState summaryState) {
        String markerId;
        this.h = summaryState;
        if (summaryState != null && (markerId = summaryState.getMarkerId()) != null) {
            getSelectCheckoutPinEvent().postValue(markerId);
        }
    }

    @Override // com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingViewModel
    @Nullable
    public SummaryState summaryState() {
        return this.h;
    }

    @Override // com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingViewModel
    @NotNull
    public SingleLiveEvent<Unit> getAuthScreenChanges() {
        return this.m;
    }

    @Override // com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingViewModel
    @NotNull
    public SingleLiveEvent<List<Marker>> getNewMarkersEvents() {
        return this.j;
    }

    @Override // com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingViewModel
    @NotNull
    public SingleLiveEvent<Overlay> getOverlayEvent() {
        return this.k;
    }

    @Override // com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingViewModel
    @NotNull
    public SingleLiveEvent<PreselectPinEvent> getPreselectPinEvent() {
        return this.n;
    }

    @Override // com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingViewModel
    @NotNull
    public SingleLiveEvent<String> getSelectCheckoutPinEvent() {
        return this.o;
    }

    @Override // com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingViewModel
    @NotNull
    public SingleLiveEvent<String> getSnackBarEvents() {
        return this.l;
    }
}

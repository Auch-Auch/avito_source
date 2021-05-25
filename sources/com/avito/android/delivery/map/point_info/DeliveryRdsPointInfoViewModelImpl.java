package com.avito.android.delivery.map.point_info;

import a2.g.r.g;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.analytics.Analytics;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.delivery.analytics.map.PinSelectedEvent;
import com.avito.android.delivery.map.common.marker.Marker;
import com.avito.android.delivery.map.point_info.DeliveryRdsPointInfoView;
import com.avito.android.delivery.map.point_info.konveyor.service.multiple.MultiServiceItem;
import com.avito.android.delivery.map.point_info.konveyor.service.single.ServiceItem;
import com.avito.android.delivery.map.point_info.konveyor.title.TitleItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.delivery.DeliveryLabel;
import com.avito.android.remote.model.delivery.DeliveryMultiPointDetailInfo;
import com.avito.android.remote.model.delivery.Overlay;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.ViewCompatIdGenerator;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.conveyor_item.Item;
import com.jakewharton.rxrelay3.PublishRelay;
import com.jakewharton.rxrelay3.Relay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002BM\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010=\u001a\u00020:\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0018\u0012\b\u00100\u001a\u0004\u0018\u00010\u0018\u0012\u0006\u0010Y\u001a\u00020V\u0012\b\u0010Q\u001a\u0004\u0018\u00010\u0018\u0012\u0006\u00108\u001a\u000205\u0012\u0006\u00104\u001a\u000201¢\u0006\u0004\b`\u0010aJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t*\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\u0012J\u0011\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0011\u0010\u001b\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001b\u0010\u001aJ\u0011\u0010\u001c\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001c\u0010\u001aJ\u000f\u0010\u001d\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001d\u0010\u0012J\u000f\u0010\u001e\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u001e\u0010\u0012R\u0018\u0010!\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010+\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020,8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010-R\u0018\u00100\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u0010*R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b9\u0010*R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010B\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\"\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00180C8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\"\u0010O\u001a\b\u0012\u0004\u0012\u00020J0I8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010NR\u0018\u0010Q\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bP\u0010*R\u001c\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00180R8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010Y\u001a\u00020V8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\"\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00180Z8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^¨\u0006b"}, d2 = {"Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoViewModelImpl;", "Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoViewModel;", "Lcom/avito/android/delivery/map/common/marker/Marker$Pin;", "pin", "", "c", "(Lcom/avito/android/delivery/map/common/marker/Marker$Pin;)V", "Lcom/avito/android/remote/model/delivery/DeliveryMultiPointDetailInfo;", "", "Lcom/avito/conveyor_item/Item;", "d", "(Lcom/avito/android/remote/model/delivery/DeliveryMultiPointDetailInfo;)Ljava/util/List;", "Lcom/avito/android/delivery/map/common/marker/Marker;", "marker", "onMarkerClicked", "(Lcom/avito/android/delivery/map/common/marker/Marker;)V", "onSelectedMarkerDisappeared", "()V", "Lcom/avito/android/remote/model/delivery/Overlay;", "overlay", "onNewOverlay", "(Lcom/avito/android/remote/model/delivery/Overlay;)V", "retry", "", "selectedService", "()Ljava/lang/String;", "fiasGuid", "markerId", "hide", "onCleared", "Lio/reactivex/rxjava3/disposables/Disposable;", "Lio/reactivex/rxjava3/disposables/Disposable;", "getShortPointInfoDisposable", g.a, "Lcom/avito/android/remote/model/delivery/DeliveryMultiPointDetailInfo;", "pointDetailInfo", "Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoInteractor;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoInteractor;", "interactor", "o", "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "subscriptions", "p", "analyticsAdvertId", "Lcom/avito/android/analytics/Analytics;", "t", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoResourceProvider;", "s", "Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoResourceProvider;", "resourceProvider", "f", "Lcom/avito/android/util/SchedulersFactory3;", "n", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "h", "Lcom/avito/android/remote/model/delivery/Overlay;", "e", "Lcom/avito/android/delivery/map/common/marker/Marker$Pin;", "clickedPin", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "j", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getSnackBarEvents", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "snackBarEvents", "Landroidx/lifecycle/MutableLiveData;", "Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoView$State;", "k", "Landroidx/lifecycle/MutableLiveData;", "getPointInfoStateChanges", "()Landroidx/lifecycle/MutableLiveData;", "pointInfoStateChanges", "r", "cartItems", "Lcom/jakewharton/rxrelay3/Relay;", "i", "Lcom/jakewharton/rxrelay3/Relay;", "serviceSelectRelay", "", VKApiConst.Q, "Z", "isCart", "Lio/reactivex/rxjava3/functions/Consumer;", "l", "Lio/reactivex/rxjava3/functions/Consumer;", "getServiceSelectConsumer", "()Lio/reactivex/rxjava3/functions/Consumer;", "serviceSelectConsumer", "<init>", "(Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoInteractor;Lcom/avito/android/util/SchedulersFactory3;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoResourceProvider;Lcom/avito/android/analytics/Analytics;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryRdsPointInfoViewModelImpl extends ViewModel implements DeliveryRdsPointInfoViewModel {
    public Disposable c;
    public CompositeDisposable d = new CompositeDisposable();
    public Marker.Pin e;
    public String f;
    public DeliveryMultiPointDetailInfo g;
    public Overlay h;
    public final Relay<String> i;
    @NotNull
    public final SingleLiveEvent<String> j;
    @NotNull
    public final MutableLiveData<DeliveryRdsPointInfoView.State> k;
    @NotNull
    public final Consumer<String> l;
    public final DeliveryRdsPointInfoInteractor m;
    public final SchedulersFactory3 n;
    public final String o;
    public final String p;
    public final boolean q;
    public final String r;
    public final DeliveryRdsPointInfoResourceProvider s;
    public final Analytics t;

    public static final class a<T> implements Consumer<String> {
        public final /* synthetic */ DeliveryRdsPointInfoViewModelImpl a;

        public a(DeliveryRdsPointInfoViewModelImpl deliveryRdsPointInfoViewModelImpl) {
            this.a = deliveryRdsPointInfoViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(String str) {
            this.a.f = str;
            DeliveryMultiPointDetailInfo deliveryMultiPointDetailInfo = this.a.g;
            if (deliveryMultiPointDetailInfo != null) {
                this.a.getPointInfoStateChanges().setValue(new DeliveryRdsPointInfoView.State.Expanded(Boolean.FALSE, this.a.d(deliveryMultiPointDetailInfo), null, null, null, 28, null));
            }
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
        }
    }

    public static final class c<T> implements Consumer<LoadingState<? super DeliveryMultiPointDetailInfo>> {
        public final /* synthetic */ DeliveryRdsPointInfoViewModelImpl a;

        public c(DeliveryRdsPointInfoViewModelImpl deliveryRdsPointInfoViewModelImpl) {
            this.a = deliveryRdsPointInfoViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(LoadingState<? super DeliveryMultiPointDetailInfo> loadingState) {
            LoadingState<? super DeliveryMultiPointDetailInfo> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loading) {
                DeliveryRdsPointInfoViewModelImpl.access$showLoadingPointInfo(this.a);
            } else if (loadingState2 instanceof LoadingState.Loaded) {
                DeliveryRdsPointInfoViewModelImpl.access$showMultiPointInfo(this.a, (DeliveryMultiPointDetailInfo) ((LoadingState.Loaded) loadingState2).getData());
            } else if (loadingState2 instanceof LoadingState.Error) {
                DeliveryRdsPointInfoViewModelImpl.access$showPointInfoError(this.a, ((LoadingState.Error) loadingState2).getError());
            }
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public final /* synthetic */ DeliveryRdsPointInfoViewModelImpl a;

        public d(DeliveryRdsPointInfoViewModelImpl deliveryRdsPointInfoViewModelImpl) {
            this.a = deliveryRdsPointInfoViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
            this.a.getSnackBarEvents().setValue(this.a.s.getUnknownError());
        }
    }

    public DeliveryRdsPointInfoViewModelImpl(@NotNull DeliveryRdsPointInfoInteractor deliveryRdsPointInfoInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @Nullable String str, @Nullable String str2, boolean z, @Nullable String str3, @NotNull DeliveryRdsPointInfoResourceProvider deliveryRdsPointInfoResourceProvider, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(deliveryRdsPointInfoInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(deliveryRdsPointInfoResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.m = deliveryRdsPointInfoInteractor;
        this.n = schedulersFactory3;
        this.o = str;
        this.p = str2;
        this.q = z;
        this.r = str3;
        this.s = deliveryRdsPointInfoResourceProvider;
        this.t = analytics;
        PublishRelay create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.i = create;
        this.j = new SingleLiveEvent<>();
        this.k = new MutableLiveData<>();
        this.l = create;
        Disposable subscribe = create.subscribe(new a(this), b.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "serviceSelectRelay.subsc…ogs.error(it) }\n        )");
        DisposableKt.addTo(subscribe, this.d);
        hide();
    }

    public static final void access$showLoadingPointInfo(DeliveryRdsPointInfoViewModelImpl deliveryRdsPointInfoViewModelImpl) {
        MutableLiveData<DeliveryRdsPointInfoView.State> pointInfoStateChanges = deliveryRdsPointInfoViewModelImpl.getPointInfoStateChanges();
        Boolean bool = Boolean.TRUE;
        pointInfoStateChanges.setValue(new DeliveryRdsPointInfoView.State.Expanded(bool, null, null, bool, null, 22, null));
    }

    public static final void access$showMultiPointInfo(DeliveryRdsPointInfoViewModelImpl deliveryRdsPointInfoViewModelImpl, DeliveryMultiPointDetailInfo deliveryMultiPointDetailInfo) {
        Objects.requireNonNull(deliveryRdsPointInfoViewModelImpl);
        List<DeliveryMultiPointDetailInfo.Service> services = deliveryMultiPointDetailInfo.getServices();
        if (services == null || services.isEmpty()) {
            deliveryRdsPointInfoViewModelImpl.getPointInfoStateChanges().setValue(new DeliveryRdsPointInfoView.State.Expanded(Boolean.FALSE, null, deliveryRdsPointInfoViewModelImpl.s.getUnknownError(), null, Boolean.TRUE, 10, null));
            return;
        }
        deliveryRdsPointInfoViewModelImpl.f = ((DeliveryMultiPointDetailInfo.Service) CollectionsKt___CollectionsKt.first((List<? extends Object>) deliveryMultiPointDetailInfo.getServices())).getId();
        deliveryRdsPointInfoViewModelImpl.getPointInfoStateChanges().setValue(new DeliveryRdsPointInfoView.State.Expanded(Boolean.FALSE, deliveryRdsPointInfoViewModelImpl.d(deliveryMultiPointDetailInfo), null, null, Boolean.TRUE, 12, null));
        deliveryRdsPointInfoViewModelImpl.g = deliveryMultiPointDetailInfo;
    }

    public static final void access$showPointInfoError(DeliveryRdsPointInfoViewModelImpl deliveryRdsPointInfoViewModelImpl, TypedError typedError) {
        deliveryRdsPointInfoViewModelImpl.getPointInfoStateChanges().setValue(new DeliveryRdsPointInfoView.State.Expanded(Boolean.FALSE, null, typedError instanceof ErrorWithMessage ? ((ErrorWithMessage) typedError).getMessage() : deliveryRdsPointInfoViewModelImpl.s.getUnknownError(), null, null, 26, null));
    }

    public final void c(Marker.Pin pin) {
        Disposable disposable = this.c;
        if (disposable != null) {
            disposable.dispose();
        }
        this.c = this.m.getDeliveryPointShortInfo(pin.getFiasGuid(), this.o, pin.getServiceIds()).observeOn(this.n.mainThread()).subscribe(new c(this), new d(this));
        this.t.track(new PinSelectedEvent(this.p, this.q, this.r));
    }

    public final List<Item> d(DeliveryMultiPointDetailInfo deliveryMultiPointDetailInfo) {
        ArrayList arrayList;
        List listOf = t6.n.d.listOf(new TitleItem(String.valueOf(ViewCompatIdGenerator.INSTANCE.generate()), deliveryMultiPointDetailInfo.getTitle()));
        List<DeliveryMultiPointDetailInfo.Service> services = deliveryMultiPointDetailInfo.getServices();
        if (services.size() == 1) {
            arrayList = new ArrayList(e.collectionSizeOrDefault(services, 10));
            for (T t2 : services) {
                String id = t2.getId();
                AttributedText title = t2.getTitle();
                DeliveryLabel label = t2.getLabel();
                arrayList.add(new ServiceItem(id, title, label != null ? label.getText() : null, t2.getSubtitles()));
            }
        } else {
            arrayList = new ArrayList(e.collectionSizeOrDefault(services, 10));
            for (T t3 : services) {
                boolean areEqual = Intrinsics.areEqual(t3.getId(), this.f);
                String id2 = t3.getId();
                AttributedText title2 = t3.getTitle();
                DeliveryLabel label2 = t3.getLabel();
                arrayList.add(new MultiServiceItem(id2, title2, label2 != null ? label2.getText() : null, t3.getSubtitles(), areEqual));
            }
        }
        return CollectionsKt___CollectionsKt.plus((Collection) listOf, (Iterable) arrayList);
    }

    @Override // com.avito.android.delivery.map.point_info.DeliveryRdsPointInfoViewModel
    @Nullable
    public String fiasGuid() {
        Marker.Pin pin = this.e;
        if (pin != null) {
            return pin.getFiasGuid();
        }
        return null;
    }

    @Override // com.avito.android.delivery.map.point_info.DeliveryRdsPointInfoViewModel
    @NotNull
    public Consumer<String> getServiceSelectConsumer() {
        return this.l;
    }

    @Override // com.avito.android.delivery.map.point_info.DeliveryRdsPointInfoViewModel
    public void hide() {
        getPointInfoStateChanges().setValue(new DeliveryRdsPointInfoView.State.Hidden(this.h));
    }

    @Override // com.avito.android.delivery.map.point_info.DeliveryRdsPointInfoViewModel
    @Nullable
    public String markerId() {
        Marker.Pin pin = this.e;
        if (pin != null) {
            return pin.getId();
        }
        return null;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Disposable disposable = this.c;
        if (disposable != null) {
            disposable.dispose();
        }
        this.d.clear();
    }

    @Override // com.avito.android.delivery.map.point_info.DeliveryRdsPointInfoViewModel
    public void onMarkerClicked(@NotNull Marker marker) {
        Intrinsics.checkNotNullParameter(marker, "marker");
        if (marker instanceof Marker.Pin) {
            Marker.Pin pin = (Marker.Pin) marker;
            this.e = pin;
            c(pin);
        }
    }

    @Override // com.avito.android.delivery.map.point_info.DeliveryRdsPointInfoViewModel
    public void onNewOverlay(@Nullable Overlay overlay) {
        this.h = overlay;
        if (getPointInfoStateChanges().getValue() instanceof DeliveryRdsPointInfoView.State.Hidden) {
            hide();
        }
    }

    @Override // com.avito.android.delivery.map.point_info.DeliveryRdsPointInfoViewModel
    public void onSelectedMarkerDisappeared() {
        hide();
    }

    @Override // com.avito.android.delivery.map.point_info.DeliveryRdsPointInfoViewModel
    public void retry() {
        Marker.Pin pin = this.e;
        if (pin != null) {
            c(pin);
        }
    }

    @Override // com.avito.android.delivery.map.point_info.DeliveryRdsPointInfoViewModel
    @Nullable
    public String selectedService() {
        return this.f;
    }

    @Override // com.avito.android.delivery.map.point_info.DeliveryRdsPointInfoViewModel
    @NotNull
    public MutableLiveData<DeliveryRdsPointInfoView.State> getPointInfoStateChanges() {
        return this.k;
    }

    @Override // com.avito.android.delivery.map.point_info.DeliveryRdsPointInfoViewModel
    @NotNull
    public SingleLiveEvent<String> getSnackBarEvents() {
        return this.j;
    }
}

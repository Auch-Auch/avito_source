package com.avito.android.item_map.amenity;

import a2.g.r.g;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.avito_map.AvitoMapMarker;
import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.avito_map.amenity.AmenityMarkerIconFactory;
import com.avito.android.item_map.remote.model.AmenityButton;
import com.avito.android.item_map.remote.model.AmenityPin;
import com.avito.android.item_map.remote.model.AmenityResponse;
import com.avito.android.item_map.view.ItemMapView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Color;
import com.avito.android.ui_components.R;
import com.avito.android.util.Kundle;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B3\b\u0007\u0012\u0006\u00109\u001a\u000206\u0012\u0006\u0010?\u001a\u00020<\u0012\u0006\u0010\u001f\u001a\u000200\u0012\b\u0010@\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010)\u001a\u00020&¢\u0006\u0004\bA\u0010BJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0019\u0010\u000fJ%\u0010\u001d\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010 \u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u0010H\u0002¢\u0006\u0004\b \u0010!R\"\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020#0\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010+\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010\u001f\u001a\u0002008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u00102R*\u00105\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\f\u0012\n\u0012\u0004\u0012\u000203\u0018\u00010\u001a0\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u0010$R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010;\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>¨\u0006C"}, d2 = {"Lcom/avito/android/item_map/amenity/AmenityButtonsPresenterImpl;", "Lcom/avito/android/item_map/amenity/AmenityButtonsPresenter;", "Lcom/avito/android/item_map/view/ItemMapView;", "view", "", "attachMapView", "(Lcom/avito/android/item_map/view/ItemMapView;)V", "Lcom/avito/android/item_map/amenity/AmenityButtonsViewBinder;", "attachButtonsView", "(Lcom/avito/android/item_map/amenity/AmenityButtonsViewBinder;)V", "detachViews", "()V", "", "type", "onAmenityButtonClick", "(Ljava/lang/String;)V", "Lcom/avito/android/item_map/amenity/ButtonViewState;", "getAmenityButtonViewState", "(Ljava/lang/String;)Lcom/avito/android/item_map/amenity/ButtonViewState;", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "kundle", "onRestoreState", "(Lcom/avito/android/util/Kundle;)V", "c", "", "Lcom/avito/android/item_map/remote/model/AmenityPin;", "pins", AuthSource.SEND_ABUSE, "(Ljava/lang/String;Ljava/util/List;)V", "state", AuthSource.BOOKING_ORDER, "(Ljava/lang/String;Lcom/avito/android/item_map/amenity/ButtonViewState;)V", "", "Lcom/avito/android/item_map/amenity/AmenityButtonState;", "Ljava/util/Map;", "buttonsState", "Lcom/avito/android/util/SchedulersFactory3;", "i", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "Lcom/avito/android/item_map/view/ItemMapView;", "mapView", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "d", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposable", "Lcom/avito/android/item_map/view/ItemMapView$ItemMapState;", "h", "Lcom/avito/android/item_map/view/ItemMapView$ItemMapState;", "Lcom/avito/android/avito_map/AvitoMapMarker;", "e", ScreenPublicConstsKt.CONTENT_TYPE_MARKERS, "Lcom/avito/android/item_map/amenity/AmenityButtonsInteractor;", "f", "Lcom/avito/android/item_map/amenity/AmenityButtonsInteractor;", "interactor", "Lcom/avito/android/item_map/amenity/AmenityButtonsViewBinder;", "buttonsView", "Lcom/avito/android/avito_map/amenity/AmenityMarkerIconFactory;", g.a, "Lcom/avito/android/avito_map/amenity/AmenityMarkerIconFactory;", "iconFactory", "amenityState", "<init>", "(Lcom/avito/android/item_map/amenity/AmenityButtonsInteractor;Lcom/avito/android/avito_map/amenity/AmenityMarkerIconFactory;Lcom/avito/android/item_map/view/ItemMapView$ItemMapState;Lcom/avito/android/util/Kundle;Lcom/avito/android/util/SchedulersFactory3;)V", "item-map_release"}, k = 1, mv = {1, 4, 2})
public final class AmenityButtonsPresenterImpl implements AmenityButtonsPresenter {
    public AmenityButtonsViewBinder a;
    public ItemMapView b;
    public final Map<String, AmenityButtonState> c = new LinkedHashMap();
    public final CompositeDisposable d = new CompositeDisposable();
    public final Map<String, List<AvitoMapMarker>> e = new LinkedHashMap();
    public final AmenityButtonsInteractor f;
    public final AmenityMarkerIconFactory g;
    public ItemMapView.ItemMapState h;
    public final SchedulersFactory3 i;

    public static final class a<T> implements Consumer<LoadingState<? super AmenityResponse>> {
        public final /* synthetic */ AmenityButtonsPresenterImpl a;
        public final /* synthetic */ String b;

        public a(AmenityButtonsPresenterImpl amenityButtonsPresenterImpl, String str) {
            this.a = amenityButtonsPresenterImpl;
            this.b = str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(LoadingState<? super AmenityResponse> loadingState) {
            LoadingState<? super AmenityResponse> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loaded) {
                List<AmenityPin> pins = ((AmenityResponse) ((LoadingState.Loaded) loadingState2).getData()).getPins();
                AmenityButtonsPresenterImpl.access$showLoading(this.a, this.b, false);
                AmenityButtonsPresenterImpl.access$setLoaded(this.a, this.b);
                if (!pins.isEmpty()) {
                    AmenityButtonsPresenterImpl.access$setCachedPins(this.a, this.b, pins);
                    this.a.a(this.b, pins);
                    this.a.b(this.b, ButtonViewState.PRESSED);
                    return;
                }
                this.a.b(this.b, ButtonViewState.DISABLED);
            } else if (loadingState2 instanceof LoadingState.Loading) {
                AmenityButtonsPresenterImpl.access$showLoading(this.a, this.b, true);
            } else if (loadingState2 instanceof LoadingState.Error) {
                AmenityButtonsPresenterImpl.access$showLoading(this.a, this.b, false);
                ItemMapView itemMapView = this.a.b;
                if (itemMapView != null) {
                    ItemMapView.DefaultImpls.showError$default(itemMapView, R.string.connection_problem, 0, 2, null);
                }
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

    @Inject
    public AmenityButtonsPresenterImpl(@NotNull AmenityButtonsInteractor amenityButtonsInteractor, @NotNull AmenityMarkerIconFactory amenityMarkerIconFactory, @NotNull ItemMapView.ItemMapState itemMapState, @Nullable Kundle kundle, @NotNull SchedulersFactory3 schedulersFactory3) {
        List<AmenityButton> amenityButtons;
        Intrinsics.checkNotNullParameter(amenityButtonsInteractor, "interactor");
        Intrinsics.checkNotNullParameter(amenityMarkerIconFactory, "iconFactory");
        Intrinsics.checkNotNullParameter(itemMapState, "state");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        this.f = amenityButtonsInteractor;
        this.g = amenityMarkerIconFactory;
        this.h = itemMapState;
        this.i = schedulersFactory3;
        if (kundle != null) {
            onRestoreState(kundle);
            return;
        }
        ItemMapView.AmenityButtonsState amenityButtonsState = this.h.getAmenityButtonsState();
        if (!(amenityButtonsState == null || (amenityButtons = amenityButtonsState.getAmenityButtons()) == null)) {
            for (T t : amenityButtons) {
                this.c.put(String.valueOf(t.getType()), new AmenityButtonState(t.getShow(), null, false, false, null, 30, null));
            }
        }
    }

    public static final void access$setCachedPins(AmenityButtonsPresenterImpl amenityButtonsPresenterImpl, String str, List list) {
        List<AmenityPin> cachedPins;
        AmenityButtonState amenityButtonState = amenityButtonsPresenterImpl.c.get(str);
        if (amenityButtonState != null && (cachedPins = amenityButtonState.getCachedPins()) != null) {
            cachedPins.addAll(list);
        }
    }

    public static final void access$setLoaded(AmenityButtonsPresenterImpl amenityButtonsPresenterImpl, String str) {
        AmenityButtonState amenityButtonState = amenityButtonsPresenterImpl.c.get(str);
        if (amenityButtonState != null) {
            amenityButtonState.setLoaded(true);
        }
    }

    public static final void access$showLoading(AmenityButtonsPresenterImpl amenityButtonsPresenterImpl, String str, boolean z) {
        AmenityButtonsViewBinder amenityButtonsViewBinder = amenityButtonsPresenterImpl.a;
        if (amenityButtonsViewBinder != null) {
            amenityButtonsViewBinder.showLoading(str, z);
        }
        AmenityButtonState amenityButtonState = amenityButtonsPresenterImpl.c.get(str);
        if (amenityButtonState != null) {
            amenityButtonState.setLoading(z);
        }
    }

    public final void a(String str, List<AmenityPin> list) {
        List<AmenityButton> amenityButtons;
        T t;
        if (!list.isEmpty()) {
            Color color = null;
            this.e.put(str, null);
            ItemMapView itemMapView = this.b;
            if (itemMapView != null) {
                Map<String, List<AvitoMapMarker>> map = this.e;
                ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(AmenityButtonsPresenterKt.toAvitoMapPoint(it.next()));
                }
                AmenityMarkerIconFactory amenityMarkerIconFactory = this.g;
                ItemMapView.AmenityButtonsState amenityButtonsState = this.h.getAmenityButtonsState();
                if (!(amenityButtonsState == null || (amenityButtons = amenityButtonsState.getAmenityButtons()) == null)) {
                    Iterator<T> it2 = amenityButtons.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            t = null;
                            break;
                        }
                        t = it2.next();
                        if (Intrinsics.areEqual(t.getType(), str)) {
                            break;
                        }
                    }
                    T t2 = t;
                    if (t2 != null) {
                        color = t2.getBgPressedColor();
                    }
                }
                map.put(str, itemMapView.addAmenityMarkers(arrayList, amenityMarkerIconFactory.bitmap(str, color != null ? color.getValue() : itemMapView.getWhiteColor())));
            }
        }
    }

    @Override // com.avito.android.item_map.amenity.AmenityButtonsPresenter
    public void attachButtonsView(@Nullable AmenityButtonsViewBinder amenityButtonsViewBinder) {
        this.a = amenityButtonsViewBinder;
        for (Map.Entry<String, AmenityButtonState> entry : this.c.entrySet()) {
            String key = entry.getKey();
            AmenityButtonState value = entry.getValue();
            if (value.isStartOnStart() && (!value.isLoaded()) && value.getCachedPins().isEmpty()) {
                c(key);
            } else if (value.getViewState() == ButtonViewState.PRESSED) {
                a(key, value.getCachedPins());
            }
        }
    }

    @Override // com.avito.android.item_map.amenity.AmenityButtonsPresenter
    public void attachMapView(@Nullable ItemMapView itemMapView) {
        this.b = itemMapView;
    }

    public final void b(String str, ButtonViewState buttonViewState) {
        AmenityButtonState amenityButtonState = this.c.get(str);
        if (amenityButtonState != null) {
            amenityButtonState.setViewState(buttonViewState);
        }
        AmenityButtonsViewBinder amenityButtonsViewBinder = this.a;
        if (amenityButtonsViewBinder != null) {
            amenityButtonsViewBinder.setButtonColors(str, buttonViewState);
        }
    }

    public final void c(String str) {
        ItemMapView.AmenityButtonsState amenityButtonsState;
        String itemId;
        AvitoMapPoint itemCoordinates = this.h.getItemCoordinates();
        if (itemCoordinates != null && (amenityButtonsState = this.h.getAmenityButtonsState()) != null && (itemId = amenityButtonsState.getItemId()) != null) {
            CompositeDisposable compositeDisposable = this.d;
            Disposable subscribe = this.f.getAmenityPins(itemId, str, itemCoordinates).observeOn(this.i.mainThread()).subscribe(new a(this, str), b.a);
            Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.getAmenityPin….error(it)\n            })");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }

    @Override // com.avito.android.item_map.amenity.AmenityButtonsPresenter
    public void detachViews() {
        this.d.clear();
        this.b = null;
        this.a = null;
    }

    @Override // com.avito.android.item_map.amenity.AmenityButtonsPresenter
    @NotNull
    public ButtonViewState getAmenityButtonViewState(@NotNull String str) {
        ButtonViewState viewState;
        Intrinsics.checkNotNullParameter(str, "type");
        AmenityButtonState amenityButtonState = this.c.get(str);
        return (amenityButtonState == null || (viewState = amenityButtonState.getViewState()) == null) ? ButtonViewState.UNPRESSED : viewState;
    }

    @Override // com.avito.android.item_map.amenity.AmenityButtonsPresenter
    public void onAmenityButtonClick(@NotNull String str) {
        ItemMapView itemMapView;
        List<AmenityPin> cachedPins;
        Intrinsics.checkNotNullParameter(str, "type");
        if (this.a != null && this.b != null) {
            AmenityButtonState amenityButtonState = this.c.get(str);
            boolean z = false;
            if (!(amenityButtonState != null && amenityButtonState.isLoading())) {
                if (getAmenityButtonViewState(str) == ButtonViewState.DISABLED) {
                    ItemMapView itemMapView2 = this.b;
                    if (itemMapView2 != null) {
                        itemMapView2.showSnackBarWarning(com.avito.android.item_map.R.string.amenity_no_information);
                        return;
                    }
                    return;
                }
                AmenityButtonState amenityButtonState2 = this.c.get(str);
                if ((amenityButtonState2 == null || (cachedPins = amenityButtonState2.getCachedPins()) == null || !cachedPins.isEmpty()) ? false : true) {
                    c(str);
                    return;
                }
                ButtonViewState amenityButtonViewState = getAmenityButtonViewState(str);
                ButtonViewState buttonViewState = ButtonViewState.PRESSED;
                if (amenityButtonViewState == buttonViewState) {
                    Map<String, List<AvitoMapMarker>> map = this.e;
                    if (map == null || map.isEmpty()) {
                        z = true;
                    }
                    if (!z && (itemMapView = this.b) != null) {
                        List<AvitoMapMarker> list = this.e.get(str);
                        if (list == null) {
                            list = CollectionsKt__CollectionsKt.emptyList();
                        }
                        itemMapView.removeAmenityMarkers(list);
                    }
                    b(str, ButtonViewState.UNPRESSED);
                    return;
                }
                if (getAmenityButtonViewState(str) == ButtonViewState.UNPRESSED) {
                    z = true;
                }
                if (z) {
                    AmenityButtonState amenityButtonState3 = this.c.get(str);
                    List<AmenityPin> cachedPins2 = amenityButtonState3 != null ? amenityButtonState3.getCachedPins() : null;
                    if (cachedPins2 == null) {
                        cachedPins2 = CollectionsKt__CollectionsKt.emptyList();
                    }
                    a(str, cachedPins2);
                    b(str, buttonViewState);
                }
            }
        }
    }

    @Override // com.avito.android.item_map.amenity.AmenityButtonsPresenter
    public void onRestoreState(@Nullable Kundle kundle) {
        Map<? extends String, ? extends AmenityButtonState> parcelableMap;
        if (kundle != null && (parcelableMap = kundle.getParcelableMap("buttonsState")) != null) {
            this.c.clear();
            this.c.putAll(parcelableMap);
        }
    }

    @Override // com.avito.android.item_map.amenity.AmenityButtonsPresenter
    @NotNull
    public Kundle onSaveState() {
        return new Kundle().putParcelableMap("buttonsState", this.c);
    }
}

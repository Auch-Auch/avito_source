package com.avito.android.item_map.view;

import android.app.Activity;
import android.location.Location;
import android.view.View;
import com.avito.android.advert_core.analytics.map.MapMovedEvent;
import com.avito.android.analytics.Analytics;
import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.avito_map.AvitoMapTarget;
import com.avito.android.item_map.view.ItemMapPresenter;
import com.avito.android.item_map.view.ItemMapView;
import com.avito.android.location.analytics.FindLocationPage;
import com.avito.android.location.analytics.LocationAnalyticsInteractor;
import com.avito.android.location.find.FindLocationPresenter;
import com.avito.android.permissions.LocationPermissionDialogPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.bottom_sheet.BottomSheet;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BA\b\u0007\u0012\u0006\u0010C\u001a\u00020\u0002\u0012\u0006\u0010,\u001a\u00020)\u0012\u0006\u0010G\u001a\u00020D\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010@\u001a\u00020=\u0012\u0006\u00106\u001a\u000203\u0012\u0006\u0010<\u001a\u000209¢\u0006\u0004\bH\u0010IJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u000bJ\u001f\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0017\u0010\u000bJ\u000f\u0010\u0018\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0018\u0010\u000bJ\u000f\u0010\u0019\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0019\u0010\u000bJ\u000f\u0010\u001a\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001a\u0010\u000bJ\u000f\u0010\u001b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001b\u0010\u000bJ\u0017\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0007H\u0016¢\u0006\u0004\b \u0010\u000bJ\u0019\u0010#\u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010C\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bE\u0010F¨\u0006J"}, d2 = {"Lcom/avito/android/item_map/view/ItemMapPresenterImpl;", "Lcom/avito/android/item_map/view/ItemMapPresenter;", "Lcom/avito/android/item_map/view/ItemMapView$ItemMapState;", "onSaveState", "()Lcom/avito/android/item_map/view/ItemMapView$ItemMapState;", "Lcom/avito/android/item_map/view/ItemMapView;", "view", "", "attachView", "(Lcom/avito/android/item_map/view/ItemMapView;)V", "detachView", "()V", "Lcom/avito/android/item_map/view/ItemMapPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/item_map/view/ItemMapPresenter$Router;)V", "detachRouter", "Lcom/avito/android/avito_map/AvitoMapPoint;", "point", "", "zoomToBounds", "addUserMarker", "(Lcom/avito/android/avito_map/AvitoMapPoint;Z)V", "onStartMap", "onStopMap", "onDestroyMap", "sendScreenExitAfterCoordinatesResolve", "subscribeOnNotPermissionGranted", "Landroid/app/Activity;", "activity", "subscribeFindLocation", "(Landroid/app/Activity;)V", "subscribeOnPermissionResult", "", "messageError", "findLocationError", "(Ljava/lang/String;)V", "Lcom/avito/android/analytics/Analytics;", a2.g.r.g.a, "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/item_map/view/ItemMapResourceProvider;", "e", "Lcom/avito/android/item_map/view/ItemMapResourceProvider;", "resourceProvider", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "c", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "viewDisposables", AuthSource.BOOKING_ORDER, "Lcom/avito/android/item_map/view/ItemMapPresenter$Router;", "Lcom/avito/android/location/find/FindLocationPresenter;", "i", "Lcom/avito/android/location/find/FindLocationPresenter;", "findLocationPresenter", AuthSource.SEND_ABUSE, "Lcom/avito/android/item_map/view/ItemMapView;", "Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;", "j", "Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;", "locationAnalytics", "Lcom/avito/android/permissions/LocationPermissionDialogPresenter;", "h", "Lcom/avito/android/permissions/LocationPermissionDialogPresenter;", "locationPermissionDialogPresenter", "d", "Lcom/avito/android/item_map/view/ItemMapView$ItemMapState;", "state", "Lcom/avito/android/util/SchedulersFactory3;", "f", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "<init>", "(Lcom/avito/android/item_map/view/ItemMapView$ItemMapState;Lcom/avito/android/item_map/view/ItemMapResourceProvider;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/permissions/LocationPermissionDialogPresenter;Lcom/avito/android/location/find/FindLocationPresenter;Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;)V", "item-map_release"}, k = 1, mv = {1, 4, 2})
public final class ItemMapPresenterImpl implements ItemMapPresenter {
    public ItemMapView a;
    public ItemMapPresenter.Router b;
    public final CompositeDisposable c = new CompositeDisposable();
    public ItemMapView.ItemMapState d;
    public ItemMapResourceProvider e;
    public SchedulersFactory3 f;
    public final Analytics g;
    public final LocationPermissionDialogPresenter h;
    public final FindLocationPresenter i;
    public LocationAnalyticsInteractor j;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<Throwable> {
        public static final a b = new a(0);
        public static final a c = new a(1);
        public static final a d = new a(2);
        public static final a e = new a(3);
        public static final a f = new a(4);
        public static final a g = new a(5);
        public static final a h = new a(6);
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Throwable th) {
            switch (this.a) {
                case 0:
                    Logs.error(th);
                    return;
                case 1:
                    Logs.error(th);
                    return;
                case 2:
                    Logs.error(th);
                    return;
                case 3:
                    Logs.error(th);
                    return;
                case 4:
                    Logs.error(th);
                    return;
                case 5:
                    Logs.error(th);
                    return;
                case 6:
                    Logs.error(th);
                    return;
                default:
                    throw null;
            }
        }
    }

    /* compiled from: java-style lambda group */
    public static final class b<T> implements Consumer<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public b(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Unit unit) {
            int i = this.a;
            if (i == 0) {
                ItemMapPresenter.Router router = ((ItemMapPresenterImpl) this.b).b;
                if (router != null) {
                    router.finishScreen();
                }
            } else if (i == 1) {
                LocationAnalyticsInteractor locationAnalyticsInteractor = ((ItemMapPresenterImpl) this.b).j;
                String fromPage = ((ItemMapPresenterImpl) this.b).d.getFromPage();
                if (fromPage == null) {
                    fromPage = FindLocationPage.BUYER_ITEM_MAP.getValue();
                }
                locationAnalyticsInteractor.trackFindCoordinates(fromPage);
                ((ItemMapPresenterImpl) this.b).subscribeOnPermissionResult();
            } else if (i == 2) {
                ItemMapPresenterImpl.access$showOsmPopUp((ItemMapPresenterImpl) this.b);
            } else if (i == 3) {
                ItemMapPresenter.Router router2 = ((ItemMapPresenterImpl) this.b).b;
                if (router2 != null) {
                    router2.openOsmUrl();
                }
            } else {
                throw null;
            }
        }
    }

    /* compiled from: java-style lambda group */
    public static final class c<T> implements Consumer<AvitoMapTarget> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public c(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(AvitoMapTarget avitoMapTarget) {
            int i = this.a;
            if (i == 0) {
                AvitoMapTarget avitoMapTarget2 = avitoMapTarget;
                ItemMapPresenterImpl itemMapPresenterImpl = (ItemMapPresenterImpl) this.b;
                ItemMapView.ItemMapState itemMapState = itemMapPresenterImpl.d;
                Intrinsics.checkNotNullExpressionValue(avitoMapTarget2, "it");
                ItemMapPresenterImpl.access$trackMapMovement(itemMapPresenterImpl, itemMapState, avitoMapTarget2);
                ItemMapPresenterImpl itemMapPresenterImpl2 = (ItemMapPresenterImpl) this.b;
                itemMapPresenterImpl2.d = ItemMapView.ItemMapState.copy$default(itemMapPresenterImpl2.d, null, false, null, null, null, avitoMapTarget2.getZoomLevel(), avitoMapTarget2.getPoint(), null, false, false, false, null, 3999, null);
            } else if (i == 1) {
                ((ItemMapView) this.b).moveToTarget(avitoMapTarget);
            } else {
                throw null;
            }
        }
    }

    public static final class d<T> implements Consumer<AvitoMapPoint> {
        public final /* synthetic */ ItemMapPresenterImpl a;

        public d(ItemMapPresenterImpl itemMapPresenterImpl) {
            this.a = itemMapPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(AvitoMapPoint avitoMapPoint) {
            AvitoMapPoint avitoMapPoint2 = avitoMapPoint;
            ItemMapPresenter.Router router = this.a.b;
            if (router != null) {
                Intrinsics.checkNotNullExpressionValue(avitoMapPoint2, "itemCoordinates");
                router.createRoute(avitoMapPoint2);
            }
        }
    }

    public static final class e<T> implements Consumer<BottomSheet.Visibility> {
        public final /* synthetic */ ItemMapPresenterImpl a;

        public e(ItemMapPresenterImpl itemMapPresenterImpl) {
            this.a = itemMapPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(BottomSheet.Visibility visibility) {
            ItemMapView.BottomSheetState bottomSheetState;
            BottomSheet.Visibility visibility2 = visibility;
            ItemMapPresenterImpl itemMapPresenterImpl = this.a;
            ItemMapView.ItemMapState itemMapState = itemMapPresenterImpl.d;
            ItemMapView.BottomSheetState bottomSheetState2 = this.a.d.getBottomSheetState();
            if (bottomSheetState2 != null) {
                ItemMapPresenterImpl itemMapPresenterImpl2 = this.a;
                Intrinsics.checkNotNullExpressionValue(visibility2, "it");
                bottomSheetState = ItemMapView.BottomSheetState.copy$default(bottomSheetState2, null, null, ItemMapPresenterImpl.access$convertVisibilityToState(itemMapPresenterImpl2, visibility2), 3, null);
            } else {
                bottomSheetState = null;
            }
            itemMapPresenterImpl.d = ItemMapView.ItemMapState.copy$default(itemMapState, null, false, null, null, bottomSheetState, 0.0f, null, null, false, false, false, null, 4079, null);
        }
    }

    public static final class f<T> implements Consumer<Throwable> {
        public final /* synthetic */ ItemMapPresenterImpl a;

        public f(ItemMapPresenterImpl itemMapPresenterImpl) {
            this.a = itemMapPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            this.a.findLocationError(th2.getMessage());
            Logs.error(th2);
        }
    }

    public static final class g<T> implements Consumer<Location> {
        public final /* synthetic */ ItemMapPresenterImpl a;

        public g(ItemMapPresenterImpl itemMapPresenterImpl) {
            this.a = itemMapPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Location location) {
            Location location2 = location;
            ItemMapPresenterImpl itemMapPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(location2, "itemLocation");
            itemMapPresenterImpl.addUserMarker(new AvitoMapPoint(location2.getLatitude(), location2.getLongitude()), true);
            LocationAnalyticsInteractor.DefaultImpls.trackResolveCoordinates$default(this.a.j, location2, null, 2, null);
        }
    }

    public static final class h<T> implements Consumer<Throwable> {
        public final /* synthetic */ ItemMapPresenterImpl a;

        public h(ItemMapPresenterImpl itemMapPresenterImpl) {
            this.a = itemMapPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            this.a.findLocationError(th2.getMessage());
            Logs.error(th2);
        }
    }

    @Inject
    public ItemMapPresenterImpl(@NotNull ItemMapView.ItemMapState itemMapState, @NotNull ItemMapResourceProvider itemMapResourceProvider, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull Analytics analytics, @NotNull LocationPermissionDialogPresenter locationPermissionDialogPresenter, @NotNull FindLocationPresenter findLocationPresenter, @NotNull LocationAnalyticsInteractor locationAnalyticsInteractor) {
        Intrinsics.checkNotNullParameter(itemMapState, "state");
        Intrinsics.checkNotNullParameter(itemMapResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(locationPermissionDialogPresenter, "locationPermissionDialogPresenter");
        Intrinsics.checkNotNullParameter(findLocationPresenter, "findLocationPresenter");
        Intrinsics.checkNotNullParameter(locationAnalyticsInteractor, "locationAnalytics");
        this.d = itemMapState;
        this.e = itemMapResourceProvider;
        this.f = schedulersFactory3;
        this.g = analytics;
        this.h = locationPermissionDialogPresenter;
        this.i = findLocationPresenter;
        this.j = locationAnalyticsInteractor;
    }

    public static final int access$convertVisibilityToState(ItemMapPresenterImpl itemMapPresenterImpl, BottomSheet.Visibility visibility) {
        Objects.requireNonNull(itemMapPresenterImpl);
        return Intrinsics.areEqual(visibility, BottomSheet.Visibility.Collapsed.INSTANCE) ? 4 : 3;
    }

    public static final void access$showOsmPopUp(ItemMapPresenterImpl itemMapPresenterImpl) {
        ItemMapView itemMapView = itemMapPresenterImpl.a;
        if (itemMapView != null) {
            itemMapView.showOsmPopUp();
        }
    }

    public static final void access$trackMapMovement(ItemMapPresenterImpl itemMapPresenterImpl, ItemMapView.ItemMapState itemMapState, AvitoMapTarget avitoMapTarget) {
        Objects.requireNonNull(itemMapPresenterImpl);
        if (itemMapState.getShouldTrackMapMovement()) {
            ItemMapView.AmenityButtonsState amenityButtonsState = itemMapState.getAmenityButtonsState();
            if ((amenityButtonsState != null ? amenityButtonsState.getItemId() : null) == null) {
                return;
            }
            if ((!Intrinsics.areEqual(itemMapState.getMapTargetPoint(), avitoMapTarget.getPoint())) || itemMapState.getMapZoomLevel() != avitoMapTarget.getZoomLevel()) {
                itemMapPresenterImpl.g.track(new MapMovedEvent(itemMapState.getAmenityButtonsState().getItemId()));
            }
        }
    }

    @Override // com.avito.android.item_map.view.ItemMapPresenter
    public void addUserMarker(@NotNull AvitoMapPoint avitoMapPoint, boolean z) {
        Intrinsics.checkNotNullParameter(avitoMapPoint, "point");
        ItemMapView itemMapView = this.a;
        if (itemMapView != null) {
            itemMapView.addUserMarker(avitoMapPoint, z, this.e.getPointsOffsetBounds());
        }
        this.d = ItemMapView.ItemMapState.copy$default(this.d, null, false, avitoMapPoint, null, null, 0.0f, null, null, false, false, false, null, 4091, null);
    }

    @Override // com.avito.android.item_map.view.ItemMapPresenter
    public void attachRouter(@NotNull ItemMapPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.b = router;
    }

    @Override // com.avito.android.item_map.view.ItemMapPresenter
    public void attachView(@NotNull ItemMapView itemMapView) {
        Intrinsics.checkNotNullParameter(itemMapView, "view");
        this.a = itemMapView;
        CompositeDisposable compositeDisposable = this.c;
        Disposable subscribe = itemMapView.bottomSheetCallback().observeOn(this.f.mainThread()).skip(1).subscribe(new e(this), a.f);
        Intrinsics.checkNotNullExpressionValue(subscribe, "view.bottomSheetCallback…ror(error)\n            })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.c;
        Disposable subscribe2 = itemMapView.backButtonCallback().observeOn(this.f.mainThread()).subscribe(new b(0, this), a.g);
        Intrinsics.checkNotNullExpressionValue(subscribe2, "view.backButtonCallback(…ror(error)\n            })");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.c;
        Observable<Unit> findMeButtonCallback = itemMapView.findMeButtonCallback();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        Disposable subscribe3 = findMeButtonCallback.throttleFirst(1000, timeUnit).observeOn(this.f.mainThread()).subscribe(new b(1, this), new f(this));
        Intrinsics.checkNotNullExpressionValue(subscribe3, "view.findMeButtonCallbac…ror(error)\n            })");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
        CompositeDisposable compositeDisposable4 = this.c;
        Disposable subscribe4 = itemMapView.osmDisclaimerCallback().throttleFirst(1000, timeUnit).observeOn(this.f.mainThread()).subscribe(new b(2, this), a.h);
        Intrinsics.checkNotNullExpressionValue(subscribe4, "view.osmDisclaimerCallba…ror(error)\n            })");
        DisposableKt.plusAssign(compositeDisposable4, subscribe4);
        CompositeDisposable compositeDisposable5 = this.c;
        Disposable subscribe5 = itemMapView.osmTooltipCallback().throttleFirst(1000, timeUnit).observeOn(this.f.mainThread()).subscribe(new b(3, this), a.b);
        Intrinsics.checkNotNullExpressionValue(subscribe5, "view.osmTooltipCallback(…ror(error)\n            })");
        DisposableKt.plusAssign(compositeDisposable5, subscribe5);
        CompositeDisposable compositeDisposable6 = this.c;
        Disposable subscribe6 = itemMapView.mapTargetUpdateCallback().observeOn(this.f.mainThread()).subscribe(new c(0, this), a.c);
        Intrinsics.checkNotNullExpressionValue(subscribe6, "view.mapTargetUpdateCall…ror(error)\n            })");
        DisposableKt.plusAssign(compositeDisposable6, subscribe6);
        CompositeDisposable compositeDisposable7 = this.c;
        Disposable subscribe7 = itemMapView.markerClickCallback().observeOn(this.f.mainThread()).subscribe(new c(1, itemMapView), a.d);
        Intrinsics.checkNotNullExpressionValue(subscribe7, "view.markerClickCallback…ror(error)\n            })");
        DisposableKt.plusAssign(compositeDisposable7, subscribe7);
        CompositeDisposable compositeDisposable8 = this.c;
        Disposable subscribe8 = itemMapView.createRouteClicks().observeOn(this.f.mainThread()).subscribe(new d(this), a.e);
        Intrinsics.checkNotNullExpressionValue(subscribe8, "view.createRouteClicks()…ror(error)\n            })");
        DisposableKt.plusAssign(compositeDisposable8, subscribe8);
    }

    @Override // com.avito.android.item_map.view.ItemMapPresenter
    public void detachRouter() {
        this.b = null;
    }

    @Override // com.avito.android.item_map.view.ItemMapPresenter
    public void detachView() {
        this.a = null;
        this.c.clear();
    }

    @Override // com.avito.android.item_map.view.ItemMapPresenter
    public void findLocationError(@Nullable String str) {
        if (str != null) {
            this.j.trackResolveCoordinates(null, str);
        }
        ItemMapView itemMapView = this.a;
        if (itemMapView != null) {
            itemMapView.showFindLocationError();
        }
    }

    @Override // com.avito.android.item_map.view.ItemMapPresenter
    public void onDestroyMap() {
        ItemMapView itemMapView = this.a;
        if (itemMapView != null) {
            itemMapView.onDestroyMap();
        }
    }

    @Override // com.avito.android.item_map.view.ItemMapPresenter
    @NotNull
    public ItemMapView.ItemMapState onSaveState() {
        return this.d;
    }

    @Override // com.avito.android.item_map.view.ItemMapPresenter
    public void onStartMap() {
        ItemMapView itemMapView = this.a;
        if (itemMapView != null) {
            itemMapView.onStartMap();
        }
    }

    @Override // com.avito.android.item_map.view.ItemMapPresenter
    public void onStopMap() {
        ItemMapView itemMapView = this.a;
        if (itemMapView != null) {
            itemMapView.onStopMap();
        }
    }

    @Override // com.avito.android.item_map.view.ItemMapPresenter
    public void sendScreenExitAfterCoordinatesResolve() {
        this.j.trackScreenExitAfterCoordinatesResolve();
    }

    @Override // com.avito.android.item_map.view.ItemMapPresenter
    public void subscribeFindLocation(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        FindLocationPresenter.DefaultImpls.findLocation$default(this.i, activity, false, 2, null).subscribe(new g(this), new h(this));
    }

    @Override // com.avito.android.item_map.view.ItemMapPresenter
    public void subscribeOnNotPermissionGranted() {
        View view;
        this.j.trackResolveCoordinates(null, "PERMISSION DENIED");
        ItemMapView itemMapView = this.a;
        if (itemMapView != null && (view = itemMapView.getView()) != null) {
            DisposableKt.plusAssign(this.c, this.h.subscriberNotPermissionGranted(view));
        }
    }

    @Override // com.avito.android.item_map.view.ItemMapPresenter
    public void subscribeOnPermissionResult() {
        DisposableKt.plusAssign(this.c, this.h.subscriberChangeLocation());
    }
}

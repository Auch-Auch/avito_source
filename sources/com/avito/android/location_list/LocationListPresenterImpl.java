package com.avito.android.location_list;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.avito.android.location.analytics.FindLocationPage;
import com.avito.android.location.analytics.LocationAnalyticsInteractor;
import com.avito.android.location.find.FindDetectLocationPresenter;
import com.avito.android.location_list.analytics.FromBlock;
import com.avito.android.location_list.analytics.LocationListAnalyticsInteractor;
import com.avito.android.permissions.LocationPermissionDialogPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.LocationsNotFoundError;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.SimpleLocation;
import com.avito.android.ui.fragments.OnBackPressedListener;
import com.avito.android.util.Bundles;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.rx3.InteropKt;
import com.avito.android.util.rx3.Observables;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.data_source.ListDataSource;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B±\u0001\u0012\u0006\u0010v\u001a\u00020t\u0012\u0006\u0010r\u001a\u00020p\u0012\u0006\u0010m\u001a\u00020k\u0012\t\u0010\u0001\u001a\u0004\u0018\u00010\u001a\u0012\u0006\u0010\\\u001a\u00020Z\u0012\u0006\u0010O\u001a\u00020M\u0012\u0006\u0010h\u001a\u00020f\u0012\u0006\u0010_\u001a\u00020]\u0012\u0006\u0010S\u001a\u00020\u0002\u0012\b\b\u0002\u0010J\u001a\u00020'\u0012\b\b\u0002\u0010I\u001a\u00020'\u0012\n\b\u0002\u0010j\u001a\u0004\u0018\u00010$\u0012\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010L\u001a\u00020'\u0012\n\b\u0002\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010U\u001a\u00020'\u0012\u0006\u0010z\u001a\u00020w\u0012\u0006\u0010Y\u001a\u00020V¢\u0006\u0006\b\u0001\u0010\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\bJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\bJ\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001e\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u001e\u0010\u0006J\u000f\u0010\u001f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001f\u0010\bJ\u0017\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b\u0005\u0010&J\u0017\u0010(\u001a\u00020'2\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0004H\u0002¢\u0006\u0004\b*\u0010\bJ\u000f\u0010+\u001a\u00020\u0004H\u0002¢\u0006\u0004\b+\u0010\bJ\u000f\u0010,\u001a\u00020\u0004H\u0002¢\u0006\u0004\b,\u0010\bJ\u0017\u0010.\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020-H\u0002¢\u0006\u0004\b.\u0010/J)\u00103\u001a\u00020\u00042\u0018\u00102\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020$01\u0012\u0004\u0012\u00020\u000400H\u0002¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020\u0004H\u0002¢\u0006\u0004\b5\u0010\bJ\u000f\u00106\u001a\u00020\u0004H\u0002¢\u0006\u0004\b6\u0010\bJ\u0017\u00107\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0002H\u0002¢\u0006\u0004\b7\u0010\u0006J\u0017\u00108\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020-H\u0002¢\u0006\u0004\b8\u0010/J\u000f\u00109\u001a\u00020\u0004H\u0002¢\u0006\u0004\b9\u0010\bJ\u000f\u0010:\u001a\u00020\u0004H\u0002¢\u0006\u0004\b:\u0010\bJ\u000f\u0010;\u001a\u00020\u0004H\u0002¢\u0006\u0004\b;\u0010\bJ/\u0010A\u001a\b\u0012\u0004\u0012\u00020>0@2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020$0<2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010>H\u0002¢\u0006\u0004\bA\u0010BJ\u001d\u0010D\u001a\u00020\u00042\f\u0010C\u001a\b\u0012\u0004\u0012\u00020>0@H\u0002¢\u0006\u0004\bD\u0010EJ\u0017\u0010F\u001a\u00020'2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\bF\u0010GR\u0016\u0010I\u001a\u00020'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010HR\u0016\u0010J\u001a\u00020'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b:\u0010HR\u0016\u0010L\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u0010HR\u0016\u0010O\u001a\u00020M8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u0010NR\u0016\u0010R\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010S\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010QR\u0016\u0010U\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bT\u0010HR\u0016\u0010Y\u001a\u00020V8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010\\\u001a\u00020Z8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u0010[R\u0016\u0010_\u001a\u00020]8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010^R\u0018\u0010b\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b`\u0010aR\u001e\u0010d\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010<8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010cR\u001e\u0010e\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010<8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u0010cR\u0016\u0010h\u001a\u00020f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010gR\u0018\u0010j\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bD\u0010iR\u0016\u0010m\u001a\u00020k8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u0010lR\u0016\u0010o\u001a\u00020>8B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\b`\u0010nR\u0016\u0010r\u001a\u00020p8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010qR\u0018\u0010s\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bF\u0010iR\u0016\u0010v\u001a\u00020t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u0010uR\u0016\u0010z\u001a\u00020w8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bx\u0010yR\u0016\u0010}\u001a\u00020{8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010|R\u0018\u0010\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b~\u0010QR\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bA\u0010\u0001R\u001a\u0010\u0001\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010iR!\u0010\u0001\u001a\u0004\u0018\u00010>8B@\u0002X\u000e¢\u0006\u000e\n\u0006\b\u0001\u0010\u0001\u001a\u0004\bP\u0010n¨\u0006\u0001"}, d2 = {"Lcom/avito/android/location_list/LocationListPresenterImpl;", "Lcom/avito/android/location_list/LocationListPresenter;", "", "id", "", "onLocationSelected", "(Ljava/lang/String;)V", "handleDetach", "()V", "handleDetachRouter", "handleOnHide", "handleOnShow", "Lcom/avito/android/location_list/LocationListRouter;", "router", "handleAttachRouter", "(Lcom/avito/android/location_list/LocationListRouter;)V", "Landroid/content/Context;", "context", "registerLocationReceiver", "(Landroid/content/Context;)V", "unregisterLocationReceiver", "sendScreenExitAfterCoordinatesResolve", "Lcom/avito/android/location_list/LocationListView;", "listView", "handleAttachView", "(Lcom/avito/android/location_list/LocationListView;)V", "Landroid/os/Bundle;", "getState", "()Landroid/os/Bundle;", "error", "onLocationNotFound", "subscribeOnNotPermissionGranted", "Landroid/app/Activity;", "activity", "findLocation", "(Landroid/app/Activity;)V", "Lcom/avito/android/remote/model/Location;", "location", "(Lcom/avito/android/remote/model/Location;)V", "", "f", "(Lcom/avito/android/remote/model/Location;)Z", VKApiConst.Q, AuthSource.SEND_ABUSE, "i", "Lcom/avito/android/remote/error/TypedError;", AuthSource.OPEN_CHANNEL_LIST, "(Lcom/avito/android/remote/error/TypedError;)V", "Lkotlin/Function1;", "Lcom/avito/android/util/LoadingState;", "func", "j", "(Lkotlin/jvm/functions/Function1;)V", "h", "k", a2.g.r.g.a, "l", "n", "p", "o", "", "list", "Lcom/avito/android/location_list/LocationItem;", "topStubItem", "Lcom/avito/konveyor/data_source/ListDataSource;", "c", "(Ljava/util/List;Lcom/avito/android/location_list/LocationItem;)Lcom/avito/konveyor/data_source/ListDataSource;", "dataSource", "r", "(Lcom/avito/konveyor/data_source/ListDataSource;)V", "e", "(Ljava/lang/String;)Z", "Z", "showWholeLocations", "hasRegion", "t", "hasSearchArea", "Lcom/avito/android/location_list/LocationListListener;", "Lcom/avito/android/location_list/LocationListListener;", "locationListListener", "d", "Ljava/lang/String;", "searchQuery", "topStubLocationName", VKApiConst.VERSION, "shouldTrackLocationEvents", "Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;", "x", "Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;", "locationAnalyticsInteractor", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/ui/fragments/OnBackPressedListener;", "Lcom/avito/android/ui/fragments/OnBackPressedListener;", "backPressListener", AuthSource.BOOKING_ORDER, "Lcom/avito/android/location_list/LocationListView;", "view", "Ljava/util/List;", "locations", "searchLocations", "Lcom/avito/android/location/find/FindDetectLocationPresenter;", "Lcom/avito/android/location/find/FindDetectLocationPresenter;", "findDetectLocationPresenter", "Lcom/avito/android/remote/model/Location;", "selectedLocation", "Lcom/avito/android/util/SchedulersFactory3;", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "()Lcom/avito/android/location_list/LocationItem;", "childTopStubLocationItem", "Lcom/avito/android/location_list/analytics/LocationListAnalyticsInteractor;", "Lcom/avito/android/location_list/analytics/LocationListAnalyticsInteractor;", "analyticsInteractor", "topLocation", "Lcom/avito/android/location_list/LocationListInteractor;", "Lcom/avito/android/location_list/LocationListInteractor;", "interactor", "Lcom/avito/android/permissions/LocationPermissionDialogPresenter;", "w", "Lcom/avito/android/permissions/LocationPermissionDialogPresenter;", "locationPermissionDialogPresenter", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "u", "categoryId", "Lcom/avito/android/location_list/LocationListRouter;", "s", "parentLocation", "topLocationItem", "Lcom/avito/android/location_list/LocationItem;", "state", "<init>", "(Lcom/avito/android/location_list/LocationListInteractor;Lcom/avito/android/location_list/analytics/LocationListAnalyticsInteractor;Lcom/avito/android/util/SchedulersFactory3;Landroid/os/Bundle;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/location_list/LocationListListener;Lcom/avito/android/location/find/FindDetectLocationPresenter;Lcom/avito/android/ui/fragments/OnBackPressedListener;Ljava/lang/String;ZZLcom/avito/android/remote/model/Location;Lcom/avito/android/remote/model/Location;ZLjava/lang/String;ZLcom/avito/android/permissions/LocationPermissionDialogPresenter;Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;)V", "location-list_release"}, k = 1, mv = {1, 4, 2})
public final class LocationListPresenterImpl implements LocationListPresenter {
    public final CompositeDisposable a;
    public LocationListView b;
    public LocationListRouter c;
    public String d;
    public Location e;
    public List<Location> f;
    public List<Location> g;
    public final LocationListInteractor h;
    public final LocationListAnalyticsInteractor i;
    public final SchedulersFactory3 j;
    public final AdapterPresenter k;
    public final LocationListListener l;
    public final FindDetectLocationPresenter m;
    public final OnBackPressedListener n;
    public final String o;
    public boolean p;
    public boolean q;
    public Location r;
    public Location s;
    public final boolean t;
    public final String u;
    public final boolean v;
    public final LocationPermissionDialogPresenter w;
    public final LocationAnalyticsInteractor x;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Unit unit) {
            int i = this.a;
            if (i != 0) {
                String str = null;
                if (i == 1) {
                    if (((LocationListPresenterImpl) this.b).v) {
                        LocationListAnalyticsInteractor locationListAnalyticsInteractor = ((LocationListPresenterImpl) this.b).i;
                        String str2 = ((LocationListPresenterImpl) this.b).u;
                        Location location = ((LocationListPresenterImpl) this.b).r;
                        if (location != null) {
                            str = location.getId();
                        }
                        locationListAnalyticsInteractor.trackLocationListScreenClose(str2, str, ((LocationListPresenterImpl) this.b).d, FromBlock.MY_LOCATION);
                    }
                    LocationListPresenterImpl.access$requestOfLocationDetect((LocationListPresenterImpl) this.b);
                    return;
                }
                throw null;
            }
            LocationListPresenterImpl.access$refresh((LocationListPresenterImpl) this.b);
        }
    }

    /* compiled from: java-style lambda group */
    public static final class b<T> implements Consumer<Throwable> {
        public static final b b = new b(0);
        public static final b c = new b(1);
        public static final b d = new b(2);
        public static final b e = new b(3);
        public final /* synthetic */ int a;

        public b(int i) {
            this.a = i;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Throwable th) {
            int i = this.a;
            if (i == 0) {
                Logs.error(th);
            } else if (i == 1) {
                Logs.error(th);
            } else if (i == 2) {
                Logs.error(th);
            } else if (i == 3) {
                Logs.error(th);
            } else {
                throw null;
            }
        }
    }

    public static final class c<T> implements Consumer<android.location.Location> {
        public final /* synthetic */ LocationListPresenterImpl a;

        public c(LocationListPresenterImpl locationListPresenterImpl) {
            this.a = locationListPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(android.location.Location location) {
            android.location.Location location2 = location;
            LocationAnalyticsInteractor.DefaultImpls.trackResolveCoordinates$default(this.a.x, location2, null, 2, null);
            LocationListPresenterImpl locationListPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(location2, "it");
            LocationListPresenterImpl.access$handleLocationAvailable(locationListPresenterImpl, String.valueOf(location2.getLatitude()), String.valueOf(location2.getLongitude()));
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public final /* synthetic */ LocationListPresenterImpl a;

        public d(LocationListPresenterImpl locationListPresenterImpl) {
            this.a = locationListPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            LocationListPresenterImpl.access$showLocationProblem(this.a, th2.getMessage());
            Logs.error(th2);
        }
    }

    public static final class e<T> implements Consumer<LoadingState<? super List<? extends Location>>> {
        public final /* synthetic */ LocationListPresenterImpl a;

        public e(LocationListPresenterImpl locationListPresenterImpl) {
            this.a = locationListPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(LoadingState<? super List<? extends Location>> loadingState) {
            LoadingState<? super List<? extends Location>> loadingState2 = loadingState;
            LocationListPresenterImpl locationListPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(loadingState2, "it");
            LocationListPresenterImpl.access$onSearchChanged(locationListPresenterImpl, loadingState2);
        }
    }

    public static final class f extends Lambda implements Function1<LoadingState<? super Location>, Unit> {
        public final /* synthetic */ Function1 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(Function1 function1) {
            super(1);
            this.a = function1;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(LoadingState<? super Location> loadingState) {
            LoadingState<? super Location> loadingState2 = loadingState;
            Function1 function1 = this.a;
            Intrinsics.checkNotNullExpressionValue(loadingState2, "it");
            function1.invoke(loadingState2);
            return Unit.INSTANCE;
        }
    }

    public static final class g extends Lambda implements Function1<LoadingState<? super List<? extends Location>>, Unit> {
        public final /* synthetic */ LocationListPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(LocationListPresenterImpl locationListPresenterImpl) {
            super(1);
            this.a = locationListPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(LoadingState<? super List<? extends Location>> loadingState) {
            LoadingState<? super List<? extends Location>> loadingState2 = loadingState;
            LocationListPresenterImpl locationListPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(loadingState2, "it");
            LocationListPresenterImpl.access$onLocationsChanged(locationListPresenterImpl, loadingState2, this.a.d());
            return Unit.INSTANCE;
        }
    }

    public static final class h<T> implements Consumer<String> {
        public final /* synthetic */ LocationListPresenterImpl a;

        public h(LocationListPresenterImpl locationListPresenterImpl) {
            this.a = locationListPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(String str) {
            String str2 = str;
            if (!Intrinsics.areEqual(str2, this.a.d)) {
                LocationListPresenterImpl locationListPresenterImpl = this.a;
                Intrinsics.checkNotNullExpressionValue(str2, "it");
                locationListPresenterImpl.g(str2);
            }
        }
    }

    public static final class i<T> implements Consumer<Unit> {
        public final /* synthetic */ LocationListPresenterImpl a;
        public final /* synthetic */ LocationListView b;

        public i(LocationListPresenterImpl locationListPresenterImpl, LocationListView locationListView) {
            this.a = locationListPresenterImpl;
            this.b = locationListView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            if (this.a.s == null && this.a.v) {
                LocationListAnalyticsInteractor locationListAnalyticsInteractor = this.a.i;
                String str = this.a.u;
                Location location = this.a.r;
                locationListAnalyticsInteractor.trackLocationListScreenClose(str, location != null ? location.getId() : null, this.a.d, FromBlock.REFUSE);
            }
            this.b.hideKeyboard();
            this.a.n.onBackPressed();
        }
    }

    public LocationListPresenterImpl(@NotNull LocationListInteractor locationListInteractor, @NotNull LocationListAnalyticsInteractor locationListAnalyticsInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @Nullable Bundle bundle, @NotNull AdapterPresenter adapterPresenter, @NotNull LocationListListener locationListListener, @NotNull FindDetectLocationPresenter findDetectLocationPresenter, @NotNull OnBackPressedListener onBackPressedListener, @NotNull String str, boolean z, boolean z2, @Nullable Location location, @Nullable Location location2, boolean z3, @Nullable String str2, boolean z4, @NotNull LocationPermissionDialogPresenter locationPermissionDialogPresenter, @NotNull LocationAnalyticsInteractor locationAnalyticsInteractor) {
        Intrinsics.checkNotNullParameter(locationListInteractor, "interactor");
        Intrinsics.checkNotNullParameter(locationListAnalyticsInteractor, "analyticsInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(locationListListener, "locationListListener");
        Intrinsics.checkNotNullParameter(findDetectLocationPresenter, "findDetectLocationPresenter");
        Intrinsics.checkNotNullParameter(onBackPressedListener, "backPressListener");
        Intrinsics.checkNotNullParameter(str, "topStubLocationName");
        Intrinsics.checkNotNullParameter(locationPermissionDialogPresenter, "locationPermissionDialogPresenter");
        Intrinsics.checkNotNullParameter(locationAnalyticsInteractor, "locationAnalyticsInteractor");
        this.h = locationListInteractor;
        this.i = locationListAnalyticsInteractor;
        this.j = schedulersFactory3;
        this.k = adapterPresenter;
        this.l = locationListListener;
        this.m = findDetectLocationPresenter;
        this.n = onBackPressedListener;
        this.o = str;
        this.p = z;
        this.q = z2;
        this.r = location;
        this.s = location2;
        this.t = z3;
        this.u = str2;
        this.v = z4;
        this.w = locationPermissionDialogPresenter;
        this.x = locationAnalyticsInteractor;
        this.a = new CompositeDisposable();
        String str3 = "";
        this.d = str3;
        if (bundle != null) {
            this.p = bundle.getBoolean("hasRegion");
            this.q = bundle.getBoolean("showWholeLocations");
            this.r = (Location) bundle.getParcelable("selectedLocation");
            this.s = (Location) bundle.getParcelable("parentLocation");
            this.e = (Location) bundle.getParcelable("topLocation");
            String string = bundle.getString("searchQuery");
            this.d = string != null ? string : str3;
            this.f = Bundles.getParcelableList(bundle, "locations");
        }
        if (this.s == null && z4) {
            Location location3 = this.r;
            locationListAnalyticsInteractor.trackLocationListScreenOpen(str2, location3 != null ? location3.getId() : null);
        }
    }

    public static final void access$handleLocationAvailable(LocationListPresenterImpl locationListPresenterImpl, String str, String str2) {
        locationListPresenterImpl.a();
        CompositeDisposable compositeDisposable = locationListPresenterImpl.a;
        Disposable subscribe = InteropKt.toV3(locationListPresenterImpl.h.getNearestLocation(str, str2)).observeOn(locationListPresenterImpl.j.mainThread()).subscribe(new a2.a.a.m1.c(locationListPresenterImpl));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.getNearestLoc…{ onNearestChanged(it) })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public static final void access$onLocationsChanged(LocationListPresenterImpl locationListPresenterImpl, LoadingState loadingState, LocationItem locationItem) {
        Objects.requireNonNull(locationListPresenterImpl);
        if (loadingState instanceof LoadingState.Loaded) {
            List<Location> list = (List) ((LoadingState.Loaded) loadingState).getData();
            locationListPresenterImpl.f = list;
            if (list != null) {
                locationListPresenterImpl.r(locationListPresenterImpl.c(list, locationItem));
            }
            locationListPresenterImpl.n();
            LocationListView locationListView = locationListPresenterImpl.b;
            if (locationListView != null) {
                locationListView.scrollToTop();
            }
        } else if (loadingState instanceof LoadingState.Loading) {
            locationListPresenterImpl.p();
        } else if (loadingState instanceof LoadingState.Error) {
            locationListPresenterImpl.l(((LoadingState.Error) loadingState).getError());
        }
    }

    public static final void access$onNearestChanged(LocationListPresenterImpl locationListPresenterImpl, LoadingState loadingState) {
        Objects.requireNonNull(locationListPresenterImpl);
        if (loadingState instanceof LoadingState.Loaded) {
            locationListPresenterImpl.a();
            Location location = (Location) ((LoadingState.Loaded) loadingState).getData();
            LocationListView locationListView = locationListPresenterImpl.b;
            if (locationListView != null) {
                locationListView.dismissLocationProgress();
            }
            LocationListRouter locationListRouter = locationListPresenterImpl.c;
            if (locationListRouter != null) {
                locationListRouter.showLocationConfirmDialog(location);
            }
        } else if (loadingState instanceof LoadingState.Error) {
            if (((LoadingState.Error) loadingState).getError() instanceof ErrorWithMessage.NetworkError) {
                locationListPresenterImpl.o();
            }
            locationListPresenterImpl.a();
        }
    }

    public static final void access$onSearchChanged(LocationListPresenterImpl locationListPresenterImpl, LoadingState loadingState) {
        Objects.requireNonNull(locationListPresenterImpl);
        if (loadingState instanceof LoadingState.Loaded) {
            LoadingState.Loaded loaded = (LoadingState.Loaded) loadingState;
            locationListPresenterImpl.r(locationListPresenterImpl.c((List) loaded.getData(), null));
            locationListPresenterImpl.n();
            if (!Intrinsics.areEqual((List) loaded.getData(), locationListPresenterImpl.g)) {
                LocationListView locationListView = locationListPresenterImpl.b;
                if (locationListView != null) {
                    locationListView.scrollToTop();
                }
                locationListPresenterImpl.g = (List) loaded.getData();
            }
        } else if (loadingState instanceof LoadingState.Loading) {
            locationListPresenterImpl.p();
        } else if (loadingState instanceof LoadingState.Error) {
            locationListPresenterImpl.m(((LoadingState.Error) loadingState).getError());
        }
    }

    public static final void access$onSelectedLocationForSearchLoaded(LocationListPresenterImpl locationListPresenterImpl, LoadingState loadingState) {
        Objects.requireNonNull(locationListPresenterImpl);
        if (loadingState instanceof LoadingState.Loaded) {
            locationListPresenterImpl.r = (Location) ((LoadingState.Loaded) loadingState).getData();
            locationListPresenterImpl.i();
        } else if (loadingState instanceof LoadingState.Loading) {
            locationListPresenterImpl.p();
        } else if (loadingState instanceof LoadingState.Error) {
            locationListPresenterImpl.m(((LoadingState.Error) loadingState).getError());
        }
    }

    public static final void access$onSelectedLocationLoaded(LocationListPresenterImpl locationListPresenterImpl, LoadingState loadingState) {
        Objects.requireNonNull(locationListPresenterImpl);
        if (loadingState instanceof LoadingState.Loaded) {
            locationListPresenterImpl.r = (Location) ((LoadingState.Loaded) loadingState).getData();
            locationListPresenterImpl.h();
        } else if (loadingState instanceof LoadingState.Loading) {
            locationListPresenterImpl.p();
        } else if (loadingState instanceof LoadingState.Error) {
            locationListPresenterImpl.l(((LoadingState.Error) loadingState).getError());
        }
    }

    public static final void access$onTopLocationLoaded(LocationListPresenterImpl locationListPresenterImpl, LoadingState loadingState) {
        Objects.requireNonNull(locationListPresenterImpl);
        if (loadingState instanceof LoadingState.Loaded) {
            locationListPresenterImpl.e = (Location) ((LoadingState.Loaded) loadingState).getData();
            locationListPresenterImpl.k();
        } else if (loadingState instanceof LoadingState.Loading) {
            locationListPresenterImpl.p();
        } else if (loadingState instanceof LoadingState.Error) {
            locationListPresenterImpl.l(((LoadingState.Error) loadingState).getError());
        }
    }

    public static final void access$refresh(LocationListPresenterImpl locationListPresenterImpl) {
        locationListPresenterImpl.g(locationListPresenterImpl.d);
    }

    public static final void access$requestOfLocationDetect(LocationListPresenterImpl locationListPresenterImpl) {
        locationListPresenterImpl.x.trackFindCoordinates(FindLocationPage.PROFILE.getValue());
        DisposableKt.plusAssign(locationListPresenterImpl.a, locationListPresenterImpl.w.subscriberChangeLocation());
    }

    public static final void access$showLocationProblem(LocationListPresenterImpl locationListPresenterImpl, String str) {
        locationListPresenterImpl.x.trackResolveCoordinates(null, str);
        LocationListView locationListView = locationListPresenterImpl.b;
        if (locationListView != null) {
            locationListView.showLocationProblem();
        }
    }

    public final void a() {
        LocationListView locationListView = this.b;
        if (locationListView != null) {
            locationListView.dismissLocationProgress();
        }
    }

    public final LocationItem b() {
        String str;
        Location location = this.s;
        if (location == null || (str = location.getId()) == null) {
            str = "stub";
        }
        return new LocationItem(str, this.o, null, false, 8, null);
    }

    public final ListDataSource<LocationItem> c(List<Location> list, LocationItem locationItem) {
        List mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) CollectionsKt__CollectionsKt.emptyList());
        Iterator<T> it = list.iterator();
        while (true) {
            String str = null;
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            String id = next.getId();
            String name = next.getName();
            SimpleLocation parent = next.getParent();
            if (parent != null) {
                str = parent.getName();
            }
            LocationItem locationItem2 = new LocationItem(id, name, str, false, 8, null);
            locationItem2.setSelected(e(locationItem2.getStringId()));
            mutableList.add(locationItem2);
        }
        if (this.q) {
            if (locationItem != null) {
                locationItem.setSelected(e(locationItem.getStringId()));
            } else {
                locationItem = null;
            }
            if (locationItem != null) {
                mutableList.add(0, locationItem);
            }
        }
        return new ListDataSource<>(mutableList);
    }

    public final LocationItem d() {
        Location location = this.e;
        String str = null;
        if (location == null) {
            return null;
        }
        String id = location.getId();
        String name = location.getName();
        SimpleLocation parent = location.getParent();
        if (parent != null) {
            str = parent.getName();
        }
        return new LocationItem(id, name, str, false, 8, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean e(java.lang.String r5) {
        /*
            r4 = this;
            com.avito.android.remote.model.Location r0 = r4.r
            r1 = 0
            if (r0 == 0) goto L_0x000a
            java.lang.String r0 = r0.getId()
            goto L_0x000b
        L_0x000a:
            r0 = r1
        L_0x000b:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r5)
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L_0x0048
            com.avito.android.remote.model.Location r0 = r4.s
            if (r0 != 0) goto L_0x0019
            r0 = 1
            goto L_0x001a
        L_0x0019:
            r0 = 0
        L_0x001a:
            if (r0 == 0) goto L_0x0045
            com.avito.android.location_list.LocationItem r0 = r4.d()
            if (r0 == 0) goto L_0x0027
            java.lang.String r0 = r0.getStringId()
            goto L_0x0028
        L_0x0027:
            r0 = r1
        L_0x0028:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r5)
            r0 = r0 ^ r3
            if (r0 == 0) goto L_0x0045
            com.avito.android.remote.model.Location r0 = r4.r
            if (r0 == 0) goto L_0x003d
            com.avito.android.remote.model.SimpleLocation r0 = r0.getParent()
            if (r0 == 0) goto L_0x003d
            java.lang.String r1 = r0.getId()
        L_0x003d:
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r5)
            if (r5 == 0) goto L_0x0045
            r5 = 1
            goto L_0x0046
        L_0x0045:
            r5 = 0
        L_0x0046:
            if (r5 == 0) goto L_0x004d
        L_0x0048:
            boolean r5 = r4.t
            if (r5 != 0) goto L_0x004d
            r2 = 1
        L_0x004d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.location_list.LocationListPresenterImpl.e(java.lang.String):boolean");
    }

    public final boolean f(Location location) {
        return Intrinsics.areEqual(location, this.e) || Intrinsics.areEqual(location, this.s);
    }

    @Override // com.avito.android.location_list.LocationListPresenter
    public void findLocation(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        LocationListView locationListView = this.b;
        if (locationListView != null) {
            locationListView.showProgressDialog();
        }
        CompositeDisposable compositeDisposable = this.a;
        Disposable subscribe = this.m.findLocation(activity, true).subscribe(new c(this), new d(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "findDetectLocationPresen…ror(error)\n            })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void g(String str) {
        boolean z = true;
        String str2 = null;
        if (!m.isBlank(str)) {
            this.d = str;
            Location location = this.r;
            if (location != null) {
                SimpleLocation parent = location.getParent();
                if (parent != null) {
                    str2 = parent.getId();
                }
                if (str2 != null && !m.isBlank(str2)) {
                    z = false;
                }
                if (z) {
                    j(new a2.a.a.m1.g(this));
                    return;
                }
            }
            i();
            return;
        }
        this.d = "";
        Location location2 = this.r;
        if (location2 != null) {
            SimpleLocation parent2 = location2.getParent();
            if (parent2 != null) {
                str2 = parent2.getId();
            }
            if (str2 != null && !m.isBlank(str2)) {
                z = false;
            }
            if (z) {
                j(new a2.a.a.m1.e(this));
                return;
            }
        }
        h();
    }

    @Override // com.avito.android.location_list.LocationListPresenter
    @NotNull
    public Bundle getState() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("hasRegion", this.p);
        bundle.putBoolean("showWholeLocations", this.q);
        bundle.putParcelable("selectedLocation", this.r);
        bundle.putParcelable("parentLocation", this.s);
        bundle.putParcelable("topLocation", this.e);
        bundle.putString("searchQuery", this.d);
        Bundles.putParcelableList(bundle, "locations", this.f);
        return bundle;
    }

    public final void h() {
        LocationItem locationItem;
        List<Location> list = this.f;
        if (list == null) {
            Location location = this.s;
            if (location != null) {
                DisposableKt.plusAssign(this.a, Observables.subscribeOnNext(a2.b.a.a.a.b2(this.j, InteropKt.toV3(this.h.getChildrenLocations(location)), "interactor.getChildrenLo…(schedulers.mainThread())"), new a2.a.a.m1.d(this)));
            } else if (this.e == null) {
                DisposableKt.plusAssign(this.a, Observables.subscribeOnNext(a2.b.a.a.a.b2(this.j, InteropKt.toV3(this.h.getTopLocation()), "interactor.getTopLocatio…(schedulers.mainThread())"), new a2.a.a.m1.f(this)));
            } else {
                k();
            }
        } else {
            if (this.s == null) {
                locationItem = d();
            } else {
                locationItem = b();
            }
            if (list != null) {
                r(c(list, locationItem));
                n();
            }
        }
    }

    @Override // com.avito.android.location_list.LocationListPresenter
    public void handleAttachRouter(@NotNull LocationListRouter locationListRouter) {
        Intrinsics.checkNotNullParameter(locationListRouter, "router");
        this.c = locationListRouter;
    }

    @Override // com.avito.android.location_list.LocationListPresenter
    public void handleAttachView(@NotNull LocationListView locationListView) {
        Intrinsics.checkNotNullParameter(locationListView, "listView");
        this.b = locationListView;
        if (this.p) {
            if (locationListView != null) {
                locationListView.setHomeIconDiscard();
            }
        } else if (locationListView != null) {
            locationListView.setHomeIconNormal();
        }
        q();
        this.g = this.h.getUsedLocations(this.d);
    }

    @Override // com.avito.android.location_list.LocationListPresenter
    public void handleDetach() {
        this.a.clear();
        this.b = null;
    }

    @Override // com.avito.android.location_list.LocationListPresenter
    public void handleDetachRouter() {
        this.c = null;
    }

    @Override // com.avito.android.location_list.LocationListPresenter
    public void handleOnHide() {
        a();
    }

    @Override // com.avito.android.location_list.LocationListPresenter
    public void handleOnShow() {
        g(this.d);
    }

    public final void i() {
        this.f = null;
        this.a.clear();
        q();
        CompositeDisposable compositeDisposable = this.a;
        Disposable subscribe = InteropKt.toV3(this.h.getSearchLocations(this.d)).observeOn(this.j.mainThread()).subscribe(new e(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.getSearchLoca…({ onSearchChanged(it) })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void j(Function1<? super LoadingState<? super Location>, Unit> function1) {
        String id;
        Location location = this.r;
        if (location != null && (id = location.getId()) != null) {
            DisposableKt.plusAssign(this.a, Observables.subscribeOnNext(a2.b.a.a.a.b2(this.j, InteropKt.toV3(this.h.getLocation(id)), "interactor.getLocation(i…(schedulers.mainThread())"), new f(function1)));
        }
    }

    public final void k() {
        DisposableKt.plusAssign(this.a, Observables.subscribeOnNext(a2.b.a.a.a.b2(this.j, InteropKt.toV3(this.h.getTopLocations()), "interactor.getTopLocatio…(schedulers.mainThread())"), new g(this)));
    }

    public final void l(TypedError typedError) {
        if (typedError instanceof ErrorWithMessage.NetworkError) {
            o();
            return;
        }
        LocationListView locationListView = this.b;
        if (locationListView != null) {
            locationListView.showContent();
        }
    }

    public final void m(TypedError typedError) {
        if (typedError instanceof ErrorWithMessage.NetworkError) {
            o();
        } else if (typedError instanceof LocationsNotFoundError) {
            r(new ListDataSource<>(CollectionsKt__CollectionsKt.emptyList()));
            n();
        } else {
            o();
        }
    }

    public final void n() {
        LocationListView locationListView = this.b;
        if (locationListView != null) {
            locationListView.showContent();
        }
        LocationListView locationListView2 = this.b;
        if (locationListView2 != null) {
            locationListView2.showSearchKeyboard();
        }
    }

    public final void o() {
        LocationListView locationListView = this.b;
        if (locationListView != null) {
            locationListView.showUnavailable();
        }
    }

    @Override // com.avito.android.location_list.LocationListPresenter
    public void onLocationNotFound(@Nullable String str) {
        if (str != null) {
            this.x.trackResolveCoordinates(null, str);
        }
        LocationListView locationListView = this.b;
        if (locationListView != null) {
            locationListView.showLocationProblem();
        }
    }

    @Override // com.avito.android.location_list.LocationListener
    public void onLocationSelected(@NotNull String str) {
        Location location;
        List<Location> list;
        Object obj;
        Intrinsics.checkNotNullParameter(str, "id");
        Location location2 = this.e;
        String str2 = null;
        boolean z = false;
        if (Intrinsics.areEqual(location2 != null ? location2.getId() : null, str)) {
            location = this.e;
        } else {
            Location location3 = this.s;
            if (Intrinsics.areEqual(location3 != null ? location3.getId() : null, str)) {
                location = this.s;
            } else {
                String str3 = this.d;
                if (str3 == null || m.isBlank(str3)) {
                    list = this.f;
                } else {
                    list = this.h.getUsedLocations(this.d);
                }
                if (list != null) {
                    Iterator it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it.next();
                        if (Intrinsics.areEqual(((Location) obj).getId(), str)) {
                            break;
                        }
                    }
                    location = (Location) obj;
                } else {
                    location = null;
                }
            }
        }
        if (location == null) {
            return;
        }
        if (f(location) || !location.getHasChildren()) {
            if (f(location)) {
                Location location4 = this.s;
                if (location4 == null) {
                    z = true;
                }
                if (!z) {
                    location = location4;
                }
            }
            if (this.v) {
                LocationListAnalyticsInteractor locationListAnalyticsInteractor = this.i;
                String str4 = this.u;
                if (location != null) {
                    str2 = location.getId();
                }
                locationListAnalyticsInteractor.trackLocationListScreenClose(str4, str2, this.d, FromBlock.REGION_TREE);
            }
            this.l.onLocationSet(location);
            LocationListView locationListView = this.b;
            if (locationListView != null) {
                locationListView.hideKeyboard();
            }
            LocationListRouter locationListRouter = this.c;
            if (locationListRouter != null) {
                locationListRouter.finish();
                return;
            }
            return;
        }
        this.l.onRegionLocationSelected(location);
    }

    public final void p() {
        LocationListView locationListView = this.b;
        if (locationListView != null) {
            locationListView.showStartLoading();
        }
    }

    public final void q() {
        LocationListView locationListView = this.b;
        if (locationListView != null) {
            CompositeDisposable compositeDisposable = this.a;
            Disposable subscribe = InteropKt.toV3(locationListView.getSearchQuery()).debounce(600, TimeUnit.MILLISECONDS, this.j.computation()).observeOn(this.j.mainThread()).subscribe(new h(this), b.b);
            Intrinsics.checkNotNullExpressionValue(subscribe, "view.searchQuery\n       …throwable)\n            })");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
            CompositeDisposable compositeDisposable2 = this.a;
            Disposable subscribe2 = InteropKt.toV3(locationListView.refreshCallback()).observeOn(this.j.mainThread()).subscribe(new a(0, this), b.c);
            Intrinsics.checkNotNullExpressionValue(subscribe2, "view.refreshCallback()\n …throwable)\n            })");
            DisposableKt.plusAssign(compositeDisposable2, subscribe2);
            CompositeDisposable compositeDisposable3 = this.a;
            Disposable subscribe3 = InteropKt.toV3(locationListView.findLocationCallback()).observeOn(this.j.mainThread()).subscribe(new a(1, this), b.d);
            Intrinsics.checkNotNullExpressionValue(subscribe3, "view.findLocationCallbac…throwable)\n            })");
            DisposableKt.plusAssign(compositeDisposable3, subscribe3);
            CompositeDisposable compositeDisposable4 = this.a;
            Disposable subscribe4 = InteropKt.toV3(locationListView.navigationCallback()).observeOn(this.j.mainThread()).subscribe(new i(this, locationListView), b.e);
            Intrinsics.checkNotNullExpressionValue(subscribe4, "view.navigationCallback(…throwable)\n            })");
            DisposableKt.plusAssign(compositeDisposable4, subscribe4);
        }
    }

    public final void r(ListDataSource<LocationItem> listDataSource) {
        this.k.onDataSourceChanged(listDataSource);
        LocationListView locationListView = this.b;
        if (locationListView != null) {
            locationListView.notifyChanged();
        }
        if (listDataSource.isEmpty()) {
            LocationListView locationListView2 = this.b;
            if (locationListView2 != null) {
                locationListView2.showEmptyView();
                return;
            }
            return;
        }
        LocationListView locationListView3 = this.b;
        if (locationListView3 != null) {
            locationListView3.showList();
        }
    }

    @Override // com.avito.android.location_list.LocationListPresenter
    public void registerLocationReceiver(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.m.registerLocationReceiver(context);
    }

    @Override // com.avito.android.location_list.LocationListPresenter
    public void sendScreenExitAfterCoordinatesResolve() {
        this.x.trackScreenExitAfterCoordinatesResolve();
    }

    @Override // com.avito.android.location_list.LocationListPresenter
    public void subscribeOnNotPermissionGranted() {
        View rootView;
        this.x.trackResolveCoordinates(null, "PERMISSION DENIED");
        LocationListView locationListView = this.b;
        if (locationListView != null && (rootView = locationListView.getRootView()) != null) {
            DisposableKt.plusAssign(this.a, this.w.subscriberNotPermissionGranted(rootView));
        }
    }

    @Override // com.avito.android.location_list.LocationListPresenter
    public void unregisterLocationReceiver(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.m.unregisterLocationReceiver(context);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LocationListPresenterImpl(LocationListInteractor locationListInteractor, LocationListAnalyticsInteractor locationListAnalyticsInteractor, SchedulersFactory3 schedulersFactory3, Bundle bundle, AdapterPresenter adapterPresenter, LocationListListener locationListListener, FindDetectLocationPresenter findDetectLocationPresenter, OnBackPressedListener onBackPressedListener, String str, boolean z, boolean z2, Location location, Location location2, boolean z3, String str2, boolean z4, LocationPermissionDialogPresenter locationPermissionDialogPresenter, LocationAnalyticsInteractor locationAnalyticsInteractor, int i2, j jVar) {
        this(locationListInteractor, locationListAnalyticsInteractor, schedulersFactory3, bundle, adapterPresenter, locationListListener, findDetectLocationPresenter, onBackPressedListener, str, (i2 & 512) != 0 ? false : z, (i2 & 1024) != 0 ? false : z2, (i2 & 2048) != 0 ? null : location, (i2 & 4096) != 0 ? null : location2, (i2 & 8192) != 0 ? false : z3, (i2 & 16384) != 0 ? null : str2, (i2 & 32768) != 0 ? false : z4, locationPermissionDialogPresenter, locationAnalyticsInteractor);
    }

    @Override // com.avito.android.location_list.LocationConfirmListener
    public void onLocationSelected(@NotNull Location location) {
        Intrinsics.checkNotNullParameter(location, "location");
        if (this.v) {
            this.i.trackLocationListScreenClose(this.u, location.getId(), this.d, FromBlock.MY_LOCATION_APPROVE_BUTTON);
        }
        this.l.onLocationSet(location);
        LocationListView locationListView = this.b;
        if (locationListView != null) {
            locationListView.hideKeyboard();
        }
        LocationListRouter locationListRouter = this.c;
        if (locationListRouter != null) {
            locationListRouter.finish();
        }
    }
}

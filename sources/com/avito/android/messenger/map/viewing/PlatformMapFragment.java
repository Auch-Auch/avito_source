package com.avito.android.messenger.map.viewing;

import a2.b.a.a.a;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.location.Location;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import com.avito.android.avito_map.AvitoMapCameraPosition;
import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.location.analytics.FindLocationPage;
import com.avito.android.location.analytics.LocationAnalyticsInteractor;
import com.avito.android.location.find.FindLocationPresenter;
import com.avito.android.messenger.R;
import com.avito.android.messenger.channels.mvi.di.ViewModelFactory;
import com.avito.android.messenger.map.OnLocationEnabledListener;
import com.avito.android.messenger.map.sharing.SharingMapFragment;
import com.avito.android.messenger.map.viewing.di.DaggerPlatformMapFragmentComponent;
import com.avito.android.messenger.map.viewing.di.PlatformMapFragmentComponent;
import com.avito.android.messenger.map.viewing.di.PlatformMapFragmentDependencies;
import com.avito.android.messenger.map.viewing.view.Pin;
import com.avito.android.messenger.map.viewing.view.PlatformMapView;
import com.avito.android.permissions.LocationPermissionDialogPresenter;
import com.avito.android.remote.model.messenger.geo.GeoMarker;
import com.avito.android.remote.model.messenger.geo.MarkersRequest;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.util.ActionBarUtils;
import com.avito.android.util.FragmentsKt;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.ToastsKt;
import com.avito.android.util.rx3.InteropKt;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.bottom_sheet.BottomSheet;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 l2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001lB\u0007¢\u0006\u0004\bk\u0010\u0013J-\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0015\u0010\u0013J\u000f\u0010\u0016\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0016\u0010\u0013J\u000f\u0010\u0017\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0017\u0010\u0013J\u000f\u0010\u0018\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0018\u0010\u0013J\u0017\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001c\u0010\u0013J\u0019\u0010\u001f\u001a\u00020\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u000fH\u0016¢\u0006\u0004\b!\u0010\u0013J\u000f\u0010\"\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\"\u0010\u0013J\u000f\u0010#\u001a\u00020\u000fH\u0016¢\u0006\u0004\b#\u0010\u0013R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\"\u0010)\u001a\u00020(8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00100\u001a\u00020/8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u00107\u001a\u0002068\u0006@\u0006X.¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010>\u001a\u00020=8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\"\u0010E\u001a\u00020D8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\"\u0010L\u001a\u00020K8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u0016\u0010U\u001a\u00020R8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\"\u0010W\u001a\u00020V8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\"\u0010^\u001a\u00020]8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\"\u0010e\u001a\u00020d8\u0006@\u0006X.¢\u0006\u0012\n\u0004\be\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010j¨\u0006m"}, d2 = {"Lcom/avito/android/messenger/map/viewing/PlatformMapFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Lcom/avito/android/messenger/map/OnLocationEnabledListener;", "Lcom/avito/android/permissions/LocationPermissionDialogPresenter$Subscriber;", "Lcom/avito/android/permissions/LocationPermissionDialogPresenter$Router;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onStart", "()V", "onResume", "onPause", "onStop", "onLowMemory", "onDestroy", "outState", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "findLocation", "", "error", "onLocationNotFound", "(Ljava/lang/String;)V", "onClickLocationSnackbar", "onNotPermissionGranted", "onLocationEnabled", "", "d", "Z", "requestLocationWhenItsEnabled", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;", "viewModelFactory", "Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;", "getViewModelFactory", "()Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;", "setViewModelFactory", "(Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;)V", "Lcom/avito/android/messenger/map/viewing/view/PlatformMapView;", "mapView", "Lcom/avito/android/messenger/map/viewing/view/PlatformMapView;", "getMapView", "()Lcom/avito/android/messenger/map/viewing/view/PlatformMapView;", "setMapView", "(Lcom/avito/android/messenger/map/viewing/view/PlatformMapView;)V", "Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;", "locationAnalyticsInteractor", "Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;", "getLocationAnalyticsInteractor", "()Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;", "setLocationAnalyticsInteractor", "(Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;)V", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "Lcom/avito/android/util/ImplicitIntentFactory;", "getImplicitIntentFactory", "()Lcom/avito/android/util/ImplicitIntentFactory;", "setImplicitIntentFactory", "(Lcom/avito/android/util/ImplicitIntentFactory;)V", "Lcom/avito/android/permissions/LocationPermissionDialogPresenter;", "locationPermissionDialogPresenter", "Lcom/avito/android/permissions/LocationPermissionDialogPresenter;", "getLocationPermissionDialogPresenter", "()Lcom/avito/android/permissions/LocationPermissionDialogPresenter;", "setLocationPermissionDialogPresenter", "(Lcom/avito/android/permissions/LocationPermissionDialogPresenter;)V", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "c", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "subscriptions", "Lcom/avito/android/messenger/map/viewing/PlatformMapPresenter;", "presenter", "Lcom/avito/android/messenger/map/viewing/PlatformMapPresenter;", "getPresenter", "()Lcom/avito/android/messenger/map/viewing/PlatformMapPresenter;", "setPresenter", "(Lcom/avito/android/messenger/map/viewing/PlatformMapPresenter;)V", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/util/SchedulersFactory3;", "getSchedulers", "()Lcom/avito/android/util/SchedulersFactory3;", "setSchedulers", "(Lcom/avito/android/util/SchedulersFactory3;)V", "Lcom/avito/android/location/find/FindLocationPresenter;", "findLocationPresenter", "Lcom/avito/android/location/find/FindLocationPresenter;", "getFindLocationPresenter", "()Lcom/avito/android/location/find/FindLocationPresenter;", "setFindLocationPresenter", "(Lcom/avito/android/location/find/FindLocationPresenter;)V", "<init>", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class PlatformMapFragment extends BaseFragment implements OnLocationEnabledListener, LocationPermissionDialogPresenter.Subscriber, LocationPermissionDialogPresenter.Router {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String TAG = "PlatformMapFragment";
    public final CompositeDisposable c = new CompositeDisposable();
    public boolean d;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public FindLocationPresenter findLocationPresenter;
    @Inject
    public ImplicitIntentFactory implicitIntentFactory;
    @Inject
    public LocationAnalyticsInteractor locationAnalyticsInteractor;
    @Inject
    public LocationPermissionDialogPresenter locationPermissionDialogPresenter;
    @Inject
    public PlatformMapView mapView;
    @Inject
    public PlatformMapPresenter presenter;
    @Inject
    public SchedulersFactory3 schedulers;
    @Inject
    public ViewModelFactory viewModelFactory;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J8\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0013\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/avito/android/messenger/map/viewing/PlatformMapFragment$Companion;", "", "", "title", "", "Lcom/avito/android/remote/model/messenger/geo/GeoMarker;", "initialGeoMarkers", "Lcom/avito/android/remote/model/messenger/geo/MarkersRequest;", "markersRequest", "", "lockBottomSheet", "Lcom/avito/android/messenger/map/viewing/PlatformMapFragment;", "invoke", "(Ljava/lang/String;[Lcom/avito/android/remote/model/messenger/geo/GeoMarker;Lcom/avito/android/remote/model/messenger/geo/MarkersRequest;Z)Lcom/avito/android/messenger/map/viewing/PlatformMapFragment;", "INITIAL_GEO_MARKERS_KEY", "Ljava/lang/String;", "LOCK_BOTTOM_SHEET_KEY", "MARKERS_REQUEST_KEY", "TAG", "TITLE_KEY", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {

        public static final class a extends Lambda implements Function1<Bundle, Unit> {
            public final /* synthetic */ String a;
            public final /* synthetic */ GeoMarker[] b;
            public final /* synthetic */ MarkersRequest c;
            public final /* synthetic */ boolean d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str, GeoMarker[] geoMarkerArr, MarkersRequest markersRequest, boolean z) {
                super(1);
                this.a = str;
                this.b = geoMarkerArr;
                this.c = markersRequest;
                this.d = z;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Bundle bundle) {
                Bundle bundle2 = bundle;
                Intrinsics.checkNotNullParameter(bundle2, "$receiver");
                bundle2.putString("title", this.a);
                bundle2.putParcelableArray("initial_pins", this.b);
                MarkersRequest markersRequest = this.c;
                if (markersRequest != null) {
                    bundle2.putParcelable("markers_request", markersRequest);
                }
                bundle2.putBoolean("lock_bottom_sheet", this.d);
                return Unit.INSTANCE;
            }
        }

        public Companion() {
        }

        @NotNull
        public final PlatformMapFragment invoke(@NotNull String str, @NotNull GeoMarker[] geoMarkerArr, @Nullable MarkersRequest markersRequest, boolean z) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(geoMarkerArr, "initialGeoMarkers");
            return (PlatformMapFragment) FragmentsKt.arguments(new PlatformMapFragment(), 3, new a(str, geoMarkerArr, markersRequest, z));
        }

        public Companion(j jVar) {
        }
    }

    public static final String access$getPage(PlatformMapFragment platformMapFragment) {
        String str;
        Bundle arguments = platformMapFragment.getArguments();
        if (arguments != null) {
            if (arguments.getBoolean("lock_bottom_sheet", false)) {
                str = FindLocationPage.PLATFORM_MAP.getValue();
            } else {
                str = FindLocationPage.PVZ_MAP.getValue();
            }
            if (str != null) {
                return str;
            }
        }
        return FindLocationPage.PVZ_MAP.getValue();
    }

    public static final void access$requestLocation(PlatformMapFragment platformMapFragment) {
        FindLocationPresenter findLocationPresenter2 = platformMapFragment.getFindLocationPresenter();
        FragmentActivity requireActivity = platformMapFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        Disposable subscribe = FindLocationPresenter.DefaultImpls.findLocation$default(findLocationPresenter2, requireActivity, false, 2, null).subscribe(new Consumer<Location>() { // from class: com.avito.android.messenger.map.viewing.PlatformMapFragment$requestLocation$1
            public final void accept(Location location) {
                LocationAnalyticsInteractor.DefaultImpls.trackResolveCoordinates$default(PlatformMapFragment.this.getLocationAnalyticsInteractor(), location, null, 2, null);
                PlatformMapPresenter presenter2 = PlatformMapFragment.this.getPresenter();
                Intrinsics.checkNotNullExpressionValue(location, "userLocation");
                presenter2.userLocationChanged(new AvitoMapPoint(location.getLatitude(), location.getLongitude()));
            }
        }, new Consumer<Throwable>() { // from class: com.avito.android.messenger.map.viewing.PlatformMapFragment$requestLocation$2
            public final void accept(Throwable th) {
                PlatformMapFragment.this.getLocationAnalyticsInteractor().trackResolveCoordinates(null, th.getMessage());
                Logs.error(th);
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "findLocationPresenter.fi…ror(error)\n            })");
        DisposableKt.addTo(subscribe, platformMapFragment.c);
    }

    public static final void access$subscribeFindLocation(PlatformMapFragment platformMapFragment) {
        LocationPermissionDialogPresenter locationPermissionDialogPresenter2 = platformMapFragment.locationPermissionDialogPresenter;
        if (locationPermissionDialogPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationPermissionDialogPresenter");
        }
        DisposableKt.addTo(locationPermissionDialogPresenter2.subscriberChangeLocation(), platformMapFragment.c);
    }

    @Override // com.avito.android.permissions.LocationPermissionDialogPresenter.Router
    public void findLocation() {
        PlatformMapPresenter platformMapPresenter = this.presenter;
        if (platformMapPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        platformMapPresenter.myLocationButtonClicked();
    }

    @NotNull
    public final DeepLinkIntentFactory getDeepLinkIntentFactory() {
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        return deepLinkIntentFactory2;
    }

    @NotNull
    public final FindLocationPresenter getFindLocationPresenter() {
        FindLocationPresenter findLocationPresenter2 = this.findLocationPresenter;
        if (findLocationPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("findLocationPresenter");
        }
        return findLocationPresenter2;
    }

    @NotNull
    public final ImplicitIntentFactory getImplicitIntentFactory() {
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        return implicitIntentFactory2;
    }

    @NotNull
    public final LocationAnalyticsInteractor getLocationAnalyticsInteractor() {
        LocationAnalyticsInteractor locationAnalyticsInteractor2 = this.locationAnalyticsInteractor;
        if (locationAnalyticsInteractor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationAnalyticsInteractor");
        }
        return locationAnalyticsInteractor2;
    }

    @NotNull
    public final LocationPermissionDialogPresenter getLocationPermissionDialogPresenter() {
        LocationPermissionDialogPresenter locationPermissionDialogPresenter2 = this.locationPermissionDialogPresenter;
        if (locationPermissionDialogPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationPermissionDialogPresenter");
        }
        return locationPermissionDialogPresenter2;
    }

    @NotNull
    public final PlatformMapView getMapView() {
        PlatformMapView platformMapView = this.mapView;
        if (platformMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapView");
        }
        return platformMapView;
    }

    @NotNull
    public final PlatformMapPresenter getPresenter() {
        PlatformMapPresenter platformMapPresenter = this.presenter;
        if (platformMapPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return platformMapPresenter;
    }

    @NotNull
    public final SchedulersFactory3 getSchedulers() {
        SchedulersFactory3 schedulersFactory3 = this.schedulers;
        if (schedulersFactory3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schedulers");
        }
        return schedulersFactory3;
    }

    @NotNull
    public final ViewModelFactory getViewModelFactory() {
        ViewModelFactory viewModelFactory2 = this.viewModelFactory;
        if (viewModelFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        return viewModelFactory2;
    }

    @Override // com.avito.android.permissions.LocationPermissionDialogPresenter.Subscriber
    public void onClickLocationSnackbar() {
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        startActivity(implicitIntentFactory2.createAppSettingsIntent());
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.messenger_platform_map_fragment, viewGroup, false);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        return (ViewGroup) inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        PlatformMapView platformMapView = this.mapView;
        if (platformMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapView");
        }
        platformMapView.onDestroy();
        super.onDestroy();
    }

    @Override // com.avito.android.messenger.map.OnLocationEnabledListener
    public void onLocationEnabled() {
        if (this.d) {
            Logs.verbose$default(TAG, "onLocationEnabled() && requestLocationWhenItsEnabled == true => presenter.myLocationButtonClicked()", null, 4, null);
            PlatformMapPresenter platformMapPresenter = this.presenter;
            if (platformMapPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            platformMapPresenter.myLocationButtonClicked();
            this.d = false;
            return;
        }
        Logs.verbose$default(TAG, "onLocationEnabled() && requestLocationWhenItsEnabled == false => do nothing", null, 4, null);
    }

    @Override // com.avito.android.permissions.LocationPermissionDialogPresenter.Subscriber
    public void onLocationNotFound(@Nullable String str) {
        if (str != null) {
            LocationAnalyticsInteractor locationAnalyticsInteractor2 = this.locationAnalyticsInteractor;
            if (locationAnalyticsInteractor2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("locationAnalyticsInteractor");
            }
            locationAnalyticsInteractor2.trackResolveCoordinates(null, str);
        }
        PlatformMapView platformMapView = this.mapView;
        if (platformMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapView");
        }
        platformMapView.showFindLocationError();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        PlatformMapView platformMapView = this.mapView;
        if (platformMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapView");
        }
        platformMapView.onLowMemory();
    }

    @Override // com.avito.android.permissions.LocationPermissionDialogPresenter.Subscriber
    public void onNotPermissionGranted() {
        LocationAnalyticsInteractor locationAnalyticsInteractor2 = this.locationAnalyticsInteractor;
        if (locationAnalyticsInteractor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationAnalyticsInteractor");
        }
        locationAnalyticsInteractor2.trackResolveCoordinates(null, "PERMISSION DENIED");
        View view = getView();
        if (view != null) {
            LocationPermissionDialogPresenter locationPermissionDialogPresenter2 = this.locationPermissionDialogPresenter;
            if (locationPermissionDialogPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("locationPermissionDialogPresenter");
            }
            Intrinsics.checkNotNullExpressionValue(view, "it");
            DisposableKt.addTo(locationPermissionDialogPresenter2.subscriberNotPermissionGranted(view), this.c);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        LocationAnalyticsInteractor locationAnalyticsInteractor2 = this.locationAnalyticsInteractor;
        if (locationAnalyticsInteractor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationAnalyticsInteractor");
        }
        locationAnalyticsInteractor2.trackScreenExitAfterCoordinatesResolve();
        FindLocationPresenter findLocationPresenter2 = this.findLocationPresenter;
        if (findLocationPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("findLocationPresenter");
        }
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        findLocationPresenter2.unregisterLocationReceiver(requireContext);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        FindLocationPresenter findLocationPresenter2 = this.findLocationPresenter;
        if (findLocationPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("findLocationPresenter");
        }
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        findLocationPresenter2.registerLocationReceiver(requireContext);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        bundle.putBoolean("request_location_when_its_enabled", this.d);
        super.onSaveInstanceState(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        getPresenter().getCreateRouteClicksStream().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.messenger.map.viewing.PlatformMapFragment$setupSubscriptions$$inlined$observeNotNull$1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    T t2 = t;
                    FragmentActivity activity = PlatformMapFragment.this.getActivity();
                    if (activity != null) {
                        Intent mapsApplicationsIntent = PlatformMapFragment.this.getImplicitIntentFactory().mapsApplicationsIntent(t2);
                        if (mapsApplicationsIntent.resolveActivity(activity.getPackageManager()) != null) {
                            activity.startActivity(mapsApplicationsIntent);
                        } else {
                            ToastsKt.showToast$default(activity, R.string.messenger_platform_map_map_apps_not_found, 0, 2, (Object) null);
                        }
                    }
                }
            }
        });
        getPresenter().getGeoMarkersLoadingErrorsStream().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.messenger.map.viewing.PlatformMapFragment$setupSubscriptions$$inlined$observeNotNull$2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    T t2 = t;
                    FragmentActivity activity = PlatformMapFragment.this.getActivity();
                    if (activity != null) {
                        ToastsKt.showToast$default(activity, t2, 0, 2, (Object) null);
                    }
                }
            }
        });
        getPresenter().getDeepLinkClicksStream().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.messenger.map.viewing.PlatformMapFragment$setupSubscriptions$$inlined$observeNotNull$3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    T t2 = t;
                    Logs.verbose$default(PlatformMapFragment.TAG, "deepLinkClicksStream got " + ((Object) t2), null, 4, null);
                    Intent intent = PlatformMapFragment.this.getDeepLinkIntentFactory().getIntent(t2);
                    if (intent != null) {
                        Logs.verbose$default(PlatformMapFragment.TAG, "deepLinkIntentFactory returned Intent for " + ((Object) t2) + " => startActivitySafely()", null, 4, null);
                        FragmentsKt.startActivitySafely(PlatformMapFragment.this, intent);
                        return;
                    }
                    Logs.verbose$default(PlatformMapFragment.TAG, "deepLinkIntentFactory returned NULL for " + ((Object) t2) + " => do nothing", null, 4, null);
                }
            }
        });
        getPresenter().getRequestLocationStream().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.messenger.map.viewing.PlatformMapFragment$setupSubscriptions$$inlined$observeNotNull$4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    PlatformMapFragment platformMapFragment = PlatformMapFragment.this;
                    FindLocationPresenter findLocationPresenter2 = platformMapFragment.getFindLocationPresenter();
                    FragmentActivity requireActivity = platformMapFragment.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                    Disposable subscribe = FindLocationPresenter.DefaultImpls.findLocation$default(findLocationPresenter2, requireActivity, false, 2, null).subscribe(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0024: INVOKE  (r0v2 'subscribe' io.reactivex.rxjava3.disposables.Disposable) = 
                          (wrap: io.reactivex.rxjava3.core.Observable : 0x0016: INVOKE  (r0v1 io.reactivex.rxjava3.core.Observable) = 
                          (r0v0 'findLocationPresenter2' com.avito.android.location.find.FindLocationPresenter)
                          (r1v0 'requireActivity' androidx.fragment.app.FragmentActivity)
                          false
                          (2 int)
                          (null java.lang.Object)
                         type: STATIC call: com.avito.android.location.find.FindLocationPresenter.DefaultImpls.findLocation$default(com.avito.android.location.find.FindLocationPresenter, android.app.Activity, boolean, int, java.lang.Object):io.reactivex.rxjava3.core.Observable)
                          (wrap: com.avito.android.messenger.map.viewing.PlatformMapFragment$setupSubscriptions$$inlined$observeNotNull$4$lambda$1 : 0x001c: CONSTRUCTOR  (r1v1 com.avito.android.messenger.map.viewing.PlatformMapFragment$setupSubscriptions$$inlined$observeNotNull$4$lambda$1) = (r6v2 'platformMapFragment' com.avito.android.messenger.map.viewing.PlatformMapFragment) call: com.avito.android.messenger.map.viewing.PlatformMapFragment$setupSubscriptions$$inlined$observeNotNull$4$lambda$1.<init>(com.avito.android.messenger.map.viewing.PlatformMapFragment):void type: CONSTRUCTOR)
                          (wrap: com.avito.android.messenger.map.viewing.PlatformMapFragment$setupSubscriptions$$inlined$observeNotNull$4$lambda$2 : 0x0021: CONSTRUCTOR  (r2v2 com.avito.android.messenger.map.viewing.PlatformMapFragment$setupSubscriptions$$inlined$observeNotNull$4$lambda$2) = (r6v2 'platformMapFragment' com.avito.android.messenger.map.viewing.PlatformMapFragment) call: com.avito.android.messenger.map.viewing.PlatformMapFragment$setupSubscriptions$$inlined$observeNotNull$4$lambda$2.<init>(com.avito.android.messenger.map.viewing.PlatformMapFragment):void type: CONSTRUCTOR)
                         type: VIRTUAL call: io.reactivex.rxjava3.core.Observable.subscribe(io.reactivex.rxjava3.functions.Consumer, io.reactivex.rxjava3.functions.Consumer):io.reactivex.rxjava3.disposables.Disposable in method: com.avito.android.messenger.map.viewing.PlatformMapFragment$setupSubscriptions$$inlined$observeNotNull$4.onChanged(T):void, file: classes3.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:245)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:104)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
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
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:345)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:298)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:267)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001c: CONSTRUCTOR  (r1v1 com.avito.android.messenger.map.viewing.PlatformMapFragment$setupSubscriptions$$inlined$observeNotNull$4$lambda$1) = (r6v2 'platformMapFragment' com.avito.android.messenger.map.viewing.PlatformMapFragment) call: com.avito.android.messenger.map.viewing.PlatformMapFragment$setupSubscriptions$$inlined$observeNotNull$4$lambda$1.<init>(com.avito.android.messenger.map.viewing.PlatformMapFragment):void type: CONSTRUCTOR in method: com.avito.android.messenger.map.viewing.PlatformMapFragment$setupSubscriptions$$inlined$observeNotNull$4.onChanged(T):void, file: classes3.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:955)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:780)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:394)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:275)
                        	... 23 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.avito.android.messenger.map.viewing.PlatformMapFragment$setupSubscriptions$$inlined$observeNotNull$4$lambda$1, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:212)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:657)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                        	... 29 more
                        */
                    /*
                        this = this;
                        if (r6 == 0) goto L_0x0034
                        kotlin.Unit r6 = (kotlin.Unit) r6
                        com.avito.android.messenger.map.viewing.PlatformMapFragment r6 = com.avito.android.messenger.map.viewing.PlatformMapFragment.this
                        com.avito.android.location.find.FindLocationPresenter r0 = r6.getFindLocationPresenter()
                        androidx.fragment.app.FragmentActivity r1 = r6.requireActivity()
                        java.lang.String r2 = "requireActivity()"
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
                        r2 = 0
                        r3 = 2
                        r4 = 0
                        io.reactivex.rxjava3.core.Observable r0 = com.avito.android.location.find.FindLocationPresenter.DefaultImpls.findLocation$default(r0, r1, r2, r3, r4)
                        com.avito.android.messenger.map.viewing.PlatformMapFragment$setupSubscriptions$$inlined$observeNotNull$4$lambda$1 r1 = new com.avito.android.messenger.map.viewing.PlatformMapFragment$setupSubscriptions$$inlined$observeNotNull$4$lambda$1
                        r1.<init>(r6)
                        com.avito.android.messenger.map.viewing.PlatformMapFragment$setupSubscriptions$$inlined$observeNotNull$4$lambda$2 r2 = new com.avito.android.messenger.map.viewing.PlatformMapFragment$setupSubscriptions$$inlined$observeNotNull$4$lambda$2
                        r2.<init>(r6)
                        io.reactivex.rxjava3.disposables.Disposable r0 = r0.subscribe(r1, r2)
                        java.lang.String r1 = "findLocationPresenter.fi…ror(error)\n            })"
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                        io.reactivex.rxjava3.disposables.CompositeDisposable r6 = com.avito.android.messenger.map.viewing.PlatformMapFragment.access$getSubscriptions$p(r6)
                        io.reactivex.rxjava3.kotlin.DisposableKt.addTo(r0, r6)
                    L_0x0034:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.map.viewing.PlatformMapFragment$setupSubscriptions$$inlined$observeNotNull$4.onChanged(java.lang.Object):void");
                }
            });
            Disposable subscribe = getMapView().getMapIsReady().observeOn(getSchedulers().mainThread()).filter(PlatformMapFragment$setupSubscriptions$5.INSTANCE).take(1).concatMap(new Function<Boolean, ObservableSource<? extends PlatformMapView.State>>() { // from class: com.avito.android.messenger.map.viewing.PlatformMapFragment$setupSubscriptions$6
                public final ObservableSource<? extends PlatformMapView.State> apply(Boolean bool) {
                    return InteropKt.toV3(PlatformMapFragment.this.getPresenter().getStateObservable());
                }
            }).observeOn(getSchedulers().mainThread()).subscribeOn(getSchedulers().mainThread()).subscribe(new Consumer<PlatformMapView.State>() { // from class: com.avito.android.messenger.map.viewing.PlatformMapFragment$setupSubscriptions$7
                public final void accept(PlatformMapView.State state) {
                    PlatformMapView mapView2 = PlatformMapFragment.this.getMapView();
                    Intrinsics.checkNotNullExpressionValue(state, "state");
                    mapView2.render(state);
                    StringBuilder sb = new StringBuilder();
                    StringBuilder I = a.I('[');
                    Thread currentThread = Thread.currentThread();
                    Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
                    I.append(currentThread.getName());
                    I.append(']');
                    sb.append(I.toString());
                    sb.append(" Rendered ");
                    sb.append(state);
                    Logs.info$default(PlatformMapFragment.TAG, sb.toString(), null, 4, null);
                }
            });
            Intrinsics.checkNotNullExpressionValue(subscribe, "mapView.mapIsReady\n     …ed $state\")\n            }");
            DisposableKt.addTo(subscribe, this.c);
            Disposable subscribe2 = getMapView().getPinClicks().observeOn(getSchedulers().mainThread()).subscribe(new Consumer<Pin>() { // from class: com.avito.android.messenger.map.viewing.PlatformMapFragment$setupSubscriptions$8
                public final void accept(Pin pin) {
                    PlatformMapPresenter presenter2 = PlatformMapFragment.this.getPresenter();
                    Intrinsics.checkNotNullExpressionValue(pin, "clickedPin");
                    presenter2.pinClicked(pin);
                }
            });
            Intrinsics.checkNotNullExpressionValue(subscribe2, "mapView.pinClicks\n      …clickedPin)\n            }");
            DisposableKt.addTo(subscribe2, this.c);
            Disposable subscribe3 = getMapView().getCameraDraggingStartedStream().observeOn(getSchedulers().mainThread()).subscribe(new Consumer<Unit>() { // from class: com.avito.android.messenger.map.viewing.PlatformMapFragment$setupSubscriptions$9
                public final void accept(Unit unit) {
                    PlatformMapFragment.this.getPresenter().cameraDraggingStarted();
                }
            });
            Intrinsics.checkNotNullExpressionValue(subscribe3, "mapView.cameraDraggingSt…ngStarted()\n            }");
            DisposableKt.addTo(subscribe3, this.c);
            Disposable subscribe4 = getMapView().getCameraPosition().observeOn(getSchedulers().mainThread()).subscribe(new Consumer<AvitoMapCameraPosition>() { // from class: com.avito.android.messenger.map.viewing.PlatformMapFragment$setupSubscriptions$10
                public final void accept(AvitoMapCameraPosition avitoMapCameraPosition) {
                    PlatformMapPresenter presenter2 = PlatformMapFragment.this.getPresenter();
                    Intrinsics.checkNotNullExpressionValue(avitoMapCameraPosition, "newCameraPosition");
                    presenter2.cameraPositionChanged(avitoMapCameraPosition, false);
                }
            });
            Intrinsics.checkNotNullExpressionValue(subscribe4, "mapView.cameraPosition\n …on = false)\n            }");
            DisposableKt.addTo(subscribe4, this.c);
            Observable<Unit> findLocationClicks = getMapView().getFindLocationClicks();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            Disposable subscribe5 = findLocationClicks.throttleFirst(300, timeUnit).observeOn(getSchedulers().mainThread()).subscribe(new Consumer<Unit>() { // from class: com.avito.android.messenger.map.viewing.PlatformMapFragment$setupSubscriptions$11
                public final void accept(Unit unit) {
                    PlatformMapFragment.this.getLocationAnalyticsInteractor().trackFindCoordinates(PlatformMapFragment.access$getPage(PlatformMapFragment.this));
                    PlatformMapFragment.access$subscribeFindLocation(PlatformMapFragment.this);
                }
            }, new Consumer<Throwable>() { // from class: com.avito.android.messenger.map.viewing.PlatformMapFragment$setupSubscriptions$12
                public final void accept(Throwable th) {
                    PlatformMapFragment.this.getLocationAnalyticsInteractor().trackResolveCoordinates(null, th.getMessage());
                    Logs.error$default(SharingMapFragment.TAG, "mapView.locationFabClicks subscription in PlatformMapFragment encountered error: " + th, null, 4, null);
                }
            });
            Intrinsics.checkNotNullExpressionValue(subscribe5, "mapView.findLocationClic…         )\n            })");
            DisposableKt.addTo(subscribe5, this.c);
            Disposable subscribe6 = getMapView().getCreateRouteButtonClicks().throttleFirst(300, timeUnit).observeOn(getSchedulers().mainThread()).subscribe(new Consumer<Unit>() { // from class: com.avito.android.messenger.map.viewing.PlatformMapFragment$setupSubscriptions$13
                public final void accept(Unit unit) {
                    PlatformMapFragment.this.getPresenter().createRouteButtonClicked();
                }
            });
            Intrinsics.checkNotNullExpressionValue(subscribe6, "mapView.createRouteButto…onClicked()\n            }");
            DisposableKt.addTo(subscribe6, this.c);
            Disposable subscribe7 = getMapView().getBottomSheetVisibilityStream().distinctUntilChanged().subscribe(new Consumer<BottomSheet.Visibility>() { // from class: com.avito.android.messenger.map.viewing.PlatformMapFragment$setupSubscriptions$14
                public final void accept(BottomSheet.Visibility visibility) {
                    PlatformMapPresenter presenter2 = PlatformMapFragment.this.getPresenter();
                    Intrinsics.checkNotNullExpressionValue(visibility, ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY);
                    presenter2.bottomSheetVisibilityChanged(visibility);
                }
            });
            Intrinsics.checkNotNullExpressionValue(subscribe7, "mapView.bottomSheetVisib…visibility)\n            }");
            DisposableKt.addTo(subscribe7, this.c);
            PlatformMapView platformMapView = this.mapView;
            if (platformMapView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mapView");
            }
            platformMapView.onStart();
        }

        @Override // androidx.fragment.app.Fragment
        public void onStop() {
            LocationPermissionDialogPresenter locationPermissionDialogPresenter2 = this.locationPermissionDialogPresenter;
            if (locationPermissionDialogPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("locationPermissionDialogPresenter");
            }
            locationPermissionDialogPresenter2.detachRouter();
            LocationPermissionDialogPresenter locationPermissionDialogPresenter3 = this.locationPermissionDialogPresenter;
            if (locationPermissionDialogPresenter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("locationPermissionDialogPresenter");
            }
            locationPermissionDialogPresenter3.detachSubscriber();
            this.c.clear();
            PlatformMapView platformMapView = this.mapView;
            if (platformMapView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mapView");
            }
            platformMapView.onStop();
            super.onStop();
        }

        @Override // androidx.fragment.app.Fragment
        public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
            String str;
            Intrinsics.checkNotNullParameter(view, "view");
            super.onViewCreated(view, bundle);
            Bundle arguments = getArguments();
            if (arguments == null || (str = arguments.getString("title")) == null) {
                str = "";
            }
            Intrinsics.checkNotNullExpressionValue(str, "arguments?.getString(TITLE_KEY) ?: \"\"");
            Bundle arguments2 = getArguments();
            MarkersRequest markersRequest = null;
            Parcelable[] parcelableArray = arguments2 != null ? arguments2.getParcelableArray("initial_pins") : null;
            if (!(parcelableArray instanceof Parcelable[])) {
                parcelableArray = null;
            }
            boolean z = false;
            if (parcelableArray == null) {
                parcelableArray = new Parcelable[0];
            }
            Bundle arguments3 = getArguments();
            MarkersRequest markersRequest2 = arguments3 != null ? (MarkersRequest) arguments3.getParcelable("markers_request") : null;
            if (markersRequest2 instanceof MarkersRequest) {
                markersRequest = markersRequest2;
            }
            Bundle arguments4 = getArguments();
            boolean z2 = arguments4 != null ? arguments4.getBoolean("lock_bottom_sheet", false) : false;
            int length = parcelableArray.length;
            GeoMarker[] geoMarkerArr = new GeoMarker[length];
            for (int i = 0; i < length; i++) {
                Parcelable parcelable = parcelableArray[i];
                Objects.requireNonNull(parcelable, "null cannot be cast to non-null type com.avito.android.remote.model.messenger.geo.GeoMarker");
                geoMarkerArr[i] = (GeoMarker) parcelable;
            }
            View findViewById = view.findViewById(R.id.toolbar);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
            setSupportActionBar((Toolbar) findViewById);
            ActionBarUtils.INSTANCE.setActionBarTitle(FragmentsKt.getSupportActionBar(this), str);
            FragmentsKt.getSupportActionBar(this).setHomeAsUpIndicator(com.avito.android.ui_components.R.drawable.ic_close_24);
            PlatformMapFragmentComponent.Builder withFragment = DaggerPlatformMapFragmentComponent.builder().platformMapFragmentDependencies((PlatformMapFragmentDependencies) ComponentDependenciesKt.getDependencies(PlatformMapFragmentDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).withFragment(this);
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            PlatformMapFragmentComponent.Builder withActivity = withFragment.withActivity(requireActivity);
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "this.parentFragmentManager");
            PlatformMapFragmentComponent.Builder withFragmentManager = withActivity.withFragmentManager(parentFragmentManager);
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            withFragmentManager.withResources(resources).withFragmentRootView(view).withInitialGeoMarkers(geoMarkerArr).withMarkersRequest(markersRequest).withLockBottomSheet(z2).build().inject(this);
            if (bundle != null) {
                z = bundle.getBoolean("request_location_when_its_enabled");
            }
            this.d = z;
            LocationPermissionDialogPresenter locationPermissionDialogPresenter2 = this.locationPermissionDialogPresenter;
            if (locationPermissionDialogPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("locationPermissionDialogPresenter");
            }
            locationPermissionDialogPresenter2.attachRouter(this);
            LocationPermissionDialogPresenter locationPermissionDialogPresenter3 = this.locationPermissionDialogPresenter;
            if (locationPermissionDialogPresenter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("locationPermissionDialogPresenter");
            }
            locationPermissionDialogPresenter3.setSubscriber(this);
        }

        public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
            Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
            this.deepLinkIntentFactory = deepLinkIntentFactory2;
        }

        public final void setFindLocationPresenter(@NotNull FindLocationPresenter findLocationPresenter2) {
            Intrinsics.checkNotNullParameter(findLocationPresenter2, "<set-?>");
            this.findLocationPresenter = findLocationPresenter2;
        }

        public final void setImplicitIntentFactory(@NotNull ImplicitIntentFactory implicitIntentFactory2) {
            Intrinsics.checkNotNullParameter(implicitIntentFactory2, "<set-?>");
            this.implicitIntentFactory = implicitIntentFactory2;
        }

        public final void setLocationAnalyticsInteractor(@NotNull LocationAnalyticsInteractor locationAnalyticsInteractor2) {
            Intrinsics.checkNotNullParameter(locationAnalyticsInteractor2, "<set-?>");
            this.locationAnalyticsInteractor = locationAnalyticsInteractor2;
        }

        public final void setLocationPermissionDialogPresenter(@NotNull LocationPermissionDialogPresenter locationPermissionDialogPresenter2) {
            Intrinsics.checkNotNullParameter(locationPermissionDialogPresenter2, "<set-?>");
            this.locationPermissionDialogPresenter = locationPermissionDialogPresenter2;
        }

        public final void setMapView(@NotNull PlatformMapView platformMapView) {
            Intrinsics.checkNotNullParameter(platformMapView, "<set-?>");
            this.mapView = platformMapView;
        }

        public final void setPresenter(@NotNull PlatformMapPresenter platformMapPresenter) {
            Intrinsics.checkNotNullParameter(platformMapPresenter, "<set-?>");
            this.presenter = platformMapPresenter;
        }

        public final void setSchedulers(@NotNull SchedulersFactory3 schedulersFactory3) {
            Intrinsics.checkNotNullParameter(schedulersFactory3, "<set-?>");
            this.schedulers = schedulersFactory3;
        }

        public final void setViewModelFactory(@NotNull ViewModelFactory viewModelFactory2) {
            Intrinsics.checkNotNullParameter(viewModelFactory2, "<set-?>");
            this.viewModelFactory = viewModelFactory2;
        }
    }

package com.avito.android.messenger.map.sharing;

import a2.b.a.a.a;
import a2.g.r.g;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.avito_map.AvitoMapAttachHelper;
import com.avito.android.avito_map.AvitoMapCameraPosition;
import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.avito_map.google.GoogleAvitoMapAttachHelper;
import com.avito.android.avito_map.yandex.YandexAvitoMapAttachHelper;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.location.analytics.FindLocationPage;
import com.avito.android.location.analytics.LocationAnalyticsInteractor;
import com.avito.android.location.find.FindLocationPresenter;
import com.avito.android.messenger.R;
import com.avito.android.messenger.analytics.MessengerGeoMyLocationClick;
import com.avito.android.messenger.analytics.MessengerGeoSearchLocationClick;
import com.avito.android.messenger.map.OnLocationEnabledListener;
import com.avito.android.messenger.map.search.GeoSearchFragmentKt;
import com.avito.android.messenger.map.sharing.SharingMapView;
import com.avito.android.messenger.map.sharing.di.DaggerSharingMapFragmentComponent;
import com.avito.android.messenger.map.sharing.di.SharingMapFragmentComponent;
import com.avito.android.messenger.map.sharing.di.SharingMapFragmentDependencies;
import com.avito.android.messenger.map.sharing.di.SharingMapFragmentModule;
import com.avito.android.permissions.LocationPermissionDialogPresenter;
import com.avito.android.remote.model.messenger.geo.GeoPoint;
import com.avito.android.remote.model.messenger.geo.GeoSearchSuggest;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.util.ActionBarUtils;
import com.avito.android.util.FragmentsKt;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.rx3.InteropKt;
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
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.c;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002\u0001B\b¢\u0006\u0005\b\u0001\u0010\u0018J-\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0019\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001a\u0010\u0018J\u000f\u0010\u001b\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001b\u0010\u0018J\u000f\u0010\u001c\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001c\u0010\u0018J\u000f\u0010\u001d\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001d\u0010\u0018J\u0017\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u000fH\u0016¢\u0006\u0004\b!\u0010\u0018J\u000f\u0010\"\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\"\u0010\u0018J\u0019\u0010%\u001a\u00020\u000f2\b\u0010$\u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u000fH\u0016¢\u0006\u0004\b'\u0010\u0018J\u0017\u0010+\u001a\u00020*2\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b+\u0010,J)\u00102\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020-2\b\u00101\u001a\u0004\u0018\u000100H\u0016¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u000fH\u0016¢\u0006\u0004\b4\u0010\u0018R\"\u00106\u001a\u0002058\u0006@\u0006X.¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\"\u0010A\u001a\u00020@8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010H\u001a\u00020G8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\"\u0010O\u001a\u00020N8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u0018\u0010X\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\"\u0010Z\u001a\u00020Y8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u0018\u0010c\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\ba\u0010bR\u001d\u0010i\u001a\u00020d8B@\u0002X\u0002¢\u0006\f\n\u0004\be\u0010f\u001a\u0004\bg\u0010hR\"\u0010k\u001a\u00020j8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bk\u0010l\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\u0016\u0010s\u001a\u00020#8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bq\u0010rR\u0016\u0010v\u001a\u00020*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bt\u0010uR\u0016\u0010z\u001a\u00020w8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bx\u0010yR$\u0010|\u001a\u00020{8\u0006@\u0006X.¢\u0006\u0014\n\u0004\b|\u0010}\u001a\u0004\b~\u0010\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/avito/android/messenger/map/sharing/SharingMapFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Lcom/avito/android/messenger/map/OnLocationEnabledListener;", "Lcom/avito/android/permissions/LocationPermissionDialogPresenter$Subscriber;", "Lcom/avito/android/permissions/LocationPermissionDialogPresenter$Router;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/view/Menu;", "menu", "Landroid/view/MenuInflater;", "onCreateOptionsMenu", "(Landroid/view/Menu;Landroid/view/MenuInflater;)V", "onStart", "()V", "onResume", "onPause", "onStop", "onLowMemory", "onDestroy", "outState", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "findLocation", "onClickLocationSnackbar", "", "error", "onLocationNotFound", "(Ljava/lang/String;)V", "onNotPermissionGranted", "Landroid/view/MenuItem;", "item", "", "onOptionsItemSelected", "(Landroid/view/MenuItem;)Z", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onLocationEnabled", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "d", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "subscriptions", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "Lcom/avito/android/util/ImplicitIntentFactory;", "getImplicitIntentFactory", "()Lcom/avito/android/util/ImplicitIntentFactory;", "setImplicitIntentFactory", "(Lcom/avito/android/util/ImplicitIntentFactory;)V", "Lcom/avito/android/permissions/LocationPermissionDialogPresenter;", "locationPermissionDialogPresenter", "Lcom/avito/android/permissions/LocationPermissionDialogPresenter;", "getLocationPermissionDialogPresenter", "()Lcom/avito/android/permissions/LocationPermissionDialogPresenter;", "setLocationPermissionDialogPresenter", "(Lcom/avito/android/permissions/LocationPermissionDialogPresenter;)V", "Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;", "locationAnalyticsInteractor", "Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;", "getLocationAnalyticsInteractor", "()Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;", "setLocationAnalyticsInteractor", "(Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;)V", "Lcom/avito/android/avito_map/AvitoMapPoint;", g.a, "Lcom/avito/android/avito_map/AvitoMapPoint;", "centerPoint", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;", "f", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;", "initialPositionFromBundle", "Lcom/avito/android/avito_map/AvitoMapAttachHelper;", "h", "Lkotlin/Lazy;", "getAvitoMapAttachHelper", "()Lcom/avito/android/avito_map/AvitoMapAttachHelper;", "avitoMapAttachHelper", "Lcom/avito/android/location/find/FindLocationPresenter;", "findLocationPresenter", "Lcom/avito/android/location/find/FindLocationPresenter;", "getFindLocationPresenter", "()Lcom/avito/android/location/find/FindLocationPresenter;", "setFindLocationPresenter", "(Lcom/avito/android/location/find/FindLocationPresenter;)V", "e", "Ljava/lang/String;", "channelId", "i", "Z", "requestLocationWhenItsEnabled", "Lcom/avito/android/messenger/map/sharing/SharingMapView;", "c", "Lcom/avito/android/messenger/map/sharing/SharingMapView;", "mapView", "Lcom/avito/android/messenger/map/sharing/SharingMapPresenter;", "presenter", "Lcom/avito/android/messenger/map/sharing/SharingMapPresenter;", "getPresenter", "()Lcom/avito/android/messenger/map/sharing/SharingMapPresenter;", "setPresenter", "(Lcom/avito/android/messenger/map/sharing/SharingMapPresenter;)V", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/util/SchedulersFactory3;", "getSchedulers", "()Lcom/avito/android/util/SchedulersFactory3;", "setSchedulers", "(Lcom/avito/android/util/SchedulersFactory3;)V", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "<init>", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class SharingMapFragment extends BaseFragment implements OnLocationEnabledListener, LocationPermissionDialogPresenter.Subscriber, LocationPermissionDialogPresenter.Router {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String TAG = "SharingMapFragment";
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public Analytics analytics;
    public SharingMapView c;
    public final CompositeDisposable d = new CompositeDisposable();
    public String e;
    public MessageBody.Location f;
    @Inject
    public Features features;
    @Inject
    public FindLocationPresenter findLocationPresenter;
    public AvitoMapPoint g;
    public final Lazy h = c.lazy(new a(this));
    public boolean i;
    @Inject
    public ImplicitIntentFactory implicitIntentFactory;
    @Inject
    public LocationAnalyticsInteractor locationAnalyticsInteractor;
    @Inject
    public LocationPermissionDialogPresenter locationPermissionDialogPresenter;
    @Inject
    public SharingMapPresenter presenter;
    @Inject
    public SchedulersFactory3 schedulers;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\"\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0016\u0010\f\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\f\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/avito/android/messenger/map/sharing/SharingMapFragment$Companion;", "", "", "channelId", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;", "initialPosition", "Lcom/avito/android/messenger/map/sharing/SharingMapFragment;", "invoke", "(Ljava/lang/String;Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;)Lcom/avito/android/messenger/map/sharing/SharingMapFragment;", "KEY_CHANNEL_ID", "Ljava/lang/String;", "KEY_INITIAL_POSITION", "TAG", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {

        public static final class a extends Lambda implements Function1<Bundle, Unit> {
            public final /* synthetic */ String a;
            public final /* synthetic */ MessageBody.Location b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str, MessageBody.Location location) {
                super(1);
                this.a = str;
                this.b = location;
            }

            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Bundle bundle) {
                Bundle bundle2 = bundle;
                Intrinsics.checkNotNullParameter(bundle2, "$receiver");
                bundle2.putString("channel_id", this.a);
                bundle2.putParcelable("initial_position", this.b);
                return Unit.INSTANCE;
            }
        }

        public Companion() {
        }

        @NotNull
        public final SharingMapFragment invoke(@NotNull String str, @Nullable MessageBody.Location location) {
            Intrinsics.checkNotNullParameter(str, "channelId");
            return (SharingMapFragment) FragmentsKt.arguments(new SharingMapFragment(), 1, new a(str, location));
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function0<AvitoMapAttachHelper> {
        public final /* synthetic */ SharingMapFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SharingMapFragment sharingMapFragment) {
            super(0);
            this.a = sharingMapFragment;
        }

        @Override // kotlin.jvm.functions.Function0
        public AvitoMapAttachHelper invoke() {
            if (this.a.getFeatures().getYandexMapsInMessenger().invoke().booleanValue()) {
                return new YandexAvitoMapAttachHelper();
            }
            return new GoogleAvitoMapAttachHelper();
        }
    }

    public static final /* synthetic */ String access$getChannelId$p(SharingMapFragment sharingMapFragment) {
        String str = sharingMapFragment.e;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelId");
        }
        return str;
    }

    public static final /* synthetic */ SharingMapView access$getMapView$p(SharingMapFragment sharingMapFragment) {
        SharingMapView sharingMapView = sharingMapFragment.c;
        if (sharingMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapView");
        }
        return sharingMapView;
    }

    public static final void access$openGeoSearchScreen(SharingMapFragment sharingMapFragment, String str) {
        ActivityIntentFactory activityIntentFactory2 = sharingMapFragment.getActivityIntentFactory();
        String access$getChannelId$p = access$getChannelId$p(sharingMapFragment);
        AvitoMapPoint avitoMapPoint = sharingMapFragment.g;
        GeoPoint geoPoint = null;
        GeoPoint geoPoint2 = avitoMapPoint != null ? new GeoPoint(avitoMapPoint.getLatitude(), avitoMapPoint.getLongitude()) : null;
        MessageBody.Location location = sharingMapFragment.f;
        if (location != null) {
            geoPoint = new GeoPoint(location.getLatitude(), location.getLongitude());
        }
        sharingMapFragment.startActivityForResult(activityIntentFactory2.geoSearchIntent(access$getChannelId$p, str, geoPoint2, geoPoint), 1);
    }

    public static final void access$requestLocation(SharingMapFragment sharingMapFragment) {
        FindLocationPresenter findLocationPresenter2 = sharingMapFragment.getFindLocationPresenter();
        FragmentActivity requireActivity = sharingMapFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        Disposable subscribe = FindLocationPresenter.DefaultImpls.findLocation$default(findLocationPresenter2, requireActivity, false, 2, null).subscribe(new Consumer<Location>() { // from class: com.avito.android.messenger.map.sharing.SharingMapFragment$requestLocation$1
            public final void accept(Location location) {
                LocationAnalyticsInteractor.DefaultImpls.trackResolveCoordinates$default(SharingMapFragment.this.getLocationAnalyticsInteractor(), location, null, 2, null);
                SharingMapPresenter presenter2 = SharingMapFragment.this.getPresenter();
                Intrinsics.checkNotNullExpressionValue(location, "userLocation");
                presenter2.userLocationChanged(new AvitoMapPoint(location.getLatitude(), location.getLongitude()));
            }
        }, new Consumer<Throwable>() { // from class: com.avito.android.messenger.map.sharing.SharingMapFragment$requestLocation$2
            public final void accept(Throwable th) {
                SharingMapFragment.this.getLocationAnalyticsInteractor().trackResolveCoordinates(null, th.getMessage());
                SharingMapFragment.access$getMapView$p(SharingMapFragment.this).showFindLocationError();
                Logs.error$default(SharingMapFragment.TAG, "mapView.locationFabClicks subscription in SharingMapFragment encountered error: " + th, null, 4, null);
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "findLocationPresenter.fi…         )\n            })");
        DisposableKt.addTo(subscribe, sharingMapFragment.d);
    }

    public static final void access$subscribeFindLocation(SharingMapFragment sharingMapFragment) {
        LocationPermissionDialogPresenter locationPermissionDialogPresenter2 = sharingMapFragment.locationPermissionDialogPresenter;
        if (locationPermissionDialogPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationPermissionDialogPresenter");
        }
        DisposableKt.addTo(locationPermissionDialogPresenter2.subscriberChangeLocation(), sharingMapFragment.d);
    }

    public static final GeoPoint access$toGeoPoint(SharingMapFragment sharingMapFragment, AvitoMapPoint avitoMapPoint) {
        Objects.requireNonNull(sharingMapFragment);
        return new GeoPoint(avitoMapPoint.getLatitude(), avitoMapPoint.getLongitude());
    }

    @Override // com.avito.android.permissions.LocationPermissionDialogPresenter.Router
    public void findLocation() {
        SharingMapPresenter sharingMapPresenter = this.presenter;
        if (sharingMapPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        sharingMapPresenter.myLocationButtonClicked();
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        String str = this.e;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelId");
        }
        analytics2.track(new MessengerGeoMyLocationClick(str));
    }

    @NotNull
    public final ActivityIntentFactory getActivityIntentFactory() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        return activityIntentFactory2;
    }

    @NotNull
    public final Analytics getAnalytics() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @NotNull
    public final Features getFeatures() {
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        return features2;
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
    public final SharingMapPresenter getPresenter() {
        SharingMapPresenter sharingMapPresenter = this.presenter;
        if (sharingMapPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return sharingMapPresenter;
    }

    @NotNull
    public final SchedulersFactory3 getSchedulers() {
        SchedulersFactory3 schedulersFactory3 = this.schedulers;
        if (schedulersFactory3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schedulers");
        }
        return schedulersFactory3;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        if (i3 == -1 && i2 == 1) {
            GeoSearchSuggest geoSearchSuggest = intent != null ? (GeoSearchSuggest) intent.getParcelableExtra(GeoSearchFragmentKt.EXTRA_SELECTED_SUGGEST) : null;
            if (geoSearchSuggest != null) {
                SharingMapPresenter sharingMapPresenter = this.presenter;
                if (sharingMapPresenter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("presenter");
                }
                sharingMapPresenter.selectedSearchSuggest(geoSearchSuggest);
                return;
            }
            return;
        }
        super.onActivityResult(i2, i3, intent);
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
    public void onCreateOptionsMenu(@NotNull Menu menu, @NotNull MenuInflater menuInflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(menuInflater, "inflater");
        menuInflater.inflate(R.menu.messenger_sharing_map, menu);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        setHasOptionsMenu(true);
        View inflate = layoutInflater.inflate(R.layout.messenger_sharing_map_fragment, viewGroup, false);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        return (ViewGroup) inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        SharingMapView sharingMapView = this.c;
        if (sharingMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapView");
        }
        sharingMapView.onDestroy();
        super.onDestroy();
    }

    @Override // com.avito.android.messenger.map.OnLocationEnabledListener
    public void onLocationEnabled() {
        if (this.i) {
            Logs.verbose$default(TAG, "onLocationEnabled() && requestLocationWhenItsEnabled == true => presenter.myLocationButtonClicked()", null, 4, null);
            SharingMapPresenter sharingMapPresenter = this.presenter;
            if (sharingMapPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            sharingMapPresenter.myLocationButtonClicked();
            this.i = false;
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
        SharingMapView sharingMapView = this.c;
        if (sharingMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapView");
        }
        sharingMapView.showFindLocationError();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        SharingMapView sharingMapView = this.c;
        if (sharingMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapView");
        }
        sharingMapView.onLowMemory();
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
            DisposableKt.addTo(locationPermissionDialogPresenter2.subscriberNotPermissionGranted(view), this.d);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(@NotNull MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        if (menuItem.getItemId() != R.id.messenger_menu_geo_search) {
            return super.onOptionsItemSelected(menuItem);
        }
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        String str = this.e;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelId");
        }
        analytics2.track(new MessengerGeoSearchLocationClick(str, MessengerGeoSearchLocationClick.SEARCH));
        ActivityIntentFactory activityIntentFactory2 = getActivityIntentFactory();
        String access$getChannelId$p = access$getChannelId$p(this);
        AvitoMapPoint avitoMapPoint = this.g;
        GeoPoint geoPoint = null;
        GeoPoint geoPoint2 = avitoMapPoint != null ? new GeoPoint(avitoMapPoint.getLatitude(), avitoMapPoint.getLongitude()) : null;
        MessageBody.Location location = this.f;
        if (location != null) {
            geoPoint = new GeoPoint(location.getLatitude(), location.getLongitude());
        }
        startActivityForResult(activityIntentFactory2.geoSearchIntent(access$getChannelId$p, "", geoPoint2, geoPoint), 1);
        return true;
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
        FindLocationPresenter findLocationPresenter2 = this.findLocationPresenter;
        if (findLocationPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("findLocationPresenter");
        }
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        findLocationPresenter2.registerLocationReceiver(requireContext);
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        bundle.putBoolean("request_location_when_its_enabled", this.i);
        super.onSaveInstanceState(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
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
        getPresenter().getSendLocationEventsStream().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.messenger.map.sharing.SharingMapFragment$setupSubscriptions$$inlined$observeNotNull$1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    T t2 = t;
                    FragmentActivity activity = SharingMapFragment.this.getActivity();
                    if (activity != null) {
                        activity.setResult(-1, new Intent().putExtra(SharingMapFragmentKt.EXTRA_SHARED_LOCATION, (Parcelable) t2));
                        activity.finish();
                    }
                }
            }
        });
        getPresenter().getEditAddressStream().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.messenger.map.sharing.SharingMapFragment$setupSubscriptions$$inlined$observeNotNull$2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    T t2 = t;
                    SharingMapFragment sharingMapFragment = SharingMapFragment.this;
                    ActivityIntentFactory activityIntentFactory2 = sharingMapFragment.getActivityIntentFactory();
                    String access$getChannelId$p = SharingMapFragment.access$getChannelId$p(sharingMapFragment);
                    AvitoMapPoint avitoMapPoint = sharingMapFragment.g;
                    GeoPoint geoPoint = null;
                    GeoPoint geoPoint2 = avitoMapPoint != null ? new GeoPoint(avitoMapPoint.getLatitude(), avitoMapPoint.getLongitude()) : null;
                    MessageBody.Location location = sharingMapFragment.f;
                    if (location != null) {
                        geoPoint = new GeoPoint(location.getLatitude(), location.getLongitude());
                    }
                    sharingMapFragment.startActivityForResult(activityIntentFactory2.geoSearchIntent(access$getChannelId$p, t2, geoPoint2, geoPoint), 1);
                }
            }
        });
        getPresenter().getRequestLocationStream().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.messenger.map.sharing.SharingMapFragment$setupSubscriptions$$inlined$observeNotNull$3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    SharingMapFragment sharingMapFragment = SharingMapFragment.this;
                    FindLocationPresenter findLocationPresenter2 = sharingMapFragment.getFindLocationPresenter();
                    FragmentActivity requireActivity = sharingMapFragment.requireActivity();
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
                          (wrap: com.avito.android.messenger.map.sharing.SharingMapFragment$setupSubscriptions$$inlined$observeNotNull$3$lambda$1 : 0x001c: CONSTRUCTOR  (r1v1 com.avito.android.messenger.map.sharing.SharingMapFragment$setupSubscriptions$$inlined$observeNotNull$3$lambda$1) = (r6v2 'sharingMapFragment' com.avito.android.messenger.map.sharing.SharingMapFragment) call: com.avito.android.messenger.map.sharing.SharingMapFragment$setupSubscriptions$$inlined$observeNotNull$3$lambda$1.<init>(com.avito.android.messenger.map.sharing.SharingMapFragment):void type: CONSTRUCTOR)
                          (wrap: com.avito.android.messenger.map.sharing.SharingMapFragment$setupSubscriptions$$inlined$observeNotNull$3$lambda$2 : 0x0021: CONSTRUCTOR  (r2v2 com.avito.android.messenger.map.sharing.SharingMapFragment$setupSubscriptions$$inlined$observeNotNull$3$lambda$2) = (r6v2 'sharingMapFragment' com.avito.android.messenger.map.sharing.SharingMapFragment) call: com.avito.android.messenger.map.sharing.SharingMapFragment$setupSubscriptions$$inlined$observeNotNull$3$lambda$2.<init>(com.avito.android.messenger.map.sharing.SharingMapFragment):void type: CONSTRUCTOR)
                         type: VIRTUAL call: io.reactivex.rxjava3.core.Observable.subscribe(io.reactivex.rxjava3.functions.Consumer, io.reactivex.rxjava3.functions.Consumer):io.reactivex.rxjava3.disposables.Disposable in method: com.avito.android.messenger.map.sharing.SharingMapFragment$setupSubscriptions$$inlined$observeNotNull$3.onChanged(T):void, file: classes3.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001c: CONSTRUCTOR  (r1v1 com.avito.android.messenger.map.sharing.SharingMapFragment$setupSubscriptions$$inlined$observeNotNull$3$lambda$1) = (r6v2 'sharingMapFragment' com.avito.android.messenger.map.sharing.SharingMapFragment) call: com.avito.android.messenger.map.sharing.SharingMapFragment$setupSubscriptions$$inlined$observeNotNull$3$lambda$1.<init>(com.avito.android.messenger.map.sharing.SharingMapFragment):void type: CONSTRUCTOR in method: com.avito.android.messenger.map.sharing.SharingMapFragment$setupSubscriptions$$inlined$observeNotNull$3.onChanged(T):void, file: classes3.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:955)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:780)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:394)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:275)
                        	... 23 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.avito.android.messenger.map.sharing.SharingMapFragment$setupSubscriptions$$inlined$observeNotNull$3$lambda$1, state: NOT_LOADED
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
                        com.avito.android.messenger.map.sharing.SharingMapFragment r6 = com.avito.android.messenger.map.sharing.SharingMapFragment.this
                        com.avito.android.location.find.FindLocationPresenter r0 = r6.getFindLocationPresenter()
                        androidx.fragment.app.FragmentActivity r1 = r6.requireActivity()
                        java.lang.String r2 = "requireActivity()"
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
                        r2 = 0
                        r3 = 2
                        r4 = 0
                        io.reactivex.rxjava3.core.Observable r0 = com.avito.android.location.find.FindLocationPresenter.DefaultImpls.findLocation$default(r0, r1, r2, r3, r4)
                        com.avito.android.messenger.map.sharing.SharingMapFragment$setupSubscriptions$$inlined$observeNotNull$3$lambda$1 r1 = new com.avito.android.messenger.map.sharing.SharingMapFragment$setupSubscriptions$$inlined$observeNotNull$3$lambda$1
                        r1.<init>(r6)
                        com.avito.android.messenger.map.sharing.SharingMapFragment$setupSubscriptions$$inlined$observeNotNull$3$lambda$2 r2 = new com.avito.android.messenger.map.sharing.SharingMapFragment$setupSubscriptions$$inlined$observeNotNull$3$lambda$2
                        r2.<init>(r6)
                        io.reactivex.rxjava3.disposables.Disposable r0 = r0.subscribe(r1, r2)
                        java.lang.String r1 = "findLocationPresenter.fi…         )\n            })"
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                        io.reactivex.rxjava3.disposables.CompositeDisposable r6 = com.avito.android.messenger.map.sharing.SharingMapFragment.access$getSubscriptions$p(r6)
                        io.reactivex.rxjava3.kotlin.DisposableKt.addTo(r0, r6)
                    L_0x0034:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.map.sharing.SharingMapFragment$setupSubscriptions$$inlined$observeNotNull$3.onChanged(java.lang.Object):void");
                }
            });
            Disposable subscribe = access$getMapView$p(this).getMapIsReadyStream().observeOn(getSchedulers().mainThread()).filter(SharingMapFragment$setupSubscriptions$4.INSTANCE).take(1).concatMap(new Function<Boolean, ObservableSource<? extends SharingMapView.State>>() { // from class: com.avito.android.messenger.map.sharing.SharingMapFragment$setupSubscriptions$5
                public final ObservableSource<? extends SharingMapView.State> apply(Boolean bool) {
                    return InteropKt.toV3(SharingMapFragment.this.getPresenter().getStateObservable());
                }
            }).observeOn(getSchedulers().mainThread()).subscribeOn(getSchedulers().mainThread()).subscribe(new Consumer<SharingMapView.State>() { // from class: com.avito.android.messenger.map.sharing.SharingMapFragment$setupSubscriptions$6
                public final void accept(SharingMapView.State state) {
                    SharingMapView access$getMapView$p = SharingMapFragment.access$getMapView$p(SharingMapFragment.this);
                    Intrinsics.checkNotNullExpressionValue(state, "state");
                    access$getMapView$p.render(state);
                    StringBuilder sb = new StringBuilder();
                    StringBuilder I = a.I('[');
                    Thread currentThread = Thread.currentThread();
                    Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
                    I.append(currentThread.getName());
                    I.append(']');
                    sb.append(I.toString());
                    sb.append(" Rendered ");
                    sb.append(state);
                    Logs.info$default(SharingMapFragment.TAG, sb.toString(), null, 4, null);
                }
            });
            Intrinsics.checkNotNullExpressionValue(subscribe, "mapView.mapIsReadyStream…ed $state\")\n            }");
            DisposableKt.addTo(subscribe, this.d);
            Disposable subscribe2 = access$getMapView$p(this).getCameraPositionStream().observeOn(getSchedulers().mainThread()).subscribe(new Consumer<AvitoMapCameraPosition>() { // from class: com.avito.android.messenger.map.sharing.SharingMapFragment$setupSubscriptions$7
                public final void accept(AvitoMapCameraPosition avitoMapCameraPosition) {
                    SharingMapPresenter presenter2 = SharingMapFragment.this.getPresenter();
                    Intrinsics.checkNotNullExpressionValue(avitoMapCameraPosition, "newCameraPosition");
                    presenter2.cameraPositionChanged(avitoMapCameraPosition, false);
                    SharingMapFragment.this.g = avitoMapCameraPosition.getMapPoint();
                }
            });
            Intrinsics.checkNotNullExpressionValue(subscribe2, "mapView.cameraPositionSt…on.mapPoint\n            }");
            DisposableKt.addTo(subscribe2, this.d);
            Disposable subscribe3 = access$getMapView$p(this).getCameraDraggingStartedStream().observeOn(getSchedulers().mainThread()).subscribe(new Consumer<Unit>() { // from class: com.avito.android.messenger.map.sharing.SharingMapFragment$setupSubscriptions$8
                public final void accept(Unit unit) {
                    SharingMapFragment.this.getPresenter().cameraDraggingStarted(false);
                }
            });
            Intrinsics.checkNotNullExpressionValue(subscribe3, "mapView.cameraDraggingSt…on = false)\n            }");
            DisposableKt.addTo(subscribe3, this.d);
            Observable<Unit> findLocationClicks = access$getMapView$p(this).getFindLocationClicks();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            Disposable subscribe4 = findLocationClicks.throttleFirst(300, timeUnit).observeOn(getSchedulers().mainThread()).subscribe(new Consumer<Unit>() { // from class: com.avito.android.messenger.map.sharing.SharingMapFragment$setupSubscriptions$9
                public final void accept(Unit unit) {
                    SharingMapFragment.this.getLocationAnalyticsInteractor().trackFindCoordinates(FindLocationPage.SHARING_MAP.getValue());
                    SharingMapFragment.access$subscribeFindLocation(SharingMapFragment.this);
                }
            }, new Consumer<Throwable>() { // from class: com.avito.android.messenger.map.sharing.SharingMapFragment$setupSubscriptions$10
                public final void accept(Throwable th) {
                    SharingMapFragment.this.getLocationAnalyticsInteractor().trackResolveCoordinates(null, th.getMessage());
                    Logs.error$default(SharingMapFragment.TAG, "mapView.locationFabClicks subscription in SharingMapFragment encountered error: " + th, null, 4, null);
                }
            });
            Intrinsics.checkNotNullExpressionValue(subscribe4, "mapView.findLocationClic…         )\n            })");
            DisposableKt.addTo(subscribe4, this.d);
            Disposable subscribe5 = access$getMapView$p(this).getSendLocationButtonClicks().throttleFirst(300, timeUnit).observeOn(getSchedulers().mainThread()).subscribe(new Consumer<Unit>() { // from class: com.avito.android.messenger.map.sharing.SharingMapFragment$setupSubscriptions$11
                public final void accept(Unit unit) {
                    SharingMapFragment.this.getPresenter().sendLocationButtonClicked();
                }
            });
            Intrinsics.checkNotNullExpressionValue(subscribe5, "mapView.sendLocationButt…onClicked()\n            }");
            DisposableKt.addTo(subscribe5, this.d);
            Disposable subscribe6 = access$getMapView$p(this).getEditAddressClicks().throttleFirst(300, timeUnit).observeOn(getSchedulers().mainThread()).subscribe(new Consumer<Unit>() { // from class: com.avito.android.messenger.map.sharing.SharingMapFragment$setupSubscriptions$12
                public final void accept(Unit unit) {
                    SharingMapFragment.this.getAnalytics().track(new MessengerGeoSearchLocationClick(SharingMapFragment.access$getChannelId$p(SharingMapFragment.this), MessengerGeoSearchLocationClick.EDIT));
                    SharingMapFragment.this.getPresenter().editAddressClicked();
                }
            });
            Intrinsics.checkNotNullExpressionValue(subscribe6, "mapView.editAddressClick…ssClicked()\n            }");
            DisposableKt.addTo(subscribe6, this.d);
            SharingMapView sharingMapView = this.c;
            if (sharingMapView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mapView");
            }
            sharingMapView.onStart();
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
            this.d.clear();
            SharingMapView sharingMapView = this.c;
            if (sharingMapView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mapView");
            }
            sharingMapView.onStop();
            super.onStop();
        }

        @Override // androidx.fragment.app.Fragment
        public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
            Intrinsics.checkNotNullParameter(view, "view");
            super.onViewCreated(view, bundle);
            Bundle arguments = getArguments();
            MessageBody.Location location = null;
            String string = arguments != null ? arguments.getString("channel_id") : null;
            Intrinsics.checkNotNull(string);
            this.e = string;
            Bundle arguments2 = getArguments();
            if (arguments2 != null) {
                location = (MessageBody.Location) arguments2.getParcelable("initial_position");
            }
            this.f = location;
            View findViewById = view.findViewById(R.id.toolbar);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
            setSupportActionBar((Toolbar) findViewById);
            ActionBarUtils.INSTANCE.setActionBarTitle(FragmentsKt.getSupportActionBar(this), getResources().getString(R.string.messenger_shared_location_map_view_title));
            FragmentsKt.getSupportActionBar(this).setHomeAsUpIndicator(com.avito.android.ui_components.R.drawable.ic_close_24);
            MessageBody.Location location2 = this.f;
            if (location2 == null) {
                location2 = new MessageBody.Location(0.0d, 0.0d, "Атлантический океан", null, null, 24, null);
            }
            this.g = new AvitoMapPoint(location2.getLatitude(), location2.getLongitude());
            SharingMapView.State.Static.Loaded loaded = new SharingMapView.State.Static.Loaded(location2, new SharingMapView.CameraState(location2.getLatitude(), location2.getLongitude(), this.f != null ? 18.0f : 1.0f), null, location2.getTitle(), false, false);
            SharingMapView.State.Empty empty = SharingMapView.State.Empty.INSTANCE;
            SharingMapFragmentComponent.Builder fragment = DaggerSharingMapFragmentComponent.builder().fragment(this);
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            SharingMapFragmentComponent.Builder sharingMapInitialViewState = fragment.activity(requireActivity).withFragment(this).sharingMapDefaultViewState(empty).sharingMapInitialViewState(loaded);
            String string2 = getResources().getString(R.string.messenger_share_map_address_not_found_title);
            Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st…_address_not_found_title)");
            SharingMapFragmentComponent.Builder addressNotFoundTitle = sharingMapInitialViewState.addressNotFoundTitle(string2);
            String string3 = getResources().getString(R.string.messenger_share_map_address_not_found_error_message);
            Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(R.st…_not_found_error_message)");
            SharingMapFragmentComponent.Builder addressNotFoundErrorMessage = addressNotFoundTitle.addressNotFoundErrorMessage(string3);
            String string4 = getResources().getString(R.string.messenger_once_again);
            Intrinsics.checkNotNullExpressionValue(string4, "resources.getString(R.string.messenger_once_again)");
            addressNotFoundErrorMessage.retryLabel(string4).sharingMapFragmentDependencies((SharingMapFragmentDependencies) ComponentDependenciesKt.getDependencies(SharingMapFragmentDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).sharingMapFragmentModule(SharingMapFragmentModule.INSTANCE).build().inject(this);
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            this.c = new SharingMapViewImpl(view, (AvitoMapAttachHelper) this.h.getValue(), parentFragmentManager);
            this.i = bundle != null ? bundle.getBoolean("request_location_when_its_enabled") : false;
        }

        public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
            Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
            this.activityIntentFactory = activityIntentFactory2;
        }

        public final void setAnalytics(@NotNull Analytics analytics2) {
            Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
            this.analytics = analytics2;
        }

        public final void setFeatures(@NotNull Features features2) {
            Intrinsics.checkNotNullParameter(features2, "<set-?>");
            this.features = features2;
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

        public final void setPresenter(@NotNull SharingMapPresenter sharingMapPresenter) {
            Intrinsics.checkNotNullParameter(sharingMapPresenter, "<set-?>");
            this.presenter = sharingMapPresenter;
        }

        public final void setSchedulers(@NotNull SchedulersFactory3 schedulersFactory3) {
            Intrinsics.checkNotNullParameter(schedulersFactory3, "<set-?>");
            this.schedulers = schedulersFactory3;
        }
    }

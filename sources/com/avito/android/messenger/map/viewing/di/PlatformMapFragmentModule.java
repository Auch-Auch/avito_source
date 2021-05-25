package com.avito.android.messenger.map.viewing.di;

import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.Features;
import com.avito.android.avito_map.AvitoMapAttachHelper;
import com.avito.android.avito_map.google.GoogleAvitoMapAttachHelper;
import com.avito.android.avito_map.yandex.YandexAvitoMapAttachHelper;
import com.avito.android.geo.GeoStorage;
import com.avito.android.location.analytics.LocationAnalyticsInteractor;
import com.avito.android.location.analytics.LocationAnalyticsInteractorImpl;
import com.avito.android.location.find.DefaultLocationInteractor;
import com.avito.android.location.find.DefaultLocationInteractorImpl;
import com.avito.android.location.find.DefaultLocationProvider;
import com.avito.android.location.find.DefaultLocationProviderImpl;
import com.avito.android.location.find.FindLocationPresenter;
import com.avito.android.location.find.FindLocationPresenterImpl;
import com.avito.android.location.find.FusedLocationInteractor;
import com.avito.android.location.find.FusedLocationInteractorImpl;
import com.avito.android.location.find.GoogleServicesLocationProvider;
import com.avito.android.location.find.GoogleServicesLocationProviderImpl;
import com.avito.android.messenger.R;
import com.avito.android.messenger.channels.mvi.di.ViewModelFactory;
import com.avito.android.messenger.map.viewing.PlatformMapInteractor;
import com.avito.android.messenger.map.viewing.PlatformMapInteractorImpl;
import com.avito.android.messenger.map.viewing.PlatformMapPresenter;
import com.avito.android.messenger.map.viewing.PlatformMapPresenterImpl;
import com.avito.android.messenger.map.viewing.view.PlatformMapView;
import com.avito.android.messenger.map.viewing.view.PlatformMapViewImpl;
import com.avito.android.permissions.LocationPermissionDialogPresenter;
import com.avito.android.permissions.LocationPermissionDialogPresenterImpl;
import com.avito.android.permissions.LocationPermissionProvider;
import com.avito.android.permissions.LocationPermissionProviderImpl;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.Formatter;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.preferences.GeoContract;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.AttributedTextFormatterModule;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001/B\t\b\u0002¢\u0006\u0004\b-\u0010.JE\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020\u001fH\u0007¢\u0006\u0004\b\"\u0010#J\u0017\u0010'\u001a\u00020&2\u0006\u0010%\u001a\u00020$H\u0007¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020*2\u0006\u0010)\u001a\u00020&H\u0007¢\u0006\u0004\b+\u0010,¨\u00060"}, d2 = {"Lcom/avito/android/messenger/map/viewing/di/PlatformMapFragmentModule;", "", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/messenger/map/viewing/PlatformMapInteractor;", "interactor", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Lcom/avito/android/util/Formatter;", "", "errorFormatter", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory3", "Landroidx/lifecycle/ViewModel;", "providePlatformMapPresenterViewModel", "(Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/messenger/map/viewing/PlatformMapInteractor;Lcom/avito/android/util/text/AttributedTextFormatter;Lcom/avito/android/util/Formatter;Landroid/content/res/Resources;Lcom/avito/android/util/SchedulersFactory3;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;", "viewModelFactory", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/avito/android/messenger/map/viewing/PlatformMapPresenter;", "providePlatformMapPresenter", "(Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;Landroidx/fragment/app/Fragment;)Lcom/avito/android/messenger/map/viewing/PlatformMapPresenter;", "Lcom/avito/android/permissions/LocationPermissionProvider;", GeoContract.PROVIDER, "Lcom/avito/android/permissions/LocationPermissionDialogPresenter;", "provideLocationPermissionDialogPresenter$messenger_release", "(Lcom/avito/android/permissions/LocationPermissionProvider;)Lcom/avito/android/permissions/LocationPermissionDialogPresenter;", "provideLocationPermissionDialogPresenter", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/avito_map/AvitoMapAttachHelper;", "provideMapAttachHelper", "(Lcom/avito/android/Features;)Lcom/avito/android/avito_map/AvitoMapAttachHelper;", "Lcom/avito/android/geo/GeoStorage;", "geoStorage", "Lcom/avito/android/location/find/DefaultLocationInteractor;", "provideDefaultLocationInteractor", "(Lcom/avito/android/geo/GeoStorage;)Lcom/avito/android/location/find/DefaultLocationInteractor;", "defaultLocationInteractor", "Lcom/avito/android/location/find/DefaultLocationProvider;", "provideDefaultLocationProvider", "(Lcom/avito/android/location/find/DefaultLocationInteractor;)Lcom/avito/android/location/find/DefaultLocationProvider;", "<init>", "()V", "Declarations", "messenger_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class, AttributedTextFormatterModule.class})
public final class PlatformMapFragmentModule {
    @NotNull
    public static final PlatformMapFragmentModule INSTANCE = new PlatformMapFragmentModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H'¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001bH'¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010\u001c\u001a\u00020 H'¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020&2\u0006\u0010\u0017\u001a\u00020%H'¢\u0006\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lcom/avito/android/messenger/map/viewing/di/PlatformMapFragmentModule$Declarations;", "", "Lcom/avito/android/location/find/FusedLocationInteractorImpl;", "fusedLocationInteractor", "Lcom/avito/android/location/find/FusedLocationInteractor;", "bindFusedLocationPresenter", "(Lcom/avito/android/location/find/FusedLocationInteractorImpl;)Lcom/avito/android/location/find/FusedLocationInteractor;", "Lcom/avito/android/location/find/GoogleServicesLocationProviderImpl;", "googleServicesLocationProvider", "Lcom/avito/android/location/find/GoogleServicesLocationProvider;", "bindGoogleServicesLocationProvider", "(Lcom/avito/android/location/find/GoogleServicesLocationProviderImpl;)Lcom/avito/android/location/find/GoogleServicesLocationProvider;", "Lcom/avito/android/location/find/FindLocationPresenterImpl;", "findLocationPresenter", "Lcom/avito/android/location/find/FindLocationPresenter;", "bindFindLocationPresenter", "(Lcom/avito/android/location/find/FindLocationPresenterImpl;)Lcom/avito/android/location/find/FindLocationPresenter;", "Lcom/avito/android/permissions/LocationPermissionProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/permissions/LocationPermissionProvider;", "bindsLocationPermissionProvider", "(Lcom/avito/android/permissions/LocationPermissionProviderImpl;)Lcom/avito/android/permissions/LocationPermissionProvider;", "Lcom/avito/android/messenger/map/viewing/PlatformMapInteractorImpl;", "interactor", "Lcom/avito/android/messenger/map/viewing/PlatformMapInteractor;", "bindPlatformMapInteractor", "(Lcom/avito/android/messenger/map/viewing/PlatformMapInteractorImpl;)Lcom/avito/android/messenger/map/viewing/PlatformMapInteractor;", "Lcom/avito/android/messenger/map/viewing/view/PlatformMapViewImpl;", "view", "Lcom/avito/android/messenger/map/viewing/view/PlatformMapView;", "bindPlatformMapView", "(Lcom/avito/android/messenger/map/viewing/view/PlatformMapViewImpl;)Lcom/avito/android/messenger/map/viewing/view/PlatformMapView;", "Lcom/avito/android/util/ErrorFormatterImpl;", "Lcom/avito/android/util/Formatter;", "", "bindErrorFormatter", "(Lcom/avito/android/util/ErrorFormatterImpl;)Lcom/avito/android/util/Formatter;", "Lcom/avito/android/location/analytics/LocationAnalyticsInteractorImpl;", "Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;", "bindsLocationAnalyticsInteractor", "(Lcom/avito/android/location/analytics/LocationAnalyticsInteractorImpl;)Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @NotNull
        Formatter<Throwable> bindErrorFormatter(@NotNull ErrorFormatterImpl errorFormatterImpl);

        @Binds
        @NotNull
        FindLocationPresenter bindFindLocationPresenter(@NotNull FindLocationPresenterImpl findLocationPresenterImpl);

        @Binds
        @NotNull
        FusedLocationInteractor bindFusedLocationPresenter(@NotNull FusedLocationInteractorImpl fusedLocationInteractorImpl);

        @Binds
        @NotNull
        GoogleServicesLocationProvider bindGoogleServicesLocationProvider(@NotNull GoogleServicesLocationProviderImpl googleServicesLocationProviderImpl);

        @Binds
        @NotNull
        PlatformMapInteractor bindPlatformMapInteractor(@NotNull PlatformMapInteractorImpl platformMapInteractorImpl);

        @Binds
        @NotNull
        PlatformMapView bindPlatformMapView(@NotNull PlatformMapViewImpl platformMapViewImpl);

        @Binds
        @NotNull
        LocationAnalyticsInteractor bindsLocationAnalyticsInteractor(@NotNull LocationAnalyticsInteractorImpl locationAnalyticsInteractorImpl);

        @Binds
        @NotNull
        LocationPermissionProvider bindsLocationPermissionProvider(@NotNull LocationPermissionProviderImpl locationPermissionProviderImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final DefaultLocationInteractor provideDefaultLocationInteractor(@NotNull GeoStorage geoStorage) {
        Intrinsics.checkNotNullParameter(geoStorage, "geoStorage");
        return new DefaultLocationInteractorImpl(geoStorage, 2000, 1);
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final DefaultLocationProvider provideDefaultLocationProvider(@NotNull DefaultLocationInteractor defaultLocationInteractor) {
        Intrinsics.checkNotNullParameter(defaultLocationInteractor, "defaultLocationInteractor");
        return new DefaultLocationProviderImpl(1000, defaultLocationInteractor);
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final LocationPermissionDialogPresenter provideLocationPermissionDialogPresenter$messenger_release(@NotNull LocationPermissionProvider locationPermissionProvider) {
        Intrinsics.checkNotNullParameter(locationPermissionProvider, GeoContract.PROVIDER);
        return new LocationPermissionDialogPresenterImpl(locationPermissionProvider);
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final AvitoMapAttachHelper provideMapAttachHelper(@NotNull Features features) {
        Intrinsics.checkNotNullParameter(features, "features");
        if (features.getYandexMapsInMessenger().invoke().booleanValue()) {
            return new YandexAvitoMapAttachHelper();
        }
        return new GoogleAvitoMapAttachHelper();
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final PlatformMapPresenter providePlatformMapPresenter(@NotNull ViewModelFactory viewModelFactory, @NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(viewModelFactory, "viewModelFactory");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        ViewModel viewModel = new ViewModelProvider(fragment, viewModelFactory).get(PlatformMapPresenterImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ctory).get(T::class.java)");
        return (PlatformMapPresenter) viewModel;
    }

    @Provides
    @JvmStatic
    @NotNull
    @ClassKey(PlatformMapPresenterImpl.class)
    @IntoMap
    public static final ViewModel providePlatformMapPresenterViewModel(@NotNull SchedulersFactory schedulersFactory, @NotNull PlatformMapInteractor platformMapInteractor, @NotNull AttributedTextFormatter attributedTextFormatter, @NotNull Formatter<Throwable> formatter, @NotNull Resources resources, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(platformMapInteractor, "interactor");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        Intrinsics.checkNotNullParameter(formatter, "errorFormatter");
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory3");
        return new PlatformMapPresenterImpl(platformMapInteractor, resources.getDimensionPixelSize(R.dimen.messenger_platform_map_lat_lng_bounds_padding), attributedTextFormatter, formatter, PlatformMapView.State.Companion.getEMPTY(), schedulersFactory, schedulersFactory3);
    }
}

package com.avito.android.messenger.map.sharing.di;

import android.content.Context;
import android.content.res.Resources;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
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
import com.avito.android.messenger.channels.mvi.di.ViewModelFactory;
import com.avito.android.messenger.map.sharing.SharingMapFragment;
import com.avito.android.messenger.map.sharing.SharingMapInteractor;
import com.avito.android.messenger.map.sharing.SharingMapInteractorImpl;
import com.avito.android.messenger.map.sharing.SharingMapPresenter;
import com.avito.android.messenger.map.sharing.SharingMapPresenterImpl;
import com.avito.android.permissions.LocationPermissionDialogPresenter;
import com.avito.android.permissions.LocationPermissionDialogPresenterImpl;
import com.avito.android.permissions.LocationPermissionProvider;
import com.avito.android.permissions.LocationPermissionProviderImpl;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.Formatter;
import com.avito.android.util.preferences.GeoContract;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001'B\t\b\u0002¢\u0006\u0004\b%\u0010&J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0017H\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\u001e8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b!\u0010 R\u0016\u0010\"\u001a\u00020\u001e8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\"\u0010 R\u0016\u0010#\u001a\u00020\u001e8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b#\u0010 R\u0016\u0010$\u001a\u00020\u001e8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b$\u0010 ¨\u0006("}, d2 = {"Lcom/avito/android/messenger/map/sharing/di/SharingMapFragmentModule;", "", "Lcom/avito/android/messenger/map/sharing/SharingMapFragment;", "fragment", "Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;", "viewModelFactory", "Lcom/avito/android/messenger/map/sharing/SharingMapPresenter;", "provideSharingMapPresenter", "(Lcom/avito/android/messenger/map/sharing/SharingMapFragment;Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;)Lcom/avito/android/messenger/map/sharing/SharingMapPresenter;", "Landroid/content/Context;", "context", "Lcom/avito/android/util/Formatter;", "", "provideErrorFormatter", "(Landroid/content/Context;)Lcom/avito/android/util/Formatter;", "Lcom/avito/android/permissions/LocationPermissionProvider;", GeoContract.PROVIDER, "Lcom/avito/android/permissions/LocationPermissionDialogPresenter;", "provideLocationPermissionDialogPresenter$messenger_release", "(Lcom/avito/android/permissions/LocationPermissionProvider;)Lcom/avito/android/permissions/LocationPermissionDialogPresenter;", "provideLocationPermissionDialogPresenter", "Lcom/avito/android/geo/GeoStorage;", "geoStorage", "Lcom/avito/android/location/find/DefaultLocationInteractor;", "provideDefaultLocationInteractor", "(Lcom/avito/android/geo/GeoStorage;)Lcom/avito/android/location/find/DefaultLocationInteractor;", "defaultLocationInteractor", "Lcom/avito/android/location/find/DefaultLocationProvider;", "provideDefaultLocationProvider", "(Lcom/avito/android/location/find/DefaultLocationInteractor;)Lcom/avito/android/location/find/DefaultLocationProvider;", "", "ADDRESS_NOT_FOUND_TITLE", "Ljava/lang/String;", "INITIAL_STATE", "ADDRESS_NOT_FOUND_ERROR_MESSAGE", "RETRY_LABEL", "DEFAULT_STATE", "<init>", "()V", "Declarations", "messenger_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class SharingMapFragmentModule {
    @NotNull
    public static final String ADDRESS_NOT_FOUND_ERROR_MESSAGE = "addressNotFoundErrorMessage";
    @NotNull
    public static final String ADDRESS_NOT_FOUND_TITLE = "addressNotFoundTitle";
    @NotNull
    public static final String DEFAULT_STATE = "default";
    @NotNull
    public static final String INITIAL_STATE = "initial";
    @NotNull
    public static final SharingMapFragmentModule INSTANCE = new SharingMapFragmentModule();
    @NotNull
    public static final String RETRY_LABEL = "retryLabel";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H'¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001bH'¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020 H'¢\u0006\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/avito/android/messenger/map/sharing/di/SharingMapFragmentModule$Declarations;", "", "Lcom/avito/android/location/find/FusedLocationInteractorImpl;", "fusedLocationInteractor", "Lcom/avito/android/location/find/FusedLocationInteractor;", "bindFusedLocationPresenter", "(Lcom/avito/android/location/find/FusedLocationInteractorImpl;)Lcom/avito/android/location/find/FusedLocationInteractor;", "Lcom/avito/android/location/find/GoogleServicesLocationProviderImpl;", "googleServicesLocationProvider", "Lcom/avito/android/location/find/GoogleServicesLocationProvider;", "bindGoogleServicesLocationProvider", "(Lcom/avito/android/location/find/GoogleServicesLocationProviderImpl;)Lcom/avito/android/location/find/GoogleServicesLocationProvider;", "Lcom/avito/android/location/find/FindLocationPresenterImpl;", "findLocationPresenter", "Lcom/avito/android/location/find/FindLocationPresenter;", "bindFindLocationPresenter", "(Lcom/avito/android/location/find/FindLocationPresenterImpl;)Lcom/avito/android/location/find/FindLocationPresenter;", "Lcom/avito/android/permissions/LocationPermissionProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/permissions/LocationPermissionProvider;", "bindsLocationPermissionProvider", "(Lcom/avito/android/permissions/LocationPermissionProviderImpl;)Lcom/avito/android/permissions/LocationPermissionProvider;", "Lcom/avito/android/messenger/map/sharing/SharingMapPresenterImpl;", "sharingMapPresenterImpl", "Landroidx/lifecycle/ViewModel;", "bindSharingMapPresenterViewModel", "(Lcom/avito/android/messenger/map/sharing/SharingMapPresenterImpl;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/messenger/map/sharing/SharingMapInteractorImpl;", "sharingMapInteractorImpl", "Lcom/avito/android/messenger/map/sharing/SharingMapInteractor;", "bindSharingMapInteractor", "(Lcom/avito/android/messenger/map/sharing/SharingMapInteractorImpl;)Lcom/avito/android/messenger/map/sharing/SharingMapInteractor;", "Lcom/avito/android/location/analytics/LocationAnalyticsInteractorImpl;", "interactor", "Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;", "bindsLocationAnalyticsInteractor", "(Lcom/avito/android/location/analytics/LocationAnalyticsInteractorImpl;)Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
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
        SharingMapInteractor bindSharingMapInteractor(@NotNull SharingMapInteractorImpl sharingMapInteractorImpl);

        @Binds
        @NotNull
        @ClassKey(SharingMapPresenterImpl.class)
        @IntoMap
        ViewModel bindSharingMapPresenterViewModel(@NotNull SharingMapPresenterImpl sharingMapPresenterImpl);

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
    public static final Formatter<Throwable> provideErrorFormatter(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        return new ErrorFormatterImpl(resources);
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
    public static final SharingMapPresenter provideSharingMapPresenter(@NotNull SharingMapFragment sharingMapFragment, @NotNull ViewModelFactory viewModelFactory) {
        Intrinsics.checkNotNullParameter(sharingMapFragment, "fragment");
        Intrinsics.checkNotNullParameter(viewModelFactory, "viewModelFactory");
        ViewModel viewModel = new ViewModelProvider(sharingMapFragment, viewModelFactory).get(SharingMapPresenterImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ctory).get(T::class.java)");
        return (SharingMapPresenter) viewModel;
    }
}

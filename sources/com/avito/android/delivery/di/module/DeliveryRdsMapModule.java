package com.avito.android.delivery.di.module;

import android.view.LayoutInflater;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.delivery.map.common.DeliveryLocationInteractor;
import com.avito.android.delivery.map.common.DeliveryLocationInteractorImpl;
import com.avito.android.delivery.map.common.DeliveryMapResourceProvider;
import com.avito.android.delivery.map.common.DeliveryMapResourceProviderImpl;
import com.avito.android.delivery.map.common.DeliveryMapViewModel;
import com.avito.android.delivery.map.common.DeliveryMapViewModelImpl;
import com.avito.android.delivery.map.common.DeliveryMapViewPresenterFactory;
import com.avito.android.delivery.map.common.marker.DeliveryMapMarkerIconFactory;
import com.avito.android.delivery.map.common.marker.DeliveryMapMarkerIconFactoryImpl;
import com.avito.android.delivery.map.common.marker.DeliveryMapMarkerResourceProvider;
import com.avito.android.delivery.map.common.marker.MarkerLabelManager;
import com.avito.android.delivery.map.common.marker.MarkerLabelManagerImpl;
import com.avito.android.di.PerFragment;
import com.avito.android.location.analytics.LocationAnalyticsInteractor;
import com.avito.android.location.analytics.LocationAnalyticsInteractorImpl;
import com.avito.android.location.di.module.FindLocationModule;
import com.avito.android.permissions.LocationPermissionDialogPresenter;
import com.avito.android.permissions.LocationPermissionDialogPresenterImpl;
import com.avito.android.permissions.LocationPermissionProvider;
import com.avito.android.permissions.LocationPermissionProviderImpl;
import com.avito.android.util.map.MapMarkerResourceProvider;
import com.avito.android.util.preferences.GeoContract;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0001¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/avito/android/delivery/di/module/DeliveryRdsMapModule;", "", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/avito/android/delivery/map/common/DeliveryMapViewPresenterFactory;", "viewModelFactory", "Lcom/avito/android/delivery/map/common/DeliveryMapViewModel;", "provideDeliveryMapViewModel$delivery_release", "(Landroidx/fragment/app/Fragment;Lcom/avito/android/delivery/map/common/DeliveryMapViewPresenterFactory;)Lcom/avito/android/delivery/map/common/DeliveryMapViewModel;", "provideDeliveryMapViewModel", "Lcom/avito/android/delivery/map/common/marker/DeliveryMapMarkerResourceProvider;", "resourceProvider", "Lcom/avito/android/delivery/map/common/marker/DeliveryMapMarkerIconFactory;", "provideIconFactory$delivery_release", "(Landroidx/fragment/app/Fragment;Lcom/avito/android/delivery/map/common/marker/DeliveryMapMarkerResourceProvider;)Lcom/avito/android/delivery/map/common/marker/DeliveryMapMarkerIconFactory;", "provideIconFactory", "<init>", "()V", "Dependencies", "delivery_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {FindLocationModule.class, Dependencies.class})
public final class DeliveryRdsMapModule {
    @NotNull
    public static final DeliveryRdsMapModule INSTANCE = new DeliveryRdsMapModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0011H'¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u0015H'¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\r\u001a\u00020\u0019H'¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020\u001dH'¢\u0006\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/avito/android/delivery/di/module/DeliveryRdsMapModule$Dependencies;", "", "Lcom/avito/android/permissions/LocationPermissionProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/permissions/LocationPermissionProvider;", "bindsLocationPermissionProvider", "(Lcom/avito/android/permissions/LocationPermissionProviderImpl;)Lcom/avito/android/permissions/LocationPermissionProvider;", "Lcom/avito/android/permissions/LocationPermissionDialogPresenterImpl;", "presenter", "Lcom/avito/android/permissions/LocationPermissionDialogPresenter;", "bindLocationPermissionDialogPresenter", "(Lcom/avito/android/permissions/LocationPermissionDialogPresenterImpl;)Lcom/avito/android/permissions/LocationPermissionDialogPresenter;", "Lcom/avito/android/delivery/map/common/DeliveryLocationInteractorImpl;", "interactor", "Lcom/avito/android/delivery/map/common/DeliveryLocationInteractor;", "bindsLocationInteractor", "(Lcom/avito/android/delivery/map/common/DeliveryLocationInteractorImpl;)Lcom/avito/android/delivery/map/common/DeliveryLocationInteractor;", "Lcom/avito/android/delivery/map/common/DeliveryMapResourceProviderImpl;", "Lcom/avito/android/delivery/map/common/DeliveryMapResourceProvider;", "bindsMapResourceProvider", "(Lcom/avito/android/delivery/map/common/DeliveryMapResourceProviderImpl;)Lcom/avito/android/delivery/map/common/DeliveryMapResourceProvider;", "Lcom/avito/android/delivery/map/common/marker/MarkerLabelManagerImpl;", "Lcom/avito/android/delivery/map/common/marker/MarkerLabelManager;", "bindsMarkerLabelManager", "(Lcom/avito/android/delivery/map/common/marker/MarkerLabelManagerImpl;)Lcom/avito/android/delivery/map/common/marker/MarkerLabelManager;", "Lcom/avito/android/location/analytics/LocationAnalyticsInteractorImpl;", "Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;", "bindsLocationAnalyticsInteractor", "(Lcom/avito/android/location/analytics/LocationAnalyticsInteractorImpl;)Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;", "Lcom/avito/android/delivery/map/common/marker/DeliveryMapMarkerResourceProvider;", "Lcom/avito/android/util/map/MapMarkerResourceProvider;", "bindMapMarkerResourceProvider", "(Lcom/avito/android/delivery/map/common/marker/DeliveryMapMarkerResourceProvider;)Lcom/avito/android/util/map/MapMarkerResourceProvider;", "delivery_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Dependencies {
        @PerFragment
        @Binds
        @NotNull
        LocationPermissionDialogPresenter bindLocationPermissionDialogPresenter(@NotNull LocationPermissionDialogPresenterImpl locationPermissionDialogPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        MapMarkerResourceProvider bindMapMarkerResourceProvider(@NotNull DeliveryMapMarkerResourceProvider deliveryMapMarkerResourceProvider);

        @PerFragment
        @Binds
        @NotNull
        LocationAnalyticsInteractor bindsLocationAnalyticsInteractor(@NotNull LocationAnalyticsInteractorImpl locationAnalyticsInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        DeliveryLocationInteractor bindsLocationInteractor(@NotNull DeliveryLocationInteractorImpl deliveryLocationInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        LocationPermissionProvider bindsLocationPermissionProvider(@NotNull LocationPermissionProviderImpl locationPermissionProviderImpl);

        @PerFragment
        @Binds
        @NotNull
        DeliveryMapResourceProvider bindsMapResourceProvider(@NotNull DeliveryMapResourceProviderImpl deliveryMapResourceProviderImpl);

        @Binds
        @NotNull
        MarkerLabelManager bindsMarkerLabelManager(@NotNull MarkerLabelManagerImpl markerLabelManagerImpl);
    }

    @Provides
    @PerFragment
    @NotNull
    public final DeliveryMapViewModel provideDeliveryMapViewModel$delivery_release(@NotNull Fragment fragment, @NotNull DeliveryMapViewPresenterFactory deliveryMapViewPresenterFactory) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(deliveryMapViewPresenterFactory, "viewModelFactory");
        ViewModel viewModel = new ViewModelProvider(fragment, deliveryMapViewPresenterFactory).get(DeliveryMapViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(fragme…iewModelImpl::class.java)");
        return (DeliveryMapViewModel) viewModel;
    }

    @Provides
    @PerFragment
    @NotNull
    public final DeliveryMapMarkerIconFactory provideIconFactory$delivery_release(@NotNull Fragment fragment, @NotNull DeliveryMapMarkerResourceProvider deliveryMapMarkerResourceProvider) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(deliveryMapMarkerResourceProvider, "resourceProvider");
        LayoutInflater from = LayoutInflater.from(fragment.requireContext());
        Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(fragment.requireContext())");
        return new DeliveryMapMarkerIconFactoryImpl(from, deliveryMapMarkerResourceProvider);
    }
}

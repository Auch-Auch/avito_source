package com.avito.android.delivery.di.module;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.Features;
import com.avito.android.avito_map.AvitoMapAttachHelper;
import com.avito.android.avito_map.google.GoogleAvitoMapAttachHelper;
import com.avito.android.avito_map.yandex.YandexAvitoMapAttachHelper;
import com.avito.android.delivery.map.common.marker.ClusterMarkerManager;
import com.avito.android.delivery.map.common.marker.ClusterMarkerManagerImpl;
import com.avito.android.delivery.map.common.marker.calculator.ClusterRadiusCalculator;
import com.avito.android.delivery.map.common.marker.calculator.LowRarityClusterRadiusCalculator;
import com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingInteractor;
import com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingInteractorImpl;
import com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingViewModel;
import com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingViewModelFactory;
import com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingViewModelImpl;
import com.avito.android.delivery.map.start_ordering.DeliveryStartOrderingResourceProvider;
import com.avito.android.delivery.map.start_ordering.DeliveryStartOrderingResourceProviderImpl;
import com.avito.android.di.PerFragment;
import com.avito.android.util.preferences.GeoContract;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0001¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/avito/android/delivery/di/module/DeliveryRdsStartOrderingModule;", "", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/avito/android/delivery/map/start_ordering/DeliveryRdsStartOrderingViewModelFactory;", "viewModelFactory", "Lcom/avito/android/delivery/map/start_ordering/DeliveryRdsStartOrderingViewModel;", "provideDeliveryRdsStartOrderingViewModel$delivery_release", "(Landroidx/fragment/app/Fragment;Lcom/avito/android/delivery/map/start_ordering/DeliveryRdsStartOrderingViewModelFactory;)Lcom/avito/android/delivery/map/start_ordering/DeliveryRdsStartOrderingViewModel;", "provideDeliveryRdsStartOrderingViewModel", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/avito_map/AvitoMapAttachHelper;", "provideAvitoMapAttachHelper$delivery_release", "(Lcom/avito/android/Features;)Lcom/avito/android/avito_map/AvitoMapAttachHelper;", "provideAvitoMapAttachHelper", "<init>", "()V", "Dependencies", "delivery_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Dependencies.class, DeliveryRdsStartOrderingTrackerModule.class})
public final class DeliveryRdsStartOrderingModule {
    @NotNull
    public static final DeliveryRdsStartOrderingModule INSTANCE = new DeliveryRdsStartOrderingModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/avito/android/delivery/di/module/DeliveryRdsStartOrderingModule$Dependencies;", "", "Lcom/avito/android/delivery/map/start_ordering/DeliveryRdsStartOrderingInteractorImpl;", "interactor", "Lcom/avito/android/delivery/map/start_ordering/DeliveryRdsStartOrderingInteractor;", "bindsStartOrderingInteractor", "(Lcom/avito/android/delivery/map/start_ordering/DeliveryRdsStartOrderingInteractorImpl;)Lcom/avito/android/delivery/map/start_ordering/DeliveryRdsStartOrderingInteractor;", "Lcom/avito/android/delivery/map/start_ordering/DeliveryStartOrderingResourceProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/delivery/map/start_ordering/DeliveryStartOrderingResourceProvider;", "bindsStartOrderingResourceProvider", "(Lcom/avito/android/delivery/map/start_ordering/DeliveryStartOrderingResourceProviderImpl;)Lcom/avito/android/delivery/map/start_ordering/DeliveryStartOrderingResourceProvider;", "Lcom/avito/android/delivery/map/common/marker/calculator/LowRarityClusterRadiusCalculator;", "calculator", "Lcom/avito/android/delivery/map/common/marker/calculator/ClusterRadiusCalculator;", "bindLowRarityClusterRadiusCalculator", "(Lcom/avito/android/delivery/map/common/marker/calculator/LowRarityClusterRadiusCalculator;)Lcom/avito/android/delivery/map/common/marker/calculator/ClusterRadiusCalculator;", "Lcom/avito/android/delivery/map/common/marker/ClusterMarkerManagerImpl;", "manager", "Lcom/avito/android/delivery/map/common/marker/ClusterMarkerManager;", "bindDensityIndependentClusterMarkerManager", "(Lcom/avito/android/delivery/map/common/marker/ClusterMarkerManagerImpl;)Lcom/avito/android/delivery/map/common/marker/ClusterMarkerManager;", "delivery_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Dependencies {
        @PerFragment
        @Binds
        @NotNull
        ClusterMarkerManager bindDensityIndependentClusterMarkerManager(@NotNull ClusterMarkerManagerImpl clusterMarkerManagerImpl);

        @PerFragment
        @Binds
        @NotNull
        ClusterRadiusCalculator bindLowRarityClusterRadiusCalculator(@NotNull LowRarityClusterRadiusCalculator lowRarityClusterRadiusCalculator);

        @PerFragment
        @Binds
        @NotNull
        DeliveryRdsStartOrderingInteractor bindsStartOrderingInteractor(@NotNull DeliveryRdsStartOrderingInteractorImpl deliveryRdsStartOrderingInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        DeliveryStartOrderingResourceProvider bindsStartOrderingResourceProvider(@NotNull DeliveryStartOrderingResourceProviderImpl deliveryStartOrderingResourceProviderImpl);
    }

    @Provides
    @PerFragment
    @NotNull
    public final AvitoMapAttachHelper provideAvitoMapAttachHelper$delivery_release(@NotNull Features features) {
        Intrinsics.checkNotNullParameter(features, "features");
        if (features.getYandexMapOnDeliveryMap().invoke().booleanValue()) {
            return new YandexAvitoMapAttachHelper();
        }
        return new GoogleAvitoMapAttachHelper();
    }

    @Provides
    @PerFragment
    @NotNull
    public final DeliveryRdsStartOrderingViewModel provideDeliveryRdsStartOrderingViewModel$delivery_release(@NotNull Fragment fragment, @NotNull DeliveryRdsStartOrderingViewModelFactory deliveryRdsStartOrderingViewModelFactory) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(deliveryRdsStartOrderingViewModelFactory, "viewModelFactory");
        ViewModel viewModel = new ViewModelProvider(fragment, deliveryRdsStartOrderingViewModelFactory).get(DeliveryRdsStartOrderingViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(fragme…iewModelImpl::class.java)");
        return (DeliveryRdsStartOrderingViewModel) viewModel;
    }
}

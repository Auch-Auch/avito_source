package com.avito.android.item_map.di;

import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.Features;
import com.avito.android.avito_map.AvitoMapAttachHelper;
import com.avito.android.avito_map.amenity.AmenityMarkerIconFactory;
import com.avito.android.avito_map.amenity.AmenityMarkerIconFactoryImpl;
import com.avito.android.avito_map.google.GoogleAvitoMapAttachHelper;
import com.avito.android.avito_map.yandex.YandexAvitoMapAttachHelper;
import com.avito.android.di.PerFragment;
import com.avito.android.item_map.amenity.AmenityButtonsInteractor;
import com.avito.android.item_map.amenity.AmenityButtonsInteractorImpl;
import com.avito.android.item_map.amenity.AmenityButtonsPresenter;
import com.avito.android.item_map.amenity.AmenityButtonsPresenterImpl;
import com.avito.android.item_map.view.ItemMapPresenter;
import com.avito.android.item_map.view.ItemMapPresenterImpl;
import com.avito.android.item_map.view.ItemMapResourceProvider;
import com.avito.android.item_map.view.ItemMapResourcesProviderImpl;
import com.avito.android.item_map.view.ItemMapViewBottomSheetAdapter;
import com.avito.android.location.analytics.LocationAnalyticsInteractor;
import com.avito.android.location.analytics.LocationAnalyticsInteractorImpl;
import com.avito.android.location.di.module.FindLocationModule;
import com.avito.android.permissions.LocationPermissionDialogPresenter;
import com.avito.android.permissions.LocationPermissionDialogPresenterImpl;
import com.avito.android.permissions.LocationPermissionProvider;
import com.avito.android.permissions.LocationPermissionProviderImpl;
import com.avito.android.util.preferences.GeoContract;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/avito/android/item_map/di/ItemMapModule;", "", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/avito_map/AvitoMapAttachHelper;", "provideAvitoMapAttachHelper", "(Lcom/avito/android/Features;)Lcom/avito/android/avito_map/AvitoMapAttachHelper;", "Lcom/avito/android/permissions/LocationPermissionProvider;", GeoContract.PROVIDER, "Lcom/avito/android/permissions/LocationPermissionDialogPresenter;", "provideLocationPermissionDialogPresenter$item_map_release", "(Lcom/avito/android/permissions/LocationPermissionProvider;)Lcom/avito/android/permissions/LocationPermissionDialogPresenter;", "provideLocationPermissionDialogPresenter", "<init>", "()V", "Declarations", "item-map_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {FindLocationModule.class, Declarations.class})
public final class ItemMapModule {
    @NotNull
    public static final ItemMapModule INSTANCE = new ItemMapModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u0017\u001a\u00020\u0016H'¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0012\u001a\u00020\u001cH'¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020!2\u0006\u0010\u0003\u001a\u00020 H'¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020%2\u0006\u0010\r\u001a\u00020$H'¢\u0006\u0004\b&\u0010'¨\u0006("}, d2 = {"Lcom/avito/android/item_map/di/ItemMapModule$Declarations;", "", "Lcom/avito/android/permissions/LocationPermissionProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/permissions/LocationPermissionProvider;", "bindsLocationPermissionProvider", "(Lcom/avito/android/permissions/LocationPermissionProviderImpl;)Lcom/avito/android/permissions/LocationPermissionProvider;", "Lcom/avito/android/avito_map/amenity/AmenityMarkerIconFactoryImpl;", "factory", "Lcom/avito/android/avito_map/amenity/AmenityMarkerIconFactory;", "bindAmenityMarkerIconFactory", "(Lcom/avito/android/avito_map/amenity/AmenityMarkerIconFactoryImpl;)Lcom/avito/android/avito_map/amenity/AmenityMarkerIconFactory;", "Lcom/avito/android/item_map/amenity/AmenityButtonsInteractorImpl;", "interactor", "Lcom/avito/android/item_map/amenity/AmenityButtonsInteractor;", "bindAmenityButtonsInteractor", "(Lcom/avito/android/item_map/amenity/AmenityButtonsInteractorImpl;)Lcom/avito/android/item_map/amenity/AmenityButtonsInteractor;", "Lcom/avito/android/item_map/amenity/AmenityButtonsPresenterImpl;", "presenter", "Lcom/avito/android/item_map/amenity/AmenityButtonsPresenter;", "bindAmenityButtonsPresenter", "(Lcom/avito/android/item_map/amenity/AmenityButtonsPresenterImpl;)Lcom/avito/android/item_map/amenity/AmenityButtonsPresenter;", "Lcom/avito/android/item_map/view/ItemMapViewBottomSheetAdapter;", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bindItemMapViewBottomSheetAdapter", "(Lcom/avito/android/item_map/view/ItemMapViewBottomSheetAdapter;)Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/avito/android/item_map/view/ItemMapPresenterImpl;", "Lcom/avito/android/item_map/view/ItemMapPresenter;", "bindItemMapPresenter", "(Lcom/avito/android/item_map/view/ItemMapPresenterImpl;)Lcom/avito/android/item_map/view/ItemMapPresenter;", "Lcom/avito/android/item_map/view/ItemMapResourcesProviderImpl;", "Lcom/avito/android/item_map/view/ItemMapResourceProvider;", "bindItemMapResourcesProvider", "(Lcom/avito/android/item_map/view/ItemMapResourcesProviderImpl;)Lcom/avito/android/item_map/view/ItemMapResourceProvider;", "Lcom/avito/android/location/analytics/LocationAnalyticsInteractorImpl;", "Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;", "bindsLocationAnalyticsInteractor", "(Lcom/avito/android/location/analytics/LocationAnalyticsInteractorImpl;)Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;", "item-map_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        AmenityButtonsInteractor bindAmenityButtonsInteractor(@NotNull AmenityButtonsInteractorImpl amenityButtonsInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        AmenityButtonsPresenter bindAmenityButtonsPresenter(@NotNull AmenityButtonsPresenterImpl amenityButtonsPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        AmenityMarkerIconFactory bindAmenityMarkerIconFactory(@NotNull AmenityMarkerIconFactoryImpl amenityMarkerIconFactoryImpl);

        @PerFragment
        @Binds
        @NotNull
        ItemMapPresenter bindItemMapPresenter(@NotNull ItemMapPresenterImpl itemMapPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        ItemMapResourceProvider bindItemMapResourcesProvider(@NotNull ItemMapResourcesProviderImpl itemMapResourcesProviderImpl);

        @Binds
        @NotNull
        @PerFragment
        RecyclerView.Adapter<RecyclerView.ViewHolder> bindItemMapViewBottomSheetAdapter(@NotNull ItemMapViewBottomSheetAdapter itemMapViewBottomSheetAdapter);

        @PerFragment
        @Binds
        @NotNull
        LocationAnalyticsInteractor bindsLocationAnalyticsInteractor(@NotNull LocationAnalyticsInteractorImpl locationAnalyticsInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        LocationPermissionProvider bindsLocationPermissionProvider(@NotNull LocationPermissionProviderImpl locationPermissionProviderImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final AvitoMapAttachHelper provideAvitoMapAttachHelper(@NotNull Features features) {
        Intrinsics.checkNotNullParameter(features, "features");
        if (features.getYandexMapOnItemDetails().invoke().booleanValue()) {
            return new YandexAvitoMapAttachHelper();
        }
        return new GoogleAvitoMapAttachHelper();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final LocationPermissionDialogPresenter provideLocationPermissionDialogPresenter$item_map_release(@NotNull LocationPermissionProvider locationPermissionProvider) {
        Intrinsics.checkNotNullParameter(locationPermissionProvider, GeoContract.PROVIDER);
        return new LocationPermissionDialogPresenterImpl(locationPermissionProvider);
    }
}

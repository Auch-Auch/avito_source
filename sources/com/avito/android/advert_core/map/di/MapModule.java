package com.avito.android.advert_core.map.di;

import com.avito.android.Features;
import com.avito.android.advert_core.map.MapBlueprint;
import com.avito.android.advert_core.map.MapPresenter;
import com.avito.android.advert_core.map.MapPresenterImpl;
import com.avito.android.advert_core.map.google.GoogleMapBlueprint;
import com.avito.android.advert_core.map.yandex.YandexMapBlueprint;
import com.avito.android.avito_map.amenity.AmenityMarkerIconFactory;
import com.avito.android.avito_map.amenity.AmenityMarkerIconFactoryImpl;
import com.avito.android.di.PerFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\rB\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/advert_core/map/di/MapModule;", "", "Lcom/avito/android/advert_core/map/MapPresenter;", "presenter", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/avito_map/amenity/AmenityMarkerIconFactory;", "factory", "Lcom/avito/android/advert_core/map/MapBlueprint;", "provideMapBlueprint", "(Lcom/avito/android/advert_core/map/MapPresenter;Lcom/avito/android/Features;Lcom/avito/android/avito_map/amenity/AmenityMarkerIconFactory;)Lcom/avito/android/advert_core/map/MapBlueprint;", "<init>", "()V", "Declarations", "advert-core_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class MapModule {
    @NotNull
    public static final MapModule INSTANCE = new MapModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/advert_core/map/di/MapModule$Declarations;", "", "Lcom/avito/android/avito_map/amenity/AmenityMarkerIconFactoryImpl;", "factory", "Lcom/avito/android/avito_map/amenity/AmenityMarkerIconFactory;", "bindAmenityMarkerIconFactory", "(Lcom/avito/android/avito_map/amenity/AmenityMarkerIconFactoryImpl;)Lcom/avito/android/avito_map/amenity/AmenityMarkerIconFactory;", "Lcom/avito/android/advert_core/map/MapPresenterImpl;", "presenter", "Lcom/avito/android/advert_core/map/MapPresenter;", "bindGoogleMapPresenter", "(Lcom/avito/android/advert_core/map/MapPresenterImpl;)Lcom/avito/android/advert_core/map/MapPresenter;", "advert-core_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        AmenityMarkerIconFactory bindAmenityMarkerIconFactory(@NotNull AmenityMarkerIconFactoryImpl amenityMarkerIconFactoryImpl);

        @PerFragment
        @Binds
        @NotNull
        MapPresenter bindGoogleMapPresenter(@NotNull MapPresenterImpl mapPresenterImpl);
    }

    @Provides
    @PerFragment
    @NotNull
    public final MapBlueprint provideMapBlueprint(@NotNull MapPresenter mapPresenter, @NotNull Features features, @NotNull AmenityMarkerIconFactory amenityMarkerIconFactory) {
        Intrinsics.checkNotNullParameter(mapPresenter, "presenter");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(amenityMarkerIconFactory, "factory");
        if (features.getYandexMapsInDevelopmentsCatalog().invoke().booleanValue()) {
            return new YandexMapBlueprint(mapPresenter, amenityMarkerIconFactory);
        }
        return new GoogleMapBlueprint(mapPresenter, amenityMarkerIconFactory);
    }
}

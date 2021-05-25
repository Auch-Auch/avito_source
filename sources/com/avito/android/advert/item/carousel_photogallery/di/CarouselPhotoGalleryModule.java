package com.avito.android.advert.item.carousel_photogallery.di;

import com.avito.android.advert.di.AdvertFragmentModule;
import com.avito.android.advert.item.carousel_photogallery.CarouselPhotoGalleryBlueprint;
import com.avito.android.advert.item.carousel_photogallery.CarouselPhotoGalleryPresenter;
import com.avito.android.advert.item.carousel_photogallery.CarouselPhotoGalleryPresenterImpl;
import com.avito.android.di.PerFragment;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/advert/item/carousel_photogallery/di/CarouselPhotoGalleryModule;", "", "Lcom/avito/android/advert/item/carousel_photogallery/CarouselPhotoGalleryPresenterImpl;", "presenter", "Lcom/avito/android/advert/item/carousel_photogallery/CarouselPhotoGalleryPresenter;", "bindPhotoGalleryPresenter", "(Lcom/avito/android/advert/item/carousel_photogallery/CarouselPhotoGalleryPresenterImpl;)Lcom/avito/android/advert/item/carousel_photogallery/CarouselPhotoGalleryPresenter;", "Lcom/avito/android/advert/item/carousel_photogallery/CarouselPhotoGalleryBlueprint;", "blueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "bindPhotoGalleryBlueprint", "(Lcom/avito/android/advert/item/carousel_photogallery/CarouselPhotoGalleryBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "advert-details_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface CarouselPhotoGalleryModule {
    @AdvertFragmentModule.AdvertBlueprints
    @Binds
    @IntoSet
    @NotNull
    @PerFragment
    ItemBlueprint<?, ?> bindPhotoGalleryBlueprint(@NotNull CarouselPhotoGalleryBlueprint carouselPhotoGalleryBlueprint);

    @PerFragment
    @Binds
    @NotNull
    CarouselPhotoGalleryPresenter bindPhotoGalleryPresenter(@NotNull CarouselPhotoGalleryPresenterImpl carouselPhotoGalleryPresenterImpl);
}

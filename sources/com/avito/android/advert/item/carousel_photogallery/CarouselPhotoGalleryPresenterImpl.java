package com.avito.android.advert.item.carousel_photogallery;

import com.avito.android.advert.item.AdvertDetailsItemsPresenter;
import com.avito.android.advert.item.AdvertDetailsPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u0018¢\u0006\u0004\b\u001c\u0010\u001dJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/avito/android/advert/item/carousel_photogallery/CarouselPhotoGalleryPresenterImpl;", "Lcom/avito/android/advert/item/carousel_photogallery/CarouselPhotoGalleryPresenter;", "Lcom/avito/android/advert/item/carousel_photogallery/CarouselPhotoGalleryView;", "view", "Lcom/avito/android/advert/item/carousel_photogallery/CarouselPhotoGalleryItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/advert/item/carousel_photogallery/CarouselPhotoGalleryView;Lcom/avito/android/advert/item/carousel_photogallery/CarouselPhotoGalleryItem;I)V", "", "stateId", "onPageSelected", "(IJ)V", "onPhotoGalleryClick", "(I)V", "onVideoGalleryClick", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert/item/carousel_photogallery/CarouselPhotoGalleryItem;", "Lcom/avito/android/advert/item/AdvertDetailsPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert/item/AdvertDetailsPresenter;", "presenter", "Lcom/avito/android/advert/item/AdvertDetailsItemsPresenter;", "c", "Lcom/avito/android/advert/item/AdvertDetailsItemsPresenter;", "itemsPresenter", "<init>", "(Lcom/avito/android/advert/item/AdvertDetailsPresenter;Lcom/avito/android/advert/item/AdvertDetailsItemsPresenter;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class CarouselPhotoGalleryPresenterImpl implements CarouselPhotoGalleryPresenter {
    public CarouselPhotoGalleryItem a;
    public final AdvertDetailsPresenter b;
    public final AdvertDetailsItemsPresenter c;

    @Inject
    public CarouselPhotoGalleryPresenterImpl(@NotNull AdvertDetailsPresenter advertDetailsPresenter, @NotNull AdvertDetailsItemsPresenter advertDetailsItemsPresenter) {
        Intrinsics.checkNotNullParameter(advertDetailsPresenter, "presenter");
        Intrinsics.checkNotNullParameter(advertDetailsItemsPresenter, "itemsPresenter");
        this.b = advertDetailsPresenter;
        this.c = advertDetailsItemsPresenter;
    }

    @Override // com.avito.android.photo_gallery.common.GalleryPageListener
    public void onPageSelected(int i, long j) {
        CarouselPhotoGalleryItem carouselPhotoGalleryItem = this.a;
        if (carouselPhotoGalleryItem == null || carouselPhotoGalleryItem.getCurrentPosition() != i) {
            this.c.onPageSelected(i, j);
        }
    }

    @Override // com.avito.android.photo_gallery.common.GalleryActionListener
    public void onPhotoGalleryClick(int i) {
        AdvertDetailsPresenter advertDetailsPresenter = this.b;
        CarouselPhotoGalleryItem carouselPhotoGalleryItem = this.a;
        advertDetailsPresenter.handleGalleryClick(i, carouselPhotoGalleryItem != null ? Long.valueOf(carouselPhotoGalleryItem.getStateId()) : null);
    }

    @Override // com.avito.android.photo_gallery.common.GalleryActionListener
    public void onVideoGalleryClick(int i) {
        AdvertDetailsPresenter advertDetailsPresenter = this.b;
        CarouselPhotoGalleryItem carouselPhotoGalleryItem = this.a;
        advertDetailsPresenter.handleVideoGalleryClick(i, carouselPhotoGalleryItem != null ? Long.valueOf(carouselPhotoGalleryItem.getStateId()) : null);
    }

    public void bindView(@NotNull CarouselPhotoGalleryView carouselPhotoGalleryView, @NotNull CarouselPhotoGalleryItem carouselPhotoGalleryItem, int i) {
        Intrinsics.checkNotNullParameter(carouselPhotoGalleryView, "view");
        Intrinsics.checkNotNullParameter(carouselPhotoGalleryItem, "item");
        this.a = carouselPhotoGalleryItem;
        carouselPhotoGalleryView.bindGallery(carouselPhotoGalleryItem.getImages(), carouselPhotoGalleryItem.getVideo(), carouselPhotoGalleryItem.getStateId(), this, this, carouselPhotoGalleryItem.getCurrentPosition(), carouselPhotoGalleryItem.getInfoImage());
    }
}

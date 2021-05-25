package com.avito.android.advert.item.photogallery;

import com.avito.android.advert.item.AdvertDetailsFragmentDelegate;
import com.avito.android.advert.item.AdvertDetailsItemsPresenter;
import com.avito.android.advert.item.AdvertDetailsPresenter;
import com.avito.android.advert.item.photogallery.AdvertDetailsGalleryView;
import com.avito.android.analytics.screens.AdvertScreen;
import com.avito.android.photo_gallery.common.GalleryActionListener;
import com.avito.android.photo_gallery.common.GalleryPageListener;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B!\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\"\u0010#J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/avito/android/advert/item/photogallery/AdvertDetailsGalleryPresenterImpl;", "Lcom/avito/android/advert/item/photogallery/AdvertDetailsGalleryPresenter;", "Lcom/avito/android/photo_gallery/common/GalleryPageListener;", "Lcom/avito/android/photo_gallery/common/GalleryActionListener;", "Lcom/avito/android/advert/item/photogallery/AdvertDetailsGalleryView;", "view", "Lcom/avito/android/advert/item/photogallery/AdvertDetailsGalleryItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/advert/item/photogallery/AdvertDetailsGalleryView;Lcom/avito/android/advert/item/photogallery/AdvertDetailsGalleryItem;I)V", "", "stateId", "onPageSelected", "(IJ)V", "onPhotoGalleryClick", "(I)V", "onVideoGalleryClick", "Lcom/avito/android/advert/item/AdvertDetailsFragmentDelegate;", "d", "Lcom/avito/android/advert/item/AdvertDetailsFragmentDelegate;", "advertDetailsDelegate", "Lcom/avito/android/advert/item/AdvertDetailsPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert/item/AdvertDetailsPresenter;", "presenter", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert/item/photogallery/AdvertDetailsGalleryItem;", "Lcom/avito/android/advert/item/AdvertDetailsItemsPresenter;", "c", "Lcom/avito/android/advert/item/AdvertDetailsItemsPresenter;", "itemsPresenter", "<init>", "(Lcom/avito/android/advert/item/AdvertDetailsPresenter;Lcom/avito/android/advert/item/AdvertDetailsItemsPresenter;Lcom/avito/android/advert/item/AdvertDetailsFragmentDelegate;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsGalleryPresenterImpl implements AdvertDetailsGalleryPresenter, GalleryPageListener, GalleryActionListener {
    public AdvertDetailsGalleryItem a;
    public final AdvertDetailsPresenter b;
    public final AdvertDetailsItemsPresenter c;
    public final AdvertDetailsFragmentDelegate d;

    @Inject
    public AdvertDetailsGalleryPresenterImpl(@NotNull AdvertDetailsPresenter advertDetailsPresenter, @NotNull AdvertDetailsItemsPresenter advertDetailsItemsPresenter, @NotNull AdvertDetailsFragmentDelegate advertDetailsFragmentDelegate) {
        Intrinsics.checkNotNullParameter(advertDetailsPresenter, "presenter");
        Intrinsics.checkNotNullParameter(advertDetailsItemsPresenter, "itemsPresenter");
        Intrinsics.checkNotNullParameter(advertDetailsFragmentDelegate, "advertDetailsDelegate");
        this.b = advertDetailsPresenter;
        this.c = advertDetailsItemsPresenter;
        this.d = advertDetailsFragmentDelegate;
    }

    @Override // com.avito.android.photo_gallery.common.GalleryPageListener
    public void onPageSelected(int i, long j) {
        AdvertDetailsGalleryItem advertDetailsGalleryItem = this.a;
        if (advertDetailsGalleryItem == null || advertDetailsGalleryItem.getCurrentPosition() != i) {
            this.c.onPageSelected(i, j);
            this.b.handleGalleryChangePosition(i);
        }
    }

    @Override // com.avito.android.photo_gallery.common.GalleryActionListener
    public void onPhotoGalleryClick(int i) {
        AdvertDetailsPresenter advertDetailsPresenter = this.b;
        AdvertDetailsGalleryItem advertDetailsGalleryItem = this.a;
        advertDetailsPresenter.handleGalleryClick(i, advertDetailsGalleryItem != null ? Long.valueOf(advertDetailsGalleryItem.getStateId()) : null);
    }

    @Override // com.avito.android.photo_gallery.common.GalleryActionListener
    public void onVideoGalleryClick(int i) {
        AdvertDetailsPresenter advertDetailsPresenter = this.b;
        AdvertDetailsGalleryItem advertDetailsGalleryItem = this.a;
        advertDetailsPresenter.handleVideoGalleryClick(i, advertDetailsGalleryItem != null ? Long.valueOf(advertDetailsGalleryItem.getStateId()) : null);
    }

    public void bindView(@NotNull AdvertDetailsGalleryView advertDetailsGalleryView, @NotNull AdvertDetailsGalleryItem advertDetailsGalleryItem, int i) {
        Intrinsics.checkNotNullParameter(advertDetailsGalleryView, "view");
        Intrinsics.checkNotNullParameter(advertDetailsGalleryItem, "item");
        this.a = advertDetailsGalleryItem;
        AdvertDetailsGalleryView.DefaultImpls.bindGallery$default(advertDetailsGalleryView, advertDetailsGalleryItem.getImages(), advertDetailsGalleryItem.getVideo(), advertDetailsGalleryItem.getCpoTeaser(), advertDetailsGalleryItem.getAdvertId(), this.d, this, this, advertDetailsGalleryItem.getCurrentPosition(), 0, AdvertScreen.INSTANCE, advertDetailsGalleryItem.getInfoImage(), advertDetailsGalleryItem.getAutotekaTeaser(), 256, null);
    }
}

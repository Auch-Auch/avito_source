package com.avito.android.developments_catalog.items.photoGallery;

import com.avito.android.developments_catalog.DevelopmentsCatalogFragmentManagerDelegate;
import com.avito.android.developments_catalog.DevelopmentsCatalogRouter;
import com.avito.android.photo_gallery.common.GalleryPageListener;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B#\b\u0007\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001c\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b$\u0010%J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\fJ\u0019\u0010\u0010\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lcom/avito/android/developments_catalog/items/photoGallery/PhotoGalleryPresenterImpl;", "Lcom/avito/android/developments_catalog/items/photoGallery/PhotoGalleryPresenter;", "Lcom/avito/android/developments_catalog/items/photoGallery/PhotoGalleryView;", "view", "Lcom/avito/android/developments_catalog/items/photoGallery/PhotoGalleryItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/developments_catalog/items/photoGallery/PhotoGalleryView;Lcom/avito/android/developments_catalog/items/photoGallery/PhotoGalleryItem;I)V", "onPhotoGalleryClick", "(I)V", "onVideoGalleryClick", "Lcom/avito/android/developments_catalog/DevelopmentsCatalogRouter;", "router", "attachRouter", "(Lcom/avito/android/developments_catalog/DevelopmentsCatalogRouter;)V", "detachRouter", "()V", "Lcom/avito/android/photo_gallery/common/GalleryPageListener;", "e", "Lcom/avito/android/photo_gallery/common/GalleryPageListener;", "galleryPageListener", AuthSource.SEND_ABUSE, "Lcom/avito/android/developments_catalog/items/photoGallery/PhotoGalleryItem;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/developments_catalog/DevelopmentsCatalogRouter;", "", "c", "Ljava/lang/String;", "searchContext", "Lcom/avito/android/developments_catalog/DevelopmentsCatalogFragmentManagerDelegate;", "d", "Lcom/avito/android/developments_catalog/DevelopmentsCatalogFragmentManagerDelegate;", "fragmentManagerDelegate", "<init>", "(Ljava/lang/String;Lcom/avito/android/developments_catalog/DevelopmentsCatalogFragmentManagerDelegate;Lcom/avito/android/photo_gallery/common/GalleryPageListener;)V", "developments-catalog_release"}, k = 1, mv = {1, 4, 2})
public final class PhotoGalleryPresenterImpl implements PhotoGalleryPresenter {
    public PhotoGalleryItem a;
    public DevelopmentsCatalogRouter b;
    public final String c;
    public final DevelopmentsCatalogFragmentManagerDelegate d;
    public final GalleryPageListener e;

    @Inject
    public PhotoGalleryPresenterImpl(@Nullable String str, @NotNull DevelopmentsCatalogFragmentManagerDelegate developmentsCatalogFragmentManagerDelegate, @NotNull GalleryPageListener galleryPageListener) {
        Intrinsics.checkNotNullParameter(developmentsCatalogFragmentManagerDelegate, "fragmentManagerDelegate");
        Intrinsics.checkNotNullParameter(galleryPageListener, "galleryPageListener");
        this.c = str;
        this.d = developmentsCatalogFragmentManagerDelegate;
        this.e = galleryPageListener;
    }

    @Override // com.avito.android.developments_catalog.items.photoGallery.PhotoGalleryPresenter
    public void attachRouter(@Nullable DevelopmentsCatalogRouter developmentsCatalogRouter) {
        this.b = developmentsCatalogRouter;
    }

    @Override // com.avito.android.developments_catalog.items.photoGallery.PhotoGalleryPresenter
    public void detachRouter() {
        this.b = null;
    }

    @Override // com.avito.android.photo_gallery.common.GalleryActionListener
    public void onPhotoGalleryClick(int i) {
        DevelopmentsCatalogRouter developmentsCatalogRouter = this.b;
        if (developmentsCatalogRouter != null) {
            PhotoGalleryItem photoGalleryItem = this.a;
            Long l = null;
            List<Image> images = photoGalleryItem != null ? photoGalleryItem.getImages() : null;
            PhotoGalleryItem photoGalleryItem2 = this.a;
            if (photoGalleryItem2 != null) {
                l = Long.valueOf(photoGalleryItem2.getStateId());
            }
            developmentsCatalogRouter.showFullscreenGallery(i, images, l, this.c);
        }
    }

    @Override // com.avito.android.photo_gallery.common.GalleryActionListener
    public void onVideoGalleryClick(int i) {
    }

    public void bindView(@NotNull PhotoGalleryView photoGalleryView, @NotNull PhotoGalleryItem photoGalleryItem, int i) {
        Intrinsics.checkNotNullParameter(photoGalleryView, "view");
        Intrinsics.checkNotNullParameter(photoGalleryItem, "item");
        this.a = photoGalleryItem;
        photoGalleryView.bindGallery(photoGalleryItem.getImages(), this.d, this.e, this, photoGalleryItem.getCurrentPosition(), photoGalleryItem.getStateId());
    }
}

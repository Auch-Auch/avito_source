package com.avito.android.developments_catalog.items.photoGallery;

import com.avito.android.developments_catalog.DevelopmentsCatalogFragmentManagerDelegate;
import com.avito.android.photo_gallery.common.GalleryActionListener;
import com.avito.android.photo_gallery.common.GalleryPageListener;
import com.avito.android.remote.model.Image;
import com.avito.konveyor.blueprint.ItemView;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001JS\u0010\u0010\u001a\u00020\u000f2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000bH&¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/avito/android/developments_catalog/items/photoGallery/PhotoGalleryView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "Lcom/avito/android/remote/model/Image;", "images", "Lcom/avito/android/developments_catalog/DevelopmentsCatalogFragmentManagerDelegate;", "fragmentManagerDelegate", "Lcom/avito/android/photo_gallery/common/GalleryPageListener;", "galleryPageListener", "Lcom/avito/android/photo_gallery/common/GalleryActionListener;", "galleryActionListener", "", "currentPosition", "", "stateId", "", "bindGallery", "(Ljava/util/List;Lcom/avito/android/developments_catalog/DevelopmentsCatalogFragmentManagerDelegate;Lcom/avito/android/photo_gallery/common/GalleryPageListener;Lcom/avito/android/photo_gallery/common/GalleryActionListener;IJ)V", VKApiConst.POSITION, "setCurrentPosition", "(I)V", "()I", "developments-catalog_release"}, k = 1, mv = {1, 4, 2})
public interface PhotoGalleryView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void bindGallery$default(PhotoGalleryView photoGalleryView, List list, DevelopmentsCatalogFragmentManagerDelegate developmentsCatalogFragmentManagerDelegate, GalleryPageListener galleryPageListener, GalleryActionListener galleryActionListener, int i, long j, int i2, Object obj) {
            if (obj == null) {
                photoGalleryView.bindGallery(list, developmentsCatalogFragmentManagerDelegate, (i2 & 4) != 0 ? null : galleryPageListener, (i2 & 8) != 0 ? null : galleryActionListener, (i2 & 16) != 0 ? -1 : i, (i2 & 32) != 0 ? -1 : j);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bindGallery");
        }

        public static void onUnbind(@NotNull PhotoGalleryView photoGalleryView) {
            ItemView.DefaultImpls.onUnbind(photoGalleryView);
        }
    }

    void bindGallery(@Nullable List<Image> list, @NotNull DevelopmentsCatalogFragmentManagerDelegate developmentsCatalogFragmentManagerDelegate, @Nullable GalleryPageListener galleryPageListener, @Nullable GalleryActionListener galleryActionListener, int i, long j);

    int currentPosition();

    void setCurrentPosition(int i);
}

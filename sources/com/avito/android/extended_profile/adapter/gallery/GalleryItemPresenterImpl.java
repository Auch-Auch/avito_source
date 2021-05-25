package com.avito.android.extended_profile.adapter.gallery;

import com.avito.android.remote.model.TnsGalleryImage;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/extended_profile/adapter/gallery/GalleryItemPresenterImpl;", "Lcom/avito/android/extended_profile/adapter/gallery/GalleryItemPresenter;", "Lcom/avito/android/extended_profile/adapter/gallery/GalleryItemView;", "view", "Lcom/avito/android/extended_profile/adapter/gallery/GalleryItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/extended_profile/adapter/gallery/GalleryItemView;Lcom/avito/android/extended_profile/adapter/gallery/GalleryItem;I)V", "<init>", "()V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public final class GalleryItemPresenterImpl implements GalleryItemPresenter {
    public void bindView(@NotNull GalleryItemView galleryItemView, @NotNull GalleryItem galleryItem, int i) {
        Intrinsics.checkNotNullParameter(galleryItemView, "view");
        Intrinsics.checkNotNullParameter(galleryItem, "item");
        galleryItemView.showTitle(galleryItem.getTitle());
        List<TnsGalleryImage> images = galleryItem.getImages();
        if (images == null || images.isEmpty()) {
            galleryItemView.getGalleryView().hideGallery();
        } else {
            galleryItemView.getGalleryView().showGallery(galleryItem.getImages());
        }
    }
}

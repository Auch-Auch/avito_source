package com.avito.android.advert.item.carousel_photogallery;

import com.avito.android.photo_gallery.common.GalleryActionListener;
import com.avito.android.photo_gallery.common.GalleryPageListener;
import com.avito.android.remote.model.ForegroundImage;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.Video;
import com.avito.konveyor.blueprint.ItemView;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J]\u0010\u0012\u001a\u00020\u00112\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\rH&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000e\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/avito/android/advert/item/carousel_photogallery/CarouselPhotoGalleryView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "Lcom/avito/android/remote/model/Image;", "images", "Lcom/avito/android/remote/model/Video;", "video", "", "stateId", "Lcom/avito/android/photo_gallery/common/GalleryPageListener;", "galleryPageListener", "Lcom/avito/android/photo_gallery/common/GalleryActionListener;", "galleryActionListener", "", "currentPosition", "Lcom/avito/android/remote/model/ForegroundImage;", "infoImage", "", "bindGallery", "(Ljava/util/List;Lcom/avito/android/remote/model/Video;JLcom/avito/android/photo_gallery/common/GalleryPageListener;Lcom/avito/android/photo_gallery/common/GalleryActionListener;ILcom/avito/android/remote/model/ForegroundImage;)V", VKApiConst.POSITION, "setCurrentPosition", "(I)V", "()I", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface CarouselPhotoGalleryView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void bindGallery$default(CarouselPhotoGalleryView carouselPhotoGalleryView, List list, Video video, long j, GalleryPageListener galleryPageListener, GalleryActionListener galleryActionListener, int i, ForegroundImage foregroundImage, int i2, Object obj) {
            if (obj == null) {
                carouselPhotoGalleryView.bindGallery(list, video, j, (i2 & 8) != 0 ? null : galleryPageListener, (i2 & 16) != 0 ? null : galleryActionListener, (i2 & 32) != 0 ? -1 : i, foregroundImage);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bindGallery");
        }

        public static void onUnbind(@NotNull CarouselPhotoGalleryView carouselPhotoGalleryView) {
            ItemView.DefaultImpls.onUnbind(carouselPhotoGalleryView);
        }
    }

    void bindGallery(@Nullable List<Image> list, @Nullable Video video, long j, @Nullable GalleryPageListener galleryPageListener, @Nullable GalleryActionListener galleryActionListener, int i, @Nullable ForegroundImage foregroundImage);

    int currentPosition();

    void setCurrentPosition(int i);
}

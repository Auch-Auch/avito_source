package com.avito.android.advert.item.photogallery;

import com.avito.android.advert.item.AdvertDetailsFragmentDelegate;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.photo_gallery.common.GalleryActionListener;
import com.avito.android.photo_gallery.common.GalleryPageListener;
import com.avito.android.remote.model.AutotekaCpoTeaser;
import com.avito.android.remote.model.AutotekaTeaserResult;
import com.avito.android.remote.model.ForegroundImage;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.Video;
import com.avito.konveyor.blueprint.ItemView;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u0001\u0010\u001c\u001a\u00020\u001b2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H&¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u0011H&¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0012\u0010!J\u000f\u0010\"\u001a\u00020\u001bH&¢\u0006\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/avito/android/advert/item/photogallery/AdvertDetailsGalleryView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "Lcom/avito/android/remote/model/Image;", "images", "Lcom/avito/android/remote/model/Video;", "video", "Lcom/avito/android/remote/model/AutotekaCpoTeaser;", "cpoTeaser", "", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/advert/item/AdvertDetailsFragmentDelegate;", "advertDetailsDelegate", "Lcom/avito/android/photo_gallery/common/GalleryPageListener;", "galleryPageListener", "Lcom/avito/android/photo_gallery/common/GalleryActionListener;", "advertDetailsGalleryActionHandler", "", "currentPosition", "", "stateId", "Lcom/avito/android/analytics/screens/Screen;", InternalConstsKt.SCREEN, "Lcom/avito/android/remote/model/ForegroundImage;", "foregroundImage", "Lcom/avito/android/remote/model/AutotekaTeaserResult;", "autotekaTeaser", "", "bindGallery", "(Ljava/util/List;Lcom/avito/android/remote/model/Video;Lcom/avito/android/remote/model/AutotekaCpoTeaser;Ljava/lang/String;Lcom/avito/android/advert/item/AdvertDetailsFragmentDelegate;Lcom/avito/android/photo_gallery/common/GalleryPageListener;Lcom/avito/android/photo_gallery/common/GalleryActionListener;IJLcom/avito/android/analytics/screens/Screen;Lcom/avito/android/remote/model/ForegroundImage;Lcom/avito/android/remote/model/AutotekaTeaserResult;)V", VKApiConst.POSITION, "setCurrentPosition", "(I)V", "()I", "removeListener", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsGalleryView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void bindGallery$default(AdvertDetailsGalleryView advertDetailsGalleryView, List list, Video video, AutotekaCpoTeaser autotekaCpoTeaser, String str, AdvertDetailsFragmentDelegate advertDetailsFragmentDelegate, GalleryPageListener galleryPageListener, GalleryActionListener galleryActionListener, int i, long j, Screen screen, ForegroundImage foregroundImage, AutotekaTeaserResult autotekaTeaserResult, int i2, Object obj) {
            if (obj == null) {
                advertDetailsGalleryView.bindGallery(list, video, autotekaCpoTeaser, str, advertDetailsFragmentDelegate, (i2 & 32) != 0 ? null : galleryPageListener, (i2 & 64) != 0 ? null : galleryActionListener, (i2 & 128) != 0 ? -1 : i, (i2 & 256) != 0 ? -1 : j, screen, (i2 & 1024) != 0 ? null : foregroundImage, autotekaTeaserResult);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bindGallery");
        }

        public static void onUnbind(@NotNull AdvertDetailsGalleryView advertDetailsGalleryView) {
            ItemView.DefaultImpls.onUnbind(advertDetailsGalleryView);
        }
    }

    void bindGallery(@Nullable List<Image> list, @Nullable Video video, @Nullable AutotekaCpoTeaser autotekaCpoTeaser, @Nullable String str, @NotNull AdvertDetailsFragmentDelegate advertDetailsFragmentDelegate, @Nullable GalleryPageListener galleryPageListener, @Nullable GalleryActionListener galleryActionListener, int i, long j, @NotNull Screen screen, @Nullable ForegroundImage foregroundImage, @Nullable AutotekaTeaserResult autotekaTeaserResult);

    int currentPosition();

    void removeListener();

    void setCurrentPosition(int i);
}

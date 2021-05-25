package com.avito.android.photo_gallery.adapter;

import com.avito.android.photo_gallery.adapter.GalleryItem;
import com.avito.android.remote.model.ForegroundImage;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.Video;
import com.avito.android.remote.model.autoteka.AutotekaTeaserGalleryModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001aE\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000b\"\u0016\u0010\r\u001a\u00020\f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/remote/model/Video;", "video", "", "Lcom/avito/android/remote/model/Image;", "items", "Lcom/avito/android/remote/model/ForegroundImage;", "foregroundImage", "Lcom/avito/android/remote/model/autoteka/AutotekaTeaserGalleryModel;", "autotekaTeaser", "Lcom/avito/android/photo_gallery/adapter/GalleryItem;", "photoGalleryCollectItems", "(Lcom/avito/android/remote/model/Video;Ljava/util/List;Lcom/avito/android/remote/model/ForegroundImage;Lcom/avito/android/remote/model/autoteka/AutotekaTeaserGalleryModel;)Ljava/util/List;", "", "GALLERY_VIDEO_POSITION", "I", "photo-gallery_release"}, k = 2, mv = {1, 4, 2})
public final class GalleryAdapterKt {
    public static final int GALLERY_VIDEO_POSITION = 1;

    @NotNull
    public static final List<GalleryItem> photoGalleryCollectItems(@Nullable Video video, @Nullable List<Image> list, @Nullable ForegroundImage foregroundImage, @Nullable AutotekaTeaserGalleryModel autotekaTeaserGalleryModel) {
        ArrayList arrayList = new ArrayList();
        if (foregroundImage != null) {
            arrayList.add(new GalleryItem.GalleryForegroundImage(foregroundImage));
        }
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new GalleryItem.GalleryImage(it.next()));
            }
        }
        if (video != null && video.hasPreviewImage()) {
            arrayList.add(Math.min(arrayList.size(), 1), new GalleryItem.GalleryVideo(video));
        }
        if (autotekaTeaserGalleryModel != null) {
            arrayList.add(new GalleryItem.GalleryTeaserAutoteka(autotekaTeaserGalleryModel));
        }
        return arrayList;
    }

    public static /* synthetic */ List photoGalleryCollectItems$default(Video video, List list, ForegroundImage foregroundImage, AutotekaTeaserGalleryModel autotekaTeaserGalleryModel, int i, Object obj) {
        if ((i & 4) != 0) {
            foregroundImage = null;
        }
        if ((i & 8) != 0) {
            autotekaTeaserGalleryModel = null;
        }
        return photoGalleryCollectItems(video, list, foregroundImage, autotekaTeaserGalleryModel);
    }
}

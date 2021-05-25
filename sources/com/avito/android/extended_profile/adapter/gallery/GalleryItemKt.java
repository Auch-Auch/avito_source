package com.avito.android.extended_profile.adapter.gallery;

import com.avito.android.remote.model.ExtendedProfileGallery;
import com.avito.android.remote.model.ExtendedProfileGalleryElement;
import com.avito.android.remote.model.TnsGalleryImage;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/remote/model/ExtendedProfileGallery;", "Lcom/avito/android/extended_profile/adapter/gallery/GalleryItem;", "toGalleryItem", "(Lcom/avito/android/remote/model/ExtendedProfileGallery;)Lcom/avito/android/extended_profile/adapter/gallery/GalleryItem;", "extended-profile_release"}, k = 2, mv = {1, 4, 2})
public final class GalleryItemKt {
    @NotNull
    public static final GalleryItem toGalleryItem(@NotNull ExtendedProfileGallery extendedProfileGallery) {
        Intrinsics.checkNotNullParameter(extendedProfileGallery, "$this$toGalleryItem");
        String title = extendedProfileGallery.getTitle();
        List<ExtendedProfileGalleryElement> images = extendedProfileGallery.getImages();
        return new GalleryItem(null, null, title, images != null ? j.filterIsInstance(images, TnsGalleryImage.class) : null, 3, null);
    }
}

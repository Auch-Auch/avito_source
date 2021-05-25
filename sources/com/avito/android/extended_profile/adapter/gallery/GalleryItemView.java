package com.avito.android.extended_profile.adapter.gallery;

import com.avito.android.tns_gallery.TnsGalleryView;
import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/avito/android/extended_profile/adapter/gallery/GalleryItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "title", "", "showTitle", "(Ljava/lang/CharSequence;)V", "Lcom/avito/android/tns_gallery/TnsGalleryView;", "getGalleryView", "()Lcom/avito/android/tns_gallery/TnsGalleryView;", "galleryView", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public interface GalleryItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull GalleryItemView galleryItemView) {
            ItemView.DefaultImpls.onUnbind(galleryItemView);
        }
    }

    @NotNull
    TnsGalleryView getGalleryView();

    void showTitle(@Nullable CharSequence charSequence);
}

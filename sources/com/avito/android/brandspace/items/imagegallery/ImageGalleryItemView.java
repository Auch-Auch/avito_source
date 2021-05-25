package com.avito.android.brandspace.items.imagegallery;

import com.avito.android.remote.model.Image;
import com.avito.konveyor.blueprint.ItemView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/brandspace/items/imagegallery/ImageGalleryItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/remote/model/Image;", "image", "", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "", "bind", "(Lcom/avito/android/remote/model/Image;I)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public interface ImageGalleryItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull ImageGalleryItemView imageGalleryItemView) {
            ItemView.DefaultImpls.onUnbind(imageGalleryItemView);
        }
    }

    void bind(@NotNull Image image, int i);
}

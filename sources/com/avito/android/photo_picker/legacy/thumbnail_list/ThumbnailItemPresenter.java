package com.avito.android.photo_picker.legacy.thumbnail_list;

import com.avito.android.util.Rotation;
import com.avito.konveyor.blueprint.ItemPresenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\tJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/avito/android/photo_picker/legacy/thumbnail_list/ThumbnailItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/photo_picker/legacy/thumbnail_list/ThumbnailItemView;", "Lcom/avito/android/photo_picker/legacy/thumbnail_list/BasePhotoItem;", "Lcom/avito/android/util/Rotation;", "newRotation", "", "setRotation", "(Lcom/avito/android/util/Rotation;)V", "Listener", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public interface ThumbnailItemPresenter extends ItemPresenter<ThumbnailItemView, BasePhotoItem> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/photo_picker/legacy/thumbnail_list/ThumbnailItemPresenter$Listener;", "", "", "id", "", "onThumbnailClicked", "(Ljava/lang/String;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
    public interface Listener {
        void onThumbnailClicked(@NotNull String str);
    }

    void setRotation(@NotNull Rotation rotation);
}

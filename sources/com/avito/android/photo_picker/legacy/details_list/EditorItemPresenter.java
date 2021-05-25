package com.avito.android.photo_picker.legacy.details_list;

import com.avito.android.krop.util.Transformation;
import com.avito.android.photo_picker.legacy.thumbnail_list.BasePhotoItem;
import com.avito.konveyor.blueprint.ItemPresenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/photo_picker/legacy/details_list/EditorItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/photo_picker/legacy/details_list/EditorItemView;", "Lcom/avito/android/photo_picker/legacy/thumbnail_list/BasePhotoItem;", "Listener", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public interface EditorItemPresenter extends ItemPresenter<EditorItemView, BasePhotoItem> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/photo_picker/legacy/details_list/EditorItemPresenter$Listener;", "", "", "id", "", "onRemovePhoto", "(Ljava/lang/String;)V", "Lcom/avito/android/krop/util/Transformation;", "transformation", "onPhotoCropped", "(Ljava/lang/String;Lcom/avito/android/krop/util/Transformation;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
    public interface Listener {
        void onPhotoCropped(@NotNull String str, @NotNull Transformation transformation);

        void onRemovePhoto(@NotNull String str);
    }
}

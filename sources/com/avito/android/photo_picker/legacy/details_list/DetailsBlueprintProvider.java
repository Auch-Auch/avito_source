package com.avito.android.photo_picker.legacy.details_list;

import com.avito.android.photo_picker.legacy.thumbnail_list.BasePhotoItem;
import com.avito.konveyor.blueprint.ItemBlueprint;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0002H&¢\u0006\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/photo_picker/legacy/details_list/DetailsBlueprintProvider;", "", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/photo_picker/legacy/details_list/CameraItemView;", "Lcom/avito/android/photo_picker/legacy/thumbnail_list/BasePhotoItem;", "provideCameraBluePrint", "()Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/photo_picker/legacy/details_list/EditorItemView;", "provideEditorBluePrint", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public interface DetailsBlueprintProvider {
    @NotNull
    ItemBlueprint<CameraItemView, BasePhotoItem> provideCameraBluePrint();

    @NotNull
    ItemBlueprint<EditorItemView, BasePhotoItem> provideEditorBluePrint();
}

package com.avito.android.photo_picker.legacy.details_list;

import com.avito.android.photo_picker.legacy.details_list.DisplayType;
import com.avito.android.photo_picker.legacy.thumbnail_list.BasePhotoItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.ItemBlueprint;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b\u001b\u0010\u001cJ\u001b\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001d"}, d2 = {"Lcom/avito/android/photo_picker/legacy/details_list/DetailsBlueprintProviderImpl;", "Lcom/avito/android/photo_picker/legacy/details_list/DetailsBlueprintProvider;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/photo_picker/legacy/details_list/CameraItemView;", "Lcom/avito/android/photo_picker/legacy/thumbnail_list/BasePhotoItem;", "provideCameraBluePrint", "()Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/photo_picker/legacy/details_list/EditorItemView;", "provideEditorBluePrint", "Lcom/avito/android/photo_picker/legacy/details_list/CameraItemPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/photo_picker/legacy/details_list/CameraItemPresenter;", "cameraItemPresenter", "Lcom/avito/android/photo_picker/legacy/details_list/DisplayType;", AuthSource.SEND_ABUSE, "Lcom/avito/android/photo_picker/legacy/details_list/DisplayType;", "displayType", "Lcom/avito/android/photo_picker/legacy/details_list/EditorItemPresenter;", "c", "Lcom/avito/android/photo_picker/legacy/details_list/EditorItemPresenter;", "editorItemPresenter", "", "d", "Z", "simplifiedUi", "Lcom/avito/android/photo_picker/legacy/details_list/DisplayAnalyzer;", "displayAnalyzer", "<init>", "(Lcom/avito/android/photo_picker/legacy/details_list/CameraItemPresenter;Lcom/avito/android/photo_picker/legacy/details_list/EditorItemPresenter;Lcom/avito/android/photo_picker/legacy/details_list/DisplayAnalyzer;Z)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class DetailsBlueprintProviderImpl implements DetailsBlueprintProvider {
    public final DisplayType a;
    public final CameraItemPresenter b;
    public final EditorItemPresenter c;
    public final boolean d;

    public DetailsBlueprintProviderImpl(@NotNull CameraItemPresenter cameraItemPresenter, @NotNull EditorItemPresenter editorItemPresenter, @NotNull DisplayAnalyzer displayAnalyzer, boolean z) {
        Intrinsics.checkNotNullParameter(cameraItemPresenter, "cameraItemPresenter");
        Intrinsics.checkNotNullParameter(editorItemPresenter, "editorItemPresenter");
        Intrinsics.checkNotNullParameter(displayAnalyzer, "displayAnalyzer");
        this.b = cameraItemPresenter;
        this.c = editorItemPresenter;
        this.d = z;
        this.a = displayAnalyzer.getDisplayType();
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.DetailsBlueprintProvider
    @NotNull
    public ItemBlueprint<CameraItemView, BasePhotoItem> provideCameraBluePrint() {
        if (this.d) {
            return new FullscreenCameraBlueprint(this.b);
        }
        DisplayType displayType = this.a;
        if (displayType instanceof DisplayType.ExtraSmall) {
            return new ExtraSmallCameraBluePrint(this.b);
        }
        if (displayType instanceof DisplayType.FourOnThree) {
            return new FourOnThreeCameraBlueprint(this.b);
        }
        if (displayType instanceof DisplayType.Normal) {
            return new CameraBlueprint(this.b);
        }
        return new CameraBlueprint(this.b);
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.DetailsBlueprintProvider
    @NotNull
    public ItemBlueprint<EditorItemView, BasePhotoItem> provideEditorBluePrint() {
        if (this.d) {
            return new FullscreenEditorBlueprint(this.c);
        }
        DisplayType displayType = this.a;
        if (displayType instanceof DisplayType.ExtraSmall) {
            return new ExtraSmallEditorBluePrint(this.c);
        }
        if (displayType instanceof DisplayType.FourOnThree) {
            return new FourOnThreeEditorBlueprint(this.c);
        }
        if (displayType instanceof DisplayType.Normal) {
            return new EditorBlueprint(this.c);
        }
        return new EditorBlueprint(this.c);
    }
}

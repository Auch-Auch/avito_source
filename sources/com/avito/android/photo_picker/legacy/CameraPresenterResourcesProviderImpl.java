package com.avito.android.photo_picker.legacy;

import android.content.res.Resources;
import com.avito.android.photo_picker.R;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0005\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0004R\u0016\u0010\r\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0004R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0004R\u0016\u0010\u0015\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/avito/android/photo_picker/legacy/CameraPresenterResourcesProviderImpl;", "Lcom/avito/android/photo_picker/legacy/CameraPresenterResourceProvider;", "", "getNoGalleryFound", "()Ljava/lang/String;", "noGalleryFound", "getSettingsButton", "settingsButton", "getGoToSettings", "goToSettings", "getNoPlaceForSnapshot", "noPlaceForSnapshot", "getAllowStorage", "allowStorage", "Landroid/content/res/Resources;", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "getUnknownError", "unknownError", "getAllowAccess", "allowAccess", "<init>", "(Landroid/content/res/Resources;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class CameraPresenterResourcesProviderImpl implements CameraPresenterResourceProvider {
    public final Resources a;

    public CameraPresenterResourcesProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.a = resources;
    }

    @Override // com.avito.android.photo_picker.legacy.CameraPresenterResourceProvider
    @NotNull
    public String getAllowAccess() {
        String string = this.a.getString(R.string.allow_access);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.allow_access)");
        return string;
    }

    @Override // com.avito.android.photo_picker.legacy.CameraPresenterResourceProvider
    @NotNull
    public String getAllowStorage() {
        String string = this.a.getString(R.string.allow_storage);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.allow_storage)");
        return string;
    }

    @Override // com.avito.android.photo_picker.legacy.CameraPresenterResourceProvider
    @NotNull
    public String getGoToSettings() {
        String string = this.a.getString(R.string.go_to_settings);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.go_to_settings)");
        return string;
    }

    @Override // com.avito.android.photo_picker.legacy.CameraPresenterResourceProvider
    @NotNull
    public String getNoGalleryFound() {
        String string = this.a.getString(R.string.no_gallery_found);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.no_gallery_found)");
        return string;
    }

    @Override // com.avito.android.photo_picker.legacy.CameraPresenterResourceProvider
    @NotNull
    public String getNoPlaceForSnapshot() {
        String string = this.a.getString(R.string.no_place_for_snapshot);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…ng.no_place_for_snapshot)");
        return string;
    }

    @Override // com.avito.android.photo_picker.legacy.CameraPresenterResourceProvider
    @NotNull
    public String getSettingsButton() {
        String string = this.a.getString(com.avito.android.app.core.R.string.settings);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…p.core.R.string.settings)");
        return string;
    }

    @Override // com.avito.android.photo_picker.legacy.CameraPresenterResourceProvider
    @NotNull
    public String getUnknownError() {
        String string = this.a.getString(R.string.camera_unknown_error);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.camera_unknown_error)");
        return string;
    }
}

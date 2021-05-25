package com.avito.android.photo_picker.legacy;

import android.content.res.Resources;
import com.avito.android.photo_picker.R;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001c\u0010\u000f\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/photo_picker/legacy/PhotoPickerPresenterResourceProviderImpl;", "Lcom/avito/android/photo_picker/legacy/PhotoPickerPresenterResourceProvider;", "", "maxCount", "", "getPhotosExceededLimitMessage", "(I)Ljava/lang/String;", "Landroid/content/res/Resources;", AuthSource.BOOKING_ORDER, "Landroid/content/res/Resources;", "resources", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getAddPhotoError", "()Ljava/lang/String;", "addPhotoError", "<init>", "(Landroid/content/res/Resources;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class PhotoPickerPresenterResourceProviderImpl implements PhotoPickerPresenterResourceProvider {
    @NotNull
    public final String a;
    public final Resources b;

    public PhotoPickerPresenterResourceProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.b = resources;
        String string = resources.getString(R.string.add_image_error);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.add_image_error)");
        this.a = string;
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoPickerPresenterResourceProvider
    @NotNull
    public String getAddPhotoError() {
        return this.a;
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoPickerPresenterResourceProvider
    @NotNull
    public String getPhotosExceededLimitMessage(int i) {
        String string = this.b.getString(R.string.photo_limit_exceeds_message, Integer.valueOf(i));
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…xceeds_message, maxCount)");
        return string;
    }
}

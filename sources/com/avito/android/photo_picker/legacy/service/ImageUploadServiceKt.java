package com.avito.android.photo_picker.legacy.service;

import android.content.Context;
import android.content.Intent;
import com.avito.android.photo_picker.PhotoPickerActivityKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a/\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroid/content/Context;", "context", "", "operationId", "photoId", "", "uploadAfterNonRestorableError", "Landroid/content/Intent;", "createImageUploadServiceIntent", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)Landroid/content/Intent;", "photo-picker_release"}, k = 2, mv = {1, 4, 2})
public final class ImageUploadServiceKt {
    @NotNull
    public static final Intent createImageUploadServiceIntent(@NotNull Context context, @NotNull String str, @Nullable String str2, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "operationId");
        Intent intent = new Intent(context, ImageUploadService.class);
        intent.putExtra(PhotoPickerActivityKt.EXTRA_OPERATION_ID, str);
        if (str2 != null) {
            intent.putExtra("photo_id", str2);
        }
        intent.putExtra("upload_after_non_restorable_error", z);
        return intent;
    }
}

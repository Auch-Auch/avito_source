package com.avito.android.photo_picker;

import android.content.Context;
import android.content.Intent;
import com.avito.android.PublishIntentFactory;
import com.avito.android.photo_picker.legacy.CameraType;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Dimension;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001ai\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012\"\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015\"\u0016\u0010\u0017\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018\"\u0016\u0010\u0019\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018\"\u0016\u0010\u001a\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018\"\u0016\u0010\u001b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001b\u0010\u0018¨\u0006\u001c"}, d2 = {"Landroid/content/Context;", "context", "", "operationId", "typeId", "", "minPhotoCount", "maxPhotoCount", "selectedPhotoId", "", "simplifiedUi", "withCrop", "Lcom/avito/android/photo_picker/legacy/CameraType;", "startCamera", "Lcom/avito/android/PublishIntentFactory$PhotoPickerMode;", "pickerMode", "Landroid/content/Intent;", "createPhotoPickerActivityIntent", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;ZZLcom/avito/android/photo_picker/legacy/CameraType;Lcom/avito/android/PublishIntentFactory$PhotoPickerMode;)Landroid/content/Intent;", "Lcom/avito/android/util/Dimension;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/Dimension;", "PHOTO_SIZE", "EXTRA_OPERATION_ID", "Ljava/lang/String;", "KEY_MAX_PHOTO_COUNT", "EXTRA_PHOTO_TRANSFORMATION", "EXTRA_PHOTO_URI", "photo-picker_release"}, k = 2, mv = {1, 4, 2})
public final class PhotoPickerActivityKt {
    @NotNull
    public static final String EXTRA_OPERATION_ID = "operation_id";
    @NotNull
    public static final String EXTRA_PHOTO_TRANSFORMATION = "photo_transformation";
    @NotNull
    public static final String EXTRA_PHOTO_URI = "photo_uri";
    @NotNull
    public static final String KEY_MAX_PHOTO_COUNT = "max_photo_count";
    public static final Dimension a = new Dimension(960, 1280);

    @NotNull
    public static final Intent createPhotoPickerActivityIntent(@NotNull Context context, @NotNull String str, @NotNull String str2, int i, int i2, @Nullable String str3, boolean z, boolean z2, @NotNull CameraType cameraType, @NotNull PublishIntentFactory.PhotoPickerMode photoPickerMode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "operationId");
        Intrinsics.checkNotNullParameter(str2, "typeId");
        Intrinsics.checkNotNullParameter(cameraType, "startCamera");
        Intrinsics.checkNotNullParameter(photoPickerMode, "pickerMode");
        Intent putExtra = new Intent(context, PhotoPickerActivity.class).putExtra(EXTRA_OPERATION_ID, str).putExtra("type_id", str2).putExtra("min_photo_count", i).putExtra("max_photo_count", i2).putExtra("simplified_ui", z).putExtra("with_crop", z2).putExtra("start_camera", cameraType).putExtra("photo_picker_mode", photoPickerMode);
        Intrinsics.checkNotNullExpressionValue(putExtra, "context.createActivityIn…_PICKER_MODE, pickerMode)");
        if (str3 != null) {
            putExtra.putExtra("selected_photo_id", str3);
        }
        return putExtra;
    }

    public static /* synthetic */ Intent createPhotoPickerActivityIntent$default(Context context, String str, String str2, int i, int i2, String str3, boolean z, boolean z2, CameraType cameraType, PublishIntentFactory.PhotoPickerMode photoPickerMode, int i3, Object obj) {
        return createPhotoPickerActivityIntent(context, str, str2, (i3 & 8) != 0 ? 0 : i, i2, (i3 & 32) != 0 ? null : str3, (i3 & 64) != 0 ? false : z, (i3 & 128) != 0 ? false : z2, (i3 & 256) != 0 ? CameraType.BackCamera.INSTANCE : cameraType, photoPickerMode);
    }
}

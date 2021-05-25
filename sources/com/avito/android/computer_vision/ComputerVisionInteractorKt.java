package com.avito.android.computer_vision;

import com.avito.android.photo.ImageConvertOptions;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0006\"\u0019\u0010\u0005\u001a\u00020\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/avito/android/photo/ImageConvertOptions;", AuthSource.SEND_ABUSE, "Lcom/avito/android/photo/ImageConvertOptions;", "getCV_IMAGE_CONVERT_OPTIONS", "()Lcom/avito/android/photo/ImageConvertOptions;", "CV_IMAGE_CONVERT_OPTIONS", "photo-picker_release"}, k = 2, mv = {1, 4, 2})
public final class ComputerVisionInteractorKt {
    @NotNull
    public static final ImageConvertOptions a = new ImageConvertOptions(480, 640, 80, 1048576);

    @NotNull
    public static final ImageConvertOptions getCV_IMAGE_CONVERT_OPTIONS() {
        return a;
    }
}

package com.avito.android.photo_picker.legacy;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\u00020\u00018\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/photo_picker/legacy/PhotoSource;", "", "toInt", "(Lcom/avito/android/photo_picker/legacy/PhotoSource;)I", "SOURCE_UNKNOWN", "I", "photo-picker_release"}, k = 2, mv = {1, 4, 2})
public final class PhotoSourceKt {
    public static final int SOURCE_UNKNOWN = 0;

    public static final int toInt(@NotNull PhotoSource photoSource) {
        Intrinsics.checkNotNullParameter(photoSource, "$this$toInt");
        return photoSource == PhotoSource.CAMERA ? 1 : 2;
    }
}

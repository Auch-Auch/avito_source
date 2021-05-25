package com.avito.android.photo_picker.legacy;

import com.avito.android.photo_picker.legacy.CameraType;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", FirebaseAnalytics.Param.INDEX, "Lcom/avito/android/photo_picker/legacy/CameraType;", "getCameraTypeByIndex", "(I)Lcom/avito/android/photo_picker/legacy/CameraType;", "photo-picker_release"}, k = 2, mv = {1, 4, 2})
public final class CameraTypeKt {
    @Nullable
    public static final CameraType getCameraTypeByIndex(int i) {
        if (i == 0) {
            return CameraType.BackCamera.INSTANCE;
        }
        if (i != 1) {
            return null;
        }
        return CameraType.FrontCamera.INSTANCE;
    }
}

package com.avito.android.photo_picker.legacy;

import com.avito.android.photo_picker.legacy.FlashMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "value", "Lcom/avito/android/photo_picker/legacy/FlashMode;", "getFlashModeByValue", "(Ljava/lang/String;)Lcom/avito/android/photo_picker/legacy/FlashMode;", "photo-picker_release"}, k = 2, mv = {1, 4, 2})
public final class FlashModeKt {
    @Nullable
    public static final FlashMode getFlashModeByValue(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        int hashCode = str.hashCode();
        if (hashCode != 3551) {
            if (hashCode != 109935) {
                if (hashCode == 3005871 && str.equals(DebugKt.DEBUG_PROPERTY_VALUE_AUTO)) {
                    return FlashMode.Auto.INSTANCE;
                }
            } else if (str.equals(DebugKt.DEBUG_PROPERTY_VALUE_OFF)) {
                return FlashMode.Off.INSTANCE;
            }
        } else if (str.equals(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
            return FlashMode.ForceOn.INSTANCE;
        }
        return null;
    }
}

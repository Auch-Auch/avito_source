package com.avito.android.photo_picker.legacy;

import android.view.Display;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Rotation;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/photo_picker/legacy/RotationProviderImpl;", "Lcom/avito/android/photo_picker/legacy/RotationProvider;", "Landroid/view/Display;", AuthSource.SEND_ABUSE, "Landroid/view/Display;", "display", "Lcom/avito/android/util/Rotation;", "getRotation", "()Lcom/avito/android/util/Rotation;", "rotation", "<init>", "(Landroid/view/Display;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class RotationProviderImpl implements RotationProvider {
    public final Display a;

    @Inject
    public RotationProviderImpl(@NotNull Display display) {
        Intrinsics.checkNotNullParameter(display, "display");
        this.a = display;
    }

    @Override // com.avito.android.photo_picker.legacy.RotationProvider
    @NotNull
    public Rotation getRotation() {
        int rotation = this.a.getRotation();
        if (rotation == 0) {
            return new Rotation.Rotation_0();
        }
        if (rotation == 1) {
            return new Rotation.Rotation_90();
        }
        if (rotation == 2) {
            return new Rotation.Rotation_180();
        }
        if (rotation != 3) {
            return new Rotation.Rotation_0();
        }
        return new Rotation.Rotation_270();
    }
}

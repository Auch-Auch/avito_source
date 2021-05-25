package com.avito.android.photo_picker.legacy;

import android.graphics.Bitmap;
import com.avito.android.util.Dimension;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J/\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/photo_picker/legacy/PhotoResizer;", "", "", "photoData", "Lcom/avito/android/util/Dimension;", "desiredSize", "", "rotation", "Lio/reactivex/Observable;", "Landroid/graphics/Bitmap;", "resize", "([BLcom/avito/android/util/Dimension;F)Lio/reactivex/Observable;", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public interface PhotoResizer {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Observable resize$default(PhotoResizer photoResizer, byte[] bArr, Dimension dimension, float f, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    f = 0.0f;
                }
                return photoResizer.resize(bArr, dimension, f);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resize");
        }
    }

    @NotNull
    Observable<Bitmap> resize(@NotNull byte[] bArr, @NotNull Dimension dimension, float f);
}

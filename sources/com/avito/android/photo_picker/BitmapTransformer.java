package com.avito.android.photo_picker;

import android.net.Uri;
import com.avito.android.krop.util.Transformation;
import com.facebook.share.internal.ShareConstants;
import io.reactivex.Observable;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J1\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H'¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/photo_picker/BitmapTransformer;", "", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "Lcom/avito/android/krop/util/Transformation;", "transformation", "", "quality", "Lio/reactivex/Observable;", "transformBitmap", "(Landroid/net/Uri;Lcom/avito/android/krop/util/Transformation;I)Lio/reactivex/Observable;", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public interface BitmapTransformer {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Observable transformBitmap$default(BitmapTransformer bitmapTransformer, Uri uri, Transformation transformation, int i, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 4) != 0) {
                    i = 95;
                }
                return bitmapTransformer.transformBitmap(uri, transformation, i);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: transformBitmap");
        }
    }

    @Deprecated(message = "get transformed bitmap directly from krop lib")
    @NotNull
    Observable<Uri> transformBitmap(@NotNull Uri uri, @Nullable Transformation transformation, int i);
}

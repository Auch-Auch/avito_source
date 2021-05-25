package com.avito.android.image_loader;

import android.net.Uri;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0013\u0010\u0001\u001a\u00020\u0000*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0001\u0010\u0002\"\u0016\u0010\u0006\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/avito/android/image_loader/Picture;", "orEmpty", "(Lcom/avito/android/image_loader/Picture;)Lcom/avito/android/image_loader/Picture;", "Lcom/avito/android/image_loader/SimplePicture;", AuthSource.SEND_ABUSE, "Lcom/avito/android/image_loader/SimplePicture;", "EMPTY_PICTURE", "image-loader_release"}, k = 2, mv = {1, 4, 2})
public final class SimplePictureKt {
    public static final SimplePicture a;

    static {
        Uri uri = Uri.EMPTY;
        Intrinsics.checkNotNullExpressionValue(uri, "Uri.EMPTY");
        a = new SimplePicture(uri);
    }

    @NotNull
    public static final Picture orEmpty(@Nullable Picture picture) {
        return picture != null ? picture : a;
    }
}

package com.avito.android.util;

import android.net.Uri;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Size;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/util/ImageContainer;", "", "Lcom/avito/android/remote/model/Size;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/Size;", "getSize", "()Lcom/avito/android/remote/model/Size;", "size", "Landroid/net/Uri;", AuthSource.BOOKING_ORDER, "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", ShareConstants.MEDIA_URI, "<init>", "(Lcom/avito/android/remote/model/Size;Landroid/net/Uri;)V", "image-loader_release"}, k = 1, mv = {1, 4, 2})
public final class ImageContainer {
    @NotNull
    public final Size a;
    @NotNull
    public final Uri b;

    public ImageContainer(@NotNull Size size, @NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        this.a = size;
        this.b = uri;
    }

    @NotNull
    public final Size getSize() {
        return this.a;
    }

    @NotNull
    public final Uri getUri() {
        return this.b;
    }
}

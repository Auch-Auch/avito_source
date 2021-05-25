package com.avito.android.remote.model;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.q;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0004\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroid/net/Uri;", "Lcom/avito/android/remote/model/Image;", "toImage", "(Landroid/net/Uri;)Lcom/avito/android/remote/model/Image;", "toSingleImage", "image-loader_release"}, k = 2, mv = {1, 4, 2})
public final class ImageKt {
    @NotNull
    public static final Image toImage(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "$this$toImage");
        return new Image(q.mapOf(TuplesKt.to(new Size(640, 480), uri)));
    }

    @Nullable
    public static final Image toSingleImage(@Nullable Uri uri) {
        if (uri == null || !(!Intrinsics.areEqual(uri, Uri.EMPTY))) {
            return null;
        }
        return new Image(q.mapOf(TuplesKt.to(new Size(640, 480), uri)));
    }
}

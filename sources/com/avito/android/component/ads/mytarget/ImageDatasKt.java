package com.avito.android.component.ads.mytarget;

import android.net.Uri;
import com.my.target.common.models.ImageData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/my/target/common/models/ImageData;", "Landroid/net/Uri;", "getImageUri", "(Lcom/my/target/common/models/ImageData;)Landroid/net/Uri;", "ui-components_release"}, k = 2, mv = {1, 4, 2})
public final class ImageDatasKt {
    @NotNull
    public static final Uri getImageUri(@Nullable ImageData imageData) {
        if (imageData == null) {
            Uri uri = Uri.EMPTY;
            Intrinsics.checkNotNullExpressionValue(uri, "Uri.EMPTY");
            return uri;
        }
        Uri parse = Uri.parse(imageData.getUrl());
        Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(this.url)");
        return parse;
    }
}

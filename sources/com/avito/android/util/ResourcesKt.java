package com.avito.android.util;

import android.content.res.Resources;
import android.net.Uri;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.core.content.res.ResourcesCompat;
import com.facebook.common.util.UriUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001e\u0010\u0007\u001a\u00020\u0001*\u00020\u00002\b\b\u0001\u0010\u0006\u001a\u00020\u0001H\b¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroid/content/res/Resources;", "", "drawableRes", "Landroid/net/Uri;", "getDrawableUri", "(Landroid/content/res/Resources;I)Landroid/net/Uri;", "colorRes", "getColorCompat", "(Landroid/content/res/Resources;I)I", "android_release"}, k = 2, mv = {1, 4, 2})
public final class ResourcesKt {
    @ColorInt
    public static final int getColorCompat(@NotNull Resources resources, @ColorRes int i) {
        Intrinsics.checkNotNullParameter(resources, "$this$getColorCompat");
        return ResourcesCompat.getColor(resources, i, null);
    }

    @NotNull
    public static final Uri getDrawableUri(@NotNull Resources resources, @DrawableRes int i) {
        Intrinsics.checkNotNullParameter(resources, "$this$getDrawableUri");
        Uri build = new Uri.Builder().scheme(UriUtil.QUALIFIED_RESOURCE_SCHEME).encodedAuthority(resources.getResourcePackageName(i)).appendPath(resources.getResourceTypeName(i)).appendPath(resources.getResourceEntryName(i)).build();
        Intrinsics.checkNotNullExpressionValue(build, "Uri.Builder()\n    .schem…rawableRes))\n    .build()");
        return build;
    }
}

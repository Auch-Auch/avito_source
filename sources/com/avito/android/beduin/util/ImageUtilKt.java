package com.avito.android.beduin.util;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import com.avito.android.beduin.core.model.icon.IconBase64;
import com.avito.android.beduin.core.model.icon.LocalIcon;
import com.avito.android.lib.generated.ColorsKt;
import com.avito.android.lib.generated.IconsKt;
import com.avito.android.lib.util.DarkThemeManagerKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Contexts;
import com.avito.android.util.DrawablesKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a-\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a#\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroid/content/Context;", "context", "Lcom/avito/android/beduin/core/model/icon/LocalIcon;", "localIcon", "Lcom/avito/android/beduin/core/model/icon/IconBase64;", "image", "Landroid/graphics/drawable/Drawable;", "loadIcon", "(Landroid/content/Context;Lcom/avito/android/beduin/core/model/icon/LocalIcon;Lcom/avito/android/beduin/core/model/icon/IconBase64;)Landroid/graphics/drawable/Drawable;", AuthSource.SEND_ABUSE, "(Landroid/content/Context;Lcom/avito/android/beduin/core/model/icon/IconBase64;)Landroid/graphics/drawable/Drawable;", "beduin_release"}, k = 2, mv = {1, 4, 2})
public final class ImageUtilKt {
    public static final Drawable a(Context context, IconBase64 iconBase64) {
        String str;
        if (iconBase64 == null) {
            return null;
        }
        if (!DarkThemeManagerKt.isDarkTheme(context) || iconBase64.getIconBase64Dark() == null) {
            str = iconBase64.getIconBase64();
        } else {
            str = iconBase64.getIconBase64Dark();
        }
        byte[] decode = Base64.decode(str, 0);
        return new BitmapDrawable(context.getResources(), BitmapFactory.decodeByteArray(decode, 0, decode.length));
    }

    @Nullable
    public static final Drawable loadIcon(@NotNull Context context, @Nullable LocalIcon localIcon, @Nullable IconBase64 iconBase64) {
        Drawable drawableByAttr;
        Intrinsics.checkNotNullParameter(context, "context");
        if (localIcon == null) {
            return a(context, iconBase64);
        }
        Integer colorByAttrName = ColorsKt.getColorByAttrName(localIcon.getColor());
        if (colorByAttrName == null) {
            return a(context, iconBase64);
        }
        int colorByAttr = Contexts.getColorByAttr(context, colorByAttrName.intValue());
        Integer iconByAttrName = IconsKt.getIconByAttrName(localIcon.getName());
        if (iconByAttrName == null || (drawableByAttr = Contexts.getDrawableByAttr(context, iconByAttrName.intValue())) == null) {
            return a(context, iconBase64);
        }
        DrawablesKt.wrapForTinting(drawableByAttr, colorByAttr);
        return drawableByAttr;
    }
}

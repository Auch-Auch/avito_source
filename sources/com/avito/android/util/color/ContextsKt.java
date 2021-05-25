package com.avito.android.util.color;

import android.content.Context;
import android.content.res.ColorStateList;
import androidx.annotation.ColorInt;
import com.avito.android.remote.model.UniversalColor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a%\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0006\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0004\u0010\u0007\u001a'\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0004\u0010\n\u001a\u0019\u0010\f\u001a\u00020\u000b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\f\u0010\r\u001a%\u0010\f\u001a\u00020\u000b*\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroid/content/Context;", "Lcom/avito/android/remote/model/UniversalColor;", "color", "", "getColorFrom", "(Landroid/content/Context;Lcom/avito/android/remote/model/UniversalColor;)I", "defColor", "(Landroid/content/Context;Lcom/avito/android/remote/model/UniversalColor;I)I", "", "colorKey", "(Landroid/content/Context;Ljava/lang/String;I)I", "Landroid/content/res/ColorStateList;", "createColorStateList", "(Landroid/content/Context;Lcom/avito/android/remote/model/UniversalColor;)Landroid/content/res/ColorStateList;", "(Landroid/content/Context;Ljava/lang/String;I)Landroid/content/res/ColorStateList;", "text-formatters_release"}, k = 2, mv = {1, 4, 2})
public final class ContextsKt {
    @NotNull
    public static final ColorStateList createColorStateList(@NotNull Context context, @NotNull UniversalColor universalColor) {
        Intrinsics.checkNotNullParameter(context, "$this$createColorStateList");
        Intrinsics.checkNotNullParameter(universalColor, "color");
        return ColorFormatter.INSTANCE.formatColorStateList(context, universalColor);
    }

    public static /* synthetic */ ColorStateList createColorStateList$default(Context context, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return createColorStateList(context, str, i);
    }

    @ColorInt
    public static final int getColorFrom(@NotNull Context context, @NotNull UniversalColor universalColor) {
        Intrinsics.checkNotNullParameter(context, "$this$getColorFrom");
        Intrinsics.checkNotNullParameter(universalColor, "color");
        return ColorFormatter.INSTANCE.formatColor(context, universalColor);
    }

    public static /* synthetic */ int getColorFrom$default(Context context, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return getColorFrom(context, str, i);
    }

    @NotNull
    public static final ColorStateList createColorStateList(@NotNull Context context, @Nullable String str, int i) {
        Intrinsics.checkNotNullParameter(context, "$this$createColorStateList");
        return ColorFormatter.INSTANCE.formatColorStateList(context, str, i);
    }

    @ColorInt
    public static final int getColorFrom(@NotNull Context context, @Nullable UniversalColor universalColor, int i) {
        Intrinsics.checkNotNullParameter(context, "$this$getColorFrom");
        return universalColor != null ? ColorFormatter.INSTANCE.formatColor(context, universalColor) : i;
    }

    @ColorInt
    public static final int getColorFrom(@NotNull Context context, @Nullable String str, int i) {
        Intrinsics.checkNotNullParameter(context, "$this$getColorFrom");
        return ColorFormatter.INSTANCE.formatColor(context, str, i);
    }
}

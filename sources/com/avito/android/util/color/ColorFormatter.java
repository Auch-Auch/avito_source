package com.avito.android.util.color;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import androidx.annotation.ColorInt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Color;
import com.avito.android.remote.model.UniversalColor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ-\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0003\u0010\u000e\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0007\u0010\u000fJ7\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0001\u0010\u0010\u001a\u00020\u00062\b\b\u0001\u0010\u0011\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0007\u0010\u0012J+\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0003\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u0013J5\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0001\u0010\u0010\u001a\u00020\u00062\b\b\u0001\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u0014J\u0013\u0010\u0016\u001a\u00020\u0015*\u00020\u0002H\u0002¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/avito/android/util/color/ColorFormatter;", "", "Landroid/content/Context;", "context", "Lcom/avito/android/remote/model/UniversalColor;", "color", "", "formatColor", "(Landroid/content/Context;Lcom/avito/android/remote/model/UniversalColor;)I", "Landroid/content/res/ColorStateList;", "formatColorStateList", "(Landroid/content/Context;Lcom/avito/android/remote/model/UniversalColor;)Landroid/content/res/ColorStateList;", "", "colorKey", "defColor", "(Landroid/content/Context;Ljava/lang/String;I)I", "defLightColor", "defDarkColor", "(Landroid/content/Context;Ljava/lang/String;II)I", "(Landroid/content/Context;Ljava/lang/String;I)Landroid/content/res/ColorStateList;", "(Landroid/content/Context;Ljava/lang/String;II)Landroid/content/res/ColorStateList;", "", AuthSource.SEND_ABUSE, "(Landroid/content/Context;)Z", "<init>", "()V", "text-formatters_release"}, k = 1, mv = {1, 4, 2})
public final class ColorFormatter {
    @NotNull
    public static final ColorFormatter INSTANCE = new ColorFormatter();

    public static /* synthetic */ int formatColor$default(ColorFormatter colorFormatter, Context context, String str, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return colorFormatter.formatColor(context, str, i);
    }

    public static /* synthetic */ ColorStateList formatColorStateList$default(ColorFormatter colorFormatter, Context context, String str, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return colorFormatter.formatColorStateList(context, str, i);
    }

    public final boolean a(Context context) {
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        return (resources.getConfiguration().uiMode & 48) == 32;
    }

    @ColorInt
    public final int formatColor(@Nullable Context context, @NotNull UniversalColor universalColor) {
        Intrinsics.checkNotNullParameter(universalColor, "color");
        String colorKey = universalColor.getColorKey();
        Color color = universalColor.getColor();
        int i = 0;
        int value = color != null ? color.getValue() : 0;
        Color colorDark = universalColor.getColorDark();
        if (colorDark == null) {
            colorDark = universalColor.getColor();
        }
        if (colorDark != null) {
            i = colorDark.getValue();
        }
        return formatColor(context, colorKey, value, i);
    }

    @NotNull
    public final ColorStateList formatColorStateList(@Nullable Context context, @NotNull UniversalColor universalColor) {
        Intrinsics.checkNotNullParameter(universalColor, "color");
        String colorKey = universalColor.getColorKey();
        Color color = universalColor.getColor();
        int i = 0;
        int value = color != null ? color.getValue() : 0;
        Color colorDark = universalColor.getColorDark();
        if (colorDark == null) {
            colorDark = universalColor.getColor();
        }
        if (colorDark != null) {
            i = colorDark.getValue();
        }
        return formatColorStateList(context, colorKey, value, i);
    }

    @ColorInt
    public final int formatColor(@Nullable Context context, @Nullable String str, @ColorInt int i) {
        return formatColor(context, str, i, i);
    }

    @NotNull
    public final ColorStateList formatColorStateList(@Nullable Context context, @Nullable String str, @ColorInt int i) {
        return formatColorStateList(context, str, i, i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0017  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0019  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x001c  */
    @androidx.annotation.ColorInt
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int formatColor(@org.jetbrains.annotations.Nullable android.content.Context r7, @org.jetbrains.annotations.Nullable java.lang.String r8, @androidx.annotation.ColorInt int r9, @androidx.annotation.ColorInt int r10) {
        /*
            r6 = this;
            r0 = 1
            if (r7 == 0) goto L_0x0043
            r1 = 0
            if (r8 == 0) goto L_0x0013
            int r2 = r8.length()
            if (r2 <= 0) goto L_0x000e
            r2 = 1
            goto L_0x000f
        L_0x000e:
            r2 = 0
        L_0x000f:
            if (r2 == 0) goto L_0x0013
            r2 = 1
            goto L_0x0014
        L_0x0013:
            r2 = 0
        L_0x0014:
            r3 = 0
            if (r2 == 0) goto L_0x0019
            r2 = r7
            goto L_0x001a
        L_0x0019:
            r2 = r3
        L_0x001a:
            if (r2 == 0) goto L_0x0043
            android.content.res.Resources r4 = r2.getResources()
            java.lang.String r2 = r2.getPackageName()
            java.lang.String r5 = "attr"
            int r8 = r4.getIdentifier(r8, r5, r2)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            int r2 = r8.intValue()
            if (r2 <= 0) goto L_0x0035
            r1 = 1
        L_0x0035:
            if (r1 == 0) goto L_0x0038
            r3 = r8
        L_0x0038:
            if (r3 == 0) goto L_0x0043
            int r8 = r3.intValue()
            int r9 = com.avito.android.util.Contexts.getColorByAttr(r7, r8)
            goto L_0x004d
        L_0x0043:
            if (r7 == 0) goto L_0x004d
            boolean r7 = r6.a(r7)
            if (r7 == r0) goto L_0x004c
            goto L_0x004d
        L_0x004c:
            r9 = r10
        L_0x004d:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.util.color.ColorFormatter.formatColor(android.content.Context, java.lang.String, int, int):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0017  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0019  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x001c  */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.content.res.ColorStateList formatColorStateList(@org.jetbrains.annotations.Nullable android.content.Context r7, @org.jetbrains.annotations.Nullable java.lang.String r8, @androidx.annotation.ColorInt int r9, @androidx.annotation.ColorInt int r10) {
        /*
            r6 = this;
            r0 = 1
            if (r7 == 0) goto L_0x0045
            r1 = 0
            if (r8 == 0) goto L_0x0013
            int r2 = r8.length()
            if (r2 <= 0) goto L_0x000e
            r2 = 1
            goto L_0x000f
        L_0x000e:
            r2 = 0
        L_0x000f:
            if (r2 == 0) goto L_0x0013
            r2 = 1
            goto L_0x0014
        L_0x0013:
            r2 = 0
        L_0x0014:
            r3 = 0
            if (r2 == 0) goto L_0x0019
            r2 = r7
            goto L_0x001a
        L_0x0019:
            r2 = r3
        L_0x001a:
            if (r2 == 0) goto L_0x0045
            android.content.res.Resources r4 = r2.getResources()
            java.lang.String r2 = r2.getPackageName()
            java.lang.String r5 = "attr"
            int r8 = r4.getIdentifier(r8, r5, r2)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            int r2 = r8.intValue()
            if (r2 <= 0) goto L_0x0035
            r1 = 1
        L_0x0035:
            if (r1 == 0) goto L_0x0038
            r3 = r8
        L_0x0038:
            if (r3 == 0) goto L_0x0045
            int r8 = r3.intValue()
            android.content.res.ColorStateList r8 = com.avito.android.util.Contexts.getColorStateListByAttr(r7, r8)
            if (r8 == 0) goto L_0x0045
            goto L_0x0058
        L_0x0045:
            if (r7 == 0) goto L_0x004f
            boolean r7 = r6.a(r7)
            if (r7 == r0) goto L_0x004e
            goto L_0x004f
        L_0x004e:
            r9 = r10
        L_0x004f:
            android.content.res.ColorStateList r8 = android.content.res.ColorStateList.valueOf(r9)
            java.lang.String r7 = "ColorStateList.valueOf(\n…          }\n            )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r7)
        L_0x0058:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.util.color.ColorFormatter.formatColorStateList(android.content.Context, java.lang.String, int, int):android.content.res.ColorStateList");
    }
}

package com.avito.android.util.drawable;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ColorStateListsKt;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000f\u0010\u0010J+\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0002H\u0004¢\u0006\u0004\b\u0007\u0010\bR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/avito/android/util/drawable/RoundStateDrawable;", "Landroid/graphics/drawable/StateListDrawable;", "", "cornerRadius", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "Landroid/graphics/drawable/Drawable;", "mask", "(III)Landroid/graphics/drawable/Drawable;", "Landroid/content/res/ColorStateList;", AuthSource.SEND_ABUSE, "Landroid/content/res/ColorStateList;", "getColorStateList", "()Landroid/content/res/ColorStateList;", "colorStateList", "<init>", "(Landroid/content/res/ColorStateList;)V", "Companion", "android_release"}, k = 1, mv = {1, 4, 2})
public abstract class RoundStateDrawable extends StateListDrawable {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    public final ColorStateList a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\\\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/avito/android/util/drawable/RoundStateDrawable$Companion;", "", "Landroid/content/res/ColorStateList;", "color", "rippleColor", "", "cornerRadius", "borderColor", "borderWidth", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "Lcom/avito/android/util/drawable/RoundStateDrawable;", "invoke", "(Landroid/content/res/ColorStateList;Landroid/content/res/ColorStateList;ILandroid/content/res/ColorStateList;III)Lcom/avito/android/util/drawable/RoundStateDrawable;", "<init>", "()V", "android_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public static /* synthetic */ RoundStateDrawable invoke$default(Companion companion, ColorStateList colorStateList, ColorStateList colorStateList2, int i, ColorStateList colorStateList3, int i2, int i3, int i4, int i5, Object obj) {
            Integer rippleColor;
            if ((i5 & 1) != 0) {
                colorStateList = null;
            }
            if ((i5 & 2) != 0) {
                colorStateList2 = (colorStateList == null || (rippleColor = ColorStateListsKt.getRippleColor(colorStateList)) == null) ? null : ColorStateList.valueOf(rippleColor.intValue());
            }
            if ((i5 & 4) != 0) {
                i = 0;
            }
            if ((i5 & 8) != 0) {
                colorStateList3 = null;
            }
            if ((i5 & 16) != 0) {
                i2 = 0;
            }
            if ((i5 & 32) != 0) {
                i3 = -1;
            }
            if ((i5 & 64) != 0) {
                i4 = -1;
            }
            return companion.invoke(colorStateList, colorStateList2, i, colorStateList3, i2, i3, i4);
        }

        @NotNull
        public final RoundStateDrawable invoke(@Nullable ColorStateList colorStateList, @Nullable ColorStateList colorStateList2, int i, @Nullable ColorStateList colorStateList3, int i2, int i3, int i4) {
            return new RoundStateDrawableV21(colorStateList, colorStateList2, i, colorStateList3, i2, i3, i4);
        }

        public Companion(j jVar) {
        }
    }

    public RoundStateDrawable(@Nullable ColorStateList colorStateList) {
        this.a = colorStateList;
    }

    public static /* synthetic */ Drawable mask$default(RoundStateDrawable roundStateDrawable, int i, int i2, int i3, int i4, Object obj) {
        if (obj == null) {
            if ((i4 & 2) != 0) {
                i2 = -1;
            }
            if ((i4 & 4) != 0) {
                i3 = -1;
            }
            return roundStateDrawable.mask(i, i2, i3);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: mask");
    }

    @Nullable
    public final ColorStateList getColorStateList() {
        return this.a;
    }

    @NotNull
    public final Drawable mask(int i, int i2, int i3) {
        float[] fArr = new float[8];
        for (int i4 = 0; i4 < 8; i4++) {
            fArr[i4] = (float) i;
        }
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(fArr, null, null));
        shapeDrawable.setIntrinsicWidth(i2);
        shapeDrawable.setIntrinsicHeight(i3);
        return shapeDrawable;
    }
}

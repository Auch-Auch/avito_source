package com.avito.android.util.drawable;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001BI\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/avito/android/util/drawable/RoundStateDrawableV21;", "Lcom/avito/android/util/drawable/RoundStateDrawable;", "Landroid/content/res/ColorStateList;", AuthSource.BOOKING_ORDER, "Landroid/content/res/ColorStateList;", "borderColor", "", "c", "I", "borderWidth", "colorStateList", "rippleColorStateList", "cornerRadius", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "<init>", "(Landroid/content/res/ColorStateList;Landroid/content/res/ColorStateList;ILandroid/content/res/ColorStateList;III)V", "android_release"}, k = 1, mv = {1, 4, 2})
public final class RoundStateDrawableV21 extends RoundStateDrawable {
    public final ColorStateList b;
    public final int c;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RoundStateDrawableV21(ColorStateList colorStateList, ColorStateList colorStateList2, int i, ColorStateList colorStateList3, int i2, int i3, int i4, int i5, j jVar) {
        this(colorStateList, colorStateList2, i, colorStateList3, i2, (i5 & 32) != 0 ? -1 : i3, (i5 & 64) != 0 ? -1 : i4);
    }

    public RoundStateDrawableV21(@Nullable ColorStateList colorStateList, @Nullable ColorStateList colorStateList2, int i, @Nullable ColorStateList colorStateList3, int i2, int i3, int i4) {
        super(colorStateList);
        Drawable drawable;
        this.b = colorStateList3;
        this.c = i2;
        if (colorStateList2 != null) {
            StatefulGradientDrawable statefulGradientDrawable = new StatefulGradientDrawable();
            statefulGradientDrawable.setColorStateList(colorStateList);
            statefulGradientDrawable.setStatefulStroke(i2, colorStateList3);
            statefulGradientDrawable.setCornerRadius((float) i);
            statefulGradientDrawable.setIgnoreStates(new int[]{16842919});
            statefulGradientDrawable.setSize(i3, i4);
            Unit unit = Unit.INSTANCE;
            drawable = new RippleDrawable(colorStateList2, statefulGradientDrawable, mask(i, i3, i4));
        } else {
            StatefulGradientDrawable statefulGradientDrawable2 = new StatefulGradientDrawable();
            statefulGradientDrawable2.setColorStateList(colorStateList);
            statefulGradientDrawable2.setStatefulStroke(i2, colorStateList3);
            statefulGradientDrawable2.setCornerRadius((float) i);
            statefulGradientDrawable2.setSize(i3, i4);
            drawable = statefulGradientDrawable2;
        }
        addState(new int[0], drawable);
    }
}

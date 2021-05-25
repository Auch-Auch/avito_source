package com.avito.android.lib.design.switcher;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.appcompat.widget.SwitchCompat;
import com.avito.android.lib.design.R;
import com.avito.android.util.appearance.AppearanceChangeableView;
import com.avito.android.util.drawable.RoundStateDrawable;
import com.avito.android.util.drawable.StatefulShapeDrawable;
import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fB\u001b\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000e\u0010\u0012B#\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u0014J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0003¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/avito/android/lib/design/switcher/Switcher;", "Landroidx/appcompat/widget/SwitchCompat;", "Lcom/avito/android/util/appearance/AppearanceChangeableView;", "", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "", "setAppearance", "(I)V", "Landroid/content/res/TypedArray;", "array", "d", "(Landroid/content/res/TypedArray;)V", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class Switcher extends SwitchCompat implements AppearanceChangeableView {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Switcher(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @SuppressLint({"CustomViewStyleable"})
    public final void d(TypedArray typedArray) {
        Integer num;
        int[] iArr = {R.styleable.Switcher_switcher_thumbColor, R.styleable.Switcher_switcher_trackColor, R.styleable.Switcher_switcher_trackBorderColor};
        int i = 0;
        while (true) {
            if (i >= 3) {
                num = null;
                break;
            }
            int i2 = iArr[i];
            if (typedArray.hasValue(i2)) {
                num = Integer.valueOf(i2);
                break;
            }
            i++;
        }
        if (num != null) {
            num.intValue();
            int dimensionPixelSize = typedArray.getDimensionPixelSize(R.styleable.Switcher_switcher_trackHeight, -1);
            int dimensionPixelSize2 = typedArray.getDimensionPixelSize(R.styleable.Switcher_switcher_trackWidth, -1);
            int dimensionPixelSize3 = (dimensionPixelSize - typedArray.getDimensionPixelSize(R.styleable.Switcher_switcher_thumbSize, 0)) / 2;
            setSwitchMinWidth(dimensionPixelSize2);
            setTrackDrawable(RoundStateDrawable.Companion.invoke$default(RoundStateDrawable.Companion, typedArray.getColorStateList(R.styleable.Switcher_switcher_trackColor), null, typedArray.getDimensionPixelSize(R.styleable.Switcher_switcher_trackCornerRadius, 0), typedArray.getColorStateList(R.styleable.Switcher_switcher_trackBorderColor), typedArray.getDimensionPixelSize(R.styleable.Switcher_switcher_trackBorderWidth, 0), 0, 0, 96, null));
            StatefulShapeDrawable statefulShapeDrawable = new StatefulShapeDrawable(new OvalShape());
            statefulShapeDrawable.setIntrinsicWidth(dimensionPixelSize);
            statefulShapeDrawable.setIntrinsicHeight(dimensionPixelSize);
            statefulShapeDrawable.setColor(typedArray.getColorStateList(R.styleable.Switcher_switcher_thumbColor));
            statefulShapeDrawable.changePadding(dimensionPixelSize3, dimensionPixelSize3, dimensionPixelSize3, dimensionPixelSize3);
            Unit unit = Unit.INSTANCE;
            setThumbDrawable(statefulShapeDrawable);
        }
    }

    @Override // com.avito.android.util.appearance.AppearanceChangeableView
    public void setAppearance(int i) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(i, R.styleable.Switcher);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "array");
        d(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        requestLayout();
    }

    @Override // com.avito.android.util.appearance.AppearanceChangeableView
    public void setAppearanceFromAttr(@AttrRes int i) {
        AppearanceChangeableView.DefaultImpls.setAppearanceFromAttr(this, i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Switcher(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Switcher(@org.jetbrains.annotations.NotNull android.content.Context r6, @org.jetbrains.annotations.Nullable android.util.AttributeSet r7, int r8) {
        /*
            r5 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r8)
            int r1 = r0.intValue()
            r2 = 1
            r3 = 0
            if (r1 <= 0) goto L_0x0013
            r1 = 1
            goto L_0x0014
        L_0x0013:
            r1 = 0
        L_0x0014:
            r4 = 0
            if (r1 == 0) goto L_0x0018
            goto L_0x0019
        L_0x0018:
            r0 = r4
        L_0x0019:
            if (r0 == 0) goto L_0x0020
            int r0 = r0.intValue()
            goto L_0x0022
        L_0x0020:
            int r0 = com.avito.android.lib.design.R.attr.switcher
        L_0x0022:
            r5.<init>(r6, r7, r0)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r8)
            int r8 = r6.intValue()
            if (r8 <= 0) goto L_0x0031
            r8 = 1
            goto L_0x0032
        L_0x0031:
            r8 = 0
        L_0x0032:
            if (r8 == 0) goto L_0x0035
            goto L_0x0036
        L_0x0035:
            r6 = r4
        L_0x0036:
            if (r6 == 0) goto L_0x003d
            int r6 = r6.intValue()
            goto L_0x003f
        L_0x003d:
            int r6 = com.avito.android.lib.design.R.attr.switcher
        L_0x003f:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r3)
            int r0 = r8.intValue()
            if (r0 <= 0) goto L_0x004a
            goto L_0x004b
        L_0x004a:
            r2 = 0
        L_0x004b:
            if (r2 == 0) goto L_0x004e
            r4 = r8
        L_0x004e:
            if (r4 == 0) goto L_0x0055
            int r8 = r4.intValue()
            goto L_0x0057
        L_0x0055:
            int r8 = com.avito.android.lib.design.R.style.Design_Widget_Switcher
        L_0x0057:
            android.content.Context r0 = r5.getContext()
            int[] r1 = com.avito.android.lib.design.R.styleable.Switcher
            android.content.res.TypedArray r6 = r0.obtainStyledAttributes(r7, r1, r6, r8)
            java.lang.String r7 = "array"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            r5.d(r6)
            r6.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.lib.design.switcher.Switcher.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}

package com.avito.android.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.avito.android.ui_components.R;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.s.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017B\u0019\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0016\u0010\u0018B!\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0019\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u001aJ\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\n\u0010\u000bR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001b"}, d2 = {"Lcom/avito/android/ui/view/FixedRatioImageView;", "Lcom/facebook/drawee/view/SimpleDraweeView;", "", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "(II)V", "Landroid/util/AttributeSet;", "attrs", "d", "(Landroid/util/AttributeSet;)V", "", "i", "F", "getRatio", "()F", "setRatio", "(F)V", "ratio", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class FixedRatioImageView extends SimpleDraweeView {
    public float i = 0.75f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FixedRatioImageView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.FixedRatioImageView);
        this.i = obtainStyledAttributes.getFloat(R.styleable.FixedRatioImageView_ratio, 0.75f);
        obtainStyledAttributes.recycle();
    }

    public final float getRatio() {
        return this.i;
    }

    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        super.onMeasure(i2, i3);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        int i6 = layoutParams.height;
        boolean z = true;
        boolean z2 = (i6 == -1 || i6 == -2) ? false : true;
        int i7 = layoutParams.width;
        if (i7 == -1 || i7 == -2) {
            z = false;
        }
        if (z2 && z) {
            i5 = getMeasuredWidth();
            i4 = getMeasuredHeight();
        } else if (z2) {
            i4 = getMeasuredHeight();
            i5 = layoutParams.width;
        } else {
            i5 = getMeasuredWidth();
            i4 = c.roundToInt(((float) i5) * this.i);
        }
        setMeasuredDimension(i5, i4);
    }

    public final void setRatio(float f) {
        this.i = f;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FixedRatioImageView(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        d(attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FixedRatioImageView(@NotNull Context context, @NotNull AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        d(attributeSet);
    }
}

package com.avito.android.design.widget;

import android.view.View;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0006\u0010\nJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/avito/android/design/widget/RatioViewGroupImpl;", "Lcom/avito/android/design/widget/RatioViewGroup;", "", "heightRatio", "widthRatio", "", "setRatio", "(II)V", "", "ratio", "(F)V", "widthMeasureSpec", "heightMeasureSpec", "Lcom/avito/android/design/widget/MutableMeasurementPair;", "measureRatio", "(II)Lcom/avito/android/design/widget/MutableMeasurementPair;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/design/widget/MutableMeasurementPair;", "mutablePair", "Landroid/view/View;", "c", "Landroid/view/View;", "view", AuthSource.SEND_ABUSE, "F", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class RatioViewGroupImpl implements RatioViewGroup {
    public float a;
    public final MutableMeasurementPair b = new MutableMeasurementPair();
    public final View c;

    public RatioViewGroupImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.c = view;
    }

    @Override // com.avito.android.design.widget.RatioViewGroup
    @NotNull
    public MutableMeasurementPair measureRatio(int i, int i2) {
        if (this.a == 0.0f) {
            return this.b.mutate(i, i2);
        }
        int size = (int) (((float) View.MeasureSpec.getSize(i2)) * this.a);
        if (this.c.getLayoutParams().width == -1) {
            size = Math.min(size, View.MeasureSpec.getSize(i));
        }
        int mode = View.MeasureSpec.getMode(i);
        if (size <= 0 || mode == 0) {
            return this.b.mutate(i, i2);
        }
        return this.b.mutate(View.MeasureSpec.makeMeasureSpec(size, 1073741824), i2);
    }

    @Override // com.avito.android.design.widget.RatioViewGroup
    public void setRatio(int i, int i2) {
        if (i2 == 0) {
            setRatio(0.0f);
        } else {
            setRatio(((float) i) / ((float) i2));
        }
    }

    @Override // com.avito.android.design.widget.RatioViewGroup
    public void setRatio(float f) {
        boolean z = false;
        if (f >= ((float) 0)) {
            z = true;
        }
        if (z) {
            this.a = f;
            return;
        }
        throw new IllegalStateException("Ratio must be >= 0".toString());
    }
}

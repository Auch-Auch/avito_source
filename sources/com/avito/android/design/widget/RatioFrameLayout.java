package com.avito.android.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cB\u001b\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u001b\u0010\u001dB#\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u001e\u001a\u00020\u0003¢\u0006\u0004\b\u001b\u0010\u001fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000b\u0010\u000eJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0017¨\u0006 "}, d2 = {"Lcom/avito/android/design/widget/RatioFrameLayout;", "Landroid/widget/FrameLayout;", "Lcom/avito/android/design/widget/RatioViewGroup;", "", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "(II)V", "heightRatio", "widthRatio", "setRatio", "", "ratio", "(F)V", "Lcom/avito/android/design/widget/MutableMeasurementPair;", "measureRatio", "(II)Lcom/avito/android/design/widget/MutableMeasurementPair;", "Landroid/util/AttributeSet;", "attrs", AuthSource.SEND_ABUSE, "(Landroid/util/AttributeSet;)V", "Lcom/avito/android/design/widget/RatioViewGroupImpl;", "Lcom/avito/android/design/widget/RatioViewGroupImpl;", "ratioDelegate", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class RatioFrameLayout extends FrameLayout implements RatioViewGroup {
    public final RatioViewGroupImpl a = new RatioViewGroupImpl(this);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RatioFrameLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.RatioFrameLayout);
        setRatio(obtainStyledAttributes.getInt(R.styleable.RatioFrameLayout_height_ratio, 0), obtainStyledAttributes.getInt(R.styleable.RatioFrameLayout_width_ratio, 0));
        obtainStyledAttributes.recycle();
    }

    @Override // com.avito.android.design.widget.RatioViewGroup
    @NotNull
    public MutableMeasurementPair measureRatio(int i, int i2) {
        return this.a.measureRatio(i, i2);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        MutableMeasurementPair measureRatio = measureRatio(i, i2);
        super.onMeasure(measureRatio.getWidthSpec(), measureRatio.getHeightSpec());
    }

    @Override // com.avito.android.design.widget.RatioViewGroup
    public void setRatio(int i, int i2) {
        this.a.setRatio(i, i2);
    }

    @Override // com.avito.android.design.widget.RatioViewGroup
    public void setRatio(float f) {
        this.a.setRatio(f);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RatioFrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        a(attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RatioFrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        a(attributeSet);
    }
}

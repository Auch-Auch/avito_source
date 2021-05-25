package com.avito.android.lib.design.tooltip;

import a2.g.r.g;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.avito.android.lib.design.R;
import com.avito.android.lib.design.tooltip.AnchorPositions;
import com.avito.android.lib.design.tooltip.TailPositions;
import com.avito.android.lib.design.tooltip.TooltipPositions;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Views;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.ref.WeakReference;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010J\u001a\u00020I\u0012\n\b\u0002\u0010L\u001a\u0004\u0018\u00010K\u0012\b\b\u0002\u0010M\u001a\u00020\u0007\u0012\b\b\u0002\u0010N\u001a\u00020\u0007¢\u0006\u0004\bO\u0010PJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0014R*\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00168\u0000@@X\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u001e\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\"\u00104\u001a\u00020\u00078\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0018\u00106\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b5\u0010$R\u0016\u00108\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u0010/R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010>\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b=\u0010/R\u0016\u0010@\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b?\u0010/R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\"\u0010H\u001a\u00020\u00078\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\bE\u0010/\u001a\u0004\bF\u00101\"\u0004\bG\u00103¨\u0006Q"}, d2 = {"Lcom/avito/android/lib/design/tooltip/TooltipContainer;", "Landroid/widget/FrameLayout;", "Landroid/view/View;", "anchor", "", "setAnchorView", "(Landroid/view/View;)V", "", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "Landroid/widget/FrameLayout$LayoutParams;", "generateDefaultLayoutParams", "()Landroid/widget/FrameLayout$LayoutParams;", "drawableStateChanged", "()V", AuthSource.SEND_ABUSE, "Lcom/avito/android/lib/design/tooltip/TooltipPosition;", "value", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/lib/design/tooltip/TooltipPosition;", "getTooltipPosition$components_release", "()Lcom/avito/android/lib/design/tooltip/TooltipPosition;", "setTooltipPosition$components_release", "(Lcom/avito/android/lib/design/tooltip/TooltipPosition;)V", "tooltipPosition", "Landroid/graphics/Rect;", "Landroid/graphics/Rect;", "tailRect", "Lcom/google/android/material/shape/ShapeAppearanceModel;", "e", "Lcom/google/android/material/shape/ShapeAppearanceModel;", "tailShape", "Landroid/content/res/ColorStateList;", "c", "Landroid/content/res/ColorStateList;", "backgroundColor", "Ljava/lang/ref/WeakReference;", "h", "Ljava/lang/ref/WeakReference;", "anchorView", "j", "I", "getMaxHeight$components_release", "()I", "setMaxHeight$components_release", "(I)V", "maxHeight", "d", "backgroundShape", "i", "minHeight", "", AuthSource.BOOKING_ORDER, "F", "tailRotation", g.a, "tailHeight", "k", "minWidth", "Landroid/graphics/drawable/Drawable;", "f", "Landroid/graphics/drawable/Drawable;", "tailDrawable", "l", "getMaxWidth$components_release", "setMaxWidth$components_release", "maxWidth", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "components_release"}, k = 1, mv = {1, 4, 2})
@SuppressLint({"CustomViewStyleable"})
public final class TooltipContainer extends FrameLayout {
    @Deprecated
    public static final float ROTATION_TAIL_BOTTOM = 225.0f;
    @Deprecated
    public static final float ROTATION_TAIL_LEFT = 315.0f;
    @Deprecated
    public static final float ROTATION_TAIL_RIGHT = 135.0f;
    @Deprecated
    public static final float ROTATION_TAIL_TOP = 45.0f;
    public Rect a;
    public float b;
    public ColorStateList c;
    public ShapeAppearanceModel d;
    public ShapeAppearanceModel e;
    public Drawable f;
    public int g;
    public WeakReference<View> h;
    public int i;
    public int j;
    public int k;
    public int l;
    @NotNull
    public TooltipPosition m;

    @JvmOverloads
    public TooltipContainer(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
    }

    @JvmOverloads
    public TooltipContainer(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
    }

    @JvmOverloads
    public TooltipContainer(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0, 8, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TooltipContainer(Context context, AttributeSet attributeSet, int i2, int i3, int i4, j jVar) {
        this(context, (i4 & 2) != 0 ? null : attributeSet, (i4 & 4) != 0 ? R.attr.tooltip : i2, (i4 & 8) != 0 ? R.style.Design_Widget_Tooltip : i3);
    }

    public final void a() {
        ShapeAppearanceModel shapeAppearanceModel = this.e;
        if (shapeAppearanceModel != null) {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(shapeAppearanceModel);
            materialShapeDrawable.setFillColor(this.c);
            Unit unit = Unit.INSTANCE;
            this.f = materialShapeDrawable;
        }
        ShapeAppearanceModel shapeAppearanceModel2 = this.d;
        if (shapeAppearanceModel2 != null) {
            MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(shapeAppearanceModel2);
            materialShapeDrawable2.setFillColor(this.c);
            Object[] array = CollectionsKt__CollectionsKt.listOfNotNull(materialShapeDrawable2).toArray(new MaterialShapeDrawable[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            LayerDrawable layerDrawable = new LayerDrawable((Drawable[]) array);
            int i2 = this.g;
            layerDrawable.setLayerInset(0, i2, i2, i2, i2);
            Unit unit2 = Unit.INSTANCE;
            setBackground(layerDrawable);
        }
        int i3 = this.g;
        Views.changePadding(this, i3, i3, i3, i3);
    }

    @Override // android.view.View, android.view.ViewGroup
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.setState(getDrawableState());
        }
    }

    public final int getMaxHeight$components_release() {
        return this.j;
    }

    public final int getMaxWidth$components_release() {
        return this.l;
    }

    @NotNull
    public final TooltipPosition getTooltipPosition$components_release() {
        return this.m;
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Rect rect = this.a;
        if (!rect.isEmpty()) {
            canvas.save();
            canvas.rotate(this.b, (float) rect.centerX(), (float) rect.centerY());
            Drawable drawable = this.f;
            if (drawable != null) {
                drawable.setBounds(rect);
            }
            Drawable drawable2 = this.f;
            if (drawable2 != null) {
                drawable2.draw(canvas);
            }
            canvas.restore();
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        View view;
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.max(this.k, Math.min(this.l, View.MeasureSpec.getSize(i2))), View.MeasureSpec.getMode(i2)), View.MeasureSpec.makeMeasureSpec(Math.max(this.i, Math.min(this.j, View.MeasureSpec.getSize(i3))), View.MeasureSpec.getMode(i3)));
        WeakReference<View> weakReference = this.h;
        if (weakReference != null && (view = weakReference.get()) != null) {
            Intrinsics.checkNotNullExpressionValue(view, "anchorView?.get() ?: return");
            if (isAttachedToWindow()) {
                Pair<Integer, Integer> tailPosition = this.m.getTailPosition(view, this);
                int intValue = tailPosition.component1().intValue();
                int intValue2 = tailPosition.component2().intValue();
                int tailSize = this.m.getTailSize() / 2;
                Rect rect = this.a;
                rect.left = intValue - tailSize;
                rect.right = intValue + tailSize;
                rect.top = intValue2 - tailSize;
                rect.bottom = intValue2 + tailSize;
                TooltipUtils tooltipUtils = TooltipUtils.INSTANCE;
                int calculateTooltipGravity = tooltipUtils.calculateTooltipGravity(tooltipUtils.measureAbsoluteRect(this), tooltipUtils.measureAbsoluteRect(view));
                this.b = calculateTooltipGravity != 3 ? calculateTooltipGravity != 5 ? calculateTooltipGravity != 80 ? 225.0f : 45.0f : 315.0f : 135.0f;
                invalidate();
            }
        }
    }

    public final void setAnchorView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "anchor");
        this.h = new WeakReference<>(view);
        requestLayout();
    }

    public final void setMaxHeight$components_release(int i2) {
        this.j = i2;
    }

    public final void setMaxWidth$components_release(int i2) {
        this.l = i2;
    }

    public final void setTooltipPosition$components_release(@NotNull TooltipPosition tooltipPosition) {
        Intrinsics.checkNotNullParameter(tooltipPosition, "value");
        this.g = tooltipPosition.getTailHeight();
        a();
        this.m = tooltipPosition;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    @Nullable
    public FrameLayout.LayoutParams generateDefaultLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TooltipContainer(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = new Rect();
        this.b = 45.0f;
        this.j = Integer.MAX_VALUE;
        this.l = Integer.MAX_VALUE;
        this.m = new TooltipPositions.Left(new TailPositions.Start(new AnchorPositions.Start()));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Tooltip, i2, i3);
        this.c = obtainStyledAttributes.getColorStateList(R.styleable.Tooltip_tooltip_backgroundColor);
        this.d = ShapeAppearanceModel.builder(context, obtainStyledAttributes.getResourceId(R.styleable.Tooltip_tooltip_backgroundShape, 0), 0).build();
        this.e = ShapeAppearanceModel.builder(context, obtainStyledAttributes.getResourceId(R.styleable.Tooltip_tooltip_tailShape, 0), 0).build();
        a();
        this.i = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Tooltip_tooltip_minHeight, this.i);
        this.j = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Tooltip_tooltip_maxHeight, this.j);
        this.k = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Tooltip_tooltip_minWidth, this.k);
        this.l = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Tooltip_tooltip_maxWidth, this.l);
        obtainStyledAttributes.recycle();
    }
}

package com.avito.android.lib.expected.badge_bar;

import a2.g.r.g;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import com.avito.android.lib.design.R;
import com.avito.android.lib.design.text_view.AvitoTextView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/avito/android/lib/expected/badge_bar/BadgeView;", "Lcom/avito/android/lib/design/text_view/AvitoTextView;", "", "color", "", "setBackgroundColor", "(I)V", "Landroid/graphics/Rect;", "h", "Landroid/graphics/Rect;", "badgePaddings", "", g.a, "F", "backgroundRadius", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class BadgeView extends AvitoTextView {
    public float g;
    public Rect h;

    @JvmOverloads
    public BadgeView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
    }

    @JvmOverloads
    public BadgeView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
    }

    @JvmOverloads
    public BadgeView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BadgeView(Context context, AttributeSet attributeSet, int i, int i2, int i3, j jVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? R.attr.badgeView : i, (i3 & 8) != 0 ? R.style.Design_Widget_BadgeView : i2);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.setPadding(this.h);
        Paint paint = shapeDrawable.getPaint();
        Intrinsics.checkNotNullExpressionValue(paint, "paint");
        paint.setColor(i);
        float[] fArr = new float[8];
        for (int i2 = 0; i2 < 8; i2++) {
            fArr[i2] = this.g;
        }
        shapeDrawable.setShape(new RoundRectShape(fArr, null, null));
        setBackground(shapeDrawable);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BadgeView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
        this.h = new Rect();
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BadgeView, i, i2);
        this.g = obtainStyledAttributes.getDimension(R.styleable.BadgeView_badgeView_radius, this.g);
        Rect rect = this.h;
        rect.left = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BadgeView_badgeView_leftPadding, rect.left);
        Rect rect2 = this.h;
        rect2.right = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BadgeView_badgeView_rightPadding, rect2.right);
        Rect rect3 = this.h;
        rect3.top = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BadgeView_badgeView_topPadding, rect3.top);
        Rect rect4 = this.h;
        rect4.bottom = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BadgeView_badgeView_bottomPadding, rect4.bottom);
        setBackgroundColor(obtainStyledAttributes.getColor(R.styleable.BadgeView_android_background, 0));
        obtainStyledAttributes.recycle();
    }
}

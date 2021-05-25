package com.avito.android.lib.design.notification_badge;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.AttrRes;
import com.avito.android.lib.design.R;
import com.avito.android.lib.design.text_view.AvitoTextView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.TextViews;
import com.avito.android.util.appearance.AppearanceChangeableView;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B1\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010!\u001a\u00020\u0003\u0012\b\b\u0002\u0010\"\u001a\u00020\u0003¢\u0006\u0004\b#\u0010$J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R$\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00168F@FX\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006%"}, d2 = {"Lcom/avito/android/lib/design/notification_badge/NotificationBadge;", "Landroid/widget/FrameLayout;", "Lcom/avito/android/util/appearance/AppearanceChangeableView;", "", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "", "setAppearance", "(I)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "Landroid/content/res/TypedArray;", "array", AuthSource.SEND_ABUSE, "(Landroid/content/res/TypedArray;)V", "I", "maxHeight", "Landroid/widget/TextView;", AuthSource.BOOKING_ORDER, "Landroid/widget/TextView;", "textView", "", "value", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "text", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationBadge extends FrameLayout implements AppearanceChangeableView {
    public int a;
    public final TextView b;

    @JvmOverloads
    public NotificationBadge(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
    }

    @JvmOverloads
    public NotificationBadge(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
    }

    @JvmOverloads
    public NotificationBadge(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NotificationBadge(Context context, AttributeSet attributeSet, int i, int i2, int i3, j jVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? R.attr.notificationBadge : i, (i3 & 8) != 0 ? R.style.Design_Widget_NotificationBadge : i2);
    }

    @SuppressLint({"CustomViewStyleable"})
    public final void a(TypedArray typedArray) {
        TextViews.setTextAppearanceCompat(this.b, typedArray.getResourceId(R.styleable.NotificationBadge_android_textAppearance, 0));
        this.b.setTextColor(typedArray.getColor(R.styleable.NotificationBadge_android_textColor, 0));
        this.b.setText(typedArray.getText(R.styleable.NotificationBadge_android_text));
        this.b.setLines(typedArray.getInteger(R.styleable.NotificationBadge_android_lines, 0));
        this.b.setTranslationY(-((float) typedArray.getDimensionPixelSize(R.styleable.NotificationBadge_notificationBadge_textCompensation, 0)));
        ShapeAppearanceModel build = ShapeAppearanceModel.builder(getContext(), typedArray.getResourceId(R.styleable.NotificationBadge_notificationBadge_backgroundShape, 0), 0).build();
        Intrinsics.checkNotNullExpressionValue(build, "ShapeAppearanceModel.bui…  0\n            ).build()");
        ColorStateList colorStateList = typedArray.getColorStateList(R.styleable.NotificationBadge_notificationBadge_backgroundColor);
        int dimensionPixelOffset = typedArray.getDimensionPixelOffset(R.styleable.NotificationBadge_notificationBadge_strokeWidth, 0);
        ColorStateList colorStateList2 = typedArray.getColorStateList(R.styleable.NotificationBadge_notificationBadge_strokeColor);
        int dimensionPixelSize = typedArray.getDimensionPixelSize(R.styleable.NotificationBadge_android_minWidth, 0);
        int dimensionPixelSize2 = typedArray.getDimensionPixelSize(R.styleable.NotificationBadge_android_minHeight, 0);
        int dimensionPixelSize3 = typedArray.getDimensionPixelSize(R.styleable.NotificationBadge_android_maxHeight, 0);
        int i = dimensionPixelOffset * 2;
        setMinimumWidth(dimensionPixelSize + i);
        setMinimumHeight(dimensionPixelSize2 + i);
        if (dimensionPixelSize3 > 0) {
            this.a = dimensionPixelSize3 + i;
        }
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(build);
        materialShapeDrawable.setFillColor(colorStateList);
        materialShapeDrawable.setStrokeWidth((float) dimensionPixelOffset);
        materialShapeDrawable.setStrokeColor(colorStateList2);
        setBackground(materialShapeDrawable);
    }

    @NotNull
    public final CharSequence getText() {
        CharSequence text = this.b.getText();
        Intrinsics.checkNotNullExpressionValue(text, "textView.text");
        return text;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.a > 0) {
            int size = View.MeasureSpec.getSize(i2);
            int mode = View.MeasureSpec.getMode(i2);
            if (mode == Integer.MIN_VALUE) {
                i2 = View.MeasureSpec.makeMeasureSpec(Math.min(size, this.a), Integer.MIN_VALUE);
            } else if (mode == 0) {
                i2 = View.MeasureSpec.makeMeasureSpec(this.a, Integer.MIN_VALUE);
            } else if (mode == 1073741824) {
                i2 = View.MeasureSpec.makeMeasureSpec(Math.min(size, this.a), 1073741824);
            }
        }
        super.onMeasure(i, i2);
    }

    @Override // com.avito.android.util.appearance.AppearanceChangeableView
    public void setAppearance(int i) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(i, R.styleable.NotificationBadge);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "array");
        a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        requestLayout();
    }

    @Override // com.avito.android.util.appearance.AppearanceChangeableView
    public void setAppearanceFromAttr(@AttrRes int i) {
        AppearanceChangeableView.DefaultImpls.setAppearanceFromAttr(this, i);
    }

    public final void setText(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "value");
        this.b.setText(charSequence);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NotificationBadge(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        AvitoTextView avitoTextView = new AvitoTextView(context, null, 0, 0, 14, null);
        this.b = avitoTextView;
        addView(avitoTextView);
        ViewGroup.LayoutParams layoutParams = avitoTextView.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.NotificationBadge, i, i2);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "array");
        a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }
}

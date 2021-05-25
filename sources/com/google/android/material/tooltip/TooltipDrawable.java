package com.google.android.material.tooltip;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.MarkerEdgeTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.OffsetEdgeTreatment;
import java.util.Objects;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class TooltipDrawable extends MaterialShapeDrawable implements TextDrawableHelper.TextDrawableDelegate {
    @StyleRes
    public static final int O = R.style.Widget_MaterialComponents_Tooltip;
    @AttrRes
    public static final int P = R.attr.tooltipStyle;
    @Nullable
    public final Paint.FontMetrics A = new Paint.FontMetrics();
    @NonNull
    public final TextDrawableHelper B;
    @NonNull
    public final View.OnLayoutChangeListener C;
    @NonNull
    public final Rect D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public float K;
    public float L;
    public float M;
    public float N;
    @Nullable
    public CharSequence y;
    @NonNull
    public final Context z;

    public class a implements View.OnLayoutChangeListener {
        public a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            TooltipDrawable tooltipDrawable = TooltipDrawable.this;
            int i9 = TooltipDrawable.O;
            Objects.requireNonNull(tooltipDrawable);
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            tooltipDrawable.J = iArr[0];
            view.getWindowVisibleDisplayFrame(tooltipDrawable.D);
        }
    }

    public TooltipDrawable(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i, @StyleRes int i2) {
        super(context, attributeSet, i, i2);
        TextDrawableHelper textDrawableHelper = new TextDrawableHelper(this);
        this.B = textDrawableHelper;
        this.C = new a();
        this.D = new Rect();
        this.K = 1.0f;
        this.L = 1.0f;
        this.M = 0.5f;
        this.N = 1.0f;
        this.z = context;
        textDrawableHelper.getTextPaint().density = context.getResources().getDisplayMetrics().density;
        textDrawableHelper.getTextPaint().setTextAlign(Paint.Align.CENTER);
    }

    @NonNull
    public static TooltipDrawable create(@NonNull Context context) {
        return createFromAttributes(context, null, P, O);
    }

    @NonNull
    public static TooltipDrawable createFromAttributes(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i, @StyleRes int i2) {
        TooltipDrawable tooltipDrawable = new TooltipDrawable(context, attributeSet, i, i2);
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(tooltipDrawable.z, attributeSet, R.styleable.Tooltip, i, i2, new int[0]);
        tooltipDrawable.I = tooltipDrawable.z.getResources().getDimensionPixelSize(R.dimen.mtrl_tooltip_arrowSize);
        tooltipDrawable.setShapeAppearanceModel(tooltipDrawable.getShapeAppearanceModel().toBuilder().setBottomEdge(tooltipDrawable.k()).build());
        tooltipDrawable.setText(obtainStyledAttributes.getText(R.styleable.Tooltip_android_text));
        tooltipDrawable.setTextAppearance(MaterialResources.getTextAppearance(tooltipDrawable.z, obtainStyledAttributes, R.styleable.Tooltip_android_textAppearance));
        tooltipDrawable.setFillColor(ColorStateList.valueOf(obtainStyledAttributes.getColor(R.styleable.Tooltip_backgroundTint, MaterialColors.layer(ColorUtils.setAlphaComponent(MaterialColors.getColor(tooltipDrawable.z, 16842801, TooltipDrawable.class.getCanonicalName()), 229), ColorUtils.setAlphaComponent(MaterialColors.getColor(tooltipDrawable.z, R.attr.colorOnBackground, TooltipDrawable.class.getCanonicalName()), 153)))));
        tooltipDrawable.setStrokeColor(ColorStateList.valueOf(MaterialColors.getColor(tooltipDrawable.z, R.attr.colorSurface, TooltipDrawable.class.getCanonicalName())));
        tooltipDrawable.E = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Tooltip_android_padding, 0);
        tooltipDrawable.F = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Tooltip_android_minWidth, 0);
        tooltipDrawable.G = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Tooltip_android_minHeight, 0);
        tooltipDrawable.H = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Tooltip_android_layout_margin, 0);
        obtainStyledAttributes.recycle();
        return tooltipDrawable;
    }

    public void detachView(@Nullable View view) {
        if (view != null) {
            view.removeOnLayoutChangeListener(this.C);
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        canvas.save();
        float j = j();
        double sqrt = Math.sqrt(2.0d);
        canvas.scale(this.K, this.L, (((float) getBounds().width()) * 0.5f) + ((float) getBounds().left), (((float) getBounds().height()) * this.M) + ((float) getBounds().top));
        canvas.translate(j, (float) (-((sqrt * ((double) this.I)) - ((double) this.I))));
        super.draw(canvas);
        if (this.y != null) {
            Rect bounds = getBounds();
            this.B.getTextPaint().getFontMetrics(this.A);
            Paint.FontMetrics fontMetrics = this.A;
            int centerY = (int) (((float) bounds.centerY()) - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f));
            if (this.B.getTextAppearance() != null) {
                this.B.getTextPaint().drawableState = getState();
                this.B.updateTextPaintDrawState(this.z);
                this.B.getTextPaint().setAlpha((int) (this.N * 255.0f));
            }
            CharSequence charSequence = this.y;
            canvas.drawText(charSequence, 0, charSequence.length(), (float) bounds.centerX(), (float) centerY, this.B.getTextPaint());
        }
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) Math.max(this.B.getTextPaint().getTextSize(), (float) this.G);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        float f;
        float f2 = (float) (this.E * 2);
        CharSequence charSequence = this.y;
        if (charSequence == null) {
            f = 0.0f;
        } else {
            f = this.B.getTextWidth(charSequence.toString());
        }
        return (int) Math.max(f2 + f, (float) this.F);
    }

    public int getLayoutMargin() {
        return this.H;
    }

    public int getMinHeight() {
        return this.G;
    }

    public int getMinWidth() {
        return this.F;
    }

    @Nullable
    public CharSequence getText() {
        return this.y;
    }

    @Nullable
    public TextAppearance getTextAppearance() {
        return this.B.getTextAppearance();
    }

    public int getTextPadding() {
        return this.E;
    }

    public final float j() {
        int i;
        if (((this.D.right - getBounds().right) - this.J) - this.H < 0) {
            i = ((this.D.right - getBounds().right) - this.J) - this.H;
        } else if (((this.D.left - getBounds().left) - this.J) + this.H <= 0) {
            return 0.0f;
        } else {
            i = ((this.D.left - getBounds().left) - this.J) + this.H;
        }
        return (float) i;
    }

    public final EdgeTreatment k() {
        float width = ((float) (((double) getBounds().width()) - (Math.sqrt(2.0d) * ((double) this.I)))) / 2.0f;
        return new OffsetEdgeTreatment(new MarkerEdgeTreatment((float) this.I), Math.min(Math.max(-j(), -width), width));
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        setShapeAppearanceModel(getShapeAppearanceModel().toBuilder().setBottomEdge(k()).build());
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    @Override // com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public void onTextSizeChange() {
        invalidateSelf();
    }

    public void setLayoutMargin(@Px int i) {
        this.H = i;
        invalidateSelf();
    }

    public void setMinHeight(@Px int i) {
        this.G = i;
        invalidateSelf();
    }

    public void setMinWidth(@Px int i) {
        this.F = i;
        invalidateSelf();
    }

    public void setRelativeToView(@Nullable View view) {
        if (view != null) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            this.J = iArr[0];
            view.getWindowVisibleDisplayFrame(this.D);
            view.addOnLayoutChangeListener(this.C);
        }
    }

    public void setRevealFraction(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.M = 1.2f;
        this.K = f;
        this.L = f;
        this.N = AnimationUtils.lerp(0.0f, 1.0f, 0.19f, 1.0f, f);
        invalidateSelf();
    }

    public void setText(@Nullable CharSequence charSequence) {
        if (!TextUtils.equals(this.y, charSequence)) {
            this.y = charSequence;
            this.B.setTextWidthDirty(true);
            invalidateSelf();
        }
    }

    public void setTextAppearance(@Nullable TextAppearance textAppearance) {
        this.B.setTextAppearance(textAppearance, this.z);
    }

    public void setTextAppearanceResource(@StyleRes int i) {
        setTextAppearance(new TextAppearance(this.z, i));
    }

    public void setTextPadding(@Px int i) {
        this.E = i;
        invalidateSelf();
    }

    public void setTextResource(@StringRes int i) {
        setText(this.z.getResources().getString(i));
    }

    @NonNull
    public static TooltipDrawable createFromAttributes(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        return createFromAttributes(context, attributeSet, P, O);
    }
}

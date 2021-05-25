package com.google.android.material.chip;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.AnimatorRes;
import androidx.annotation.AttrRes;
import androidx.annotation.BoolRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.XmlRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.text.BidiFormatter;
import com.google.android.material.R;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.canvas.CanvasCompat;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.ref.WeakReference;
import java.util.Arrays;
public class ChipDrawable extends MaterialShapeDrawable implements TintAwareDrawable, Drawable.Callback, TextDrawableHelper.TextDrawableDelegate {
    public static final int[] H0 = {16842910};
    public static final ShapeDrawable I0 = new ShapeDrawable(new OvalShape());
    public float A;
    public boolean A0;
    public float B = -1.0f;
    @Nullable
    public ColorStateList B0;
    @Nullable
    public ColorStateList C;
    @NonNull
    public WeakReference<Delegate> C0 = new WeakReference<>(null);
    public float D;
    public TextUtils.TruncateAt D0;
    @Nullable
    public ColorStateList E;
    public boolean E0;
    @Nullable
    public CharSequence F;
    public int F0;
    public boolean G;
    public boolean G0;
    @Nullable
    public Drawable H;
    @Nullable
    public ColorStateList I;
    public float J;
    public boolean K;
    public boolean L;
    @Nullable
    public Drawable M;
    @Nullable
    public Drawable N;
    @Nullable
    public ColorStateList O;
    public float P;
    @Nullable
    public CharSequence Q;
    public boolean R;
    public boolean S;
    @Nullable
    public Drawable T;
    @Nullable
    public ColorStateList U;
    @Nullable
    public MotionSpec V;
    @Nullable
    public MotionSpec W;
    public float X;
    public float Y;
    public float Z;
    public float a0;
    public float b0;
    public float c0;
    public float d0;
    public float e0;
    @NonNull
    public final Context f0;
    public final Paint g0 = new Paint(1);
    public final Paint.FontMetrics h0 = new Paint.FontMetrics();
    public final RectF i0 = new RectF();
    public final PointF j0 = new PointF();
    public final Path k0 = new Path();
    @NonNull
    public final TextDrawableHelper l0;
    @ColorInt
    public int m0;
    @ColorInt
    public int n0;
    @ColorInt
    public int o0;
    @ColorInt
    public int p0;
    @ColorInt
    public int q0;
    @ColorInt
    public int r0;
    public boolean s0;
    @ColorInt
    public int t0;
    public int u0 = 255;
    @Nullable
    public ColorFilter v0;
    @Nullable
    public PorterDuffColorFilter w0;
    @Nullable
    public ColorStateList x0;
    @Nullable
    public ColorStateList y;
    @Nullable
    public PorterDuff.Mode y0 = PorterDuff.Mode.SRC_IN;
    @Nullable
    public ColorStateList z;
    public int[] z0;

    public interface Delegate {
        void onChipDrawableSizeChange();
    }

    public ChipDrawable(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i, @StyleRes int i2) {
        super(context, attributeSet, i, i2);
        initializeElevationOverlay(context);
        this.f0 = context;
        TextDrawableHelper textDrawableHelper = new TextDrawableHelper(this);
        this.l0 = textDrawableHelper;
        this.F = "";
        textDrawableHelper.getTextPaint().density = context.getResources().getDisplayMetrics().density;
        int[] iArr = H0;
        setState(iArr);
        setCloseIconState(iArr);
        this.E0 = true;
        if (RippleUtils.USE_FRAMEWORK_RIPPLE) {
            I0.setTint(-1);
        }
    }

    @NonNull
    public static ChipDrawable createFromAttributes(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i, @StyleRes int i2) {
        ChipDrawable chipDrawable = new ChipDrawable(context, attributeSet, i, i2);
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(chipDrawable.f0, attributeSet, R.styleable.Chip, i, i2, new int[0]);
        chipDrawable.G0 = obtainStyledAttributes.hasValue(R.styleable.Chip_shapeAppearance);
        ColorStateList colorStateList = MaterialResources.getColorStateList(chipDrawable.f0, obtainStyledAttributes, R.styleable.Chip_chipSurfaceColor);
        if (chipDrawable.y != colorStateList) {
            chipDrawable.y = colorStateList;
            chipDrawable.onStateChange(chipDrawable.getState());
        }
        chipDrawable.setChipBackgroundColor(MaterialResources.getColorStateList(chipDrawable.f0, obtainStyledAttributes, R.styleable.Chip_chipBackgroundColor));
        chipDrawable.setChipMinHeight(obtainStyledAttributes.getDimension(R.styleable.Chip_chipMinHeight, 0.0f));
        int i3 = R.styleable.Chip_chipCornerRadius;
        if (obtainStyledAttributes.hasValue(i3)) {
            chipDrawable.setChipCornerRadius(obtainStyledAttributes.getDimension(i3, 0.0f));
        }
        chipDrawable.setChipStrokeColor(MaterialResources.getColorStateList(chipDrawable.f0, obtainStyledAttributes, R.styleable.Chip_chipStrokeColor));
        chipDrawable.setChipStrokeWidth(obtainStyledAttributes.getDimension(R.styleable.Chip_chipStrokeWidth, 0.0f));
        chipDrawable.setRippleColor(MaterialResources.getColorStateList(chipDrawable.f0, obtainStyledAttributes, R.styleable.Chip_rippleColor));
        chipDrawable.setText(obtainStyledAttributes.getText(R.styleable.Chip_android_text));
        TextAppearance textAppearance = MaterialResources.getTextAppearance(chipDrawable.f0, obtainStyledAttributes, R.styleable.Chip_android_textAppearance);
        textAppearance.textSize = obtainStyledAttributes.getDimension(R.styleable.Chip_android_textSize, textAppearance.textSize);
        chipDrawable.setTextAppearance(textAppearance);
        int i4 = obtainStyledAttributes.getInt(R.styleable.Chip_android_ellipsize, 0);
        if (i4 == 1) {
            chipDrawable.setEllipsize(TextUtils.TruncateAt.START);
        } else if (i4 == 2) {
            chipDrawable.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        } else if (i4 == 3) {
            chipDrawable.setEllipsize(TextUtils.TruncateAt.END);
        }
        chipDrawable.setChipIconVisible(obtainStyledAttributes.getBoolean(R.styleable.Chip_chipIconVisible, false));
        if (!(attributeSet == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") != null)) {
            chipDrawable.setChipIconVisible(obtainStyledAttributes.getBoolean(R.styleable.Chip_chipIconEnabled, false));
        }
        chipDrawable.setChipIcon(MaterialResources.getDrawable(chipDrawable.f0, obtainStyledAttributes, R.styleable.Chip_chipIcon));
        int i5 = R.styleable.Chip_chipIconTint;
        if (obtainStyledAttributes.hasValue(i5)) {
            chipDrawable.setChipIconTint(MaterialResources.getColorStateList(chipDrawable.f0, obtainStyledAttributes, i5));
        }
        chipDrawable.setChipIconSize(obtainStyledAttributes.getDimension(R.styleable.Chip_chipIconSize, -1.0f));
        chipDrawable.setCloseIconVisible(obtainStyledAttributes.getBoolean(R.styleable.Chip_closeIconVisible, false));
        if (!(attributeSet == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") != null)) {
            chipDrawable.setCloseIconVisible(obtainStyledAttributes.getBoolean(R.styleable.Chip_closeIconEnabled, false));
        }
        chipDrawable.setCloseIcon(MaterialResources.getDrawable(chipDrawable.f0, obtainStyledAttributes, R.styleable.Chip_closeIcon));
        chipDrawable.setCloseIconTint(MaterialResources.getColorStateList(chipDrawable.f0, obtainStyledAttributes, R.styleable.Chip_closeIconTint));
        chipDrawable.setCloseIconSize(obtainStyledAttributes.getDimension(R.styleable.Chip_closeIconSize, 0.0f));
        chipDrawable.setCheckable(obtainStyledAttributes.getBoolean(R.styleable.Chip_android_checkable, false));
        chipDrawable.setCheckedIconVisible(obtainStyledAttributes.getBoolean(R.styleable.Chip_checkedIconVisible, false));
        if (!(attributeSet == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") != null)) {
            chipDrawable.setCheckedIconVisible(obtainStyledAttributes.getBoolean(R.styleable.Chip_checkedIconEnabled, false));
        }
        chipDrawable.setCheckedIcon(MaterialResources.getDrawable(chipDrawable.f0, obtainStyledAttributes, R.styleable.Chip_checkedIcon));
        int i6 = R.styleable.Chip_checkedIconTint;
        if (obtainStyledAttributes.hasValue(i6)) {
            chipDrawable.setCheckedIconTint(MaterialResources.getColorStateList(chipDrawable.f0, obtainStyledAttributes, i6));
        }
        chipDrawable.setShowMotionSpec(MotionSpec.createFromAttribute(chipDrawable.f0, obtainStyledAttributes, R.styleable.Chip_showMotionSpec));
        chipDrawable.setHideMotionSpec(MotionSpec.createFromAttribute(chipDrawable.f0, obtainStyledAttributes, R.styleable.Chip_hideMotionSpec));
        chipDrawable.setChipStartPadding(obtainStyledAttributes.getDimension(R.styleable.Chip_chipStartPadding, 0.0f));
        chipDrawable.setIconStartPadding(obtainStyledAttributes.getDimension(R.styleable.Chip_iconStartPadding, 0.0f));
        chipDrawable.setIconEndPadding(obtainStyledAttributes.getDimension(R.styleable.Chip_iconEndPadding, 0.0f));
        chipDrawable.setTextStartPadding(obtainStyledAttributes.getDimension(R.styleable.Chip_textStartPadding, 0.0f));
        chipDrawable.setTextEndPadding(obtainStyledAttributes.getDimension(R.styleable.Chip_textEndPadding, 0.0f));
        chipDrawable.setCloseIconStartPadding(obtainStyledAttributes.getDimension(R.styleable.Chip_closeIconStartPadding, 0.0f));
        chipDrawable.setCloseIconEndPadding(obtainStyledAttributes.getDimension(R.styleable.Chip_closeIconEndPadding, 0.0f));
        chipDrawable.setChipEndPadding(obtainStyledAttributes.getDimension(R.styleable.Chip_chipEndPadding, 0.0f));
        chipDrawable.setMaxWidth(obtainStyledAttributes.getDimensionPixelSize(R.styleable.Chip_android_maxWidth, Integer.MAX_VALUE));
        obtainStyledAttributes.recycle();
        return chipDrawable;
    }

    @NonNull
    public static ChipDrawable createFromResource(@NonNull Context context, @XmlRes int i) {
        AttributeSet parseDrawableXml = DrawableUtils.parseDrawableXml(context, i, "chip");
        int styleAttribute = parseDrawableXml.getStyleAttribute();
        if (styleAttribute == 0) {
            styleAttribute = R.style.Widget_MaterialComponents_Chip_Entry;
        }
        return createFromAttributes(context, parseDrawableXml, R.attr.chipStandaloneStyle, styleAttribute);
    }

    public static boolean r(@Nullable ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    public static boolean s(@Nullable Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        int i;
        Rect bounds = getBounds();
        if (!bounds.isEmpty() && getAlpha() != 0) {
            int i2 = this.u0;
            int saveLayerAlpha = i2 < 255 ? CanvasCompat.saveLayerAlpha(canvas, (float) bounds.left, (float) bounds.top, (float) bounds.right, (float) bounds.bottom, i2) : 0;
            if (!this.G0) {
                this.g0.setColor(this.m0);
                this.g0.setStyle(Paint.Style.FILL);
                this.i0.set(bounds);
                canvas.drawRoundRect(this.i0, getChipCornerRadius(), getChipCornerRadius(), this.g0);
            }
            if (!this.G0) {
                this.g0.setColor(this.n0);
                this.g0.setStyle(Paint.Style.FILL);
                Paint paint = this.g0;
                ColorFilter colorFilter = this.v0;
                if (colorFilter == null) {
                    colorFilter = this.w0;
                }
                paint.setColorFilter(colorFilter);
                this.i0.set(bounds);
                canvas.drawRoundRect(this.i0, getChipCornerRadius(), getChipCornerRadius(), this.g0);
            }
            if (this.G0) {
                super.draw(canvas);
            }
            if (this.D > 0.0f && !this.G0) {
                this.g0.setColor(this.p0);
                this.g0.setStyle(Paint.Style.STROKE);
                if (!this.G0) {
                    Paint paint2 = this.g0;
                    ColorFilter colorFilter2 = this.v0;
                    if (colorFilter2 == null) {
                        colorFilter2 = this.w0;
                    }
                    paint2.setColorFilter(colorFilter2);
                }
                RectF rectF = this.i0;
                float f = this.D / 2.0f;
                rectF.set(((float) bounds.left) + f, ((float) bounds.top) + f, ((float) bounds.right) - f, ((float) bounds.bottom) - f);
                float f2 = this.B - (this.D / 2.0f);
                canvas.drawRoundRect(this.i0, f2, f2, this.g0);
            }
            this.g0.setColor(this.q0);
            this.g0.setStyle(Paint.Style.FILL);
            this.i0.set(bounds);
            if (!this.G0) {
                canvas.drawRoundRect(this.i0, getChipCornerRadius(), getChipCornerRadius(), this.g0);
            } else {
                calculatePathForSize(new RectF(bounds), this.k0);
                super.drawShape(canvas, this.g0, this.k0, getBoundsAsRectF());
            }
            if (v()) {
                k(bounds, this.i0);
                RectF rectF2 = this.i0;
                float f3 = rectF2.left;
                float f4 = rectF2.top;
                canvas.translate(f3, f4);
                this.H.setBounds(0, 0, (int) this.i0.width(), (int) this.i0.height());
                this.H.draw(canvas);
                canvas.translate(-f3, -f4);
            }
            if (u()) {
                k(bounds, this.i0);
                RectF rectF3 = this.i0;
                float f5 = rectF3.left;
                float f6 = rectF3.top;
                canvas.translate(f5, f6);
                this.T.setBounds(0, 0, (int) this.i0.width(), (int) this.i0.height());
                this.T.draw(canvas);
                canvas.translate(-f5, -f6);
            }
            if (this.E0 && this.F != null) {
                PointF pointF = this.j0;
                pointF.set(0.0f, 0.0f);
                Paint.Align align = Paint.Align.LEFT;
                if (this.F != null) {
                    float l = l() + this.X + this.a0;
                    if (DrawableCompat.getLayoutDirection(this) == 0) {
                        pointF.x = ((float) bounds.left) + l;
                        align = Paint.Align.LEFT;
                    } else {
                        pointF.x = ((float) bounds.right) - l;
                        align = Paint.Align.RIGHT;
                    }
                    this.l0.getTextPaint().getFontMetrics(this.h0);
                    Paint.FontMetrics fontMetrics = this.h0;
                    pointF.y = ((float) bounds.centerY()) - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f);
                }
                RectF rectF4 = this.i0;
                rectF4.setEmpty();
                if (this.F != null) {
                    float l2 = l() + this.X + this.a0;
                    float p = p() + this.e0 + this.b0;
                    if (DrawableCompat.getLayoutDirection(this) == 0) {
                        rectF4.left = ((float) bounds.left) + l2;
                        rectF4.right = ((float) bounds.right) - p;
                    } else {
                        rectF4.left = ((float) bounds.left) + p;
                        rectF4.right = ((float) bounds.right) - l2;
                    }
                    rectF4.top = (float) bounds.top;
                    rectF4.bottom = (float) bounds.bottom;
                }
                if (this.l0.getTextAppearance() != null) {
                    this.l0.getTextPaint().drawableState = getState();
                    this.l0.updateTextPaintDrawState(this.f0);
                }
                this.l0.getTextPaint().setTextAlign(align);
                boolean z2 = Math.round(this.l0.getTextWidth(getText().toString())) > Math.round(this.i0.width());
                if (z2) {
                    int save = canvas.save();
                    canvas.clipRect(this.i0);
                    i = save;
                } else {
                    i = 0;
                }
                CharSequence charSequence = this.F;
                if (z2 && this.D0 != null) {
                    charSequence = TextUtils.ellipsize(charSequence, this.l0.getTextPaint(), this.i0.width(), this.D0);
                }
                int length = charSequence.length();
                PointF pointF2 = this.j0;
                canvas.drawText(charSequence, 0, length, pointF2.x, pointF2.y, this.l0.getTextPaint());
                if (z2) {
                    canvas.restoreToCount(i);
                }
            }
            if (w()) {
                n(bounds, this.i0);
                RectF rectF5 = this.i0;
                float f7 = rectF5.left;
                float f8 = rectF5.top;
                canvas.translate(f7, f8);
                this.M.setBounds(0, 0, (int) this.i0.width(), (int) this.i0.height());
                if (RippleUtils.USE_FRAMEWORK_RIPPLE) {
                    this.N.setBounds(this.M.getBounds());
                    this.N.jumpToCurrentState();
                    this.N.draw(canvas);
                } else {
                    this.M.draw(canvas);
                }
                canvas.translate(-f7, -f8);
            }
            if (this.u0 < 255) {
                canvas.restoreToCount(saveLayerAlpha);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.u0;
    }

    @Nullable
    public Drawable getCheckedIcon() {
        return this.T;
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        return this.U;
    }

    @Nullable
    public ColorStateList getChipBackgroundColor() {
        return this.z;
    }

    public float getChipCornerRadius() {
        return this.G0 ? getTopLeftCornerResolvedSize() : this.B;
    }

    public float getChipEndPadding() {
        return this.e0;
    }

    @Nullable
    public Drawable getChipIcon() {
        Drawable drawable = this.H;
        if (drawable != null) {
            return DrawableCompat.unwrap(drawable);
        }
        return null;
    }

    public float getChipIconSize() {
        return this.J;
    }

    @Nullable
    public ColorStateList getChipIconTint() {
        return this.I;
    }

    public float getChipMinHeight() {
        return this.A;
    }

    public float getChipStartPadding() {
        return this.X;
    }

    @Nullable
    public ColorStateList getChipStrokeColor() {
        return this.C;
    }

    public float getChipStrokeWidth() {
        return this.D;
    }

    public void getChipTouchBounds(@NonNull RectF rectF) {
        m(getBounds(), rectF);
    }

    @Nullable
    public Drawable getCloseIcon() {
        Drawable drawable = this.M;
        if (drawable != null) {
            return DrawableCompat.unwrap(drawable);
        }
        return null;
    }

    @Nullable
    public CharSequence getCloseIconContentDescription() {
        return this.Q;
    }

    public float getCloseIconEndPadding() {
        return this.d0;
    }

    public float getCloseIconSize() {
        return this.P;
    }

    public float getCloseIconStartPadding() {
        return this.c0;
    }

    @NonNull
    public int[] getCloseIconState() {
        return this.z0;
    }

    @Nullable
    public ColorStateList getCloseIconTint() {
        return this.O;
    }

    public void getCloseIconTouchBounds(@NonNull RectF rectF) {
        o(getBounds(), rectF);
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public ColorFilter getColorFilter() {
        return this.v0;
    }

    public TextUtils.TruncateAt getEllipsize() {
        return this.D0;
    }

    @Nullable
    public MotionSpec getHideMotionSpec() {
        return this.W;
    }

    public float getIconEndPadding() {
        return this.Z;
    }

    public float getIconStartPadding() {
        return this.Y;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.A;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.min(Math.round(p() + this.l0.getTextWidth(getText().toString()) + l() + this.X + this.a0 + this.b0 + this.e0), this.F0);
    }

    @Px
    public int getMaxWidth() {
        return this.F0;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@NonNull Outline outline) {
        if (this.G0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            outline.setRoundRect(bounds, this.B);
        } else {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.B);
        }
        outline.setAlpha(((float) getAlpha()) / 255.0f);
    }

    @Nullable
    public ColorStateList getRippleColor() {
        return this.E;
    }

    @Nullable
    public MotionSpec getShowMotionSpec() {
        return this.V;
    }

    @Nullable
    public CharSequence getText() {
        return this.F;
    }

    @Nullable
    public TextAppearance getTextAppearance() {
        return this.l0.getTextAppearance();
    }

    public float getTextEndPadding() {
        return this.b0;
    }

    public float getTextStartPadding() {
        return this.a0;
    }

    public boolean getUseCompatRipple() {
        return this.A0;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public boolean isCheckable() {
        return this.R;
    }

    @Deprecated
    public boolean isCheckedIconEnabled() {
        return isCheckedIconVisible();
    }

    public boolean isCheckedIconVisible() {
        return this.S;
    }

    @Deprecated
    public boolean isChipIconEnabled() {
        return isChipIconVisible();
    }

    public boolean isChipIconVisible() {
        return this.G;
    }

    @Deprecated
    public boolean isCloseIconEnabled() {
        return isCloseIconVisible();
    }

    public boolean isCloseIconStateful() {
        return s(this.M);
    }

    public boolean isCloseIconVisible() {
        return this.L;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        if (r(this.y) || r(this.z) || r(this.C)) {
            return true;
        }
        if (this.A0 && r(this.B0)) {
            return true;
        }
        TextAppearance textAppearance = this.l0.getTextAppearance();
        if ((textAppearance == null || (colorStateList = textAppearance.textColor) == null || !colorStateList.isStateful()) ? false : true) {
            return true;
        }
        if ((this.S && this.T != null && this.R) || s(this.H) || s(this.T) || r(this.x0)) {
            return true;
        }
        return false;
    }

    public final void j(@Nullable Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(this);
            DrawableCompat.setLayoutDirection(drawable, DrawableCompat.getLayoutDirection(this));
            drawable.setLevel(getLevel());
            drawable.setVisible(isVisible(), false);
            if (drawable == this.M) {
                if (drawable.isStateful()) {
                    drawable.setState(getCloseIconState());
                }
                DrawableCompat.setTintList(drawable, this.O);
                return;
            }
            if (drawable.isStateful()) {
                drawable.setState(getState());
            }
            Drawable drawable2 = this.H;
            if (drawable == drawable2 && this.K) {
                DrawableCompat.setTintList(drawable2, this.I);
            }
        }
    }

    public final void k(@NonNull Rect rect, @NonNull RectF rectF) {
        float f;
        rectF.setEmpty();
        if (v() || u()) {
            float f2 = this.X + this.Y;
            float q = q();
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                float f3 = ((float) rect.left) + f2;
                rectF.left = f3;
                rectF.right = f3 + q;
            } else {
                float f4 = ((float) rect.right) - f2;
                rectF.right = f4;
                rectF.left = f4 - q;
            }
            Drawable drawable = this.s0 ? this.T : this.H;
            float f5 = this.J;
            if (f5 <= 0.0f && drawable != null) {
                f5 = (float) Math.ceil((double) ViewUtils.dpToPx(this.f0, 24));
                if (((float) drawable.getIntrinsicHeight()) <= f5) {
                    f = (float) drawable.getIntrinsicHeight();
                    float exactCenterY = rect.exactCenterY() - (f / 2.0f);
                    rectF.top = exactCenterY;
                    rectF.bottom = exactCenterY + f;
                }
            }
            f = f5;
            float exactCenterY = rect.exactCenterY() - (f / 2.0f);
            rectF.top = exactCenterY;
            rectF.bottom = exactCenterY + f;
        }
    }

    public float l() {
        if (!v() && !u()) {
            return 0.0f;
        }
        return q() + this.Y + this.Z;
    }

    public final void m(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.set(rect);
        if (w()) {
            float f = this.e0 + this.d0 + this.P + this.c0 + this.b0;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                rectF.right = ((float) rect.right) - f;
            } else {
                rectF.left = ((float) rect.left) + f;
            }
        }
    }

    public final void n(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.setEmpty();
        if (w()) {
            float f = this.e0 + this.d0;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                float f2 = ((float) rect.right) - f;
                rectF.right = f2;
                rectF.left = f2 - this.P;
            } else {
                float f3 = ((float) rect.left) + f;
                rectF.left = f3;
                rectF.right = f3 + this.P;
            }
            float exactCenterY = rect.exactCenterY();
            float f4 = this.P;
            float f5 = exactCenterY - (f4 / 2.0f);
            rectF.top = f5;
            rectF.bottom = f5 + f4;
        }
    }

    public final void o(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.setEmpty();
        if (w()) {
            float f = this.e0 + this.d0 + this.P + this.c0 + this.b0;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                float f2 = (float) rect.right;
                rectF.right = f2;
                rectF.left = f2 - f;
            } else {
                int i = rect.left;
                rectF.left = (float) i;
                rectF.right = ((float) i) + f;
            }
            rectF.top = (float) rect.top;
            rectF.bottom = (float) rect.bottom;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i);
        if (v()) {
            onLayoutDirectionChanged |= DrawableCompat.setLayoutDirection(this.H, i);
        }
        if (u()) {
            onLayoutDirectionChanged |= DrawableCompat.setLayoutDirection(this.T, i);
        }
        if (w()) {
            onLayoutDirectionChanged |= DrawableCompat.setLayoutDirection(this.M, i);
        }
        if (!onLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        boolean onLevelChange = super.onLevelChange(i);
        if (v()) {
            onLevelChange |= this.H.setLevel(i);
        }
        if (u()) {
            onLevelChange |= this.T.setLevel(i);
        }
        if (w()) {
            onLevelChange |= this.M.setLevel(i);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    public void onSizeChange() {
        Delegate delegate = this.C0.get();
        if (delegate != null) {
            delegate.onChipDrawableSizeChange();
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public boolean onStateChange(@NonNull int[] iArr) {
        if (this.G0) {
            super.onStateChange(iArr);
        }
        return t(iArr, getCloseIconState());
    }

    @Override // com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public void onTextSizeChange() {
        onSizeChange();
        invalidateSelf();
    }

    public float p() {
        if (w()) {
            return this.c0 + this.P + this.d0;
        }
        return 0.0f;
    }

    public final float q() {
        Drawable drawable = this.s0 ? this.T : this.H;
        float f = this.J;
        return (f > 0.0f || drawable == null) ? f : (float) drawable.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.u0 != i) {
            this.u0 = i;
            invalidateSelf();
        }
    }

    public void setCheckable(boolean z2) {
        if (this.R != z2) {
            this.R = z2;
            float l = l();
            if (!z2 && this.s0) {
                this.s0 = false;
            }
            float l2 = l();
            invalidateSelf();
            if (l != l2) {
                onSizeChange();
            }
        }
    }

    public void setCheckableResource(@BoolRes int i) {
        setCheckable(this.f0.getResources().getBoolean(i));
    }

    public void setCheckedIcon(@Nullable Drawable drawable) {
        if (this.T != drawable) {
            float l = l();
            this.T = drawable;
            float l2 = l();
            x(this.T);
            j(this.T);
            invalidateSelf();
            if (l != l2) {
                onSizeChange();
            }
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z2) {
        setCheckedIconVisible(z2);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(@BoolRes int i) {
        setCheckedIconVisible(this.f0.getResources().getBoolean(i));
    }

    public void setCheckedIconResource(@DrawableRes int i) {
        setCheckedIcon(AppCompatResources.getDrawable(this.f0, i));
    }

    public void setCheckedIconTint(@Nullable ColorStateList colorStateList) {
        if (this.U != colorStateList) {
            this.U = colorStateList;
            if (this.S && this.T != null && this.R) {
                DrawableCompat.setTintList(this.T, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void setCheckedIconTintResource(@ColorRes int i) {
        setCheckedIconTint(AppCompatResources.getColorStateList(this.f0, i));
    }

    public void setCheckedIconVisible(@BoolRes int i) {
        setCheckedIconVisible(this.f0.getResources().getBoolean(i));
    }

    public void setChipBackgroundColor(@Nullable ColorStateList colorStateList) {
        if (this.z != colorStateList) {
            this.z = colorStateList;
            onStateChange(getState());
        }
    }

    public void setChipBackgroundColorResource(@ColorRes int i) {
        setChipBackgroundColor(AppCompatResources.getColorStateList(this.f0, i));
    }

    @Deprecated
    public void setChipCornerRadius(float f) {
        if (this.B != f) {
            this.B = f;
            setShapeAppearanceModel(getShapeAppearanceModel().withCornerSize(f));
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(@DimenRes int i) {
        setChipCornerRadius(this.f0.getResources().getDimension(i));
    }

    public void setChipEndPadding(float f) {
        if (this.e0 != f) {
            this.e0 = f;
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setChipEndPaddingResource(@DimenRes int i) {
        setChipEndPadding(this.f0.getResources().getDimension(i));
    }

    public void setChipIcon(@Nullable Drawable drawable) {
        Drawable chipIcon = getChipIcon();
        if (chipIcon != drawable) {
            float l = l();
            this.H = drawable != null ? DrawableCompat.wrap(drawable).mutate() : null;
            float l2 = l();
            x(chipIcon);
            if (v()) {
                j(this.H);
            }
            invalidateSelf();
            if (l != l2) {
                onSizeChange();
            }
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z2) {
        setChipIconVisible(z2);
    }

    @Deprecated
    public void setChipIconEnabledResource(@BoolRes int i) {
        setChipIconVisible(i);
    }

    public void setChipIconResource(@DrawableRes int i) {
        setChipIcon(AppCompatResources.getDrawable(this.f0, i));
    }

    public void setChipIconSize(float f) {
        if (this.J != f) {
            float l = l();
            this.J = f;
            float l2 = l();
            invalidateSelf();
            if (l != l2) {
                onSizeChange();
            }
        }
    }

    public void setChipIconSizeResource(@DimenRes int i) {
        setChipIconSize(this.f0.getResources().getDimension(i));
    }

    public void setChipIconTint(@Nullable ColorStateList colorStateList) {
        this.K = true;
        if (this.I != colorStateList) {
            this.I = colorStateList;
            if (v()) {
                DrawableCompat.setTintList(this.H, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void setChipIconTintResource(@ColorRes int i) {
        setChipIconTint(AppCompatResources.getColorStateList(this.f0, i));
    }

    public void setChipIconVisible(@BoolRes int i) {
        setChipIconVisible(this.f0.getResources().getBoolean(i));
    }

    public void setChipMinHeight(float f) {
        if (this.A != f) {
            this.A = f;
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setChipMinHeightResource(@DimenRes int i) {
        setChipMinHeight(this.f0.getResources().getDimension(i));
    }

    public void setChipStartPadding(float f) {
        if (this.X != f) {
            this.X = f;
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setChipStartPaddingResource(@DimenRes int i) {
        setChipStartPadding(this.f0.getResources().getDimension(i));
    }

    public void setChipStrokeColor(@Nullable ColorStateList colorStateList) {
        if (this.C != colorStateList) {
            this.C = colorStateList;
            if (this.G0) {
                setStrokeColor(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void setChipStrokeColorResource(@ColorRes int i) {
        setChipStrokeColor(AppCompatResources.getColorStateList(this.f0, i));
    }

    public void setChipStrokeWidth(float f) {
        if (this.D != f) {
            this.D = f;
            this.g0.setStrokeWidth(f);
            if (this.G0) {
                super.setStrokeWidth(f);
            }
            invalidateSelf();
        }
    }

    public void setChipStrokeWidthResource(@DimenRes int i) {
        setChipStrokeWidth(this.f0.getResources().getDimension(i));
    }

    public void setCloseIcon(@Nullable Drawable drawable) {
        Drawable closeIcon = getCloseIcon();
        if (closeIcon != drawable) {
            float p = p();
            this.M = drawable != null ? DrawableCompat.wrap(drawable).mutate() : null;
            if (RippleUtils.USE_FRAMEWORK_RIPPLE) {
                this.N = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(getRippleColor()), this.M, I0);
            }
            float p2 = p();
            x(closeIcon);
            if (w()) {
                j(this.M);
            }
            invalidateSelf();
            if (p != p2) {
                onSizeChange();
            }
        }
    }

    public void setCloseIconContentDescription(@Nullable CharSequence charSequence) {
        if (this.Q != charSequence) {
            this.Q = BidiFormatter.getInstance().unicodeWrap(charSequence);
            invalidateSelf();
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z2) {
        setCloseIconVisible(z2);
    }

    @Deprecated
    public void setCloseIconEnabledResource(@BoolRes int i) {
        setCloseIconVisible(i);
    }

    public void setCloseIconEndPadding(float f) {
        if (this.d0 != f) {
            this.d0 = f;
            invalidateSelf();
            if (w()) {
                onSizeChange();
            }
        }
    }

    public void setCloseIconEndPaddingResource(@DimenRes int i) {
        setCloseIconEndPadding(this.f0.getResources().getDimension(i));
    }

    public void setCloseIconResource(@DrawableRes int i) {
        setCloseIcon(AppCompatResources.getDrawable(this.f0, i));
    }

    public void setCloseIconSize(float f) {
        if (this.P != f) {
            this.P = f;
            invalidateSelf();
            if (w()) {
                onSizeChange();
            }
        }
    }

    public void setCloseIconSizeResource(@DimenRes int i) {
        setCloseIconSize(this.f0.getResources().getDimension(i));
    }

    public void setCloseIconStartPadding(float f) {
        if (this.c0 != f) {
            this.c0 = f;
            invalidateSelf();
            if (w()) {
                onSizeChange();
            }
        }
    }

    public void setCloseIconStartPaddingResource(@DimenRes int i) {
        setCloseIconStartPadding(this.f0.getResources().getDimension(i));
    }

    public boolean setCloseIconState(@NonNull int[] iArr) {
        if (Arrays.equals(this.z0, iArr)) {
            return false;
        }
        this.z0 = iArr;
        if (w()) {
            return t(getState(), iArr);
        }
        return false;
    }

    public void setCloseIconTint(@Nullable ColorStateList colorStateList) {
        if (this.O != colorStateList) {
            this.O = colorStateList;
            if (w()) {
                DrawableCompat.setTintList(this.M, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void setCloseIconTintResource(@ColorRes int i) {
        setCloseIconTint(AppCompatResources.getColorStateList(this.f0, i));
    }

    public void setCloseIconVisible(@BoolRes int i) {
        setCloseIconVisible(this.f0.getResources().getBoolean(i));
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        if (this.v0 != colorFilter) {
            this.v0 = colorFilter;
            invalidateSelf();
        }
    }

    public void setDelegate(@Nullable Delegate delegate) {
        this.C0 = new WeakReference<>(delegate);
    }

    public void setEllipsize(@Nullable TextUtils.TruncateAt truncateAt) {
        this.D0 = truncateAt;
    }

    public void setHideMotionSpec(@Nullable MotionSpec motionSpec) {
        this.W = motionSpec;
    }

    public void setHideMotionSpecResource(@AnimatorRes int i) {
        setHideMotionSpec(MotionSpec.createFromResource(this.f0, i));
    }

    public void setIconEndPadding(float f) {
        if (this.Z != f) {
            float l = l();
            this.Z = f;
            float l2 = l();
            invalidateSelf();
            if (l != l2) {
                onSizeChange();
            }
        }
    }

    public void setIconEndPaddingResource(@DimenRes int i) {
        setIconEndPadding(this.f0.getResources().getDimension(i));
    }

    public void setIconStartPadding(float f) {
        if (this.Y != f) {
            float l = l();
            this.Y = f;
            float l2 = l();
            invalidateSelf();
            if (l != l2) {
                onSizeChange();
            }
        }
    }

    public void setIconStartPaddingResource(@DimenRes int i) {
        setIconStartPadding(this.f0.getResources().getDimension(i));
    }

    public void setMaxWidth(@Px int i) {
        this.F0 = i;
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        if (this.E != colorStateList) {
            this.E = colorStateList;
            this.B0 = this.A0 ? RippleUtils.sanitizeRippleDrawableColor(colorStateList) : null;
            onStateChange(getState());
        }
    }

    public void setRippleColorResource(@ColorRes int i) {
        setRippleColor(AppCompatResources.getColorStateList(this.f0, i));
    }

    public void setShowMotionSpec(@Nullable MotionSpec motionSpec) {
        this.V = motionSpec;
    }

    public void setShowMotionSpecResource(@AnimatorRes int i) {
        setShowMotionSpec(MotionSpec.createFromResource(this.f0, i));
    }

    public void setText(@Nullable CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (!TextUtils.equals(this.F, charSequence)) {
            this.F = charSequence;
            this.l0.setTextWidthDirty(true);
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setTextAppearance(@Nullable TextAppearance textAppearance) {
        this.l0.setTextAppearance(textAppearance, this.f0);
    }

    public void setTextAppearanceResource(@StyleRes int i) {
        setTextAppearance(new TextAppearance(this.f0, i));
    }

    public void setTextEndPadding(float f) {
        if (this.b0 != f) {
            this.b0 = f;
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setTextEndPaddingResource(@DimenRes int i) {
        setTextEndPadding(this.f0.getResources().getDimension(i));
    }

    public void setTextResource(@StringRes int i) {
        setText(this.f0.getResources().getString(i));
    }

    public void setTextSize(@Dimension float f) {
        TextAppearance textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.textSize = f;
            this.l0.getTextPaint().setTextSize(f);
            onTextSizeChange();
        }
    }

    public void setTextStartPadding(float f) {
        if (this.a0 != f) {
            this.a0 = f;
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setTextStartPaddingResource(@DimenRes int i) {
        setTextStartPadding(this.f0.getResources().getDimension(i));
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(@Nullable ColorStateList colorStateList) {
        if (this.x0 != colorStateList) {
            this.x0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(@NonNull PorterDuff.Mode mode) {
        if (this.y0 != mode) {
            this.y0 = mode;
            this.w0 = DrawableUtils.updateTintFilter(this, this.x0, mode);
            invalidateSelf();
        }
    }

    public void setUseCompatRipple(boolean z2) {
        if (this.A0 != z2) {
            this.A0 = z2;
            this.B0 = z2 ? RippleUtils.sanitizeRippleDrawableColor(this.E) : null;
            onStateChange(getState());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z3) {
        boolean visible = super.setVisible(z2, z3);
        if (v()) {
            visible |= this.H.setVisible(z2, z3);
        }
        if (u()) {
            visible |= this.T.setVisible(z2, z3);
        }
        if (w()) {
            visible |= this.M.setVisible(z2, z3);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x015a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean t(@androidx.annotation.NonNull int[] r9, @androidx.annotation.NonNull int[] r10) {
        /*
        // Method dump skipped, instructions count: 355
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.ChipDrawable.t(int[], int[]):boolean");
    }

    public final boolean u() {
        return this.S && this.T != null && this.s0;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public final boolean v() {
        return this.G && this.H != null;
    }

    public final boolean w() {
        return this.L && this.M != null;
    }

    public final void x(@Nullable Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public void setCheckedIconVisible(boolean z2) {
        if (this.S != z2) {
            boolean u = u();
            this.S = z2;
            boolean u2 = u();
            if (u != u2) {
                if (u2) {
                    j(this.T);
                } else {
                    x(this.T);
                }
                invalidateSelf();
                onSizeChange();
            }
        }
    }

    public void setChipIconVisible(boolean z2) {
        if (this.G != z2) {
            boolean v = v();
            this.G = z2;
            boolean v2 = v();
            if (v != v2) {
                if (v2) {
                    j(this.H);
                } else {
                    x(this.H);
                }
                invalidateSelf();
                onSizeChange();
            }
        }
    }

    public void setCloseIconVisible(boolean z2) {
        if (this.L != z2) {
            boolean w = w();
            this.L = z2;
            boolean w2 = w();
            if (w != w2) {
                if (w2) {
                    j(this.M);
                } else {
                    x(this.M);
                }
                invalidateSelf();
                onSizeChange();
            }
        }
    }
}

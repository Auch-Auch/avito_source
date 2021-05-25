package com.google.android.material.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;
public class MaterialButton extends AppCompatButton implements Checkable, Shapeable {
    public static final int ICON_GRAVITY_END = 3;
    public static final int ICON_GRAVITY_START = 1;
    public static final int ICON_GRAVITY_TEXT_END = 4;
    public static final int ICON_GRAVITY_TEXT_START = 2;
    public static final int ICON_GRAVITY_TEXT_TOP = 32;
    public static final int ICON_GRAVITY_TOP = 16;
    public static final int[] p = {16842911};
    public static final int[] q = {16842912};
    public static final int r = R.style.Widget_MaterialComponents_Button;
    @NonNull
    public final a2.j.b.d.g.a c;
    @NonNull
    public final LinkedHashSet<OnCheckedChangeListener> d;
    @Nullable
    public a e;
    @Nullable
    public PorterDuff.Mode f;
    @Nullable
    public ColorStateList g;
    @Nullable
    public Drawable h;
    @Px
    public int i;
    @Px
    public int j;
    @Px
    public int k;
    @Px
    public int l;
    public boolean m;
    public boolean n;
    public int o;

    @Retention(RetentionPolicy.SOURCE)
    public @interface IconGravity {
    }

    public interface OnCheckedChangeListener {
        void onCheckedChanged(MaterialButton materialButton, boolean z);
    }

    public interface a {
    }

    public static class b extends AbsSavedState {
        public static final Parcelable.Creator<b> CREATOR = new a();
        public boolean b;

        public static class a implements Parcelable.ClassLoaderCreator<b> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            public b createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new b(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            public Object[] newArray(int i) {
                return new b[i];
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            public Object createFromParcel(@NonNull Parcel parcel) {
                return new b(parcel, null);
            }
        }

        public b(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.b ? 1 : 0);
        }

        public b(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                b.class.getClassLoader();
            }
            this.b = parcel.readInt() != 1 ? false : true;
        }
    }

    public MaterialButton(@NonNull Context context) {
        this(context, null);
    }

    @NonNull
    private String getA11yClassName() {
        return (isCheckable() ? CompoundButton.class : Button.class).getName();
    }

    private int getTextHeight() {
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(charSequence, 0, charSequence.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextWidth() {
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        return Math.min((int) paint.measureText(charSequence), getLayout().getEllipsizedWidth());
    }

    public final boolean a() {
        int i2 = this.o;
        return i2 == 3 || i2 == 4;
    }

    public void addOnCheckedChangeListener(@NonNull OnCheckedChangeListener onCheckedChangeListener) {
        this.d.add(onCheckedChangeListener);
    }

    public final boolean b() {
        int i2 = this.o;
        return i2 == 1 || i2 == 2;
    }

    public final boolean c() {
        int i2 = this.o;
        return i2 == 16 || i2 == 32;
    }

    public void clearOnCheckedChangeListeners() {
        this.d.clear();
    }

    public final boolean d() {
        a2.j.b.d.g.a aVar = this.c;
        return aVar != null && !aVar.o;
    }

    public final void e() {
        if (b()) {
            TextViewCompat.setCompoundDrawablesRelative(this, this.h, null, null, null);
        } else if (a()) {
            TextViewCompat.setCompoundDrawablesRelative(this, null, null, this.h, null);
        } else if (c()) {
            TextViewCompat.setCompoundDrawablesRelative(this, null, this.h, null, null);
        }
    }

    public final void f(boolean z) {
        Drawable drawable = this.h;
        if (drawable != null) {
            Drawable mutate = DrawableCompat.wrap(drawable).mutate();
            this.h = mutate;
            DrawableCompat.setTintList(mutate, this.g);
            PorterDuff.Mode mode = this.f;
            if (mode != null) {
                DrawableCompat.setTintMode(this.h, mode);
            }
            int i2 = this.i;
            if (i2 == 0) {
                i2 = this.h.getIntrinsicWidth();
            }
            int i3 = this.i;
            if (i3 == 0) {
                i3 = this.h.getIntrinsicHeight();
            }
            Drawable drawable2 = this.h;
            int i4 = this.j;
            int i5 = this.k;
            drawable2.setBounds(i4, i5, i2 + i4, i3 + i5);
        }
        if (z) {
            e();
            return;
        }
        Drawable[] compoundDrawablesRelative = TextViewCompat.getCompoundDrawablesRelative(this);
        boolean z2 = false;
        Drawable drawable3 = compoundDrawablesRelative[0];
        Drawable drawable4 = compoundDrawablesRelative[1];
        Drawable drawable5 = compoundDrawablesRelative[2];
        if ((b() && drawable3 != this.h) || ((a() && drawable5 != this.h) || (c() && drawable4 != this.h))) {
            z2 = true;
        }
        if (z2) {
            e();
        }
    }

    public final void g(int i2, int i3) {
        if (this.h != null && getLayout() != null) {
            if (b() || a()) {
                this.k = 0;
                int i4 = this.o;
                boolean z = true;
                if (i4 == 1 || i4 == 3) {
                    this.j = 0;
                    f(false);
                    return;
                }
                int i5 = this.i;
                if (i5 == 0) {
                    i5 = this.h.getIntrinsicWidth();
                }
                int textWidth = (((((i2 - getTextWidth()) - ViewCompat.getPaddingEnd(this)) - i5) - this.l) - ViewCompat.getPaddingStart(this)) / 2;
                boolean z2 = ViewCompat.getLayoutDirection(this) == 1;
                if (this.o != 4) {
                    z = false;
                }
                if (z2 != z) {
                    textWidth = -textWidth;
                }
                if (this.j != textWidth) {
                    this.j = textWidth;
                    f(false);
                }
            } else if (c()) {
                this.j = 0;
                if (this.o == 16) {
                    this.k = 0;
                    f(false);
                    return;
                }
                int i6 = this.i;
                if (i6 == 0) {
                    i6 = this.h.getIntrinsicHeight();
                }
                int textHeight = (((((i3 - getTextHeight()) - getPaddingTop()) - i6) - this.l) - getPaddingBottom()) / 2;
                if (this.k != textHeight) {
                    this.k = textHeight;
                    f(false);
                }
            }
        }
    }

    @Override // android.view.View
    @Nullable
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    @Nullable
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    @Px
    public int getCornerRadius() {
        if (d()) {
            return this.c.g;
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.h;
    }

    public int getIconGravity() {
        return this.o;
    }

    @Px
    public int getIconPadding() {
        return this.l;
    }

    @Px
    public int getIconSize() {
        return this.i;
    }

    public ColorStateList getIconTint() {
        return this.g;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f;
    }

    @Dimension
    public int getInsetBottom() {
        return this.c.f;
    }

    @Dimension
    public int getInsetTop() {
        return this.c.e;
    }

    @Nullable
    public ColorStateList getRippleColor() {
        if (d()) {
            return this.c.l;
        }
        return null;
    }

    @Override // com.google.android.material.shape.Shapeable
    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        if (d()) {
            return this.c.b;
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (d()) {
            return this.c.k;
        }
        return null;
    }

    @Px
    public int getStrokeWidth() {
        if (d()) {
            return this.c.h;
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ColorStateList getSupportBackgroundTintList() {
        if (d()) {
            return this.c.j;
        }
        return super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (d()) {
            return this.c.i;
        }
        return super.getSupportBackgroundTintMode();
    }

    public boolean isCheckable() {
        a2.j.b.d.g.a aVar = this.c;
        return aVar != null && aVar.q;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.m;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (d()) {
            MaterialShapeUtils.setParentAbsoluteElevation(this, this.c.b());
        }
    }

    @Override // android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 2);
        if (isCheckable()) {
            Button.mergeDrawableStates(onCreateDrawableState, p);
        }
        if (isChecked()) {
            Button.mergeDrawableStates(onCreateDrawableState, q);
        }
        return onCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(isCheckable());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        a2.j.b.d.g.a aVar;
        super.onLayout(z, i2, i3, i4, i5);
        if (Build.VERSION.SDK_INT == 21 && (aVar = this.c) != null) {
            int i6 = i5 - i3;
            int i7 = i4 - i2;
            Drawable drawable = aVar.m;
            if (drawable != null) {
                drawable.setBounds(aVar.c, aVar.e, i7 - aVar.d, i6 - aVar.f);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof b)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.getSuperState());
        setChecked(bVar.b);
    }

    @Override // android.widget.TextView, android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        bVar.b = this.m;
        return bVar;
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        g(i2, i3);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        g(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    public void removeOnCheckedChangeListener(@NonNull OnCheckedChangeListener onCheckedChangeListener) {
        this.d.remove(onCheckedChangeListener);
    }

    @Override // android.view.View
    public void setBackground(@NonNull Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int i2) {
        if (d()) {
            a2.j.b.d.g.a aVar = this.c;
            if (aVar.b() != null) {
                aVar.b().setTint(i2);
                return;
            }
            return;
        }
        super.setBackgroundColor(i2);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(@NonNull Drawable drawable) {
        if (!d()) {
            super.setBackgroundDrawable(drawable);
        } else if (drawable != getBackground()) {
            a2.j.b.d.g.a aVar = this.c;
            aVar.o = true;
            aVar.a.setSupportBackgroundTintList(aVar.j);
            aVar.a.setSupportBackgroundTintMode(aVar.i);
            super.setBackgroundDrawable(drawable);
        } else {
            getBackground().setState(drawable.getState());
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(@DrawableRes int i2) {
        setBackgroundDrawable(i2 != 0 ? AppCompatResources.getDrawable(getContext(), i2) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z) {
        if (d()) {
            this.c.q = z;
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (isCheckable() && isEnabled() && this.m != z) {
            this.m = z;
            refreshDrawableState();
            if (!this.n) {
                this.n = true;
                Iterator<OnCheckedChangeListener> it = this.d.iterator();
                while (it.hasNext()) {
                    it.next().onCheckedChanged(this, this.m);
                }
                this.n = false;
            }
        }
    }

    public void setCornerRadius(@Px int i2) {
        if (d()) {
            a2.j.b.d.g.a aVar = this.c;
            if (!aVar.p || aVar.g != i2) {
                aVar.g = i2;
                aVar.p = true;
                aVar.e(aVar.b.withCornerSize((float) i2));
            }
        }
    }

    public void setCornerRadiusResource(@DimenRes int i2) {
        if (d()) {
            setCornerRadius(getResources().getDimensionPixelSize(i2));
        }
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f2) {
        super.setElevation(f2);
        if (d()) {
            this.c.b().setElevation(f2);
        }
    }

    public void setIcon(@Nullable Drawable drawable) {
        if (this.h != drawable) {
            this.h = drawable;
            f(true);
            g(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i2) {
        if (this.o != i2) {
            this.o = i2;
            g(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(@Px int i2) {
        if (this.l != i2) {
            this.l = i2;
            setCompoundDrawablePadding(i2);
        }
    }

    public void setIconResource(@DrawableRes int i2) {
        setIcon(i2 != 0 ? AppCompatResources.getDrawable(getContext(), i2) : null);
    }

    public void setIconSize(@Px int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        } else if (this.i != i2) {
            this.i = i2;
            f(true);
        }
    }

    public void setIconTint(@Nullable ColorStateList colorStateList) {
        if (this.g != colorStateList) {
            this.g = colorStateList;
            f(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f != mode) {
            this.f = mode;
            f(false);
        }
    }

    public void setIconTintResource(@ColorRes int i2) {
        setIconTint(AppCompatResources.getColorStateList(getContext(), i2));
    }

    public void setInsetBottom(@Dimension int i2) {
        a2.j.b.d.g.a aVar = this.c;
        aVar.f(aVar.e, i2);
    }

    public void setInsetTop(@Dimension int i2) {
        a2.j.b.d.g.a aVar = this.c;
        aVar.f(i2, aVar.f);
    }

    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setOnPressedChangeListenerInternal(@Nullable a aVar) {
        this.e = aVar;
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        a aVar = this.e;
        if (aVar != null) {
            MaterialButtonToggleGroup.this.invalidate();
        }
        super.setPressed(z);
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        if (d()) {
            a2.j.b.d.g.a aVar = this.c;
            if (aVar.l != colorStateList) {
                aVar.l = colorStateList;
                if (aVar.a.getBackground() instanceof RippleDrawable) {
                    ((RippleDrawable) aVar.a.getBackground()).setColor(RippleUtils.sanitizeRippleDrawableColor(colorStateList));
                }
            }
        }
    }

    public void setRippleColorResource(@ColorRes int i2) {
        if (d()) {
            setRippleColor(AppCompatResources.getColorStateList(getContext(), i2));
        }
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        if (d()) {
            this.c.e(shapeAppearanceModel);
            return;
        }
        throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
    }

    public void setShouldDrawSurfaceColorStroke(boolean z) {
        if (d()) {
            a2.j.b.d.g.a aVar = this.c;
            aVar.n = z;
            aVar.h();
        }
    }

    public void setStrokeColor(@Nullable ColorStateList colorStateList) {
        if (d()) {
            a2.j.b.d.g.a aVar = this.c;
            if (aVar.k != colorStateList) {
                aVar.k = colorStateList;
                aVar.h();
            }
        }
    }

    public void setStrokeColorResource(@ColorRes int i2) {
        if (d()) {
            setStrokeColor(AppCompatResources.getColorStateList(getContext(), i2));
        }
    }

    public void setStrokeWidth(@Px int i2) {
        if (d()) {
            a2.j.b.d.g.a aVar = this.c;
            if (aVar.h != i2) {
                aVar.h = i2;
                aVar.h();
            }
        }
    }

    public void setStrokeWidthResource(@DimenRes int i2) {
        if (d()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i2));
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (d()) {
            a2.j.b.d.g.a aVar = this.c;
            if (aVar.j != colorStateList) {
                aVar.j = colorStateList;
                if (aVar.b() != null) {
                    DrawableCompat.setTintList(aVar.b(), aVar.j);
                    return;
                }
                return;
            }
            return;
        }
        super.setSupportBackgroundTintList(colorStateList);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        if (d()) {
            a2.j.b.d.g.a aVar = this.c;
            if (aVar.i != mode) {
                aVar.i = mode;
                if (aVar.b() != null && aVar.i != null) {
                    DrawableCompat.setTintMode(aVar.b(), aVar.i);
                    return;
                }
                return;
            }
            return;
        }
        super.setSupportBackgroundTintMode(mode);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.m);
    }

    public MaterialButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialButtonStyle);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MaterialButton(@androidx.annotation.NonNull android.content.Context r9, @androidx.annotation.Nullable android.util.AttributeSet r10, int r11) {
        /*
        // Method dump skipped, instructions count: 343
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.button.MaterialButton.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}

package com.google.android.material.badge;

import a2.j.b.d.b.a;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.PluralsRes;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.XmlRes;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
public class BadgeDrawable extends Drawable implements TextDrawableHelper.TextDrawableDelegate {
    public static final int BOTTOM_END = 8388693;
    public static final int BOTTOM_START = 8388691;
    public static final int TOP_END = 8388661;
    public static final int TOP_START = 8388659;
    @StyleRes
    public static final int q = R.style.Widget_MaterialComponents_Badge;
    @AttrRes
    public static final int r = R.attr.badgeStyle;
    @NonNull
    public final WeakReference<Context> a;
    @NonNull
    public final MaterialShapeDrawable b = new MaterialShapeDrawable();
    @NonNull
    public final TextDrawableHelper c;
    @NonNull
    public final Rect d = new Rect();
    public final float e;
    public final float f;
    public final float g;
    @NonNull
    public final SavedState h;
    public float i;
    public float j;
    public int k;
    public float l;
    public float m;
    public float n;
    @Nullable
    public WeakReference<View> o;
    @Nullable
    public WeakReference<FrameLayout> p;

    @Retention(RetentionPolicy.SOURCE)
    public @interface BadgeGravity {
    }

    public BadgeDrawable(@NonNull Context context) {
        TextAppearance textAppearance;
        Context context2;
        WeakReference<Context> weakReference = new WeakReference<>(context);
        this.a = weakReference;
        ThemeEnforcement.checkMaterialTheme(context);
        Resources resources = context.getResources();
        this.e = (float) resources.getDimensionPixelSize(R.dimen.mtrl_badge_radius);
        this.g = (float) resources.getDimensionPixelSize(R.dimen.mtrl_badge_long_text_horizontal_padding);
        this.f = (float) resources.getDimensionPixelSize(R.dimen.mtrl_badge_with_text_radius);
        TextDrawableHelper textDrawableHelper = new TextDrawableHelper(this);
        this.c = textDrawableHelper;
        textDrawableHelper.getTextPaint().setTextAlign(Paint.Align.CENTER);
        this.h = new SavedState(context);
        int i2 = R.style.TextAppearance_MaterialComponents_Badge;
        Context context3 = weakReference.get();
        if (context3 != null && textDrawableHelper.getTextAppearance() != (textAppearance = new TextAppearance(context3, i2)) && (context2 = weakReference.get()) != null) {
            textDrawableHelper.setTextAppearance(textAppearance, context2);
            c();
        }
    }

    @NonNull
    public static BadgeDrawable a(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        BadgeDrawable badgeDrawable = new BadgeDrawable(context);
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, R.styleable.Badge, i2, i3, new int[0]);
        badgeDrawable.setMaxCharacterCount(obtainStyledAttributes.getInt(R.styleable.Badge_maxCharacterCount, 4));
        int i4 = R.styleable.Badge_number;
        if (obtainStyledAttributes.hasValue(i4)) {
            badgeDrawable.setNumber(obtainStyledAttributes.getInt(i4, 0));
        }
        badgeDrawable.setBackgroundColor(MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.Badge_backgroundColor).getDefaultColor());
        int i5 = R.styleable.Badge_badgeTextColor;
        if (obtainStyledAttributes.hasValue(i5)) {
            badgeDrawable.setBadgeTextColor(MaterialResources.getColorStateList(context, obtainStyledAttributes, i5).getDefaultColor());
        }
        badgeDrawable.setBadgeGravity(obtainStyledAttributes.getInt(R.styleable.Badge_badgeGravity, TOP_END));
        badgeDrawable.setHorizontalOffset(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Badge_horizontalOffset, 0));
        badgeDrawable.setVerticalOffset(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Badge_verticalOffset, 0));
        obtainStyledAttributes.recycle();
        return badgeDrawable;
    }

    @NonNull
    public static BadgeDrawable create(@NonNull Context context) {
        return a(context, null, r, q);
    }

    @NonNull
    public static BadgeDrawable createFromResource(@NonNull Context context, @XmlRes int i2) {
        AttributeSet parseDrawableXml = DrawableUtils.parseDrawableXml(context, i2, "badge");
        int styleAttribute = parseDrawableXml.getStyleAttribute();
        if (styleAttribute == 0) {
            styleAttribute = q;
        }
        return a(context, parseDrawableXml, r, styleAttribute);
    }

    @NonNull
    public final String b() {
        if (getNumber() <= this.k) {
            return NumberFormat.getInstance().format((long) getNumber());
        }
        Context context = this.a.get();
        if (context == null) {
            return "";
        }
        return context.getString(R.string.mtrl_exceed_max_badge_number_suffix, Integer.valueOf(this.k), "+");
    }

    public final void c() {
        float f2;
        float f3;
        Context context = this.a.get();
        WeakReference<View> weakReference = this.o;
        FrameLayout frameLayout = null;
        View view = weakReference != null ? weakReference.get() : null;
        if (context != null && view != null) {
            Rect rect = new Rect();
            rect.set(this.d);
            Rect rect2 = new Rect();
            view.getDrawingRect(rect2);
            WeakReference<FrameLayout> weakReference2 = this.p;
            if (weakReference2 != null) {
                frameLayout = weakReference2.get();
            }
            if (frameLayout != null || BadgeUtils.USE_COMPAT_PARENT) {
                if (frameLayout == null) {
                    frameLayout = (ViewGroup) view.getParent();
                }
                frameLayout.offsetDescendantRectToMyCoords(view, rect2);
            }
            SavedState savedState = this.h;
            int i2 = savedState.i;
            if (i2 == 8388691 || i2 == 8388693) {
                this.j = (float) (rect2.bottom - savedState.l);
            } else {
                this.j = (float) (rect2.top + savedState.l);
            }
            if (getNumber() <= 9) {
                float f4 = !hasNumber() ? this.e : this.f;
                this.l = f4;
                this.n = f4;
                this.m = f4;
            } else {
                float f5 = this.f;
                this.l = f5;
                this.n = f5;
                this.m = (this.c.getTextWidth(b()) / 2.0f) + this.g;
            }
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(hasNumber() ? R.dimen.mtrl_badge_text_horizontal_edge_offset : R.dimen.mtrl_badge_horizontal_edge_offset);
            int i3 = this.h.i;
            if (i3 == 8388659 || i3 == 8388691) {
                if (ViewCompat.getLayoutDirection(view) == 0) {
                    f2 = (((float) rect2.left) - this.m) + ((float) dimensionPixelSize) + ((float) this.h.k);
                } else {
                    f2 = ((((float) rect2.right) + this.m) - ((float) dimensionPixelSize)) - ((float) this.h.k);
                }
                this.i = f2;
            } else {
                if (ViewCompat.getLayoutDirection(view) == 0) {
                    f3 = ((((float) rect2.right) + this.m) - ((float) dimensionPixelSize)) - ((float) this.h.k);
                } else {
                    f3 = (((float) rect2.left) - this.m) + ((float) dimensionPixelSize) + ((float) this.h.k);
                }
                this.i = f3;
            }
            BadgeUtils.updateBadgeBounds(this.d, this.i, this.j, this.m, this.n);
            this.b.setCornerSize(this.l);
            if (!rect.equals(this.d)) {
                this.b.setBounds(this.d);
            }
        }
    }

    public void clearNumber() {
        this.h.d = -1;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (!getBounds().isEmpty() && getAlpha() != 0 && isVisible()) {
            this.b.draw(canvas);
            if (hasNumber()) {
                Rect rect = new Rect();
                String b2 = b();
                this.c.getTextPaint().getTextBounds(b2, 0, b2.length(), rect);
                canvas.drawText(b2, this.i, this.j + ((float) (rect.height() / 2)), this.c.getTextPaint());
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.h.c;
    }

    @ColorInt
    public int getBackgroundColor() {
        return this.b.getFillColor().getDefaultColor();
    }

    public int getBadgeGravity() {
        return this.h.i;
    }

    @ColorInt
    public int getBadgeTextColor() {
        return this.c.getTextPaint().getColor();
    }

    @Nullable
    public CharSequence getContentDescription() {
        Context context;
        if (!isVisible()) {
            return null;
        }
        if (!hasNumber()) {
            return this.h.f;
        }
        if (this.h.g <= 0 || (context = this.a.get()) == null) {
            return null;
        }
        int number = getNumber();
        int i2 = this.k;
        if (number <= i2) {
            return context.getResources().getQuantityString(this.h.g, getNumber(), Integer.valueOf(getNumber()));
        }
        return context.getString(this.h.h, Integer.valueOf(i2));
    }

    @Nullable
    public FrameLayout getCustomBadgeParent() {
        WeakReference<FrameLayout> weakReference = this.p;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public int getHorizontalOffset() {
        return this.h.k;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.d.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.d.width();
    }

    public int getMaxCharacterCount() {
        return this.h.e;
    }

    public int getNumber() {
        if (!hasNumber()) {
            return 0;
        }
        return this.h.d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @NonNull
    public SavedState getSavedState() {
        return this.h;
    }

    public int getVerticalOffset() {
        return this.h.l;
    }

    public boolean hasNumber() {
        return this.h.d != -1;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return false;
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    @Override // com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onTextSizeChange() {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.h.c = i2;
        this.c.getTextPaint().setAlpha(i2);
        invalidateSelf();
    }

    public void setBackgroundColor(@ColorInt int i2) {
        this.h.a = i2;
        ColorStateList valueOf = ColorStateList.valueOf(i2);
        if (this.b.getFillColor() != valueOf) {
            this.b.setFillColor(valueOf);
            invalidateSelf();
        }
    }

    public void setBadgeGravity(int i2) {
        SavedState savedState = this.h;
        if (savedState.i != i2) {
            savedState.i = i2;
            WeakReference<View> weakReference = this.o;
            if (weakReference != null && weakReference.get() != null) {
                View view = this.o.get();
                WeakReference<FrameLayout> weakReference2 = this.p;
                updateBadgeCoordinates(view, weakReference2 != null ? weakReference2.get() : null);
            }
        }
    }

    public void setBadgeTextColor(@ColorInt int i2) {
        this.h.b = i2;
        if (this.c.getTextPaint().getColor() != i2) {
            this.c.getTextPaint().setColor(i2);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void setContentDescriptionExceedsMaxBadgeNumberStringResource(@StringRes int i2) {
        this.h.h = i2;
    }

    public void setContentDescriptionNumberless(CharSequence charSequence) {
        this.h.f = charSequence;
    }

    public void setContentDescriptionQuantityStringsResource(@PluralsRes int i2) {
        this.h.g = i2;
    }

    public void setHorizontalOffset(int i2) {
        this.h.k = i2;
        c();
    }

    public void setMaxCharacterCount(int i2) {
        SavedState savedState = this.h;
        if (savedState.e != i2) {
            savedState.e = i2;
            this.k = ((int) Math.pow(10.0d, ((double) getMaxCharacterCount()) - 1.0d)) - 1;
            this.c.setTextWidthDirty(true);
            c();
            invalidateSelf();
        }
    }

    public void setNumber(int i2) {
        int max = Math.max(0, i2);
        SavedState savedState = this.h;
        if (savedState.d != max) {
            savedState.d = max;
            this.c.setTextWidthDirty(true);
            c();
            invalidateSelf();
        }
    }

    public void setVerticalOffset(int i2) {
        this.h.l = i2;
        c();
    }

    public void setVisible(boolean z) {
        setVisible(z, false);
        this.h.j = z;
        if (BadgeUtils.USE_COMPAT_PARENT && getCustomBadgeParent() != null && !z) {
            ((ViewGroup) getCustomBadgeParent().getParent()).invalidate();
        }
    }

    @Deprecated
    public void updateBadgeCoordinates(@NonNull View view, @Nullable ViewGroup viewGroup) {
        if (viewGroup instanceof FrameLayout) {
            updateBadgeCoordinates(view, (FrameLayout) viewGroup);
            return;
        }
        throw new IllegalArgumentException("customBadgeParent must be a FrameLayout");
    }

    public void updateBadgeCoordinates(@NonNull View view) {
        updateBadgeCoordinates(view, (FrameLayout) null);
    }

    public void updateBadgeCoordinates(@NonNull View view, @Nullable FrameLayout frameLayout) {
        WeakReference<FrameLayout> weakReference;
        this.o = new WeakReference<>(view);
        boolean z = BadgeUtils.USE_COMPAT_PARENT;
        if (!z || frameLayout != null) {
            this.p = new WeakReference<>(frameLayout);
        } else {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if ((viewGroup == null || viewGroup.getId() != R.id.mtrl_anchor_parent) && ((weakReference = this.p) == null || weakReference.get() != viewGroup)) {
                ViewGroup viewGroup2 = (ViewGroup) view.getParent();
                viewGroup2.setClipChildren(false);
                viewGroup2.setClipToPadding(false);
                FrameLayout frameLayout2 = new FrameLayout(view.getContext());
                frameLayout2.setId(R.id.mtrl_anchor_parent);
                frameLayout2.setClipChildren(false);
                frameLayout2.setClipToPadding(false);
                frameLayout2.setLayoutParams(view.getLayoutParams());
                frameLayout2.setMinimumWidth(view.getWidth());
                frameLayout2.setMinimumHeight(view.getHeight());
                int indexOfChild = viewGroup.indexOfChild(view);
                viewGroup.removeViewAt(indexOfChild);
                view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                frameLayout2.addView(view);
                viewGroup.addView(frameLayout2, indexOfChild);
                this.p = new WeakReference<>(frameLayout2);
                frameLayout2.post(new a(this, view, frameLayout2));
            }
        }
        if (!z) {
            ViewGroup viewGroup3 = (ViewGroup) view.getParent();
            viewGroup3.setClipChildren(false);
            viewGroup3.setClipToPadding(false);
        }
        c();
        invalidateSelf();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        @ColorInt
        public int a;
        @ColorInt
        public int b;
        public int c = 255;
        public int d = -1;
        public int e;
        @Nullable
        public CharSequence f;
        @PluralsRes
        public int g;
        @StringRes
        public int h;
        public int i;
        public boolean j;
        @Dimension(unit = 1)
        public int k;
        @Dimension(unit = 1)
        public int l;

        public static class a implements Parcelable.Creator<SavedState> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            @NonNull
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            @NonNull
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(@NonNull Context context) {
            this.b = new TextAppearance(context, R.style.TextAppearance_MaterialComponents_Badge).textColor.getDefaultColor();
            this.f = context.getString(R.string.mtrl_badge_numberless_content_description);
            this.g = R.plurals.mtrl_badge_content_description;
            this.h = R.string.mtrl_exceed_max_badge_number_content_description;
            this.j = true;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c);
            parcel.writeInt(this.d);
            parcel.writeInt(this.e);
            parcel.writeString(this.f.toString());
            parcel.writeInt(this.g);
            parcel.writeInt(this.i);
            parcel.writeInt(this.k);
            parcel.writeInt(this.l);
            parcel.writeInt(this.j ? 1 : 0);
        }

        public SavedState(@NonNull Parcel parcel) {
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            this.c = parcel.readInt();
            this.d = parcel.readInt();
            this.e = parcel.readInt();
            this.f = parcel.readString();
            this.g = parcel.readInt();
            this.i = parcel.readInt();
            this.k = parcel.readInt();
            this.l = parcel.readInt();
            this.j = parcel.readInt() != 0;
        }
    }
}

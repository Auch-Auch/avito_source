package com.google.android.material.textfield;

import a2.j.b.d.s.g;
import a2.j.b.d.s.m;
import a2.j.b.d.s.n;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.DrawableUtils;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.text.BidiFormatter;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
public class TextInputLayout extends LinearLayout {
    public static final int BOX_BACKGROUND_FILLED = 1;
    public static final int BOX_BACKGROUND_NONE = 0;
    public static final int BOX_BACKGROUND_OUTLINE = 2;
    public static final int END_ICON_CLEAR_TEXT = 2;
    public static final int END_ICON_CUSTOM = -1;
    public static final int END_ICON_DROPDOWN_MENU = 3;
    public static final int END_ICON_NONE = 0;
    public static final int END_ICON_PASSWORD_TOGGLE = 1;
    public static final int J0 = R.style.Widget_Design_TextInputLayout;
    public boolean A;
    @ColorInt
    public int A0;
    @Nullable
    public MaterialShapeDrawable B;
    @ColorInt
    public int B0;
    @Nullable
    public MaterialShapeDrawable C;
    public boolean C0;
    @NonNull
    public ShapeAppearanceModel D;
    public final CollapsingTextHelper D0;
    public final int E;
    public boolean E0;
    public int F;
    public boolean F0;
    public int G;
    public ValueAnimator G0;
    public int H;
    public boolean H0;
    public int I;
    public boolean I0;
    public int J;
    @ColorInt
    public int K;
    @ColorInt
    public int L;
    public final Rect M;
    public final Rect N;
    public final RectF O;
    public Typeface P;
    @NonNull
    public final CheckableImageButton Q;
    public ColorStateList R;
    public boolean S;
    public PorterDuff.Mode T;
    public boolean U;
    @Nullable
    public Drawable V;
    public int W;
    @NonNull
    public final FrameLayout a;
    public View.OnLongClickListener a0;
    @NonNull
    public final LinearLayout b;
    public final LinkedHashSet<OnEditTextAttachedListener> b0;
    @NonNull
    public final LinearLayout c;
    public int c0;
    @NonNull
    public final FrameLayout d;
    public final SparseArray<m> d0;
    public EditText e;
    @NonNull
    public final CheckableImageButton e0;
    public CharSequence f;
    public final LinkedHashSet<OnEndIconChangedListener> f0;
    public final n g;
    public ColorStateList g0;
    public boolean h;
    public boolean h0;
    public int i;
    public PorterDuff.Mode i0;
    public boolean j;
    public boolean j0;
    @Nullable
    public TextView k;
    @Nullable
    public Drawable k0;
    public int l;
    public int l0;
    public int m;
    public Drawable m0;
    public CharSequence n;
    public View.OnLongClickListener n0;
    public boolean o;
    public View.OnLongClickListener o0;
    public TextView p;
    @NonNull
    public final CheckableImageButton p0;
    @Nullable
    public ColorStateList q;
    public ColorStateList q0;
    public int r;
    public ColorStateList r0;
    @Nullable
    public ColorStateList s;
    public ColorStateList s0;
    @Nullable
    public ColorStateList t;
    @ColorInt
    public int t0;
    @Nullable
    public CharSequence u;
    @ColorInt
    public int u0;
    @NonNull
    public final TextView v;
    @ColorInt
    public int v0;
    @Nullable
    public CharSequence w;
    public ColorStateList w0;
    @NonNull
    public final TextView x;
    @ColorInt
    public int x0;
    public boolean y;
    @ColorInt
    public int y0;
    public CharSequence z;
    @ColorInt
    public int z0;

    public static class AccessibilityDelegate extends AccessibilityDelegateCompat {
        public final TextInputLayout d;

        public AccessibilityDelegate(@NonNull TextInputLayout textInputLayout) {
            this.d = textInputLayout;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(@NonNull View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            EditText editText = this.d.getEditText();
            CharSequence text = editText != null ? editText.getText() : null;
            CharSequence hint = this.d.getHint();
            CharSequence error = this.d.getError();
            CharSequence placeholderText = this.d.getPlaceholderText();
            int counterMaxLength = this.d.getCounterMaxLength();
            CharSequence counterOverflowDescription = this.d.getCounterOverflowDescription();
            boolean z = !TextUtils.isEmpty(text);
            boolean z2 = !TextUtils.isEmpty(hint);
            boolean z3 = !this.d.C0;
            boolean z4 = !TextUtils.isEmpty(error);
            boolean z5 = z4 || !TextUtils.isEmpty(counterOverflowDescription);
            String charSequence = z2 ? hint.toString() : "";
            if (z) {
                accessibilityNodeInfoCompat.setText(text);
            } else if (!TextUtils.isEmpty(charSequence)) {
                accessibilityNodeInfoCompat.setText(charSequence);
                if (z3 && placeholderText != null) {
                    accessibilityNodeInfoCompat.setText(charSequence + ", " + ((Object) placeholderText));
                }
            } else if (placeholderText != null) {
                accessibilityNodeInfoCompat.setText(placeholderText);
            }
            if (!TextUtils.isEmpty(charSequence)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    accessibilityNodeInfoCompat.setHintText(charSequence);
                } else {
                    if (z) {
                        charSequence = ((Object) text) + ", " + charSequence;
                    }
                    accessibilityNodeInfoCompat.setText(charSequence);
                }
                accessibilityNodeInfoCompat.setShowingHintText(!z);
            }
            if (text == null || text.length() != counterMaxLength) {
                counterMaxLength = -1;
            }
            accessibilityNodeInfoCompat.setMaxTextLength(counterMaxLength);
            if (z5) {
                if (!z4) {
                    error = counterOverflowDescription;
                }
                accessibilityNodeInfoCompat.setError(error);
            }
            if (editText != null) {
                editText.setLabelFor(R.id.textinput_helper_text);
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface BoxBackgroundMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface EndIconMode {
    }

    public interface OnEditTextAttachedListener {
        void onEditTextAttached(@NonNull TextInputLayout textInputLayout);
    }

    public interface OnEndIconChangedListener {
        void onEndIconChanged(@NonNull TextInputLayout textInputLayout, int i);
    }

    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@NonNull Editable editable) {
            TextInputLayout textInputLayout = TextInputLayout.this;
            textInputLayout.v(!textInputLayout.I0, false);
            TextInputLayout textInputLayout2 = TextInputLayout.this;
            if (textInputLayout2.h) {
                textInputLayout2.q(editable.length());
            }
            TextInputLayout textInputLayout3 = TextInputLayout.this;
            if (textInputLayout3.o) {
                textInputLayout3.w(editable.length());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.e0.performClick();
            TextInputLayout.this.e0.jumpDrawablesToCurrentState();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.e.requestLayout();
        }
    }

    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            TextInputLayout.this.D0.setExpansionFraction(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public static class e extends AbsSavedState {
        public static final Parcelable.Creator<e> CREATOR = new a();
        @Nullable
        public CharSequence b;
        public boolean c;
        @Nullable
        public CharSequence d;
        @Nullable
        public CharSequence e;
        @Nullable
        public CharSequence f;

        public static class a implements Parcelable.ClassLoaderCreator<e> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            public e createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new e(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            public Object[] newArray(int i) {
                return new e[i];
            }

            @Override // android.os.Parcelable.Creator
            @Nullable
            public Object createFromParcel(@NonNull Parcel parcel) {
                return new e(parcel, null);
            }
        }

        public e(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // java.lang.Object
        @NonNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("TextInputLayout.SavedState{");
            L.append(Integer.toHexString(System.identityHashCode(this)));
            L.append(" error=");
            L.append((Object) this.b);
            L.append(" hint=");
            L.append((Object) this.d);
            L.append(" helperText=");
            L.append((Object) this.e);
            L.append(" placeholderText=");
            L.append((Object) this.f);
            L.append("}");
            return L.toString();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.b, parcel, i);
            parcel.writeInt(this.c ? 1 : 0);
            TextUtils.writeToParcel(this.d, parcel, i);
            TextUtils.writeToParcel(this.e, parcel, i);
            TextUtils.writeToParcel(this.f, parcel, i);
        }

        public e(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.c = parcel.readInt() != 1 ? false : true;
            this.d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.e = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }
    }

    public TextInputLayout(@NonNull Context context) {
        this(context, null);
    }

    private m getEndIconDelegate() {
        m mVar = this.d0.get(this.c0);
        return mVar != null ? mVar : this.d0.get(0);
    }

    @Nullable
    private CheckableImageButton getEndIconToUpdateDummyDrawable() {
        if (this.p0.getVisibility() == 0) {
            return this.p0;
        }
        if (!i() || !isEndIconVisible()) {
            return null;
        }
        return this.e0;
    }

    public static void l(@NonNull ViewGroup viewGroup, boolean z2) {
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            childAt.setEnabled(z2);
            if (childAt instanceof ViewGroup) {
                l((ViewGroup) childAt, z2);
            }
        }
    }

    public static void n(@NonNull CheckableImageButton checkableImageButton, @Nullable View.OnLongClickListener onLongClickListener) {
        boolean hasOnClickListeners = ViewCompat.hasOnClickListeners(checkableImageButton);
        boolean z2 = false;
        int i2 = 1;
        boolean z3 = onLongClickListener != null;
        if (hasOnClickListeners || z3) {
            z2 = true;
        }
        checkableImageButton.setFocusable(z2);
        checkableImageButton.setClickable(hasOnClickListeners);
        checkableImageButton.setPressable(hasOnClickListeners);
        checkableImageButton.setLongClickable(z3);
        if (!z2) {
            i2 = 2;
        }
        ViewCompat.setImportantForAccessibility(checkableImageButton, i2);
    }

    private void setEditText(EditText editText) {
        if (this.e == null) {
            if (this.c0 != 3) {
                boolean z2 = editText instanceof TextInputEditText;
            }
            this.e = editText;
            j();
            setTextInputAccessibilityDelegate(new AccessibilityDelegate(this));
            this.D0.setTypefaces(this.e.getTypeface());
            this.D0.setExpandedTextSize(this.e.getTextSize());
            int gravity = this.e.getGravity();
            this.D0.setCollapsedTextGravity((gravity & -113) | 48);
            this.D0.setExpandedTextGravity(gravity);
            this.e.addTextChangedListener(new a());
            if (this.r0 == null) {
                this.r0 = this.e.getHintTextColors();
            }
            if (this.y) {
                if (TextUtils.isEmpty(this.z)) {
                    CharSequence hint = this.e.getHint();
                    this.f = hint;
                    setHint(hint);
                    this.e.setHint((CharSequence) null);
                }
                this.A = true;
            }
            if (this.k != null) {
                q(this.e.getText().length());
            }
            t();
            this.g.b();
            this.b.bringToFront();
            this.c.bringToFront();
            this.d.bringToFront();
            this.p0.bringToFront();
            Iterator<OnEditTextAttachedListener> it = this.b0.iterator();
            while (it.hasNext()) {
                it.next().onEditTextAttached(this);
            }
            x();
            A();
            if (!isEnabled()) {
                editText.setEnabled(false);
            }
            v(false, true);
            return;
        }
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    private void setErrorIconVisible(boolean z2) {
        int i2 = 0;
        this.p0.setVisibility(z2 ? 0 : 8);
        FrameLayout frameLayout = this.d;
        if (z2) {
            i2 = 8;
        }
        frameLayout.setVisibility(i2);
        A();
        if (!i()) {
            s();
        }
    }

    private void setHintInternal(CharSequence charSequence) {
        if (!TextUtils.equals(charSequence, this.z)) {
            this.z = charSequence;
            this.D0.setText(charSequence);
            if (!this.C0) {
                k();
            }
        }
    }

    private void setPlaceholderTextEnabled(boolean z2) {
        if (this.o != z2) {
            if (z2) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
                this.p = appCompatTextView;
                appCompatTextView.setId(R.id.textinput_placeholder);
                ViewCompat.setAccessibilityLiveRegion(this.p, 1);
                setPlaceholderTextAppearance(this.r);
                setPlaceholderTextColor(this.q);
                TextView textView = this.p;
                if (textView != null) {
                    this.a.addView(textView);
                    this.p.setVisibility(0);
                }
            } else {
                TextView textView2 = this.p;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
                this.p = null;
            }
            this.o = z2;
        }
    }

    public final void A() {
        if (this.e != null) {
            int i2 = 0;
            if (!isEndIconVisible()) {
                if (!(this.p0.getVisibility() == 0)) {
                    i2 = ViewCompat.getPaddingEnd(this.e);
                }
            }
            ViewCompat.setPaddingRelative(this.x, getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), this.e.getPaddingTop(), i2, this.e.getPaddingBottom());
        }
    }

    public final void B() {
        int visibility = this.x.getVisibility();
        int i2 = 0;
        boolean z2 = this.w != null && !this.C0;
        TextView textView = this.x;
        if (!z2) {
            i2 = 8;
        }
        textView.setVisibility(i2);
        if (visibility != this.x.getVisibility()) {
            getEndIconDelegate().c(z2);
        }
        s();
    }

    public void C() {
        TextView textView;
        EditText editText;
        EditText editText2;
        if (this.B != null && this.F != 0) {
            boolean z2 = false;
            boolean z3 = isFocused() || ((editText2 = this.e) != null && editText2.hasFocus());
            boolean z4 = isHovered() || ((editText = this.e) != null && editText.isHovered());
            if (!isEnabled()) {
                this.K = this.B0;
            } else if (this.g.e()) {
                if (this.w0 != null) {
                    z(z3, z4);
                } else {
                    this.K = this.g.g();
                }
            } else if (!this.j || (textView = this.k) == null) {
                if (z3) {
                    this.K = this.v0;
                } else if (z4) {
                    this.K = this.u0;
                } else {
                    this.K = this.t0;
                }
            } else if (this.w0 != null) {
                z(z3, z4);
            } else {
                this.K = textView.getCurrentTextColor();
            }
            if (getErrorIconDrawable() != null) {
                n nVar = this.g;
                if (nVar.k && nVar.e()) {
                    z2 = true;
                }
            }
            setErrorIconVisible(z2);
            refreshErrorIconDrawableState();
            refreshStartIconDrawableState();
            refreshEndIconDrawableState();
            if (getEndIconDelegate().d()) {
                if (!this.g.e() || getEndIconDrawable() == null) {
                    c();
                } else {
                    Drawable mutate = DrawableCompat.wrap(getEndIconDrawable()).mutate();
                    DrawableCompat.setTint(mutate, this.g.g());
                    this.e0.setImageDrawable(mutate);
                }
            }
            if (!z3 || !isEnabled()) {
                this.H = this.I;
            } else {
                this.H = this.J;
            }
            if (this.F == 1) {
                if (!isEnabled()) {
                    this.L = this.y0;
                } else if (z4 && !z3) {
                    this.L = this.A0;
                } else if (z3) {
                    this.L = this.z0;
                } else {
                    this.L = this.x0;
                }
            }
            b();
        }
    }

    @VisibleForTesting
    public void a(float f2) {
        if (this.D0.getExpansionFraction() != f2) {
            if (this.G0 == null) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.G0 = valueAnimator;
                valueAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
                this.G0.setDuration(167L);
                this.G0.addUpdateListener(new d());
            }
            this.G0.setFloatValues(this.D0.getExpansionFraction(), f2);
            this.G0.start();
        }
    }

    public void addOnEditTextAttachedListener(@NonNull OnEditTextAttachedListener onEditTextAttachedListener) {
        this.b0.add(onEditTextAttachedListener);
        if (this.e != null) {
            onEditTextAttachedListener.onEditTextAttached(this);
        }
    }

    public void addOnEndIconChangedListener(@NonNull OnEndIconChangedListener onEndIconChangedListener) {
        this.f0.add(onEndIconChangedListener);
    }

    @Override // android.view.ViewGroup
    public void addView(@NonNull View view, int i2, @NonNull ViewGroup.LayoutParams layoutParams) {
        if (view instanceof EditText) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            layoutParams2.gravity = (layoutParams2.gravity & -113) | 16;
            this.a.addView(view, layoutParams2);
            this.a.setLayoutParams(layoutParams);
            u();
            setEditText((EditText) view);
            return;
        }
        super.addView(view, i2, layoutParams);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0024  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b() {
        /*
            r6 = this;
            com.google.android.material.shape.MaterialShapeDrawable r0 = r6.B
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            com.google.android.material.shape.ShapeAppearanceModel r1 = r6.D
            r0.setShapeAppearanceModel(r1)
            int r0 = r6.F
            r1 = 2
            r2 = -1
            r3 = 0
            r4 = 1
            if (r0 != r1) goto L_0x0021
            int r0 = r6.H
            if (r0 <= r2) goto L_0x001c
            int r0 = r6.K
            if (r0 == 0) goto L_0x001c
            r0 = 1
            goto L_0x001d
        L_0x001c:
            r0 = 0
        L_0x001d:
            if (r0 == 0) goto L_0x0021
            r0 = 1
            goto L_0x0022
        L_0x0021:
            r0 = 0
        L_0x0022:
            if (r0 == 0) goto L_0x002e
            com.google.android.material.shape.MaterialShapeDrawable r0 = r6.B
            int r1 = r6.H
            float r1 = (float) r1
            int r5 = r6.K
            r0.setStroke(r1, r5)
        L_0x002e:
            int r0 = r6.L
            int r1 = r6.F
            if (r1 != r4) goto L_0x0040
            int r0 = com.google.android.material.R.attr.colorSurface
            int r0 = com.google.android.material.color.MaterialColors.getColor(r6, r0, r3)
            int r1 = r6.L
            int r0 = com.google.android.material.color.MaterialColors.layer(r0, r1)
        L_0x0040:
            r6.L = r0
            com.google.android.material.shape.MaterialShapeDrawable r1 = r6.B
            android.content.res.ColorStateList r0 = android.content.res.ColorStateList.valueOf(r0)
            r1.setFillColor(r0)
            int r0 = r6.c0
            r1 = 3
            if (r0 != r1) goto L_0x0059
            android.widget.EditText r0 = r6.e
            android.graphics.drawable.Drawable r0 = r0.getBackground()
            r0.invalidateSelf()
        L_0x0059:
            com.google.android.material.shape.MaterialShapeDrawable r0 = r6.C
            if (r0 != 0) goto L_0x005e
            goto L_0x0075
        L_0x005e:
            int r1 = r6.H
            if (r1 <= r2) goto L_0x0067
            int r1 = r6.K
            if (r1 == 0) goto L_0x0067
            r3 = 1
        L_0x0067:
            if (r3 == 0) goto L_0x0072
            int r1 = r6.K
            android.content.res.ColorStateList r1 = android.content.res.ColorStateList.valueOf(r1)
            r0.setFillColor(r1)
        L_0x0072:
            r6.invalidate()
        L_0x0075:
            r6.invalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.b():void");
    }

    public final void c() {
        d(this.e0, this.h0, this.g0, this.j0, this.i0);
    }

    public void clearOnEditTextAttachedListeners() {
        this.b0.clear();
    }

    public void clearOnEndIconChangedListeners() {
        this.f0.clear();
    }

    public final void d(@NonNull CheckableImageButton checkableImageButton, boolean z2, ColorStateList colorStateList, boolean z3, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null && (z2 || z3)) {
            drawable = DrawableCompat.wrap(drawable).mutate();
            if (z2) {
                DrawableCompat.setTintList(drawable, colorStateList);
            }
            if (z3) {
                DrawableCompat.setTintMode(drawable, mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    @TargetApi(26)
    public void dispatchProvideAutofillStructure(@NonNull ViewStructure viewStructure, int i2) {
        EditText editText = this.e;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i2);
            return;
        }
        if (this.f != null) {
            boolean z2 = this.A;
            this.A = false;
            CharSequence hint = editText.getHint();
            this.e.setHint(this.f);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i2);
            } finally {
                this.e.setHint(hint);
                this.A = z2;
            }
        } else {
            viewStructure.setAutofillId(getAutofillId());
            onProvideAutofillStructure(viewStructure, i2);
            onProvideAutofillVirtualStructure(viewStructure, i2);
            viewStructure.setChildCount(this.a.getChildCount());
            for (int i3 = 0; i3 < this.a.getChildCount(); i3++) {
                View childAt = this.a.getChildAt(i3);
                ViewStructure newChild = viewStructure.newChild(i3);
                childAt.dispatchProvideAutofillStructure(newChild, i2);
                if (childAt == this.e) {
                    newChild.setHint(getHint());
                }
            }
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    public void dispatchRestoreInstanceState(@NonNull SparseArray<Parcelable> sparseArray) {
        this.I0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.I0 = false;
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        if (this.y) {
            this.D0.draw(canvas);
        }
        MaterialShapeDrawable materialShapeDrawable = this.C;
        if (materialShapeDrawable != null) {
            Rect bounds = materialShapeDrawable.getBounds();
            bounds.top = bounds.bottom - this.H;
            this.C.draw(canvas);
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    public void drawableStateChanged() {
        if (!this.H0) {
            boolean z2 = true;
            this.H0 = true;
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            CollapsingTextHelper collapsingTextHelper = this.D0;
            boolean state = collapsingTextHelper != null ? collapsingTextHelper.setState(drawableState) | false : false;
            if (this.e != null) {
                if (!ViewCompat.isLaidOut(this) || !isEnabled()) {
                    z2 = false;
                }
                v(z2, false);
            }
            t();
            C();
            if (state) {
                invalidate();
            }
            this.H0 = false;
        }
    }

    public final int e() {
        float collapsedTextHeight;
        if (!this.y) {
            return 0;
        }
        int i2 = this.F;
        if (i2 == 0 || i2 == 1) {
            collapsedTextHeight = this.D0.getCollapsedTextHeight();
        } else if (i2 != 2) {
            return 0;
        } else {
            collapsedTextHeight = this.D0.getCollapsedTextHeight() / 2.0f;
        }
        return (int) collapsedTextHeight;
    }

    public final boolean f() {
        return this.y && !TextUtils.isEmpty(this.z) && (this.B instanceof g);
    }

    public final int g(int i2, boolean z2) {
        int compoundPaddingLeft = this.e.getCompoundPaddingLeft() + i2;
        return (this.u == null || z2) ? compoundPaddingLeft : (compoundPaddingLeft - this.v.getMeasuredWidth()) + this.v.getPaddingLeft();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.e;
        if (editText == null) {
            return super.getBaseline();
        }
        return e() + getPaddingTop() + editText.getBaseline();
    }

    @NonNull
    public MaterialShapeDrawable getBoxBackground() {
        int i2 = this.F;
        if (i2 == 1 || i2 == 2) {
            return this.B;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.L;
    }

    public int getBoxBackgroundMode() {
        return this.F;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return this.B.getBottomLeftCornerResolvedSize();
    }

    public float getBoxCornerRadiusBottomStart() {
        return this.B.getBottomRightCornerResolvedSize();
    }

    public float getBoxCornerRadiusTopEnd() {
        return this.B.getTopRightCornerResolvedSize();
    }

    public float getBoxCornerRadiusTopStart() {
        return this.B.getTopLeftCornerResolvedSize();
    }

    public int getBoxStrokeColor() {
        return this.v0;
    }

    @Nullable
    public ColorStateList getBoxStrokeErrorColor() {
        return this.w0;
    }

    public int getBoxStrokeWidth() {
        return this.I;
    }

    public int getBoxStrokeWidthFocused() {
        return this.J;
    }

    public int getCounterMaxLength() {
        return this.i;
    }

    @Nullable
    public CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (!this.h || !this.j || (textView = this.k) == null) {
            return null;
        }
        return textView.getContentDescription();
    }

    @Nullable
    public ColorStateList getCounterOverflowTextColor() {
        return this.s;
    }

    @Nullable
    public ColorStateList getCounterTextColor() {
        return this.s;
    }

    @Nullable
    public ColorStateList getDefaultHintTextColor() {
        return this.r0;
    }

    @Nullable
    public EditText getEditText() {
        return this.e;
    }

    @Nullable
    public CharSequence getEndIconContentDescription() {
        return this.e0.getContentDescription();
    }

    @Nullable
    public Drawable getEndIconDrawable() {
        return this.e0.getDrawable();
    }

    public int getEndIconMode() {
        return this.c0;
    }

    @NonNull
    public CheckableImageButton getEndIconView() {
        return this.e0;
    }

    @Nullable
    public CharSequence getError() {
        n nVar = this.g;
        if (nVar.k) {
            return nVar.j;
        }
        return null;
    }

    @Nullable
    public CharSequence getErrorContentDescription() {
        return this.g.m;
    }

    @ColorInt
    public int getErrorCurrentTextColors() {
        return this.g.g();
    }

    @Nullable
    public Drawable getErrorIconDrawable() {
        return this.p0.getDrawable();
    }

    @VisibleForTesting
    public final int getErrorTextCurrentColor() {
        return this.g.g();
    }

    @Nullable
    public CharSequence getHelperText() {
        n nVar = this.g;
        if (nVar.q) {
            return nVar.p;
        }
        return null;
    }

    @ColorInt
    public int getHelperTextCurrentTextColor() {
        TextView textView = this.g.r;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    @Nullable
    public CharSequence getHint() {
        if (this.y) {
            return this.z;
        }
        return null;
    }

    @VisibleForTesting
    public final float getHintCollapsedTextHeight() {
        return this.D0.getCollapsedTextHeight();
    }

    @VisibleForTesting
    public final int getHintCurrentCollapsedTextColor() {
        return this.D0.getCurrentCollapsedTextColor();
    }

    @Nullable
    public ColorStateList getHintTextColor() {
        return this.s0;
    }

    @Nullable
    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.e0.getContentDescription();
    }

    @Nullable
    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.e0.getDrawable();
    }

    @Nullable
    public CharSequence getPlaceholderText() {
        if (this.o) {
            return this.n;
        }
        return null;
    }

    @StyleRes
    public int getPlaceholderTextAppearance() {
        return this.r;
    }

    @Nullable
    public ColorStateList getPlaceholderTextColor() {
        return this.q;
    }

    @Nullable
    public CharSequence getPrefixText() {
        return this.u;
    }

    @Nullable
    public ColorStateList getPrefixTextColor() {
        return this.v.getTextColors();
    }

    @NonNull
    public TextView getPrefixTextView() {
        return this.v;
    }

    @Nullable
    public CharSequence getStartIconContentDescription() {
        return this.Q.getContentDescription();
    }

    @Nullable
    public Drawable getStartIconDrawable() {
        return this.Q.getDrawable();
    }

    @Nullable
    public CharSequence getSuffixText() {
        return this.w;
    }

    @Nullable
    public ColorStateList getSuffixTextColor() {
        return this.x.getTextColors();
    }

    @NonNull
    public TextView getSuffixTextView() {
        return this.x;
    }

    @Nullable
    public Typeface getTypeface() {
        return this.P;
    }

    public final int h(int i2, boolean z2) {
        int compoundPaddingRight = i2 - this.e.getCompoundPaddingRight();
        return (this.u == null || !z2) ? compoundPaddingRight : compoundPaddingRight + (this.v.getMeasuredWidth() - this.v.getPaddingRight());
    }

    public final boolean i() {
        return this.c0 != 0;
    }

    public boolean isCounterEnabled() {
        return this.h;
    }

    public boolean isEndIconCheckable() {
        return this.e0.isCheckable();
    }

    public boolean isEndIconVisible() {
        return this.d.getVisibility() == 0 && this.e0.getVisibility() == 0;
    }

    public boolean isErrorEnabled() {
        return this.g.k;
    }

    public boolean isExpandedHintEnabled() {
        return this.E0;
    }

    public boolean isHelperTextEnabled() {
        return this.g.q;
    }

    public boolean isHintAnimationEnabled() {
        return this.F0;
    }

    public boolean isHintEnabled() {
        return this.y;
    }

    @Deprecated
    public boolean isPasswordVisibilityToggleEnabled() {
        return this.c0 == 1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isProvidingHint() {
        return this.A;
    }

    public boolean isStartIconCheckable() {
        return this.Q.isCheckable();
    }

    public boolean isStartIconVisible() {
        return this.Q.getVisibility() == 0;
    }

    public final void j() {
        int i2 = this.F;
        if (i2 == 0) {
            this.B = null;
            this.C = null;
        } else if (i2 == 1) {
            this.B = new MaterialShapeDrawable(this.D);
            this.C = new MaterialShapeDrawable();
        } else if (i2 == 2) {
            if (!this.y || (this.B instanceof g)) {
                this.B = new MaterialShapeDrawable(this.D);
            } else {
                this.B = new g(this.D);
            }
            this.C = null;
        } else {
            throw new IllegalArgumentException(a2.b.a.a.a.j(new StringBuilder(), this.F, " is illegal; only @BoxBackgroundMode constants are supported."));
        }
        EditText editText = this.e;
        if ((editText == null || this.B == null || editText.getBackground() != null || this.F == 0) ? false : true) {
            ViewCompat.setBackground(this.e, this.B);
        }
        C();
        if (this.F == 1) {
            if (MaterialResources.isFontScaleAtLeast2_0(getContext())) {
                this.G = getResources().getDimensionPixelSize(R.dimen.material_font_2_0_box_collapsed_padding_top);
            } else if (MaterialResources.isFontScaleAtLeast1_3(getContext())) {
                this.G = getResources().getDimensionPixelSize(R.dimen.material_font_1_3_box_collapsed_padding_top);
            }
        }
        if (this.e != null && this.F == 1) {
            if (MaterialResources.isFontScaleAtLeast2_0(getContext())) {
                EditText editText2 = this.e;
                ViewCompat.setPaddingRelative(editText2, ViewCompat.getPaddingStart(editText2), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_2_0_padding_top), ViewCompat.getPaddingEnd(this.e), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_2_0_padding_bottom));
            } else if (MaterialResources.isFontScaleAtLeast1_3(getContext())) {
                EditText editText3 = this.e;
                ViewCompat.setPaddingRelative(editText3, ViewCompat.getPaddingStart(editText3), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_1_3_padding_top), ViewCompat.getPaddingEnd(this.e), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_1_3_padding_bottom));
            }
        }
        if (this.F != 0) {
            u();
        }
    }

    public final void k() {
        if (f()) {
            RectF rectF = this.O;
            this.D0.getCollapsedTextActualBounds(rectF, this.e.getWidth(), this.e.getGravity());
            float f2 = rectF.left;
            float f3 = (float) this.E;
            rectF.left = f2 - f3;
            rectF.top -= f3;
            rectF.right += f3;
            rectF.bottom += f3;
            rectF.offset((float) (-getPaddingLeft()), (float) (-getPaddingTop()));
            g gVar = (g) this.B;
            Objects.requireNonNull(gVar);
            gVar.j(rectF.left, rectF.top, rectF.right, rectF.bottom);
        }
    }

    public final void m(CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() != null && colorStateList != null && colorStateList.isStateful()) {
            int[] drawableState = getDrawableState();
            int[] drawableState2 = checkableImageButton.getDrawableState();
            int length = drawableState.length;
            int[] copyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
            System.arraycopy(drawableState2, 0, copyOf, length, drawableState2.length);
            int colorForState = colorStateList.getColorForState(copyOf, colorStateList.getDefaultColor());
            Drawable mutate = DrawableCompat.wrap(drawable).mutate();
            DrawableCompat.setTintList(mutate, ColorStateList.valueOf(colorForState));
            checkableImageButton.setImageDrawable(mutate);
        }
    }

    public void o(@NonNull TextView textView, @StyleRes int i2) {
        boolean z2 = true;
        try {
            TextViewCompat.setTextAppearance(textView, i2);
            if (Build.VERSION.SDK_INT < 23 || textView.getTextColors().getDefaultColor() != -65281) {
                z2 = false;
            }
        } catch (Exception unused) {
        }
        if (z2) {
            TextViewCompat.setTextAppearance(textView, R.style.TextAppearance_AppCompat_Caption);
            textView.setTextColor(ContextCompat.getColor(getContext(), R.color.design_error));
        }
    }

    @Override // android.widget.LinearLayout, android.view.View, android.view.ViewGroup
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        super.onLayout(z2, i2, i3, i4, i5);
        EditText editText = this.e;
        if (editText != null) {
            Rect rect = this.M;
            DescendantOffsetUtils.getDescendantRect(this, editText, rect);
            MaterialShapeDrawable materialShapeDrawable = this.C;
            if (materialShapeDrawable != null) {
                int i8 = rect.bottom;
                materialShapeDrawable.setBounds(rect.left, i8 - this.J, rect.right, i8);
            }
            if (this.y) {
                this.D0.setExpandedTextSize(this.e.getTextSize());
                int gravity = this.e.getGravity();
                this.D0.setCollapsedTextGravity((gravity & -113) | 48);
                this.D0.setExpandedTextGravity(gravity);
                CollapsingTextHelper collapsingTextHelper = this.D0;
                if (this.e != null) {
                    Rect rect2 = this.N;
                    boolean z3 = false;
                    boolean z4 = ViewCompat.getLayoutDirection(this) == 1;
                    rect2.bottom = rect.bottom;
                    int i9 = this.F;
                    if (i9 == 1) {
                        rect2.left = g(rect.left, z4);
                        rect2.top = rect.top + this.G;
                        rect2.right = h(rect.right, z4);
                    } else if (i9 != 2) {
                        rect2.left = g(rect.left, z4);
                        rect2.top = getPaddingTop();
                        rect2.right = h(rect.right, z4);
                    } else {
                        rect2.left = this.e.getPaddingLeft() + rect.left;
                        rect2.top = rect.top - e();
                        rect2.right = rect.right - this.e.getPaddingRight();
                    }
                    collapsingTextHelper.setCollapsedBounds(rect2);
                    CollapsingTextHelper collapsingTextHelper2 = this.D0;
                    if (this.e != null) {
                        Rect rect3 = this.N;
                        float expandedTextHeight = collapsingTextHelper2.getExpandedTextHeight();
                        rect3.left = this.e.getCompoundPaddingLeft() + rect.left;
                        if (this.F == 1 && this.e.getMinLines() <= 1) {
                            i6 = (int) (((float) rect.centerY()) - (expandedTextHeight / 2.0f));
                        } else {
                            i6 = rect.top + this.e.getCompoundPaddingTop();
                        }
                        rect3.top = i6;
                        rect3.right = rect.right - this.e.getCompoundPaddingRight();
                        if (this.F == 1 && this.e.getMinLines() <= 1) {
                            z3 = true;
                        }
                        if (z3) {
                            i7 = (int) (((float) rect3.top) + expandedTextHeight);
                        } else {
                            i7 = rect.bottom - this.e.getCompoundPaddingBottom();
                        }
                        rect3.bottom = i7;
                        collapsingTextHelper2.setExpandedBounds(rect3);
                        this.D0.recalculate();
                        if (f() && !this.C0) {
                            k();
                            return;
                        }
                        return;
                    }
                    throw new IllegalStateException();
                }
                throw new IllegalStateException();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        EditText editText;
        int max;
        super.onMeasure(i2, i3);
        boolean z2 = false;
        if (this.e != null && this.e.getMeasuredHeight() < (max = Math.max(this.c.getMeasuredHeight(), this.b.getMeasuredHeight()))) {
            this.e.setMinimumHeight(max);
            z2 = true;
        }
        boolean s2 = s();
        if (z2 || s2) {
            this.e.post(new c());
        }
        if (!(this.p == null || (editText = this.e) == null)) {
            this.p.setGravity(editText.getGravity());
            this.p.setPadding(this.e.getCompoundPaddingLeft(), this.e.getCompoundPaddingTop(), this.e.getCompoundPaddingRight(), this.e.getCompoundPaddingBottom());
        }
        x();
        A();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof e)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        e eVar = (e) parcelable;
        super.onRestoreInstanceState(eVar.getSuperState());
        setError(eVar.b);
        if (eVar.c) {
            this.e0.post(new b());
        }
        setHint(eVar.d);
        setHelperText(eVar.e);
        setPlaceholderText(eVar.f);
        requestLayout();
    }

    @Override // android.view.View
    @Nullable
    public Parcelable onSaveInstanceState() {
        e eVar = new e(super.onSaveInstanceState());
        if (this.g.e()) {
            eVar.b = getError();
        }
        eVar.c = i() && this.e0.isChecked();
        eVar.d = getHint();
        eVar.e = getHelperText();
        eVar.f = getPlaceholderText();
        return eVar;
    }

    public final void p() {
        if (this.k != null) {
            EditText editText = this.e;
            q(editText == null ? 0 : editText.getText().length());
        }
    }

    @Deprecated
    public void passwordVisibilityToggleRequested(boolean z2) {
        if (this.c0 == 1) {
            this.e0.performClick();
            if (z2) {
                this.e0.jumpDrawablesToCurrentState();
            }
        }
    }

    public void q(int i2) {
        boolean z2 = this.j;
        int i3 = this.i;
        if (i3 == -1) {
            this.k.setText(String.valueOf(i2));
            this.k.setContentDescription(null);
            this.j = false;
        } else {
            this.j = i2 > i3;
            Context context = getContext();
            this.k.setContentDescription(context.getString(this.j ? R.string.character_counter_overflowed_content_description : R.string.character_counter_content_description, Integer.valueOf(i2), Integer.valueOf(this.i)));
            if (z2 != this.j) {
                r();
            }
            this.k.setText(BidiFormatter.getInstance().unicodeWrap(getContext().getString(R.string.character_counter_pattern, Integer.valueOf(i2), Integer.valueOf(this.i))));
        }
        if (this.e != null && z2 != this.j) {
            v(false, false);
            C();
            t();
        }
    }

    public final void r() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.k;
        if (textView != null) {
            o(textView, this.j ? this.l : this.m);
            if (!this.j && (colorStateList2 = this.s) != null) {
                this.k.setTextColor(colorStateList2);
            }
            if (this.j && (colorStateList = this.t) != null) {
                this.k.setTextColor(colorStateList);
            }
        }
    }

    public void refreshEndIconDrawableState() {
        m(this.e0, this.g0);
    }

    public void refreshErrorIconDrawableState() {
        m(this.p0, this.q0);
    }

    public void refreshStartIconDrawableState() {
        m(this.Q, this.R);
    }

    public void removeOnEditTextAttachedListener(@NonNull OnEditTextAttachedListener onEditTextAttachedListener) {
        this.b0.remove(onEditTextAttachedListener);
    }

    public void removeOnEndIconChangedListener(@NonNull OnEndIconChangedListener onEndIconChangedListener) {
        this.f0.remove(onEndIconChangedListener);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0104  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean s() {
        /*
        // Method dump skipped, instructions count: 295
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.s():boolean");
    }

    public void setBoxBackgroundColor(@ColorInt int i2) {
        if (this.L != i2) {
            this.L = i2;
            this.x0 = i2;
            this.z0 = i2;
            this.A0 = i2;
            b();
        }
    }

    public void setBoxBackgroundColorResource(@ColorRes int i2) {
        setBoxBackgroundColor(ContextCompat.getColor(getContext(), i2));
    }

    public void setBoxBackgroundColorStateList(@NonNull ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.x0 = defaultColor;
        this.L = defaultColor;
        this.y0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.z0 = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        this.A0 = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
        b();
    }

    public void setBoxBackgroundMode(int i2) {
        if (i2 != this.F) {
            this.F = i2;
            if (this.e != null) {
                j();
            }
        }
    }

    public void setBoxCornerRadii(float f2, float f3, float f4, float f5) {
        MaterialShapeDrawable materialShapeDrawable = this.B;
        if (materialShapeDrawable == null || materialShapeDrawable.getTopLeftCornerResolvedSize() != f2 || this.B.getTopRightCornerResolvedSize() != f3 || this.B.getBottomRightCornerResolvedSize() != f5 || this.B.getBottomLeftCornerResolvedSize() != f4) {
            this.D = this.D.toBuilder().setTopLeftCornerSize(f2).setTopRightCornerSize(f3).setBottomRightCornerSize(f5).setBottomLeftCornerSize(f4).build();
            b();
        }
    }

    public void setBoxCornerRadiiResources(@DimenRes int i2, @DimenRes int i3, @DimenRes int i4, @DimenRes int i5) {
        setBoxCornerRadii(getContext().getResources().getDimension(i2), getContext().getResources().getDimension(i3), getContext().getResources().getDimension(i5), getContext().getResources().getDimension(i4));
    }

    public void setBoxStrokeColor(@ColorInt int i2) {
        if (this.v0 != i2) {
            this.v0 = i2;
            C();
        }
    }

    public void setBoxStrokeColorStateList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.t0 = colorStateList.getDefaultColor();
            this.B0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.u0 = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
            this.v0 = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        } else if (this.v0 != colorStateList.getDefaultColor()) {
            this.v0 = colorStateList.getDefaultColor();
        }
        C();
    }

    public void setBoxStrokeErrorColor(@Nullable ColorStateList colorStateList) {
        if (this.w0 != colorStateList) {
            this.w0 = colorStateList;
            C();
        }
    }

    public void setBoxStrokeWidth(int i2) {
        this.I = i2;
        C();
    }

    public void setBoxStrokeWidthFocused(int i2) {
        this.J = i2;
        C();
    }

    public void setBoxStrokeWidthFocusedResource(@DimenRes int i2) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i2));
    }

    public void setBoxStrokeWidthResource(@DimenRes int i2) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i2));
    }

    public void setCounterEnabled(boolean z2) {
        if (this.h != z2) {
            if (z2) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
                this.k = appCompatTextView;
                appCompatTextView.setId(R.id.textinput_counter);
                Typeface typeface = this.P;
                if (typeface != null) {
                    this.k.setTypeface(typeface);
                }
                this.k.setMaxLines(1);
                this.g.a(this.k, 2);
                MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) this.k.getLayoutParams(), getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_counter_margin_start));
                r();
                p();
            } else {
                this.g.j(this.k, 2);
                this.k = null;
            }
            this.h = z2;
        }
    }

    public void setCounterMaxLength(int i2) {
        if (this.i != i2) {
            if (i2 > 0) {
                this.i = i2;
            } else {
                this.i = -1;
            }
            if (this.h) {
                p();
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i2) {
        if (this.l != i2) {
            this.l = i2;
            r();
        }
    }

    public void setCounterOverflowTextColor(@Nullable ColorStateList colorStateList) {
        if (this.t != colorStateList) {
            this.t = colorStateList;
            r();
        }
    }

    public void setCounterTextAppearance(int i2) {
        if (this.m != i2) {
            this.m = i2;
            r();
        }
    }

    public void setCounterTextColor(@Nullable ColorStateList colorStateList) {
        if (this.s != colorStateList) {
            this.s = colorStateList;
            r();
        }
    }

    public void setDefaultHintTextColor(@Nullable ColorStateList colorStateList) {
        this.r0 = colorStateList;
        this.s0 = colorStateList;
        if (this.e != null) {
            v(false, false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z2) {
        l(this, z2);
        super.setEnabled(z2);
    }

    public void setEndIconActivated(boolean z2) {
        this.e0.setActivated(z2);
    }

    public void setEndIconCheckable(boolean z2) {
        this.e0.setCheckable(z2);
    }

    public void setEndIconContentDescription(@StringRes int i2) {
        setEndIconContentDescription(i2 != 0 ? getResources().getText(i2) : null);
    }

    public void setEndIconDrawable(@DrawableRes int i2) {
        setEndIconDrawable(i2 != 0 ? AppCompatResources.getDrawable(getContext(), i2) : null);
    }

    public void setEndIconMode(int i2) {
        int i3 = this.c0;
        this.c0 = i2;
        Iterator<OnEndIconChangedListener> it = this.f0.iterator();
        while (it.hasNext()) {
            it.next().onEndIconChanged(this, i3);
        }
        setEndIconVisible(i2 != 0);
        if (getEndIconDelegate().b(this.F)) {
            getEndIconDelegate().a();
            c();
            return;
        }
        StringBuilder L2 = a2.b.a.a.a.L("The current box background mode ");
        L2.append(this.F);
        L2.append(" is not supported by the end icon mode ");
        L2.append(i2);
        throw new IllegalStateException(L2.toString());
    }

    public void setEndIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        CheckableImageButton checkableImageButton = this.e0;
        View.OnLongClickListener onLongClickListener = this.n0;
        checkableImageButton.setOnClickListener(onClickListener);
        n(checkableImageButton, onLongClickListener);
    }

    public void setEndIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.n0 = onLongClickListener;
        CheckableImageButton checkableImageButton = this.e0;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        n(checkableImageButton, onLongClickListener);
    }

    public void setEndIconTintList(@Nullable ColorStateList colorStateList) {
        if (this.g0 != colorStateList) {
            this.g0 = colorStateList;
            this.h0 = true;
            c();
        }
    }

    public void setEndIconTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.i0 != mode) {
            this.i0 = mode;
            this.j0 = true;
            c();
        }
    }

    public void setEndIconVisible(boolean z2) {
        if (isEndIconVisible() != z2) {
            this.e0.setVisibility(z2 ? 0 : 8);
            A();
            s();
        }
    }

    public void setError(@Nullable CharSequence charSequence) {
        if (!this.g.k) {
            if (!TextUtils.isEmpty(charSequence)) {
                setErrorEnabled(true);
            } else {
                return;
            }
        }
        if (!TextUtils.isEmpty(charSequence)) {
            n nVar = this.g;
            nVar.c();
            nVar.j = charSequence;
            nVar.l.setText(charSequence);
            int i2 = nVar.h;
            if (i2 != 1) {
                nVar.i = 1;
            }
            nVar.l(i2, nVar.i, nVar.k(nVar.l, charSequence));
            return;
        }
        this.g.i();
    }

    public void setErrorContentDescription(@Nullable CharSequence charSequence) {
        n nVar = this.g;
        nVar.m = charSequence;
        TextView textView = nVar.l;
        if (textView != null) {
            textView.setContentDescription(charSequence);
        }
    }

    public void setErrorEnabled(boolean z2) {
        n nVar = this.g;
        if (nVar.k != z2) {
            nVar.c();
            if (z2) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(nVar.a);
                nVar.l = appCompatTextView;
                appCompatTextView.setId(R.id.textinput_error);
                nVar.l.setTextAlignment(5);
                Typeface typeface = nVar.u;
                if (typeface != null) {
                    nVar.l.setTypeface(typeface);
                }
                int i2 = nVar.n;
                nVar.n = i2;
                TextView textView = nVar.l;
                if (textView != null) {
                    nVar.b.o(textView, i2);
                }
                ColorStateList colorStateList = nVar.o;
                nVar.o = colorStateList;
                TextView textView2 = nVar.l;
                if (!(textView2 == null || colorStateList == null)) {
                    textView2.setTextColor(colorStateList);
                }
                CharSequence charSequence = nVar.m;
                nVar.m = charSequence;
                TextView textView3 = nVar.l;
                if (textView3 != null) {
                    textView3.setContentDescription(charSequence);
                }
                nVar.l.setVisibility(4);
                ViewCompat.setAccessibilityLiveRegion(nVar.l, 1);
                nVar.a(nVar.l, 0);
            } else {
                nVar.i();
                nVar.j(nVar.l, 0);
                nVar.l = null;
                nVar.b.t();
                nVar.b.C();
            }
            nVar.k = z2;
        }
    }

    public void setErrorIconDrawable(@DrawableRes int i2) {
        setErrorIconDrawable(i2 != 0 ? AppCompatResources.getDrawable(getContext(), i2) : null);
        refreshErrorIconDrawableState();
    }

    public void setErrorIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        CheckableImageButton checkableImageButton = this.p0;
        View.OnLongClickListener onLongClickListener = this.o0;
        checkableImageButton.setOnClickListener(onClickListener);
        n(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.o0 = onLongClickListener;
        CheckableImageButton checkableImageButton = this.p0;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        n(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconTintList(@Nullable ColorStateList colorStateList) {
        this.q0 = colorStateList;
        Drawable drawable = this.p0.getDrawable();
        if (drawable != null) {
            drawable = DrawableCompat.wrap(drawable).mutate();
            DrawableCompat.setTintList(drawable, colorStateList);
        }
        if (this.p0.getDrawable() != drawable) {
            this.p0.setImageDrawable(drawable);
        }
    }

    public void setErrorIconTintMode(@Nullable PorterDuff.Mode mode) {
        Drawable drawable = this.p0.getDrawable();
        if (drawable != null) {
            drawable = DrawableCompat.wrap(drawable).mutate();
            DrawableCompat.setTintMode(drawable, mode);
        }
        if (this.p0.getDrawable() != drawable) {
            this.p0.setImageDrawable(drawable);
        }
    }

    public void setErrorTextAppearance(@StyleRes int i2) {
        n nVar = this.g;
        nVar.n = i2;
        TextView textView = nVar.l;
        if (textView != null) {
            nVar.b.o(textView, i2);
        }
    }

    public void setErrorTextColor(@Nullable ColorStateList colorStateList) {
        n nVar = this.g;
        nVar.o = colorStateList;
        TextView textView = nVar.l;
        if (textView != null && colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setExpandedHintEnabled(boolean z2) {
        if (this.E0 != z2) {
            this.E0 = z2;
            v(false, false);
        }
    }

    public void setHelperText(@Nullable CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (!isHelperTextEnabled()) {
                setHelperTextEnabled(true);
            }
            n nVar = this.g;
            nVar.c();
            nVar.p = charSequence;
            nVar.r.setText(charSequence);
            int i2 = nVar.h;
            if (i2 != 2) {
                nVar.i = 2;
            }
            nVar.l(i2, nVar.i, nVar.k(nVar.r, charSequence));
        } else if (isHelperTextEnabled()) {
            setHelperTextEnabled(false);
        }
    }

    public void setHelperTextColor(@Nullable ColorStateList colorStateList) {
        n nVar = this.g;
        nVar.t = colorStateList;
        TextView textView = nVar.r;
        if (textView != null && colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setHelperTextEnabled(boolean z2) {
        n nVar = this.g;
        if (nVar.q != z2) {
            nVar.c();
            if (z2) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(nVar.a);
                nVar.r = appCompatTextView;
                appCompatTextView.setId(R.id.textinput_helper_text);
                nVar.r.setTextAlignment(5);
                Typeface typeface = nVar.u;
                if (typeface != null) {
                    nVar.r.setTypeface(typeface);
                }
                nVar.r.setVisibility(4);
                ViewCompat.setAccessibilityLiveRegion(nVar.r, 1);
                int i2 = nVar.s;
                nVar.s = i2;
                TextView textView = nVar.r;
                if (textView != null) {
                    TextViewCompat.setTextAppearance(textView, i2);
                }
                ColorStateList colorStateList = nVar.t;
                nVar.t = colorStateList;
                TextView textView2 = nVar.r;
                if (!(textView2 == null || colorStateList == null)) {
                    textView2.setTextColor(colorStateList);
                }
                nVar.a(nVar.r, 1);
            } else {
                nVar.c();
                int i3 = nVar.h;
                if (i3 == 2) {
                    nVar.i = 0;
                }
                nVar.l(i3, nVar.i, nVar.k(nVar.r, null));
                nVar.j(nVar.r, 1);
                nVar.r = null;
                nVar.b.t();
                nVar.b.C();
            }
            nVar.q = z2;
        }
    }

    public void setHelperTextTextAppearance(@StyleRes int i2) {
        n nVar = this.g;
        nVar.s = i2;
        TextView textView = nVar.r;
        if (textView != null) {
            TextViewCompat.setTextAppearance(textView, i2);
        }
    }

    public void setHint(@Nullable CharSequence charSequence) {
        if (this.y) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z2) {
        this.F0 = z2;
    }

    public void setHintEnabled(boolean z2) {
        if (z2 != this.y) {
            this.y = z2;
            if (!z2) {
                this.A = false;
                if (!TextUtils.isEmpty(this.z) && TextUtils.isEmpty(this.e.getHint())) {
                    this.e.setHint(this.z);
                }
                setHintInternal(null);
            } else {
                CharSequence hint = this.e.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.z)) {
                        setHint(hint);
                    }
                    this.e.setHint((CharSequence) null);
                }
                this.A = true;
            }
            if (this.e != null) {
                u();
            }
        }
    }

    public void setHintTextAppearance(@StyleRes int i2) {
        this.D0.setCollapsedTextAppearance(i2);
        this.s0 = this.D0.getCollapsedTextColor();
        if (this.e != null) {
            v(false, false);
            u();
        }
    }

    public void setHintTextColor(@Nullable ColorStateList colorStateList) {
        if (this.s0 != colorStateList) {
            if (this.r0 == null) {
                this.D0.setCollapsedTextColor(colorStateList);
            }
            this.s0 = colorStateList;
            if (this.e != null) {
                v(false, false);
            }
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@StringRes int i2) {
        setPasswordVisibilityToggleContentDescription(i2 != 0 ? getResources().getText(i2) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@DrawableRes int i2) {
        setPasswordVisibilityToggleDrawable(i2 != 0 ? AppCompatResources.getDrawable(getContext(), i2) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z2) {
        if (z2 && this.c0 != 1) {
            setEndIconMode(1);
        } else if (!z2) {
            setEndIconMode(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(@Nullable ColorStateList colorStateList) {
        this.g0 = colorStateList;
        this.h0 = true;
        c();
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(@Nullable PorterDuff.Mode mode) {
        this.i0 = mode;
        this.j0 = true;
        c();
    }

    public void setPlaceholderText(@Nullable CharSequence charSequence) {
        int i2 = 0;
        if (!this.o || !TextUtils.isEmpty(charSequence)) {
            if (!this.o) {
                setPlaceholderTextEnabled(true);
            }
            this.n = charSequence;
        } else {
            setPlaceholderTextEnabled(false);
        }
        EditText editText = this.e;
        if (editText != null) {
            i2 = editText.getText().length();
        }
        w(i2);
    }

    public void setPlaceholderTextAppearance(@StyleRes int i2) {
        this.r = i2;
        TextView textView = this.p;
        if (textView != null) {
            TextViewCompat.setTextAppearance(textView, i2);
        }
    }

    public void setPlaceholderTextColor(@Nullable ColorStateList colorStateList) {
        if (this.q != colorStateList) {
            this.q = colorStateList;
            TextView textView = this.p;
            if (textView != null && colorStateList != null) {
                textView.setTextColor(colorStateList);
            }
        }
    }

    public void setPrefixText(@Nullable CharSequence charSequence) {
        this.u = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.v.setText(charSequence);
        y();
    }

    public void setPrefixTextAppearance(@StyleRes int i2) {
        TextViewCompat.setTextAppearance(this.v, i2);
    }

    public void setPrefixTextColor(@NonNull ColorStateList colorStateList) {
        this.v.setTextColor(colorStateList);
    }

    public void setStartIconCheckable(boolean z2) {
        this.Q.setCheckable(z2);
    }

    public void setStartIconContentDescription(@StringRes int i2) {
        setStartIconContentDescription(i2 != 0 ? getResources().getText(i2) : null);
    }

    public void setStartIconDrawable(@DrawableRes int i2) {
        setStartIconDrawable(i2 != 0 ? AppCompatResources.getDrawable(getContext(), i2) : null);
    }

    public void setStartIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        CheckableImageButton checkableImageButton = this.Q;
        View.OnLongClickListener onLongClickListener = this.a0;
        checkableImageButton.setOnClickListener(onClickListener);
        n(checkableImageButton, onLongClickListener);
    }

    public void setStartIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.a0 = onLongClickListener;
        CheckableImageButton checkableImageButton = this.Q;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        n(checkableImageButton, onLongClickListener);
    }

    public void setStartIconTintList(@Nullable ColorStateList colorStateList) {
        if (this.R != colorStateList) {
            this.R = colorStateList;
            this.S = true;
            d(this.Q, true, colorStateList, this.U, this.T);
        }
    }

    public void setStartIconTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.T != mode) {
            this.T = mode;
            this.U = true;
            d(this.Q, this.S, this.R, true, mode);
        }
    }

    public void setStartIconVisible(boolean z2) {
        if (isStartIconVisible() != z2) {
            this.Q.setVisibility(z2 ? 0 : 8);
            x();
            s();
        }
    }

    public void setSuffixText(@Nullable CharSequence charSequence) {
        this.w = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.x.setText(charSequence);
        B();
    }

    public void setSuffixTextAppearance(@StyleRes int i2) {
        TextViewCompat.setTextAppearance(this.x, i2);
    }

    public void setSuffixTextColor(@NonNull ColorStateList colorStateList) {
        this.x.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(@Nullable AccessibilityDelegate accessibilityDelegate) {
        EditText editText = this.e;
        if (editText != null) {
            ViewCompat.setAccessibilityDelegate(editText, accessibilityDelegate);
        }
    }

    public void setTypeface(@Nullable Typeface typeface) {
        if (typeface != this.P) {
            this.P = typeface;
            this.D0.setTypefaces(typeface);
            n nVar = this.g;
            if (typeface != nVar.u) {
                nVar.u = typeface;
                TextView textView = nVar.l;
                if (textView != null) {
                    textView.setTypeface(typeface);
                }
                TextView textView2 = nVar.r;
                if (textView2 != null) {
                    textView2.setTypeface(typeface);
                }
            }
            TextView textView3 = this.k;
            if (textView3 != null) {
                textView3.setTypeface(typeface);
            }
        }
    }

    public void t() {
        Drawable background;
        TextView textView;
        EditText editText = this.e;
        if (editText != null && this.F == 0 && (background = editText.getBackground()) != null) {
            if (DrawableUtils.canSafelyMutateDrawable(background)) {
                background = background.mutate();
            }
            if (this.g.e()) {
                background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(this.g.g(), PorterDuff.Mode.SRC_IN));
            } else if (!this.j || (textView = this.k) == null) {
                DrawableCompat.clearColorFilter(background);
                this.e.refreshDrawableState();
            } else {
                background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
            }
        }
    }

    public final void u() {
        if (this.F != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.a.getLayoutParams();
            int e2 = e();
            if (e2 != layoutParams.topMargin) {
                layoutParams.topMargin = e2;
                this.a.requestLayout();
            }
        }
    }

    public final void v(boolean z2, boolean z3) {
        ColorStateList colorStateList;
        TextView textView;
        boolean isEnabled = isEnabled();
        EditText editText = this.e;
        int i2 = 0;
        boolean z4 = editText != null && !TextUtils.isEmpty(editText.getText());
        EditText editText2 = this.e;
        boolean z5 = editText2 != null && editText2.hasFocus();
        boolean e2 = this.g.e();
        ColorStateList colorStateList2 = this.r0;
        if (colorStateList2 != null) {
            this.D0.setCollapsedTextColor(colorStateList2);
            this.D0.setExpandedTextColor(this.r0);
        }
        if (!isEnabled) {
            ColorStateList colorStateList3 = this.r0;
            int colorForState = colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.B0) : this.B0;
            this.D0.setCollapsedTextColor(ColorStateList.valueOf(colorForState));
            this.D0.setExpandedTextColor(ColorStateList.valueOf(colorForState));
        } else if (e2) {
            CollapsingTextHelper collapsingTextHelper = this.D0;
            TextView textView2 = this.g.l;
            collapsingTextHelper.setCollapsedTextColor(textView2 != null ? textView2.getTextColors() : null);
        } else if (this.j && (textView = this.k) != null) {
            this.D0.setCollapsedTextColor(textView.getTextColors());
        } else if (z5 && (colorStateList = this.s0) != null) {
            this.D0.setCollapsedTextColor(colorStateList);
        }
        if (z4 || !this.E0 || (isEnabled() && z5)) {
            if (z3 || this.C0) {
                ValueAnimator valueAnimator = this.G0;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.G0.cancel();
                }
                if (!z2 || !this.F0) {
                    this.D0.setExpansionFraction(1.0f);
                } else {
                    a(1.0f);
                }
                this.C0 = false;
                if (f()) {
                    k();
                }
                EditText editText3 = this.e;
                if (editText3 != null) {
                    i2 = editText3.getText().length();
                }
                w(i2);
                y();
                B();
            }
        } else if (z3 || !this.C0) {
            ValueAnimator valueAnimator2 = this.G0;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.G0.cancel();
            }
            if (!z2 || !this.F0) {
                this.D0.setExpansionFraction(0.0f);
            } else {
                a(0.0f);
            }
            if (f() && (!((g) this.B).z.isEmpty()) && f()) {
                ((g) this.B).j(0.0f, 0.0f, 0.0f, 0.0f);
            }
            this.C0 = true;
            TextView textView3 = this.p;
            if (textView3 != null && this.o) {
                textView3.setText((CharSequence) null);
                this.p.setVisibility(4);
            }
            y();
            B();
        }
    }

    public final void w(int i2) {
        if (i2 != 0 || this.C0) {
            TextView textView = this.p;
            if (textView != null && this.o) {
                textView.setText((CharSequence) null);
                this.p.setVisibility(4);
                return;
            }
            return;
        }
        TextView textView2 = this.p;
        if (textView2 != null && this.o) {
            textView2.setText(this.n);
            this.p.setVisibility(0);
            this.p.bringToFront();
        }
    }

    public final void x() {
        if (this.e != null) {
            ViewCompat.setPaddingRelative(this.v, isStartIconVisible() ? 0 : ViewCompat.getPaddingStart(this.e), this.e.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), this.e.getCompoundPaddingBottom());
        }
    }

    public final void y() {
        this.v.setVisibility((this.u == null || this.C0) ? 8 : 0);
        s();
    }

    public final void z(boolean z2, boolean z3) {
        int defaultColor = this.w0.getDefaultColor();
        int colorForState = this.w0.getColorForState(new int[]{16843623, 16842910}, defaultColor);
        int colorForState2 = this.w0.getColorForState(new int[]{16843518, 16842910}, defaultColor);
        if (z2) {
            this.K = colorForState2;
        } else if (z3) {
            this.K = colorForState;
        } else {
            this.K = defaultColor;
        }
    }

    public TextInputLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textInputStyle);
    }

    public void setEndIconContentDescription(@Nullable CharSequence charSequence) {
        if (getEndIconContentDescription() != charSequence) {
            this.e0.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(@Nullable Drawable drawable) {
        this.e0.setImageDrawable(drawable);
        refreshEndIconDrawableState();
    }

    public void setStartIconContentDescription(@Nullable CharSequence charSequence) {
        if (getStartIconContentDescription() != charSequence) {
            this.Q.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(@Nullable Drawable drawable) {
        this.Q.setImageDrawable(drawable);
        if (drawable != null) {
            setStartIconVisible(true);
            refreshStartIconDrawableState();
            return;
        }
        setStartIconVisible(false);
        setStartIconOnClickListener(null);
        setStartIconOnLongClickListener(null);
        setStartIconContentDescription((CharSequence) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TextInputLayout(@androidx.annotation.NonNull android.content.Context r24, @androidx.annotation.Nullable android.util.AttributeSet r25, int r26) {
        /*
        // Method dump skipped, instructions count: 1538
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setErrorIconDrawable(@Nullable Drawable drawable) {
        this.p0.setImageDrawable(drawable);
        setErrorIconVisible(drawable != null && this.g.k);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@Nullable CharSequence charSequence) {
        this.e0.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@Nullable Drawable drawable) {
        this.e0.setImageDrawable(drawable);
    }

    public void setHint(@StringRes int i2) {
        setHint(i2 != 0 ? getResources().getText(i2) : null);
    }
}

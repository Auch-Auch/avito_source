package a2.j.b.d.p;

import a2.j.b.d.p.a;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.SeekBar;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewOverlayImpl;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.slider.BaseOnChangeListener;
import com.google.android.material.slider.BaseOnSliderTouchListener;
import com.google.android.material.slider.LabelFormatter;
import com.google.android.material.tooltip.TooltipDrawable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
public abstract class a<S extends a<S, L, T>, L extends BaseOnChangeListener<S>, T extends BaseOnSliderTouchListener<S>> extends View {
    public static final String b0 = a.class.getSimpleName();
    public static final int c0 = R.style.Widget_MaterialComponents_Slider;
    public int A;
    public float B;
    public MotionEvent C;
    public LabelFormatter D;
    public boolean E;
    public float F;
    public float G;
    public ArrayList<Float> H;
    public int I;
    public int J;
    public float K;
    public float[] L;
    public boolean M;
    public int N;
    public boolean O;
    public boolean P;
    @NonNull
    public ColorStateList Q;
    @NonNull
    public ColorStateList R;
    @NonNull
    public ColorStateList S;
    @NonNull
    public ColorStateList T;
    @NonNull
    public ColorStateList U;
    @NonNull
    public final MaterialShapeDrawable V;
    public float W;
    @NonNull
    public final Paint a;
    public int a0;
    @NonNull
    public final Paint b;
    @NonNull
    public final Paint c;
    @NonNull
    public final Paint d;
    @NonNull
    public final Paint e;
    @NonNull
    public final Paint f;
    @NonNull
    public final e g;
    public final AccessibilityManager h;
    public a<S, L, T>.d i;
    @NonNull
    public final g j;
    @NonNull
    public final List<TooltipDrawable> k;
    @NonNull
    public final List<L> l;
    @NonNull
    public final List<T> m;
    public boolean n;
    public ValueAnimator o;
    public ValueAnimator p;
    public final int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    /* renamed from: a2.j.b.d.p.a$a  reason: collision with other inner class name */
    public class C0044a implements g {
        public final /* synthetic */ AttributeSet a;
        public final /* synthetic */ int b;

        public C0044a(AttributeSet attributeSet, int i) {
            this.a = attributeSet;
            this.b = i;
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            for (TooltipDrawable tooltipDrawable : a.this.k) {
                tooltipDrawable.setRevealFraction(floatValue);
            }
            ViewCompat.postInvalidateOnAnimation(a.this);
        }
    }

    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            for (TooltipDrawable tooltipDrawable : a.this.k) {
                ViewUtils.getContentViewOverlay(a.this).remove(tooltipDrawable);
            }
        }
    }

    public class d implements Runnable {
        public int a = -1;

        public d(C0044a aVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.g.sendEventForVirtualView(this.a, 4);
        }
    }

    public static class e extends ExploreByTouchHelper {
        public final a<?, ?, ?> q;
        public Rect r = new Rect();

        public e(a<?, ?, ?> aVar) {
            super(aVar);
            this.q = aVar;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public int getVirtualViewAt(float f, float f2) {
            for (int i = 0; i < this.q.getValues().size(); i++) {
                this.q.s(i, this.r);
                if (this.r.contains((int) f, (int) f2)) {
                    return i;
                }
            }
            return -1;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void getVisibleVirtualViews(List<Integer> list) {
            for (int i = 0; i < this.q.getValues().size(); i++) {
                list.add(Integer.valueOf(i));
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle) {
            if (!this.q.isEnabled()) {
                return false;
            }
            if (i2 == 4096 || i2 == 8192) {
                float a = this.q.a(20);
                if (i2 == 8192) {
                    a = -a;
                }
                if (this.q.i()) {
                    a = -a;
                }
                if (!this.q.q(i, MathUtils.clamp(this.q.getValues().get(i).floatValue() + a, this.q.getValueFrom(), this.q.getValueTo()))) {
                    return false;
                }
                this.q.t();
                this.q.postInvalidate();
                invalidateVirtualView(i);
                return true;
            }
            if (i2 == 16908349 && bundle != null && bundle.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE)) {
                if (this.q.q(i, bundle.getFloat(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE))) {
                    this.q.t();
                    this.q.postInvalidate();
                    invalidateVirtualView(i);
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void onPopulateNodeForVirtualView(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            String str;
            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SET_PROGRESS);
            List<Float> values = this.q.getValues();
            float floatValue = values.get(i).floatValue();
            float valueFrom = this.q.getValueFrom();
            float valueTo = this.q.getValueTo();
            if (this.q.isEnabled()) {
                if (floatValue > valueFrom) {
                    accessibilityNodeInfoCompat.addAction(8192);
                }
                if (floatValue < valueTo) {
                    accessibilityNodeInfoCompat.addAction(4096);
                }
            }
            accessibilityNodeInfoCompat.setRangeInfo(AccessibilityNodeInfoCompat.RangeInfoCompat.obtain(1, valueFrom, valueTo, floatValue));
            accessibilityNodeInfoCompat.setClassName(SeekBar.class.getName());
            StringBuilder sb = new StringBuilder();
            if (this.q.getContentDescription() != null) {
                sb.append(this.q.getContentDescription());
                sb.append(",");
            }
            if (values.size() > 1) {
                if (i == this.q.getValues().size() - 1) {
                    str = this.q.getContext().getString(R.string.material_slider_range_end);
                } else {
                    str = i == 0 ? this.q.getContext().getString(R.string.material_slider_range_start) : "";
                }
                sb.append(str);
                sb.append(this.q.f(floatValue));
            }
            accessibilityNodeInfoCompat.setContentDescription(sb.toString());
            this.q.s(i, this.r);
            accessibilityNodeInfoCompat.setBoundsInParent(this.r);
        }
    }

    public static class f extends View.BaseSavedState {
        public static final Parcelable.Creator<f> CREATOR = new C0045a();
        public float a;
        public float b;
        public ArrayList<Float> c;
        public float d;
        public boolean e;

        /* renamed from: a2.j.b.d.p.a$f$a  reason: collision with other inner class name */
        public static class C0045a implements Parcelable.Creator<f> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            @NonNull
            public f createFromParcel(@NonNull Parcel parcel) {
                return new f(parcel, null);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            @NonNull
            public f[] newArray(int i) {
                return new f[i];
            }
        }

        public f(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.os.Parcelable, android.view.AbsSavedState
        public void writeToParcel(@NonNull Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeFloat(this.a);
            parcel.writeFloat(this.b);
            parcel.writeList(this.c);
            parcel.writeFloat(this.d);
            parcel.writeBooleanArray(new boolean[]{this.e});
        }

        public f(Parcel parcel, C0044a aVar) {
            super(parcel);
            this.a = parcel.readFloat();
            this.b = parcel.readFloat();
            ArrayList<Float> arrayList = new ArrayList<>();
            this.c = arrayList;
            parcel.readList(arrayList, Float.class.getClassLoader());
            this.d = parcel.readFloat();
            this.e = parcel.createBooleanArray()[0];
        }
    }

    public interface g {
    }

    public a(@NonNull Context context) {
        this(context, null);
    }

    private float[] getActiveRange() {
        float floatValue = ((Float) Collections.max(getValues())).floatValue();
        float floatValue2 = ((Float) Collections.min(getValues())).floatValue();
        if (this.H.size() == 1) {
            floatValue2 = this.F;
        }
        float m2 = m(floatValue2);
        float m3 = m(floatValue);
        return i() ? new float[]{m3, m2} : new float[]{m2, m3};
    }

    private float getValueOfTouchPosition() {
        double d2;
        float f2 = this.W;
        float f3 = this.K;
        if (f3 > 0.0f) {
            int i2 = (int) ((this.G - this.F) / f3);
            d2 = ((double) Math.round(f2 * ((float) i2))) / ((double) i2);
        } else {
            d2 = (double) f2;
        }
        if (i()) {
            d2 = 1.0d - d2;
        }
        float f4 = this.G;
        float f5 = this.F;
        return (float) ((d2 * ((double) (f4 - f5))) + ((double) f5));
    }

    private float getValueOfTouchPositionAbsolute() {
        float f2 = this.W;
        if (i()) {
            f2 = 1.0f - f2;
        }
        float f3 = this.G;
        float f4 = this.F;
        return a2.b.a.a.a.b(f3, f4, f2, f4);
    }

    private void setValuesInternal(@NonNull ArrayList<Float> arrayList) {
        ViewOverlayImpl contentViewOverlay;
        if (!arrayList.isEmpty()) {
            Collections.sort(arrayList);
            if (this.H.size() != arrayList.size() || !this.H.equals(arrayList)) {
                this.H = arrayList;
                int i2 = 1;
                this.P = true;
                this.J = 0;
                t();
                if (this.k.size() > this.H.size()) {
                    List<TooltipDrawable> subList = this.k.subList(this.H.size(), this.k.size());
                    for (TooltipDrawable tooltipDrawable : subList) {
                        if (ViewCompat.isAttachedToWindow(this) && (contentViewOverlay = ViewUtils.getContentViewOverlay(this)) != null) {
                            contentViewOverlay.remove(tooltipDrawable);
                            tooltipDrawable.detachView(ViewUtils.getContentView(this));
                        }
                    }
                    subList.clear();
                }
                while (this.k.size() < this.H.size()) {
                    C0044a aVar = (C0044a) this.j;
                    TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(a.this.getContext(), aVar.a, R.styleable.Slider, aVar.b, c0, new int[0]);
                    TooltipDrawable createFromAttributes = TooltipDrawable.createFromAttributes(a.this.getContext(), null, 0, obtainStyledAttributes.getResourceId(R.styleable.Slider_labelStyle, R.style.Widget_MaterialComponents_Tooltip));
                    obtainStyledAttributes.recycle();
                    this.k.add(createFromAttributes);
                    if (ViewCompat.isAttachedToWindow(this)) {
                        createFromAttributes.setRelativeToView(ViewUtils.getContentView(this));
                    }
                }
                if (this.k.size() == 1) {
                    i2 = 0;
                }
                for (TooltipDrawable tooltipDrawable2 : this.k) {
                    tooltipDrawable2.setStrokeWidth((float) i2);
                }
                d();
                postInvalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("At least one value must be set");
    }

    public final float a(int i2) {
        float f2 = this.K;
        if (f2 == 0.0f) {
            f2 = 1.0f;
        }
        float f3 = (this.G - this.F) / f2;
        float f4 = (float) i2;
        if (f3 <= f4) {
            return f2;
        }
        return ((float) Math.round(f3 / f4)) * f2;
    }

    public void addOnChangeListener(@Nullable L l2) {
        this.l.add(l2);
    }

    public void addOnSliderTouchListener(@NonNull T t2) {
        this.m.add(t2);
    }

    public final int b() {
        int i2 = this.x;
        int i3 = 0;
        if (this.u == 1) {
            i3 = this.k.get(0).getIntrinsicHeight();
        }
        return i2 + i3;
    }

    public final ValueAnimator c(boolean z2) {
        float f2 = 0.0f;
        float f3 = z2 ? 0.0f : 1.0f;
        ValueAnimator valueAnimator = z2 ? this.p : this.o;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            f3 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            valueAnimator.cancel();
        }
        if (z2) {
            f2 = 1.0f;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f3, f2);
        ofFloat.setDuration(z2 ? 83 : 117);
        ofFloat.setInterpolator(z2 ? AnimationUtils.DECELERATE_INTERPOLATOR : AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR);
        ofFloat.addUpdateListener(new b());
        return ofFloat;
    }

    public void clearOnChangeListeners() {
        this.l.clear();
    }

    public void clearOnSliderTouchListeners() {
        this.m.clear();
    }

    public final void d() {
        for (L l2 : this.l) {
            Iterator<Float> it = this.H.iterator();
            while (it.hasNext()) {
                l2.onValueChange(this, it.next().floatValue(), false);
            }
        }
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(@NonNull MotionEvent motionEvent) {
        return this.g.dispatchHoverEvent(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.a.setColor(g(this.U));
        this.b.setColor(g(this.T));
        this.e.setColor(g(this.S));
        this.f.setColor(g(this.R));
        for (TooltipDrawable tooltipDrawable : this.k) {
            if (tooltipDrawable.isStateful()) {
                tooltipDrawable.setState(getDrawableState());
            }
        }
        if (this.V.isStateful()) {
            this.V.setState(getDrawableState());
        }
        this.d.setColor(g(this.Q));
        this.d.setAlpha(63);
    }

    public final void e() {
        if (this.n) {
            this.n = false;
            ValueAnimator c2 = c(false);
            this.p = c2;
            this.o = null;
            c2.addListener(new c());
            this.p.start();
        }
    }

    public final String f(float f2) {
        if (hasLabelFormatter()) {
            return this.D.getFormattedValue(f2);
        }
        return String.format(((float) ((int) f2)) == f2 ? "%.0f" : "%.2f", Float.valueOf(f2));
    }

    @ColorInt
    public final int g(@NonNull ColorStateList colorStateList) {
        return colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
    }

    @Override // android.view.View
    @NonNull
    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    @VisibleForTesting
    public final int getAccessibilityFocusedVirtualViewId() {
        return this.g.getAccessibilityFocusedVirtualViewId();
    }

    public int getActiveThumbIndex() {
        return this.I;
    }

    public int getFocusedThumbIndex() {
        return this.J;
    }

    @Dimension
    public int getHaloRadius() {
        return this.z;
    }

    @NonNull
    public ColorStateList getHaloTintList() {
        return this.Q;
    }

    public int getLabelBehavior() {
        return this.u;
    }

    public float getMinSeparation() {
        return 0.0f;
    }

    public float getStepSize() {
        return this.K;
    }

    public float getThumbElevation() {
        return this.V.getElevation();
    }

    @Dimension
    public int getThumbRadius() {
        return this.y;
    }

    public ColorStateList getThumbStrokeColor() {
        return this.V.getStrokeColor();
    }

    public float getThumbStrokeWidth() {
        return this.V.getStrokeWidth();
    }

    @NonNull
    public ColorStateList getThumbTintList() {
        return this.V.getFillColor();
    }

    @NonNull
    public ColorStateList getTickActiveTintList() {
        return this.R;
    }

    @NonNull
    public ColorStateList getTickInactiveTintList() {
        return this.S;
    }

    @NonNull
    public ColorStateList getTickTintList() {
        if (this.S.equals(this.R)) {
            return this.R;
        }
        throw new IllegalStateException("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
    }

    @NonNull
    public ColorStateList getTrackActiveTintList() {
        return this.T;
    }

    @Dimension
    public int getTrackHeight() {
        return this.v;
    }

    @NonNull
    public ColorStateList getTrackInactiveTintList() {
        return this.U;
    }

    @Dimension
    public int getTrackSidePadding() {
        return this.w;
    }

    @NonNull
    public ColorStateList getTrackTintList() {
        if (this.U.equals(this.T)) {
            return this.T;
        }
        throw new IllegalStateException("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
    }

    @Dimension
    public int getTrackWidth() {
        return this.N;
    }

    public float getValueFrom() {
        return this.F;
    }

    public float getValueTo() {
        return this.G;
    }

    @NonNull
    public List<Float> getValues() {
        return new ArrayList(this.H);
    }

    public final boolean h() {
        ViewParent parent = getParent();
        while (true) {
            boolean z2 = false;
            if (!(parent instanceof ViewGroup)) {
                return false;
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            if (viewGroup.canScrollVertically(1) || viewGroup.canScrollVertically(-1)) {
                z2 = true;
            }
            if (z2 && viewGroup.shouldDelayChildPressedState()) {
                return true;
            }
            parent = parent.getParent();
        }
    }

    public boolean hasLabelFormatter() {
        return this.D != null;
    }

    public final boolean i() {
        return ViewCompat.getLayoutDirection(this) == 1;
    }

    public boolean isTickVisible() {
        return this.M;
    }

    public final void j() {
        if (this.K > 0.0f) {
            u();
            int min = Math.min((int) (((this.G - this.F) / this.K) + 1.0f), (this.N / (this.v * 2)) + 1);
            float[] fArr = this.L;
            if (fArr == null || fArr.length != min * 2) {
                this.L = new float[(min * 2)];
            }
            float f2 = ((float) this.N) / ((float) (min - 1));
            for (int i2 = 0; i2 < min * 2; i2 += 2) {
                float[] fArr2 = this.L;
                fArr2[i2] = (((float) (i2 / 2)) * f2) + ((float) this.w);
                fArr2[i2 + 1] = (float) b();
            }
        }
    }

    public final boolean k(int i2) {
        int i3 = this.J;
        int clamp = (int) MathUtils.clamp(((long) i3) + ((long) i2), 0L, (long) (this.H.size() - 1));
        this.J = clamp;
        if (clamp == i3) {
            return false;
        }
        if (this.I != -1) {
            this.I = clamp;
        }
        t();
        postInvalidate();
        return true;
    }

    public final boolean l(int i2) {
        if (i()) {
            i2 = i2 == Integer.MIN_VALUE ? Integer.MAX_VALUE : -i2;
        }
        return k(i2);
    }

    public final float m(float f2) {
        float f3 = this.F;
        float f4 = (f2 - f3) / (this.G - f3);
        return i() ? 1.0f - f4 : f4;
    }

    public final void n() {
        for (T t2 : this.m) {
            t2.onStartTrackingTouch(this);
        }
    }

    public final void o(TooltipDrawable tooltipDrawable, float f2) {
        tooltipDrawable.setText(f(f2));
        int m2 = (this.w + ((int) (m(f2) * ((float) this.N)))) - (tooltipDrawable.getIntrinsicWidth() / 2);
        int b2 = b() - (this.A + this.y);
        tooltipDrawable.setBounds(m2, b2 - tooltipDrawable.getIntrinsicHeight(), tooltipDrawable.getIntrinsicWidth() + m2, b2);
        Rect rect = new Rect(tooltipDrawable.getBounds());
        DescendantOffsetUtils.offsetDescendantRect(ViewUtils.getContentView(this), this, rect);
        tooltipDrawable.setBounds(rect);
        ViewUtils.getContentViewOverlay(this).add(tooltipDrawable);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        for (TooltipDrawable tooltipDrawable : this.k) {
            tooltipDrawable.setRelativeToView(ViewUtils.getContentView(this));
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        a<S, L, T>.d dVar = this.i;
        if (dVar != null) {
            removeCallbacks(dVar);
        }
        this.n = false;
        for (TooltipDrawable tooltipDrawable : this.k) {
            ViewOverlayImpl contentViewOverlay = ViewUtils.getContentViewOverlay(this);
            if (contentViewOverlay != null) {
                contentViewOverlay.remove(tooltipDrawable);
                tooltipDrawable.detachView(ViewUtils.getContentView(this));
            }
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(@NonNull Canvas canvas) {
        if (this.P) {
            u();
            j();
        }
        super.onDraw(canvas);
        int b2 = b();
        int i2 = this.N;
        float[] activeRange = getActiveRange();
        int i3 = this.w;
        float f2 = (float) i2;
        float f3 = (activeRange[1] * f2) + ((float) i3);
        float f4 = (float) (i3 + i2);
        if (f3 < f4) {
            float f5 = (float) b2;
            canvas.drawLine(f3, f5, f4, f5, this.a);
        }
        float f6 = (float) this.w;
        float f7 = (activeRange[0] * f2) + f6;
        if (f7 > f6) {
            float f8 = (float) b2;
            canvas.drawLine(f6, f8, f7, f8, this.a);
        }
        if (((Float) Collections.max(getValues())).floatValue() > this.F) {
            int i4 = this.N;
            float[] activeRange2 = getActiveRange();
            float f9 = (float) this.w;
            float f10 = (float) i4;
            float f11 = (float) b2;
            canvas.drawLine((activeRange2[0] * f10) + f9, f11, (activeRange2[1] * f10) + f9, f11, this.b);
        }
        if (this.M && this.K > 0.0f) {
            float[] activeRange3 = getActiveRange();
            int round = Math.round(activeRange3[0] * ((float) ((this.L.length / 2) - 1)));
            int round2 = Math.round(activeRange3[1] * ((float) ((this.L.length / 2) - 1)));
            int i5 = round * 2;
            canvas.drawPoints(this.L, 0, i5, this.e);
            int i6 = round2 * 2;
            canvas.drawPoints(this.L, i5, i6 - i5, this.f);
            float[] fArr = this.L;
            canvas.drawPoints(fArr, i6, fArr.length - i6, this.e);
        }
        if ((this.E || isFocused()) && isEnabled()) {
            int i7 = this.N;
            if (p()) {
                int m2 = (int) ((m(this.H.get(this.J).floatValue()) * ((float) i7)) + ((float) this.w));
                if (Build.VERSION.SDK_INT < 28) {
                    int i8 = this.z;
                    canvas.clipRect((float) (m2 - i8), (float) (b2 - i8), (float) (m2 + i8), (float) (i8 + b2), Region.Op.UNION);
                }
                canvas.drawCircle((float) m2, (float) b2, (float) this.z, this.d);
            }
            if (!(this.I == -1 || this.u == 2)) {
                if (!this.n) {
                    this.n = true;
                    ValueAnimator c2 = c(true);
                    this.o = c2;
                    this.p = null;
                    c2.start();
                }
                Iterator<TooltipDrawable> it = this.k.iterator();
                for (int i9 = 0; i9 < this.H.size() && it.hasNext(); i9++) {
                    if (i9 != this.J) {
                        o(it.next(), this.H.get(i9).floatValue());
                    }
                }
                if (it.hasNext()) {
                    o(it.next(), this.H.get(this.J).floatValue());
                } else {
                    throw new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", Integer.valueOf(this.k.size()), Integer.valueOf(this.H.size())));
                }
            }
        }
        int i10 = this.N;
        if (!isEnabled()) {
            Iterator<Float> it2 = this.H.iterator();
            while (it2.hasNext()) {
                canvas.drawCircle((m(it2.next().floatValue()) * ((float) i10)) + ((float) this.w), (float) b2, (float) this.y, this.c);
            }
        }
        Iterator<Float> it3 = this.H.iterator();
        while (it3.hasNext()) {
            canvas.save();
            int m3 = this.w + ((int) (m(it3.next().floatValue()) * ((float) i10)));
            int i11 = this.y;
            canvas.translate((float) (m3 - i11), (float) (b2 - i11));
            this.V.draw(canvas);
            canvas.restore();
        }
    }

    @Override // android.view.View
    public void onFocusChanged(boolean z2, int i2, @Nullable Rect rect) {
        super.onFocusChanged(z2, i2, rect);
        if (!z2) {
            this.I = -1;
            e();
            this.g.clearKeyboardFocusForVirtualView(this.J);
            return;
        }
        if (i2 == 1) {
            k(Integer.MAX_VALUE);
        } else if (i2 == 2) {
            k(Integer.MIN_VALUE);
        } else if (i2 == 17) {
            l(Integer.MAX_VALUE);
        } else if (i2 == 66) {
            l(Integer.MIN_VALUE);
        }
        this.g.requestKeyboardFocusForVirtualView(this.J);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, @NonNull KeyEvent keyEvent) {
        float f2;
        if (!isEnabled()) {
            return super.onKeyDown(i2, keyEvent);
        }
        if (this.H.size() == 1) {
            this.I = 0;
        }
        Float f3 = null;
        Boolean bool = null;
        if (this.I == -1) {
            if (i2 != 61) {
                if (i2 != 66) {
                    if (i2 != 81) {
                        if (i2 != 69) {
                            if (i2 != 70) {
                                switch (i2) {
                                    case 21:
                                        l(-1);
                                        bool = Boolean.TRUE;
                                        break;
                                    case 22:
                                        l(1);
                                        bool = Boolean.TRUE;
                                        break;
                                }
                            }
                        } else {
                            k(-1);
                            bool = Boolean.TRUE;
                        }
                    }
                    k(1);
                    bool = Boolean.TRUE;
                }
                this.I = this.J;
                postInvalidate();
                bool = Boolean.TRUE;
            } else if (keyEvent.hasNoModifiers()) {
                bool = Boolean.valueOf(k(1));
            } else if (keyEvent.isShiftPressed()) {
                bool = Boolean.valueOf(k(-1));
            } else {
                bool = Boolean.FALSE;
            }
            return bool != null ? bool.booleanValue() : super.onKeyDown(i2, keyEvent);
        }
        boolean isLongPress = this.O | keyEvent.isLongPress();
        this.O = isLongPress;
        if (isLongPress) {
            f2 = a(20);
        } else {
            f2 = this.K;
            if (f2 == 0.0f) {
                f2 = 1.0f;
            }
        }
        if (i2 == 21) {
            if (!i()) {
                f2 = -f2;
            }
            f3 = Float.valueOf(f2);
        } else if (i2 == 22) {
            if (i()) {
                f2 = -f2;
            }
            f3 = Float.valueOf(f2);
        } else if (i2 == 69) {
            f3 = Float.valueOf(-f2);
        } else if (i2 == 70 || i2 == 81) {
            f3 = Float.valueOf(f2);
        }
        if (f3 != null) {
            if (q(this.I, f3.floatValue() + this.H.get(this.I).floatValue())) {
                t();
                postInvalidate();
            }
            return true;
        }
        if (i2 != 23) {
            if (i2 != 61) {
                if (i2 != 66) {
                    return super.onKeyDown(i2, keyEvent);
                }
            } else if (keyEvent.hasNoModifiers()) {
                return k(1);
            } else {
                if (keyEvent.isShiftPressed()) {
                    return k(-1);
                }
                return false;
            }
        }
        this.I = -1;
        e();
        postInvalidate();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, @NonNull KeyEvent keyEvent) {
        this.O = false;
        return super.onKeyUp(i2, keyEvent);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int i4 = this.t;
        int i5 = 0;
        if (this.u == 1) {
            i5 = this.k.get(0).getIntrinsicHeight();
        }
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(i4 + i5, 1073741824));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        f fVar = (f) parcelable;
        super.onRestoreInstanceState(fVar.getSuperState());
        this.F = fVar.a;
        this.G = fVar.b;
        setValuesInternal(fVar.c);
        this.K = fVar.d;
        if (fVar.e) {
            requestFocus();
        }
        d();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        f fVar = new f(super.onSaveInstanceState());
        fVar.a = this.F;
        fVar.b = this.G;
        fVar.c = new ArrayList<>(this.H);
        fVar.d = this.K;
        fVar.e = hasFocus();
        return fVar;
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.N = Math.max(i2 - (this.w * 2), 0);
        j();
        t();
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        float x2 = motionEvent.getX();
        float f2 = (x2 - ((float) this.w)) / ((float) this.N);
        this.W = f2;
        float max = Math.max(0.0f, f2);
        this.W = max;
        this.W = Math.min(1.0f, max);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.B = x2;
            if (!h()) {
                getParent().requestDisallowInterceptTouchEvent(true);
                if (pickActiveThumb()) {
                    requestFocus();
                    this.E = true;
                    r();
                    t();
                    invalidate();
                    n();
                }
            }
        } else if (actionMasked == 1) {
            this.E = false;
            MotionEvent motionEvent2 = this.C;
            if (motionEvent2 != null && motionEvent2.getActionMasked() == 0 && Math.abs(this.C.getX() - motionEvent.getX()) <= ((float) this.q) && Math.abs(this.C.getY() - motionEvent.getY()) <= ((float) this.q) && pickActiveThumb()) {
                n();
            }
            if (this.I != -1) {
                r();
                this.I = -1;
                for (T t2 : this.m) {
                    t2.onStopTrackingTouch(this);
                }
            }
            e();
            invalidate();
        } else if (actionMasked == 2) {
            if (!this.E) {
                if (h() && Math.abs(x2 - this.B) < ((float) this.q)) {
                    return false;
                }
                getParent().requestDisallowInterceptTouchEvent(true);
                n();
            }
            if (pickActiveThumb()) {
                this.E = true;
                r();
                t();
                invalidate();
            }
        }
        setPressed(this.E);
        this.C = MotionEvent.obtain(motionEvent);
        return true;
    }

    public final boolean p() {
        return !(getBackground() instanceof RippleDrawable);
    }

    public boolean pickActiveThumb() {
        if (this.I != -1) {
            return true;
        }
        float valueOfTouchPositionAbsolute = getValueOfTouchPositionAbsolute();
        float m2 = (m(valueOfTouchPositionAbsolute) * ((float) this.N)) + ((float) this.w);
        this.I = 0;
        float abs = Math.abs(this.H.get(0).floatValue() - valueOfTouchPositionAbsolute);
        for (int i2 = 1; i2 < this.H.size(); i2++) {
            float abs2 = Math.abs(this.H.get(i2).floatValue() - valueOfTouchPositionAbsolute);
            float m3 = (m(this.H.get(i2).floatValue()) * ((float) this.N)) + ((float) this.w);
            if (Float.compare(abs2, abs) > 1) {
                break;
            }
            boolean z2 = !i() ? m3 - m2 < 0.0f : m3 - m2 > 0.0f;
            if (Float.compare(abs2, abs) < 0) {
                this.I = i2;
            } else {
                if (Float.compare(abs2, abs) != 0) {
                    continue;
                } else if (Math.abs(m3 - m2) < ((float) this.q)) {
                    this.I = -1;
                    return false;
                } else if (z2) {
                    this.I = i2;
                }
            }
            abs = abs2;
        }
        if (this.I != -1) {
            return true;
        }
        return false;
    }

    public final boolean q(int i2, float f2) {
        if (((double) Math.abs(f2 - this.H.get(i2).floatValue())) < 1.0E-4d) {
            return false;
        }
        float f3 = 0.0f;
        float minSeparation = this.K == 0.0f ? getMinSeparation() : 0.0f;
        if (this.a0 == 0) {
            if (minSeparation != 0.0f) {
                float f4 = (minSeparation - ((float) this.w)) / ((float) this.N);
                float f5 = this.F;
                f3 = a2.b.a.a.a.b(f5, this.G, f4, f5);
            }
            minSeparation = f3;
        }
        if (i()) {
            minSeparation = -minSeparation;
        }
        int i3 = i2 + 1;
        int i4 = i2 - 1;
        this.H.set(i2, Float.valueOf(MathUtils.clamp(f2, i4 < 0 ? this.F : minSeparation + this.H.get(i4).floatValue(), i3 >= this.H.size() ? this.G : this.H.get(i3).floatValue() - minSeparation)));
        this.J = i2;
        for (L l2 : this.l) {
            l2.onValueChange(this, this.H.get(i2).floatValue(), true);
        }
        AccessibilityManager accessibilityManager = this.h;
        if (accessibilityManager != null && accessibilityManager.isEnabled()) {
            a<S, L, T>.d dVar = this.i;
            if (dVar == null) {
                this.i = new d(null);
            } else {
                removeCallbacks(dVar);
            }
            a<S, L, T>.d dVar2 = this.i;
            dVar2.a = i2;
            postDelayed(dVar2, 200);
        }
        return true;
    }

    public final boolean r() {
        return q(this.I, getValueOfTouchPosition());
    }

    public void removeOnChangeListener(@NonNull L l2) {
        this.l.remove(l2);
    }

    public void removeOnSliderTouchListener(@NonNull T t2) {
        this.m.remove(t2);
    }

    public void s(int i2, Rect rect) {
        int m2 = this.w + ((int) (m(getValues().get(i2).floatValue()) * ((float) this.N)));
        int b2 = b();
        int i3 = this.y;
        rect.set(m2 - i3, b2 - i3, m2 + i3, b2 + i3);
    }

    public void setActiveThumbIndex(int i2) {
        this.I = i2;
    }

    @Override // android.view.View
    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        setLayerType(z2 ? 0 : 2, null);
    }

    public void setFocusedThumbIndex(int i2) {
        if (i2 < 0 || i2 >= this.H.size()) {
            throw new IllegalArgumentException("index out of range");
        }
        this.J = i2;
        this.g.requestKeyboardFocusForVirtualView(i2);
        postInvalidate();
    }

    public void setHaloRadius(@IntRange(from = 0) @Dimension int i2) {
        if (i2 != this.z) {
            this.z = i2;
            Drawable background = getBackground();
            if (p() || !(background instanceof RippleDrawable)) {
                postInvalidate();
            } else {
                DrawableUtils.setRippleDrawableRadius((RippleDrawable) background, this.z);
            }
        }
    }

    public void setHaloRadiusResource(@DimenRes int i2) {
        setHaloRadius(getResources().getDimensionPixelSize(i2));
    }

    public void setHaloTintList(@NonNull ColorStateList colorStateList) {
        if (!colorStateList.equals(this.Q)) {
            this.Q = colorStateList;
            Drawable background = getBackground();
            if (p() || !(background instanceof RippleDrawable)) {
                this.d.setColor(colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor()));
                this.d.setAlpha(63);
                invalidate();
                return;
            }
            ((RippleDrawable) background).setColor(colorStateList);
        }
    }

    public void setLabelBehavior(int i2) {
        if (this.u != i2) {
            this.u = i2;
            requestLayout();
        }
    }

    public void setLabelFormatter(@Nullable LabelFormatter labelFormatter) {
        this.D = labelFormatter;
    }

    public void setSeparationUnit(int i2) {
        this.a0 = i2;
    }

    public void setStepSize(float f2) {
        if (f2 < 0.0f) {
            throw new IllegalArgumentException(String.format("The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range", Float.toString(f2), Float.toString(this.F), Float.toString(this.G)));
        } else if (this.K != f2) {
            this.K = f2;
            this.P = true;
            postInvalidate();
        }
    }

    public void setThumbElevation(float f2) {
        this.V.setElevation(f2);
    }

    public void setThumbElevationResource(@DimenRes int i2) {
        setThumbElevation(getResources().getDimension(i2));
    }

    public void setThumbRadius(@IntRange(from = 0) @Dimension int i2) {
        if (i2 != this.y) {
            this.y = i2;
            this.w = this.r + Math.max(i2 - this.s, 0);
            if (ViewCompat.isLaidOut(this)) {
                this.N = Math.max(getWidth() - (this.w * 2), 0);
                j();
            }
            this.V.setShapeAppearanceModel(ShapeAppearanceModel.builder().setAllCorners(0, (float) this.y).build());
            MaterialShapeDrawable materialShapeDrawable = this.V;
            int i3 = this.y;
            materialShapeDrawable.setBounds(0, 0, i3 * 2, i3 * 2);
            postInvalidate();
        }
    }

    public void setThumbRadiusResource(@DimenRes int i2) {
        setThumbRadius(getResources().getDimensionPixelSize(i2));
    }

    public void setThumbStrokeColor(@Nullable ColorStateList colorStateList) {
        this.V.setStrokeColor(colorStateList);
        postInvalidate();
    }

    public void setThumbStrokeColorResource(@ColorRes int i2) {
        if (i2 != 0) {
            setThumbStrokeColor(AppCompatResources.getColorStateList(getContext(), i2));
        }
    }

    public void setThumbStrokeWidth(float f2) {
        this.V.setStrokeWidth(f2);
        postInvalidate();
    }

    public void setThumbStrokeWidthResource(@DimenRes int i2) {
        if (i2 != 0) {
            setThumbStrokeWidth(getResources().getDimension(i2));
        }
    }

    public void setThumbTintList(@NonNull ColorStateList colorStateList) {
        if (!colorStateList.equals(this.V.getFillColor())) {
            this.V.setFillColor(colorStateList);
            invalidate();
        }
    }

    public void setTickActiveTintList(@NonNull ColorStateList colorStateList) {
        if (!colorStateList.equals(this.R)) {
            this.R = colorStateList;
            this.f.setColor(g(colorStateList));
            invalidate();
        }
    }

    public void setTickInactiveTintList(@NonNull ColorStateList colorStateList) {
        if (!colorStateList.equals(this.S)) {
            this.S = colorStateList;
            this.e.setColor(g(colorStateList));
            invalidate();
        }
    }

    public void setTickTintList(@NonNull ColorStateList colorStateList) {
        setTickInactiveTintList(colorStateList);
        setTickActiveTintList(colorStateList);
    }

    public void setTickVisible(boolean z2) {
        if (this.M != z2) {
            this.M = z2;
            postInvalidate();
        }
    }

    public void setTrackActiveTintList(@NonNull ColorStateList colorStateList) {
        if (!colorStateList.equals(this.T)) {
            this.T = colorStateList;
            this.b.setColor(g(colorStateList));
            invalidate();
        }
    }

    public void setTrackHeight(@IntRange(from = 0) @Dimension int i2) {
        if (this.v != i2) {
            this.v = i2;
            this.a.setStrokeWidth((float) i2);
            this.b.setStrokeWidth((float) this.v);
            this.e.setStrokeWidth(((float) this.v) / 2.0f);
            this.f.setStrokeWidth(((float) this.v) / 2.0f);
            postInvalidate();
        }
    }

    public void setTrackInactiveTintList(@NonNull ColorStateList colorStateList) {
        if (!colorStateList.equals(this.U)) {
            this.U = colorStateList;
            this.a.setColor(g(colorStateList));
            invalidate();
        }
    }

    public void setTrackTintList(@NonNull ColorStateList colorStateList) {
        setTrackInactiveTintList(colorStateList);
        setTrackActiveTintList(colorStateList);
    }

    public void setValueFrom(float f2) {
        this.F = f2;
        this.P = true;
        postInvalidate();
    }

    public void setValueTo(float f2) {
        this.G = f2;
        this.P = true;
        postInvalidate();
    }

    public void setValues(@NonNull Float... fArr) {
        ArrayList<Float> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, fArr);
        setValuesInternal(arrayList);
    }

    public final void t() {
        if (!p() && getMeasuredWidth() > 0) {
            Drawable background = getBackground();
            if (background instanceof RippleDrawable) {
                int m2 = (int) ((m(this.H.get(this.J).floatValue()) * ((float) this.N)) + ((float) this.w));
                int b2 = b();
                int i2 = this.z;
                DrawableCompat.setHotspotBounds(background, m2 - i2, b2 - i2, m2 + i2, b2 + i2);
            }
        }
    }

    public final void u() {
        if (this.P) {
            float f2 = this.F;
            float f3 = this.G;
            if (f2 >= f3) {
                throw new IllegalStateException(String.format("valueFrom(%s) must be smaller than valueTo(%s)", Float.toString(this.F), Float.toString(this.G)));
            } else if (f3 <= f2) {
                throw new IllegalStateException(String.format("valueTo(%s) must be greater than valueFrom(%s)", Float.toString(this.G), Float.toString(this.F)));
            } else if (this.K <= 0.0f || v(f3)) {
                Iterator<Float> it = this.H.iterator();
                while (it.hasNext()) {
                    Float next = it.next();
                    if (next.floatValue() < this.F || next.floatValue() > this.G) {
                        throw new IllegalStateException(String.format("Slider value(%s) must be greater or equal to valueFrom(%s), and lower or equal to valueTo(%s)", Float.toString(next.floatValue()), Float.toString(this.F), Float.toString(this.G)));
                    } else if (this.K > 0.0f && !v(next.floatValue())) {
                        throw new IllegalStateException(String.format("Value(%s) must be equal to valueFrom(%s) plus a multiple of stepSize(%s) when using stepSize(%s)", Float.toString(next.floatValue()), Float.toString(this.F), Float.toString(this.K), Float.toString(this.K)));
                    }
                }
                float f4 = this.K;
                if (f4 != 0.0f) {
                    if (((float) ((int) f4)) != f4) {
                        String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the  value correctly.", "stepSize", Float.valueOf(f4));
                    }
                    float f5 = this.F;
                    if (((float) ((int) f5)) != f5) {
                        String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the  value correctly.", "valueFrom", Float.valueOf(f5));
                    }
                    float f6 = this.G;
                    if (((float) ((int) f6)) != f6) {
                        String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the  value correctly.", "valueTo", Float.valueOf(f6));
                    }
                }
                this.P = false;
            } else {
                throw new IllegalStateException(String.format("The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range", Float.toString(this.K), Float.toString(this.F), Float.toString(this.G)));
            }
        }
    }

    public final boolean v(float f2) {
        double doubleValue = new BigDecimal(Float.toString(f2)).subtract(new BigDecimal(Float.toString(this.F))).divide(new BigDecimal(Float.toString(this.K)), MathContext.DECIMAL64).doubleValue();
        return Math.abs(((double) Math.round(doubleValue)) - doubleValue) < 1.0E-4d;
    }

    public a(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.sliderStyle);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a(@androidx.annotation.NonNull android.content.Context r11, @androidx.annotation.Nullable android.util.AttributeSet r12, int r13) {
        /*
        // Method dump skipped, instructions count: 533
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.j.b.d.p.a.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setValues(@NonNull List<Float> list) {
        setValuesInternal(new ArrayList<>(list));
    }
}

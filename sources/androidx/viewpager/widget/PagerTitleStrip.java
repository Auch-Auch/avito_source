package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.SingleLineTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.ViewPager;
import java.lang.ref.WeakReference;
import java.util.Locale;
@ViewPager.DecorView
public class PagerTitleStrip extends ViewGroup {
    public static final int[] o = {16842804, 16842901, 16842904, 16842927};
    public static final int[] p = {16843660};
    public ViewPager a;
    public TextView b;
    public TextView c;
    public TextView d;
    public int e;
    public float f;
    public int g;
    public int h;
    public boolean i;
    public boolean j;
    public final a k;
    public WeakReference<PagerAdapter> l;
    public int m;
    public int n;

    public class a extends DataSetObserver implements ViewPager.OnPageChangeListener, ViewPager.OnAdapterChangeListener {
        public int a;

        public a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public void onAdapterChanged(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
            PagerTitleStrip.this.a(pagerAdapter, pagerAdapter2);
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
            pagerTitleStrip.b(pagerTitleStrip.a.getCurrentItem(), PagerTitleStrip.this.a.getAdapter());
            PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
            float f = pagerTitleStrip2.f;
            if (f < 0.0f) {
                f = 0.0f;
            }
            pagerTitleStrip2.c(pagerTitleStrip2.a.getCurrentItem(), f, true);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.a = i;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (f > 0.5f) {
                i++;
            }
            PagerTitleStrip.this.c(i, f, false);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (this.a == 0) {
                PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
                pagerTitleStrip.b(pagerTitleStrip.a.getCurrentItem(), PagerTitleStrip.this.a.getAdapter());
                PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
                float f = pagerTitleStrip2.f;
                if (f < 0.0f) {
                    f = 0.0f;
                }
                pagerTitleStrip2.c(pagerTitleStrip2.a.getCurrentItem(), f, true);
            }
        }
    }

    public static class b extends SingleLineTransformationMethod {
        public Locale a;

        public b(Context context) {
            this.a = context.getResources().getConfiguration().locale;
        }

        @Override // android.text.method.ReplacementTransformationMethod, android.text.method.TransformationMethod
        public CharSequence getTransformation(CharSequence charSequence, View view) {
            CharSequence transformation = super.getTransformation(charSequence, view);
            if (transformation != null) {
                return transformation.toString().toUpperCase(this.a);
            }
            return null;
        }
    }

    public PagerTitleStrip(@NonNull Context context) {
        this(context, null);
    }

    private static void setSingleLineAllCaps(TextView textView) {
        textView.setTransformationMethod(new b(textView.getContext()));
    }

    public void a(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
        if (pagerAdapter != null) {
            pagerAdapter.unregisterDataSetObserver(this.k);
            this.l = null;
        }
        if (pagerAdapter2 != null) {
            pagerAdapter2.registerDataSetObserver(this.k);
            this.l = new WeakReference<>(pagerAdapter2);
        }
        ViewPager viewPager = this.a;
        if (viewPager != null) {
            this.e = -1;
            this.f = -1.0f;
            b(viewPager.getCurrentItem(), pagerAdapter2);
            requestLayout();
        }
    }

    public void b(int i2, PagerAdapter pagerAdapter) {
        int count = pagerAdapter != null ? pagerAdapter.getCount() : 0;
        this.i = true;
        CharSequence charSequence = null;
        this.b.setText((i2 < 1 || pagerAdapter == null) ? null : pagerAdapter.getPageTitle(i2 - 1));
        this.c.setText((pagerAdapter == null || i2 >= count) ? null : pagerAdapter.getPageTitle(i2));
        int i3 = i2 + 1;
        if (i3 < count && pagerAdapter != null) {
            charSequence = pagerAdapter.getPageTitle(i3);
        }
        this.d.setText(charSequence);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((float) ((getWidth() - getPaddingLeft()) - getPaddingRight())) * 0.8f)), Integer.MIN_VALUE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        this.b.measure(makeMeasureSpec, makeMeasureSpec2);
        this.c.measure(makeMeasureSpec, makeMeasureSpec2);
        this.d.measure(makeMeasureSpec, makeMeasureSpec2);
        this.e = i2;
        if (!this.j) {
            c(i2, this.f, false);
        }
        this.i = false;
    }

    public void c(int i2, float f2, boolean z) {
        int i3;
        int i4;
        int i5;
        int i6;
        if (i2 != this.e) {
            b(i2, this.a.getAdapter());
        } else if (!z && f2 == this.f) {
            return;
        }
        this.j = true;
        int measuredWidth = this.b.getMeasuredWidth();
        int measuredWidth2 = this.c.getMeasuredWidth();
        int measuredWidth3 = this.d.getMeasuredWidth();
        int i7 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i8 = paddingRight + i7;
        int i9 = (width - (paddingLeft + i7)) - i8;
        float f3 = 0.5f + f2;
        if (f3 > 1.0f) {
            f3 -= 1.0f;
        }
        int i10 = ((width - i8) - ((int) (((float) i9) * f3))) - i7;
        int i11 = measuredWidth2 + i10;
        int baseline = this.b.getBaseline();
        int baseline2 = this.c.getBaseline();
        int baseline3 = this.d.getBaseline();
        int max = Math.max(Math.max(baseline, baseline2), baseline3);
        int i12 = max - baseline;
        int i13 = max - baseline2;
        int i14 = max - baseline3;
        int max2 = Math.max(Math.max(this.b.getMeasuredHeight() + i12, this.c.getMeasuredHeight() + i13), this.d.getMeasuredHeight() + i14);
        int i15 = this.h & 112;
        if (i15 == 16) {
            i6 = (((height - paddingTop) - paddingBottom) - max2) / 2;
        } else if (i15 != 80) {
            i5 = i12 + paddingTop;
            i3 = i13 + paddingTop;
            i4 = paddingTop + i14;
            TextView textView = this.c;
            textView.layout(i10, i3, i11, textView.getMeasuredHeight() + i3);
            int min = Math.min(paddingLeft, (i10 - this.g) - measuredWidth);
            TextView textView2 = this.b;
            textView2.layout(min, i5, measuredWidth + min, textView2.getMeasuredHeight() + i5);
            int max3 = Math.max((width - paddingRight) - measuredWidth3, i11 + this.g);
            TextView textView3 = this.d;
            textView3.layout(max3, i4, max3 + measuredWidth3, textView3.getMeasuredHeight() + i4);
            this.f = f2;
            this.j = false;
        } else {
            i6 = (height - paddingBottom) - max2;
        }
        i5 = i12 + i6;
        i3 = i13 + i6;
        i4 = i6 + i14;
        TextView textView = this.c;
        textView.layout(i10, i3, i11, textView.getMeasuredHeight() + i3);
        int min = Math.min(paddingLeft, (i10 - this.g) - measuredWidth);
        TextView textView2 = this.b;
        textView2.layout(min, i5, measuredWidth + min, textView2.getMeasuredHeight() + i5);
        int max3 = Math.max((width - paddingRight) - measuredWidth3, i11 + this.g);
        TextView textView3 = this.d;
        textView3.layout(max3, i4, max3 + measuredWidth3, textView3.getMeasuredHeight() + i4);
        this.f = f2;
        this.j = false;
    }

    public int getMinHeight() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return 0;
    }

    public int getTextSpacing() {
        return this.g;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof ViewPager) {
            ViewPager viewPager = (ViewPager) parent;
            PagerAdapter adapter = viewPager.getAdapter();
            a aVar = this.k;
            viewPager.V = aVar;
            viewPager.addOnAdapterChangeListener(aVar);
            this.a = viewPager;
            WeakReference<PagerAdapter> weakReference = this.l;
            a(weakReference != null ? weakReference.get() : null, adapter);
            return;
        }
        throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewPager viewPager = this.a;
        if (viewPager != null) {
            a(viewPager.getAdapter(), null);
            ViewPager viewPager2 = this.a;
            ViewPager.OnPageChangeListener onPageChangeListener = viewPager2.V;
            viewPager2.V = null;
            viewPager2.removeOnAdapterChangeListener(this.k);
            this.a = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (this.a != null) {
            float f2 = this.f;
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            c(this.e, f2, true);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        if (View.MeasureSpec.getMode(i2) == 1073741824) {
            int paddingBottom = getPaddingBottom() + getPaddingTop();
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, paddingBottom, -2);
            int size = View.MeasureSpec.getSize(i2);
            int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i2, (int) (((float) size) * 0.2f), -2);
            this.b.measure(childMeasureSpec2, childMeasureSpec);
            this.c.measure(childMeasureSpec2, childMeasureSpec);
            this.d.measure(childMeasureSpec2, childMeasureSpec);
            if (View.MeasureSpec.getMode(i3) == 1073741824) {
                i4 = View.MeasureSpec.getSize(i3);
            } else {
                i4 = Math.max(getMinHeight(), this.c.getMeasuredHeight() + paddingBottom);
            }
            setMeasuredDimension(size, View.resolveSizeAndState(i4, i3, this.c.getMeasuredState() << 16));
            return;
        }
        throw new IllegalStateException("Must measure with an exact width");
    }

    @Override // android.view.ViewParent, android.view.View
    public void requestLayout() {
        if (!this.i) {
            super.requestLayout();
        }
    }

    public void setGravity(int i2) {
        this.h = i2;
        requestLayout();
    }

    public void setNonPrimaryAlpha(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        int i2 = ((int) (f2 * 255.0f)) & 255;
        this.m = i2;
        int i3 = (i2 << 24) | (this.n & ViewCompat.MEASURED_SIZE_MASK);
        this.b.setTextColor(i3);
        this.d.setTextColor(i3);
    }

    public void setTextColor(@ColorInt int i2) {
        this.n = i2;
        this.c.setTextColor(i2);
        int i3 = (this.m << 24) | (this.n & ViewCompat.MEASURED_SIZE_MASK);
        this.b.setTextColor(i3);
        this.d.setTextColor(i3);
    }

    public void setTextSize(int i2, float f2) {
        this.b.setTextSize(i2, f2);
        this.c.setTextSize(i2, f2);
        this.d.setTextSize(i2, f2);
    }

    public void setTextSpacing(int i2) {
        this.g = i2;
        requestLayout();
    }

    public PagerTitleStrip(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = -1;
        this.f = -1.0f;
        this.k = new a();
        TextView textView = new TextView(context);
        this.b = textView;
        addView(textView);
        TextView textView2 = new TextView(context);
        this.c = textView2;
        addView(textView2);
        TextView textView3 = new TextView(context);
        this.d = textView3;
        addView(textView3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o);
        boolean z = false;
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            TextViewCompat.setTextAppearance(this.b, resourceId);
            TextViewCompat.setTextAppearance(this.c, resourceId);
            TextViewCompat.setTextAppearance(this.d, resourceId);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            setTextSize(0, (float) dimensionPixelSize);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            int color = obtainStyledAttributes.getColor(2, 0);
            this.b.setTextColor(color);
            this.c.setTextColor(color);
            this.d.setTextColor(color);
        }
        this.h = obtainStyledAttributes.getInteger(3, 80);
        obtainStyledAttributes.recycle();
        this.n = this.c.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(0.6f);
        this.b.setEllipsize(TextUtils.TruncateAt.END);
        this.c.setEllipsize(TextUtils.TruncateAt.END);
        this.d.setEllipsize(TextUtils.TruncateAt.END);
        if (resourceId != 0) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, p);
            z = obtainStyledAttributes2.getBoolean(0, false);
            obtainStyledAttributes2.recycle();
        }
        if (z) {
            setSingleLineAllCaps(this.b);
            setSingleLineAllCaps(this.c);
            setSingleLineAllCaps(this.d);
        } else {
            this.b.setSingleLine();
            this.c.setSingleLine();
            this.d.setSingleLine();
        }
        this.g = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }
}

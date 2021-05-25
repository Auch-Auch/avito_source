package ru.tinkoff.scrollingpagerindicator;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
public class ScrollingPagerIndicator extends View {
    public int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public int f;
    public int g;
    public int h;
    public float i;
    public float j;
    public float k;
    public SparseArray<Float> l;
    public int m;
    public final Paint n;
    public final ArgbEvaluator o;
    @ColorInt
    public int p;
    @ColorInt
    public int q;
    public boolean r;
    public Runnable s;
    public PagerAttacher<?> t;
    public boolean u;

    public @interface Orientation {
    }

    public interface PagerAttacher<T> {
        void attachToPager(@NonNull ScrollingPagerIndicator scrollingPagerIndicator, @NonNull T t);

        void detachFromPager();
    }

    public class a implements Runnable {
        public final /* synthetic */ Object a;
        public final /* synthetic */ PagerAttacher b;

        public a(Object obj, PagerAttacher pagerAttacher) {
            this.a = obj;
            this.b = pagerAttacher;
        }

        @Override // java.lang.Runnable
        public void run() {
            ScrollingPagerIndicator scrollingPagerIndicator = ScrollingPagerIndicator.this;
            scrollingPagerIndicator.m = -1;
            scrollingPagerIndicator.attachToPager(this.a, this.b);
        }
    }

    public ScrollingPagerIndicator(Context context) {
        this(context, null);
    }

    private int getDotCount() {
        if (!this.r || this.m <= this.f) {
            return this.m;
        }
        return this.a;
    }

    public final void a(float f2, int i2) {
        int i3 = this.m;
        int i4 = this.f;
        if (i3 <= i4) {
            this.i = 0.0f;
        } else if (this.r || i3 <= i4) {
            this.i = ((((float) this.e) * f2) + b(this.a / 2)) - (this.j / 2.0f);
        } else {
            float f3 = this.k;
            int i5 = this.e;
            this.i = ((((float) i5) * f2) + (f3 + ((float) (i2 * i5)))) - (this.j / 2.0f);
            int i6 = i4 / 2;
            float b2 = b((getDotCount() - 1) - i6);
            if ((this.j / 2.0f) + this.i < b(i6)) {
                this.i = b(i6) - (this.j / 2.0f);
                return;
            }
            float f4 = this.i;
            float f5 = this.j;
            if ((f5 / 2.0f) + f4 > b2) {
                this.i = b2 - (f5 / 2.0f);
            }
        }
    }

    public void attachToPager(@NonNull ViewPager viewPager) {
        attachToPager(viewPager, new ViewPagerAttacher());
    }

    public void attachToRecyclerView(@NonNull RecyclerView recyclerView) {
        attachToPager(recyclerView, new RecyclerViewAttacher());
    }

    public final float b(int i2) {
        return this.k + ((float) (i2 * this.e));
    }

    public final void c(int i2, float f2) {
        if (this.l != null && getDotCount() != 0) {
            float abs = 1.0f - Math.abs(f2);
            if (abs == 0.0f) {
                this.l.remove(i2);
            } else {
                this.l.put(i2, Float.valueOf(abs));
            }
        }
    }

    public void detachFromPager() {
        PagerAttacher<?> pagerAttacher = this.t;
        if (pagerAttacher != null) {
            pagerAttacher.detachFromPager();
            this.t = null;
            this.s = null;
        }
        this.u = false;
    }

    @ColorInt
    public int getDotColor() {
        return this.p;
    }

    @Orientation
    public int getOrientation() {
        return this.h;
    }

    @ColorInt
    public int getSelectedDotColor() {
        return this.q;
    }

    public int getVisibleDotCount() {
        return this.f;
    }

    public int getVisibleDotThreshold() {
        return this.g;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i2;
        int dotCount = getDotCount();
        if (dotCount >= this.g) {
            int i3 = this.e;
            int i4 = this.d;
            float R1 = ((float) a2.b.a.a.a.R1(i4, this.c, 2, i3)) * 0.7f;
            float f2 = (float) (i4 / 2);
            float f3 = ((float) i3) * 0.85714287f;
            float f4 = this.i;
            int i5 = ((int) (f4 - this.k)) / i3;
            int b2 = (((int) ((f4 + this.j) - b(i5))) / this.e) + i5;
            if (i5 == 0 && b2 + 1 > dotCount) {
                b2 = dotCount - 1;
            }
            while (i5 <= b2) {
                float b3 = b(i5);
                float f5 = this.i;
                if (b3 >= f5) {
                    float f6 = this.j;
                    if (b3 < f5 + f6) {
                        float f7 = 0.0f;
                        if (!this.r || this.m <= this.f) {
                            Float f8 = this.l.get(i5);
                            if (f8 != null) {
                                f7 = f8.floatValue();
                            }
                        } else {
                            float f9 = (f6 / 2.0f) + f5;
                            if (b3 >= f9 - f3 && b3 <= f9) {
                                f7 = ((b3 - f9) + f3) / f3;
                            } else if (b3 > f9 && b3 < f9 + f3) {
                                f7 = 1.0f - ((b3 - f9) / f3);
                            }
                        }
                        int i6 = this.c;
                        float f10 = (((float) (this.d - i6)) * f7) + ((float) i6);
                        if (this.m > this.f) {
                            float f11 = (this.r || !(i5 == 0 || i5 == dotCount + -1)) ? R1 : f2;
                            int width = getWidth();
                            if (this.h == 1) {
                                width = getHeight();
                            }
                            float f12 = this.i;
                            if (b3 - f12 < f11) {
                                float f13 = ((b3 - f12) * f10) / f11;
                                i2 = this.b;
                                if (f13 > ((float) i2)) {
                                    if (f13 < f10) {
                                        f10 = f13;
                                    }
                                }
                            } else {
                                float f14 = (float) width;
                                if (b3 - f12 > f14 - f11) {
                                    float f15 = ((((-b3) + f12) + f14) * f10) / f11;
                                    i2 = this.b;
                                    if (f15 > ((float) i2)) {
                                        if (f15 < f10) {
                                            f10 = f15;
                                        }
                                    }
                                }
                            }
                            f10 = (float) i2;
                        }
                        this.n.setColor(((Integer) this.o.evaluate(f7, Integer.valueOf(this.p), Integer.valueOf(this.q))).intValue());
                        if (this.h == 0) {
                            canvas.drawCircle(b3 - this.i, (float) (getMeasuredHeight() / 2), f10 / 2.0f, this.n);
                        } else {
                            canvas.drawCircle((float) (getMeasuredWidth() / 2), b3 - this.i, f10 / 2.0f, this.n);
                        }
                    }
                }
                i5++;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0077  */
    @Override // android.view.View
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r5, int r6) {
        /*
            r4 = this;
            int r0 = r4.h
            r1 = 1073741824(0x40000000, float:2.0)
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != 0) goto L_0x0042
            boolean r5 = r4.isInEditMode()
            if (r5 == 0) goto L_0x001a
            int r5 = r4.f
            int r5 = r5 + -1
            int r0 = r4.e
            int r5 = r5 * r0
            int r0 = r4.d
        L_0x0018:
            int r5 = r5 + r0
            goto L_0x002d
        L_0x001a:
            int r5 = r4.m
            int r0 = r4.f
            if (r5 < r0) goto L_0x0024
            float r5 = r4.j
            int r5 = (int) r5
            goto L_0x002d
        L_0x0024:
            int r5 = r5 + -1
            int r0 = r4.e
            int r5 = r5 * r0
            int r0 = r4.d
            goto L_0x0018
        L_0x002d:
            int r0 = android.view.View.MeasureSpec.getMode(r6)
            int r6 = android.view.View.MeasureSpec.getSize(r6)
            int r3 = r4.d
            if (r0 == r2) goto L_0x003d
            if (r0 == r1) goto L_0x007b
            r6 = r3
            goto L_0x007b
        L_0x003d:
            int r6 = java.lang.Math.min(r3, r6)
            goto L_0x007b
        L_0x0042:
            boolean r6 = r4.isInEditMode()
            if (r6 == 0) goto L_0x0054
            int r6 = r4.f
            int r6 = r6 + -1
            int r0 = r4.e
            int r6 = r6 * r0
            int r0 = r4.d
        L_0x0052:
            int r6 = r6 + r0
            goto L_0x0067
        L_0x0054:
            int r6 = r4.m
            int r0 = r4.f
            if (r6 < r0) goto L_0x005e
            float r6 = r4.j
            int r6 = (int) r6
            goto L_0x0067
        L_0x005e:
            int r6 = r6 + -1
            int r0 = r4.e
            int r6 = r6 * r0
            int r0 = r4.d
            goto L_0x0052
        L_0x0067:
            int r0 = android.view.View.MeasureSpec.getMode(r5)
            int r5 = android.view.View.MeasureSpec.getSize(r5)
            int r3 = r4.d
            if (r0 == r2) goto L_0x0077
            if (r0 == r1) goto L_0x007b
            r5 = r3
            goto L_0x007b
        L_0x0077:
            int r5 = java.lang.Math.min(r3, r5)
        L_0x007b:
            r4.setMeasuredDimension(r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator.onMeasure(int, int):void");
    }

    public void onPageScrolled(int i2, float f2) {
        int i3;
        if (f2 < 0.0f || f2 > 1.0f) {
            throw new IllegalArgumentException("Offset must be [0, 1]");
        } else if (i2 < 0 || (i2 != 0 && i2 >= this.m)) {
            throw new IndexOutOfBoundsException("page must be [0, adapter.getItemCount())");
        } else {
            if (!this.r || ((i3 = this.m) <= this.f && i3 > 1)) {
                this.l.clear();
                if (this.h == 0) {
                    c(i2, f2);
                    int i4 = this.m;
                    if (i2 < i4 - 1) {
                        c(i2 + 1, 1.0f - f2);
                    } else if (i4 > 1) {
                        c(0, 1.0f - f2);
                    }
                } else {
                    c(i2 - 1, f2);
                    c(i2, 1.0f - f2);
                }
                invalidate();
            }
            if (this.h == 0) {
                a(f2, i2);
            } else {
                a(f2, i2 - 1);
            }
            invalidate();
        }
    }

    public void reattach() {
        Runnable runnable = this.s;
        if (runnable != null) {
            runnable.run();
            invalidate();
        }
    }

    public void setCurrentPosition(int i2) {
        if (i2 != 0 && (i2 < 0 || i2 >= this.m)) {
            throw new IndexOutOfBoundsException("Position must be [0, adapter.getItemCount()]");
        } else if (this.m != 0) {
            a(0.0f, i2);
            if (!this.r || this.m < this.f) {
                this.l.clear();
                this.l.put(i2, Float.valueOf(1.0f));
                invalidate();
            }
        }
    }

    public void setDotColor(@ColorInt int i2) {
        this.p = i2;
        invalidate();
    }

    public void setDotCount(int i2) {
        if (this.m != i2 || !this.u) {
            this.m = i2;
            this.u = true;
            this.l = new SparseArray<>();
            if (i2 < this.g) {
                requestLayout();
                invalidate();
                return;
            }
            this.k = (!this.r || this.m <= this.f) ? (float) (this.d / 2) : 0.0f;
            this.j = (float) (((this.f - 1) * this.e) + this.d);
            requestLayout();
            invalidate();
        }
    }

    public void setLooped(boolean z) {
        this.r = z;
        reattach();
        invalidate();
    }

    public void setOrientation(@Orientation int i2) {
        this.h = i2;
        if (this.s != null) {
            reattach();
        } else {
            requestLayout();
        }
    }

    public void setSelectedDotColor(@ColorInt int i2) {
        this.q = i2;
        invalidate();
    }

    public void setVisibleDotCount(int i2) {
        if (i2 % 2 != 0) {
            this.f = i2;
            this.a = i2 + 2;
            if (this.s != null) {
                reattach();
            } else {
                requestLayout();
            }
        } else {
            throw new IllegalArgumentException("visibleDotCount must be odd");
        }
    }

    public void setVisibleDotThreshold(int i2) {
        this.g = i2;
        if (this.s != null) {
            reattach();
        } else {
            requestLayout();
        }
    }

    public ScrollingPagerIndicator(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.scrollingPagerIndicatorStyle);
    }

    public void attachToPager(@NonNull ViewPager2 viewPager2) {
        attachToPager(viewPager2, new ViewPager2Attacher());
    }

    public void attachToRecyclerView(@NonNull RecyclerView recyclerView, int i2) {
        attachToPager(recyclerView, new RecyclerViewAttacher(i2));
    }

    public ScrollingPagerIndicator(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.o = new ArgbEvaluator();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ScrollingPagerIndicator, i2, R.style.ScrollingPagerIndicator);
        int color = obtainStyledAttributes.getColor(R.styleable.ScrollingPagerIndicator_spi_dotColor, 0);
        this.p = color;
        this.q = obtainStyledAttributes.getColor(R.styleable.ScrollingPagerIndicator_spi_dotSelectedColor, color);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ScrollingPagerIndicator_spi_dotSize, 0);
        this.c = dimensionPixelSize;
        this.d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ScrollingPagerIndicator_spi_dotSelectedSize, 0);
        int i3 = -1;
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ScrollingPagerIndicator_spi_dotMinimumSize, -1);
        this.b = dimensionPixelSize2 <= dimensionPixelSize ? dimensionPixelSize2 : i3;
        this.e = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ScrollingPagerIndicator_spi_dotSpacing, 0) + dimensionPixelSize;
        this.r = obtainStyledAttributes.getBoolean(R.styleable.ScrollingPagerIndicator_spi_looped, false);
        int i4 = obtainStyledAttributes.getInt(R.styleable.ScrollingPagerIndicator_spi_visibleDotCount, 0);
        setVisibleDotCount(i4);
        this.g = obtainStyledAttributes.getInt(R.styleable.ScrollingPagerIndicator_spi_visibleDotThreshold, 2);
        this.h = obtainStyledAttributes.getInt(R.styleable.ScrollingPagerIndicator_spi_orientation, 0);
        obtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.n = paint;
        paint.setAntiAlias(true);
        if (isInEditMode()) {
            setDotCount(i4);
            onPageScrolled(i4 / 2, 0.0f);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator$PagerAttacher<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> void attachToPager(@NonNull T t2, @NonNull PagerAttacher<T> pagerAttacher) {
        detachFromPager();
        pagerAttacher.attachToPager(this, t2);
        this.t = pagerAttacher;
        this.s = new a(t2, pagerAttacher);
    }
}

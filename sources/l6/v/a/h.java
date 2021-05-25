package l6.v.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
@VisibleForTesting
public class h extends RecyclerView.ItemDecoration implements RecyclerView.OnItemTouchListener {
    public static final int[] D = {16842919};
    public static final int[] E = new int[0];
    public int A;
    public final Runnable B;
    public final RecyclerView.OnScrollListener C;
    public final int a;
    public final int b;
    public final StateListDrawable c;
    public final Drawable d;
    public final int e;
    public final int f;
    public final StateListDrawable g;
    public final Drawable h;
    public final int i;
    public final int j;
    @VisibleForTesting
    public int k;
    @VisibleForTesting
    public int l;
    @VisibleForTesting
    public float m;
    @VisibleForTesting
    public int n;
    @VisibleForTesting
    public int o;
    @VisibleForTesting
    public float p;
    public int q = 0;
    public int r = 0;
    public RecyclerView s;
    public boolean t = false;
    public boolean u = false;
    public int v = 0;
    public int w = 0;
    public final int[] x = new int[2];
    public final int[] y = new int[2];
    public final ValueAnimator z;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h hVar = h.this;
            int i = hVar.A;
            if (i == 1) {
                hVar.z.cancel();
            } else if (i != 2) {
                return;
            }
            hVar.A = 3;
            ValueAnimator valueAnimator = hVar.z;
            valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
            hVar.z.setDuration((long) 500);
            hVar.z.start();
        }
    }

    public class b extends RecyclerView.OnScrollListener {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            h hVar = h.this;
            int computeHorizontalScrollOffset = recyclerView.computeHorizontalScrollOffset();
            int computeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
            int computeVerticalScrollRange = hVar.s.computeVerticalScrollRange();
            int i3 = hVar.r;
            hVar.t = computeVerticalScrollRange - i3 > 0 && i3 >= hVar.a;
            int computeHorizontalScrollRange = hVar.s.computeHorizontalScrollRange();
            int i4 = hVar.q;
            boolean z = computeHorizontalScrollRange - i4 > 0 && i4 >= hVar.a;
            hVar.u = z;
            boolean z2 = hVar.t;
            if (z2 || z) {
                if (z2) {
                    float f = (float) i3;
                    hVar.l = (int) ((((f / 2.0f) + ((float) computeVerticalScrollOffset)) * f) / ((float) computeVerticalScrollRange));
                    hVar.k = Math.min(i3, (i3 * i3) / computeVerticalScrollRange);
                }
                if (hVar.u) {
                    float f2 = (float) computeHorizontalScrollOffset;
                    float f3 = (float) i4;
                    hVar.o = (int) ((((f3 / 2.0f) + f2) * f3) / ((float) computeHorizontalScrollRange));
                    hVar.n = Math.min(i4, (i4 * i4) / computeHorizontalScrollRange);
                }
                int i5 = hVar.v;
                if (i5 == 0 || i5 == 1) {
                    hVar.e(1);
                }
            } else if (hVar.v != 0) {
                hVar.e(0);
            }
        }
    }

    public class c extends AnimatorListenerAdapter {
        public boolean a = false;

        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.a) {
                this.a = false;
            } else if (((Float) h.this.z.getAnimatedValue()).floatValue() == 0.0f) {
                h hVar = h.this;
                hVar.A = 0;
                hVar.e(0);
            } else {
                h hVar2 = h.this;
                hVar2.A = 2;
                hVar2.s.invalidate();
            }
        }
    }

    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            h.this.c.setAlpha(floatValue);
            h.this.d.setAlpha(floatValue);
            h.this.s.invalidate();
        }
    }

    public h(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i2, int i3, int i4) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.z = ofFloat;
        this.A = 0;
        this.B = new a();
        b bVar = new b();
        this.C = bVar;
        this.c = stateListDrawable;
        this.d = drawable;
        this.g = stateListDrawable2;
        this.h = drawable2;
        this.e = Math.max(i2, stateListDrawable.getIntrinsicWidth());
        this.f = Math.max(i2, drawable.getIntrinsicWidth());
        this.i = Math.max(i2, stateListDrawable2.getIntrinsicWidth());
        this.j = Math.max(i2, drawable2.getIntrinsicWidth());
        this.a = i3;
        this.b = i4;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        ofFloat.addListener(new c());
        ofFloat.addUpdateListener(new d());
        RecyclerView recyclerView2 = this.s;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                recyclerView2.removeItemDecoration(this);
                this.s.removeOnItemTouchListener(this);
                this.s.removeOnScrollListener(bVar);
                a();
            }
            this.s = recyclerView;
            recyclerView.addItemDecoration(this);
            this.s.addOnItemTouchListener(this);
            this.s.addOnScrollListener(bVar);
        }
    }

    public final void a() {
        this.s.removeCallbacks(this.B);
    }

    @VisibleForTesting
    public boolean b(float f2, float f3) {
        if (f3 >= ((float) (this.r - this.i))) {
            int i2 = this.o;
            int i3 = this.n;
            if (f2 >= ((float) (i2 - (i3 / 2))) && f2 <= ((float) ((i3 / 2) + i2))) {
                return true;
            }
        }
        return false;
    }

    @VisibleForTesting
    public boolean c(float f2, float f3) {
        if (ViewCompat.getLayoutDirection(this.s) == 1) {
            if (f2 > ((float) (this.e / 2))) {
                return false;
            }
        } else if (f2 < ((float) (this.q - this.e))) {
            return false;
        }
        int i2 = this.l;
        int i3 = this.k / 2;
        if (f3 < ((float) (i2 - i3)) || f3 > ((float) (i3 + i2))) {
            return false;
        }
        return true;
    }

    public final int d(float f2, float f3, int[] iArr, int i2, int i3, int i4) {
        int i5 = iArr[1] - iArr[0];
        if (i5 == 0) {
            return 0;
        }
        int i6 = i2 - i4;
        int i7 = (int) (((f3 - f2) / ((float) i5)) * ((float) i6));
        int i8 = i3 + i7;
        if (i8 >= i6 || i8 < 0) {
            return 0;
        }
        return i7;
    }

    public void e(int i2) {
        if (i2 == 2 && this.v != 2) {
            this.c.setState(D);
            a();
        }
        if (i2 == 0) {
            this.s.invalidate();
        } else {
            f();
        }
        if (this.v == 2 && i2 != 2) {
            this.c.setState(E);
            a();
            this.s.postDelayed(this.B, (long) 1200);
        } else if (i2 == 1) {
            a();
            this.s.postDelayed(this.B, (long) 1500);
        }
        this.v = i2;
    }

    public void f() {
        int i2 = this.A;
        if (i2 != 0) {
            if (i2 == 3) {
                this.z.cancel();
            } else {
                return;
            }
        }
        this.A = 1;
        ValueAnimator valueAnimator = this.z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.z.setDuration(500L);
        this.z.setStartDelay(0);
        this.z.start();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        if (this.q != this.s.getWidth() || this.r != this.s.getHeight()) {
            this.q = this.s.getWidth();
            this.r = this.s.getHeight();
            e(0);
        } else if (this.A != 0) {
            if (this.t) {
                int i2 = this.q;
                int i3 = this.e;
                int i4 = i2 - i3;
                int i5 = this.l;
                int i6 = this.k;
                int i7 = i5 - (i6 / 2);
                this.c.setBounds(0, 0, i3, i6);
                this.d.setBounds(0, 0, this.f, this.r);
                boolean z2 = true;
                if (ViewCompat.getLayoutDirection(this.s) != 1) {
                    z2 = false;
                }
                if (z2) {
                    this.d.draw(canvas);
                    canvas.translate((float) this.e, (float) i7);
                    canvas.scale(-1.0f, 1.0f);
                    this.c.draw(canvas);
                    canvas.scale(1.0f, 1.0f);
                    canvas.translate((float) (-this.e), (float) (-i7));
                } else {
                    canvas.translate((float) i4, 0.0f);
                    this.d.draw(canvas);
                    canvas.translate(0.0f, (float) i7);
                    this.c.draw(canvas);
                    canvas.translate((float) (-i4), (float) (-i7));
                }
            }
            if (this.u) {
                int i8 = this.r;
                int i9 = this.i;
                int i10 = i8 - i9;
                int i11 = this.o;
                int i12 = this.n;
                int i13 = i11 - (i12 / 2);
                this.g.setBounds(0, 0, i12, i9);
                this.h.setBounds(0, 0, this.q, this.j);
                canvas.translate(0.0f, (float) i10);
                this.h.draw(canvas);
                canvas.translate((float) i13, 0.0f);
                this.g.draw(canvas);
                canvas.translate((float) (-i13), (float) (-i10));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        int i2 = this.v;
        if (i2 == 1) {
            boolean c2 = c(motionEvent.getX(), motionEvent.getY());
            boolean b2 = b(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() == 0 && (c2 || b2)) {
                if (b2) {
                    this.w = 1;
                    this.p = (float) ((int) motionEvent.getX());
                } else if (c2) {
                    this.w = 2;
                    this.m = (float) ((int) motionEvent.getY());
                }
                e(2);
                return true;
            }
        } else if (i2 == 2) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onRequestDisallowInterceptTouchEvent(boolean z2) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        if (this.v != 0) {
            if (motionEvent.getAction() == 0) {
                boolean c2 = c(motionEvent.getX(), motionEvent.getY());
                boolean b2 = b(motionEvent.getX(), motionEvent.getY());
                if (c2 || b2) {
                    if (b2) {
                        this.w = 1;
                        this.p = (float) ((int) motionEvent.getX());
                    } else if (c2) {
                        this.w = 2;
                        this.m = (float) ((int) motionEvent.getY());
                    }
                    e(2);
                }
            } else if (motionEvent.getAction() == 1 && this.v == 2) {
                this.m = 0.0f;
                this.p = 0.0f;
                e(1);
                this.w = 0;
            } else if (motionEvent.getAction() == 2 && this.v == 2) {
                f();
                if (this.w == 1) {
                    float x2 = motionEvent.getX();
                    int[] iArr = this.y;
                    int i2 = this.b;
                    iArr[0] = i2;
                    iArr[1] = this.q - i2;
                    float max = Math.max((float) iArr[0], Math.min((float) iArr[1], x2));
                    if (Math.abs(((float) this.o) - max) >= 2.0f) {
                        int d2 = d(this.p, max, iArr, this.s.computeHorizontalScrollRange(), this.s.computeHorizontalScrollOffset(), this.q);
                        if (d2 != 0) {
                            this.s.scrollBy(d2, 0);
                        }
                        this.p = max;
                    }
                }
                if (this.w == 2) {
                    float y2 = motionEvent.getY();
                    int[] iArr2 = this.x;
                    int i3 = this.b;
                    iArr2[0] = i3;
                    iArr2[1] = this.r - i3;
                    float max2 = Math.max((float) iArr2[0], Math.min((float) iArr2[1], y2));
                    if (Math.abs(((float) this.l) - max2) >= 2.0f) {
                        int d3 = d(this.m, max2, iArr2, this.s.computeVerticalScrollRange(), this.s.computeVerticalScrollOffset(), this.r);
                        if (d3 != 0) {
                            this.s.scrollBy(0, d3);
                        }
                        this.m = max2;
                    }
                }
            }
        }
    }
}

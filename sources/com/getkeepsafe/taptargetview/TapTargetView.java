package com.getkeepsafe.taptargetview;

import a2.h.a.b;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.view.ViewOutlineProvider;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import com.google.android.material.badge.BadgeDrawable;
import java.util.Objects;
@SuppressLint({"ViewConstructor"})
public class TapTargetView extends View {
    public static final /* synthetic */ int q0 = 0;
    @Nullable
    public CharSequence A;
    @Nullable
    public StaticLayout B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    @Nullable
    public SpannableStringBuilder I;
    @Nullable
    public DynamicLayout J;
    @Nullable
    public TextPaint K;
    @Nullable
    public Paint L;
    public Rect M;
    public Rect N;
    public Path O;
    public float P;
    public int Q;
    public int[] R;
    public int S;
    public float T;
    public int U;
    public float V;
    public int W;
    public boolean a = false;
    public int a0;
    public boolean b = false;
    public int b0;
    public boolean c = true;
    public float c0;
    public final int d;
    public float d0;
    public final int e;
    public int e0;
    public final int f;
    public int f0;
    public final int g;
    public Bitmap g0;
    public final int h;
    public Listener h0;
    public final int i;
    @Nullable
    public ViewOutlineProvider i0;
    public final int j;
    public final b.c j0 = new d();
    public final int k;
    public final ValueAnimator k0;
    public final int l;
    public final ValueAnimator l0;
    public final int m;
    public final ValueAnimator m0;
    public final int n;
    public final ValueAnimator n0;
    @Nullable
    public final ViewGroup o;
    public ValueAnimator[] o0;
    public final ViewManager p;
    public final ViewTreeObserver.OnGlobalLayoutListener p0;
    public final TapTarget q;
    public final Rect r;
    public final TextPaint s;
    public final TextPaint t;
    public final Paint u;
    public final Paint v;
    public final Paint w;
    public final Paint x;
    public CharSequence y;
    @Nullable
    public StaticLayout z;

    public static class Listener {
        public void onOuterCircleClick(TapTargetView tapTargetView) {
        }

        public void onTargetCancel(TapTargetView tapTargetView) {
            tapTargetView.dismiss(false);
        }

        public void onTargetClick(TapTargetView tapTargetView) {
            tapTargetView.dismiss(true);
        }

        public void onTargetDismissed(TapTargetView tapTargetView, boolean z) {
        }

        public void onTargetLongClick(TapTargetView tapTargetView) {
            onTargetClick(tapTargetView);
        }
    }

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TapTargetView tapTargetView = TapTargetView.this;
            if (tapTargetView.h0 != null && tapTargetView.R != null && tapTargetView.c) {
                int centerX = tapTargetView.r.centerX();
                int centerY = TapTargetView.this.r.centerY();
                TapTargetView tapTargetView2 = TapTargetView.this;
                double b = tapTargetView.b(centerX, centerY, (int) tapTargetView2.c0, (int) tapTargetView2.d0);
                TapTargetView tapTargetView3 = TapTargetView.this;
                boolean z = true;
                boolean z2 = b <= ((double) tapTargetView3.V);
                int[] iArr = tapTargetView3.R;
                double b2 = tapTargetView3.b(iArr[0], iArr[1], (int) tapTargetView3.c0, (int) tapTargetView3.d0);
                TapTargetView tapTargetView4 = TapTargetView.this;
                if (b2 > ((double) tapTargetView4.P)) {
                    z = false;
                }
                if (z2) {
                    tapTargetView4.c = false;
                    tapTargetView4.h0.onTargetClick(tapTargetView4);
                } else if (z) {
                    tapTargetView4.h0.onOuterCircleClick(tapTargetView4);
                } else if (tapTargetView4.G) {
                    tapTargetView4.c = false;
                    tapTargetView4.h0.onTargetCancel(tapTargetView4);
                }
            }
        }
    }

    public class b implements View.OnLongClickListener {
        public b() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            TapTargetView tapTargetView = TapTargetView.this;
            if (tapTargetView.h0 == null || !tapTargetView.r.contains((int) tapTargetView.c0, (int) tapTargetView.d0)) {
                return false;
            }
            TapTargetView tapTargetView2 = TapTargetView.this;
            tapTargetView2.h0.onTargetLongClick(tapTargetView2);
            return true;
        }
    }

    public class c extends ViewOutlineProvider {
        public c() {
        }

        @Override // android.view.ViewOutlineProvider
        @TargetApi(21)
        public void getOutline(View view, Outline outline) {
            TapTargetView tapTargetView = TapTargetView.this;
            int[] iArr = tapTargetView.R;
            if (iArr != null) {
                float f = tapTargetView.P;
                outline.setOval((int) (((float) iArr[0]) - f), (int) (((float) iArr[1]) - f), (int) (((float) iArr[0]) + f), (int) (((float) iArr[1]) + f));
                outline.setAlpha(((float) TapTargetView.this.S) / 255.0f);
                if (Build.VERSION.SDK_INT >= 22) {
                    outline.offset(0, TapTargetView.this.m);
                }
            }
        }
    }

    public class d implements b.c {
        public d() {
        }

        @Override // a2.h.a.b.c
        public void a(float f) {
            TapTargetView tapTargetView = TapTargetView.this;
            float f2 = ((float) tapTargetView.Q) * f;
            boolean z = f2 > tapTargetView.P;
            if (!z) {
                tapTargetView.a();
            }
            TapTargetView tapTargetView2 = TapTargetView.this;
            float f3 = tapTargetView2.q.c * 255.0f;
            tapTargetView2.P = f2;
            float f4 = 1.5f * f;
            tapTargetView2.S = (int) Math.min(f3, f4 * f3);
            TapTargetView.this.O.reset();
            TapTargetView tapTargetView3 = TapTargetView.this;
            Path path = tapTargetView3.O;
            int[] iArr = tapTargetView3.R;
            path.addCircle((float) iArr[0], (float) iArr[1], tapTargetView3.P, Path.Direction.CW);
            TapTargetView.this.W = (int) Math.min(255.0f, f4 * 255.0f);
            if (z) {
                TapTargetView tapTargetView4 = TapTargetView.this;
                tapTargetView4.V = Math.min(1.0f, f4) * ((float) tapTargetView4.e);
            } else {
                TapTargetView tapTargetView5 = TapTargetView.this;
                tapTargetView5.V = ((float) tapTargetView5.e) * f;
                tapTargetView5.T *= f;
            }
            TapTargetView tapTargetView6 = TapTargetView.this;
            Objects.requireNonNull(tapTargetView6);
            tapTargetView6.a0 = (int) ((f < 0.7f ? 0.0f : (f - 0.7f) / 0.3f) * 255.0f);
            if (z) {
                TapTargetView.this.a();
            }
            TapTargetView tapTargetView7 = TapTargetView.this;
            tapTargetView7.c(tapTargetView7.M);
        }
    }

    public class e implements b.AbstractC0029b {
        public e() {
        }

        @Override // a2.h.a.b.AbstractC0029b
        public void a() {
            TapTargetView.this.l0.start();
            TapTargetView.this.c = true;
        }
    }

    public class f implements b.c {
        public f() {
        }

        @Override // a2.h.a.b.c
        public void a(float f) {
            TapTargetView.this.j0.a(f);
        }
    }

    public class g implements b.c {
        public g() {
        }

        @Override // a2.h.a.b.c
        public void a(float f) {
            Objects.requireNonNull(TapTargetView.this);
            int i = (f > 0.5f ? 1 : (f == 0.5f ? 0 : -1));
            float f2 = i < 0 ? 0.0f : (f - 0.5f) / 0.5f;
            TapTargetView tapTargetView = TapTargetView.this;
            float f3 = (float) tapTargetView.e;
            tapTargetView.T = (f2 + 1.0f) * f3;
            tapTargetView.U = (int) ((1.0f - f2) * 255.0f);
            tapTargetView.V = ((i < 0 ? f / 0.5f : (1.0f - f) / 0.5f) * ((float) tapTargetView.f)) + f3;
            float f4 = tapTargetView.P;
            float f5 = (float) tapTargetView.Q;
            if (f4 != f5) {
                tapTargetView.P = f5;
            }
            tapTargetView.a();
            TapTargetView tapTargetView2 = TapTargetView.this;
            tapTargetView2.c(tapTargetView2.M);
        }
    }

    public class h implements b.AbstractC0029b {
        public h() {
        }

        @Override // a2.h.a.b.AbstractC0029b
        public void a() {
            TapTargetView tapTargetView = TapTargetView.this;
            int i = TapTargetView.q0;
            tapTargetView.e(true);
            ViewManager viewManager = tapTargetView.p;
            if (viewManager != null) {
                try {
                    viewManager.removeView(tapTargetView);
                } catch (Exception unused) {
                }
            }
        }
    }

    public class i implements b.c {
        public i() {
        }

        @Override // a2.h.a.b.c
        public void a(float f) {
            TapTargetView.this.j0.a(f);
        }
    }

    public class j implements b.AbstractC0029b {
        public j() {
        }

        @Override // a2.h.a.b.AbstractC0029b
        public void a() {
            TapTargetView tapTargetView = TapTargetView.this;
            int i = TapTargetView.q0;
            tapTargetView.e(true);
            ViewManager viewManager = tapTargetView.p;
            if (viewManager != null) {
                try {
                    viewManager.removeView(tapTargetView);
                } catch (Exception unused) {
                }
            }
        }
    }

    public class k implements b.c {
        public k() {
        }

        @Override // a2.h.a.b.c
        public void a(float f) {
            float min = Math.min(1.0f, 2.0f * f);
            TapTargetView tapTargetView = TapTargetView.this;
            tapTargetView.P = ((0.2f * min) + 1.0f) * ((float) tapTargetView.Q);
            float f2 = 1.0f - min;
            tapTargetView.S = (int) (tapTargetView.q.c * f2 * 255.0f);
            tapTargetView.O.reset();
            TapTargetView tapTargetView2 = TapTargetView.this;
            Path path = tapTargetView2.O;
            int[] iArr = tapTargetView2.R;
            path.addCircle((float) iArr[0], (float) iArr[1], tapTargetView2.P, Path.Direction.CW);
            TapTargetView tapTargetView3 = TapTargetView.this;
            float f3 = 1.0f - f;
            int i = tapTargetView3.e;
            tapTargetView3.V = ((float) i) * f3;
            tapTargetView3.W = (int) (f3 * 255.0f);
            tapTargetView3.T = (f + 1.0f) * ((float) i);
            tapTargetView3.U = (int) (f3 * ((float) tapTargetView3.U));
            tapTargetView3.a0 = (int) (f2 * 255.0f);
            tapTargetView3.a();
            TapTargetView tapTargetView4 = TapTargetView.this;
            tapTargetView4.c(tapTargetView4.M);
        }
    }

    public class l implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ TapTarget a;
        public final /* synthetic */ ViewGroup b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ boolean f;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                int[] iArr = new int[2];
                l lVar = l.this;
                TapTargetView.this.r.set(lVar.a.bounds());
                TapTargetView.this.getLocationOnScreen(iArr);
                TapTargetView.this.r.offset(-iArr[0], -iArr[1]);
                l lVar2 = l.this;
                if (lVar2.b != null) {
                    DisplayMetrics displayMetrics = new DisplayMetrics();
                    ((WindowManager) lVar2.c.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                    Rect rect = new Rect();
                    l.this.b.getWindowVisibleDisplayFrame(rect);
                    int[] iArr2 = new int[2];
                    l.this.b.getLocationInWindow(iArr2);
                    l lVar3 = l.this;
                    if (lVar3.d) {
                        rect.top = iArr2[1];
                    }
                    if (lVar3.e) {
                        rect.bottom = lVar3.b.getHeight() + iArr2[1];
                    }
                    l lVar4 = l.this;
                    if (lVar4.f) {
                        TapTargetView.this.e0 = Math.max(0, rect.top);
                        TapTargetView.this.f0 = Math.min(rect.bottom, displayMetrics.heightPixels);
                    } else {
                        TapTargetView tapTargetView = TapTargetView.this;
                        tapTargetView.e0 = rect.top;
                        tapTargetView.f0 = rect.bottom;
                    }
                }
                TapTargetView tapTargetView2 = TapTargetView.this;
                Drawable drawable = tapTargetView2.q.f;
                if (!tapTargetView2.E || drawable == null) {
                    tapTargetView2.g0 = null;
                } else if (tapTargetView2.g0 == null) {
                    tapTargetView2.g0 = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(tapTargetView2.g0);
                    drawable.setColorFilter(new PorterDuffColorFilter(tapTargetView2.u.getColor(), PorterDuff.Mode.SRC_ATOP));
                    drawable.draw(canvas);
                    drawable.setColorFilter(null);
                }
                TapTargetView.this.requestFocus();
                TapTargetView tapTargetView3 = TapTargetView.this;
                tapTargetView3.N = tapTargetView3.getTextBounds();
                int[] outerCircleCenterPoint = tapTargetView3.getOuterCircleCenterPoint();
                tapTargetView3.R = outerCircleCenterPoint;
                int i = outerCircleCenterPoint[0];
                int i2 = outerCircleCenterPoint[1];
                Rect rect2 = tapTargetView3.N;
                Rect rect3 = tapTargetView3.r;
                int centerX = rect3.centerX();
                int centerY = rect3.centerY();
                Rect rect4 = new Rect(centerX, centerY, centerX, centerY);
                int i3 = -((int) (((float) tapTargetView3.e) * 1.1f));
                rect4.inset(i3, i3);
                tapTargetView3.Q = Math.max(tapTargetView3.d(i, i2, rect2), tapTargetView3.d(i, i2, rect4)) + tapTargetView3.k;
                TapTargetView tapTargetView4 = TapTargetView.this;
                if (!tapTargetView4.H) {
                    tapTargetView4.c = false;
                    tapTargetView4.k0.start();
                    tapTargetView4.H = true;
                }
            }
        }

        public l(TapTarget tapTarget, ViewGroup viewGroup, Context context, boolean z, boolean z2, boolean z3) {
            this.a = tapTarget;
            this.b = viewGroup;
            this.c = context;
            this.d = z;
            this.e = z2;
            this.f = z3;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            TapTargetView tapTargetView = TapTargetView.this;
            if (!tapTargetView.b) {
                int min = Math.min(tapTargetView.getWidth(), tapTargetView.i) - (tapTargetView.g * 2);
                if (min > 0) {
                    tapTargetView.z = new StaticLayout(tapTargetView.y, tapTargetView.s, min, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                    if (tapTargetView.A != null) {
                        tapTargetView.B = new StaticLayout(tapTargetView.A, tapTargetView.t, min, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                    } else {
                        tapTargetView.B = null;
                    }
                }
                this.a.onReady(new a());
            }
        }
    }

    public TapTargetView(Context context, ViewManager viewManager, @Nullable ViewGroup viewGroup, TapTarget tapTarget, @Nullable Listener listener) {
        super(context);
        Listener listener2;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5 = false;
        a2.h.a.b bVar = new a2.h.a.b(false);
        bVar.a.setDuration(250L);
        bVar.a.setStartDelay(250);
        bVar.a.setInterpolator(new AccelerateDecelerateInterpolator());
        bVar.a.addUpdateListener(new a2.h.a.a(bVar, new f()));
        bVar.b = new e();
        ValueAnimator a3 = bVar.a();
        this.k0 = a3;
        a2.h.a.b bVar2 = new a2.h.a.b(false);
        bVar2.a.setDuration(1000L);
        bVar2.a.setRepeatCount(-1);
        bVar2.a.setInterpolator(new AccelerateDecelerateInterpolator());
        bVar2.a.addUpdateListener(new a2.h.a.a(bVar2, new g()));
        ValueAnimator a4 = bVar2.a();
        this.l0 = a4;
        a2.h.a.b bVar3 = new a2.h.a.b(true);
        bVar3.a.setDuration(250L);
        bVar3.a.setInterpolator(new AccelerateDecelerateInterpolator());
        bVar3.a.addUpdateListener(new a2.h.a.a(bVar3, new i()));
        bVar3.b = new h();
        ValueAnimator a5 = bVar3.a();
        this.m0 = a5;
        a2.h.a.b bVar4 = new a2.h.a.b(false);
        bVar4.a.setDuration(250L);
        bVar4.a.setInterpolator(new AccelerateDecelerateInterpolator());
        bVar4.a.addUpdateListener(new a2.h.a.a(bVar4, new k()));
        bVar4.b = new j();
        ValueAnimator a6 = bVar4.a();
        this.n0 = a6;
        this.o0 = new ValueAnimator[]{a3, a4, a6, a5};
        if (tapTarget != null) {
            this.q = tapTarget;
            this.p = viewManager;
            this.o = viewGroup;
            if (listener != null) {
                listener2 = listener;
            } else {
                listener2 = new Listener();
            }
            this.h0 = listener2;
            this.y = tapTarget.a;
            this.A = tapTarget.b;
            this.d = AppCompatDelegateImpl.i.e0(context, 20);
            this.k = AppCompatDelegateImpl.i.e0(context, 40);
            int e02 = AppCompatDelegateImpl.i.e0(context, tapTarget.d);
            this.e = e02;
            this.g = AppCompatDelegateImpl.i.e0(context, 40);
            this.h = AppCompatDelegateImpl.i.e0(context, 8);
            this.i = AppCompatDelegateImpl.i.e0(context, 360);
            this.j = AppCompatDelegateImpl.i.e0(context, 20);
            this.l = AppCompatDelegateImpl.i.e0(context, 88);
            this.m = AppCompatDelegateImpl.i.e0(context, 8);
            int e03 = AppCompatDelegateImpl.i.e0(context, 1);
            this.n = e03;
            this.f = (int) (((float) e02) * 0.1f);
            this.O = new Path();
            this.r = new Rect();
            this.M = new Rect();
            TextPaint textPaint = new TextPaint();
            this.s = textPaint;
            textPaint.setTextSize((float) tapTarget.b(context, tapTarget.u, tapTarget.s));
            textPaint.setTypeface(Typeface.create("sans-serif-medium", 0));
            textPaint.setAntiAlias(true);
            TextPaint textPaint2 = new TextPaint();
            this.t = textPaint2;
            textPaint2.setTextSize((float) tapTarget.b(context, tapTarget.v, tapTarget.t));
            textPaint2.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
            textPaint2.setAntiAlias(true);
            textPaint2.setAlpha(137);
            Paint paint = new Paint();
            this.u = paint;
            paint.setAntiAlias(true);
            paint.setAlpha((int) (tapTarget.c * 255.0f));
            Paint paint2 = new Paint();
            this.v = paint2;
            paint2.setAntiAlias(true);
            paint2.setAlpha(50);
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setStrokeWidth((float) e03);
            paint2.setColor(ViewCompat.MEASURED_STATE_MASK);
            Paint paint3 = new Paint();
            this.w = paint3;
            paint3.setAntiAlias(true);
            Paint paint4 = new Paint();
            this.x = paint4;
            paint4.setAntiAlias(true);
            applyTargetOptions(context);
            if (context instanceof Activity) {
                int i2 = ((Activity) context).getWindow().getAttributes().flags;
                z4 = (67108864 & i2) != 0;
                z3 = (134217728 & i2) != 0;
                z2 = (i2 & 512) != 0 ? true : z5;
            } else {
                z4 = false;
                z3 = false;
                z2 = false;
            }
            l lVar = new l(tapTarget, viewGroup, context, z4, z3, z2);
            this.p0 = lVar;
            getViewTreeObserver().addOnGlobalLayoutListener(lVar);
            setFocusableInTouchMode(true);
            setClickable(true);
            setOnClickListener(new a());
            setOnLongClickListener(new b());
            return;
        }
        throw new IllegalArgumentException("Target cannot be null");
    }

    public static TapTargetView showFor(Activity activity, TapTarget tapTarget) {
        return showFor(activity, tapTarget, (Listener) null);
    }

    public void a() {
        int[] iArr = this.R;
        if (iArr != null) {
            this.M.left = (int) Math.max(0.0f, ((float) iArr[0]) - this.P);
            this.M.top = (int) Math.min(0.0f, ((float) this.R[1]) - this.P);
            this.M.right = (int) Math.min((float) getWidth(), ((float) this.R[0]) + this.P + ((float) this.k));
            this.M.bottom = (int) Math.min((float) getHeight(), ((float) this.R[1]) + this.P + ((float) this.k));
        }
    }

    public void applyTargetOptions(Context context) {
        TapTarget tapTarget = this.q;
        boolean z2 = tapTarget.A;
        boolean z3 = true;
        this.E = !z2 && tapTarget.z;
        boolean z4 = tapTarget.x;
        this.F = z4;
        this.G = tapTarget.y;
        if (z4 && !z2) {
            c cVar = new c();
            this.i0 = cVar;
            setOutlineProvider(cVar);
            setElevation((float) this.m);
        }
        if (this.F) {
            ViewOutlineProvider viewOutlineProvider = this.i0;
        }
        setLayerType(2, null);
        Resources.Theme theme = context.getTheme();
        if (AppCompatDelegateImpl.i.X1(context, "isLightTheme") != 0) {
            z3 = false;
        }
        this.C = z3;
        TapTarget tapTarget2 = this.q;
        Integer a3 = tapTarget2.a(context, tapTarget2.n, tapTarget2.i);
        int i2 = -1;
        if (a3 != null) {
            this.u.setColor(a3.intValue());
        } else if (theme != null) {
            this.u.setColor(AppCompatDelegateImpl.i.X1(context, "colorPrimary"));
        } else {
            this.u.setColor(-1);
        }
        TapTarget tapTarget3 = this.q;
        Integer a4 = tapTarget3.a(context, tapTarget3.o, tapTarget3.j);
        if (a4 != null) {
            this.w.setColor(a4.intValue());
        } else {
            this.w.setColor(this.C ? ViewCompat.MEASURED_STATE_MASK : -1);
        }
        if (this.q.A) {
            this.w.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        }
        this.x.setColor(this.w.getColor());
        TapTarget tapTarget4 = this.q;
        Integer a5 = tapTarget4.a(context, tapTarget4.p, tapTarget4.k);
        if (a5 != null) {
            int intValue = a5.intValue();
            this.b0 = (intValue & ViewCompat.MEASURED_SIZE_MASK) | (((int) (((float) (intValue >>> 24)) * 0.3f)) << 24);
        } else {
            this.b0 = -1;
        }
        TapTarget tapTarget5 = this.q;
        Integer a6 = tapTarget5.a(context, tapTarget5.q, tapTarget5.l);
        if (a6 != null) {
            this.s.setColor(a6.intValue());
        } else {
            TextPaint textPaint = this.s;
            if (this.C) {
                i2 = ViewCompat.MEASURED_STATE_MASK;
            }
            textPaint.setColor(i2);
        }
        TapTarget tapTarget6 = this.q;
        Integer a8 = tapTarget6.a(context, tapTarget6.r, tapTarget6.m);
        if (a8 != null) {
            this.t.setColor(a8.intValue());
        } else {
            this.t.setColor(this.s.getColor());
        }
        Typeface typeface = this.q.g;
        if (typeface != null) {
            this.s.setTypeface(typeface);
        }
        Typeface typeface2 = this.q.h;
        if (typeface2 != null) {
            this.t.setTypeface(typeface2);
        }
    }

    public double b(int i2, int i3, int i4, int i5) {
        return Math.sqrt(Math.pow((double) (i5 - i3), 2.0d) + Math.pow((double) (i4 - i2), 2.0d));
    }

    public void c(Rect rect) {
        invalidate(rect);
        if (this.i0 != null) {
            invalidateOutline();
        }
    }

    public int d(int i2, int i3, Rect rect) {
        return (int) Math.max(b(i2, i3, rect.left, rect.top), Math.max(b(i2, i3, rect.right, rect.top), Math.max(b(i2, i3, rect.left, rect.bottom), b(i2, i3, rect.right, rect.bottom))));
    }

    public void dismiss(boolean z2) {
        this.b = true;
        this.l0.cancel();
        this.k0.cancel();
        if (!this.H || this.R == null) {
            e(z2);
            ViewManager viewManager = this.p;
            if (viewManager != null) {
                try {
                    viewManager.removeView(this);
                } catch (Exception unused) {
                }
            }
        } else if (z2) {
            this.n0.start();
        } else {
            this.m0.start();
        }
    }

    public void e(boolean z2) {
        if (!this.a) {
            this.b = false;
            this.a = true;
            ValueAnimator[] valueAnimatorArr = this.o0;
            for (ValueAnimator valueAnimator : valueAnimatorArr) {
                valueAnimator.cancel();
                valueAnimator.removeAllUpdateListeners();
            }
            getViewTreeObserver().removeOnGlobalLayoutListener(this.p0);
            this.H = false;
            Listener listener = this.h0;
            if (listener != null) {
                listener.onTargetDismissed(this, z2);
            }
        }
    }

    public int[] getOuterCircleCenterPoint() {
        int i2;
        int i3;
        int centerY = this.r.centerY();
        int i4 = this.f0;
        if (i4 <= 0 ? centerY < this.l || centerY > getHeight() - this.l : centerY < (i3 = this.l) || centerY > i4 - i3) {
            return new int[]{this.r.centerX(), this.r.centerY()};
        }
        int max = (Math.max(this.r.width(), this.r.height()) / 2) + this.d;
        int totalTextHeight = getTotalTextHeight();
        boolean z2 = ((this.r.centerY() - this.e) - this.d) - totalTextHeight > 0;
        int min = Math.min(this.N.left, this.r.left - max);
        int max2 = Math.max(this.N.right, this.r.right + max);
        StaticLayout staticLayout = this.z;
        int height = staticLayout == null ? 0 : staticLayout.getHeight();
        if (z2) {
            i2 = (((this.r.centerY() - this.e) - this.d) - totalTextHeight) + height;
        } else {
            i2 = this.r.centerY() + this.e + this.d + height;
        }
        return new int[]{(min + max2) / 2, i2};
    }

    public Rect getTextBounds() {
        int totalTextHeight = getTotalTextHeight();
        int totalTextWidth = getTotalTextWidth();
        int centerY = ((this.r.centerY() - this.e) - this.d) - totalTextHeight;
        if (centerY <= this.e0) {
            centerY = this.r.centerY() + this.e + this.d;
        }
        int max = Math.max(this.g, (this.r.centerX() - ((getWidth() / 2) - this.r.centerX() < 0 ? -this.j : this.j)) - totalTextWidth);
        return new Rect(max, centerY, Math.min(getWidth() - this.g, totalTextWidth + max), totalTextHeight + centerY);
    }

    public int getTotalTextHeight() {
        StaticLayout staticLayout = this.z;
        if (staticLayout == null) {
            return 0;
        }
        if (this.B == null) {
            return staticLayout.getHeight() + this.h;
        }
        return this.B.getHeight() + staticLayout.getHeight() + this.h;
    }

    public int getTotalTextWidth() {
        StaticLayout staticLayout = this.z;
        if (staticLayout == null) {
            return 0;
        }
        if (this.B == null) {
            return staticLayout.getWidth();
        }
        return Math.max(staticLayout.getWidth(), this.B.getWidth());
    }

    public boolean isVisible() {
        return !this.a && this.H;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e(false);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        StaticLayout staticLayout;
        if (!(this.a || this.R == null)) {
            int i2 = this.e0;
            if (i2 > 0 && this.f0 > 0) {
                canvas.clipRect(0, i2, getWidth(), this.f0);
            }
            int i3 = this.b0;
            if (i3 != -1) {
                canvas.drawColor(i3);
            }
            this.u.setAlpha(this.S);
            if (this.F && this.i0 == null) {
                int save = canvas.save();
                canvas.clipPath(this.O, Region.Op.DIFFERENCE);
                float f2 = ((float) this.S) * 0.2f;
                this.v.setStyle(Paint.Style.FILL_AND_STROKE);
                this.v.setAlpha((int) f2);
                int[] iArr = this.R;
                canvas.drawCircle((float) iArr[0], (float) (iArr[1] + this.m), this.P, this.v);
                this.v.setStyle(Paint.Style.STROKE);
                for (int i4 = 6; i4 > 0; i4--) {
                    this.v.setAlpha((int) ((((float) i4) / 7.0f) * f2));
                    int[] iArr2 = this.R;
                    canvas.drawCircle((float) iArr2[0], (float) (iArr2[1] + this.m), this.P + ((float) ((7 - i4) * this.n)), this.v);
                }
                canvas.restoreToCount(save);
            }
            int[] iArr3 = this.R;
            canvas.drawCircle((float) iArr3[0], (float) iArr3[1], this.P, this.u);
            this.w.setAlpha(this.W);
            int i5 = this.U;
            if (i5 > 0) {
                this.x.setAlpha(i5);
                canvas.drawCircle((float) this.r.centerX(), (float) this.r.centerY(), this.T, this.x);
            }
            canvas.drawCircle((float) this.r.centerX(), (float) this.r.centerY(), this.V, this.w);
            int save2 = canvas.save();
            Rect rect = this.N;
            canvas.translate((float) rect.left, (float) rect.top);
            this.s.setAlpha(this.a0);
            StaticLayout staticLayout2 = this.z;
            if (staticLayout2 != null) {
                staticLayout2.draw(canvas);
            }
            if (!(this.B == null || (staticLayout = this.z) == null)) {
                canvas.translate(0.0f, (float) (staticLayout.getHeight() + this.h));
                this.t.setAlpha((int) (this.q.B * ((float) this.a0)));
                this.B.draw(canvas);
            }
            canvas.restoreToCount(save2);
            int save3 = canvas.save();
            if (this.g0 != null) {
                canvas.translate((float) (this.r.centerX() - (this.g0.getWidth() / 2)), (float) (this.r.centerY() - (this.g0.getHeight() / 2)));
                canvas.drawBitmap(this.g0, 0.0f, 0.0f, this.w);
            } else if (this.q.f != null) {
                canvas.translate((float) (this.r.centerX() - (this.q.f.getBounds().width() / 2)), (float) (this.r.centerY() - (this.q.f.getBounds().height() / 2)));
                this.q.f.setAlpha(this.w.getAlpha());
                this.q.f.draw(canvas);
            }
            canvas.restoreToCount(save3);
            if (this.D) {
                if (this.L == null) {
                    Paint paint = new Paint();
                    this.L = paint;
                    paint.setARGB(255, 255, 0, 0);
                    this.L.setStyle(Paint.Style.STROKE);
                    this.L.setStrokeWidth((float) AppCompatDelegateImpl.i.e0(getContext(), 1));
                }
                if (this.K == null) {
                    TextPaint textPaint = new TextPaint();
                    this.K = textPaint;
                    textPaint.setColor(SupportMenu.CATEGORY_MASK);
                    this.K.setTextSize((float) ((int) TypedValue.applyDimension(2, (float) 16, getContext().getResources().getDisplayMetrics())));
                }
                this.L.setStyle(Paint.Style.STROKE);
                canvas.drawRect(this.N, this.L);
                canvas.drawRect(this.r, this.L);
                int[] iArr4 = this.R;
                canvas.drawCircle((float) iArr4[0], (float) iArr4[1], 10.0f, this.L);
                int[] iArr5 = this.R;
                canvas.drawCircle((float) iArr5[0], (float) iArr5[1], (float) (this.Q - this.k), this.L);
                canvas.drawCircle((float) this.r.centerX(), (float) this.r.centerY(), (float) (this.e + this.d), this.L);
                this.L.setStyle(Paint.Style.FILL);
                String str = "Text bounds: " + this.N.toShortString() + "\nTarget bounds: " + this.r.toShortString() + "\nCenter: " + this.R[0] + " " + this.R[1] + "\nView size: " + getWidth() + " " + getHeight() + "\nTarget bounds: " + this.r.toShortString();
                SpannableStringBuilder spannableStringBuilder = this.I;
                if (spannableStringBuilder == null) {
                    this.I = new SpannableStringBuilder(str);
                } else {
                    spannableStringBuilder.clear();
                    this.I.append((CharSequence) str);
                }
                if (this.J == null) {
                    this.J = new DynamicLayout(str, this.K, getWidth(), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                }
                int save4 = canvas.save();
                this.L.setARGB(220, 0, 0, 0);
                canvas.translate(0.0f, (float) this.e0);
                canvas.drawRect(0.0f, 0.0f, (float) this.J.getWidth(), (float) this.J.getHeight(), this.L);
                this.L.setARGB(255, 255, 0, 0);
                this.J.draw(canvas);
                canvas.restoreToCount(save4);
            }
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (!isVisible() || !this.G || i2 != 4) {
            return false;
        }
        keyEvent.startTracking();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (!isVisible() || !this.c || !this.G || i2 != 4 || !keyEvent.isTracking() || keyEvent.isCanceled()) {
            return false;
        }
        this.c = false;
        Listener listener = this.h0;
        if (listener != null) {
            listener.onTargetCancel(this);
            return true;
        }
        new Listener().onTargetCancel(this);
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.c0 = motionEvent.getX();
        this.d0 = motionEvent.getY();
        return super.onTouchEvent(motionEvent);
    }

    public void setDrawDebug(boolean z2) {
        if (this.D != z2) {
            this.D = z2;
            postInvalidate();
        }
    }

    public static TapTargetView showFor(Activity activity, TapTarget tapTarget, Listener listener) {
        if (activity != null) {
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            TapTargetView tapTargetView = new TapTargetView(activity, viewGroup, (ViewGroup) viewGroup.findViewById(16908290), tapTarget, listener);
            viewGroup.addView(tapTargetView, layoutParams);
            return tapTargetView;
        }
        throw new IllegalArgumentException("Activity is null");
    }

    public static TapTargetView showFor(Dialog dialog, TapTarget tapTarget) {
        return showFor(dialog, tapTarget, (Listener) null);
    }

    public static TapTargetView showFor(Dialog dialog, TapTarget tapTarget, Listener listener) {
        if (dialog != null) {
            Context context = dialog.getContext();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.type = 2;
            layoutParams.format = 1;
            layoutParams.flags = 0;
            layoutParams.gravity = BadgeDrawable.TOP_START;
            layoutParams.x = 0;
            layoutParams.y = 0;
            layoutParams.width = -1;
            layoutParams.height = -1;
            TapTargetView tapTargetView = new TapTargetView(context, windowManager, null, tapTarget, listener);
            windowManager.addView(tapTargetView, layoutParams);
            return tapTargetView;
        }
        throw new IllegalArgumentException("Dialog is null");
    }
}

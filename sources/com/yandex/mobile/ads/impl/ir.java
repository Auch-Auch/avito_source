package com.yandex.mobile.ads.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import com.yandex.mobile.ads.impl.iq;
import com.yandex.mobile.ads.impl.w;
public final class ir {

    public static final class a {
        public static final int a = Color.parseColor("#cc000000");
    }

    public static final class b {
        public static final GradientDrawable a;
        public static final ColorDrawable b = new ColorDrawable(Color.parseColor("#ff000000"));
        public static final GradientDrawable c;

        static {
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.parseColor("#ff303030"), Color.parseColor("#ff181818"), Color.parseColor("#ff000000")});
            gradientDrawable.setCornerRadius(0.0f);
            a = gradientDrawable;
            GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.parseColor("#ff949494"), Color.parseColor("#ff5a5f62")});
            gradientDrawable2.setCornerRadius(0.0f);
            c = gradientDrawable2;
        }
    }

    public static final class c {
        @NonNull
        public static RelativeLayout a(@NonNull Context context) {
            RelativeLayout relativeLayout = new RelativeLayout(context);
            relativeLayout.setBackgroundColor(0);
            return relativeLayout;
        }

        @NonNull
        public static RelativeLayout b(@NonNull Context context) {
            RelativeLayout relativeLayout = new RelativeLayout(context);
            relativeLayout.setBackgroundDrawable(b.c);
            return relativeLayout;
        }
    }

    public static class f extends RelativeLayout {
        private boolean a = true;
        private boolean b = false;
        private long c = 500;
        private RelativeLayout d;
        private RelativeLayout e;
        private Interpolator f;
        private Interpolator g;
        private float h;
        private float i;
        private float j;

        public final class a implements Animation.AnimationListener {
            private a() {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationEnd(Animation animation) {
                f.this.b = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationStart(Animation animation) {
            }

            public /* synthetic */ a(f fVar, byte b) {
                this();
            }
        }

        public final class b implements Animation.AnimationListener {
            private boolean b;

            public b(boolean z) {
                this.b = z;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationEnd(Animation animation) {
                f.a(f.this, this.b);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationStart(Animation animation) {
            }
        }

        public f(Context context) {
            super(context);
            setBackgroundColor(0);
        }

        public final void setAnimationDuration(long j2) {
            this.c = j2 / 2;
        }

        public final void setBackFace(RelativeLayout relativeLayout, RelativeLayout.LayoutParams layoutParams) {
            RelativeLayout relativeLayout2 = this.e;
            if (relativeLayout2 != null) {
                removeView(relativeLayout2);
            }
            this.e = relativeLayout;
            if (relativeLayout != null) {
                addView(relativeLayout, layoutParams);
                this.e.setVisibility(this.a ? 4 : 0);
            }
        }

        public final void setDepthZ(float f2) {
            this.j = f2;
        }

        public final void setFromInterpolator(Interpolator interpolator) {
            this.f = interpolator;
        }

        public final void setFrontFace(RelativeLayout relativeLayout, RelativeLayout.LayoutParams layoutParams) {
            RelativeLayout relativeLayout2 = this.d;
            if (relativeLayout2 != null) {
                removeView(relativeLayout2);
            }
            this.d = relativeLayout;
            if (relativeLayout != null) {
                addView(relativeLayout, layoutParams);
                this.d.setVisibility(this.a ? 0 : 4);
            }
        }

        public final void setPivot(float f2, float f3) {
            this.h = f2;
            this.i = f3;
        }

        public final void setToInterpolator(Interpolator interpolator) {
            this.g = interpolator;
        }

        public final void a() {
            int i2 = this.a ? 1 : -1;
            this.b = true;
            iq.b bVar = new iq.b(0.0f, (float) (i2 * 90), this.h, this.i, this.j, 0.0f);
            bVar.setDuration(this.c);
            bVar.setFillAfter(true);
            bVar.setInterpolator(this.f);
            bVar.setAnimationListener(new b(this.a));
            if (this.a) {
                this.d.startAnimation(bVar);
            } else {
                this.e.startAnimation(bVar);
            }
            this.a = !this.a;
        }

        public static /* synthetic */ void a(f fVar, boolean z) {
            iq.b bVar;
            if (z) {
                fVar.d.setVisibility(4);
                fVar.e.setVisibility(0);
                fVar.e.requestFocus();
                bVar = new iq.b(-90.0f, 0.0f, fVar.h, fVar.i, fVar.j, 1.0f);
            } else {
                fVar.e.setVisibility(4);
                fVar.d.setVisibility(0);
                fVar.d.requestFocus();
                bVar = new iq.b(90.0f, 0.0f, fVar.h, fVar.i, fVar.j, 1.0f);
            }
            bVar.setDuration(fVar.c);
            bVar.setFillAfter(true);
            bVar.setInterpolator(fVar.g);
            bVar.setAnimationListener(new a(fVar, (byte) 0));
            if (z) {
                fVar.e.startAnimation(bVar);
            } else {
                fVar.d.startAnimation(bVar);
            }
        }
    }

    public static final class g {
        @NonNull
        public static View a(@NonNull Context context) {
            e eVar = new e(context);
            FrameLayout frameLayout = new FrameLayout(context);
            int a = dv.a(context, 25.0f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a, a);
            layoutParams.gravity = 17;
            int a3 = dv.a(context, 10.0f);
            layoutParams.setMargins(a3, a3, a3, a3);
            frameLayout.addView(eVar, layoutParams);
            eVar.setTag(ef.a("close_button"));
            eVar.g = 1.0f;
            eVar.invalidate();
            return frameLayout;
        }
    }

    public static class e extends View {
        public Paint a;
        public Paint b;
        public Paint c;
        public int d;
        public int e;
        public int f;
        public float g;

        private e(Context context, Integer num) {
            super(context);
            int i = a.a;
            this.d = i;
            this.e = i;
            this.f = -1;
            this.g = -1.0f;
            if (num != null) {
                this.e = num.intValue();
                a(num.intValue());
            }
            Paint paint = new Paint(0);
            this.a = paint;
            paint.setAntiAlias(true);
            this.a.setStyle(Paint.Style.FILL);
            Paint paint2 = new Paint(0);
            this.b = paint2;
            paint2.setAntiAlias(true);
            this.b.setStrokeWidth(2.0f);
            this.b.setStyle(Paint.Style.STROKE);
            Paint paint3 = new Paint(0);
            this.c = paint3;
            paint3.setAntiAlias(true);
            this.c.setStyle(Paint.Style.STROKE);
            a();
        }

        private void a(int i) {
            int a3 = eg.a(i, 20.0f);
            this.d = a3;
            if (eg.a(a3)) {
                this.f = -1;
            } else {
                this.f = ViewCompat.MEASURED_STATE_MASK;
            }
        }

        private void b(int i) {
            a(i);
            a();
            invalidate();
        }

        @Override // android.view.View
        public final void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawColor(0);
            float min = (float) Math.min(getWidth(), getHeight());
            float f2 = min / 2.0f;
            canvas.drawCircle(f2, f2, f2, this.a);
            float f3 = min / 5.0f;
            float f4 = f2 - f3;
            float f5 = f3 + f2;
            canvas.drawLine(f4, f4, f5, f5, this.b);
            canvas.drawLine(f4, f5, f5, f4, this.b);
            float f6 = this.g;
            if (f6 > 0.0f) {
                this.c.setStrokeWidth(f6);
                canvas.drawCircle(f2, f2, f2 - this.g, this.c);
            }
        }

        @Override // android.view.View
        @SuppressLint({"ClickableViewAccessibility"})
        public final boolean onTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                b(w.a.a);
            } else if (1 == motionEvent.getAction()) {
                b(this.e);
            }
            return super.onTouchEvent(motionEvent);
        }

        @Override // android.view.View
        public final void setBackgroundColor(int i) {
            this.e = i;
            a(i);
            a();
            invalidate();
        }

        private void a() {
            this.a.setColor(this.d);
            this.b.setColor(this.f);
            this.c.setColor(this.f);
        }

        public e(Context context) {
            this(context, Integer.valueOf(a.a));
        }
    }

    public static final class d {
        @NonNull
        public static RelativeLayout.LayoutParams a(@NonNull Context context, @Nullable am amVar) {
            RelativeLayout.LayoutParams layoutParams;
            if (amVar != null) {
                layoutParams = a(context, amVar.b(context), amVar.a(context));
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            }
            layoutParams.addRule(13);
            return layoutParams;
        }

        @NonNull
        public static RelativeLayout.LayoutParams b(@NonNull Context context, @NonNull x xVar) {
            RelativeLayout.LayoutParams a = a(context, xVar);
            int a3 = dv.a(context, 45.0f);
            a.width = Math.min(a.width + a3, eg.a(context));
            a.height = Math.min(a.height + a3, eg.b(context));
            return a;
        }

        @NonNull
        public static RelativeLayout.LayoutParams a(@NonNull Context context, @Nullable x xVar) {
            RelativeLayout.LayoutParams a = xVar != null ? a(context, xVar.q(), xVar.r()) : new RelativeLayout.LayoutParams(-2, -2);
            a.addRule(13);
            return a;
        }

        public static RelativeLayout.LayoutParams a() {
            return new RelativeLayout.LayoutParams(-1, -1);
        }

        @NonNull
        public static RelativeLayout.LayoutParams a(@NonNull Context context, @NonNull View view) {
            int a = dv.a(context, 25.0f);
            int a3 = dv.a(context, 45.0f);
            int i = a3 >> 1;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a3, a3);
            layoutParams.addRule(7, view.getId());
            layoutParams.addRule(6, view.getId());
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            int i2 = layoutParams2.width;
            boolean z = true;
            boolean z2 = i2 == -1 || i2 + a >= eg.a(context);
            int i3 = layoutParams2.height;
            if (i3 != -1 && i3 + a < eg.b(context)) {
                z = false;
            }
            int i4 = (a >> 1) - ((a3 - a) / 2);
            if (!z2 && !z) {
                i4 = -i;
            }
            layoutParams.setMargins(0, i4, i4, 0);
            return layoutParams;
        }

        @NonNull
        private static RelativeLayout.LayoutParams a(@NonNull Context context, int i, int i2) {
            return new RelativeLayout.LayoutParams(dv.a(context, (float) i), dv.a(context, (float) i2));
        }
    }
}

package com.google.android.material.transition;

import a2.j.b.d.v.f;
import a2.j.b.d.v.g;
import a2.j.b.d.v.i;
import a2.j.b.d.v.j;
import a2.j.b.d.v.k;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.transition.PathMotion;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.maps.android.heatmaps.WeightedLatLng;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;
import java.util.Objects;
public final class MaterialContainerTransform extends Transition {
    public static final int FADE_MODE_CROSS = 2;
    public static final int FADE_MODE_IN = 0;
    public static final int FADE_MODE_OUT = 1;
    public static final int FADE_MODE_THROUGH = 3;
    public static final int FIT_MODE_AUTO = 0;
    public static final int FIT_MODE_HEIGHT = 2;
    public static final int FIT_MODE_WIDTH = 1;
    public static final int TRANSITION_DIRECTION_AUTO = 0;
    public static final int TRANSITION_DIRECTION_ENTER = 1;
    public static final int TRANSITION_DIRECTION_RETURN = 2;
    public static final String j0 = MaterialContainerTransform.class.getSimpleName();
    public static final String[] k0 = {"materialContainerTransition:bounds", "materialContainerTransition:shapeAppearance"};
    public static final c l0 = new c(new ProgressThresholds(0.0f, 0.25f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 0.75f), null);
    public static final c m0 = new c(new ProgressThresholds(0.6f, 0.9f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.3f, 0.9f), null);
    public static final c n0 = new c(new ProgressThresholds(0.1f, 0.4f), new ProgressThresholds(0.1f, 1.0f), new ProgressThresholds(0.1f, 1.0f), new ProgressThresholds(0.1f, 0.9f), null);
    public static final c o0 = new c(new ProgressThresholds(0.6f, 0.9f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.2f, 0.9f), null);
    public boolean J = false;
    public boolean K = false;
    @IdRes
    public int L = 16908290;
    @IdRes
    public int M = -1;
    @IdRes
    public int N = -1;
    @ColorInt
    public int O = 0;
    @ColorInt
    public int P = 0;
    @ColorInt
    public int Q = 0;
    @ColorInt
    public int R = 1375731712;
    public int S = 0;
    public int T = 0;
    public int U = 0;
    @Nullable
    public View V;
    @Nullable
    public View W;
    @Nullable
    public ShapeAppearanceModel a0;
    @Nullable
    public ShapeAppearanceModel b0;
    @Nullable
    public ProgressThresholds c0;
    @Nullable
    public ProgressThresholds d0;
    @Nullable
    public ProgressThresholds e0;
    @Nullable
    public ProgressThresholds f0;
    public boolean g0;
    public float h0;
    public float i0;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface FadeMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface FitMode {
    }

    public static class ProgressThresholds {
        @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
        public final float a;
        @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
        public final float b;

        public ProgressThresholds(@FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
            this.a = f;
            this.b = f2;
        }

        @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
        public float getEnd() {
            return this.b;
        }

        @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
        public float getStart() {
            return this.a;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface TransitionDirection {
    }

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ d a;

        public a(MaterialContainerTransform materialContainerTransform, d dVar) {
            this.a = dVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            d dVar = this.a;
            float animatedFraction = valueAnimator.getAnimatedFraction();
            if (dVar.L != animatedFraction) {
                dVar.e(animatedFraction);
            }
        }
    }

    public class b extends i {
        public final /* synthetic */ View a;
        public final /* synthetic */ d b;
        public final /* synthetic */ View c;
        public final /* synthetic */ View d;

        public b(View view, d dVar, View view2, View view3) {
            this.a = view;
            this.b = dVar;
            this.c = view2;
            this.d = view3;
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition transition) {
            MaterialContainerTransform.this.removeListener(this);
            if (!MaterialContainerTransform.this.K) {
                this.c.setAlpha(1.0f);
                this.d.setAlpha(1.0f);
                ViewUtils.getOverlay(this.a).remove(this.b);
            }
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionStart(@NonNull Transition transition) {
            ViewUtils.getOverlay(this.a).add(this.b);
            this.c.setAlpha(0.0f);
            this.d.setAlpha(0.0f);
        }
    }

    public static class c {
        @NonNull
        public final ProgressThresholds a;
        @NonNull
        public final ProgressThresholds b;
        @NonNull
        public final ProgressThresholds c;
        @NonNull
        public final ProgressThresholds d;

        public c(ProgressThresholds progressThresholds, ProgressThresholds progressThresholds2, ProgressThresholds progressThresholds3, ProgressThresholds progressThresholds4, a aVar) {
            this.a = progressThresholds;
            this.b = progressThresholds2;
            this.c = progressThresholds3;
            this.d = progressThresholds4;
        }
    }

    public static final class d extends Drawable {
        public final c A;
        public final a2.j.b.d.v.a B;
        public final a2.j.b.d.v.d C;
        public final boolean D;
        public final Paint E;
        public final Path F;
        public a2.j.b.d.v.c G;
        public f H;
        public RectF I;
        public float J;
        public float K;
        public float L;
        public final View a;
        public final RectF b;
        public final ShapeAppearanceModel c;
        public final float d;
        public final View e;
        public final RectF f;
        public final ShapeAppearanceModel g;
        public final float h;
        public final Paint i;
        public final Paint j;
        public final Paint k;
        public final Paint l = new Paint();
        public final Paint m;
        public final g n;
        public final PathMeasure o;
        public final float p;
        public final float[] q;
        public final boolean r;
        public final float s;
        public final float t;
        public final boolean u;
        public final MaterialShapeDrawable v;
        public final RectF w;
        public final RectF x;
        public final RectF y;
        public final RectF z;

        public class a implements k.a {
            public a() {
            }

            @Override // a2.j.b.d.v.k.a
            public void a(Canvas canvas) {
                d.this.a.draw(canvas);
            }
        }

        public class b implements k.a {
            public b() {
            }

            @Override // a2.j.b.d.v.k.a
            public void a(Canvas canvas) {
                d.this.e.draw(canvas);
            }
        }

        public d(PathMotion pathMotion, View view, RectF rectF, ShapeAppearanceModel shapeAppearanceModel, float f2, View view2, RectF rectF2, ShapeAppearanceModel shapeAppearanceModel2, float f3, int i2, int i3, int i4, int i5, boolean z2, boolean z3, a2.j.b.d.v.a aVar, a2.j.b.d.v.d dVar, c cVar, boolean z4, a aVar2) {
            Paint paint = new Paint();
            this.i = paint;
            Paint paint2 = new Paint();
            this.j = paint2;
            Paint paint3 = new Paint();
            this.k = paint3;
            Paint paint4 = new Paint();
            this.m = paint4;
            this.n = new g();
            float[] fArr = new float[2];
            this.q = fArr;
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
            this.v = materialShapeDrawable;
            Paint paint5 = new Paint();
            this.E = paint5;
            this.F = new Path();
            this.a = view;
            this.b = rectF;
            this.c = shapeAppearanceModel;
            this.d = f2;
            this.e = view2;
            this.f = rectF2;
            this.g = shapeAppearanceModel2;
            this.h = f3;
            this.r = z2;
            this.u = z3;
            this.B = aVar;
            this.C = dVar;
            this.A = cVar;
            this.D = z4;
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            this.s = (float) displayMetrics.widthPixels;
            this.t = (float) displayMetrics.heightPixels;
            paint.setColor(i2);
            paint2.setColor(i3);
            paint3.setColor(i4);
            materialShapeDrawable.setFillColor(ColorStateList.valueOf(0));
            materialShapeDrawable.setShadowCompatibilityMode(2);
            materialShapeDrawable.setShadowBitmapDrawingEnable(false);
            materialShapeDrawable.setShadowColor(-7829368);
            RectF rectF3 = new RectF(rectF);
            this.w = rectF3;
            this.x = new RectF(rectF3);
            RectF rectF4 = new RectF(rectF3);
            this.y = rectF4;
            this.z = new RectF(rectF4);
            PointF c2 = c(rectF);
            PointF c3 = c(rectF2);
            PathMeasure pathMeasure = new PathMeasure(pathMotion.getPath(c2.x, c2.y, c3.x, c3.y), false);
            this.o = pathMeasure;
            this.p = pathMeasure.getLength();
            fArr[0] = rectF.centerX();
            fArr[1] = rectF.top;
            paint4.setStyle(Paint.Style.FILL);
            RectF rectF5 = k.a;
            paint4.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, 0.0f, i5, i5, Shader.TileMode.CLAMP));
            paint5.setStyle(Paint.Style.STROKE);
            paint5.setStrokeWidth(10.0f);
            e(0.0f);
        }

        public static PointF c(RectF rectF) {
            return new PointF(rectF.centerX(), rectF.top);
        }

        public final void a(Canvas canvas) {
            d(canvas, this.k);
            Rect bounds = getBounds();
            RectF rectF = this.y;
            k.h(canvas, bounds, rectF.left, rectF.top, this.H.b, this.G.b, new b());
        }

        public final void b(Canvas canvas) {
            d(canvas, this.j);
            Rect bounds = getBounds();
            RectF rectF = this.w;
            k.h(canvas, bounds, rectF.left, rectF.top, this.H.a, this.G.a, new a());
        }

        public final void d(Canvas canvas, Paint paint) {
            if (paint.getColor() != 0 && paint.getAlpha() > 0) {
                canvas.drawRect(getBounds(), paint);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(@NonNull Canvas canvas) {
            if (this.m.getAlpha() > 0) {
                canvas.drawRect(getBounds(), this.m);
            }
            int save = this.D ? canvas.save() : -1;
            if (this.u && this.J > 0.0f) {
                canvas.save();
                canvas.clipPath(this.n.a, Region.Op.DIFFERENCE);
                if (Build.VERSION.SDK_INT > 28) {
                    ShapeAppearanceModel shapeAppearanceModel = this.n.e;
                    if (shapeAppearanceModel.isRoundRect(this.I)) {
                        float cornerSize = shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(this.I);
                        canvas.drawRoundRect(this.I, cornerSize, cornerSize, this.l);
                    } else {
                        canvas.drawPath(this.n.a, this.l);
                    }
                } else {
                    MaterialShapeDrawable materialShapeDrawable = this.v;
                    RectF rectF = this.I;
                    materialShapeDrawable.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                    this.v.setElevation(this.J);
                    this.v.setShadowVerticalOffset((int) this.K);
                    this.v.setShapeAppearanceModel(this.n.e);
                    this.v.draw(canvas);
                }
                canvas.restore();
            }
            g gVar = this.n;
            if (Build.VERSION.SDK_INT >= 23) {
                canvas.clipPath(gVar.a);
            } else {
                canvas.clipPath(gVar.b);
                canvas.clipPath(gVar.c, Region.Op.UNION);
            }
            d(canvas, this.i);
            if (this.G.c) {
                b(canvas);
                a(canvas);
            } else {
                a(canvas);
                b(canvas);
            }
            if (this.D) {
                canvas.restoreToCount(save);
                RectF rectF2 = this.w;
                Path path = this.F;
                PointF c2 = c(rectF2);
                if (this.L == 0.0f) {
                    path.reset();
                    path.moveTo(c2.x, c2.y);
                } else {
                    path.lineTo(c2.x, c2.y);
                    this.E.setColor(-65281);
                    canvas.drawPath(path, this.E);
                }
                RectF rectF3 = this.x;
                this.E.setColor(InputDeviceCompat.SOURCE_ANY);
                canvas.drawRect(rectF3, this.E);
                RectF rectF4 = this.w;
                this.E.setColor(-16711936);
                canvas.drawRect(rectF4, this.E);
                RectF rectF5 = this.z;
                this.E.setColor(-16711681);
                canvas.drawRect(rectF5, this.E);
                RectF rectF6 = this.y;
                this.E.setColor(-16776961);
                canvas.drawRect(rectF6, this.E);
            }
        }

        public final void e(float f2) {
            float f3;
            float f4;
            this.L = f2;
            this.m.setAlpha((int) (this.r ? k.d(0.0f, 255.0f, f2) : k.d(255.0f, 0.0f, f2)));
            this.o.getPosTan(this.p * f2, this.q, null);
            float[] fArr = this.q;
            boolean z2 = false;
            float f5 = fArr[0];
            float f6 = fArr[1];
            int i2 = (f2 > 1.0f ? 1 : (f2 == 1.0f ? 0 : -1));
            if (i2 > 0 || f2 < 0.0f) {
                if (i2 > 0) {
                    f4 = 0.99f;
                    f3 = (f2 - 1.0f) / 0.00999999f;
                } else {
                    f4 = 0.01f;
                    f3 = (f2 / 0.01f) * -1.0f;
                }
                this.o.getPosTan(this.p * f4, fArr, null);
                float[] fArr2 = this.q;
                float f7 = fArr2[0];
                float f8 = fArr2[1];
                f5 = a2.b.a.a.a.b(f5, f7, f3, f5);
                f6 = a2.b.a.a.a.b(f6, f8, f3, f6);
            }
            f a3 = this.C.a(f2, ((Float) Preconditions.checkNotNull(Float.valueOf(this.A.b.a))).floatValue(), ((Float) Preconditions.checkNotNull(Float.valueOf(this.A.b.b))).floatValue(), this.b.width(), this.b.height(), this.f.width(), this.f.height());
            this.H = a3;
            RectF rectF = this.w;
            float f9 = a3.c / 2.0f;
            rectF.set(f5 - f9, f6, f9 + f5, a3.d + f6);
            RectF rectF2 = this.y;
            f fVar = this.H;
            float f10 = fVar.e / 2.0f;
            rectF2.set(f5 - f10, f6, f10 + f5, fVar.f + f6);
            this.x.set(this.w);
            this.z.set(this.y);
            float floatValue = ((Float) Preconditions.checkNotNull(Float.valueOf(this.A.c.a))).floatValue();
            float floatValue2 = ((Float) Preconditions.checkNotNull(Float.valueOf(this.A.c.b))).floatValue();
            boolean b2 = this.C.b(this.H);
            RectF rectF3 = b2 ? this.x : this.z;
            float e2 = k.e(0.0f, 1.0f, floatValue, floatValue2, f2);
            if (!b2) {
                e2 = 1.0f - e2;
            }
            this.C.c(rectF3, e2, this.H);
            this.I = new RectF(Math.min(this.x.left, this.z.left), Math.min(this.x.top, this.z.top), Math.max(this.x.right, this.z.right), Math.max(this.x.bottom, this.z.bottom));
            g gVar = this.n;
            ShapeAppearanceModel shapeAppearanceModel = this.c;
            ShapeAppearanceModel shapeAppearanceModel2 = this.g;
            RectF rectF4 = this.w;
            RectF rectF5 = this.x;
            RectF rectF6 = this.z;
            ProgressThresholds progressThresholds = this.A.d;
            Objects.requireNonNull(gVar);
            float start = progressThresholds.getStart();
            float end = progressThresholds.getEnd();
            RectF rectF7 = k.a;
            if (f2 >= start) {
                if (f2 > end) {
                    shapeAppearanceModel = shapeAppearanceModel2;
                } else {
                    if (!(shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(rectF4) == 0.0f && shapeAppearanceModel.getTopRightCornerSize().getCornerSize(rectF4) == 0.0f && shapeAppearanceModel.getBottomRightCornerSize().getCornerSize(rectF4) == 0.0f && shapeAppearanceModel.getBottomLeftCornerSize().getCornerSize(rectF4) == 0.0f)) {
                        z2 = true;
                    }
                    shapeAppearanceModel = (z2 ? shapeAppearanceModel : shapeAppearanceModel2).toBuilder().setTopLeftCornerSize(new AbsoluteCornerSize(k.e(shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(rectF4), shapeAppearanceModel2.getTopLeftCornerSize().getCornerSize(rectF6), start, end, f2))).setTopRightCornerSize(new AbsoluteCornerSize(k.e(shapeAppearanceModel.getTopRightCornerSize().getCornerSize(rectF4), shapeAppearanceModel2.getTopRightCornerSize().getCornerSize(rectF6), start, end, f2))).setBottomLeftCornerSize(new AbsoluteCornerSize(k.e(shapeAppearanceModel.getBottomLeftCornerSize().getCornerSize(rectF4), shapeAppearanceModel2.getBottomLeftCornerSize().getCornerSize(rectF6), start, end, f2))).setBottomRightCornerSize(new AbsoluteCornerSize(k.e(shapeAppearanceModel.getBottomRightCornerSize().getCornerSize(rectF4), shapeAppearanceModel2.getBottomRightCornerSize().getCornerSize(rectF6), start, end, f2))).build();
                }
            }
            gVar.e = shapeAppearanceModel;
            gVar.d.calculatePath(shapeAppearanceModel, 1.0f, rectF5, gVar.b);
            gVar.d.calculatePath(gVar.e, 1.0f, rectF6, gVar.c);
            if (Build.VERSION.SDK_INT >= 23) {
                gVar.a.op(gVar.b, gVar.c, Path.Op.UNION);
            }
            this.J = k.d(this.d, this.h, f2);
            RectF rectF8 = this.I;
            float f11 = this.s;
            RectF rectF9 = this.I;
            float f12 = this.t;
            float f13 = this.J;
            float centerY = (float) ((int) ((rectF9.centerY() / f12) * 1.5f * f13));
            this.K = centerY;
            this.l.setShadowLayer(f13, (float) ((int) (((rectF8.centerX() / (f11 / 2.0f)) - 1.0f) * 0.3f * f13)), centerY, 754974720);
            this.G = this.B.a(f2, ((Float) Preconditions.checkNotNull(Float.valueOf(this.A.a.a))).floatValue(), ((Float) Preconditions.checkNotNull(Float.valueOf(this.A.a.b))).floatValue());
            if (this.j.getColor() != 0) {
                this.j.setAlpha(this.G.a);
            }
            if (this.k.getColor() != 0) {
                this.k.setAlpha(this.G.b);
            }
            invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i2) {
            throw new UnsupportedOperationException("Setting alpha on is not supported");
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(@Nullable ColorFilter colorFilter) {
            throw new UnsupportedOperationException("Setting a color filter is not supported");
        }
    }

    public MaterialContainerTransform() {
        boolean z = false;
        this.g0 = Build.VERSION.SDK_INT >= 28 ? true : z;
        this.h0 = -1.0f;
        this.i0 = -1.0f;
        setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
    }

    public static void o(@NonNull TransitionValues transitionValues, @Nullable View view, @IdRes int i, @Nullable ShapeAppearanceModel shapeAppearanceModel) {
        RectF rectF;
        if (i != -1) {
            View view2 = transitionValues.view;
            RectF rectF2 = k.a;
            View findViewById = view2.findViewById(i);
            if (findViewById == null) {
                findViewById = k.b(view2, i);
            }
            transitionValues.view = findViewById;
        } else if (view != null) {
            transitionValues.view = view;
        } else {
            View view3 = transitionValues.view;
            int i2 = R.id.mtrl_motion_snapshot_view;
            if (view3.getTag(i2) instanceof View) {
                transitionValues.view.setTag(i2, null);
                transitionValues.view = (View) transitionValues.view.getTag(i2);
            }
        }
        View view4 = transitionValues.view;
        if (ViewCompat.isLaidOut(view4) || view4.getWidth() != 0 || view4.getHeight() != 0) {
            if (view4.getParent() == null) {
                RectF rectF3 = k.a;
                rectF = new RectF((float) view4.getLeft(), (float) view4.getTop(), (float) view4.getRight(), (float) view4.getBottom());
            } else {
                rectF = k.c(view4);
            }
            transitionValues.values.put("materialContainerTransition:bounds", rectF);
            Map<String, Object> map = transitionValues.values;
            if (shapeAppearanceModel == null) {
                int i3 = R.id.mtrl_motion_snapshot_view;
                if (view4.getTag(i3) instanceof ShapeAppearanceModel) {
                    shapeAppearanceModel = (ShapeAppearanceModel) view4.getTag(i3);
                } else {
                    Context context = view4.getContext();
                    TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new int[]{R.attr.transitionShapeAppearance});
                    int resourceId = obtainStyledAttributes.getResourceId(0, -1);
                    obtainStyledAttributes.recycle();
                    if (resourceId != -1) {
                        shapeAppearanceModel = ShapeAppearanceModel.builder(context, resourceId, 0).build();
                    } else if (view4 instanceof Shapeable) {
                        shapeAppearanceModel = ((Shapeable) view4).getShapeAppearanceModel();
                    } else {
                        shapeAppearanceModel = ShapeAppearanceModel.builder().build();
                    }
                }
            }
            RectF rectF4 = k.a;
            map.put("materialContainerTransition:shapeAppearance", shapeAppearanceModel.withTransformedCornerSizes(new j(rectF)));
        }
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        o(transitionValues, this.W, this.N, this.b0);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        o(transitionValues, this.V, this.M, this.a0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00cb, code lost:
        if ((r14.height() * r14.width()) > (r10.height() * r10.width())) goto L_0x00cd;
     */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0153  */
    @Override // androidx.transition.Transition
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.animation.Animator createAnimator(@androidx.annotation.NonNull android.view.ViewGroup r30, @androidx.annotation.Nullable androidx.transition.TransitionValues r31, @androidx.annotation.Nullable androidx.transition.TransitionValues r32) {
        /*
        // Method dump skipped, instructions count: 518
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.transition.MaterialContainerTransform.createAnimator(android.view.ViewGroup, androidx.transition.TransitionValues, androidx.transition.TransitionValues):android.animation.Animator");
    }

    @ColorInt
    public int getContainerColor() {
        return this.O;
    }

    @IdRes
    public int getDrawingViewId() {
        return this.L;
    }

    @ColorInt
    public int getEndContainerColor() {
        return this.Q;
    }

    public float getEndElevation() {
        return this.i0;
    }

    @Nullable
    public ShapeAppearanceModel getEndShapeAppearanceModel() {
        return this.b0;
    }

    @Nullable
    public View getEndView() {
        return this.W;
    }

    @IdRes
    public int getEndViewId() {
        return this.N;
    }

    public int getFadeMode() {
        return this.T;
    }

    @Nullable
    public ProgressThresholds getFadeProgressThresholds() {
        return this.c0;
    }

    public int getFitMode() {
        return this.U;
    }

    @Nullable
    public ProgressThresholds getScaleMaskProgressThresholds() {
        return this.e0;
    }

    @Nullable
    public ProgressThresholds getScaleProgressThresholds() {
        return this.d0;
    }

    @ColorInt
    public int getScrimColor() {
        return this.R;
    }

    @Nullable
    public ProgressThresholds getShapeMaskProgressThresholds() {
        return this.f0;
    }

    @ColorInt
    public int getStartContainerColor() {
        return this.P;
    }

    public float getStartElevation() {
        return this.h0;
    }

    @Nullable
    public ShapeAppearanceModel getStartShapeAppearanceModel() {
        return this.a0;
    }

    @Nullable
    public View getStartView() {
        return this.V;
    }

    @IdRes
    public int getStartViewId() {
        return this.M;
    }

    public int getTransitionDirection() {
        return this.S;
    }

    @Override // androidx.transition.Transition
    @Nullable
    public String[] getTransitionProperties() {
        return k0;
    }

    public boolean isDrawDebugEnabled() {
        return this.J;
    }

    public boolean isElevationShadowEnabled() {
        return this.g0;
    }

    public boolean isHoldAtEndEnabled() {
        return this.K;
    }

    public final c p(boolean z, c cVar, c cVar2) {
        if (!z) {
            cVar = cVar2;
        }
        return new c((ProgressThresholds) k.a(this.c0, cVar.a), (ProgressThresholds) k.a(this.d0, cVar.b), (ProgressThresholds) k.a(this.e0, cVar.c), (ProgressThresholds) k.a(this.f0, cVar.d), null);
    }

    public void setAllContainerColors(@ColorInt int i) {
        this.O = i;
        this.P = i;
        this.Q = i;
    }

    public void setContainerColor(@ColorInt int i) {
        this.O = i;
    }

    public void setDrawDebugEnabled(boolean z) {
        this.J = z;
    }

    public void setDrawingViewId(@IdRes int i) {
        this.L = i;
    }

    public void setElevationShadowEnabled(boolean z) {
        this.g0 = z;
    }

    public void setEndContainerColor(@ColorInt int i) {
        this.Q = i;
    }

    public void setEndElevation(float f) {
        this.i0 = f;
    }

    public void setEndShapeAppearanceModel(@Nullable ShapeAppearanceModel shapeAppearanceModel) {
        this.b0 = shapeAppearanceModel;
    }

    public void setEndView(@Nullable View view) {
        this.W = view;
    }

    public void setEndViewId(@IdRes int i) {
        this.N = i;
    }

    public void setFadeMode(int i) {
        this.T = i;
    }

    public void setFadeProgressThresholds(@Nullable ProgressThresholds progressThresholds) {
        this.c0 = progressThresholds;
    }

    public void setFitMode(int i) {
        this.U = i;
    }

    public void setHoldAtEndEnabled(boolean z) {
        this.K = z;
    }

    public void setScaleMaskProgressThresholds(@Nullable ProgressThresholds progressThresholds) {
        this.e0 = progressThresholds;
    }

    public void setScaleProgressThresholds(@Nullable ProgressThresholds progressThresholds) {
        this.d0 = progressThresholds;
    }

    public void setScrimColor(@ColorInt int i) {
        this.R = i;
    }

    public void setShapeMaskProgressThresholds(@Nullable ProgressThresholds progressThresholds) {
        this.f0 = progressThresholds;
    }

    public void setStartContainerColor(@ColorInt int i) {
        this.P = i;
    }

    public void setStartElevation(float f) {
        this.h0 = f;
    }

    public void setStartShapeAppearanceModel(@Nullable ShapeAppearanceModel shapeAppearanceModel) {
        this.a0 = shapeAppearanceModel;
    }

    public void setStartView(@Nullable View view) {
        this.V = view;
    }

    public void setStartViewId(@IdRes int i) {
        this.M = i;
    }

    public void setTransitionDirection(int i) {
        this.S = i;
    }
}

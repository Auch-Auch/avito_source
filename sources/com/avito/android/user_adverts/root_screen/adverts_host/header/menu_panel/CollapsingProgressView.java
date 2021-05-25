package com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel;

import a2.a.a.i3.c.a.i.e.c;
import a2.g.r.g;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.user_adverts.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.GlobalAnimationsKt;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\be\u0010fB\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\be\u0010\bJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\u000eJ+\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u00102\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J7\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0015H\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cH\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0006H\u0014¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\"\u0010!J\r\u0010#\u001a\u00020\u0006¢\u0006\u0004\b#\u0010!J\r\u0010$\u001a\u00020\u0006¢\u0006\u0004\b$\u0010!J\r\u0010%\u001a\u00020\u0006¢\u0006\u0004\b%\u0010!J\r\u0010&\u001a\u00020\u0006¢\u0006\u0004\b&\u0010!R\u0016\u0010\f\u001a\u00020\t8B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u0010.R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010;\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u001c\u0010D\u001a\b\u0012\u0004\u0012\u00020A0@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u001c\u0010H\u001a\u00020\t8B@\u0002X\u000e¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010(R\u0016\u0010J\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bI\u0010FR\u0016\u0010&\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bK\u0010.R\u0016\u0010M\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bL\u0010:R\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010S\u001a\u00020A8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010RR\u0016\u0010U\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bT\u0010FR\u0016\u0010V\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010:R\u0016\u0010X\u001a\u00020N8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bW\u0010PR\u0016\u0010Z\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bY\u0010FR\u0016\u0010\\\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b[\u0010FR*\u0010d\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010]8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010c¨\u0006g"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/header/menu_panel/CollapsingProgressView;", "Landroid/view/View;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "c", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "distanceFromCenter", "angleDegrees", "circleRadius", AuthSource.SEND_ABUSE, "(FFF)V", "angle", "Lkotlin/Pair;", AuthSource.BOOKING_ORDER, "(FF)Lkotlin/Pair;", "", "changed", "", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "top", "right", "bottom", "onLayout", "(ZIIII)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "onDetachedFromWindow", "()V", "onAttachedToWindow", "prepareAnimation", "startProgressAnimation", "startCollapseAnimation", "stopAnimation", "getCircleRadius", "()F", "Landroid/animation/Animator;", "r", "Landroid/animation/Animator;", "currentAnimator", "l", "Z", "radiusChanged", AuthSource.OPEN_CHANNEL_LIST, "angleChanged", "Landroid/animation/AnimatorSet;", "s", "Landroid/animation/AnimatorSet;", "progressAnimatorSet", "La2/a/a/i3/c/a/i/e/c;", "p", "La2/a/a/i3/c/a/i/e/c;", "drawingInfo", "I", "distanceBetweenCircles", "Landroid/graphics/Path;", "h", "Landroid/graphics/Path;", MessageMetaInfo.COLUMN_PATH, "", "La2/a/a/i3/c/a/i/e/b;", "o", "Ljava/util/List;", "tickCoords", "k", "F", "getSingleCircleRadius", "singleCircleRadius", "i", "rotationAngle", VKApiConst.Q, "d", "usableSpace", "Landroid/graphics/Paint;", g.a, "Landroid/graphics/Paint;", "tickPaint", "La2/a/a/i3/c/a/i/e/b;", "viewCenterCoords", "n", "finalCircleRadius", "circleDiameter", "f", "paint", "j", "spiralRadius", "e", "rotationRadius", "Lkotlin/Function0;", "t", "Lkotlin/jvm/functions/Function0;", "getAnimationFinishListener", "()Lkotlin/jvm/functions/Function0;", "setAnimationFinishListener", "(Lkotlin/jvm/functions/Function0;)V", "animationFinishListener", "<init>", "(Landroid/content/Context;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class CollapsingProgressView extends View {
    public int a = getResources().getDimensionPixelSize(R.dimen.collapsing_progress_distance_between_circles);
    public int b = getResources().getDimensionPixelSize(R.dimen.collapsing_progress_circle_size);
    public final a2.a.a.i3.c.a.i.e.b c = new a2.a.a.i3.c.a.i.e.b(0.0f, 0.0f);
    public int d;
    public float e;
    public Paint f = new Paint();
    public Paint g = new Paint();
    public final Path h = new Path();
    public float i;
    public float j;
    public float k = -1.0f;
    public boolean l;
    public boolean m;
    public float n;
    public final List<a2.a.a.i3.c.a.i.e.b> o = new ArrayList();
    public c p = new c(CollectionsKt__CollectionsKt.emptyList(), null, 2);
    public boolean q;
    public Animator r;
    public final AnimatorSet s;
    @Nullable
    public Function0<Unit> t;

    /* compiled from: java-style lambda group */
    public static final class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            int i = this.a;
            if (i == 0) {
                Paint paint = ((CollapsingProgressView) this.b).f;
                Intrinsics.checkNotNullExpressionValue(valueAnimator, "valueAnimator");
                Object animatedValue = valueAnimator.getAnimatedValue();
                Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
                paint.setAlpha(((Integer) animatedValue).intValue());
                ((CollapsingProgressView) this.b).invalidate();
            } else if (i == 1) {
                Intrinsics.checkNotNullExpressionValue(valueAnimator, "valueAnimator");
                Object animatedValue2 = valueAnimator.getAnimatedValue();
                Objects.requireNonNull(animatedValue2, "null cannot be cast to non-null type kotlin.Float");
                ((CollapsingProgressView) this.b).i = ((Float) animatedValue2).floatValue();
                CollapsingProgressView collapsingProgressView = (CollapsingProgressView) this.b;
                collapsingProgressView.a(collapsingProgressView.e, ((CollapsingProgressView) this.b).i, ((CollapsingProgressView) this.b).getCircleRadius());
                ((CollapsingProgressView) this.b).invalidate();
            } else {
                throw null;
            }
        }
    }

    /* compiled from: java-style lambda group */
    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public b(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            int i = this.a;
            if (i == 0) {
                Paint paint = ((CollapsingProgressView) this.b).f;
                Intrinsics.checkNotNullExpressionValue(valueAnimator, "valueAnimator");
                Object animatedValue = valueAnimator.getAnimatedValue();
                Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
                paint.setAlpha(((Integer) animatedValue).intValue());
                ((CollapsingProgressView) this.b).invalidate();
            } else if (i == 1) {
                Intrinsics.checkNotNullExpressionValue(valueAnimator, "valueAnimator");
                Object animatedValue2 = valueAnimator.getAnimatedValue();
                Objects.requireNonNull(animatedValue2, "null cannot be cast to non-null type kotlin.Float");
                ((CollapsingProgressView) this.b).i = ((Float) animatedValue2).floatValue();
                CollapsingProgressView collapsingProgressView = (CollapsingProgressView) this.b;
                collapsingProgressView.a(collapsingProgressView.e, ((CollapsingProgressView) this.b).i, ((CollapsingProgressView) this.b).getCircleRadius());
                ((CollapsingProgressView) this.b).invalidate();
            } else {
                throw null;
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CollapsingProgressView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        AnimatorSet animatorSet = new AnimatorSet();
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 255);
        ofInt.setDuration(100L);
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.addUpdateListener(new b(0, this));
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 360.0f);
        ofFloat.setDuration(770L);
        GlobalAnimationsKt.setSafeRepeatCount(ofFloat, 10);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addUpdateListener(new b(1, this));
        animatorSet.playSequentially(ofInt, ofFloat);
        animatorSet.addListener(new AnimatorListenerAdapter(this) { // from class: com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel.CollapsingProgressView$$special$$inlined$apply$lambda$5
            public final /* synthetic */ CollapsingProgressView a;

            {
                this.a = r1;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(@Nullable Animator animator) {
                CollapsingProgressView.access$setCurrentAnimator$p(this.a, animator);
            }
        });
        this.s = animatorSet;
        c(context, null);
    }

    public static final void access$calculateSingleCircle(CollapsingProgressView collapsingProgressView, float f2, boolean z) {
        List<a2.a.a.i3.c.a.i.e.b> list;
        Objects.requireNonNull(collapsingProgressView);
        ArrayList arrayList = new ArrayList();
        a2.a.a.i3.c.a.i.e.b bVar = collapsingProgressView.c;
        arrayList.add(new a2.a.a.i3.c.a.i.e.a(bVar.a, bVar.b, f2));
        if (z) {
            list = collapsingProgressView.o;
        } else {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        collapsingProgressView.p = new c(arrayList, list);
    }

    public static final void access$invalidateSpiral(CollapsingProgressView collapsingProgressView) {
        if (collapsingProgressView.l && collapsingProgressView.m) {
            collapsingProgressView.l = false;
            collapsingProgressView.m = false;
            collapsingProgressView.a(collapsingProgressView.j, collapsingProgressView.i, collapsingProgressView.getCircleRadius());
            collapsingProgressView.invalidate();
        }
    }

    private final float getCircleRadius() {
        return ((float) this.b) / 2.0f;
    }

    /* access modifiers changed from: public */
    private final float getSingleCircleRadius() {
        float f2 = this.k;
        return f2 < ((float) 0) ? getCircleRadius() : f2;
    }

    public final void a(float f2, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        Pair<Float, Float> b2 = b(f2, 135.0f + f3);
        Pair<Float, Float> b3 = b(f2, 45.0f + f3);
        Pair<Float, Float> b4 = b(f2, 315.0f + f3);
        Pair<Float, Float> b5 = b(f2, f3 + 225.0f);
        arrayList.add(new a2.a.a.i3.c.a.i.e.a(b2.getFirst().floatValue(), b2.getSecond().floatValue(), f4));
        arrayList.add(new a2.a.a.i3.c.a.i.e.a(b3.getFirst().floatValue(), b3.getSecond().floatValue(), f4));
        arrayList.add(new a2.a.a.i3.c.a.i.e.a(b4.getFirst().floatValue(), b4.getSecond().floatValue(), f4));
        arrayList.add(new a2.a.a.i3.c.a.i.e.a(b5.getFirst().floatValue(), b5.getSecond().floatValue(), f4));
        this.p = new c(arrayList, null, 2);
    }

    public final Pair<Float, Float> b(float f2, float f3) {
        return TuplesKt.to(Float.valueOf((((float) Math.cos((double) CollapsingProgressViewKt.access$degreesToRadians(f3))) * f2) + this.c.a), Float.valueOf((f2 * ((float) Math.sin((double) CollapsingProgressViewKt.access$degreesToRadians(f3)))) + this.c.b));
    }

    public final void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CollapsingProgressView);
        int color = obtainStyledAttributes.getColor(R.styleable.CollapsingProgressView_circlesColor, Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.blue));
        this.b = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CollapsingProgressView_circlesDiameter, getResources().getDimensionPixelSize(R.dimen.collapsing_progress_circle_size));
        int color2 = obtainStyledAttributes.getColor(R.styleable.CollapsingProgressView_tickColor, Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.white));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CollapsingProgressView_tickWidth, getResources().getDimensionPixelSize(R.dimen.collapsing_progress_tick_width));
        this.n = ((float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.CollapsingProgressView_finalCircleDiameter, (int) (getCircleRadius() * 4.5f))) / 2.0f;
        this.a = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CollapsingProgressView_distanceBetweenCircles, getResources().getDimensionPixelSize(R.dimen.collapsing_progress_distance_between_circles));
        obtainStyledAttributes.recycle();
        this.f.setColor(color);
        this.f.setAntiAlias(true);
        this.g.setColor(color2);
        this.g.setStyle(Paint.Style.STROKE);
        this.g.setStrokeJoin(Paint.Join.ROUND);
        this.g.setStrokeCap(Paint.Cap.ROUND);
        this.g.setAntiAlias(true);
        this.g.setStrokeWidth((float) dimensionPixelSize);
    }

    @Nullable
    public final Function0<Unit> getAnimationFinishListener() {
        return this.t;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.q = false;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnimation();
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        for (T t2 : this.p.a) {
            canvas.drawCircle(t2.a, t2.b, t2.c, this.f);
        }
        int i2 = 0;
        for (T t3 : this.p.b) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            T t4 = t3;
            float f2 = t4.a;
            float f3 = t4.b;
            if (i2 == 0) {
                this.h.reset();
                this.h.moveTo(f2, f3);
            } else {
                this.h.lineTo(f2, f3);
            }
            i2 = i3;
        }
        if (!this.p.b.isEmpty()) {
            canvas.drawPath(this.h, this.g);
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        int i6 = this.b + this.a;
        this.d = i6;
        this.e = ((float) Math.hypot((double) ((float) i6), (double) ((float) i6))) / ((float) 2);
        this.c.a = ((float) getWidth()) / 2.0f;
        this.c.b = ((float) getHeight()) / 2.0f;
        a2.a.a.i3.c.a.i.e.b bVar = this.c;
        float f2 = bVar.a;
        float f3 = bVar.b;
        float f4 = this.n;
        float f5 = (float) 18;
        float f6 = (((float) 7) * f4) / f5;
        float f7 = f2 - f6;
        float f8 = (f4 / f5) + f3;
        float f9 = (f4 / ((float) 3)) + f3;
        this.o.clear();
        this.o.add(new a2.a.a.i3.c.a.i.e.b(f7, f8));
        this.o.add(new a2.a.a.i3.c.a.i.e.b(f2 - (f4 / ((float) 9)), f9));
        this.o.add(new a2.a.a.i3.c.a.i.e.b(f6 + f2, f3 - ((f4 * ((float) 5)) / f5)));
    }

    public final void prepareAnimation() {
        this.f.setAlpha(0);
        float f2 = this.e;
        float circleRadius = getCircleRadius();
        ArrayList arrayList = new ArrayList();
        Pair<Float, Float> b2 = b(f2, 135.0f);
        Pair<Float, Float> b3 = b(f2, 45.0f);
        Pair<Float, Float> b4 = b(f2, 315.0f);
        Pair<Float, Float> b5 = b(f2, 225.0f);
        arrayList.add(new a2.a.a.i3.c.a.i.e.a(b2.getFirst().floatValue(), b2.getSecond().floatValue(), circleRadius));
        arrayList.add(new a2.a.a.i3.c.a.i.e.a(b3.getFirst().floatValue(), b3.getSecond().floatValue(), circleRadius));
        arrayList.add(new a2.a.a.i3.c.a.i.e.a(b4.getFirst().floatValue(), b4.getSecond().floatValue(), circleRadius));
        arrayList.add(new a2.a.a.i3.c.a.i.e.a(b5.getFirst().floatValue(), b5.getSecond().floatValue(), circleRadius));
        this.p = new c(arrayList, null, 2);
    }

    public final void setAnimationFinishListener(@Nullable Function0<Unit> function0) {
        this.t = function0;
    }

    public final void startCollapseAnimation() {
        if (this.s.isRunning()) {
            this.s.cancel();
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 255);
        ofInt.setDuration(300L);
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.addUpdateListener(new w3(0, this));
        ValueAnimator ofFloat = ValueAnimator.ofFloat(getCircleRadius(), this.n);
        ofFloat.setDuration(500L);
        ofFloat.setInterpolator(new PathInterpolator(1.0f, 0.0f, 1.0f, 1.0f));
        ofFloat.addUpdateListener(new w3(1, this));
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(this.e, 0.0f);
        ofFloat2.setDuration(1000L);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ofFloat2.addUpdateListener(new w3(2, this));
        Intrinsics.checkNotNullExpressionValue(ofFloat2, "ValueAnimator.ofFloat(ro…          }\n            }");
        float f2 = this.i;
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(f2, f2 + 720.0f);
        ofFloat3.setDuration(1000L);
        ofFloat3.setInterpolator(new LinearInterpolator());
        ofFloat3.addUpdateListener(new w3(3, this));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat2, ofFloat3);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playSequentially(animatorSet, ofFloat, ofInt);
        animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel.CollapsingProgressView$initAndStartCollapseAnimator$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@Nullable Animator animator) {
                if (CollapsingProgressView.access$getStopAnimation$p(CollapsingProgressView.this)) {
                    CollapsingProgressView.access$setStopAnimation$p(CollapsingProgressView.this, false);
                    return;
                }
                Function0<Unit> animationFinishListener = CollapsingProgressView.this.getAnimationFinishListener();
                if (animationFinishListener != null) {
                    animationFinishListener.invoke();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(@Nullable Animator animator) {
                CollapsingProgressView.access$setCurrentAnimator$p(CollapsingProgressView.this, animator);
            }
        });
        animatorSet2.start();
    }

    public final void startProgressAnimation() {
        stopAnimation();
        this.s.start();
    }

    public final void stopAnimation() {
        Animator animator = this.r;
        if (animator != null && animator.isStarted()) {
            Animator animator2 = this.r;
            if (animator2 != null) {
                animator2.cancel();
            }
            this.q = true;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CollapsingProgressView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        AnimatorSet animatorSet = new AnimatorSet();
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 255);
        ofInt.setDuration(100L);
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.addUpdateListener(new a(0, this));
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 360.0f);
        ofFloat.setDuration(770L);
        GlobalAnimationsKt.setSafeRepeatCount(ofFloat, 10);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addUpdateListener(new a(1, this));
        animatorSet.playSequentially(ofInt, ofFloat);
        animatorSet.addListener(new AnimatorListenerAdapter(this) { // from class: com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel.CollapsingProgressView$$special$$inlined$apply$lambda$10
            public final /* synthetic */ CollapsingProgressView a;

            {
                this.a = r1;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(@Nullable Animator animator) {
                CollapsingProgressView.access$setCurrentAnimator$p(this.a, animator);
            }
        });
        this.s = animatorSet;
        c(context, attributeSet);
    }
}

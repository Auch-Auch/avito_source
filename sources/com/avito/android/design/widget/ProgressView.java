package com.avito.android.design.widget;

import a2.g.r.g;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.GlobalAnimationsKt;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0016B'\b\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010;\u001a\u00020\u0002¢\u0006\u0004\b<\u0010=B+\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010>\u001a\u00020\u0002\u0012\u0006\u0010?\u001a\u00020\u0002¢\u0006\u0004\b<\u0010@J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J/\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020%0$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u0010)R\u0016\u00106\u001a\u00020\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b5\u0010\u001aR\u001c\u0010:\u001a\b\u0012\u0004\u0012\u000208078\u0002@\u0002X.¢\u0006\u0006\n\u0004\b9\u0010'¨\u0006A"}, d2 = {"Lcom/avito/android/design/widget/ProgressView;", "Landroid/view/View;", "", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "(II)V", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "oldWidth", "oldHeight", "onSizeChanged", "(IIII)V", "Landroid/graphics/Canvas;", "canvas", "draw", "(Landroid/graphics/Canvas;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", AuthSource.SEND_ABUSE, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "d", "F", "circleDistanceFromCenter", "Landroid/graphics/Paint;", "i", "Landroid/graphics/Paint;", "singleColorPaint", "Landroid/animation/ValueAnimator;", g.a, "Landroid/animation/ValueAnimator;", "rotationAnimator", "", "Landroid/animation/Animator;", "h", "Ljava/util/List;", "circleAnimators", "I", "padding", "", "j", "Z", "rotate", "", "c", "J", "animationDuration", AuthSource.BOOKING_ORDER, "circlesDistance", "e", "scaleFactor", "", "Lcom/avito/android/design/widget/ProgressView$a;", "f", "circles", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class ProgressView extends View {
    public int a;
    public int b;
    public long c;
    public float d;
    public float e;
    public List<a> f;
    public ValueAnimator g;
    public final List<Animator> h;
    public Paint i;
    public boolean j;

    public static final class a {
        public final float a;
        @NotNull
        public final Paint b;
        public float c;

        public a(float f, Paint paint, float f2, int i) {
            f2 = (i & 4) != 0 ? 1.0f : f2;
            Intrinsics.checkNotNullParameter(paint, "paint");
            this.a = f;
            this.b = paint;
            this.c = f2;
        }
    }

    @JvmOverloads
    public ProgressView(@NotNull Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public ProgressView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ProgressView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.e = 1.0f;
        this.h = new ArrayList();
        this.j = true;
        a(context, attributeSet);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ProgressView);
        this.j = obtainStyledAttributes.getBoolean(R.styleable.ProgressView_rotate, this.j);
        int i2 = R.styleable.ProgressView_circlesColor;
        if (obtainStyledAttributes.hasValue(i2)) {
            Paint paint = new Paint();
            this.i = paint;
            if (paint != null) {
                paint.setColor(obtainStyledAttributes.getColor(i2, 0));
            }
        }
        this.a = context.getResources().getInteger(R.integer.loader_padding);
        this.b = context.getResources().getInteger(R.integer.loader_circles_distance);
        this.c = (long) context.getResources().getInteger(R.integer.loader_animation_duration);
        int[] intArray = context.getResources().getIntArray(R.array.loader_circle_colors);
        Intrinsics.checkNotNullExpressionValue(intArray, "context.resources.getInt…ray.loader_circle_colors)");
        Integer[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(intArray);
        int[] intArray2 = context.getResources().getIntArray(R.array.loader_circle_sizes);
        Intrinsics.checkNotNullExpressionValue(intArray2, "context.resources.getInt…rray.loader_circle_sizes)");
        List<Pair> zip = ArraysKt___ArraysKt.zip(ArraysKt___ArraysJvmKt.toTypedArray(intArray2), typedArray);
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(zip, 10));
        for (Pair pair : zip) {
            Paint paint2 = new Paint();
            paint2.setColor(((Number) pair.getSecond()).intValue());
            arrayList.add(new a((float) ((Number) pair.getFirst()).intValue(), paint2, 0.0f, 4));
        }
        this.f = arrayList;
        List list = ProgressViewKt.a;
        List<a> list2 = this.f;
        if (list2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("circles");
        }
        for (Pair pair2 : CollectionsKt___CollectionsKt.zip(list, list2)) {
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(pair2.getSecond(), (PropertyValuesHolder) pair2.getFirst());
            Intrinsics.checkNotNullExpressionValue(ofPropertyValuesHolder, "ObjectAnimator.ofPropert…lder(it.second, it.first)");
            ofPropertyValuesHolder.setDuration(this.c);
            GlobalAnimationsKt.setSafeRepeatCount(ofPropertyValuesHolder, -1);
            ofPropertyValuesHolder.setInterpolator(null);
            ofPropertyValuesHolder.start();
            this.h.add(ofPropertyValuesHolder);
        }
        if (this.j) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 360.0f);
            this.g = ofFloat;
            if (ofFloat != null) {
                ofFloat.setDuration(this.c);
                GlobalAnimationsKt.setSafeRepeatCount(ofFloat, -1);
                ofFloat.setInterpolator(null);
                ofFloat.start();
            }
        }
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.draw(canvas);
        canvas.save();
        ValueAnimator valueAnimator = this.g;
        if (valueAnimator != null) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            canvas.rotate(((Float) animatedValue).floatValue(), ((float) canvas.getWidth()) / 2.0f, ((float) canvas.getHeight()) / 2.0f);
        }
        List<a> list = this.f;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("circles");
        }
        int i2 = 0;
        for (T t : list) {
            int width = canvas.getWidth() / 2;
            int width2 = canvas.getWidth() / 2;
            List<a> list2 = this.f;
            if (list2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("circles");
            }
            double size = (((double) (((float) i2) / ((float) list2.size()))) * 6.283185307179586d) - ((((double) 3.0f) * 6.283185307179586d) / ((double) 8.0f));
            double cos = (Math.cos(size) * ((double) this.d)) + ((double) width);
            double a3 = a2.b.a.a.a.a(size, (double) this.d, (double) width2);
            float f2 = (float) cos;
            float f3 = (float) a3;
            float f4 = t.a * t.c * this.e;
            Paint paint = this.i;
            if (paint == null) {
                paint = t.b;
            }
            canvas.drawCircle(f2, f3, f4, paint);
            i2++;
        }
        canvas.restore();
        invalidate();
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int i4 = (int) (((float) ((this.a * 2) + this.b)) * this.e);
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode == Integer.MIN_VALUE) {
            size = Math.min(i4, size);
        } else if (mode != 1073741824) {
            size = i4;
        }
        if (mode2 == 1073741824 || mode == 1073741824) {
            i4 = size2;
        } else if (mode2 == Integer.MIN_VALUE) {
            i4 = Math.min(i4, size2);
        }
        setMeasuredDimension(size, i4);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        int i6 = this.a;
        int i7 = this.b;
        this.e = ((float) i2) / ((float) (i6 + i7));
        this.d = ((((float) i7) * ((float) Math.sqrt((double) 2))) / 2.0f) * this.e;
        invalidate();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ProgressView(Context context, AttributeSet attributeSet, int i2, int i3, j jVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProgressView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.e = 1.0f;
        this.h = new ArrayList();
        this.j = true;
        a(context, attributeSet);
    }
}

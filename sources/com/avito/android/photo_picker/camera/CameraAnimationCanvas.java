package com.avito.android.photo_picker.camera;

import a2.g.r.g;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.avito.android.photo_picker.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Contexts;
import com.vk.sdk.api.model.VKApiUserFull;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b*\u0010+B\u001b\b\u0016\u0012\u0006\u0010)\u001a\u00020(\u0012\b\u0010-\u001a\u0004\u0018\u00010,¢\u0006\u0004\b*\u0010.B#\b\u0016\u0012\u0006\u0010)\u001a\u00020(\u0012\b\u0010-\u001a\u0004\u0018\u00010,\u0012\u0006\u00100\u001a\u00020/¢\u0006\u0004\b*\u00101J\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ'\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u0014R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010\u0014¨\u00062"}, d2 = {"Lcom/avito/android/photo_picker/camera/CameraAnimationCanvas;", "Landroid/widget/FrameLayout;", "", "x", "y", "", "startClickAnimation", "(FF)V", "startPhotoCaptureAnimation", "()V", "Landroid/graphics/Canvas;", "canvas", "Landroid/view/View;", VKApiUserFull.RelativeType.CHILD, "", "drawingTime", "", "drawChild", "(Landroid/graphics/Canvas;Landroid/view/View;J)Z", AuthSource.SEND_ABUSE, "F", "touchX", AuthSource.BOOKING_ORDER, "touchY", "Landroid/graphics/Paint;", g.a, "Landroid/graphics/Paint;", "circlePaint", "c", "focusProgress", "Landroid/view/animation/Animation;", "e", "Landroid/view/animation/Animation;", "cameraBlinkAnimation", "Landroid/view/animation/AccelerateDecelerateInterpolator;", "d", "Landroid/view/animation/AccelerateDecelerateInterpolator;", "interpolator", "f", "circleRadius", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class CameraAnimationCanvas extends FrameLayout {
    public float a;
    public float b;
    public float c;
    public final AccelerateDecelerateInterpolator d;
    public Animation e;
    public final float f;
    public final Paint g;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CameraAnimationCanvas(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(@NotNull Canvas canvas, @NotNull View view, long j) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(view, VKApiUserFull.RelativeType.CHILD);
        boolean drawChild = super.drawChild(canvas, view, j);
        float f2 = this.c;
        if (f2 < 1.0f) {
            float abs = 1.0f - Math.abs((this.d.getInterpolation(f2) * 2.0f) - 1.0f);
            this.g.setAlpha((int) (255.0f * abs));
            float f3 = this.a;
            float f4 = this.b;
            float f5 = this.f;
            canvas.drawCircle(f3, f4, (0.2f * f5 * abs) + f5, this.g);
            this.c += 0.025f;
            invalidate();
        }
        return drawChild;
    }

    public final void startClickAnimation(float f2, float f3) {
        this.a = f2;
        this.b = f3;
        this.c = 0.0f;
        invalidate();
    }

    public final void startPhotoCaptureAnimation() {
        startAnimation(this.e);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CameraAnimationCanvas(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CameraAnimationCanvas(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.c = 1.0f;
        this.d = new AccelerateDecelerateInterpolator();
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.camera_blink);
        Intrinsics.checkNotNullExpressionValue(loadAnimation, "AnimationUtils.loadAnima…ext, R.anim.camera_blink)");
        this.e = loadAnimation;
        this.f = getResources().getDimension(R.dimen.photo_picker_focus_circle_radius);
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(getResources().getDimension(R.dimen.photo_picker_focus_circle_stroke_width));
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        paint.setColor(Contexts.getColorByAttr(context2, com.avito.android.lib.design.R.attr.blue600));
        Unit unit = Unit.INSTANCE;
        this.g = paint;
    }
}

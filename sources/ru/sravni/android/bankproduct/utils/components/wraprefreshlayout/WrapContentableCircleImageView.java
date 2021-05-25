package ru.sravni.android.bankproduct.utils.components.wraprefreshlayout;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.View;
import android.view.animation.Animation;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 !2\u00020\u0001:\u0001!B\u0019\b\u0000\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0011R\"\u0010\u0019\u001a\u00020\u00028\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0011R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\""}, d2 = {"Lru/sravni/android/bankproduct/utils/components/wraprefreshlayout/WrapContentableCircleImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "(II)V", "Landroid/view/animation/Animation$AnimationListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setAnimationListener", "(Landroid/view/animation/Animation$AnimationListener;)V", "onAnimationStart", "()V", "onAnimationEnd", "colorRes", "setBackgroundColorRes", "(I)V", "color", "setBackgroundColor", "d", "I", "getMShadowRadius$sravnichat_release", "()I", "setMShadowRadius$sravnichat_release", "mShadowRadius", "c", "Landroid/view/animation/Animation$AnimationListener;", "mListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;I)V", "Companion", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class WrapContentableCircleImageView extends AppCompatImageView {
    public static final Companion Companion = new Companion(null);
    public static final int f = f;
    public static final int g = g;
    public static final float h = 1.75f;
    public static final float i = 3.5f;
    public static final int j = 4;
    public Animation.AnimationListener c;
    public int d;
    public HashMap e;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\n\u0010\tR\u0016\u0010\u000b\u001a\u00020\u00078\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\u000b\u0010\t¨\u0006\u000e"}, d2 = {"Lru/sravni/android/bankproduct/utils/components/wraprefreshlayout/WrapContentableCircleImageView$Companion;", "", "", "FILL_SHADOW_COLOR", "I", "KEY_SHADOW_COLOR", "SHADOW_ELEVATION", "", "SHADOW_RADIUS", "F", "X_OFFSET", "Y_OFFSET", "<init>", "()V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WrapContentableCircleImageView(@NotNull Context context, int i2) {
        super(context);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Context context2 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context2, "getContext()");
        Resources resources = context2.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "getContext().resources");
        float f2 = resources.getDisplayMetrics().density;
        this.d = (int) (i * f2);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        ViewCompat.setElevation(this, ((float) j) * f2);
        Paint paint = shapeDrawable.getPaint();
        Intrinsics.checkExpressionValueIsNotNull(paint, "circle.paint");
        paint.setColor(i2);
        ViewCompat.setBackground(this, shapeDrawable);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.e;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i2) {
        if (this.e == null) {
            this.e = new HashMap();
        }
        View view = (View) this.e.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.e.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final int getMShadowRadius$sravnichat_release() {
        return this.d;
    }

    @Override // android.view.View
    public void onAnimationEnd() {
        Animation.AnimationListener animationListener = this.c;
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
        super.onAnimationEnd();
    }

    @Override // android.view.View
    public void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener animationListener = this.c;
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
    }

    public final void setAnimationListener(@Nullable Animation.AnimationListener animationListener) {
        this.c = animationListener;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        if (getBackground() instanceof ShapeDrawable) {
            Drawable background = getBackground();
            if (background != null) {
                Paint paint = ((ShapeDrawable) background).getPaint();
                Intrinsics.checkExpressionValueIsNotNull(paint, "(background as ShapeDrawable).paint");
                paint.setColor(i2);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.graphics.drawable.ShapeDrawable");
        }
    }

    public final void setBackgroundColorRes(int i2) {
        setBackgroundColor(ContextCompat.getColor(getContext(), i2));
    }

    public final void setMShadowRadius$sravnichat_release(int i2) {
        this.d = i2;
    }
}

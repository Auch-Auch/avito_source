package com.sumsub.sns.core.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.graphics.MatrixKt;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.sumsub.sns.core.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000K\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001 \u0018\u0000 +2\u00020\u0001:\u0001+B'\b\u0007\u0012\u0006\u0010%\u001a\u00020$\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&\u0012\b\b\u0002\u0010(\u001a\u00020\f¢\u0006\u0004\b)\u0010*J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0012\u001a\u00020\f8F@\u0006¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R$\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00178\u0002@BX\u000e¢\u0006\f\n\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006,"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSRotationImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "", "rotateCW", "()V", "rotateCCW", "Landroid/graphics/drawable/Drawable;", "drawable", "setImageDrawable", "(Landroid/graphics/drawable/Drawable;)V", "Landroid/graphics/Bitmap;", "bm", "", "rotationDegrees", "setImageBitmapWithRotation", "(Landroid/graphics/Bitmap;I)V", "getRotation", "()I", "rotation", "Landroidx/dynamicanimation/animation/SpringAnimation;", "f", "Landroidx/dynamicanimation/animation/SpringAnimation;", "rotationAnimation", "", "d", "F", "targetAngle", "value", "c", "setRotationAngle", "(F)V", "rotationAngle", "com/sumsub/sns/core/widget/SNSRotationImageView$rotationPositionHolder$1", "e", "Lcom/sumsub/sns/core/widget/SNSRotationImageView$rotationPositionHolder$1;", "rotationPositionHolder", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class SNSRotationImageView extends AppCompatImageView {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public float c;
    public float d;
    public final SNSRotationImageView$rotationPositionHolder$1 e;
    public final SpringAnimation f;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSRotationImageView$Companion;", "", "", "ANIMATION_MULTIPLIER", "F", "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @JvmOverloads
    public SNSRotationImageView(@NotNull Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public SNSRotationImageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSRotationImageView(Context context, AttributeSet attributeSet, int i, int i2, j jVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? R.attr.sns_RotationImageViewStyle : i);
    }

    /* access modifiers changed from: private */
    public final void setRotationAngle(float f2) {
        float f3;
        this.c = f2;
        Drawable drawable = getDrawable();
        Intrinsics.checkNotNullExpressionValue(drawable, "drawable");
        float intrinsicWidth = (float) drawable.getIntrinsicWidth();
        Drawable drawable2 = getDrawable();
        Intrinsics.checkNotNullExpressionValue(drawable2, "drawable");
        float intrinsicHeight = (float) drawable2.getIntrinsicHeight();
        float f4 = intrinsicWidth / 2.0f;
        float f5 = intrinsicHeight / 2.0f;
        Matrix rotationMatrix = MatrixKt.rotationMatrix(f2, f4, f5);
        if (this.d % ((float) 180) == 0.0f) {
            f3 = Math.min(((float) getWidth()) / intrinsicWidth, ((float) getHeight()) / intrinsicHeight);
        } else {
            f3 = Math.min(((float) getWidth()) / intrinsicHeight, ((float) getHeight()) / intrinsicWidth);
        }
        rotationMatrix.postScale(f3, f3, f4, f5);
        float f6 = (float) 2;
        rotationMatrix.postTranslate((-(intrinsicWidth - ((float) getWidth()))) / f6, (-(intrinsicHeight - ((float) getHeight()))) / f6);
        Unit unit = Unit.INSTANCE;
        setImageMatrix(rotationMatrix);
    }

    @Override // android.view.View
    public final int getRotation() {
        return (int) this.d;
    }

    public final void rotateCCW() {
        float f2 = this.d - 0.049804688f;
        this.d = f2;
        this.f.animateToFinalPosition(f2 * 1000.0f);
    }

    public final void rotateCW() {
        float f2 = this.d + 90.0f;
        this.d = f2;
        this.f.animateToFinalPosition(f2 * 1000.0f);
    }

    public final void setImageBitmapWithRotation(@Nullable Bitmap bitmap, int i) {
        super.setImageBitmap(bitmap);
        float f2 = (float) i;
        this.d = f2;
        this.f.animateToFinalPosition(f2 * 1000.0f);
        this.f.skipToEnd();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        super.setImageDrawable(drawable);
        this.d = 0.0f;
        this.f.animateToFinalPosition(0.0f);
        this.f.skipToEnd();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SNSRotationImageView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        SNSRotationImageView$rotationPositionHolder$1 sNSRotationImageView$rotationPositionHolder$1 = new FloatPropertyCompat<SNSRotationImageView>(this, "rotationDegree") { // from class: com.sumsub.sns.core.widget.SNSRotationImageView$rotationPositionHolder$1
            public final /* synthetic */ SNSRotationImageView a;

            {
                this.a = r1;
            }

            public float getValue(@Nullable SNSRotationImageView sNSRotationImageView) {
                return SNSRotationImageView.access$getRotationAngle$p(this.a) * 1000.0f;
            }

            public void setValue(@Nullable SNSRotationImageView sNSRotationImageView, float f2) {
                SNSRotationImageView.access$setRotationAngle$p(this.a, f2 / 1000.0f);
            }
        };
        this.e = sNSRotationImageView$rotationPositionHolder$1;
        SpringAnimation springAnimation = new SpringAnimation(this, sNSRotationImageView$rotationPositionHolder$1, 0.0f);
        SpringForce spring = springAnimation.getSpring();
        Intrinsics.checkNotNullExpressionValue(spring, "spring");
        spring.setDampingRatio(1.0f);
        SpringForce spring2 = springAnimation.getSpring();
        Intrinsics.checkNotNullExpressionValue(spring2, "spring");
        spring2.setStiffness(1500.0f);
        Unit unit = Unit.INSTANCE;
        this.f = springAnimation;
        setScaleType(ImageView.ScaleType.MATRIX);
    }
}

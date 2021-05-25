package ru.sravni.android.bankproduct.utils.components.wraprefreshlayout;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"ru/sravni/android/bankproduct/utils/components/wraprefreshlayout/WrapContentableSwipeRefreshLayout$mAnimateToCorrectPosition$1", "Landroid/view/animation/Animation;", "", "interpolatedTime", "Landroid/view/animation/Transformation;", "t", "", "applyTransformation", "(FLandroid/view/animation/Transformation;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class WrapContentableSwipeRefreshLayout$mAnimateToCorrectPosition$1 extends Animation {
    public final /* synthetic */ WrapContentableSwipeRefreshLayout a;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public WrapContentableSwipeRefreshLayout$mAnimateToCorrectPosition$1(WrapContentableSwipeRefreshLayout wrapContentableSwipeRefreshLayout) {
        this.a = wrapContentableSwipeRefreshLayout;
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f, @NotNull Transformation transformation) {
        int i;
        Intrinsics.checkParameterIsNotNull(transformation, "t");
        if (!this.a.getMUsingCustomStart$sravnichat_release()) {
            i = this.a.getProgressViewEndOffset() - Math.abs(this.a.getProgressViewStartOffset());
        } else {
            i = this.a.getProgressViewEndOffset();
        }
        this.a.setTargetOffsetTopAndBottom$sravnichat_release((this.a.getMFrom() + ((int) (((float) (i - this.a.getMFrom())) * f))) - this.a.getMCircleView$sravnichat_release().getTop());
        this.a.getMProgress$sravnichat_release().setArrowScale(((float) 1) - f);
    }
}

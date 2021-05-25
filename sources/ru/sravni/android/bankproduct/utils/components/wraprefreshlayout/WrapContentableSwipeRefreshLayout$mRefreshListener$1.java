package ru.sravni.android.bankproduct.utils.components.wraprefreshlayout;

import android.view.animation.Animation;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"ru/sravni/android/bankproduct/utils/components/wraprefreshlayout/WrapContentableSwipeRefreshLayout$mRefreshListener$1", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "(Landroid/view/animation/Animation;)V", "onAnimationRepeat", "onAnimationEnd", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class WrapContentableSwipeRefreshLayout$mRefreshListener$1 implements Animation.AnimationListener {
    public final /* synthetic */ WrapContentableSwipeRefreshLayout a;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public WrapContentableSwipeRefreshLayout$mRefreshListener$1(WrapContentableSwipeRefreshLayout wrapContentableSwipeRefreshLayout) {
        this.a = wrapContentableSwipeRefreshLayout;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(@Nullable Animation animation) {
        if (this.a.getMRefreshing$sravnichat_release()) {
            this.a.getMProgress$sravnichat_release().setAlpha(WrapContentableSwipeRefreshLayout.R);
            this.a.getMProgress$sravnichat_release().start();
            if (this.a.getMNotify$sravnichat_release() && this.a.getMListener$sravnichat_release() != null) {
                SwipeRefreshLayout.OnRefreshListener mListener$sravnichat_release = this.a.getMListener$sravnichat_release();
                if (mListener$sravnichat_release == null) {
                    Intrinsics.throwNpe();
                }
                mListener$sravnichat_release.onRefresh();
            }
            WrapContentableSwipeRefreshLayout wrapContentableSwipeRefreshLayout = this.a;
            wrapContentableSwipeRefreshLayout.setMCurrentTargetOffsetTop$sravnichat_release(wrapContentableSwipeRefreshLayout.getMCircleView$sravnichat_release().getTop());
            return;
        }
        this.a.reset$sravnichat_release();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(@Nullable Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(@Nullable Animation animation) {
    }
}

package a2.j.b.d.q;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import java.util.Objects;
public class a implements Runnable {
    public final /* synthetic */ BaseTransientBottomBar a;

    public a(BaseTransientBottomBar baseTransientBottomBar) {
        this.a = baseTransientBottomBar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BaseTransientBottomBar.SnackbarBaseLayout snackbarBaseLayout = this.a.view;
        if (snackbarBaseLayout != null) {
            if (snackbarBaseLayout.getParent() != null) {
                this.a.view.setVisibility(0);
            }
            if (this.a.view.getAnimationMode() == 1) {
                BaseTransientBottomBar baseTransientBottomBar = this.a;
                Objects.requireNonNull(baseTransientBottomBar);
                ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                ofFloat.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
                ofFloat.addUpdateListener(new d(baseTransientBottomBar));
                ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.8f, 1.0f);
                ofFloat2.setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
                ofFloat2.addUpdateListener(new e(baseTransientBottomBar));
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(ofFloat, ofFloat2);
                animatorSet.setDuration(150L);
                animatorSet.addListener(new b(baseTransientBottomBar));
                animatorSet.start();
                return;
            }
            BaseTransientBottomBar baseTransientBottomBar2 = this.a;
            int b = baseTransientBottomBar2.b();
            baseTransientBottomBar2.view.setTranslationY((float) b);
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setIntValues(b, 0);
            valueAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
            valueAnimator.setDuration(250L);
            valueAnimator.addListener(new f(baseTransientBottomBar2));
            valueAnimator.addUpdateListener(new g(baseTransientBottomBar2, b));
            valueAnimator.start();
        }
    }
}

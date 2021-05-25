package a2.j.b.d.q;

import android.animation.ValueAnimator;
import androidx.annotation.NonNull;
import com.google.android.material.snackbar.BaseTransientBottomBar;
public class i implements ValueAnimator.AnimatorUpdateListener {
    public int a = 0;
    public final /* synthetic */ BaseTransientBottomBar b;

    public i(BaseTransientBottomBar baseTransientBottomBar) {
        this.b = baseTransientBottomBar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        int i = BaseTransientBottomBar.ANIMATION_MODE_SLIDE;
        this.b.view.setTranslationY((float) intValue);
        this.a = intValue;
    }
}

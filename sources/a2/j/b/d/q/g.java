package a2.j.b.d.q;

import android.animation.ValueAnimator;
import androidx.annotation.NonNull;
import com.google.android.material.snackbar.BaseTransientBottomBar;
public class g implements ValueAnimator.AnimatorUpdateListener {
    public int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ BaseTransientBottomBar c;

    public g(BaseTransientBottomBar baseTransientBottomBar, int i) {
        this.c = baseTransientBottomBar;
        this.b = i;
        this.a = i;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        int i = BaseTransientBottomBar.ANIMATION_MODE_SLIDE;
        this.c.view.setTranslationY((float) intValue);
        this.a = intValue;
    }
}

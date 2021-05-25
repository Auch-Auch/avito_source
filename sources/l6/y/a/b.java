package l6.y.a;

import android.animation.ValueAnimator;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
public class b implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ CircularProgressDrawable.a a;
    public final /* synthetic */ CircularProgressDrawable b;

    public b(CircularProgressDrawable circularProgressDrawable, CircularProgressDrawable.a aVar) {
        this.b = circularProgressDrawable;
        this.a = aVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.b.c(floatValue, this.a);
        this.b.a(floatValue, this.a, false);
        this.b.invalidateSelf();
    }
}

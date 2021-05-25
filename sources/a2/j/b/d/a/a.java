package a2.j.b.d.a;

import android.animation.ValueAnimator;
import androidx.annotation.NonNull;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.shape.MaterialShapeDrawable;
public class a implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ MaterialShapeDrawable a;

    public a(AppBarLayout appBarLayout, MaterialShapeDrawable materialShapeDrawable) {
        this.a = materialShapeDrawable;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
        this.a.setElevation(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}

package a2.j.b.d.u;

import android.animation.ValueAnimator;
import android.view.View;
import com.google.android.material.transformation.FabTransformationBehavior;
public class a implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ View a;

    public a(FabTransformationBehavior fabTransformationBehavior, View view) {
        this.a = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.invalidate();
    }
}

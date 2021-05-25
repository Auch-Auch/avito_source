package a2.a.a.g3.b;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.RelativeLayout;
import com.avito.android.ui.view.BaseSelectView;
public class a implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ RelativeLayout.LayoutParams a;
    public final /* synthetic */ View b;

    public a(BaseSelectView baseSelectView, RelativeLayout.LayoutParams layoutParams, View view) {
        this.a = layoutParams;
        this.b = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.rightMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.b.requestLayout();
    }
}

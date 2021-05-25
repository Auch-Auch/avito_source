package a2.a.a.k1.a.i;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.avito.android.lib.design.segmented_control.SegmentedControl;
import java.util.Objects;
public final class a implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ View a;

    public a(View view, SegmentedControl segmentedControl) {
        this.a = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int intValue = ((Integer) a2.b.a.a.a.g2(valueAnimator, "valueAnimation", "null cannot be cast to non-null type kotlin.Int")).intValue();
        View view = this.a;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.setMargins(intValue, 0, 0, 0);
        view.setLayoutParams(layoutParams2);
    }
}

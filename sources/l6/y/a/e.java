package l6.y.a;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
public class e extends Animation {
    public final /* synthetic */ SwipeRefreshLayout a;

    public e(SwipeRefreshLayout swipeRefreshLayout) {
        this.a = swipeRefreshLayout;
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f, Transformation transformation) {
        SwipeRefreshLayout swipeRefreshLayout = this.a;
        float f2 = swipeRefreshLayout.v;
        swipeRefreshLayout.setAnimationProgress(((-f2) * f) + f2);
        this.a.e(f);
    }
}

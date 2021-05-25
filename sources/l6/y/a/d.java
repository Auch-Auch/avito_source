package l6.y.a;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
public class d extends Animation {
    public final /* synthetic */ SwipeRefreshLayout a;

    public d(SwipeRefreshLayout swipeRefreshLayout) {
        this.a = swipeRefreshLayout;
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f, Transformation transformation) {
        this.a.setAnimationProgress(f);
    }
}

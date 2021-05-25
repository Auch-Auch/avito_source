package v6.b.a;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
public class a {
    public static final Interpolator a = new FastOutSlowInInterpolator();
    public static final Interpolator b = new FastOutLinearInInterpolator();
    public static final Interpolator c = new LinearOutSlowInInterpolator();
    public static final Interpolator d = new DecelerateInterpolator();

    static {
        new LinearInterpolator();
    }
}

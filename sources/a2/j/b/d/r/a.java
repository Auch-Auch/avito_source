package a2.j.b.d.r;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.tabs.TabLayout;
public class a extends b {
    public static float c(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        return (float) (1.0d - Math.cos((((double) f) * 3.141592653589793d) / 2.0d));
    }

    @Override // a2.j.b.d.r.b
    public void b(TabLayout tabLayout, View view, View view2, float f, @NonNull Drawable drawable) {
        float f2;
        float f3;
        RectF a = b.a(tabLayout, view);
        RectF a3 = b.a(tabLayout, view2);
        if (a.left < a3.left) {
            f3 = c(f);
            f2 = (float) Math.sin((((double) f) * 3.141592653589793d) / 2.0d);
        } else {
            f3 = (float) Math.sin((((double) f) * 3.141592653589793d) / 2.0d);
            f2 = c(f);
        }
        drawable.setBounds(AnimationUtils.lerp((int) a.left, (int) a3.left, f3), drawable.getBounds().top, AnimationUtils.lerp((int) a.right, (int) a3.right, f2), drawable.getBounds().bottom);
    }
}

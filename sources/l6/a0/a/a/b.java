package l6.a0.a.a;

import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
public class b extends Animatable2.AnimationCallback {
    public final /* synthetic */ Animatable2Compat.AnimationCallback a;

    public b(Animatable2Compat.AnimationCallback animationCallback) {
        this.a = animationCallback;
    }

    @Override // android.graphics.drawable.Animatable2.AnimationCallback
    public void onAnimationEnd(Drawable drawable) {
        this.a.onAnimationEnd(drawable);
    }

    @Override // android.graphics.drawable.Animatable2.AnimationCallback
    public void onAnimationStart(Drawable drawable) {
        this.a.onAnimationStart(drawable);
    }
}

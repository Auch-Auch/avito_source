package l6.n.a;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;
import androidx.annotation.NonNull;
import androidx.core.view.OneShotPreDrawListener;
public class g extends AnimationSet implements Runnable {
    public final ViewGroup a;
    public final View b;
    public boolean c;
    public boolean d;
    public boolean e = true;

    public g(@NonNull Animation animation, @NonNull ViewGroup viewGroup, @NonNull View view) {
        super(false);
        this.a = viewGroup;
        this.b = view;
        addAnimation(animation);
        viewGroup.post(this);
    }

    @Override // android.view.animation.AnimationSet, android.view.animation.Animation
    public boolean getTransformation(long j, @NonNull Transformation transformation) {
        this.e = true;
        if (this.c) {
            return !this.d;
        }
        if (!super.getTransformation(j, transformation)) {
            this.c = true;
            OneShotPreDrawListener.add(this.a, this);
        }
        return true;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.c || !this.e) {
            this.a.endViewTransition(this.b);
            this.d = true;
            return;
        }
        this.e = false;
        this.a.post(this);
    }

    @Override // android.view.animation.Animation
    public boolean getTransformation(long j, @NonNull Transformation transformation, float f) {
        this.e = true;
        if (this.c) {
            return !this.d;
        }
        if (!super.getTransformation(j, transformation, f)) {
            this.c = true;
            OneShotPreDrawListener.add(this.a, this);
        }
        return true;
    }
}

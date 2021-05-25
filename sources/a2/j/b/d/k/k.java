package a2.j.b.d.k;

import android.animation.Animator;
import android.animation.AnimatorSet;
import androidx.annotation.AnimatorRes;
import androidx.annotation.Nullable;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
public interface k {
    boolean a();

    @AnimatorRes
    int b();

    AnimatorSet c();

    void d(@Nullable ExtendedFloatingActionButton.OnChangedCallback onChangedCallback);

    void e();

    void f();

    void g();

    void onAnimationStart(Animator animator);
}

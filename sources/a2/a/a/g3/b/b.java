package a2.a.a.g3.b;

import android.animation.Animator;
import com.avito.android.ui.view.BaseSelectView;
import com.avito.android.util.AnimationUtils;
public class b extends AnimationUtils.SimpleAnimatorListener {
    public final /* synthetic */ BaseSelectView a;

    public b(BaseSelectView baseSelectView) {
        this.a = baseSelectView;
    }

    @Override // com.avito.android.util.AnimationUtils.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.a.d.setVisibility(0);
    }
}

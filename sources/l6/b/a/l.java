package l6.b.a;

import android.view.View;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
public class l extends ViewPropertyAnimatorListenerAdapter {
    public final /* synthetic */ AppCompatDelegateImpl a;

    public l(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.a = appCompatDelegateImpl;
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationEnd(View view) {
        this.a.p.setAlpha(1.0f);
        this.a.s.setListener(null);
        this.a.s = null;
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationStart(View view) {
        this.a.p.setVisibility(0);
        this.a.p.sendAccessibilityEvent(32);
        if (this.a.p.getParent() instanceof View) {
            ViewCompat.requestApplyInsets((View) this.a.p.getParent());
        }
    }
}

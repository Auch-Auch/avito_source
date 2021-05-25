package l6.b.a;

import android.view.View;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
public class k implements Runnable {
    public final /* synthetic */ AppCompatDelegateImpl a;

    public class a extends ViewPropertyAnimatorListenerAdapter {
        public a() {
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            k.this.a.p.setAlpha(1.0f);
            k.this.a.s.setListener(null);
            k.this.a.s = null;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationStart(View view) {
            k.this.a.p.setVisibility(0);
        }
    }

    public k(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.a = appCompatDelegateImpl;
    }

    @Override // java.lang.Runnable
    public void run() {
        AppCompatDelegateImpl appCompatDelegateImpl = this.a;
        appCompatDelegateImpl.q.showAtLocation(appCompatDelegateImpl.p, 55, 0, 0);
        this.a.j();
        if (this.a.x()) {
            this.a.p.setAlpha(0.0f);
            AppCompatDelegateImpl appCompatDelegateImpl2 = this.a;
            appCompatDelegateImpl2.s = ViewCompat.animate(appCompatDelegateImpl2.p).alpha(1.0f);
            this.a.s.setListener(new a());
            return;
        }
        this.a.p.setAlpha(1.0f);
        this.a.p.setVisibility(0);
    }
}

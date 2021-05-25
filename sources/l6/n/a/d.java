package l6.n.a;

import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.core.os.CancellationSignal;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import l6.n.a.w;
public final class d implements Animation.AnimationListener {
    public final /* synthetic */ ViewGroup a;
    public final /* synthetic */ Fragment b;
    public final /* synthetic */ w.a c;
    public final /* synthetic */ CancellationSignal d;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.b.getAnimatingAway() != null) {
                d.this.b.setAnimatingAway(null);
                d dVar = d.this;
                ((FragmentManager.b) dVar.c).a(dVar.b, dVar.d);
            }
        }
    }

    public d(ViewGroup viewGroup, Fragment fragment, w.a aVar, CancellationSignal cancellationSignal) {
        this.a = viewGroup;
        this.b = fragment;
        this.c = aVar;
        this.d = cancellationSignal;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.a.post(new a());
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}

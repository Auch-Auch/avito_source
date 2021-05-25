package l6.n.a;

import androidx.core.os.CancellationSignal;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import l6.n.a.w;
public final class s implements Runnable {
    public final /* synthetic */ w.a a;
    public final /* synthetic */ Fragment b;
    public final /* synthetic */ CancellationSignal c;

    public s(w.a aVar, Fragment fragment, CancellationSignal cancellationSignal) {
        this.a = aVar;
        this.b = fragment;
        this.c = cancellationSignal;
    }

    @Override // java.lang.Runnable
    public void run() {
        ((FragmentManager.b) this.a).a(this.b, this.c);
    }
}

package l6.p;

import androidx.lifecycle.WithLifecycleStateKt;
public final class g implements Runnable {
    public final /* synthetic */ WithLifecycleStateKt.b a;

    public g(WithLifecycleStateKt.b bVar) {
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WithLifecycleStateKt.b bVar = this.a;
        bVar.b.removeObserver(bVar.a);
    }
}

package s6.a.e.b;

import io.reactivex.rxjava3.disposables.Disposable;
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ Disposable a;

    public /* synthetic */ c(Disposable disposable) {
        this.a = disposable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.dispose();
    }
}

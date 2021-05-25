package a2.a.a.b2;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
public final class j<T> implements Consumer<Disposable> {
    public final /* synthetic */ l a;

    public j(l lVar) {
        this.a = lVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Disposable disposable) {
        this.a.c.showLogoutProgress();
    }
}

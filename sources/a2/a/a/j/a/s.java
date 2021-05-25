package a2.a.a.j.a;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
public final class s<T> implements Consumer<Disposable> {
    public final /* synthetic */ u a;

    public s(u uVar) {
        this.a = uVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Disposable disposable) {
        this.a.d.trackSendingStarted();
    }
}

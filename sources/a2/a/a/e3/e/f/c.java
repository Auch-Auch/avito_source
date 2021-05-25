package a2.a.a.e3.e.f;

import io.reactivex.functions.Consumer;
import timber.log.Timber;
public final class c<T> implements Consumer<Throwable> {
    public static final c a = new c();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Timber.e(th);
    }
}

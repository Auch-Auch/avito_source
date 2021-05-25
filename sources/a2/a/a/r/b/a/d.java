package a2.a.a.r.b.a;

import io.reactivex.functions.Consumer;
import timber.log.Timber;
public final class d<T> implements Consumer<Throwable> {
    public static final d a = new d();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Timber.e(th);
    }
}

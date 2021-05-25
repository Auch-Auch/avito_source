package a2.a.a.r.b.b.b;

import io.reactivex.functions.Consumer;
import timber.log.Timber;
public final class e<T> implements Consumer<Throwable> {
    public static final e a = new e();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Timber.e(th);
    }
}

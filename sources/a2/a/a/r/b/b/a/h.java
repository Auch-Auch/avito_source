package a2.a.a.r.b.b.a;

import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
public final class h<T> implements Consumer<Throwable> {
    public static final h a = new h();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Logs.error(th);
    }
}

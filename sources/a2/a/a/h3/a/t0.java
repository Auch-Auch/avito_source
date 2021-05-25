package a2.a.a.h3.a;

import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Consumer;
public final class t0<T> implements Consumer<Throwable> {
    public static final t0 a = new t0();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        Logs.error(th);
    }
}

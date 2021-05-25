package a2.a.a.q3.f;

import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
public final class b0<T> implements Consumer<Throwable> {
    public static final b0 a = new b0();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Logs.error(th);
    }
}

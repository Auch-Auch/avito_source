package a2.a.a.b2;

import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
public final class h0<T> implements Consumer<Throwable> {
    public static final h0 a = new h0();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Logs.error("Failed to observe urlClickStream", th);
    }
}

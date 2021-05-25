package a2.a.a.b3.c.b;

import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
public final class p<T> implements Consumer<Throwable> {
    public static final p a = new p();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Logs.error(th);
    }
}

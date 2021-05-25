package a2.a.a.v2.b.i.a;

import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Consumer;
public final class i<T> implements Consumer<Throwable> {
    public static final i a = new i();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        Logs.error(th);
    }
}

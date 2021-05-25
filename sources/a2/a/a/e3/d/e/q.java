package a2.a.a.e3.d.e;

import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
public final class q<T> implements Consumer<Throwable> {
    public static final q a = new q();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Logs.error(th);
    }
}

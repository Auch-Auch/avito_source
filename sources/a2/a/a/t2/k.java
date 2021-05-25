package a2.a.a.t2;

import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
public final class k<T> implements Consumer<Throwable> {
    public static final k a = new k();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Logs.error(th);
    }
}

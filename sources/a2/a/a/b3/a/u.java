package a2.a.a.b3.a;

import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
public final class u<T> implements Consumer<Throwable> {
    public static final u a = new u();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Logs.error(th);
    }
}

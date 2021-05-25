package a2.a.a.y1;

import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
public final class b<T> implements Consumer<Throwable> {
    public static final b a = new b();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Logs.error("Unable to process photo move", th);
    }
}

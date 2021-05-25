package a2.a.a.i3.b;

import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
public final class i<T> implements Consumer<Throwable> {
    public static final i a = new i();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Logs.error("Failed to handle search query", th);
    }
}

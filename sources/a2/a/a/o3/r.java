package a2.a.a.o3;

import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
public final class r<T> implements Consumer<Throwable> {
    public static final r a = new r();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Logs.error("subscriptionsToRange", th);
    }
}

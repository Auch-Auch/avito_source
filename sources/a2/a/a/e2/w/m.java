package a2.a.a.e2.w;

import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
public final class m<T> implements Consumer<Throwable> {
    public static final m a = new m();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Logs.error("Failed to startLocalValidation", th);
    }
}

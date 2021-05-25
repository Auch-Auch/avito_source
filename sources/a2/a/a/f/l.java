package a2.a.a.f;

import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Consumer;
public final class l<T> implements Consumer<Throwable> {
    public static final l a = new l();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        Logs.error(th);
    }
}

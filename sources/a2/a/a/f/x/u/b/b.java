package a2.a.a.f.x.u.b;

import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Consumer;
public final class b<T> implements Consumer<Throwable> {
    public static final b a = new b();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        Logs.error$default("Error when try request flat number", null, 2, null);
    }
}

package a2.a.a.m2;

import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Consumer;
public final class d<T> implements Consumer<Throwable> {
    public static final d a = new d();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        Logs.error("Failed to observe item clicks", th);
    }
}

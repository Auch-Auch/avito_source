package a2.a.a.l3.c;

import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Consumer;
public final class d<T> implements Consumer<Throwable> {
    public static final d a = new d();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        Logs.error("Error while formatting data to statistics tab", th);
    }
}

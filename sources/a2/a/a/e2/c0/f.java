package a2.a.a.e2.c0;

import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
public final class f<T> implements Consumer<Throwable> {
    public static final f a = new f();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Logs.error("subscribeToItemClickStream", th);
    }
}

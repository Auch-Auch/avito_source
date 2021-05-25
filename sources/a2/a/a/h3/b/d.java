package a2.a.a.h3.b;

import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
public final class d<T> implements Consumer<Throwable> {
    public static final d a = new d();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Logs.error("Failed to observe price focus changes", th);
    }
}

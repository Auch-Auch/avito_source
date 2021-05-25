package a2.a.a.j.a;

import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
public final class o0<T> implements Consumer<Throwable> {
    public static final o0 a = new o0();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Logs.error("PublishDraftsSyncTask", "Failed to sync draft", th);
    }
}

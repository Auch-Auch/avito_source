package a2.a.a.j.b;

import com.avito.android.util.Logs;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
public final class e<T> implements Consumer<Disposable> {
    public static final e a = new e();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Disposable disposable) {
        Logs.verbose$default("SendPendingMessagesWorker", "Started background handling", null, 4, null);
    }
}

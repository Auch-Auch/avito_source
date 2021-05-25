package a2.a.a.j.a;

import com.avito.android.util.Logs;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
public final class y0<T> implements Consumer<Disposable> {
    public static final y0 a = new y0();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Disposable disposable) {
        Logs.verbose$default("PendingMessageSendingTask", "Started foreground handling", null, 4, null);
    }
}

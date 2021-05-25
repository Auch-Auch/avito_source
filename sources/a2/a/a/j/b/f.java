package a2.a.a.j.b;

import androidx.work.ListenableWorker;
import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
public final class f<T> implements Consumer<ListenableWorker.Result> {
    public static final f a = new f();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(ListenableWorker.Result result) {
        Logs.verbose$default("SendPendingMessagesWorker", "Result = " + result, null, 4, null);
    }
}

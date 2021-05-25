package a2.a.a.a1;

import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Consumer;
public final class b<T> implements Consumer<Throwable> {
    public static final b a = new b();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        String message = th.getMessage();
        if (message == null) {
            message = "Throwable's message is null";
        }
        Logs.error$default("HomeActivity", message, null, 4, null);
    }
}

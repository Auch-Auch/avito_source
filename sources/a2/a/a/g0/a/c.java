package a2.a.a.g0.a;

import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
public final class c<T> implements Consumer<Throwable> {
    public static final c a = new c();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Logs.error("ConnectivityProvider", "observeNetworkConnectivity() failed", th);
    }
}

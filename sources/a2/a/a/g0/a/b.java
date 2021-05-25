package a2.a.a.g0.a;

import com.avito.android.util.Logs;
import com.github.pwittchen.reactivenetwork.library.rx2.Connectivity;
import io.reactivex.functions.Consumer;
public final class b<T> implements Consumer<Connectivity> {
    public static final b a = new b();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Connectivity connectivity) {
        Logs.verbose$default("ConnectivityProvider", "Connectivity update received: " + connectivity, null, 4, null);
    }
}

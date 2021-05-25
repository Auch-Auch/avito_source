package a2.a.a.q0;

import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Consumer;
public final class h0<T> implements Consumer<Throwable> {
    public static final h0 a = new h0();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        Logs.error("ExtendedProfileViewModel", th);
    }
}

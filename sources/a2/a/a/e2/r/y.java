package a2.a.a.e2.r;

import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
public final class y<T> implements Consumer<Throwable> {
    public static final y a = new y();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Logs.error("Failed on observeSwitcherValueChanges", th);
    }
}

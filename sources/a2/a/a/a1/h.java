package a2.a.a.a1;

import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Consumer;
public final class h<T> implements Consumer<Throwable> {
    public static final h a = new h();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        Logs.error("HomePresenter", "Error isLocationChanged", th);
    }
}

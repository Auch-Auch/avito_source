package a2.a.a.a1;

import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Consumer;
public final class u<T> implements Consumer<Throwable> {
    public static final u a = new u();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        Logs.error("HomePresenter", "Error onLogin", th);
    }
}

package a2.a.a.w.c;

import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Consumer;
public final class x<T> implements Consumer<Throwable> {
    public static final x a = new x();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        Logs.error("BrandspacePresenter", "Error loading snippets", th);
    }
}

package a2.a.a.e2.d0.g;

import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Consumer;
public final class c<T> implements Consumer<Throwable> {
    public static final c a = new c();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        Logs.error("Failed on publishViewModel.parametersValueChanges for TextParameter", th);
    }
}

package a2.a.a.o1.c;

import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
public final class e<T> implements Consumer<Long> {
    public static final e a = new e();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Long l) {
        Logs.verbose$default("KeepConnectionProvider", "Background timeout has passed", null, 4, null);
    }
}

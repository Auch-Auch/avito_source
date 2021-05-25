package a2.a.a.b2;

import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
public final class v<T> implements Consumer<Throwable> {
    public static final v a = new v();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Logs.error("Failed to observe deliverySettingsCardItemStream", th);
    }
}

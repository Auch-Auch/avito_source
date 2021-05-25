package a2.a.a.o1.d.a0.f;

import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Consumer;
public final class o<T> implements Consumer<Throwable> {
    public static final o a = new o();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        Logs.error("UploadStatusUpdatesHandlerImpl", "Error during upload status handling", th);
    }
}

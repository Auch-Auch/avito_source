package a2.a.a.f1.e;

import a2.b.a.a.a;
import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Consumer;
import java.io.File;
public final class b<T> implements Consumer<Throwable> {
    public final /* synthetic */ File a;

    public b(File file) {
        this.a = file;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        StringBuilder L = a.L("Failed to upload log file: ");
        L.append(this.a.getName());
        Logs.debug("LogUploader", L.toString(), th);
    }
}

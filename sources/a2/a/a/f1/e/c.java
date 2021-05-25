package a2.a.a.f1.e;

import com.avito.android.util.Logs;
import java.io.File;
import java.util.concurrent.Callable;
import kotlin.Unit;
public final class c<V> implements Callable<Object> {
    public final /* synthetic */ File a;

    public c(File file) {
        this.a = file;
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        this.a.delete();
        Logs.debug$default("LogUploader", "Remove log file: " + this.a.getName(), null, 4, null);
        return Unit.INSTANCE;
    }
}

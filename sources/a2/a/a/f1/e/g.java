package a2.a.a.f1.e;

import a2.b.a.a.a;
import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Consumer;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;
public final class g<T> implements Consumer<Throwable> {
    public final /* synthetic */ File a;

    public g(File file) {
        this.a = file;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        StringBuilder L = a.L("Can't upload call log [");
        File file = this.a;
        Intrinsics.checkNotNullExpressionValue(file, "file");
        L.append(file.getName());
        L.append(']');
        Logs.error("SendCallLogsWorker", L.toString(), th);
    }
}

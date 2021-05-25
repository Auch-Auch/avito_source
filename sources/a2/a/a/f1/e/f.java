package a2.a.a.f1.e;

import a2.b.a.a.a;
import com.avito.android.in_app_calls.logging.SendCallLogsWorker;
import com.avito.android.util.Logs;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;
public final class f<T> implements Consumer<Disposable> {
    public final /* synthetic */ SendCallLogsWorker.a a;
    public final /* synthetic */ File b;

    public f(SendCallLogsWorker.a aVar, File file) {
        this.a = aVar;
        this.b = file;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Disposable disposable) {
        StringBuilder L = a.L("Start upload call log #");
        L.append(this.a.b.indexOf(this.b));
        L.append(" [");
        File file = this.b;
        Intrinsics.checkNotNullExpressionValue(file, "file");
        L.append(file.getName());
        L.append(']');
        Logs.debug$default("SendCallLogsWorker", L.toString(), null, 4, null);
    }
}

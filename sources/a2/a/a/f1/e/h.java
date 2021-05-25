package a2.a.a.f1.e;

import a2.b.a.a.a;
import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Action;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;
public final class h implements Action {
    public final /* synthetic */ File a;

    public h(File file) {
        this.a = file;
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public final void run() {
        StringBuilder L = a.L("Done uploading call log [");
        File file = this.a;
        Intrinsics.checkNotNullExpressionValue(file, "file");
        L.append(file.getName());
        L.append(']');
        Logs.debug$default("SendCallLogsWorker", L.toString(), null, 4, null);
    }
}

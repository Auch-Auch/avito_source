package a2.a.a.o1.d.a0.f;

import a2.b.a.a.a;
import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Action;
public final class j implements Action {
    public final /* synthetic */ k a;

    public j(k kVar) {
        this.a = kVar;
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public final void run() {
        StringBuilder L = a.L("Uploading file has started, uploadId = ");
        L.append(this.a.a.b);
        Logs.debug$default("FileUploadInteractorImpl", L.toString(), null, 4, null);
    }
}

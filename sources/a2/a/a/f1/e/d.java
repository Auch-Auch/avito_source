package a2.a.a.f1.e;

import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Action;
public final class d implements Action {
    public static final d a = new d();

    @Override // io.reactivex.rxjava3.functions.Action
    public final void run() {
        Logs.debug$default("LogUploader", "Log file uploaded and deleted!", null, 4, null);
    }
}

package a2.a.a.z.a.g;

import com.avito.android.calls_shared.LogTagsKt;
import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Action;
public final class c implements Action {
    public static final c a = new c();

    @Override // io.reactivex.rxjava3.functions.Action
    public final void run() {
        Logs.debug$default(LogTagsKt.TAG_IAC, "Connected!", null, 4, null);
    }
}

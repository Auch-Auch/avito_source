package a2.a.a.z.a.g;

import com.avito.android.calls.voximplant.rx.VoxCallClientConnection;
import com.avito.android.calls_shared.LogTagsKt;
import com.avito.android.util.Logs;
import java.util.concurrent.Callable;
import kotlin.Unit;
public final class f<V> implements Callable<Object> {
    public final /* synthetic */ VoxCallClientConnection.b a;

    public f(VoxCallClientConnection.b bVar) {
        this.a = bVar;
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        Logs.debug$default(LogTagsKt.TAG_IAC, "Disconnect from vox", null, 4, null);
        this.a.a.b.disconnect();
        return Unit.INSTANCE;
    }
}

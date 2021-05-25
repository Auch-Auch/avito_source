package a2.a.a.z.a.g;

import com.avito.android.calls.voximplant.rx.VoxCallClientConnection;
import com.avito.android.calls_shared.LogTagsKt;
import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Action;
public final class b implements Action {
    public final /* synthetic */ VoxCallClientConnection a;

    public b(VoxCallClientConnection voxCallClientConnection) {
        this.a = voxCallClientConnection;
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public final void run() {
        Logs.debug$default(LogTagsKt.TAG_IAC, "Connecting...", null, 4, null);
        this.a.b.connect();
    }
}

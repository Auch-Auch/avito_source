package a2.a.a.j.a;

import com.avito.android.util.Logs;
import io.reactivex.functions.Action;
public final class x implements Action {
    public static final x a = new x();

    @Override // io.reactivex.functions.Action
    public final void run() {
        Logs.debug$default("PendingMessageHandler", "Waiting for new messages.", null, 4, null);
    }
}

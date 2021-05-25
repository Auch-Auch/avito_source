package a2.a.a.j.a;

import com.avito.android.util.Logs;
import io.reactivex.functions.Action;
public final class z0 implements Action {
    public static final z0 a = new z0();

    @Override // io.reactivex.functions.Action
    public final void run() {
        Logs.verbose$default("PendingMessageSendingTask", "Stopped foreground handling", null, 4, null);
    }
}

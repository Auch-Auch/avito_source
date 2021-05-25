package a2.a.a.z.a.g;

import com.avito.android.calls.voximplant.rx.VoxCallClientPushTokenRegistration;
import com.avito.android.calls_shared.LogTagsKt;
import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Action;
public final class j implements Action {
    public final /* synthetic */ VoxCallClientPushTokenRegistration.c a;

    public j(VoxCallClientPushTokenRegistration.c cVar) {
        this.a = cVar;
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public final void run() {
        Logs.debug$default(LogTagsKt.TAG_IAC, "Unregister push token: clear lastRegisteredPushToken", null, 4, null);
        this.a.a.a.setLastRegisteredPushToken("");
    }
}

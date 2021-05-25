package a2.t.a.c.q0;

import com.voximplant.sdk.internal.proto.MES_getUsers;
import com.voximplant.sdk.messaging.IMessengerCompletionHandler;
import com.voximplant.sdk.messaging.IUserEvent;
import com.voximplant.sdk.messaging.MessengerAction;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
public final /* synthetic */ class z implements Runnable {
    public final /* synthetic */ p0 a;
    public final /* synthetic */ IMessengerCompletionHandler b;
    public final /* synthetic */ int c;
    public final /* synthetic */ Map d;

    public /* synthetic */ z(p0 p0Var, IMessengerCompletionHandler iMessengerCompletionHandler, int i, Map map) {
        this.a = p0Var;
        this.b = iMessengerCompletionHandler;
        this.c = i;
        this.d = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p0 p0Var = this.a;
        IMessengerCompletionHandler<List<IUserEvent>> iMessengerCompletionHandler = this.b;
        int i = this.c;
        Map map = this.d;
        Objects.requireNonNull(p0Var);
        String uuid = UUID.randomUUID().toString();
        if (iMessengerCompletionHandler != null) {
            p0Var.h.put(uuid, iMessengerCompletionHandler);
            p0Var.j.put(uuid, new ArrayList());
            p0Var.k.put(uuid, Integer.valueOf(i));
        }
        p0Var.g(uuid, MessengerAction.GET_USERS);
        p0Var.e.add(new MES_getUsers(uuid, map));
    }
}

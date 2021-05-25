package a2.t.a.c.q0;

import com.voximplant.sdk.internal.proto.MES_retransmitEvents;
import com.voximplant.sdk.messaging.IMessengerCompletionHandler;
import com.voximplant.sdk.messaging.IMessengerEvent;
import com.voximplant.sdk.messaging.MessengerAction;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
public final /* synthetic */ class h implements Runnable {
    public final /* synthetic */ p0 a;
    public final /* synthetic */ IMessengerCompletionHandler b;
    public final /* synthetic */ Map c;

    public /* synthetic */ h(p0 p0Var, IMessengerCompletionHandler iMessengerCompletionHandler, Map map) {
        this.a = p0Var;
        this.b = iMessengerCompletionHandler;
        this.c = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p0 p0Var = this.a;
        IMessengerCompletionHandler<? extends IMessengerEvent> iMessengerCompletionHandler = this.b;
        Map map = this.c;
        Objects.requireNonNull(p0Var);
        String uuid = UUID.randomUUID().toString();
        ConcurrentHashMap<String, MessengerAction> concurrentHashMap = p0Var.m;
        MessengerAction messengerAction = MessengerAction.RETRANSMIT_EVENTS;
        concurrentHashMap.put(uuid, messengerAction);
        if (iMessengerCompletionHandler != null) {
            p0Var.g.put(uuid, iMessengerCompletionHandler);
        }
        p0Var.j.put(uuid, new ArrayList());
        p0Var.g(uuid, messengerAction);
        p0Var.e.add(new MES_retransmitEvents(uuid, map));
    }
}

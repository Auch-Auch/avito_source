package a2.t.a.c.q0;

import com.voximplant.sdk.internal.Logger;
import com.voximplant.sdk.internal.proto.MES_getSubscriptions;
import com.voximplant.sdk.internal.proto.MES_subscribe;
import com.voximplant.sdk.internal.proto.MES_unSubscribe;
import com.voximplant.sdk.messaging.IMessengerCompletionHandler;
import com.voximplant.sdk.messaging.IMessengerEvent;
import com.voximplant.sdk.messaging.MessengerAction;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
public final /* synthetic */ class i0 implements Runnable {
    public final /* synthetic */ p0 a;
    public final /* synthetic */ MessengerAction b;
    public final /* synthetic */ IMessengerCompletionHandler c;
    public final /* synthetic */ Map d;

    public /* synthetic */ i0(p0 p0Var, MessengerAction messengerAction, IMessengerCompletionHandler iMessengerCompletionHandler, Map map) {
        this.a = p0Var;
        this.b = messengerAction;
        this.c = iMessengerCompletionHandler;
        this.d = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p0 p0Var = this.a;
        MessengerAction messengerAction = this.b;
        IMessengerCompletionHandler<? extends IMessengerEvent> iMessengerCompletionHandler = this.c;
        Map map = this.d;
        Objects.requireNonNull(p0Var);
        String uuid = UUID.randomUUID().toString();
        p0Var.m.put(uuid, messengerAction);
        p0Var.g(uuid, messengerAction);
        if (iMessengerCompletionHandler != null) {
            p0Var.g.put(uuid, iMessengerCompletionHandler);
        }
        if (messengerAction == MessengerAction.SUBSCRIBE) {
            p0Var.e.add(new MES_subscribe(uuid, map));
        } else if (messengerAction == MessengerAction.UNSUBSCRIBE) {
            p0Var.e.add(new MES_unSubscribe(uuid, map));
        } else if (messengerAction == MessengerAction.GET_SUBSCRIPTION_LIST) {
            p0Var.e.add(new MES_getSubscriptions(uuid, map));
        } else {
            Logger.e("MessengerManager: processSubscriptionCommand: Unknown action type");
        }
    }
}

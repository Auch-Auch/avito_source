package a2.t.a.c.q0;

import com.voximplant.sdk.internal.Logger;
import com.voximplant.sdk.internal.proto.MES_markAsRead;
import com.voximplant.sdk.internal.proto.MES_typingMessage;
import com.voximplant.sdk.messaging.IMessengerCompletionHandler;
import com.voximplant.sdk.messaging.IMessengerEvent;
import com.voximplant.sdk.messaging.MessengerAction;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
public final /* synthetic */ class g0 implements Runnable {
    public final /* synthetic */ p0 a;
    public final /* synthetic */ MessengerAction b;
    public final /* synthetic */ IMessengerCompletionHandler c;
    public final /* synthetic */ Map d;

    public /* synthetic */ g0(p0 p0Var, MessengerAction messengerAction, IMessengerCompletionHandler iMessengerCompletionHandler, Map map) {
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
        if (messengerAction == MessengerAction.TYPING_MESSAGE) {
            p0Var.e.add(new MES_typingMessage(uuid, map));
        } else if (messengerAction == MessengerAction.IS_READ) {
            p0Var.e.add(new MES_markAsRead(uuid, map));
        } else {
            Logger.e("MessengerManager: processConversationServiceCommand: Unknown action type");
        }
    }
}

package a2.t.a.c.q0;

import com.voximplant.sdk.internal.messaging.Message;
import com.voximplant.sdk.internal.proto.MES_editMessage;
import com.voximplant.sdk.internal.proto.MES_sendMessage;
import com.voximplant.sdk.messaging.IMessengerCompletionHandler;
import com.voximplant.sdk.messaging.IMessengerEvent;
import com.voximplant.sdk.messaging.MessengerAction;
import java.util.Objects;
import java.util.UUID;
public final /* synthetic */ class o implements Runnable {
    public final /* synthetic */ p0 a;
    public final /* synthetic */ MessengerAction b;
    public final /* synthetic */ IMessengerCompletionHandler c;
    public final /* synthetic */ Message d;

    public /* synthetic */ o(p0 p0Var, MessengerAction messengerAction, IMessengerCompletionHandler iMessengerCompletionHandler, Message message) {
        this.a = p0Var;
        this.b = messengerAction;
        this.c = iMessengerCompletionHandler;
        this.d = message;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p0 p0Var = this.a;
        MessengerAction messengerAction = this.b;
        IMessengerCompletionHandler<? extends IMessengerEvent> iMessengerCompletionHandler = this.c;
        Message message = this.d;
        Objects.requireNonNull(p0Var);
        String uuid = UUID.randomUUID().toString();
        p0Var.m.put(uuid, messengerAction);
        p0Var.g(uuid, messengerAction);
        if (iMessengerCompletionHandler != null) {
            p0Var.g.put(uuid, iMessengerCompletionHandler);
        }
        if (messengerAction == MessengerAction.SEND_MESSAGE) {
            p0Var.e.add(new MES_sendMessage(uuid, message));
        } else if (messengerAction == MessengerAction.EDIT_MESSAGE) {
            p0Var.e.add(new MES_editMessage(uuid, message));
        }
    }
}

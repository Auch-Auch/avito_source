package a2.t.a.c.q0;

import com.voximplant.sdk.internal.Logger;
import com.voximplant.sdk.internal.messaging.User;
import com.voximplant.sdk.internal.proto.MES_editUser;
import com.voximplant.sdk.internal.proto.MES_getUser;
import com.voximplant.sdk.messaging.IMessengerCompletionHandler;
import com.voximplant.sdk.messaging.IMessengerEvent;
import com.voximplant.sdk.messaging.MessengerAction;
import java.util.Objects;
import java.util.UUID;
public final /* synthetic */ class j0 implements Runnable {
    public final /* synthetic */ p0 a;
    public final /* synthetic */ MessengerAction b;
    public final /* synthetic */ IMessengerCompletionHandler c;
    public final /* synthetic */ User d;

    public /* synthetic */ j0(p0 p0Var, MessengerAction messengerAction, IMessengerCompletionHandler iMessengerCompletionHandler, User user) {
        this.a = p0Var;
        this.b = messengerAction;
        this.c = iMessengerCompletionHandler;
        this.d = user;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p0 p0Var = this.a;
        MessengerAction messengerAction = this.b;
        IMessengerCompletionHandler<? extends IMessengerEvent> iMessengerCompletionHandler = this.c;
        User user = this.d;
        Objects.requireNonNull(p0Var);
        String uuid = UUID.randomUUID().toString();
        p0Var.m.put(uuid, messengerAction);
        p0Var.g(uuid, messengerAction);
        if (iMessengerCompletionHandler != null) {
            p0Var.g.put(uuid, iMessengerCompletionHandler);
        }
        if (messengerAction == MessengerAction.GET_USER) {
            p0Var.e.add(new MES_getUser(uuid, user));
        } else if (messengerAction == MessengerAction.EDIT_USER) {
            p0Var.e.add(new MES_editUser(uuid, user));
        } else {
            Logger.e("MessengerManager: processUserCommand: Unknown action type");
        }
    }
}

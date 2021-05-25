package a2.t.a.c.q0;

import com.voximplant.sdk.internal.messaging.Conversation;
import com.voximplant.sdk.internal.proto.MES_createConversation;
import com.voximplant.sdk.internal.proto.MES_editConversation;
import com.voximplant.sdk.messaging.IMessengerCompletionHandler;
import com.voximplant.sdk.messaging.IMessengerEvent;
import com.voximplant.sdk.messaging.MessengerAction;
import java.util.Objects;
import java.util.UUID;
public final /* synthetic */ class t implements Runnable {
    public final /* synthetic */ p0 a;
    public final /* synthetic */ MessengerAction b;
    public final /* synthetic */ IMessengerCompletionHandler c;
    public final /* synthetic */ Conversation d;

    public /* synthetic */ t(p0 p0Var, MessengerAction messengerAction, IMessengerCompletionHandler iMessengerCompletionHandler, Conversation conversation) {
        this.a = p0Var;
        this.b = messengerAction;
        this.c = iMessengerCompletionHandler;
        this.d = conversation;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p0 p0Var = this.a;
        MessengerAction messengerAction = this.b;
        IMessengerCompletionHandler<? extends IMessengerEvent> iMessengerCompletionHandler = this.c;
        Conversation conversation = this.d;
        Objects.requireNonNull(p0Var);
        String uuid = UUID.randomUUID().toString();
        p0Var.m.put(uuid, messengerAction);
        p0Var.g(uuid, messengerAction);
        if (iMessengerCompletionHandler != null) {
            p0Var.g.put(uuid, iMessengerCompletionHandler);
        }
        if (messengerAction == MessengerAction.CREATE_CONVERSATION) {
            p0Var.e.add(new MES_createConversation(uuid, conversation));
        } else if (messengerAction == MessengerAction.EDIT_CONVERSATION) {
            conversation.b("type/vox.store.IncomingNamespace.EditConversation");
            p0Var.e.add(new MES_editConversation(uuid, conversation));
        }
    }
}

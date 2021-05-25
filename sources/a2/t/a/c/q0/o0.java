package a2.t.a.c.q0;

import com.voximplant.sdk.messaging.IMessengerEvent;
import com.voximplant.sdk.messaging.MessengerAction;
import com.voximplant.sdk.messaging.MessengerEventType;
public class o0 implements IMessengerEvent {
    public MessengerEventType a;
    public MessengerAction b;
    public long c;

    public o0(MessengerAction messengerAction, long j, MessengerEventType messengerEventType) {
        this.b = messengerAction;
        this.c = j;
        this.a = messengerEventType;
    }

    @Override // com.voximplant.sdk.messaging.IMessengerEvent
    public long getIMUserId() {
        return this.c;
    }

    @Override // com.voximplant.sdk.messaging.IMessengerEvent
    public MessengerAction getMessengerAction() {
        return this.b;
    }

    @Override // com.voximplant.sdk.messaging.IMessengerEvent
    public MessengerEventType getMessengerEventType() {
        return this.a;
    }
}

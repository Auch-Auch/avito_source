package a2.t.a.c.q0;

import com.voximplant.sdk.messaging.IMessage;
import com.voximplant.sdk.messaging.IMessageEvent;
import com.voximplant.sdk.messaging.MessengerAction;
import com.voximplant.sdk.messaging.MessengerEventType;
public class n0 extends o0 implements IMessageEvent {
    public IMessage d;
    public long e;
    public long f;

    public n0(MessengerAction messengerAction, long j, MessengerEventType messengerEventType, IMessage iMessage, long j2, long j3) {
        super(messengerAction, j, messengerEventType);
        this.d = iMessage;
        this.e = j2;
        this.f = j3;
    }

    @Override // com.voximplant.sdk.messaging.IMessageEvent
    public IMessage getMessage() {
        return this.d;
    }

    @Override // com.voximplant.sdk.messaging.IMessageEvent
    public long getSequence() {
        return this.e;
    }

    @Override // com.voximplant.sdk.messaging.IMessageEvent
    public long getTimestamp() {
        return this.f;
    }
}

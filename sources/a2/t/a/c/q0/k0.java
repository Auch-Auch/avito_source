package a2.t.a.c.q0;

import com.voximplant.sdk.messaging.IConversation;
import com.voximplant.sdk.messaging.IConversationEvent;
import com.voximplant.sdk.messaging.MessengerAction;
import com.voximplant.sdk.messaging.MessengerEventType;
public class k0 extends o0 implements IConversationEvent {
    public IConversation d;
    public long e;
    public long f;

    public k0(MessengerAction messengerAction, long j, MessengerEventType messengerEventType, IConversation iConversation, long j2, long j3) {
        super(messengerAction, j, messengerEventType);
        this.d = iConversation;
        this.e = j2;
        this.f = j3;
    }

    @Override // com.voximplant.sdk.messaging.IConversationEvent
    public IConversation getConversation() {
        return this.d;
    }

    @Override // com.voximplant.sdk.messaging.IConversationEvent
    public long getSequence() {
        return this.e;
    }

    @Override // com.voximplant.sdk.messaging.IConversationEvent
    public long getTimestamp() {
        return this.f;
    }
}

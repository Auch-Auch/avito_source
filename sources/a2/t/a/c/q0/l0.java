package a2.t.a.c.q0;

import com.voximplant.sdk.messaging.IConversationServiceEvent;
import com.voximplant.sdk.messaging.MessengerAction;
import com.voximplant.sdk.messaging.MessengerEventType;
public class l0 extends o0 implements IConversationServiceEvent {
    public String d;
    public long e;

    public l0(MessengerAction messengerAction, long j, MessengerEventType messengerEventType, String str, long j2) {
        super(messengerAction, j, messengerEventType);
        this.d = str;
        this.e = j2;
    }

    @Override // com.voximplant.sdk.messaging.IConversationServiceEvent
    public String getConversationUUID() {
        return this.d;
    }

    @Override // com.voximplant.sdk.messaging.IConversationServiceEvent
    public long getSequence() {
        return this.e;
    }
}

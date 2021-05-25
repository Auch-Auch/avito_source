package a2.t.a.c.q0;

import com.voximplant.sdk.messaging.IMessengerEvent;
import com.voximplant.sdk.messaging.IRetransmitEvent;
import com.voximplant.sdk.messaging.MessengerAction;
import com.voximplant.sdk.messaging.MessengerEventType;
import java.util.List;
public class q0 extends o0 implements IRetransmitEvent {
    public List<IMessengerEvent> d;
    public long e;
    public long f;

    public q0(MessengerAction messengerAction, long j, MessengerEventType messengerEventType, List<IMessengerEvent> list, Long l, Long l2) {
        super(messengerAction, j, messengerEventType);
        long j2;
        this.d = list;
        long j3 = 0;
        if (l == null) {
            j2 = 0;
        } else {
            j2 = l.longValue();
        }
        this.e = j2;
        this.f = l2 != null ? l2.longValue() : j3;
    }

    @Override // com.voximplant.sdk.messaging.IRetransmitEvent
    public List<IMessengerEvent> getEvents() {
        return this.d;
    }

    @Override // com.voximplant.sdk.messaging.IRetransmitEvent
    public long getFromSequence() {
        return this.e;
    }

    @Override // com.voximplant.sdk.messaging.IRetransmitEvent
    public long getToSequence() {
        return this.f;
    }
}

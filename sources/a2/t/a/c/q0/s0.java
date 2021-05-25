package a2.t.a.c.q0;

import com.voximplant.sdk.messaging.ISubscriptionEvent;
import com.voximplant.sdk.messaging.MessengerAction;
import com.voximplant.sdk.messaging.MessengerEventType;
import java.util.List;
public class s0 extends o0 implements ISubscriptionEvent {
    public List<Long> d;

    public s0(MessengerAction messengerAction, long j, MessengerEventType messengerEventType, List<Long> list) {
        super(messengerAction, j, messengerEventType);
        this.d = list;
    }

    @Override // com.voximplant.sdk.messaging.ISubscriptionEvent
    public List<Long> getUsers() {
        return this.d;
    }
}

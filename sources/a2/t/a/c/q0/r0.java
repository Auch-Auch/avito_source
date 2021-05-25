package a2.t.a.c.q0;

import com.voximplant.sdk.messaging.IStatusEvent;
import com.voximplant.sdk.messaging.MessengerAction;
import com.voximplant.sdk.messaging.MessengerEventType;
public class r0 extends o0 implements IStatusEvent {
    public boolean d;

    public r0(MessengerAction messengerAction, long j, MessengerEventType messengerEventType, boolean z) {
        super(messengerAction, j, messengerEventType);
        this.d = z;
    }

    @Override // com.voximplant.sdk.messaging.IStatusEvent
    public boolean isOnline() {
        return this.d;
    }
}

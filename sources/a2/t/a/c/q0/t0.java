package a2.t.a.c.q0;

import com.voximplant.sdk.messaging.IUser;
import com.voximplant.sdk.messaging.IUserEvent;
import com.voximplant.sdk.messaging.MessengerAction;
import com.voximplant.sdk.messaging.MessengerEventType;
public class t0 extends o0 implements IUserEvent {
    public IUser d;

    public t0(MessengerAction messengerAction, long j, MessengerEventType messengerEventType, IUser iUser) {
        super(messengerAction, j, messengerEventType);
        this.d = iUser;
    }

    @Override // com.voximplant.sdk.messaging.IUserEvent
    public IUser getUser() {
        return this.d;
    }
}

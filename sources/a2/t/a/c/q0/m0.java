package a2.t.a.c.q0;

import com.voximplant.sdk.messaging.IErrorEvent;
import com.voximplant.sdk.messaging.MessengerAction;
import com.voximplant.sdk.messaging.MessengerEventType;
public class m0 extends o0 implements IErrorEvent {
    public int d;
    public String e;

    public m0(MessengerAction messengerAction, MessengerEventType messengerEventType, int i, String str) {
        super(messengerAction, 0, messengerEventType);
        this.d = i;
        this.e = str;
    }

    @Override // com.voximplant.sdk.messaging.IErrorEvent
    public int getErrorCode() {
        return this.d;
    }

    @Override // com.voximplant.sdk.messaging.IErrorEvent
    public String getErrorDescription() {
        return this.e;
    }
}

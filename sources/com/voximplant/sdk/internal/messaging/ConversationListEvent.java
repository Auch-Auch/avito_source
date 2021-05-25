package com.voximplant.sdk.internal.messaging;

import a2.t.a.c.q0.o0;
import com.voximplant.sdk.messaging.IConversationListEvent;
import com.voximplant.sdk.messaging.MessengerAction;
import com.voximplant.sdk.messaging.MessengerEventType;
import java.util.List;
public class ConversationListEvent extends o0 implements IConversationListEvent {
    public List<String> d;

    public ConversationListEvent(MessengerAction messengerAction, long j, MessengerEventType messengerEventType, List<String> list) {
        super(messengerAction, j, messengerEventType);
        this.d = list;
    }

    @Override // com.voximplant.sdk.messaging.IConversationListEvent
    public List<String> getConversationList() {
        return this.d;
    }

    @Override // a2.t.a.c.q0.o0, com.voximplant.sdk.messaging.IMessengerEvent
    public /* bridge */ /* synthetic */ long getIMUserId() {
        return super.getIMUserId();
    }

    @Override // a2.t.a.c.q0.o0, com.voximplant.sdk.messaging.IMessengerEvent
    public /* bridge */ /* synthetic */ MessengerAction getMessengerAction() {
        return super.getMessengerAction();
    }

    @Override // a2.t.a.c.q0.o0, com.voximplant.sdk.messaging.IMessengerEvent
    public /* bridge */ /* synthetic */ MessengerEventType getMessengerEventType() {
        return super.getMessengerEventType();
    }
}

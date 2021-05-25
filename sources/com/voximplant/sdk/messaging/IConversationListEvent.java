package com.voximplant.sdk.messaging;

import java.util.List;
public interface IConversationListEvent extends IMessengerEvent {
    List<String> getConversationList();
}

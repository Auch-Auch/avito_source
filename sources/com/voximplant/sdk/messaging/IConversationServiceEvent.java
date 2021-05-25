package com.voximplant.sdk.messaging;
public interface IConversationServiceEvent extends IMessengerEvent {
    String getConversationUUID();

    long getSequence();
}

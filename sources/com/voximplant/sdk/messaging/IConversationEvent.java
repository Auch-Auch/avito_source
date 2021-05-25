package com.voximplant.sdk.messaging;
public interface IConversationEvent extends IMessengerEvent {
    IConversation getConversation();

    long getSequence();

    long getTimestamp();
}

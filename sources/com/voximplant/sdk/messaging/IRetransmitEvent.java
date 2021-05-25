package com.voximplant.sdk.messaging;

import java.util.List;
public interface IRetransmitEvent extends IMessengerEvent {
    List<IMessengerEvent> getEvents();

    long getFromSequence();

    long getToSequence();
}

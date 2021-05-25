package com.voximplant.sdk.messaging;

import java.util.List;
public interface ISubscriptionEvent extends IMessengerEvent {
    List<Long> getUsers();
}

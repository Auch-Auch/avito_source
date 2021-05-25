package com.voximplant.sdk.messaging;

import java.util.Map;
public interface IMessengerPushNotificationProcessing {
    IMessengerEvent processPushNotification(Map<String, String> map);
}

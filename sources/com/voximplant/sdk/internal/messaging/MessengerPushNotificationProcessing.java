package com.voximplant.sdk.internal.messaging;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.voximplant.sdk.internal.Logger;
import com.voximplant.sdk.messaging.IMessengerEvent;
import com.voximplant.sdk.messaging.IMessengerPushNotificationProcessing;
import java.util.Map;
import java.util.Objects;
public class MessengerPushNotificationProcessing implements IMessengerPushNotificationProcessing {
    public static MessengerPushNotificationProcessing b;
    public Gson a = new GsonBuilder().create();

    public class a {
    }

    public static synchronized MessengerPushNotificationProcessing getInstance() {
        MessengerPushNotificationProcessing messengerPushNotificationProcessing;
        synchronized (MessengerPushNotificationProcessing.class) {
            if (b == null) {
                b = new MessengerPushNotificationProcessing();
            }
            messengerPushNotificationProcessing = b;
        }
        return messengerPushNotificationProcessing;
    }

    @Override // com.voximplant.sdk.messaging.IMessengerPushNotificationProcessing
    public IMessengerEvent processPushNotification(Map<String, String> map) {
        if (!map.containsKey("voximplant_im")) {
            Logger.e("Failed to process push notification: this not VoxImplant messenger push notification");
            return null;
        }
        try {
            Objects.requireNonNull((a) this.a.fromJson(map.get("voximplant_im"), (Class<Object>) a.class));
            throw null;
        } catch (JsonParseException e) {
            StringBuilder L = a2.b.a.a.a.L("Failed to process push notification: ");
            L.append(e.getMessage());
            Logger.e(L.toString());
            return null;
        }
    }
}

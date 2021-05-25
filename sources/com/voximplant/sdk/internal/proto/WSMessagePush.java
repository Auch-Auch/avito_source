package com.voximplant.sdk.internal.proto;

import androidx.core.app.NotificationCompat;
import java.util.Map;
public class WSMessagePush extends WSMessage {
    public String getError() {
        Map map;
        if (((this instanceof M_registerPushTokenResult) || (this instanceof M_unregisterPushTokenResult)) && this.params.size() > 0 && (map = (Map) this.params.get(0)) != null) {
            return (String) map.get(NotificationCompat.CATEGORY_MESSAGE);
        }
        return null;
    }

    public String getRequestUUID() {
        Map map;
        if (((this instanceof M_registerPushTokenResult) || (this instanceof M_unregisterPushTokenResult)) && this.params.size() > 0 && (map = (Map) this.params.get(0)) != null) {
            return (String) map.get("params");
        }
        return null;
    }

    public boolean isSuccessful() {
        Map map;
        String str;
        if (((this instanceof M_registerPushTokenResult) || (this instanceof M_unregisterPushTokenResult)) && this.params.size() > 0 && (map = (Map) this.params.get(0)) != null && (str = (String) map.get("status")) != null && str.equals("OK")) {
            return true;
        }
        return false;
    }
}

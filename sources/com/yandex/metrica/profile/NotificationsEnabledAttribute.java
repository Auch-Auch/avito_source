package com.yandex.metrica.profile;

import com.yandex.metrica.impl.ob.adp;
import com.yandex.metrica.impl.ob.un;
public class NotificationsEnabledAttribute extends BooleanAttribute {
    public NotificationsEnabledAttribute() {
        super("appmetrica_notifications_enabled", new adp(), new un());
    }
}

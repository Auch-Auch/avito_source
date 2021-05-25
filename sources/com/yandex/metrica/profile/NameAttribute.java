package com.yandex.metrica.profile;

import com.yandex.metrica.impl.ob.adl;
import com.yandex.metrica.impl.ob.adp;
import com.yandex.metrica.impl.ob.un;
public class NameAttribute extends StringAttribute {
    public NameAttribute() {
        super("appmetrica_name", new adl(100, "Name attribute"), new adp(), new un());
    }
}

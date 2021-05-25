package com.yandex.metrica.profile;

import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.adw;
import com.yandex.metrica.impl.ob.tz;
import com.yandex.metrica.impl.ob.ue;
import com.yandex.metrica.impl.ob.uf;
import com.yandex.metrica.impl.ob.ur;
public final class CounterAttribute {
    private final uf mCustomAttribute;

    public CounterAttribute(@NonNull String str, @NonNull adw<String> adw, @NonNull tz tzVar) {
        this.mCustomAttribute = new uf(str, adw, tzVar);
    }

    @NonNull
    public UserProfileUpdate<? extends ur> withDelta(double d) {
        return new UserProfileUpdate<>(new ue(this.mCustomAttribute.a(), d));
    }
}

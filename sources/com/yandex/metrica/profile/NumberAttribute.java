package com.yandex.metrica.profile;

import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.ade;
import com.yandex.metrica.impl.ob.adw;
import com.yandex.metrica.impl.ob.tz;
import com.yandex.metrica.impl.ob.uc;
import com.yandex.metrica.impl.ob.uf;
import com.yandex.metrica.impl.ob.ug;
import com.yandex.metrica.impl.ob.uh;
import com.yandex.metrica.impl.ob.uj;
import com.yandex.metrica.impl.ob.ul;
import com.yandex.metrica.impl.ob.um;
import com.yandex.metrica.impl.ob.ur;
public final class NumberAttribute {
    private final uf mCustomAttribute;

    public NumberAttribute(@NonNull String str, @NonNull adw<String> adw, @NonNull tz tzVar) {
        this.mCustomAttribute = new uf(str, adw, tzVar);
    }

    @NonNull
    public UserProfileUpdate<? extends ur> withValue(double d) {
        return new UserProfileUpdate<>(new uj(this.mCustomAttribute.a(), d, new ug(), new uc(new uh(new ade(100)))));
    }

    @NonNull
    public UserProfileUpdate<? extends ur> withValueIfUndefined(double d) {
        return new UserProfileUpdate<>(new uj(this.mCustomAttribute.a(), d, new ug(), new um(new uh(new ade(100)))));
    }

    @NonNull
    public UserProfileUpdate<? extends ur> withValueReset() {
        return new UserProfileUpdate<>(new ul(1, this.mCustomAttribute.a(), new ug(), new uh(new ade(100))));
    }
}

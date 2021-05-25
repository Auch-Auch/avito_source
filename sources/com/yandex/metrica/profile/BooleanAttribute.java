package com.yandex.metrica.profile;

import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.adw;
import com.yandex.metrica.impl.ob.tz;
import com.yandex.metrica.impl.ob.ub;
import com.yandex.metrica.impl.ob.uc;
import com.yandex.metrica.impl.ob.uf;
import com.yandex.metrica.impl.ob.ul;
import com.yandex.metrica.impl.ob.um;
import com.yandex.metrica.impl.ob.ur;
public class BooleanAttribute {
    private final uf mCustomAttribute;

    public BooleanAttribute(@NonNull String str, @NonNull adw<String> adw, @NonNull tz tzVar) {
        this.mCustomAttribute = new uf(str, adw, tzVar);
    }

    @NonNull
    public UserProfileUpdate<? extends ur> withValue(boolean z) {
        return new UserProfileUpdate<>(new ub(this.mCustomAttribute.a(), z, this.mCustomAttribute.c(), new uc(this.mCustomAttribute.b())));
    }

    @NonNull
    public UserProfileUpdate<? extends ur> withValueIfUndefined(boolean z) {
        return new UserProfileUpdate<>(new ub(this.mCustomAttribute.a(), z, this.mCustomAttribute.c(), new um(this.mCustomAttribute.b())));
    }

    @NonNull
    public UserProfileUpdate<? extends ur> withValueReset() {
        return new UserProfileUpdate<>(new ul(3, this.mCustomAttribute.a(), this.mCustomAttribute.c(), this.mCustomAttribute.b()));
    }
}

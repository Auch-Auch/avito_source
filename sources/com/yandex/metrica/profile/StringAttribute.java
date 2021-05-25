package com.yandex.metrica.profile;

import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.adn;
import com.yandex.metrica.impl.ob.adw;
import com.yandex.metrica.impl.ob.tz;
import com.yandex.metrica.impl.ob.uc;
import com.yandex.metrica.impl.ob.uf;
import com.yandex.metrica.impl.ob.ul;
import com.yandex.metrica.impl.ob.um;
import com.yandex.metrica.impl.ob.uo;
import com.yandex.metrica.impl.ob.ur;
public class StringAttribute {
    private final uf mCustomAttribute;
    private final adn<String> mValueTrimmer;

    public StringAttribute(@NonNull String str, @NonNull adn<String> adn, @NonNull adw<String> adw, @NonNull tz tzVar) {
        this.mCustomAttribute = new uf(str, adw, tzVar);
        this.mValueTrimmer = adn;
    }

    @NonNull
    public UserProfileUpdate<? extends ur> withValue(@NonNull String str) {
        return new UserProfileUpdate<>(new uo(this.mCustomAttribute.a(), str, this.mValueTrimmer, this.mCustomAttribute.c(), new uc(this.mCustomAttribute.b())));
    }

    @NonNull
    public UserProfileUpdate<? extends ur> withValueIfUndefined(@NonNull String str) {
        return new UserProfileUpdate<>(new uo(this.mCustomAttribute.a(), str, this.mValueTrimmer, this.mCustomAttribute.c(), new um(this.mCustomAttribute.b())));
    }

    @NonNull
    public UserProfileUpdate<? extends ur> withValueReset() {
        return new UserProfileUpdate<>(new ul(0, this.mCustomAttribute.a(), this.mCustomAttribute.c(), this.mCustomAttribute.b()));
    }
}

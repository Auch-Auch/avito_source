package com.yandex.metrica.profile;

import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.adf;
import com.yandex.metrica.impl.ob.adp;
import com.yandex.metrica.impl.ob.uc;
import com.yandex.metrica.impl.ob.uf;
import com.yandex.metrica.impl.ob.ul;
import com.yandex.metrica.impl.ob.um;
import com.yandex.metrica.impl.ob.un;
import com.yandex.metrica.impl.ob.uo;
import com.yandex.metrica.impl.ob.ur;
public class GenderAttribute {
    private final uf mCustomAttribute = new uf("appmetrica_gender", new adp(), new un());

    public enum Gender {
        MALE("M"),
        FEMALE("F"),
        OTHER("O");
        
        private final String mStringValue;

        private Gender(String str) {
            this.mStringValue = str;
        }

        public String getStringValue() {
            return this.mStringValue;
        }
    }

    @NonNull
    public UserProfileUpdate<? extends ur> withValue(@NonNull Gender gender) {
        return new UserProfileUpdate<>(new uo(this.mCustomAttribute.a(), gender.getStringValue(), new adf(), this.mCustomAttribute.c(), new uc(this.mCustomAttribute.b())));
    }

    @NonNull
    public UserProfileUpdate<? extends ur> withValueIfUndefined(@NonNull Gender gender) {
        return new UserProfileUpdate<>(new uo(this.mCustomAttribute.a(), gender.getStringValue(), new adf(), this.mCustomAttribute.c(), new um(this.mCustomAttribute.b())));
    }

    @NonNull
    public UserProfileUpdate<? extends ur> withValueReset() {
        return new UserProfileUpdate<>(new ul(0, this.mCustomAttribute.a(), this.mCustomAttribute.c(), this.mCustomAttribute.b()));
    }
}

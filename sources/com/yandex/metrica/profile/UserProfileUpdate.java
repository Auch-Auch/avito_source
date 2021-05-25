package com.yandex.metrica.profile;

import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.ur;
public class UserProfileUpdate<T extends ur> {
    @NonNull
    public final T mUserProfileUpdatePatcher;

    public UserProfileUpdate(@NonNull T t) {
        this.mUserProfileUpdatePatcher = t;
    }

    @NonNull
    public T getUserProfileUpdatePatcher() {
        return this.mUserProfileUpdatePatcher;
    }
}

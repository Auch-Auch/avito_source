package com.yandex.metrica.impl.ob;

import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public final class dp extends Location {
    @Nullable
    private final String a;

    private dp(@NonNull Location location, @Nullable String str) {
        super(location);
        this.a = str;
    }

    public static dp b(@NonNull Location location) {
        return new dp(new Location(location), "");
    }

    @Nullable
    public String a() {
        return this.a;
    }

    public static dp a(@NonNull Location location) {
        Location location2 = new Location(location);
        String provider = location2.getProvider();
        location2.setProvider("");
        return new dp(location2, provider);
    }
}

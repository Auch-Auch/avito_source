package com.my.target.ads;

import androidx.annotation.NonNull;
public class Reward {
    public static final String DEFAULT = "default";
    @NonNull
    public final String type;

    public Reward(@NonNull String str) {
        this.type = str;
    }

    @NonNull
    public static Reward getDefault() {
        return new Reward("default");
    }
}

package com.google.firebase.emulators;

import androidx.annotation.NonNull;
public final class EmulatedServiceSettings {
    public final String a;
    public final int b;

    public EmulatedServiceSettings(@NonNull String str, int i) {
        this.a = str;
        this.b = i;
    }

    public String getHost() {
        return this.a;
    }

    public int getPort() {
        return this.b;
    }
}

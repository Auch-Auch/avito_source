package com.vk.sdk;

import androidx.annotation.Nullable;
public abstract class VKAccessTokenTracker {
    public boolean a = false;

    public boolean isTracking() {
        return this.a;
    }

    public abstract void onVKAccessTokenChanged(@Nullable VKAccessToken vKAccessToken, @Nullable VKAccessToken vKAccessToken2);

    public void startTracking() {
        VKSdk.j.add(this);
        this.a = true;
    }

    public void stopTracking() {
        VKSdk.j.remove(this);
        this.a = false;
    }
}

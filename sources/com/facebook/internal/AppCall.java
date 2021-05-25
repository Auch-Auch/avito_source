package com.facebook.internal;

import android.content.Intent;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import java.util.UUID;
@AutoHandleExceptions
public class AppCall {
    public static AppCall d;
    public UUID a;
    public Intent b;
    public int c;

    public AppCall(int i) {
        this(i, UUID.randomUUID());
    }

    public static synchronized boolean a(AppCall appCall) {
        boolean z;
        synchronized (AppCall.class) {
            AppCall currentPendingCall = getCurrentPendingCall();
            d = appCall;
            z = currentPendingCall != null;
        }
        return z;
    }

    public static synchronized AppCall finishPendingCall(UUID uuid, int i) {
        synchronized (AppCall.class) {
            AppCall currentPendingCall = getCurrentPendingCall();
            if (currentPendingCall != null && currentPendingCall.getCallId().equals(uuid)) {
                if (currentPendingCall.getRequestCode() == i) {
                    a(null);
                    return currentPendingCall;
                }
            }
            return null;
        }
    }

    public static AppCall getCurrentPendingCall() {
        return d;
    }

    public UUID getCallId() {
        return this.a;
    }

    public int getRequestCode() {
        return this.c;
    }

    public Intent getRequestIntent() {
        return this.b;
    }

    public boolean setPending() {
        return a(this);
    }

    public void setRequestCode(int i) {
        this.c = i;
    }

    public void setRequestIntent(Intent intent) {
        this.b = intent;
    }

    public AppCall(int i, UUID uuid) {
        this.a = uuid;
        this.c = i;
    }
}

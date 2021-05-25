package com.vk.sdk.payments;

import a2.s.a.c.b;
import android.content.Context;
import java.util.Objects;
public abstract class VKPaymentsCallback {
    public static void requestUserState(Context context, VKPaymentsCallback vKPaymentsCallback) {
        b c = b.c(context);
        Objects.requireNonNull(c);
        synchronized (b.class) {
            int i = c.c;
            if (i == 0) {
                vKPaymentsCallback.onUserState(false);
            } else if (i == 1 || i == 2) {
                vKPaymentsCallback.onUserState(true);
            } else {
                c.d.add(vKPaymentsCallback);
            }
        }
    }

    public abstract void onUserState(boolean z);
}

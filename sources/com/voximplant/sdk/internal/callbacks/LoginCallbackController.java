package com.voximplant.sdk.internal.callbacks;

import a2.t.a.c.o0.d;
import com.voximplant.sdk.client.IClientLoginListener;
import com.voximplant.sdk.client.LoginError;
import com.voximplant.sdk.internal.SharedData;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
public class LoginCallbackController {
    public IClientLoginListener a;
    public ConcurrentLinkedQueue<Callback> b = new ConcurrentLinkedQueue<>();
    public Executor c = SharedData.getCallbackExecutor();

    public final LoginError a(int i) {
        if (i == 408) {
            return LoginError.TIMEOUT;
        }
        if (i == 491) {
            return LoginError.INVALID_STATE;
        }
        if (i == 503) {
            return LoginError.NETWORK_ISSUES;
        }
        if (i == 701) {
            return LoginError.TOKEN_EXPIRED;
        }
        switch (i) {
            case 401:
                return LoginError.INVALID_PASSWORD;
            case 402:
                return LoginError.MAU_ACCESS_DENIED;
            case 403:
                return LoginError.ACCOUNT_FROZEN;
            case 404:
                return LoginError.INVALID_USERNAME;
            default:
                return LoginError.INTERNAL_ERROR;
        }
    }

    public void addLoginCallbackToQueue(Callback callback) {
        this.b.add(callback);
        this.c.execute(new d(this));
    }

    public void setLoginListener(IClientLoginListener iClientLoginListener) {
        this.a = iClientLoginListener;
        this.c.execute(new d(this));
    }
}

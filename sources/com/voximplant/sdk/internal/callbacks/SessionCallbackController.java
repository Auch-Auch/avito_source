package com.voximplant.sdk.internal.callbacks;

import a2.t.a.c.o0.f;
import com.voximplant.sdk.client.IClientSessionListener;
import com.voximplant.sdk.internal.SharedData;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
public class SessionCallbackController {
    public IClientSessionListener a;
    public ConcurrentLinkedQueue<Callback> b = new ConcurrentLinkedQueue<>();
    public Executor c = SharedData.getCallbackExecutor();

    public void addSessionCallbackToQueue(Callback callback) {
        this.b.add(callback);
        this.c.execute(new f(this));
    }

    public void setSessionListener(IClientSessionListener iClientSessionListener) {
        this.a = iClientSessionListener;
        this.c.execute(new f(this));
    }
}

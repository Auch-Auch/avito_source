package com.voximplant.sdk.internal.callbacks;

import a2.t.a.c.o0.c;
import com.voximplant.sdk.client.IClientIncomingCallListener;
import com.voximplant.sdk.internal.SharedData;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
public class IncomingCallCallbackController {
    public IClientIncomingCallListener a;
    public ConcurrentLinkedQueue<Callback> b = new ConcurrentLinkedQueue<>();
    public Executor c = SharedData.getCallbackExecutor();

    public void addIncomingCallCallbackToQueue(Callback callback) {
        this.b.add(callback);
        this.c.execute(new c(this));
    }

    public void setIncomingCallListener(IClientIncomingCallListener iClientIncomingCallListener) {
        this.a = iClientIncomingCallListener;
        this.c.execute(new c(this));
    }
}

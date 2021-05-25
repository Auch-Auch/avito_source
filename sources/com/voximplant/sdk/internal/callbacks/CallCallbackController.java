package com.voximplant.sdk.internal.callbacks;

import a2.t.a.c.o0.a;
import com.voximplant.sdk.call.ICallListener;
import com.voximplant.sdk.internal.SharedData;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
public class CallCallbackController {
    public CopyOnWriteArrayList<ICallListener> a = new CopyOnWriteArrayList<>();
    public ConcurrentLinkedQueue<Callback> b = new ConcurrentLinkedQueue<>();
    public Executor c = SharedData.getCallbackExecutor();

    public void addCallCallbackToQueue(Callback callback) {
        this.b.add(callback);
        this.c.execute(new a(this));
    }

    public void addCallListener(ICallListener iCallListener) {
        if (iCallListener != null) {
            this.a.add(iCallListener);
            this.c.execute(new a(this));
        }
    }

    public void removeCallListener(ICallListener iCallListener) {
        this.a.remove(iCallListener);
    }
}

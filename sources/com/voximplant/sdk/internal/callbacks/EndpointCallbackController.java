package com.voximplant.sdk.internal.callbacks;

import a2.t.a.c.o0.b;
import com.voximplant.sdk.call.IEndpointListener;
import com.voximplant.sdk.internal.SharedData;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
public class EndpointCallbackController {
    public WeakReference<IEndpointListener> a;
    public ConcurrentLinkedQueue<Callback> b = new ConcurrentLinkedQueue<>();
    public Executor c = SharedData.getCallbackExecutor();

    public void addEndpointCallbackToQueue(Callback callback) {
        this.b.add(callback);
        WeakReference<IEndpointListener> weakReference = this.a;
        if (weakReference != null && weakReference.get() != null) {
            this.c.execute(new b(this));
        }
    }

    public void setEndpointListener(IEndpointListener iEndpointListener) {
        WeakReference<IEndpointListener> weakReference = new WeakReference<>(iEndpointListener);
        this.a = weakReference;
        if (weakReference.get() != null) {
            this.c.execute(new b(this));
        }
    }
}

package net.gotev.uploadservice.observer.request;

import androidx.lifecycle.GeneratedAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MethodCallsLogger;
public class RequestObserver_LifecycleAdapter implements GeneratedAdapter {
    public final RequestObserver a;

    public RequestObserver_LifecycleAdapter(RequestObserver requestObserver) {
        this.a = requestObserver;
    }

    @Override // androidx.lifecycle.GeneratedAdapter
    public void callMethods(LifecycleOwner lifecycleOwner, Lifecycle.Event event, boolean z, MethodCallsLogger methodCallsLogger) {
        boolean z2 = methodCallsLogger != null;
        if (!z) {
            if (event == Lifecycle.Event.ON_RESUME) {
                if (!z2 || methodCallsLogger.approveCall("register", 1)) {
                    this.a.register();
                }
            } else if (event != Lifecycle.Event.ON_PAUSE) {
            } else {
                if (!z2 || methodCallsLogger.approveCall("unregister", 1)) {
                    this.a.unregister();
                }
            }
        }
    }
}

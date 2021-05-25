package a2.t.a.c.o0;

import com.voximplant.sdk.client.IClientIncomingCallListener;
import com.voximplant.sdk.internal.Logger;
import com.voximplant.sdk.internal.callbacks.Callback;
import com.voximplant.sdk.internal.callbacks.IncomingCallCallbackController;
import com.voximplant.sdk.internal.callbacks.OnIncomingCall;
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ IncomingCallCallbackController a;

    public /* synthetic */ c(IncomingCallCallbackController incomingCallCallbackController) {
        this.a = incomingCallCallbackController;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IncomingCallCallbackController incomingCallCallbackController = this.a;
        while (!incomingCallCallbackController.b.isEmpty()) {
            Callback poll = incomingCallCallbackController.b.poll();
            IClientIncomingCallListener iClientIncomingCallListener = incomingCallCallbackController.a;
            if (iClientIncomingCallListener != null && (poll instanceof OnIncomingCall)) {
                OnIncomingCall onIncomingCall = (OnIncomingCall) poll;
                Logger.i("Invoke onIncomingCall");
                iClientIncomingCallListener.onIncomingCall(onIncomingCall.getCall(), onIncomingCall.isVideoCall(), onIncomingCall.getHeaders());
            }
        }
    }
}

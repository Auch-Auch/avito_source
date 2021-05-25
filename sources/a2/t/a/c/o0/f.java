package a2.t.a.c.o0;

import com.voximplant.sdk.client.IClientSessionListener;
import com.voximplant.sdk.internal.Logger;
import com.voximplant.sdk.internal.callbacks.Callback;
import com.voximplant.sdk.internal.callbacks.OnConnectionClosed;
import com.voximplant.sdk.internal.callbacks.OnConnectionEstablished;
import com.voximplant.sdk.internal.callbacks.OnConnectionFailed;
import com.voximplant.sdk.internal.callbacks.SessionCallbackController;
public final /* synthetic */ class f implements Runnable {
    public final /* synthetic */ SessionCallbackController a;

    public /* synthetic */ f(SessionCallbackController sessionCallbackController) {
        this.a = sessionCallbackController;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SessionCallbackController sessionCallbackController = this.a;
        while (!sessionCallbackController.b.isEmpty()) {
            Callback poll = sessionCallbackController.b.poll();
            IClientSessionListener iClientSessionListener = sessionCallbackController.a;
            if (iClientSessionListener != null) {
                if (poll instanceof OnConnectionEstablished) {
                    Logger.i("Invoke onConnectionEstablished");
                    iClientSessionListener.onConnectionEstablished();
                }
                if (poll instanceof OnConnectionFailed) {
                    Logger.i("Invoke onConnectionFailed");
                    iClientSessionListener.onConnectionFailed(((OnConnectionFailed) poll).getError());
                }
                if (poll instanceof OnConnectionClosed) {
                    Logger.i("Invoke onConnectionClosed");
                    iClientSessionListener.onConnectionClosed();
                }
            }
        }
    }
}

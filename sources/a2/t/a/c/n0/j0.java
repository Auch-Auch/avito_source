package a2.t.a.c.n0;

import a2.t.a.c.n0.x1;
import com.voximplant.sdk.call.ICall;
import com.voximplant.sdk.internal.call.CallIn;
import com.voximplant.sdk.internal.callbacks.OnIceTimeout;
import org.webrtc.PeerConnection;
public final /* synthetic */ class j0 implements Runnable {
    public final /* synthetic */ x1.a.C0107a a;
    public final /* synthetic */ ICall b;

    public /* synthetic */ j0(x1.a.C0107a aVar, ICall iCall) {
        this.a = aVar;
        this.b = iCall;
    }

    @Override // java.lang.Runnable
    public final void run() {
        x1.a.C0107a aVar = this.a;
        ICall iCall = this.b;
        CallIn callIn = x1.this.b;
        PeerConnection.IceConnectionState iceConnectionState = callIn.u;
        if (iceConnectionState != PeerConnection.IceConnectionState.COMPLETED && iceConnectionState != PeerConnection.IceConnectionState.CONNECTED) {
            callIn.w = true;
            x1.this.b.d.addCallCallbackToQueue(new OnIceTimeout(iCall));
        }
    }
}

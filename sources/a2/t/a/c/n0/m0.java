package a2.t.a.c.n0;

import com.voximplant.sdk.internal.call.Call;
import com.voximplant.sdk.internal.call.CallOut;
import com.voximplant.sdk.internal.callbacks.OnIceTimeout;
import org.webrtc.PeerConnection;
public final /* synthetic */ class m0 implements Runnable {
    public final /* synthetic */ CallOut.a a;
    public final /* synthetic */ Call b;

    public /* synthetic */ m0(CallOut.a aVar, Call call) {
        this.a = aVar;
        this.b = call;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CallOut.a aVar = this.a;
        Call call = this.b;
        CallOut callOut = CallOut.this;
        PeerConnection.IceConnectionState iceConnectionState = callOut.u;
        if (iceConnectionState != PeerConnection.IceConnectionState.COMPLETED && iceConnectionState != PeerConnection.IceConnectionState.CONNECTED) {
            callOut.w = true;
            CallOut.this.d.addCallCallbackToQueue(new OnIceTimeout(call));
        }
    }
}
